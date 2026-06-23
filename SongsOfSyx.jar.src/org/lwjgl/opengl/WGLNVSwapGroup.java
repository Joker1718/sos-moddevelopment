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
/*     */ public class WGLNVSwapGroup
/*     */ {
/*     */   protected WGLNVSwapGroup() {
/*  19 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglJoinSwapGroupNV(@NativeType("HDC") long hDC, @NativeType("GLuint") int group) {
/*  27 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglJoinSwapGroupNV;
/*  28 */     if (Checks.CHECKS) {
/*  29 */       Checks.check(__functionAddress);
/*  30 */       Checks.check(hDC);
/*     */     } 
/*  32 */     return (JNI.callPI(hDC, group, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglBindSwapBarrierNV(@NativeType("GLuint") int group, @NativeType("GLuint") int barrier) {
/*  40 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglBindSwapBarrierNV;
/*  41 */     if (Checks.CHECKS) {
/*  42 */       Checks.check(__functionAddress);
/*     */     }
/*  44 */     return (JNI.callI(group, barrier, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglQuerySwapGroupNV(long hDC, long group, long barrier) {
/*  51 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglQuerySwapGroupNV;
/*  52 */     if (Checks.CHECKS) {
/*  53 */       Checks.check(__functionAddress);
/*  54 */       Checks.check(hDC);
/*     */     } 
/*  56 */     return JNI.callPPPI(hDC, group, barrier, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglQuerySwapGroupNV(@NativeType("HDC") long hDC, @NativeType("GLuint *") IntBuffer group, @NativeType("GLuint *") IntBuffer barrier) {
/*  62 */     if (Checks.CHECKS) {
/*  63 */       Checks.check(group, 1);
/*  64 */       Checks.check(barrier, 1);
/*     */     } 
/*  66 */     return (nwglQuerySwapGroupNV(hDC, MemoryUtil.memAddress(group), MemoryUtil.memAddress(barrier)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglQueryMaxSwapGroupsNV(long hDC, long maxGroups, long maxBarriers) {
/*  73 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglQueryMaxSwapGroupsNV;
/*  74 */     if (Checks.CHECKS) {
/*  75 */       Checks.check(__functionAddress);
/*  76 */       Checks.check(hDC);
/*     */     } 
/*  78 */     return JNI.callPPPI(hDC, maxGroups, maxBarriers, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglQueryMaxSwapGroupsNV(@NativeType("HDC") long hDC, @NativeType("GLuint *") IntBuffer maxGroups, @NativeType("GLuint *") IntBuffer maxBarriers) {
/*  84 */     if (Checks.CHECKS) {
/*  85 */       Checks.check(maxGroups, 1);
/*  86 */       Checks.check(maxBarriers, 1);
/*     */     } 
/*  88 */     return (nwglQueryMaxSwapGroupsNV(hDC, MemoryUtil.memAddress(maxGroups), MemoryUtil.memAddress(maxBarriers)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglQueryFrameCountNV(long hDC, long count) {
/*  95 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglQueryFrameCountNV;
/*  96 */     if (Checks.CHECKS) {
/*  97 */       Checks.check(__functionAddress);
/*  98 */       Checks.check(hDC);
/*     */     } 
/* 100 */     return JNI.callPPI(hDC, count, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglQueryFrameCountNV(@NativeType("HDC") long hDC, @NativeType("GLuint *") IntBuffer count) {
/* 106 */     if (Checks.CHECKS) {
/* 107 */       Checks.check(count, 1);
/*     */     }
/* 109 */     return (nwglQueryFrameCountNV(hDC, MemoryUtil.memAddress(count)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglResetFrameCountNV(@NativeType("HDC") long hDC) {
/* 117 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglResetFrameCountNV;
/* 118 */     if (Checks.CHECKS) {
/* 119 */       Checks.check(__functionAddress);
/* 120 */       Checks.check(hDC);
/*     */     } 
/* 122 */     return (JNI.callPI(hDC, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglQuerySwapGroupNV(@NativeType("HDC") long hDC, @NativeType("GLuint *") int[] group, @NativeType("GLuint *") int[] barrier) {
/* 128 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglQuerySwapGroupNV;
/* 129 */     if (Checks.CHECKS) {
/* 130 */       Checks.check(__functionAddress);
/* 131 */       Checks.check(hDC);
/* 132 */       Checks.check(group, 1);
/* 133 */       Checks.check(barrier, 1);
/*     */     } 
/* 135 */     return (JNI.callPPPI(hDC, group, barrier, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglQueryMaxSwapGroupsNV(@NativeType("HDC") long hDC, @NativeType("GLuint *") int[] maxGroups, @NativeType("GLuint *") int[] maxBarriers) {
/* 141 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglQueryMaxSwapGroupsNV;
/* 142 */     if (Checks.CHECKS) {
/* 143 */       Checks.check(__functionAddress);
/* 144 */       Checks.check(hDC);
/* 145 */       Checks.check(maxGroups, 1);
/* 146 */       Checks.check(maxBarriers, 1);
/*     */     } 
/* 148 */     return (JNI.callPPPI(hDC, maxGroups, maxBarriers, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglQueryFrameCountNV(@NativeType("HDC") long hDC, @NativeType("GLuint *") int[] count) {
/* 154 */     long __functionAddress = (GL.getCapabilitiesWGL()).wglQueryFrameCountNV;
/* 155 */     if (Checks.CHECKS) {
/* 156 */       Checks.check(__functionAddress);
/* 157 */       Checks.check(hDC);
/* 158 */       Checks.check(count, 1);
/*     */     } 
/* 160 */     return (JNI.callPPI(hDC, count, __functionAddress) != 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\WGLNVSwapGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */