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
/*     */ public class GLXNVSwapGroup
/*     */ {
/*     */   protected GLXNVSwapGroup() {
/*  19 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXJoinSwapGroupNV(@NativeType("Display *") long display, @NativeType("GLXDrawable") long drawable, @NativeType("GLuint") int group) {
/*  27 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXJoinSwapGroupNV;
/*  28 */     if (Checks.CHECKS) {
/*  29 */       Checks.check(__functionAddress);
/*  30 */       Checks.check(display);
/*  31 */       Checks.check(drawable);
/*     */     } 
/*  33 */     return (JNI.callPPI(display, drawable, group, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXBindSwapBarrierNV(@NativeType("Display *") long display, @NativeType("GLuint") int group, @NativeType("GLuint") int barrier) {
/*  41 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXBindSwapBarrierNV;
/*  42 */     if (Checks.CHECKS) {
/*  43 */       Checks.check(__functionAddress);
/*  44 */       Checks.check(display);
/*     */     } 
/*  46 */     return (JNI.callPI(display, group, barrier, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXQuerySwapGroupNV(long display, long drawable, long group, long barrier) {
/*  53 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXQuerySwapGroupNV;
/*  54 */     if (Checks.CHECKS) {
/*  55 */       Checks.check(__functionAddress);
/*  56 */       Checks.check(display);
/*  57 */       Checks.check(drawable);
/*     */     } 
/*  59 */     return JNI.callPPPPI(display, drawable, group, barrier, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQuerySwapGroupNV(@NativeType("Display *") long display, @NativeType("GLXDrawable") long drawable, @NativeType("GLuint *") IntBuffer group, @NativeType("GLuint *") IntBuffer barrier) {
/*  65 */     if (Checks.CHECKS) {
/*  66 */       Checks.check(group, 1);
/*  67 */       Checks.check(barrier, 1);
/*     */     } 
/*  69 */     return (nglXQuerySwapGroupNV(display, drawable, MemoryUtil.memAddress(group), MemoryUtil.memAddress(barrier)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXQueryMaxSwapGroupsNV(long display, int screen, long maxGroups, long maxBarriers) {
/*  76 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXQueryMaxSwapGroupsNV;
/*  77 */     if (Checks.CHECKS) {
/*  78 */       Checks.check(__functionAddress);
/*  79 */       Checks.check(display);
/*     */     } 
/*  81 */     return JNI.callPPPI(display, screen, maxGroups, maxBarriers, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQueryMaxSwapGroupsNV(@NativeType("Display *") long display, int screen, @NativeType("GLuint *") IntBuffer maxGroups, @NativeType("GLuint *") IntBuffer maxBarriers) {
/*  87 */     if (Checks.CHECKS) {
/*  88 */       Checks.check(maxGroups, 1);
/*  89 */       Checks.check(maxBarriers, 1);
/*     */     } 
/*  91 */     return (nglXQueryMaxSwapGroupsNV(display, screen, MemoryUtil.memAddress(maxGroups), MemoryUtil.memAddress(maxBarriers)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXQueryFrameCountNV(long display, int screen, long count) {
/*  98 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXQueryFrameCountNV;
/*  99 */     if (Checks.CHECKS) {
/* 100 */       Checks.check(__functionAddress);
/* 101 */       Checks.check(display);
/*     */     } 
/* 103 */     return JNI.callPPI(display, screen, count, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQueryFrameCountNV(@NativeType("Display *") long display, int screen, @NativeType("GLuint *") IntBuffer count) {
/* 109 */     if (Checks.CHECKS) {
/* 110 */       Checks.check(count, 1);
/*     */     }
/* 112 */     return (nglXQueryFrameCountNV(display, screen, MemoryUtil.memAddress(count)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXResetFrameCountNV(@NativeType("Display *") long display, int screen) {
/* 120 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXResetFrameCountNV;
/* 121 */     if (Checks.CHECKS) {
/* 122 */       Checks.check(__functionAddress);
/* 123 */       Checks.check(display);
/*     */     } 
/* 125 */     return (JNI.callPI(display, screen, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQuerySwapGroupNV(@NativeType("Display *") long display, @NativeType("GLXDrawable") long drawable, @NativeType("GLuint *") int[] group, @NativeType("GLuint *") int[] barrier) {
/* 131 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXQuerySwapGroupNV;
/* 132 */     if (Checks.CHECKS) {
/* 133 */       Checks.check(__functionAddress);
/* 134 */       Checks.check(display);
/* 135 */       Checks.check(drawable);
/* 136 */       Checks.check(group, 1);
/* 137 */       Checks.check(barrier, 1);
/*     */     } 
/* 139 */     return (JNI.callPPPPI(display, drawable, group, barrier, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQueryMaxSwapGroupsNV(@NativeType("Display *") long display, int screen, @NativeType("GLuint *") int[] maxGroups, @NativeType("GLuint *") int[] maxBarriers) {
/* 145 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXQueryMaxSwapGroupsNV;
/* 146 */     if (Checks.CHECKS) {
/* 147 */       Checks.check(__functionAddress);
/* 148 */       Checks.check(display);
/* 149 */       Checks.check(maxGroups, 1);
/* 150 */       Checks.check(maxBarriers, 1);
/*     */     } 
/* 152 */     return (JNI.callPPPI(display, screen, maxGroups, maxBarriers, __functionAddress) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQueryFrameCountNV(@NativeType("Display *") long display, int screen, @NativeType("GLuint *") int[] count) {
/* 158 */     long __functionAddress = (GL.getCapabilitiesGLXClient()).glXQueryFrameCountNV;
/* 159 */     if (Checks.CHECKS) {
/* 160 */       Checks.check(__functionAddress);
/* 161 */       Checks.check(display);
/* 162 */       Checks.check(count, 1);
/*     */     } 
/* 164 */     return (JNI.callPPI(display, screen, count, __functionAddress) != 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLXNVSwapGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */