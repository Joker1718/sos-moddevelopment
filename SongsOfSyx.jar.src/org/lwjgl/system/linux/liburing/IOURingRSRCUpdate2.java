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
/*     */ 
/*     */ @NativeType("struct io_uring_rsrc_update2")
/*     */ public class IOURingRSRCUpdate2
/*     */   extends Struct<IOURingRSRCUpdate2>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int OFFSET;
/*     */   public static final int RESV;
/*     */   public static final int DATA;
/*     */   public static final int TAGS;
/*     */   public static final int NR;
/*     */   public static final int RESV2;
/*     */   
/*     */   static {
/*  48 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  49 */           __member(4), 
/*  50 */           __member(4), 
/*  51 */           __member(8), 
/*  52 */           __member(8), 
/*  53 */           __member(4), 
/*  54 */           __member(4)
/*     */         });
/*     */     
/*  57 */     SIZEOF = layout.getSize();
/*  58 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  60 */     OFFSET = layout.offsetof(0);
/*  61 */     RESV = layout.offsetof(1);
/*  62 */     DATA = layout.offsetof(2);
/*  63 */     TAGS = layout.offsetof(3);
/*  64 */     NR = layout.offsetof(4);
/*  65 */     RESV2 = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected IOURingRSRCUpdate2(long address, ByteBuffer container) {
/*  69 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingRSRCUpdate2 create(long address, ByteBuffer container) {
/*  74 */     return new IOURingRSRCUpdate2(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRSRCUpdate2(ByteBuffer container) {
/*  84 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  88 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int offset() {
/*  92 */     return noffset(address());
/*     */   } @NativeType("__u64")
/*     */   public long data() {
/*  95 */     return ndata(address());
/*     */   } @NativeType("__u64")
/*     */   public long tags() {
/*  98 */     return ntags(address());
/*     */   } @NativeType("__u32")
/*     */   public int nr() {
/* 101 */     return nnr(address());
/*     */   }
/*     */   public IOURingRSRCUpdate2 offset(@NativeType("__u32") int value) {
/* 104 */     noffset(address(), value); return this;
/*     */   } public IOURingRSRCUpdate2 data(@NativeType("__u64") long value) {
/* 106 */     ndata(address(), value); return this;
/*     */   } public IOURingRSRCUpdate2 tags(@NativeType("__u64") long value) {
/* 108 */     ntags(address(), value); return this;
/*     */   } public IOURingRSRCUpdate2 nr(@NativeType("__u32") int value) {
/* 110 */     nnr(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRSRCUpdate2 set(int offset, long data, long tags, int nr) {
/* 119 */     offset(offset);
/* 120 */     data(data);
/* 121 */     tags(tags);
/* 122 */     nr(nr);
/*     */     
/* 124 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRSRCUpdate2 set(IOURingRSRCUpdate2 src) {
/* 135 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 136 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate2 malloc() {
/* 143 */     return new IOURingRSRCUpdate2(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate2 calloc() {
/* 148 */     return new IOURingRSRCUpdate2(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate2 create() {
/* 153 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 154 */     return new IOURingRSRCUpdate2(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate2 create(long address) {
/* 159 */     return new IOURingRSRCUpdate2(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate2 createSafe(long address) {
/* 164 */     return (address == 0L) ? null : new IOURingRSRCUpdate2(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 173 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 182 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 191 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 192 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 202 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 207 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate2 malloc(MemoryStack stack) {
/* 216 */     return new IOURingRSRCUpdate2(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRSRCUpdate2 calloc(MemoryStack stack) {
/* 225 */     return new IOURingRSRCUpdate2(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 235 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 245 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int noffset(long struct) {
/* 251 */     return MemoryUtil.memGetInt(struct + OFFSET); } public static int nresv(long struct) {
/* 252 */     return MemoryUtil.memGetInt(struct + RESV);
/*     */   } public static long ndata(long struct) {
/* 254 */     return MemoryUtil.memGetLong(struct + DATA);
/*     */   } public static long ntags(long struct) {
/* 256 */     return MemoryUtil.memGetLong(struct + TAGS);
/*     */   }
/* 258 */   public static int nnr(long struct) { return MemoryUtil.memGetInt(struct + NR); } public static int nresv2(long struct) {
/* 259 */     return MemoryUtil.memGetInt(struct + RESV2);
/*     */   }
/*     */   
/* 262 */   public static void noffset(long struct, int value) { MemoryUtil.memPutInt(struct + OFFSET, value); } public static void nresv(long struct, int value) {
/* 263 */     MemoryUtil.memPutInt(struct + RESV, value);
/*     */   } public static void ndata(long struct, long value) {
/* 265 */     MemoryUtil.memPutLong(struct + DATA, value);
/*     */   } public static void ntags(long struct, long value) {
/* 267 */     MemoryUtil.memPutLong(struct + TAGS, value);
/*     */   }
/* 269 */   public static void nnr(long struct, int value) { MemoryUtil.memPutInt(struct + NR, value); } public static void nresv2(long struct, int value) {
/* 270 */     MemoryUtil.memPutInt(struct + RESV2, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingRSRCUpdate2, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 277 */     private static final IOURingRSRCUpdate2 ELEMENT_FACTORY = IOURingRSRCUpdate2.create(-1L);
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
/* 289 */       super(container, container.remaining() / IOURingRSRCUpdate2.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 293 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 297 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 302 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 307 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingRSRCUpdate2 getElementFactory() {
/* 312 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int offset() {
/* 317 */       return IOURingRSRCUpdate2.noffset(address());
/*     */     } @NativeType("__u64")
/*     */     public long data() {
/* 320 */       return IOURingRSRCUpdate2.ndata(address());
/*     */     } @NativeType("__u64")
/*     */     public long tags() {
/* 323 */       return IOURingRSRCUpdate2.ntags(address());
/*     */     } @NativeType("__u32")
/*     */     public int nr() {
/* 326 */       return IOURingRSRCUpdate2.nnr(address());
/*     */     }
/*     */     public Buffer offset(@NativeType("__u32") int value) {
/* 329 */       IOURingRSRCUpdate2.noffset(address(), value); return this;
/*     */     } public Buffer data(@NativeType("__u64") long value) {
/* 331 */       IOURingRSRCUpdate2.ndata(address(), value); return this;
/*     */     } public Buffer tags(@NativeType("__u64") long value) {
/* 333 */       IOURingRSRCUpdate2.ntags(address(), value); return this;
/*     */     } public Buffer nr(@NativeType("__u32") int value) {
/* 335 */       IOURingRSRCUpdate2.nnr(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingRSRCUpdate2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */