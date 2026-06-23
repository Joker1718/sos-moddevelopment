/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBSamplerObjects
/*     */ {
/*     */   public static final int GL_SAMPLER_BINDING = 35097;
/*     */   
/*     */   static {
/*  14 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   protected ARBSamplerObjects() {
/*  19 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGenSamplers(int count, long samplers) {
/*  26 */     GL33C.nglGenSamplers(count, samplers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenSamplers(@NativeType("GLuint *") IntBuffer samplers) {
/*  31 */     GL33C.glGenSamplers(samplers);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenSamplers() {
/*  37 */     return GL33C.glGenSamplers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDeleteSamplers(int count, long samplers) {
/*  44 */     GL33C.nglDeleteSamplers(count, samplers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteSamplers(@NativeType("GLuint const *") IntBuffer samplers) {
/*  49 */     GL33C.glDeleteSamplers(samplers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteSamplers(@NativeType("GLuint const *") int sampler) {
/*  54 */     GL33C.glDeleteSamplers(sampler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsSampler(@NativeType("GLuint") int sampler) {
/*  62 */     return GL33C.glIsSampler(sampler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBindSampler(@NativeType("GLuint") int unit, @NativeType("GLuint") int sampler) {
/*  69 */     GL33C.glBindSampler(unit, sampler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSamplerParameteri(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint") int param) {
/*  76 */     GL33C.glSamplerParameteri(sampler, pname, param);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterf(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLfloat") float param) {
/*  83 */     GL33C.glSamplerParameterf(sampler, pname, param);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglSamplerParameteriv(int sampler, int pname, long params) {
/*  90 */     GL33C.nglSamplerParameteriv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameteriv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/*  95 */     GL33C.glSamplerParameteriv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglSamplerParameterfv(int sampler, int pname, long params) {
/* 102 */     GL33C.nglSamplerParameterfv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterfv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") FloatBuffer params) {
/* 107 */     GL33C.glSamplerParameterfv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglSamplerParameterIiv(int sampler, int pname, long params) {
/* 114 */     GL33C.nglSamplerParameterIiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterIiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint const *") IntBuffer params) {
/* 119 */     GL33C.glSamplerParameterIiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglSamplerParameterIuiv(int sampler, int pname, long params) {
/* 126 */     GL33C.nglSamplerParameterIuiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterIuiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLuint const *") IntBuffer params) {
/* 131 */     GL33C.glSamplerParameterIuiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetSamplerParameteriv(int sampler, int pname, long params) {
/* 138 */     GL33C.nglGetSamplerParameteriv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameteriv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 143 */     GL33C.glGetSamplerParameteriv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetSamplerParameteri(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname) {
/* 149 */     return GL33C.glGetSamplerParameteri(sampler, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetSamplerParameterfv(int sampler, int pname, long params) {
/* 156 */     GL33C.nglGetSamplerParameterfv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterfv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLfloat *") FloatBuffer params) {
/* 161 */     GL33C.glGetSamplerParameterfv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static float glGetSamplerParameterf(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname) {
/* 167 */     return GL33C.glGetSamplerParameterf(sampler, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetSamplerParameterIiv(int sampler, int pname, long params) {
/* 174 */     GL33C.nglGetSamplerParameterIiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterIiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer params) {
/* 179 */     GL33C.glGetSamplerParameterIiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetSamplerParameterIi(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname) {
/* 185 */     return GL33C.glGetSamplerParameterIi(sampler, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetSamplerParameterIuiv(int sampler, int pname, long params) {
/* 192 */     GL33C.nglGetSamplerParameterIuiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterIuiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLuint *") IntBuffer params) {
/* 197 */     GL33C.glGetSamplerParameterIuiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetSamplerParameterIui(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname) {
/* 203 */     return GL33C.glGetSamplerParameterIui(sampler, pname);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenSamplers(@NativeType("GLuint *") int[] samplers) {
/* 208 */     GL33C.glGenSamplers(samplers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteSamplers(@NativeType("GLuint const *") int[] samplers) {
/* 213 */     GL33C.glDeleteSamplers(samplers);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameteriv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 218 */     GL33C.glSamplerParameteriv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterfv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLfloat const *") float[] params) {
/* 223 */     GL33C.glSamplerParameterfv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterIiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint const *") int[] params) {
/* 228 */     GL33C.glSamplerParameterIiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSamplerParameterIuiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLuint const *") int[] params) {
/* 233 */     GL33C.glSamplerParameterIuiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameteriv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 238 */     GL33C.glGetSamplerParameteriv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterfv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLfloat *") float[] params) {
/* 243 */     GL33C.glGetSamplerParameterfv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterIiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] params) {
/* 248 */     GL33C.glGetSamplerParameterIiv(sampler, pname, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetSamplerParameterIuiv(@NativeType("GLuint") int sampler, @NativeType("GLenum") int pname, @NativeType("GLuint *") int[] params) {
/* 253 */     GL33C.glGetSamplerParameterIuiv(sampler, pname, params);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBSamplerObjects.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */