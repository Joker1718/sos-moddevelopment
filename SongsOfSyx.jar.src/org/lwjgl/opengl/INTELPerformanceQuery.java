/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ public class INTELPerformanceQuery
/*     */ {
/*     */   public static final int GL_PERFQUERY_SINGLE_CONTEXT_INTEL = 0;
/*     */   public static final int GL_PERFQUERY_GLOBAL_CONTEXT_INTEL = 1;
/*     */   
/*     */   static {
/*  19 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_PERFQUERY_WAIT_INTEL = 33787;
/*     */   
/*     */   public static final int GL_PERFQUERY_FLUSH_INTEL = 33786;
/*     */   
/*     */   public static final int GL_PERFQUERY_DONOT_FLUSH_INTEL = 33785;
/*     */   
/*     */   public static final int GL_PERFQUERY_COUNTER_EVENT_INTEL = 38128;
/*     */   
/*     */   public static final int GL_PERFQUERY_COUNTER_DURATION_NORM_INTEL = 38129;
/*     */   
/*     */   public static final int GL_PERFQUERY_COUNTER_DURATION_RAW_INTEL = 38130;
/*     */   
/*     */   public static final int GL_PERFQUERY_COUNTER_THROUGHPUT_INTEL = 38131;
/*     */   
/*     */   public static final int GL_PERFQUERY_COUNTER_RAW_INTEL = 38132;
/*     */   
/*     */   public static final int GL_PERFQUERY_COUNTER_TIMESTAMP_INTEL = 38133;
/*     */   
/*     */   public static final int GL_PERFQUERY_COUNTER_DATA_UINT32_INTEL = 38136;
/*     */   
/*     */   public static final int GL_PERFQUERY_COUNTER_DATA_UINT64_INTEL = 38137;
/*     */   public static final int GL_PERFQUERY_COUNTER_DATA_FLOAT_INTEL = 38138;
/*     */   public static final int GL_PERFQUERY_COUNTER_DATA_DOUBLE_INTEL = 38139;
/*     */   public static final int GL_PERFQUERY_COUNTER_DATA_BOOL32_INTEL = 38140;
/*     */   public static final int GL_PERFQUERY_QUERY_NAME_LENGTH_MAX_INTEL = 38141;
/*     */   public static final int GL_PERFQUERY_COUNTER_NAME_LENGTH_MAX_INTEL = 38142;
/*     */   public static final int GL_PERFQUERY_COUNTER_DESC_LENGTH_MAX_INTEL = 38143;
/*     */   public static final int GL_PERFQUERY_GPA_EXTENDED_COUNTERS_INTEL = 38144;
/*     */   
/*     */   protected INTELPerformanceQuery() {
/*  53 */     throw new UnsupportedOperationException();
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
/*     */   public static void glCreatePerfQueryINTEL(@NativeType("GLuint") int queryId, @NativeType("GLuint *") IntBuffer queryHandle) {
/*  68 */     if (Checks.CHECKS) {
/*  69 */       Checks.check(queryHandle, 1);
/*     */     }
/*  71 */     nglCreatePerfQueryINTEL(queryId, MemoryUtil.memAddress(queryHandle));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glCreatePerfQueryINTEL(@NativeType("GLuint") int queryId) {
/*  77 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  79 */       IntBuffer queryHandle = stack.callocInt(1);
/*  80 */       nglCreatePerfQueryINTEL(queryId, MemoryUtil.memAddress(queryHandle));
/*  81 */       return queryHandle.get(0);
/*     */     } finally {
/*  83 */       stack.setPointer(stackPointer);
/*     */     } 
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
/*     */   public static void glGetFirstPerfQueryIdINTEL(@NativeType("GLuint *") IntBuffer queryId) {
/* 104 */     if (Checks.CHECKS) {
/* 105 */       Checks.check(queryId, 1);
/*     */     }
/* 107 */     nglGetFirstPerfQueryIdINTEL(MemoryUtil.memAddress(queryId));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetFirstPerfQueryIdINTEL() {
/* 113 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 115 */       IntBuffer queryId = stack.callocInt(1);
/* 116 */       nglGetFirstPerfQueryIdINTEL(MemoryUtil.memAddress(queryId));
/* 117 */       return queryId.get(0);
/*     */     } finally {
/* 119 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetNextPerfQueryIdINTEL(@NativeType("GLuint") int queryId, @NativeType("GLuint *") IntBuffer nextQueryId) {
/* 130 */     if (Checks.CHECKS) {
/* 131 */       Checks.check(nextQueryId, 1);
/*     */     }
/* 133 */     nglGetNextPerfQueryIdINTEL(queryId, MemoryUtil.memAddress(nextQueryId));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetNextPerfQueryIdINTEL(@NativeType("GLuint") int queryId) {
/* 139 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 141 */       IntBuffer nextQueryId = stack.callocInt(1);
/* 142 */       nglGetNextPerfQueryIdINTEL(queryId, MemoryUtil.memAddress(nextQueryId));
/* 143 */       return nextQueryId.get(0);
/*     */     } finally {
/* 145 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetPerfCounterInfoINTEL(@NativeType("GLuint") int queryId, @NativeType("GLuint") int counterId, @NativeType("GLchar *") ByteBuffer counterName, @NativeType("GLchar *") ByteBuffer counterDesc, @NativeType("GLuint *") IntBuffer counterOffset, @NativeType("GLuint *") IntBuffer counterDataSize, @NativeType("GLuint *") IntBuffer counterTypeEnum, @NativeType("GLuint *") IntBuffer counterDataTypeEnum, @NativeType("GLuint64 *") LongBuffer rawCounterMaxValue) {
/* 156 */     if (Checks.CHECKS) {
/* 157 */       Checks.check(counterOffset, 1);
/* 158 */       Checks.check(counterDataSize, 1);
/* 159 */       Checks.check(counterTypeEnum, 1);
/* 160 */       Checks.check(counterDataTypeEnum, 1);
/* 161 */       Checks.check(rawCounterMaxValue, 1);
/*     */     } 
/* 163 */     nglGetPerfCounterInfoINTEL(queryId, counterId, counterName.remaining(), MemoryUtil.memAddress(counterName), counterDesc.remaining(), MemoryUtil.memAddress(counterDesc), MemoryUtil.memAddress(counterOffset), MemoryUtil.memAddress(counterDataSize), MemoryUtil.memAddress(counterTypeEnum), MemoryUtil.memAddress(counterDataTypeEnum), MemoryUtil.memAddress(rawCounterMaxValue));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetPerfQueryDataINTEL(@NativeType("GLuint") int queryHandle, @NativeType("GLuint") int flags, @NativeType("void *") ByteBuffer data, @NativeType("GLuint *") IntBuffer bytesWritten) {
/* 173 */     if (Checks.CHECKS) {
/* 174 */       Checks.check(bytesWritten, 1);
/*     */     }
/* 176 */     nglGetPerfQueryDataINTEL(queryHandle, flags, data.remaining(), MemoryUtil.memAddress(data), MemoryUtil.memAddress(bytesWritten));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetPerfQueryIdByNameINTEL(@NativeType("GLchar *") ByteBuffer queryName, @NativeType("GLuint *") IntBuffer queryId) {
/* 186 */     if (Checks.CHECKS) {
/* 187 */       Checks.checkNT1(queryName);
/* 188 */       Checks.check(queryId, 1);
/*     */     } 
/* 190 */     nglGetPerfQueryIdByNameINTEL(MemoryUtil.memAddress(queryName), MemoryUtil.memAddress(queryId));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfQueryIdByNameINTEL(@NativeType("GLchar *") CharSequence queryName, @NativeType("GLuint *") IntBuffer queryId) {
/* 195 */     if (Checks.CHECKS) {
/* 196 */       Checks.check(queryId, 1);
/*     */     }
/* 198 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 200 */       stack.nASCII(queryName, true);
/* 201 */       long queryNameEncoded = stack.getPointerAddress();
/* 202 */       nglGetPerfQueryIdByNameINTEL(queryNameEncoded, MemoryUtil.memAddress(queryId));
/*     */     } finally {
/* 204 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetPerfQueryIdByNameINTEL(@NativeType("GLchar *") CharSequence queryName) {
/* 211 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 213 */       stack.nASCII(queryName, true);
/* 214 */       long queryNameEncoded = stack.getPointerAddress();
/* 215 */       IntBuffer queryId = stack.callocInt(1);
/* 216 */       nglGetPerfQueryIdByNameINTEL(queryNameEncoded, MemoryUtil.memAddress(queryId));
/* 217 */       return queryId.get(0);
/*     */     } finally {
/* 219 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetPerfQueryInfoINTEL(@NativeType("GLuint") int queryId, @NativeType("GLchar *") ByteBuffer queryName, @NativeType("GLuint *") IntBuffer dataSize, @NativeType("GLuint *") IntBuffer noCounters, @NativeType("GLuint *") IntBuffer noInstances, @NativeType("GLuint *") IntBuffer capsMask) {
/* 230 */     if (Checks.CHECKS) {
/* 231 */       Checks.check(dataSize, 1);
/* 232 */       Checks.check(noCounters, 1);
/* 233 */       Checks.check(noInstances, 1);
/* 234 */       Checks.check(capsMask, 1);
/*     */     } 
/* 236 */     nglGetPerfQueryInfoINTEL(queryId, queryName.remaining(), MemoryUtil.memAddress(queryName), MemoryUtil.memAddress(dataSize), MemoryUtil.memAddress(noCounters), MemoryUtil.memAddress(noInstances), MemoryUtil.memAddress(capsMask));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glCreatePerfQueryINTEL(@NativeType("GLuint") int queryId, @NativeType("GLuint *") int[] queryHandle) {
/* 241 */     long __functionAddress = (GL.getICD()).glCreatePerfQueryINTEL;
/* 242 */     if (Checks.CHECKS) {
/* 243 */       Checks.check(__functionAddress);
/* 244 */       Checks.check(queryHandle, 1);
/*     */     } 
/* 246 */     JNI.callPV(queryId, queryHandle, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetFirstPerfQueryIdINTEL(@NativeType("GLuint *") int[] queryId) {
/* 251 */     long __functionAddress = (GL.getICD()).glGetFirstPerfQueryIdINTEL;
/* 252 */     if (Checks.CHECKS) {
/* 253 */       Checks.check(__functionAddress);
/* 254 */       Checks.check(queryId, 1);
/*     */     } 
/* 256 */     JNI.callPV(queryId, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetNextPerfQueryIdINTEL(@NativeType("GLuint") int queryId, @NativeType("GLuint *") int[] nextQueryId) {
/* 261 */     long __functionAddress = (GL.getICD()).glGetNextPerfQueryIdINTEL;
/* 262 */     if (Checks.CHECKS) {
/* 263 */       Checks.check(__functionAddress);
/* 264 */       Checks.check(nextQueryId, 1);
/*     */     } 
/* 266 */     JNI.callPV(queryId, nextQueryId, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfCounterInfoINTEL(@NativeType("GLuint") int queryId, @NativeType("GLuint") int counterId, @NativeType("GLchar *") ByteBuffer counterName, @NativeType("GLchar *") ByteBuffer counterDesc, @NativeType("GLuint *") int[] counterOffset, @NativeType("GLuint *") int[] counterDataSize, @NativeType("GLuint *") int[] counterTypeEnum, @NativeType("GLuint *") int[] counterDataTypeEnum, @NativeType("GLuint64 *") long[] rawCounterMaxValue) {
/* 271 */     long __functionAddress = (GL.getICD()).glGetPerfCounterInfoINTEL;
/* 272 */     if (Checks.CHECKS) {
/* 273 */       Checks.check(__functionAddress);
/* 274 */       Checks.check(counterOffset, 1);
/* 275 */       Checks.check(counterDataSize, 1);
/* 276 */       Checks.check(counterTypeEnum, 1);
/* 277 */       Checks.check(counterDataTypeEnum, 1);
/* 278 */       Checks.check(rawCounterMaxValue, 1);
/*     */     } 
/* 280 */     JNI.callPPPPPPPV(queryId, counterId, counterName.remaining(), MemoryUtil.memAddress(counterName), counterDesc.remaining(), MemoryUtil.memAddress(counterDesc), counterOffset, counterDataSize, counterTypeEnum, counterDataTypeEnum, rawCounterMaxValue, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfQueryDataINTEL(@NativeType("GLuint") int queryHandle, @NativeType("GLuint") int flags, @NativeType("void *") ByteBuffer data, @NativeType("GLuint *") int[] bytesWritten) {
/* 285 */     long __functionAddress = (GL.getICD()).glGetPerfQueryDataINTEL;
/* 286 */     if (Checks.CHECKS) {
/* 287 */       Checks.check(__functionAddress);
/* 288 */       Checks.check(bytesWritten, 1);
/*     */     } 
/* 290 */     JNI.callPPV(queryHandle, flags, data.remaining(), MemoryUtil.memAddress(data), bytesWritten, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfQueryIdByNameINTEL(@NativeType("GLchar *") ByteBuffer queryName, @NativeType("GLuint *") int[] queryId) {
/* 295 */     long __functionAddress = (GL.getICD()).glGetPerfQueryIdByNameINTEL;
/* 296 */     if (Checks.CHECKS) {
/* 297 */       Checks.check(__functionAddress);
/* 298 */       Checks.checkNT1(queryName);
/* 299 */       Checks.check(queryId, 1);
/*     */     } 
/* 301 */     JNI.callPPV(MemoryUtil.memAddress(queryName), queryId, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfQueryIdByNameINTEL(@NativeType("GLchar *") CharSequence queryName, @NativeType("GLuint *") int[] queryId) {
/* 306 */     long __functionAddress = (GL.getICD()).glGetPerfQueryIdByNameINTEL;
/* 307 */     if (Checks.CHECKS) {
/* 308 */       Checks.check(__functionAddress);
/* 309 */       Checks.check(queryId, 1);
/*     */     } 
/* 311 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 313 */       stack.nASCII(queryName, true);
/* 314 */       long queryNameEncoded = stack.getPointerAddress();
/* 315 */       JNI.callPPV(queryNameEncoded, queryId, __functionAddress);
/*     */     } finally {
/* 317 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetPerfQueryInfoINTEL(@NativeType("GLuint") int queryId, @NativeType("GLchar *") ByteBuffer queryName, @NativeType("GLuint *") int[] dataSize, @NativeType("GLuint *") int[] noCounters, @NativeType("GLuint *") int[] noInstances, @NativeType("GLuint *") int[] capsMask) {
/* 323 */     long __functionAddress = (GL.getICD()).glGetPerfQueryInfoINTEL;
/* 324 */     if (Checks.CHECKS) {
/* 325 */       Checks.check(__functionAddress);
/* 326 */       Checks.check(dataSize, 1);
/* 327 */       Checks.check(noCounters, 1);
/* 328 */       Checks.check(noInstances, 1);
/* 329 */       Checks.check(capsMask, 1);
/*     */     } 
/* 331 */     JNI.callPPPPPV(queryId, queryName.remaining(), MemoryUtil.memAddress(queryName), dataSize, noCounters, noInstances, capsMask, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glBeginPerfQueryINTEL(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglCreatePerfQueryINTEL(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glDeletePerfQueryINTEL(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glEndPerfQueryINTEL(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglGetFirstPerfQueryIdINTEL(long paramLong);
/*     */   
/*     */   public static native void nglGetNextPerfQueryIdINTEL(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetPerfCounterInfoINTEL(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
/*     */   
/*     */   public static native void nglGetPerfQueryDataINTEL(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nglGetPerfQueryIdByNameINTEL(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nglGetPerfQueryInfoINTEL(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\INTELPerformanceQuery.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */