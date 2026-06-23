/*     */ package org.lwjgl.glfw;
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
/*     */ @NativeType("struct GLFWimage")
/*     */ public class GLFWImage
/*     */   extends Struct<GLFWImage>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int WIDTH;
/*     */   public static final int HEIGHT;
/*     */   public static final int PIXELS;
/*     */   
/*     */   static {
/*  43 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  44 */           __member(4), 
/*  45 */           __member(4), 
/*  46 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  49 */     SIZEOF = layout.getSize();
/*  50 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  52 */     WIDTH = layout.offsetof(0);
/*  53 */     HEIGHT = layout.offsetof(1);
/*  54 */     PIXELS = layout.offsetof(2);
/*     */   }
/*     */   
/*     */   protected GLFWImage(long address, ByteBuffer container) {
/*  58 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWImage create(long address, ByteBuffer container) {
/*  63 */     return new GLFWImage(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWImage(ByteBuffer container) {
/*  73 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  77 */     return SIZEOF;
/*     */   }
/*     */   public int width() {
/*  80 */     return nwidth(address());
/*     */   } public int height() {
/*  82 */     return nheight(address());
/*     */   } @NativeType("unsigned char *")
/*     */   public ByteBuffer pixels(int capacity) {
/*  85 */     return npixels(address(), capacity);
/*     */   }
/*     */   public GLFWImage width(int value) {
/*  88 */     nwidth(address(), value); return this;
/*     */   } public GLFWImage height(int value) {
/*  90 */     nheight(address(), value); return this;
/*     */   } public GLFWImage pixels(@NativeType("unsigned char *") ByteBuffer value) {
/*  92 */     npixels(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWImage set(int width, int height, ByteBuffer pixels) {
/* 100 */     width(width);
/* 101 */     height(height);
/* 102 */     pixels(pixels);
/*     */     
/* 104 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWImage set(GLFWImage src) {
/* 115 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 116 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWImage malloc() {
/* 123 */     return new GLFWImage(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWImage calloc() {
/* 128 */     return new GLFWImage(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWImage create() {
/* 133 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 134 */     return new GLFWImage(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWImage create(long address) {
/* 139 */     return new GLFWImage(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWImage createSafe(long address) {
/* 144 */     return (address == 0L) ? null : new GLFWImage(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 153 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 162 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 171 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 172 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 182 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 187 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWImage malloc(MemoryStack stack) {
/* 196 */     return new GLFWImage(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWImage calloc(MemoryStack stack) {
/* 205 */     return new GLFWImage(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 215 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 225 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwidth(long struct) {
/* 231 */     return MemoryUtil.memGetInt(struct + WIDTH);
/*     */   } public static int nheight(long struct) {
/* 233 */     return MemoryUtil.memGetInt(struct + HEIGHT);
/*     */   } public static ByteBuffer npixels(long struct, int capacity) {
/* 235 */     return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(struct + PIXELS), capacity);
/*     */   }
/*     */   public static void nwidth(long struct, int value) {
/* 238 */     MemoryUtil.memPutInt(struct + WIDTH, value);
/*     */   } public static void nheight(long struct, int value) {
/* 240 */     MemoryUtil.memPutInt(struct + HEIGHT, value);
/*     */   } public static void npixels(long struct, ByteBuffer value) {
/* 242 */     MemoryUtil.memPutAddress(struct + PIXELS, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 250 */     Checks.check(MemoryUtil.memGetAddress(struct + PIXELS));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<GLFWImage, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 258 */     private static final GLFWImage ELEMENT_FACTORY = GLFWImage.create(-1L);
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
/* 270 */       super(container, container.remaining() / GLFWImage.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 274 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 278 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 283 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 288 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected GLFWImage getElementFactory() {
/* 293 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     public int width() {
/* 297 */       return GLFWImage.nwidth(address());
/*     */     } public int height() {
/* 299 */       return GLFWImage.nheight(address());
/*     */     } @NativeType("unsigned char *")
/*     */     public ByteBuffer pixels(int capacity) {
/* 302 */       return GLFWImage.npixels(address(), capacity);
/*     */     }
/*     */     public Buffer width(int value) {
/* 305 */       GLFWImage.nwidth(address(), value); return this;
/*     */     } public Buffer height(int value) {
/* 307 */       GLFWImage.nheight(address(), value); return this;
/*     */     } public Buffer pixels(@NativeType("unsigned char *") ByteBuffer value) {
/* 309 */       GLFWImage.npixels(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWImage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */