/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
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
/*     */ public class GLXAMDGPUAssociation
/*     */ {
/*     */   public static final int GLX_GPU_VENDOR_AMD = 7936;
/*     */   public static final int GLX_GPU_RENDERER_STRING_AMD = 7937;
/*     */   public static final int GLX_GPU_OPENGL_VERSION_STRING_AMD = 7938;
/*     */   public static final int GLX_GPU_FASTEST_TARGET_GPUS_AMD = 8610;
/*     */   public static final int GLX_GPU_RAM_AMD = 8611;
/*     */   public static final int GLX_GPU_CLOCK_AMD = 8612;
/*     */   public static final int GLX_GPU_NUM_PIPES_AMD = 8613;
/*     */   public static final int GLX_GPU_NUM_SIMD_AMD = 8614;
/*     */   public static final int GLX_GPU_NUM_RB_AMD = 8615;
/*     */   public static final int GLX_GPU_NUM_SPI_AMD = 8616;
/*     */   
/*     */   protected GLXAMDGPUAssociation() {
/*  33 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glXBlitContextFramebufferAMD(@NativeType("GLXContext") long dstCtx, @NativeType("GLint") int srcX0, @NativeType("GLint") int srcY0, @NativeType("GLint") int srcX1, @NativeType("GLint") int srcY1, @NativeType("GLint") int dstX0, @NativeType("GLint") int dstY0, @NativeType("GLint") int dstX1, @NativeType("GLint") int dstY1, @NativeType("GLbitfield") int mask, @NativeType("GLenum") int filter) {
/*  40 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXBlitContextFramebufferAMD;
/*  41 */     if (Checks.CHECKS) {
/*  42 */       Checks.check(__functionAddress);
/*  43 */       Checks.check(dstCtx);
/*     */     } 
/*  45 */     JNI.callPV(dstCtx, srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXContext")
/*     */   public static long glXCreateAssociatedContextAMD(@NativeType("unsigned int") int id, @NativeType("GLXContext") long share_list) {
/*  53 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXCreateAssociatedContextAMD;
/*  54 */     if (Checks.CHECKS) {
/*  55 */       Checks.check(__functionAddress);
/*     */     }
/*  57 */     return JNI.callPP(id, share_list, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nglXCreateAssociatedContextAttribsAMD(int id, long share_list, long attribList) {
/*  64 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXCreateAssociatedContextAttribsAMD;
/*  65 */     if (Checks.CHECKS) {
/*  66 */       Checks.check(__functionAddress);
/*     */     }
/*  68 */     return JNI.callPPP(id, share_list, attribList, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXContext")
/*     */   public static long glXCreateAssociatedContextAttribsAMD(@NativeType("unsigned int") int id, @NativeType("GLXContext") long share_list, @NativeType("int const *") IntBuffer attribList) {
/*  74 */     if (Checks.CHECKS) {
/*  75 */       Checks.checkNT(attribList);
/*     */     }
/*  77 */     return nglXCreateAssociatedContextAttribsAMD(id, share_list, MemoryUtil.memAddress(attribList));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXDeleteAssociatedContextAMD(@NativeType("GLXContext") long ctx) {
/*  85 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXDeleteAssociatedContextAMD;
/*  86 */     if (Checks.CHECKS) {
/*  87 */       Checks.check(__functionAddress);
/*  88 */       Checks.check(ctx);
/*     */     } 
/*  90 */     return (JNI.callPI(ctx, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("unsigned int")
/*     */   public static int glXGetContextGPUIDAMD(@NativeType("GLXContext") long ctx) {
/*  98 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetContextGPUIDAMD;
/*  99 */     if (Checks.CHECKS) {
/* 100 */       Checks.check(__functionAddress);
/* 101 */       Checks.check(ctx);
/*     */     } 
/* 103 */     return JNI.callPI(ctx, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXContext")
/*     */   public static long glXGetCurrentAssociatedContextAMD() {
/* 111 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetCurrentAssociatedContextAMD;
/* 112 */     if (Checks.CHECKS) {
/* 113 */       Checks.check(__functionAddress);
/*     */     }
/* 115 */     return JNI.callP(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXGetGPUIDsAMD(int maxCount, long ids) {
/* 122 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetGPUIDsAMD;
/* 123 */     if (Checks.CHECKS) {
/* 124 */       Checks.check(__functionAddress);
/*     */     }
/* 126 */     return JNI.callPI(maxCount, ids, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("unsigned int")
/*     */   public static int glXGetGPUIDsAMD(@NativeType("unsigned int *") IntBuffer ids) {
/* 132 */     return nglXGetGPUIDsAMD(Checks.remainingSafe(ids), MemoryUtil.memAddressSafe(ids));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXGetGPUInfoAMD(int id, int property, int dataType, int size, long data) {
/* 139 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetGPUInfoAMD;
/* 140 */     if (Checks.CHECKS) {
/* 141 */       Checks.check(__functionAddress);
/*     */     }
/* 143 */     return JNI.callPI(id, property, dataType, size, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int glXGetGPUInfoAMD(@NativeType("unsigned int") int id, int property, @NativeType("GLenum") int dataType, @NativeType("void *") ByteBuffer data) {
/* 148 */     return nglXGetGPUInfoAMD(id, property, dataType, data.remaining(), MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXMakeAssociatedContextCurrentAMD(@NativeType("GLXContext") long ctx) {
/* 156 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXMakeAssociatedContextCurrentAMD;
/* 157 */     if (Checks.CHECKS) {
/* 158 */       Checks.check(__functionAddress);
/* 159 */       Checks.check(ctx);
/*     */     } 
/* 161 */     return (JNI.callPI(ctx, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLXContext")
/*     */   public static long glXCreateAssociatedContextAttribsAMD(@NativeType("unsigned int") int id, @NativeType("GLXContext") long share_list, @NativeType("int const *") int[] attribList) {
/* 167 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXCreateAssociatedContextAttribsAMD;
/* 168 */     if (Checks.CHECKS) {
/* 169 */       Checks.check(__functionAddress);
/* 170 */       Checks.checkNT(attribList);
/*     */     } 
/* 172 */     return JNI.callPPP(id, share_list, attribList, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("unsigned int")
/*     */   public static int glXGetGPUIDsAMD(@NativeType("unsigned int *") int[] ids) {
/* 178 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXGetGPUIDsAMD;
/* 179 */     if (Checks.CHECKS) {
/* 180 */       Checks.check(__functionAddress);
/*     */     }
/* 182 */     return JNI.callPI(Checks.lengthSafe(ids), ids, __functionAddress);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLXAMDGPUAssociation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */