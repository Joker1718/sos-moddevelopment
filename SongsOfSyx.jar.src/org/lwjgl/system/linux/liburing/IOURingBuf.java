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
/*     */ @NativeType("struct io_uring_buf")
/*     */ public class IOURingBuf
/*     */   extends Struct<IOURingBuf>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int ADDR;
/*     */   public static final int LEN;
/*     */   public static final int BID;
/*     */   public static final int RESV;
/*     */   
/*     */   static {
/*  44 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  45 */           __member(8), 
/*  46 */           __member(4), 
/*  47 */           __member(2), 
/*  48 */           __member(2)
/*     */         });
/*     */     
/*  51 */     SIZEOF = layout.getSize();
/*  52 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  54 */     ADDR = layout.offsetof(0);
/*  55 */     LEN = layout.offsetof(1);
/*  56 */     BID = layout.offsetof(2);
/*  57 */     RESV = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected IOURingBuf(long address, ByteBuffer container) {
/*  61 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingBuf create(long address, ByteBuffer container) {
/*  66 */     return new IOURingBuf(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingBuf(ByteBuffer container) {
/*  76 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  80 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u64")
/*     */   public long addr() {
/*  84 */     return naddr(address());
/*     */   } @NativeType("__u32")
/*     */   public int len() {
/*  87 */     return nlen(address());
/*     */   } @NativeType("__u16")
/*     */   public short bid() {
/*  90 */     return nbid(address());
/*     */   }
/*     */   public IOURingBuf addr(@NativeType("__u64") long value) {
/*  93 */     naddr(address(), value); return this;
/*     */   } public IOURingBuf len(@NativeType("__u32") int value) {
/*  95 */     nlen(address(), value); return this;
/*     */   } public IOURingBuf bid(@NativeType("__u16") short value) {
/*  97 */     nbid(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingBuf set(long addr, int len, short bid) {
/* 105 */     addr(addr);
/* 106 */     len(len);
/* 107 */     bid(bid);
/*     */     
/* 109 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingBuf set(IOURingBuf src) {
/* 120 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 121 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBuf malloc() {
/* 128 */     return new IOURingBuf(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBuf calloc() {
/* 133 */     return new IOURingBuf(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBuf create() {
/* 138 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 139 */     return new IOURingBuf(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBuf create(long address) {
/* 144 */     return new IOURingBuf(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingBuf createSafe(long address) {
/* 149 */     return (address == 0L) ? null : new IOURingBuf(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 158 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 167 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 176 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 177 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 187 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 192 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBuf malloc(MemoryStack stack) {
/* 201 */     return new IOURingBuf(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingBuf calloc(MemoryStack stack) {
/* 210 */     return new IOURingBuf(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 220 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 230 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long naddr(long struct) {
/* 236 */     return MemoryUtil.memGetLong(struct + ADDR);
/*     */   } public static int nlen(long struct) {
/* 238 */     return MemoryUtil.memGetInt(struct + LEN);
/*     */   }
/* 240 */   public static short nbid(long struct) { return MemoryUtil.memGetShort(struct + BID); } public static short nresv(long struct) {
/* 241 */     return MemoryUtil.memGetShort(struct + RESV);
/*     */   }
/*     */   public static void naddr(long struct, long value) {
/* 244 */     MemoryUtil.memPutLong(struct + ADDR, value);
/*     */   } public static void nlen(long struct, int value) {
/* 246 */     MemoryUtil.memPutInt(struct + LEN, value);
/*     */   }
/* 248 */   public static void nbid(long struct, short value) { MemoryUtil.memPutShort(struct + BID, value); } public static void nresv(long struct, short value) {
/* 249 */     MemoryUtil.memPutShort(struct + RESV, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingBuf, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 256 */     private static final IOURingBuf ELEMENT_FACTORY = IOURingBuf.create(-1L);
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
/* 268 */       super(container, container.remaining() / IOURingBuf.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 272 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 276 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 281 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 286 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingBuf getElementFactory() {
/* 291 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u64")
/*     */     public long addr() {
/* 296 */       return IOURingBuf.naddr(address());
/*     */     } @NativeType("__u32")
/*     */     public int len() {
/* 299 */       return IOURingBuf.nlen(address());
/*     */     } @NativeType("__u16")
/*     */     public short bid() {
/* 302 */       return IOURingBuf.nbid(address());
/*     */     }
/*     */     public Buffer addr(@NativeType("__u64") long value) {
/* 305 */       IOURingBuf.naddr(address(), value); return this;
/*     */     } public Buffer len(@NativeType("__u32") int value) {
/* 307 */       IOURingBuf.nlen(address(), value); return this;
/*     */     } public Buffer bid(@NativeType("__u16") short value) {
/* 309 */       IOURingBuf.nbid(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingBuf.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */