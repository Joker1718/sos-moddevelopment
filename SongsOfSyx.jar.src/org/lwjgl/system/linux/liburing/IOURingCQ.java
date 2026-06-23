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
/*     */ @NativeType("struct io_uring_cq")
/*     */ public class IOURingCQ
/*     */   extends Struct<IOURingCQ>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int KHEAD;
/*     */   public static final int KTAIL;
/*     */   public static final int KRING_MASK;
/*     */   public static final int KRING_ENTRIES;
/*     */   public static final int KFLAGS;
/*     */   public static final int KOVERFLOW;
/*     */   public static final int CQES;
/*     */   public static final int RING_SZ;
/*     */   public static final int RING_PTR;
/*     */   public static final int RING_MASK;
/*     */   public static final int RING_ENTRIES;
/*     */   public static final int PAD;
/*     */   
/*     */   static {
/*  61 */     Struct.Layout layout = __struct(new Struct.Member[] { 
/*  62 */           __member(POINTER_SIZE), 
/*  63 */           __member(POINTER_SIZE), 
/*  64 */           __member(POINTER_SIZE), 
/*  65 */           __member(POINTER_SIZE), 
/*  66 */           __member(POINTER_SIZE), 
/*  67 */           __member(POINTER_SIZE), 
/*  68 */           __member(POINTER_SIZE), 
/*  69 */           __member(POINTER_SIZE), 
/*  70 */           __member(POINTER_SIZE), 
/*  71 */           __member(4), 
/*  72 */           __member(4), 
/*  73 */           __array(4, 2) });
/*     */ 
/*     */     
/*  76 */     SIZEOF = layout.getSize();
/*  77 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  79 */     KHEAD = layout.offsetof(0);
/*  80 */     KTAIL = layout.offsetof(1);
/*  81 */     KRING_MASK = layout.offsetof(2);
/*  82 */     KRING_ENTRIES = layout.offsetof(3);
/*  83 */     KFLAGS = layout.offsetof(4);
/*  84 */     KOVERFLOW = layout.offsetof(5);
/*  85 */     CQES = layout.offsetof(6);
/*  86 */     RING_SZ = layout.offsetof(7);
/*  87 */     RING_PTR = layout.offsetof(8);
/*  88 */     RING_MASK = layout.offsetof(9);
/*  89 */     RING_ENTRIES = layout.offsetof(10);
/*  90 */     PAD = layout.offsetof(11);
/*     */   }
/*     */   
/*     */   protected IOURingCQ(long address, ByteBuffer container) {
/*  94 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingCQ create(long address, ByteBuffer container) {
/*  99 */     return new IOURingCQ(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingCQ(ByteBuffer container) {
/* 109 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 113 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("unsigned *")
/*     */   public IntBuffer khead(int capacity) {
/* 117 */     return nkhead(address(), capacity);
/*     */   } @NativeType("unsigned *")
/*     */   public IntBuffer ktail(int capacity) {
/* 120 */     return nktail(address(), capacity);
/*     */   } @NativeType("unsigned *")
/*     */   public IntBuffer kring_mask(int capacity) {
/* 123 */     return nkring_mask(address(), capacity);
/*     */   } @NativeType("unsigned *")
/*     */   public IntBuffer kring_entries(int capacity) {
/* 126 */     return nkring_entries(address(), capacity);
/*     */   } @NativeType("unsigned *")
/*     */   public IntBuffer kflags(int capacity) {
/* 129 */     return nkflags(address(), capacity);
/*     */   } @NativeType("unsigned *")
/*     */   public IntBuffer koverflow(int capacity) {
/* 132 */     return nkoverflow(address(), capacity);
/*     */   } @NativeType("struct io_uring_cqe *")
/*     */   public IOURingCQE cqes() {
/* 135 */     return ncqes(address());
/*     */   } @NativeType("size_t")
/*     */   public long ring_sz() {
/* 138 */     return nring_sz(address());
/*     */   } @NativeType("void *")
/*     */   public ByteBuffer ring_ptr() {
/* 141 */     return nring_ptr(address());
/*     */   } @NativeType("unsigned")
/*     */   public int ring_mask() {
/* 144 */     return nring_mask(address());
/*     */   } @NativeType("unsigned")
/*     */   public int ring_entries() {
/* 147 */     return nring_entries(address());
/*     */   }
/*     */   public IOURingCQ khead(@NativeType("unsigned *") IntBuffer value) {
/* 150 */     nkhead(address(), value); return this;
/*     */   } public IOURingCQ ktail(@NativeType("unsigned *") IntBuffer value) {
/* 152 */     nktail(address(), value); return this;
/*     */   } public IOURingCQ kring_mask(@NativeType("unsigned *") IntBuffer value) {
/* 154 */     nkring_mask(address(), value); return this;
/*     */   } public IOURingCQ kring_entries(@NativeType("unsigned *") IntBuffer value) {
/* 156 */     nkring_entries(address(), value); return this;
/*     */   } public IOURingCQ kflags(@NativeType("unsigned *") IntBuffer value) {
/* 158 */     nkflags(address(), value); return this;
/*     */   } public IOURingCQ koverflow(@NativeType("unsigned *") IntBuffer value) {
/* 160 */     nkoverflow(address(), value); return this;
/*     */   } public IOURingCQ cqes(@NativeType("struct io_uring_cqe *") IOURingCQE value) {
/* 162 */     ncqes(address(), value); return this;
/*     */   } public IOURingCQ ring_ptr(@NativeType("void *") ByteBuffer value) {
/* 164 */     nring_ptr(address(), value); return this;
/*     */   } public IOURingCQ ring_mask(@NativeType("unsigned") int value) {
/* 166 */     nring_mask(address(), value); return this;
/*     */   } public IOURingCQ ring_entries(@NativeType("unsigned") int value) {
/* 168 */     nring_entries(address(), value); return this;
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
/*     */   public IOURingCQ set(IntBuffer khead, IntBuffer ktail, IntBuffer kring_mask, IntBuffer kring_entries, IntBuffer kflags, IntBuffer koverflow, IOURingCQE cqes, ByteBuffer ring_ptr, int ring_mask, int ring_entries) {
/* 183 */     khead(khead);
/* 184 */     ktail(ktail);
/* 185 */     kring_mask(kring_mask);
/* 186 */     kring_entries(kring_entries);
/* 187 */     kflags(kflags);
/* 188 */     koverflow(koverflow);
/* 189 */     cqes(cqes);
/* 190 */     ring_ptr(ring_ptr);
/* 191 */     ring_mask(ring_mask);
/* 192 */     ring_entries(ring_entries);
/*     */     
/* 194 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingCQ set(IOURingCQ src) {
/* 205 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 206 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingCQ malloc() {
/* 213 */     return new IOURingCQ(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingCQ calloc() {
/* 218 */     return new IOURingCQ(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingCQ create() {
/* 223 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 224 */     return new IOURingCQ(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingCQ create(long address) {
/* 229 */     return new IOURingCQ(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingCQ createSafe(long address) {
/* 234 */     return (address == 0L) ? null : new IOURingCQ(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 243 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 252 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 261 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 262 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 272 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 277 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingCQ malloc(MemoryStack stack) {
/* 286 */     return new IOURingCQ(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingCQ calloc(MemoryStack stack) {
/* 295 */     return new IOURingCQ(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 305 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 315 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IntBuffer nkhead(long struct, int capacity) {
/* 321 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(struct + KHEAD), capacity);
/*     */   } public static IntBuffer nktail(long struct, int capacity) {
/* 323 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(struct + KTAIL), capacity);
/*     */   } public static IntBuffer nkring_mask(long struct, int capacity) {
/* 325 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(struct + KRING_MASK), capacity);
/*     */   } public static IntBuffer nkring_entries(long struct, int capacity) {
/* 327 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(struct + KRING_ENTRIES), capacity);
/*     */   } public static IntBuffer nkflags(long struct, int capacity) {
/* 329 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(struct + KFLAGS), capacity);
/*     */   } public static IntBuffer nkoverflow(long struct, int capacity) {
/* 331 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(struct + KOVERFLOW), capacity);
/*     */   } public static IOURingCQE ncqes(long struct) {
/* 333 */     return IOURingCQE.create(MemoryUtil.memGetAddress(struct + CQES));
/*     */   } public static long nring_sz(long struct) {
/* 335 */     return MemoryUtil.memGetAddress(struct + RING_SZ);
/*     */   } public static ByteBuffer nring_ptr(long struct) {
/* 337 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(struct + RING_PTR), (int)nring_sz(struct));
/*     */   } public static int nring_mask(long struct) {
/* 339 */     return MemoryUtil.memGetInt(struct + RING_MASK);
/*     */   }
/* 341 */   public static int nring_entries(long struct) { return MemoryUtil.memGetInt(struct + RING_ENTRIES); } public static IntBuffer npad(long struct) {
/* 342 */     return MemoryUtil.memIntBuffer(struct + PAD, 2);
/*     */   } public static int npad(long struct, int index) {
/* 344 */     return MemoryUtil.memGetInt(struct + PAD + Checks.check(index, 2) * 4L);
/*     */   }
/*     */   
/*     */   public static void nkhead(long struct, IntBuffer value) {
/* 348 */     MemoryUtil.memPutAddress(struct + KHEAD, MemoryUtil.memAddress(value));
/*     */   } public static void nktail(long struct, IntBuffer value) {
/* 350 */     MemoryUtil.memPutAddress(struct + KTAIL, MemoryUtil.memAddress(value));
/*     */   } public static void nkring_mask(long struct, IntBuffer value) {
/* 352 */     MemoryUtil.memPutAddress(struct + KRING_MASK, MemoryUtil.memAddress(value));
/*     */   } public static void nkring_entries(long struct, IntBuffer value) {
/* 354 */     MemoryUtil.memPutAddress(struct + KRING_ENTRIES, MemoryUtil.memAddress(value));
/*     */   } public static void nkflags(long struct, IntBuffer value) {
/* 356 */     MemoryUtil.memPutAddress(struct + KFLAGS, MemoryUtil.memAddress(value));
/*     */   } public static void nkoverflow(long struct, IntBuffer value) {
/* 358 */     MemoryUtil.memPutAddress(struct + KOVERFLOW, MemoryUtil.memAddress(value));
/*     */   } public static void ncqes(long struct, IOURingCQE value) {
/* 360 */     MemoryUtil.memPutAddress(struct + CQES, value.address());
/*     */   } public static void nring_sz(long struct, long value) {
/* 362 */     MemoryUtil.memPutAddress(struct + RING_SZ, value);
/*     */   } public static void nring_ptr(long struct, ByteBuffer value) {
/* 364 */     MemoryUtil.memPutAddress(struct + RING_PTR, MemoryUtil.memAddress(value)); nring_sz(struct, value.remaining());
/*     */   } public static void nring_mask(long struct, int value) {
/* 366 */     MemoryUtil.memPutInt(struct + RING_MASK, value);
/*     */   } public static void nring_entries(long struct, int value) {
/* 368 */     MemoryUtil.memPutInt(struct + RING_ENTRIES, value);
/*     */   } public static void npad(long struct, IntBuffer value) {
/* 370 */     if (Checks.CHECKS) Checks.checkGT(value, 2); 
/* 371 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + PAD, (value.remaining() * 4));
/*     */   }
/*     */   public static void npad(long struct, int index, int value) {
/* 374 */     MemoryUtil.memPutInt(struct + PAD + Checks.check(index, 2) * 4L, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 383 */     Checks.check(MemoryUtil.memGetAddress(struct + KHEAD));
/* 384 */     Checks.check(MemoryUtil.memGetAddress(struct + KTAIL));
/* 385 */     Checks.check(MemoryUtil.memGetAddress(struct + KRING_MASK));
/* 386 */     Checks.check(MemoryUtil.memGetAddress(struct + KRING_ENTRIES));
/* 387 */     Checks.check(MemoryUtil.memGetAddress(struct + KFLAGS));
/* 388 */     Checks.check(MemoryUtil.memGetAddress(struct + KOVERFLOW));
/* 389 */     Checks.check(MemoryUtil.memGetAddress(struct + CQES));
/* 390 */     Checks.check(MemoryUtil.memGetAddress(struct + RING_PTR));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingCQ, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 398 */     private static final IOURingCQ ELEMENT_FACTORY = IOURingCQ.create(-1L);
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
/* 410 */       super(container, container.remaining() / IOURingCQ.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 414 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 418 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 423 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 428 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingCQ getElementFactory() {
/* 433 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("unsigned *")
/*     */     public IntBuffer khead(int capacity) {
/* 438 */       return IOURingCQ.nkhead(address(), capacity);
/*     */     } @NativeType("unsigned *")
/*     */     public IntBuffer ktail(int capacity) {
/* 441 */       return IOURingCQ.nktail(address(), capacity);
/*     */     } @NativeType("unsigned *")
/*     */     public IntBuffer kring_mask(int capacity) {
/* 444 */       return IOURingCQ.nkring_mask(address(), capacity);
/*     */     } @NativeType("unsigned *")
/*     */     public IntBuffer kring_entries(int capacity) {
/* 447 */       return IOURingCQ.nkring_entries(address(), capacity);
/*     */     } @NativeType("unsigned *")
/*     */     public IntBuffer kflags(int capacity) {
/* 450 */       return IOURingCQ.nkflags(address(), capacity);
/*     */     } @NativeType("unsigned *")
/*     */     public IntBuffer koverflow(int capacity) {
/* 453 */       return IOURingCQ.nkoverflow(address(), capacity);
/*     */     } @NativeType("struct io_uring_cqe *")
/*     */     public IOURingCQE cqes() {
/* 456 */       return IOURingCQ.ncqes(address());
/*     */     } @NativeType("size_t")
/*     */     public long ring_sz() {
/* 459 */       return IOURingCQ.nring_sz(address());
/*     */     } @NativeType("void *")
/*     */     public ByteBuffer ring_ptr() {
/* 462 */       return IOURingCQ.nring_ptr(address());
/*     */     } @NativeType("unsigned")
/*     */     public int ring_mask() {
/* 465 */       return IOURingCQ.nring_mask(address());
/*     */     } @NativeType("unsigned")
/*     */     public int ring_entries() {
/* 468 */       return IOURingCQ.nring_entries(address());
/*     */     }
/*     */     public Buffer khead(@NativeType("unsigned *") IntBuffer value) {
/* 471 */       IOURingCQ.nkhead(address(), value); return this;
/*     */     } public Buffer ktail(@NativeType("unsigned *") IntBuffer value) {
/* 473 */       IOURingCQ.nktail(address(), value); return this;
/*     */     } public Buffer kring_mask(@NativeType("unsigned *") IntBuffer value) {
/* 475 */       IOURingCQ.nkring_mask(address(), value); return this;
/*     */     } public Buffer kring_entries(@NativeType("unsigned *") IntBuffer value) {
/* 477 */       IOURingCQ.nkring_entries(address(), value); return this;
/*     */     } public Buffer kflags(@NativeType("unsigned *") IntBuffer value) {
/* 479 */       IOURingCQ.nkflags(address(), value); return this;
/*     */     } public Buffer koverflow(@NativeType("unsigned *") IntBuffer value) {
/* 481 */       IOURingCQ.nkoverflow(address(), value); return this;
/*     */     } public Buffer cqes(@NativeType("struct io_uring_cqe *") IOURingCQE value) {
/* 483 */       IOURingCQ.ncqes(address(), value); return this;
/*     */     } public Buffer ring_ptr(@NativeType("void *") ByteBuffer value) {
/* 485 */       IOURingCQ.nring_ptr(address(), value); return this;
/*     */     } public Buffer ring_mask(@NativeType("unsigned") int value) {
/* 487 */       IOURingCQ.nring_mask(address(), value); return this;
/*     */     } public Buffer ring_entries(@NativeType("unsigned") int value) {
/* 489 */       IOURingCQ.nring_entries(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingCQ.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */