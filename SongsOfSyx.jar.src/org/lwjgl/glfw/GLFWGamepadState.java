/*     */ package org.lwjgl.glfw;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
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
/*     */ @NativeType("struct GLFWgamepadstate")
/*     */ public class GLFWGamepadState
/*     */   extends Struct<GLFWGamepadState>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int BUTTONS;
/*     */   public static final int AXES;
/*     */   
/*     */   static {
/*  41 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  42 */           __array(1, 15), 
/*  43 */           __array(4, 6)
/*     */         });
/*     */     
/*  46 */     SIZEOF = layout.getSize();
/*  47 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  49 */     BUTTONS = layout.offsetof(0);
/*  50 */     AXES = layout.offsetof(1);
/*     */   }
/*     */   
/*     */   protected GLFWGamepadState(long address, ByteBuffer container) {
/*  54 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected GLFWGamepadState create(long address, ByteBuffer container) {
/*  59 */     return new GLFWGamepadState(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWGamepadState(ByteBuffer container) {
/*  69 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  73 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("unsigned char[15]")
/*     */   public ByteBuffer buttons() {
/*  77 */     return nbuttons(address());
/*     */   } @NativeType("unsigned char")
/*     */   public byte buttons(int index) {
/*  80 */     return nbuttons(address(), index);
/*     */   } @NativeType("float[6]")
/*     */   public FloatBuffer axes() {
/*  83 */     return naxes(address());
/*     */   } public float axes(int index) {
/*  85 */     return naxes(address(), index);
/*     */   }
/*     */   public GLFWGamepadState buttons(@NativeType("unsigned char[15]") ByteBuffer value) {
/*  88 */     nbuttons(address(), value); return this;
/*     */   } public GLFWGamepadState buttons(int index, @NativeType("unsigned char") byte value) {
/*  90 */     nbuttons(address(), index, value); return this;
/*     */   } public GLFWGamepadState axes(@NativeType("float[6]") FloatBuffer value) {
/*  92 */     naxes(address(), value); return this;
/*     */   } public GLFWGamepadState axes(int index, float value) {
/*  94 */     naxes(address(), index, value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GLFWGamepadState set(ByteBuffer buttons, FloatBuffer axes) {
/* 101 */     buttons(buttons);
/* 102 */     axes(axes);
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
/*     */   public GLFWGamepadState set(GLFWGamepadState src) {
/* 115 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 116 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWGamepadState malloc() {
/* 123 */     return new GLFWGamepadState(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWGamepadState calloc() {
/* 128 */     return new GLFWGamepadState(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWGamepadState create() {
/* 133 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 134 */     return new GLFWGamepadState(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWGamepadState create(long address) {
/* 139 */     return new GLFWGamepadState(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GLFWGamepadState createSafe(long address) {
/* 144 */     return (address == 0L) ? null : new GLFWGamepadState(address, null);
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
/*     */   public static GLFWGamepadState malloc(MemoryStack stack) {
/* 196 */     return new GLFWGamepadState(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GLFWGamepadState calloc(MemoryStack stack) {
/* 205 */     return new GLFWGamepadState(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
/*     */   public static ByteBuffer nbuttons(long struct) {
/* 231 */     return MemoryUtil.memByteBuffer(struct + BUTTONS, 15);
/*     */   }
/*     */   public static byte nbuttons(long struct, int index) {
/* 234 */     return MemoryUtil.memGetByte(struct + BUTTONS + Checks.check(index, 15) * 1L);
/*     */   }
/*     */   public static FloatBuffer naxes(long struct) {
/* 237 */     return MemoryUtil.memFloatBuffer(struct + AXES, 6);
/*     */   }
/*     */   public static float naxes(long struct, int index) {
/* 240 */     return MemoryUtil.memGetFloat(struct + AXES + Checks.check(index, 6) * 4L);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void nbuttons(long struct, ByteBuffer value) {
/* 245 */     if (Checks.CHECKS) Checks.checkGT(value, 15); 
/* 246 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + BUTTONS, (value.remaining() * 1));
/*     */   }
/*     */   
/*     */   public static void nbuttons(long struct, int index, byte value) {
/* 250 */     MemoryUtil.memPutByte(struct + BUTTONS + Checks.check(index, 15) * 1L, value);
/*     */   }
/*     */   
/*     */   public static void naxes(long struct, FloatBuffer value) {
/* 254 */     if (Checks.CHECKS) Checks.checkGT(value, 6); 
/* 255 */     MemoryUtil.memCopy(MemoryUtil.memAddress(value), struct + AXES, (value.remaining() * 4));
/*     */   }
/*     */   
/*     */   public static void naxes(long struct, int index, float value) {
/* 259 */     MemoryUtil.memPutFloat(struct + AXES + Checks.check(index, 6) * 4L, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Buffer
/*     */     extends StructBuffer<GLFWGamepadState, Buffer>
/*     */     implements NativeResource
/*     */   {
/* 267 */     private static final GLFWGamepadState ELEMENT_FACTORY = GLFWGamepadState.create(-1L);
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
/* 279 */       super(container, container.remaining() / GLFWGamepadState.SIZEOF);
/*     */     }
/*     */     
/*     */     public Buffer(long address, int cap) {
/* 283 */       super(address, null, -1, 0, cap, cap);
/*     */     }
/*     */     
/*     */     Buffer(long address, ByteBuffer container, int mark, int pos, int lim, int cap) {
/* 287 */       super(address, container, mark, pos, lim, cap);
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer self() {
/* 292 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Buffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/* 297 */       return new Buffer(address, container, mark, position, limit, capacity);
/*     */     }
/*     */ 
/*     */     
/*     */     protected GLFWGamepadState getElementFactory() {
/* 302 */       return ELEMENT_FACTORY;
/*     */     }
/*     */     
/*     */     @NativeType("unsigned char[15]")
/*     */     public ByteBuffer buttons() {
/* 307 */       return GLFWGamepadState.nbuttons(address());
/*     */     } @NativeType("unsigned char")
/*     */     public byte buttons(int index) {
/* 310 */       return GLFWGamepadState.nbuttons(address(), index);
/*     */     } @NativeType("float[6]")
/*     */     public FloatBuffer axes() {
/* 313 */       return GLFWGamepadState.naxes(address());
/*     */     } public float axes(int index) {
/* 315 */       return GLFWGamepadState.naxes(address(), index);
/*     */     }
/*     */     public Buffer buttons(@NativeType("unsigned char[15]") ByteBuffer value) {
/* 318 */       GLFWGamepadState.nbuttons(address(), value); return this;
/*     */     } public Buffer buttons(int index, @NativeType("unsigned char") byte value) {
/* 320 */       GLFWGamepadState.nbuttons(address(), index, value); return this;
/*     */     } public Buffer axes(@NativeType("float[6]") FloatBuffer value) {
/* 322 */       GLFWGamepadState.naxes(address(), value); return this;
/*     */     } public Buffer axes(int index, float value) {
/* 324 */       GLFWGamepadState.naxes(address(), index, value); return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWGamepadState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */