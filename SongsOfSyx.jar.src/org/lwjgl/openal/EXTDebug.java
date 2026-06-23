/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Pointer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EXTDebug
/*     */ {
/*     */   public static final int ALC_CONTEXT_FLAGS_EXT = 6607;
/*     */   public static final int ALC_CONTEXT_DEBUG_BIT_EXT = 1;
/*     */   public static final int AL_CONTEXT_FLAGS_EXT = 6607;
/*     */   public static final int AL_CONTEXT_DEBUG_BIT_EXT = 1;
/*     */   public static final int AL_DEBUG_OUTPUT_EXT = 6578;
/*     */   public static final int AL_DEBUG_CALLBACK_FUNCTION_EXT = 6579;
/*     */   public static final int AL_DEBUG_CALLBACK_USER_PARAM_EXT = 6580;
/*     */   public static final int AL_DEBUG_SOURCE_API_EXT = 6581;
/*     */   public static final int AL_DEBUG_SOURCE_AUDIO_SYSTEM_EXT = 6582;
/*     */   public static final int AL_DEBUG_SOURCE_THIRD_PARTY_EXT = 6583;
/*     */   public static final int AL_DEBUG_SOURCE_APPLICATION_EXT = 6584;
/*     */   public static final int AL_DEBUG_SOURCE_OTHER_EXT = 6585;
/*     */   public static final int AL_DEBUG_TYPE_ERROR_EXT = 6586;
/*     */   public static final int AL_DEBUG_TYPE_DEPRECATED_BEHAVIOR_EXT = 6587;
/*     */   public static final int AL_DEBUG_TYPE_UNDEFINED_BEHAVIOR_EXT = 6588;
/*     */   public static final int AL_DEBUG_TYPE_PORTABILITY_EXT = 6589;
/*     */   public static final int AL_DEBUG_TYPE_PERFORMANCE_EXT = 6590;
/*     */   public static final int AL_DEBUG_TYPE_MARKER_EXT = 6591;
/*     */   public static final int AL_DEBUG_TYPE_OTHER_EXT = 6594;
/*     */   public static final int AL_DEBUG_TYPE_PUSH_GROUP_EXT = 6592;
/*     */   public static final int AL_DEBUG_TYPE_POP_GROUP_EXT = 6593;
/*     */   public static final int AL_DEBUG_SEVERITY_HIGH_EXT = 6595;
/*     */   public static final int AL_DEBUG_SEVERITY_MEDIUM_EXT = 6596;
/*     */   public static final int AL_DEBUG_SEVERITY_LOW_EXT = 6597;
/*     */   public static final int AL_DEBUG_SEVERITY_NOTIFICATION_EXT = 6598;
/*     */   public static final int AL_DONT_CARE_EXT = 2;
/*     */   public static final int AL_DEBUG_LOGGED_MESSAGES_EXT = 6599;
/*     */   public static final int AL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH_EXT = 6600;
/*     */   public static final int AL_MAX_DEBUG_MESSAGE_LENGTH_EXT = 6601;
/*     */   public static final int AL_MAX_DEBUG_LOGGED_MESSAGES_EXT = 6602;
/*     */   public static final int AL_MAX_DEBUG_GROUP_STACK_DEPTH_EXT = 6603;
/*     */   public static final int AL_MAX_LABEL_LENGTH_EXT = 6604;
/*     */   public static final int AL_STACK_OVERFLOW_EXT = 6605;
/*     */   public static final int AL_STACK_UNDERFLOW_EXT = 6606;
/*     */   public static final int AL_BUFFER_EXT = 4105;
/*     */   public static final int AL_SOURCE_EXT = 6608;
/*     */   public static final int AL_FILTER_EXT = 6609;
/*     */   public static final int AL_EFFECT_EXT = 6610;
/*     */   public static final int AL_AUXILIARY_EFFECT_SLOT_EXT = 6611;
/*     */   
/*     */   protected EXTDebug() {
/*  87 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalDebugMessageCallbackEXT(long callback, long userParam) {
/*  94 */     long __functionAddress = (AL.getICD()).alDebugMessageCallbackEXT;
/*  95 */     if (Checks.CHECKS) {
/*  96 */       Checks.check(__functionAddress);
/*     */     }
/*  98 */     JNI.invokePPV(callback, userParam, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alDebugMessageCallbackEXT(@NativeType("ALDEBUGPROCEXT") EXTDebugProcI callback, @NativeType("ALvoid *") long userParam) {
/* 104 */     nalDebugMessageCallbackEXT(MemoryUtil.memAddressSafe((Pointer)callback), userParam);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalDebugMessageCallbackDirectEXT(long context, long callback, long userParam) {
/* 111 */     long __functionAddress = (AL.getICD()).alDebugMessageCallbackDirectEXT;
/* 112 */     if (Checks.CHECKS) {
/* 113 */       Checks.check(__functionAddress);
/* 114 */       Checks.check(context);
/*     */     } 
/* 116 */     JNI.invokePPPV(context, callback, userParam, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alDebugMessageCallbackDirectEXT(@NativeType("ALCcontext *") long context, @NativeType("ALDEBUGPROCEXT") EXTDebugProcI callback, @NativeType("ALvoid *") long userParam) {
/* 122 */     nalDebugMessageCallbackDirectEXT(context, MemoryUtil.memAddressSafe((Pointer)callback), userParam);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalDebugMessageInsertEXT(int source, int type, int id, int severity, int length, long message) {
/* 129 */     long __functionAddress = (AL.getICD()).alDebugMessageInsertEXT;
/* 130 */     if (Checks.CHECKS) {
/* 131 */       Checks.check(__functionAddress);
/*     */     }
/* 133 */     JNI.invokePV(source, type, id, severity, length, message, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alDebugMessageInsertEXT(@NativeType("ALenum") int source, @NativeType("ALenum") int type, @NativeType("ALuint") int id, @NativeType("ALenum") int severity, @NativeType("ALchar const *") ByteBuffer message) {
/* 139 */     nalDebugMessageInsertEXT(source, type, id, severity, message.remaining(), MemoryUtil.memAddress(message));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alDebugMessageInsertEXT(@NativeType("ALenum") int source, @NativeType("ALenum") int type, @NativeType("ALuint") int id, @NativeType("ALenum") int severity, @NativeType("ALchar const *") CharSequence message) {
/* 145 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 147 */       int messageEncodedLength = stack.nUTF8(message, false);
/* 148 */       long messageEncoded = stack.getPointerAddress();
/* 149 */       nalDebugMessageInsertEXT(source, type, id, severity, messageEncodedLength, messageEncoded);
/*     */     } finally {
/* 151 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalDebugMessageInsertDirectEXT(long context, int source, int type, int id, int severity, int length, long message) {
/* 159 */     long __functionAddress = (AL.getICD()).alDebugMessageInsertDirectEXT;
/* 160 */     if (Checks.CHECKS) {
/* 161 */       Checks.check(__functionAddress);
/* 162 */       Checks.check(context);
/*     */     } 
/* 164 */     JNI.invokePPV(context, source, type, id, severity, length, message, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alDebugMessageInsertDirectEXT(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int source, @NativeType("ALenum") int type, @NativeType("ALuint") int id, @NativeType("ALenum") int severity, @NativeType("ALchar const *") ByteBuffer message) {
/* 170 */     nalDebugMessageInsertDirectEXT(context, source, type, id, severity, message.remaining(), MemoryUtil.memAddress(message));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alDebugMessageInsertDirectEXT(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int source, @NativeType("ALenum") int type, @NativeType("ALuint") int id, @NativeType("ALenum") int severity, @NativeType("ALchar const *") CharSequence message) {
/* 176 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 178 */       int messageEncodedLength = stack.nUTF8(message, false);
/* 179 */       long messageEncoded = stack.getPointerAddress();
/* 180 */       nalDebugMessageInsertDirectEXT(context, source, type, id, severity, messageEncodedLength, messageEncoded);
/*     */     } finally {
/* 182 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalDebugMessageControlEXT(int source, int type, int severity, int count, long ids, boolean enable) {
/* 190 */     long __functionAddress = (AL.getICD()).alDebugMessageControlEXT;
/* 191 */     if (Checks.CHECKS) {
/* 192 */       Checks.check(__functionAddress);
/*     */     }
/* 194 */     JNI.invokePV(source, type, severity, count, ids, enable, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alDebugMessageControlEXT(@NativeType("ALenum") int source, @NativeType("ALenum") int type, @NativeType("ALenum") int severity, @NativeType("ALuint const *") IntBuffer ids, @NativeType("ALboolean") boolean enable) {
/* 200 */     nalDebugMessageControlEXT(source, type, severity, Checks.remainingSafe(ids), MemoryUtil.memAddressSafe(ids), enable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalDebugMessageControlDirectEXT(long context, int source, int type, int severity, int count, long ids, boolean enable) {
/* 207 */     long __functionAddress = (AL.getICD()).alDebugMessageControlDirectEXT;
/* 208 */     if (Checks.CHECKS) {
/* 209 */       Checks.check(__functionAddress);
/* 210 */       Checks.check(context);
/*     */     } 
/* 212 */     JNI.invokePPV(context, source, type, severity, count, ids, enable, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alDebugMessageControlDirectEXT(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int source, @NativeType("ALenum") int type, @NativeType("ALenum") int severity, @NativeType("ALuint const *") IntBuffer ids, @NativeType("ALboolean") boolean enable) {
/* 218 */     nalDebugMessageControlDirectEXT(context, source, type, severity, Checks.remainingSafe(ids), MemoryUtil.memAddressSafe(ids), enable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalPushDebugGroupEXT(int source, int id, int length, long message) {
/* 225 */     long __functionAddress = (AL.getICD()).alPushDebugGroupEXT;
/* 226 */     if (Checks.CHECKS) {
/* 227 */       Checks.check(__functionAddress);
/*     */     }
/* 229 */     JNI.invokePV(source, id, length, message, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alPushDebugGroupEXT(@NativeType("ALenum") int source, @NativeType("ALuint") int id, @NativeType("ALchar const *") ByteBuffer message) {
/* 235 */     nalPushDebugGroupEXT(source, id, message.remaining(), MemoryUtil.memAddress(message));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alPushDebugGroupEXT(@NativeType("ALenum") int source, @NativeType("ALuint") int id, @NativeType("ALchar const *") CharSequence message) {
/* 241 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 243 */       int messageEncodedLength = stack.nUTF8(message, false);
/* 244 */       long messageEncoded = stack.getPointerAddress();
/* 245 */       nalPushDebugGroupEXT(source, id, messageEncodedLength, messageEncoded);
/*     */     } finally {
/* 247 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalPushDebugGroupDirectEXT(long context, int source, int id, int length, long message) {
/* 255 */     long __functionAddress = (AL.getICD()).alPushDebugGroupDirectEXT;
/* 256 */     if (Checks.CHECKS) {
/* 257 */       Checks.check(__functionAddress);
/* 258 */       Checks.check(context);
/*     */     } 
/* 260 */     JNI.invokePPV(context, source, id, length, message, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alPushDebugGroupDirectEXT(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int source, @NativeType("ALuint") int id, @NativeType("ALchar const *") ByteBuffer message) {
/* 266 */     nalPushDebugGroupDirectEXT(context, source, id, message.remaining(), MemoryUtil.memAddress(message));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alPushDebugGroupDirectEXT(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int source, @NativeType("ALuint") int id, @NativeType("ALchar const *") CharSequence message) {
/* 272 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 274 */       int messageEncodedLength = stack.nUTF8(message, false);
/* 275 */       long messageEncoded = stack.getPointerAddress();
/* 276 */       nalPushDebugGroupDirectEXT(context, source, id, messageEncodedLength, messageEncoded);
/*     */     } finally {
/* 278 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alPopDebugGroupEXT() {
/* 287 */     long __functionAddress = (AL.getICD()).alPopDebugGroupEXT;
/* 288 */     if (Checks.CHECKS) {
/* 289 */       Checks.check(__functionAddress);
/*     */     }
/* 291 */     JNI.invokeV(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alPopDebugGroupDirectEXT(@NativeType("ALCcontext *") long context) {
/* 299 */     long __functionAddress = (AL.getICD()).alPopDebugGroupDirectEXT;
/* 300 */     if (Checks.CHECKS) {
/* 301 */       Checks.check(__functionAddress);
/* 302 */       Checks.check(context);
/*     */     } 
/* 304 */     JNI.invokePV(context, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nalGetDebugMessageLogEXT(int count, int logBufSize, long sources, long types, long ids, long severities, long lengths, long logBuf) {
/* 311 */     long __functionAddress = (AL.getICD()).alGetDebugMessageLogEXT;
/* 312 */     if (Checks.CHECKS) {
/* 313 */       Checks.check(__functionAddress);
/*     */     }
/* 315 */     return JNI.invokePPPPPPI(count, logBufSize, sources, types, ids, severities, lengths, logBuf, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALuint")
/*     */   public static int alGetDebugMessageLogEXT(@NativeType("ALenum *") IntBuffer sources, @NativeType("ALenum *") IntBuffer types, @NativeType("ALuint *") IntBuffer ids, @NativeType("ALenum *") IntBuffer severities, @NativeType("ALsizei *") IntBuffer lengths, @NativeType("ALchar *") ByteBuffer logBuf) {
/* 321 */     if (Checks.CHECKS) {
/* 322 */       Checks.checkSafe(types, Checks.remainingSafe(sources));
/* 323 */       Checks.checkSafe(ids, Checks.remainingSafe(sources));
/* 324 */       Checks.checkSafe(severities, Checks.remainingSafe(sources));
/* 325 */       Checks.checkSafe(lengths, Checks.remainingSafe(sources));
/*     */     } 
/* 327 */     return nalGetDebugMessageLogEXT(Checks.remainingSafe(sources), Checks.remainingSafe(logBuf), MemoryUtil.memAddressSafe(sources), MemoryUtil.memAddressSafe(types), MemoryUtil.memAddressSafe(ids), MemoryUtil.memAddressSafe(severities), MemoryUtil.memAddressSafe(lengths), MemoryUtil.memAddressSafe(logBuf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nalGetDebugMessageLogDirectEXT(long context, int count, int logBufSize, long sources, long types, long ids, long severities, long lengths, long logBuf) {
/* 334 */     long __functionAddress = (AL.getICD()).alGetDebugMessageLogDirectEXT;
/* 335 */     if (Checks.CHECKS) {
/* 336 */       Checks.check(__functionAddress);
/* 337 */       Checks.check(context);
/*     */     } 
/* 339 */     return JNI.invokePPPPPPPI(context, count, logBufSize, sources, types, ids, severities, lengths, logBuf, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALuint")
/*     */   public static int alGetDebugMessageLogDirectEXT(@NativeType("ALCcontext *") long context, @NativeType("ALenum *") IntBuffer sources, @NativeType("ALenum *") IntBuffer types, @NativeType("ALuint *") IntBuffer ids, @NativeType("ALenum *") IntBuffer severities, @NativeType("ALsizei *") IntBuffer lengths, @NativeType("ALchar *") ByteBuffer logBuf) {
/* 345 */     if (Checks.CHECKS) {
/* 346 */       Checks.checkSafe(types, Checks.remainingSafe(sources));
/* 347 */       Checks.checkSafe(ids, Checks.remainingSafe(sources));
/* 348 */       Checks.checkSafe(severities, Checks.remainingSafe(sources));
/* 349 */       Checks.checkSafe(lengths, Checks.remainingSafe(sources));
/*     */     } 
/* 351 */     return nalGetDebugMessageLogDirectEXT(context, Checks.remainingSafe(sources), Checks.remainingSafe(logBuf), MemoryUtil.memAddressSafe(sources), MemoryUtil.memAddressSafe(types), MemoryUtil.memAddressSafe(ids), MemoryUtil.memAddressSafe(severities), MemoryUtil.memAddressSafe(lengths), MemoryUtil.memAddressSafe(logBuf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalObjectLabelEXT(int identifier, int name, int length, long label) {
/* 358 */     long __functionAddress = (AL.getICD()).alObjectLabelEXT;
/* 359 */     if (Checks.CHECKS) {
/* 360 */       Checks.check(__functionAddress);
/*     */     }
/* 362 */     JNI.invokePV(identifier, name, length, label, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alObjectLabelEXT(@NativeType("ALenum") int identifier, @NativeType("ALuint") int name, @NativeType("ALchar const *") ByteBuffer label) {
/* 368 */     nalObjectLabelEXT(identifier, name, label.remaining(), MemoryUtil.memAddress(label));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alObjectLabelEXT(@NativeType("ALenum") int identifier, @NativeType("ALuint") int name, @NativeType("ALchar const *") CharSequence label) {
/* 374 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 376 */       int labelEncodedLength = stack.nUTF8(label, false);
/* 377 */       long labelEncoded = stack.getPointerAddress();
/* 378 */       nalObjectLabelEXT(identifier, name, labelEncodedLength, labelEncoded);
/*     */     } finally {
/* 380 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalObjectLabelDirectEXT(long context, int identifier, int name, int length, long label) {
/* 388 */     long __functionAddress = (AL.getICD()).alObjectLabelDirectEXT;
/* 389 */     if (Checks.CHECKS) {
/* 390 */       Checks.check(__functionAddress);
/* 391 */       Checks.check(context);
/*     */     } 
/* 393 */     JNI.invokePPV(context, identifier, name, length, label, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alObjectLabelDirectEXT(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int identifier, @NativeType("ALuint") int name, @NativeType("ALchar const *") ByteBuffer label) {
/* 399 */     nalObjectLabelDirectEXT(context, identifier, name, label.remaining(), MemoryUtil.memAddress(label));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alObjectLabelDirectEXT(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int identifier, @NativeType("ALuint") int name, @NativeType("ALchar const *") CharSequence label) {
/* 405 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 407 */       int labelEncodedLength = stack.nUTF8(label, false);
/* 408 */       long labelEncoded = stack.getPointerAddress();
/* 409 */       nalObjectLabelDirectEXT(context, identifier, name, labelEncodedLength, labelEncoded);
/*     */     } finally {
/* 411 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetObjectLabelEXT(int identifier, int name, int bufSize, long length, long label) {
/* 419 */     long __functionAddress = (AL.getICD()).alGetObjectLabelEXT;
/* 420 */     if (Checks.CHECKS) {
/* 421 */       Checks.check(__functionAddress);
/*     */     }
/* 423 */     JNI.invokePPV(identifier, name, bufSize, length, label, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetObjectLabelEXT(@NativeType("ALenum") int identifier, @NativeType("ALuint") int name, @NativeType("ALsizei *") IntBuffer length, @NativeType("ALchar *") ByteBuffer label) {
/* 429 */     if (Checks.CHECKS) {
/* 430 */       Checks.check(length, 1);
/*     */     }
/* 432 */     nalGetObjectLabelEXT(identifier, name, Checks.remainingSafe(label), MemoryUtil.memAddress(length), MemoryUtil.memAddressSafe(label));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetObjectLabelDirectEXT(long context, int identifier, int name, int bufSize, long length, long label) {
/* 439 */     long __functionAddress = (AL.getICD()).alGetObjectLabelDirectEXT;
/* 440 */     if (Checks.CHECKS) {
/* 441 */       Checks.check(__functionAddress);
/* 442 */       Checks.check(context);
/*     */     } 
/* 444 */     JNI.invokePPPV(context, identifier, name, bufSize, length, label, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetObjectLabelDirectEXT(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int identifier, @NativeType("ALuint") int name, @NativeType("ALsizei *") IntBuffer length, @NativeType("ALchar *") ByteBuffer label) {
/* 450 */     if (Checks.CHECKS) {
/* 451 */       Checks.check(length, 1);
/*     */     }
/* 453 */     nalGetObjectLabelDirectEXT(context, identifier, name, Checks.remainingSafe(label), MemoryUtil.memAddress(length), MemoryUtil.memAddressSafe(label));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid *")
/*     */   public static long alGetPointerEXT(@NativeType("ALenum") int pname) {
/* 461 */     long __functionAddress = (AL.getICD()).alGetPointerEXT;
/* 462 */     if (Checks.CHECKS) {
/* 463 */       Checks.check(__functionAddress);
/*     */     }
/* 465 */     return JNI.invokeP(pname, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid *")
/*     */   public static long alGetPointerDirectEXT(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int pname) {
/* 473 */     long __functionAddress = (AL.getICD()).alGetPointerDirectEXT;
/* 474 */     if (Checks.CHECKS) {
/* 475 */       Checks.check(__functionAddress);
/* 476 */       Checks.check(context);
/*     */     } 
/* 478 */     return JNI.invokePP(context, pname, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetPointervEXT(int pname, long values) {
/* 485 */     long __functionAddress = (AL.getICD()).alGetPointervEXT;
/* 486 */     if (Checks.CHECKS) {
/* 487 */       Checks.check(__functionAddress);
/*     */     }
/* 489 */     JNI.invokePV(pname, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetPointervEXT(@NativeType("ALenum") int pname, @NativeType("ALvoid **") PointerBuffer values) {
/* 495 */     if (Checks.CHECKS) {
/* 496 */       Checks.check((CustomBuffer)values, 1);
/*     */     }
/* 498 */     nalGetPointervEXT(pname, MemoryUtil.memAddress((CustomBuffer)values));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetPointervDirectEXT(long context, int pname, long values) {
/* 505 */     long __functionAddress = (AL.getICD()).alGetPointervDirectEXT;
/* 506 */     if (Checks.CHECKS) {
/* 507 */       Checks.check(__functionAddress);
/* 508 */       Checks.check(context);
/*     */     } 
/* 510 */     JNI.invokePPV(context, pname, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetPointervDirectEXT(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int pname, @NativeType("ALvoid **") PointerBuffer values) {
/* 516 */     if (Checks.CHECKS) {
/* 517 */       Checks.check((CustomBuffer)values, 1);
/*     */     }
/* 519 */     nalGetPointervDirectEXT(context, pname, MemoryUtil.memAddress((CustomBuffer)values));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alDebugMessageControlEXT(@NativeType("ALenum") int source, @NativeType("ALenum") int type, @NativeType("ALenum") int severity, @NativeType("ALuint const *") int[] ids, @NativeType("ALboolean") boolean enable) {
/* 525 */     long __functionAddress = (AL.getICD()).alDebugMessageControlEXT;
/* 526 */     if (Checks.CHECKS) {
/* 527 */       Checks.check(__functionAddress);
/*     */     }
/* 529 */     JNI.invokePV(source, type, severity, Checks.lengthSafe(ids), ids, enable, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alDebugMessageControlDirectEXT(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int source, @NativeType("ALenum") int type, @NativeType("ALenum") int severity, @NativeType("ALuint const *") int[] ids, @NativeType("ALboolean") boolean enable) {
/* 535 */     long __functionAddress = (AL.getICD()).alDebugMessageControlDirectEXT;
/* 536 */     if (Checks.CHECKS) {
/* 537 */       Checks.check(__functionAddress);
/* 538 */       Checks.check(context);
/*     */     } 
/* 540 */     JNI.invokePPV(context, source, type, severity, Checks.lengthSafe(ids), ids, enable, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALuint")
/*     */   public static int alGetDebugMessageLogEXT(@NativeType("ALenum *") int[] sources, @NativeType("ALenum *") int[] types, @NativeType("ALuint *") int[] ids, @NativeType("ALenum *") int[] severities, @NativeType("ALsizei *") int[] lengths, @NativeType("ALchar *") ByteBuffer logBuf) {
/* 546 */     long __functionAddress = (AL.getICD()).alGetDebugMessageLogEXT;
/* 547 */     if (Checks.CHECKS) {
/* 548 */       Checks.check(__functionAddress);
/* 549 */       Checks.checkSafe(types, Checks.lengthSafe(sources));
/* 550 */       Checks.checkSafe(ids, Checks.lengthSafe(sources));
/* 551 */       Checks.checkSafe(severities, Checks.lengthSafe(sources));
/* 552 */       Checks.checkSafe(lengths, Checks.lengthSafe(sources));
/*     */     } 
/* 554 */     return JNI.invokePPPPPPI(Checks.lengthSafe(sources), Checks.remainingSafe(logBuf), sources, types, ids, severities, lengths, MemoryUtil.memAddressSafe(logBuf), __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALuint")
/*     */   public static int alGetDebugMessageLogDirectEXT(@NativeType("ALCcontext *") long context, @NativeType("ALenum *") int[] sources, @NativeType("ALenum *") int[] types, @NativeType("ALuint *") int[] ids, @NativeType("ALenum *") int[] severities, @NativeType("ALsizei *") int[] lengths, @NativeType("ALchar *") ByteBuffer logBuf) {
/* 560 */     long __functionAddress = (AL.getICD()).alGetDebugMessageLogDirectEXT;
/* 561 */     if (Checks.CHECKS) {
/* 562 */       Checks.check(__functionAddress);
/* 563 */       Checks.check(context);
/* 564 */       Checks.checkSafe(types, Checks.lengthSafe(sources));
/* 565 */       Checks.checkSafe(ids, Checks.lengthSafe(sources));
/* 566 */       Checks.checkSafe(severities, Checks.lengthSafe(sources));
/* 567 */       Checks.checkSafe(lengths, Checks.lengthSafe(sources));
/*     */     } 
/* 569 */     return JNI.invokePPPPPPPI(context, Checks.lengthSafe(sources), Checks.remainingSafe(logBuf), sources, types, ids, severities, lengths, MemoryUtil.memAddressSafe(logBuf), __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetObjectLabelEXT(@NativeType("ALenum") int identifier, @NativeType("ALuint") int name, @NativeType("ALsizei *") int[] length, @NativeType("ALchar *") ByteBuffer label) {
/* 575 */     long __functionAddress = (AL.getICD()).alGetObjectLabelEXT;
/* 576 */     if (Checks.CHECKS) {
/* 577 */       Checks.check(__functionAddress);
/* 578 */       Checks.check(length, 1);
/*     */     } 
/* 580 */     JNI.invokePPV(identifier, name, Checks.remainingSafe(label), length, MemoryUtil.memAddressSafe(label), __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetObjectLabelDirectEXT(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int identifier, @NativeType("ALuint") int name, @NativeType("ALsizei *") int[] length, @NativeType("ALchar *") ByteBuffer label) {
/* 586 */     long __functionAddress = (AL.getICD()).alGetObjectLabelDirectEXT;
/* 587 */     if (Checks.CHECKS) {
/* 588 */       Checks.check(__functionAddress);
/* 589 */       Checks.check(context);
/* 590 */       Checks.check(length, 1);
/*     */     } 
/* 592 */     JNI.invokePPPV(context, identifier, name, Checks.remainingSafe(label), length, MemoryUtil.memAddressSafe(label), __functionAddress);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\EXTDebug.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */