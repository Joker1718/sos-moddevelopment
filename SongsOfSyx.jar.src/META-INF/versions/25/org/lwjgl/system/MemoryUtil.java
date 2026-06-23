/*      */ package META-INF.versions.25.org.lwjgl.system;
/*      */ import java.lang.foreign.MemorySegment;
/*      */ import java.lang.foreign.ValueLayout;
/*      */ import java.lang.invoke.MethodHandle;
/*      */ import java.lang.invoke.MethodHandles;
/*      */ import java.lang.invoke.MethodType;
/*      */ import java.lang.invoke.VarHandle;
/*      */ import java.nio.Buffer;
/*      */ import java.nio.BufferOverflowException;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.ByteOrder;
/*      */ import java.nio.CharBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import java.nio.charset.Charset;
/*      */ import java.nio.charset.StandardCharsets;
/*      */ import org.lwjgl.CLongBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.APIUtil;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.Configuration;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.Library;
/*      */ import org.lwjgl.system.MathUtil;
/*      */ import org.lwjgl.system.MemoryManage;
/*      */ import org.lwjgl.system.MemoryUtilTunables;
/*      */ import org.lwjgl.system.MultiReleaseTextDecoding;
/*      */ import org.lwjgl.system.Pointer;
/*      */ import org.lwjgl.system.Struct;
/*      */ 
/*      */ @NullMarked
/*      */ public final class MemoryUtil {
/*      */   public static final long NULL = 0L;
/*      */   public static final int PAGE_SIZE;
/*      */   public static final int CACHE_LINE_SIZE;
/*   39 */   static final int ARRAY_TLC_SIZE = ((Integer)Configuration.ARRAY_TLC_SIZE.get(Integer.valueOf(8192))).intValue();
/*      */   
/*   41 */   static final ThreadLocal<byte[]> ARRAY_TLC_BYTE = (ThreadLocal)ThreadLocal.withInitial(() -> new byte[ARRAY_TLC_SIZE]);
/*   42 */   static final ThreadLocal<char[]> ARRAY_TLC_CHAR = (ThreadLocal)ThreadLocal.withInitial(() -> new char[ARRAY_TLC_SIZE]);
/*      */   
/*   44 */   static final ByteOrder NATIVE_ORDER = ByteOrder.nativeOrder();
/*      */   
/*   46 */   private static final Charset UTF16 = (NATIVE_ORDER == ByteOrder.LITTLE_ENDIAN) ? 
/*   47 */     StandardCharsets.UTF_16LE : 
/*   48 */     StandardCharsets.UTF_16BE; private static final int MAX_BUFFER_SIZE = 2147483639; private static final VarHandle VH_JAVA_BYTE; private static final VarHandle VH_JAVA_SHORT; private static final VarHandle VH_JAVA_INT; private static final VarHandle VH_JAVA_LONG; private static final VarHandle VH_JAVA_FLOAT;
/*      */   private static final VarHandle VH_JAVA_DOUBLE;
/*      */   private static final VarHandle VH_CLONG;
/*      */   private static final VarHandle VH_ADDRESS;
/*      */   
/*   53 */   static { Library.initialize();
/*      */     
/*   55 */     PAGE_SIZE = 4096;
/*   56 */     CACHE_LINE_SIZE = 64;
/*      */     
/*   58 */     APIUtil.apiLog("Java 25 MemoryUtil enabled");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2333 */     try { MethodHandles.Lookup lookup = MethodHandles.lookup();
/*      */ 
/*      */       
/* 2336 */       MethodHandle ofAddress = lookup.findStatic(MemorySegment.class, "ofAddress", MethodType.methodType(MemorySegment.class, long.class));
/*      */ 
/*      */       
/* 2339 */       MethodHandle reinterpret = lookup.findVirtual(MemorySegment.class, "reinterpret", MethodType.methodType(MemorySegment.class, long.class));
/*      */ 
/*      */       
/* 2342 */       VH_JAVA_BYTE = createMemoryAccessVH(ValueLayout.JAVA_BYTE, ofAddress, reinterpret).withInvokeExactBehavior();
/*      */       
/* 2344 */       VH_JAVA_SHORT = createMemoryAccessVH(Checks.DEBUG ? ValueLayout.JAVA_SHORT : ValueLayout.JAVA_SHORT_UNALIGNED, ofAddress, reinterpret).withInvokeExactBehavior();
/*      */       
/* 2346 */       VH_JAVA_INT = createMemoryAccessVH(Checks.DEBUG ? ValueLayout.JAVA_INT : ValueLayout.JAVA_INT_UNALIGNED, ofAddress, reinterpret).withInvokeExactBehavior();
/*      */       
/* 2348 */       VH_JAVA_LONG = createMemoryAccessVH(Checks.DEBUG ? ValueLayout.JAVA_LONG : ValueLayout.JAVA_LONG_UNALIGNED, ofAddress, reinterpret).withInvokeExactBehavior();
/*      */       
/* 2350 */       VH_JAVA_FLOAT = createMemoryAccessVH(Checks.DEBUG ? ValueLayout.JAVA_FLOAT : ValueLayout.JAVA_FLOAT_UNALIGNED, ofAddress, reinterpret).withInvokeExactBehavior();
/*      */       
/* 2352 */       VH_JAVA_DOUBLE = createMemoryAccessVH(Checks.DEBUG ? ValueLayout.JAVA_DOUBLE : ValueLayout.JAVA_DOUBLE_UNALIGNED, ofAddress, reinterpret).withInvokeExactBehavior();
/*      */       
/* 2354 */       VarHandle vh = createMemoryAccessVH(
/* 2355 */           (Pointer.CLONG_SIZE == 8) ? (
/* 2356 */           Checks.DEBUG ? ValueLayout.JAVA_LONG : ValueLayout.JAVA_LONG_UNALIGNED) : (
/* 2357 */           Checks.DEBUG ? ValueLayout.JAVA_INT : ValueLayout.JAVA_INT_UNALIGNED), ofAddress, reinterpret);
/*      */       
/* 2359 */       if (Pointer.CLONG_SIZE == 4) {
/* 2360 */         vh = MethodHandles.filterValue(vh, 
/* 2361 */             MethodHandles.explicitCastArguments(
/* 2362 */               MethodHandles.identity(int.class), 
/* 2363 */               MethodType.methodType(int.class, long.class)), 
/*      */             
/* 2365 */             MethodHandles.explicitCastArguments(
/* 2366 */               MethodHandles.identity(long.class), 
/* 2367 */               MethodType.methodType(long.class, int.class)));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 2372 */       VH_CLONG = vh.withInvokeExactBehavior();
/*      */       
/* 2374 */       vh = createMemoryAccessVH(Pointer.BITS64 ? (
/* 2375 */           Checks.DEBUG ? ValueLayout.JAVA_LONG : ValueLayout.JAVA_LONG_UNALIGNED) : (
/* 2376 */           Checks.DEBUG ? ValueLayout.JAVA_INT : ValueLayout.JAVA_INT_UNALIGNED), ofAddress, reinterpret);
/*      */       
/* 2378 */       if (Pointer.BITS32) {
/* 2379 */         vh = MethodHandles.filterValue(vh, 
/* 2380 */             MethodHandles.explicitCastArguments(
/* 2381 */               MethodHandles.identity(int.class), 
/* 2382 */               MethodType.methodType(int.class, long.class)), lookup
/*      */             
/* 2384 */             .findStatic(org.lwjgl.system.MemoryUtil.class, "castAddress32", 
/*      */               
/* 2386 */               MethodType.methodType(long.class, int.class)));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 2391 */       VH_ADDRESS = vh.withInvokeExactBehavior(); }
/* 2392 */     catch (NoSuchMethodException|IllegalAccessException e)
/* 2393 */     { throw new RuntimeException(e); }  }
/*      */   public static MemoryAllocator getAllocator() { return getAllocator(false); }
/*      */   public static MemoryAllocator getAllocator(boolean tracked) { return tracked ? LazyInit.ALLOCATOR : LazyInit.ALLOCATOR_IMPL; }
/*      */   public static long nmemAlloc(long size) { return LazyInit.ALLOCATOR.malloc(size); }
/*      */   public static long nmemAllocChecked(long size) { long address = nmemAlloc((size != 0L) ? size : 1L); if (Checks.CHECKS && address == 0L) throw new OutOfMemoryError();  return address; }
/*      */   private static long getAllocationSize(int elements, int elementShift) { return APIUtil.apiCheckAllocation(elements, Integer.toUnsignedLong(elements) << elementShift, Pointer.BITS64 ? Long.MAX_VALUE : 4294967295L); } public static ByteBuffer memAlloc(int size) { return wrapBufferByte(nmemAllocChecked(size), size); } public static ShortBuffer memAllocShort(int size) { return wrapBufferShort(nmemAllocChecked(getAllocationSize(size, 1)), size); } public static IntBuffer memAllocInt(int size) { return wrapBufferInt(nmemAllocChecked(getAllocationSize(size, 2)), size); } public static FloatBuffer memAllocFloat(int size) { return wrapBufferFloat(nmemAllocChecked(getAllocationSize(size, 2)), size); } public static LongBuffer memAllocLong(int size) { return wrapBufferLong(nmemAllocChecked(getAllocationSize(size, 3)), size); } public static CLongBuffer memAllocCLong(int size) { return CLongBuffer.create(nmemAllocChecked(getAllocationSize(size, Pointer.CLONG_SHIFT)), size); } public static DoubleBuffer memAllocDouble(int size) { return wrapBufferDouble(nmemAllocChecked(getAllocationSize(size, 3)), size); } public static PointerBuffer memAllocPointer(int size) { return PointerBuffer.create(nmemAllocChecked(getAllocationSize(size, Pointer.POINTER_SHIFT)), size); } public static void nmemFree(long ptr) { LazyInit.ALLOCATOR.free(ptr); } public static void memFree(Buffer ptr) { if (ptr != null) nmemFree(memAddress0(ptr));  } public static void memFree(ByteBuffer ptr) { if (ptr != null) nmemFree(MemorySegment.ofBuffer(ptr).address() - ptr.position());  } public static void memFree(ShortBuffer ptr) { if (ptr != null) nmemFree(MemorySegment.ofBuffer(ptr).address() - (ptr.position() << 1L));  } public static void memFree(CharBuffer ptr) { if (ptr != null) nmemFree(MemorySegment.ofBuffer(ptr).address() - (ptr.position() << 1L));  } public static void memFree(IntBuffer ptr) { if (ptr != null) nmemFree(MemorySegment.ofBuffer(ptr).address() - (ptr.position() << 2L));  } public static void memFree(LongBuffer ptr) { if (ptr != null) nmemFree(MemorySegment.ofBuffer(ptr).address() - (ptr.position() << 3L));  } public static void memFree(FloatBuffer ptr) { if (ptr != null) nmemFree(MemorySegment.ofBuffer(ptr).address() - (ptr.position() << 2L));  } public static void memFree(DoubleBuffer ptr) { if (ptr != null) nmemFree(MemorySegment.ofBuffer(ptr).address() - (ptr.position() << 3L));  } public static void memFree(CustomBuffer<?> ptr) { if (ptr != null) nmemFree(ptr.address);  } public static long nmemCalloc(long num, long size) { return LazyInit.ALLOCATOR.calloc(num, size); } public static long nmemCallocChecked(long num, long size) { if (num == 0L || size == 0L) { num = 1L; size = 1L; }  long address = nmemCalloc(num, size); if (Checks.CHECKS && address == 0L) throw new OutOfMemoryError();  return address; } public static ByteBuffer memCalloc(int num, int size) { return wrapBufferByte(nmemCallocChecked(num, size), num * size); } public static ByteBuffer memCalloc(int num) { return wrapBufferByte(nmemCallocChecked(num, 1L), num); } public static ShortBuffer memCallocShort(int num) { return wrapBufferShort(nmemCallocChecked(num, 2L), num); } public static IntBuffer memCallocInt(int num) { return wrapBufferInt(nmemCallocChecked(num, 4L), num); } public static FloatBuffer memCallocFloat(int num) { return wrapBufferFloat(nmemCallocChecked(num, 4L), num); } public static LongBuffer memCallocLong(int num) { return wrapBufferLong(nmemCallocChecked(num, 8L), num); } public static CLongBuffer memCallocCLong(int num) { return CLongBuffer.create(nmemCallocChecked(num, Pointer.CLONG_SIZE), num); } public static DoubleBuffer memCallocDouble(int num) { return wrapBufferDouble(nmemCallocChecked(num, 8L), num); } public static PointerBuffer memCallocPointer(int num) { return PointerBuffer.create(nmemCallocChecked(num, Pointer.POINTER_SIZE), num); } public static long nmemRealloc(long ptr, long size) { return LazyInit.ALLOCATOR.realloc(ptr, size); } public static long nmemReallocChecked(long ptr, long size) { long address = nmemRealloc(ptr, (size != 0L) ? size : 1L); if (Checks.CHECKS && address == 0L) throw new OutOfMemoryError();  return address; } private static <T extends Buffer> T realloc(T old_p, T new_p, int size) { if (old_p != null) new_p.position(Math.min(old_p.position(), size));  return new_p; } public static ByteBuffer memRealloc(ByteBuffer ptr, int size) { return realloc(ptr, memByteBuffer(nmemReallocChecked((ptr == null) ? 0L : memAddress0(ptr), size), size), size); } public static ShortBuffer memRealloc(ShortBuffer ptr, int size) { return realloc(ptr, memShortBuffer(nmemReallocChecked((ptr == null) ? 0L : memAddress0(ptr), getAllocationSize(size, 1)), size), size); } public static IntBuffer memRealloc(IntBuffer ptr, int size) { return realloc(ptr, memIntBuffer(nmemReallocChecked((ptr == null) ? 0L : memAddress0(ptr), getAllocationSize(size, 2)), size), size); } public static LongBuffer memRealloc(LongBuffer ptr, int size) { return realloc(ptr, memLongBuffer(nmemReallocChecked((ptr == null) ? 0L : memAddress0(ptr), getAllocationSize(size, 3)), size), size); } public static CLongBuffer memRealloc(CLongBuffer ptr, int size) { CLongBuffer buffer = memCLongBuffer(nmemReallocChecked((ptr == null) ? 0L : ptr.address, getAllocationSize(size, Pointer.CLONG_SIZE)), size); if (ptr != null) buffer.position(Math.min(ptr.position(), size));  return buffer; } public static FloatBuffer memRealloc(FloatBuffer ptr, int size) { return realloc(ptr, memFloatBuffer(nmemReallocChecked((ptr == null) ? 0L : memAddress0(ptr), getAllocationSize(size, 2)), size), size); } public static DoubleBuffer memRealloc(DoubleBuffer ptr, int size) { return realloc(ptr, memDoubleBuffer(nmemReallocChecked((ptr == null) ? 0L : memAddress0(ptr), getAllocationSize(size, 3)), size), size); } public static PointerBuffer memRealloc(PointerBuffer ptr, int size) { PointerBuffer buffer = memPointerBuffer(nmemReallocChecked((ptr == null) ? 0L : ptr.address, getAllocationSize(size, Pointer.POINTER_SHIFT)), size); if (ptr != null) buffer.position(Math.min(ptr.position(), size));  return buffer; } public static long nmemAlignedAlloc(long alignment, long size) { return LazyInit.ALLOCATOR.aligned_alloc(alignment, size); } public static long nmemAlignedAllocChecked(long alignment, long size) { long address = nmemAlignedAlloc(alignment, (size != 0L) ? size : 1L); if (Checks.CHECKS && address == 0L) throw new OutOfMemoryError();  return address; } public static ByteBuffer memAlignedAlloc(int alignment, int size) { return wrapBufferByte(nmemAlignedAllocChecked(alignment, size), size); } public static void nmemAlignedFree(long ptr) { LazyInit.ALLOCATOR.aligned_free(ptr); } public static void memAlignedFree(ByteBuffer ptr) { if (ptr != null) nmemAlignedFree(MemorySegment.ofBuffer(ptr).address() - ptr.position());  } public static void memReport(MemoryAllocationReport report) { MemoryManage.DebugAllocator.report(report); } public static void memReport(MemoryAllocationReport report, MemoryAllocationReport.Aggregate groupByStackTrace, boolean groupByThread) { MemoryManage.DebugAllocator.report(report, groupByStackTrace, groupByThread); } public static long memAddress0(Buffer buffer) { // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: dup
/*      */     //   2: invokestatic requireNonNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*      */     //   5: pop
/*      */     //   6: astore_2
/*      */     //   7: iconst_0
/*      */     //   8: istore_3
/*      */     //   9: aload_2
/*      */     //   10: iload_3
/*      */     //   11: <illegal opcode> typeSwitch : (Ljava/nio/Buffer;I)I
/*      */     //   16: tableswitch default -> 114, 0 -> 52, 1 -> 56, 2 -> 56, 3 -> 85, 4 -> 85
/*      */     //   52: iconst_0
/*      */     //   53: goto -> 118
/*      */     //   56: aload_2
/*      */     //   57: instanceof java/nio/ShortBuffer
/*      */     //   60: ifeq -> 66
/*      */     //   63: goto -> 81
/*      */     //   66: aload_2
/*      */     //   67: instanceof java/nio/CharBuffer
/*      */     //   70: ifeq -> 76
/*      */     //   73: goto -> 81
/*      */     //   76: iconst_3
/*      */     //   77: istore_3
/*      */     //   78: goto -> 9
/*      */     //   81: iconst_1
/*      */     //   82: goto -> 118
/*      */     //   85: aload_2
/*      */     //   86: instanceof java/nio/IntBuffer
/*      */     //   89: ifeq -> 95
/*      */     //   92: goto -> 110
/*      */     //   95: aload_2
/*      */     //   96: instanceof java/nio/FloatBuffer
/*      */     //   99: ifeq -> 105
/*      */     //   102: goto -> 110
/*      */     //   105: iconst_5
/*      */     //   106: istore_3
/*      */     //   107: goto -> 9
/*      */     //   110: iconst_2
/*      */     //   111: goto -> 118
/*      */     //   114: iconst_3
/*      */     //   115: goto -> 118
/*      */     //   118: istore_1
/*      */     //   119: aload_0
/*      */     //   120: invokestatic ofBuffer : (Ljava/nio/Buffer;)Ljava/lang/foreign/MemorySegment;
/*      */     //   123: invokeinterface address : ()J
/*      */     //   128: aload_0
/*      */     //   129: invokevirtual position : ()I
/*      */     //   132: i2l
/*      */     //   133: iload_1
/*      */     //   134: lshl
/*      */     //   135: lsub
/*      */     //   136: lreturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #697	-> 0
/*      */     //   #698	-> 52
/*      */     //   #699	-> 56
/*      */     //   #700	-> 85
/*      */     //   #701	-> 114
/*      */     //   #702	-> 118
/*      */     //   #703	-> 119
/*      */     // Local variable table:
/*      */     //   start	length	slot	name	descriptor
/*      */     //   0	137	0	buffer	Ljava/nio/Buffer;
/* 2398 */     //   119	18	1	elementShift	I } public static long memAddress0(ByteBuffer buffer) { return MemorySegment.ofBuffer(buffer).address() - buffer.position(); } public static long memAddress0(ShortBuffer buffer) { return MemorySegment.ofBuffer(buffer).address() - (buffer.position() << 1L); } public static long memAddress0(CharBuffer buffer) { return MemorySegment.ofBuffer(buffer).address() - (buffer.position() << 1L); } public static long memAddress0(IntBuffer buffer) { return MemorySegment.ofBuffer(buffer).address() - (buffer.position() << 2L); } public static long memAddress0(LongBuffer buffer) { return MemorySegment.ofBuffer(buffer).address() - (buffer.position() << 3L); } public static long memAddress0(FloatBuffer buffer) { return MemorySegment.ofBuffer(buffer).address() - (buffer.position() << 2L); } public static long memAddress0(DoubleBuffer buffer) { return MemorySegment.ofBuffer(buffer).address() - (buffer.position() << 3L); } public static long memAddress(ByteBuffer buffer) { return MemorySegment.ofBuffer(buffer).address(); } public static long memAddress(ByteBuffer buffer, int position) { return MemorySegment.ofBuffer(buffer).address() + Integer.toUnsignedLong(position) - buffer.position(); } private static long address(Buffer buffer, int position, int elementShift) { return MemorySegment.ofBuffer(buffer).address() + (Integer.toUnsignedLong(position) - buffer.position() << elementShift); } public static long memAddress(ShortBuffer buffer) { return MemorySegment.ofBuffer(buffer).address(); } public static long memAddress(ShortBuffer buffer, int position) { return address(buffer, position, 1); } public static long memAddress(CharBuffer buffer) { return MemorySegment.ofBuffer(buffer).address(); } public static long memAddress(CharBuffer buffer, int position) { return address(buffer, position, 1); } public static long memAddress(IntBuffer buffer) { return MemorySegment.ofBuffer(buffer).address(); } public static long memAddress(IntBuffer buffer, int position) { return address(buffer, position, 2); } public static long memAddress(FloatBuffer buffer) { return MemorySegment.ofBuffer(buffer).address(); } public static long memAddress(FloatBuffer buffer, int position) { return address(buffer, position, 2); } public static long memAddress(LongBuffer buffer) { return MemorySegment.ofBuffer(buffer).address(); } public static long memAddress(LongBuffer buffer, int position) { return address(buffer, position, 3); } public static long memAddress(DoubleBuffer buffer) { return MemorySegment.ofBuffer(buffer).address(); } public static long memAddress(DoubleBuffer buffer, int position) { return address(buffer, position, 3); } public static long memAddress(Buffer buffer) { return MemorySegment.ofBuffer(buffer).address(); } public static long memAddress(CustomBuffer<?> buffer) { return buffer.address(); } public static long memAddress(CustomBuffer<?> buffer, int position) { return buffer.address(position); } public static long memAddressSafe(ByteBuffer buffer) { return (buffer == null) ? 0L : MemorySegment.ofBuffer(buffer).address(); } public static long memAddressSafe(ShortBuffer buffer) { return (buffer == null) ? 0L : MemorySegment.ofBuffer(buffer).address(); } public static long memAddressSafe(CharBuffer buffer) { return (buffer == null) ? 0L : MemorySegment.ofBuffer(buffer).address(); } public static long memAddressSafe(IntBuffer buffer) { return (buffer == null) ? 0L : MemorySegment.ofBuffer(buffer).address(); } public static long memAddressSafe(FloatBuffer buffer) { return (buffer == null) ? 0L : MemorySegment.ofBuffer(buffer).address(); } public static long memAddressSafe(LongBuffer buffer) { return (buffer == null) ? 0L : MemorySegment.ofBuffer(buffer).address(); } public static long memAddressSafe(DoubleBuffer buffer) { return (buffer == null) ? 0L : MemorySegment.ofBuffer(buffer).address(); } public static long memAddressSafe(Pointer pointer) { return (pointer == null) ? 0L : pointer.address(); } public static ByteBuffer memByteBuffer(long address, int capacity) { if (Checks.CHECKS) Checks.check(address);  return wrapBufferByte(address, capacity); } public static ByteBuffer memByteBufferSafe(long address, int capacity) { return (address == 0L) ? null : wrapBufferByte(address, capacity); } public static ByteBuffer memByteBuffer(ShortBuffer buffer) { return wrapBufferByte(memAddress(buffer), buffer.remaining() << 1); } public static ByteBuffer memByteBuffer(CharBuffer buffer) { return wrapBufferByte(memAddress(buffer), buffer.remaining() << 1); } public static ByteBuffer memByteBuffer(IntBuffer buffer) { return wrapBufferByte(memAddress(buffer), buffer.remaining() << 2); } public static ByteBuffer memByteBuffer(LongBuffer buffer) { return wrapBufferByte(memAddress(buffer), buffer.remaining() << 3); } public static ByteBuffer memByteBuffer(FloatBuffer buffer) { return wrapBufferByte(memAddress(buffer), buffer.remaining() << 2); } public static ByteBuffer memByteBuffer(DoubleBuffer buffer) { return wrapBufferByte(memAddress(buffer), buffer.remaining() << 3); } public static ByteBuffer memByteBuffer(CustomBuffer<?> buffer) { if (Checks.CHECKS && 2147483639 / buffer.sizeof() < buffer.remaining()) throw new IllegalArgumentException("The source buffer range is too wide");  return wrapBufferByte(memAddress(buffer), buffer.remaining() * buffer.sizeof()); } public static <T extends Struct<T>> ByteBuffer memByteBuffer(T value) { return wrapBufferByte(((Struct)value).address, value.sizeof()); } public static ShortBuffer memShortBuffer(long address, int capacity) { if (Checks.CHECKS) Checks.check(address);  return wrapBufferShort(address, capacity); } public static ShortBuffer memShortBufferSafe(long address, int capacity) { return (address == 0L) ? null : wrapBufferShort(address, capacity); } public static CharBuffer memCharBuffer(long address, int capacity) { if (Checks.CHECKS) Checks.check(address);  return wrapBufferChar(address, capacity); } public static CharBuffer memCharBufferSafe(long address, int capacity) { return (address == 0L) ? null : wrapBufferChar(address, capacity); } public static IntBuffer memIntBuffer(long address, int capacity) { if (Checks.CHECKS) Checks.check(address);  return wrapBufferInt(address, capacity); } public static IntBuffer memIntBufferSafe(long address, int capacity) { return (address == 0L) ? null : wrapBufferInt(address, capacity); } public static LongBuffer memLongBuffer(long address, int capacity) { if (Checks.CHECKS) Checks.check(address);  return wrapBufferLong(address, capacity); } public static LongBuffer memLongBufferSafe(long address, int capacity) { return (address == 0L) ? null : wrapBufferLong(address, capacity); } public static CLongBuffer memCLongBuffer(long address, int capacity) { if (Checks.CHECKS) Checks.check(address);  return CLongBuffer.create(address, capacity); } public static CLongBuffer memCLongBufferSafe(long address, int capacity) { return (address == 0L) ? null : CLongBuffer.create(address, capacity); } public static FloatBuffer memFloatBuffer(long address, int capacity) { if (Checks.CHECKS) Checks.check(address);  return wrapBufferFloat(address, capacity); } public static FloatBuffer memFloatBufferSafe(long address, int capacity) { return (address == 0L) ? null : wrapBufferFloat(address, capacity); } public static DoubleBuffer memDoubleBuffer(long address, int capacity) { if (Checks.CHECKS) Checks.check(address);  return wrapBufferDouble(address, capacity); } public static DoubleBuffer memDoubleBufferSafe(long address, int capacity) { return (address == 0L) ? null : wrapBufferDouble(address, capacity); } public static PointerBuffer memPointerBuffer(long address, int capacity) { if (Checks.CHECKS) Checks.check(address);  return PointerBuffer.create(address, capacity); } private static VarHandle createMemoryAccessVH(ValueLayout layout, MethodHandle ofAddress, MethodHandle reinterpret) { VarHandle vh = layout.varHandle();
/*      */     
/* 2400 */     vh = MethodHandles.insertCoordinates(vh, 1, new Object[] { Long.valueOf(0L) });
/* 2401 */     vh = MethodHandles.filterCoordinates(vh, 0, new MethodHandle[] { MethodHandles.filterReturnValue(ofAddress, 
/*      */             
/* 2403 */             MethodHandles.insertArguments(reinterpret, 1, new Object[] { Long.valueOf(layout.byteSize()) })) });
/*      */ 
/*      */     
/* 2406 */     return vh; }
/*      */   public static PointerBuffer memPointerBufferSafe(long address, int capacity) { return (address == 0L) ? null : PointerBuffer.create(address, capacity); }
/*      */   public static ByteBuffer memDuplicate(ByteBuffer buffer) { return buffer.duplicate().order(buffer.order()); }
/*      */   public static ShortBuffer memDuplicate(ShortBuffer buffer) { return buffer.duplicate(); }
/* 2410 */   public static CharBuffer memDuplicate(CharBuffer buffer) { return buffer.duplicate(); } public static IntBuffer memDuplicate(IntBuffer buffer) { return buffer.duplicate(); } public static LongBuffer memDuplicate(LongBuffer buffer) { return buffer.duplicate(); } public static FloatBuffer memDuplicate(FloatBuffer buffer) { return buffer.duplicate(); } public static DoubleBuffer memDuplicate(DoubleBuffer buffer) { return buffer.duplicate(); } public static ByteBuffer memSlice(ByteBuffer buffer) { return buffer.slice().order(NATIVE_ORDER); } public static ShortBuffer memSlice(ShortBuffer buffer) { return buffer.slice(); } public static CharBuffer memSlice(CharBuffer buffer) { return buffer.slice(); } public static IntBuffer memSlice(IntBuffer buffer) { return buffer.slice(); } public static LongBuffer memSlice(LongBuffer buffer) { return buffer.slice(); } public static FloatBuffer memSlice(FloatBuffer buffer) { return buffer.slice(); } public static DoubleBuffer memSlice(DoubleBuffer buffer) { return buffer.slice(); } public static ByteBuffer memSlice(ByteBuffer buffer, int offset, int capacity) { return buffer.slice(buffer.position() + offset, capacity).order(NATIVE_ORDER); } public static ShortBuffer memSlice(ShortBuffer buffer, int offset, int capacity) { return buffer.slice(buffer.position() + offset, capacity); } public static CharBuffer memSlice(CharBuffer buffer, int offset, int capacity) { return buffer.slice(buffer.position() + offset, capacity); } public static IntBuffer memSlice(IntBuffer buffer, int offset, int capacity) { return buffer.slice(buffer.position() + offset, capacity); } public static LongBuffer memSlice(LongBuffer buffer, int offset, int capacity) { return buffer.slice(buffer.position() + offset, capacity); } public static FloatBuffer memSlice(FloatBuffer buffer, int offset, int capacity) { return buffer.slice(buffer.position() + offset, capacity); } public static DoubleBuffer memSlice(DoubleBuffer buffer, int offset, int capacity) { return buffer.slice(buffer.position() + offset, capacity); } public static <T extends CustomBuffer<T>> T memSlice(T buffer, int offset, int capacity) { return (T)buffer.slice(offset, capacity); } public static void memSet(ByteBuffer ptr, int value) { memSet(memAddress(ptr), value, ptr.remaining()); } public static void memSet(ShortBuffer ptr, int value) { memSet(memAddress(ptr), value, APIUtil.apiGetBytes(ptr.remaining(), 1)); } public static void memSet(CharBuffer ptr, int value) { memSet(memAddress(ptr), value, APIUtil.apiGetBytes(ptr.remaining(), 1)); } public static void memSet(IntBuffer ptr, int value) { memSet(memAddress(ptr), value, APIUtil.apiGetBytes(ptr.remaining(), 2)); } public static void memSet(LongBuffer ptr, int value) { memSet(memAddress(ptr), value, APIUtil.apiGetBytes(ptr.remaining(), 3)); } public static void memSet(FloatBuffer ptr, int value) { memSet(memAddress(ptr), value, APIUtil.apiGetBytes(ptr.remaining(), 2)); } public static void memSet(DoubleBuffer ptr, int value) { memSet(memAddress(ptr), value, APIUtil.apiGetBytes(ptr.remaining(), 3)); } public static <T extends CustomBuffer<T>> void memSet(T ptr, int value) { memSet(memAddress((CustomBuffer<?>)ptr), value, Integer.toUnsignedLong(ptr.remaining()) * ptr.sizeof()); } public static <T extends Struct<T>> void memSet(T ptr, int value) { memSet(((Struct)ptr).address, value, ptr.sizeof()); } public static void memCopy(ByteBuffer src, ByteBuffer dst) { if (Checks.CHECKS) Checks.check(dst, src.remaining());  MemoryUtilTunables.memcpy(memAddress(src), memAddress(dst), src.remaining()); } public static void memCopy(ShortBuffer src, ShortBuffer dst) { if (Checks.CHECKS) Checks.check(dst, src.remaining());  MemoryUtilTunables.memcpy(memAddress(src), memAddress(dst), APIUtil.apiGetBytes(src.remaining(), 1)); } public static void memCopy(CharBuffer src, CharBuffer dst) { if (Checks.CHECKS) Checks.check(dst, src.remaining());  MemoryUtilTunables.memcpy(memAddress(src), memAddress(dst), APIUtil.apiGetBytes(src.remaining(), 1)); } public static void memCopy(IntBuffer src, IntBuffer dst) { if (Checks.CHECKS) Checks.check(dst, src.remaining());  MemoryUtilTunables.memcpy(memAddress(src), memAddress(dst), APIUtil.apiGetBytes(src.remaining(), 2)); } public static void memCopy(LongBuffer src, LongBuffer dst) { if (Checks.CHECKS) Checks.check(dst, src.remaining());  MemoryUtilTunables.memcpy(memAddress(src), memAddress(dst), APIUtil.apiGetBytes(src.remaining(), 3)); } public static void memCopy(FloatBuffer src, FloatBuffer dst) { if (Checks.CHECKS) Checks.check(dst, src.remaining());  MemoryUtilTunables.memcpy(memAddress(src), memAddress(dst), APIUtil.apiGetBytes(src.remaining(), 2)); } public static void memCopy(DoubleBuffer src, DoubleBuffer dst) { if (Checks.CHECKS) Checks.check(dst, src.remaining());  MemoryUtilTunables.memcpy(memAddress(src), memAddress(dst), APIUtil.apiGetBytes(src.remaining(), 3)); } public static <T extends CustomBuffer<T>> void memCopy(T src, T dst) { if (Checks.CHECKS) Checks.check((CustomBuffer)dst, src.remaining());  MemoryUtilTunables.memcpy(memAddress((CustomBuffer<?>)src), memAddress((CustomBuffer<?>)dst), Integer.toUnsignedLong(src.remaining()) * src.sizeof()); } public static <T extends Struct<T>> void memCopy(T src, T dst) { MemoryUtilTunables.memcpy(((Struct)src).address, ((Struct)dst).address, src.sizeof()); } public static void memCopy(byte[] src, ByteBuffer dst) { if (Checks.CHECKS) Checks.check(dst, src.length);  MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length); } public static void memCopy(short[] src, ByteBuffer dst) { if (Checks.CHECKS) Checks.check(dst, APIUtil.apiGetBytes(src.length, 1));  MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length); } public static void memCopy(short[] src, ShortBuffer dst) { if (Checks.CHECKS) Checks.check(dst, src.length);  MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length); } public static void memCopy(int[] src, ByteBuffer dst) { if (Checks.CHECKS) Checks.check(dst, APIUtil.apiGetBytes(src.length, 2));  MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length); } public static void memCopy(int[] src, IntBuffer dst) { if (Checks.CHECKS) Checks.check(dst, src.length);  MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length); } public static void memCopy(long[] src, ByteBuffer dst) { if (Checks.CHECKS) Checks.check(dst, APIUtil.apiGetBytes(src.length, 3));  MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length); } public static void memCopy(long[] src, LongBuffer dst) { if (Checks.CHECKS) Checks.check(dst, src.length);  MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length); } public static void memCopy(float[] src, ByteBuffer dst) { if (Checks.CHECKS) Checks.check(dst, APIUtil.apiGetBytes(src.length, 2));  MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length); } public static void memCopy(float[] src, FloatBuffer dst) { if (Checks.CHECKS) Checks.check(dst, src.length);  MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length); } public static void memCopy(double[] src, ByteBuffer dst) { if (Checks.CHECKS) Checks.check(dst, APIUtil.apiGetBytes(src.length, 3));  MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length); } public static void memCopy(double[] src, DoubleBuffer dst) { if (Checks.CHECKS) Checks.check(dst, src.length);  MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length); } public static void memCopy(byte[] src, ByteBuffer dst, int offset, int size) { if (Checks.CHECKS) Checks.check(dst, size);  MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size); } public static void memCopy(short[] src, ByteBuffer dst, int offset, int size) { if (Checks.CHECKS) Checks.check(dst, APIUtil.apiGetBytes(size, 1));  MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size); } public static void memCopy(short[] src, ShortBuffer dst, int offset, int size) { if (Checks.CHECKS) Checks.check(dst, size);  MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size); } public static void memCopy(int[] src, ByteBuffer dst, int offset, int size) { if (Checks.CHECKS) Checks.check(dst, APIUtil.apiGetBytes(size, 2));  MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size); } public static void memCopy(int[] src, IntBuffer dst, int offset, int size) { if (Checks.CHECKS) Checks.check(dst, size);  MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size); } public static void memCopy(long[] src, ByteBuffer dst, int offset, int size) { if (Checks.CHECKS) Checks.check(dst, APIUtil.apiGetBytes(size, 3));  MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size); } public static void memCopy(long[] src, LongBuffer dst, int offset, int size) { if (Checks.CHECKS) Checks.check(dst, size);  MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size); } public static void memCopy(float[] src, ByteBuffer dst, int offset, int size) { if (Checks.CHECKS) Checks.check(dst, APIUtil.apiGetBytes(size, 2));  MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size); } public static void memCopy(float[] src, FloatBuffer dst, int offset, int size) { if (Checks.CHECKS) Checks.check(dst, size);  MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size); } public static void memCopy(double[] src, ByteBuffer dst, int offset, int size) { if (Checks.CHECKS) Checks.check(dst, APIUtil.apiGetBytes(size, 3));  MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size); } public static void memCopy(double[] src, DoubleBuffer dst, int offset, int size) { if (Checks.CHECKS) Checks.check(dst, size);  MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size); } public static void memCopy(ByteBuffer src, byte[] dst) { if (Checks.CHECKS) Checks.check(src, dst.length);  MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length); } public static void memCopy(ByteBuffer src, short[] dst) { if (Checks.CHECKS) Checks.check(src, APIUtil.apiGetBytes(dst.length, 1));  MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length); } public static void memCopy(ShortBuffer src, short[] dst) { if (Checks.CHECKS) Checks.check(src, dst.length);  MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length); } public static void memCopy(ByteBuffer src, int[] dst) { if (Checks.CHECKS) Checks.check(src, APIUtil.apiGetBytes(dst.length, 2));  MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length); } public static void memCopy(IntBuffer src, int[] dst) { if (Checks.CHECKS) Checks.check(src, dst.length);  MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length); } public static void memCopy(ByteBuffer src, long[] dst) { if (Checks.CHECKS) Checks.check(src, APIUtil.apiGetBytes(dst.length, 3));  MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length); } public static void memCopy(LongBuffer src, long[] dst) { if (Checks.CHECKS) Checks.check(src, dst.length);  MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length); } public static void memCopy(ByteBuffer src, float[] dst) { if (Checks.CHECKS) Checks.check(src, APIUtil.apiGetBytes(dst.length, 2));  MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length); } public static void memCopy(FloatBuffer src, float[] dst) { if (Checks.CHECKS) Checks.check(src, dst.length);  MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length); } public static void memCopy(ByteBuffer src, double[] dst) { if (Checks.CHECKS) Checks.check(src, APIUtil.apiGetBytes(dst.length, 3));  MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length); } public static void memCopy(DoubleBuffer src, double[] dst) { if (Checks.CHECKS) Checks.check(src, dst.length);  MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length); } public static void memCopy(ByteBuffer src, byte[] dst, int offset, int size) { if (Checks.CHECKS) Checks.check(src, size);  MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size); } public static void memCopy(ByteBuffer src, short[] dst, int offset, int size) { if (Checks.CHECKS) Checks.check(src, APIUtil.apiGetBytes(size, 1));  MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size); } public static void memCopy(ShortBuffer src, short[] dst, int offset, int size) { if (Checks.CHECKS) Checks.check(src, size);  MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size); } public static void memCopy(ByteBuffer src, int[] dst, int offset, int size) { if (Checks.CHECKS) Checks.check(src, APIUtil.apiGetBytes(size, 2));  MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size); } public static void memCopy(IntBuffer src, int[] dst, int offset, int size) { if (Checks.CHECKS) Checks.check(src, size);  MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size); } public static void memCopy(ByteBuffer src, long[] dst, int offset, int size) { if (Checks.CHECKS) Checks.check(src, APIUtil.apiGetBytes(size, 3));  MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size); } public static void memCopy(LongBuffer src, long[] dst, int offset, int size) { if (Checks.CHECKS) Checks.check(src, size);  MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size); } public static void memCopy(ByteBuffer src, float[] dst, int offset, int size) { if (Checks.CHECKS) Checks.check(src, APIUtil.apiGetBytes(size, 2));  MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size); } public static void memCopy(FloatBuffer src, float[] dst, int offset, int size) { if (Checks.CHECKS) Checks.check(src, size);  MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size); } public static void memCopy(ByteBuffer src, double[] dst, int offset, int size) { if (Checks.CHECKS) Checks.check(src, APIUtil.apiGetBytes(size, 3));  MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size); } public static void memCopy(DoubleBuffer src, double[] dst, int offset, int size) { if (Checks.CHECKS) Checks.check(src, size);  MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size); } public static void memSet(long ptr, int value, long bytes) { if (Checks.DEBUG && (ptr == 0L || bytes < 0L)) throw new IllegalArgumentException();  MemoryUtilTunables.memset(ptr, value, bytes); } public static void memCopy(long src, long dst, long bytes) { if (Checks.DEBUG && (src == 0L || dst == 0L || bytes < 0L)) throw new IllegalArgumentException();  MemoryUtilTunables.memcpy(src, dst, bytes); } public static void memCopy(byte[] src, long dst) { MemoryUtilTunables.memcpy(src, dst, 0, src.length); } public static void memCopy(short[] src, long dst) { MemoryUtilTunables.memcpy(src, dst, 0, src.length); } public static void memCopy(int[] src, long dst) { MemoryUtilTunables.memcpy(src, dst, 0, src.length); } public static void memCopy(long[] src, long dst) { MemoryUtilTunables.memcpy(src, dst, 0, src.length); } public static void memCopy(float[] src, long dst) { MemoryUtilTunables.memcpy(src, dst, 0, src.length); } public static void memCopy(double[] src, long dst) { MemoryUtilTunables.memcpy(src, dst, 0, src.length); } public static void memCopy(byte[] src, long dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); } public static void memCopy(short[] src, long dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); } public static void memCopy(int[] src, long dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); } public static void memCopy(long[] src, long dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); } public static void memCopy(float[] src, long dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); } public static void memCopy(double[] src, long dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); } public static void memCopy(long src, byte[] dst) { MemoryUtilTunables.memcpy(src, dst, 0, dst.length); } public static void memCopy(long src, short[] dst) { MemoryUtilTunables.memcpy(src, dst, 0, dst.length); } public static void memCopy(long src, int[] dst) { MemoryUtilTunables.memcpy(src, dst, 0, dst.length); } public static void memCopy(long src, long[] dst) { MemoryUtilTunables.memcpy(src, dst, 0, dst.length); } public static void memCopy(long src, float[] dst) { MemoryUtilTunables.memcpy(src, dst, 0, dst.length); } public static void memCopy(long src, double[] dst) { MemoryUtilTunables.memcpy(src, dst, 0, dst.length); } public static void memCopy(long src, byte[] dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); } public static void memCopy(long src, short[] dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); } public static void memCopy(long src, int[] dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); } public static void memCopy(long src, long[] dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); } public static void memCopy(long src, float[] dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); } public static void memCopy(long src, double[] dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); } private static long castAddress32(int ptr) { return ptr & 0xFFFFFFFFL; }
/*      */ 
/*      */   
/* 2413 */   public static boolean memGetBoolean(long ptr) { return (VH_JAVA_BYTE.get(ptr) != 0); }
/* 2414 */   public static byte memGetByte(long ptr) { return VH_JAVA_BYTE.get(ptr); }
/* 2415 */   public static short memGetShort(long ptr) { return VH_JAVA_SHORT.get(ptr); }
/* 2416 */   public static int memGetInt(long ptr) { return VH_JAVA_INT.get(ptr); }
/* 2417 */   public static long memGetLong(long ptr) { return VH_JAVA_LONG.get(ptr); }
/* 2418 */   public static float memGetFloat(long ptr) { return VH_JAVA_FLOAT.get(ptr); } public static double memGetDouble(long ptr) {
/* 2419 */     return VH_JAVA_DOUBLE.get(ptr);
/*      */   }
/* 2421 */   public static void memPutByte(long ptr, byte value) { VH_JAVA_BYTE.set(ptr, value); }
/* 2422 */   public static void memPutShort(long ptr, short value) { VH_JAVA_SHORT.set(ptr, value); }
/* 2423 */   public static void memPutInt(long ptr, int value) { VH_JAVA_INT.set(ptr, value); }
/* 2424 */   public static void memPutLong(long ptr, long value) { VH_JAVA_LONG.set(ptr, value); }
/* 2425 */   public static void memPutFloat(long ptr, float value) { VH_JAVA_FLOAT.set(ptr, value); } public static void memPutDouble(long ptr, double value) {
/* 2426 */     VH_JAVA_DOUBLE.set(ptr, value);
/*      */   }
/*      */   public static long memGetCLong(long ptr) {
/* 2429 */     return VH_CLONG.get(ptr);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long memGetAddress(long ptr) {
/* 2436 */     return VH_ADDRESS.get(ptr);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memPutCLong(long ptr, long value) {
/* 2443 */     VH_CLONG.set(ptr, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memPutAddress(long ptr, long value) {
/* 2452 */     VH_ADDRESS.set(ptr, value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean memGetBoolean(MemorySegment segment, long offset) {
/* 2466 */     return memGetBoolean(segment.address() + offset);
/* 2467 */   } public static byte memGetByte(MemorySegment segment, long offset) { return memGetByte(segment.address() + offset); }
/* 2468 */   public static short memGetShort(MemorySegment segment, long offset) { return memGetShort(segment.address() + offset); }
/* 2469 */   public static int memGetInt(MemorySegment segment, long offset) { return memGetInt(segment.address() + offset); }
/* 2470 */   public static long memGetLong(MemorySegment segment, long offset) { return memGetLong(segment.address() + offset); }
/* 2471 */   public static float memGetFloat(MemorySegment segment, long offset) { return memGetFloat(segment.address() + offset); }
/* 2472 */   public static double memGetDouble(MemorySegment segment, long offset) { return memGetDouble(segment.address() + offset); }
/* 2473 */   public static long memGetCLong(MemorySegment segment, long offset) { return memGetCLong(segment.address() + offset); } public static long memGetAddress(MemorySegment segment, long offset) {
/* 2474 */     return memGetAddress(segment.address() + offset);
/*      */   }
/* 2476 */   public static void memPutByte(MemorySegment segment, long offset, byte value) { memPutByte(segment.address() + offset, value); }
/* 2477 */   public static void memPutShort(MemorySegment segment, long offset, short value) { memPutShort(segment.address() + offset, value); }
/* 2478 */   public static void memPutInt(MemorySegment segment, long offset, int value) { memPutInt(segment.address() + offset, value); }
/* 2479 */   public static void memPutLong(MemorySegment segment, long offset, long value) { memPutLong(segment.address() + offset, value); }
/* 2480 */   public static void memPutFloat(MemorySegment segment, long offset, float value) { memPutFloat(segment.address() + offset, value); }
/* 2481 */   public static void memPutDouble(MemorySegment segment, long offset, double value) { memPutDouble(segment.address() + offset, value); }
/* 2482 */   public static void memPutCLong(MemorySegment segment, long offset, long value) { memPutCLong(segment.address() + offset, value); } public static void memPutAddress(MemorySegment segment, long offset, long value) {
/* 2483 */     memPutAddress(segment.address() + offset, value);
/*      */   }
/* 2485 */   public static short memGetShortAtIndex(MemorySegment segment, long index) { return memGetShort(segment.address() + (index << 1L)); }
/* 2486 */   public static int memGetIntAtIndex(MemorySegment segment, long index) { return memGetInt(segment.address() + (index << 2L)); }
/* 2487 */   public static long memGetLongAtIndex(MemorySegment segment, long index) { return memGetLong(segment.address() + (index << 3L)); }
/* 2488 */   public static float memGetFloatAtIndex(MemorySegment segment, long index) { return memGetFloat(segment.address() + (index << 2L)); }
/* 2489 */   public static double memGetDoubleAtIndex(MemorySegment segment, long index) { return memGetDouble(segment.address() + (index << 3L)); }
/* 2490 */   public static long memGetCLongAtIndex(MemorySegment segment, long index) { return memGetCLong(segment.address() + (index << Pointer.CLONG_SHIFT)); } public static long memGetAddressAtIndex(MemorySegment segment, long index) {
/* 2491 */     return memGetAddress(segment.address() + (index << Pointer.POINTER_SHIFT));
/*      */   }
/* 2493 */   public static void memPutShortAtIndex(MemorySegment segment, long index, short value) { memPutShort(segment.address() + (index << 1L), value); }
/* 2494 */   public static void memPutIntAtIndex(MemorySegment segment, long index, int value) { memPutInt(segment.address() + (index << 2L), value); }
/* 2495 */   public static void memPutLongAtIndex(MemorySegment segment, long index, long value) { memPutLong(segment.address() + (index << 3L), value); }
/* 2496 */   public static void memPutFloatAtIndex(MemorySegment segment, long index, float value) { memPutFloat(segment.address() + (index << 2L), value); }
/* 2497 */   public static void memPutDoubleAtIndex(MemorySegment segment, long index, double value) { memPutDouble(segment.address() + (index << 3L), value); }
/* 2498 */   public static void memPutCLongAtIndex(MemorySegment segment, long index, long value) { memPutCLong(segment.address() + (index << Pointer.CLONG_SHIFT), value); } public static void memPutAddressAtIndex(MemorySegment segment, long index, long value) {
/* 2499 */     memPutAddress(segment.address() + (index << Pointer.POINTER_SHIFT), value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int write8(long target, int offset, int value) {
/* 2524 */     memPutByte(target + Integer.toUnsignedLong(offset), (byte)value);
/* 2525 */     return offset + 1;
/*      */   }
/*      */   private static int write8Safe(long target, int offset, int maxLength, int value) {
/* 2528 */     if (offset == maxLength) {
/* 2529 */       throw new BufferOverflowException();
/*      */     }
/* 2531 */     memPutByte(target + Integer.toUnsignedLong(offset), (byte)value);
/* 2532 */     return offset + 1;
/*      */   }
/*      */   private static int write16(long target, int offset, char value) {
/* 2535 */     memPutShort(target + Integer.toUnsignedLong(offset), (short)value);
/* 2536 */     return offset + 2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memASCII(CharSequence text) {
/* 2549 */     return memASCII(text, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memASCIISafe(CharSequence text) {
/* 2555 */     return (text == null) ? null : memASCII(text, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memASCII(CharSequence text, boolean nullTerminated) {
/* 2569 */     int length = memLengthASCII(text, nullTerminated);
/* 2570 */     long target = nmemAlloc(length);
/* 2571 */     if (Checks.CHECKS && target == 0L) {
/* 2572 */       throw new OutOfMemoryError();
/*      */     }
/* 2574 */     encodeASCIIUnsafe(text, nullTerminated, target);
/* 2575 */     return wrapBufferByte(target, length);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memASCIISafe(CharSequence text, boolean nullTerminated) {
/* 2581 */     return (text == null) ? null : memASCII(text, nullTerminated);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memASCII(CharSequence text, boolean nullTerminated, ByteBuffer target) {
/* 2597 */     if (target.remaining() < memLengthASCII(text, nullTerminated)) {
/* 2598 */       throw new BufferOverflowException();
/*      */     }
/* 2600 */     long address = memAddress(target);
/* 2601 */     return encodeASCIIUnsafe(text, nullTerminated, address);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memASCII(CharSequence text, boolean nullTerminated, ByteBuffer target, int offset) {
/* 2617 */     if (target.capacity() - offset < memLengthASCII(text, nullTerminated)) {
/* 2618 */       throw new BufferOverflowException();
/*      */     }
/* 2620 */     return encodeASCIIUnsafe(text, nullTerminated, memAddress(target, offset));
/*      */   }
/*      */   
/*      */   static int encodeASCIIUnsafe(CharSequence text, boolean nullTerminated, long target) {
/* 2624 */     int i = 0, len = text.length();
/*      */     
/* 2626 */     while (i < len) {
/* 2627 */       i = write8(target, i, text.charAt(i));
/*      */     }
/*      */     
/* 2630 */     if (nullTerminated) {
/* 2631 */       i = write8(target, i, 0);
/*      */     }
/*      */     
/* 2634 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memLengthASCII(CharSequence value, boolean nullTerminated) {
/* 2648 */     int len = value.length() + (nullTerminated ? 1 : 0);
/* 2649 */     if (len < 0) {
/* 2650 */       throw new BufferOverflowException();
/*      */     }
/* 2652 */     return len;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF8(CharSequence text) {
/* 2665 */     return memUTF8(text, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF8Safe(CharSequence text) {
/* 2671 */     return (text == null) ? null : memUTF8(text, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF8(CharSequence text, boolean nullTerminated) {
/* 2685 */     int length = memLengthUTF8(text, nullTerminated);
/* 2686 */     long target = nmemAlloc(length);
/* 2687 */     if (Checks.CHECKS && target == 0L) {
/* 2688 */       throw new OutOfMemoryError();
/*      */     }
/* 2690 */     encodeUTF8Unsafe(text, nullTerminated, target);
/* 2691 */     return wrapBufferByte(target, length);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF8Safe(CharSequence text, boolean nullTerminated) {
/* 2697 */     return (text == null) ? null : memUTF8(text, nullTerminated);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memUTF8(CharSequence text, boolean nullTerminated, ByteBuffer target) {
/* 2713 */     if (target.remaining() < memLengthASCII(text, nullTerminated)) {
/* 2714 */       throw new BufferOverflowException();
/*      */     }
/* 2716 */     return encodeUTF8Safe(text, nullTerminated, memAddress(target), target.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memUTF8(CharSequence text, boolean nullTerminated, ByteBuffer target, int offset) {
/* 2733 */     if (target.capacity() - offset < memLengthASCII(text, nullTerminated)) {
/* 2734 */       throw new BufferOverflowException();
/*      */     }
/* 2736 */     return encodeUTF8Safe(text, nullTerminated, memAddress(target, offset), target.capacity() - offset);
/*      */   }
/*      */   
/*      */   static int encodeUTF8Unsafe(CharSequence text, boolean nullTerminated, long target) {
/* 2740 */     int p = 0, i = 0, len = text.length();
/*      */     
/* 2742 */     while (i < len) {
/* 2743 */       char c = text.charAt(i++);
/* 2744 */       if (c < '') {
/* 2745 */         p = write8(target, p, c); continue;
/*      */       } 
/* 2747 */       int cp = c;
/* 2748 */       if (c < 'ࠀ') {
/* 2749 */         p = write8(target, p, 0xC0 | cp >> 6);
/*      */       } else {
/* 2751 */         if (!Character.isHighSurrogate(c)) {
/* 2752 */           p = write8(target, p, 0xE0 | cp >> 12);
/*      */         } else {
/* 2754 */           cp = Character.toCodePoint(c, text.charAt(i++));
/*      */           
/* 2756 */           p = write8(target, p, 0xF0 | cp >> 18);
/* 2757 */           p = write8(target, p, 0x80 | cp >> 12 & 0x3F);
/*      */         } 
/* 2759 */         p = write8(target, p, 0x80 | cp >> 6 & 0x3F);
/*      */       } 
/* 2761 */       p = write8(target, p, 0x80 | cp & 0x3F);
/*      */     } 
/*      */ 
/*      */     
/* 2765 */     if (nullTerminated) {
/* 2766 */       p = write8(target, p, 0);
/*      */     }
/*      */     
/* 2769 */     return p;
/*      */   }
/*      */   
/*      */   static int encodeUTF8Safe(CharSequence text, boolean nullTerminated, long target, int maxLength) {
/* 2773 */     int p = 0, i = 0, length = text.length();
/*      */ 
/*      */     
/* 2776 */     while (i < length) {
/* 2777 */       char c = text.charAt(i);
/* 2778 */       if ('' <= c) {
/*      */         break;
/*      */       }
/* 2781 */       p = write8(target, p, c);
/* 2782 */       i++;
/*      */     } 
/*      */ 
/*      */     
/* 2786 */     while (i < length) {
/* 2787 */       char c = text.charAt(i++);
/* 2788 */       if (c < '') {
/* 2789 */         p = write8Safe(target, p, maxLength, c); continue;
/*      */       } 
/* 2791 */       int cp = c;
/* 2792 */       if (c < 'ࠀ') {
/* 2793 */         p = write8Safe(target, p, maxLength, 0xC0 | cp >> 6);
/*      */       } else {
/* 2795 */         if (!Character.isHighSurrogate(c)) {
/* 2796 */           p = write8Safe(target, p, maxLength, 0xE0 | cp >> 12);
/*      */         } else {
/* 2798 */           cp = Character.toCodePoint(c, text.charAt(i++));
/*      */           
/* 2800 */           p = write8Safe(target, p, maxLength, 0xF0 | cp >> 18);
/* 2801 */           p = write8Safe(target, p, maxLength, 0x80 | cp >> 12 & 0x3F);
/*      */         } 
/* 2803 */         p = write8Safe(target, p, maxLength, 0x80 | cp >> 6 & 0x3F);
/*      */       } 
/* 2805 */       p = write8Safe(target, p, maxLength, 0x80 | cp & 0x3F);
/*      */     } 
/*      */ 
/*      */     
/* 2809 */     if (nullTerminated) {
/* 2810 */       p = write8Safe(target, p, maxLength, 0);
/*      */     }
/*      */     
/* 2813 */     return p;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memLengthUTF8(CharSequence value, boolean nullTerminated) {
/* 2827 */     int len = value.length();
/* 2828 */     int bytes = len + (nullTerminated ? 1 : 0);
/*      */     
/* 2830 */     for (int i = 0; i < len; i++) {
/* 2831 */       char c = value.charAt(i);
/*      */       
/* 2833 */       if (c >= '') {
/*      */ 
/*      */         
/* 2836 */         if (c < 'ࠀ') {
/*      */ 
/*      */           
/* 2839 */           bytes += 127 - c >>> 31;
/*      */         }
/*      */         else {
/*      */           
/* 2843 */           bytes += 2;
/* 2844 */           if (Character.isHighSurrogate(c)) {
/* 2845 */             i++;
/*      */           }
/*      */         } 
/* 2848 */         if (bytes < 0) {
/* 2849 */           throw new BufferOverflowException();
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2854 */     if (bytes < 0) {
/* 2855 */       throw new BufferOverflowException();
/*      */     }
/*      */     
/* 2858 */     return bytes;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF16(CharSequence text) {
/* 2871 */     return memUTF16(text, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF16Safe(CharSequence text) {
/* 2877 */     return (text == null) ? null : memUTF16(text, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF16(CharSequence text, boolean nullTerminated) {
/* 2891 */     int length = memLengthUTF16(text, nullTerminated);
/* 2892 */     long target = nmemAlloc(length);
/* 2893 */     if (Checks.CHECKS && target == 0L) {
/* 2894 */       throw new OutOfMemoryError();
/*      */     }
/* 2896 */     encodeUTF16Unsafe(text, nullTerminated, target);
/* 2897 */     return wrapBufferByte(target, length);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF16Safe(CharSequence text, boolean nullTerminated) {
/* 2903 */     return (text == null) ? null : memUTF16(text, nullTerminated);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memUTF16(CharSequence text, boolean nullTerminated, ByteBuffer target) {
/* 2920 */     if (target.remaining() < memLengthUTF16(text, nullTerminated)) {
/* 2921 */       throw new BufferOverflowException();
/*      */     }
/* 2923 */     long address = memAddress(target);
/* 2924 */     return encodeUTF16Unsafe(text, nullTerminated, address);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memUTF16(CharSequence text, boolean nullTerminated, ByteBuffer target, int offset) {
/* 2942 */     if (target.capacity() - offset < memLengthUTF16(text, nullTerminated)) {
/* 2943 */       throw new BufferOverflowException();
/*      */     }
/* 2945 */     long address = memAddress(target, offset);
/* 2946 */     return encodeUTF16Unsafe(text, nullTerminated, address);
/*      */   }
/*      */   
/*      */   static int encodeUTF16Unsafe(CharSequence text, boolean nullTerminated, long target) {
/* 2950 */     int p = 0, i = 0, len = text.length();
/*      */     
/* 2952 */     while (i < len) {
/* 2953 */       p = write16(target, p, text.charAt(i++));
/*      */     }
/*      */     
/* 2956 */     if (nullTerminated) {
/* 2957 */       p = write16(target, p, false);
/*      */     }
/*      */     
/* 2960 */     return p;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memLengthUTF16(CharSequence value, boolean nullTerminated) {
/* 2972 */     int len = value.length() + (nullTerminated ? 1 : 0);
/* 2973 */     if (len < 0 || 1073741823 < len) {
/* 2974 */       throw new BufferOverflowException();
/*      */     }
/* 2976 */     return len << 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int memLengthNT1(long address, int maxLength) {
/* 2986 */     if (Checks.CHECKS) {
/* 2987 */       Checks.check(address);
/*      */     }
/* 2989 */     return Pointer.BITS64 ? 
/* 2990 */       strlen64NT1(address, maxLength) : 
/* 2991 */       strlen32NT1(address, maxLength);
/*      */   }
/*      */   
/*      */   private static int strlen64NT1(long address, int maxLength) {
/* 2995 */     int i = 0;
/*      */     
/* 2997 */     if (8 <= maxLength) {
/* 2998 */       int misalignment = (int)address & 0x7;
/* 2999 */       if (misalignment != 0)
/*      */       {
/* 3001 */         for (int len = 8 - misalignment; i < len; i++) {
/* 3002 */           if (memGetByte(address + i) == 0) {
/* 3003 */             return i;
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 3009 */       for (; i <= maxLength - 8 && 
/* 3010 */         !MathUtil.mathHasZeroByte(memGetLong(address + i)); i += 8);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3017 */     for (; i < maxLength && 
/* 3018 */       memGetByte(address + i) != 0; i++);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3023 */     return i;
/*      */   }
/*      */   
/*      */   private static int strlen32NT1(long address, int maxLength) {
/* 3027 */     int i = 0;
/*      */     
/* 3029 */     if (4 <= maxLength) {
/* 3030 */       int misalignment = (int)address & 0x3;
/* 3031 */       if (misalignment != 0)
/*      */       {
/* 3033 */         for (int len = 4 - misalignment; i < len; i++) {
/* 3034 */           if (memGetByte(address + i) == 0) {
/* 3035 */             return i;
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 3041 */       for (; i <= maxLength - 4 && 
/* 3042 */         !MathUtil.mathHasZeroByte(memGetInt(address + i)); i += 4);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3049 */     for (; i < maxLength && 
/* 3050 */       memGetByte(address + i) != 0; i++);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3055 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memLengthNT1(ByteBuffer buffer) {
/* 3069 */     return memLengthNT1(memAddress(buffer), buffer.remaining());
/*      */   }
/*      */   
/*      */   private static int memLengthNT2(long address, int maxLength) {
/* 3073 */     if (Checks.CHECKS) {
/* 3074 */       Checks.check(address);
/*      */     }
/* 3076 */     return Pointer.BITS64 ? 
/* 3077 */       strlen64NT2(address, maxLength) : 
/* 3078 */       strlen32NT2((int)address, maxLength);
/*      */   }
/*      */   
/*      */   private static int strlen64NT2(long address, int maxLength) {
/* 3082 */     int i = 0;
/*      */     
/* 3084 */     if (8 <= maxLength) {
/* 3085 */       int misalignment = (int)address & 0x7;
/* 3086 */       if (misalignment != 0)
/*      */       {
/* 3088 */         for (int len = 8 - misalignment; i < len; i += 2) {
/* 3089 */           if (memGetShort(address + i) == 0) {
/* 3090 */             return i;
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 3096 */       for (; i <= maxLength - 8 && 
/* 3097 */         !MathUtil.mathHasZeroShort(memGetLong(address + i)); i += 8);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3104 */     for (; i < maxLength && 
/* 3105 */       memGetShort(address + i) != 0; i += 2);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3110 */     return i;
/*      */   }
/*      */   
/*      */   private static int strlen32NT2(long address, int maxLength) {
/* 3114 */     int i = 0;
/*      */     
/* 3116 */     if (4 <= maxLength) {
/* 3117 */       int misalignment = (int)address & 0x3;
/* 3118 */       if (misalignment != 0)
/*      */       {
/* 3120 */         for (int len = 4 - misalignment; i < len; i += 2) {
/* 3121 */           if (memGetShort(address + i) == 0) {
/* 3122 */             return i;
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 3128 */       while (i <= maxLength - 4 && 
/* 3129 */         !MathUtil.mathHasZeroShort(memGetInt(address + i)))
/*      */       {
/*      */         
/* 3132 */         i += 4;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 3137 */     for (; i < maxLength && 
/* 3138 */       memGetShort(address + i) != 0; i += 2);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3143 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int memLengthNT2(ByteBuffer buffer) {
/* 3157 */     return memLengthNT2(memAddress(buffer), buffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT1(long address) {
/* 3171 */     return memByteBuffer(address, memLengthNT1(address, 2147483639));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT1(long address, int maxLength) {
/* 3186 */     return memByteBuffer(address, memLengthNT1(address, maxLength));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT1Safe(long address) {
/* 3192 */     return (address == 0L) ? null : memByteBuffer(address, memLengthNT1(address, 2147483639));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT1Safe(long address, int maxLength) {
/* 3198 */     return (address == 0L) ? null : memByteBuffer(address, memLengthNT1(address, maxLength));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT2(long address) {
/* 3212 */     return memByteBufferNT2(address, 2147483638);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT2(long address, int maxLength) {
/* 3226 */     if (Checks.DEBUG && (
/* 3227 */       maxLength & 0x1) != 0) {
/* 3228 */       throw new IllegalArgumentException("The maximum length must be an even number.");
/*      */     }
/*      */     
/* 3231 */     return memByteBuffer(address, memLengthNT2(address, maxLength));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT2Safe(long address) {
/* 3237 */     return (address == 0L) ? null : memByteBufferNT2(address, 2147483638);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT2Safe(long address, int maxLength) {
/* 3243 */     return (address == 0L) ? null : memByteBufferNT2(address, maxLength);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memASCII(long address) {
/* 3254 */     return memASCII(address, memLengthNT1(address, 2147483639));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memASCII(long address, int length) {
/* 3267 */     if (length <= 0) {
/* 3268 */       return "";
/*      */     }
/*      */     
/* 3271 */     byte[] ascii = (length <= ARRAY_TLC_SIZE) ? ARRAY_TLC_BYTE.get() : new byte[length];
/* 3272 */     memByteBuffer(address, length).get(ascii, 0, length);
/* 3273 */     return new String(ascii, 0, 0, length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memASCII(ByteBuffer buffer) {
/* 3286 */     return memASCII(memAddress(buffer), buffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memASCIISafe(long address) {
/* 3292 */     return (address == 0L) ? null : memASCII(address, memLengthNT1(address, 2147483639));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memASCIISafe(long address, int length) {
/* 3298 */     return (address == 0L) ? null : memASCII(address, length);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memASCIISafe(ByteBuffer buffer) {
/* 3304 */     return (buffer == null) ? null : memASCII(memAddress(buffer), buffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memASCII(ByteBuffer buffer, int length) {
/* 3318 */     return memASCII(memAddress(buffer), length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memASCII(ByteBuffer buffer, int length, int offset) {
/* 3333 */     return memASCII(memAddress(buffer, offset), length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF8(long address) {
/* 3344 */     return MultiReleaseTextDecoding.decodeUTF8(address, memLengthNT1(address, 2147483639));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF8(long address, int length) {
/* 3356 */     return MultiReleaseTextDecoding.decodeUTF8(address, length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF8(ByteBuffer buffer) {
/* 3369 */     return MultiReleaseTextDecoding.decodeUTF8(memAddress(buffer), buffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF8Safe(long address) {
/* 3375 */     return (address == 0L) ? null : MultiReleaseTextDecoding.decodeUTF8(address, memLengthNT1(address, 2147483639));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF8Safe(long address, int length) {
/* 3381 */     return (address == 0L) ? null : MultiReleaseTextDecoding.decodeUTF8(address, length);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF8Safe(ByteBuffer buffer) {
/* 3387 */     return (buffer == null) ? null : MultiReleaseTextDecoding.decodeUTF8(memAddress(buffer), buffer.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF8(ByteBuffer buffer, int length) {
/* 3401 */     return MultiReleaseTextDecoding.decodeUTF8(memAddress(buffer), length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF8(ByteBuffer buffer, int length, int offset) {
/* 3416 */     return MultiReleaseTextDecoding.decodeUTF8(memAddress(buffer, offset), length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF16(long address) {
/* 3427 */     return memUTF16(address, memLengthNT2(address, 2147483638) >> 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF16(long address, int length) {
/* 3439 */     if (length <= 0) {
/* 3440 */       return "";
/*      */     }
/*      */     
/* 3443 */     if (Checks.DEBUG) {
/*      */       
/* 3445 */       int len = length << 1;
/* 3446 */       byte[] bytes = (len <= ARRAY_TLC_SIZE) ? ARRAY_TLC_BYTE.get() : new byte[len];
/* 3447 */       memByteBuffer(address, len).get(bytes, 0, len);
/* 3448 */       return new String(bytes, 0, len, UTF16);
/*      */     } 
/*      */     
/* 3451 */     char[] chars = (length <= ARRAY_TLC_SIZE) ? ARRAY_TLC_CHAR.get() : new char[length];
/* 3452 */     memCharBuffer(address, length).get(chars, 0, length);
/* 3453 */     return new String(chars, 0, length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF16(ByteBuffer buffer) {
/* 3466 */     return memUTF16(memAddress(buffer), buffer.remaining() >> 1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF16Safe(long address) {
/* 3472 */     return (address == 0L) ? null : memUTF16(address, memLengthNT2(address, 2147483638) >> 1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF16Safe(long address, int length) {
/* 3478 */     return (address == 0L) ? null : memUTF16(address, length);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF16Safe(ByteBuffer buffer) {
/* 3484 */     return (buffer == null) ? null : memUTF16(memAddress(buffer), buffer.remaining() >> 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF16(ByteBuffer buffer, int length) {
/* 3498 */     return memUTF16(memAddress(buffer), length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String memUTF16(ByteBuffer buffer, int length, int offset) {
/* 3513 */     return memUTF16(memAddress(buffer, offset), length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static ByteBuffer wrapBufferByte(long address, int capacity) {
/* 3524 */     return MemorySegment.ofAddress(address)
/* 3525 */       .reinterpret(capacity & 0xFFFFFFFFL)
/* 3526 */       .asByteBuffer()
/* 3527 */       .order(ByteOrder.nativeOrder());
/*      */   }
/* 3529 */   static ShortBuffer wrapBufferShort(long address, int capacity) { return wrapBufferByte(address, capacity << 1).asShortBuffer(); }
/* 3530 */   static CharBuffer wrapBufferChar(long address, int capacity) { return wrapBufferByte(address, capacity << 1).asCharBuffer(); }
/* 3531 */   static IntBuffer wrapBufferInt(long address, int capacity) { return wrapBufferByte(address, capacity << 2).asIntBuffer(); }
/* 3532 */   static LongBuffer wrapBufferLong(long address, int capacity) { return wrapBufferByte(address, capacity << 3).asLongBuffer(); }
/* 3533 */   static FloatBuffer wrapBufferFloat(long address, int capacity) { return wrapBufferByte(address, capacity << 2).asFloatBuffer(); } static DoubleBuffer wrapBufferDouble(long address, int capacity) {
/* 3534 */     return wrapBufferByte(address, capacity << 3).asDoubleBuffer();
/*      */   }
/*      */   
/*      */   public static native <T> T memGlobalRefToObject(long paramLong);
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\MemoryUtil.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */