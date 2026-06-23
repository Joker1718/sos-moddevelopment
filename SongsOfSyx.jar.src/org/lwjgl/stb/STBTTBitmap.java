/*     */ package org.lwjgl.stb;
/*     */ 
/*     */ import java.nio.ByteBuffer;
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
/*     */ @NativeType("struct stbtt__bitmap")
/*     */ public class STBTTBitmap
/*     */   extends Struct<STBTTBitmap>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int W;
/*     */   public static final int H;
/*     */   public static final int STRIDE;
/*     */   public static final int PIXELS;
/*     */   
/*     */   static {
/*  45 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  46 */           __member(4), 
/*  47 */           __member(4), 
/*  48 */           __member(4), 
/*  49 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  52 */     SIZEOF = layout.getSize();
/*  53 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  55 */     W = layout.offsetof(0);
/*  56 */     H = layout.offsetof(1);
/*  57 */     STRIDE = layout.offsetof(2);
/*  58 */     PIXELS = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected STBTTBitmap(long address, ByteBuffer container) {
/*  62 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected STBTTBitmap create(long address, ByteBuffer container) {
/*  67 */     return new STBTTBitmap(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTBitmap(ByteBuffer container) {
/*  77 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  81 */     return SIZEOF;
/*     */   }
/*     */   public int w() {
/*  84 */     return nw(address());
/*     */   } public int h() {
/*  86 */     return nh(address());
/*     */   } public int stride() {
/*  88 */     return nstride(address());
/*     */   } @NativeType("unsigned char *")
/*     */   public ByteBuffer pixels(int capacity) {
/*  91 */     return npixels(address(), capacity);
/*     */   }
/*     */   public STBTTBitmap w(int value) {
/*  94 */     nw(address(), value); return this;
/*     */   } public STBTTBitmap h(int value) {
/*  96 */     nh(address(), value); return this;
/*     */   } public STBTTBitmap stride(int value) {
/*  98 */     nstride(address(), value); return this;
/*     */   } public STBTTBitmap pixels(@NativeType("unsigned char *") ByteBuffer value) {
/* 100 */     npixels(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTBitmap set(int w, int h, int stride, ByteBuffer pixels) {
/* 109 */     w(w);
/* 110 */     h(h);
/* 111 */     stride(stride);
/* 112 */     pixels(pixels);
/*     */     
/* 114 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STBTTBitmap set(STBTTBitmap src) {
/* 125 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 126 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTBitmap malloc() {
/* 133 */     return new STBTTBitmap(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTBitmap calloc() {
/* 138 */     return new STBTTBitmap(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTBitmap create() {
/* 143 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 144 */     return new STBTTBitmap(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTBitmap create(long address) {
/* 149 */     return new STBTTBitmap(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static STBTTBitmap createSafe(long address) {
/* 154 */     return (address == 0L) ? null : new STBTTBitmap(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 163 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 172 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 181 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 182 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 192 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 197 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTBitmap malloc(MemoryStack stack) {
/* 206 */     return new STBTTBitmap(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static STBTTBitmap calloc(MemoryStack stack) {
/* 215 */     return new STBTTBitmap(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 225 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 235 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nw(long struct) {
/* 241 */     return MemoryUtil.memGetInt(struct + W);
/*     */   } public static int nh(long struct) {
/* 243 */     return MemoryUtil.memGetInt(struct + H);
/*     */   } public static int nstride(long struct) {
/* 245 */     return MemoryUtil.memGetInt(struct + STRIDE);
/*     */   } public static ByteBuffer npixels(long struct, int capacity) {
/* 247 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(struct + PIXELS), capacity);
/*     */   }
/*     */   public static void nw(long struct, int value) {
/* 250 */     MemoryUtil.memPutInt(struct + W, value);
/*     */   } public static void nh(long struct, int value) {
/* 252 */     MemoryUtil.memPutInt(struct + H, value);
/*     */   } public static void nstride(long struct, int value) {
/* 254 */     MemoryUtil.memPutInt(struct + STRIDE, value);
/*     */   } public static void npixels(long struct, ByteBuffer value) {
/* 256 */     MemoryUtil.memPutAddress(struct + PIXELS, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 264 */     Checks.check(MemoryUtil.memGetAddress(struct + PIXELS));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<STBTTBitmap, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 272 */     private static final STBTTBitmap ELEMENT_FACTORY = STBTTBitmap.create(-1L);
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
/* 284 */       super(container, container.remaining() / STBTTBitmap.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 288 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 292 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 297 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 302 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected STBTTBitmap getElementFactory() {
/* 307 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int w() {
/* 311 */       return STBTTBitmap.nw(address());
/*     */     } public int h() {
/* 313 */       return STBTTBitmap.nh(address());
/*     */     } public int stride() {
/* 315 */       return STBTTBitmap.nstride(address());
/*     */     } @NativeType("unsigned char *")
/*     */     public ByteBuffer pixels(int capacity) {
/* 318 */       return STBTTBitmap.npixels(address(), capacity);
/*     */     }
/*     */     public Buffer w(int value) {
/* 321 */       STBTTBitmap.nw(address(), value); return this;
/*     */     } public Buffer h(int value) {
/* 323 */       STBTTBitmap.nh(address(), value); return this;
/*     */     } public Buffer stride(int value) {
/* 325 */       STBTTBitmap.nstride(address(), value); return this;
/*     */     } public Buffer pixels(@NativeType("unsigned char *") ByteBuffer value) {
/* 327 */       STBTTBitmap.npixels(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBTTBitmap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */