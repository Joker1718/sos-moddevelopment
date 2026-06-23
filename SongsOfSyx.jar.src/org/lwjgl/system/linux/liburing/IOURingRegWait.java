/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
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
/*     */ import org.lwjgl.system.linux.KernelTimespec;
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
/*     */ @NativeType("struct io_uring_reg_wait")
/*     */ public class IOURingRegWait
/*     */   extends Struct<IOURingRegWait>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int TS;
/*     */   public static final int MIN_WAIT_USEC;
/*     */   public static final int FLAGS;
/*     */   public static final int SIGMASK;
/*     */   public static final int SIGMASK_SZ;
/*     */   public static final int PAD;
/*     */   public static final int PAD2;
/*     */   
/*     */   static {
/*  53 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  54 */           __member(KernelTimespec.SIZEOF, KernelTimespec.ALIGNOF), 
/*  55 */           __member(4), 
/*  56 */           __member(4), 
/*  57 */           __member(8), 
/*  58 */           __member(4), 
/*  59 */           __array(4, 3), 
/*  60 */           __array(8, 2)
/*     */         });
/*     */     
/*  63 */     SIZEOF = layout.getSize();
/*  64 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  66 */     TS = layout.offsetof(0);
/*  67 */     MIN_WAIT_USEC = layout.offsetof(1);
/*  68 */     FLAGS = layout.offsetof(2);
/*  69 */     SIGMASK = layout.offsetof(3);
/*  70 */     SIGMASK_SZ = layout.offsetof(4);
/*  71 */     PAD = layout.offsetof(5);
/*  72 */     PAD2 = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected IOURingRegWait(long address, ByteBuffer container) {
/*  76 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingRegWait create(long address, ByteBuffer container) {
/*  81 */     return new IOURingRegWait(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRegWait(ByteBuffer container) {
/*  91 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  95 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("struct __kernel_timespec")
/*     */   public KernelTimespec ts() {
/*  99 */     return nts(address());
/*     */   } @NativeType("__u32")
/*     */   public int min_wait_usec() {
/* 102 */     return nmin_wait_usec(address());
/*     */   } @NativeType("__u32")
/*     */   public int flags() {
/* 105 */     return nflags(address());
/*     */   } @NativeType("__u64")
/*     */   public long sigmask() {
/* 108 */     return nsigmask(address());
/*     */   } @NativeType("__u32")
/*     */   public int sigmask_sz() {
/* 111 */     return nsigmask_sz(address());
/*     */   }
/*     */   public IOURingRegWait ts(@NativeType("struct __kernel_timespec") KernelTimespec value) {
/* 114 */     nts(address(), value); return this;
/*     */   } public IOURingRegWait ts(Consumer<KernelTimespec> consumer) {
/* 116 */     consumer.accept(ts()); return this;
/*     */   } public IOURingRegWait min_wait_usec(@NativeType("__u32") int value) {
/* 118 */     nmin_wait_usec(address(), value); return this;
/*     */   } public IOURingRegWait flags(@NativeType("__u32") int value) {
/* 120 */     nflags(address(), value); return this;
/*     */   } public IOURingRegWait sigmask(@NativeType("__u64") long value) {
/* 122 */     nsigmask(address(), value); return this;
/*     */   } public IOURingRegWait sigmask_sz(@NativeType("__u32") int value) {
/* 124 */     nsigmask_sz(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRegWait set(KernelTimespec ts, int min_wait_usec, int flags, long sigmask, int sigmask_sz) {
/* 134 */     ts(ts);
/* 135 */     min_wait_usec(min_wait_usec);
/* 136 */     flags(flags);
/* 137 */     sigmask(sigmask);
/* 138 */     sigmask_sz(sigmask_sz);
/*     */     
/* 140 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRegWait set(IOURingRegWait src) {
/* 151 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 152 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRegWait malloc() {
/* 159 */     return new IOURingRegWait(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRegWait calloc() {
/* 164 */     return new IOURingRegWait(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRegWait create() {
/* 169 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 170 */     return new IOURingRegWait(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRegWait create(long address) {
/* 175 */     return new IOURingRegWait(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRegWait createSafe(long address) {
/* 180 */     return (address == 0L) ? null : new IOURingRegWait(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 189 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 198 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 207 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 208 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 218 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 223 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRegWait malloc(MemoryStack stack) {
/* 232 */     return new IOURingRegWait(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRegWait calloc(MemoryStack stack) {
/* 241 */     return new IOURingRegWait(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 251 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 261 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static KernelTimespec nts(long struct) {
/* 267 */     return KernelTimespec.create(struct + TS);
/*     */   } public static int nmin_wait_usec(long struct) {
/* 269 */     return MemoryUtil.memGetInt(struct + MIN_WAIT_USEC);
/*     */   } public static int nflags(long struct) {
/* 271 */     return MemoryUtil.memGetInt(struct + FLAGS);
/*     */   } public static long nsigmask(long struct) {
/* 273 */     return MemoryUtil.memGetLong(struct + SIGMASK);
/*     */   }
/* 275 */   public static int nsigmask_sz(long struct) { return MemoryUtil.memGetInt(struct + SIGMASK_SZ); } public static IntBuffer npad(long struct) {
/* 276 */     return MemoryUtil.memIntBuffer(struct + PAD, 3);
/*     */   } public static int npad(long struct, int index) {
/* 278 */     return MemoryUtil.memGetInt(struct + PAD + Checks.check(index, 3) * 4L);
/*     */   } public static LongBuffer npad2(long struct) {
/* 280 */     return MemoryUtil.memLongBuffer(struct + PAD2, 2);
/*     */   } public static long npad2(long struct, int index) {
/* 282 */     return MemoryUtil.memGetLong(struct + PAD2 + Checks.check(index, 2) * 8L);
/*     */   }
/*     */   
/*     */   public static void nts(long struct, KernelTimespec value) {
/* 286 */     MemoryUtil.memCopy(value.address(), struct + TS, KernelTimespec.SIZEOF);
/*     */   } public static void nmin_wait_usec(long struct, int value) {
/* 288 */     MemoryUtil.memPutInt(struct + MIN_WAIT_USEC, value);
/*     */   } public static void nflags(long struct, int value) {
/* 290 */     MemoryUtil.memPutInt(struct + FLAGS, value);
/*     */   } public static void nsigmask(long struct, long value) {
/* 292 */     MemoryUtil.memPutLong(struct + SIGMASK, value);
/*     */   } public static void nsigmask_sz(long struct, int value) {
/* 294 */     MemoryUtil.memPutInt(struct + SIGMASK_SZ, value);
/*     */   } public static void npad(long struct, IntBuffer value) {
/* 296 */     if (Checks.CHECKS) Checks.checkGT(value, 3); 
/* 297 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + PAD, (value.remaining() * 4));
/*     */   }
/*     */   public static void npad(long struct, int index, int value) {
/* 300 */     MemoryUtil.memPutInt(struct + PAD + Checks.check(index, 3) * 4L, value);
/*     */   }
/*     */   public static void npad2(long struct, LongBuffer value) {
/* 303 */     if (Checks.CHECKS) Checks.checkGT(value, 2); 
/* 304 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + PAD2, (value.remaining() * 8));
/*     */   }
/*     */   public static void npad2(long struct, int index, long value) {
/* 307 */     MemoryUtil.memPutLong(struct + PAD2 + Checks.check(index, 2) * 8L, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingRegWait, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 315 */     private static final IOURingRegWait ELEMENT_FACTORY = IOURingRegWait.create(-1L);
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
/* 327 */       super(container, container.remaining() / IOURingRegWait.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 331 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 335 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 340 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 345 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingRegWait getElementFactory() {
/* 350 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("struct __kernel_timespec")
/*     */     public KernelTimespec ts() {
/* 355 */       return IOURingRegWait.nts(address());
/*     */     } @NativeType("__u32")
/*     */     public int min_wait_usec() {
/* 358 */       return IOURingRegWait.nmin_wait_usec(address());
/*     */     } @NativeType("__u32")
/*     */     public int flags() {
/* 361 */       return IOURingRegWait.nflags(address());
/*     */     } @NativeType("__u64")
/*     */     public long sigmask() {
/* 364 */       return IOURingRegWait.nsigmask(address());
/*     */     } @NativeType("__u32")
/*     */     public int sigmask_sz() {
/* 367 */       return IOURingRegWait.nsigmask_sz(address());
/*     */     }
/*     */     public Buffer ts(@NativeType("struct __kernel_timespec") KernelTimespec value) {
/* 370 */       IOURingRegWait.nts(address(), value); return this;
/*     */     } public Buffer ts(Consumer<KernelTimespec> consumer) {
/* 372 */       consumer.accept(ts()); return this;
/*     */     } public Buffer min_wait_usec(@NativeType("__u32") int value) {
/* 374 */       IOURingRegWait.nmin_wait_usec(address(), value); return this;
/*     */     } public Buffer flags(@NativeType("__u32") int value) {
/* 376 */       IOURingRegWait.nflags(address(), value); return this;
/*     */     } public Buffer sigmask(@NativeType("__u64") long value) {
/* 378 */       IOURingRegWait.nsigmask(address(), value); return this;
/*     */     } public Buffer sigmask_sz(@NativeType("__u32") int value) {
/* 380 */       IOURingRegWait.nsigmask_sz(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingRegWait.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */