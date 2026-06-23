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
/*     */ @NativeType("struct io_uring_recvmsg_out")
/*     */ public class IOURingRecvmsgOut
/*     */   extends Struct<IOURingRecvmsgOut>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int NAMELEN;
/*     */   public static final int CONTROLLEN;
/*     */   public static final int PAYLOADLEN;
/*     */   public static final int FLAGS;
/*     */   
/*     */   static {
/*  44 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  45 */           __member(4), 
/*  46 */           __member(4), 
/*  47 */           __member(4), 
/*  48 */           __member(4)
/*     */         });
/*     */     
/*  51 */     SIZEOF = layout.getSize();
/*  52 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  54 */     NAMELEN = layout.offsetof(0);
/*  55 */     CONTROLLEN = layout.offsetof(1);
/*  56 */     PAYLOADLEN = layout.offsetof(2);
/*  57 */     FLAGS = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected IOURingRecvmsgOut(long address, ByteBuffer container) {
/*  61 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingRecvmsgOut create(long address, ByteBuffer container) {
/*  66 */     return new IOURingRecvmsgOut(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRecvmsgOut(ByteBuffer container) {
/*  76 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  80 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u32")
/*     */   public int namelen() {
/*  84 */     return nnamelen(address());
/*     */   } @NativeType("__u32")
/*     */   public int controllen() {
/*  87 */     return ncontrollen(address());
/*     */   } @NativeType("__u32")
/*     */   public int payloadlen() {
/*  90 */     return npayloadlen(address());
/*     */   } @NativeType("__u32")
/*     */   public int flags() {
/*  93 */     return nflags(address());
/*     */   }
/*     */   public IOURingRecvmsgOut namelen(@NativeType("__u32") int value) {
/*  96 */     nnamelen(address(), value); return this;
/*     */   } public IOURingRecvmsgOut controllen(@NativeType("__u32") int value) {
/*  98 */     ncontrollen(address(), value); return this;
/*     */   } public IOURingRecvmsgOut payloadlen(@NativeType("__u32") int value) {
/* 100 */     npayloadlen(address(), value); return this;
/*     */   } public IOURingRecvmsgOut flags(@NativeType("__u32") int value) {
/* 102 */     nflags(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRecvmsgOut set(int namelen, int controllen, int payloadlen, int flags) {
/* 111 */     namelen(namelen);
/* 112 */     controllen(controllen);
/* 113 */     payloadlen(payloadlen);
/* 114 */     flags(flags);
/*     */     
/* 116 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingRecvmsgOut set(IOURingRecvmsgOut src) {
/* 127 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 128 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRecvmsgOut malloc() {
/* 135 */     return new IOURingRecvmsgOut(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRecvmsgOut calloc() {
/* 140 */     return new IOURingRecvmsgOut(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRecvmsgOut create() {
/* 145 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 146 */     return new IOURingRecvmsgOut(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRecvmsgOut create(long address) {
/* 151 */     return new IOURingRecvmsgOut(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingRecvmsgOut createSafe(long address) {
/* 156 */     return (address == 0L) ? null : new IOURingRecvmsgOut(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 165 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 174 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 183 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 184 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 194 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 199 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRecvmsgOut malloc(MemoryStack stack) {
/* 208 */     return new IOURingRecvmsgOut(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingRecvmsgOut calloc(MemoryStack stack) {
/* 217 */     return new IOURingRecvmsgOut(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 227 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 237 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nnamelen(long struct) {
/* 243 */     return MemoryUtil.memGetInt(struct + NAMELEN);
/*     */   } public static int ncontrollen(long struct) {
/* 245 */     return MemoryUtil.memGetInt(struct + CONTROLLEN);
/*     */   } public static int npayloadlen(long struct) {
/* 247 */     return MemoryUtil.memGetInt(struct + PAYLOADLEN);
/*     */   } public static int nflags(long struct) {
/* 249 */     return MemoryUtil.memGetInt(struct + FLAGS);
/*     */   }
/*     */   public static void nnamelen(long struct, int value) {
/* 252 */     MemoryUtil.memPutInt(struct + NAMELEN, value);
/*     */   } public static void ncontrollen(long struct, int value) {
/* 254 */     MemoryUtil.memPutInt(struct + CONTROLLEN, value);
/*     */   } public static void npayloadlen(long struct, int value) {
/* 256 */     MemoryUtil.memPutInt(struct + PAYLOADLEN, value);
/*     */   } public static void nflags(long struct, int value) {
/* 258 */     MemoryUtil.memPutInt(struct + FLAGS, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingRecvmsgOut, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 265 */     private static final IOURingRecvmsgOut ELEMENT_FACTORY = IOURingRecvmsgOut.create(-1L);
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
/* 277 */       super(container, container.remaining() / IOURingRecvmsgOut.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 281 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 285 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 290 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 295 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingRecvmsgOut getElementFactory() {
/* 300 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u32")
/*     */     public int namelen() {
/* 305 */       return IOURingRecvmsgOut.nnamelen(address());
/*     */     } @NativeType("__u32")
/*     */     public int controllen() {
/* 308 */       return IOURingRecvmsgOut.ncontrollen(address());
/*     */     } @NativeType("__u32")
/*     */     public int payloadlen() {
/* 311 */       return IOURingRecvmsgOut.npayloadlen(address());
/*     */     } @NativeType("__u32")
/*     */     public int flags() {
/* 314 */       return IOURingRecvmsgOut.nflags(address());
/*     */     }
/*     */     public Buffer namelen(@NativeType("__u32") int value) {
/* 317 */       IOURingRecvmsgOut.nnamelen(address(), value); return this;
/*     */     } public Buffer controllen(@NativeType("__u32") int value) {
/* 319 */       IOURingRecvmsgOut.ncontrollen(address(), value); return this;
/*     */     } public Buffer payloadlen(@NativeType("__u32") int value) {
/* 321 */       IOURingRecvmsgOut.npayloadlen(address(), value); return this;
/*     */     } public Buffer flags(@NativeType("__u32") int value) {
/* 323 */       IOURingRecvmsgOut.nflags(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingRecvmsgOut.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */