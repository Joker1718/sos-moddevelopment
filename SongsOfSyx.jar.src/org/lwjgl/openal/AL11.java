/*     */ package org.lwjgl.openal;
/*     */ 
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
/*     */ public class AL11
/*     */   extends AL10
/*     */ {
/*     */   public static final int AL_SEC_OFFSET = 4132;
/*     */   public static final int AL_SAMPLE_OFFSET = 4133;
/*     */   public static final int AL_BYTE_OFFSET = 4134;
/*     */   public static final int AL_STATIC = 4136;
/*     */   public static final int AL_STREAMING = 4137;
/*     */   public static final int AL_UNDETERMINED = 4144;
/*     */   public static final int AL_ILLEGAL_COMMAND = 40964;
/*     */   public static final int AL_SPEED_OF_SOUND = 49155;
/*     */   public static final int AL_LINEAR_DISTANCE = 53251;
/*     */   public static final int AL_LINEAR_DISTANCE_CLAMPED = 53252;
/*     */   public static final int AL_EXPONENT_DISTANCE = 53253;
/*     */   public static final int AL_EXPONENT_DISTANCE_CLAMPED = 53254;
/*     */   
/*     */   protected AL11() {
/*  33 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alListener3i(@NativeType("ALenum") int paramName, @NativeType("ALint") int value1, @NativeType("ALint") int value2, @NativeType("ALint") int value3) {
/*  41 */     long __functionAddress = (AL.getICD()).alListener3i;
/*  42 */     if (Checks.CHECKS) {
/*  43 */       Checks.check(__functionAddress);
/*     */     }
/*  45 */     JNI.invokeV(paramName, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alListener3iDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALint") int value1, @NativeType("ALint") int value2, @NativeType("ALint") int value3) {
/*  53 */     long __functionAddress = (AL.getICD()).alListener3iDirect;
/*  54 */     if (Checks.CHECKS) {
/*  55 */       Checks.check(__functionAddress);
/*  56 */       Checks.check(context);
/*     */     } 
/*  58 */     JNI.invokePV(context, paramName, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetListener3i(int param, long value1, long value2, long value3) {
/*  65 */     long __functionAddress = (AL.getICD()).alGetListener3i;
/*  66 */     if (Checks.CHECKS) {
/*  67 */       Checks.check(__functionAddress);
/*     */     }
/*  69 */     JNI.invokePPPV(param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetListener3i(@NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer value1, @NativeType("ALint *") IntBuffer value2, @NativeType("ALint *") IntBuffer value3) {
/*  75 */     if (Checks.CHECKS) {
/*  76 */       Checks.check(value1, 1);
/*  77 */       Checks.check(value2, 1);
/*  78 */       Checks.check(value3, 1);
/*     */     } 
/*  80 */     nalGetListener3i(param, MemoryUtil.memAddress(value1), MemoryUtil.memAddress(value2), MemoryUtil.memAddress(value3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetListener3iDirect(long context, int param, long value1, long value2, long value3) {
/*  87 */     long __functionAddress = (AL.getICD()).alGetListener3iDirect;
/*  88 */     if (Checks.CHECKS) {
/*  89 */       Checks.check(__functionAddress);
/*  90 */       Checks.check(context);
/*     */     } 
/*  92 */     JNI.invokePPPPV(context, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetListener3iDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer value1, @NativeType("ALint *") IntBuffer value2, @NativeType("ALint *") IntBuffer value3) {
/*  98 */     if (Checks.CHECKS) {
/*  99 */       Checks.check(value1, 1);
/* 100 */       Checks.check(value2, 1);
/* 101 */       Checks.check(value3, 1);
/*     */     } 
/* 103 */     nalGetListener3iDirect(context, param, MemoryUtil.memAddress(value1), MemoryUtil.memAddress(value2), MemoryUtil.memAddress(value3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetListeneriv(int param, long values) {
/* 110 */     long __functionAddress = (AL.getICD()).alGetListeneriv;
/* 111 */     if (Checks.CHECKS) {
/* 112 */       Checks.check(__functionAddress);
/*     */     }
/* 114 */     JNI.invokePV(param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetListeneriv(@NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer values) {
/* 120 */     if (Checks.CHECKS) {
/* 121 */       Checks.check(values, 1);
/*     */     }
/* 123 */     nalGetListeneriv(param, MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetListenerivDirect(long context, int param, long values) {
/* 130 */     long __functionAddress = (AL.getICD()).alGetListenerivDirect;
/* 131 */     if (Checks.CHECKS) {
/* 132 */       Checks.check(__functionAddress);
/* 133 */       Checks.check(context);
/*     */     } 
/* 135 */     JNI.invokePPV(context, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetListenerivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer values) {
/* 141 */     if (Checks.CHECKS) {
/* 142 */       Checks.check(values, 1);
/*     */     }
/* 144 */     nalGetListenerivDirect(context, param, MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSource3i(@NativeType("ALuint") int source, @NativeType("ALenum") int paramName, @NativeType("ALint") int value1, @NativeType("ALint") int value2, @NativeType("ALint") int value3) {
/* 152 */     long __functionAddress = (AL.getICD()).alSource3i;
/* 153 */     if (Checks.CHECKS) {
/* 154 */       Checks.check(__functionAddress);
/*     */     }
/* 156 */     JNI.invokeV(source, paramName, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSource3iDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int paramName, @NativeType("ALint") int value1, @NativeType("ALint") int value2, @NativeType("ALint") int value3) {
/* 164 */     long __functionAddress = (AL.getICD()).alSource3iDirect;
/* 165 */     if (Checks.CHECKS) {
/* 166 */       Checks.check(__functionAddress);
/* 167 */       Checks.check(context);
/*     */     } 
/* 169 */     JNI.invokePV(context, source, paramName, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSource3i(int source, int param, long value1, long value2, long value3) {
/* 176 */     long __functionAddress = (AL.getICD()).alGetSource3i;
/* 177 */     if (Checks.CHECKS) {
/* 178 */       Checks.check(__functionAddress);
/*     */     }
/* 180 */     JNI.invokePPPV(source, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSource3i(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer value1, @NativeType("ALint *") IntBuffer value2, @NativeType("ALint *") IntBuffer value3) {
/* 186 */     if (Checks.CHECKS) {
/* 187 */       Checks.check(value1, 1);
/* 188 */       Checks.check(value2, 1);
/* 189 */       Checks.check(value3, 1);
/*     */     } 
/* 191 */     nalGetSource3i(source, param, MemoryUtil.memAddress(value1), MemoryUtil.memAddress(value2), MemoryUtil.memAddress(value3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetSource3iDirect(long context, int source, int param, long value1, long value2, long value3) {
/* 198 */     long __functionAddress = (AL.getICD()).alGetSource3iDirect;
/* 199 */     if (Checks.CHECKS) {
/* 200 */       Checks.check(__functionAddress);
/* 201 */       Checks.check(context);
/*     */     } 
/* 203 */     JNI.invokePPPPV(context, source, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSource3iDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer value1, @NativeType("ALint *") IntBuffer value2, @NativeType("ALint *") IntBuffer value3) {
/* 209 */     if (Checks.CHECKS) {
/* 210 */       Checks.check(value1, 1);
/* 211 */       Checks.check(value2, 1);
/* 212 */       Checks.check(value3, 1);
/*     */     } 
/* 214 */     nalGetSource3iDirect(context, source, param, MemoryUtil.memAddress(value1), MemoryUtil.memAddress(value2), MemoryUtil.memAddress(value3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalListeneriv(int listener, long value) {
/* 221 */     long __functionAddress = (AL.getICD()).alListeneriv;
/* 222 */     if (Checks.CHECKS) {
/* 223 */       Checks.check(__functionAddress);
/*     */     }
/* 225 */     JNI.invokePV(listener, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alListeneriv(@NativeType("ALenum") int listener, @NativeType("ALint const *") IntBuffer value) {
/* 231 */     if (Checks.CHECKS) {
/* 232 */       Checks.check(value, 1);
/*     */     }
/* 234 */     nalListeneriv(listener, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalListenerivDirect(long context, int listener, long value) {
/* 241 */     long __functionAddress = (AL.getICD()).alListenerivDirect;
/* 242 */     if (Checks.CHECKS) {
/* 243 */       Checks.check(__functionAddress);
/* 244 */       Checks.check(context);
/*     */     } 
/* 246 */     JNI.invokePPV(context, listener, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alListenerivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int listener, @NativeType("ALint const *") IntBuffer value) {
/* 252 */     if (Checks.CHECKS) {
/* 253 */       Checks.check(value, 1);
/*     */     }
/* 255 */     nalListenerivDirect(context, listener, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalSourceiv(int source, int paramName, long value) {
/* 262 */     long __functionAddress = (AL.getICD()).alSourceiv;
/* 263 */     if (Checks.CHECKS) {
/* 264 */       Checks.check(__functionAddress);
/*     */     }
/* 266 */     JNI.invokePV(source, paramName, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourceiv(@NativeType("ALuint") int source, @NativeType("ALenum") int paramName, @NativeType("ALint const *") IntBuffer value) {
/* 272 */     if (Checks.CHECKS) {
/* 273 */       Checks.check(value, 1);
/*     */     }
/* 275 */     nalSourceiv(source, paramName, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalSourceivDirect(long context, int source, int paramName, long value) {
/* 282 */     long __functionAddress = (AL.getICD()).alSourceivDirect;
/* 283 */     if (Checks.CHECKS) {
/* 284 */       Checks.check(__functionAddress);
/* 285 */       Checks.check(context);
/*     */     } 
/* 287 */     JNI.invokePPV(context, source, paramName, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourceivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int paramName, @NativeType("ALint const *") IntBuffer value) {
/* 293 */     if (Checks.CHECKS) {
/* 294 */       Checks.check(value, 1);
/*     */     }
/* 296 */     nalSourceivDirect(context, source, paramName, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferf(@NativeType("ALuint") int buffer, @NativeType("ALenum") int paramName, @NativeType("ALfloat") float value) {
/* 304 */     long __functionAddress = (AL.getICD()).alBufferf;
/* 305 */     if (Checks.CHECKS) {
/* 306 */       Checks.check(__functionAddress);
/*     */     }
/* 308 */     JNI.invokeV(buffer, paramName, value, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int paramName, @NativeType("ALfloat") float value) {
/* 316 */     long __functionAddress = (AL.getICD()).alBufferfDirect;
/* 317 */     if (Checks.CHECKS) {
/* 318 */       Checks.check(__functionAddress);
/* 319 */       Checks.check(context);
/*     */     } 
/* 321 */     JNI.invokePV(context, buffer, paramName, value, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBuffer3f(@NativeType("ALuint") int buffer, @NativeType("ALenum") int paramName, @NativeType("ALfloat") float value1, @NativeType("ALfloat") float value2, @NativeType("ALfloat") float value3) {
/* 329 */     long __functionAddress = (AL.getICD()).alBuffer3f;
/* 330 */     if (Checks.CHECKS) {
/* 331 */       Checks.check(__functionAddress);
/*     */     }
/* 333 */     JNI.invokeV(buffer, paramName, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBuffer3fDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int paramName, @NativeType("ALfloat") float value1, @NativeType("ALfloat") float value2, @NativeType("ALfloat") float value3) {
/* 341 */     long __functionAddress = (AL.getICD()).alBuffer3fDirect;
/* 342 */     if (Checks.CHECKS) {
/* 343 */       Checks.check(__functionAddress);
/* 344 */       Checks.check(context);
/*     */     } 
/* 346 */     JNI.invokePV(context, buffer, paramName, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalBufferfv(int buffer, int paramName, long value) {
/* 353 */     long __functionAddress = (AL.getICD()).alBufferfv;
/* 354 */     if (Checks.CHECKS) {
/* 355 */       Checks.check(__functionAddress);
/*     */     }
/* 357 */     JNI.invokePV(buffer, paramName, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferfv(@NativeType("ALuint") int buffer, @NativeType("ALenum") int paramName, @NativeType("ALfloat const *") FloatBuffer value) {
/* 363 */     if (Checks.CHECKS) {
/* 364 */       Checks.check(value, 1);
/*     */     }
/* 366 */     nalBufferfv(buffer, paramName, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalBufferfvDirect(long context, int buffer, int paramName, long value) {
/* 373 */     long __functionAddress = (AL.getICD()).alBufferfvDirect;
/* 374 */     if (Checks.CHECKS) {
/* 375 */       Checks.check(__functionAddress);
/* 376 */       Checks.check(context);
/*     */     } 
/* 378 */     JNI.invokePPV(context, buffer, paramName, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int paramName, @NativeType("ALfloat const *") FloatBuffer value) {
/* 384 */     if (Checks.CHECKS) {
/* 385 */       Checks.check(value, 1);
/*     */     }
/* 387 */     nalBufferfvDirect(context, buffer, paramName, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferi(@NativeType("ALuint") int buffer, @NativeType("ALenum") int paramName, @NativeType("ALint") int value) {
/* 395 */     long __functionAddress = (AL.getICD()).alBufferi;
/* 396 */     if (Checks.CHECKS) {
/* 397 */       Checks.check(__functionAddress);
/*     */     }
/* 399 */     JNI.invokeV(buffer, paramName, value, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferiDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int paramName, @NativeType("ALint") int value) {
/* 407 */     long __functionAddress = (AL.getICD()).alBufferiDirect;
/* 408 */     if (Checks.CHECKS) {
/* 409 */       Checks.check(__functionAddress);
/* 410 */       Checks.check(context);
/*     */     } 
/* 412 */     JNI.invokePV(context, buffer, paramName, value, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBuffer3i(@NativeType("ALuint") int buffer, @NativeType("ALenum") int paramName, @NativeType("ALint") int value1, @NativeType("ALint") int value2, @NativeType("ALint") int value3) {
/* 420 */     long __functionAddress = (AL.getICD()).alBuffer3i;
/* 421 */     if (Checks.CHECKS) {
/* 422 */       Checks.check(__functionAddress);
/*     */     }
/* 424 */     JNI.invokeV(buffer, paramName, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBuffer3iDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int paramName, @NativeType("ALint") int value1, @NativeType("ALint") int value2, @NativeType("ALint") int value3) {
/* 432 */     long __functionAddress = (AL.getICD()).alBuffer3iDirect;
/* 433 */     if (Checks.CHECKS) {
/* 434 */       Checks.check(__functionAddress);
/* 435 */       Checks.check(context);
/*     */     } 
/* 437 */     JNI.invokePV(context, buffer, paramName, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalBufferiv(int buffer, int paramName, long value) {
/* 444 */     long __functionAddress = (AL.getICD()).alBufferiv;
/* 445 */     if (Checks.CHECKS) {
/* 446 */       Checks.check(__functionAddress);
/*     */     }
/* 448 */     JNI.invokePV(buffer, paramName, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferiv(@NativeType("ALuint") int buffer, @NativeType("ALenum") int paramName, @NativeType("ALint const *") IntBuffer value) {
/* 454 */     if (Checks.CHECKS) {
/* 455 */       Checks.check(value, 1);
/*     */     }
/* 457 */     nalBufferiv(buffer, paramName, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalBufferivDirect(long context, int buffer, int paramName, long value) {
/* 464 */     long __functionAddress = (AL.getICD()).alBufferivDirect;
/* 465 */     if (Checks.CHECKS) {
/* 466 */       Checks.check(__functionAddress);
/* 467 */       Checks.check(context);
/*     */     } 
/* 469 */     JNI.invokePPV(context, buffer, paramName, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int paramName, @NativeType("ALint const *") IntBuffer value) {
/* 475 */     if (Checks.CHECKS) {
/* 476 */       Checks.check(value, 1);
/*     */     }
/* 478 */     nalBufferivDirect(context, buffer, paramName, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBuffer3i(int buffer, int param, long value1, long value2, long value3) {
/* 485 */     long __functionAddress = (AL.getICD()).alGetBuffer3i;
/* 486 */     if (Checks.CHECKS) {
/* 487 */       Checks.check(__functionAddress);
/*     */     }
/* 489 */     JNI.invokePPPV(buffer, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBuffer3i(@NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer value1, @NativeType("ALint *") IntBuffer value2, @NativeType("ALint *") IntBuffer value3) {
/* 495 */     if (Checks.CHECKS) {
/* 496 */       Checks.check(value1, 1);
/* 497 */       Checks.check(value2, 1);
/* 498 */       Checks.check(value3, 1);
/*     */     } 
/* 500 */     nalGetBuffer3i(buffer, param, MemoryUtil.memAddress(value1), MemoryUtil.memAddress(value2), MemoryUtil.memAddress(value3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBuffer3iDirect(long context, int buffer, int param, long value1, long value2, long value3) {
/* 507 */     long __functionAddress = (AL.getICD()).alGetBuffer3iDirect;
/* 508 */     if (Checks.CHECKS) {
/* 509 */       Checks.check(__functionAddress);
/* 510 */       Checks.check(context);
/*     */     } 
/* 512 */     JNI.invokePPPPV(context, buffer, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBuffer3iDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer value1, @NativeType("ALint *") IntBuffer value2, @NativeType("ALint *") IntBuffer value3) {
/* 518 */     if (Checks.CHECKS) {
/* 519 */       Checks.check(value1, 1);
/* 520 */       Checks.check(value2, 1);
/* 521 */       Checks.check(value3, 1);
/*     */     } 
/* 523 */     nalGetBuffer3iDirect(context, buffer, param, MemoryUtil.memAddress(value1), MemoryUtil.memAddress(value2), MemoryUtil.memAddress(value3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBufferiv(int buffer, int param, long values) {
/* 530 */     long __functionAddress = (AL.getICD()).alGetBufferiv;
/* 531 */     if (Checks.CHECKS) {
/* 532 */       Checks.check(__functionAddress);
/*     */     }
/* 534 */     JNI.invokePV(buffer, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBufferiv(@NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer values) {
/* 540 */     if (Checks.CHECKS) {
/* 541 */       Checks.check(values, 1);
/*     */     }
/* 543 */     nalGetBufferiv(buffer, param, MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBufferivDirect(long context, int buffer, int param, long values) {
/* 550 */     long __functionAddress = (AL.getICD()).alGetBufferivDirect;
/* 551 */     if (Checks.CHECKS) {
/* 552 */       Checks.check(__functionAddress);
/* 553 */       Checks.check(context);
/*     */     } 
/* 555 */     JNI.invokePPV(context, buffer, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBufferivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer values) {
/* 561 */     if (Checks.CHECKS) {
/* 562 */       Checks.check(values, 1);
/*     */     }
/* 564 */     nalGetBufferivDirect(context, buffer, param, MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBuffer3f(int buffer, int param, long value1, long value2, long value3) {
/* 571 */     long __functionAddress = (AL.getICD()).alGetBuffer3f;
/* 572 */     if (Checks.CHECKS) {
/* 573 */       Checks.check(__functionAddress);
/*     */     }
/* 575 */     JNI.invokePPPV(buffer, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBuffer3f(@NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer value1, @NativeType("ALfloat *") FloatBuffer value2, @NativeType("ALfloat *") FloatBuffer value3) {
/* 581 */     if (Checks.CHECKS) {
/* 582 */       Checks.check(value1, 1);
/* 583 */       Checks.check(value2, 1);
/* 584 */       Checks.check(value3, 1);
/*     */     } 
/* 586 */     nalGetBuffer3f(buffer, param, MemoryUtil.memAddress(value1), MemoryUtil.memAddress(value2), MemoryUtil.memAddress(value3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBuffer3fDirect(long context, int buffer, int param, long value1, long value2, long value3) {
/* 593 */     long __functionAddress = (AL.getICD()).alGetBuffer3fDirect;
/* 594 */     if (Checks.CHECKS) {
/* 595 */       Checks.check(__functionAddress);
/* 596 */       Checks.check(context);
/*     */     } 
/* 598 */     JNI.invokePPPPV(context, buffer, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBuffer3fDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer value1, @NativeType("ALfloat *") FloatBuffer value2, @NativeType("ALfloat *") FloatBuffer value3) {
/* 604 */     if (Checks.CHECKS) {
/* 605 */       Checks.check(value1, 1);
/* 606 */       Checks.check(value2, 1);
/* 607 */       Checks.check(value3, 1);
/*     */     } 
/* 609 */     nalGetBuffer3fDirect(context, buffer, param, MemoryUtil.memAddress(value1), MemoryUtil.memAddress(value2), MemoryUtil.memAddress(value3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBufferfv(int buffer, int param, long values) {
/* 616 */     long __functionAddress = (AL.getICD()).alGetBufferfv;
/* 617 */     if (Checks.CHECKS) {
/* 618 */       Checks.check(__functionAddress);
/*     */     }
/* 620 */     JNI.invokePV(buffer, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBufferfv(@NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer values) {
/* 626 */     if (Checks.CHECKS) {
/* 627 */       Checks.check(values, 1);
/*     */     }
/* 629 */     nalGetBufferfv(buffer, param, MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBufferfvDirect(long context, int buffer, int param, long values) {
/* 636 */     long __functionAddress = (AL.getICD()).alGetBufferfvDirect;
/* 637 */     if (Checks.CHECKS) {
/* 638 */       Checks.check(__functionAddress);
/* 639 */       Checks.check(context);
/*     */     } 
/* 641 */     JNI.invokePPV(context, buffer, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBufferfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer values) {
/* 647 */     if (Checks.CHECKS) {
/* 648 */       Checks.check(values, 1);
/*     */     }
/* 650 */     nalGetBufferfvDirect(context, buffer, param, MemoryUtil.memAddress(values));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSpeedOfSound(@NativeType("ALfloat") float value) {
/* 658 */     long __functionAddress = (AL.getICD()).alSpeedOfSound;
/* 659 */     if (Checks.CHECKS) {
/* 660 */       Checks.check(__functionAddress);
/*     */     }
/* 662 */     JNI.invokeV(value, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSpeedOfSoundDirect(@NativeType("ALCcontext *") long context, @NativeType("ALfloat") float value) {
/* 670 */     long __functionAddress = (AL.getICD()).alSpeedOfSoundDirect;
/* 671 */     if (Checks.CHECKS) {
/* 672 */       Checks.check(__functionAddress);
/* 673 */       Checks.check(context);
/*     */     } 
/* 675 */     JNI.invokePV(context, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetListener3i(@NativeType("ALenum") int param, @NativeType("ALint *") int[] value1, @NativeType("ALint *") int[] value2, @NativeType("ALint *") int[] value3) {
/* 681 */     long __functionAddress = (AL.getICD()).alGetListener3i;
/* 682 */     if (Checks.CHECKS) {
/* 683 */       Checks.check(__functionAddress);
/* 684 */       Checks.check(value1, 1);
/* 685 */       Checks.check(value2, 1);
/* 686 */       Checks.check(value3, 1);
/*     */     } 
/* 688 */     JNI.invokePPPV(param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetListener3iDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int param, @NativeType("ALint *") int[] value1, @NativeType("ALint *") int[] value2, @NativeType("ALint *") int[] value3) {
/* 694 */     long __functionAddress = (AL.getICD()).alGetListener3iDirect;
/* 695 */     if (Checks.CHECKS) {
/* 696 */       Checks.check(__functionAddress);
/* 697 */       Checks.check(context);
/* 698 */       Checks.check(value1, 1);
/* 699 */       Checks.check(value2, 1);
/* 700 */       Checks.check(value3, 1);
/*     */     } 
/* 702 */     JNI.invokePPPPV(context, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetListeneriv(@NativeType("ALenum") int param, @NativeType("ALint *") int[] values) {
/* 708 */     long __functionAddress = (AL.getICD()).alGetListeneriv;
/* 709 */     if (Checks.CHECKS) {
/* 710 */       Checks.check(__functionAddress);
/* 711 */       Checks.check(values, 1);
/*     */     } 
/* 713 */     JNI.invokePV(param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetListenerivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int param, @NativeType("ALint *") int[] values) {
/* 719 */     long __functionAddress = (AL.getICD()).alGetListenerivDirect;
/* 720 */     if (Checks.CHECKS) {
/* 721 */       Checks.check(__functionAddress);
/* 722 */       Checks.check(context);
/* 723 */       Checks.check(values, 1);
/*     */     } 
/* 725 */     JNI.invokePPV(context, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSource3i(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint *") int[] value1, @NativeType("ALint *") int[] value2, @NativeType("ALint *") int[] value3) {
/* 731 */     long __functionAddress = (AL.getICD()).alGetSource3i;
/* 732 */     if (Checks.CHECKS) {
/* 733 */       Checks.check(__functionAddress);
/* 734 */       Checks.check(value1, 1);
/* 735 */       Checks.check(value2, 1);
/* 736 */       Checks.check(value3, 1);
/*     */     } 
/* 738 */     JNI.invokePPPV(source, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetSource3iDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint *") int[] value1, @NativeType("ALint *") int[] value2, @NativeType("ALint *") int[] value3) {
/* 744 */     long __functionAddress = (AL.getICD()).alGetSource3iDirect;
/* 745 */     if (Checks.CHECKS) {
/* 746 */       Checks.check(__functionAddress);
/* 747 */       Checks.check(context);
/* 748 */       Checks.check(value1, 1);
/* 749 */       Checks.check(value2, 1);
/* 750 */       Checks.check(value3, 1);
/*     */     } 
/* 752 */     JNI.invokePPPPV(context, source, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alListeneriv(@NativeType("ALenum") int listener, @NativeType("ALint const *") int[] value) {
/* 758 */     long __functionAddress = (AL.getICD()).alListeneriv;
/* 759 */     if (Checks.CHECKS) {
/* 760 */       Checks.check(__functionAddress);
/* 761 */       Checks.check(value, 1);
/*     */     } 
/* 763 */     JNI.invokePV(listener, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alListenerivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int listener, @NativeType("ALint const *") int[] value) {
/* 769 */     long __functionAddress = (AL.getICD()).alListenerivDirect;
/* 770 */     if (Checks.CHECKS) {
/* 771 */       Checks.check(__functionAddress);
/* 772 */       Checks.check(context);
/* 773 */       Checks.check(value, 1);
/*     */     } 
/* 775 */     JNI.invokePPV(context, listener, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourceiv(@NativeType("ALuint") int source, @NativeType("ALenum") int paramName, @NativeType("ALint const *") int[] value) {
/* 781 */     long __functionAddress = (AL.getICD()).alSourceiv;
/* 782 */     if (Checks.CHECKS) {
/* 783 */       Checks.check(__functionAddress);
/* 784 */       Checks.check(value, 1);
/*     */     } 
/* 786 */     JNI.invokePV(source, paramName, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alSourceivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int paramName, @NativeType("ALint const *") int[] value) {
/* 792 */     long __functionAddress = (AL.getICD()).alSourceivDirect;
/* 793 */     if (Checks.CHECKS) {
/* 794 */       Checks.check(__functionAddress);
/* 795 */       Checks.check(context);
/* 796 */       Checks.check(value, 1);
/*     */     } 
/* 798 */     JNI.invokePPV(context, source, paramName, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferfv(@NativeType("ALuint") int buffer, @NativeType("ALenum") int paramName, @NativeType("ALfloat const *") float[] value) {
/* 804 */     long __functionAddress = (AL.getICD()).alBufferfv;
/* 805 */     if (Checks.CHECKS) {
/* 806 */       Checks.check(__functionAddress);
/* 807 */       Checks.check(value, 1);
/*     */     } 
/* 809 */     JNI.invokePV(buffer, paramName, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int paramName, @NativeType("ALfloat const *") float[] value) {
/* 815 */     long __functionAddress = (AL.getICD()).alBufferfvDirect;
/* 816 */     if (Checks.CHECKS) {
/* 817 */       Checks.check(__functionAddress);
/* 818 */       Checks.check(context);
/* 819 */       Checks.check(value, 1);
/*     */     } 
/* 821 */     JNI.invokePPV(context, buffer, paramName, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferiv(@NativeType("ALuint") int buffer, @NativeType("ALenum") int paramName, @NativeType("ALint const *") int[] value) {
/* 827 */     long __functionAddress = (AL.getICD()).alBufferiv;
/* 828 */     if (Checks.CHECKS) {
/* 829 */       Checks.check(__functionAddress);
/* 830 */       Checks.check(value, 1);
/*     */     } 
/* 832 */     JNI.invokePV(buffer, paramName, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int paramName, @NativeType("ALint const *") int[] value) {
/* 838 */     long __functionAddress = (AL.getICD()).alBufferivDirect;
/* 839 */     if (Checks.CHECKS) {
/* 840 */       Checks.check(__functionAddress);
/* 841 */       Checks.check(context);
/* 842 */       Checks.check(value, 1);
/*     */     } 
/* 844 */     JNI.invokePPV(context, buffer, paramName, value, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBuffer3i(@NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALint *") int[] value1, @NativeType("ALint *") int[] value2, @NativeType("ALint *") int[] value3) {
/* 850 */     long __functionAddress = (AL.getICD()).alGetBuffer3i;
/* 851 */     if (Checks.CHECKS) {
/* 852 */       Checks.check(__functionAddress);
/* 853 */       Checks.check(value1, 1);
/* 854 */       Checks.check(value2, 1);
/* 855 */       Checks.check(value3, 1);
/*     */     } 
/* 857 */     JNI.invokePPPV(buffer, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBuffer3iDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALint *") int[] value1, @NativeType("ALint *") int[] value2, @NativeType("ALint *") int[] value3) {
/* 863 */     long __functionAddress = (AL.getICD()).alGetBuffer3iDirect;
/* 864 */     if (Checks.CHECKS) {
/* 865 */       Checks.check(__functionAddress);
/* 866 */       Checks.check(context);
/* 867 */       Checks.check(value1, 1);
/* 868 */       Checks.check(value2, 1);
/* 869 */       Checks.check(value3, 1);
/*     */     } 
/* 871 */     JNI.invokePPPPV(context, buffer, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBufferiv(@NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALint *") int[] values) {
/* 877 */     long __functionAddress = (AL.getICD()).alGetBufferiv;
/* 878 */     if (Checks.CHECKS) {
/* 879 */       Checks.check(__functionAddress);
/* 880 */       Checks.check(values, 1);
/*     */     } 
/* 882 */     JNI.invokePV(buffer, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBufferivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALint *") int[] values) {
/* 888 */     long __functionAddress = (AL.getICD()).alGetBufferivDirect;
/* 889 */     if (Checks.CHECKS) {
/* 890 */       Checks.check(__functionAddress);
/* 891 */       Checks.check(context);
/* 892 */       Checks.check(values, 1);
/*     */     } 
/* 894 */     JNI.invokePPV(context, buffer, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBuffer3f(@NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] value1, @NativeType("ALfloat *") float[] value2, @NativeType("ALfloat *") float[] value3) {
/* 900 */     long __functionAddress = (AL.getICD()).alGetBuffer3f;
/* 901 */     if (Checks.CHECKS) {
/* 902 */       Checks.check(__functionAddress);
/* 903 */       Checks.check(value1, 1);
/* 904 */       Checks.check(value2, 1);
/* 905 */       Checks.check(value3, 1);
/*     */     } 
/* 907 */     JNI.invokePPPV(buffer, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBuffer3fDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] value1, @NativeType("ALfloat *") float[] value2, @NativeType("ALfloat *") float[] value3) {
/* 913 */     long __functionAddress = (AL.getICD()).alGetBuffer3fDirect;
/* 914 */     if (Checks.CHECKS) {
/* 915 */       Checks.check(__functionAddress);
/* 916 */       Checks.check(context);
/* 917 */       Checks.check(value1, 1);
/* 918 */       Checks.check(value2, 1);
/* 919 */       Checks.check(value3, 1);
/*     */     } 
/* 921 */     JNI.invokePPPPV(context, buffer, param, value1, value2, value3, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBufferfv(@NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] values) {
/* 927 */     long __functionAddress = (AL.getICD()).alGetBufferfv;
/* 928 */     if (Checks.CHECKS) {
/* 929 */       Checks.check(__functionAddress);
/* 930 */       Checks.check(values, 1);
/*     */     } 
/* 932 */     JNI.invokePV(buffer, param, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBufferfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] values) {
/* 938 */     long __functionAddress = (AL.getICD()).alGetBufferfvDirect;
/* 939 */     if (Checks.CHECKS) {
/* 940 */       Checks.check(__functionAddress);
/* 941 */       Checks.check(context);
/* 942 */       Checks.check(values, 1);
/*     */     } 
/* 944 */     JNI.invokePPV(context, buffer, param, values, __functionAddress);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\AL11.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */