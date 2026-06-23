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
/*     */ @NativeType("struct io_uring_buf_reg")
/*     */ public class IOURingBufReg
/*     */   extends Struct<IOURingBufReg>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int RING_ADDR;
/*     */   public static final int RING_ENTRIES;
/*     */   public static final int BGID;
/*     */   public static final int FLAGS;
/*     */   public static final int RESV;
/*     */   
/*     */   static {
/*  47 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  48 */           __member(8), 
/*  49 */           __member(4), 
/*  50 */           __member(2), 
/*  51 */           __member(2), 
/*  52 */           __array(8, 3)
/*     */         });
/*     */     
/*  55 */     SIZEOF = layout.getSize();
/*  56 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  58 */     RING_ADDR = layout.offsetof(0);
/*  59 */     RING_ENTRIES = layout.offsetof(1);
/*  60 */     BGID = layout.offsetof(2);
/*  61 */     FLAGS = layout.offsetof(3);
/*  62 */     RESV = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected IOURingBufReg(long address, ByteBuffer container) {
/*  66 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingBufReg create(long address, ByteBuffer container) {
/*  71 */     return new IOURingBufReg(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingBufReg(ByteBuffer container) {
/*  81 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  85 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u64")
/*     */   public long ring_addr() {
/*  89 */     return nring_addr(address());
/*     */   } @NativeType("__u32")
/*     */   public int ring_entries() {
/*  92 */     return nring_entries(address());
/*     */   } @NativeType("__u16")
/*     */   public short bgid() {
/*  95 */     return nbgid(address());
/*     */   } @NativeType("__u16")
/*     */   public short flags() {
/*  98 */     return nflags(address());
/*     */   }
/*     */   public IOURingBufReg ring_addr(@NativeType("__u64") long value) {
/* 101 */     nring_addr(address(), value); return this;
/*     */   } public IOURingBufReg ring_entries(@NativeType("__u32") int value) {
/* 103 */     nring_entries(address(), value); return this;
/*     */   } public IOURingBufReg bgid(@NativeType("__u16") short value) {
/* 105 */     nbgid(address(), value); return this;
/*     */   } public IOURingBufReg flags(@NativeType("__u16") short value) {
/* 107 */     nflags(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingBufReg set(long ring_addr, int ring_entries, short bgid, short flags) {
/* 116 */     ring_addr(ring_addr);
/* 117 */     ring_entries(ring_entries);
/* 118 */     bgid(bgid);
/* 119 */     flags(flags);
/*     */     
/* 121 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingBufReg set(IOURingBufReg src) {
/* 132 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 133 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBufReg malloc() {
/* 140 */     return new IOURingBufReg(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBufReg calloc() {
/* 145 */     return new IOURingBufReg(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBufReg create() {
/* 150 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 151 */     return new IOURingBufReg(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBufReg create(long address) {
/* 156 */     return new IOURingBufReg(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBufReg createSafe(long address) {
/* 161 */     return (address == 0L) ? null : new IOURingBufReg(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 170 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 179 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 188 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 189 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 199 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 204 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBufReg malloc(MemoryStack stack) {
/* 213 */     return new IOURingBufReg(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBufReg calloc(MemoryStack stack) {
/* 222 */     return new IOURingBufReg(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 232 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 242 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nring_addr(long struct) {
/* 248 */     return MemoryUtil.memGetLong(struct + RING_ADDR);
/*     */   } public static int nring_entries(long struct) {
/* 250 */     return MemoryUtil.memGetInt(struct + RING_ENTRIES);
/*     */   } public static short nbgid(long struct) {
/* 252 */     return MemoryUtil.memGetShort(struct + BGID);
/*     */   }
/* 254 */   public static short nflags(long struct) { return MemoryUtil.memGetShort(struct + FLAGS); } public static LongBuffer nresv(long struct) {
/* 255 */     return MemoryUtil.memLongBuffer(struct + RESV, 3);
/*     */   } public static long nresv(long struct, int index) {
/* 257 */     return MemoryUtil.memGetLong(struct + RESV + Checks.check(index, 3) * 8L);
/*     */   }
/*     */   
/*     */   public static void nring_addr(long struct, long value) {
/* 261 */     MemoryUtil.memPutLong(struct + RING_ADDR, value);
/*     */   } public static void nring_entries(long struct, int value) {
/* 263 */     MemoryUtil.memPutInt(struct + RING_ENTRIES, value);
/*     */   } public static void nbgid(long struct, short value) {
/* 265 */     MemoryUtil.memPutShort(struct + BGID, value);
/*     */   } public static void nflags(long struct, short value) {
/* 267 */     MemoryUtil.memPutShort(struct + FLAGS, value);
/*     */   } public static void nresv(long struct, LongBuffer value) {
/* 269 */     if (Checks.CHECKS) Checks.checkGT(value, 3); 
/* 270 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + RESV, (value.remaining() * 8));
/*     */   }
/*     */   public static void nresv(long struct, int index, long value) {
/* 273 */     MemoryUtil.memPutLong(struct + RESV + Checks.check(index, 3) * 8L, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingBufReg, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 281 */     private static final IOURingBufReg ELEMENT_FACTORY = IOURingBufReg.create(-1L);
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
/* 293 */       super(container, container.remaining() / IOURingBufReg.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 297 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 301 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 306 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 311 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingBufReg getElementFactory() {
/* 316 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long ring_addr() {
/* 321 */       return IOURingBufReg.nring_addr(address());
/*     */     } @NativeType("__u32")
/*     */     public int ring_entries() {
/* 324 */       return IOURingBufReg.nring_entries(address());
/*     */     } @NativeType("__u16")
/*     */     public short bgid() {
/* 327 */       return IOURingBufReg.nbgid(address());
/*     */     } @NativeType("__u16")
/*     */     public short flags() {
/* 330 */       return IOURingBufReg.nflags(address());
/*     */     }
/*     */     public Buffer ring_addr(@NativeType("__u64") long value) {
/* 333 */       IOURingBufReg.nring_addr(address(), value); return this;
/*     */     } public Buffer ring_entries(@NativeType("__u32") int value) {
/* 335 */       IOURingBufReg.nring_entries(address(), value); return this;
/*     */     } public Buffer bgid(@NativeType("__u16") short value) {
/* 337 */       IOURingBufReg.nbgid(address(), value); return this;
/*     */     } public Buffer flags(@NativeType("__u16") short value) {
/* 339 */       IOURingBufReg.nflags(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingBufReg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */