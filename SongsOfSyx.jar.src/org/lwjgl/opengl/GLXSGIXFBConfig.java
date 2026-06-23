/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.linux.XVisualInfo;
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
/*     */ public class GLXSGIXFBConfig
/*     */ {
/*     */   public static final int GLX_DRAWABLE_TYPE_SGIX = 32784;
/*     */   public static final int GLX_RENDER_TYPE_SGIX = 32785;
/*     */   public static final int GLX_X_RENDERABLE_SGIX = 32786;
/*     */   public static final int GLX_FBCONFIG_ID_SGIX = 32787;
/*     */   public static final int GLX_SCREEN_EXT = 32780;
/*     */   public static final int GLX_WINDOW_BIT_SGIX = 1;
/*     */   public static final int GLX_PIXMAP_BIT_SGIX = 2;
/*     */   public static final int GLX_RGBA_BIT_SGIX = 1;
/*     */   public static final int GLX_COLOR_INDEX_BIT_SGIX = 2;
/*     */   public static final int GLX_RGBA_TYPE_SGIX = 32788;
/*     */   public static final int GLX_COLOR_INDEX_TYPE_SGIX = 32789;
/*     */   
/*     */   protected GLXSGIXFBConfig() {
/*  47 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXGetFBConfigAttribSGIX(long display, long config, int attribute, long value) {
/*  54 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetFBConfigAttribSGIX;
/*  55 */     if (Checks.CHECKS) {
/*  56 */       Checks.check(__functionAddress);
/*  57 */       Checks.check(display);
/*  58 */       Checks.check(config);
/*     */     } 
/*  60 */     return JNI.callPPPI(display, config, attribute, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int glXGetFBConfigAttribSGIX(@NativeType("Display *") long display, @NativeType("GLXFBConfigSGIX") long config, int attribute, @NativeType("int *") IntBuffer value) {
/*  65 */     if (Checks.CHECKS) {
/*  66 */       Checks.check(value, 1);
/*     */     }
/*  68 */     return nglXGetFBConfigAttribSGIX(display, config, attribute, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXChooseFBConfigSGIX(long display, int screen, long attrib_list, long nelements) {
/*  75 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXChooseFBConfigSGIX;
/*  76 */     if (Checks.CHECKS) {
/*  77 */       Checks.check(__functionAddress);
/*  78 */       Checks.check(display);
/*     */     } 
/*  80 */     return JNI.callPPPP(display, screen, attrib_list, nelements, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXFBConfigSGIX *")
/*     */   public static PointerBuffer glXChooseFBConfigSGIX(@NativeType("Display *") long display, int screen, @NativeType("int const *") IntBuffer attrib_list) {
/*  86 */     if (Checks.CHECKS) {
/*  87 */       Checks.checkNTSafe(attrib_list);
/*     */     }
/*  89 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*  90 */     IntBuffer nelements = stack.callocInt(1);
/*     */     try {
/*  92 */       long __result = nglXChooseFBConfigSGIX(display, screen, MemoryUtil.memAddressSafe(attrib_list), MemoryUtil.memAddress(nelements));
/*  93 */       return MemoryUtil.memPointerBufferSafe(__result, nelements.get(0));
/*     */     } finally {
/*  95 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXPixmap")
/*     */   public static long glXCreateGLXPixmapWithConfigSGIX(@NativeType("Display *") long display, @NativeType("GLXFBConfig") long config, @NativeType("Pixmap") long pixmap) {
/* 104 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXCreateGLXPixmapWithConfigSGIX;
/* 105 */     if (Checks.CHECKS) {
/* 106 */       Checks.check(__functionAddress);
/* 107 */       Checks.check(display);
/* 108 */       Checks.check(config);
/*     */     } 
/* 110 */     return JNI.callPPNP(display, config, pixmap, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXContext")
/*     */   public static long glXCreateContextWithConfigSGIX(@NativeType("Display *") long display, @NativeType("GLXFBConfig") long config, int render_type, @NativeType("GLXContext") long share_list, @NativeType("Bool") boolean direct) {
/* 118 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXCreateContextWithConfigSGIX;
/* 119 */     if (Checks.CHECKS) {
/* 120 */       Checks.check(__functionAddress);
/* 121 */       Checks.check(display);
/* 122 */       Checks.check(config);
/* 123 */       Checks.check(share_list);
/*     */     } 
/* 125 */     return JNI.callPPPP(display, config, render_type, share_list, direct ? 1 : 0, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXGetVisualFromFBConfigSGIX(long display, long config) {
/* 132 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetVisualFromFBConfigSGIX;
/* 133 */     if (Checks.CHECKS) {
/* 134 */       Checks.check(__functionAddress);
/* 135 */       Checks.check(display);
/* 136 */       Checks.check(config);
/*     */     } 
/* 138 */     return JNI.callPPP(display, config, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("XVisualInfo *")
/*     */   public static XVisualInfo glXGetVisualFromFBConfigSGIX(@NativeType("Display *") long display, @NativeType("GLXFBConfig") long config) {
/* 144 */     long __result = nglXGetVisualFromFBConfigSGIX(display, config);
/* 145 */     return XVisualInfo.createSafe(__result);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXGetFBConfigFromVisualSGIX(long display, long vis) {
/* 152 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetFBConfigFromVisualSGIX;
/* 153 */     if (Checks.CHECKS) {
/* 154 */       Checks.check(__functionAddress);
/* 155 */       Checks.check(display);
/* 156 */       XVisualInfo.validate(vis);
/*     */     } 
/* 158 */     return JNI.callPPP(display, vis, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXFBConfigSGIX")
/*     */   public static long glXGetFBConfigFromVisualSGIX(@NativeType("Display *") long display, @NativeType("XVisualInfo *") XVisualInfo vis) {
/* 164 */     return nglXGetFBConfigFromVisualSGIX(display, vis.address());
/*     */   }
/*     */ 
/*     */   
/*     */   public static int glXGetFBConfigAttribSGIX(@NativeType("Display *") long display, @NativeType("GLXFBConfigSGIX") long config, int attribute, @NativeType("int *") int[] value) {
/* 169 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetFBConfigAttribSGIX;
/* 170 */     if (Checks.CHECKS) {
/* 171 */       Checks.check(__functionAddress);
/* 172 */       Checks.check(display);
/* 173 */       Checks.check(config);
/* 174 */       Checks.check(value, 1);
/*     */     } 
/* 176 */     return JNI.callPPPI(display, config, attribute, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXFBConfigSGIX *")
/*     */   public static PointerBuffer glXChooseFBConfigSGIX(@NativeType("Display *") long display, int screen, @NativeType("int const *") int[] attrib_list) {
/* 182 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXChooseFBConfigSGIX;
/* 183 */     if (Checks.CHECKS) {
/* 184 */       Checks.check(__functionAddress);
/* 185 */       Checks.check(display);
/* 186 */       Checks.checkNTSafe(attrib_list);
/*     */     } 
/* 188 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/* 189 */     IntBuffer nelements = stack.callocInt(1);
/*     */     try {
/* 191 */       long __result = JNI.callPPPP(display, screen, attrib_list, MemoryUtil.memAddress(nelements), __functionAddress);
/* 192 */       return MemoryUtil.memPointerBufferSafe(__result, nelements.get(0));
/*     */     } finally {
/* 194 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLXSGIXFBConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */