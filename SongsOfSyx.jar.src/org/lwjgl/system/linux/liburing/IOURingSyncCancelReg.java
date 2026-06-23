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
/*     */ 
/*     */ @NativeType("struct io_uring_sync_cancel_reg")
/*     */ public class IOURingSyncCancelReg
/*     */   extends Struct<IOURingSyncCancelReg>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int ADDR;
/*     */   public static final int FD;
/*     */   public static final int FLAGS;
/*     */   public static final int TIMEOUT;
/*     */   public static final int OPCODE;
/*     */   public static final int PAD;
/*     */   public static final int PAD2;
/*     */   
/*     */   static {
/*  53 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  54 */           __member(8), 
/*  55 */           __member(4), 
/*  56 */           __member(4), 
/*  57 */           __member(KernelTimespec.SIZEOF, KernelTimespec.ALIGNOF), 
/*  58 */           __member(1), 
/*  59 */           __array(1, 7), 
/*  60 */           __array(8, 3)
/*     */         });
/*     */     
/*  63 */     SIZEOF = layout.getSize();
/*  64 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  66 */     ADDR = layout.offsetof(0);
/*  67 */     FD = layout.offsetof(1);
/*  68 */     FLAGS = layout.offsetof(2);
/*  69 */     TIMEOUT = layout.offsetof(3);
/*  70 */     OPCODE = layout.offsetof(4);
/*  71 */     PAD = layout.offsetof(5);
/*  72 */     PAD2 = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected IOURingSyncCancelReg(long address, ByteBuffer container) {
/*  76 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingSyncCancelReg create(long address, ByteBuffer container) {
/*  81 */     return new IOURingSyncCancelReg(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingSyncCancelReg(ByteBuffer container) {
/*  91 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  95 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u64")
/*     */   public long addr() {
/*  99 */     return naddr(address());
/*     */   } @NativeType("__s32")
/*     */   public int fd() {
/* 102 */     return nfd(address());
/*     */   } @NativeType("__u32")
/*     */   public int flags() {
/* 105 */     return nflags(address());
/*     */   } @NativeType("struct __kernel_timespec")
/*     */   public KernelTimespec timeout() {
/* 108 */     return ntimeout(address());
/*     */   } @NativeType("__u8")
/*     */   public byte opcode() {
/* 111 */     return nopcode(address());
/*     */   }
/*     */   public IOURingSyncCancelReg addr(@NativeType("__u64") long value) {
/* 114 */     naddr(address(), value); return this;
/*     */   } public IOURingSyncCancelReg fd(@NativeType("__s32") int value) {
/* 116 */     nfd(address(), value); return this;
/*     */   } public IOURingSyncCancelReg flags(@NativeType("__u32") int value) {
/* 118 */     nflags(address(), value); return this;
/*     */   } public IOURingSyncCancelReg timeout(@NativeType("struct __kernel_timespec") KernelTimespec value) {
/* 120 */     ntimeout(address(), value); return this;
/*     */   } public IOURingSyncCancelReg timeout(Consumer<KernelTimespec> consumer) {
/* 122 */     consumer.accept(timeout()); return this;
/*     */   } public IOURingSyncCancelReg opcode(@NativeType("__u8") byte value) {
/* 124 */     nopcode(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingSyncCancelReg set(long addr, int fd, int flags, KernelTimespec timeout, byte opcode) {
/* 134 */     addr(addr);
/* 135 */     fd(fd);
/* 136 */     flags(flags);
/* 137 */     timeout(timeout);
/* 138 */     opcode(opcode);
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
/*     */   public IOURingSyncCancelReg set(IOURingSyncCancelReg src) {
/* 151 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 152 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingSyncCancelReg malloc() {
/* 159 */     return new IOURingSyncCancelReg(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingSyncCancelReg calloc() {
/* 164 */     return new IOURingSyncCancelReg(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingSyncCancelReg create() {
/* 169 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 170 */     return new IOURingSyncCancelReg(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingSyncCancelReg create(long address) {
/* 175 */     return new IOURingSyncCancelReg(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingSyncCancelReg createSafe(long address) {
/* 180 */     return (address == 0L) ? null : new IOURingSyncCancelReg(address, null);
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
/*     */   public static IOURingSyncCancelReg malloc(MemoryStack stack) {
/* 232 */     return new IOURingSyncCancelReg(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingSyncCancelReg calloc(MemoryStack stack) {
/* 241 */     return new IOURingSyncCancelReg(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   public static long naddr(long struct) {
/* 267 */     return MemoryUtil.memGetLong(struct + ADDR);
/*     */   } public static int nfd(long struct) {
/* 269 */     return MemoryUtil.memGetInt(struct + FD);
/*     */   } public static int nflags(long struct) {
/* 271 */     return MemoryUtil.memGetInt(struct + FLAGS);
/*     */   } public static KernelTimespec ntimeout(long struct) {
/* 273 */     return KernelTimespec.create(struct + TIMEOUT);
/*     */   }
/* 275 */   public static byte nopcode(long struct) { return MemoryUtil.memGetByte(struct + OPCODE); } public static ByteBuffer npad(long struct) {
/* 276 */     return MemoryUtil.memByteBuffer(struct + PAD, 7);
/*     */   } public static byte npad(long struct, int index) {
/* 278 */     return MemoryUtil.memGetByte(struct + PAD + Checks.check(index, 7) * 1L);
/*     */   } public static LongBuffer npad2(long struct) {
/* 280 */     return MemoryUtil.memLongBuffer(struct + PAD2, 3);
/*     */   } public static long npad2(long struct, int index) {
/* 282 */     return MemoryUtil.memGetLong(struct + PAD2 + Checks.check(index, 3) * 8L);
/*     */   }
/*     */   
/*     */   public static void naddr(long struct, long value) {
/* 286 */     MemoryUtil.memPutLong(struct + ADDR, value);
/*     */   } public static void nfd(long struct, int value) {
/* 288 */     MemoryUtil.memPutInt(struct + FD, value);
/*     */   } public static void nflags(long struct, int value) {
/* 290 */     MemoryUtil.memPutInt(struct + FLAGS, value);
/*     */   } public static void ntimeout(long struct, KernelTimespec value) {
/* 292 */     MemoryUtil.memCopy(value.address(), struct + TIMEOUT, KernelTimespec.SIZEOF);
/*     */   } public static void nopcode(long struct, byte value) {
/* 294 */     MemoryUtil.memPutByte(struct + OPCODE, value);
/*     */   } public static void npad(long struct, ByteBuffer value) {
/* 296 */     if (Checks.CHECKS) Checks.checkGT(value, 7); 
/* 297 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + PAD, (value.remaining() * 1));
/*     */   }
/*     */   public static void npad(long struct, int index, byte value) {
/* 300 */     MemoryUtil.memPutByte(struct + PAD + Checks.check(index, 7) * 1L, value);
/*     */   }
/*     */   public static void npad2(long struct, LongBuffer value) {
/* 303 */     if (Checks.CHECKS) Checks.checkGT(value, 3); 
/* 304 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + PAD2, (value.remaining() * 8));
/*     */   }
/*     */   public static void npad2(long struct, int index, long value) {
/* 307 */     MemoryUtil.memPutLong(struct + PAD2 + Checks.check(index, 3) * 8L, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingSyncCancelReg, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 315 */     private static final IOURingSyncCancelReg ELEMENT_FACTORY = IOURingSyncCancelReg.create(-1L);
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
/* 327 */       super(container, container.remaining() / IOURingSyncCancelReg.SIZEOF);
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
/*     */     protected IOURingSyncCancelReg getElementFactory() {
/* 350 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long addr() {
/* 355 */       return IOURingSyncCancelReg.naddr(address());
/*     */     } @NativeType("__s32")
/*     */     public int fd() {
/* 358 */       return IOURingSyncCancelReg.nfd(address());
/*     */     } @NativeType("__u32")
/*     */     public int flags() {
/* 361 */       return IOURingSyncCancelReg.nflags(address());
/*     */     } @NativeType("struct __kernel_timespec")
/*     */     public KernelTimespec timeout() {
/* 364 */       return IOURingSyncCancelReg.ntimeout(address());
/*     */     } @NativeType("__u8")
/*     */     public byte opcode() {
/* 367 */       return IOURingSyncCancelReg.nopcode(address());
/*     */     }
/*     */     public Buffer addr(@NativeType("__u64") long value) {
/* 370 */       IOURingSyncCancelReg.naddr(address(), value); return this;
/*     */     } public Buffer fd(@NativeType("__s32") int value) {
/* 372 */       IOURingSyncCancelReg.nfd(address(), value); return this;
/*     */     } public Buffer flags(@NativeType("__u32") int value) {
/* 374 */       IOURingSyncCancelReg.nflags(address(), value); return this;
/*     */     } public Buffer timeout(@NativeType("struct __kernel_timespec") KernelTimespec value) {
/* 376 */       IOURingSyncCancelReg.ntimeout(address(), value); return this;
/*     */     } public Buffer timeout(Consumer<KernelTimespec> consumer) {
/* 378 */       consumer.accept(timeout()); return this;
/*     */     } public Buffer opcode(@NativeType("__u8") byte value) {
/* 380 */       IOURingSyncCancelReg.nopcode(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingSyncCancelReg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */