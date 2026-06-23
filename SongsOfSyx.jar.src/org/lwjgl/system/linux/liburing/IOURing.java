/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
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
/*     */ @NativeType("struct io_uring")
/*     */ public class IOURing
/*     */   extends Struct<IOURing>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int SQ;
/*     */   public static final int CQ;
/*     */   public static final int FLAGS;
/*     */   public static final int RING_FD;
/*     */   public static final int FEATURES;
/*     */   public static final int ENTER_RING_FD;
/*     */   public static final int INT_FLAGS;
/*     */   public static final int PAD;
/*     */   public static final int PAD2;
/*     */   
/*     */   static {
/*  55 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  56 */           __member(IOURingSQ.SIZEOF, IOURingSQ.ALIGNOF), 
/*  57 */           __member(IOURingCQ.SIZEOF, IOURingCQ.ALIGNOF), 
/*  58 */           __member(4), 
/*  59 */           __member(4), 
/*  60 */           __member(4), 
/*  61 */           __member(4), 
/*  62 */           __member(1), 
/*  63 */           __array(1, 3), 
/*  64 */           __member(4)
/*     */         });
/*     */     
/*  67 */     SIZEOF = layout.getSize();
/*  68 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  70 */     SQ = layout.offsetof(0);
/*  71 */     CQ = layout.offsetof(1);
/*  72 */     FLAGS = layout.offsetof(2);
/*  73 */     RING_FD = layout.offsetof(3);
/*  74 */     FEATURES = layout.offsetof(4);
/*  75 */     ENTER_RING_FD = layout.offsetof(5);
/*  76 */     INT_FLAGS = layout.offsetof(6);
/*  77 */     PAD = layout.offsetof(7);
/*  78 */     PAD2 = layout.offsetof(8);
/*     */   }
/*     */   
/*     */   protected IOURing(long address, ByteBuffer container) {
/*  82 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURing create(long address, ByteBuffer container) {
/*  87 */     return new IOURing(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURing(ByteBuffer container) {
/*  97 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 101 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("struct io_uring_sq")
/*     */   public IOURingSQ sq() {
/* 105 */     return nsq(address());
/*     */   } @NativeType("struct io_uring_cq")
/*     */   public IOURingCQ cq() {
/* 108 */     return ncq(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int flags() {
/* 111 */     return nflags(address());
/*     */   } public int ring_fd() {
/* 113 */     return nring_fd(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int features() {
/* 116 */     return nfeatures(address());
/*     */   } public int enter_ring_fd() {
/* 118 */     return nenter_ring_fd(address());
/*     */   } @NativeType("__u8")
/*     */   public byte int_flags() {
/* 121 */     return nint_flags(address());
/*     */   }
/*     */   public IOURing sq(@NativeType("struct io_uring_sq") IOURingSQ value) {
/* 124 */     nsq(address(), value); return this;
/*     */   } public IOURing sq(Consumer<IOURingSQ> consumer) {
/* 126 */     consumer.accept(sq()); return this;
/*     */   } public IOURing cq(@NativeType("struct io_uring_cq") IOURingCQ value) {
/* 128 */     ncq(address(), value); return this;
/*     */   } public IOURing cq(Consumer<IOURingCQ> consumer) {
/* 130 */     consumer.accept(cq()); return this;
/*     */   } public IOURing flags(@NativeType("unsigned int") int value) {
/* 132 */     nflags(address(), value); return this;
/*     */   } public IOURing ring_fd(int value) {
/* 134 */     nring_fd(address(), value); return this;
/*     */   } public IOURing features(@NativeType("unsigned int") int value) {
/* 136 */     nfeatures(address(), value); return this;
/*     */   } public IOURing enter_ring_fd(int value) {
/* 138 */     nenter_ring_fd(address(), value); return this;
/*     */   } public IOURing int_flags(@NativeType("__u8") byte value) {
/* 140 */     nint_flags(address(), value); return this;
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
/*     */   public IOURing set(IOURingSQ sq, IOURingCQ cq, int flags, int ring_fd, int features, int enter_ring_fd, byte int_flags) {
/* 152 */     sq(sq);
/* 153 */     cq(cq);
/* 154 */     flags(flags);
/* 155 */     ring_fd(ring_fd);
/* 156 */     features(features);
/* 157 */     enter_ring_fd(enter_ring_fd);
/* 158 */     int_flags(int_flags);
/*     */     
/* 160 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURing set(IOURing src) {
/* 171 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 172 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURing malloc() {
/* 179 */     return new IOURing(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURing calloc() {
/* 184 */     return new IOURing(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURing create() {
/* 189 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 190 */     return new IOURing(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURing create(long address) {
/* 195 */     return new IOURing(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURing createSafe(long address) {
/* 200 */     return (address == 0L) ? null : new IOURing(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 209 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 218 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 227 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 228 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 238 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 243 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURing malloc(MemoryStack stack) {
/* 252 */     return new IOURing(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURing calloc(MemoryStack stack) {
/* 261 */     return new IOURing(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 271 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 281 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingSQ nsq(long struct) {
/* 287 */     return IOURingSQ.create(struct + SQ);
/*     */   } public static IOURingCQ ncq(long struct) {
/* 289 */     return IOURingCQ.create(struct + CQ);
/*     */   } public static int nflags(long struct) {
/* 291 */     return MemoryUtil.memGetInt(struct + FLAGS);
/*     */   } public static int nring_fd(long struct) {
/* 293 */     return MemoryUtil.memGetInt(struct + RING_FD);
/*     */   } public static int nfeatures(long struct) {
/* 295 */     return MemoryUtil.memGetInt(struct + FEATURES);
/*     */   } public static int nenter_ring_fd(long struct) {
/* 297 */     return MemoryUtil.memGetInt(struct + ENTER_RING_FD);
/*     */   }
/* 299 */   public static byte nint_flags(long struct) { return MemoryUtil.memGetByte(struct + INT_FLAGS); } public static ByteBuffer npad(long struct) {
/* 300 */     return MemoryUtil.memByteBuffer(struct + PAD, 3);
/*     */   } public static byte npad(long struct, int index) {
/* 302 */     return MemoryUtil.memGetByte(struct + PAD + Checks.check(index, 3) * 1L);
/*     */   } public static int npad2(long struct) {
/* 304 */     return MemoryUtil.memGetInt(struct + PAD2);
/*     */   }
/*     */   public static void nsq(long struct, IOURingSQ value) {
/* 307 */     MemoryUtil.memCopy(value.address(), struct + SQ, IOURingSQ.SIZEOF);
/*     */   } public static void ncq(long struct, IOURingCQ value) {
/* 309 */     MemoryUtil.memCopy(value.address(), struct + CQ, IOURingCQ.SIZEOF);
/*     */   } public static void nflags(long struct, int value) {
/* 311 */     MemoryUtil.memPutInt(struct + FLAGS, value);
/*     */   } public static void nring_fd(long struct, int value) {
/* 313 */     MemoryUtil.memPutInt(struct + RING_FD, value);
/*     */   } public static void nfeatures(long struct, int value) {
/* 315 */     MemoryUtil.memPutInt(struct + FEATURES, value);
/*     */   } public static void nenter_ring_fd(long struct, int value) {
/* 317 */     MemoryUtil.memPutInt(struct + ENTER_RING_FD, value);
/*     */   } public static void nint_flags(long struct, byte value) {
/* 319 */     MemoryUtil.memPutByte(struct + INT_FLAGS, value);
/*     */   } public static void npad(long struct, ByteBuffer value) {
/* 321 */     if (Checks.CHECKS) Checks.checkGT(value, 3); 
/* 322 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + PAD, (value.remaining() * 1));
/*     */   }
/*     */   public static void npad(long struct, int index, byte value) {
/* 325 */     MemoryUtil.memPutByte(struct + PAD + Checks.check(index, 3) * 1L, value);
/*     */   } public static void npad2(long struct, int value) {
/* 327 */     MemoryUtil.memPutInt(struct + PAD2, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 335 */     IOURingSQ.validate(struct + SQ);
/* 336 */     IOURingCQ.validate(struct + CQ);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURing, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 344 */     private static final IOURing ELEMENT_FACTORY = IOURing.create(-1L);
/*     */ 
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
/* 356 */       super(container, container.remaining() / IOURing.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 360 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 364 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 369 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 374 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURing getElementFactory() {
/* 379 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("struct io_uring_sq")
/*     */     public IOURingSQ sq() {
/* 384 */       return IOURing.nsq(address());
/*     */     } @NativeType("struct io_uring_cq")
/*     */     public IOURingCQ cq() {
/* 387 */       return IOURing.ncq(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int flags() {
/* 390 */       return IOURing.nflags(address());
/*     */     } public int ring_fd() {
/* 392 */       return IOURing.nring_fd(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int features() {
/* 395 */       return IOURing.nfeatures(address());
/*     */     } public int enter_ring_fd() {
/* 397 */       return IOURing.nenter_ring_fd(address());
/*     */     } @NativeType("__u8")
/*     */     public byte int_flags() {
/* 400 */       return IOURing.nint_flags(address());
/*     */     }
/*     */     public Buffer sq(@NativeType("struct io_uring_sq") IOURingSQ value) {
/* 403 */       IOURing.nsq(address(), value); return this;
/*     */     } public Buffer sq(Consumer<IOURingSQ> consumer) {
/* 405 */       consumer.accept(sq()); return this;
/*     */     } public Buffer cq(@NativeType("struct io_uring_cq") IOURingCQ value) {
/* 407 */       IOURing.ncq(address(), value); return this;
/*     */     } public Buffer cq(Consumer<IOURingCQ> consumer) {
/* 409 */       consumer.accept(cq()); return this;
/*     */     } public Buffer flags(@NativeType("unsigned int") int value) {
/* 411 */       IOURing.nflags(address(), value); return this;
/*     */     } public Buffer ring_fd(int value) {
/* 413 */       IOURing.nring_fd(address(), value); return this;
/*     */     } public Buffer features(@NativeType("unsigned int") int value) {
/* 415 */       IOURing.nfeatures(address(), value); return this;
/*     */     } public Buffer enter_ring_fd(int value) {
/* 417 */       IOURing.nenter_ring_fd(address(), value); return this;
/*     */     } public Buffer int_flags(@NativeType("__u8") byte value) {
/* 419 */       IOURing.nint_flags(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */