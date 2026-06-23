/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.util.function.Consumer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct io_uring_zcrx_ifq_reg")
/*     */ public class IOURingZCRXIfqReg
/*     */   extends Struct<IOURingZCRXIfqReg>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int IF_IDX;
/*     */   public static final int IF_RXQ;
/*     */   public static final int RQ_ENTRIES;
/*     */   public static final int FLAGS;
/*     */   public static final int AREA_PTR;
/*     */   public static final int REGION_PTR;
/*     */   public static final int OFFSETS;
/*     */   public static final int ZCRX_ID;
/*     */   public static final int __RESV2;
/*     */   public static final int __RESV;
/*     */   
/*     */   static {
/*  57 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  58 */           __member(4), 
/*  59 */           __member(4), 
/*  60 */           __member(4), 
/*  61 */           __member(4), 
/*  62 */           __member(8), 
/*  63 */           __member(8), 
/*  64 */           __member(IOURingZCRXOffsets.SIZEOF, IOURingZCRXOffsets.ALIGNOF), 
/*  65 */           __member(4), 
/*  66 */           __member(4), 
/*  67 */           __array(8, 3)
/*     */         });
/*     */     
/*  70 */     SIZEOF = layout.getSize();
/*  71 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  73 */     IF_IDX = layout.offsetof(0);
/*  74 */     IF_RXQ = layout.offsetof(1);
/*  75 */     RQ_ENTRIES = layout.offsetof(2);
/*  76 */     FLAGS = layout.offsetof(3);
/*  77 */     AREA_PTR = layout.offsetof(4);
/*  78 */     REGION_PTR = layout.offsetof(5);
/*  79 */     OFFSETS = layout.offsetof(6);
/*  80 */     ZCRX_ID = layout.offsetof(7);
/*  81 */     __RESV2 = layout.offsetof(8);
/*  82 */     __RESV = layout.offsetof(9);
/*     */   }
/*     */   
/*     */   protected IOURingZCRXIfqReg(long address, ByteBuffer container) {
/*  86 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingZCRXIfqReg create(long address, ByteBuffer container) {
/*  91 */     return new IOURingZCRXIfqReg(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingZCRXIfqReg(ByteBuffer container) {
/* 101 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 105 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int if_idx() {
/* 109 */     return nif_idx(address());
/*     */   } @NativeType("__u32")
/*     */   public int if_rxq() {
/* 112 */     return nif_rxq(address());
/*     */   } @NativeType("__u32")
/*     */   public int rq_entries() {
/* 115 */     return nrq_entries(address());
/*     */   } @NativeType("__u32")
/*     */   public int flags() {
/* 118 */     return nflags(address());
/*     */   } @NativeType("__u64")
/*     */   public long area_ptr() {
/* 121 */     return narea_ptr(address());
/*     */   } @NativeType("__u64")
/*     */   public long region_ptr() {
/* 124 */     return nregion_ptr(address());
/*     */   } @NativeType("struct io_uring_zcrx_offsets")
/*     */   public IOURingZCRXOffsets offsets() {
/* 127 */     return noffsets(address());
/*     */   } @NativeType("__u32")
/*     */   public int zcrx_id() {
/* 130 */     return nzcrx_id(address());
/*     */   }
/*     */   public IOURingZCRXIfqReg if_idx(@NativeType("__u32") int value) {
/* 133 */     nif_idx(address(), value); return this;
/*     */   } public IOURingZCRXIfqReg if_rxq(@NativeType("__u32") int value) {
/* 135 */     nif_rxq(address(), value); return this;
/*     */   } public IOURingZCRXIfqReg rq_entries(@NativeType("__u32") int value) {
/* 137 */     nrq_entries(address(), value); return this;
/*     */   } public IOURingZCRXIfqReg flags(@NativeType("__u32") int value) {
/* 139 */     nflags(address(), value); return this;
/*     */   } public IOURingZCRXIfqReg area_ptr(@NativeType("__u64") long value) {
/* 141 */     narea_ptr(address(), value); return this;
/*     */   } public IOURingZCRXIfqReg region_ptr(@NativeType("__u64") long value) {
/* 143 */     nregion_ptr(address(), value); return this;
/*     */   } public IOURingZCRXIfqReg offsets(@NativeType("struct io_uring_zcrx_offsets") IOURingZCRXOffsets value) {
/* 145 */     noffsets(address(), value); return this;
/*     */   } public IOURingZCRXIfqReg offsets(Consumer<IOURingZCRXOffsets> consumer) {
/* 147 */     consumer.accept(offsets()); return this;
/*     */   } public IOURingZCRXIfqReg zcrx_id(@NativeType("__u32") int value) {
/* 149 */     nzcrx_id(address(), value); return this;
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
/*     */   public IOURingZCRXIfqReg set(int if_idx, int if_rxq, int rq_entries, int flags, long area_ptr, long region_ptr, IOURingZCRXOffsets offsets, int zcrx_id) {
/* 162 */     if_idx(if_idx);
/* 163 */     if_rxq(if_rxq);
/* 164 */     rq_entries(rq_entries);
/* 165 */     flags(flags);
/* 166 */     area_ptr(area_ptr);
/* 167 */     region_ptr(region_ptr);
/* 168 */     offsets(offsets);
/* 169 */     zcrx_id(zcrx_id);
/*     */     
/* 171 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingZCRXIfqReg set(IOURingZCRXIfqReg src) {
/* 182 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 183 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingZCRXIfqReg malloc() {
/* 190 */     return new IOURingZCRXIfqReg(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXIfqReg calloc() {
/* 195 */     return new IOURingZCRXIfqReg(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXIfqReg create() {
/* 200 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 201 */     return new IOURingZCRXIfqReg(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXIfqReg create(long address) {
/* 206 */     return new IOURingZCRXIfqReg(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXIfqReg createSafe(long address) {
/* 211 */     return (address == 0L) ? null : new IOURingZCRXIfqReg(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 220 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 229 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 238 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 239 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 249 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 254 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingZCRXIfqReg malloc(MemoryStack stack) {
/* 263 */     return new IOURingZCRXIfqReg(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingZCRXIfqReg calloc(MemoryStack stack) {
/* 272 */     return new IOURingZCRXIfqReg(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 282 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 292 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nif_idx(long struct) {
/* 298 */     return MemoryUtil.memGetInt(struct + IF_IDX);
/*     */   } public static int nif_rxq(long struct) {
/* 300 */     return MemoryUtil.memGetInt(struct + IF_RXQ);
/*     */   } public static int nrq_entries(long struct) {
/* 302 */     return MemoryUtil.memGetInt(struct + RQ_ENTRIES);
/*     */   } public static int nflags(long struct) {
/* 304 */     return MemoryUtil.memGetInt(struct + FLAGS);
/*     */   } public static long narea_ptr(long struct) {
/* 306 */     return MemoryUtil.memGetLong(struct + AREA_PTR);
/*     */   } public static long nregion_ptr(long struct) {
/* 308 */     return MemoryUtil.memGetLong(struct + REGION_PTR);
/*     */   } public static IOURingZCRXOffsets noffsets(long struct) {
/* 310 */     return IOURingZCRXOffsets.create(struct + OFFSETS);
/*     */   }
/* 312 */   public static int nzcrx_id(long struct) { return MemoryUtil.memGetInt(struct + ZCRX_ID); }
/* 313 */   public static int n__resv2(long struct) { return MemoryUtil.memGetInt(struct + __RESV2); } public static LongBuffer n__resv(long struct) {
/* 314 */     return MemoryUtil.memLongBuffer(struct + __RESV, 3);
/*     */   } public static long n__resv(long struct, int index) {
/* 316 */     return MemoryUtil.memGetLong(struct + __RESV + Checks.check(index, 3) * 8L);
/*     */   }
/*     */   
/*     */   public static void nif_idx(long struct, int value) {
/* 320 */     MemoryUtil.memPutInt(struct + IF_IDX, value);
/*     */   } public static void nif_rxq(long struct, int value) {
/* 322 */     MemoryUtil.memPutInt(struct + IF_RXQ, value);
/*     */   } public static void nrq_entries(long struct, int value) {
/* 324 */     MemoryUtil.memPutInt(struct + RQ_ENTRIES, value);
/*     */   } public static void nflags(long struct, int value) {
/* 326 */     MemoryUtil.memPutInt(struct + FLAGS, value);
/*     */   } public static void narea_ptr(long struct, long value) {
/* 328 */     MemoryUtil.memPutLong(struct + AREA_PTR, value);
/*     */   } public static void nregion_ptr(long struct, long value) {
/* 330 */     MemoryUtil.memPutLong(struct + REGION_PTR, value);
/*     */   } public static void noffsets(long struct, IOURingZCRXOffsets value) {
/* 332 */     MemoryUtil.memCopy(value.address(), struct + OFFSETS, IOURingZCRXOffsets.SIZEOF);
/*     */   }
/* 334 */   public static void nzcrx_id(long struct, int value) { MemoryUtil.memPutInt(struct + ZCRX_ID, value); } public static void n__resv2(long struct, int value) {
/* 335 */     MemoryUtil.memPutInt(struct + __RESV2, value);
/*     */   } public static void n__resv(long struct, LongBuffer value) {
/* 337 */     if (Checks.CHECKS) Checks.checkGT(value, 3); 
/* 338 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + __RESV, (value.remaining() * 8));
/*     */   }
/*     */   public static void n__resv(long struct, int index, long value) {
/* 341 */     MemoryUtil.memPutLong(struct + __RESV + Checks.check(index, 3) * 8L, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingZCRXIfqReg, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 349 */     private static final IOURingZCRXIfqReg ELEMENT_FACTORY = IOURingZCRXIfqReg.create(-1L);
/*     */ 
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
/* 361 */       super(container, container.remaining() / IOURingZCRXIfqReg.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 365 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 369 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 374 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 379 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingZCRXIfqReg getElementFactory() {
/* 384 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int if_idx() {
/* 389 */       return IOURingZCRXIfqReg.nif_idx(address());
/*     */     } @NativeType("__u32")
/*     */     public int if_rxq() {
/* 392 */       return IOURingZCRXIfqReg.nif_rxq(address());
/*     */     } @NativeType("__u32")
/*     */     public int rq_entries() {
/* 395 */       return IOURingZCRXIfqReg.nrq_entries(address());
/*     */     } @NativeType("__u32")
/*     */     public int flags() {
/* 398 */       return IOURingZCRXIfqReg.nflags(address());
/*     */     } @NativeType("__u64")
/*     */     public long area_ptr() {
/* 401 */       return IOURingZCRXIfqReg.narea_ptr(address());
/*     */     } @NativeType("__u64")
/*     */     public long region_ptr() {
/* 404 */       return IOURingZCRXIfqReg.nregion_ptr(address());
/*     */     } @NativeType("struct io_uring_zcrx_offsets")
/*     */     public IOURingZCRXOffsets offsets() {
/* 407 */       return IOURingZCRXIfqReg.noffsets(address());
/*     */     } @NativeType("__u32")
/*     */     public int zcrx_id() {
/* 410 */       return IOURingZCRXIfqReg.nzcrx_id(address());
/*     */     }
/*     */     public Buffer if_idx(@NativeType("__u32") int value) {
/* 413 */       IOURingZCRXIfqReg.nif_idx(address(), value); return this;
/*     */     } public Buffer if_rxq(@NativeType("__u32") int value) {
/* 415 */       IOURingZCRXIfqReg.nif_rxq(address(), value); return this;
/*     */     } public Buffer rq_entries(@NativeType("__u32") int value) {
/* 417 */       IOURingZCRXIfqReg.nrq_entries(address(), value); return this;
/*     */     } public Buffer flags(@NativeType("__u32") int value) {
/* 419 */       IOURingZCRXIfqReg.nflags(address(), value); return this;
/*     */     } public Buffer area_ptr(@NativeType("__u64") long value) {
/* 421 */       IOURingZCRXIfqReg.narea_ptr(address(), value); return this;
/*     */     } public Buffer region_ptr(@NativeType("__u64") long value) {
/* 423 */       IOURingZCRXIfqReg.nregion_ptr(address(), value); return this;
/*     */     } public Buffer offsets(@NativeType("struct io_uring_zcrx_offsets") IOURingZCRXOffsets value) {
/* 425 */       IOURingZCRXIfqReg.noffsets(address(), value); return this;
/*     */     } public Buffer offsets(Consumer<IOURingZCRXOffsets> consumer) {
/* 427 */       consumer.accept(offsets()); return this;
/*     */     } public Buffer zcrx_id(@NativeType("__u32") int value) {
/* 429 */       IOURingZCRXIfqReg.nzcrx_id(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingZCRXIfqReg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */