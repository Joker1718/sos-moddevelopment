/*      */ package org.lwjgl.system;
/*      */ 
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Modifier;
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
/*      */ import java.util.Objects;
/*      */ import java.util.function.LongPredicate;
/*      */ import org.lwjgl.CLongBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.jni.JNINativeInterface;
/*      */ import sun.misc.Unsafe;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class MemoryUtil
/*      */ {
/*      */   public static final long NULL = 0L;
/*      */   public static final int PAGE_SIZE;
/*      */   public static final int CACHE_LINE_SIZE;
/*   63 */   static final int ARRAY_TLC_SIZE = ((Integer)Configuration.ARRAY_TLC_SIZE.get(Integer.valueOf(8192))).intValue();
/*      */   
/*   65 */   static final ThreadLocal<byte[]> ARRAY_TLC_BYTE = (ThreadLocal)ThreadLocal.withInitial(() -> new byte[ARRAY_TLC_SIZE]);
/*   66 */   static final ThreadLocal<char[]> ARRAY_TLC_CHAR = (ThreadLocal)ThreadLocal.withInitial(() -> new char[ARRAY_TLC_SIZE]);
/*      */   
/*      */   static final Unsafe UNSAFE;
/*      */   
/*   70 */   static final ByteOrder NATIVE_ORDER = ByteOrder.nativeOrder();
/*      */   
/*   72 */   private static final Charset UTF16 = (NATIVE_ORDER == ByteOrder.LITTLE_ENDIAN) ? StandardCharsets.UTF_16LE : StandardCharsets.UTF_16BE;
/*      */   
/*      */   static final Class<? extends ByteBuffer> BUFFER_BYTE;
/*      */   
/*      */   static final Class<? extends ShortBuffer> BUFFER_SHORT;
/*      */   
/*      */   static final Class<? extends CharBuffer> BUFFER_CHAR;
/*      */   
/*      */   static final Class<? extends IntBuffer> BUFFER_INT;
/*      */   static final Class<? extends LongBuffer> BUFFER_LONG;
/*      */   static final Class<? extends FloatBuffer> BUFFER_FLOAT;
/*      */   static final Class<? extends DoubleBuffer> BUFFER_DOUBLE;
/*      */   private static final long MARK;
/*      */   private static final long POSITION;
/*      */   private static final long LIMIT;
/*      */   private static final long CAPACITY;
/*      */   private static final long ADDRESS;
/*      */   private static final long PARENT_BYTE;
/*      */   private static final long PARENT_SHORT;
/*      */   private static final long PARENT_CHAR;
/*      */   private static final long PARENT_INT;
/*      */   private static final long PARENT_LONG;
/*      */   private static final long PARENT_FLOAT;
/*      */   private static final long PARENT_DOUBLE;
/*      */   private static final int MAGIC_CAPACITY = 219540062;
/*      */   private static final int MAGIC_POSITION = 16435934;
/*      */   
/*      */   static {
/*  100 */     Library.initialize();
/*      */     
/*  102 */     ByteBuffer bb = ByteBuffer.allocateDirect(0).order(NATIVE_ORDER);
/*      */     
/*  104 */     BUFFER_BYTE = (Class)bb.getClass();
/*  105 */     BUFFER_SHORT = (Class)bb.asShortBuffer().getClass();
/*  106 */     BUFFER_CHAR = (Class)bb.asCharBuffer().getClass();
/*  107 */     BUFFER_INT = (Class)bb.asIntBuffer().getClass();
/*  108 */     BUFFER_LONG = (Class)bb.asLongBuffer().getClass();
/*  109 */     BUFFER_FLOAT = (Class)bb.asFloatBuffer().getClass();
/*  110 */     BUFFER_DOUBLE = (Class)bb.asDoubleBuffer().getClass();
/*      */     
/*  112 */     UNSAFE = getUnsafeInstance();
/*      */     
/*      */     try {
/*  115 */       MARK = getMarkOffset();
/*  116 */       POSITION = getPositionOffset();
/*  117 */       LIMIT = getLimitOffset();
/*  118 */       CAPACITY = getCapacityOffset();
/*      */       
/*  120 */       ADDRESS = getAddressOffset();
/*      */       
/*  122 */       PARENT_BYTE = getFieldOffsetObject(bb.duplicate().order(bb.order()), bb);
/*  123 */       PARENT_SHORT = getFieldOffsetObject(bb.asShortBuffer(), bb);
/*  124 */       PARENT_CHAR = getFieldOffsetObject(bb.asCharBuffer(), bb);
/*  125 */       PARENT_INT = getFieldOffsetObject(bb.asIntBuffer(), bb);
/*  126 */       PARENT_LONG = getFieldOffsetObject(bb.asLongBuffer(), bb);
/*  127 */       PARENT_FLOAT = getFieldOffsetObject(bb.asFloatBuffer(), bb);
/*  128 */       PARENT_DOUBLE = getFieldOffsetObject(bb.asDoubleBuffer(), bb);
/*  129 */     } catch (Throwable t) {
/*  130 */       throw new UnsupportedOperationException(t);
/*      */     } 
/*      */     
/*  133 */     PAGE_SIZE = UNSAFE.pageSize();
/*  134 */     CACHE_LINE_SIZE = 64;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static final class LazyInit
/*      */   {
/*      */     static {
/*  146 */       boolean debug = ((Boolean)Configuration.DEBUG_MEMORY_ALLOCATOR.get(Boolean.valueOf(false))).booleanValue();
/*      */     }
/*  148 */     static final MemoryUtil.MemoryAllocator ALLOCATOR_IMPL = MemoryManage.getInstance(); static final MemoryUtil.MemoryAllocator ALLOCATOR; static {
/*  149 */       ALLOCATOR = debug ? new MemoryManage.DebugAllocator(ALLOCATOR_IMPL) : ALLOCATOR_IMPL;
/*      */ 
/*      */ 
/*      */       
/*  153 */       APIUtil.apiLog("MemoryUtil allocator: " + ALLOCATOR.getClass().getSimpleName());
/*  154 */       if (debug && !((Boolean)Configuration.DEBUG_MEMORY_ALLOCATOR_FAST.get(Boolean.valueOf(false))).booleanValue()) {
/*  155 */         APIUtil.apiLogMore("Reminder: enable Configuration.DEBUG_MEMORY_ALLOCATOR_FAST for low overhead allocation tracking.");
/*      */       }
/*      */     }
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MemoryAllocator getAllocator() {
/*  213 */     return getAllocator(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MemoryAllocator getAllocator(boolean tracked) {
/*  224 */     return tracked ? LazyInit.ALLOCATOR : LazyInit.ALLOCATOR_IMPL;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nmemAlloc(long size) {
/*  233 */     return LazyInit.ALLOCATOR.malloc(size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nmemAllocChecked(long size) {
/*  244 */     long address = nmemAlloc((size != 0L) ? size : 1L);
/*  245 */     if (Checks.CHECKS && address == 0L) {
/*  246 */       throw new OutOfMemoryError();
/*      */     }
/*  248 */     return address;
/*      */   }
/*      */   
/*      */   private static long getAllocationSize(int elements, int elementShift) {
/*  252 */     return APIUtil.apiCheckAllocation(elements, Integer.toUnsignedLong(elements) << elementShift, Pointer.BITS64 ? Long.MAX_VALUE : 4294967295L);
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
/*      */   public static ByteBuffer memAlloc(int size) {
/*  270 */     return wrapBufferByte(nmemAllocChecked(size), size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ShortBuffer memAllocShort(int size) {
/*  279 */     return wrapBufferShort(nmemAllocChecked(getAllocationSize(size, 1)), size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static IntBuffer memAllocInt(int size) {
/*  288 */     return wrapBufferInt(nmemAllocChecked(getAllocationSize(size, 2)), size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FloatBuffer memAllocFloat(int size) {
/*  297 */     return wrapBufferFloat(nmemAllocChecked(getAllocationSize(size, 2)), size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LongBuffer memAllocLong(int size) {
/*  306 */     return wrapBufferLong(nmemAllocChecked(getAllocationSize(size, 3)), size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static CLongBuffer memAllocCLong(int size) {
/*  315 */     return CLongBuffer.create(nmemAllocChecked(getAllocationSize(size, Pointer.CLONG_SHIFT)), size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static DoubleBuffer memAllocDouble(int size) {
/*  324 */     return wrapBufferDouble(nmemAllocChecked(getAllocationSize(size, 3)), size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static PointerBuffer memAllocPointer(int size) {
/*  333 */     return PointerBuffer.create(nmemAllocChecked(getAllocationSize(size, Pointer.POINTER_SHIFT)), size);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void nmemFree(long ptr) {
/*  338 */     LazyInit.ALLOCATOR.free(ptr);
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
/*      */   public static void memFree(Buffer ptr) {
/*  352 */     if (ptr != null) {
/*  353 */       nmemFree(UNSAFE.getLong(ptr, ADDRESS));
/*      */     }
/*      */   }
/*      */   
/*      */   public static void memFree(ByteBuffer ptr) {
/*  358 */     if (ptr != null) {
/*  359 */       nmemFree(UNSAFE.getLong(ptr, ADDRESS));
/*      */     }
/*      */   }
/*      */   
/*      */   public static void memFree(ShortBuffer ptr) {
/*  364 */     if (ptr != null) {
/*  365 */       nmemFree(UNSAFE.getLong(ptr, ADDRESS));
/*      */     }
/*      */   }
/*      */   
/*      */   public static void memFree(CharBuffer ptr) {
/*  370 */     if (ptr != null) {
/*  371 */       nmemFree(UNSAFE.getLong(ptr, ADDRESS));
/*      */     }
/*      */   }
/*      */   
/*      */   public static void memFree(IntBuffer ptr) {
/*  376 */     if (ptr != null) {
/*  377 */       nmemFree(UNSAFE.getLong(ptr, ADDRESS));
/*      */     }
/*      */   }
/*      */   
/*      */   public static void memFree(LongBuffer ptr) {
/*  382 */     if (ptr != null) {
/*  383 */       nmemFree(UNSAFE.getLong(ptr, ADDRESS));
/*      */     }
/*      */   }
/*      */   
/*      */   public static void memFree(FloatBuffer ptr) {
/*  388 */     if (ptr != null) {
/*  389 */       nmemFree(UNSAFE.getLong(ptr, ADDRESS));
/*      */     }
/*      */   }
/*      */   
/*      */   public static void memFree(DoubleBuffer ptr) {
/*  394 */     if (ptr != null) {
/*  395 */       nmemFree(UNSAFE.getLong(ptr, ADDRESS));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static void memFree(CustomBuffer<?> ptr) {
/*  401 */     if (ptr != null) {
/*  402 */       nmemFree(ptr.address);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nmemCalloc(long num, long size) {
/*  410 */     return LazyInit.ALLOCATOR.calloc(num, size);
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
/*      */   public static long nmemCallocChecked(long num, long size) {
/*  422 */     if (num == 0L || size == 0L) {
/*  423 */       num = 1L;
/*  424 */       size = 1L;
/*      */     } 
/*      */     
/*  427 */     long address = nmemCalloc(num, size);
/*  428 */     if (Checks.CHECKS && address == 0L) {
/*  429 */       throw new OutOfMemoryError();
/*      */     }
/*  431 */     return address;
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
/*      */   public static ByteBuffer memCalloc(int num, int size) {
/*  451 */     return wrapBufferByte(nmemCallocChecked(num, size), num * size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ByteBuffer memCalloc(int num) {
/*  460 */     return wrapBufferByte(nmemCallocChecked(num, 1L), num);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ShortBuffer memCallocShort(int num) {
/*  469 */     return wrapBufferShort(nmemCallocChecked(num, 2L), num);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static IntBuffer memCallocInt(int num) {
/*  478 */     return wrapBufferInt(nmemCallocChecked(num, 4L), num);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FloatBuffer memCallocFloat(int num) {
/*  487 */     return wrapBufferFloat(nmemCallocChecked(num, 4L), num);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LongBuffer memCallocLong(int num) {
/*  496 */     return wrapBufferLong(nmemCallocChecked(num, 8L), num);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static CLongBuffer memCallocCLong(int num) {
/*  505 */     return CLongBuffer.create(nmemCallocChecked(num, Pointer.CLONG_SIZE), num);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static DoubleBuffer memCallocDouble(int num) {
/*  514 */     return wrapBufferDouble(nmemCallocChecked(num, 8L), num);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static PointerBuffer memCallocPointer(int num) {
/*  523 */     return PointerBuffer.create(nmemCallocChecked(num, Pointer.POINTER_SIZE), num);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nmemRealloc(long ptr, long size) {
/*  530 */     return LazyInit.ALLOCATOR.realloc(ptr, size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nmemReallocChecked(long ptr, long size) {
/*  541 */     long address = nmemRealloc(ptr, (size != 0L) ? size : 1L);
/*  542 */     if (Checks.CHECKS && address == 0L) {
/*  543 */       throw new OutOfMemoryError();
/*      */     }
/*  545 */     return address;
/*      */   }
/*      */   
/*      */   private static <T extends Buffer> T realloc(T old_p, T new_p, int size) {
/*  549 */     if (old_p != null) {
/*  550 */       new_p.position(Math.min(old_p.position(), size));
/*      */     }
/*  552 */     return new_p;
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
/*      */   public static ByteBuffer memRealloc(ByteBuffer ptr, int size) {
/*  576 */     return realloc(ptr, memByteBuffer(nmemReallocChecked((ptr == null) ? 0L : UNSAFE.getLong(ptr, ADDRESS), size), size), size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ShortBuffer memRealloc(ShortBuffer ptr, int size) {
/*  585 */     return realloc(ptr, memShortBuffer(nmemReallocChecked((ptr == null) ? 0L : UNSAFE.getLong(ptr, ADDRESS), getAllocationSize(size, 1)), size), size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static IntBuffer memRealloc(IntBuffer ptr, int size) {
/*  594 */     return realloc(ptr, memIntBuffer(nmemReallocChecked((ptr == null) ? 0L : UNSAFE.getLong(ptr, ADDRESS), getAllocationSize(size, 2)), size), size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static LongBuffer memRealloc(LongBuffer ptr, int size) {
/*  603 */     return realloc(ptr, memLongBuffer(nmemReallocChecked((ptr == null) ? 0L : UNSAFE.getLong(ptr, ADDRESS), getAllocationSize(size, 3)), size), size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static CLongBuffer memRealloc(CLongBuffer ptr, int size) {
/*  612 */     CLongBuffer buffer = memCLongBuffer(nmemReallocChecked((ptr == null) ? 0L : ptr.address, getAllocationSize(size, Pointer.CLONG_SIZE)), size);
/*  613 */     if (ptr != null) {
/*  614 */       buffer.position(Math.min(ptr.position(), size));
/*      */     }
/*  616 */     return buffer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FloatBuffer memRealloc(FloatBuffer ptr, int size) {
/*  625 */     return realloc(ptr, memFloatBuffer(nmemReallocChecked((ptr == null) ? 0L : UNSAFE.getLong(ptr, ADDRESS), getAllocationSize(size, 2)), size), size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static DoubleBuffer memRealloc(DoubleBuffer ptr, int size) {
/*  634 */     return realloc(ptr, memDoubleBuffer(nmemReallocChecked((ptr == null) ? 0L : UNSAFE.getLong(ptr, ADDRESS), getAllocationSize(size, 3)), size), size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static PointerBuffer memRealloc(PointerBuffer ptr, int size) {
/*  643 */     PointerBuffer buffer = memPointerBuffer(nmemReallocChecked((ptr == null) ? 0L : ptr.address, getAllocationSize(size, Pointer.POINTER_SHIFT)), size);
/*  644 */     if (ptr != null) {
/*  645 */       buffer.position(Math.min(ptr.position(), size));
/*      */     }
/*  647 */     return buffer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nmemAlignedAlloc(long alignment, long size) {
/*  654 */     return LazyInit.ALLOCATOR.aligned_alloc(alignment, size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nmemAlignedAllocChecked(long alignment, long size) {
/*  665 */     long address = nmemAlignedAlloc(alignment, (size != 0L) ? size : 1L);
/*  666 */     if (Checks.CHECKS && address == 0L) {
/*  667 */       throw new OutOfMemoryError();
/*      */     }
/*  669 */     return address;
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
/*      */   public static ByteBuffer memAlignedAlloc(int alignment, int size) {
/*  682 */     return wrapBufferByte(nmemAlignedAllocChecked(alignment, size), size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nmemAlignedFree(long ptr) {
/*  689 */     LazyInit.ALLOCATOR.aligned_free(ptr);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memAlignedFree(ByteBuffer ptr) {
/*  698 */     if (ptr != null) {
/*  699 */       nmemAlignedFree(UNSAFE.getLong(ptr, ADDRESS));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static interface MemoryAllocationReport
/*      */   {
/*      */     void invoke(long param1Long1, long param1Long2, long param1Long3, String param1String, StackTraceElement... param1VarArgs);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public enum Aggregate
/*      */     {
/*  722 */       ALL,
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  727 */       GROUP_BY_METHOD,
/*      */       
/*  729 */       GROUP_BY_STACKTRACE; } } public enum Aggregate { ALL, GROUP_BY_METHOD, GROUP_BY_STACKTRACE; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memReport(MemoryAllocationReport report) {
/*  741 */     MemoryManage.DebugAllocator.report(report);
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
/*      */   public static void memReport(MemoryAllocationReport report, MemoryAllocationReport.Aggregate groupByStackTrace, boolean groupByThread) {
/*  754 */     MemoryManage.DebugAllocator.report(report, groupByStackTrace, groupByThread);
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
/*      */   public static long memAddress0(Buffer buffer) {
/*  772 */     return UNSAFE.getLong(buffer, ADDRESS);
/*      */   } public static long memAddress0(ByteBuffer buffer) {
/*  774 */     return UNSAFE.getLong(buffer, ADDRESS);
/*      */   } public static long memAddress0(ShortBuffer buffer) {
/*  776 */     return UNSAFE.getLong(buffer, ADDRESS);
/*      */   } public static long memAddress0(CharBuffer buffer) {
/*  778 */     return UNSAFE.getLong(buffer, ADDRESS);
/*      */   } public static long memAddress0(IntBuffer buffer) {
/*  780 */     return UNSAFE.getLong(buffer, ADDRESS);
/*      */   } public static long memAddress0(LongBuffer buffer) {
/*  782 */     return UNSAFE.getLong(buffer, ADDRESS);
/*      */   } public static long memAddress0(FloatBuffer buffer) {
/*  784 */     return UNSAFE.getLong(buffer, ADDRESS);
/*      */   } public static long memAddress0(DoubleBuffer buffer) {
/*  786 */     return UNSAFE.getLong(buffer, ADDRESS);
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
/*      */   public static long memAddress(ByteBuffer buffer) {
/*  798 */     return buffer.position() + memAddress0(buffer);
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
/*      */   public static long memAddress(ByteBuffer buffer, int position) {
/*  811 */     Objects.requireNonNull(buffer);
/*  812 */     return memAddress0(buffer) + Integer.toUnsignedLong(position);
/*      */   }
/*      */   
/*      */   private static long address(int position, int elementShift, long address) {
/*  816 */     return address + ((position & 0xFFFFFFFFL) << elementShift);
/*      */   }
/*      */   
/*      */   public static long memAddress(ShortBuffer buffer) {
/*  820 */     return address(buffer.position(), 1, memAddress0(buffer));
/*      */   }
/*      */   public static long memAddress(ShortBuffer buffer, int position) {
/*  823 */     Objects.requireNonNull(buffer);
/*  824 */     return address(position, 1, memAddress0(buffer));
/*      */   }
/*      */   
/*      */   public static long memAddress(CharBuffer buffer) {
/*  828 */     return address(buffer.position(), 1, memAddress0(buffer));
/*      */   }
/*      */   public static long memAddress(CharBuffer buffer, int position) {
/*  831 */     Objects.requireNonNull(buffer);
/*  832 */     return address(position, 1, memAddress0(buffer));
/*      */   }
/*      */   
/*      */   public static long memAddress(IntBuffer buffer) {
/*  836 */     return address(buffer.position(), 2, memAddress0(buffer));
/*      */   }
/*      */   public static long memAddress(IntBuffer buffer, int position) {
/*  839 */     Objects.requireNonNull(buffer);
/*  840 */     return address(position, 2, memAddress0(buffer));
/*      */   }
/*      */   
/*      */   public static long memAddress(FloatBuffer buffer) {
/*  844 */     return address(buffer.position(), 2, memAddress0(buffer));
/*      */   }
/*      */   public static long memAddress(FloatBuffer buffer, int position) {
/*  847 */     Objects.requireNonNull(buffer);
/*  848 */     return address(position, 2, memAddress0(buffer));
/*      */   }
/*      */   
/*      */   public static long memAddress(LongBuffer buffer) {
/*  852 */     return address(buffer.position(), 3, memAddress0(buffer));
/*      */   }
/*      */   public static long memAddress(LongBuffer buffer, int position) {
/*  855 */     Objects.requireNonNull(buffer);
/*  856 */     return address(position, 3, memAddress0(buffer));
/*      */   }
/*      */   
/*      */   public static long memAddress(DoubleBuffer buffer) {
/*  860 */     return address(buffer.position(), 3, memAddress0(buffer));
/*      */   }
/*      */   public static long memAddress(DoubleBuffer buffer, int position) {
/*  863 */     Objects.requireNonNull(buffer);
/*  864 */     return address(position, 3, memAddress0(buffer));
/*      */   }
/*      */ 
/*      */   
/*      */   public static long memAddress(Buffer buffer) {
/*      */     int elementShift;
/*  870 */     if (buffer instanceof ByteBuffer) {
/*  871 */       elementShift = 0;
/*  872 */     } else if (buffer instanceof ShortBuffer || buffer instanceof CharBuffer) {
/*  873 */       elementShift = 1;
/*  874 */     } else if (buffer instanceof IntBuffer || buffer instanceof FloatBuffer) {
/*  875 */       elementShift = 2;
/*      */     } else {
/*  877 */       elementShift = 3;
/*      */     } 
/*  879 */     return address(buffer.position(), elementShift, UNSAFE.getLong(buffer, ADDRESS));
/*      */   }
/*      */   
/*      */   public static long memAddress(CustomBuffer<?> buffer) {
/*  883 */     return buffer.address();
/*      */   } public static long memAddress(CustomBuffer<?> buffer, int position) {
/*  885 */     return buffer.address(position);
/*      */   }
/*      */ 
/*      */   
/*      */   public static long memAddressSafe(ByteBuffer buffer) {
/*  890 */     return (buffer == null) ? 0L : (memAddress0(buffer) + buffer.position());
/*      */   }
/*      */   public static long memAddressSafe(ShortBuffer buffer) {
/*  893 */     return (buffer == null) ? 0L : address(buffer.position(), 1, memAddress0(buffer));
/*      */   }
/*      */   public static long memAddressSafe(CharBuffer buffer) {
/*  896 */     return (buffer == null) ? 0L : address(buffer.position(), 1, memAddress0(buffer));
/*      */   }
/*      */   public static long memAddressSafe(IntBuffer buffer) {
/*  899 */     return (buffer == null) ? 0L : address(buffer.position(), 2, memAddress0(buffer));
/*      */   }
/*      */   public static long memAddressSafe(FloatBuffer buffer) {
/*  902 */     return (buffer == null) ? 0L : address(buffer.position(), 2, memAddress0(buffer));
/*      */   }
/*      */   public static long memAddressSafe(LongBuffer buffer) {
/*  905 */     return (buffer == null) ? 0L : address(buffer.position(), 3, memAddress0(buffer));
/*      */   }
/*      */   public static long memAddressSafe(DoubleBuffer buffer) {
/*  908 */     return (buffer == null) ? 0L : address(buffer.position(), 3, memAddress0(buffer));
/*      */   }
/*      */   public static long memAddressSafe(Pointer pointer) {
/*  911 */     return (pointer == null) ? 0L : pointer.address();
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
/*      */   public static ByteBuffer memByteBuffer(long address, int capacity) {
/*  925 */     if (Checks.CHECKS) {
/*  926 */       Checks.check(address);
/*      */     }
/*  928 */     return wrapBufferByte(address, capacity);
/*      */   }
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferSafe(long address, int capacity) {
/*  933 */     return (address == 0L) ? null : wrapBufferByte(address, capacity);
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
/*      */   public static ByteBuffer memByteBuffer(ShortBuffer buffer) {
/*  947 */     if (Checks.CHECKS && 1073741823 < buffer.remaining()) {
/*  948 */       throw new IllegalStateException("The source buffer range is too wide");
/*      */     }
/*  950 */     return wrapBufferByte(memAddress(buffer), buffer.remaining() << 1);
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
/*      */   public static ByteBuffer memByteBuffer(CharBuffer buffer) {
/*  964 */     if (Checks.CHECKS && 1073741823 < buffer.remaining()) {
/*  965 */       throw new IllegalStateException("The source buffer range is too wide");
/*      */     }
/*  967 */     return wrapBufferByte(memAddress(buffer), buffer.remaining() << 1);
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
/*      */   public static ByteBuffer memByteBuffer(IntBuffer buffer) {
/*  981 */     if (Checks.CHECKS && 536870911 < buffer.remaining()) {
/*  982 */       throw new IllegalStateException("The source buffer range is too wide");
/*      */     }
/*  984 */     return wrapBufferByte(memAddress(buffer), buffer.remaining() << 2);
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
/*      */   public static ByteBuffer memByteBuffer(LongBuffer buffer) {
/*  998 */     if (Checks.CHECKS && 268435455 < buffer.remaining()) {
/*  999 */       throw new IllegalStateException("The source buffer range is too wide");
/*      */     }
/* 1001 */     return wrapBufferByte(memAddress(buffer), buffer.remaining() << 3);
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
/*      */   public static ByteBuffer memByteBuffer(FloatBuffer buffer) {
/* 1015 */     if (Checks.CHECKS && 536870911 < buffer.remaining()) {
/* 1016 */       throw new IllegalStateException("The source buffer range is too wide");
/*      */     }
/* 1018 */     return wrapBufferByte(memAddress(buffer), buffer.remaining() << 2);
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
/*      */   public static ByteBuffer memByteBuffer(DoubleBuffer buffer) {
/* 1032 */     if (Checks.CHECKS && 268435455 < buffer.remaining()) {
/* 1033 */       throw new IllegalStateException("The source buffer range is too wide");
/*      */     }
/* 1035 */     return wrapBufferByte(memAddress(buffer), buffer.remaining() << 3);
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
/*      */   public static ByteBuffer memByteBuffer(CustomBuffer<?> buffer) {
/* 1048 */     if (Checks.CHECKS && Integer.MAX_VALUE / buffer.sizeof() < buffer.remaining()) {
/* 1049 */       throw new IllegalStateException("The source buffer range is too wide");
/*      */     }
/* 1051 */     return wrapBufferByte(memAddress(buffer), buffer.remaining() * buffer.sizeof());
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
/*      */   public static <T extends Struct<T>> ByteBuffer memByteBuffer(T value) {
/* 1064 */     return wrapBufferByte(((Struct)value).address, value.sizeof());
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
/*      */   public static ShortBuffer memShortBuffer(long address, int capacity) {
/* 1078 */     if (Checks.CHECKS) {
/* 1079 */       Checks.check(address);
/*      */     }
/* 1081 */     return wrapBufferShort(address, capacity);
/*      */   }
/*      */ 
/*      */   
/*      */   public static ShortBuffer memShortBufferSafe(long address, int capacity) {
/* 1086 */     return (address == 0L) ? null : wrapBufferShort(address, capacity);
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
/*      */   public static CharBuffer memCharBuffer(long address, int capacity) {
/* 1100 */     if (Checks.CHECKS) {
/* 1101 */       Checks.check(address);
/*      */     }
/* 1103 */     return wrapBufferChar(address, capacity);
/*      */   }
/*      */ 
/*      */   
/*      */   public static CharBuffer memCharBufferSafe(long address, int capacity) {
/* 1108 */     return (address == 0L) ? null : wrapBufferChar(address, capacity);
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
/*      */   public static IntBuffer memIntBuffer(long address, int capacity) {
/* 1122 */     if (Checks.CHECKS) {
/* 1123 */       Checks.check(address);
/*      */     }
/* 1125 */     return wrapBufferInt(address, capacity);
/*      */   }
/*      */ 
/*      */   
/*      */   public static IntBuffer memIntBufferSafe(long address, int capacity) {
/* 1130 */     return (address == 0L) ? null : wrapBufferInt(address, capacity);
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
/*      */   public static LongBuffer memLongBuffer(long address, int capacity) {
/* 1144 */     if (Checks.CHECKS) {
/* 1145 */       Checks.check(address);
/*      */     }
/* 1147 */     return wrapBufferLong(address, capacity);
/*      */   }
/*      */ 
/*      */   
/*      */   public static LongBuffer memLongBufferSafe(long address, int capacity) {
/* 1152 */     return (address == 0L) ? null : wrapBufferLong(address, capacity);
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
/*      */   public static CLongBuffer memCLongBuffer(long address, int capacity) {
/* 1166 */     if (Checks.CHECKS) {
/* 1167 */       Checks.check(address);
/*      */     }
/* 1169 */     return CLongBuffer.create(address, capacity);
/*      */   }
/*      */ 
/*      */   
/*      */   public static CLongBuffer memCLongBufferSafe(long address, int capacity) {
/* 1174 */     return (address == 0L) ? null : CLongBuffer.create(address, capacity);
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
/*      */   public static FloatBuffer memFloatBuffer(long address, int capacity) {
/* 1188 */     if (Checks.CHECKS) {
/* 1189 */       Checks.check(address);
/*      */     }
/* 1191 */     return wrapBufferFloat(address, capacity);
/*      */   }
/*      */ 
/*      */   
/*      */   public static FloatBuffer memFloatBufferSafe(long address, int capacity) {
/* 1196 */     return (address == 0L) ? null : wrapBufferFloat(address, capacity);
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
/*      */   public static DoubleBuffer memDoubleBuffer(long address, int capacity) {
/* 1210 */     if (Checks.CHECKS) {
/* 1211 */       Checks.check(address);
/*      */     }
/* 1213 */     return wrapBufferDouble(address, capacity);
/*      */   }
/*      */ 
/*      */   
/*      */   public static DoubleBuffer memDoubleBufferSafe(long address, int capacity) {
/* 1218 */     return (address == 0L) ? null : wrapBufferDouble(address, capacity);
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
/*      */   public static PointerBuffer memPointerBuffer(long address, int capacity) {
/* 1233 */     if (Checks.CHECKS) {
/* 1234 */       Checks.check(address);
/*      */     }
/* 1236 */     return PointerBuffer.create(address, capacity);
/*      */   }
/*      */ 
/*      */   
/*      */   public static PointerBuffer memPointerBufferSafe(long address, int capacity) {
/* 1241 */     return (address == 0L) ? null : PointerBuffer.create(address, capacity);
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
/*      */   public static ByteBuffer memDuplicate(ByteBuffer buffer) {
/*      */     ByteBuffer target;
/*      */     try {
/* 1259 */       target = (ByteBuffer)UNSAFE.allocateInstance(BUFFER_BYTE);
/* 1260 */     } catch (InstantiationException e) {
/* 1261 */       throw new UnsupportedOperationException(e);
/*      */     } 
/*      */     
/* 1264 */     UNSAFE.putLong(target, ADDRESS, UNSAFE.getLong(buffer, ADDRESS));
/* 1265 */     UNSAFE.putInt(target, MARK, UNSAFE.getInt(buffer, MARK));
/* 1266 */     UNSAFE.putInt(target, POSITION, UNSAFE.getInt(buffer, POSITION));
/* 1267 */     UNSAFE.putInt(target, LIMIT, UNSAFE.getInt(buffer, LIMIT));
/* 1268 */     UNSAFE.putInt(target, CAPACITY, UNSAFE.getInt(buffer, CAPACITY));
/*      */     
/* 1270 */     Object attachment = UNSAFE.getObject(buffer, PARENT_BYTE);
/* 1271 */     UNSAFE.putObject(target, PARENT_BYTE, (attachment == null) ? buffer : attachment);
/*      */     
/* 1273 */     return target.order(buffer.order());
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
/*      */   public static ShortBuffer memDuplicate(ShortBuffer buffer) {
/* 1286 */     return duplicate(BUFFER_SHORT, buffer, PARENT_SHORT);
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
/*      */   public static CharBuffer memDuplicate(CharBuffer buffer) {
/* 1298 */     return duplicate(BUFFER_CHAR, buffer, PARENT_CHAR);
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
/*      */   public static IntBuffer memDuplicate(IntBuffer buffer) {
/* 1310 */     return duplicate(BUFFER_INT, buffer, PARENT_INT);
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
/*      */   public static LongBuffer memDuplicate(LongBuffer buffer) {
/* 1322 */     return duplicate(BUFFER_LONG, buffer, PARENT_LONG);
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
/*      */   public static FloatBuffer memDuplicate(FloatBuffer buffer) {
/* 1334 */     return duplicate(BUFFER_FLOAT, buffer, PARENT_FLOAT);
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
/*      */   public static DoubleBuffer memDuplicate(DoubleBuffer buffer) {
/* 1346 */     return duplicate(BUFFER_DOUBLE, buffer, PARENT_DOUBLE);
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
/*      */   public static ByteBuffer memSlice(ByteBuffer buffer) {
/* 1361 */     return slice(buffer, memAddress0(buffer) + buffer.position(), buffer.remaining());
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
/*      */   public static ShortBuffer memSlice(ShortBuffer buffer) {
/* 1375 */     return slice(BUFFER_SHORT, buffer, address(buffer.position(), 1, memAddress0(buffer)), buffer.remaining(), PARENT_SHORT);
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
/*      */   public static CharBuffer memSlice(CharBuffer buffer) {
/* 1389 */     return slice(BUFFER_CHAR, buffer, address(buffer.position(), 1, memAddress0(buffer)), buffer.remaining(), PARENT_CHAR);
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
/*      */   public static IntBuffer memSlice(IntBuffer buffer) {
/* 1403 */     return slice(BUFFER_INT, buffer, address(buffer.position(), 2, memAddress0(buffer)), buffer.remaining(), PARENT_INT);
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
/*      */   public static LongBuffer memSlice(LongBuffer buffer) {
/* 1417 */     return slice(BUFFER_LONG, buffer, address(buffer.position(), 3, memAddress0(buffer)), buffer.remaining(), PARENT_LONG);
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
/*      */   public static FloatBuffer memSlice(FloatBuffer buffer) {
/* 1431 */     return slice(BUFFER_FLOAT, buffer, address(buffer.position(), 2, memAddress0(buffer)), buffer.remaining(), PARENT_FLOAT);
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
/*      */   public static DoubleBuffer memSlice(DoubleBuffer buffer) {
/* 1445 */     return slice(BUFFER_DOUBLE, buffer, address(buffer.position(), 3, memAddress0(buffer)), buffer.remaining(), PARENT_DOUBLE);
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
/*      */   public static ByteBuffer memSlice(ByteBuffer buffer, int offset, int capacity) {
/* 1460 */     int position = buffer.position() + offset;
/* 1461 */     if (offset < 0 || buffer.limit() < position) {
/* 1462 */       throw new IllegalArgumentException();
/*      */     }
/* 1464 */     if (capacity < 0 || buffer.capacity() - position < capacity) {
/* 1465 */       throw new IllegalArgumentException();
/*      */     }
/* 1467 */     return slice(buffer, memAddress0(buffer) + position, capacity);
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
/*      */   public static ShortBuffer memSlice(ShortBuffer buffer, int offset, int capacity) {
/* 1482 */     int position = buffer.position() + offset;
/* 1483 */     if (offset < 0 || buffer.limit() < position) {
/* 1484 */       throw new IllegalArgumentException();
/*      */     }
/* 1486 */     if (capacity < 0 || buffer.capacity() - position < capacity) {
/* 1487 */       throw new IllegalArgumentException();
/*      */     }
/* 1489 */     return slice(BUFFER_SHORT, buffer, address(position, 1, memAddress0(buffer)), capacity, PARENT_SHORT);
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
/*      */   public static CharBuffer memSlice(CharBuffer buffer, int offset, int capacity) {
/* 1504 */     int position = buffer.position() + offset;
/* 1505 */     if (offset < 0 || buffer.limit() < position) {
/* 1506 */       throw new IllegalArgumentException();
/*      */     }
/* 1508 */     if (capacity < 0 || buffer.capacity() - position < capacity) {
/* 1509 */       throw new IllegalArgumentException();
/*      */     }
/* 1511 */     return slice(BUFFER_CHAR, buffer, address(position, 1, memAddress0(buffer)), capacity, PARENT_CHAR);
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
/*      */   public static IntBuffer memSlice(IntBuffer buffer, int offset, int capacity) {
/* 1526 */     int position = buffer.position() + offset;
/* 1527 */     if (offset < 0 || buffer.limit() < position) {
/* 1528 */       throw new IllegalArgumentException();
/*      */     }
/* 1530 */     if (capacity < 0 || buffer.capacity() - position < capacity) {
/* 1531 */       throw new IllegalArgumentException();
/*      */     }
/* 1533 */     return slice(BUFFER_INT, buffer, address(position, 2, memAddress0(buffer)), capacity, PARENT_INT);
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
/*      */   public static LongBuffer memSlice(LongBuffer buffer, int offset, int capacity) {
/* 1548 */     int position = buffer.position() + offset;
/* 1549 */     if (offset < 0 || buffer.limit() < position) {
/* 1550 */       throw new IllegalArgumentException();
/*      */     }
/* 1552 */     if (capacity < 0 || buffer.capacity() - position < capacity) {
/* 1553 */       throw new IllegalArgumentException();
/*      */     }
/* 1555 */     return slice(BUFFER_LONG, buffer, address(position, 3, memAddress0(buffer)), capacity, PARENT_LONG);
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
/*      */   public static FloatBuffer memSlice(FloatBuffer buffer, int offset, int capacity) {
/* 1570 */     int position = buffer.position() + offset;
/* 1571 */     if (offset < 0 || buffer.limit() < position) {
/* 1572 */       throw new IllegalArgumentException();
/*      */     }
/* 1574 */     if (capacity < 0 || buffer.capacity() - position < capacity) {
/* 1575 */       throw new IllegalArgumentException();
/*      */     }
/* 1577 */     return slice(BUFFER_FLOAT, buffer, address(position, 2, memAddress0(buffer)), capacity, PARENT_FLOAT);
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
/*      */   public static DoubleBuffer memSlice(DoubleBuffer buffer, int offset, int capacity) {
/* 1592 */     int position = buffer.position() + offset;
/* 1593 */     if (offset < 0 || buffer.limit() < position) {
/* 1594 */       throw new IllegalArgumentException();
/*      */     }
/* 1596 */     if (capacity < 0 || buffer.capacity() - position < capacity) {
/* 1597 */       throw new IllegalArgumentException();
/*      */     }
/* 1599 */     return slice(BUFFER_DOUBLE, buffer, address(position, 3, memAddress0(buffer)), capacity, PARENT_DOUBLE);
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
/*      */   public static <T extends CustomBuffer<T>> T memSlice(T buffer, int offset, int capacity) {
/* 1613 */     return buffer.slice(offset, capacity);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memSet(ByteBuffer ptr, int value) {
/* 1623 */     memSet(memAddress(ptr), value, ptr.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memSet(ShortBuffer ptr, int value) {
/* 1631 */     memSet(memAddress(ptr), value, APIUtil.apiGetBytes(ptr.remaining(), 1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memSet(CharBuffer ptr, int value) {
/* 1639 */     memSet(memAddress(ptr), value, APIUtil.apiGetBytes(ptr.remaining(), 1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memSet(IntBuffer ptr, int value) {
/* 1647 */     memSet(memAddress(ptr), value, APIUtil.apiGetBytes(ptr.remaining(), 2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memSet(LongBuffer ptr, int value) {
/* 1655 */     memSet(memAddress(ptr), value, APIUtil.apiGetBytes(ptr.remaining(), 3));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memSet(FloatBuffer ptr, int value) {
/* 1663 */     memSet(memAddress(ptr), value, APIUtil.apiGetBytes(ptr.remaining(), 2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memSet(DoubleBuffer ptr, int value) {
/* 1671 */     memSet(memAddress(ptr), value, APIUtil.apiGetBytes(ptr.remaining(), 3));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends CustomBuffer<T>> void memSet(T ptr, int value) {
/* 1680 */     memSet(memAddress((CustomBuffer<?>)ptr), value, Integer.toUnsignedLong(ptr.remaining()) * ptr.sizeof());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends Struct<T>> void memSet(T ptr, int value) {
/* 1689 */     memSet(((Struct)ptr).address, value, ptr.sizeof());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(ByteBuffer src, ByteBuffer dst) {
/* 1700 */     if (Checks.CHECKS) {
/* 1701 */       Checks.check(dst, src.remaining());
/*      */     }
/* 1703 */     MemoryUtilTunables.memcpy(memAddress(src), memAddress(dst), src.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(ShortBuffer src, ShortBuffer dst) {
/* 1713 */     if (Checks.CHECKS) {
/* 1714 */       Checks.check(dst, src.remaining());
/*      */     }
/* 1716 */     MemoryUtilTunables.memcpy(memAddress(src), memAddress(dst), APIUtil.apiGetBytes(src.remaining(), 1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(CharBuffer src, CharBuffer dst) {
/* 1726 */     if (Checks.CHECKS) {
/* 1727 */       Checks.check(dst, src.remaining());
/*      */     }
/* 1729 */     MemoryUtilTunables.memcpy(memAddress(src), memAddress(dst), APIUtil.apiGetBytes(src.remaining(), 1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(IntBuffer src, IntBuffer dst) {
/* 1739 */     if (Checks.CHECKS) {
/* 1740 */       Checks.check(dst, src.remaining());
/*      */     }
/* 1742 */     MemoryUtilTunables.memcpy(memAddress(src), memAddress(dst), APIUtil.apiGetBytes(src.remaining(), 2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(LongBuffer src, LongBuffer dst) {
/* 1752 */     if (Checks.CHECKS) {
/* 1753 */       Checks.check(dst, src.remaining());
/*      */     }
/* 1755 */     MemoryUtilTunables.memcpy(memAddress(src), memAddress(dst), APIUtil.apiGetBytes(src.remaining(), 3));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(FloatBuffer src, FloatBuffer dst) {
/* 1765 */     if (Checks.CHECKS) {
/* 1766 */       Checks.check(dst, src.remaining());
/*      */     }
/* 1768 */     MemoryUtilTunables.memcpy(memAddress(src), memAddress(dst), APIUtil.apiGetBytes(src.remaining(), 2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(DoubleBuffer src, DoubleBuffer dst) {
/* 1778 */     if (Checks.CHECKS) {
/* 1779 */       Checks.check(dst, src.remaining());
/*      */     }
/* 1781 */     MemoryUtilTunables.memcpy(memAddress(src), memAddress(dst), APIUtil.apiGetBytes(src.remaining(), 3));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends CustomBuffer<T>> void memCopy(T src, T dst) {
/* 1792 */     if (Checks.CHECKS) {
/* 1793 */       Checks.check((CustomBuffer<?>)dst, src.remaining());
/*      */     }
/* 1795 */     MemoryUtilTunables.memcpy(memAddress((CustomBuffer<?>)src), memAddress((CustomBuffer<?>)dst), Integer.toUnsignedLong(src.remaining()) * src.sizeof());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends Struct<T>> void memCopy(T src, T dst) {
/* 1806 */     MemoryUtilTunables.memcpy(((Struct)src).address, ((Struct)dst).address, src.sizeof());
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
/*      */   public static void memCopy(byte[] src, ByteBuffer dst) {
/* 1818 */     if (Checks.CHECKS) {
/* 1819 */       Checks.check(dst, src.length);
/*      */     }
/* 1821 */     MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(short[] src, ByteBuffer dst) {
/* 1831 */     if (Checks.CHECKS) {
/* 1832 */       Checks.check(dst, APIUtil.apiGetBytes(src.length, 1));
/*      */     }
/* 1834 */     MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(short[] src, ShortBuffer dst) {
/* 1843 */     if (Checks.CHECKS) {
/* 1844 */       Checks.check(dst, src.length);
/*      */     }
/* 1846 */     MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(int[] src, ByteBuffer dst) {
/* 1856 */     if (Checks.CHECKS) {
/* 1857 */       Checks.check(dst, APIUtil.apiGetBytes(src.length, 2));
/*      */     }
/* 1859 */     MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(int[] src, IntBuffer dst) {
/* 1868 */     if (Checks.CHECKS) {
/* 1869 */       Checks.check(dst, src.length);
/*      */     }
/* 1871 */     MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(long[] src, ByteBuffer dst) {
/* 1881 */     if (Checks.CHECKS) {
/* 1882 */       Checks.check(dst, APIUtil.apiGetBytes(src.length, 3));
/*      */     }
/* 1884 */     MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(long[] src, LongBuffer dst) {
/* 1893 */     if (Checks.CHECKS) {
/* 1894 */       Checks.check(dst, src.length);
/*      */     }
/* 1896 */     MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(float[] src, ByteBuffer dst) {
/* 1906 */     if (Checks.CHECKS) {
/* 1907 */       Checks.check(dst, APIUtil.apiGetBytes(src.length, 2));
/*      */     }
/* 1909 */     MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(float[] src, FloatBuffer dst) {
/* 1918 */     if (Checks.CHECKS) {
/* 1919 */       Checks.check(dst, src.length);
/*      */     }
/* 1921 */     MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(double[] src, ByteBuffer dst) {
/* 1931 */     if (Checks.CHECKS) {
/* 1932 */       Checks.check(dst, APIUtil.apiGetBytes(src.length, 3));
/*      */     }
/* 1934 */     MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(double[] src, DoubleBuffer dst) {
/* 1943 */     if (Checks.CHECKS) {
/* 1944 */       Checks.check(dst, src.length);
/*      */     }
/* 1946 */     MemoryUtilTunables.memcpy(src, memAddress(dst), 0, src.length);
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
/*      */   public static void memCopy(byte[] src, ByteBuffer dst, int offset, int size) {
/* 1958 */     if (Checks.CHECKS) {
/* 1959 */       Checks.check(dst, size);
/*      */     }
/* 1961 */     MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size);
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
/*      */   public static void memCopy(short[] src, ByteBuffer dst, int offset, int size) {
/* 1973 */     if (Checks.CHECKS) {
/* 1974 */       Checks.check(dst, APIUtil.apiGetBytes(size, 1));
/*      */     }
/* 1976 */     MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(short[] src, ShortBuffer dst, int offset, int size) {
/* 1987 */     if (Checks.CHECKS) {
/* 1988 */       Checks.check(dst, size);
/*      */     }
/* 1990 */     MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size);
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
/*      */   public static void memCopy(int[] src, ByteBuffer dst, int offset, int size) {
/* 2002 */     if (Checks.CHECKS) {
/* 2003 */       Checks.check(dst, APIUtil.apiGetBytes(size, 2));
/*      */     }
/* 2005 */     MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(int[] src, IntBuffer dst, int offset, int size) {
/* 2016 */     if (Checks.CHECKS) {
/* 2017 */       Checks.check(dst, size);
/*      */     }
/* 2019 */     MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size);
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
/*      */   public static void memCopy(long[] src, ByteBuffer dst, int offset, int size) {
/* 2031 */     if (Checks.CHECKS) {
/* 2032 */       Checks.check(dst, APIUtil.apiGetBytes(size, 3));
/*      */     }
/* 2034 */     MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(long[] src, LongBuffer dst, int offset, int size) {
/* 2045 */     if (Checks.CHECKS) {
/* 2046 */       Checks.check(dst, size);
/*      */     }
/* 2048 */     MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size);
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
/*      */   public static void memCopy(float[] src, ByteBuffer dst, int offset, int size) {
/* 2060 */     if (Checks.CHECKS) {
/* 2061 */       Checks.check(dst, APIUtil.apiGetBytes(size, 2));
/*      */     }
/* 2063 */     MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(float[] src, FloatBuffer dst, int offset, int size) {
/* 2074 */     if (Checks.CHECKS) {
/* 2075 */       Checks.check(dst, size);
/*      */     }
/* 2077 */     MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size);
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
/*      */   public static void memCopy(double[] src, ByteBuffer dst, int offset, int size) {
/* 2089 */     if (Checks.CHECKS) {
/* 2090 */       Checks.check(dst, APIUtil.apiGetBytes(size, 3));
/*      */     }
/* 2092 */     MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(double[] src, DoubleBuffer dst, int offset, int size) {
/* 2103 */     if (Checks.CHECKS) {
/* 2104 */       Checks.check(dst, size);
/*      */     }
/* 2106 */     MemoryUtilTunables.memcpy(src, memAddress(dst), offset, size);
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
/*      */   public static void memCopy(ByteBuffer src, byte[] dst) {
/* 2118 */     if (Checks.CHECKS) {
/* 2119 */       Checks.check(src, dst.length);
/*      */     }
/* 2121 */     MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(ByteBuffer src, short[] dst) {
/* 2131 */     if (Checks.CHECKS) {
/* 2132 */       Checks.check(src, APIUtil.apiGetBytes(dst.length, 1));
/*      */     }
/* 2134 */     MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(ShortBuffer src, short[] dst) {
/* 2143 */     if (Checks.CHECKS) {
/* 2144 */       Checks.check(src, dst.length);
/*      */     }
/* 2146 */     MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(ByteBuffer src, int[] dst) {
/* 2156 */     if (Checks.CHECKS) {
/* 2157 */       Checks.check(src, APIUtil.apiGetBytes(dst.length, 2));
/*      */     }
/* 2159 */     MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(IntBuffer src, int[] dst) {
/* 2168 */     if (Checks.CHECKS) {
/* 2169 */       Checks.check(src, dst.length);
/*      */     }
/* 2171 */     MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(ByteBuffer src, long[] dst) {
/* 2181 */     if (Checks.CHECKS) {
/* 2182 */       Checks.check(src, APIUtil.apiGetBytes(dst.length, 3));
/*      */     }
/* 2184 */     MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(LongBuffer src, long[] dst) {
/* 2193 */     if (Checks.CHECKS) {
/* 2194 */       Checks.check(src, dst.length);
/*      */     }
/* 2196 */     MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(ByteBuffer src, float[] dst) {
/* 2206 */     if (Checks.CHECKS) {
/* 2207 */       Checks.check(src, APIUtil.apiGetBytes(dst.length, 2));
/*      */     }
/* 2209 */     MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(FloatBuffer src, float[] dst) {
/* 2218 */     if (Checks.CHECKS) {
/* 2219 */       Checks.check(src, dst.length);
/*      */     }
/* 2221 */     MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(ByteBuffer src, double[] dst) {
/* 2231 */     if (Checks.CHECKS) {
/* 2232 */       Checks.check(src, APIUtil.apiGetBytes(dst.length, 3));
/*      */     }
/* 2234 */     MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(DoubleBuffer src, double[] dst) {
/* 2243 */     if (Checks.CHECKS) {
/* 2244 */       Checks.check(src, dst.length);
/*      */     }
/* 2246 */     MemoryUtilTunables.memcpy(memAddress(src), dst, 0, dst.length);
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
/*      */   public static void memCopy(ByteBuffer src, byte[] dst, int offset, int size) {
/* 2258 */     if (Checks.CHECKS) {
/* 2259 */       Checks.check(src, size);
/*      */     }
/* 2261 */     MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size);
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
/*      */   public static void memCopy(ByteBuffer src, short[] dst, int offset, int size) {
/* 2273 */     if (Checks.CHECKS) {
/* 2274 */       Checks.check(src, APIUtil.apiGetBytes(size, 1));
/*      */     }
/* 2276 */     MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(ShortBuffer src, short[] dst, int offset, int size) {
/* 2287 */     if (Checks.CHECKS) {
/* 2288 */       Checks.check(src, size);
/*      */     }
/* 2290 */     MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size);
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
/*      */   public static void memCopy(ByteBuffer src, int[] dst, int offset, int size) {
/* 2302 */     if (Checks.CHECKS) {
/* 2303 */       Checks.check(src, APIUtil.apiGetBytes(size, 2));
/*      */     }
/* 2305 */     MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(IntBuffer src, int[] dst, int offset, int size) {
/* 2316 */     if (Checks.CHECKS) {
/* 2317 */       Checks.check(src, size);
/*      */     }
/* 2319 */     MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size);
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
/*      */   public static void memCopy(ByteBuffer src, long[] dst, int offset, int size) {
/* 2331 */     if (Checks.CHECKS) {
/* 2332 */       Checks.check(src, APIUtil.apiGetBytes(size, 3));
/*      */     }
/* 2334 */     MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(LongBuffer src, long[] dst, int offset, int size) {
/* 2345 */     if (Checks.CHECKS) {
/* 2346 */       Checks.check(src, size);
/*      */     }
/* 2348 */     MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size);
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
/*      */   public static void memCopy(ByteBuffer src, float[] dst, int offset, int size) {
/* 2360 */     if (Checks.CHECKS) {
/* 2361 */       Checks.check(src, APIUtil.apiGetBytes(size, 2));
/*      */     }
/* 2363 */     MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(FloatBuffer src, float[] dst, int offset, int size) {
/* 2374 */     if (Checks.CHECKS) {
/* 2375 */       Checks.check(src, size);
/*      */     }
/* 2377 */     MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size);
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
/*      */   public static void memCopy(ByteBuffer src, double[] dst, int offset, int size) {
/* 2389 */     if (Checks.CHECKS) {
/* 2390 */       Checks.check(src, APIUtil.apiGetBytes(size, 3));
/*      */     }
/* 2392 */     MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(DoubleBuffer src, double[] dst, int offset, int size) {
/* 2403 */     if (Checks.CHECKS) {
/* 2404 */       Checks.check(src, size);
/*      */     }
/* 2406 */     MemoryUtilTunables.memcpy(memAddress(src), dst, offset, size);
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
/*      */   public static void memSet(long ptr, int value, long bytes) {
/* 2423 */     if (Checks.DEBUG && (ptr == 0L || bytes < 0L)) {
/* 2424 */       throw new IllegalArgumentException();
/*      */     }
/* 2426 */     MemoryUtilTunables.memset(ptr, value, bytes);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void memCopy(long src, long dst, long bytes) {
/* 2437 */     if (Checks.DEBUG && (src == 0L || dst == 0L || bytes < 0L)) {
/* 2438 */       throw new IllegalArgumentException();
/*      */     }
/* 2440 */     MemoryUtilTunables.memcpy(src, dst, bytes);
/*      */   }
/*      */   
/* 2443 */   public static void memCopy(byte[] src, long dst) { MemoryUtilTunables.memcpy(src, dst, 0, src.length); }
/* 2444 */   public static void memCopy(short[] src, long dst) { MemoryUtilTunables.memcpy(src, dst, 0, src.length); }
/* 2445 */   public static void memCopy(int[] src, long dst) { MemoryUtilTunables.memcpy(src, dst, 0, src.length); }
/* 2446 */   public static void memCopy(long[] src, long dst) { MemoryUtilTunables.memcpy(src, dst, 0, src.length); }
/* 2447 */   public static void memCopy(float[] src, long dst) { MemoryUtilTunables.memcpy(src, dst, 0, src.length); } public static void memCopy(double[] src, long dst) {
/* 2448 */     MemoryUtilTunables.memcpy(src, dst, 0, src.length);
/*      */   }
/* 2450 */   public static void memCopy(byte[] src, long dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); }
/* 2451 */   public static void memCopy(short[] src, long dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); }
/* 2452 */   public static void memCopy(int[] src, long dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); }
/* 2453 */   public static void memCopy(long[] src, long dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); }
/* 2454 */   public static void memCopy(float[] src, long dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); } public static void memCopy(double[] src, long dst, int offset, int size) {
/* 2455 */     MemoryUtilTunables.memcpy(src, dst, offset, size);
/*      */   }
/* 2457 */   public static void memCopy(long src, byte[] dst) { MemoryUtilTunables.memcpy(src, dst, 0, dst.length); }
/* 2458 */   public static void memCopy(long src, short[] dst) { MemoryUtilTunables.memcpy(src, dst, 0, dst.length); }
/* 2459 */   public static void memCopy(long src, int[] dst) { MemoryUtilTunables.memcpy(src, dst, 0, dst.length); }
/* 2460 */   public static void memCopy(long src, long[] dst) { MemoryUtilTunables.memcpy(src, dst, 0, dst.length); }
/* 2461 */   public static void memCopy(long src, float[] dst) { MemoryUtilTunables.memcpy(src, dst, 0, dst.length); } public static void memCopy(long src, double[] dst) {
/* 2462 */     MemoryUtilTunables.memcpy(src, dst, 0, dst.length);
/*      */   }
/* 2464 */   public static void memCopy(long src, byte[] dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); }
/* 2465 */   public static void memCopy(long src, short[] dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); }
/* 2466 */   public static void memCopy(long src, int[] dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); }
/* 2467 */   public static void memCopy(long src, long[] dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); }
/* 2468 */   public static void memCopy(long src, float[] dst, int offset, int size) { MemoryUtilTunables.memcpy(src, dst, offset, size); } public static void memCopy(long src, double[] dst, int offset, int size) {
/* 2469 */     MemoryUtilTunables.memcpy(src, dst, offset, size);
/*      */   }
/*      */   
/*      */   public static boolean memGetBoolean(long ptr) {
/* 2473 */     return (UNSAFE.getByte(null, ptr) != 0);
/* 2474 */   } public static byte memGetByte(long ptr) { return UNSAFE.getByte(null, ptr); }
/* 2475 */   public static short memGetShort(long ptr) { return UNSAFE.getShort(null, ptr); }
/* 2476 */   public static int memGetInt(long ptr) { return UNSAFE.getInt(null, ptr); }
/* 2477 */   public static long memGetLong(long ptr) { return UNSAFE.getLong(null, ptr); }
/* 2478 */   public static float memGetFloat(long ptr) { return UNSAFE.getFloat(null, ptr); } public static double memGetDouble(long ptr) {
/* 2479 */     return UNSAFE.getDouble(null, ptr);
/*      */   } public static long memGetCLong(long ptr) {
/* 2481 */     return (Pointer.CLONG_SIZE == 8) ? UNSAFE
/* 2482 */       .getLong(null, ptr) : UNSAFE
/* 2483 */       .getInt(null, ptr);
/*      */   }
/*      */   
/*      */   public static long memGetAddress(long ptr) {
/* 2487 */     return Pointer.BITS64 ? UNSAFE
/* 2488 */       .getLong(null, ptr) : (UNSAFE
/* 2489 */       .getInt(null, ptr) & 0xFFFFFFFFL);
/*      */   }
/*      */   
/* 2492 */   public static void memPutByte(long ptr, byte value) { UNSAFE.putByte(null, ptr, value); }
/* 2493 */   public static void memPutShort(long ptr, short value) { UNSAFE.putShort(null, ptr, value); }
/* 2494 */   public static void memPutInt(long ptr, int value) { UNSAFE.putInt(null, ptr, value); }
/* 2495 */   public static void memPutLong(long ptr, long value) { UNSAFE.putLong(null, ptr, value); }
/* 2496 */   public static void memPutFloat(long ptr, float value) { UNSAFE.putFloat(null, ptr, value); } public static void memPutDouble(long ptr, double value) {
/* 2497 */     UNSAFE.putDouble(null, ptr, value);
/*      */   } public static void memPutCLong(long ptr, long value) {
/* 2499 */     if (Pointer.CLONG_SIZE == 8) {
/* 2500 */       UNSAFE.putLong(null, ptr, value);
/*      */     } else {
/* 2502 */       UNSAFE.putInt(null, ptr, (int)value);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void memPutAddress(long ptr, long value) {
/* 2507 */     if (Pointer.BITS64) {
/* 2508 */       UNSAFE.putLong(null, ptr, value);
/*      */     } else {
/* 2510 */       UNSAFE.putInt(null, ptr, (int)value);
/*      */     } 
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
/*      */   
/*      */   private static int write8(long target, int offset, int value) {
/* 2537 */     UNSAFE.putByte(null, target + Integer.toUnsignedLong(offset), (byte)value);
/* 2538 */     return offset + 1;
/*      */   }
/*      */   private static int write8Safe(long target, int offset, int maxLength, int value) {
/* 2541 */     if (offset == maxLength) {
/* 2542 */       throw new BufferOverflowException();
/*      */     }
/* 2544 */     UNSAFE.putByte(null, target + Integer.toUnsignedLong(offset), (byte)value);
/* 2545 */     return offset + 1;
/*      */   }
/*      */   private static int write16(long target, int offset, char value) {
/* 2548 */     UNSAFE.putShort(null, target + Integer.toUnsignedLong(offset), (short)value);
/* 2549 */     return offset + 2;
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
/* 2562 */     return memASCII(text, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public static ByteBuffer memASCIISafe(CharSequence text) {
/* 2567 */     return (text == null) ? null : memASCII(text, true);
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
/* 2581 */     int length = memLengthASCII(text, nullTerminated);
/* 2582 */     long target = nmemAlloc(length);
/* 2583 */     if (Checks.CHECKS && target == 0L) {
/* 2584 */       throw new OutOfMemoryError();
/*      */     }
/* 2586 */     encodeASCIIUnsafe(text, nullTerminated, target);
/* 2587 */     return wrapBufferByte(target, length);
/*      */   }
/*      */ 
/*      */   
/*      */   public static ByteBuffer memASCIISafe(CharSequence text, boolean nullTerminated) {
/* 2592 */     return (text == null) ? null : memASCII(text, nullTerminated);
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
/* 2608 */     if (target.remaining() < memLengthASCII(text, nullTerminated)) {
/* 2609 */       throw new BufferOverflowException();
/*      */     }
/* 2611 */     long address = memAddress(target);
/* 2612 */     return encodeASCIIUnsafe(text, nullTerminated, address);
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
/* 2628 */     if (target.capacity() - offset < memLengthASCII(text, nullTerminated)) {
/* 2629 */       throw new BufferOverflowException();
/*      */     }
/* 2631 */     return encodeASCIIUnsafe(text, nullTerminated, memAddress(target, offset));
/*      */   }
/*      */   
/*      */   static int encodeASCIIUnsafe(CharSequence text, boolean nullTerminated, long target) {
/* 2635 */     int i = 0, len = text.length();
/*      */     
/* 2637 */     while (i < len) {
/* 2638 */       i = write8(target, i, text.charAt(i));
/*      */     }
/*      */     
/* 2641 */     if (nullTerminated) {
/* 2642 */       i = write8(target, i, 0);
/*      */     }
/*      */     
/* 2645 */     return i;
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
/* 2659 */     int len = value.length() + (nullTerminated ? 1 : 0);
/* 2660 */     if (len < 0) {
/* 2661 */       throw new BufferOverflowException();
/*      */     }
/* 2663 */     return len;
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
/* 2676 */     return memUTF8(text, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF8Safe(CharSequence text) {
/* 2681 */     return (text == null) ? null : memUTF8(text, true);
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
/* 2695 */     int length = memLengthUTF8(text, nullTerminated);
/* 2696 */     long target = nmemAlloc(length);
/* 2697 */     if (Checks.CHECKS && target == 0L) {
/* 2698 */       throw new OutOfMemoryError();
/*      */     }
/* 2700 */     encodeUTF8Unsafe(text, nullTerminated, target);
/* 2701 */     return wrapBufferByte(target, length);
/*      */   }
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF8Safe(CharSequence text, boolean nullTerminated) {
/* 2706 */     return (text == null) ? null : memUTF8(text, nullTerminated);
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
/* 2722 */     if (target.remaining() < memLengthASCII(text, nullTerminated)) {
/* 2723 */       throw new BufferOverflowException();
/*      */     }
/* 2725 */     return encodeUTF8Safe(text, nullTerminated, memAddress(target), target.remaining());
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
/* 2742 */     if (target.capacity() - offset < memLengthASCII(text, nullTerminated)) {
/* 2743 */       throw new BufferOverflowException();
/*      */     }
/* 2745 */     return encodeUTF8Safe(text, nullTerminated, memAddress(target, offset), target.capacity() - offset);
/*      */   }
/*      */   
/*      */   static int encodeUTF8Unsafe(CharSequence text, boolean nullTerminated, long target) {
/* 2749 */     int p = 0, i = 0, len = text.length();
/*      */     
/* 2751 */     while (i < len) {
/* 2752 */       char c = text.charAt(i++);
/* 2753 */       if (c < '') {
/* 2754 */         p = write8(target, p, c); continue;
/*      */       } 
/* 2756 */       int cp = c;
/* 2757 */       if (c < 'ࠀ') {
/* 2758 */         p = write8(target, p, 0xC0 | cp >> 6);
/*      */       } else {
/* 2760 */         if (!Character.isHighSurrogate(c)) {
/* 2761 */           p = write8(target, p, 0xE0 | cp >> 12);
/*      */         } else {
/* 2763 */           cp = Character.toCodePoint(c, text.charAt(i++));
/*      */           
/* 2765 */           p = write8(target, p, 0xF0 | cp >> 18);
/* 2766 */           p = write8(target, p, 0x80 | cp >> 12 & 0x3F);
/*      */         } 
/* 2768 */         p = write8(target, p, 0x80 | cp >> 6 & 0x3F);
/*      */       } 
/* 2770 */       p = write8(target, p, 0x80 | cp & 0x3F);
/*      */     } 
/*      */ 
/*      */     
/* 2774 */     if (nullTerminated) {
/* 2775 */       p = write8(target, p, 0);
/*      */     }
/*      */     
/* 2778 */     return p;
/*      */   }
/*      */   
/*      */   static int encodeUTF8Safe(CharSequence text, boolean nullTerminated, long target, int maxLength) {
/* 2782 */     int p = 0, i = 0, length = text.length();
/*      */ 
/*      */     
/* 2785 */     while (i < length) {
/* 2786 */       char c = text.charAt(i);
/* 2787 */       if ('' <= c) {
/*      */         break;
/*      */       }
/* 2790 */       p = write8(target, p, c);
/* 2791 */       i++;
/*      */     } 
/*      */ 
/*      */     
/* 2795 */     while (i < length) {
/* 2796 */       char c = text.charAt(i++);
/* 2797 */       if (c < '') {
/* 2798 */         p = write8Safe(target, p, maxLength, c); continue;
/*      */       } 
/* 2800 */       int cp = c;
/* 2801 */       if (c < 'ࠀ') {
/* 2802 */         p = write8Safe(target, p, maxLength, 0xC0 | cp >> 6);
/*      */       } else {
/* 2804 */         if (!Character.isHighSurrogate(c)) {
/* 2805 */           p = write8Safe(target, p, maxLength, 0xE0 | cp >> 12);
/*      */         } else {
/* 2807 */           cp = Character.toCodePoint(c, text.charAt(i++));
/*      */           
/* 2809 */           p = write8Safe(target, p, maxLength, 0xF0 | cp >> 18);
/* 2810 */           p = write8Safe(target, p, maxLength, 0x80 | cp >> 12 & 0x3F);
/*      */         } 
/* 2812 */         p = write8Safe(target, p, maxLength, 0x80 | cp >> 6 & 0x3F);
/*      */       } 
/* 2814 */       p = write8Safe(target, p, maxLength, 0x80 | cp & 0x3F);
/*      */     } 
/*      */ 
/*      */     
/* 2818 */     if (nullTerminated) {
/* 2819 */       p = write8Safe(target, p, maxLength, 0);
/*      */     }
/*      */     
/* 2822 */     return p;
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
/* 2836 */     int len = value.length();
/* 2837 */     int bytes = len + (nullTerminated ? 1 : 0);
/*      */     
/* 2839 */     for (int i = 0; i < len; i++) {
/* 2840 */       char c = value.charAt(i);
/*      */       
/* 2842 */       if (c >= '') {
/*      */ 
/*      */         
/* 2845 */         if (c < 'ࠀ') {
/*      */ 
/*      */           
/* 2848 */           bytes += 127 - c >>> 31;
/*      */         }
/*      */         else {
/*      */           
/* 2852 */           bytes += 2;
/* 2853 */           if (Character.isHighSurrogate(c)) {
/* 2854 */             i++;
/*      */           }
/*      */         } 
/* 2857 */         if (bytes < 0) {
/* 2858 */           throw new BufferOverflowException();
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2863 */     if (bytes < 0) {
/* 2864 */       throw new BufferOverflowException();
/*      */     }
/*      */     
/* 2867 */     return bytes;
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
/* 2880 */     return memUTF16(text, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF16Safe(CharSequence text) {
/* 2885 */     return (text == null) ? null : memUTF16(text, true);
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
/* 2899 */     int length = memLengthUTF16(text, nullTerminated);
/* 2900 */     long target = nmemAlloc(length);
/* 2901 */     if (Checks.CHECKS && target == 0L) {
/* 2902 */       throw new OutOfMemoryError();
/*      */     }
/* 2904 */     encodeUTF16Unsafe(text, nullTerminated, target);
/* 2905 */     return wrapBufferByte(target, length);
/*      */   }
/*      */ 
/*      */   
/*      */   public static ByteBuffer memUTF16Safe(CharSequence text, boolean nullTerminated) {
/* 2910 */     return (text == null) ? null : memUTF16(text, nullTerminated);
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
/* 2927 */     if (target.remaining() < memLengthUTF16(text, nullTerminated)) {
/* 2928 */       throw new BufferOverflowException();
/*      */     }
/* 2930 */     long address = memAddress(target);
/* 2931 */     return encodeUTF16Unsafe(text, nullTerminated, address);
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
/* 2949 */     if (target.capacity() - offset < memLengthUTF16(text, nullTerminated)) {
/* 2950 */       throw new BufferOverflowException();
/*      */     }
/* 2952 */     long address = memAddress(target, offset);
/* 2953 */     return encodeUTF16Unsafe(text, nullTerminated, address);
/*      */   }
/*      */   
/*      */   static int encodeUTF16Unsafe(CharSequence text, boolean nullTerminated, long target) {
/* 2957 */     int p = 0, i = 0, len = text.length();
/*      */     
/* 2959 */     while (i < len) {
/* 2960 */       p = write16(target, p, text.charAt(i++));
/*      */     }
/*      */     
/* 2963 */     if (nullTerminated) {
/* 2964 */       p = write16(target, p, false);
/*      */     }
/*      */     
/* 2967 */     return p;
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
/* 2979 */     int len = value.length() + (nullTerminated ? 1 : 0);
/* 2980 */     if (len < 0 || 1073741823 < len) {
/* 2981 */       throw new BufferOverflowException();
/*      */     }
/* 2983 */     return len << 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int memLengthNT1(long address, int maxLength) {
/* 2993 */     if (Checks.CHECKS) {
/* 2994 */       Checks.check(address);
/*      */     }
/* 2996 */     return Pointer.BITS64 ? 
/* 2997 */       strlen64NT1(address, maxLength) : 
/* 2998 */       strlen32NT1(address, maxLength);
/*      */   }
/*      */   
/*      */   private static int strlen64NT1(long address, int maxLength) {
/* 3002 */     int i = 0;
/*      */     
/* 3004 */     if (8 <= maxLength) {
/* 3005 */       int misalignment = (int)address & 0x7;
/* 3006 */       if (misalignment != 0)
/*      */       {
/* 3008 */         for (int len = 8 - misalignment; i < len; i++) {
/* 3009 */           if (UNSAFE.getByte(null, address + i) == 0) {
/* 3010 */             return i;
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 3016 */       for (; i <= maxLength - 8 && 
/* 3017 */         !MathUtil.mathHasZeroByte(UNSAFE.getLong(null, address + i)); i += 8);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3024 */     for (; i < maxLength && 
/* 3025 */       UNSAFE.getByte(null, address + i) != 0; i++);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3030 */     return i;
/*      */   }
/*      */   
/*      */   private static int strlen32NT1(long address, int maxLength) {
/* 3034 */     int i = 0;
/*      */     
/* 3036 */     if (4 <= maxLength) {
/* 3037 */       int misalignment = (int)address & 0x3;
/* 3038 */       if (misalignment != 0)
/*      */       {
/* 3040 */         for (int len = 4 - misalignment; i < len; i++) {
/* 3041 */           if (UNSAFE.getByte(null, address + i) == 0) {
/* 3042 */             return i;
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 3048 */       for (; i <= maxLength - 4 && 
/* 3049 */         !MathUtil.mathHasZeroByte(UNSAFE.getInt(null, address + i)); i += 4);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3056 */     for (; i < maxLength && 
/* 3057 */       UNSAFE.getByte(null, address + i) != 0; i++);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3062 */     return i;
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
/* 3076 */     return memLengthNT1(memAddress(buffer), buffer.remaining());
/*      */   }
/*      */   
/*      */   private static int memLengthNT2(long address, int maxLength) {
/* 3080 */     if (Checks.CHECKS) {
/* 3081 */       Checks.check(address);
/*      */     }
/* 3083 */     return Pointer.BITS64 ? 
/* 3084 */       strlen64NT2(address, maxLength) : 
/* 3085 */       strlen32NT2((int)address, maxLength);
/*      */   }
/*      */   
/*      */   private static int strlen64NT2(long address, int maxLength) {
/* 3089 */     int i = 0;
/*      */     
/* 3091 */     if (8 <= maxLength) {
/* 3092 */       int misalignment = (int)address & 0x7;
/* 3093 */       if (misalignment != 0)
/*      */       {
/* 3095 */         for (int len = 8 - misalignment; i < len; i += 2) {
/* 3096 */           if (UNSAFE.getShort(null, address + i) == 0) {
/* 3097 */             return i;
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 3103 */       for (; i <= maxLength - 8 && 
/* 3104 */         !MathUtil.mathHasZeroShort(UNSAFE.getLong(null, address + i)); i += 8);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3111 */     for (; i < maxLength && 
/* 3112 */       UNSAFE.getShort(null, address + i) != 0; i += 2);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3117 */     return i;
/*      */   }
/*      */   
/*      */   private static int strlen32NT2(long address, int maxLength) {
/* 3121 */     int i = 0;
/*      */     
/* 3123 */     if (4 <= maxLength) {
/* 3124 */       int misalignment = (int)address & 0x3;
/* 3125 */       if (misalignment != 0)
/*      */       {
/* 3127 */         for (int len = 4 - misalignment; i < len; i += 2) {
/* 3128 */           if (UNSAFE.getShort(null, address + i) == 0) {
/* 3129 */             return i;
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 3135 */       while (i <= maxLength - 4 && 
/* 3136 */         !MathUtil.mathHasZeroShort(UNSAFE.getInt(null, address + i)))
/*      */       {
/*      */         
/* 3139 */         i += 4;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 3144 */     for (; i < maxLength && 
/* 3145 */       UNSAFE.getShort(null, address + i) != 0; i += 2);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3150 */     return i;
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
/* 3164 */     return memLengthNT2(memAddress(buffer), buffer.remaining());
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
/* 3178 */     return memByteBuffer(address, memLengthNT1(address, 2147483647));
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
/* 3193 */     return memByteBuffer(address, memLengthNT1(address, maxLength));
/*      */   }
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT1Safe(long address) {
/* 3198 */     return (address == 0L) ? null : memByteBuffer(address, memLengthNT1(address, 2147483647));
/*      */   }
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT1Safe(long address, int maxLength) {
/* 3203 */     return (address == 0L) ? null : memByteBuffer(address, memLengthNT1(address, maxLength));
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
/* 3217 */     return memByteBufferNT2(address, 2147483646);
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
/* 3231 */     if (Checks.DEBUG && (
/* 3232 */       maxLength & 0x1) != 0) {
/* 3233 */       throw new IllegalArgumentException("The maximum length must be an even number.");
/*      */     }
/*      */     
/* 3236 */     return memByteBuffer(address, memLengthNT2(address, maxLength));
/*      */   }
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT2Safe(long address) {
/* 3241 */     return (address == 0L) ? null : memByteBufferNT2(address, 2147483646);
/*      */   }
/*      */ 
/*      */   
/*      */   public static ByteBuffer memByteBufferNT2Safe(long address, int maxLength) {
/* 3246 */     return (address == 0L) ? null : memByteBufferNT2(address, maxLength);
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
/* 3257 */     return memASCII(address, memLengthNT1(address, 2147483647));
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
/* 3270 */     if (length <= 0) {
/* 3271 */       return "";
/*      */     }
/*      */     
/* 3274 */     byte[] ascii = (length <= ARRAY_TLC_SIZE) ? ARRAY_TLC_BYTE.get() : new byte[length];
/* 3275 */     memByteBuffer(address, length).get(ascii, 0, length);
/* 3276 */     return new String(ascii, 0, 0, length);
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
/* 3289 */     return memASCII(memAddress(buffer), buffer.remaining());
/*      */   }
/*      */ 
/*      */   
/*      */   public static String memASCIISafe(long address) {
/* 3294 */     return (address == 0L) ? null : memASCII(address, memLengthNT1(address, 2147483647));
/*      */   }
/*      */ 
/*      */   
/*      */   public static String memASCIISafe(long address, int length) {
/* 3299 */     return (address == 0L) ? null : memASCII(address, length);
/*      */   }
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
/* 3344 */     return MultiReleaseTextDecoding.decodeUTF8(address, memLengthNT1(address, 2147483647));
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
/*      */   public static String memUTF8Safe(long address) {
/* 3374 */     return (address == 0L) ? null : MultiReleaseTextDecoding.decodeUTF8(address, memLengthNT1(address, 2147483647));
/*      */   }
/*      */ 
/*      */   
/*      */   public static String memUTF8Safe(long address, int length) {
/* 3379 */     return (address == 0L) ? null : MultiReleaseTextDecoding.decodeUTF8(address, length);
/*      */   }
/*      */ 
/*      */   
/*      */   public static String memUTF8Safe(ByteBuffer buffer) {
/* 3384 */     return (buffer == null) ? null : MultiReleaseTextDecoding.decodeUTF8(memAddress(buffer), buffer.remaining());
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
/* 3398 */     return MultiReleaseTextDecoding.decodeUTF8(memAddress(buffer), length);
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
/* 3413 */     return MultiReleaseTextDecoding.decodeUTF8(memAddress(buffer, offset), length);
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
/* 3424 */     return memUTF16(address, memLengthNT2(address, 2147483646) >> 1);
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
/* 3436 */     if (length <= 0) {
/* 3437 */       return "";
/*      */     }
/*      */     
/* 3440 */     if (Checks.DEBUG) {
/*      */       
/* 3442 */       int len = length << 1;
/* 3443 */       byte[] bytes = (len <= ARRAY_TLC_SIZE) ? ARRAY_TLC_BYTE.get() : new byte[len];
/* 3444 */       memByteBuffer(address, len).get(bytes, 0, len);
/* 3445 */       return new String(bytes, 0, len, UTF16);
/*      */     } 
/*      */     
/* 3448 */     char[] chars = (length <= ARRAY_TLC_SIZE) ? ARRAY_TLC_CHAR.get() : new char[length];
/* 3449 */     memCharBuffer(address, length).get(chars, 0, length);
/* 3450 */     return new String(chars, 0, length);
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
/* 3463 */     return memUTF16(memAddress(buffer), buffer.remaining() >> 1);
/*      */   }
/*      */ 
/*      */   
/*      */   public static String memUTF16Safe(long address) {
/* 3468 */     return (address == 0L) ? null : memUTF16(address, memLengthNT2(address, 2147483646) >> 1);
/*      */   }
/*      */ 
/*      */   
/*      */   public static String memUTF16Safe(long address, int length) {
/* 3473 */     return (address == 0L) ? null : memUTF16(address, length);
/*      */   }
/*      */ 
/*      */   
/*      */   public static String memUTF16Safe(ByteBuffer buffer) {
/* 3478 */     return (buffer == null) ? null : memUTF16(memAddress(buffer), buffer.remaining() >> 1);
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
/* 3492 */     return memUTF16(memAddress(buffer), length);
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
/* 3507 */     return memUTF16(memAddress(buffer, offset), length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Unsafe getUnsafeInstance() {
/* 3515 */     Field[] fields = Unsafe.class.getDeclaredFields();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3525 */     for (Field field : fields) {
/* 3526 */       if (field.getType().equals(Unsafe.class)) {
/*      */ 
/*      */ 
/*      */         
/* 3530 */         int modifiers = field.getModifiers();
/* 3531 */         if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers))
/*      */           
/*      */           try {
/*      */ 
/*      */             
/* 3536 */             field.setAccessible(true);
/* 3537 */             return (Unsafe)field.get(null);
/* 3538 */           } catch (Exception exception) {
/*      */             break;
/*      */           }  
/*      */       } 
/*      */     } 
/* 3543 */     throw new UnsupportedOperationException("LWJGL requires sun.misc.Unsafe to be available.");
/*      */   }
/*      */   
/*      */   private static long getFieldOffset(Class<?> containerType, Class<?> fieldType, LongPredicate predicate) {
/* 3547 */     Class<?> c = containerType;
/* 3548 */     while (c != Object.class) {
/* 3549 */       Field[] fields = c.getDeclaredFields();
/* 3550 */       for (Field field : fields) {
/* 3551 */         if (field.getType().isAssignableFrom(fieldType) && !Modifier.isStatic(field.getModifiers()) && !field.isSynthetic()) {
/*      */ 
/*      */ 
/*      */           
/* 3555 */           long offset = UNSAFE.objectFieldOffset(field);
/* 3556 */           if (predicate.test(offset))
/* 3557 */             return offset; 
/*      */         } 
/*      */       } 
/* 3560 */       c = c.getSuperclass();
/*      */     } 
/* 3562 */     throw new UnsupportedOperationException("Failed to find field offset in class.");
/*      */   }
/*      */   
/*      */   private static long getFieldOffsetInt(Object container, int value) {
/* 3566 */     return getFieldOffset(container.getClass(), int.class, offset -> (UNSAFE.getInt(container, offset) == value));
/*      */   }
/*      */   
/*      */   private static long getFieldOffsetObject(Object container, Object value) {
/* 3570 */     return getFieldOffset(container.getClass(), value.getClass(), offset -> (UNSAFE.getObject(container, offset) == value));
/*      */   }
/*      */   
/*      */   private static long getAddressOffset() {
/* 3574 */     long MAGIC_ADDRESS = 0xDEADBEEF8BADF00DL & (Pointer.BITS32 ? 4294967295L : -1L);
/*      */     
/* 3576 */     ByteBuffer bb = Objects.<ByteBuffer>requireNonNull(JNINativeInterface.NewDirectByteBuffer(MAGIC_ADDRESS, 0L));
/*      */     
/* 3578 */     return getFieldOffset(bb.getClass(), long.class, offset -> (UNSAFE.getLong(bb, offset) == MAGIC_ADDRESS));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static long getMarkOffset() {
/* 3585 */     ByteBuffer bb = Objects.<ByteBuffer>requireNonNull(JNINativeInterface.NewDirectByteBuffer(1L, 0L));
/* 3586 */     return getFieldOffsetInt(bb, -1);
/*      */   }
/*      */   
/*      */   private static long getPositionOffset() {
/* 3590 */     ByteBuffer bb = Objects.<ByteBuffer>requireNonNull(JNINativeInterface.NewDirectByteBuffer(-1L, 219540062L));
/* 3591 */     bb.position(16435934);
/* 3592 */     return getFieldOffsetInt(bb, 16435934);
/*      */   }
/*      */   
/*      */   private static long getLimitOffset() {
/* 3596 */     ByteBuffer bb = Objects.<ByteBuffer>requireNonNull(JNINativeInterface.NewDirectByteBuffer(-1L, 219540062L));
/* 3597 */     bb.limit(16435934);
/* 3598 */     return getFieldOffsetInt(bb, 16435934);
/*      */   }
/*      */   
/*      */   private static long getCapacityOffset() {
/* 3602 */     ByteBuffer bb = Objects.<ByteBuffer>requireNonNull(JNINativeInterface.NewDirectByteBuffer(-1L, 219540062L));
/* 3603 */     bb.limit(0);
/* 3604 */     return getFieldOffsetInt(bb, 219540062);
/*      */   }
/*      */   
/*      */   static ByteBuffer wrapBufferByte(long address, int capacity) {
/*      */     ByteBuffer buffer;
/*      */     try {
/* 3610 */       buffer = (ByteBuffer)UNSAFE.allocateInstance(BUFFER_BYTE);
/* 3611 */     } catch (InstantiationException e) {
/* 3612 */       throw new UnsupportedOperationException(e);
/*      */     } 
/*      */     
/* 3615 */     UNSAFE.putLong(buffer, ADDRESS, address);
/* 3616 */     UNSAFE.putInt(buffer, MARK, -1);
/* 3617 */     UNSAFE.putInt(buffer, LIMIT, capacity);
/* 3618 */     UNSAFE.putInt(buffer, CAPACITY, capacity);
/*      */     
/* 3620 */     return buffer.order(NATIVE_ORDER);
/*      */   }
/*      */   
/*      */   static ShortBuffer wrapBufferShort(long address, int capacity) {
/*      */     ShortBuffer buffer;
/*      */     try {
/* 3626 */       buffer = (ShortBuffer)UNSAFE.allocateInstance(BUFFER_SHORT);
/* 3627 */     } catch (InstantiationException e) {
/* 3628 */       throw new UnsupportedOperationException(e);
/*      */     } 
/*      */     
/* 3631 */     UNSAFE.putLong(buffer, ADDRESS, address);
/* 3632 */     UNSAFE.putInt(buffer, MARK, -1);
/* 3633 */     UNSAFE.putInt(buffer, LIMIT, capacity);
/* 3634 */     UNSAFE.putInt(buffer, CAPACITY, capacity);
/*      */     
/* 3636 */     return buffer;
/*      */   }
/*      */   
/*      */   static CharBuffer wrapBufferChar(long address, int capacity) {
/*      */     CharBuffer buffer;
/*      */     try {
/* 3642 */       buffer = (CharBuffer)UNSAFE.allocateInstance(BUFFER_CHAR);
/* 3643 */     } catch (InstantiationException e) {
/* 3644 */       throw new UnsupportedOperationException(e);
/*      */     } 
/*      */     
/* 3647 */     UNSAFE.putLong(buffer, ADDRESS, address);
/* 3648 */     UNSAFE.putInt(buffer, MARK, -1);
/* 3649 */     UNSAFE.putInt(buffer, LIMIT, capacity);
/* 3650 */     UNSAFE.putInt(buffer, CAPACITY, capacity);
/*      */     
/* 3652 */     return buffer;
/*      */   }
/*      */   
/*      */   static IntBuffer wrapBufferInt(long address, int capacity) {
/*      */     IntBuffer buffer;
/*      */     try {
/* 3658 */       buffer = (IntBuffer)UNSAFE.allocateInstance(BUFFER_INT);
/* 3659 */     } catch (InstantiationException e) {
/* 3660 */       throw new UnsupportedOperationException(e);
/*      */     } 
/*      */     
/* 3663 */     UNSAFE.putLong(buffer, ADDRESS, address);
/* 3664 */     UNSAFE.putInt(buffer, MARK, -1);
/* 3665 */     UNSAFE.putInt(buffer, LIMIT, capacity);
/* 3666 */     UNSAFE.putInt(buffer, CAPACITY, capacity);
/*      */     
/* 3668 */     return buffer;
/*      */   }
/*      */   
/*      */   static LongBuffer wrapBufferLong(long address, int capacity) {
/*      */     LongBuffer buffer;
/*      */     try {
/* 3674 */       buffer = (LongBuffer)UNSAFE.allocateInstance(BUFFER_LONG);
/* 3675 */     } catch (InstantiationException e) {
/* 3676 */       throw new UnsupportedOperationException(e);
/*      */     } 
/*      */     
/* 3679 */     UNSAFE.putLong(buffer, ADDRESS, address);
/* 3680 */     UNSAFE.putInt(buffer, MARK, -1);
/* 3681 */     UNSAFE.putInt(buffer, LIMIT, capacity);
/* 3682 */     UNSAFE.putInt(buffer, CAPACITY, capacity);
/*      */     
/* 3684 */     return buffer;
/*      */   }
/*      */   
/*      */   static FloatBuffer wrapBufferFloat(long address, int capacity) {
/*      */     FloatBuffer buffer;
/*      */     try {
/* 3690 */       buffer = (FloatBuffer)UNSAFE.allocateInstance(BUFFER_FLOAT);
/* 3691 */     } catch (InstantiationException e) {
/* 3692 */       throw new UnsupportedOperationException(e);
/*      */     } 
/*      */     
/* 3695 */     UNSAFE.putLong(buffer, ADDRESS, address);
/* 3696 */     UNSAFE.putInt(buffer, MARK, -1);
/* 3697 */     UNSAFE.putInt(buffer, LIMIT, capacity);
/* 3698 */     UNSAFE.putInt(buffer, CAPACITY, capacity);
/*      */     
/* 3700 */     return buffer;
/*      */   }
/*      */   
/*      */   static DoubleBuffer wrapBufferDouble(long address, int capacity) {
/*      */     DoubleBuffer buffer;
/*      */     try {
/* 3706 */       buffer = (DoubleBuffer)UNSAFE.allocateInstance(BUFFER_DOUBLE);
/* 3707 */     } catch (InstantiationException e) {
/* 3708 */       throw new UnsupportedOperationException(e);
/*      */     } 
/*      */     
/* 3711 */     UNSAFE.putLong(buffer, ADDRESS, address);
/* 3712 */     UNSAFE.putInt(buffer, MARK, -1);
/* 3713 */     UNSAFE.putInt(buffer, LIMIT, capacity);
/* 3714 */     UNSAFE.putInt(buffer, CAPACITY, capacity);
/*      */     
/* 3716 */     return buffer;
/*      */   }
/*      */   
/*      */   static ByteBuffer slice(ByteBuffer source, long address, int capacity) {
/*      */     ByteBuffer target;
/*      */     try {
/* 3722 */       target = (ByteBuffer)UNSAFE.allocateInstance(BUFFER_BYTE);
/* 3723 */     } catch (InstantiationException e) {
/* 3724 */       throw new UnsupportedOperationException(e);
/*      */     } 
/*      */     
/* 3727 */     UNSAFE.putLong(target, ADDRESS, address);
/* 3728 */     UNSAFE.putInt(target, MARK, -1);
/* 3729 */     UNSAFE.putInt(target, LIMIT, capacity);
/* 3730 */     UNSAFE.putInt(target, CAPACITY, capacity);
/*      */     
/* 3732 */     Object attachment = UNSAFE.getObject(source, PARENT_BYTE);
/* 3733 */     UNSAFE.putObject(target, PARENT_BYTE, (attachment == null) ? source : attachment);
/*      */     
/* 3735 */     return target.order(source.order());
/*      */   }
/*      */ 
/*      */   
/*      */   static <T extends Buffer> T slice(Class<? extends T> clazz, T source, long address, int capacity, long attachmentOffset) {
/*      */     Buffer buffer;
/*      */     try {
/* 3742 */       buffer = (Buffer)UNSAFE.allocateInstance(clazz);
/* 3743 */     } catch (InstantiationException e) {
/* 3744 */       throw new UnsupportedOperationException(e);
/*      */     } 
/*      */     
/* 3747 */     UNSAFE.putLong(buffer, ADDRESS, address);
/* 3748 */     UNSAFE.putInt(buffer, MARK, -1);
/* 3749 */     UNSAFE.putInt(buffer, LIMIT, capacity);
/* 3750 */     UNSAFE.putInt(buffer, CAPACITY, capacity);
/*      */     
/* 3752 */     UNSAFE.putObject(buffer, attachmentOffset, UNSAFE.getObject(source, attachmentOffset));
/*      */     
/* 3754 */     return (T)buffer;
/*      */   }
/*      */ 
/*      */   
/*      */   static <T extends Buffer> T duplicate(Class<? extends T> clazz, T source, long attachmentOffset) {
/*      */     Buffer buffer;
/*      */     try {
/* 3761 */       buffer = (Buffer)UNSAFE.allocateInstance(clazz);
/* 3762 */     } catch (InstantiationException e) {
/* 3763 */       throw new UnsupportedOperationException(e);
/*      */     } 
/*      */     
/* 3766 */     UNSAFE.putLong(buffer, ADDRESS, UNSAFE.getLong(source, ADDRESS));
/* 3767 */     UNSAFE.putInt(buffer, MARK, UNSAFE.getInt(source, MARK));
/* 3768 */     UNSAFE.putInt(buffer, POSITION, UNSAFE.getInt(source, POSITION));
/* 3769 */     UNSAFE.putInt(buffer, LIMIT, UNSAFE.getInt(source, LIMIT));
/* 3770 */     UNSAFE.putInt(buffer, CAPACITY, UNSAFE.getInt(source, CAPACITY));
/*      */     
/* 3772 */     UNSAFE.putObject(buffer, attachmentOffset, UNSAFE.getObject(source, attachmentOffset));
/*      */     
/* 3774 */     return (T)buffer;
/*      */   }
/*      */   
/*      */   public static native <T> T memGlobalRefToObject(long paramLong);
/*      */   
/*      */   public static interface MemoryAllocator {
/*      */     long getMalloc();
/*      */     
/*      */     long getCalloc();
/*      */     
/*      */     long getRealloc();
/*      */     
/*      */     long getFree();
/*      */     
/*      */     long getAlignedAlloc();
/*      */     
/*      */     long getAlignedFree();
/*      */     
/*      */     long malloc(long param1Long);
/*      */     
/*      */     long calloc(long param1Long1, long param1Long2);
/*      */     
/*      */     long realloc(long param1Long1, long param1Long2);
/*      */     
/*      */     void free(long param1Long);
/*      */     
/*      */     long aligned_alloc(long param1Long1, long param1Long2);
/*      */     
/*      */     void aligned_free(long param1Long);
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\MemoryUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */