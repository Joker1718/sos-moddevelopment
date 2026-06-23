/*     */ package org.lwjgl.system.jawt;
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
/*     */ @NativeType("struct JAWT_Rectangle")
/*     */ public class JAWTRectangle
/*     */   extends Struct<JAWTRectangle>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int X;
/*     */   public static final int Y;
/*     */   public static final int WIDTH;
/*     */   public static final int HEIGHT;
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
/*  54 */     X = layout.offsetof(0);
/*  55 */     Y = layout.offsetof(1);
/*  56 */     WIDTH = layout.offsetof(2);
/*  57 */     HEIGHT = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected JAWTRectangle(long address, ByteBuffer container) {
/*  61 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected JAWTRectangle create(long address, ByteBuffer container) {
/*  66 */     return new JAWTRectangle(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JAWTRectangle(ByteBuffer container) {
/*  76 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  80 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("jint")
/*     */   public int x() {
/*  84 */     return nx(address());
/*     */   } @NativeType("jint")
/*     */   public int y() {
/*  87 */     return ny(address());
/*     */   } @NativeType("jint")
/*     */   public int width() {
/*  90 */     return nwidth(address());
/*     */   } @NativeType("jint")
/*     */   public int height() {
/*  93 */     return nheight(address());
/*     */   }
/*     */   public JAWTRectangle x(@NativeType("jint") int value) {
/*  96 */     nx(address(), value); return this;
/*     */   } public JAWTRectangle y(@NativeType("jint") int value) {
/*  98 */     ny(address(), value); return this;
/*     */   } public JAWTRectangle width(@NativeType("jint") int value) {
/* 100 */     nwidth(address(), value); return this;
/*     */   } public JAWTRectangle height(@NativeType("jint") int value) {
/* 102 */     nheight(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JAWTRectangle set(int x, int y, int width, int height) {
/* 111 */     x(x);
/* 112 */     y(y);
/* 113 */     width(width);
/* 114 */     height(height);
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
/*     */   public JAWTRectangle set(JAWTRectangle src) {
/* 127 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 128 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JAWTRectangle malloc() {
/* 135 */     return new JAWTRectangle(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static JAWTRectangle calloc() {
/* 140 */     return new JAWTRectangle(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static JAWTRectangle create() {
/* 145 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 146 */     return new JAWTRectangle(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static JAWTRectangle create(long address) {
/* 151 */     return new JAWTRectangle(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static JAWTRectangle createSafe(long address) {
/* 156 */     return (address == 0L) ? null : new JAWTRectangle(address, null);
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
/*     */   public static JAWTRectangle malloc(MemoryStack stack) {
/* 208 */     return new JAWTRectangle(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JAWTRectangle calloc(MemoryStack stack) {
/* 217 */     return new JAWTRectangle(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   public static int nx(long struct) {
/* 243 */     return MemoryUtil.memGetInt(struct + X);
/*     */   } public static int ny(long struct) {
/* 245 */     return MemoryUtil.memGetInt(struct + Y);
/*     */   } public static int nwidth(long struct) {
/* 247 */     return MemoryUtil.memGetInt(struct + WIDTH);
/*     */   } public static int nheight(long struct) {
/* 249 */     return MemoryUtil.memGetInt(struct + HEIGHT);
/*     */   }
/*     */   public static void nx(long struct, int value) {
/* 252 */     MemoryUtil.memPutInt(struct + X, value);
/*     */   } public static void ny(long struct, int value) {
/* 254 */     MemoryUtil.memPutInt(struct + Y, value);
/*     */   } public static void nwidth(long struct, int value) {
/* 256 */     MemoryUtil.memPutInt(struct + WIDTH, value);
/*     */   } public static void nheight(long struct, int value) {
/* 258 */     MemoryUtil.memPutInt(struct + HEIGHT, value);
/*     */   }
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<JAWTRectangle, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 265 */     private static final JAWTRectangle ELEMENT_FACTORY = JAWTRectangle.create(-1L);
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
/* 277 */       super(container, container.remaining() / JAWTRectangle.SIZEOF);
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
/*     */     protected JAWTRectangle getElementFactory() {
/* 300 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("jint")
/*     */     public int x() {
/* 305 */       return JAWTRectangle.nx(address());
/*     */     } @NativeType("jint")
/*     */     public int y() {
/* 308 */       return JAWTRectangle.ny(address());
/*     */     } @NativeType("jint")
/*     */     public int width() {
/* 311 */       return JAWTRectangle.nwidth(address());
/*     */     } @NativeType("jint")
/*     */     public int height() {
/* 314 */       return JAWTRectangle.nheight(address());
/*     */     }
/*     */     public Buffer x(@NativeType("jint") int value) {
/* 317 */       JAWTRectangle.nx(address(), value); return this;
/*     */     } public Buffer y(@NativeType("jint") int value) {
/* 319 */       JAWTRectangle.ny(address(), value); return this;
/*     */     } public Buffer width(@NativeType("jint") int value) {
/* 321 */       JAWTRectangle.nwidth(address(), value); return this;
/*     */     } public Buffer height(@NativeType("jint") int value) {
/* 323 */       JAWTRectangle.nheight(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\jawt\JAWTRectangle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */