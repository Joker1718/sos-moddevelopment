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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WGLARBPbuffer
/*     */ {
/*     */   public static final int WGL_DRAW_TO_PBUFFER_ARB = 8237;
/*     */   public static final int WGL_MAX_PBUFFER_PIXELS_ARB = 8238;
/*     */   public static final int WGL_MAX_PBUFFER_WIDTH_ARB = 8239;
/*     */   public static final int WGL_MAX_PBUFFER_HEIGHT_ARB = 8240;
/*     */   public static final int WGL_PBUFFER_LARGEST_ARB = 8243;
/*     */   public static final int WGL_PBUFFER_WIDTH_ARB = 8244;
/*     */   public static final int WGL_PBUFFER_HEIGHT_ARB = 8245;
/*     */   public static final int WGL_PBUFFER_LOST_ARB = 8246;
/*     */   
/*     */   protected WGLARBPbuffer() {
/*  35 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nwglCreatePbufferARB(long hdc, int pixelFormat, int width, int height, long attribList) {
/*  42 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglCreatePbufferARB;
/*  43 */     if (Checks.CHECKS) {
/*  44 */       Checks.check(__functionAddress);
/*  45 */       Checks.check(hdc);
/*     */     } 
/*  47 */     return JNI.callPPP(hdc, pixelFormat, width, height, attribList, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("HPBUFFERARB")
/*     */   public static long wglCreatePbufferARB(@NativeType("HDC") long hdc, int pixelFormat, int width, int height, @NativeType("int const *") IntBuffer attribList) {
/*  53 */     if (Checks.CHECKS) {
/*  54 */       Checks.checkNTSafe(attribList);
/*     */     }
/*  56 */     return nwglCreatePbufferARB(hdc, pixelFormat, width, height, MemoryUtil.memAddressSafe(attribList));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HDC")
/*     */   public static long wglGetPbufferDCARB(@NativeType("HPBUFFERARB") long pbuffer) {
/*  64 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglGetPbufferDCARB;
/*  65 */     if (Checks.CHECKS) {
/*  66 */       Checks.check(__functionAddress);
/*  67 */       Checks.check(pbuffer);
/*     */     } 
/*  69 */     return JNI.callPP(pbuffer, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int wglReleasePbufferDCARB(@NativeType("HPBUFFERARB") long pbuffer, @NativeType("HDC") long hdc) {
/*  76 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglReleasePbufferDCARB;
/*  77 */     if (Checks.CHECKS) {
/*  78 */       Checks.check(__functionAddress);
/*  79 */       Checks.check(pbuffer);
/*  80 */       Checks.check(hdc);
/*     */     } 
/*  82 */     return JNI.callPPI(pbuffer, hdc, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglDestroyPbufferARB(@NativeType("HPBUFFERARB") long pbuffer) {
/*  90 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglDestroyPbufferARB;
/*  91 */     if (Checks.CHECKS) {
/*  92 */       Checks.check(__functionAddress);
/*  93 */       Checks.check(pbuffer);
/*     */     } 
/*  95 */     return (JNI.callPI(pbuffer, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglQueryPbufferARB(long pbuffer, int attribute, long value) {
/* 102 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglQueryPbufferARB;
/* 103 */     if (Checks.CHECKS) {
/* 104 */       Checks.check(__functionAddress);
/* 105 */       Checks.check(pbuffer);
/*     */     } 
/* 107 */     return JNI.callPPI(pbuffer, attribute, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglQueryPbufferARB(@NativeType("HPBUFFERARB") long pbuffer, int attribute, @NativeType("int *") IntBuffer value) {
/* 113 */     if (Checks.CHECKS) {
/* 114 */       Checks.check(value, 1);
/*     */     }
/* 116 */     return (nwglQueryPbufferARB(pbuffer, attribute, MemoryUtil.memAddress(value)) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("HPBUFFERARB")
/*     */   public static long wglCreatePbufferARB(@NativeType("HDC") long hdc, int pixelFormat, int width, int height, @NativeType("int const *") int[] attribList) {
/* 122 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglCreatePbufferARB;
/* 123 */     if (Checks.CHECKS) {
/* 124 */       Checks.check(__functionAddress);
/* 125 */       Checks.check(hdc);
/* 126 */       Checks.checkNTSafe(attribList);
/*     */     } 
/* 128 */     return JNI.callPPP(hdc, pixelFormat, width, height, attribList, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglQueryPbufferARB(@NativeType("HPBUFFERARB") long pbuffer, int attribute, @NativeType("int *") int[] value) {
/* 134 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglQueryPbufferARB;
/* 135 */     if (Checks.CHECKS) {
/* 136 */       Checks.check(__functionAddress);
/* 137 */       Checks.check(pbuffer);
/* 138 */       Checks.check(value, 1);
/*     */     } 
/* 140 */     return (JNI.callPPI(pbuffer, attribute, value, __functionAddress) != 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\WGLARBPbuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */