/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class ARBES2Compatibility {
/*     */   public static final int GL_SHADER_COMPILER = 36346;
/*     */   public static final int GL_SHADER_BINARY_FORMATS = 36344;
/*     */   public static final int GL_NUM_SHADER_BINARY_FORMATS = 36345;
/*     */   public static final int GL_MAX_VERTEX_UNIFORM_VECTORS = 36347;
/*     */   
/*     */   static {
/*  14 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_VARYING_VECTORS = 36348;
/*     */   
/*     */   public static final int GL_MAX_FRAGMENT_UNIFORM_VECTORS = 36349;
/*     */   
/*     */   public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE = 35738;
/*     */   
/*     */   public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT = 35739;
/*     */   
/*     */   public static final int GL_FIXED = 5132;
/*     */   
/*     */   public static final int GL_LOW_FLOAT = 36336;
/*     */   
/*     */   public static final int GL_MEDIUM_FLOAT = 36337;
/*     */   
/*     */   public static final int GL_HIGH_FLOAT = 36338;
/*     */   public static final int GL_LOW_INT = 36339;
/*     */   public static final int GL_MEDIUM_INT = 36340;
/*     */   public static final int GL_HIGH_INT = 36341;
/*     */   public static final int GL_RGB565 = 36194;
/*     */   
/*     */   protected ARBES2Compatibility() {
/*  39 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glReleaseShaderCompiler() {
/*  46 */     GL41C.glReleaseShaderCompiler();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglShaderBinary(int count, long shaders, int binaryformat, long binary, int length) {
/*  53 */     GL41C.nglShaderBinary(count, shaders, binaryformat, binary, length);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glShaderBinary(@NativeType("GLuint const *") IntBuffer shaders, @NativeType("GLenum") int binaryformat, @NativeType("void const *") ByteBuffer binary) {
/*  58 */     GL41C.glShaderBinary(shaders, binaryformat, binary);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetShaderPrecisionFormat(int shadertype, int precisiontype, long range, long precision) {
/*  65 */     GL41C.nglGetShaderPrecisionFormat(shadertype, precisiontype, range, precision);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetShaderPrecisionFormat(@NativeType("GLenum") int shadertype, @NativeType("GLenum") int precisiontype, @NativeType("GLint *") IntBuffer range, @NativeType("GLint *") IntBuffer precision) {
/*  70 */     GL41C.glGetShaderPrecisionFormat(shadertype, precisiontype, range, precision);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetShaderPrecisionFormat(@NativeType("GLenum") int shadertype, @NativeType("GLenum") int precisiontype, @NativeType("GLint *") IntBuffer range) {
/*  76 */     return GL41C.glGetShaderPrecisionFormat(shadertype, precisiontype, range);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDepthRangef(@NativeType("GLfloat") float zNear, @NativeType("GLfloat") float zFar) {
/*  83 */     GL41C.glDepthRangef(zNear, zFar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glClearDepthf(@NativeType("GLfloat") float depth) {
/*  90 */     GL41C.glClearDepthf(depth);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glShaderBinary(@NativeType("GLuint const *") int[] shaders, @NativeType("GLenum") int binaryformat, @NativeType("void const *") ByteBuffer binary) {
/*  95 */     GL41C.glShaderBinary(shaders, binaryformat, binary);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetShaderPrecisionFormat(@NativeType("GLenum") int shadertype, @NativeType("GLenum") int precisiontype, @NativeType("GLint *") int[] range, @NativeType("GLint *") int[] precision) {
/* 100 */     GL41C.glGetShaderPrecisionFormat(shadertype, precisiontype, range, precision);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBES2Compatibility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */