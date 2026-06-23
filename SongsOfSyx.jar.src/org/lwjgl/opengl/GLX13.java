/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.CLongBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
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
/*     */ public class GLX13
/*     */   extends GLX12
/*     */ {
/*     */   public static final int GLX_WINDOW_BIT = 1;
/*     */   public static final int GLX_PIXMAP_BIT = 2;
/*     */   public static final int GLX_PBUFFER_BIT = 4;
/*     */   public static final int GLX_RGBA_BIT = 1;
/*     */   public static final int GLX_COLOR_INDEX_BIT = 2;
/*     */   public static final int GLX_PBUFFER_CLOBBER_MASK = 134217728;
/*     */   public static final int GLX_FRONT_LEFT_BUFFER_BIT = 1;
/*     */   public static final int GLX_FRONT_RIGHT_BUFFER_BIT = 2;
/*     */   public static final int GLX_BACK_LEFT_BUFFER_BIT = 4;
/*     */   public static final int GLX_BACK_RIGHT_BUFFER_BIT = 8;
/*     */   public static final int GLX_AUX_BUFFERS_BIT = 16;
/*     */   public static final int GLX_DEPTH_BUFFER_BIT = 32;
/*     */   public static final int GLX_STENCIL_BUFFER_BIT = 64;
/*     */   public static final int GLX_ACCUM_BUFFER_BIT = 128;
/*     */   public static final int GLX_CONFIG_CAVEAT = 32;
/*     */   public static final int GLX_X_VISUAL_TYPE = 34;
/*     */   public static final int GLX_TRANSPARENT_TYPE = 35;
/*     */   public static final int GLX_TRANSPARENT_INDEX_VALUE = 36;
/*     */   public static final int GLX_TRANSPARENT_RED_VALUE = 37;
/*     */   public static final int GLX_TRANSPARENT_GREEN_VALUE = 38;
/*     */   public static final int GLX_TRANSPARENT_BLUE_VALUE = 39;
/*     */   public static final int GLX_TRANSPARENT_ALPHA_VALUE = 40;
/*     */   public static final int GLX_DONT_CARE = -1;
/*     */   public static final int GLX_NONE = 32768;
/*     */   public static final int GLX_SLOW_CONFIG = 32769;
/*     */   public static final int GLX_TRUE_COLOR = 32770;
/*     */   public static final int GLX_DIRECT_COLOR = 32771;
/*     */   public static final int GLX_PSEUDO_COLOR = 32772;
/*     */   public static final int GLX_STATIC_COLOR = 32773;
/*     */   public static final int GLX_GRAY_SCALE = 32774;
/*     */   public static final int GLX_STATIC_GRAY = 32775;
/*     */   public static final int GLX_TRANSPARENT_RGB = 32776;
/*     */   public static final int GLX_TRANSPARENT_INDEX = 32777;
/*     */   public static final int GLX_VISUAL_ID = 32779;
/*     */   public static final int GLX_SCREEN = 32780;
/*     */   public static final int GLX_NON_CONFORMANT_CONFIG = 32781;
/*     */   public static final int GLX_DRAWABLE_TYPE = 32784;
/*     */   public static final int GLX_RENDER_TYPE = 32785;
/*     */   public static final int GLX_X_RENDERABLE = 32786;
/*     */   public static final int GLX_FBCONFIG_ID = 32787;
/*     */   public static final int GLX_RGBA_TYPE = 32788;
/*     */   public static final int GLX_COLOR_INDEX_TYPE = 32789;
/*     */   public static final int GLX_MAX_PBUFFER_WIDTH = 32790;
/*     */   public static final int GLX_MAX_PBUFFER_HEIGHT = 32791;
/*     */   public static final int GLX_MAX_PBUFFER_PIXELS = 32792;
/*     */   public static final int GLX_PRESERVED_CONTENTS = 32795;
/*     */   public static final int GLX_LARGEST_PBUFFER = 32796;
/*     */   public static final int GLX_WIDTH = 32797;
/*     */   public static final int GLX_HEIGHT = 32798;
/*     */   public static final int GLX_EVENT_MASK = 32799;
/*     */   public static final int GLX_DAMAGED = 32800;
/*     */   public static final int GLX_SAVED = 32801;
/*     */   public static final int GLX_WINDOW = 32802;
/*     */   public static final int GLX_PBUFFER = 32803;
/*     */   public static final int GLX_PBUFFER_HEIGHT = 32832;
/*     */   public static final int GLX_PBUFFER_WIDTH = 32833;
/*     */   
/*     */   protected GLX13() {
/*  84 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXGetFBConfigs(long display, int screen, long nelements) {
/*  91 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetFBConfigs;
/*  92 */     if (Checks.CHECKS) {
/*  93 */       Checks.check(__functionAddress);
/*  94 */       Checks.check(display);
/*     */     } 
/*  96 */     return JNI.callPPP(display, screen, nelements, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXFBConfig *")
/*     */   public static PointerBuffer glXGetFBConfigs(@NativeType("Display *") long display, int screen) {
/* 102 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/* 103 */     IntBuffer nelements = stack.callocInt(1);
/*     */     try {
/* 105 */       long __result = nglXGetFBConfigs(display, screen, MemoryUtil.memAddress(nelements));
/* 106 */       return MemoryUtil.memPointerBufferSafe(__result, nelements.get(0));
/*     */     } finally {
/* 108 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXChooseFBConfig(long display, int screen, long attrib_list, long nelements) {
/* 116 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXChooseFBConfig;
/* 117 */     if (Checks.CHECKS) {
/* 118 */       Checks.check(__functionAddress);
/* 119 */       Checks.check(display);
/*     */     } 
/* 121 */     return JNI.callPPPP(display, screen, attrib_list, nelements, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXFBConfig *")
/*     */   public static PointerBuffer glXChooseFBConfig(@NativeType("Display *") long display, int screen, @NativeType("int const *") IntBuffer attrib_list) {
/* 127 */     if (Checks.CHECKS) {
/* 128 */       Checks.checkNTSafe(attrib_list);
/*     */     }
/* 130 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/* 131 */     IntBuffer nelements = stack.callocInt(1);
/*     */     try {
/* 133 */       long __result = nglXChooseFBConfig(display, screen, MemoryUtil.memAddressSafe(attrib_list), MemoryUtil.memAddress(nelements));
/* 134 */       return MemoryUtil.memPointerBufferSafe(__result, nelements.get(0));
/*     */     } finally {
/* 136 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXGetFBConfigAttrib(long display, long config, int attribute, long value) {
/* 144 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetFBConfigAttrib;
/* 145 */     if (Checks.CHECKS) {
/* 146 */       Checks.check(__functionAddress);
/* 147 */       Checks.check(display);
/* 148 */       Checks.check(config);
/*     */     } 
/* 150 */     return JNI.callPPPI(display, config, attribute, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int glXGetFBConfigAttrib(@NativeType("Display *") long display, @NativeType("GLXFBConfig") long config, int attribute, @NativeType("int *") IntBuffer value) {
/* 155 */     if (Checks.CHECKS) {
/* 156 */       Checks.check(value, 1);
/*     */     }
/* 158 */     return nglXGetFBConfigAttrib(display, config, attribute, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXGetVisualFromFBConfig(long display, long config) {
/* 165 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetVisualFromFBConfig;
/* 166 */     if (Checks.CHECKS) {
/* 167 */       Checks.check(__functionAddress);
/* 168 */       Checks.check(display);
/* 169 */       Checks.check(config);
/*     */     } 
/* 171 */     return JNI.callPPP(display, config, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("XVisualInfo *")
/*     */   public static XVisualInfo glXGetVisualFromFBConfig(@NativeType("Display *") long display, @NativeType("GLXFBConfig") long config) {
/* 177 */     long __result = nglXGetVisualFromFBConfig(display, config);
/* 178 */     return XVisualInfo.createSafe(__result);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXCreateWindow(long display, long config, long win, long attrib_list) {
/* 185 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXCreateWindow;
/* 186 */     if (Checks.CHECKS) {
/* 187 */       Checks.check(__functionAddress);
/* 188 */       Checks.check(display);
/* 189 */       Checks.check(config);
/*     */     } 
/* 191 */     return JNI.callPPNPP(display, config, win, attrib_list, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXWindow")
/*     */   public static long glXCreateWindow(@NativeType("Display *") long display, @NativeType("GLXFBConfig") long config, @NativeType("Window") long win, @NativeType("int const *") IntBuffer attrib_list) {
/* 197 */     if (Checks.CHECKS) {
/* 198 */       Checks.checkNTSafe(attrib_list);
/*     */     }
/* 200 */     return nglXCreateWindow(display, config, win, MemoryUtil.memAddressSafe(attrib_list));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXCreatePixmap(long display, long config, long pixmap, long attrib_list) {
/* 207 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXCreatePixmap;
/* 208 */     if (Checks.CHECKS) {
/* 209 */       Checks.check(__functionAddress);
/* 210 */       Checks.check(display);
/* 211 */       Checks.check(config);
/*     */     } 
/* 213 */     return JNI.callPPNPP(display, config, pixmap, attrib_list, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXPixmap")
/*     */   public static long glXCreatePixmap(@NativeType("Display *") long display, @NativeType("GLXFBConfig") long config, @NativeType("Pixmap") long pixmap, @NativeType("int const *") IntBuffer attrib_list) {
/* 219 */     if (Checks.CHECKS) {
/* 220 */       Checks.checkNTSafe(attrib_list);
/*     */     }
/* 222 */     return nglXCreatePixmap(display, config, pixmap, MemoryUtil.memAddressSafe(attrib_list));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glXDestroyPixmap(@NativeType("Display *") long display, @NativeType("GLXPixmap") long pixmap) {
/* 229 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXDestroyPixmap;
/* 230 */     if (Checks.CHECKS) {
/* 231 */       Checks.check(__functionAddress);
/* 232 */       Checks.check(display);
/* 233 */       Checks.check(pixmap);
/*     */     } 
/* 235 */     JNI.callPPV(display, pixmap, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXCreatePbuffer(long display, long config, long attrib_list) {
/* 242 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXCreatePbuffer;
/* 243 */     if (Checks.CHECKS) {
/* 244 */       Checks.check(__functionAddress);
/* 245 */       Checks.check(display);
/* 246 */       Checks.check(config);
/*     */     } 
/* 248 */     return JNI.callPPPP(display, config, attrib_list, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXPbuffer")
/*     */   public static long glXCreatePbuffer(@NativeType("Display *") long display, @NativeType("GLXFBConfig") long config, @NativeType("int const *") IntBuffer attrib_list) {
/* 254 */     if (Checks.CHECKS) {
/* 255 */       Checks.checkNTSafe(attrib_list);
/*     */     }
/* 257 */     return nglXCreatePbuffer(display, config, MemoryUtil.memAddressSafe(attrib_list));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glXDestroyPbuffer(@NativeType("Display *") long display, @NativeType("GLXPbuffer") long pbuf) {
/* 264 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXDestroyPbuffer;
/* 265 */     if (Checks.CHECKS) {
/* 266 */       Checks.check(__functionAddress);
/* 267 */       Checks.check(display);
/* 268 */       Checks.check(pbuf);
/*     */     } 
/* 270 */     JNI.callPPV(display, pbuf, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglXQueryDrawable(long display, long draw, int attribute, long value) {
/* 277 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXQueryDrawable;
/* 278 */     if (Checks.CHECKS) {
/* 279 */       Checks.check(__functionAddress);
/* 280 */       Checks.check(display);
/* 281 */       Checks.check(draw);
/*     */     } 
/* 283 */     JNI.callPPPV(display, draw, attribute, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glXQueryDrawable(@NativeType("Display *") long display, @NativeType("GLXDrawable") long draw, int attribute, @NativeType("unsigned int *") IntBuffer value) {
/* 288 */     if (Checks.CHECKS) {
/* 289 */       Checks.check(value, 1);
/*     */     }
/* 291 */     nglXQueryDrawable(display, draw, attribute, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glXQueryDrawable(@NativeType("Display *") long display, @NativeType("GLXDrawable") long draw, int attribute) {
/* 297 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 299 */       IntBuffer value = stack.callocInt(1);
/* 300 */       nglXQueryDrawable(display, draw, attribute, MemoryUtil.memAddress(value));
/* 301 */       return value.get(0);
/*     */     } finally {
/* 303 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXContext")
/*     */   public static long glXCreateNewContext(@NativeType("Display *") long display, @NativeType("GLXFBConfig") long config, int render_type, @NativeType("GLXContext") long share_list, @NativeType("Bool") boolean direct) {
/* 312 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXCreateNewContext;
/* 313 */     if (Checks.CHECKS) {
/* 314 */       Checks.check(__functionAddress);
/* 315 */       Checks.check(display);
/* 316 */       Checks.check(config);
/*     */     } 
/* 318 */     return JNI.callPPPP(display, config, render_type, share_list, direct ? 1 : 0, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXMakeContextCurrent(@NativeType("Display *") long display, @NativeType("GLXDrawable") long draw, @NativeType("GLXDrawable") long read, @NativeType("GLXContext") long ctx) {
/* 326 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXMakeContextCurrent;
/* 327 */     if (Checks.CHECKS) {
/* 328 */       Checks.check(__functionAddress);
/* 329 */       Checks.check(display);
/*     */     } 
/* 331 */     return (JNI.callPPPPI(display, draw, read, ctx, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXDrawable")
/*     */   public static long glXGetCurrentReadDrawable() {
/* 339 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetCurrentReadDrawable;
/* 340 */     if (Checks.CHECKS) {
/* 341 */       Checks.check(__functionAddress);
/*     */     }
/* 343 */     return JNI.callP(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXQueryContext(long display, long ctx, int attribute, long value) {
/* 350 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXQueryContext;
/* 351 */     if (Checks.CHECKS) {
/* 352 */       Checks.check(__functionAddress);
/* 353 */       Checks.check(display);
/* 354 */       Checks.check(ctx);
/*     */     } 
/* 356 */     return JNI.callPPPI(display, ctx, attribute, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int glXQueryContext(@NativeType("Display *") long display, @NativeType("GLXContext") long ctx, int attribute, @NativeType("int *") IntBuffer value) {
/* 361 */     if (Checks.CHECKS) {
/* 362 */       Checks.check(value, 1);
/*     */     }
/* 364 */     return nglXQueryContext(display, ctx, attribute, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glXSelectEvent(@NativeType("Display *") long display, @NativeType("GLXDrawable") long draw, @NativeType("unsigned long") long event_mask) {
/* 371 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXSelectEvent;
/* 372 */     if (Checks.CHECKS) {
/* 373 */       Checks.check(__functionAddress);
/* 374 */       Checks.check(display);
/* 375 */       Checks.check(draw);
/*     */     } 
/* 377 */     JNI.callPPNV(display, draw, event_mask, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglXGetSelectedEvent(long display, long draw, long event_mask) {
/* 384 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetSelectedEvent;
/* 385 */     if (Checks.CHECKS) {
/* 386 */       Checks.check(__functionAddress);
/* 387 */       Checks.check(display);
/* 388 */       Checks.check(draw);
/*     */     } 
/* 390 */     JNI.callPPPV(display, draw, event_mask, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glXGetSelectedEvent(@NativeType("Display *") long display, @NativeType("GLXDrawable") long draw, @NativeType("unsigned long *") CLongBuffer event_mask) {
/* 395 */     if (Checks.CHECKS) {
/* 396 */       Checks.check((CustomBuffer)event_mask, 1);
/*     */     }
/* 398 */     nglXGetSelectedEvent(display, draw, MemoryUtil.memAddress((CustomBuffer)event_mask));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXFBConfig *")
/*     */   public static PointerBuffer glXChooseFBConfig(@NativeType("Display *") long display, int screen, @NativeType("int const *") int[] attrib_list) {
/* 404 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXChooseFBConfig;
/* 405 */     if (Checks.CHECKS) {
/* 406 */       Checks.check(__functionAddress);
/* 407 */       Checks.check(display);
/* 408 */       Checks.checkNTSafe(attrib_list);
/*     */     } 
/* 410 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/* 411 */     IntBuffer nelements = stack.callocInt(1);
/*     */     try {
/* 413 */       long __result = JNI.callPPPP(display, screen, attrib_list, MemoryUtil.memAddress(nelements), __functionAddress);
/* 414 */       return MemoryUtil.memPointerBufferSafe(__result, nelements.get(0));
/*     */     } finally {
/* 416 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static int glXGetFBConfigAttrib(@NativeType("Display *") long display, @NativeType("GLXFBConfig") long config, int attribute, @NativeType("int *") int[] value) {
/* 422 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetFBConfigAttrib;
/* 423 */     if (Checks.CHECKS) {
/* 424 */       Checks.check(__functionAddress);
/* 425 */       Checks.check(display);
/* 426 */       Checks.check(config);
/* 427 */       Checks.check(value, 1);
/*     */     } 
/* 429 */     return JNI.callPPPI(display, config, attribute, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXWindow")
/*     */   public static long glXCreateWindow(@NativeType("Display *") long display, @NativeType("GLXFBConfig") long config, @NativeType("Window") long win, @NativeType("int const *") int[] attrib_list) {
/* 435 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXCreateWindow;
/* 436 */     if (Checks.CHECKS) {
/* 437 */       Checks.check(__functionAddress);
/* 438 */       Checks.check(display);
/* 439 */       Checks.check(config);
/* 440 */       Checks.checkNTSafe(attrib_list);
/*     */     } 
/* 442 */     return JNI.callPPNPP(display, config, win, attrib_list, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXPixmap")
/*     */   public static long glXCreatePixmap(@NativeType("Display *") long display, @NativeType("GLXFBConfig") long config, @NativeType("Pixmap") long pixmap, @NativeType("int const *") int[] attrib_list) {
/* 448 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXCreatePixmap;
/* 449 */     if (Checks.CHECKS) {
/* 450 */       Checks.check(__functionAddress);
/* 451 */       Checks.check(display);
/* 452 */       Checks.check(config);
/* 453 */       Checks.checkNTSafe(attrib_list);
/*     */     } 
/* 455 */     return JNI.callPPNPP(display, config, pixmap, attrib_list, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXPbuffer")
/*     */   public static long glXCreatePbuffer(@NativeType("Display *") long display, @NativeType("GLXFBConfig") long config, @NativeType("int const *") int[] attrib_list) {
/* 461 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXCreatePbuffer;
/* 462 */     if (Checks.CHECKS) {
/* 463 */       Checks.check(__functionAddress);
/* 464 */       Checks.check(display);
/* 465 */       Checks.check(config);
/* 466 */       Checks.checkNTSafe(attrib_list);
/*     */     } 
/* 468 */     return JNI.callPPPP(display, config, attrib_list, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glXQueryDrawable(@NativeType("Display *") long display, @NativeType("GLXDrawable") long draw, int attribute, @NativeType("unsigned int *") int[] value) {
/* 473 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXQueryDrawable;
/* 474 */     if (Checks.CHECKS) {
/* 475 */       Checks.check(__functionAddress);
/* 476 */       Checks.check(display);
/* 477 */       Checks.check(draw);
/* 478 */       Checks.check(value, 1);
/*     */     } 
/* 480 */     JNI.callPPPV(display, draw, attribute, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int glXQueryContext(@NativeType("Display *") long display, @NativeType("GLXContext") long ctx, int attribute, @NativeType("int *") int[] value) {
/* 485 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXQueryContext;
/* 486 */     if (Checks.CHECKS) {
/* 487 */       Checks.check(__functionAddress);
/* 488 */       Checks.check(display);
/* 489 */       Checks.check(ctx);
/* 490 */       Checks.check(value, 1);
/*     */     } 
/* 492 */     return JNI.callPPPI(display, ctx, attribute, value, __functionAddress);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLX13.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */