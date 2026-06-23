/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class EXTTextureInteger
/*     */ {
/*     */   public static final int GL_RGBA_INTEGER_MODE_EXT = 36254;
/*     */   public static final int GL_RGBA32UI_EXT = 36208;
/*     */   public static final int GL_RGB32UI_EXT = 36209;
/*     */   public static final int GL_ALPHA32UI_EXT = 36210;
/*     */   public static final int GL_INTENSITY32UI_EXT = 36211;
/*     */   
/*     */   static {
/*  19 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_LUMINANCE32UI_EXT = 36212;
/*     */   
/*     */   public static final int GL_LUMINANCE_ALPHA32UI_EXT = 36213;
/*     */   
/*     */   public static final int GL_RGBA16UI_EXT = 36214;
/*     */   
/*     */   public static final int GL_RGB16UI_EXT = 36215;
/*     */   
/*     */   public static final int GL_ALPHA16UI_EXT = 36216;
/*     */   
/*     */   public static final int GL_INTENSITY16UI_EXT = 36217;
/*     */   
/*     */   public static final int GL_LUMINANCE16UI_EXT = 36218;
/*     */   
/*     */   public static final int GL_LUMINANCE_ALPHA16UI_EXT = 36219;
/*     */   public static final int GL_RGBA8UI_EXT = 36220;
/*     */   public static final int GL_RGB8UI_EXT = 36221;
/*     */   public static final int GL_ALPHA8UI_EXT = 36222;
/*     */   public static final int GL_INTENSITY8UI_EXT = 36223;
/*     */   public static final int GL_LUMINANCE8UI_EXT = 36224;
/*     */   public static final int GL_LUMINANCE_ALPHA8UI_EXT = 36225;
/*     */   public static final int GL_RGBA32I_EXT = 36226;
/*     */   public static final int GL_RGB32I_EXT = 36227;
/*     */   public static final int GL_ALPHA32I_EXT = 36228;
/*     */   public static final int GL_INTENSITY32I_EXT = 36229;
/*     */   public static final int GL_LUMINANCE32I_EXT = 36230;
/*     */   public static final int GL_LUMINANCE_ALPHA32I_EXT = 36231;
/*     */   public static final int GL_RGBA16I_EXT = 36232;
/*     */   public static final int GL_RGB16I_EXT = 36233;
/*     */   public static final int GL_ALPHA16I_EXT = 36234;
/*     */   public static final int GL_INTENSITY16I_EXT = 36235;
/*     */   public static final int GL_LUMINANCE16I_EXT = 36236;
/*     */   public static final int GL_LUMINANCE_ALPHA16I_EXT = 36237;
/*     */   public static final int GL_RGBA8I_EXT = 36238;
/*     */   public static final int GL_RGB8I_EXT = 36239;
/*     */   public static final int GL_ALPHA8I_EXT = 36240;
/*     */   public static final int GL_INTENSITY8I_EXT = 36241;
/*     */   public static final int GL_LUMINANCE8I_EXT = 36242;
/*     */   public static final int GL_LUMINANCE_ALPHA8I_EXT = 36243;
/*     */   public static final int GL_RED_INTEGER_EXT = 36244;
/*     */   public static final int GL_GREEN_INTEGER_EXT = 36245;
/*     */   public static final int GL_BLUE_INTEGER_EXT = 36246;
/*     */   public static final int GL_ALPHA_INTEGER_EXT = 36247;
/*     */   public static final int GL_RGB_INTEGER_EXT = 36248;
/*     */   public static final int GL_RGBA_INTEGER_EXT = 36249;
/*     */   public static final int GL_BGR_INTEGER_EXT = 36250;
/*     */   public static final int GL_BGRA_INTEGER_EXT = 36251;
/*     */   public static final int GL_LUMINANCE_INTEGER_EXT = 36252;
/*     */   public static final int GL_LUMINANCE_ALPHA_INTEGER_EXT = 36253;
/*     */   
/*     */   protected EXTTextureInteger() {
/*  74 */     throw new UnsupportedOperationException();
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
/*     */   public static void glTexParameterIivEXT(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/*  94 */     if (Checks.CHECKS) {
/*  95 */       Checks.check(params, 1);
/*     */     }
/*  97 */     nglTexParameterIivEXT(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexParameterIiEXT(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int param) {
/* 102 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 104 */       IntBuffer params = stack.ints(param);
/* 105 */       nglTexParameterIivEXT(target, pname, MemoryUtil.memAddress(params));
/*     */     } finally {
/* 107 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glTexParameterIuivEXT(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint *") IntBuffer params) {
/* 118 */     if (Checks.CHECKS) {
/* 119 */       Checks.check(params, 1);
/*     */     }
/* 121 */     nglTexParameterIuivEXT(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexParameterIuiEXT(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint *") int param) {
/* 126 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 128 */       IntBuffer params = stack.ints(param);
/* 129 */       nglTexParameterIuivEXT(target, pname, MemoryUtil.memAddress(params));
/*     */     } finally {
/* 131 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetTexParameterIivEXT(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 142 */     if (Checks.CHECKS) {
/* 143 */       Checks.check(params, 1);
/*     */     }
/* 145 */     nglGetTexParameterIivEXT(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetTexParameterIiEXT(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 151 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 153 */       IntBuffer params = stack.callocInt(1);
/* 154 */       nglGetTexParameterIivEXT(target, pname, MemoryUtil.memAddress(params));
/* 155 */       return params.get(0);
/*     */     } finally {
/* 157 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetTexParameterIuivEXT(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint *") IntBuffer params) {
/* 168 */     if (Checks.CHECKS) {
/* 169 */       Checks.check(params, 1);
/*     */     }
/* 171 */     nglGetTexParameterIuivEXT(target, pname, MemoryUtil.memAddress(params));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetTexParameterIuiEXT(@NativeType("GLenum") int target, @NativeType("GLenum") int pname) {
/* 177 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 179 */       IntBuffer params = stack.callocInt(1);
/* 180 */       nglGetTexParameterIuivEXT(target, pname, MemoryUtil.memAddress(params));
/* 181 */       return params.get(0);
/*     */     } finally {
/* 183 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexParameterIivEXT(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 189 */     long __functionAddress = (GL.getICD()).glTexParameterIivEXT;
/* 190 */     if (Checks.CHECKS) {
/* 191 */       Checks.check(__functionAddress);
/* 192 */       Checks.check(params, 1);
/*     */     } 
/* 194 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexParameterIuivEXT(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint *") int[] params) {
/* 199 */     long __functionAddress = (GL.getICD()).glTexParameterIuivEXT;
/* 200 */     if (Checks.CHECKS) {
/* 201 */       Checks.check(__functionAddress);
/* 202 */       Checks.check(params, 1);
/*     */     } 
/* 204 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetTexParameterIivEXT(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 209 */     long __functionAddress = (GL.getICD()).glGetTexParameterIivEXT;
/* 210 */     if (Checks.CHECKS) {
/* 211 */       Checks.check(__functionAddress);
/* 212 */       Checks.check(params, 1);
/*     */     } 
/* 214 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetTexParameterIuivEXT(@NativeType("GLenum") int target, @NativeType("GLenum") int pname, @NativeType("GLuint *") int[] params) {
/* 219 */     long __functionAddress = (GL.getICD()).glGetTexParameterIuivEXT;
/* 220 */     if (Checks.CHECKS) {
/* 221 */       Checks.check(__functionAddress);
/* 222 */       Checks.check(params, 1);
/*     */     } 
/* 224 */     JNI.callPV(target, pname, params, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glClearColorIiEXT(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4);
/*     */   
/*     */   public static native void glClearColorIuiEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4);
/*     */   
/*     */   public static native void nglTexParameterIivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglTexParameterIuivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetTexParameterIivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetTexParameterIuivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\EXTTextureInteger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */