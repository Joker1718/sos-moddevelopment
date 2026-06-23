/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
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
/*     */ public class WGLAMDGPUAssociation
/*     */ {
/*     */   public static final int WGL_GPU_VENDOR_AMD = 7936;
/*     */   public static final int WGL_GPU_RENDERER_STRING_AMD = 7937;
/*     */   public static final int WGL_GPU_OPENGL_VERSION_STRING_AMD = 7938;
/*     */   public static final int WGL_GPU_FASTEST_TARGET_GPUS_AMD = 8610;
/*     */   public static final int WGL_GPU_RAM_AMD = 8611;
/*     */   public static final int WGL_GPU_CLOCK_AMD = 8612;
/*     */   public static final int WGL_GPU_NUM_PIPES_AMD = 8613;
/*     */   public static final int WGL_GPU_NUM_SIMD_AMD = 8614;
/*     */   public static final int WGL_GPU_NUM_RB_AMD = 8615;
/*     */   public static final int WGL_GPU_NUM_SPI_AMD = 8616;
/*     */   
/*     */   protected WGLAMDGPUAssociation() {
/*  33 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglGetGPUIDsAMD(int maxCount, long ids) {
/*  40 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglGetGPUIDsAMD;
/*  41 */     if (Checks.CHECKS) {
/*  42 */       Checks.check(__functionAddress);
/*     */     }
/*  44 */     return JNI.callPI(maxCount, ids, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("UINT")
/*     */   public static int wglGetGPUIDsAMD(@NativeType("UINT *") IntBuffer ids) {
/*  50 */     return nwglGetGPUIDsAMD(Checks.remainingSafe(ids), MemoryUtil.memAddressSafe(ids));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglGetGPUInfoAMD(int id, int property, int dataType, int size, long data) {
/*  57 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglGetGPUInfoAMD;
/*  58 */     if (Checks.CHECKS) {
/*  59 */       Checks.check(__functionAddress);
/*     */     }
/*  61 */     return JNI.callPI(id, property, dataType, size, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int wglGetGPUInfoAMD(@NativeType("UINT") int id, int property, @NativeType("GLenum") int dataType, @NativeType("void *") ByteBuffer data) {
/*  66 */     return nwglGetGPUInfoAMD(id, property, dataType, data.remaining() >> GLChecks.typeToByteShift(dataType), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int wglGetGPUInfoAMD(@NativeType("UINT") int id, int property, @NativeType("GLenum") int dataType, @NativeType("void *") IntBuffer data) {
/*  71 */     return nwglGetGPUInfoAMD(id, property, dataType, (int)(data.remaining() << 2L >> GLChecks.typeToByteShift(dataType)), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int wglGetGPUInfoAMD(@NativeType("UINT") int id, int property, @NativeType("GLenum") int dataType, @NativeType("void *") FloatBuffer data) {
/*  76 */     return nwglGetGPUInfoAMD(id, property, dataType, (int)(data.remaining() << 2L >> GLChecks.typeToByteShift(dataType)), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("UINT")
/*     */   public static int wglGetContextGPUIDAMD(@NativeType("HGLRC") long hglrc) {
/*  84 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglGetContextGPUIDAMD;
/*  85 */     if (Checks.CHECKS) {
/*  86 */       Checks.check(__functionAddress);
/*  87 */       Checks.check(hglrc);
/*     */     } 
/*  89 */     return JNI.callPI(hglrc, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HGLRC")
/*     */   public static long wglCreateAssociatedContextAMD(@NativeType("UINT") int id) {
/*  97 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglCreateAssociatedContextAMD;
/*  98 */     if (Checks.CHECKS) {
/*  99 */       Checks.check(__functionAddress);
/*     */     }
/* 101 */     return JNI.callP(id, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nwglCreateAssociatedContextAttribsAMD(int id, long shareContext, long attribList) {
/* 108 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglCreateAssociatedContextAttribsAMD;
/* 109 */     if (Checks.CHECKS) {
/* 110 */       Checks.check(__functionAddress);
/*     */     }
/* 112 */     return JNI.callPPP(id, shareContext, attribList, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("HGLRC")
/*     */   public static long wglCreateAssociatedContextAttribsAMD(@NativeType("UINT") int id, @NativeType("HGLRC") long shareContext, @NativeType("int const *") IntBuffer attribList) {
/* 118 */     if (Checks.CHECKS) {
/* 119 */       Checks.checkNTSafe(attribList);
/*     */     }
/* 121 */     return nwglCreateAssociatedContextAttribsAMD(id, shareContext, MemoryUtil.memAddressSafe(attribList));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglDeleteAssociatedContextAMD(@NativeType("HGLRC") long hglrc) {
/* 129 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglDeleteAssociatedContextAMD;
/* 130 */     if (Checks.CHECKS) {
/* 131 */       Checks.check(__functionAddress);
/* 132 */       Checks.check(hglrc);
/*     */     } 
/* 134 */     return (JNI.callPI(hglrc, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglMakeAssociatedContextCurrentAMD(@NativeType("HGLRC") long hglrc) {
/* 142 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglMakeAssociatedContextCurrentAMD;
/* 143 */     if (Checks.CHECKS) {
/* 144 */       Checks.check(__functionAddress);
/* 145 */       Checks.check(hglrc);
/*     */     } 
/* 147 */     return (JNI.callPI(hglrc, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HGLRC")
/*     */   public static long wglGetCurrentAssociatedContextAMD() {
/* 155 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglGetCurrentAssociatedContextAMD;
/* 156 */     if (Checks.CHECKS) {
/* 157 */       Checks.check(__functionAddress);
/*     */     }
/* 159 */     return JNI.callP(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("VOID")
/*     */   public static void wglBlitContextFramebufferAMD(@NativeType("HGLRC") long dstCtx, @NativeType("GLint") int srcX0, @NativeType("GLint") int srcY0, @NativeType("GLint") int srcX1, @NativeType("GLint") int srcY1, @NativeType("GLint") int dstX0, @NativeType("GLint") int dstY0, @NativeType("GLint") int dstX1, @NativeType("GLint") int dstY1, @NativeType("GLbitfield") int mask, @NativeType("GLenum") int filter) {
/* 167 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglBlitContextFramebufferAMD;
/* 168 */     if (Checks.CHECKS) {
/* 169 */       Checks.check(__functionAddress);
/* 170 */       Checks.check(dstCtx);
/*     */     } 
/* 172 */     JNI.callPV(dstCtx, srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("UINT")
/*     */   public static int wglGetGPUIDsAMD(@NativeType("UINT *") int[] ids) {
/* 178 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglGetGPUIDsAMD;
/* 179 */     if (Checks.CHECKS) {
/* 180 */       Checks.check(__functionAddress);
/*     */     }
/* 182 */     return JNI.callPI(Checks.lengthSafe(ids), ids, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int wglGetGPUInfoAMD(@NativeType("UINT") int id, int property, @NativeType("GLenum") int dataType, @NativeType("void *") int[] data) {
/* 187 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglGetGPUInfoAMD;
/* 188 */     if (Checks.CHECKS) {
/* 189 */       Checks.check(__functionAddress);
/*     */     }
/* 191 */     return JNI.callPI(id, property, dataType, data.length, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int wglGetGPUInfoAMD(@NativeType("UINT") int id, int property, @NativeType("GLenum") int dataType, @NativeType("void *") float[] data) {
/* 196 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglGetGPUInfoAMD;
/* 197 */     if (Checks.CHECKS) {
/* 198 */       Checks.check(__functionAddress);
/*     */     }
/* 200 */     return JNI.callPI(id, property, dataType, data.length, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("HGLRC")
/*     */   public static long wglCreateAssociatedContextAttribsAMD(@NativeType("UINT") int id, @NativeType("HGLRC") long shareContext, @NativeType("int const *") int[] attribList) {
/* 206 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglCreateAssociatedContextAttribsAMD;
/* 207 */     if (Checks.CHECKS) {
/* 208 */       Checks.check(__functionAddress);
/* 209 */       Checks.checkNTSafe(attribList);
/*     */     } 
/* 211 */     return JNI.callPPP(id, shareContext, attribList, __functionAddress);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\WGLAMDGPUAssociation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */