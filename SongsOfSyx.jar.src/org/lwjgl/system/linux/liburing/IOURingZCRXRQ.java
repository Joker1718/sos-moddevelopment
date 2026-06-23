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
/*     */ @NativeType("struct io_uring_zcrx_rq")
/*     */ public class IOURingZCRXRQ
/*     */   extends Struct<IOURingZCRXRQ>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int KHEAD;
/*     */   public static final int KTAIL;
/*     */   public static final int RQ_TAIL;
/*     */   public static final int RING_ENTRIES;
/*     */   public static final int RQES;
/*     */   public static final int RING_PTR;
/*     */   
/*     */   static {
/*  49 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  50 */           __member(POINTER_SIZE), 
/*  51 */           __member(POINTER_SIZE), 
/*  52 */           __member(4), 
/*  53 */           __member(4), 
/*  54 */           __member(POINTER_SIZE), 
/*  55 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  58 */     SIZEOF = layout.getSize();
/*  59 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  61 */     KHEAD = layout.offsetof(0);
/*  62 */     KTAIL = layout.offsetof(1);
/*  63 */     RQ_TAIL = layout.offsetof(2);
/*  64 */     RING_ENTRIES = layout.offsetof(3);
/*  65 */     RQES = layout.offsetof(4);
/*  66 */     RING_PTR = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected IOURingZCRXRQ(long address, ByteBuffer container) {
/*  70 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingZCRXRQ create(long address, ByteBuffer container) {
/*  75 */     return new IOURingZCRXRQ(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingZCRXRQ(ByteBuffer container) {
/*  85 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  89 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32 *")
/*     */   public IntBuffer khead(int capacity) {
/*  93 */     return nkhead(address(), capacity);
/*     */   } @NativeType("__u32 *")
/*     */   public IntBuffer ktail(int capacity) {
/*  96 */     return nktail(address(), capacity);
/*     */   } @NativeType("__u32")
/*     */   public int rq_tail() {
/*  99 */     return nrq_tail(address());
/*     */   } @NativeType("unsigned")
/*     */   public int ring_entries() {
/* 102 */     return nring_entries(address());
/*     */   } @NativeType("struct io_uring_zcrx_rqe *")
/*     */   public IOURingZCRXRQE rqes() {
/* 105 */     return nrqes(address());
/*     */   } @NativeType("void *")
/*     */   public long ring_ptr() {
/* 108 */     return nring_ptr(address());
/*     */   }
/*     */   public IOURingZCRXRQ khead(@NativeType("__u32 *") IntBuffer value) {
/* 111 */     nkhead(address(), value); return this;
/*     */   } public IOURingZCRXRQ ktail(@NativeType("__u32 *") IntBuffer value) {
/* 113 */     nktail(address(), value); return this;
/*     */   } public IOURingZCRXRQ rq_tail(@NativeType("__u32") int value) {
/* 115 */     nrq_tail(address(), value); return this;
/*     */   } public IOURingZCRXRQ ring_entries(@NativeType("unsigned") int value) {
/* 117 */     nring_entries(address(), value); return this;
/*     */   } public IOURingZCRXRQ rqes(@NativeType("struct io_uring_zcrx_rqe *") IOURingZCRXRQE value) {
/* 119 */     nrqes(address(), value); return this;
/*     */   } public IOURingZCRXRQ ring_ptr(@NativeType("void *") long value) {
/* 121 */     nring_ptr(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingZCRXRQ set(IntBuffer khead, IntBuffer ktail, int rq_tail, int ring_entries, IOURingZCRXRQE rqes, long ring_ptr) {
/* 132 */     khead(khead);
/* 133 */     ktail(ktail);
/* 134 */     rq_tail(rq_tail);
/* 135 */     ring_entries(ring_entries);
/* 136 */     rqes(rqes);
/* 137 */     ring_ptr(ring_ptr);
/*     */     
/* 139 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingZCRXRQ set(IOURingZCRXRQ src) {
/* 150 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 151 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingZCRXRQ malloc() {
/* 158 */     return new IOURingZCRXRQ(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXRQ calloc() {
/* 163 */     return new IOURingZCRXRQ(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXRQ create() {
/* 168 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 169 */     return new IOURingZCRXRQ(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXRQ create(long address) {
/* 174 */     return new IOURingZCRXRQ(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingZCRXRQ createSafe(long address) {
/* 179 */     return (address == 0L) ? null : new IOURingZCRXRQ(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 188 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 197 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 206 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 207 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 217 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 222 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingZCRXRQ malloc(MemoryStack stack) {
/* 231 */     return new IOURingZCRXRQ(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingZCRXRQ calloc(MemoryStack stack) {
/* 240 */     return new IOURingZCRXRQ(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 250 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 260 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static IntBuffer nkhead(long struct, int capacity) {
/* 266 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(struct + KHEAD), capacity);
/*     */   } public static IntBuffer nktail(long struct, int capacity) {
/* 268 */     return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(struct + KTAIL), capacity);
/*     */   } public static int nrq_tail(long struct) {
/* 270 */     return MemoryUtil.memGetInt(struct + RQ_TAIL);
/*     */   } public static int nring_entries(long struct) {
/* 272 */     return MemoryUtil.memGetInt(struct + RING_ENTRIES);
/*     */   } public static IOURingZCRXRQE nrqes(long struct) {
/* 274 */     return IOURingZCRXRQE.create(MemoryUtil.memGetAddress(struct + RQES));
/*     */   } public static long nring_ptr(long struct) {
/* 276 */     return MemoryUtil.memGetAddress(struct + RING_PTR);
/*     */   }
/*     */   public static void nkhead(long struct, IntBuffer value) {
/* 279 */     MemoryUtil.memPutAddress(struct + KHEAD, MemoryUtil.memAddress(value));
/*     */   } public static void nktail(long struct, IntBuffer value) {
/* 281 */     MemoryUtil.memPutAddress(struct + KTAIL, MemoryUtil.memAddress(value));
/*     */   } public static void nrq_tail(long struct, int value) {
/* 283 */     MemoryUtil.memPutInt(struct + RQ_TAIL, value);
/*     */   } public static void nring_entries(long struct, int value) {
/* 285 */     MemoryUtil.memPutInt(struct + RING_ENTRIES, value);
/*     */   } public static void nrqes(long struct, IOURingZCRXRQE value) {
/* 287 */     MemoryUtil.memPutAddress(struct + RQES, value.address());
/*     */   } public static void nring_ptr(long struct, long value) {
/* 289 */     MemoryUtil.memPutAddress(struct + RING_PTR, Checks.check(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 297 */     Checks.check(MemoryUtil.memGetAddress(struct + KHEAD));
/* 298 */     Checks.check(MemoryUtil.memGetAddress(struct + KTAIL));
/* 299 */     Checks.check(MemoryUtil.memGetAddress(struct + RQES));
/* 300 */     Checks.check(MemoryUtil.memGetAddress(struct + RING_PTR));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingZCRXRQ, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 308 */     private static final IOURingZCRXRQ ELEMENT_FACTORY = IOURingZCRXRQ.create(-1L);
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
/* 320 */       super(container, container.remaining() / IOURingZCRXRQ.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 324 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 328 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 333 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 338 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingZCRXRQ getElementFactory() {
/* 343 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32 *")
/*     */     public IntBuffer khead(int capacity) {
/* 348 */       return IOURingZCRXRQ.nkhead(address(), capacity);
/*     */     } @NativeType("__u32 *")
/*     */     public IntBuffer ktail(int capacity) {
/* 351 */       return IOURingZCRXRQ.nktail(address(), capacity);
/*     */     } @NativeType("__u32")
/*     */     public int rq_tail() {
/* 354 */       return IOURingZCRXRQ.nrq_tail(address());
/*     */     } @NativeType("unsigned")
/*     */     public int ring_entries() {
/* 357 */       return IOURingZCRXRQ.nring_entries(address());
/*     */     } @NativeType("struct io_uring_zcrx_rqe *")
/*     */     public IOURingZCRXRQE rqes() {
/* 360 */       return IOURingZCRXRQ.nrqes(address());
/*     */     } @NativeType("void *")
/*     */     public long ring_ptr() {
/* 363 */       return IOURingZCRXRQ.nring_ptr(address());
/*     */     }
/*     */     public Buffer khead(@NativeType("__u32 *") IntBuffer value) {
/* 366 */       IOURingZCRXRQ.nkhead(address(), value); return this;
/*     */     } public Buffer ktail(@NativeType("__u32 *") IntBuffer value) {
/* 368 */       IOURingZCRXRQ.nktail(address(), value); return this;
/*     */     } public Buffer rq_tail(@NativeType("__u32") int value) {
/* 370 */       IOURingZCRXRQ.nrq_tail(address(), value); return this;
/*     */     } public Buffer ring_entries(@NativeType("unsigned") int value) {
/* 372 */       IOURingZCRXRQ.nring_entries(address(), value); return this;
/*     */     } public Buffer rqes(@NativeType("struct io_uring_zcrx_rqe *") IOURingZCRXRQE value) {
/* 374 */       IOURingZCRXRQ.nrqes(address(), value); return this;
/*     */     } public Buffer ring_ptr(@NativeType("void *") long value) {
/* 376 */       IOURingZCRXRQ.nring_ptr(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingZCRXRQ.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */