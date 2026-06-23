/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Struct;
/*     */ import org.lwjgl.system.StructBuffer;
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
/*     */ @NativeType("struct io_uring_zcrx_cqe")
/*     */ public class IOURingZCRXCQE
/*     */   extends Struct<IOURingZCRXCQE>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int OFF;
/*     */   public static final int __PAD;
/*     */   
/*     */   static {
/*  40 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  41 */           __member(8), 
/*  42 */           __member(8)
/*     */         });
/*     */     
/*  45 */     SIZEOF = layout.getSize();
/*  46 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  48 */     OFF = layout.offsetof(0);
/*  49 */     __PAD = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected IOURingZCRXCQE(long address, ByteBuffer container) {
/*  53 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingZCRXCQE create(long address, ByteBuffer container) {
/*  58 */     return new IOURingZCRXCQE(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingZCRXCQE(ByteBuffer container) {
/*  68 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  72 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u64")
/*     */   public long off() {
/*  76 */     return noff(address());
/*     */   }
/*     */   public IOURingZCRXCQE off(@NativeType("__u64") long value) {
/*  79 */     noff(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingZCRXCQE set(IOURingZCRXCQE src) {
/*  89 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/*  90 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingZCRXCQE malloc() {
/*  97 */     return new IOURingZCRXCQE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXCQE calloc() {
/* 102 */     return new IOURingZCRXCQE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXCQE create() {
/* 107 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 108 */     return new IOURingZCRXCQE(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXCQE create(long address) {
/* 113 */     return new IOURingZCRXCQE(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXCQE createSafe(long address) {
/* 118 */     return (address == 0L) ? null : new IOURingZCRXCQE(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 127 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 136 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 145 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 146 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 156 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 161 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingZCRXCQE malloc(MemoryStack stack) {
/* 170 */     return new IOURingZCRXCQE(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingZCRXCQE calloc(MemoryStack stack) {
/* 179 */     return new IOURingZCRXCQE(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 189 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 199 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long noff(long struct) {
/* 205 */     return MemoryUtil.memGetLong(struct + OFF); } public static long n__pad(long struct) {
/* 206 */     return MemoryUtil.memGetLong(struct + __PAD);
/*     */   }
/*     */   
/* 209 */   public static void noff(long struct, long value) { MemoryUtil.memPutLong(struct + OFF, value); } public static void n__pad(long struct, long value) {
/* 210 */     MemoryUtil.memPutLong(struct + __PAD, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingZCRXCQE, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 217 */     private static final IOURingZCRXCQE ELEMENT_FACTORY = IOURingZCRXCQE.create(-1L);
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
/*     */     public Buffer(ByteBuffer container) {
/* 229 */       super(container, container.remaining() / IOURingZCRXCQE.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 233 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 237 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 242 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 247 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingZCRXCQE getElementFactory() {
/* 252 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long off() {
/* 257 */       return IOURingZCRXCQE.noff(address());
/*     */     }
/*     */     public Buffer off(@NativeType("__u64") long value) {
/* 260 */       IOURingZCRXCQE.noff(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingZCRXCQE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */