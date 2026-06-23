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
/*     */ 
/*     */ @NativeType("struct io_uring_zcrx_rqe")
/*     */ public class IOURingZCRXRQE
/*     */   extends Struct<IOURingZCRXRQE>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int OFF;
/*     */   public static final int LEN;
/*     */   public static final int __PAD;
/*     */   
/*     */   static {
/*  42 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  43 */           __member(8), 
/*  44 */           __member(4), 
/*  45 */           __member(4)
/*     */         });
/*     */     
/*  48 */     SIZEOF = layout.getSize();
/*  49 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  51 */     OFF = layout.offsetof(0);
/*  52 */     LEN = layout.offsetof(1);
/*  53 */     __PAD = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected IOURingZCRXRQE(long address, ByteBuffer container) {
/*  57 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingZCRXRQE create(long address, ByteBuffer container) {
/*  62 */     return new IOURingZCRXRQE(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingZCRXRQE(ByteBuffer container) {
/*  72 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  76 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u64")
/*     */   public long off() {
/*  80 */     return noff(address());
/*     */   } @NativeType("__u32")
/*     */   public int len() {
/*  83 */     return nlen(address());
/*     */   }
/*     */   public IOURingZCRXRQE off(@NativeType("__u64") long value) {
/*  86 */     noff(address(), value); return this;
/*     */   } public IOURingZCRXRQE len(@NativeType("__u32") int value) {
/*  88 */     nlen(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingZCRXRQE set(long off, int len) {
/*  95 */     off(off);
/*  96 */     len(len);
/*     */     
/*  98 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingZCRXRQE set(IOURingZCRXRQE src) {
/* 109 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 110 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingZCRXRQE malloc() {
/* 117 */     return new IOURingZCRXRQE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXRQE calloc() {
/* 122 */     return new IOURingZCRXRQE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXRQE create() {
/* 127 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 128 */     return new IOURingZCRXRQE(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXRQE create(long address) {
/* 133 */     return new IOURingZCRXRQE(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXRQE createSafe(long address) {
/* 138 */     return (address == 0L) ? null : new IOURingZCRXRQE(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 147 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 156 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 165 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 166 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 176 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 181 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingZCRXRQE malloc(MemoryStack stack) {
/* 190 */     return new IOURingZCRXRQE(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingZCRXRQE calloc(MemoryStack stack) {
/* 199 */     return new IOURingZCRXRQE(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 209 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 219 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long noff(long struct) {
/* 225 */     return MemoryUtil.memGetLong(struct + OFF);
/*     */   }
/* 227 */   public static int nlen(long struct) { return MemoryUtil.memGetInt(struct + LEN); } public static int n__pad(long struct) {
/* 228 */     return MemoryUtil.memGetInt(struct + __PAD);
/*     */   }
/*     */   public static void noff(long struct, long value) {
/* 231 */     MemoryUtil.memPutLong(struct + OFF, value);
/*     */   }
/* 233 */   public static void nlen(long struct, int value) { MemoryUtil.memPutInt(struct + LEN, value); } public static void n__pad(long struct, int value) {
/* 234 */     MemoryUtil.memPutInt(struct + __PAD, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingZCRXRQE, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 241 */     private static final IOURingZCRXRQE ELEMENT_FACTORY = IOURingZCRXRQE.create(-1L);
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
/* 253 */       super(container, container.remaining() / IOURingZCRXRQE.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 257 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 261 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 266 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 271 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingZCRXRQE getElementFactory() {
/* 276 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long off() {
/* 281 */       return IOURingZCRXRQE.noff(address());
/*     */     } @NativeType("__u32")
/*     */     public int len() {
/* 284 */       return IOURingZCRXRQE.nlen(address());
/*     */     }
/*     */     public Buffer off(@NativeType("__u64") long value) {
/* 287 */       IOURingZCRXRQE.noff(address(), value); return this;
/*     */     } public Buffer len(@NativeType("__u32") int value) {
/* 289 */       IOURingZCRXRQE.nlen(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingZCRXRQE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */