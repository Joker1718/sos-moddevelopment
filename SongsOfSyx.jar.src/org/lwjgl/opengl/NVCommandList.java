/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class NVCommandList
/*     */ {
/*     */   public static final int GL_TERMINATE_SEQUENCE_COMMAND_NV = 0;
/*     */   public static final int GL_NOP_COMMAND_NV = 1;
/*     */   public static final int GL_DRAW_ELEMENTS_COMMAND_NV = 2;
/*     */   public static final int GL_DRAW_ARRAYS_COMMAND_NV = 3;
/*     */   
/*     */   static {
/*  21 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_DRAW_ELEMENTS_STRIP_COMMAND_NV = 4;
/*     */   
/*     */   public static final int GL_DRAW_ARRAYS_STRIP_COMMAND_NV = 5;
/*     */   
/*     */   public static final int GL_DRAW_ELEMENTS_INSTANCED_COMMAND_NV = 6;
/*     */   
/*     */   public static final int GL_DRAW_ARRAYS_INSTANCED_COMMAND_NV = 7;
/*     */   public static final int GL_ELEMENT_ADDRESS_COMMAND_NV = 8;
/*     */   public static final int GL_ATTRIBUTE_ADDRESS_COMMAND_NV = 9;
/*     */   public static final int GL_UNIFORM_ADDRESS_COMMAND_NV = 10;
/*     */   public static final int GL_BLEND_COLOR_COMMAND_NV = 11;
/*     */   public static final int GL_STENCIL_REF_COMMAND_NV = 12;
/*     */   public static final int GL_LINE_WIDTH_COMMAND_NV = 13;
/*     */   public static final int GL_POLYGON_OFFSET_COMMAND_NV = 14;
/*     */   public static final int GL_ALPHA_REF_COMMAND_NV = 15;
/*     */   public static final int GL_VIEWPORT_COMMAND_NV = 16;
/*     */   public static final int GL_SCISSOR_COMMAND_NV = 17;
/*     */   public static final int GL_FRONT_FACE_COMMAND_NV = 18;
/*     */   
/*     */   protected NVCommandList() {
/*  45 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glCreateStatesNV(@NativeType("GLuint *") IntBuffer states) {
/*  55 */     nglCreateStatesNV(states.remaining(), MemoryUtil.memAddress(states));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glCreateStatesNV() {
/*  61 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  63 */       IntBuffer states = stack.callocInt(1);
/*  64 */       nglCreateStatesNV(1, MemoryUtil.memAddress(states));
/*  65 */       return states.get(0);
/*     */     } finally {
/*  67 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteStatesNV(@NativeType("GLuint const *") IntBuffer states) {
/*  78 */     nglDeleteStatesNV(states.remaining(), MemoryUtil.memAddress(states));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteStatesNV(@NativeType("GLuint const *") int state) {
/*  83 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  85 */       IntBuffer states = stack.ints(state);
/*  86 */       nglDeleteStatesNV(1, MemoryUtil.memAddress(states));
/*     */     } finally {
/*  88 */       stack.setPointer(stackPointer);
/*     */     } 
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
/*     */   public static void glDrawCommandsNV(@NativeType("GLenum") int primitiveMode, @NativeType("GLuint") int buffer, @NativeType("GLintptr const *") PointerBuffer indirects, @NativeType("GLsizei const *") IntBuffer sizes) {
/* 122 */     if (Checks.CHECKS) {
/* 123 */       Checks.check(sizes, indirects.remaining());
/*     */     }
/* 125 */     nglDrawCommandsNV(primitiveMode, buffer, MemoryUtil.memAddress((CustomBuffer)indirects), MemoryUtil.memAddress(sizes), indirects.remaining());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawCommandsAddressNV(@NativeType("GLenum") int primitiveMode, @NativeType("GLuint64 const *") LongBuffer indirects, @NativeType("GLsizei const *") IntBuffer sizes) {
/* 135 */     if (Checks.CHECKS) {
/* 136 */       Checks.check(sizes, indirects.remaining());
/*     */     }
/* 138 */     nglDrawCommandsAddressNV(primitiveMode, MemoryUtil.memAddress(indirects), MemoryUtil.memAddress(sizes), indirects.remaining());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawCommandsStatesNV(@NativeType("GLuint") int buffer, @NativeType("GLintptr const *") PointerBuffer indirects, @NativeType("GLsizei const *") IntBuffer sizes, @NativeType("GLuint const *") IntBuffer states, @NativeType("GLuint const *") IntBuffer fbos) {
/* 148 */     if (Checks.CHECKS) {
/* 149 */       Checks.check(sizes, indirects.remaining());
/* 150 */       Checks.check(states, indirects.remaining());
/* 151 */       Checks.check(fbos, indirects.remaining());
/*     */     } 
/* 153 */     nglDrawCommandsStatesNV(buffer, MemoryUtil.memAddress((CustomBuffer)indirects), MemoryUtil.memAddress(sizes), MemoryUtil.memAddress(states), MemoryUtil.memAddress(fbos), indirects.remaining());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawCommandsStatesAddressNV(@NativeType("GLuint64 const *") LongBuffer indirects, @NativeType("GLsizei const *") IntBuffer sizes, @NativeType("GLuint const *") IntBuffer states, @NativeType("GLuint const *") IntBuffer fbos) {
/* 163 */     if (Checks.CHECKS) {
/* 164 */       Checks.check(sizes, indirects.remaining());
/* 165 */       Checks.check(states, indirects.remaining());
/* 166 */       Checks.check(fbos, indirects.remaining());
/*     */     } 
/* 168 */     nglDrawCommandsStatesAddressNV(MemoryUtil.memAddress(indirects), MemoryUtil.memAddress(sizes), MemoryUtil.memAddress(states), MemoryUtil.memAddress(fbos), indirects.remaining());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glCreateCommandListsNV(@NativeType("GLuint *") IntBuffer lists) {
/* 178 */     nglCreateCommandListsNV(lists.remaining(), MemoryUtil.memAddress(lists));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glCreateCommandListsNV() {
/* 184 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 186 */       IntBuffer lists = stack.callocInt(1);
/* 187 */       nglCreateCommandListsNV(1, MemoryUtil.memAddress(lists));
/* 188 */       return lists.get(0);
/*     */     } finally {
/* 190 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteCommandListsNV(@NativeType("GLuint const *") IntBuffer lists) {
/* 201 */     nglDeleteCommandListsNV(lists.remaining(), MemoryUtil.memAddress(lists));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteCommandListsNV(@NativeType("GLuint const *") int list) {
/* 206 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 208 */       IntBuffer lists = stack.ints(list);
/* 209 */       nglDeleteCommandListsNV(1, MemoryUtil.memAddress(lists));
/*     */     } finally {
/* 211 */       stack.setPointer(stackPointer);
/*     */     } 
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
/*     */ 
/*     */   
/*     */   public static void glListDrawCommandsStatesClientNV(@NativeType("GLuint") int list, @NativeType("GLuint") int segment, @NativeType("void const **") PointerBuffer indirects, @NativeType("GLsizei const *") IntBuffer sizes, @NativeType("GLuint const *") IntBuffer states, @NativeType("GLuint const *") IntBuffer fbos) {
/* 228 */     if (Checks.CHECKS) {
/* 229 */       Checks.check(sizes, indirects.remaining());
/* 230 */       Checks.check(states, indirects.remaining());
/* 231 */       Checks.check(fbos, indirects.remaining());
/*     */     } 
/* 233 */     nglListDrawCommandsStatesClientNV(list, segment, MemoryUtil.memAddress((CustomBuffer)indirects), MemoryUtil.memAddress(sizes), MemoryUtil.memAddress(states), MemoryUtil.memAddress(fbos), indirects.remaining());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glCreateStatesNV(@NativeType("GLuint *") int[] states) {
/* 253 */     long __functionAddress = (GL.getICD()).glCreateStatesNV;
/* 254 */     if (Checks.CHECKS) {
/* 255 */       Checks.check(__functionAddress);
/*     */     }
/* 257 */     JNI.callPV(states.length, states, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteStatesNV(@NativeType("GLuint const *") int[] states) {
/* 262 */     long __functionAddress = (GL.getICD()).glDeleteStatesNV;
/* 263 */     if (Checks.CHECKS) {
/* 264 */       Checks.check(__functionAddress);
/*     */     }
/* 266 */     JNI.callPV(states.length, states, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawCommandsNV(@NativeType("GLenum") int primitiveMode, @NativeType("GLuint") int buffer, @NativeType("GLintptr const *") PointerBuffer indirects, @NativeType("GLsizei const *") int[] sizes) {
/* 271 */     long __functionAddress = (GL.getICD()).glDrawCommandsNV;
/* 272 */     if (Checks.CHECKS) {
/* 273 */       Checks.check(__functionAddress);
/* 274 */       Checks.check(sizes, indirects.remaining());
/*     */     } 
/* 276 */     JNI.callPPV(primitiveMode, buffer, MemoryUtil.memAddress((CustomBuffer)indirects), sizes, indirects.remaining(), __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawCommandsAddressNV(@NativeType("GLenum") int primitiveMode, @NativeType("GLuint64 const *") long[] indirects, @NativeType("GLsizei const *") int[] sizes) {
/* 281 */     long __functionAddress = (GL.getICD()).glDrawCommandsAddressNV;
/* 282 */     if (Checks.CHECKS) {
/* 283 */       Checks.check(__functionAddress);
/* 284 */       Checks.check(sizes, indirects.length);
/*     */     } 
/* 286 */     JNI.callPPV(primitiveMode, indirects, sizes, indirects.length, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawCommandsStatesNV(@NativeType("GLuint") int buffer, @NativeType("GLintptr const *") PointerBuffer indirects, @NativeType("GLsizei const *") int[] sizes, @NativeType("GLuint const *") int[] states, @NativeType("GLuint const *") int[] fbos) {
/* 291 */     long __functionAddress = (GL.getICD()).glDrawCommandsStatesNV;
/* 292 */     if (Checks.CHECKS) {
/* 293 */       Checks.check(__functionAddress);
/* 294 */       Checks.check(sizes, indirects.remaining());
/* 295 */       Checks.check(states, indirects.remaining());
/* 296 */       Checks.check(fbos, indirects.remaining());
/*     */     } 
/* 298 */     JNI.callPPPPV(buffer, MemoryUtil.memAddress((CustomBuffer)indirects), sizes, states, fbos, indirects.remaining(), __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDrawCommandsStatesAddressNV(@NativeType("GLuint64 const *") long[] indirects, @NativeType("GLsizei const *") int[] sizes, @NativeType("GLuint const *") int[] states, @NativeType("GLuint const *") int[] fbos) {
/* 303 */     long __functionAddress = (GL.getICD()).glDrawCommandsStatesAddressNV;
/* 304 */     if (Checks.CHECKS) {
/* 305 */       Checks.check(__functionAddress);
/* 306 */       Checks.check(sizes, indirects.length);
/* 307 */       Checks.check(states, indirects.length);
/* 308 */       Checks.check(fbos, indirects.length);
/*     */     } 
/* 310 */     JNI.callPPPPV(indirects, sizes, states, fbos, indirects.length, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCreateCommandListsNV(@NativeType("GLuint *") int[] lists) {
/* 315 */     long __functionAddress = (GL.getICD()).glCreateCommandListsNV;
/* 316 */     if (Checks.CHECKS) {
/* 317 */       Checks.check(__functionAddress);
/*     */     }
/* 319 */     JNI.callPV(lists.length, lists, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteCommandListsNV(@NativeType("GLuint const *") int[] lists) {
/* 324 */     long __functionAddress = (GL.getICD()).glDeleteCommandListsNV;
/* 325 */     if (Checks.CHECKS) {
/* 326 */       Checks.check(__functionAddress);
/*     */     }
/* 328 */     JNI.callPV(lists.length, lists, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glListDrawCommandsStatesClientNV(@NativeType("GLuint") int list, @NativeType("GLuint") int segment, @NativeType("void const **") PointerBuffer indirects, @NativeType("GLsizei const *") int[] sizes, @NativeType("GLuint const *") int[] states, @NativeType("GLuint const *") int[] fbos) {
/* 333 */     long __functionAddress = (GL.getICD()).glListDrawCommandsStatesClientNV;
/* 334 */     if (Checks.CHECKS) {
/* 335 */       Checks.check(__functionAddress);
/* 336 */       Checks.check(sizes, indirects.remaining());
/* 337 */       Checks.check(states, indirects.remaining());
/* 338 */       Checks.check(fbos, indirects.remaining());
/*     */     } 
/* 340 */     JNI.callPPPPV(list, segment, MemoryUtil.memAddress((CustomBuffer)indirects), sizes, states, fbos, indirects.remaining(), __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglCreateStatesNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglDeleteStatesNV(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsStateNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glStateCaptureNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static native int glGetCommandHeaderNV(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   @NativeType("GLushort")
/*     */   public static native short glGetStageIndexNV(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void nglDrawCommandsNV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3);
/*     */   
/*     */   public static native void nglDrawCommandsAddressNV(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native void nglDrawCommandsStatesNV(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt2);
/*     */   
/*     */   public static native void nglDrawCommandsStatesAddressNV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt);
/*     */   
/*     */   public static native void nglCreateCommandListsNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglDeleteCommandListsNV(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsCommandListNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglListDrawCommandsStatesClientNV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt3);
/*     */   
/*     */   public static native void glCommandListSegmentsNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void glCompileCommandListNV(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glCallCommandListNV(@NativeType("GLuint") int paramInt);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVCommandList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */