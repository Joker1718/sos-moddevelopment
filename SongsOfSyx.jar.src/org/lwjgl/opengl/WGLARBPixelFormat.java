/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
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
/*     */ public class WGLARBPixelFormat
/*     */ {
/*     */   public static final int WGL_NUMBER_PIXEL_FORMATS_ARB = 8192;
/*     */   public static final int WGL_DRAW_TO_WINDOW_ARB = 8193;
/*     */   public static final int WGL_DRAW_TO_BITMAP_ARB = 8194;
/*     */   public static final int WGL_ACCELERATION_ARB = 8195;
/*     */   public static final int WGL_NEED_PALETTE_ARB = 8196;
/*     */   public static final int WGL_NEED_SYSTEM_PALETTE_ARB = 8197;
/*     */   public static final int WGL_SWAP_LAYER_BUFFERS_ARB = 8198;
/*     */   public static final int WGL_SWAP_METHOD_ARB = 8199;
/*     */   public static final int WGL_NUMBER_OVERLAYS_ARB = 8200;
/*     */   public static final int WGL_NUMBER_UNDERLAYS_ARB = 8201;
/*     */   public static final int WGL_TRANSPARENT_ARB = 8202;
/*     */   public static final int WGL_TRANSPARENT_RED_VALUE_ARB = 8247;
/*     */   public static final int WGL_TRANSPARENT_GREEN_VALUE_ARB = 8248;
/*     */   public static final int WGL_TRANSPARENT_BLUE_VALUE_ARB = 8249;
/*     */   public static final int WGL_TRANSPARENT_ALPHA_VALUE_ARB = 8250;
/*     */   public static final int WGL_TRANSPARENT_INDEX_VALUE_ARB = 8251;
/*     */   public static final int WGL_SHARE_DEPTH_ARB = 8204;
/*     */   public static final int WGL_SHARE_STENCIL_ARB = 8205;
/*     */   public static final int WGL_SHARE_ACCUM_ARB = 8206;
/*     */   public static final int WGL_SUPPORT_GDI_ARB = 8207;
/*     */   public static final int WGL_SUPPORT_OPENGL_ARB = 8208;
/*     */   public static final int WGL_DOUBLE_BUFFER_ARB = 8209;
/*     */   public static final int WGL_STEREO_ARB = 8210;
/*     */   public static final int WGL_PIXEL_TYPE_ARB = 8211;
/*     */   public static final int WGL_COLOR_BITS_ARB = 8212;
/*     */   public static final int WGL_RED_BITS_ARB = 8213;
/*     */   public static final int WGL_RED_SHIFT_ARB = 8214;
/*     */   public static final int WGL_GREEN_BITS_ARB = 8215;
/*     */   public static final int WGL_GREEN_SHIFT_ARB = 8216;
/*     */   public static final int WGL_BLUE_BITS_ARB = 8217;
/*     */   public static final int WGL_BLUE_SHIFT_ARB = 8218;
/*     */   public static final int WGL_ALPHA_BITS_ARB = 8219;
/*     */   public static final int WGL_ALPHA_SHIFT_ARB = 8220;
/*     */   public static final int WGL_ACCUM_BITS_ARB = 8221;
/*     */   public static final int WGL_ACCUM_RED_BITS_ARB = 8222;
/*     */   public static final int WGL_ACCUM_GREEN_BITS_ARB = 8223;
/*     */   public static final int WGL_ACCUM_BLUE_BITS_ARB = 8224;
/*     */   public static final int WGL_ACCUM_ALPHA_BITS_ARB = 8225;
/*     */   public static final int WGL_DEPTH_BITS_ARB = 8226;
/*     */   public static final int WGL_STENCIL_BITS_ARB = 8227;
/*     */   public static final int WGL_AUX_BUFFERS_ARB = 8228;
/*     */   public static final int WGL_NO_ACCELERATION_ARB = 8229;
/*     */   public static final int WGL_GENERIC_ACCELERATION_ARB = 8230;
/*     */   public static final int WGL_FULL_ACCELERATION_ARB = 8231;
/*     */   public static final int WGL_SWAP_EXCHANGE_ARB = 8232;
/*     */   public static final int WGL_SWAP_COPY_ARB = 8233;
/*     */   public static final int WGL_SWAP_UNDEFINED_ARB = 8234;
/*     */   public static final int WGL_TYPE_RGBA_ARB = 8235;
/*     */   public static final int WGL_TYPE_COLORINDEX_ARB = 8236;
/*     */   
/*     */   protected WGLARBPixelFormat() {
/*  75 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglGetPixelFormatAttribivARB(long hdc, int pixelFormat, int layerPlane, int n, long attributes, long values) {
/*  82 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglGetPixelFormatAttribivARB;
/*  83 */     if (Checks.CHECKS) {
/*  84 */       Checks.check(__functionAddress);
/*  85 */       Checks.check(hdc);
/*     */     } 
/*  87 */     return JNI.callPPPI(hdc, pixelFormat, layerPlane, n, attributes, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglGetPixelFormatAttribivARB(@NativeType("HDC") long hdc, int pixelFormat, int layerPlane, @NativeType("int const *") IntBuffer attributes, @NativeType("int *") IntBuffer values) {
/*  93 */     if (Checks.CHECKS) {
/*  94 */       Checks.check(values, attributes.remaining());
/*     */     }
/*  96 */     return (nwglGetPixelFormatAttribivARB(hdc, pixelFormat, layerPlane, attributes.remaining(), MemoryUtil.memAddress(attributes), MemoryUtil.memAddress(values)) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglGetPixelFormatAttribiARB(@NativeType("HDC") long hdc, int pixelFormat, int layerPlane, @NativeType("int const *") int attribute, @NativeType("int *") IntBuffer values) {
/* 102 */     if (Checks.CHECKS) {
/* 103 */       Checks.check(values, 1);
/*     */     }
/* 105 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 107 */       IntBuffer attributes = stack.ints(attribute);
/* 108 */       return (nwglGetPixelFormatAttribivARB(hdc, pixelFormat, layerPlane, 1, MemoryUtil.memAddress(attributes), MemoryUtil.memAddress(values)) != 0);
/*     */     } finally {
/* 110 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglGetPixelFormatAttribfvARB(long hdc, int pixelFormat, int layerPlane, int n, long attributes, long values) {
/* 118 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglGetPixelFormatAttribfvARB;
/* 119 */     if (Checks.CHECKS) {
/* 120 */       Checks.check(__functionAddress);
/* 121 */       Checks.check(hdc);
/*     */     } 
/* 123 */     return JNI.callPPPI(hdc, pixelFormat, layerPlane, n, attributes, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglGetPixelFormatAttribfvARB(@NativeType("HDC") long hdc, int pixelFormat, int layerPlane, @NativeType("int const *") IntBuffer attributes, @NativeType("FLOAT *") FloatBuffer values) {
/* 129 */     if (Checks.CHECKS) {
/* 130 */       Checks.check(values, attributes.remaining());
/*     */     }
/* 132 */     return (nwglGetPixelFormatAttribfvARB(hdc, pixelFormat, layerPlane, attributes.remaining(), MemoryUtil.memAddress(attributes), MemoryUtil.memAddress(values)) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglGetPixelFormatAttribfARB(@NativeType("HDC") long hdc, int pixelFormat, int layerPlane, @NativeType("int const *") int attribute, @NativeType("FLOAT *") FloatBuffer values) {
/* 138 */     if (Checks.CHECKS) {
/* 139 */       Checks.check(values, 1);
/*     */     }
/* 141 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 143 */       IntBuffer attributes = stack.ints(attribute);
/* 144 */       return (nwglGetPixelFormatAttribfvARB(hdc, pixelFormat, layerPlane, 1, MemoryUtil.memAddress(attributes), MemoryUtil.memAddress(values)) != 0);
/*     */     } finally {
/* 146 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglChoosePixelFormatARB(long hdc, long attribIList, long attribFList, int maxFormats, long formats, long numFormats) {
/* 154 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglChoosePixelFormatARB;
/* 155 */     if (Checks.CHECKS) {
/* 156 */       Checks.check(__functionAddress);
/* 157 */       Checks.check(hdc);
/*     */     } 
/* 159 */     return JNI.callPPPPPI(hdc, attribIList, attribFList, maxFormats, formats, numFormats, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglChoosePixelFormatARB(@NativeType("HDC") long hdc, @NativeType("int const *") IntBuffer attribIList, @NativeType("FLOAT const *") FloatBuffer attribFList, @NativeType("int *") IntBuffer formats, @NativeType("UINT *") IntBuffer numFormats) {
/* 165 */     if (Checks.CHECKS) {
/* 166 */       Checks.checkNTSafe(attribIList);
/* 167 */       Checks.checkNTSafe(attribFList);
/* 168 */       Checks.check(numFormats, 1);
/*     */     } 
/* 170 */     return (nwglChoosePixelFormatARB(hdc, MemoryUtil.memAddressSafe(attribIList), MemoryUtil.memAddressSafe(attribFList), formats.remaining(), MemoryUtil.memAddress(formats), MemoryUtil.memAddress(numFormats)) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglGetPixelFormatAttribivARB(@NativeType("HDC") long hdc, int pixelFormat, int layerPlane, @NativeType("int const *") int[] attributes, @NativeType("int *") int[] values) {
/* 176 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglGetPixelFormatAttribivARB;
/* 177 */     if (Checks.CHECKS) {
/* 178 */       Checks.check(__functionAddress);
/* 179 */       Checks.check(hdc);
/* 180 */       Checks.check(values, attributes.length);
/*     */     } 
/* 182 */     return (JNI.callPPPI(hdc, pixelFormat, layerPlane, attributes.length, attributes, values, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglGetPixelFormatAttribfvARB(@NativeType("HDC") long hdc, int pixelFormat, int layerPlane, @NativeType("int const *") int[] attributes, @NativeType("FLOAT *") float[] values) {
/* 188 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglGetPixelFormatAttribfvARB;
/* 189 */     if (Checks.CHECKS) {
/* 190 */       Checks.check(__functionAddress);
/* 191 */       Checks.check(hdc);
/* 192 */       Checks.check(values, attributes.length);
/*     */     } 
/* 194 */     return (JNI.callPPPI(hdc, pixelFormat, layerPlane, attributes.length, attributes, values, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglChoosePixelFormatARB(@NativeType("HDC") long hdc, @NativeType("int const *") int[] attribIList, @NativeType("FLOAT const *") float[] attribFList, @NativeType("int *") int[] formats, @NativeType("UINT *") int[] numFormats) {
/* 200 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglChoosePixelFormatARB;
/* 201 */     if (Checks.CHECKS) {
/* 202 */       Checks.check(__functionAddress);
/* 203 */       Checks.check(hdc);
/* 204 */       Checks.checkNTSafe(attribIList);
/* 205 */       Checks.checkNTSafe(attribFList);
/* 206 */       Checks.check(numFormats, 1);
/*     */     } 
/* 208 */     return (JNI.callPPPPPI(hdc, attribIList, attribFList, formats.length, formats, numFormats, __functionAddress) != 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\WGLARBPixelFormat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */