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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WGLARBRenderTexture
/*     */ {
/*     */   public static final int WGL_BIND_TO_TEXTURE_RGB_ARB = 8304;
/*     */   public static final int WGL_BIND_TO_TEXTURE_RGBA_ARB = 8305;
/*     */   public static final int WGL_TEXTURE_FORMAT_ARB = 8306;
/*     */   public static final int WGL_TEXTURE_TARGET_ARB = 8307;
/*     */   public static final int WGL_MIPMAP_TEXTURE_ARB = 8308;
/*     */   public static final int WGL_TEXTURE_RGB_ARB = 8309;
/*     */   public static final int WGL_TEXTURE_RGBA_ARB = 8310;
/*     */   public static final int WGL_NO_TEXTURE_ARB = 8311;
/*     */   public static final int WGL_TEXTURE_CUBE_MAP_ARB = 8312;
/*     */   public static final int WGL_TEXTURE_1D_ARB = 8313;
/*     */   public static final int WGL_TEXTURE_2D_ARB = 8314;
/*     */   public static final int WGL_MIPMAP_LEVEL_ARB = 8315;
/*     */   public static final int WGL_CUBE_MAP_FACE_ARB = 8316;
/*     */   public static final int WGL_TEXTURE_CUBE_MAP_POSITIVE_X_ARB = 8317;
/*     */   public static final int WGL_TEXTURE_CUBE_MAP_NEGATIVE_X_ARB = 8318;
/*     */   public static final int WGL_TEXTURE_CUBE_MAP_POSITIVE_Y_ARB = 8319;
/*     */   public static final int WGL_TEXTURE_CUBE_MAP_NEGATIVE_Y_ARB = 8320;
/*     */   public static final int WGL_TEXTURE_CUBE_MAP_POSITIVE_Z_ARB = 8321;
/*     */   public static final int WGL_TEXTURE_CUBE_MAP_NEGATIVE_Z_ARB = 8322;
/*     */   public static final int WGL_FRONT_LEFT_ARB = 8323;
/*     */   public static final int WGL_FRONT_RIGHT_ARB = 8324;
/*     */   public static final int WGL_BACK_LEFT_ARB = 8325;
/*     */   public static final int WGL_BACK_RIGHT_ARB = 8326;
/*     */   public static final int WGL_AUX0_ARB = 8327;
/*     */   public static final int WGL_AUX1_ARB = 8328;
/*     */   public static final int WGL_AUX2_ARB = 8329;
/*     */   public static final int WGL_AUX3_ARB = 8330;
/*     */   public static final int WGL_AUX4_ARB = 8331;
/*     */   public static final int WGL_AUX5_ARB = 8332;
/*     */   public static final int WGL_AUX6_ARB = 8333;
/*     */   public static final int WGL_AUX7_ARB = 8334;
/*     */   public static final int WGL_AUX8_ARB = 8335;
/*     */   public static final int WGL_AUX9_ARB = 8336;
/*     */   
/*     */   protected WGLARBRenderTexture() {
/*  68 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglBindTexImageARB(@NativeType("HPBUFFERARB") long pbuffer, int buffer) {
/*  76 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglBindTexImageARB;
/*  77 */     if (Checks.CHECKS) {
/*  78 */       Checks.check(__functionAddress);
/*  79 */       Checks.check(pbuffer);
/*     */     } 
/*  81 */     return (JNI.callPI(pbuffer, buffer, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglReleaseTexImageARB(@NativeType("HPBUFFERARB") long pbuffer, int buffer) {
/*  89 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglReleaseTexImageARB;
/*  90 */     if (Checks.CHECKS) {
/*  91 */       Checks.check(__functionAddress);
/*  92 */       Checks.check(pbuffer);
/*     */     } 
/*  94 */     return (JNI.callPI(pbuffer, buffer, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglSetPbufferAttribARB(long pbuffer, long attribList) {
/* 101 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglSetPbufferAttribARB;
/* 102 */     if (Checks.CHECKS) {
/* 103 */       Checks.check(__functionAddress);
/* 104 */       Checks.check(pbuffer);
/*     */     } 
/* 106 */     return JNI.callPPI(pbuffer, attribList, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglSetPbufferAttribARB(@NativeType("HPBUFFERARB") long pbuffer, @NativeType("int const *") IntBuffer attribList) {
/* 112 */     if (Checks.CHECKS) {
/* 113 */       Checks.checkNTSafe(attribList);
/*     */     }
/* 115 */     return (nwglSetPbufferAttribARB(pbuffer, MemoryUtil.memAddressSafe(attribList)) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglSetPbufferAttribARB(@NativeType("HPBUFFERARB") long pbuffer, @NativeType("int const *") int[] attribList) {
/* 121 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglSetPbufferAttribARB;
/* 122 */     if (Checks.CHECKS) {
/* 123 */       Checks.check(__functionAddress);
/* 124 */       Checks.check(pbuffer);
/* 125 */       Checks.checkNTSafe(attribList);
/*     */     } 
/* 127 */     return (JNI.callPPI(pbuffer, attribList, __functionAddress) != 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\WGLARBRenderTexture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */