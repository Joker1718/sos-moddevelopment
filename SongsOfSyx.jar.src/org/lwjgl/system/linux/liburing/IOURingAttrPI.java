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
/*     */ @NativeType("struct io_uring_attr_pi")
/*     */ public class IOURingAttrPI
/*     */   extends Struct<IOURingAttrPI>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int FLAGS;
/*     */   public static final int APP_TAG;
/*     */   public static final int LEN;
/*     */   public static final int ADDR;
/*     */   public static final int SEED;
/*     */   public static final int RSVD;
/*     */   
/*     */   static {
/*  48 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  49 */           __member(2), 
/*  50 */           __member(2), 
/*  51 */           __member(4), 
/*  52 */           __member(8), 
/*  53 */           __member(8), 
/*  54 */           __member(8)
/*     */         });
/*     */     
/*  57 */     SIZEOF = layout.getSize();
/*  58 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  60 */     FLAGS = layout.offsetof(0);
/*  61 */     APP_TAG = layout.offsetof(1);
/*  62 */     LEN = layout.offsetof(2);
/*  63 */     ADDR = layout.offsetof(3);
/*  64 */     SEED = layout.offsetof(4);
/*  65 */     RSVD = layout.offsetof(5);
/*     */   }
/*     */   
/*     */   protected IOURingAttrPI(long address, ByteBuffer container) {
/*  69 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected IOURingAttrPI create(long address, ByteBuffer container) {
/*  74 */     return new IOURingAttrPI(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingAttrPI(ByteBuffer container) {
/*  84 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  88 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("__u16")
/*     */   public short flags() {
/*  92 */     return nflags(address());
/*     */   } @NativeType("__u16")
/*     */   public short app_tag() {
/*  95 */     return napp_tag(address());
/*     */   } @NativeType("__u32")
/*     */   public int len() {
/*  98 */     return nlen(address());
/*     */   } @NativeType("__u64")
/*     */   public long addr() {
/* 101 */     return naddr(address());
/*     */   } @NativeType("__u64")
/*     */   public long seed() {
/* 104 */     return nseed(address());
/*     */   } @NativeType("__u64")
/*     */   public long rsvd() {
/* 107 */     return nrsvd(address());
/*     */   }
/*     */   public IOURingAttrPI flags(@NativeType("__u16") short value) {
/* 110 */     nflags(address(), value); return this;
/*     */   } public IOURingAttrPI app_tag(@NativeType("__u16") short value) {
/* 112 */     napp_tag(address(), value); return this;
/*     */   } public IOURingAttrPI len(@NativeType("__u32") int value) {
/* 114 */     nlen(address(), value); return this;
/*     */   } public IOURingAttrPI addr(@NativeType("__u64") long value) {
/* 116 */     naddr(address(), value); return this;
/*     */   } public IOURingAttrPI seed(@NativeType("__u64") long value) {
/* 118 */     nseed(address(), value); return this;
/*     */   } public IOURingAttrPI rsvd(@NativeType("__u64") long value) {
/* 120 */     nrsvd(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingAttrPI set(short flags, short app_tag, int len, long addr, long seed, long rsvd) {
/* 131 */     flags(flags);
/* 132 */     app_tag(app_tag);
/* 133 */     len(len);
/* 134 */     addr(addr);
/* 135 */     seed(seed);
/* 136 */     rsvd(rsvd);
/*     */     
/* 138 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOURingAttrPI set(IOURingAttrPI src) {
/* 149 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 150 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingAttrPI malloc() {
/* 157 */     return new IOURingAttrPI(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingAttrPI calloc() {
/* 162 */     return new IOURingAttrPI(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingAttrPI create() {
/* 167 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 168 */     return new IOURingAttrPI(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingAttrPI create(long address) {
/* 173 */     return new IOURingAttrPI(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static IOURingAttrPI createSafe(long address) {
/* 178 */     return (address == 0L) ? null : new IOURingAttrPI(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 187 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 196 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 205 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 206 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 216 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 221 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingAttrPI malloc(MemoryStack stack) {
/* 230 */     return new IOURingAttrPI(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IOURingAttrPI calloc(MemoryStack stack) {
/* 239 */     return new IOURingAttrPI(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 249 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 259 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short nflags(long struct) {
/* 265 */     return MemoryUtil.memGetShort(struct + FLAGS);
/*     */   } public static short napp_tag(long struct) {
/* 267 */     return MemoryUtil.memGetShort(struct + APP_TAG);
/*     */   } public static int nlen(long struct) {
/* 269 */     return MemoryUtil.memGetInt(struct + LEN);
/*     */   } public static long naddr(long struct) {
/* 271 */     return MemoryUtil.memGetLong(struct + ADDR);
/*     */   } public static long nseed(long struct) {
/* 273 */     return MemoryUtil.memGetLong(struct + SEED);
/*     */   } public static long nrsvd(long struct) {
/* 275 */     return MemoryUtil.memGetLong(struct + RSVD);
/*     */   }
/*     */   public static void nflags(long struct, short value) {
/* 278 */     MemoryUtil.memPutShort(struct + FLAGS, value);
/*     */   } public static void napp_tag(long struct, short value) {
/* 280 */     MemoryUtil.memPutShort(struct + APP_TAG, value);
/*     */   } public static void nlen(long struct, int value) {
/* 282 */     MemoryUtil.memPutInt(struct + LEN, value);
/*     */   } public static void naddr(long struct, long value) {
/* 284 */     MemoryUtil.memPutLong(struct + ADDR, value);
/*     */   } public static void nseed(long struct, long value) {
/* 286 */     MemoryUtil.memPutLong(struct + SEED, value);
/*     */   } public static void nrsvd(long struct, long value) {
/* 288 */     MemoryUtil.memPutLong(struct + RSVD, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<IOURingAttrPI, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 295 */     private static final IOURingAttrPI ELEMENT_FACTORY = IOURingAttrPI.create(-1L);
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
/* 307 */       super(container, container.remaining() / IOURingAttrPI.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 311 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 315 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 320 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 325 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected IOURingAttrPI getElementFactory() {
/* 330 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("__u16")
/*     */     public short flags() {
/* 335 */       return IOURingAttrPI.nflags(address());
/*     */     } @NativeType("__u16")
/*     */     public short app_tag() {
/* 338 */       return IOURingAttrPI.napp_tag(address());
/*     */     } @NativeType("__u32")
/*     */     public int len() {
/* 341 */       return IOURingAttrPI.nlen(address());
/*     */     } @NativeType("__u64")
/*     */     public long addr() {
/* 344 */       return IOURingAttrPI.naddr(address());
/*     */     } @NativeType("__u64")
/*     */     public long seed() {
/* 347 */       return IOURingAttrPI.nseed(address());
/*     */     } @NativeType("__u64")
/*     */     public long rsvd() {
/* 350 */       return IOURingAttrPI.nrsvd(address());
/*     */     }
/*     */     public Buffer flags(@NativeType("__u16") short value) {
/* 353 */       IOURingAttrPI.nflags(address(), value); return this;
/*     */     } public Buffer app_tag(@NativeType("__u16") short value) {
/* 355 */       IOURingAttrPI.napp_tag(address(), value); return this;
/*     */     } public Buffer len(@NativeType("__u32") int value) {
/* 357 */       IOURingAttrPI.nlen(address(), value); return this;
/*     */     } public Buffer addr(@NativeType("__u64") long value) {
/* 359 */       IOURingAttrPI.naddr(address(), value); return this;
/*     */     } public Buffer seed(@NativeType("__u64") long value) {
/* 361 */       IOURingAttrPI.nseed(address(), value); return this;
/*     */     } public Buffer rsvd(@NativeType("__u64") long value) {
/* 363 */       IOURingAttrPI.nrsvd(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\liburing\IOURingAttrPI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */