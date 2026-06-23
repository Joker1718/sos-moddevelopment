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
/*     */ @NativeType("struct io_uring_cqe")
/*     */ public class IOURingCQE
/*     */   extends Struct<IOURingCQE>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int USER_DATA;
/*     */   public static final int RES;
/*     */   public static final int FLAGS;
/*     */   public static final int BIG_CQE;
/*     */   
/*     */   static {
/*  45 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  46 */           __member(8), 
/*  47 */           __member(4), 
/*  48 */           __member(4), 
/*  49 */           __array(8, 0)
/*     */         });
/*     */     
/*  52 */     SIZEOF = layout.getSize();
/*  53 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  55 */     USER_DATA = layout.offsetof(0);
/*  56 */     RES = layout.offsetof(1);
/*  57 */     FLAGS = layout.offsetof(2);
/*  58 */     BIG_CQE = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected IOURingCQE(long address, ByteBuffer container) {
/*  62 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingCQE create(long address, ByteBuffer container) {
/*  67 */     return new IOURingCQE(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingCQE(ByteBuffer container) {
/*  77 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  81 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u64")
/*     */   public long user_data() {
/*  85 */     return nuser_data(address());
/*     */   } @NativeType("__s32")
/*     */   public int res() {
/*  88 */     return nres(address());
/*     */   } @NativeType("__u32")
/*     */   public int flags() {
/*  91 */     return nflags(address());
/*     */   } @NativeType("__u64[0]")
/*     */   public LongBuffer big_cqe() {
/*  94 */     return nbig_cqe(address());
/*     */   } @NativeType("__u64")
/*     */   public long big_cqe(int index) {
/*  97 */     return nbig_cqe(address(), index);
/*     */   }
/*     */   public IOURingCQE user_data(@NativeType("__u64") long value) {
/* 100 */     nuser_data(address(), value); return this;
/*     */   } public IOURingCQE res(@NativeType("__s32") int value) {
/* 102 */     nres(address(), value); return this;
/*     */   } public IOURingCQE flags(@NativeType("__u32") int value) {
/* 104 */     nflags(address(), value); return this;
/*     */   } public IOURingCQE big_cqe(@NativeType("__u64[0]") LongBuffer value) {
/* 106 */     nbig_cqe(address(), value); return this;
/*     */   } public IOURingCQE big_cqe(int index, @NativeType("__u64") long value) {
/* 108 */     nbig_cqe(address(), index, value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingCQE set(long user_data, int res, int flags, LongBuffer big_cqe) {
/* 117 */     user_data(user_data);
/* 118 */     res(res);
/* 119 */     flags(flags);
/* 120 */     big_cqe(big_cqe);
/*     */     
/* 122 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingCQE set(IOURingCQE src) {
/* 133 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 134 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingCQE malloc() {
/* 141 */     return new IOURingCQE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingCQE calloc() {
/* 146 */     return new IOURingCQE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingCQE create() {
/* 151 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 152 */     return new IOURingCQE(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingCQE create(long address) {
/* 157 */     return new IOURingCQE(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingCQE createSafe(long address) {
/* 162 */     return (address == 0L) ? null : new IOURingCQE(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 171 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 180 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 189 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 190 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 200 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 205 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingCQE malloc(MemoryStack stack) {
/* 214 */     return new IOURingCQE(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingCQE calloc(MemoryStack stack) {
/* 223 */     return new IOURingCQE(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 233 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 243 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nuser_data(long struct) {
/* 249 */     return MemoryUtil.memGetLong(struct + USER_DATA);
/*     */   } public static int nres(long struct) {
/* 251 */     return MemoryUtil.memGetInt(struct + RES);
/*     */   } public static int nflags(long struct) {
/* 253 */     return MemoryUtil.memGetInt(struct + FLAGS);
/*     */   } public static LongBuffer nbig_cqe(long struct) {
/* 255 */     return MemoryUtil.memLongBuffer(struct + BIG_CQE, 0);
/*     */   }
/*     */   public static long nbig_cqe(long struct, int index) {
/* 258 */     return MemoryUtil.memGetLong(struct + BIG_CQE + Checks.check(index, 0) * 8L);
/*     */   }
/*     */   
/*     */   public static void nuser_data(long struct, long value) {
/* 262 */     MemoryUtil.memPutLong(struct + USER_DATA, value);
/*     */   } public static void nres(long struct, int value) {
/* 264 */     MemoryUtil.memPutInt(struct + RES, value);
/*     */   } public static void nflags(long struct, int value) {
/* 266 */     MemoryUtil.memPutInt(struct + FLAGS, value);
/*     */   }
/*     */   public static void nbig_cqe(long struct, LongBuffer value) {
/* 269 */     if (Checks.CHECKS) Checks.checkGT(value, 0); 
/* 270 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + BIG_CQE, (value.remaining() * 8));
/*     */   }
/*     */   
/*     */   public static void nbig_cqe(long struct, int index, long value) {
/* 274 */     MemoryUtil.memPutLong(struct + BIG_CQE + Checks.check(index, 0) * 8L, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingCQE, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 282 */     private static final IOURingCQE ELEMENT_FACTORY = IOURingCQE.create(-1L);
/*     */ 
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
/* 294 */       super(container, container.remaining() / IOURingCQE.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 298 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 302 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 307 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 312 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingCQE getElementFactory() {
/* 317 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long user_data() {
/* 322 */       return IOURingCQE.nuser_data(address());
/*     */     } @NativeType("__s32")
/*     */     public int res() {
/* 325 */       return IOURingCQE.nres(address());
/*     */     } @NativeType("__u32")
/*     */     public int flags() {
/* 328 */       return IOURingCQE.nflags(address());
/*     */     } @NativeType("__u64[0]")
/*     */     public LongBuffer big_cqe() {
/* 331 */       return IOURingCQE.nbig_cqe(address());
/*     */     } @NativeType("__u64")
/*     */     public long big_cqe(int index) {
/* 334 */       return IOURingCQE.nbig_cqe(address(), index);
/*     */     }
/*     */     public Buffer user_data(@NativeType("__u64") long value) {
/* 337 */       IOURingCQE.nuser_data(address(), value); return this;
/*     */     } public Buffer res(@NativeType("__s32") int value) {
/* 339 */       IOURingCQE.nres(address(), value); return this;
/*     */     } public Buffer flags(@NativeType("__u32") int value) {
/* 341 */       IOURingCQE.nflags(address(), value); return this;
/*     */     } public Buffer big_cqe(@NativeType("__u64[0]") LongBuffer value) {
/* 343 */       IOURingCQE.nbig_cqe(address(), value); return this;
/*     */     } public Buffer big_cqe(int index, @NativeType("__u64") long value) {
/* 345 */       IOURingCQE.nbig_cqe(address(), index, value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingCQE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */