/*     */ package org.lwjgl;
/*     */ 
/*     */ import java.nio.BufferOverflowException;
/*     */ import java.nio.BufferUnderflowException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.CheckIntrinsics;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.Pointer;
/*     */ 
/*     */ public class PointerBuffer
/*     */   extends CustomBuffer<PointerBuffer> implements Comparable<PointerBuffer> {
/*     */   protected PointerBuffer(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/*  20 */     super(address, container, mark, position, limit, capacity);
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
/*     */   public static PointerBuffer allocateDirect(int capacity) {
/*  35 */     ByteBuffer source = BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(capacity, POINTER_SHIFT));
/*  36 */     return new PointerBuffer(MemoryUtil.memAddress(source), source, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PointerBuffer create(long address, int capacity) {
/*  46 */     return new PointerBuffer(address, null, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PointerBuffer create(ByteBuffer source) {
/*  55 */     int capacity = source.remaining() >> POINTER_SHIFT;
/*  56 */     return new PointerBuffer(MemoryUtil.memAddress(source), source, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   protected PointerBuffer self() {
/*  61 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected PointerBuffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/*  66 */     return new PointerBuffer(address, container, mark, position, limit, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public int sizeof() {
/*  71 */     return POINTER_SIZE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long get() {
/*  82 */     return MemoryUtil.memGetAddress(this.address + Integer.toUnsignedLong(nextGetIndex()) * POINTER_SIZE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long get(ByteBuffer source) {
/*  91 */     if (source.remaining() < POINTER_SIZE) {
/*  92 */       throw new BufferUnderflowException();
/*     */     }
/*     */     
/*     */     try {
/*  96 */       return MemoryUtil.memGetAddress(MemoryUtil.memAddress(source));
/*     */     } finally {
/*  98 */       source.position(source.position() + POINTER_SIZE);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PointerBuffer put(long p) {
/* 114 */     MemoryUtil.memPutAddress(this.address + Integer.toUnsignedLong(nextPutIndex()) * POINTER_SIZE, p);
/* 115 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void put(ByteBuffer target, long p) {
/* 125 */     if (target.remaining() < POINTER_SIZE) {
/* 126 */       throw new BufferOverflowException();
/*     */     }
/*     */     
/*     */     try {
/* 130 */       MemoryUtil.memPutAddress(MemoryUtil.memAddress(target), p);
/*     */     } finally {
/* 132 */       target.position(target.position() + POINTER_SIZE);
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
/*     */ 
/*     */   
/*     */   public long get(int index) {
/* 146 */     return MemoryUtil.memGetAddress(this.address + Checks.check(index, this.limit) * POINTER_SIZE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long get(ByteBuffer source, int index) {
/* 156 */     CheckIntrinsics.checkFromIndexSize(index, POINTER_SIZE, source.limit());
/* 157 */     return MemoryUtil.memGetAddress(MemoryUtil.memAddress0(source) + index);
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
/*     */   
/*     */   public PointerBuffer put(int index, long p) {
/* 173 */     MemoryUtil.memPutAddress(this.address + Checks.check(index, this.limit) * POINTER_SIZE, p);
/* 174 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void put(ByteBuffer target, int index, long p) {
/* 185 */     CheckIntrinsics.checkFromIndexSize(index, POINTER_SIZE, target.limit());
/* 186 */     MemoryUtil.memPutAddress(MemoryUtil.memAddress0(target) + index, p);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PointerBuffer put(Pointer pointer) {
/* 193 */     put(pointer.address());
/* 194 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public PointerBuffer put(int index, Pointer pointer) {
/* 199 */     put(index, pointer.address());
/* 200 */     return this;
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
/*     */   public PointerBuffer put(ByteBuffer buffer) {
/* 215 */     put(MemoryUtil.memAddress(buffer));
/* 216 */     return this;
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
/*     */   public PointerBuffer put(ShortBuffer buffer) {
/* 229 */     put(MemoryUtil.memAddress(buffer));
/* 230 */     return this;
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
/*     */   public PointerBuffer put(IntBuffer buffer) {
/* 243 */     put(MemoryUtil.memAddress(buffer));
/* 244 */     return this;
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
/*     */   public PointerBuffer put(LongBuffer buffer) {
/* 257 */     put(MemoryUtil.memAddress(buffer));
/* 258 */     return this;
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
/*     */   public PointerBuffer put(FloatBuffer buffer) {
/* 271 */     put(MemoryUtil.memAddress(buffer));
/* 272 */     return this;
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
/*     */   public PointerBuffer put(DoubleBuffer buffer) {
/* 285 */     put(MemoryUtil.memAddress(buffer));
/* 286 */     return this;
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
/*     */   public PointerBuffer putAddressOf(CustomBuffer<?> buffer) {
/* 299 */     put(MemoryUtil.memAddress(buffer));
/* 300 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PointerBuffer put(int index, ByteBuffer buffer) {
/* 307 */     put(index, MemoryUtil.memAddress(buffer));
/* 308 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public PointerBuffer put(int index, ShortBuffer buffer) {
/* 313 */     put(index, MemoryUtil.memAddress(buffer));
/* 314 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public PointerBuffer put(int index, IntBuffer buffer) {
/* 319 */     put(index, MemoryUtil.memAddress(buffer));
/* 320 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public PointerBuffer put(int index, LongBuffer buffer) {
/* 325 */     put(index, MemoryUtil.memAddress(buffer));
/* 326 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public PointerBuffer put(int index, FloatBuffer buffer) {
/* 331 */     put(index, MemoryUtil.memAddress(buffer));
/* 332 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public PointerBuffer put(int index, DoubleBuffer buffer) {
/* 337 */     put(index, MemoryUtil.memAddress(buffer));
/* 338 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public PointerBuffer putAddressOf(int index, CustomBuffer<?> buffer) {
/* 343 */     put(index, MemoryUtil.memAddress(buffer));
/* 344 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteBuffer getByteBuffer(int size) {
/* 355 */     return MemoryUtil.memByteBuffer(get(), size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ShortBuffer getShortBuffer(int size) {
/* 363 */     return MemoryUtil.memShortBuffer(get(), size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntBuffer getIntBuffer(int size) {
/* 371 */     return MemoryUtil.memIntBuffer(get(), size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LongBuffer getLongBuffer(int size) {
/* 379 */     return MemoryUtil.memLongBuffer(get(), size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FloatBuffer getFloatBuffer(int size) {
/* 387 */     return MemoryUtil.memFloatBuffer(get(), size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DoubleBuffer getDoubleBuffer(int size) {
/* 395 */     return MemoryUtil.memDoubleBuffer(get(), size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PointerBuffer getPointerBuffer(int size) {
/* 403 */     return MemoryUtil.memPointerBuffer(get(), size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringASCII() {
/* 411 */     return MemoryUtil.memASCII(get());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringUTF8() {
/* 419 */     return MemoryUtil.memUTF8(get());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStringUTF16() {
/* 427 */     return MemoryUtil.memUTF16(get());
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuffer getByteBuffer(int index, int size) {
/* 432 */     return MemoryUtil.memByteBuffer(get(index), size);
/*     */   }
/*     */   public ShortBuffer getShortBuffer(int index, int size) {
/* 435 */     return MemoryUtil.memShortBuffer(get(index), size);
/*     */   }
/*     */   public IntBuffer getIntBuffer(int index, int size) {
/* 438 */     return MemoryUtil.memIntBuffer(get(index), size);
/*     */   }
/*     */   public LongBuffer getLongBuffer(int index, int size) {
/* 441 */     return MemoryUtil.memLongBuffer(get(index), size);
/*     */   }
/*     */   public FloatBuffer getFloatBuffer(int index, int size) {
/* 444 */     return MemoryUtil.memFloatBuffer(get(index), size);
/*     */   }
/*     */   public DoubleBuffer getDoubleBuffer(int index, int size) {
/* 447 */     return MemoryUtil.memDoubleBuffer(get(index), size);
/*     */   }
/*     */   public PointerBuffer getPointerBuffer(int index, int size) {
/* 450 */     return MemoryUtil.memPointerBuffer(get(index), size);
/*     */   }
/*     */   public String getStringASCII(int index) {
/* 453 */     return MemoryUtil.memASCII(get(index));
/*     */   }
/*     */   public String getStringUTF8(int index) {
/* 456 */     return MemoryUtil.memUTF8(get(index));
/*     */   }
/*     */   public String getStringUTF16(int index) {
/* 459 */     return MemoryUtil.memUTF16(get(index));
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
/*     */ 
/*     */ 
/*     */   
/*     */   public PointerBuffer get(long[] dst) {
/* 477 */     return get(dst, 0, dst.length);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public PointerBuffer get(long[] dst, int offset, int length) {
/* 508 */     if (BITS64) {
/* 509 */       MemoryUtil.memLongBuffer(address(), remaining()).get(dst, offset, length);
/* 510 */       position(position() + length);
/*     */     } else {
/* 512 */       get32(dst, offset, length);
/*     */     } 
/*     */     
/* 515 */     return this;
/*     */   }
/*     */   
/*     */   private void get32(long[] dst, int offset, int length) {
/* 519 */     CheckIntrinsics.checkFromIndexSize(offset, length, dst.length);
/* 520 */     if (remaining() < length) {
/* 521 */       throw new BufferUnderflowException();
/*     */     }
/* 523 */     for (int i = offset, end = offset + length; i < end; i++) {
/* 524 */       dst[i] = get();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PointerBuffer put(long[] src) {
/* 542 */     return put(src, 0, src.length);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public PointerBuffer put(long[] src, int offset, int length) {
/* 573 */     if (BITS64) {
/* 574 */       MemoryUtil.memLongBuffer(address(), remaining()).put(src, offset, length);
/* 575 */       position(position() + length);
/*     */     } else {
/* 577 */       put32(src, offset, length);
/*     */     } 
/*     */     
/* 580 */     return this;
/*     */   }
/*     */   
/*     */   private void put32(long[] src, int offset, int length) {
/* 584 */     CheckIntrinsics.checkFromIndexSize(offset, length, src.length);
/* 585 */     if (remaining() < length) {
/* 586 */       throw new BufferOverflowException();
/*     */     }
/* 588 */     int end = offset + length;
/* 589 */     for (int i = offset; i < end; i++) {
/* 590 */       put(src[i]);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 606 */     int h = 1;
/* 607 */     int p = position();
/* 608 */     for (int i = limit() - 1; i >= p; i--) {
/* 609 */       h = 31 * h + (int)get(i);
/*     */     }
/* 611 */     return h;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 634 */     if (!(ob instanceof PointerBuffer)) {
/* 635 */       return false;
/*     */     }
/* 637 */     PointerBuffer that = (PointerBuffer)ob;
/* 638 */     if (remaining() != that.remaining()) {
/* 639 */       return false;
/*     */     }
/* 641 */     int p = position();
/* 642 */     for (int i = limit() - 1, j = that.limit() - 1; i >= p; i--, j--) {
/* 643 */       long v1 = get(i);
/* 644 */       long v2 = that.get(j);
/* 645 */       if (v1 != v2) {
/* 646 */         return false;
/*     */       }
/*     */     } 
/* 649 */     return true;
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
/*     */   public int compareTo(PointerBuffer that) {
/* 664 */     int n = position() + Math.min(remaining(), that.remaining());
/* 665 */     for (int i = position(), j = that.position(); i < n; ) {
/* 666 */       long v1 = get(i);
/* 667 */       long v2 = that.get(j);
/* 668 */       if (v1 == v2) {
/*     */         i++; j++; continue;
/*     */       } 
/* 671 */       if (v1 < v2) {
/* 672 */         return -1;
/*     */       }
/* 674 */       return 1;
/*     */     } 
/* 676 */     return remaining() - that.remaining();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\PointerBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */