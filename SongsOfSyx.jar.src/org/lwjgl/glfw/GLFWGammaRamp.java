/*     */ package org.lwjgl.glfw;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ShortBuffer;
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
/*     */ @NativeType("struct GLFWgammaramp")
/*     */ public class GLFWGammaRamp
/*     */   extends Struct<GLFWGammaRamp>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int RED;
/*     */   public static final int GREEN;
/*     */   public static final int BLUE;
/*     */   public static final int SIZE;
/*     */   
/*     */   static {
/*  45 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  46 */           __member(POINTER_SIZE), 
/*  47 */           __member(POINTER_SIZE), 
/*  48 */           __member(POINTER_SIZE), 
/*  49 */           __member(4)
/*     */         });
/*     */     
/*  52 */     SIZEOF = layout.getSize();
/*  53 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  55 */     RED = layout.offsetof(0);
/*  56 */     GREEN = layout.offsetof(1);
/*  57 */     BLUE = layout.offsetof(2);
/*  58 */     SIZE = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected GLFWGammaRamp(long address, ByteBuffer container) {
/*  62 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWGammaRamp create(long address, ByteBuffer container) {
/*  67 */     return new GLFWGammaRamp(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWGammaRamp(ByteBuffer container) {
/*  77 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  81 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("unsigned short *")
/*     */   public ShortBuffer red() {
/*  85 */     return nred(address());
/*     */   } @NativeType("unsigned short *")
/*     */   public ShortBuffer green() {
/*  88 */     return ngreen(address());
/*     */   } @NativeType("unsigned short *")
/*     */   public ShortBuffer blue() {
/*  91 */     return nblue(address());
/*     */   } @NativeType("unsigned int")
/*     */   public int size() {
/*  94 */     return nsize(address());
/*     */   }
/*     */   public GLFWGammaRamp red(@NativeType("unsigned short *") ShortBuffer value) {
/*  97 */     nred(address(), value); return this;
/*     */   } public GLFWGammaRamp green(@NativeType("unsigned short *") ShortBuffer value) {
/*  99 */     ngreen(address(), value); return this;
/*     */   } public GLFWGammaRamp blue(@NativeType("unsigned short *") ShortBuffer value) {
/* 101 */     nblue(address(), value); return this;
/*     */   } public GLFWGammaRamp size(@NativeType("unsigned int") int value) {
/* 103 */     nsize(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWGammaRamp set(ShortBuffer red, ShortBuffer green, ShortBuffer blue, int size) {
/* 112 */     red(red);
/* 113 */     green(green);
/* 114 */     blue(blue);
/* 115 */     size(size);
/*     */     
/* 117 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWGammaRamp set(GLFWGammaRamp src) {
/* 128 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 129 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWGammaRamp malloc() {
/* 136 */     return new GLFWGammaRamp(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWGammaRamp calloc() {
/* 141 */     return new GLFWGammaRamp(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWGammaRamp create() {
/* 146 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 147 */     return new GLFWGammaRamp(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWGammaRamp create(long address) {
/* 152 */     return new GLFWGammaRamp(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWGammaRamp createSafe(long address) {
/* 157 */     return (address == 0L) ? null : new GLFWGammaRamp(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity) {
/* 166 */     return new Buffer(MemoryUtil.nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity) {
/* 175 */     return new Buffer(MemoryUtil.nmemCallocChecked(capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(int capacity) {
/* 184 */     ByteBuffer container = __create(capacity, SIZEOF);
/* 185 */     return new Buffer(MemoryUtil.memAddress(container), container, -1, 0, capacity, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer create(long address, int capacity) {
/* 195 */     return new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Buffer createSafe(long address, int capacity) {
/* 200 */     return (address == 0L) ? null : new Buffer(address, capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWGammaRamp malloc(MemoryStack stack) {
/* 209 */     return new GLFWGammaRamp(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWGammaRamp calloc(MemoryStack stack) {
/* 218 */     return new GLFWGammaRamp(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer malloc(int capacity, MemoryStack stack) {
/* 228 */     return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Buffer calloc(int capacity, MemoryStack stack) {
/* 238 */     return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ShortBuffer nred(long struct) {
/* 244 */     return MemoryUtil.memShortBuffer(MemoryUtil.memGetAddress(struct + RED), nsize(struct));
/*     */   } public static ShortBuffer ngreen(long struct) {
/* 246 */     return MemoryUtil.memShortBuffer(MemoryUtil.memGetAddress(struct + GREEN), nsize(struct));
/*     */   } public static ShortBuffer nblue(long struct) {
/* 248 */     return MemoryUtil.memShortBuffer(MemoryUtil.memGetAddress(struct + BLUE), nsize(struct));
/*     */   } public static int nsize(long struct) {
/* 250 */     return MemoryUtil.memGetInt(struct + SIZE);
/*     */   }
/*     */   public static void nred(long struct, ShortBuffer value) {
/* 253 */     MemoryUtil.memPutAddress(struct + RED, MemoryUtil.memAddress(value));
/*     */   } public static void ngreen(long struct, ShortBuffer value) {
/* 255 */     MemoryUtil.memPutAddress(struct + GREEN, MemoryUtil.memAddress(value));
/*     */   } public static void nblue(long struct, ShortBuffer value) {
/* 257 */     MemoryUtil.memPutAddress(struct + BLUE, MemoryUtil.memAddress(value));
/*     */   } public static void nsize(long struct, int value) {
/* 259 */     MemoryUtil.memPutInt(struct + SIZE, value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 267 */     Checks.check(MemoryUtil.memGetAddress(struct + RED));
/* 268 */     Checks.check(MemoryUtil.memGetAddress(struct + GREEN));
/* 269 */     Checks.check(MemoryUtil.memGetAddress(struct + BLUE));
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<GLFWGammaRamp, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 277 */     private static final GLFWGammaRamp ELEMENT_FACTORY = GLFWGammaRamp.create(-1L);
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
/* 289 */       super(container, container.remaining() / GLFWGammaRamp.SIZEOF);
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
/*     */     protected GLFWGammaRamp getElementFactory() {
/* 312 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("unsigned short *")
/*     */     public ShortBuffer red() {
/* 317 */       return GLFWGammaRamp.nred(address());
/*     */     } @NativeType("unsigned short *")
/*     */     public ShortBuffer green() {
/* 320 */       return GLFWGammaRamp.ngreen(address());
/*     */     } @NativeType("unsigned short *")
/*     */     public ShortBuffer blue() {
/* 323 */       return GLFWGammaRamp.nblue(address());
/*     */     } @NativeType("unsigned int")
/*     */     public int size() {
/* 326 */       return GLFWGammaRamp.nsize(address());
/*     */     }
/*     */     public Buffer red(@NativeType("unsigned short *") ShortBuffer value) {
/* 329 */       GLFWGammaRamp.nred(address(), value); return this;
/*     */     } public Buffer green(@NativeType("unsigned short *") ShortBuffer value) {
/* 331 */       GLFWGammaRamp.ngreen(address(), value); return this;
/*     */     } public Buffer blue(@NativeType("unsigned short *") ShortBuffer value) {
/* 333 */       GLFWGammaRamp.nblue(address(), value); return this;
/*     */     } public Buffer size(@NativeType("unsigned int") int value) {
/* 335 */       GLFWGammaRamp.nsize(address(), value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWGammaRamp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */