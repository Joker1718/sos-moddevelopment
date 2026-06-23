/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.CLongBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
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
/*     */ public class GLXSGIXPbuffer
/*     */ {
/*     */   public static final int GLX_MAX_PBUFFER_WIDTH_SGIX = 32790;
/*     */   public static final int GLX_MAX_PBUFFER_HEIGHT_SGIX = 32791;
/*     */   public static final int GLX_MAX_PBUFFER_PIXELS_SGIX = 32792;
/*     */   public static final int GLX_OPTIMAL_PBUFFER_WIDTH_SGIX = 32793;
/*     */   public static final int GLX_OPTIMAL_PBUFFER_HEIGHT_SGIX = 32794;
/*     */   public static final int GLX_PBUFFER_BIT_SGIX = 4;
/*     */   public static final int GLX_PRESERVED_CONTENTS_SGIX = 32795;
/*     */   public static final int GLX_LARGEST_PBUFFER_SGIX = 32796;
/*     */   public static final int GLX_WIDTH_SGIX = 32797;
/*     */   public static final int GLX_HEIGHT_SGIX = 32798;
/*     */   public static final int GLX_EVENT_MASK_SGIX = 32799;
/*     */   public static final int GLX_BUFFER_CLOBBER_MASK_SGIX = 134217728;
/*     */   public static final int GLX_DAMAGED_SGIX = 32800;
/*     */   public static final int GLX_SAVED_SGIX = 32801;
/*     */   public static final int GLX_WINDOW_SGIX = 32802;
/*     */   public static final int GLX_PBUFFER_SGIX = 32803;
/*     */   public static final int GLX_FRONT_LEFT_BUFFER_BIT_SGIX = 1;
/*     */   public static final int GLX_FRONT_RIGHT_BUFFER_BIT_SGIX = 2;
/*     */   public static final int GLX_BACK_LEFT_BUFFER_BIT_SGIX = 4;
/*     */   public static final int GLX_BACK_RIGHT_BUFFER_BIT_SGIX = 8;
/*     */   public static final int GLX_AUX_BUFFERS_BIT_SGIX = 16;
/*     */   public static final int GLX_DEPTH_BUFFER_BIT_SGIX = 32;
/*     */   public static final int GLX_STENCIL_BUFFER_BIT_SGIX = 64;
/*     */   public static final int GLX_ACCUM_BUFFER_BIT_SGIX = 128;
/*     */   public static final int GLX_SAMPLE_BUFFERS_BIT_SGIX = 256;
/*     */   
/*     */   protected GLXSGIXPbuffer() {
/*  62 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXCreateGLXPbufferSGIX(long display, long config, int width, int height, long attrib_list) {
/*  69 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXCreateGLXPbufferSGIX;
/*  70 */     if (Checks.CHECKS) {
/*  71 */       Checks.check(__functionAddress);
/*  72 */       Checks.check(display);
/*  73 */       Checks.check(config);
/*     */     } 
/*  75 */     return JNI.callPPPP(display, config, width, height, attrib_list, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXPbuffer")
/*     */   public static long glXCreateGLXPbufferSGIX(@NativeType("Display *") long display, @NativeType("GLXFBConfig") long config, @NativeType("unsigned int") int width, @NativeType("unsigned int") int height, @NativeType("int *") IntBuffer attrib_list) {
/*  81 */     if (Checks.CHECKS) {
/*  82 */       Checks.checkNTSafe(attrib_list);
/*     */     }
/*  84 */     return nglXCreateGLXPbufferSGIX(display, config, width, height, MemoryUtil.memAddressSafe(attrib_list));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glXDestroyGLXPbufferSGIX(@NativeType("Display *") long display, @NativeType("GLXPbuffer") long pbuf) {
/*  91 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXDestroyGLXPbufferSGIX;
/*  92 */     if (Checks.CHECKS) {
/*  93 */       Checks.check(__functionAddress);
/*  94 */       Checks.check(display);
/*  95 */       Checks.check(pbuf);
/*     */     } 
/*  97 */     JNI.callPPV(display, pbuf, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglXQueryGLXPbufferSGIX(long display, long pbuf, int attribute, long value) {
/* 104 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXQueryGLXPbufferSGIX;
/* 105 */     if (Checks.CHECKS) {
/* 106 */       Checks.check(__functionAddress);
/* 107 */       Checks.check(display);
/* 108 */       Checks.check(pbuf);
/*     */     } 
/* 110 */     JNI.callPPPV(display, pbuf, attribute, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glXQueryGLXPbufferSGIX(@NativeType("Display *") long display, @NativeType("GLXPbuffer") long pbuf, int attribute, @NativeType("unsigned int *") IntBuffer value) {
/* 115 */     if (Checks.CHECKS) {
/* 116 */       Checks.check(value, 1);
/*     */     }
/* 118 */     nglXQueryGLXPbufferSGIX(display, pbuf, attribute, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glXSelectEventSGIX(@NativeType("Display *") long display, @NativeType("GLXDrawable") long drawable, @NativeType("unsigned long") long mask) {
/* 125 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXSelectEventSGIX;
/* 126 */     if (Checks.CHECKS) {
/* 127 */       Checks.check(__functionAddress);
/* 128 */       Checks.check(display);
/* 129 */       Checks.check(drawable);
/*     */     } 
/* 131 */     JNI.callPPNV(display, drawable, mask, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglXGetSelectedEventSGIX(long display, long drawable, long mask) {
/* 138 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetSelectedEventSGIX;
/* 139 */     if (Checks.CHECKS) {
/* 140 */       Checks.check(__functionAddress);
/* 141 */       Checks.check(display);
/* 142 */       Checks.check(drawable);
/*     */     } 
/* 144 */     JNI.callPPPV(display, drawable, mask, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glXGetSelectedEventSGIX(@NativeType("Display *") long display, @NativeType("GLXDrawable") long drawable, @NativeType("unsigned long *") CLongBuffer mask) {
/* 149 */     if (Checks.CHECKS) {
/* 150 */       Checks.check((CustomBuffer)mask, 1);
/*     */     }
/* 152 */     nglXGetSelectedEventSGIX(display, drawable, MemoryUtil.memAddress((CustomBuffer)mask));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXPbuffer")
/*     */   public static long glXCreateGLXPbufferSGIX(@NativeType("Display *") long display, @NativeType("GLXFBConfig") long config, @NativeType("unsigned int") int width, @NativeType("unsigned int") int height, @NativeType("int *") int[] attrib_list) {
/* 158 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXCreateGLXPbufferSGIX;
/* 159 */     if (Checks.CHECKS) {
/* 160 */       Checks.check(__functionAddress);
/* 161 */       Checks.check(display);
/* 162 */       Checks.check(config);
/* 163 */       Checks.checkNTSafe(attrib_list);
/*     */     } 
/* 165 */     return JNI.callPPPP(display, config, width, height, attrib_list, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glXQueryGLXPbufferSGIX(@NativeType("Display *") long display, @NativeType("GLXPbuffer") long pbuf, int attribute, @NativeType("unsigned int *") int[] value) {
/* 170 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXQueryGLXPbufferSGIX;
/* 171 */     if (Checks.CHECKS) {
/* 172 */       Checks.check(__functionAddress);
/* 173 */       Checks.check(display);
/* 174 */       Checks.check(pbuf);
/* 175 */       Checks.check(value, 1);
/*     */     } 
/* 177 */     JNI.callPPPV(display, pbuf, attribute, value, __functionAddress);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLXSGIXPbuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */