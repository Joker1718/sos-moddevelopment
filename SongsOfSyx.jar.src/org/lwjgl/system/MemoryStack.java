/*      */ package org.lwjgl.system;
/*      */ 
/*      */ import java.nio.Buffer;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import java.util.Arrays;
/*      */ import java.util.Objects;
/*      */ import org.lwjgl.BufferUtils;
/*      */ import org.lwjgl.CLongBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class MemoryStack
/*      */   extends Pointer.Default
/*      */   implements AutoCloseable
/*      */ {
/*   28 */   private static final int DEFAULT_STACK_SIZE = ((Integer)Configuration.STACK_SIZE.get(Integer.valueOf(64))).intValue() * 1024;
/*      */   
/*      */   private static final int DEFAULT_STACK_FRAMES = 8;
/*   31 */   private static final ThreadLocal<MemoryStack> TLS = ThreadLocal.withInitial(MemoryStack::create); private final ByteBuffer container;
/*      */   
/*      */   static {
/*   34 */     if (DEFAULT_STACK_SIZE < 0) {
/*   35 */       throw new IllegalStateException("Invalid stack size.");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int size;
/*      */ 
/*      */ 
/*      */   
/*      */   private int pointer;
/*      */ 
/*      */ 
/*      */   
/*      */   private int[] frames;
/*      */ 
/*      */ 
/*      */   
/*      */   protected int frameIndex;
/*      */ 
/*      */ 
/*      */   
/*      */   protected MemoryStack(ByteBuffer container, long address, int size) {
/*   59 */     super(address);
/*   60 */     this.container = container;
/*      */     
/*   62 */     this.size = size;
/*   63 */     this.pointer = size;
/*      */     
/*   65 */     this.frames = new int[8];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MemoryStack create() {
/*   74 */     return create(DEFAULT_STACK_SIZE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MemoryStack create(int capacity) {
/*   85 */     return create(BufferUtils.createByteBuffer(capacity));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MemoryStack create(ByteBuffer buffer) {
/*   96 */     long address = MemoryUtil.memAddress(buffer);
/*   97 */     int size = buffer.remaining();
/*   98 */     return ((Boolean)Configuration.DEBUG_STACK.get(Boolean.valueOf(false))).booleanValue() ? new DebugMemoryStack(buffer, address, size) : new MemoryStack(buffer, address, size);
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
/*      */   public static MemoryStack ncreate(long address, int size) {
/*  112 */     return ((Boolean)Configuration.DEBUG_STACK.get(Boolean.valueOf(false))).booleanValue() ? new DebugMemoryStack(null, address, size) : new MemoryStack(null, address, size);
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
/*      */   public MemoryStack push() {
/*  133 */     if (this.frameIndex == this.frames.length) {
/*  134 */       frameOverflow();
/*      */     }
/*      */     
/*  137 */     this.frames[this.frameIndex++] = this.pointer;
/*  138 */     return this;
/*      */   }
/*      */   
/*      */   private void frameOverflow() {
/*  142 */     if (Checks.DEBUG) {
/*  143 */       APIUtil.apiLog("[WARNING] Out of frame stack space (" + this.frames.length + ") in thread: " + Thread.currentThread());
/*      */     }
/*  145 */     this.frames = Arrays.copyOf(this.frames, this.frames.length * 3 / 2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MemoryStack pop() {
/*  154 */     this.pointer = this.frames[--this.frameIndex];
/*  155 */     return this;
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
/*      */   public void close() {
/*  167 */     pop();
/*      */   }
/*      */   
/*      */   private static class DebugMemoryStack
/*      */     extends MemoryStack
/*      */   {
/*      */     private Object[] debugFrames;
/*      */     
/*      */     DebugMemoryStack(ByteBuffer buffer, long address, int size) {
/*  176 */       super(buffer, address, size);
/*  177 */       this.debugFrames = new Object[8];
/*      */     }
/*      */ 
/*      */     
/*      */     public MemoryStack push() {
/*  182 */       if (this.frameIndex == this.debugFrames.length) {
/*  183 */         frameOverflow();
/*      */       }
/*      */       
/*  186 */       this.debugFrames[this.frameIndex] = StackWalkUtil.stackWalkGetMethod(MemoryStack.class);
/*      */       
/*  188 */       return super.push();
/*      */     }
/*      */     
/*      */     private void frameOverflow() {
/*  192 */       this.debugFrames = Arrays.copyOf(this.debugFrames, this.debugFrames.length * 3 / 2);
/*      */     }
/*      */ 
/*      */     
/*      */     public MemoryStack pop() {
/*  197 */       Object pushed = Objects.requireNonNull(this.debugFrames[this.frameIndex - 1]);
/*  198 */       Object popped = StackWalkUtil.stackWalkCheckPop(MemoryStack.class, pushed);
/*  199 */       if (popped != null) {
/*  200 */         reportAsymmetricPop(pushed, popped);
/*      */       }
/*      */       
/*  203 */       this.debugFrames[this.frameIndex - 1] = null;
/*  204 */       return super.pop();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {
/*  210 */       this.debugFrames[this.frameIndex - 1] = null;
/*  211 */       super.pop();
/*      */     }
/*      */     
/*      */     private static void reportAsymmetricPop(Object pushed, Object popped) {
/*  215 */       APIUtil.DEBUG_STREAM.format("[LWJGL] Asymmetric pop detected:\n\tPUSHED: %s\n\tPOPPED: %s\n\tTHREAD: %s\n", new Object[] { pushed, popped, 
/*      */ 
/*      */ 
/*      */             
/*  219 */             Thread.currentThread() });
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
/*      */   public long getAddress() {
/*  231 */     return this.address;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSize() {
/*  240 */     return this.size;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFrameIndex() {
/*  249 */     return this.frameIndex;
/*      */   }
/*      */ 
/*      */   
/*      */   public long getPointerAddress() {
/*  254 */     return this.address + (this.pointer & 0xFFFFFFFFL);
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
/*      */   public int getPointer() {
/*  266 */     return this.pointer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPointer(int pointer) {
/*  276 */     if (Checks.CHECKS) {
/*  277 */       checkPointer(pointer);
/*      */     }
/*      */     
/*  280 */     this.pointer = pointer;
/*      */   }
/*      */   
/*      */   private void checkPointer(int pointer) {
/*  284 */     if (pointer < 0 || this.size < pointer) {
/*  285 */       throw new IndexOutOfBoundsException("Invalid stack pointer");
/*      */     }
/*      */   }
/*      */   
/*      */   private static void checkAlignment(int alignment) {
/*  290 */     if (Integer.bitCount(alignment) != 1) {
/*  291 */       throw new IllegalArgumentException("Alignment must be a power-of-two value.");
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
/*      */   public long nmalloc(int size) {
/*  303 */     return nmalloc(POINTER_SIZE, size);
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
/*      */   public long nmalloc(int alignment, int size) {
/*  317 */     long address = this.address + this.pointer - size & (Integer.toUnsignedLong(alignment - 1) ^ 0xFFFFFFFFFFFFFFFFL);
/*      */     
/*  319 */     this.pointer = (int)(address - this.address);
/*  320 */     if (Checks.CHECKS && this.pointer < 0) {
/*  321 */       throw new OutOfMemoryError("Out of stack space.");
/*      */     }
/*      */     
/*  324 */     return address;
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
/*      */   public long ncalloc(int alignment, int num, int size) {
/*  338 */     int bytes = num * size;
/*  339 */     long address = nmalloc(alignment, bytes);
/*  340 */     MemoryUtil.memSet(address, 0, bytes);
/*  341 */     return address;
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
/*      */   public ByteBuffer malloc(int alignment, int size) {
/*  355 */     if (Checks.DEBUG) {
/*  356 */       checkAlignment(alignment);
/*      */     }
/*  358 */     return MemoryUtil.wrapBufferByte(nmalloc(alignment, size), size);
/*      */   }
/*      */   
/*      */   public ByteBuffer calloc(int alignment, int size) {
/*  362 */     if (Checks.DEBUG) {
/*  363 */       checkAlignment(alignment);
/*      */     }
/*  365 */     return MemoryUtil.wrapBufferByte(ncalloc(alignment, size, 1), size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ByteBuffer malloc(int size) {
/*  376 */     return MemoryUtil.wrapBufferByte(nmalloc(POINTER_SIZE, size), size);
/*      */   }
/*      */   
/*      */   public ByteBuffer calloc(int size) {
/*  380 */     return MemoryUtil.wrapBufferByte(ncalloc(POINTER_SIZE, size, 1), size);
/*      */   }
/*      */ 
/*      */   
/*      */   public long nbyte(byte value) {
/*  385 */     long a = nmalloc(1, 1);
/*  386 */     MemoryUtil.memPutByte(a, value);
/*  387 */     return a;
/*      */   }
/*      */   public ByteBuffer bytes(byte x) {
/*  390 */     return malloc(1, 1).put(0, x);
/*      */   } public ByteBuffer bytes(byte x, byte y) {
/*  392 */     return malloc(1, 2).put(0, x).put(1, y);
/*      */   } public ByteBuffer bytes(byte x, byte y, byte z) {
/*  394 */     return malloc(1, 3).put(0, x).put(1, y).put(2, z);
/*      */   } public ByteBuffer bytes(byte x, byte y, byte z, byte w) {
/*  396 */     return malloc(1, 4).put(0, x).put(1, y).put(2, z).put(3, w);
/*      */   }
/*      */   public ByteBuffer bytes(byte... values) {
/*  399 */     ByteBuffer buffer = malloc(1, values.length).put(values);
/*  400 */     buffer.flip();
/*  401 */     return buffer;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ShortBuffer mallocShort(int size) {
/*  407 */     return MemoryUtil.wrapBufferShort(nmalloc(2, size << 1), size);
/*      */   }
/*      */   public ShortBuffer callocShort(int size) {
/*  410 */     int bytes = size * 2;
/*  411 */     long address = nmalloc(2, bytes);
/*  412 */     MemoryUtil.memSet(address, 0, bytes);
/*  413 */     return MemoryUtil.wrapBufferShort(address, size);
/*      */   }
/*      */ 
/*      */   
/*      */   public long nshort(short value) {
/*  418 */     long a = nmalloc(2, 2);
/*  419 */     MemoryUtil.memPutShort(a, value);
/*  420 */     return a;
/*      */   }
/*      */   public ShortBuffer shorts(short x) {
/*  423 */     return mallocShort(1).put(0, x);
/*      */   } public ShortBuffer shorts(short x, short y) {
/*  425 */     return mallocShort(2).put(0, x).put(1, y);
/*      */   } public ShortBuffer shorts(short x, short y, short z) {
/*  427 */     return mallocShort(3).put(0, x).put(1, y).put(2, z);
/*      */   } public ShortBuffer shorts(short x, short y, short z, short w) {
/*  429 */     return mallocShort(4).put(0, x).put(1, y).put(2, z).put(3, w);
/*      */   }
/*      */   public ShortBuffer shorts(short... values) {
/*  432 */     ShortBuffer buffer = mallocShort(values.length).put(values);
/*  433 */     buffer.flip();
/*  434 */     return buffer;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public IntBuffer mallocInt(int size) {
/*  440 */     return MemoryUtil.wrapBufferInt(nmalloc(4, size << 2), size);
/*      */   }
/*      */   public IntBuffer callocInt(int size) {
/*  443 */     int bytes = size * 4;
/*  444 */     long address = nmalloc(4, bytes);
/*  445 */     MemoryUtil.memSet(address, 0, bytes);
/*  446 */     return MemoryUtil.wrapBufferInt(address, size);
/*      */   }
/*      */ 
/*      */   
/*      */   public long nint(int value) {
/*  451 */     long a = nmalloc(4, 4);
/*  452 */     MemoryUtil.memPutInt(a, value);
/*  453 */     return a;
/*      */   }
/*      */   public IntBuffer ints(int x) {
/*  456 */     return mallocInt(1).put(0, x);
/*      */   } public IntBuffer ints(int x, int y) {
/*  458 */     return mallocInt(2).put(0, x).put(1, y);
/*      */   } public IntBuffer ints(int x, int y, int z) {
/*  460 */     return mallocInt(3).put(0, x).put(1, y).put(2, z);
/*      */   } public IntBuffer ints(int x, int y, int z, int w) {
/*  462 */     return mallocInt(4).put(0, x).put(1, y).put(2, z).put(3, w);
/*      */   }
/*      */   public IntBuffer ints(int... values) {
/*  465 */     IntBuffer buffer = mallocInt(values.length).put(values);
/*  466 */     buffer.flip();
/*  467 */     return buffer;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public LongBuffer mallocLong(int size) {
/*  473 */     return MemoryUtil.wrapBufferLong(nmalloc(8, size << 3), size);
/*      */   }
/*      */   public LongBuffer callocLong(int size) {
/*  476 */     int bytes = size * 8;
/*  477 */     long address = nmalloc(8, bytes);
/*  478 */     MemoryUtil.memSet(address, 0, bytes);
/*  479 */     return MemoryUtil.wrapBufferLong(address, size);
/*      */   }
/*      */ 
/*      */   
/*      */   public long nlong(long value) {
/*  484 */     long a = nmalloc(8, 8);
/*  485 */     MemoryUtil.memPutLong(a, value);
/*  486 */     return a;
/*      */   }
/*      */   public LongBuffer longs(long x) {
/*  489 */     return mallocLong(1).put(0, x);
/*      */   } public LongBuffer longs(long x, long y) {
/*  491 */     return mallocLong(2).put(0, x).put(1, y);
/*      */   } public LongBuffer longs(long x, long y, long z) {
/*  493 */     return mallocLong(3).put(0, x).put(1, y).put(2, z);
/*      */   } public LongBuffer longs(long x, long y, long z, long w) {
/*  495 */     return mallocLong(4).put(0, x).put(1, y).put(2, z).put(3, w);
/*      */   }
/*      */   public LongBuffer longs(long... more) {
/*  498 */     LongBuffer buffer = mallocLong(more.length).put(more);
/*  499 */     buffer.flip();
/*  500 */     return buffer;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public CLongBuffer mallocCLong(int size) {
/*  506 */     return CLongBuffer.create(nmalloc(CLONG_SIZE, size << CLONG_SHIFT), size);
/*      */   }
/*      */   public CLongBuffer callocCLong(int size) {
/*  509 */     int bytes = size * CLONG_SIZE;
/*  510 */     long address = nmalloc(CLONG_SIZE, bytes);
/*  511 */     MemoryUtil.memSet(address, 0, bytes);
/*  512 */     return CLongBuffer.create(address, size);
/*      */   }
/*      */ 
/*      */   
/*      */   public long nclong(long value) {
/*  517 */     long a = nmalloc(CLONG_SIZE, CLONG_SIZE);
/*  518 */     MemoryUtil.memPutCLong(a, value);
/*  519 */     return a;
/*      */   }
/*      */   public CLongBuffer clongs(long x) {
/*  522 */     return mallocCLong(1).put(0, x);
/*      */   } public CLongBuffer clongs(long x, long y) {
/*  524 */     return mallocCLong(2).put(0, x).put(1, y);
/*      */   } public CLongBuffer clongs(long x, long y, long z) {
/*  526 */     return mallocCLong(3).put(0, x).put(1, y).put(2, z);
/*      */   } public CLongBuffer clongs(long x, long y, long z, long w) {
/*  528 */     return mallocCLong(4).put(0, x).put(1, y).put(2, z).put(3, w);
/*      */   }
/*      */   public CLongBuffer clongs(long... values) {
/*  531 */     CLongBuffer buffer = mallocCLong(values.length).put(values);
/*  532 */     buffer.flip();
/*  533 */     return buffer;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public FloatBuffer mallocFloat(int size) {
/*  539 */     return MemoryUtil.wrapBufferFloat(nmalloc(4, size << 2), size);
/*      */   }
/*      */   public FloatBuffer callocFloat(int size) {
/*  542 */     int bytes = size * 4;
/*  543 */     long address = nmalloc(4, bytes);
/*  544 */     MemoryUtil.memSet(address, 0, bytes);
/*  545 */     return MemoryUtil.wrapBufferFloat(address, size);
/*      */   }
/*      */ 
/*      */   
/*      */   public long nfloat(float value) {
/*  550 */     long a = nmalloc(4, 4);
/*  551 */     MemoryUtil.memPutFloat(a, value);
/*  552 */     return a;
/*      */   }
/*      */   public FloatBuffer floats(float x) {
/*  555 */     return mallocFloat(1).put(0, x);
/*      */   } public FloatBuffer floats(float x, float y) {
/*  557 */     return mallocFloat(2).put(0, x).put(1, y);
/*      */   } public FloatBuffer floats(float x, float y, float z) {
/*  559 */     return mallocFloat(3).put(0, x).put(1, y).put(2, z);
/*      */   } public FloatBuffer floats(float x, float y, float z, float w) {
/*  561 */     return mallocFloat(4).put(0, x).put(1, y).put(2, z).put(3, w);
/*      */   }
/*      */   public FloatBuffer floats(float... values) {
/*  564 */     FloatBuffer buffer = mallocFloat(values.length).put(values);
/*  565 */     buffer.flip();
/*  566 */     return buffer;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public DoubleBuffer mallocDouble(int size) {
/*  572 */     return MemoryUtil.wrapBufferDouble(nmalloc(8, size << 3), size);
/*      */   }
/*      */   public DoubleBuffer callocDouble(int size) {
/*  575 */     int bytes = size * 8;
/*  576 */     long address = nmalloc(8, bytes);
/*  577 */     MemoryUtil.memSet(address, 0, bytes);
/*  578 */     return MemoryUtil.wrapBufferDouble(address, size);
/*      */   }
/*      */ 
/*      */   
/*      */   public long ndouble(double value) {
/*  583 */     long a = nmalloc(8, 8);
/*  584 */     MemoryUtil.memPutDouble(a, value);
/*  585 */     return a;
/*      */   }
/*      */   public DoubleBuffer doubles(double x) {
/*  588 */     return mallocDouble(1).put(0, x);
/*      */   } public DoubleBuffer doubles(double x, double y) {
/*  590 */     return mallocDouble(2).put(0, x).put(1, y);
/*      */   } public DoubleBuffer doubles(double x, double y, double z) {
/*  592 */     return mallocDouble(3).put(0, x).put(1, y).put(2, z);
/*      */   } public DoubleBuffer doubles(double x, double y, double z, double w) {
/*  594 */     return mallocDouble(4).put(0, x).put(1, y).put(2, z).put(3, w);
/*      */   }
/*      */   public DoubleBuffer doubles(double... values) {
/*  597 */     DoubleBuffer buffer = mallocDouble(values.length).put(values);
/*  598 */     buffer.flip();
/*  599 */     return buffer;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public PointerBuffer mallocPointer(int size) {
/*  605 */     return PointerBuffer.create(nmalloc(POINTER_SIZE, size << POINTER_SHIFT), size);
/*      */   }
/*      */   public PointerBuffer callocPointer(int size) {
/*  608 */     int bytes = size * POINTER_SIZE;
/*  609 */     long address = nmalloc(POINTER_SIZE, bytes);
/*  610 */     MemoryUtil.memSet(address, 0, bytes);
/*  611 */     return PointerBuffer.create(address, size);
/*      */   }
/*      */ 
/*      */   
/*      */   public long npointer(long value) {
/*  616 */     long a = nmalloc(POINTER_SIZE, POINTER_SIZE);
/*  617 */     MemoryUtil.memPutAddress(a, value);
/*  618 */     return a;
/*      */   }
/*      */   public PointerBuffer pointers(long x) {
/*  621 */     return mallocPointer(1).put(0, x);
/*      */   } public PointerBuffer pointers(long x, long y) {
/*  623 */     return mallocPointer(2).put(0, x).put(1, y);
/*      */   } public PointerBuffer pointers(long x, long y, long z) {
/*  625 */     return mallocPointer(3).put(0, x).put(1, y).put(2, z);
/*      */   } public PointerBuffer pointers(long x, long y, long z, long w) {
/*  627 */     return mallocPointer(4).put(0, x).put(1, y).put(2, z).put(3, w);
/*      */   }
/*      */   public PointerBuffer pointers(long... values) {
/*  630 */     PointerBuffer buffer = mallocPointer(values.length).put(values);
/*  631 */     buffer.flip();
/*  632 */     return buffer;
/*      */   }
/*      */ 
/*      */   
/*      */   public long npointer(Pointer value) {
/*  637 */     long a = nmalloc(POINTER_SIZE, POINTER_SIZE);
/*  638 */     MemoryUtil.memPutAddress(a, value.address());
/*  639 */     return a;
/*      */   }
/*      */   public PointerBuffer pointers(Pointer x) {
/*  642 */     return mallocPointer(1).put(0, x);
/*      */   } public PointerBuffer pointers(Pointer x, Pointer y) {
/*  644 */     return mallocPointer(2).put(0, x).put(1, y);
/*      */   } public PointerBuffer pointers(Pointer x, Pointer y, Pointer z) {
/*  646 */     return mallocPointer(3).put(0, x).put(1, y).put(2, z);
/*      */   } public PointerBuffer pointers(Pointer x, Pointer y, Pointer z, Pointer w) {
/*  648 */     return mallocPointer(4).put(0, x).put(1, y).put(2, z).put(3, w);
/*      */   }
/*      */   public PointerBuffer pointers(Pointer... values) {
/*  651 */     PointerBuffer buffer = mallocPointer(values.length);
/*  652 */     for (int i = 0; i < values.length; i++) {
/*  653 */       buffer.put(i, values[i]);
/*      */     }
/*  655 */     return buffer;
/*      */   }
/*      */ 
/*      */   
/*      */   public long npointer(Buffer value) {
/*  660 */     long a = nmalloc(POINTER_SIZE, POINTER_SIZE);
/*  661 */     MemoryUtil.memPutAddress(a, MemoryUtil.memAddress(value));
/*  662 */     return a;
/*      */   }
/*      */   
/*      */   public PointerBuffer pointers(Buffer x) {
/*  666 */     return mallocPointer(1)
/*  667 */       .put(0, MemoryUtil.memAddress(x));
/*      */   }
/*      */   
/*      */   public PointerBuffer pointers(Buffer x, Buffer y) {
/*  671 */     return mallocPointer(2)
/*  672 */       .put(0, MemoryUtil.memAddress(x))
/*  673 */       .put(1, MemoryUtil.memAddress(y));
/*      */   }
/*      */   
/*      */   public PointerBuffer pointers(Buffer x, Buffer y, Buffer z) {
/*  677 */     return mallocPointer(3)
/*  678 */       .put(0, MemoryUtil.memAddress(x))
/*  679 */       .put(1, MemoryUtil.memAddress(y))
/*  680 */       .put(2, MemoryUtil.memAddress(z));
/*      */   }
/*      */   
/*      */   public PointerBuffer pointers(Buffer x, Buffer y, Buffer z, Buffer w) {
/*  684 */     return mallocPointer(4)
/*  685 */       .put(0, MemoryUtil.memAddress(x))
/*  686 */       .put(1, MemoryUtil.memAddress(y))
/*  687 */       .put(2, MemoryUtil.memAddress(z))
/*  688 */       .put(3, MemoryUtil.memAddress(w));
/*      */   }
/*      */   
/*      */   public PointerBuffer pointers(Buffer... values) {
/*  692 */     PointerBuffer buffer = mallocPointer(values.length);
/*  693 */     for (int i = 0; i < values.length; i++) {
/*  694 */       buffer.put(i, MemoryUtil.memAddress(values[i]));
/*      */     }
/*  696 */     return buffer;
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
/*      */   public PointerBuffer pointersOfElements(CustomBuffer<?> buffer) {
/*  711 */     int remaining = buffer.remaining();
/*  712 */     long addr = buffer.address();
/*  713 */     long sizeof = buffer.sizeof();
/*      */     
/*  715 */     PointerBuffer pointerBuffer = mallocPointer(remaining);
/*  716 */     for (int i = 0; i < remaining; i++) {
/*  717 */       pointerBuffer.put(i, addr + sizeof * i);
/*      */     }
/*      */     
/*  720 */     return pointerBuffer;
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
/*      */   public ByteBuffer ASCII(CharSequence text) {
/*  734 */     return ASCII(text, true);
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
/*      */   public ByteBuffer ASCII(CharSequence text, boolean nullTerminated) {
/*  746 */     int length = MemoryUtil.memLengthASCII(text, nullTerminated);
/*  747 */     long target = nmalloc(POINTER_SIZE, length);
/*  748 */     MemoryUtil.encodeASCIIUnsafe(text, nullTerminated, target);
/*  749 */     return MemoryUtil.wrapBufferByte(target, length);
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
/*      */   public int nASCII(CharSequence text, boolean nullTerminated) {
/*  762 */     long target = nmalloc(POINTER_SIZE, MemoryUtil.memLengthASCII(text, nullTerminated));
/*  763 */     return MemoryUtil.encodeASCIIUnsafe(text, nullTerminated, target);
/*      */   }
/*      */ 
/*      */   
/*      */   public ByteBuffer ASCIISafe(CharSequence text) {
/*  768 */     return ASCIISafe(text, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public ByteBuffer ASCIISafe(CharSequence text, boolean nullTerminated) {
/*  773 */     return (text == null) ? null : ASCII(text, nullTerminated);
/*      */   }
/*      */ 
/*      */   
/*      */   public int nASCIISafe(CharSequence text, boolean nullTerminated) {
/*  778 */     return (text == null) ? 0 : nASCII(text, nullTerminated);
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
/*      */   public ByteBuffer UTF8(CharSequence text) {
/*  790 */     return UTF8(text, true);
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
/*      */   public ByteBuffer UTF8(CharSequence text, boolean nullTerminated) {
/*  802 */     int length = MemoryUtil.memLengthUTF8(text, nullTerminated);
/*  803 */     long target = nmalloc(POINTER_SIZE, length);
/*  804 */     MemoryUtil.encodeUTF8Unsafe(text, nullTerminated, target);
/*  805 */     return MemoryUtil.wrapBufferByte(target, length);
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
/*      */   public int nUTF8(CharSequence text, boolean nullTerminated) {
/*  818 */     long target = nmalloc(POINTER_SIZE, MemoryUtil.memLengthUTF8(text, nullTerminated));
/*  819 */     return MemoryUtil.encodeUTF8Unsafe(text, nullTerminated, target);
/*      */   }
/*      */ 
/*      */   
/*      */   public ByteBuffer UTF8Safe(CharSequence text) {
/*  824 */     return UTF8Safe(text, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public ByteBuffer UTF8Safe(CharSequence text, boolean nullTerminated) {
/*  829 */     return (text == null) ? null : UTF8(text, nullTerminated);
/*      */   }
/*      */ 
/*      */   
/*      */   public int nUTF8Safe(CharSequence text, boolean nullTerminated) {
/*  834 */     return (text == null) ? 0 : nUTF8(text, nullTerminated);
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
/*      */   public ByteBuffer UTF16(CharSequence text) {
/*  846 */     return UTF16(text, true);
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
/*      */   public ByteBuffer UTF16(CharSequence text, boolean nullTerminated) {
/*  858 */     int length = MemoryUtil.memLengthUTF16(text, nullTerminated);
/*  859 */     long target = nmalloc(POINTER_SIZE, length);
/*  860 */     MemoryUtil.encodeUTF16Unsafe(text, nullTerminated, target);
/*  861 */     return MemoryUtil.wrapBufferByte(target, length);
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
/*      */   public int nUTF16(CharSequence text, boolean nullTerminated) {
/*  874 */     long target = nmalloc(POINTER_SIZE, MemoryUtil.memLengthUTF16(text, nullTerminated));
/*  875 */     return MemoryUtil.encodeUTF16Unsafe(text, nullTerminated, target);
/*      */   }
/*      */ 
/*      */   
/*      */   public ByteBuffer UTF16Safe(CharSequence text) {
/*  880 */     return UTF16Safe(text, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public ByteBuffer UTF16Safe(CharSequence text, boolean nullTerminated) {
/*  885 */     return (text == null) ? null : UTF16(text, nullTerminated);
/*      */   }
/*      */ 
/*      */   
/*      */   public int nUTF16Safe(CharSequence text, boolean nullTerminated) {
/*  890 */     return (text == null) ? 0 : nUTF16(text, nullTerminated);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MemoryStack stackGet() {
/*  899 */     return TLS.get();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MemoryStack stackPush() {
/*  908 */     return stackGet().push();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MemoryStack stackPop() {
/*  917 */     return stackGet().pop();
/*      */   }
/*      */   
/*      */   public static long nstackMalloc(int size) {
/*  921 */     return stackGet().nmalloc(size);
/*      */   } public static long nstackMalloc(int alignment, int size) {
/*  923 */     return stackGet().nmalloc(alignment, size);
/*      */   } public static long nstackCalloc(int alignment, int num, int size) {
/*  925 */     return stackGet().ncalloc(alignment, num, size);
/*      */   }
/*      */ 
/*      */   
/*      */   public static ByteBuffer stackMalloc(int size) {
/*  930 */     return stackGet().malloc(size);
/*      */   } public static ByteBuffer stackCalloc(int size) {
/*  932 */     return stackGet().calloc(size);
/*      */   }
/*      */   public static ByteBuffer stackBytes(byte x) {
/*  935 */     return stackGet().bytes(x);
/*      */   } public static ByteBuffer stackBytes(byte x, byte y) {
/*  937 */     return stackGet().bytes(x, y);
/*      */   } public static ByteBuffer stackBytes(byte x, byte y, byte z) {
/*  939 */     return stackGet().bytes(x, y, z);
/*      */   } public static ByteBuffer stackBytes(byte x, byte y, byte z, byte w) {
/*  941 */     return stackGet().bytes(x, y, z, w);
/*      */   } public static ByteBuffer stackBytes(byte... values) {
/*  943 */     return stackGet().bytes(values);
/*      */   }
/*      */ 
/*      */   
/*      */   public static ShortBuffer stackMallocShort(int size) {
/*  948 */     return stackGet().mallocShort(size);
/*      */   } public static ShortBuffer stackCallocShort(int size) {
/*  950 */     return stackGet().callocShort(size);
/*      */   }
/*      */   public static ShortBuffer stackShorts(short x) {
/*  953 */     return stackGet().shorts(x);
/*      */   } public static ShortBuffer stackShorts(short x, short y) {
/*  955 */     return stackGet().shorts(x, y);
/*      */   } public static ShortBuffer stackShorts(short x, short y, short z) {
/*  957 */     return stackGet().shorts(x, y, z);
/*      */   } public static ShortBuffer stackShorts(short x, short y, short z, short w) {
/*  959 */     return stackGet().shorts(x, y, z, w);
/*      */   } public static ShortBuffer stackShorts(short... values) {
/*  961 */     return stackGet().shorts(values);
/*      */   }
/*      */ 
/*      */   
/*      */   public static IntBuffer stackMallocInt(int size) {
/*  966 */     return stackGet().mallocInt(size);
/*      */   } public static IntBuffer stackCallocInt(int size) {
/*  968 */     return stackGet().callocInt(size);
/*      */   }
/*      */   public static IntBuffer stackInts(int x) {
/*  971 */     return stackGet().ints(x);
/*      */   } public static IntBuffer stackInts(int x, int y) {
/*  973 */     return stackGet().ints(x, y);
/*      */   } public static IntBuffer stackInts(int x, int y, int z) {
/*  975 */     return stackGet().ints(x, y, z);
/*      */   } public static IntBuffer stackInts(int x, int y, int z, int w) {
/*  977 */     return stackGet().ints(x, y, z, w);
/*      */   } public static IntBuffer stackInts(int... values) {
/*  979 */     return stackGet().ints(values);
/*      */   }
/*      */ 
/*      */   
/*      */   public static LongBuffer stackMallocLong(int size) {
/*  984 */     return stackGet().mallocLong(size);
/*      */   } public static LongBuffer stackCallocLong(int size) {
/*  986 */     return stackGet().callocLong(size);
/*      */   }
/*      */   public static LongBuffer stackLongs(long x) {
/*  989 */     return stackGet().longs(x);
/*      */   } public static LongBuffer stackLongs(long x, long y) {
/*  991 */     return stackGet().longs(x, y);
/*      */   } public static LongBuffer stackLongs(long x, long y, long z) {
/*  993 */     return stackGet().longs(x, y, z);
/*      */   } public static LongBuffer stackLongs(long x, long y, long z, long w) {
/*  995 */     return stackGet().longs(x, y, z, w);
/*      */   } public static LongBuffer stackLongs(long... values) {
/*  997 */     return stackGet().longs(values);
/*      */   }
/*      */ 
/*      */   
/*      */   public static CLongBuffer stackMallocCLong(int size) {
/* 1002 */     return stackGet().mallocCLong(size);
/*      */   } public static CLongBuffer stackCallocCLong(int size) {
/* 1004 */     return stackGet().callocCLong(size);
/*      */   }
/*      */   public static CLongBuffer stackCLongs(long x) {
/* 1007 */     return stackGet().clongs(x);
/*      */   } public static CLongBuffer stackCLongs(long x, long y) {
/* 1009 */     return stackGet().clongs(x, y);
/*      */   } public static CLongBuffer stackCLongs(long x, long y, long z) {
/* 1011 */     return stackGet().clongs(x, y, z);
/*      */   } public static CLongBuffer stackCLongs(long x, long y, long z, long w) {
/* 1013 */     return stackGet().clongs(x, y, z, w);
/*      */   } public static CLongBuffer stackCLongs(long... values) {
/* 1015 */     return stackGet().clongs(values);
/*      */   }
/*      */ 
/*      */   
/*      */   public static FloatBuffer stackMallocFloat(int size) {
/* 1020 */     return stackGet().mallocFloat(size);
/*      */   } public static FloatBuffer stackCallocFloat(int size) {
/* 1022 */     return stackGet().callocFloat(size);
/*      */   }
/*      */   public static FloatBuffer stackFloats(float x) {
/* 1025 */     return stackGet().floats(x);
/*      */   } public static FloatBuffer stackFloats(float x, float y) {
/* 1027 */     return stackGet().floats(x, y);
/*      */   } public static FloatBuffer stackFloats(float x, float y, float z) {
/* 1029 */     return stackGet().floats(x, y, z);
/*      */   } public static FloatBuffer stackFloats(float x, float y, float z, float w) {
/* 1031 */     return stackGet().floats(x, y, z, w);
/*      */   } public static FloatBuffer stackFloats(float... values) {
/* 1033 */     return stackGet().floats(values);
/*      */   }
/*      */ 
/*      */   
/*      */   public static DoubleBuffer stackMallocDouble(int size) {
/* 1038 */     return stackGet().mallocDouble(size);
/*      */   } public static DoubleBuffer stackCallocDouble(int size) {
/* 1040 */     return stackGet().callocDouble(size);
/*      */   }
/*      */   public static DoubleBuffer stackDoubles(double x) {
/* 1043 */     return stackGet().doubles(x);
/*      */   } public static DoubleBuffer stackDoubles(double x, double y) {
/* 1045 */     return stackGet().doubles(x, y);
/*      */   } public static DoubleBuffer stackDoubles(double x, double y, double z) {
/* 1047 */     return stackGet().doubles(x, y, z);
/*      */   } public static DoubleBuffer stackDoubles(double x, double y, double z, double w) {
/* 1049 */     return stackGet().doubles(x, y, z, w);
/*      */   } public static DoubleBuffer stackDoubles(double... values) {
/* 1051 */     return stackGet().doubles(values);
/*      */   }
/*      */ 
/*      */   
/*      */   public static PointerBuffer stackMallocPointer(int size) {
/* 1056 */     return stackGet().mallocPointer(size);
/*      */   } public static PointerBuffer stackCallocPointer(int size) {
/* 1058 */     return stackGet().callocPointer(size);
/*      */   }
/*      */   public static PointerBuffer stackPointers(long x) {
/* 1061 */     return stackGet().pointers(x);
/*      */   } public static PointerBuffer stackPointers(long x, long y) {
/* 1063 */     return stackGet().pointers(x, y);
/*      */   } public static PointerBuffer stackPointers(long x, long y, long z) {
/* 1065 */     return stackGet().pointers(x, y, z);
/*      */   } public static PointerBuffer stackPointers(long x, long y, long z, long w) {
/* 1067 */     return stackGet().pointers(x, y, z, w);
/*      */   } public static PointerBuffer stackPointers(long... values) {
/* 1069 */     return stackGet().pointers(values);
/*      */   }
/*      */   public static PointerBuffer stackPointers(Pointer x) {
/* 1072 */     return stackGet().pointers(x);
/*      */   } public static PointerBuffer stackPointers(Pointer x, Pointer y) {
/* 1074 */     return stackGet().pointers(x, y);
/*      */   } public static PointerBuffer stackPointers(Pointer x, Pointer y, Pointer z) {
/* 1076 */     return stackGet().pointers(x, y, z);
/*      */   } public static PointerBuffer stackPointers(Pointer x, Pointer y, Pointer z, Pointer w) {
/* 1078 */     return stackGet().pointers(x, y, z, w);
/*      */   } public static PointerBuffer stackPointers(Pointer... values) {
/* 1080 */     return stackGet().pointers(values);
/*      */   }
/*      */ 
/*      */   
/*      */   public static ByteBuffer stackASCII(CharSequence text) {
/* 1085 */     return stackGet().ASCII(text);
/*      */   }
/*      */   public static ByteBuffer stackASCII(CharSequence text, boolean nullTerminated) {
/* 1088 */     return stackGet().ASCII(text, nullTerminated);
/*      */   }
/*      */   public static ByteBuffer stackUTF8(CharSequence text) {
/* 1091 */     return stackGet().UTF8(text);
/*      */   }
/*      */   public static ByteBuffer stackUTF8(CharSequence text, boolean nullTerminated) {
/* 1094 */     return stackGet().UTF8(text, nullTerminated);
/*      */   }
/*      */   public static ByteBuffer stackUTF16(CharSequence text) {
/* 1097 */     return stackGet().UTF16(text);
/*      */   }
/*      */   public static ByteBuffer stackUTF16(CharSequence text, boolean nullTerminated) {
/* 1100 */     return stackGet().UTF16(text, nullTerminated);
/*      */   }
/*      */   public static ByteBuffer stackASCIISafe(CharSequence text) {
/* 1103 */     return stackGet().ASCIISafe(text);
/*      */   }
/*      */   public static ByteBuffer stackASCIISafe(CharSequence text, boolean nullTerminated) {
/* 1106 */     return stackGet().ASCIISafe(text, nullTerminated);
/*      */   }
/*      */   public static ByteBuffer stackUTF8Safe(CharSequence text) {
/* 1109 */     return stackGet().UTF8Safe(text);
/*      */   }
/*      */   public static ByteBuffer stackUTF8Safe(CharSequence text, boolean nullTerminated) {
/* 1112 */     return stackGet().UTF8Safe(text, nullTerminated);
/*      */   }
/*      */   public static ByteBuffer stackUTF16Safe(CharSequence text) {
/* 1115 */     return stackGet().UTF16Safe(text);
/*      */   }
/*      */   public static ByteBuffer stackUTF16Safe(CharSequence text, boolean nullTerminated) {
/* 1118 */     return stackGet().UTF16Safe(text, nullTerminated);
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\MemoryStack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */