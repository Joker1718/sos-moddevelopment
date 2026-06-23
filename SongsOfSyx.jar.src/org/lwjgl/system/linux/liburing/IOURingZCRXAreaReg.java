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
/*     */ 
/*     */ @NativeType("struct io_uring_zcrx_area_reg")
/*     */ public class IOURingZCRXAreaReg
/*     */   extends Struct<IOURingZCRXAreaReg>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int ADDR;
/*     */   public static final int LEN;
/*     */   public static final int RQ_AREA_TOKEN;
/*     */   public static final int FLAGS;
/*     */   public static final int DMABUF_FD;
/*     */   public static final int __RESV2;
/*     */   
/*     */   static {
/*  49 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  50 */           __member(8), 
/*  51 */           __member(8), 
/*  52 */           __member(8), 
/*  53 */           __member(4), 
/*  54 */           __member(4), 
/*  55 */           __array(8, 2)
/*     */         });
/*     */     
/*  58 */     SIZEOF = layout.getSize();
/*  59 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  61 */     ADDR = layout.offsetof(0);
/*  62 */     LEN = layout.offsetof(1);
/*  63 */     RQ_AREA_TOKEN = layout.offsetof(2);
/*  64 */     FLAGS = layout.offsetof(3);
/*  65 */     DMABUF_FD = layout.offsetof(4);
/*  66 */     __RESV2 = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected IOURingZCRXAreaReg(long address, ByteBuffer container) {
/*  70 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingZCRXAreaReg create(long address, ByteBuffer container) {
/*  75 */     return new IOURingZCRXAreaReg(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingZCRXAreaReg(ByteBuffer container) {
/*  85 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  89 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u64")
/*     */   public long addr() {
/*  93 */     return naddr(address());
/*     */   } @NativeType("__u64")
/*     */   public long len() {
/*  96 */     return nlen(address());
/*     */   } @NativeType("__u64")
/*     */   public long rq_area_token() {
/*  99 */     return nrq_area_token(address());
/*     */   } @NativeType("__u32")
/*     */   public int flags() {
/* 102 */     return nflags(address());
/*     */   } @NativeType("__u32")
/*     */   public int dmabuf_fd() {
/* 105 */     return ndmabuf_fd(address());
/*     */   }
/*     */   public IOURingZCRXAreaReg addr(@NativeType("__u64") long value) {
/* 108 */     naddr(address(), value); return this;
/*     */   } public IOURingZCRXAreaReg len(@NativeType("__u64") long value) {
/* 110 */     nlen(address(), value); return this;
/*     */   } public IOURingZCRXAreaReg rq_area_token(@NativeType("__u64") long value) {
/* 112 */     nrq_area_token(address(), value); return this;
/*     */   } public IOURingZCRXAreaReg flags(@NativeType("__u32") int value) {
/* 114 */     nflags(address(), value); return this;
/*     */   } public IOURingZCRXAreaReg dmabuf_fd(@NativeType("__u32") int value) {
/* 116 */     ndmabuf_fd(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingZCRXAreaReg set(long addr, long len, long rq_area_token, int flags, int dmabuf_fd) {
/* 126 */     addr(addr);
/* 127 */     len(len);
/* 128 */     rq_area_token(rq_area_token);
/* 129 */     flags(flags);
/* 130 */     dmabuf_fd(dmabuf_fd);
/*     */     
/* 132 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingZCRXAreaReg set(IOURingZCRXAreaReg src) {
/* 143 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 144 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingZCRXAreaReg malloc() {
/* 151 */     return new IOURingZCRXAreaReg(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXAreaReg calloc() {
/* 156 */     return new IOURingZCRXAreaReg(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXAreaReg create() {
/* 161 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 162 */     return new IOURingZCRXAreaReg(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXAreaReg create(long address) {
/* 167 */     return new IOURingZCRXAreaReg(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXAreaReg createSafe(long address) {
/* 172 */     return (address == 0L) ? null : new IOURingZCRXAreaReg(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 181 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 190 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 199 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 200 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 210 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 215 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingZCRXAreaReg malloc(MemoryStack stack) {
/* 224 */     return new IOURingZCRXAreaReg(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingZCRXAreaReg calloc(MemoryStack stack) {
/* 233 */     return new IOURingZCRXAreaReg(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 243 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 253 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long naddr(long struct) {
/* 259 */     return MemoryUtil.memGetLong(struct + ADDR);
/*     */   } public static long nlen(long struct) {
/* 261 */     return MemoryUtil.memGetLong(struct + LEN);
/*     */   } public static long nrq_area_token(long struct) {
/* 263 */     return MemoryUtil.memGetLong(struct + RQ_AREA_TOKEN);
/*     */   } public static int nflags(long struct) {
/* 265 */     return MemoryUtil.memGetInt(struct + FLAGS);
/*     */   }
/* 267 */   public static int ndmabuf_fd(long struct) { return MemoryUtil.memGetInt(struct + DMABUF_FD); } public static LongBuffer n__resv2(long struct) {
/* 268 */     return MemoryUtil.memLongBuffer(struct + __RESV2, 2);
/*     */   } public static long n__resv2(long struct, int index) {
/* 270 */     return MemoryUtil.memGetLong(struct + __RESV2 + Checks.check(index, 2) * 8L);
/*     */   }
/*     */   
/*     */   public static void naddr(long struct, long value) {
/* 274 */     MemoryUtil.memPutLong(struct + ADDR, value);
/*     */   } public static void nlen(long struct, long value) {
/* 276 */     MemoryUtil.memPutLong(struct + LEN, value);
/*     */   } public static void nrq_area_token(long struct, long value) {
/* 278 */     MemoryUtil.memPutLong(struct + RQ_AREA_TOKEN, value);
/*     */   } public static void nflags(long struct, int value) {
/* 280 */     MemoryUtil.memPutInt(struct + FLAGS, value);
/*     */   } public static void ndmabuf_fd(long struct, int value) {
/* 282 */     MemoryUtil.memPutInt(struct + DMABUF_FD, value);
/*     */   } public static void n__resv2(long struct, LongBuffer value) {
/* 284 */     if (Checks.CHECKS) Checks.checkGT(value, 2); 
/* 285 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + __RESV2, (value.remaining() * 8));
/*     */   }
/*     */   public static void n__resv2(long struct, int index, long value) {
/* 288 */     MemoryUtil.memPutLong(struct + __RESV2 + Checks.check(index, 2) * 8L, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingZCRXAreaReg, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 296 */     private static final IOURingZCRXAreaReg ELEMENT_FACTORY = IOURingZCRXAreaReg.create(-1L);
/*     */ 
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
/* 308 */       super(container, container.remaining() / IOURingZCRXAreaReg.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 312 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 316 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 321 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 326 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingZCRXAreaReg getElementFactory() {
/* 331 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long addr() {
/* 336 */       return IOURingZCRXAreaReg.naddr(address());
/*     */     } @NativeType("__u64")
/*     */     public long len() {
/* 339 */       return IOURingZCRXAreaReg.nlen(address());
/*     */     } @NativeType("__u64")
/*     */     public long rq_area_token() {
/* 342 */       return IOURingZCRXAreaReg.nrq_area_token(address());
/*     */     } @NativeType("__u32")
/*     */     public int flags() {
/* 345 */       return IOURingZCRXAreaReg.nflags(address());
/*     */     } @NativeType("__u32")
/*     */     public int dmabuf_fd() {
/* 348 */       return IOURingZCRXAreaReg.ndmabuf_fd(address());
/*     */     }
/*     */     public Buffer addr(@NativeType("__u64") long value) {
/* 351 */       IOURingZCRXAreaReg.naddr(address(), value); return this;
/*     */     } public Buffer len(@NativeType("__u64") long value) {
/* 353 */       IOURingZCRXAreaReg.nlen(address(), value); return this;
/*     */     } public Buffer rq_area_token(@NativeType("__u64") long value) {
/* 355 */       IOURingZCRXAreaReg.nrq_area_token(address(), value); return this;
/*     */     } public Buffer flags(@NativeType("__u32") int value) {
/* 357 */       IOURingZCRXAreaReg.nflags(address(), value); return this;
/*     */     } public Buffer dmabuf_fd(@NativeType("__u32") int value) {
/* 359 */       IOURingZCRXAreaReg.ndmabuf_fd(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingZCRXAreaReg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */