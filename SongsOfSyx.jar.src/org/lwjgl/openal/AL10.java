/*      */ package org.lwjgl.openal;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class AL10
/*      */ {
/*      */   public static final int AL_INVALID = -1;
/*      */   public static final int AL_NONE = 0;
/*      */   public static final int AL_FALSE = 0;
/*      */   public static final int AL_TRUE = 1;
/*      */   public static final int AL_NO_ERROR = 0;
/*      */   public static final int AL_INVALID_NAME = 40961;
/*      */   public static final int AL_INVALID_ENUM = 40962;
/*      */   public static final int AL_INVALID_VALUE = 40963;
/*      */   public static final int AL_INVALID_OPERATION = 40964;
/*      */   public static final int AL_OUT_OF_MEMORY = 40965;
/*      */   public static final int AL_DOPPLER_FACTOR = 49152;
/*      */   public static final int AL_DISTANCE_MODEL = 53248;
/*      */   public static final int AL_VENDOR = 45057;
/*      */   public static final int AL_VERSION = 45058;
/*      */   public static final int AL_RENDERER = 45059;
/*      */   public static final int AL_EXTENSIONS = 45060;
/*      */   public static final int AL_INVERSE_DISTANCE = 53249;
/*      */   public static final int AL_INVERSE_DISTANCE_CLAMPED = 53250;
/*      */   public static final int AL_SOURCE_ABSOLUTE = 513;
/*      */   public static final int AL_SOURCE_RELATIVE = 514;
/*      */   public static final int AL_POSITION = 4100;
/*      */   public static final int AL_VELOCITY = 4102;
/*      */   public static final int AL_GAIN = 4106;
/*      */   public static final int AL_CONE_INNER_ANGLE = 4097;
/*      */   public static final int AL_CONE_OUTER_ANGLE = 4098;
/*      */   public static final int AL_PITCH = 4099;
/*      */   public static final int AL_DIRECTION = 4101;
/*      */   public static final int AL_LOOPING = 4103;
/*      */   public static final int AL_BUFFER = 4105;
/*      */   public static final int AL_SOURCE_STATE = 4112;
/*      */   public static final int AL_CONE_OUTER_GAIN = 4130;
/*      */   public static final int AL_SOURCE_TYPE = 4135;
/*      */   public static final int AL_INITIAL = 4113;
/*      */   public static final int AL_PLAYING = 4114;
/*      */   public static final int AL_PAUSED = 4115;
/*      */   public static final int AL_STOPPED = 4116;
/*      */   public static final int AL_ORIENTATION = 4111;
/*      */   public static final int AL_BUFFERS_QUEUED = 4117;
/*      */   public static final int AL_BUFFERS_PROCESSED = 4118;
/*      */   public static final int AL_MIN_GAIN = 4109;
/*      */   public static final int AL_MAX_GAIN = 4110;
/*      */   public static final int AL_REFERENCE_DISTANCE = 4128;
/*      */   public static final int AL_ROLLOFF_FACTOR = 4129;
/*      */   public static final int AL_MAX_DISTANCE = 4131;
/*      */   public static final int AL_FREQUENCY = 8193;
/*      */   public static final int AL_BITS = 8194;
/*      */   public static final int AL_CHANNELS = 8195;
/*      */   public static final int AL_SIZE = 8196;
/*      */   public static final int AL_FORMAT_MONO8 = 4352;
/*      */   public static final int AL_FORMAT_MONO16 = 4353;
/*      */   public static final int AL_FORMAT_STEREO8 = 4354;
/*      */   public static final int AL_FORMAT_STEREO16 = 4355;
/*      */   public static final int AL_UNUSED = 8208;
/*      */   public static final int AL_PENDING = 8209;
/*      */   public static final int AL_PROCESSED = 8210;
/*      */   
/*      */   protected AL10() {
/*  108 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALenum")
/*      */   public static int alGetError() {
/*  116 */     long __functionAddress = (AL.getICD()).alGetError;
/*  117 */     return JNI.invokeI(__functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALenum")
/*      */   public static int alGetErrorDirect(@NativeType("ALCcontext *") long context) {
/*  125 */     long __functionAddress = (AL.getICD()).alGetErrorDirect;
/*  126 */     if (Checks.CHECKS) {
/*  127 */       Checks.check(__functionAddress);
/*  128 */       Checks.check(context);
/*      */     } 
/*  130 */     return JNI.invokePI(context, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEnable(@NativeType("ALenum") int target) {
/*  138 */     long __functionAddress = (AL.getICD()).alEnable;
/*  139 */     JNI.invokeV(target, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alEnableDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int target) {
/*  147 */     long __functionAddress = (AL.getICD()).alEnableDirect;
/*  148 */     if (Checks.CHECKS) {
/*  149 */       Checks.check(__functionAddress);
/*  150 */       Checks.check(context);
/*      */     } 
/*  152 */     JNI.invokePV(context, target, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDisable(@NativeType("ALenum") int target) {
/*  160 */     long __functionAddress = (AL.getICD()).alDisable;
/*  161 */     JNI.invokeV(target, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDisableDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int target) {
/*  169 */     long __functionAddress = (AL.getICD()).alDisableDirect;
/*  170 */     if (Checks.CHECKS) {
/*  171 */       Checks.check(__functionAddress);
/*  172 */       Checks.check(context);
/*      */     } 
/*  174 */     JNI.invokePV(context, target, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alIsEnabled(@NativeType("ALenum") int target) {
/*  182 */     long __functionAddress = (AL.getICD()).alIsEnabled;
/*  183 */     return JNI.invokeZ(target, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alIsEnabledDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int target) {
/*  191 */     long __functionAddress = (AL.getICD()).alIsEnabledDirect;
/*  192 */     if (Checks.CHECKS) {
/*  193 */       Checks.check(__functionAddress);
/*  194 */       Checks.check(context);
/*      */     } 
/*  196 */     return JNI.invokePZ(context, target, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alGetBoolean(@NativeType("ALenum") int paramName) {
/*  204 */     long __functionAddress = (AL.getICD()).alGetBoolean;
/*  205 */     return JNI.invokeZ(paramName, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alGetBooleanDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName) {
/*  213 */     long __functionAddress = (AL.getICD()).alGetBooleanDirect;
/*  214 */     if (Checks.CHECKS) {
/*  215 */       Checks.check(__functionAddress);
/*  216 */       Checks.check(context);
/*      */     } 
/*  218 */     return JNI.invokePZ(context, paramName, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALint")
/*      */   public static int alGetInteger(@NativeType("ALenum") int paramName) {
/*  226 */     long __functionAddress = (AL.getICD()).alGetInteger;
/*  227 */     return JNI.invokeI(paramName, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALint")
/*      */   public static int alGetIntegerDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName) {
/*  235 */     long __functionAddress = (AL.getICD()).alGetIntegerDirect;
/*  236 */     if (Checks.CHECKS) {
/*  237 */       Checks.check(__functionAddress);
/*  238 */       Checks.check(context);
/*      */     } 
/*  240 */     return JNI.invokePI(context, paramName, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALfloat")
/*      */   public static float alGetFloat(@NativeType("ALenum") int paramName) {
/*  248 */     long __functionAddress = (AL.getICD()).alGetFloat;
/*  249 */     return JNI.invokeF(paramName, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALfloat")
/*      */   public static float alGetFloatDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName) {
/*  257 */     long __functionAddress = (AL.getICD()).alGetFloatDirect;
/*  258 */     if (Checks.CHECKS) {
/*  259 */       Checks.check(__functionAddress);
/*  260 */       Checks.check(context);
/*      */     } 
/*  262 */     return JNI.invokePF(context, paramName, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALdouble")
/*      */   public static double alGetDouble(@NativeType("ALenum") int paramName) {
/*  270 */     long __functionAddress = (AL.getICD()).alGetDouble;
/*  271 */     return JNI.invokeD(paramName, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALdouble")
/*      */   public static double alGetDoubleDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName) {
/*  279 */     long __functionAddress = (AL.getICD()).alGetDoubleDirect;
/*  280 */     if (Checks.CHECKS) {
/*  281 */       Checks.check(__functionAddress);
/*  282 */       Checks.check(context);
/*      */     } 
/*  284 */     return JNI.invokePD(context, paramName, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetBooleanv(int paramName, long dest) {
/*  291 */     long __functionAddress = (AL.getICD()).alGetBooleanv;
/*  292 */     JNI.invokePV(paramName, dest, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetBooleanv(@NativeType("ALenum") int paramName, @NativeType("ALboolean *") ByteBuffer dest) {
/*  298 */     if (Checks.CHECKS) {
/*  299 */       Checks.check(dest, 1);
/*      */     }
/*  301 */     nalGetBooleanv(paramName, MemoryUtil.memAddress(dest));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetBooleanvDirect(long context, int paramName, long dest) {
/*  308 */     long __functionAddress = (AL.getICD()).alGetBooleanvDirect;
/*  309 */     if (Checks.CHECKS) {
/*  310 */       Checks.check(__functionAddress);
/*  311 */       Checks.check(context);
/*      */     } 
/*  313 */     JNI.invokePPV(context, paramName, dest, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetBooleanvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALboolean *") ByteBuffer dest) {
/*  319 */     if (Checks.CHECKS) {
/*  320 */       Checks.check(dest, 1);
/*      */     }
/*  322 */     nalGetBooleanvDirect(context, paramName, MemoryUtil.memAddress(dest));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetIntegerv(int paramName, long dest) {
/*  329 */     long __functionAddress = (AL.getICD()).alGetIntegerv;
/*  330 */     JNI.invokePV(paramName, dest, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetIntegerv(@NativeType("ALenum") int paramName, @NativeType("ALint *") IntBuffer dest) {
/*  336 */     if (Checks.CHECKS) {
/*  337 */       Checks.check(dest, 1);
/*      */     }
/*  339 */     nalGetIntegerv(paramName, MemoryUtil.memAddress(dest));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetIntegervDirect(long context, int paramName, long dest) {
/*  346 */     long __functionAddress = (AL.getICD()).alGetIntegervDirect;
/*  347 */     if (Checks.CHECKS) {
/*  348 */       Checks.check(__functionAddress);
/*  349 */       Checks.check(context);
/*      */     } 
/*  351 */     JNI.invokePPV(context, paramName, dest, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetIntegervDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALint *") IntBuffer dest) {
/*  357 */     if (Checks.CHECKS) {
/*  358 */       Checks.check(dest, 1);
/*      */     }
/*  360 */     nalGetIntegervDirect(context, paramName, MemoryUtil.memAddress(dest));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetFloatv(int paramName, long dest) {
/*  367 */     long __functionAddress = (AL.getICD()).alGetFloatv;
/*  368 */     JNI.invokePV(paramName, dest, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFloatv(@NativeType("ALenum") int paramName, @NativeType("ALfloat *") FloatBuffer dest) {
/*  374 */     if (Checks.CHECKS) {
/*  375 */       Checks.check(dest, 1);
/*      */     }
/*  377 */     nalGetFloatv(paramName, MemoryUtil.memAddress(dest));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetFloatvDirect(long context, int paramName, long dest) {
/*  384 */     long __functionAddress = (AL.getICD()).alGetFloatvDirect;
/*  385 */     if (Checks.CHECKS) {
/*  386 */       Checks.check(__functionAddress);
/*  387 */       Checks.check(context);
/*      */     } 
/*  389 */     JNI.invokePPV(context, paramName, dest, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFloatvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALfloat *") FloatBuffer dest) {
/*  395 */     if (Checks.CHECKS) {
/*  396 */       Checks.check(dest, 1);
/*      */     }
/*  398 */     nalGetFloatvDirect(context, paramName, MemoryUtil.memAddress(dest));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetDoublev(int paramName, long dest) {
/*  405 */     long __functionAddress = (AL.getICD()).alGetDoublev;
/*  406 */     JNI.invokePV(paramName, dest, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetDoublev(@NativeType("ALenum") int paramName, @NativeType("ALdouble *") DoubleBuffer dest) {
/*  412 */     if (Checks.CHECKS) {
/*  413 */       Checks.check(dest, 1);
/*      */     }
/*  415 */     nalGetDoublev(paramName, MemoryUtil.memAddress(dest));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetDoublevDirect(long context, int paramName, long dest) {
/*  422 */     long __functionAddress = (AL.getICD()).alGetDoublevDirect;
/*  423 */     if (Checks.CHECKS) {
/*  424 */       Checks.check(__functionAddress);
/*  425 */       Checks.check(context);
/*      */     } 
/*  427 */     JNI.invokePPV(context, paramName, dest, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetDoublevDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALdouble *") DoubleBuffer dest) {
/*  433 */     if (Checks.CHECKS) {
/*  434 */       Checks.check(dest, 1);
/*      */     }
/*  436 */     nalGetDoublevDirect(context, paramName, MemoryUtil.memAddress(dest));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nalGetString(int paramName) {
/*  443 */     long __functionAddress = (AL.getICD()).alGetString;
/*  444 */     return JNI.invokeP(paramName, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALchar const *")
/*      */   public static String alGetString(@NativeType("ALenum") int paramName) {
/*  450 */     long __result = nalGetString(paramName);
/*  451 */     return MemoryUtil.memUTF8Safe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nalGetStringDirect(long context, int paramName) {
/*  458 */     long __functionAddress = (AL.getICD()).alGetStringDirect;
/*  459 */     if (Checks.CHECKS) {
/*  460 */       Checks.check(__functionAddress);
/*  461 */       Checks.check(context);
/*      */     } 
/*  463 */     return JNI.invokePP(context, paramName, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALchar const *")
/*      */   public static String alGetStringDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName) {
/*  469 */     long __result = nalGetStringDirect(context, paramName);
/*  470 */     return MemoryUtil.memUTF8Safe(__result);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDistanceModel(@NativeType("ALenum") int modelName) {
/*  478 */     long __functionAddress = (AL.getICD()).alDistanceModel;
/*  479 */     JNI.invokeV(modelName, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDistanceModelDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int modelName) {
/*  487 */     long __functionAddress = (AL.getICD()).alDistanceModelDirect;
/*  488 */     if (Checks.CHECKS) {
/*  489 */       Checks.check(__functionAddress);
/*  490 */       Checks.check(context);
/*      */     } 
/*  492 */     JNI.invokePV(context, modelName, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDopplerFactor(@NativeType("ALfloat") float dopplerFactor) {
/*  500 */     long __functionAddress = (AL.getICD()).alDopplerFactor;
/*  501 */     JNI.invokeV(dopplerFactor, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDopplerFactorDirect(@NativeType("ALCcontext *") long context, @NativeType("ALfloat") float dopplerFactor) {
/*  509 */     long __functionAddress = (AL.getICD()).alDopplerFactorDirect;
/*  510 */     if (Checks.CHECKS) {
/*  511 */       Checks.check(__functionAddress);
/*  512 */       Checks.check(context);
/*      */     } 
/*  514 */     JNI.invokePV(context, dopplerFactor, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDopplerVelocity(@NativeType("ALfloat") float dopplerVelocity) {
/*  522 */     long __functionAddress = (AL.getICD()).alDopplerVelocity;
/*  523 */     JNI.invokeV(dopplerVelocity, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alListenerf(@NativeType("ALenum") int paramName, @NativeType("ALfloat") float value) {
/*  531 */     long __functionAddress = (AL.getICD()).alListenerf;
/*  532 */     JNI.invokeV(paramName, value, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alListenerfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALfloat") float value) {
/*  540 */     long __functionAddress = (AL.getICD()).alListenerfDirect;
/*  541 */     if (Checks.CHECKS) {
/*  542 */       Checks.check(__functionAddress);
/*  543 */       Checks.check(context);
/*      */     } 
/*  545 */     JNI.invokePV(context, paramName, value, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alListeneri(@NativeType("ALenum") int paramName, @NativeType("ALint") int values) {
/*  553 */     long __functionAddress = (AL.getICD()).alListeneri;
/*  554 */     JNI.invokeV(paramName, values, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alListeneriDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALint") int values) {
/*  562 */     long __functionAddress = (AL.getICD()).alListeneriDirect;
/*  563 */     if (Checks.CHECKS) {
/*  564 */       Checks.check(__functionAddress);
/*  565 */       Checks.check(context);
/*      */     } 
/*  567 */     JNI.invokePV(context, paramName, values, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alListener3f(@NativeType("ALenum") int paramName, @NativeType("ALfloat") float value1, @NativeType("ALfloat") float value2, @NativeType("ALfloat") float value3) {
/*  575 */     long __functionAddress = (AL.getICD()).alListener3f;
/*  576 */     JNI.invokeV(paramName, value1, value2, value3, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alListener3fDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALfloat") float value1, @NativeType("ALfloat") float value2, @NativeType("ALfloat") float value3) {
/*  584 */     long __functionAddress = (AL.getICD()).alListener3fDirect;
/*  585 */     if (Checks.CHECKS) {
/*  586 */       Checks.check(__functionAddress);
/*  587 */       Checks.check(context);
/*      */     } 
/*  589 */     JNI.invokePV(context, paramName, value1, value2, value3, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalListenerfv(int paramName, long values) {
/*  596 */     long __functionAddress = (AL.getICD()).alListenerfv;
/*  597 */     JNI.invokePV(paramName, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alListenerfv(@NativeType("ALenum") int paramName, @NativeType("ALfloat const *") FloatBuffer values) {
/*  603 */     if (Checks.CHECKS) {
/*  604 */       Checks.check(values, 1);
/*      */     }
/*  606 */     nalListenerfv(paramName, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalListenerfvDirect(long context, int paramName, long values) {
/*  613 */     long __functionAddress = (AL.getICD()).alListenerfvDirect;
/*  614 */     if (Checks.CHECKS) {
/*  615 */       Checks.check(__functionAddress);
/*  616 */       Checks.check(context);
/*      */     } 
/*  618 */     JNI.invokePPV(context, paramName, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alListenerfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALfloat const *") FloatBuffer values) {
/*  624 */     if (Checks.CHECKS) {
/*  625 */       Checks.check(values, 1);
/*      */     }
/*  627 */     nalListenerfvDirect(context, paramName, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetListenerf(int paramName, long value) {
/*  634 */     long __functionAddress = (AL.getICD()).alGetListenerf;
/*  635 */     JNI.invokePV(paramName, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListenerf(@NativeType("ALenum") int paramName, @NativeType("ALfloat *") FloatBuffer value) {
/*  641 */     if (Checks.CHECKS) {
/*  642 */       Checks.check(value, 1);
/*      */     }
/*  644 */     nalGetListenerf(paramName, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static float alGetListenerf(@NativeType("ALenum") int paramName) {
/*  650 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  652 */       FloatBuffer value = stack.callocFloat(1);
/*  653 */       nalGetListenerf(paramName, MemoryUtil.memAddress(value));
/*  654 */       return value.get(0);
/*      */     } finally {
/*  656 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetListenerfDirect(long context, int paramName, long value) {
/*  664 */     long __functionAddress = (AL.getICD()).alGetListenerfDirect;
/*  665 */     if (Checks.CHECKS) {
/*  666 */       Checks.check(__functionAddress);
/*  667 */       Checks.check(context);
/*      */     } 
/*  669 */     JNI.invokePPV(context, paramName, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListenerfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALfloat *") FloatBuffer value) {
/*  675 */     if (Checks.CHECKS) {
/*  676 */       Checks.check(value, 1);
/*      */     }
/*  678 */     nalGetListenerfDirect(context, paramName, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static float alGetListenerfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName) {
/*  684 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  686 */       FloatBuffer value = stack.callocFloat(1);
/*  687 */       nalGetListenerfDirect(context, paramName, MemoryUtil.memAddress(value));
/*  688 */       return value.get(0);
/*      */     } finally {
/*  690 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetListeneri(int paramName, long value) {
/*  698 */     long __functionAddress = (AL.getICD()).alGetListeneri;
/*  699 */     JNI.invokePV(paramName, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListeneri(@NativeType("ALenum") int paramName, @NativeType("ALint *") IntBuffer value) {
/*  705 */     if (Checks.CHECKS) {
/*  706 */       Checks.check(value, 1);
/*      */     }
/*  708 */     nalGetListeneri(paramName, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGetListeneri(@NativeType("ALenum") int paramName) {
/*  714 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  716 */       IntBuffer value = stack.callocInt(1);
/*  717 */       nalGetListeneri(paramName, MemoryUtil.memAddress(value));
/*  718 */       return value.get(0);
/*      */     } finally {
/*  720 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetListeneriDirect(long context, int paramName, long value) {
/*  728 */     long __functionAddress = (AL.getICD()).alGetListeneriDirect;
/*  729 */     if (Checks.CHECKS) {
/*  730 */       Checks.check(__functionAddress);
/*  731 */       Checks.check(context);
/*      */     } 
/*  733 */     JNI.invokePPV(context, paramName, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListeneriDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALint *") IntBuffer value) {
/*  739 */     if (Checks.CHECKS) {
/*  740 */       Checks.check(value, 1);
/*      */     }
/*  742 */     nalGetListeneriDirect(context, paramName, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGetListeneriDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName) {
/*  748 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  750 */       IntBuffer value = stack.callocInt(1);
/*  751 */       nalGetListeneriDirect(context, paramName, MemoryUtil.memAddress(value));
/*  752 */       return value.get(0);
/*      */     } finally {
/*  754 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetListener3f(int paramName, long value1, long value2, long value3) {
/*  762 */     long __functionAddress = (AL.getICD()).alGetListener3f;
/*  763 */     JNI.invokePPPV(paramName, value1, value2, value3, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListener3f(@NativeType("ALenum") int paramName, @NativeType("ALfloat *") FloatBuffer value1, @NativeType("ALfloat *") FloatBuffer value2, @NativeType("ALfloat *") FloatBuffer value3) {
/*  769 */     if (Checks.CHECKS) {
/*  770 */       Checks.check(value1, 1);
/*  771 */       Checks.check(value2, 1);
/*  772 */       Checks.check(value3, 1);
/*      */     } 
/*  774 */     nalGetListener3f(paramName, MemoryUtil.memAddress(value1), MemoryUtil.memAddress(value2), MemoryUtil.memAddress(value3));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetListener3fDirect(long context, int paramName, long value1, long value2, long value3) {
/*  781 */     long __functionAddress = (AL.getICD()).alGetListener3fDirect;
/*  782 */     if (Checks.CHECKS) {
/*  783 */       Checks.check(__functionAddress);
/*  784 */       Checks.check(context);
/*      */     } 
/*  786 */     JNI.invokePPPPV(context, paramName, value1, value2, value3, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListener3fDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALfloat *") FloatBuffer value1, @NativeType("ALfloat *") FloatBuffer value2, @NativeType("ALfloat *") FloatBuffer value3) {
/*  792 */     if (Checks.CHECKS) {
/*  793 */       Checks.check(value1, 1);
/*  794 */       Checks.check(value2, 1);
/*  795 */       Checks.check(value3, 1);
/*      */     } 
/*  797 */     nalGetListener3fDirect(context, paramName, MemoryUtil.memAddress(value1), MemoryUtil.memAddress(value2), MemoryUtil.memAddress(value3));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetListenerfv(int paramName, long values) {
/*  804 */     long __functionAddress = (AL.getICD()).alGetListenerfv;
/*  805 */     JNI.invokePV(paramName, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListenerfv(@NativeType("ALenum") int paramName, @NativeType("ALfloat *") FloatBuffer values) {
/*  811 */     if (Checks.CHECKS) {
/*  812 */       Checks.check(values, 1);
/*      */     }
/*  814 */     nalGetListenerfv(paramName, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetListenerfvDirect(long context, int paramName, long values) {
/*  821 */     long __functionAddress = (AL.getICD()).alGetListenerfvDirect;
/*  822 */     if (Checks.CHECKS) {
/*  823 */       Checks.check(__functionAddress);
/*  824 */       Checks.check(context);
/*      */     } 
/*  826 */     JNI.invokePPV(context, paramName, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListenerfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALfloat *") FloatBuffer values) {
/*  832 */     if (Checks.CHECKS) {
/*  833 */       Checks.check(values, 1);
/*      */     }
/*  835 */     nalGetListenerfvDirect(context, paramName, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGenSources(int n, long srcNames) {
/*  842 */     long __functionAddress = (AL.getICD()).alGenSources;
/*  843 */     JNI.invokePV(n, srcNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenSources(@NativeType("ALuint *") IntBuffer srcNames) {
/*  849 */     nalGenSources(srcNames.remaining(), MemoryUtil.memAddress(srcNames));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGenSources() {
/*  855 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  857 */       IntBuffer srcNames = stack.callocInt(1);
/*  858 */       nalGenSources(1, MemoryUtil.memAddress(srcNames));
/*  859 */       return srcNames.get(0);
/*      */     } finally {
/*  861 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGenSourcesDirect(long context, int n, long srcNames) {
/*  869 */     long __functionAddress = (AL.getICD()).alGenSourcesDirect;
/*  870 */     if (Checks.CHECKS) {
/*  871 */       Checks.check(__functionAddress);
/*  872 */       Checks.check(context);
/*      */     } 
/*  874 */     JNI.invokePPV(context, n, srcNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenSourcesDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") IntBuffer srcNames) {
/*  880 */     nalGenSourcesDirect(context, srcNames.remaining(), MemoryUtil.memAddress(srcNames));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGenSourcesDirect(@NativeType("ALCcontext *") long context) {
/*  886 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  888 */       IntBuffer srcNames = stack.callocInt(1);
/*  889 */       nalGenSourcesDirect(context, 1, MemoryUtil.memAddress(srcNames));
/*  890 */       return srcNames.get(0);
/*      */     } finally {
/*  892 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalDeleteSources(int n, long sources) {
/*  900 */     long __functionAddress = (AL.getICD()).alDeleteSources;
/*  901 */     JNI.invokePV(n, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteSources(@NativeType("ALuint *") IntBuffer sources) {
/*  907 */     nalDeleteSources(sources.remaining(), MemoryUtil.memAddress(sources));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteSources(@NativeType("ALuint *") int source) {
/*  913 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  915 */       IntBuffer sources = stack.ints(source);
/*  916 */       nalDeleteSources(1, MemoryUtil.memAddress(sources));
/*      */     } finally {
/*  918 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalDeleteSourcesDirect(long context, int n, long sources) {
/*  926 */     long __functionAddress = (AL.getICD()).alDeleteSourcesDirect;
/*  927 */     if (Checks.CHECKS) {
/*  928 */       Checks.check(__functionAddress);
/*  929 */       Checks.check(context);
/*      */     } 
/*  931 */     JNI.invokePPV(context, n, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteSourcesDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") IntBuffer sources) {
/*  937 */     nalDeleteSourcesDirect(context, sources.remaining(), MemoryUtil.memAddress(sources));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteSourcesDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") int source) {
/*  943 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/*  945 */       IntBuffer sources = stack.ints(source);
/*  946 */       nalDeleteSourcesDirect(context, 1, MemoryUtil.memAddress(sources));
/*      */     } finally {
/*  948 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alIsSource(@NativeType("ALuint") int sourceName) {
/*  957 */     long __functionAddress = (AL.getICD()).alIsSource;
/*  958 */     return JNI.invokeZ(sourceName, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alIsSourceDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int sourceName) {
/*  966 */     long __functionAddress = (AL.getICD()).alIsSourceDirect;
/*  967 */     if (Checks.CHECKS) {
/*  968 */       Checks.check(__functionAddress);
/*  969 */       Checks.check(context);
/*      */     } 
/*  971 */     return JNI.invokePZ(context, sourceName, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcef(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat") float value) {
/*  979 */     long __functionAddress = (AL.getICD()).alSourcef;
/*  980 */     JNI.invokeV(source, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcefDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat") float value) {
/*  988 */     long __functionAddress = (AL.getICD()).alSourcefDirect;
/*  989 */     if (Checks.CHECKS) {
/*  990 */       Checks.check(__functionAddress);
/*  991 */       Checks.check(context);
/*      */     } 
/*  993 */     JNI.invokePV(context, source, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSource3f(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat") float v1, @NativeType("ALfloat") float v2, @NativeType("ALfloat") float v3) {
/* 1001 */     long __functionAddress = (AL.getICD()).alSource3f;
/* 1002 */     JNI.invokeV(source, param, v1, v2, v3, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSource3fDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat") float v1, @NativeType("ALfloat") float v2, @NativeType("ALfloat") float v3) {
/* 1010 */     long __functionAddress = (AL.getICD()).alSource3fDirect;
/* 1011 */     if (Checks.CHECKS) {
/* 1012 */       Checks.check(__functionAddress);
/* 1013 */       Checks.check(context);
/*      */     } 
/* 1015 */     JNI.invokePV(context, source, param, v1, v2, v3, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourcefv(int source, int param, long values) {
/* 1022 */     long __functionAddress = (AL.getICD()).alSourcefv;
/* 1023 */     JNI.invokePV(source, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcefv(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat const *") FloatBuffer values) {
/* 1029 */     if (Checks.CHECKS) {
/* 1030 */       Checks.check(values, 1);
/*      */     }
/* 1032 */     nalSourcefv(source, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourcefvDirect(long context, int source, int param, long values) {
/* 1039 */     long __functionAddress = (AL.getICD()).alSourcefvDirect;
/* 1040 */     if (Checks.CHECKS) {
/* 1041 */       Checks.check(__functionAddress);
/* 1042 */       Checks.check(context);
/*      */     } 
/* 1044 */     JNI.invokePPV(context, source, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcefvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat const *") FloatBuffer values) {
/* 1050 */     if (Checks.CHECKS) {
/* 1051 */       Checks.check(values, 1);
/*      */     }
/* 1053 */     nalSourcefvDirect(context, source, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcei(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint") int value) {
/* 1061 */     long __functionAddress = (AL.getICD()).alSourcei;
/* 1062 */     JNI.invokeV(source, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceiDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint") int value) {
/* 1070 */     long __functionAddress = (AL.getICD()).alSourceiDirect;
/* 1071 */     if (Checks.CHECKS) {
/* 1072 */       Checks.check(__functionAddress);
/* 1073 */       Checks.check(context);
/*      */     } 
/* 1075 */     JNI.invokePV(context, source, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetSourcef(int source, int param, long value) {
/* 1082 */     long __functionAddress = (AL.getICD()).alGetSourcef;
/* 1083 */     JNI.invokePV(source, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourcef(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer value) {
/* 1089 */     if (Checks.CHECKS) {
/* 1090 */       Checks.check(value, 1);
/*      */     }
/* 1092 */     nalGetSourcef(source, param, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static float alGetSourcef(@NativeType("ALuint") int source, @NativeType("ALenum") int param) {
/* 1098 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1100 */       FloatBuffer value = stack.callocFloat(1);
/* 1101 */       nalGetSourcef(source, param, MemoryUtil.memAddress(value));
/* 1102 */       return value.get(0);
/*      */     } finally {
/* 1104 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetSourcefDirect(long context, int source, int param, long value) {
/* 1112 */     long __functionAddress = (AL.getICD()).alGetSourcefDirect;
/* 1113 */     if (Checks.CHECKS) {
/* 1114 */       Checks.check(__functionAddress);
/* 1115 */       Checks.check(context);
/*      */     } 
/* 1117 */     JNI.invokePPV(context, source, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourcefDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer value) {
/* 1123 */     if (Checks.CHECKS) {
/* 1124 */       Checks.check(value, 1);
/*      */     }
/* 1126 */     nalGetSourcefDirect(context, source, param, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static float alGetSourcefDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param) {
/* 1132 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1134 */       FloatBuffer value = stack.callocFloat(1);
/* 1135 */       nalGetSourcefDirect(context, source, param, MemoryUtil.memAddress(value));
/* 1136 */       return value.get(0);
/*      */     } finally {
/* 1138 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetSource3f(int source, int param, long v1, long v2, long v3) {
/* 1146 */     long __functionAddress = (AL.getICD()).alGetSource3f;
/* 1147 */     JNI.invokePPPV(source, param, v1, v2, v3, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSource3f(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer v1, @NativeType("ALfloat *") FloatBuffer v2, @NativeType("ALfloat *") FloatBuffer v3) {
/* 1153 */     if (Checks.CHECKS) {
/* 1154 */       Checks.check(v1, 1);
/* 1155 */       Checks.check(v2, 1);
/* 1156 */       Checks.check(v3, 1);
/*      */     } 
/* 1158 */     nalGetSource3f(source, param, MemoryUtil.memAddress(v1), MemoryUtil.memAddress(v2), MemoryUtil.memAddress(v3));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetSource3fDirect(long context, int source, int param, long v1, long v2, long v3) {
/* 1165 */     long __functionAddress = (AL.getICD()).alGetSource3fDirect;
/* 1166 */     if (Checks.CHECKS) {
/* 1167 */       Checks.check(__functionAddress);
/* 1168 */       Checks.check(context);
/*      */     } 
/* 1170 */     JNI.invokePPPPV(context, source, param, v1, v2, v3, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSource3fDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer v1, @NativeType("ALfloat *") FloatBuffer v2, @NativeType("ALfloat *") FloatBuffer v3) {
/* 1176 */     if (Checks.CHECKS) {
/* 1177 */       Checks.check(v1, 1);
/* 1178 */       Checks.check(v2, 1);
/* 1179 */       Checks.check(v3, 1);
/*      */     } 
/* 1181 */     nalGetSource3fDirect(context, source, param, MemoryUtil.memAddress(v1), MemoryUtil.memAddress(v2), MemoryUtil.memAddress(v3));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetSourcefv(int source, int param, long values) {
/* 1188 */     long __functionAddress = (AL.getICD()).alGetSourcefv;
/* 1189 */     JNI.invokePV(source, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourcefv(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer values) {
/* 1195 */     if (Checks.CHECKS) {
/* 1196 */       Checks.check(values, 1);
/*      */     }
/* 1198 */     nalGetSourcefv(source, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetSourcefvDirect(long context, int source, int param, long values) {
/* 1205 */     long __functionAddress = (AL.getICD()).alGetSourcefvDirect;
/* 1206 */     if (Checks.CHECKS) {
/* 1207 */       Checks.check(__functionAddress);
/* 1208 */       Checks.check(context);
/*      */     } 
/* 1210 */     JNI.invokePPV(context, source, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourcefvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat *") FloatBuffer values) {
/* 1216 */     if (Checks.CHECKS) {
/* 1217 */       Checks.check(values, 1);
/*      */     }
/* 1219 */     nalGetSourcefvDirect(context, source, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetSourcei(int source, int param, long value) {
/* 1226 */     long __functionAddress = (AL.getICD()).alGetSourcei;
/* 1227 */     JNI.invokePV(source, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourcei(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer value) {
/* 1233 */     if (Checks.CHECKS) {
/* 1234 */       Checks.check(value, 1);
/*      */     }
/* 1236 */     nalGetSourcei(source, param, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGetSourcei(@NativeType("ALuint") int source, @NativeType("ALenum") int param) {
/* 1242 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1244 */       IntBuffer value = stack.callocInt(1);
/* 1245 */       nalGetSourcei(source, param, MemoryUtil.memAddress(value));
/* 1246 */       return value.get(0);
/*      */     } finally {
/* 1248 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetSourceiDirect(long context, int source, int param, long value) {
/* 1256 */     long __functionAddress = (AL.getICD()).alGetSourceiDirect;
/* 1257 */     if (Checks.CHECKS) {
/* 1258 */       Checks.check(__functionAddress);
/* 1259 */       Checks.check(context);
/*      */     } 
/* 1261 */     JNI.invokePPV(context, source, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourceiDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer value) {
/* 1267 */     if (Checks.CHECKS) {
/* 1268 */       Checks.check(value, 1);
/*      */     }
/* 1270 */     nalGetSourceiDirect(context, source, param, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGetSourceiDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param) {
/* 1276 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1278 */       IntBuffer value = stack.callocInt(1);
/* 1279 */       nalGetSourceiDirect(context, source, param, MemoryUtil.memAddress(value));
/* 1280 */       return value.get(0);
/*      */     } finally {
/* 1282 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetSourceiv(int source, int param, long values) {
/* 1290 */     long __functionAddress = (AL.getICD()).alGetSourceiv;
/* 1291 */     JNI.invokePV(source, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourceiv(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer values) {
/* 1297 */     if (Checks.CHECKS) {
/* 1298 */       Checks.check(values, 1);
/*      */     }
/* 1300 */     nalGetSourceiv(source, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetSourceivDirect(long context, int source, int param, long values) {
/* 1307 */     long __functionAddress = (AL.getICD()).alGetSourceivDirect;
/* 1308 */     if (Checks.CHECKS) {
/* 1309 */       Checks.check(__functionAddress);
/* 1310 */       Checks.check(context);
/*      */     } 
/* 1312 */     JNI.invokePPV(context, source, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourceivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint *") IntBuffer values) {
/* 1318 */     if (Checks.CHECKS) {
/* 1319 */       Checks.check(values, 1);
/*      */     }
/* 1321 */     nalGetSourceivDirect(context, source, param, MemoryUtil.memAddress(values));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourceQueueBuffers(int sourceName, int numBuffers, long bufferNames) {
/* 1328 */     long __functionAddress = (AL.getICD()).alSourceQueueBuffers;
/* 1329 */     JNI.invokePV(sourceName, numBuffers, bufferNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceQueueBuffers(@NativeType("ALuint") int sourceName, @NativeType("ALuint *") IntBuffer bufferNames) {
/* 1335 */     nalSourceQueueBuffers(sourceName, bufferNames.remaining(), MemoryUtil.memAddress(bufferNames));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceQueueBuffers(@NativeType("ALuint") int sourceName, @NativeType("ALuint *") int bufferName) {
/* 1341 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1343 */       IntBuffer bufferNames = stack.ints(bufferName);
/* 1344 */       nalSourceQueueBuffers(sourceName, 1, MemoryUtil.memAddress(bufferNames));
/*      */     } finally {
/* 1346 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourceQueueBuffersDirect(long context, int sourceName, int numBuffers, long bufferNames) {
/* 1354 */     long __functionAddress = (AL.getICD()).alSourceQueueBuffersDirect;
/* 1355 */     if (Checks.CHECKS) {
/* 1356 */       Checks.check(__functionAddress);
/* 1357 */       Checks.check(context);
/*      */     } 
/* 1359 */     JNI.invokePPV(context, sourceName, numBuffers, bufferNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceQueueBuffersDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int sourceName, @NativeType("ALuint *") IntBuffer bufferNames) {
/* 1365 */     nalSourceQueueBuffersDirect(context, sourceName, bufferNames.remaining(), MemoryUtil.memAddress(bufferNames));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceQueueBuffersDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int sourceName, @NativeType("ALuint *") int bufferName) {
/* 1371 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1373 */       IntBuffer bufferNames = stack.ints(bufferName);
/* 1374 */       nalSourceQueueBuffersDirect(context, sourceName, 1, MemoryUtil.memAddress(bufferNames));
/*      */     } finally {
/* 1376 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourceUnqueueBuffers(int sourceName, int numEntries, long bufferNames) {
/* 1384 */     long __functionAddress = (AL.getICD()).alSourceUnqueueBuffers;
/* 1385 */     JNI.invokePV(sourceName, numEntries, bufferNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceUnqueueBuffers(@NativeType("ALuint") int sourceName, @NativeType("ALuint *") IntBuffer bufferNames) {
/* 1391 */     nalSourceUnqueueBuffers(sourceName, bufferNames.remaining(), MemoryUtil.memAddress(bufferNames));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alSourceUnqueueBuffers(@NativeType("ALuint") int sourceName) {
/* 1397 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1399 */       IntBuffer bufferNames = stack.callocInt(1);
/* 1400 */       nalSourceUnqueueBuffers(sourceName, 1, MemoryUtil.memAddress(bufferNames));
/* 1401 */       return bufferNames.get(0);
/*      */     } finally {
/* 1403 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourceUnqueueBuffersDirect(long context, int sourceName, int numEntries, long bufferNames) {
/* 1411 */     long __functionAddress = (AL.getICD()).alSourceUnqueueBuffersDirect;
/* 1412 */     if (Checks.CHECKS) {
/* 1413 */       Checks.check(__functionAddress);
/* 1414 */       Checks.check(context);
/*      */     } 
/* 1416 */     JNI.invokePPV(context, sourceName, numEntries, bufferNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceUnqueueBuffersDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int sourceName, @NativeType("ALuint *") IntBuffer bufferNames) {
/* 1422 */     nalSourceUnqueueBuffersDirect(context, sourceName, bufferNames.remaining(), MemoryUtil.memAddress(bufferNames));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alSourceUnqueueBuffersDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int sourceName) {
/* 1428 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1430 */       IntBuffer bufferNames = stack.callocInt(1);
/* 1431 */       nalSourceUnqueueBuffersDirect(context, sourceName, 1, MemoryUtil.memAddress(bufferNames));
/* 1432 */       return bufferNames.get(0);
/*      */     } finally {
/* 1434 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcePlay(@NativeType("ALuint") int source) {
/* 1443 */     long __functionAddress = (AL.getICD()).alSourcePlay;
/* 1444 */     JNI.invokeV(source, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcePlayDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source) {
/* 1452 */     long __functionAddress = (AL.getICD()).alSourcePlayDirect;
/* 1453 */     if (Checks.CHECKS) {
/* 1454 */       Checks.check(__functionAddress);
/* 1455 */       Checks.check(context);
/*      */     } 
/* 1457 */     JNI.invokePV(context, source, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcePause(@NativeType("ALuint") int source) {
/* 1465 */     long __functionAddress = (AL.getICD()).alSourcePause;
/* 1466 */     JNI.invokeV(source, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcePauseDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source) {
/* 1474 */     long __functionAddress = (AL.getICD()).alSourcePauseDirect;
/* 1475 */     if (Checks.CHECKS) {
/* 1476 */       Checks.check(__functionAddress);
/* 1477 */       Checks.check(context);
/*      */     } 
/* 1479 */     JNI.invokePV(context, source, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceStop(@NativeType("ALuint") int source) {
/* 1487 */     long __functionAddress = (AL.getICD()).alSourceStop;
/* 1488 */     JNI.invokeV(source, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceStopDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source) {
/* 1496 */     long __functionAddress = (AL.getICD()).alSourceStopDirect;
/* 1497 */     if (Checks.CHECKS) {
/* 1498 */       Checks.check(__functionAddress);
/* 1499 */       Checks.check(context);
/*      */     } 
/* 1501 */     JNI.invokePV(context, source, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceRewind(@NativeType("ALuint") int source) {
/* 1509 */     long __functionAddress = (AL.getICD()).alSourceRewind;
/* 1510 */     JNI.invokeV(source, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceRewindDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source) {
/* 1518 */     long __functionAddress = (AL.getICD()).alSourceRewindDirect;
/* 1519 */     if (Checks.CHECKS) {
/* 1520 */       Checks.check(__functionAddress);
/* 1521 */       Checks.check(context);
/*      */     } 
/* 1523 */     JNI.invokePV(context, source, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourcePlayv(int n, long sources) {
/* 1530 */     long __functionAddress = (AL.getICD()).alSourcePlayv;
/* 1531 */     JNI.invokePV(n, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcePlayv(@NativeType("ALuint const *") IntBuffer sources) {
/* 1537 */     nalSourcePlayv(sources.remaining(), MemoryUtil.memAddress(sources));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourcePlayvDirect(long context, int n, long sources) {
/* 1544 */     long __functionAddress = (AL.getICD()).alSourcePlayvDirect;
/* 1545 */     if (Checks.CHECKS) {
/* 1546 */       Checks.check(__functionAddress);
/* 1547 */       Checks.check(context);
/*      */     } 
/* 1549 */     JNI.invokePPV(context, n, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcePlayvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint const *") IntBuffer sources) {
/* 1555 */     nalSourcePlayvDirect(context, sources.remaining(), MemoryUtil.memAddress(sources));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourcePausev(int n, long sources) {
/* 1562 */     long __functionAddress = (AL.getICD()).alSourcePausev;
/* 1563 */     JNI.invokePV(n, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcePausev(@NativeType("ALuint const *") IntBuffer sources) {
/* 1569 */     nalSourcePausev(sources.remaining(), MemoryUtil.memAddress(sources));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourcePausevDirect(long context, int n, long sources) {
/* 1576 */     long __functionAddress = (AL.getICD()).alSourcePausevDirect;
/* 1577 */     if (Checks.CHECKS) {
/* 1578 */       Checks.check(__functionAddress);
/* 1579 */       Checks.check(context);
/*      */     } 
/* 1581 */     JNI.invokePPV(context, n, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcePausevDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint const *") IntBuffer sources) {
/* 1587 */     nalSourcePausevDirect(context, sources.remaining(), MemoryUtil.memAddress(sources));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourceStopv(int n, long sources) {
/* 1594 */     long __functionAddress = (AL.getICD()).alSourceStopv;
/* 1595 */     JNI.invokePV(n, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceStopv(@NativeType("ALuint const *") IntBuffer sources) {
/* 1601 */     nalSourceStopv(sources.remaining(), MemoryUtil.memAddress(sources));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourceStopvDirect(long context, int n, long sources) {
/* 1608 */     long __functionAddress = (AL.getICD()).alSourceStopvDirect;
/* 1609 */     if (Checks.CHECKS) {
/* 1610 */       Checks.check(__functionAddress);
/* 1611 */       Checks.check(context);
/*      */     } 
/* 1613 */     JNI.invokePPV(context, n, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceStopvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint const *") IntBuffer sources) {
/* 1619 */     nalSourceStopvDirect(context, sources.remaining(), MemoryUtil.memAddress(sources));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourceRewindv(int n, long sources) {
/* 1626 */     long __functionAddress = (AL.getICD()).alSourceRewindv;
/* 1627 */     JNI.invokePV(n, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceRewindv(@NativeType("ALuint const *") IntBuffer sources) {
/* 1633 */     nalSourceRewindv(sources.remaining(), MemoryUtil.memAddress(sources));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalSourceRewindvDirect(long context, int n, long sources) {
/* 1640 */     long __functionAddress = (AL.getICD()).alSourceRewindvDirect;
/* 1641 */     if (Checks.CHECKS) {
/* 1642 */       Checks.check(__functionAddress);
/* 1643 */       Checks.check(context);
/*      */     } 
/* 1645 */     JNI.invokePPV(context, n, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceRewindvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint const *") IntBuffer sources) {
/* 1651 */     nalSourceRewindvDirect(context, sources.remaining(), MemoryUtil.memAddress(sources));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGenBuffers(int n, long bufferNames) {
/* 1658 */     long __functionAddress = (AL.getICD()).alGenBuffers;
/* 1659 */     JNI.invokePV(n, bufferNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenBuffers(@NativeType("ALuint *") IntBuffer bufferNames) {
/* 1665 */     nalGenBuffers(bufferNames.remaining(), MemoryUtil.memAddress(bufferNames));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGenBuffers() {
/* 1671 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1673 */       IntBuffer bufferNames = stack.callocInt(1);
/* 1674 */       nalGenBuffers(1, MemoryUtil.memAddress(bufferNames));
/* 1675 */       return bufferNames.get(0);
/*      */     } finally {
/* 1677 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGenBuffersDirect(long context, int n, long bufferNames) {
/* 1685 */     long __functionAddress = (AL.getICD()).alGenBuffersDirect;
/* 1686 */     if (Checks.CHECKS) {
/* 1687 */       Checks.check(__functionAddress);
/* 1688 */       Checks.check(context);
/*      */     } 
/* 1690 */     JNI.invokePPV(context, n, bufferNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenBuffersDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") IntBuffer bufferNames) {
/* 1696 */     nalGenBuffersDirect(context, bufferNames.remaining(), MemoryUtil.memAddress(bufferNames));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGenBuffersDirect(@NativeType("ALCcontext *") long context) {
/* 1702 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1704 */       IntBuffer bufferNames = stack.callocInt(1);
/* 1705 */       nalGenBuffersDirect(context, 1, MemoryUtil.memAddress(bufferNames));
/* 1706 */       return bufferNames.get(0);
/*      */     } finally {
/* 1708 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalDeleteBuffers(int n, long bufferNames) {
/* 1716 */     long __functionAddress = (AL.getICD()).alDeleteBuffers;
/* 1717 */     JNI.invokePV(n, bufferNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteBuffers(@NativeType("ALuint const *") IntBuffer bufferNames) {
/* 1723 */     nalDeleteBuffers(bufferNames.remaining(), MemoryUtil.memAddress(bufferNames));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteBuffers(@NativeType("ALuint const *") int bufferName) {
/* 1729 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1731 */       IntBuffer bufferNames = stack.ints(bufferName);
/* 1732 */       nalDeleteBuffers(1, MemoryUtil.memAddress(bufferNames));
/*      */     } finally {
/* 1734 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalDeleteBuffersDirect(long context, int n, long bufferNames) {
/* 1742 */     long __functionAddress = (AL.getICD()).alDeleteBuffersDirect;
/* 1743 */     if (Checks.CHECKS) {
/* 1744 */       Checks.check(__functionAddress);
/* 1745 */       Checks.check(context);
/*      */     } 
/* 1747 */     JNI.invokePPV(context, n, bufferNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteBuffersDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint const *") IntBuffer bufferNames) {
/* 1753 */     nalDeleteBuffersDirect(context, bufferNames.remaining(), MemoryUtil.memAddress(bufferNames));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteBuffersDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint const *") int bufferName) {
/* 1759 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1761 */       IntBuffer bufferNames = stack.ints(bufferName);
/* 1762 */       nalDeleteBuffersDirect(context, 1, MemoryUtil.memAddress(bufferNames));
/*      */     } finally {
/* 1764 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alIsBuffer(@NativeType("ALuint") int bufferName) {
/* 1773 */     long __functionAddress = (AL.getICD()).alIsBuffer;
/* 1774 */     return JNI.invokeZ(bufferName, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("ALboolean")
/*      */   public static boolean alIsBufferDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int bufferName) {
/* 1782 */     long __functionAddress = (AL.getICD()).alIsBufferDirect;
/* 1783 */     if (Checks.CHECKS) {
/* 1784 */       Checks.check(__functionAddress);
/* 1785 */       Checks.check(context);
/*      */     } 
/* 1787 */     return JNI.invokePZ(context, bufferName, __functionAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetBufferf(int bufferName, int paramName, long value) {
/* 1794 */     long __functionAddress = (AL.getICD()).alGetBufferf;
/* 1795 */     JNI.invokePV(bufferName, paramName, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetBufferf(@NativeType("ALuint") int bufferName, @NativeType("ALenum") int paramName, @NativeType("ALfloat *") FloatBuffer value) {
/* 1801 */     if (Checks.CHECKS) {
/* 1802 */       Checks.check(value, 1);
/*      */     }
/* 1804 */     nalGetBufferf(bufferName, paramName, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static float alGetBufferf(@NativeType("ALuint") int bufferName, @NativeType("ALenum") int paramName) {
/* 1810 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1812 */       FloatBuffer value = stack.callocFloat(1);
/* 1813 */       nalGetBufferf(bufferName, paramName, MemoryUtil.memAddress(value));
/* 1814 */       return value.get(0);
/*      */     } finally {
/* 1816 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetBufferfDirect(long context, int bufferName, int paramName, long value) {
/* 1824 */     long __functionAddress = (AL.getICD()).alGetBufferfDirect;
/* 1825 */     if (Checks.CHECKS) {
/* 1826 */       Checks.check(__functionAddress);
/* 1827 */       Checks.check(context);
/*      */     } 
/* 1829 */     JNI.invokePPV(context, bufferName, paramName, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetBufferfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int bufferName, @NativeType("ALenum") int paramName, @NativeType("ALfloat *") FloatBuffer value) {
/* 1835 */     if (Checks.CHECKS) {
/* 1836 */       Checks.check(value, 1);
/*      */     }
/* 1838 */     nalGetBufferfDirect(context, bufferName, paramName, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static float alGetBufferfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int bufferName, @NativeType("ALenum") int paramName) {
/* 1844 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1846 */       FloatBuffer value = stack.callocFloat(1);
/* 1847 */       nalGetBufferfDirect(context, bufferName, paramName, MemoryUtil.memAddress(value));
/* 1848 */       return value.get(0);
/*      */     } finally {
/* 1850 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetBufferi(int bufferName, int paramName, long value) {
/* 1858 */     long __functionAddress = (AL.getICD()).alGetBufferi;
/* 1859 */     JNI.invokePV(bufferName, paramName, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetBufferi(@NativeType("ALuint") int bufferName, @NativeType("ALenum") int paramName, @NativeType("ALint *") IntBuffer value) {
/* 1865 */     if (Checks.CHECKS) {
/* 1866 */       Checks.check(value, 1);
/*      */     }
/* 1868 */     nalGetBufferi(bufferName, paramName, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGetBufferi(@NativeType("ALuint") int bufferName, @NativeType("ALenum") int paramName) {
/* 1874 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1876 */       IntBuffer value = stack.callocInt(1);
/* 1877 */       nalGetBufferi(bufferName, paramName, MemoryUtil.memAddress(value));
/* 1878 */       return value.get(0);
/*      */     } finally {
/* 1880 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalGetBufferiDirect(long context, int bufferName, int paramName, long value) {
/* 1888 */     long __functionAddress = (AL.getICD()).alGetBufferiDirect;
/* 1889 */     if (Checks.CHECKS) {
/* 1890 */       Checks.check(__functionAddress);
/* 1891 */       Checks.check(context);
/*      */     } 
/* 1893 */     JNI.invokePPV(context, bufferName, paramName, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetBufferiDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int bufferName, @NativeType("ALenum") int paramName, @NativeType("ALint *") IntBuffer value) {
/* 1899 */     if (Checks.CHECKS) {
/* 1900 */       Checks.check(value, 1);
/*      */     }
/* 1902 */     nalGetBufferiDirect(context, bufferName, paramName, MemoryUtil.memAddress(value));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static int alGetBufferiDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int bufferName, @NativeType("ALenum") int paramName) {
/* 1908 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 1910 */       IntBuffer value = stack.callocInt(1);
/* 1911 */       nalGetBufferiDirect(context, bufferName, paramName, MemoryUtil.memAddress(value));
/* 1912 */       return value.get(0);
/*      */     } finally {
/* 1914 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalBufferData(int bufferName, int format, long data, int size, int frequency) {
/* 1922 */     long __functionAddress = (AL.getICD()).alBufferData;
/* 1923 */     JNI.invokePV(bufferName, format, data, size, frequency, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferData(@NativeType("ALuint") int bufferName, @NativeType("ALenum") int format, @NativeType("ALvoid const *") ByteBuffer data, @NativeType("ALsizei") int frequency) {
/* 1929 */     nalBufferData(bufferName, format, MemoryUtil.memAddress(data), data.remaining(), frequency);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferData(@NativeType("ALuint") int bufferName, @NativeType("ALenum") int format, @NativeType("ALvoid const *") ShortBuffer data, @NativeType("ALsizei") int frequency) {
/* 1935 */     nalBufferData(bufferName, format, MemoryUtil.memAddress(data), data.remaining() << 1, frequency);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferData(@NativeType("ALuint") int bufferName, @NativeType("ALenum") int format, @NativeType("ALvoid const *") IntBuffer data, @NativeType("ALsizei") int frequency) {
/* 1941 */     nalBufferData(bufferName, format, MemoryUtil.memAddress(data), data.remaining() << 2, frequency);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferData(@NativeType("ALuint") int bufferName, @NativeType("ALenum") int format, @NativeType("ALvoid const *") FloatBuffer data, @NativeType("ALsizei") int frequency) {
/* 1947 */     nalBufferData(bufferName, format, MemoryUtil.memAddress(data), data.remaining() << 2, frequency);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nalBufferDataDirect(long context, int bufferName, int format, long data, int size, int frequency) {
/* 1954 */     long __functionAddress = (AL.getICD()).alBufferDataDirect;
/* 1955 */     if (Checks.CHECKS) {
/* 1956 */       Checks.check(__functionAddress);
/* 1957 */       Checks.check(context);
/*      */     } 
/* 1959 */     JNI.invokePPV(context, bufferName, format, data, size, frequency, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferDataDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int bufferName, @NativeType("ALenum") int format, @NativeType("ALvoid const *") ByteBuffer data, @NativeType("ALsizei") int frequency) {
/* 1965 */     nalBufferDataDirect(context, bufferName, format, MemoryUtil.memAddress(data), data.remaining(), frequency);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferDataDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int bufferName, @NativeType("ALenum") int format, @NativeType("ALvoid const *") ShortBuffer data, @NativeType("ALsizei") int frequency) {
/* 1971 */     nalBufferDataDirect(context, bufferName, format, MemoryUtil.memAddress(data), data.remaining() << 1, frequency);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferDataDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int bufferName, @NativeType("ALenum") int format, @NativeType("ALvoid const *") IntBuffer data, @NativeType("ALsizei") int frequency) {
/* 1977 */     nalBufferDataDirect(context, bufferName, format, MemoryUtil.memAddress(data), data.remaining() << 2, frequency);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferDataDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int bufferName, @NativeType("ALenum") int format, @NativeType("ALvoid const *") FloatBuffer data, @NativeType("ALsizei") int frequency) {
/* 1983 */     nalBufferDataDirect(context, bufferName, format, MemoryUtil.memAddress(data), data.remaining() << 2, frequency);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nalGetEnumValue(long enumName) {
/* 1990 */     long __functionAddress = (AL.getICD()).alGetEnumValue;
/* 1991 */     return JNI.invokePI(enumName, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALenum")
/*      */   public static int alGetEnumValue(@NativeType("ALchar const *") ByteBuffer enumName) {
/* 1997 */     if (Checks.CHECKS) {
/* 1998 */       Checks.checkNT1(enumName);
/*      */     }
/* 2000 */     return nalGetEnumValue(MemoryUtil.memAddress(enumName));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALenum")
/*      */   public static int alGetEnumValue(@NativeType("ALchar const *") CharSequence enumName) {
/* 2006 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2008 */       stack.nASCII(enumName, true);
/* 2009 */       long enumNameEncoded = stack.getPointerAddress();
/* 2010 */       return nalGetEnumValue(enumNameEncoded);
/*      */     } finally {
/* 2012 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nalGetEnumValueDirect(long context, long enumName) {
/* 2020 */     long __functionAddress = (AL.getICD()).alGetEnumValueDirect;
/* 2021 */     if (Checks.CHECKS) {
/* 2022 */       Checks.check(__functionAddress);
/* 2023 */       Checks.check(context);
/*      */     } 
/* 2025 */     return JNI.invokePPI(context, enumName, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALenum")
/*      */   public static int alGetEnumValueDirect(@NativeType("ALCcontext *") long context, @NativeType("ALchar const *") ByteBuffer enumName) {
/* 2031 */     if (Checks.CHECKS) {
/* 2032 */       Checks.checkNT1(enumName);
/*      */     }
/* 2034 */     return nalGetEnumValueDirect(context, MemoryUtil.memAddress(enumName));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALenum")
/*      */   public static int alGetEnumValueDirect(@NativeType("ALCcontext *") long context, @NativeType("ALchar const *") CharSequence enumName) {
/* 2040 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2042 */       stack.nASCII(enumName, true);
/* 2043 */       long enumNameEncoded = stack.getPointerAddress();
/* 2044 */       return nalGetEnumValueDirect(context, enumNameEncoded);
/*      */     } finally {
/* 2046 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nalGetProcAddress(long funcName) {
/* 2054 */     long __functionAddress = (AL.getICD()).alGetProcAddress;
/* 2055 */     return JNI.invokePP(funcName, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid *")
/*      */   public static long alGetProcAddress(@NativeType("ALchar const *") ByteBuffer funcName) {
/* 2061 */     if (Checks.CHECKS) {
/* 2062 */       Checks.checkNT1(funcName);
/*      */     }
/* 2064 */     return nalGetProcAddress(MemoryUtil.memAddress(funcName));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid *")
/*      */   public static long alGetProcAddress(@NativeType("ALchar const *") CharSequence funcName) {
/* 2070 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2072 */       stack.nASCII(funcName, true);
/* 2073 */       long funcNameEncoded = stack.getPointerAddress();
/* 2074 */       return nalGetProcAddress(funcNameEncoded);
/*      */     } finally {
/* 2076 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nalGetProcAddressDirect(long context, long funcName) {
/* 2084 */     long __functionAddress = (AL.getICD()).alGetProcAddressDirect;
/* 2085 */     if (Checks.CHECKS) {
/* 2086 */       Checks.check(__functionAddress);
/* 2087 */       Checks.check(context);
/*      */     } 
/* 2089 */     return JNI.invokePPP(context, funcName, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid *")
/*      */   public static long alGetProcAddressDirect(@NativeType("ALCcontext *") long context, @NativeType("ALchar const *") ByteBuffer funcName) {
/* 2095 */     if (Checks.CHECKS) {
/* 2096 */       Checks.checkNT1(funcName);
/*      */     }
/* 2098 */     return nalGetProcAddressDirect(context, MemoryUtil.memAddress(funcName));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid *")
/*      */   public static long alGetProcAddressDirect(@NativeType("ALCcontext *") long context, @NativeType("ALchar const *") CharSequence funcName) {
/* 2104 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2106 */       stack.nASCII(funcName, true);
/* 2107 */       long funcNameEncoded = stack.getPointerAddress();
/* 2108 */       return nalGetProcAddressDirect(context, funcNameEncoded);
/*      */     } finally {
/* 2110 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean nalIsExtensionPresent(long extName) {
/* 2118 */     long __functionAddress = (AL.getICD()).alIsExtensionPresent;
/* 2119 */     return JNI.invokePZ(extName, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALCboolean")
/*      */   public static boolean alIsExtensionPresent(@NativeType("ALchar const *") ByteBuffer extName) {
/* 2125 */     if (Checks.CHECKS) {
/* 2126 */       Checks.checkNT1(extName);
/*      */     }
/* 2128 */     return nalIsExtensionPresent(MemoryUtil.memAddress(extName));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALCboolean")
/*      */   public static boolean alIsExtensionPresent(@NativeType("ALchar const *") CharSequence extName) {
/* 2134 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2136 */       stack.nASCII(extName, true);
/* 2137 */       long extNameEncoded = stack.getPointerAddress();
/* 2138 */       return nalIsExtensionPresent(extNameEncoded);
/*      */     } finally {
/* 2140 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean nalIsExtensionPresentDirect(long context, long extName) {
/* 2148 */     long __functionAddress = (AL.getICD()).alIsExtensionPresentDirect;
/* 2149 */     if (Checks.CHECKS) {
/* 2150 */       Checks.check(__functionAddress);
/* 2151 */       Checks.check(context);
/*      */     } 
/* 2153 */     return JNI.invokePPZ(context, extName, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALCboolean")
/*      */   public static boolean alIsExtensionPresentDirect(@NativeType("ALCcontext *") long context, @NativeType("ALchar const *") ByteBuffer extName) {
/* 2159 */     if (Checks.CHECKS) {
/* 2160 */       Checks.checkNT1(extName);
/*      */     }
/* 2162 */     return nalIsExtensionPresentDirect(context, MemoryUtil.memAddress(extName));
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALCboolean")
/*      */   public static boolean alIsExtensionPresentDirect(@NativeType("ALCcontext *") long context, @NativeType("ALchar const *") CharSequence extName) {
/* 2168 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*      */     try {
/* 2170 */       stack.nASCII(extName, true);
/* 2171 */       long extNameEncoded = stack.getPointerAddress();
/* 2172 */       return nalIsExtensionPresentDirect(context, extNameEncoded);
/*      */     } finally {
/* 2174 */       stack.setPointer(stackPointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetIntegerv(@NativeType("ALenum") int paramName, @NativeType("ALint *") int[] dest) {
/* 2181 */     long __functionAddress = (AL.getICD()).alGetIntegerv;
/* 2182 */     if (Checks.CHECKS) {
/* 2183 */       Checks.check(dest, 1);
/*      */     }
/* 2185 */     JNI.invokePV(paramName, dest, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetIntegervDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALint *") int[] dest) {
/* 2191 */     long __functionAddress = (AL.getICD()).alGetIntegervDirect;
/* 2192 */     if (Checks.CHECKS) {
/* 2193 */       Checks.check(__functionAddress);
/* 2194 */       Checks.check(context);
/* 2195 */       Checks.check(dest, 1);
/*      */     } 
/* 2197 */     JNI.invokePPV(context, paramName, dest, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFloatv(@NativeType("ALenum") int paramName, @NativeType("ALfloat *") float[] dest) {
/* 2203 */     long __functionAddress = (AL.getICD()).alGetFloatv;
/* 2204 */     if (Checks.CHECKS) {
/* 2205 */       Checks.check(dest, 1);
/*      */     }
/* 2207 */     JNI.invokePV(paramName, dest, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetFloatvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALfloat *") float[] dest) {
/* 2213 */     long __functionAddress = (AL.getICD()).alGetFloatvDirect;
/* 2214 */     if (Checks.CHECKS) {
/* 2215 */       Checks.check(__functionAddress);
/* 2216 */       Checks.check(context);
/* 2217 */       Checks.check(dest, 1);
/*      */     } 
/* 2219 */     JNI.invokePPV(context, paramName, dest, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetDoublev(@NativeType("ALenum") int paramName, @NativeType("ALdouble *") double[] dest) {
/* 2225 */     long __functionAddress = (AL.getICD()).alGetDoublev;
/* 2226 */     if (Checks.CHECKS) {
/* 2227 */       Checks.check(dest, 1);
/*      */     }
/* 2229 */     JNI.invokePV(paramName, dest, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetDoublevDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALdouble *") double[] dest) {
/* 2235 */     long __functionAddress = (AL.getICD()).alGetDoublevDirect;
/* 2236 */     if (Checks.CHECKS) {
/* 2237 */       Checks.check(__functionAddress);
/* 2238 */       Checks.check(context);
/* 2239 */       Checks.check(dest, 1);
/*      */     } 
/* 2241 */     JNI.invokePPV(context, paramName, dest, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alListenerfv(@NativeType("ALenum") int paramName, @NativeType("ALfloat const *") float[] values) {
/* 2247 */     long __functionAddress = (AL.getICD()).alListenerfv;
/* 2248 */     if (Checks.CHECKS) {
/* 2249 */       Checks.check(values, 1);
/*      */     }
/* 2251 */     JNI.invokePV(paramName, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alListenerfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALfloat const *") float[] values) {
/* 2257 */     long __functionAddress = (AL.getICD()).alListenerfvDirect;
/* 2258 */     if (Checks.CHECKS) {
/* 2259 */       Checks.check(__functionAddress);
/* 2260 */       Checks.check(context);
/* 2261 */       Checks.check(values, 1);
/*      */     } 
/* 2263 */     JNI.invokePPV(context, paramName, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListenerf(@NativeType("ALenum") int paramName, @NativeType("ALfloat *") float[] value) {
/* 2269 */     long __functionAddress = (AL.getICD()).alGetListenerf;
/* 2270 */     if (Checks.CHECKS) {
/* 2271 */       Checks.check(value, 1);
/*      */     }
/* 2273 */     JNI.invokePV(paramName, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListenerfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALfloat *") float[] value) {
/* 2279 */     long __functionAddress = (AL.getICD()).alGetListenerfDirect;
/* 2280 */     if (Checks.CHECKS) {
/* 2281 */       Checks.check(__functionAddress);
/* 2282 */       Checks.check(context);
/* 2283 */       Checks.check(value, 1);
/*      */     } 
/* 2285 */     JNI.invokePPV(context, paramName, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListeneri(@NativeType("ALenum") int paramName, @NativeType("ALint *") int[] value) {
/* 2291 */     long __functionAddress = (AL.getICD()).alGetListeneri;
/* 2292 */     if (Checks.CHECKS) {
/* 2293 */       Checks.check(value, 1);
/*      */     }
/* 2295 */     JNI.invokePV(paramName, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListeneriDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALint *") int[] value) {
/* 2301 */     long __functionAddress = (AL.getICD()).alGetListeneriDirect;
/* 2302 */     if (Checks.CHECKS) {
/* 2303 */       Checks.check(__functionAddress);
/* 2304 */       Checks.check(context);
/* 2305 */       Checks.check(value, 1);
/*      */     } 
/* 2307 */     JNI.invokePPV(context, paramName, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListener3f(@NativeType("ALenum") int paramName, @NativeType("ALfloat *") float[] value1, @NativeType("ALfloat *") float[] value2, @NativeType("ALfloat *") float[] value3) {
/* 2313 */     long __functionAddress = (AL.getICD()).alGetListener3f;
/* 2314 */     if (Checks.CHECKS) {
/* 2315 */       Checks.check(value1, 1);
/* 2316 */       Checks.check(value2, 1);
/* 2317 */       Checks.check(value3, 1);
/*      */     } 
/* 2319 */     JNI.invokePPPV(paramName, value1, value2, value3, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListener3fDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALfloat *") float[] value1, @NativeType("ALfloat *") float[] value2, @NativeType("ALfloat *") float[] value3) {
/* 2325 */     long __functionAddress = (AL.getICD()).alGetListener3fDirect;
/* 2326 */     if (Checks.CHECKS) {
/* 2327 */       Checks.check(__functionAddress);
/* 2328 */       Checks.check(context);
/* 2329 */       Checks.check(value1, 1);
/* 2330 */       Checks.check(value2, 1);
/* 2331 */       Checks.check(value3, 1);
/*      */     } 
/* 2333 */     JNI.invokePPPPV(context, paramName, value1, value2, value3, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListenerfv(@NativeType("ALenum") int paramName, @NativeType("ALfloat *") float[] values) {
/* 2339 */     long __functionAddress = (AL.getICD()).alGetListenerfv;
/* 2340 */     if (Checks.CHECKS) {
/* 2341 */       Checks.check(values, 1);
/*      */     }
/* 2343 */     JNI.invokePV(paramName, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetListenerfvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int paramName, @NativeType("ALfloat *") float[] values) {
/* 2349 */     long __functionAddress = (AL.getICD()).alGetListenerfvDirect;
/* 2350 */     if (Checks.CHECKS) {
/* 2351 */       Checks.check(__functionAddress);
/* 2352 */       Checks.check(context);
/* 2353 */       Checks.check(values, 1);
/*      */     } 
/* 2355 */     JNI.invokePPV(context, paramName, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenSources(@NativeType("ALuint *") int[] srcNames) {
/* 2361 */     long __functionAddress = (AL.getICD()).alGenSources;
/* 2362 */     JNI.invokePV(srcNames.length, srcNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenSourcesDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") int[] srcNames) {
/* 2368 */     long __functionAddress = (AL.getICD()).alGenSourcesDirect;
/* 2369 */     if (Checks.CHECKS) {
/* 2370 */       Checks.check(__functionAddress);
/* 2371 */       Checks.check(context);
/*      */     } 
/* 2373 */     JNI.invokePPV(context, srcNames.length, srcNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteSources(@NativeType("ALuint *") int[] sources) {
/* 2379 */     long __functionAddress = (AL.getICD()).alDeleteSources;
/* 2380 */     JNI.invokePV(sources.length, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteSourcesDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") int[] sources) {
/* 2386 */     long __functionAddress = (AL.getICD()).alDeleteSourcesDirect;
/* 2387 */     if (Checks.CHECKS) {
/* 2388 */       Checks.check(__functionAddress);
/* 2389 */       Checks.check(context);
/*      */     } 
/* 2391 */     JNI.invokePPV(context, sources.length, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcefv(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat const *") float[] values) {
/* 2397 */     long __functionAddress = (AL.getICD()).alSourcefv;
/* 2398 */     if (Checks.CHECKS) {
/* 2399 */       Checks.check(values, 1);
/*      */     }
/* 2401 */     JNI.invokePV(source, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcefvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat const *") float[] values) {
/* 2407 */     long __functionAddress = (AL.getICD()).alSourcefvDirect;
/* 2408 */     if (Checks.CHECKS) {
/* 2409 */       Checks.check(__functionAddress);
/* 2410 */       Checks.check(context);
/* 2411 */       Checks.check(values, 1);
/*      */     } 
/* 2413 */     JNI.invokePPV(context, source, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourcef(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] value) {
/* 2419 */     long __functionAddress = (AL.getICD()).alGetSourcef;
/* 2420 */     if (Checks.CHECKS) {
/* 2421 */       Checks.check(value, 1);
/*      */     }
/* 2423 */     JNI.invokePV(source, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourcefDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] value) {
/* 2429 */     long __functionAddress = (AL.getICD()).alGetSourcefDirect;
/* 2430 */     if (Checks.CHECKS) {
/* 2431 */       Checks.check(__functionAddress);
/* 2432 */       Checks.check(context);
/* 2433 */       Checks.check(value, 1);
/*      */     } 
/* 2435 */     JNI.invokePPV(context, source, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSource3f(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] v1, @NativeType("ALfloat *") float[] v2, @NativeType("ALfloat *") float[] v3) {
/* 2441 */     long __functionAddress = (AL.getICD()).alGetSource3f;
/* 2442 */     if (Checks.CHECKS) {
/* 2443 */       Checks.check(v1, 1);
/* 2444 */       Checks.check(v2, 1);
/* 2445 */       Checks.check(v3, 1);
/*      */     } 
/* 2447 */     JNI.invokePPPV(source, param, v1, v2, v3, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSource3fDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] v1, @NativeType("ALfloat *") float[] v2, @NativeType("ALfloat *") float[] v3) {
/* 2453 */     long __functionAddress = (AL.getICD()).alGetSource3fDirect;
/* 2454 */     if (Checks.CHECKS) {
/* 2455 */       Checks.check(__functionAddress);
/* 2456 */       Checks.check(context);
/* 2457 */       Checks.check(v1, 1);
/* 2458 */       Checks.check(v2, 1);
/* 2459 */       Checks.check(v3, 1);
/*      */     } 
/* 2461 */     JNI.invokePPPPV(context, source, param, v1, v2, v3, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourcefv(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] values) {
/* 2467 */     long __functionAddress = (AL.getICD()).alGetSourcefv;
/* 2468 */     if (Checks.CHECKS) {
/* 2469 */       Checks.check(values, 1);
/*      */     }
/* 2471 */     JNI.invokePV(source, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourcefvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALfloat *") float[] values) {
/* 2477 */     long __functionAddress = (AL.getICD()).alGetSourcefvDirect;
/* 2478 */     if (Checks.CHECKS) {
/* 2479 */       Checks.check(__functionAddress);
/* 2480 */       Checks.check(context);
/* 2481 */       Checks.check(values, 1);
/*      */     } 
/* 2483 */     JNI.invokePPV(context, source, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourcei(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint *") int[] value) {
/* 2489 */     long __functionAddress = (AL.getICD()).alGetSourcei;
/* 2490 */     if (Checks.CHECKS) {
/* 2491 */       Checks.check(value, 1);
/*      */     }
/* 2493 */     JNI.invokePV(source, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourceiDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint *") int[] value) {
/* 2499 */     long __functionAddress = (AL.getICD()).alGetSourceiDirect;
/* 2500 */     if (Checks.CHECKS) {
/* 2501 */       Checks.check(__functionAddress);
/* 2502 */       Checks.check(context);
/* 2503 */       Checks.check(value, 1);
/*      */     } 
/* 2505 */     JNI.invokePPV(context, source, param, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourceiv(@NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint *") int[] values) {
/* 2511 */     long __functionAddress = (AL.getICD()).alGetSourceiv;
/* 2512 */     if (Checks.CHECKS) {
/* 2513 */       Checks.check(values, 1);
/*      */     }
/* 2515 */     JNI.invokePV(source, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetSourceivDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int source, @NativeType("ALenum") int param, @NativeType("ALint *") int[] values) {
/* 2521 */     long __functionAddress = (AL.getICD()).alGetSourceivDirect;
/* 2522 */     if (Checks.CHECKS) {
/* 2523 */       Checks.check(__functionAddress);
/* 2524 */       Checks.check(context);
/* 2525 */       Checks.check(values, 1);
/*      */     } 
/* 2527 */     JNI.invokePPV(context, source, param, values, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceQueueBuffers(@NativeType("ALuint") int sourceName, @NativeType("ALuint *") int[] bufferNames) {
/* 2533 */     long __functionAddress = (AL.getICD()).alSourceQueueBuffers;
/* 2534 */     JNI.invokePV(sourceName, bufferNames.length, bufferNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceQueueBuffersDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int sourceName, @NativeType("ALuint *") int[] bufferNames) {
/* 2540 */     long __functionAddress = (AL.getICD()).alSourceQueueBuffersDirect;
/* 2541 */     if (Checks.CHECKS) {
/* 2542 */       Checks.check(__functionAddress);
/* 2543 */       Checks.check(context);
/*      */     } 
/* 2545 */     JNI.invokePPV(context, sourceName, bufferNames.length, bufferNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceUnqueueBuffers(@NativeType("ALuint") int sourceName, @NativeType("ALuint *") int[] bufferNames) {
/* 2551 */     long __functionAddress = (AL.getICD()).alSourceUnqueueBuffers;
/* 2552 */     JNI.invokePV(sourceName, bufferNames.length, bufferNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceUnqueueBuffersDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int sourceName, @NativeType("ALuint *") int[] bufferNames) {
/* 2558 */     long __functionAddress = (AL.getICD()).alSourceUnqueueBuffersDirect;
/* 2559 */     if (Checks.CHECKS) {
/* 2560 */       Checks.check(__functionAddress);
/* 2561 */       Checks.check(context);
/*      */     } 
/* 2563 */     JNI.invokePPV(context, sourceName, bufferNames.length, bufferNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcePlayv(@NativeType("ALuint const *") int[] sources) {
/* 2569 */     long __functionAddress = (AL.getICD()).alSourcePlayv;
/* 2570 */     JNI.invokePV(sources.length, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcePlayvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint const *") int[] sources) {
/* 2576 */     long __functionAddress = (AL.getICD()).alSourcePlayvDirect;
/* 2577 */     if (Checks.CHECKS) {
/* 2578 */       Checks.check(__functionAddress);
/* 2579 */       Checks.check(context);
/*      */     } 
/* 2581 */     JNI.invokePPV(context, sources.length, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcePausev(@NativeType("ALuint const *") int[] sources) {
/* 2587 */     long __functionAddress = (AL.getICD()).alSourcePausev;
/* 2588 */     JNI.invokePV(sources.length, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourcePausevDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint const *") int[] sources) {
/* 2594 */     long __functionAddress = (AL.getICD()).alSourcePausevDirect;
/* 2595 */     if (Checks.CHECKS) {
/* 2596 */       Checks.check(__functionAddress);
/* 2597 */       Checks.check(context);
/*      */     } 
/* 2599 */     JNI.invokePPV(context, sources.length, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceStopv(@NativeType("ALuint const *") int[] sources) {
/* 2605 */     long __functionAddress = (AL.getICD()).alSourceStopv;
/* 2606 */     JNI.invokePV(sources.length, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceStopvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint const *") int[] sources) {
/* 2612 */     long __functionAddress = (AL.getICD()).alSourceStopvDirect;
/* 2613 */     if (Checks.CHECKS) {
/* 2614 */       Checks.check(__functionAddress);
/* 2615 */       Checks.check(context);
/*      */     } 
/* 2617 */     JNI.invokePPV(context, sources.length, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceRewindv(@NativeType("ALuint const *") int[] sources) {
/* 2623 */     long __functionAddress = (AL.getICD()).alSourceRewindv;
/* 2624 */     JNI.invokePV(sources.length, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alSourceRewindvDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint const *") int[] sources) {
/* 2630 */     long __functionAddress = (AL.getICD()).alSourceRewindvDirect;
/* 2631 */     if (Checks.CHECKS) {
/* 2632 */       Checks.check(__functionAddress);
/* 2633 */       Checks.check(context);
/*      */     } 
/* 2635 */     JNI.invokePPV(context, sources.length, sources, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenBuffers(@NativeType("ALuint *") int[] bufferNames) {
/* 2641 */     long __functionAddress = (AL.getICD()).alGenBuffers;
/* 2642 */     JNI.invokePV(bufferNames.length, bufferNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGenBuffersDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint *") int[] bufferNames) {
/* 2648 */     long __functionAddress = (AL.getICD()).alGenBuffersDirect;
/* 2649 */     if (Checks.CHECKS) {
/* 2650 */       Checks.check(__functionAddress);
/* 2651 */       Checks.check(context);
/*      */     } 
/* 2653 */     JNI.invokePPV(context, bufferNames.length, bufferNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteBuffers(@NativeType("ALuint const *") int[] bufferNames) {
/* 2659 */     long __functionAddress = (AL.getICD()).alDeleteBuffers;
/* 2660 */     JNI.invokePV(bufferNames.length, bufferNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alDeleteBuffersDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint const *") int[] bufferNames) {
/* 2666 */     long __functionAddress = (AL.getICD()).alDeleteBuffersDirect;
/* 2667 */     if (Checks.CHECKS) {
/* 2668 */       Checks.check(__functionAddress);
/* 2669 */       Checks.check(context);
/*      */     } 
/* 2671 */     JNI.invokePPV(context, bufferNames.length, bufferNames, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetBufferf(@NativeType("ALuint") int bufferName, @NativeType("ALenum") int paramName, @NativeType("ALfloat *") float[] value) {
/* 2677 */     long __functionAddress = (AL.getICD()).alGetBufferf;
/* 2678 */     if (Checks.CHECKS) {
/* 2679 */       Checks.check(value, 1);
/*      */     }
/* 2681 */     JNI.invokePV(bufferName, paramName, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetBufferfDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int bufferName, @NativeType("ALenum") int paramName, @NativeType("ALfloat *") float[] value) {
/* 2687 */     long __functionAddress = (AL.getICD()).alGetBufferfDirect;
/* 2688 */     if (Checks.CHECKS) {
/* 2689 */       Checks.check(__functionAddress);
/* 2690 */       Checks.check(context);
/* 2691 */       Checks.check(value, 1);
/*      */     } 
/* 2693 */     JNI.invokePPV(context, bufferName, paramName, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetBufferi(@NativeType("ALuint") int bufferName, @NativeType("ALenum") int paramName, @NativeType("ALint *") int[] value) {
/* 2699 */     long __functionAddress = (AL.getICD()).alGetBufferi;
/* 2700 */     if (Checks.CHECKS) {
/* 2701 */       Checks.check(value, 1);
/*      */     }
/* 2703 */     JNI.invokePV(bufferName, paramName, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alGetBufferiDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int bufferName, @NativeType("ALenum") int paramName, @NativeType("ALint *") int[] value) {
/* 2709 */     long __functionAddress = (AL.getICD()).alGetBufferiDirect;
/* 2710 */     if (Checks.CHECKS) {
/* 2711 */       Checks.check(__functionAddress);
/* 2712 */       Checks.check(context);
/* 2713 */       Checks.check(value, 1);
/*      */     } 
/* 2715 */     JNI.invokePPV(context, bufferName, paramName, value, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferData(@NativeType("ALuint") int bufferName, @NativeType("ALenum") int format, @NativeType("ALvoid const *") short[] data, @NativeType("ALsizei") int frequency) {
/* 2721 */     long __functionAddress = (AL.getICD()).alBufferData;
/* 2722 */     JNI.invokePV(bufferName, format, data, data.length << 1, frequency, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferData(@NativeType("ALuint") int bufferName, @NativeType("ALenum") int format, @NativeType("ALvoid const *") int[] data, @NativeType("ALsizei") int frequency) {
/* 2728 */     long __functionAddress = (AL.getICD()).alBufferData;
/* 2729 */     JNI.invokePV(bufferName, format, data, data.length << 2, frequency, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferData(@NativeType("ALuint") int bufferName, @NativeType("ALenum") int format, @NativeType("ALvoid const *") float[] data, @NativeType("ALsizei") int frequency) {
/* 2735 */     long __functionAddress = (AL.getICD()).alBufferData;
/* 2736 */     JNI.invokePV(bufferName, format, data, data.length << 2, frequency, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferDataDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int bufferName, @NativeType("ALenum") int format, @NativeType("ALvoid const *") short[] data, @NativeType("ALsizei") int frequency) {
/* 2742 */     long __functionAddress = (AL.getICD()).alBufferDataDirect;
/* 2743 */     if (Checks.CHECKS) {
/* 2744 */       Checks.check(__functionAddress);
/* 2745 */       Checks.check(context);
/*      */     } 
/* 2747 */     JNI.invokePPV(context, bufferName, format, data, data.length << 1, frequency, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferDataDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int bufferName, @NativeType("ALenum") int format, @NativeType("ALvoid const *") int[] data, @NativeType("ALsizei") int frequency) {
/* 2753 */     long __functionAddress = (AL.getICD()).alBufferDataDirect;
/* 2754 */     if (Checks.CHECKS) {
/* 2755 */       Checks.check(__functionAddress);
/* 2756 */       Checks.check(context);
/*      */     } 
/* 2758 */     JNI.invokePPV(context, bufferName, format, data, data.length << 2, frequency, __functionAddress);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("ALvoid")
/*      */   public static void alBufferDataDirect(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int bufferName, @NativeType("ALenum") int format, @NativeType("ALvoid const *") float[] data, @NativeType("ALsizei") int frequency) {
/* 2764 */     long __functionAddress = (AL.getICD()).alBufferDataDirect;
/* 2765 */     if (Checks.CHECKS) {
/* 2766 */       Checks.check(__functionAddress);
/* 2767 */       Checks.check(context);
/*      */     } 
/* 2769 */     JNI.invokePPV(context, bufferName, format, data, data.length << 2, frequency, __functionAddress);
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\AL10.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */