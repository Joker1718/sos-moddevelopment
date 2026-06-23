/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ public class ARBShaderSubroutine
/*     */ {
/*     */   public static final int GL_ACTIVE_SUBROUTINES = 36325;
/*     */   public static final int GL_ACTIVE_SUBROUTINE_UNIFORMS = 36326;
/*     */   public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS = 36423;
/*     */   public static final int GL_ACTIVE_SUBROUTINE_MAX_LENGTH = 36424;
/*     */   
/*     */   static {
/*  16 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH = 36425;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_SUBROUTINES = 36327;
/*     */   
/*     */   public static final int GL_MAX_SUBROUTINE_UNIFORM_LOCATIONS = 36328;
/*     */   
/*     */   public static final int GL_NUM_COMPATIBLE_SUBROUTINES = 36426;
/*     */   
/*     */   public static final int GL_COMPATIBLE_SUBROUTINES = 36427;
/*     */ 
/*     */   
/*     */   protected ARBShaderSubroutine() {
/*  34 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglGetSubroutineUniformLocation(int program, int shadertype, long name) {
/*  41 */     return GL40C.nglGetSubroutineUniformLocation(program, shadertype, name);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetSubroutineUniformLocation(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLchar const *") ByteBuffer name) {
/*  47 */     return GL40C.glGetSubroutineUniformLocation(program, shadertype, name);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glGetSubroutineUniformLocation(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLchar const *") CharSequence name) {
/*  53 */     return GL40C.glGetSubroutineUniformLocation(program, shadertype, name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglGetSubroutineIndex(int program, int shadertype, long name) {
/*  60 */     return GL40C.nglGetSubroutineIndex(program, shadertype, name);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetSubroutineIndex(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLchar const *") ByteBuffer name) {
/*  66 */     return GL40C.glGetSubroutineIndex(program, shadertype, name);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLuint")
/*     */   public static int glGetSubroutineIndex(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLchar const *") CharSequence name) {
/*  72 */     return GL40C.glGetSubroutineIndex(program, shadertype, name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetActiveSubroutineUniformiv(int program, int shadertype, int index, int pname, long values) {
/*  79 */     GL40C.nglGetActiveSubroutineUniformiv(program, shadertype, index, pname, values);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineUniformiv(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer values) {
/*  84 */     GL40C.glGetActiveSubroutineUniformiv(program, shadertype, index, pname, values);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetActiveSubroutineUniformi(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLenum") int pname) {
/*  90 */     return GL40C.glGetActiveSubroutineUniformi(program, shadertype, index, pname);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetActiveSubroutineUniformName(int program, int shadertype, int index, int bufsize, long length, long name) {
/*  97 */     GL40C.nglGetActiveSubroutineUniformName(program, shadertype, index, bufsize, length, name);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineUniformName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer name) {
/* 102 */     GL40C.glGetActiveSubroutineUniformName(program, shadertype, index, length, name);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveSubroutineUniformName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLsizei") int bufsize) {
/* 108 */     return GL40C.glGetActiveSubroutineUniformName(program, shadertype, index, bufsize);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveSubroutineUniformName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index) {
/* 114 */     return glGetActiveSubroutineUniformName(program, shadertype, index, glGetActiveSubroutineUniformi(program, shadertype, index, 35385));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetActiveSubroutineName(int program, int shadertype, int index, int bufsize, long length, long name) {
/* 121 */     GL40C.nglGetActiveSubroutineName(program, shadertype, index, bufsize, length, name);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer name) {
/* 126 */     GL40C.glGetActiveSubroutineName(program, shadertype, index, length, name);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveSubroutineName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLsizei") int bufsize) {
/* 132 */     return GL40C.glGetActiveSubroutineName(program, shadertype, index, bufsize);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static String glGetActiveSubroutineName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index) {
/* 138 */     return glGetActiveSubroutineName(program, shadertype, index, glGetProgramStagei(program, shadertype, 36424));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglUniformSubroutinesuiv(int shadertype, int count, long indices) {
/* 145 */     GL40C.nglUniformSubroutinesuiv(shadertype, count, indices);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformSubroutinesuiv(@NativeType("GLenum") int shadertype, @NativeType("GLuint const *") IntBuffer indices) {
/* 150 */     GL40C.glUniformSubroutinesuiv(shadertype, indices);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformSubroutinesui(@NativeType("GLenum") int shadertype, @NativeType("GLuint const *") int index) {
/* 155 */     GL40C.glUniformSubroutinesui(shadertype, index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetUniformSubroutineuiv(int shadertype, int location, long params) {
/* 162 */     GL40C.nglGetUniformSubroutineuiv(shadertype, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformSubroutineuiv(@NativeType("GLenum") int shadertype, @NativeType("GLint") int location, @NativeType("GLuint *") IntBuffer params) {
/* 167 */     GL40C.glGetUniformSubroutineuiv(shadertype, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetUniformSubroutineui(@NativeType("GLenum") int shadertype, @NativeType("GLint") int location) {
/* 173 */     return GL40C.glGetUniformSubroutineui(shadertype, location);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetProgramStageiv(int program, int shadertype, int pname, long values) {
/* 180 */     GL40C.nglGetProgramStageiv(program, shadertype, pname, values);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetProgramStageiv(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLenum") int pname, @NativeType("GLint *") IntBuffer values) {
/* 185 */     GL40C.glGetProgramStageiv(program, shadertype, pname, values);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetProgramStagei(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLenum") int pname) {
/* 191 */     return GL40C.glGetProgramStagei(program, shadertype, pname);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineUniformiv(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] values) {
/* 196 */     GL40C.glGetActiveSubroutineUniformiv(program, shadertype, index, pname, values);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineUniformName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer name) {
/* 201 */     GL40C.glGetActiveSubroutineUniformName(program, shadertype, index, length, name);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetActiveSubroutineName(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLuint") int index, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer name) {
/* 206 */     GL40C.glGetActiveSubroutineName(program, shadertype, index, length, name);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glUniformSubroutinesuiv(@NativeType("GLenum") int shadertype, @NativeType("GLuint const *") int[] indices) {
/* 211 */     GL40C.glUniformSubroutinesuiv(shadertype, indices);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetUniformSubroutineuiv(@NativeType("GLenum") int shadertype, @NativeType("GLint") int location, @NativeType("GLuint *") int[] params) {
/* 216 */     GL40C.glGetUniformSubroutineuiv(shadertype, location, params);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetProgramStageiv(@NativeType("GLuint") int program, @NativeType("GLenum") int shadertype, @NativeType("GLenum") int pname, @NativeType("GLint *") int[] values) {
/* 221 */     GL40C.glGetProgramStageiv(program, shadertype, pname, values);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBShaderSubroutine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */