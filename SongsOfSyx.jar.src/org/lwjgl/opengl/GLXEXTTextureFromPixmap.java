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
/*     */ public class GLXEXTTextureFromPixmap
/*     */ {
/*     */   public static final int GLX_BIND_TO_TEXTURE_RGB_EXT = 8400;
/*     */   public static final int GLX_BIND_TO_TEXTURE_RGBA_EXT = 8401;
/*     */   public static final int GLX_BIND_TO_MIPMAP_TEXTURE_EXT = 8402;
/*     */   public static final int GLX_BIND_TO_TEXTURE_TARGETS_EXT = 8403;
/*     */   public static final int GLX_Y_INVERTED_EXT = 8404;
/*     */   public static final int GLX_TEXTURE_FORMAT_EXT = 8405;
/*     */   public static final int GLX_TEXTURE_TARGET_EXT = 8406;
/*     */   public static final int GLX_MIPMAP_TEXTURE_EXT = 8407;
/*     */   public static final int GLX_TEXTURE_FORMAT_NONE_EXT = 8408;
/*     */   public static final int GLX_TEXTURE_FORMAT_RGB_EXT = 8409;
/*     */   public static final int GLX_TEXTURE_FORMAT_RGBA_EXT = 8410;
/*     */   public static final int GLX_TEXTURE_1D_BIT_EXT = 1;
/*     */   public static final int GLX_TEXTURE_2D_BIT_EXT = 2;
/*     */   public static final int GLX_TEXTURE_RECTANGLE_BIT_EXT = 4;
/*     */   public static final int GLX_TEXTURE_1D_EXT = 8411;
/*     */   public static final int GLX_TEXTURE_2D_EXT = 8412;
/*     */   public static final int GLX_TEXTURE_RECTANGLE_EXT = 8413;
/*     */   public static final int GLX_FRONT_LEFT_EXT = 8414;
/*     */   public static final int GLX_FRONT_RIGHT_EXT = 8415;
/*     */   public static final int GLX_BACK_LEFT_EXT = 8416;
/*     */   public static final int GLX_BACK_RIGHT_EXT = 8417;
/*     */   public static final int GLX_FRONT_EXT = 8414;
/*     */   public static final int GLX_BACK_EXT = 8416;
/*     */   public static final int GLX_AUX0_EXT = 8418;
/*     */   public static final int GLX_AUX1_EXT = 8419;
/*     */   public static final int GLX_AUX2_EXT = 8420;
/*     */   public static final int GLX_AUX3_EXT = 8421;
/*     */   public static final int GLX_AUX4_EXT = 8422;
/*     */   public static final int GLX_AUX5_EXT = 8423;
/*     */   public static final int GLX_AUX6_EXT = 8424;
/*     */   public static final int GLX_AUX7_EXT = 8425;
/*     */   public static final int GLX_AUX8_EXT = 8426;
/*     */   public static final int GLX_AUX9_EXT = 8427;
/*     */   
/*     */   protected GLXEXTTextureFromPixmap() {
/*  66 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglXBindTexImageEXT(long display, long drawable, int buffer, long attrib_list) {
/*  73 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXBindTexImageEXT;
/*  74 */     if (Checks.CHECKS) {
/*  75 */       Checks.check(__functionAddress);
/*  76 */       Checks.check(display);
/*  77 */       Checks.check(drawable);
/*     */     } 
/*  79 */     JNI.callPPPV(display, drawable, buffer, attrib_list, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glXBindTexImageEXT(@NativeType("Display *") long display, @NativeType("GLXDrawable") long drawable, int buffer, @NativeType("int const *") IntBuffer attrib_list) {
/*  84 */     if (Checks.CHECKS) {
/*  85 */       Checks.checkNTSafe(attrib_list);
/*     */     }
/*  87 */     nglXBindTexImageEXT(display, drawable, buffer, MemoryUtil.memAddressSafe(attrib_list));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glXReleaseTexImageEXT(@NativeType("Display *") long display, @NativeType("GLXDrawable") long drawable, int buffer) {
/*  94 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXReleaseTexImageEXT;
/*  95 */     if (Checks.CHECKS) {
/*  96 */       Checks.check(__functionAddress);
/*  97 */       Checks.check(display);
/*  98 */       Checks.check(drawable);
/*     */     } 
/* 100 */     JNI.callPPV(display, drawable, buffer, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glXBindTexImageEXT(@NativeType("Display *") long display, @NativeType("GLXDrawable") long drawable, int buffer, @NativeType("int const *") int[] attrib_list) {
/* 105 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXBindTexImageEXT;
/* 106 */     if (Checks.CHECKS) {
/* 107 */       Checks.check(__functionAddress);
/* 108 */       Checks.check(display);
/* 109 */       Checks.check(drawable);
/* 110 */       Checks.checkNTSafe(attrib_list);
/*     */     } 
/* 112 */     JNI.callPPPV(display, drawable, buffer, attrib_list, __functionAddress);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLXEXTTextureFromPixmap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */