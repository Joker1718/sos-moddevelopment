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
/*     */ @NativeType("struct io_uring_buf_ring")
/*     */ public class IOURingBufRing
/*     */   extends Struct<IOURingBufRing>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int RESV1;
/*     */   public static final int RESV2;
/*     */   public static final int RESV3;
/*     */   public static final int TAIL;
/*     */   public static final int BUFS;
/*     */   
/*     */   static {
/*  51 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  52 */           (Struct.Member)__union(new Struct.Member[] {
/*  53 */               (Struct.Member)__struct(new Struct.Member[] {
/*  54 */                   __member(8), 
/*  55 */                   __member(4), 
/*  56 */                   __member(2), 
/*  57 */                   __member(2)
/*     */                 
/*  59 */                 }), __array(IOURingBuf.SIZEOF, IOURingBuf.ALIGNOF, 0)
/*     */             })
/*     */         });
/*     */     
/*  63 */     SIZEOF = layout.getSize();
/*  64 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  66 */     RESV1 = layout.offsetof(2);
/*  67 */     RESV2 = layout.offsetof(3);
/*  68 */     RESV3 = layout.offsetof(4);
/*  69 */     TAIL = layout.offsetof(5);
/*  70 */     BUFS = layout.offsetof(6);
/*     */   }
/*     */   
/*     */   protected IOURingBufRing(long address, ByteBuffer container) {
/*  74 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingBufRing create(long address, ByteBuffer container) {
/*  79 */     return new IOURingBufRing(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingBufRing(ByteBuffer container) {
/*  89 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  93 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u64")
/*     */   public long resv1() {
/*  97 */     return nresv1(address());
/*     */   } @NativeType("__u32")
/*     */   public int resv2() {
/* 100 */     return nresv2(address());
/*     */   } @NativeType("__u16")
/*     */   public short resv3() {
/* 103 */     return nresv3(address());
/*     */   } @NativeType("__u16")
/*     */   public short tail() {
/* 106 */     return ntail(address());
/*     */   } @NativeType("struct io_uring_buf[0]")
/*     */   public IOURingBuf.Buffer bufs() {
/* 109 */     return nbufs(address());
/*     */   } @NativeType("struct io_uring_buf")
/*     */   public IOURingBuf bufs(int index) {
/* 112 */     return nbufs(address(), index);
/*     */   }
/*     */   public IOURingBufRing resv1(@NativeType("__u64") long value) {
/* 115 */     nresv1(address(), value); return this;
/*     */   } public IOURingBufRing resv2(@NativeType("__u32") int value) {
/* 117 */     nresv2(address(), value); return this;
/*     */   } public IOURingBufRing resv3(@NativeType("__u16") short value) {
/* 119 */     nresv3(address(), value); return this;
/*     */   } public IOURingBufRing tail(@NativeType("__u16") short value) {
/* 121 */     ntail(address(), value); return this;
/*     */   } public IOURingBufRing bufs(@NativeType("struct io_uring_buf[0]") IOURingBuf.Buffer value) {
/* 123 */     nbufs(address(), value); return this;
/*     */   } public IOURingBufRing bufs(int index, @NativeType("struct io_uring_buf") IOURingBuf value) {
/* 125 */     nbufs(address(), index, value); return this;
/*     */   } public IOURingBufRing bufs(Consumer<IOURingBuf.Buffer> consumer) {
/* 127 */     consumer.accept(bufs()); return this;
/*     */   } public IOURingBufRing bufs(int index, Consumer<IOURingBuf> consumer) {
/* 129 */     consumer.accept(bufs(index)); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingBufRing set(IOURingBufRing src) {
/* 139 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 140 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBufRing malloc() {
/* 147 */     return new IOURingBufRing(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBufRing calloc() {
/* 152 */     return new IOURingBufRing(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBufRing create() {
/* 157 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 158 */     return new IOURingBufRing(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBufRing create(long address) {
/* 163 */     return new IOURingBufRing(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBufRing createSafe(long address) {
/* 168 */     return (address == 0L) ? null : new IOURingBufRing(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 177 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 186 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 195 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 196 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 206 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 211 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBufRing malloc(MemoryStack stack) {
/* 220 */     return new IOURingBufRing(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBufRing calloc(MemoryStack stack) {
/* 229 */     return new IOURingBufRing(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 239 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 249 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nresv1(long struct) {
/* 255 */     return MemoryUtil.memGetLong(struct + RESV1);
/*     */   } public static int nresv2(long struct) {
/* 257 */     return MemoryUtil.memGetInt(struct + RESV2);
/*     */   } public static short nresv3(long struct) {
/* 259 */     return MemoryUtil.memGetShort(struct + RESV3);
/*     */   } public static short ntail(long struct) {
/* 261 */     return MemoryUtil.memGetShort(struct + TAIL);
/*     */   } public static IOURingBuf.Buffer nbufs(long struct) {
/* 263 */     return IOURingBuf.create(struct + BUFS, 0);
/*     */   }
/*     */   public static IOURingBuf nbufs(long struct, int index) {
/* 266 */     return IOURingBuf.create(struct + BUFS + Checks.check(index, 0) * IOURingBuf.SIZEOF);
/*     */   }
/*     */   
/*     */   public static void nresv1(long struct, long value) {
/* 270 */     MemoryUtil.memPutLong(struct + RESV1, value);
/*     */   } public static void nresv2(long struct, int value) {
/* 272 */     MemoryUtil.memPutInt(struct + RESV2, value);
/*     */   } public static void nresv3(long struct, short value) {
/* 274 */     MemoryUtil.memPutShort(struct + RESV3, value);
/*     */   } public static void ntail(long struct, short value) {
/* 276 */     MemoryUtil.memPutShort(struct + TAIL, value);
/*     */   }
/*     */   public static void nbufs(long struct, IOURingBuf.Buffer value) {
/* 279 */     if (Checks.CHECKS) Checks.checkGT((CustomBuffer)value, 0); 
/* 280 */     MemoryUtil.memCopy(value.address(), struct + BUFS, (value.remaining() * IOURingBuf.SIZEOF));
/*     */   }
/*     */   
/*     */   public static void nbufs(long struct, int index, IOURingBuf value) {
/* 284 */     MemoryUtil.memCopy(value.address(), struct + BUFS + Checks.check(index, 0) * IOURingBuf.SIZEOF, IOURingBuf.SIZEOF);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingBufRing, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 292 */     private static final IOURingBufRing ELEMENT_FACTORY = IOURingBufRing.create(-1L);
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
/* 304 */       super(container, container.remaining() / IOURingBufRing.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 308 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 312 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 317 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 322 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingBufRing getElementFactory() {
/* 327 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long resv1() {
/* 332 */       return IOURingBufRing.nresv1(address());
/*     */     } @NativeType("__u32")
/*     */     public int resv2() {
/* 335 */       return IOURingBufRing.nresv2(address());
/*     */     } @NativeType("__u16")
/*     */     public short resv3() {
/* 338 */       return IOURingBufRing.nresv3(address());
/*     */     } @NativeType("__u16")
/*     */     public short tail() {
/* 341 */       return IOURingBufRing.ntail(address());
/*     */     } @NativeType("struct io_uring_buf[0]")
/*     */     public IOURingBuf.Buffer bufs() {
/* 344 */       return IOURingBufRing.nbufs(address());
/*     */     } @NativeType("struct io_uring_buf")
/*     */     public IOURingBuf bufs(int index) {
/* 347 */       return IOURingBufRing.nbufs(address(), index);
/*     */     }
/*     */     public Buffer resv1(@NativeType("__u64") long value) {
/* 350 */       IOURingBufRing.nresv1(address(), value); return this;
/*     */     } public Buffer resv2(@NativeType("__u32") int value) {
/* 352 */       IOURingBufRing.nresv2(address(), value); return this;
/*     */     } public Buffer resv3(@NativeType("__u16") short value) {
/* 354 */       IOURingBufRing.nresv3(address(), value); return this;
/*     */     } public Buffer tail(@NativeType("__u16") short value) {
/* 356 */       IOURingBufRing.ntail(address(), value); return this;
/*     */     } public Buffer bufs(@NativeType("struct io_uring_buf[0]") IOURingBuf.Buffer value) {
/* 358 */       IOURingBufRing.nbufs(address(), value); return this;
/*     */     } public Buffer bufs(int index, @NativeType("struct io_uring_buf") IOURingBuf value) {
/* 360 */       IOURingBufRing.nbufs(address(), index, value); return this;
/*     */     } public Buffer bufs(Consumer<IOURingBuf.Buffer> consumer) {
/* 362 */       consumer.accept(bufs()); return this;
/*     */     } public Buffer bufs(int index, Consumer<IOURingBuf> consumer) {
/* 364 */       consumer.accept(bufs(index)); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingBufRing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */