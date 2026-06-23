/*     */ package org.lwjgl;
/*     */ 
/*     */ import java.nio.BufferOverflowException;
/*     */ import java.nio.BufferUnderflowException;
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.CheckIntrinsics;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryUtil;
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
/*     */ public class CLongBuffer
/*     */   extends CustomBuffer<CLongBuffer>
/*     */   implements Comparable<CLongBuffer>
/*     */ {
/*     */   protected CLongBuffer(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/*  25 */     super(address, container, mark, position, limit, capacity);
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
/*     */   public static CLongBuffer allocateDirect(int capacity) {
/*  40 */     ByteBuffer source = BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(capacity, CLONG_SHIFT));
/*  41 */     return new CLongBuffer(MemoryUtil.memAddress(source), source, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CLongBuffer create(long address, int capacity) {
/*  51 */     return new CLongBuffer(address, null, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CLongBuffer create(ByteBuffer source) {
/*  60 */     int capacity = source.remaining() >> CLONG_SHIFT;
/*  61 */     return new CLongBuffer(MemoryUtil.memAddress(source), source, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   protected CLongBuffer self() {
/*  66 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CLongBuffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/*  71 */     return new CLongBuffer(address, container, mark, position, limit, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public int sizeof() {
/*  76 */     return CLONG_SIZE;
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
/*  87 */     return MemoryUtil.memGetCLong(this.address + Integer.toUnsignedLong(nextGetIndex()) * CLONG_SIZE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long get(ByteBuffer source) {
/*  96 */     if (source.remaining() < CLONG_SIZE) {
/*  97 */       throw new BufferUnderflowException();
/*     */     }
/*     */     
/*     */     try {
/* 101 */       return MemoryUtil.memGetCLong(MemoryUtil.memAddress(source));
/*     */     } finally {
/* 103 */       source.position(source.position() + CLONG_SIZE);
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
/*     */   public CLongBuffer put(long p) {
/* 119 */     MemoryUtil.memPutCLong(this.address + Integer.toUnsignedLong(nextPutIndex()) * CLONG_SIZE, p);
/* 120 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void put(ByteBuffer target, long p) {
/* 130 */     if (target.remaining() < CLONG_SIZE) {
/* 131 */       throw new BufferOverflowException();
/*     */     }
/*     */     
/*     */     try {
/* 135 */       MemoryUtil.memPutCLong(MemoryUtil.memAddress(target), p);
/*     */     } finally {
/* 137 */       target.position(target.position() + CLONG_SIZE);
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
/* 151 */     return MemoryUtil.memGetCLong(this.address + Checks.check(index, this.limit) * CLONG_SIZE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long get(ByteBuffer source, int index) {
/* 161 */     CheckIntrinsics.checkFromIndexSize(index, CLONG_SIZE, source.limit());
/* 162 */     return MemoryUtil.memGetCLong(MemoryUtil.memAddress0(source) + index);
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
/*     */   public CLongBuffer put(int index, long p) {
/* 178 */     MemoryUtil.memPutCLong(this.address + Checks.check(index, this.limit) * CLONG_SIZE, p);
/* 179 */     return this;
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
/* 190 */     CheckIntrinsics.checkFromIndexSize(index, CLONG_SIZE, target.limit());
/* 191 */     MemoryUtil.memPutCLong(MemoryUtil.memAddress0(target) + index, p);
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
/*     */   public CLongBuffer get(long[] dst) {
/* 210 */     return get(dst, 0, dst.length);
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
/*     */   public CLongBuffer get(long[] dst, int offset, int length) {
/* 241 */     if (CLONG_SIZE == 8) {
/* 242 */       MemoryUtil.memLongBuffer(address(), remaining()).get(dst, offset, length);
/* 243 */       position(position() + length);
/*     */     } else {
/* 245 */       get32(dst, offset, length);
/*     */     } 
/*     */     
/* 248 */     return this;
/*     */   }
/*     */   
/*     */   private void get32(long[] dst, int offset, int length) {
/* 252 */     CheckIntrinsics.checkFromIndexSize(offset, length, dst.length);
/* 253 */     if (remaining() < length) {
/* 254 */       throw new BufferUnderflowException();
/*     */     }
/* 256 */     for (int i = offset, end = offset + length; i < end; i++) {
/* 257 */       dst[i] = get();
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
/*     */   public CLongBuffer put(long[] src) {
/* 275 */     return put(src, 0, src.length);
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
/*     */   public CLongBuffer put(long[] src, int offset, int length) {
/* 306 */     if (CLONG_SIZE == 8) {
/* 307 */       MemoryUtil.memLongBuffer(address(), remaining()).put(src, offset, length);
/* 308 */       position(position() + length);
/*     */     } else {
/* 310 */       put32(src, offset, length);
/*     */     } 
/*     */     
/* 313 */     return this;
/*     */   }
/*     */   
/*     */   private void put32(long[] src, int offset, int length) {
/* 317 */     CheckIntrinsics.checkFromIndexSize(offset, length, src.length);
/* 318 */     if (remaining() < length) {
/* 319 */       throw new BufferOverflowException();
/*     */     }
/* 321 */     int end = offset + length;
/* 322 */     for (int i = offset; i < end; i++) {
/* 323 */       put(src[i]);
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
/* 339 */     int h = 1;
/* 340 */     int p = position();
/* 341 */     for (int i = limit() - 1; i >= p; i--) {
/* 342 */       h = 31 * h + (int)get(i);
/*     */     }
/* 344 */     return h;
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
/* 367 */     if (!(ob instanceof CLongBuffer)) {
/* 368 */       return false;
/*     */     }
/* 370 */     CLongBuffer that = (CLongBuffer)ob;
/* 371 */     if (remaining() != that.remaining()) {
/* 372 */       return false;
/*     */     }
/* 374 */     int p = position();
/* 375 */     for (int i = limit() - 1, j = that.limit() - 1; i >= p; i--, j--) {
/* 376 */       long v1 = get(i);
/* 377 */       long v2 = that.get(j);
/* 378 */       if (v1 != v2) {
/* 379 */         return false;
/*     */       }
/*     */     } 
/* 382 */     return true;
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
/*     */   public int compareTo(CLongBuffer that) {
/* 397 */     int n = position() + Math.min(remaining(), that.remaining());
/* 398 */     for (int i = position(), j = that.position(); i < n; ) {
/* 399 */       long v1 = get(i);
/* 400 */       long v2 = that.get(j);
/* 401 */       if (v1 == v2) {
/*     */         i++; j++; continue;
/*     */       } 
/* 404 */       if (v1 < v2) {
/* 405 */         return -1;
/*     */       }
/* 407 */       return 1;
/*     */     } 
/* 409 */     return remaining() - that.remaining();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\CLongBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */