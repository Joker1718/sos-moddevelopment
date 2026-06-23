/*     */ package org.lwjgl.opengl;public class GLX { public static final int GLXBadContext = 0; public static final int GLXBadContextState = 1; public static final int GLXBadDrawable = 2; public static final int GLXBadPixmap = 3; public static final int GLXBadContextTag = 4; public static final int GLXBadCurrentWindow = 5; public static final int GLXBadRenderRequest = 6; public static final int GLXBadLargeRequest = 7; public static final int GLXUnsupportedPrivateRequest = 8; public static final int GLXBadFBConfig = 9;
/*     */   public static final int GLXBadPbuffer = 10;
/*     */   public static final int GLXBadCurrentDrawable = 11;
/*     */   public static final int GLXBadWindow = 12;
/*     */   public static final int GLX_USE_GL = 1;
/*     */   public static final int GLX_BUFFER_SIZE = 2;
/*     */   public static final int GLX_LEVEL = 3;
/*     */   public static final int GLX_RGBA = 4;
/*     */   public static final int GLX_DOUBLEBUFFER = 5;
/*     */   public static final int GLX_STEREO = 6;
/*     */   public static final int GLX_AUX_BUFFERS = 7;
/*     */   public static final int GLX_RED_SIZE = 8;
/*     */   public static final int GLX_GREEN_SIZE = 9;
/*     */   public static final int GLX_BLUE_SIZE = 10;
/*     */   public static final int GLX_ALPHA_SIZE = 11;
/*     */   public static final int GLX_DEPTH_SIZE = 12;
/*     */   public static final int GLX_STENCIL_SIZE = 13;
/*     */   public static final int GLX_ACCUM_RED_SIZE = 14;
/*     */   public static final int GLX_ACCUM_GREEN_SIZE = 15;
/*     */   public static final int GLX_ACCUM_BLUE_SIZE = 16;
/*     */   public static final int GLX_ACCUM_ALPHA_SIZE = 17;
/*     */   public static final int GLX_BAD_SCREEN = 1;
/*     */   public static final int GLX_BAD_ATTRIBUTE = 2;
/*     */   public static final int GLX_NO_EXTENSION = 3;
/*     */   public static final int GLX_BAD_VISUAL = 4;
/*     */   public static final int GLX_BAD_CONTEXT = 5;
/*     */   public static final int GLX_BAD_VALUE = 6;
/*     */   public static final int GLX_BAD_ENUM = 7;
/*     */   
/*  30 */   public static final class Functions { public static final long QueryExtension = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXQueryExtension");
/*  31 */     public static final long QueryVersion = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXQueryVersion");
/*  32 */     public static final long GetConfig = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXGetConfig");
/*  33 */     public static final long ChooseVisual = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXChooseVisual");
/*  34 */     public static final long CreateContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXCreateContext");
/*  35 */     public static final long MakeCurrent = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXMakeCurrent");
/*  36 */     public static final long CopyContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXCopyContext");
/*  37 */     public static final long IsDirect = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXIsDirect");
/*  38 */     public static final long DestroyContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXDestroyContext");
/*  39 */     public static final long GetCurrentContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXGetCurrentContext");
/*  40 */     public static final long GetCurrentDrawable = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXGetCurrentDrawable");
/*  41 */     public static final long WaitGL = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXWaitGL");
/*  42 */     public static final long WaitX = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXWaitX");
/*  43 */     public static final long SwapBuffers = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXSwapBuffers");
/*  44 */     public static final long UseXFont = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXUseXFont");
/*  45 */     public static final long CreateGLXPixmap = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXCreateGLXPixmap");
/*  46 */     public static final long DestroyGLXPixmap = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "glXDestroyGLXPixmap"); }
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
/*     */   protected GLX() {
/*  94 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXQueryExtension(long display, long error_base, long event_base) {
/* 101 */     long __functionAddress = Functions.QueryExtension;
/* 102 */     if (Checks.CHECKS) {
/* 103 */       Checks.check(display);
/*     */     }
/* 105 */     return JNI.callPPPI(display, error_base, event_base, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQueryExtension(@NativeType("Display *") long display, @NativeType("int *") IntBuffer error_base, @NativeType("int *") IntBuffer event_base) {
/* 111 */     if (Checks.CHECKS) {
/* 112 */       Checks.check(error_base, 1);
/* 113 */       Checks.check(event_base, 1);
/*     */     } 
/* 115 */     return (nglXQueryExtension(display, MemoryUtil.memAddress(error_base), MemoryUtil.memAddress(event_base)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXQueryVersion(long display, long major, long minor) {
/* 122 */     long __functionAddress = Functions.QueryVersion;
/* 123 */     if (Checks.CHECKS) {
/* 124 */       Checks.check(display);
/*     */     }
/* 126 */     return JNI.callPPPI(display, major, minor, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQueryVersion(@NativeType("Display *") long display, @NativeType("int *") IntBuffer major, @NativeType("int *") IntBuffer minor) {
/* 132 */     if (Checks.CHECKS) {
/* 133 */       Checks.check(major, 1);
/* 134 */       Checks.check(minor, 1);
/*     */     } 
/* 136 */     return (nglXQueryVersion(display, MemoryUtil.memAddress(major), MemoryUtil.memAddress(minor)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXGetConfig(long display, long visual, int attribute, long value) {
/* 143 */     long __functionAddress = Functions.GetConfig;
/* 144 */     if (Checks.CHECKS) {
/* 145 */       Checks.check(display);
/* 146 */       XVisualInfo.validate(visual);
/*     */     } 
/* 148 */     return JNI.callPPPI(display, visual, attribute, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int glXGetConfig(@NativeType("Display *") long display, @NativeType("XVisualInfo *") XVisualInfo visual, int attribute, @NativeType("int *") IntBuffer value) {
/* 153 */     if (Checks.CHECKS) {
/* 154 */       Checks.check(value, 1);
/*     */     }
/* 156 */     return nglXGetConfig(display, visual.address(), attribute, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXChooseVisual(long display, int screen, long attrib_list) {
/* 163 */     long __functionAddress = Functions.ChooseVisual;
/* 164 */     if (Checks.CHECKS) {
/* 165 */       Checks.check(display);
/*     */     }
/* 167 */     return JNI.callPPP(display, screen, attrib_list, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("XVisualInfo *")
/*     */   public static XVisualInfo glXChooseVisual(@NativeType("Display *") long display, int screen, @NativeType("int *") IntBuffer attrib_list) {
/* 173 */     if (Checks.CHECKS) {
/* 174 */       Checks.checkNTSafe(attrib_list);
/*     */     }
/* 176 */     long __result = nglXChooseVisual(display, screen, MemoryUtil.memAddressSafe(attrib_list));
/* 177 */     return XVisualInfo.createSafe(__result);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXCreateContext(long display, long visual, long share_list, int direct) {
/* 184 */     long __functionAddress = Functions.CreateContext;
/* 185 */     if (Checks.CHECKS) {
/* 186 */       Checks.check(display);
/* 187 */       XVisualInfo.validate(visual);
/*     */     } 
/* 189 */     return JNI.callPPPP(display, visual, share_list, direct, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXContext")
/*     */   public static long glXCreateContext(@NativeType("Display *") long display, @NativeType("XVisualInfo *") XVisualInfo visual, @NativeType("GLXContext") long share_list, @NativeType("Bool") boolean direct) {
/* 195 */     return nglXCreateContext(display, visual.address(), share_list, direct ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXMakeCurrent(@NativeType("Display *") long display, @NativeType("GLXDrawable") long draw, @NativeType("GLXContext") long ctx) {
/* 203 */     long __functionAddress = Functions.MakeCurrent;
/* 204 */     if (Checks.CHECKS) {
/* 205 */       Checks.check(display);
/*     */     }
/* 207 */     return (JNI.callPPPI(display, draw, ctx, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glXCopyContext(@NativeType("Display *") long display, @NativeType("GLXContext") long source, @NativeType("GLXContext") long dest, @NativeType("unsigned long") long mask) {
/* 214 */     long __functionAddress = Functions.CopyContext;
/* 215 */     if (Checks.CHECKS) {
/* 216 */       Checks.check(display);
/* 217 */       Checks.check(source);
/* 218 */       Checks.check(dest);
/*     */     } 
/* 220 */     JNI.callPPPNV(display, source, dest, mask, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXIsDirect(@NativeType("Display *") long display, @NativeType("GLXContext") long ctx) {
/* 228 */     long __functionAddress = Functions.IsDirect;
/* 229 */     if (Checks.CHECKS) {
/* 230 */       Checks.check(display);
/* 231 */       Checks.check(ctx);
/*     */     } 
/* 233 */     return (JNI.callPPI(display, ctx, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glXDestroyContext(@NativeType("Display *") long display, @NativeType("GLXContext") long ctx) {
/* 240 */     long __functionAddress = Functions.DestroyContext;
/* 241 */     if (Checks.CHECKS) {
/* 242 */       Checks.check(display);
/* 243 */       Checks.check(ctx);
/*     */     } 
/* 245 */     JNI.callPPV(display, ctx, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXContext")
/*     */   public static long glXGetCurrentContext() {
/* 253 */     long __functionAddress = Functions.GetCurrentContext;
/* 254 */     return JNI.callP(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXDrawable")
/*     */   public static long glXGetCurrentDrawable() {
/* 262 */     long __functionAddress = Functions.GetCurrentDrawable;
/* 263 */     return JNI.callP(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glXWaitGL() {
/* 270 */     long __functionAddress = Functions.WaitGL;
/* 271 */     JNI.callV(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glXWaitX() {
/* 278 */     long __functionAddress = Functions.WaitX;
/* 279 */     JNI.callV(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glXSwapBuffers(@NativeType("Display *") long display, @NativeType("GLXDrawable") long draw) {
/* 286 */     long __functionAddress = Functions.SwapBuffers;
/* 287 */     if (Checks.CHECKS) {
/* 288 */       Checks.check(display);
/* 289 */       Checks.check(draw);
/*     */     } 
/* 291 */     JNI.callPPV(display, draw, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glXUseXFont(@NativeType("Font") long font, int first, int count, int list_base) {
/* 298 */     long __functionAddress = Functions.UseXFont;
/* 299 */     JNI.callNV(font, first, count, list_base, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXCreateGLXPixmap(long display, long visual, long pixmap) {
/* 306 */     long __functionAddress = Functions.CreateGLXPixmap;
/* 307 */     if (Checks.CHECKS) {
/* 308 */       Checks.check(display);
/* 309 */       XVisualInfo.validate(visual);
/*     */     } 
/* 311 */     return JNI.callPPNP(display, visual, pixmap, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXPixmap")
/*     */   public static long glXCreateGLXPixmap(@NativeType("Display *") long display, @NativeType("XVisualInfo *") XVisualInfo visual, @NativeType("Pixmap") long pixmap) {
/* 317 */     return nglXCreateGLXPixmap(display, visual.address(), pixmap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glXDestroyGLXPixmap(@NativeType("Display *") long display, @NativeType("GLXPixmap") long pixmap) {
/* 324 */     long __functionAddress = Functions.DestroyGLXPixmap;
/* 325 */     if (Checks.CHECKS) {
/* 326 */       Checks.check(display);
/* 327 */       Checks.check(pixmap);
/*     */     } 
/* 329 */     JNI.callPPV(display, pixmap, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQueryExtension(@NativeType("Display *") long display, @NativeType("int *") int[] error_base, @NativeType("int *") int[] event_base) {
/* 335 */     long __functionAddress = Functions.QueryExtension;
/* 336 */     if (Checks.CHECKS) {
/* 337 */       Checks.check(display);
/* 338 */       Checks.check(error_base, 1);
/* 339 */       Checks.check(event_base, 1);
/*     */     } 
/* 341 */     return (JNI.callPPPI(display, error_base, event_base, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQueryVersion(@NativeType("Display *") long display, @NativeType("int *") int[] major, @NativeType("int *") int[] minor) {
/* 347 */     long __functionAddress = Functions.QueryVersion;
/* 348 */     if (Checks.CHECKS) {
/* 349 */       Checks.check(display);
/* 350 */       Checks.check(major, 1);
/* 351 */       Checks.check(minor, 1);
/*     */     } 
/* 353 */     return (JNI.callPPPI(display, major, minor, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int glXGetConfig(@NativeType("Display *") long display, @NativeType("XVisualInfo *") XVisualInfo visual, int attribute, @NativeType("int *") int[] value) {
/* 358 */     long __functionAddress = Functions.GetConfig;
/* 359 */     if (Checks.CHECKS) {
/* 360 */       Checks.check(display);
/* 361 */       Checks.check(value, 1);
/* 362 */       XVisualInfo.validate(visual.address());
/*     */     } 
/* 364 */     return JNI.callPPPI(display, visual.address(), attribute, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("XVisualInfo *")
/*     */   public static XVisualInfo glXChooseVisual(@NativeType("Display *") long display, int screen, @NativeType("int *") int[] attrib_list) {
/* 370 */     long __functionAddress = Functions.ChooseVisual;
/* 371 */     if (Checks.CHECKS) {
/* 372 */       Checks.check(display);
/* 373 */       Checks.checkNTSafe(attrib_list);
/*     */     } 
/* 375 */     long __result = JNI.callPPP(display, screen, attrib_list, __functionAddress);
/* 376 */     return XVisualInfo.createSafe(__result);
/*     */   } }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLX.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */