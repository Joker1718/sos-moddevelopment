import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.tree.ClassNode;
import jdk.internal.org.objectweb.asm.tree.AbstractInsnNode;
import jdk.internal.org.objectweb.asm.tree.InsnList;
import jdk.internal.org.objectweb.asm.tree.InsnNode;
import jdk.internal.org.objectweb.asm.tree.MethodInsnNode;
import jdk.internal.org.objectweb.asm.tree.MethodNode;

public final class BuildHaulerSpawner {

    private static final String TARGET_CLASS = "settlement/room/infra/hauler/HaulerInstance.class";
    private static final String HELPER_CLASS = "settlement/room/infra/hauler/HaulerSpawnerHelper.class";

    private BuildHaulerSpawner() {
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("Usage: BuildHaulerSpawner <base-jar> <helper-class-dir> <output-jar> <temp-dir>");
        }

        Path baseJar = Path.of(args[0]);
        Path helperDir = Path.of(args[1]);
        Path outputJar = Path.of(args[2]);
        Path tempDir = Path.of(args[3]);

        Files.createDirectories(tempDir);
        Path helperClassFile = helperDir.resolve(HELPER_CLASS);
        if (!Files.exists(helperClassFile)) {
            throw new IOException("Missing helper class: " + helperClassFile);
        }

        byte[] helperBytes = Files.readAllBytes(helperClassFile);

        Path stagedJar = tempDir.resolve("hauler-spawner-staged.jar");
        try (JarInputStream jarFile = new JarInputStream(Files.newInputStream(baseJar));
             JarOutputStream out = new JarOutputStream(Files.newOutputStream(stagedJar))) {
            JarEntry entry;
            while ((entry = jarFile.getNextJarEntry()) != null) {
                if (entry.isDirectory()) {
                    out.putNextEntry(new JarEntry(entry.getName()));
                    out.closeEntry();
                    continue;
                }

                byte[] bytes = jarFile.readAllBytes();

                if (TARGET_CLASS.equals(entry.getName())) {
                    bytes = patchHaulerInstance(bytes);
                }

                JarEntry copy = new JarEntry(entry.getName());
                copy.setTime(entry.getTime());
                out.putNextEntry(copy);
                out.write(bytes);
                out.closeEntry();
            }

            JarEntry helperEntry = new JarEntry(HELPER_CLASS);
            out.putNextEntry(helperEntry);
            out.write(helperBytes);
            out.closeEntry();
        }

        Files.copy(stagedJar, outputJar, StandardCopyOption.REPLACE_EXISTING);
    }

    private static byte[] patchHaulerInstance(byte[] original) {
        ClassReader reader = new ClassReader(original);
        ClassNode node = new ClassNode();
        reader.accept(node, 0);

        for (MethodNode method : node.methods) {
            if ("updateAction".equals(method.name) && "(DZ)V".equals(method.desc)) {
                InsnList inject = new InsnList();
                inject.add(new MethodInsnNode(
                    Opcodes.INVOKESTATIC,
                    "settlement/room/infra/hauler/HaulerSpawnerHelper",
                    "spawn",
                    "(Lsettlement/room/infra/hauler/HaulerInstance;)V",
                    false
                ));
                method.instructions.insertBefore(lastReturn(method), inject);
                method.maxStack = Math.max(method.maxStack, 1);
                break;
            }
        }

        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
        node.accept(writer);
        return writer.toByteArray();
    }

    private static AbstractInsnNode lastReturn(MethodNode method) {
        AbstractInsnNode last = null;
        for (AbstractInsnNode insn = method.instructions.getFirst(); insn != null; insn = insn.getNext()) {
            if (insn.getOpcode() == Opcodes.RETURN) {
                last = insn;
            }
        }
        if (last == null) {
            throw new IllegalStateException("No return found in updateAction");
        }
        return last;
    }
}
