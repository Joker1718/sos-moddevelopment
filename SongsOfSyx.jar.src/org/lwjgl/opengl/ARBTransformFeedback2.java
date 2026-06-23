/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class ARBTransformFeedback2
/*     */ {
/*     */   public static final int GL_TRANSFORM_FEEDBACK = 36386;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED = 36387;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE = 36388;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BINDING = 36389;
/*     */   
/*     */   static {
/*  14 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ARBTransformFeedback2() {
/*  24 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBindTransformFeedback(@NativeType("GLenum") int target, @NativeType("GLuint") int id) {
/*  31 */     GL40C.glBindTransformFeedback(target, id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDeleteTransformFeedbacks(int n, long ids) {
/*  38 */     GL40C.nglDeleteTransformFeedbacks(n, ids);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteTransformFeedbacks(@NativeType("GLuint const *") IntBuffer ids) {
/*  43 */     GL40C.glDeleteTransformFeedbacks(ids);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteTransformFeedbacks(@NativeType("GLuint const *") int id) {
/*  48 */     GL40C.glDeleteTransformFeedbacks(id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGenTransformFeedbacks(int n, long ids) {
/*  55 */     GL40C.nglGenTransformFeedbacks(n, ids);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenTransformFeedbacks(@NativeType("GLuint *") IntBuffer ids) {
/*  60 */     GL40C.glGenTransformFeedbacks(ids);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenTransformFeedbacks() {
/*  66 */     return GL40C.glGenTransformFeedbacks();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsTransformFeedback(@NativeType("GLuint") int id) {
/*  74 */     return GL40C.glIsTransformFeedback(id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glPauseTransformFeedback() {
/*  81 */     GL40C.glPauseTransformFeedback();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glResumeTransformFeedback() {
/*  88 */     GL40C.glResumeTransformFeedback();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawTransformFeedback(@NativeType("GLenum") int mode, @NativeType("GLuint") int id) {
/*  95 */     GL40C.glDrawTransformFeedback(mode, id);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteTransformFeedbacks(@NativeType("GLuint const *") int[] ids) {
/* 100 */     GL40C.glDeleteTransformFeedbacks(ids);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenTransformFeedbacks(@NativeType("GLuint *") int[] ids) {
/* 105 */     GL40C.glGenTransformFeedbacks(ids);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\ARBTransformFeedback2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */