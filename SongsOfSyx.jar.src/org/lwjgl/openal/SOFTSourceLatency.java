/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.LongBuffer;
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
/*     */ public class SOFTSourceLatency
/*     */ {
/*     */   public static final int AL_SAMPLE_OFFSET_LATENCY_SOFT = 4608;
/*     */   public static final int AL_SEC_OFFSET_LATENCY_SOFT = 4609;
/*     */   
/*     */   protected SOFTSourceLatency() {
/*  24 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcedSOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble") double value) {
/*  32 */     long __functionAddress = (AL.getICD()).alSourcedSOFT;
/*  33 */     if (Checks.CHECKS) {
/*  34 */       Checks.check(__functionAddress);
/*     */     }
/*  36 */     JNI.invokeV(source, param, value, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcedDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble") double value) {
/*  44 */     long __functionAddress = (AL.getICD()).alSourcedDirectSOFT;
/*  45 */     if (Checks.CHECKS) {
/*  46 */       Checks.check(__functionAddress);
/*  47 */       Checks.check(context);
/*     */     } 
/*  49 */     JNI.invokePV(context, source, param, value, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSource3dSOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble") double value1, @NativeType("ALdouble") double value2, @NativeType("ALdouble") double value3) {
/*  57 */     long __functionAddress = (AL.getICD()).alSource3dSOFT;
/*  58 */     if (Checks.CHECKS) {
/*  59 */       Checks.check(__functionAddress);
/*     */     }
/*  61 */     JNI.invokeV(source, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSource3dDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble") double value1, @NativeType("ALdouble") double value2, @NativeType("ALdouble") double value3) {
/*  69 */     long __functionAddress = (AL.getICD()).alSource3dDirectSOFT;
/*  70 */     if (Checks.CHECKS) {
/*  71 */       Checks.check(__functionAddress);
/*  72 */       Checks.check(context);
/*     */     } 
/*  74 */     JNI.invokePV(context, source, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalSourcedvSOFT(int source, int param, long value) {
/*  81 */     long __functionAddress = (AL.getICD()).alSourcedvSOFT;
/*  82 */     if (Checks.CHECKS) {
/*  83 */       Checks.check(__functionAddress);
/*     */     }
/*  85 */     JNI.invokePV(source, param, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcedvSOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble const *") DoubleBuffer value) {
/*  91 */     if (Checks.CHECKS) {
/*  92 */       Checks.check(value, 1);
/*     */     }
/*  94 */     nalSourcedvSOFT(source, param, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalSourcedvDirectSOFT(long context, int source, int param, long value) {
/* 101 */     long __functionAddress = (AL.getICD()).alSourcedvDirectSOFT;
/* 102 */     if (Checks.CHECKS) {
/* 103 */       Checks.check(__functionAddress);
/* 104 */       Checks.check(context);
/*     */     } 
/* 106 */     JNI.invokePPV(context, source, param, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcedvDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble const *") DoubleBuffer value) {
/* 112 */     if (Checks.CHECKS) {
/* 113 */       Checks.check(value, 1);
/*     */     }
/* 115 */     nalSourcedvDirectSOFT(context, source, param, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSourcedSOFT(int source, int param, long value) {
/* 122 */     long __functionAddress = (AL.getICD()).alGetSourcedSOFT;
/* 123 */     if (Checks.CHECKS) {
/* 124 */       Checks.check(__functionAddress);
/*     */     }
/* 126 */     JNI.invokePV(source, param, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcedSOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble *") DoubleBuffer value) {
/* 132 */     if (Checks.CHECKS) {
/* 133 */       Checks.check(value, 1);
/*     */     }
/* 135 */     nalGetSourcedSOFT(source, param, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static double alGetSourcedSOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param) {
/* 141 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 143 */       DoubleBuffer value = stack.callocDouble(1);
/* 144 */       nalGetSourcedSOFT(source, param, MemoryUtil.memAddress(value));
/* 145 */       return value.get(0);
/*     */     } finally {
/* 147 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSourcedDirectSOFT(long context, int source, int param, long value) {
/* 155 */     long __functionAddress = (AL.getICD()).alGetSourcedDirectSOFT;
/* 156 */     if (Checks.CHECKS) {
/* 157 */       Checks.check(__functionAddress);
/* 158 */       Checks.check(context);
/*     */     } 
/* 160 */     JNI.invokePPV(context, source, param, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcedDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble *") DoubleBuffer value) {
/* 166 */     if (Checks.CHECKS) {
/* 167 */       Checks.check(value, 1);
/*     */     }
/* 169 */     nalGetSourcedDirectSOFT(context, source, param, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static double alGetSourcedDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param) {
/* 175 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 177 */       DoubleBuffer value = stack.callocDouble(1);
/* 178 */       nalGetSourcedDirectSOFT(context, source, param, MemoryUtil.memAddress(value));
/* 179 */       return value.get(0);
/*     */     } finally {
/* 181 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSource3dSOFT(int source, int param, long value1, long value2, long value3) {
/* 189 */     long __functionAddress = (AL.getICD()).alGetSource3dSOFT;
/* 190 */     if (Checks.CHECKS) {
/* 191 */       Checks.check(__functionAddress);
/*     */     }
/* 193 */     JNI.invokePPPV(source, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSource3dSOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble *") DoubleBuffer value1, @NativeType("ALdouble *") DoubleBuffer value2, @NativeType("ALdouble *") DoubleBuffer value3) {
/* 199 */     if (Checks.CHECKS) {
/* 200 */       Checks.check(value1, 1);
/* 201 */       Checks.check(value2, 1);
/* 202 */       Checks.check(value3, 1);
/*     */     } 
/* 204 */     nalGetSource3dSOFT(source, param, MemoryUtil.memAddress(value1), MemoryUtil.memAddress(value2), MemoryUtil.memAddress(value3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSource3dDirectSOFT(long context, int source, int param, long value1, long value2, long value3) {
/* 211 */     long __functionAddress = (AL.getICD()).alGetSource3dDirectSOFT;
/* 212 */     if (Checks.CHECKS) {
/* 213 */       Checks.check(__functionAddress);
/* 214 */       Checks.check(context);
/*     */     } 
/* 216 */     JNI.invokePPPPV(context, source, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSource3dDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble *") DoubleBuffer value1, @NativeType("ALdouble *") DoubleBuffer value2, @NativeType("ALdouble *") DoubleBuffer value3) {
/* 222 */     if (Checks.CHECKS) {
/* 223 */       Checks.check(value1, 1);
/* 224 */       Checks.check(value2, 1);
/* 225 */       Checks.check(value3, 1);
/*     */     } 
/* 227 */     nalGetSource3dDirectSOFT(context, source, param, MemoryUtil.memAddress(value1), MemoryUtil.memAddress(value2), MemoryUtil.memAddress(value3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSourcedvSOFT(int source, int param, long values) {
/* 234 */     long __functionAddress = (AL.getICD()).alGetSourcedvSOFT;
/* 235 */     if (Checks.CHECKS) {
/* 236 */       Checks.check(__functionAddress);
/*     */     }
/* 238 */     JNI.invokePV(source, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcedvSOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble *") DoubleBuffer values) {
/* 244 */     if (Checks.CHECKS) {
/* 245 */       Checks.check(values, 1);
/*     */     }
/* 247 */     nalGetSourcedvSOFT(source, param, MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSourcedvDirectSOFT(long context, int source, int param, long values) {
/* 254 */     long __functionAddress = (AL.getICD()).alGetSourcedvDirectSOFT;
/* 255 */     if (Checks.CHECKS) {
/* 256 */       Checks.check(__functionAddress);
/* 257 */       Checks.check(context);
/*     */     } 
/* 259 */     JNI.invokePPV(context, source, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcedvDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble *") DoubleBuffer values) {
/* 265 */     if (Checks.CHECKS) {
/* 266 */       Checks.check(values, 1);
/*     */     }
/* 268 */     nalGetSourcedvDirectSOFT(context, source, param, MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcei64SOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT") long value) {
/* 276 */     long __functionAddress = (AL.getICD()).alSourcei64SOFT;
/* 277 */     if (Checks.CHECKS) {
/* 278 */       Checks.check(__functionAddress);
/*     */     }
/* 280 */     JNI.invokeJV(source, param, value, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcei64DirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT") long value) {
/* 288 */     long __functionAddress = (AL.getICD()).alSourcei64DirectSOFT;
/* 289 */     if (Checks.CHECKS) {
/* 290 */       Checks.check(__functionAddress);
/* 291 */       Checks.check(context);
/*     */     } 
/* 293 */     JNI.invokePJV(context, source, param, value, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSource3i64SOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT") long value1, @NativeType("ALint64SOFT") long value2, @NativeType("ALint64SOFT") long value3) {
/* 301 */     long __functionAddress = (AL.getICD()).alSource3i64SOFT;
/* 302 */     if (Checks.CHECKS) {
/* 303 */       Checks.check(__functionAddress);
/*     */     }
/* 305 */     JNI.invokeJJJV(source, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSource3i64DirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT") long value1, @NativeType("ALint64SOFT") long value2, @NativeType("ALint64SOFT") long value3) {
/* 313 */     long __functionAddress = (AL.getICD()).alSource3i64DirectSOFT;
/* 314 */     if (Checks.CHECKS) {
/* 315 */       Checks.check(__functionAddress);
/* 316 */       Checks.check(context);
/*     */     } 
/* 318 */     JNI.invokePJJJV(context, source, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalSourcei64vSOFT(int source, int param, long values) {
/* 325 */     long __functionAddress = (AL.getICD()).alSourcei64vSOFT;
/* 326 */     if (Checks.CHECKS) {
/* 327 */       Checks.check(__functionAddress);
/*     */     }
/* 329 */     JNI.invokePV(source, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcei64vSOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT const *") LongBuffer values) {
/* 335 */     if (Checks.CHECKS) {
/* 336 */       Checks.check(values, 1);
/*     */     }
/* 338 */     nalSourcei64vSOFT(source, param, MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalSourcei64vDirectSOFT(long context, int source, int param, long values) {
/* 345 */     long __functionAddress = (AL.getICD()).alSourcei64vDirectSOFT;
/* 346 */     if (Checks.CHECKS) {
/* 347 */       Checks.check(__functionAddress);
/* 348 */       Checks.check(context);
/*     */     } 
/* 350 */     JNI.invokePPV(context, source, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcei64vDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT const *") LongBuffer values) {
/* 356 */     if (Checks.CHECKS) {
/* 357 */       Checks.check(values, 1);
/*     */     }
/* 359 */     nalSourcei64vDirectSOFT(context, source, param, MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSourcei64SOFT(int source, int param, long value) {
/* 366 */     long __functionAddress = (AL.getICD()).alGetSourcei64SOFT;
/* 367 */     if (Checks.CHECKS) {
/* 368 */       Checks.check(__functionAddress);
/*     */     }
/* 370 */     JNI.invokePV(source, param, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcei64SOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT *") LongBuffer value) {
/* 376 */     if (Checks.CHECKS) {
/* 377 */       Checks.check(value, 1);
/*     */     }
/* 379 */     nalGetSourcei64SOFT(source, param, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static long alGetSourcei64SOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param) {
/* 385 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 387 */       LongBuffer value = stack.callocLong(1);
/* 388 */       nalGetSourcei64SOFT(source, param, MemoryUtil.memAddress(value));
/* 389 */       return value.get(0);
/*     */     } finally {
/* 391 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSourcei64DirectSOFT(long context, int source, int param, long value) {
/* 399 */     long __functionAddress = (AL.getICD()).alGetSourcei64DirectSOFT;
/* 400 */     if (Checks.CHECKS) {
/* 401 */       Checks.check(__functionAddress);
/* 402 */       Checks.check(context);
/*     */     } 
/* 404 */     JNI.invokePPV(context, source, param, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcei64DirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT *") LongBuffer value) {
/* 410 */     if (Checks.CHECKS) {
/* 411 */       Checks.check(value, 1);
/*     */     }
/* 413 */     nalGetSourcei64DirectSOFT(context, source, param, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static long alGetSourcei64DirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param) {
/* 419 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 421 */       LongBuffer value = stack.callocLong(1);
/* 422 */       nalGetSourcei64DirectSOFT(context, source, param, MemoryUtil.memAddress(value));
/* 423 */       return value.get(0);
/*     */     } finally {
/* 425 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSource3i64SOFT(int source, int param, long value1, long value2, long value3) {
/* 433 */     long __functionAddress = (AL.getICD()).alGetSource3i64SOFT;
/* 434 */     if (Checks.CHECKS) {
/* 435 */       Checks.check(__functionAddress);
/*     */     }
/* 437 */     JNI.invokePPPV(source, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSource3i64SOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT *") LongBuffer value1, @NativeType("ALint64SOFT *") LongBuffer value2, @NativeType("ALint64SOFT *") LongBuffer value3) {
/* 443 */     if (Checks.CHECKS) {
/* 444 */       Checks.check(value1, 1);
/* 445 */       Checks.check(value2, 1);
/* 446 */       Checks.check(value3, 1);
/*     */     } 
/* 448 */     nalGetSource3i64SOFT(source, param, MemoryUtil.memAddress(value1), MemoryUtil.memAddress(value2), MemoryUtil.memAddress(value3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSource3i64DirectSOFT(long context, int source, int param, long value1, long value2, long value3) {
/* 455 */     long __functionAddress = (AL.getICD()).alGetSource3i64DirectSOFT;
/* 456 */     if (Checks.CHECKS) {
/* 457 */       Checks.check(__functionAddress);
/* 458 */       Checks.check(context);
/*     */     } 
/* 460 */     JNI.invokePPPPV(context, source, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSource3i64DirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT *") LongBuffer value1, @NativeType("ALint64SOFT *") LongBuffer value2, @NativeType("ALint64SOFT *") LongBuffer value3) {
/* 466 */     if (Checks.CHECKS) {
/* 467 */       Checks.check(value1, 1);
/* 468 */       Checks.check(value2, 1);
/* 469 */       Checks.check(value3, 1);
/*     */     } 
/* 471 */     nalGetSource3i64DirectSOFT(context, source, param, MemoryUtil.memAddress(value1), MemoryUtil.memAddress(value2), MemoryUtil.memAddress(value3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSourcei64vSOFT(int source, int param, long values) {
/* 478 */     long __functionAddress = (AL.getICD()).alGetSourcei64vSOFT;
/* 479 */     if (Checks.CHECKS) {
/* 480 */       Checks.check(__functionAddress);
/*     */     }
/* 482 */     JNI.invokePV(source, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcei64vSOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT *") LongBuffer values) {
/* 488 */     if (Checks.CHECKS) {
/* 489 */       Checks.check(values, 1);
/*     */     }
/* 491 */     nalGetSourcei64vSOFT(source, param, MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSourcei64vDirectSOFT(long context, int source, int param, long values) {
/* 498 */     long __functionAddress = (AL.getICD()).alGetSourcei64vDirectSOFT;
/* 499 */     if (Checks.CHECKS) {
/* 500 */       Checks.check(__functionAddress);
/* 501 */       Checks.check(context);
/*     */     } 
/* 503 */     JNI.invokePPV(context, source, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcei64vDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT *") LongBuffer values) {
/* 509 */     if (Checks.CHECKS) {
/* 510 */       Checks.check(values, 1);
/*     */     }
/* 512 */     nalGetSourcei64vDirectSOFT(context, source, param, MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcedvSOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble const *") double[] value) {
/* 518 */     long __functionAddress = (AL.getICD()).alSourcedvSOFT;
/* 519 */     if (Checks.CHECKS) {
/* 520 */       Checks.check(__functionAddress);
/* 521 */       Checks.check(value, 1);
/*     */     } 
/* 523 */     JNI.invokePV(source, param, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcedvDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble const *") double[] value) {
/* 529 */     long __functionAddress = (AL.getICD()).alSourcedvDirectSOFT;
/* 530 */     if (Checks.CHECKS) {
/* 531 */       Checks.check(__functionAddress);
/* 532 */       Checks.check(context);
/* 533 */       Checks.check(value, 1);
/*     */     } 
/* 535 */     JNI.invokePPV(context, source, param, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcedSOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble *") double[] value) {
/* 541 */     long __functionAddress = (AL.getICD()).alGetSourcedSOFT;
/* 542 */     if (Checks.CHECKS) {
/* 543 */       Checks.check(__functionAddress);
/* 544 */       Checks.check(value, 1);
/*     */     } 
/* 546 */     JNI.invokePV(source, param, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcedDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble *") double[] value) {
/* 552 */     long __functionAddress = (AL.getICD()).alGetSourcedDirectSOFT;
/* 553 */     if (Checks.CHECKS) {
/* 554 */       Checks.check(__functionAddress);
/* 555 */       Checks.check(context);
/* 556 */       Checks.check(value, 1);
/*     */     } 
/* 558 */     JNI.invokePPV(context, source, param, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSource3dSOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble *") double[] value1, @NativeType("ALdouble *") double[] value2, @NativeType("ALdouble *") double[] value3) {
/* 564 */     long __functionAddress = (AL.getICD()).alGetSource3dSOFT;
/* 565 */     if (Checks.CHECKS) {
/* 566 */       Checks.check(__functionAddress);
/* 567 */       Checks.check(value1, 1);
/* 568 */       Checks.check(value2, 1);
/* 569 */       Checks.check(value3, 1);
/*     */     } 
/* 571 */     JNI.invokePPPV(source, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSource3dDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble *") double[] value1, @NativeType("ALdouble *") double[] value2, @NativeType("ALdouble *") double[] value3) {
/* 577 */     long __functionAddress = (AL.getICD()).alGetSource3dDirectSOFT;
/* 578 */     if (Checks.CHECKS) {
/* 579 */       Checks.check(__functionAddress);
/* 580 */       Checks.check(context);
/* 581 */       Checks.check(value1, 1);
/* 582 */       Checks.check(value2, 1);
/* 583 */       Checks.check(value3, 1);
/*     */     } 
/* 585 */     JNI.invokePPPPV(context, source, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcedvSOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble *") double[] values) {
/* 591 */     long __functionAddress = (AL.getICD()).alGetSourcedvSOFT;
/* 592 */     if (Checks.CHECKS) {
/* 593 */       Checks.check(__functionAddress);
/* 594 */       Checks.check(values, 1);
/*     */     } 
/* 596 */     JNI.invokePV(source, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcedvDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALdouble *") double[] values) {
/* 602 */     long __functionAddress = (AL.getICD()).alGetSourcedvDirectSOFT;
/* 603 */     if (Checks.CHECKS) {
/* 604 */       Checks.check(__functionAddress);
/* 605 */       Checks.check(context);
/* 606 */       Checks.check(values, 1);
/*     */     } 
/* 608 */     JNI.invokePPV(context, source, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcei64vSOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT const *") long[] values) {
/* 614 */     long __functionAddress = (AL.getICD()).alSourcei64vSOFT;
/* 615 */     if (Checks.CHECKS) {
/* 616 */       Checks.check(__functionAddress);
/* 617 */       Checks.check(values, 1);
/*     */     } 
/* 619 */     JNI.invokePV(source, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourcei64vDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT const *") long[] values) {
/* 625 */     long __functionAddress = (AL.getICD()).alSourcei64vDirectSOFT;
/* 626 */     if (Checks.CHECKS) {
/* 627 */       Checks.check(__functionAddress);
/* 628 */       Checks.check(context);
/* 629 */       Checks.check(values, 1);
/*     */     } 
/* 631 */     JNI.invokePPV(context, source, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcei64SOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT *") long[] value) {
/* 637 */     long __functionAddress = (AL.getICD()).alGetSourcei64SOFT;
/* 638 */     if (Checks.CHECKS) {
/* 639 */       Checks.check(__functionAddress);
/* 640 */       Checks.check(value, 1);
/*     */     } 
/* 642 */     JNI.invokePV(source, param, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcei64DirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT *") long[] value) {
/* 648 */     long __functionAddress = (AL.getICD()).alGetSourcei64DirectSOFT;
/* 649 */     if (Checks.CHECKS) {
/* 650 */       Checks.check(__functionAddress);
/* 651 */       Checks.check(context);
/* 652 */       Checks.check(value, 1);
/*     */     } 
/* 654 */     JNI.invokePPV(context, source, param, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSource3i64SOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT *") long[] value1, @NativeType("ALint64SOFT *") long[] value2, @NativeType("ALint64SOFT *") long[] value3) {
/* 660 */     long __functionAddress = (AL.getICD()).alGetSource3i64SOFT;
/* 661 */     if (Checks.CHECKS) {
/* 662 */       Checks.check(__functionAddress);
/* 663 */       Checks.check(value1, 1);
/* 664 */       Checks.check(value2, 1);
/* 665 */       Checks.check(value3, 1);
/*     */     } 
/* 667 */     JNI.invokePPPV(source, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSource3i64DirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT *") long[] value1, @NativeType("ALint64SOFT *") long[] value2, @NativeType("ALint64SOFT *") long[] value3) {
/* 673 */     long __functionAddress = (AL.getICD()).alGetSource3i64DirectSOFT;
/* 674 */     if (Checks.CHECKS) {
/* 675 */       Checks.check(__functionAddress);
/* 676 */       Checks.check(context);
/* 677 */       Checks.check(value1, 1);
/* 678 */       Checks.check(value2, 1);
/* 679 */       Checks.check(value3, 1);
/*     */     } 
/* 681 */     JNI.invokePPPPV(context, source, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcei64vSOFT(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT *") long[] values) {
/* 687 */     long __functionAddress = (AL.getICD()).alGetSourcei64vSOFT;
/* 688 */     if (Checks.CHECKS) {
/* 689 */       Checks.check(__functionAddress);
/* 690 */       Checks.check(values, 1);
/*     */     } 
/* 692 */     JNI.invokePV(source, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSourcei64vDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint64SOFT *") long[] values) {
/* 698 */     long __functionAddress = (AL.getICD()).alGetSourcei64vDirectSOFT;
/* 699 */     if (Checks.CHECKS) {
/* 700 */       Checks.check(__functionAddress);
/* 701 */       Checks.check(context);
/* 702 */       Checks.check(values, 1);
/*     */     } 
/* 704 */     JNI.invokePPV(context, source, param, values, __functionAddress);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\SOFTSourceLatency.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */