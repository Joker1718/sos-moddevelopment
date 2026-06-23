/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.file.CopyOption;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.nio.file.StandardCopyOption;
/*     */ import java.nio.file.attribute.FileAttribute;
/*     */ import java.util.HashSet;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.stream.Stream;
/*     */ import java.util.zip.CRC32;
/*     */ import org.lwjgl.Version;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class SharedLibraryLoader
/*     */ {
/*  36 */   private static final Lock EXTRACT_PATH_LOCK = new ReentrantLock();
/*     */   
/*     */   private static Path extractPath;
/*     */   
/*  40 */   private static HashSet<Path> extractPaths = new HashSet<>(4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean checkedLoad;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static FileChannel load(String name, String filename, URL resource, Consumer<String> load) {
/*     */     try {
/*     */       Path extractedFile;
/*  61 */       EXTRACT_PATH_LOCK.lock();
/*     */       try {
/*  63 */         if (extractPath != null) {
/*     */           
/*  65 */           extractedFile = extractPath.resolve(filename);
/*     */         } else {
/*  67 */           extractedFile = getExtractPath(filename, resource, load);
/*     */           
/*  69 */           Path parent = extractedFile.getParent();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  78 */           if (checkedLoad) {
/*  79 */             extractPath = parent;
/*     */           }
/*  81 */           initExtractPath(parent);
/*     */         } 
/*     */       } finally {
/*  84 */         EXTRACT_PATH_LOCK.unlock();
/*     */       } 
/*     */       
/*  87 */       return extract(extractedFile, resource);
/*  88 */     } catch (Exception e) {
/*  89 */       Path extractedFile; throw new RuntimeException("\tFailed to extract " + name + " library", extractedFile);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void initExtractPath(Path extractPath) {
/*  94 */     if (extractPaths.contains(extractPath)) {
/*     */       return;
/*     */     }
/*  97 */     extractPaths.add(extractPath);
/*     */     
/*  99 */     String newLibPath = extractPath.toAbsolutePath().toString();
/*     */ 
/*     */     
/* 102 */     String libPath = Configuration.LIBRARY_PATH.get();
/* 103 */     if (libPath != null && !libPath.isEmpty()) {
/* 104 */       newLibPath = newLibPath + File.pathSeparator + libPath;
/*     */     }
/*     */     
/* 107 */     System.setProperty(Configuration.LIBRARY_PATH.getProperty(), newLibPath);
/* 108 */     Configuration.LIBRARY_PATH.set(newLibPath);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Path getExtractPath(String filename, URL resource, Consumer<String> load) {
/* 121 */     String override = Configuration.SHARED_LIBRARY_EXTRACT_PATH.get();
/* 122 */     if (override != null) {
/* 123 */       Path path1, path2 = (path1 = Paths.get(override, new String[0])).resolve(filename);
/* 124 */       if (canWrite(path1, path2, resource, load)) {
/* 125 */         return path2;
/*     */       }
/* 127 */       APIUtil.apiLogMore("The path " + override + " is not accessible. Trying other paths.");
/*     */     } 
/*     */     
/* 130 */     String version = Version.getVersion().replace(' ', '-');
/* 131 */     String arch = Platform.getArchitecture().name().toLowerCase();
/*     */ 
/*     */ 
/*     */     
/* 135 */     Path root, file = (root = Paths.get(System.getProperty("java.io.tmpdir"), new String[0])).resolve(Paths.get(Configuration.SHARED_LIBRARY_EXTRACT_DIRECTORY.get("lwjgl_" + System.getProperty("user.name").trim()), new String[] { version, arch, filename }));
/* 136 */     if (canWrite(root, file, resource, load)) {
/* 137 */       return file;
/*     */     }
/*     */     
/* 140 */     Path lwjgl_version_filename = Paths.get("." + (String)Configuration.SHARED_LIBRARY_EXTRACT_DIRECTORY.get("lwjgl"), new String[] { version, arch, filename });
/*     */ 
/*     */     
/* 143 */     file = (root = Paths.get("", new String[0]).toAbsolutePath()).resolve(lwjgl_version_filename);
/* 144 */     if (canWrite(root, file, resource, load)) {
/* 145 */       return file;
/*     */     }
/*     */ 
/*     */     
/* 149 */     file = (root = Paths.get(System.getProperty("user.home"), new String[0])).resolve(lwjgl_version_filename);
/* 150 */     if (canWrite(root, file, resource, load)) {
/* 151 */       return file;
/*     */     }
/*     */     
/* 154 */     if (Platform.get() == Platform.WINDOWS) {
/*     */       
/* 156 */       String env = System.getenv("SystemRoot");
/* 157 */       if (env != null) {
/* 158 */         file = (root = Paths.get(env, new String[] { "Temp" })).resolve(lwjgl_version_filename);
/* 159 */         if (canWrite(root, file, resource, load)) {
/* 160 */           return file;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 165 */       env = System.getenv("SystemDrive");
/* 166 */       if (env != null) {
/* 167 */         file = (root = Paths.get(env + "/", new String[0])).resolve(Paths.get("Temp", new String[0]).resolve(lwjgl_version_filename));
/* 168 */         if (canWrite(root, file, resource, load)) {
/* 169 */           return file;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 176 */       file = Files.createTempDirectory("lwjgl", (FileAttribute<?>[])new FileAttribute[0]);
/* 177 */       root = file.getParent();
/* 178 */       file = file.resolve(filename);
/* 179 */       if (canWrite(root, file, resource, load)) {
/* 180 */         return file;
/*     */       }
/* 182 */     } catch (IOException iOException) {}
/*     */ 
/*     */     
/* 185 */     throw new RuntimeException("Failed to find an appropriate directory to extract the native library");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static FileChannel extract(Path file, URL resource) throws IOException {
/* 199 */     if (Files.exists(file, new java.nio.file.LinkOption[0]))
/*     */     {
/* 201 */       try(InputStream source = resource.openStream(); 
/* 202 */           InputStream target = Files.newInputStream(file, new java.nio.file.OpenOption[0])) {
/*     */         
/* 204 */         if (crc(inputStream) == crc(target)) {
/* 205 */           if (((Boolean)Configuration.DEBUG_LOADER.get(Boolean.valueOf(false))).booleanValue()) {
/* 206 */             APIUtil.apiLogMore("Found at: " + file);
/*     */           }
/* 208 */           return lock(file);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 214 */     APIUtil.apiLogMore("Extracting: " + resource.getPath());
/*     */     
/* 216 */     if (extractPath == null) {
/* 217 */       APIUtil.apiLogMore("        to: " + file);
/*     */     }
/*     */     
/* 220 */     Files.createDirectories(file.getParent(), (FileAttribute<?>[])new FileAttribute[0]);
/* 221 */     try (InputStream source = resource.openStream()) {
/* 222 */       Files.copy(source, file, new CopyOption[] { StandardCopyOption.REPLACE_EXISTING });
/*     */     } 
/*     */     
/* 225 */     return lock(file);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static FileChannel lock(Path file) {
/*     */     try {
/* 237 */       FileChannel fc = FileChannel.open(file, new java.nio.file.OpenOption[0]);
/*     */       
/* 239 */       if (fc.tryLock(0L, Long.MAX_VALUE, true) == null) {
/* 240 */         if (((Boolean)Configuration.DEBUG_LOADER.get(Boolean.valueOf(false))).booleanValue()) {
/* 241 */           APIUtil.apiLogMore("File is locked by another process, waiting...");
/*     */         }
/*     */         
/* 244 */         fc.lock(0L, Long.MAX_VALUE, true);
/*     */       } 
/*     */ 
/*     */       
/* 248 */       return fc;
/* 249 */     } catch (Exception e) {
/* 250 */       throw new RuntimeException("Failed to lock file.", e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static long crc(InputStream input) throws IOException {
/* 262 */     CRC32 crc = new CRC32();
/*     */     
/* 264 */     byte[] buffer = new byte[8192]; int n;
/* 265 */     while ((n = input.read(buffer)) != -1) {
/* 266 */       crc.update(buffer, 0, n);
/*     */     }
/*     */     
/* 269 */     return crc.getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean canWrite(Path root, Path file, URL resource, Consumer<String> load) {
/*     */     Path testFile;
/* 285 */     if (Files.exists(file, new java.nio.file.LinkOption[0])) {
/* 286 */       if (!Files.isWritable(file)) {
/* 287 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 291 */       testFile = file.getParent().resolve(".lwjgl.test");
/*     */     } else {
/*     */       try {
/* 294 */         Files.createDirectories(file.getParent(), (FileAttribute<?>[])new FileAttribute[0]);
/* 295 */       } catch (IOException ignored) {
/* 296 */         return false;
/*     */       } 
/* 298 */       testFile = file;
/*     */     } 
/*     */     
/*     */     try {
/* 302 */       Files.write(testFile, new byte[0], new java.nio.file.OpenOption[0]);
/* 303 */       Files.delete(testFile);
/*     */       
/* 305 */       if (load != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 312 */         try (FileChannel ignored = extract(file, resource)) {
/* 313 */           load.accept(file.toAbsolutePath().toString());
/*     */         } 
/* 315 */         checkedLoad = true;
/*     */       } 
/*     */       
/* 318 */       return true;
/* 319 */     } catch (Throwable ignored) {
/* 320 */       if (file == testFile) {
/* 321 */         canWriteCleanup(root, file);
/*     */       }
/* 323 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void canWriteCleanup(Path root, Path file) {
/*     */     try {
/* 330 */       Files.deleteIfExists(file);
/*     */ 
/*     */       
/* 333 */       Path parent = file.getParent();
/* 334 */       while (!Files.isSameFile(parent, root)) {
/* 335 */         try (Stream<Path> dir = Files.list(parent)) {
/* 336 */           if (dir.findAny().isPresent())
/*     */           
/*     */           { 
/* 339 */             if (dir != null) { if (null != null) { try { dir.close(); } catch (Throwable throwable) { null.addSuppressed(throwable); }  break; }  dir.close(); }  break; } 
/* 340 */         }  Files.delete(parent);
/* 341 */         parent = parent.getParent();
/*     */       } 
/* 343 */     } catch (IOException iOException) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\SharedLibraryLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */