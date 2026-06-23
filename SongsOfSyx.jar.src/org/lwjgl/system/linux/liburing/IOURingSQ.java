/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct io_uring_sq")
/*     */ public class IOURingSQ
/*     */   extends Struct<IOURingSQ>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int KHEAD;
/*     */   public static final int KTAIL;
/*     */   public static final int KRING_MASK;
/*     */   public static final int KRING_ENTRIES;
/*     */   public static final int KFLAGS;
/*     */   public static final int KDROPPED;
/*     */   public static final int ARRAY;
/*     */   public static final int SQES;
/*     */   public static final int SQE_HEAD;
/*     */   public static final int SQE_TAIL;
/*     */   public static final int RING_SZ;
/*     */   public static final int RING_PTR;
/*     */   public static final int RING_MASK;
/*     */   public static final int RING_ENTRIES;
/*     */   public static final int PAD;
/*     */   
/*     */   static {
/*  67 */     Struct.Layout layout = __struct(new Struct.Member[] { 
/*  68 */           __member(POINTER_SIZE), 
/*  69 */           __member(POINTER_SIZE), 
/*  70 */           __member(POINTER_SIZE), 
/*  71 */           __member(POINTER_SIZE), 
/*  72 */           __member(POINTER_SIZE), 
/*  73 */           __member(POINTER_SIZE), 
/*  74 */           __member(POINTER_SIZE), 
/*  75 */           __member(POINTER_SIZE), 
/*  76 */           __member(4), 
/*  77 */           __member(4), 
/*  78 */           __member(POINTER_SIZE), 
/*  79 */           __member(POINTER_SIZE), 
/*  80 */           __member(4), 
/*  81 */           __member(4), 
/*  82 */           __array(4, 2) });
/*     */ 
/*     */     
/*  85 */     SIZEOF = layout.getSize();
/*  86 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  88 */     KHEAD = layout.offsetof(0);
/*  89 */     KTAIL = layout.offsetof(1);
/*  90 */     KRING_MASK = layout.offsetof(2);
/*  91 */     KRING_ENTRIES = layout.offsetof(3);
/*  92 */     KFLAGS = layout.offsetof(4);
/*  93 */     KDROPPED = layout.offsetof(5);
/*  94 */     ARRAY = layout.offsetof(6);
/*  95 */     SQES = layout.offsetof(7);
/*  96 */     SQE_HEAD = layout.offsetof(8);
/*  97 */     SQE_TAIL = layout.offsetof(9);
/*  98 */     RING_SZ = layout.offsetof(10);
/*  99 */     RING_PTR = layout.offsetof(11);
/* 100 */     RING_MASK = layout.offsetof(12);
/* 101 */     RING_ENTRIES = layout.offsetof(13);
/* 102 */     PAD = layout.offsetof(14);
/*     */   }
/*     */   
/*     */   protected IOURingSQ(long address, ByteBuffer container) {
/* 106 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingSQ create(long address, ByteBuffer container) {
/* 111 */     return new IOURingSQ(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingSQ(ByteBuffer container) {
/* 121 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 125 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("unsigned *")
/*     */   public IntBuffer khead(int capacity) {
/* 129 */     return nkhead(address(), capacity);
/*     */   } @NativeType("unsigned *")
/*     */   public IntBuffer ktail(int capacity) {
/* 132 */     return nktail(address(), capacity);
/*     */   } @NativeType("unsigned *")
/*     */   public IntBuffer kring_mask(int capacity) {
/* 135 */     return nkring_mask(address(), capacity);
/*     */   } @NativeType("unsigned *")
/*     */   public IntBuffer kring_entries(int capacity) {
/* 138 */     return nkring_entries(address(), capacity);
/*     */   } @NativeType("unsigned *")
/*     */   public IntBuffer kflags(int capacity) {
/* 141 */     return nkflags(address(), capacity);
/*     */   } @NativeType("unsigned *")
/*     */   public IntBuffer kdropped(int capacity) {
/* 144 */     return nkdropped(address(), capacity);
/*     */   } @NativeType("unsigned *")
/*     */   public IntBuffer array(int capacity) {
/* 147 */     return narray(address(), capacity);
/*     */   } @NativeType("struct io_uring_sqe *")
/*     */   public IOURingSQE sqes() {
/* 150 */     return nsqes(address());
/*     */   } @NativeType("unsigned")
/*     */   public int sqe_head() {
/* 153 */     return nsqe_head(address());
/*     */   } @NativeType("unsigned")
/*     */   public int sqe_tail() {
/* 156 */     return nsqe_tail(address());
/*     */   } @NativeType("size_t")
/*     */   public long ring_sz() {
/* 159 */     return nring_sz(address());
/*     */   } @NativeType("void *")
/*     */   public ByteBuffer ring_ptr() {
/* 162 */     return nring_ptr(address());
/*     */   } @NativeType("unsigned")
/*     */   public int ring_mask() {
/* 165 */     return nring_mask(address());
/*     */   } @NativeType("unsigned")
/*     */   public int ring_entries() {
/* 168 */     return nring_entries(address());
/*     */   }
/*     */   public IOURingSQ khead(@NativeType("unsigned *") IntBuffer value) {
/* 171 */     nkhead(address(), value); return this;
/*     */   } public IOURingSQ ktail(@NativeType("unsigned *") IntBuffer value) {
/* 173 */     nktail(address(), value); return this;
/*     */   } public IOURingSQ kring_mask(@NativeType("unsigned *") IntBuffer value) {
/* 175 */     nkring_mask(address(), value); return this;
/*     */   } public IOURingSQ kring_entries(@NativeType("unsigned *") IntBuffer value) {
/* 177 */     nkring_entries(address(), value); return this;
/*     */   } public IOURingSQ kflags(@NativeType("unsigned *") IntBuffer value) {
/* 179 */     nkflags(address(), value); return this;
/*     */   } public IOURingSQ kdropped(@NativeType("unsigned *") IntBuffer value) {
/* 181 */     nkdropped(address(), value); return this;
/*     */   } public IOURingSQ array(@NativeType("unsigned *") IntBuffer value) {
/* 183 */     narray(address(), value); return this;
/*     */   } public IOURingSQ sqes(@NativeType("struct io_uring_sqe *") IOURingSQE value) {
/* 185 */     nsqes(address(), value); return this;
/*     */   } public IOURingSQ sqe_head(@NativeType("unsigned") int value) {
/* 187 */     nsqe_head(address(), value); return this;
/*     */   } public IOURingSQ sqe_tail(@NativeType("unsigned") int value) {
/* 189 */     nsqe_tail(address(), value); return this;
/*     */   } public IOURingSQ ring_ptr(@NativeType("void *") ByteBuffer value) {
/* 191 */     nring_ptr(address(), value); return this;
/*     */   } public IOURingSQ ring_mask(@NativeType("unsigned") int value) {
/* 193 */     nring_mask(address(), value); return this;
/*     */   } public IOURingSQ ring_entries(@NativeType("unsigned") int value) {
/* 195 */     nring_entries(address(), value); return this;
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
/*     */   public IOURingSQ set(IntBuffer khead, IntBuffer ktail, IntBuffer kring_mask, IntBuffer kring_entries, IntBuffer kflags, IntBuffer kdropped, IntBuffer array, IOURingSQE sqes, int sqe_head, int sqe_tail, ByteBuffer ring_ptr, int ring_mask, int ring_entries) {
/* 213 */     khead(khead);
/* 214 */     ktail(ktail);
/* 215 */     kring_mask(kring_mask);
/* 216 */     kring_entries(kring_entries);
/* 217 */     kflags(kflags);
/* 218 */     kdropped(kdropped);
/* 219 */     array(array);
/* 220 */     sqes(sqes);
/* 221 */     sqe_head(sqe_head);
/* 222 */     sqe_tail(sqe_tail);
/* 223 */     ring_ptr(ring_ptr);
/* 224 */     ring_mask(ring_mask);
/* 225 */     ring_entries(ring_entries);
/*     */     
/* 227 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingSQ set(IOURingSQ src) {
/* 238 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 239 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingSQ malloc() {
/* 246 */     return new IOURingSQ(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingSQ calloc() {
/* 251 */     return new IOURingSQ(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingSQ create() {
/* 256 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 257 */     return new IOURingSQ(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingSQ create(long address) {
/* 262 */     return new IOURingSQ(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingSQ createSafe(long address) {
/* 267 */     return (address == 0L) ? null : new IOURingSQ(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 276 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 285 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 294 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 295 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 305 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 310 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingSQ malloc(MemoryStack stack) {
/* 319 */     return new IOURingSQ(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingSQ calloc(MemoryStack stack) {
/* 328 */     return new IOURingSQ(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 338 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 348 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IntBuffer nkhead(long struct, int capacity) {
/* 354 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(struct + KHEAD), capacity);
/*     */   } public static IntBuffer nktail(long struct, int capacity) {
/* 356 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(struct + KTAIL), capacity);
/*     */   } public static IntBuffer nkring_mask(long struct, int capacity) {
/* 358 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(struct + KRING_MASK), capacity);
/*     */   } public static IntBuffer nkring_entries(long struct, int capacity) {
/* 360 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(struct + KRING_ENTRIES), capacity);
/*     */   } public static IntBuffer nkflags(long struct, int capacity) {
/* 362 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(struct + KFLAGS), capacity);
/*     */   } public static IntBuffer nkdropped(long struct, int capacity) {
/* 364 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(struct + KDROPPED), capacity);
/*     */   } public static IntBuffer narray(long struct, int capacity) {
/* 366 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(struct + ARRAY), capacity);
/*     */   } public static IOURingSQE nsqes(long struct) {
/* 368 */     return IOURingSQE.create(MemoryUtil.memGetAddress(struct + SQES));
/*     */   } public static int nsqe_head(long struct) {
/* 370 */     return MemoryUtil.memGetInt(struct + SQE_HEAD);
/*     */   } public static int nsqe_tail(long struct) {
/* 372 */     return MemoryUtil.memGetInt(struct + SQE_TAIL);
/*     */   } public static long nring_sz(long struct) {
/* 374 */     return MemoryUtil.memGetAddress(struct + RING_SZ);
/*     */   } public static ByteBuffer nring_ptr(long struct) {
/* 376 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(struct + RING_PTR), (int)nring_sz(struct));
/*     */   } public static int nring_mask(long struct) {
/* 378 */     return MemoryUtil.memGetInt(struct + RING_MASK);
/*     */   }
/* 380 */   public static int nring_entries(long struct) { return MemoryUtil.memGetInt(struct + RING_ENTRIES); } public static IntBuffer npad(long struct) {
/* 381 */     return MemoryUtil.memIntBuffer(struct + PAD, 2);
/*     */   } public static int npad(long struct, int index) {
/* 383 */     return MemoryUtil.memGetInt(struct + PAD + Checks.check(index, 2) * 4L);
/*     */   }
/*     */   
/*     */   public static void nkhead(long struct, IntBuffer value) {
/* 387 */     MemoryUtil.memPutAddress(struct + KHEAD, MemoryUtil.memAddress(value));
/*     */   } public static void nktail(long struct, IntBuffer value) {
/* 389 */     MemoryUtil.memPutAddress(struct + KTAIL, MemoryUtil.memAddress(value));
/*     */   } public static void nkring_mask(long struct, IntBuffer value) {
/* 391 */     MemoryUtil.memPutAddress(struct + KRING_MASK, MemoryUtil.memAddress(value));
/*     */   } public static void nkring_entries(long struct, IntBuffer value) {
/* 393 */     MemoryUtil.memPutAddress(struct + KRING_ENTRIES, MemoryUtil.memAddress(value));
/*     */   } public static void nkflags(long struct, IntBuffer value) {
/* 395 */     MemoryUtil.memPutAddress(struct + KFLAGS, MemoryUtil.memAddress(value));
/*     */   } public static void nkdropped(long struct, IntBuffer value) {
/* 397 */     MemoryUtil.memPutAddress(struct + KDROPPED, MemoryUtil.memAddress(value));
/*     */   } public static void narray(long struct, IntBuffer value) {
/* 399 */     MemoryUtil.memPutAddress(struct + ARRAY, MemoryUtil.memAddress(value));
/*     */   } public static void nsqes(long struct, IOURingSQE value) {
/* 401 */     MemoryUtil.memPutAddress(struct + SQES, value.address());
/*     */   } public static void nsqe_head(long struct, int value) {
/* 403 */     MemoryUtil.memPutInt(struct + SQE_HEAD, value);
/*     */   } public static void nsqe_tail(long struct, int value) {
/* 405 */     MemoryUtil.memPutInt(struct + SQE_TAIL, value);
/*     */   } public static void nring_sz(long struct, long value) {
/* 407 */     MemoryUtil.memPutAddress(struct + RING_SZ, value);
/*     */   } public static void nring_ptr(long struct, ByteBuffer value) {
/* 409 */     MemoryUtil.memPutAddress(struct + RING_PTR, MemoryUtil.memAddress(value)); nring_sz(struct, value.remaining());
/*     */   } public static void nring_mask(long struct, int value) {
/* 411 */     MemoryUtil.memPutInt(struct + RING_MASK, value);
/*     */   } public static void nring_entries(long struct, int value) {
/* 413 */     MemoryUtil.memPutInt(struct + RING_ENTRIES, value);
/*     */   } public static void npad(long struct, IntBuffer value) {
/* 415 */     if (Checks.CHECKS) Checks.checkGT(value, 2); 
/* 416 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + PAD, (value.remaining() * 4));
/*     */   }
/*     */   public static void npad(long struct, int index, int value) {
/* 419 */     MemoryUtil.memPutInt(struct + PAD + Checks.check(index, 2) * 4L, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 428 */     Checks.check(MemoryUtil.memGetAddress(struct + KHEAD));
/* 429 */     Checks.check(MemoryUtil.memGetAddress(struct + KTAIL));
/* 430 */     Checks.check(MemoryUtil.memGetAddress(struct + KRING_MASK));
/* 431 */     Checks.check(MemoryUtil.memGetAddress(struct + KRING_ENTRIES));
/* 432 */     Checks.check(MemoryUtil.memGetAddress(struct + KFLAGS));
/* 433 */     Checks.check(MemoryUtil.memGetAddress(struct + KDROPPED));
/* 434 */     Checks.check(MemoryUtil.memGetAddress(struct + ARRAY));
/* 435 */     Checks.check(MemoryUtil.memGetAddress(struct + SQES));
/* 436 */     Checks.check(MemoryUtil.memGetAddress(struct + RING_PTR));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingSQ, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 444 */     private static final IOURingSQ ELEMENT_FACTORY = IOURingSQ.create(-1L);
/*     */ 
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
/* 456 */       super(container, container.remaining() / IOURingSQ.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 460 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 464 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 469 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 474 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingSQ getElementFactory() {
/* 479 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("unsigned *")
/*     */     public IntBuffer khead(int capacity) {
/* 484 */       return IOURingSQ.nkhead(address(), capacity);
/*     */     } @NativeType("unsigned *")
/*     */     public IntBuffer ktail(int capacity) {
/* 487 */       return IOURingSQ.nktail(address(), capacity);
/*     */     } @NativeType("unsigned *")
/*     */     public IntBuffer kring_mask(int capacity) {
/* 490 */       return IOURingSQ.nkring_mask(address(), capacity);
/*     */     } @NativeType("unsigned *")
/*     */     public IntBuffer kring_entries(int capacity) {
/* 493 */       return IOURingSQ.nkring_entries(address(), capacity);
/*     */     } @NativeType("unsigned *")
/*     */     public IntBuffer kflags(int capacity) {
/* 496 */       return IOURingSQ.nkflags(address(), capacity);
/*     */     } @NativeType("unsigned *")
/*     */     public IntBuffer kdropped(int capacity) {
/* 499 */       return IOURingSQ.nkdropped(address(), capacity);
/*     */     } @NativeType("unsigned *")
/*     */     public IntBuffer array(int capacity) {
/* 502 */       return IOURingSQ.narray(address(), capacity);
/*     */     } @NativeType("struct io_uring_sqe *")
/*     */     public IOURingSQE sqes() {
/* 505 */       return IOURingSQ.nsqes(address());
/*     */     } @NativeType("unsigned")
/*     */     public int sqe_head() {
/* 508 */       return IOURingSQ.nsqe_head(address());
/*     */     } @NativeType("unsigned")
/*     */     public int sqe_tail() {
/* 511 */       return IOURingSQ.nsqe_tail(address());
/*     */     } @NativeType("size_t")
/*     */     public long ring_sz() {
/* 514 */       return IOURingSQ.nring_sz(address());
/*     */     } @NativeType("void *")
/*     */     public ByteBuffer ring_ptr() {
/* 517 */       return IOURingSQ.nring_ptr(address());
/*     */     } @NativeType("unsigned")
/*     */     public int ring_mask() {
/* 520 */       return IOURingSQ.nring_mask(address());
/*     */     } @NativeType("unsigned")
/*     */     public int ring_entries() {
/* 523 */       return IOURingSQ.nring_entries(address());
/*     */     }
/*     */     public Buffer khead(@NativeType("unsigned *") IntBuffer value) {
/* 526 */       IOURingSQ.nkhead(address(), value); return this;
/*     */     } public Buffer ktail(@NativeType("unsigned *") IntBuffer value) {
/* 528 */       IOURingSQ.nktail(address(), value); return this;
/*     */     } public Buffer kring_mask(@NativeType("unsigned *") IntBuffer value) {
/* 530 */       IOURingSQ.nkring_mask(address(), value); return this;
/*     */     } public Buffer kring_entries(@NativeType("unsigned *") IntBuffer value) {
/* 532 */       IOURingSQ.nkring_entries(address(), value); return this;
/*     */     } public Buffer kflags(@NativeType("unsigned *") IntBuffer value) {
/* 534 */       IOURingSQ.nkflags(address(), value); return this;
/*     */     } public Buffer kdropped(@NativeType("unsigned *") IntBuffer value) {
/* 536 */       IOURingSQ.nkdropped(address(), value); return this;
/*     */     } public Buffer array(@NativeType("unsigned *") IntBuffer value) {
/* 538 */       IOURingSQ.narray(address(), value); return this;
/*     */     } public Buffer sqes(@NativeType("struct io_uring_sqe *") IOURingSQE value) {
/* 540 */       IOURingSQ.nsqes(address(), value); return this;
/*     */     } public Buffer sqe_head(@NativeType("unsigned") int value) {
/* 542 */       IOURingSQ.nsqe_head(address(), value); return this;
/*     */     } public Buffer sqe_tail(@NativeType("unsigned") int value) {
/* 544 */       IOURingSQ.nsqe_tail(address(), value); return this;
/*     */     } public Buffer ring_ptr(@NativeType("void *") ByteBuffer value) {
/* 546 */       IOURingSQ.nring_ptr(address(), value); return this;
/*     */     } public Buffer ring_mask(@NativeType("unsigned") int value) {
/* 548 */       IOURingSQ.nring_mask(address(), value); return this;
/*     */     } public Buffer ring_entries(@NativeType("unsigned") int value) {
/* 550 */       IOURingSQ.nring_entries(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingSQ.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */