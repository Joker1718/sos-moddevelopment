/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
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
/*     */ public class AMDPerformanceMonitor
/*     */ {
/*     */   public static final int GL_COUNTER_TYPE_AMD = 35776;
/*     */   public static final int GL_COUNTER_RANGE_AMD = 35777;
/*     */   public static final int GL_UNSIGNED_INT64_AMD = 35778;
/*     */   
/*     */   static {
/*  21 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_PERCENTAGE_AMD = 35779;
/*     */ 
/*     */   
/*     */   public static final int GL_PERFMON_RESULT_AVAILABLE_AMD = 35780;
/*     */   
/*     */   public static final int GL_PERFMON_RESULT_SIZE_AMD = 35781;
/*     */   
/*     */   public static final int GL_PERFMON_RESULT_AMD = 35782;
/*     */ 
/*     */   
/*     */   protected AMDPerformanceMonitor() {
/*  37 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorGroupsAMD(@NativeType("GLint *") IntBuffer numGroups, @NativeType("GLuint *") IntBuffer groups) {
/*  47 */     if (Checks.CHECKS) {
/*  48 */       Checks.checkSafe(numGroups, 1);
/*     */     }
/*  50 */     nglGetPerfMonitorGroupsAMD(MemoryUtil.memAddressSafe(numGroups), Checks.remainingSafe(groups), MemoryUtil.memAddressSafe(groups));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorCountersAMD(@NativeType("GLuint") int group, @NativeType("GLint *") IntBuffer numCounters, @NativeType("GLint *") IntBuffer maxActiveCounters, @NativeType("GLuint *") IntBuffer counters) {
/*  60 */     if (Checks.CHECKS) {
/*  61 */       Checks.check(numCounters, 1);
/*  62 */       Checks.check(maxActiveCounters, 1);
/*     */     } 
/*  64 */     nglGetPerfMonitorCountersAMD(group, MemoryUtil.memAddress(numCounters), MemoryUtil.memAddress(maxActiveCounters), counters.remaining(), MemoryUtil.memAddress(counters));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorGroupStringAMD(@NativeType("GLuint") int group, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer groupString) {
/*  74 */     if (Checks.CHECKS) {
/*  75 */       Checks.check(length, 1);
/*     */     }
/*  77 */     nglGetPerfMonitorGroupStringAMD(group, groupString.remaining(), MemoryUtil.memAddress(length), MemoryUtil.memAddress(groupString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorCounterStringAMD(@NativeType("GLuint") int group, @NativeType("GLuint") int counter, @NativeType("GLsizei *") IntBuffer length, @NativeType("GLchar *") ByteBuffer counterString) {
/*  87 */     if (Checks.CHECKS) {
/*  88 */       Checks.checkSafe(length, 1);
/*     */     }
/*  90 */     nglGetPerfMonitorCounterStringAMD(group, counter, Checks.remainingSafe(counterString), MemoryUtil.memAddressSafe(length), MemoryUtil.memAddressSafe(counterString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorCounterInfoAMD(@NativeType("GLuint") int group, @NativeType("GLuint") int counter, @NativeType("GLenum") int pname, @NativeType("void *") ByteBuffer data) {
/* 100 */     if (Checks.CHECKS) {
/* 101 */       Checks.check(data, 4);
/*     */     }
/* 103 */     nglGetPerfMonitorCounterInfoAMD(group, counter, pname, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorCounterInfoAMD(@NativeType("GLuint") int group, @NativeType("GLuint") int counter, @NativeType("GLenum") int pname, @NativeType("void *") IntBuffer data) {
/* 108 */     if (Checks.CHECKS) {
/* 109 */       Checks.check(data, 1);
/*     */     }
/* 111 */     nglGetPerfMonitorCounterInfoAMD(group, counter, pname, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorCounterInfoAMD(@NativeType("GLuint") int group, @NativeType("GLuint") int counter, @NativeType("GLenum") int pname, @NativeType("void *") FloatBuffer data) {
/* 116 */     if (Checks.CHECKS) {
/* 117 */       Checks.check(data, 1);
/*     */     }
/* 119 */     nglGetPerfMonitorCounterInfoAMD(group, counter, pname, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenPerfMonitorsAMD(@NativeType("GLuint *") IntBuffer monitors) {
/* 129 */     nglGenPerfMonitorsAMD(monitors.remaining(), MemoryUtil.memAddress(monitors));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenPerfMonitorsAMD() {
/* 135 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 137 */       IntBuffer monitors = stack.callocInt(1);
/* 138 */       nglGenPerfMonitorsAMD(1, MemoryUtil.memAddress(monitors));
/* 139 */       return monitors.get(0);
/*     */     } finally {
/* 141 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeletePerfMonitorsAMD(@NativeType("GLuint *") IntBuffer monitors) {
/* 152 */     nglDeletePerfMonitorsAMD(monitors.remaining(), MemoryUtil.memAddress(monitors));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeletePerfMonitorsAMD(@NativeType("GLuint *") int monitor) {
/* 157 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 159 */       IntBuffer monitors = stack.ints(monitor);
/* 160 */       nglDeletePerfMonitorsAMD(1, MemoryUtil.memAddress(monitors));
/*     */     } finally {
/* 162 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glSelectPerfMonitorCountersAMD(@NativeType("GLuint") int monitor, @NativeType("GLboolean") boolean enable, @NativeType("GLuint") int group, @NativeType("GLuint *") IntBuffer counterList) {
/* 173 */     nglSelectPerfMonitorCountersAMD(monitor, enable, group, counterList.remaining(), MemoryUtil.memAddress(counterList));
/*     */   }
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
/*     */   public static void glGetPerfMonitorCounterDataAMD(@NativeType("GLuint") int monitor, @NativeType("GLenum") int pname, @NativeType("GLuint *") IntBuffer data, @NativeType("GLint *") IntBuffer bytesWritten) {
/* 193 */     if (Checks.CHECKS) {
/* 194 */       Checks.checkSafe(bytesWritten, 1);
/*     */     }
/* 196 */     nglGetPerfMonitorCounterDataAMD(monitor, pname, data.remaining(), MemoryUtil.memAddress(data), MemoryUtil.memAddressSafe(bytesWritten));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorGroupsAMD(@NativeType("GLint *") int[] numGroups, @NativeType("GLuint *") int[] groups) {
/* 201 */     long __functionAddress = (GL.getICD()).glGetPerfMonitorGroupsAMD;
/* 202 */     if (Checks.CHECKS) {
/* 203 */       Checks.check(__functionAddress);
/* 204 */       Checks.checkSafe(numGroups, 1);
/*     */     } 
/* 206 */     JNI.callPPV(numGroups, Checks.lengthSafe(groups), groups, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorCountersAMD(@NativeType("GLuint") int group, @NativeType("GLint *") int[] numCounters, @NativeType("GLint *") int[] maxActiveCounters, @NativeType("GLuint *") int[] counters) {
/* 211 */     long __functionAddress = (GL.getICD()).glGetPerfMonitorCountersAMD;
/* 212 */     if (Checks.CHECKS) {
/* 213 */       Checks.check(__functionAddress);
/* 214 */       Checks.check(numCounters, 1);
/* 215 */       Checks.check(maxActiveCounters, 1);
/*     */     } 
/* 217 */     JNI.callPPPV(group, numCounters, maxActiveCounters, counters.length, counters, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorGroupStringAMD(@NativeType("GLuint") int group, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer groupString) {
/* 222 */     long __functionAddress = (GL.getICD()).glGetPerfMonitorGroupStringAMD;
/* 223 */     if (Checks.CHECKS) {
/* 224 */       Checks.check(__functionAddress);
/* 225 */       Checks.check(length, 1);
/*     */     } 
/* 227 */     JNI.callPPV(group, groupString.remaining(), length, MemoryUtil.memAddress(groupString), __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorCounterStringAMD(@NativeType("GLuint") int group, @NativeType("GLuint") int counter, @NativeType("GLsizei *") int[] length, @NativeType("GLchar *") ByteBuffer counterString) {
/* 232 */     long __functionAddress = (GL.getICD()).glGetPerfMonitorCounterStringAMD;
/* 233 */     if (Checks.CHECKS) {
/* 234 */       Checks.check(__functionAddress);
/* 235 */       Checks.checkSafe(length, 1);
/*     */     } 
/* 237 */     JNI.callPPV(group, counter, Checks.remainingSafe(counterString), length, MemoryUtil.memAddressSafe(counterString), __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorCounterInfoAMD(@NativeType("GLuint") int group, @NativeType("GLuint") int counter, @NativeType("GLenum") int pname, @NativeType("void *") int[] data) {
/* 242 */     long __functionAddress = (GL.getICD()).glGetPerfMonitorCounterInfoAMD;
/* 243 */     if (Checks.CHECKS) {
/* 244 */       Checks.check(__functionAddress);
/* 245 */       Checks.check(data, 1);
/*     */     } 
/* 247 */     JNI.callPV(group, counter, pname, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorCounterInfoAMD(@NativeType("GLuint") int group, @NativeType("GLuint") int counter, @NativeType("GLenum") int pname, @NativeType("void *") float[] data) {
/* 252 */     long __functionAddress = (GL.getICD()).glGetPerfMonitorCounterInfoAMD;
/* 253 */     if (Checks.CHECKS) {
/* 254 */       Checks.check(__functionAddress);
/* 255 */       Checks.check(data, 1);
/*     */     } 
/* 257 */     JNI.callPV(group, counter, pname, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenPerfMonitorsAMD(@NativeType("GLuint *") int[] monitors) {
/* 262 */     long __functionAddress = (GL.getICD()).glGenPerfMonitorsAMD;
/* 263 */     if (Checks.CHECKS) {
/* 264 */       Checks.check(__functionAddress);
/*     */     }
/* 266 */     JNI.callPV(monitors.length, monitors, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeletePerfMonitorsAMD(@NativeType("GLuint *") int[] monitors) {
/* 271 */     long __functionAddress = (GL.getICD()).glDeletePerfMonitorsAMD;
/* 272 */     if (Checks.CHECKS) {
/* 273 */       Checks.check(__functionAddress);
/*     */     }
/* 275 */     JNI.callPV(monitors.length, monitors, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSelectPerfMonitorCountersAMD(@NativeType("GLuint") int monitor, @NativeType("GLboolean") boolean enable, @NativeType("GLuint") int group, @NativeType("GLuint *") int[] counterList) {
/* 280 */     long __functionAddress = (GL.getICD()).glSelectPerfMonitorCountersAMD;
/* 281 */     if (Checks.CHECKS) {
/* 282 */       Checks.check(__functionAddress);
/*     */     }
/* 284 */     JNI.callPV(monitor, enable, group, counterList.length, counterList, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfMonitorCounterDataAMD(@NativeType("GLuint") int monitor, @NativeType("GLenum") int pname, @NativeType("GLuint *") int[] data, @NativeType("GLint *") int[] bytesWritten) {
/* 289 */     long __functionAddress = (GL.getICD()).glGetPerfMonitorCounterDataAMD;
/* 290 */     if (Checks.CHECKS) {
/* 291 */       Checks.check(__functionAddress);
/* 292 */       Checks.checkSafe(bytesWritten, 1);
/*     */     } 
/* 294 */     JNI.callPPV(monitor, pname, data.length, data, bytesWritten, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void nglGetPerfMonitorGroupsAMD(long paramLong1, int paramInt, long paramLong2);
/*     */   
/*     */   public static native void nglGetPerfMonitorCountersAMD(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3);
/*     */   
/*     */   public static native void nglGetPerfMonitorGroupStringAMD(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nglGetPerfMonitorCounterStringAMD(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nglGetPerfMonitorCounterInfoAMD(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void nglGenPerfMonitorsAMD(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglDeletePerfMonitorsAMD(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglSelectPerfMonitorCountersAMD(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glBeginPerfMonitorAMD(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glEndPerfMonitorAMD(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglGetPerfMonitorCounterDataAMD(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\AMDPerformanceMonitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */