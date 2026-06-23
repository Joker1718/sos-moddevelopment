/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GLXEXTImportContext
/*     */ {
/*     */   public static final int GLX_SHARE_CONTEXT_EXT = 32778;
/*     */   public static final int GLX_VISUAL_ID_EXT = 32779;
/*     */   public static final int GLX_SCREEN_EXT = 32780;
/*     */   
/*     */   protected GLXEXTImportContext() {
/*  24 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Display *")
/*     */   public static long glXGetCurrentDisplayEXT() {
/*  32 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetCurrentDisplayEXT;
/*  33 */     if (Checks.CHECKS) {
/*  34 */       Checks.check(__functionAddress);
/*     */     }
/*  36 */     return JNI.callP(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXQueryContextInfoEXT(long display, long context, int attribute, long value) {
/*  43 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXQueryContextInfoEXT;
/*  44 */     if (Checks.CHECKS) {
/*  45 */       Checks.check(__functionAddress);
/*  46 */       Checks.check(display);
/*  47 */       Checks.check(context);
/*     */     } 
/*  49 */     return JNI.callPPPI(display, context, attribute, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int glXQueryContextInfoEXT(@NativeType("Display *") long display, @NativeType("GLXContext") long context, int attribute, @NativeType("int *") IntBuffer value) {
/*  54 */     if (Checks.CHECKS) {
/*  55 */       Checks.check(value, 1);
/*     */     }
/*  57 */     return nglXQueryContextInfoEXT(display, context, attribute, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXContextID")
/*     */   public static long glXGetContextIDEXT(@NativeType("GLXContext const") long context) {
/*  65 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetContextIDEXT;
/*  66 */     if (Checks.CHECKS) {
/*  67 */       Checks.check(__functionAddress);
/*  68 */       Checks.check(context);
/*     */     } 
/*  70 */     return JNI.callPN(context, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXContext")
/*     */   public static long glXImportContextEXT(@NativeType("Display *") long display, @NativeType("GLXContextID") long contextID) {
/*  78 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXImportContextEXT;
/*  79 */     if (Checks.CHECKS) {
/*  80 */       Checks.check(__functionAddress);
/*  81 */       Checks.check(display);
/*     */     } 
/*  83 */     return JNI.callPNP(display, contextID, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glXFreeContextEXT(@NativeType("Display *") long display, @NativeType("GLXContext") long context) {
/*  90 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXFreeContextEXT;
/*  91 */     if (Checks.CHECKS) {
/*  92 */       Checks.check(__functionAddress);
/*  93 */       Checks.check(display);
/*  94 */       Checks.check(context);
/*     */     } 
/*  96 */     JNI.callPPV(display, context, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int glXQueryContextInfoEXT(@NativeType("Display *") long display, @NativeType("GLXContext") long context, int attribute, @NativeType("int *") int[] value) {
/* 101 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXQueryContextInfoEXT;
/* 102 */     if (Checks.CHECKS) {
/* 103 */       Checks.check(__functionAddress);
/* 104 */       Checks.check(display);
/* 105 */       Checks.check(context);
/* 106 */       Checks.check(value, 1);
/*     */     } 
/* 108 */     return JNI.callPPPI(display, context, attribute, value, __functionAddress);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLXEXTImportContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */