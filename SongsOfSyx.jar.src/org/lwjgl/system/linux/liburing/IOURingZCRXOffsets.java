/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.system.Checks;
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
/*     */ 
/*     */ @NativeType("struct io_uring_zcrx_offsets")
/*     */ public class IOURingZCRXOffsets
/*     */   extends Struct<IOURingZCRXOffsets>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int HEAD;
/*     */   public static final int TAIL;
/*     */   public static final int RQES;
/*     */   public static final int __RESV2;
/*     */   public static final int __RESV;
/*     */   
/*     */   static {
/*  47 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  48 */           __member(4), 
/*  49 */           __member(4), 
/*  50 */           __member(4), 
/*  51 */           __member(4), 
/*  52 */           __array(8, 2)
/*     */         });
/*     */     
/*  55 */     SIZEOF = layout.getSize();
/*  56 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  58 */     HEAD = layout.offsetof(0);
/*  59 */     TAIL = layout.offsetof(1);
/*  60 */     RQES = layout.offsetof(2);
/*  61 */     __RESV2 = layout.offsetof(3);
/*  62 */     __RESV = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected IOURingZCRXOffsets(long address, ByteBuffer container) {
/*  66 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingZCRXOffsets create(long address, ByteBuffer container) {
/*  71 */     return new IOURingZCRXOffsets(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingZCRXOffsets(ByteBuffer container) {
/*  81 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  85 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int head() {
/*  89 */     return nhead(address());
/*     */   } @NativeType("__u32")
/*     */   public int tail() {
/*  92 */     return ntail(address());
/*     */   } @NativeType("__u32")
/*     */   public int rqes() {
/*  95 */     return nrqes(address());
/*     */   }
/*     */   public IOURingZCRXOffsets head(@NativeType("__u32") int value) {
/*  98 */     nhead(address(), value); return this;
/*     */   } public IOURingZCRXOffsets tail(@NativeType("__u32") int value) {
/* 100 */     ntail(address(), value); return this;
/*     */   } public IOURingZCRXOffsets rqes(@NativeType("__u32") int value) {
/* 102 */     nrqes(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingZCRXOffsets set(int head, int tail, int rqes) {
/* 110 */     head(head);
/* 111 */     tail(tail);
/* 112 */     rqes(rqes);
/*     */     
/* 114 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingZCRXOffsets set(IOURingZCRXOffsets src) {
/* 125 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 126 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingZCRXOffsets malloc() {
/* 133 */     return new IOURingZCRXOffsets(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXOffsets calloc() {
/* 138 */     return new IOURingZCRXOffsets(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXOffsets create() {
/* 143 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 144 */     return new IOURingZCRXOffsets(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXOffsets create(long address) {
/* 149 */     return new IOURingZCRXOffsets(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXOffsets createSafe(long address) {
/* 154 */     return (address == 0L) ? null : new IOURingZCRXOffsets(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 163 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 172 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 181 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 182 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 192 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 197 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingZCRXOffsets malloc(MemoryStack stack) {
/* 206 */     return new IOURingZCRXOffsets(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingZCRXOffsets calloc(MemoryStack stack) {
/* 215 */     return new IOURingZCRXOffsets(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 225 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 235 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nhead(long struct) {
/* 241 */     return MemoryUtil.memGetInt(struct + HEAD);
/*     */   } public static int ntail(long struct) {
/* 243 */     return MemoryUtil.memGetInt(struct + TAIL);
/*     */   }
/* 245 */   public static int nrqes(long struct) { return MemoryUtil.memGetInt(struct + RQES); }
/* 246 */   public static int n__resv2(long struct) { return MemoryUtil.memGetInt(struct + __RESV2); } public static LongBuffer n__resv(long struct) {
/* 247 */     return MemoryUtil.memLongBuffer(struct + __RESV, 2);
/*     */   } public static long n__resv(long struct, int index) {
/* 249 */     return MemoryUtil.memGetLong(struct + __RESV + Checks.check(index, 2) * 8L);
/*     */   }
/*     */   
/*     */   public static void nhead(long struct, int value) {
/* 253 */     MemoryUtil.memPutInt(struct + HEAD, value);
/*     */   } public static void ntail(long struct, int value) {
/* 255 */     MemoryUtil.memPutInt(struct + TAIL, value);
/*     */   }
/* 257 */   public static void nrqes(long struct, int value) { MemoryUtil.memPutInt(struct + RQES, value); } public static void n__resv2(long struct, int value) {
/* 258 */     MemoryUtil.memPutInt(struct + __RESV2, value);
/*     */   } public static void n__resv(long struct, LongBuffer value) {
/* 260 */     if (Checks.CHECKS) Checks.checkGT(value, 2); 
/* 261 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + __RESV, (value.remaining() * 8));
/*     */   }
/*     */   public static void n__resv(long struct, int index, long value) {
/* 264 */     MemoryUtil.memPutLong(struct + __RESV + Checks.check(index, 2) * 8L, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingZCRXOffsets, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 272 */     private static final IOURingZCRXOffsets ELEMENT_FACTORY = IOURingZCRXOffsets.create(-1L);
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
/* 284 */       super(container, container.remaining() / IOURingZCRXOffsets.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 288 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 292 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 297 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 302 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingZCRXOffsets getElementFactory() {
/* 307 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int head() {
/* 312 */       return IOURingZCRXOffsets.nhead(address());
/*     */     } @NativeType("__u32")
/*     */     public int tail() {
/* 315 */       return IOURingZCRXOffsets.ntail(address());
/*     */     } @NativeType("__u32")
/*     */     public int rqes() {
/* 318 */       return IOURingZCRXOffsets.nrqes(address());
/*     */     }
/*     */     public Buffer head(@NativeType("__u32") int value) {
/* 321 */       IOURingZCRXOffsets.nhead(address(), value); return this;
/*     */     } public Buffer tail(@NativeType("__u32") int value) {
/* 323 */       IOURingZCRXOffsets.ntail(address(), value); return this;
/*     */     } public Buffer rqes(@NativeType("__u32") int value) {
/* 325 */       IOURingZCRXOffsets.nrqes(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingZCRXOffsets.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */