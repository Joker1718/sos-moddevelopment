/*     */ package org.lwjgl.system.linux.liburing;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
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
/*     */ @NativeType("struct io_uring_rsrc_register")
/*     */ public class IOURingRSRCRegister
/*     */   extends Struct<IOURingRSRCRegister>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int NR;
/*     */   public static final int FLAGS;
/*     */   public static final int RESV2;
/*     */   public static final int DATA;
/*     */   public static final int TAGS;
/*     */   
/*     */   static {
/*  46 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  47 */           __member(4), 
/*  48 */           __member(4), 
/*  49 */           __member(8), 
/*  50 */           __member(8), 
/*  51 */           __member(8)
/*     */         });
/*     */     
/*  54 */     SIZEOF = layout.getSize();
/*  55 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  57 */     NR = layout.offsetof(0);
/*  58 */     FLAGS = layout.offsetof(1);
/*  59 */     RESV2 = layout.offsetof(2);
/*  60 */     DATA = layout.offsetof(3);
/*  61 */     TAGS = layout.offsetof(4);
/*     */   }
/*     */   
/*     */   protected IOURingRSRCRegister(long address, ByteBuffer container) {
/*  65 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingRSRCRegister create(long address, ByteBuffer container) {
/*  70 */     return new IOURingRSRCRegister(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRSRCRegister(ByteBuffer container) {
/*  80 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  84 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int nr() {
/*  88 */     return nnr(address());
/*     */   } @NativeType("__u32")
/*     */   public int flags() {
/*  91 */     return nflags(address());
/*     */   } @NativeType("__u64")
/*     */   public long data() {
/*  94 */     return ndata(address());
/*     */   } @NativeType("__u64")
/*     */   public long tags() {
/*  97 */     return ntags(address());
/*     */   }
/*     */   public IOURingRSRCRegister nr(@NativeType("__u32") int value) {
/* 100 */     nnr(address(), value); return this;
/*     */   } public IOURingRSRCRegister flags(@NativeType("__u32") int value) {
/* 102 */     nflags(address(), value); return this;
/*     */   } public IOURingRSRCRegister data(@NativeType("__u64") long value) {
/* 104 */     ndata(address(), value); return this;
/*     */   } public IOURingRSRCRegister tags(@NativeType("__u64") long value) {
/* 106 */     ntags(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRSRCRegister set(int nr, int flags, long data, long tags) {
/* 115 */     nr(nr);
/* 116 */     flags(flags);
/* 117 */     data(data);
/* 118 */     tags(tags);
/*     */     
/* 120 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRSRCRegister set(IOURingRSRCRegister src) {
/* 131 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 132 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCRegister malloc() {
/* 139 */     return new IOURingRSRCRegister(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCRegister calloc() {
/* 144 */     return new IOURingRSRCRegister(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCRegister create() {
/* 149 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 150 */     return new IOURingRSRCRegister(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCRegister create(long address) {
/* 155 */     return new IOURingRSRCRegister(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCRegister createSafe(long address) {
/* 160 */     return (address == 0L) ? null : new IOURingRSRCRegister(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 169 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 178 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 187 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 188 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 198 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 203 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCRegister malloc(MemoryStack stack) {
/* 212 */     return new IOURingRSRCRegister(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCRegister calloc(MemoryStack stack) {
/* 221 */     return new IOURingRSRCRegister(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 231 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 241 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nnr(long struct) {
/* 247 */     return MemoryUtil.memGetInt(struct + NR);
/*     */   }
/* 249 */   public static int nflags(long struct) { return MemoryUtil.memGetInt(struct + FLAGS); } public static long nresv2(long struct) {
/* 250 */     return MemoryUtil.memGetLong(struct + RESV2);
/*     */   } public static long ndata(long struct) {
/* 252 */     return MemoryUtil.memGetLong(struct + DATA);
/*     */   } public static long ntags(long struct) {
/* 254 */     return MemoryUtil.memGetLong(struct + TAGS);
/*     */   }
/*     */   public static void nnr(long struct, int value) {
/* 257 */     MemoryUtil.memPutInt(struct + NR, value);
/*     */   }
/* 259 */   public static void nflags(long struct, int value) { MemoryUtil.memPutInt(struct + FLAGS, value); } public static void nresv2(long struct, long value) {
/* 260 */     MemoryUtil.memPutLong(struct + RESV2, value);
/*     */   } public static void ndata(long struct, long value) {
/* 262 */     MemoryUtil.memPutLong(struct + DATA, value);
/*     */   } public static void ntags(long struct, long value) {
/* 264 */     MemoryUtil.memPutLong(struct + TAGS, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingRSRCRegister, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 271 */     private static final IOURingRSRCRegister ELEMENT_FACTORY = IOURingRSRCRegister.create(-1L);
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
/* 283 */       super(container, container.remaining() / IOURingRSRCRegister.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 287 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 291 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 296 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 301 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingRSRCRegister getElementFactory() {
/* 306 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int nr() {
/* 311 */       return IOURingRSRCRegister.nnr(address());
/*     */     } @NativeType("__u32")
/*     */     public int flags() {
/* 314 */       return IOURingRSRCRegister.nflags(address());
/*     */     } @NativeType("__u64")
/*     */     public long data() {
/* 317 */       return IOURingRSRCRegister.ndata(address());
/*     */     } @NativeType("__u64")
/*     */     public long tags() {
/* 320 */       return IOURingRSRCRegister.ntags(address());
/*     */     }
/*     */     public Buffer nr(@NativeType("__u32") int value) {
/* 323 */       IOURingRSRCRegister.nnr(address(), value); return this;
/*     */     } public Buffer flags(@NativeType("__u32") int value) {
/* 325 */       IOURingRSRCRegister.nflags(address(), value); return this;
/*     */     } public Buffer data(@NativeType("__u64") long value) {
/* 327 */       IOURingRSRCRegister.ndata(address(), value); return this;
/*     */     } public Buffer tags(@NativeType("__u64") long value) {
/* 329 */       IOURingRSRCRegister.ntags(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingRSRCRegister.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */