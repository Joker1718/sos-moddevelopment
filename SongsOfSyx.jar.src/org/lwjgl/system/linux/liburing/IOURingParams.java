/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
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
/*     */ @NativeType("struct io_uring_params")
/*     */ public class IOURingParams
/*     */   extends Struct<IOURingParams>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int SQ_ENTRIES;
/*     */   public static final int CQ_ENTRIES;
/*     */   public static final int FLAGS;
/*     */   public static final int SQ_THREAD_CPU;
/*     */   public static final int SQ_THREAD_IDLE;
/*     */   public static final int FEATURES;
/*     */   public static final int WQ_FD;
/*     */   public static final int RESV;
/*     */   public static final int SQ_OFF;
/*     */   public static final int CQ_OFF;
/*     */   
/*     */   static {
/*  57 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  58 */           __member(4), 
/*  59 */           __member(4), 
/*  60 */           __member(4), 
/*  61 */           __member(4), 
/*  62 */           __member(4), 
/*  63 */           __member(4), 
/*  64 */           __member(4), 
/*  65 */           __array(4, 3), 
/*  66 */           __member(IOSQRingOffsets.SIZEOF, IOSQRingOffsets.ALIGNOF), 
/*  67 */           __member(IOCQRingOffsets.SIZEOF, IOCQRingOffsets.ALIGNOF)
/*     */         });
/*     */     
/*  70 */     SIZEOF = layout.getSize();
/*  71 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  73 */     SQ_ENTRIES = layout.offsetof(0);
/*  74 */     CQ_ENTRIES = layout.offsetof(1);
/*  75 */     FLAGS = layout.offsetof(2);
/*  76 */     SQ_THREAD_CPU = layout.offsetof(3);
/*  77 */     SQ_THREAD_IDLE = layout.offsetof(4);
/*  78 */     FEATURES = layout.offsetof(5);
/*  79 */     WQ_FD = layout.offsetof(6);
/*  80 */     RESV = layout.offsetof(7);
/*  81 */     SQ_OFF = layout.offsetof(8);
/*  82 */     CQ_OFF = layout.offsetof(9);
/*     */   }
/*     */   
/*     */   protected IOURingParams(long address, ByteBuffer container) {
/*  86 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingParams create(long address, ByteBuffer container) {
/*  91 */     return new IOURingParams(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingParams(ByteBuffer container) {
/* 101 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 105 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int sq_entries() {
/* 109 */     return nsq_entries(address());
/*     */   } @NativeType("__u32")
/*     */   public int cq_entries() {
/* 112 */     return ncq_entries(address());
/*     */   } @NativeType("__u32")
/*     */   public int flags() {
/* 115 */     return nflags(address());
/*     */   } @NativeType("__u32")
/*     */   public int sq_thread_cpu() {
/* 118 */     return nsq_thread_cpu(address());
/*     */   } @NativeType("__u32")
/*     */   public int sq_thread_idle() {
/* 121 */     return nsq_thread_idle(address());
/*     */   } @NativeType("__u32")
/*     */   public int features() {
/* 124 */     return nfeatures(address());
/*     */   } @NativeType("__u32")
/*     */   public int wq_fd() {
/* 127 */     return nwq_fd(address());
/*     */   } @NativeType("struct io_sqring_offsets")
/*     */   public IOSQRingOffsets sq_off() {
/* 130 */     return nsq_off(address());
/*     */   } @NativeType("struct io_cqring_offsets")
/*     */   public IOCQRingOffsets cq_off() {
/* 133 */     return ncq_off(address());
/*     */   }
/*     */   public IOURingParams sq_entries(@NativeType("__u32") int value) {
/* 136 */     nsq_entries(address(), value); return this;
/*     */   } public IOURingParams cq_entries(@NativeType("__u32") int value) {
/* 138 */     ncq_entries(address(), value); return this;
/*     */   } public IOURingParams flags(@NativeType("__u32") int value) {
/* 140 */     nflags(address(), value); return this;
/*     */   } public IOURingParams sq_thread_cpu(@NativeType("__u32") int value) {
/* 142 */     nsq_thread_cpu(address(), value); return this;
/*     */   } public IOURingParams sq_thread_idle(@NativeType("__u32") int value) {
/* 144 */     nsq_thread_idle(address(), value); return this;
/*     */   } public IOURingParams features(@NativeType("__u32") int value) {
/* 146 */     nfeatures(address(), value); return this;
/*     */   } public IOURingParams wq_fd(@NativeType("__u32") int value) {
/* 148 */     nwq_fd(address(), value); return this;
/*     */   } public IOURingParams sq_off(@NativeType("struct io_sqring_offsets") IOSQRingOffsets value) {
/* 150 */     nsq_off(address(), value); return this;
/*     */   } public IOURingParams sq_off(Consumer<IOSQRingOffsets> consumer) {
/* 152 */     consumer.accept(sq_off()); return this;
/*     */   } public IOURingParams cq_off(@NativeType("struct io_cqring_offsets") IOCQRingOffsets value) {
/* 154 */     ncq_off(address(), value); return this;
/*     */   } public IOURingParams cq_off(Consumer<IOCQRingOffsets> consumer) {
/* 156 */     consumer.accept(cq_off()); return this;
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
/*     */   public IOURingParams set(int sq_entries, int cq_entries, int flags, int sq_thread_cpu, int sq_thread_idle, int features, int wq_fd, IOSQRingOffsets sq_off, IOCQRingOffsets cq_off) {
/* 170 */     sq_entries(sq_entries);
/* 171 */     cq_entries(cq_entries);
/* 172 */     flags(flags);
/* 173 */     sq_thread_cpu(sq_thread_cpu);
/* 174 */     sq_thread_idle(sq_thread_idle);
/* 175 */     features(features);
/* 176 */     wq_fd(wq_fd);
/* 177 */     sq_off(sq_off);
/* 178 */     cq_off(cq_off);
/*     */     
/* 180 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingParams set(IOURingParams src) {
/* 191 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 192 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingParams malloc() {
/* 199 */     return new IOURingParams(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingParams calloc() {
/* 204 */     return new IOURingParams(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingParams create() {
/* 209 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 210 */     return new IOURingParams(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingParams create(long address) {
/* 215 */     return new IOURingParams(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingParams createSafe(long address) {
/* 220 */     return (address == 0L) ? null : new IOURingParams(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 229 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 238 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 247 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 248 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 258 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 263 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingParams malloc(MemoryStack stack) {
/* 272 */     return new IOURingParams(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingParams calloc(MemoryStack stack) {
/* 281 */     return new IOURingParams(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 291 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 301 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nsq_entries(long struct) {
/* 307 */     return MemoryUtil.memGetInt(struct + SQ_ENTRIES);
/*     */   } public static int ncq_entries(long struct) {
/* 309 */     return MemoryUtil.memGetInt(struct + CQ_ENTRIES);
/*     */   } public static int nflags(long struct) {
/* 311 */     return MemoryUtil.memGetInt(struct + FLAGS);
/*     */   } public static int nsq_thread_cpu(long struct) {
/* 313 */     return MemoryUtil.memGetInt(struct + SQ_THREAD_CPU);
/*     */   } public static int nsq_thread_idle(long struct) {
/* 315 */     return MemoryUtil.memGetInt(struct + SQ_THREAD_IDLE);
/*     */   } public static int nfeatures(long struct) {
/* 317 */     return MemoryUtil.memGetInt(struct + FEATURES);
/*     */   }
/* 319 */   public static int nwq_fd(long struct) { return MemoryUtil.memGetInt(struct + WQ_FD); } public static IntBuffer nresv(long struct) {
/* 320 */     return MemoryUtil.memIntBuffer(struct + RESV, 3);
/*     */   } public static int nresv(long struct, int index) {
/* 322 */     return MemoryUtil.memGetInt(struct + RESV + Checks.check(index, 3) * 4L);
/*     */   }
/*     */   public static IOSQRingOffsets nsq_off(long struct) {
/* 325 */     return IOSQRingOffsets.create(struct + SQ_OFF);
/*     */   } public static IOCQRingOffsets ncq_off(long struct) {
/* 327 */     return IOCQRingOffsets.create(struct + CQ_OFF);
/*     */   }
/*     */   public static void nsq_entries(long struct, int value) {
/* 330 */     MemoryUtil.memPutInt(struct + SQ_ENTRIES, value);
/*     */   } public static void ncq_entries(long struct, int value) {
/* 332 */     MemoryUtil.memPutInt(struct + CQ_ENTRIES, value);
/*     */   } public static void nflags(long struct, int value) {
/* 334 */     MemoryUtil.memPutInt(struct + FLAGS, value);
/*     */   } public static void nsq_thread_cpu(long struct, int value) {
/* 336 */     MemoryUtil.memPutInt(struct + SQ_THREAD_CPU, value);
/*     */   } public static void nsq_thread_idle(long struct, int value) {
/* 338 */     MemoryUtil.memPutInt(struct + SQ_THREAD_IDLE, value);
/*     */   } public static void nfeatures(long struct, int value) {
/* 340 */     MemoryUtil.memPutInt(struct + FEATURES, value);
/*     */   } public static void nwq_fd(long struct, int value) {
/* 342 */     MemoryUtil.memPutInt(struct + WQ_FD, value);
/*     */   } public static void nresv(long struct, IntBuffer value) {
/* 344 */     if (Checks.CHECKS) Checks.checkGT(value, 3); 
/* 345 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + RESV, (value.remaining() * 4));
/*     */   }
/*     */   public static void nresv(long struct, int index, int value) {
/* 348 */     MemoryUtil.memPutInt(struct + RESV + Checks.check(index, 3) * 4L, value);
/*     */   }
/*     */   public static void nsq_off(long struct, IOSQRingOffsets value) {
/* 351 */     MemoryUtil.memCopy(value.address(), struct + SQ_OFF, IOSQRingOffsets.SIZEOF);
/*     */   } public static void ncq_off(long struct, IOCQRingOffsets value) {
/* 353 */     MemoryUtil.memCopy(value.address(), struct + CQ_OFF, IOCQRingOffsets.SIZEOF);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingParams, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 360 */     private static final IOURingParams ELEMENT_FACTORY = IOURingParams.create(-1L);
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
/* 372 */       super(container, container.remaining() / IOURingParams.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 376 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 380 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 385 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 390 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingParams getElementFactory() {
/* 395 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int sq_entries() {
/* 400 */       return IOURingParams.nsq_entries(address());
/*     */     } @NativeType("__u32")
/*     */     public int cq_entries() {
/* 403 */       return IOURingParams.ncq_entries(address());
/*     */     } @NativeType("__u32")
/*     */     public int flags() {
/* 406 */       return IOURingParams.nflags(address());
/*     */     } @NativeType("__u32")
/*     */     public int sq_thread_cpu() {
/* 409 */       return IOURingParams.nsq_thread_cpu(address());
/*     */     } @NativeType("__u32")
/*     */     public int sq_thread_idle() {
/* 412 */       return IOURingParams.nsq_thread_idle(address());
/*     */     } @NativeType("__u32")
/*     */     public int features() {
/* 415 */       return IOURingParams.nfeatures(address());
/*     */     } @NativeType("__u32")
/*     */     public int wq_fd() {
/* 418 */       return IOURingParams.nwq_fd(address());
/*     */     } @NativeType("struct io_sqring_offsets")
/*     */     public IOSQRingOffsets sq_off() {
/* 421 */       return IOURingParams.nsq_off(address());
/*     */     } @NativeType("struct io_cqring_offsets")
/*     */     public IOCQRingOffsets cq_off() {
/* 424 */       return IOURingParams.ncq_off(address());
/*     */     }
/*     */     public Buffer sq_entries(@NativeType("__u32") int value) {
/* 427 */       IOURingParams.nsq_entries(address(), value); return this;
/*     */     } public Buffer cq_entries(@NativeType("__u32") int value) {
/* 429 */       IOURingParams.ncq_entries(address(), value); return this;
/*     */     } public Buffer flags(@NativeType("__u32") int value) {
/* 431 */       IOURingParams.nflags(address(), value); return this;
/*     */     } public Buffer sq_thread_cpu(@NativeType("__u32") int value) {
/* 433 */       IOURingParams.nsq_thread_cpu(address(), value); return this;
/*     */     } public Buffer sq_thread_idle(@NativeType("__u32") int value) {
/* 435 */       IOURingParams.nsq_thread_idle(address(), value); return this;
/*     */     } public Buffer features(@NativeType("__u32") int value) {
/* 437 */       IOURingParams.nfeatures(address(), value); return this;
/*     */     } public Buffer wq_fd(@NativeType("__u32") int value) {
/* 439 */       IOURingParams.nwq_fd(address(), value); return this;
/*     */     } public Buffer sq_off(@NativeType("struct io_sqring_offsets") IOSQRingOffsets value) {
/* 441 */       IOURingParams.nsq_off(address(), value); return this;
/*     */     } public Buffer sq_off(Consumer<IOSQRingOffsets> consumer) {
/* 443 */       consumer.accept(sq_off()); return this;
/*     */     } public Buffer cq_off(@NativeType("struct io_cqring_offsets") IOCQRingOffsets value) {
/* 445 */       IOURingParams.ncq_off(address(), value); return this;
/*     */     } public Buffer cq_off(Consumer<IOCQRingOffsets> consumer) {
/* 447 */       consumer.accept(cq_off()); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingParams.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */