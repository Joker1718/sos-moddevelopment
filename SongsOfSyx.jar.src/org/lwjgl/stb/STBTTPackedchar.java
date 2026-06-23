/*     */ package org.lwjgl.stb;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct stbtt_packedchar")
/*     */ public class STBTTPackedchar
/*     */   extends Struct<STBTTPackedchar>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int X0;
/*     */   public static final int Y0;
/*     */   public static final int X1;
/*     */   public static final int Y1;
/*     */   public static final int XOFF;
/*     */   public static final int YOFF;
/*     */   public static final int XADVANCE;
/*     */   public static final int XOFF2;
/*     */   public static final int YOFF2;
/*     */   
/*     */   static {
/*  54 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  55 */           __member(2), 
/*  56 */           __member(2), 
/*  57 */           __member(2), 
/*  58 */           __member(2), 
/*  59 */           __member(4), 
/*  60 */           __member(4), 
/*  61 */           __member(4), 
/*  62 */           __member(4), 
/*  63 */           __member(4)
/*     */         });
/*     */     
/*  66 */     SIZEOF = layout.getSize();
/*  67 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  69 */     X0 = layout.offsetof(0);
/*  70 */     Y0 = layout.offsetof(1);
/*  71 */     X1 = layout.offsetof(2);
/*  72 */     Y1 = layout.offsetof(3);
/*  73 */     XOFF = layout.offsetof(4);
/*  74 */     YOFF = layout.offsetof(5);
/*  75 */     XADVANCE = layout.offsetof(6);
/*  76 */     XOFF2 = layout.offsetof(7);
/*  77 */     YOFF2 = layout.offsetof(8);
/*     */   }
/*     */   
/*     */   protected STBTTPackedchar(long address, ByteBuffer container) {
/*  81 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBTTPackedchar create(long address, ByteBuffer container) {
/*  86 */     return new STBTTPackedchar(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTPackedchar(ByteBuffer container) {
/*  96 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 100 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("unsigned short")
/*     */   public short x0() {
/* 104 */     return nx0(address());
/*     */   } @NativeType("unsigned short")
/*     */   public short y0() {
/* 107 */     return ny0(address());
/*     */   } @NativeType("unsigned short")
/*     */   public short x1() {
/* 110 */     return nx1(address());
/*     */   } @NativeType("unsigned short")
/*     */   public short y1() {
/* 113 */     return ny1(address());
/*     */   } public float xoff() {
/* 115 */     return nxoff(address());
/*     */   } public float yoff() {
/* 117 */     return nyoff(address());
/*     */   } public float xadvance() {
/* 119 */     return nxadvance(address());
/*     */   } public float xoff2() {
/* 121 */     return nxoff2(address());
/*     */   } public float yoff2() {
/* 123 */     return nyoff2(address());
/*     */   }
/*     */   public STBTTPackedchar x0(@NativeType("unsigned short") short value) {
/* 126 */     nx0(address(), value); return this;
/*     */   } public STBTTPackedchar y0(@NativeType("unsigned short") short value) {
/* 128 */     ny0(address(), value); return this;
/*     */   } public STBTTPackedchar x1(@NativeType("unsigned short") short value) {
/* 130 */     nx1(address(), value); return this;
/*     */   } public STBTTPackedchar y1(@NativeType("unsigned short") short value) {
/* 132 */     ny1(address(), value); return this;
/*     */   } public STBTTPackedchar xoff(float value) {
/* 134 */     nxoff(address(), value); return this;
/*     */   } public STBTTPackedchar yoff(float value) {
/* 136 */     nyoff(address(), value); return this;
/*     */   } public STBTTPackedchar xadvance(float value) {
/* 138 */     nxadvance(address(), value); return this;
/*     */   } public STBTTPackedchar xoff2(float value) {
/* 140 */     nxoff2(address(), value); return this;
/*     */   } public STBTTPackedchar yoff2(float value) {
/* 142 */     nyoff2(address(), value); return this;
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
/*     */   public STBTTPackedchar set(short x0, short y0, short x1, short y1, float xoff, float yoff, float xadvance, float xoff2, float yoff2) {
/* 156 */     x0(x0);
/* 157 */     y0(y0);
/* 158 */     x1(x1);
/* 159 */     y1(y1);
/* 160 */     xoff(xoff);
/* 161 */     yoff(yoff);
/* 162 */     xadvance(xadvance);
/* 163 */     xoff2(xoff2);
/* 164 */     yoff2(yoff2);
/*     */     
/* 166 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTPackedchar set(STBTTPackedchar src) {
/* 177 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 178 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackedchar malloc() {
/* 185 */     return new STBTTPackedchar(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackedchar calloc() {
/* 190 */     return new STBTTPackedchar(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackedchar create() {
/* 195 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 196 */     return new STBTTPackedchar(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackedchar create(long address) {
/* 201 */     return new STBTTPackedchar(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTPackedchar createSafe(long address) {
/* 206 */     return (address == 0L) ? null : new STBTTPackedchar(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 215 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 224 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 233 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 234 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 244 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 249 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackedchar malloc(MemoryStack stack) {
/* 258 */     return new STBTTPackedchar(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTPackedchar calloc(MemoryStack stack) {
/* 267 */     return new STBTTPackedchar(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 277 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 287 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short nx0(long struct) {
/* 293 */     return MemoryUtil.memGetShort(struct + X0);
/*     */   } public static short ny0(long struct) {
/* 295 */     return MemoryUtil.memGetShort(struct + Y0);
/*     */   } public static short nx1(long struct) {
/* 297 */     return MemoryUtil.memGetShort(struct + X1);
/*     */   } public static short ny1(long struct) {
/* 299 */     return MemoryUtil.memGetShort(struct + Y1);
/*     */   } public static float nxoff(long struct) {
/* 301 */     return MemoryUtil.memGetFloat(struct + XOFF);
/*     */   } public static float nyoff(long struct) {
/* 303 */     return MemoryUtil.memGetFloat(struct + YOFF);
/*     */   } public static float nxadvance(long struct) {
/* 305 */     return MemoryUtil.memGetFloat(struct + XADVANCE);
/*     */   } public static float nxoff2(long struct) {
/* 307 */     return MemoryUtil.memGetFloat(struct + XOFF2);
/*     */   } public static float nyoff2(long struct) {
/* 309 */     return MemoryUtil.memGetFloat(struct + YOFF2);
/*     */   }
/*     */   public static void nx0(long struct, short value) {
/* 312 */     MemoryUtil.memPutShort(struct + X0, value);
/*     */   } public static void ny0(long struct, short value) {
/* 314 */     MemoryUtil.memPutShort(struct + Y0, value);
/*     */   } public static void nx1(long struct, short value) {
/* 316 */     MemoryUtil.memPutShort(struct + X1, value);
/*     */   } public static void ny1(long struct, short value) {
/* 318 */     MemoryUtil.memPutShort(struct + Y1, value);
/*     */   } public static void nxoff(long struct, float value) {
/* 320 */     MemoryUtil.memPutFloat(struct + XOFF, value);
/*     */   } public static void nyoff(long struct, float value) {
/* 322 */     MemoryUtil.memPutFloat(struct + YOFF, value);
/*     */   } public static void nxadvance(long struct, float value) {
/* 324 */     MemoryUtil.memPutFloat(struct + XADVANCE, value);
/*     */   } public static void nxoff2(long struct, float value) {
/* 326 */     MemoryUtil.memPutFloat(struct + XOFF2, value);
/*     */   } public static void nyoff2(long struct, float value) {
/* 328 */     MemoryUtil.memPutFloat(struct + YOFF2, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBTTPackedchar, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 335 */     private static final STBTTPackedchar ELEMENT_FACTORY = STBTTPackedchar.create(-1L);
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
/* 347 */       super(container, container.remaining() / STBTTPackedchar.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 351 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 355 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 360 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 365 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBTTPackedchar getElementFactory() {
/* 370 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("unsigned short")
/*     */     public short x0() {
/* 375 */       return STBTTPackedchar.nx0(address());
/*     */     } @NativeType("unsigned short")
/*     */     public short y0() {
/* 378 */       return STBTTPackedchar.ny0(address());
/*     */     } @NativeType("unsigned short")
/*     */     public short x1() {
/* 381 */       return STBTTPackedchar.nx1(address());
/*     */     } @NativeType("unsigned short")
/*     */     public short y1() {
/* 384 */       return STBTTPackedchar.ny1(address());
/*     */     } public float xoff() {
/* 386 */       return STBTTPackedchar.nxoff(address());
/*     */     } public float yoff() {
/* 388 */       return STBTTPackedchar.nyoff(address());
/*     */     } public float xadvance() {
/* 390 */       return STBTTPackedchar.nxadvance(address());
/*     */     } public float xoff2() {
/* 392 */       return STBTTPackedchar.nxoff2(address());
/*     */     } public float yoff2() {
/* 394 */       return STBTTPackedchar.nyoff2(address());
/*     */     }
/*     */     public Buffer x0(@NativeType("unsigned short") short value) {
/* 397 */       STBTTPackedchar.nx0(address(), value); return this;
/*     */     } public Buffer y0(@NativeType("unsigned short") short value) {
/* 399 */       STBTTPackedchar.ny0(address(), value); return this;
/*     */     } public Buffer x1(@NativeType("unsigned short") short value) {
/* 401 */       STBTTPackedchar.nx1(address(), value); return this;
/*     */     } public Buffer y1(@NativeType("unsigned short") short value) {
/* 403 */       STBTTPackedchar.ny1(address(), value); return this;
/*     */     } public Buffer xoff(float value) {
/* 405 */       STBTTPackedchar.nxoff(address(), value); return this;
/*     */     } public Buffer yoff(float value) {
/* 407 */       STBTTPackedchar.nyoff(address(), value); return this;
/*     */     } public Buffer xadvance(float value) {
/* 409 */       STBTTPackedchar.nxadvance(address(), value); return this;
/*     */     } public Buffer xoff2(float value) {
/* 411 */       STBTTPackedchar.nxoff2(address(), value); return this;
/*     */     } public Buffer yoff2(float value) {
/* 413 */       STBTTPackedchar.nyoff2(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBTTPackedchar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */