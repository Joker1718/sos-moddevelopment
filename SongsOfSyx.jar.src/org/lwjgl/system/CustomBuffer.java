/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.nio.BufferOverflowException;
/*     */ import java.nio.BufferUnderflowException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.InvalidMarkException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class CustomBuffer<SELF extends CustomBuffer<SELF>>
/*     */   extends Pointer.Default
/*     */ {
/*     */   protected ByteBuffer container;
/*     */   protected int mark;
/*     */   protected int position;
/*     */   protected int limit;
/*     */   protected int capacity;
/*     */   
/*     */   protected CustomBuffer(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/*  25 */     super(address);
/*     */     
/*  27 */     this.container = container;
/*     */     
/*  29 */     this.mark = mark;
/*  30 */     this.position = position;
/*  31 */     this.limit = limit;
/*  32 */     this.capacity = capacity;
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract int sizeof();
/*     */ 
/*     */   
/*     */   public long address0() {
/*  40 */     return this.address;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long address() {
/*  46 */     return this.address + Integer.toUnsignedLong(this.position) * sizeof();
/*     */   }
/*     */ 
/*     */   
/*     */   public long address(int position) {
/*  51 */     return this.address + Integer.toUnsignedLong(position) * sizeof();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void free() {
/*  60 */     MemoryUtil.nmemFree(this.address);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int capacity() {
/*  69 */     return this.capacity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int position() {
/*  78 */     return this.position;
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
/*     */   public SELF position(int position) {
/*  91 */     if (position < 0 || this.limit < position) {
/*  92 */       throw new IllegalArgumentException();
/*     */     }
/*  94 */     this.position = position;
/*  95 */     if (position < this.mark) {
/*  96 */       this.mark = -1;
/*     */     }
/*  98 */     return self();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int limit() {
/* 107 */     return this.limit;
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
/*     */   public SELF limit(int limit) {
/* 121 */     if (limit < 0 || this.capacity < limit) {
/* 122 */       throw new IllegalArgumentException();
/*     */     }
/* 124 */     this.limit = limit;
/* 125 */     if (limit < this.position) {
/* 126 */       this.position = limit;
/*     */     }
/* 128 */     if (limit < this.mark) {
/* 129 */       this.mark = -1;
/*     */     }
/* 131 */     return self();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SELF mark() {
/* 140 */     this.mark = this.position;
/* 141 */     return self();
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
/*     */   public SELF reset() {
/* 154 */     int m = this.mark;
/* 155 */     if (m < 0) {
/* 156 */       throw new InvalidMarkException();
/*     */     }
/* 158 */     this.position = m;
/* 159 */     return self();
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
/*     */   public SELF clear() {
/* 177 */     this.position = 0;
/* 178 */     this.limit = this.capacity;
/* 179 */     this.mark = -1;
/* 180 */     return self();
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
/*     */   public SELF flip() {
/* 200 */     this.limit = this.position;
/* 201 */     this.position = 0;
/* 202 */     this.mark = -1;
/* 203 */     return self();
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
/*     */   public SELF rewind() {
/* 220 */     this.position = 0;
/* 221 */     this.mark = -1;
/* 222 */     return self();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int remaining() {
/* 231 */     return this.limit - this.position;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasRemaining() {
/* 240 */     return (this.position < this.limit);
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
/*     */   public SELF slice() {
/* 255 */     return create(this.address + Integer.toUnsignedLong(this.position) * sizeof(), this.container, -1, 0, remaining(), remaining());
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
/*     */   public SELF slice(int offset, int capacity) {
/* 269 */     int position = this.position + offset;
/* 270 */     if (offset < 0 || this.limit < offset) {
/* 271 */       throw new IllegalArgumentException();
/*     */     }
/*     */     
/* 274 */     if (capacity < 0 || this.capacity - position < capacity) {
/* 275 */       throw new IllegalArgumentException();
/*     */     }
/*     */     
/* 278 */     return create(this.address + Integer.toUnsignedLong(position) * sizeof(), this.container, -1, 0, capacity, capacity);
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
/*     */   public SELF duplicate() {
/* 292 */     return create(this.address, this.container, this.mark, this.position, this.limit, this.capacity);
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
/*     */   
/*     */   public SELF put(SELF src) {
/* 324 */     if (src == this) {
/* 325 */       throw new IllegalArgumentException();
/*     */     }
/* 327 */     int n = src.remaining();
/* 328 */     if (remaining() < n) {
/* 329 */       throw new BufferOverflowException();
/*     */     }
/*     */     
/* 332 */     MemoryUtil.memCopy(src.address(), address(), Integer.toUnsignedLong(n) * sizeof());
/* 333 */     this.position += n;
/*     */     
/* 335 */     return self();
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
/*     */   public SELF compact() {
/* 355 */     MemoryUtil.memCopy(address(), this.address, Integer.toUnsignedLong(remaining()) * sizeof());
/* 356 */     position(remaining());
/* 357 */     limit(capacity());
/* 358 */     this.mark = -1;
/*     */     
/* 360 */     return self();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 369 */     return getClass().getName() + "[pos=" + position() + " lim=" + limit() + " cap=" + capacity() + "]";
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract SELF self();
/*     */ 
/*     */   
/*     */   protected abstract SELF create(long paramLong, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */   
/*     */   protected final int nextGetIndex() {
/* 379 */     if (this.position < this.limit) {
/* 380 */       return this.position++;
/*     */     }
/* 382 */     throw new BufferUnderflowException();
/*     */   }
/*     */   
/*     */   protected final int nextPutIndex() {
/* 386 */     if (this.position < this.limit) {
/* 387 */       return this.position++;
/*     */     }
/* 389 */     throw new BufferOverflowException();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\CustomBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */