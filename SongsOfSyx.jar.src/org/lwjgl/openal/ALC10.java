/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
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
/*     */ public class ALC10
/*     */ {
/*     */   public static final int ALC_INVALID = -1;
/*     */   public static final int ALC_FALSE = 0;
/*     */   public static final int ALC_TRUE = 1;
/*     */   public static final int ALC_FREQUENCY = 4103;
/*     */   public static final int ALC_REFRESH = 4104;
/*     */   public static final int ALC_SYNC = 4105;
/*     */   public static final int ALC_NO_ERROR = 0;
/*     */   public static final int ALC_INVALID_DEVICE = 40961;
/*     */   public static final int ALC_INVALID_CONTEXT = 40962;
/*     */   public static final int ALC_INVALID_ENUM = 40963;
/*     */   public static final int ALC_INVALID_VALUE = 40964;
/*     */   public static final int ALC_OUT_OF_MEMORY = 40965;
/*     */   public static final int ALC_DEFAULT_DEVICE_SPECIFIER = 4100;
/*     */   public static final int ALC_DEVICE_SPECIFIER = 4101;
/*     */   public static final int ALC_EXTENSIONS = 4102;
/*     */   public static final int ALC_MAJOR_VERSION = 4096;
/*     */   public static final int ALC_MINOR_VERSION = 4097;
/*     */   public static final int ALC_ATTRIBUTES_SIZE = 4098;
/*     */   public static final int ALC_ALL_ATTRIBUTES = 4099;
/*     */   
/*     */   protected ALC10() {
/*  51 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nalcOpenDevice(long deviceSpecifier) {
/*  58 */     long __functionAddress = (ALC.getICD()).alcOpenDevice;
/*  59 */     return JNI.invokePP(deviceSpecifier, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCdevice *")
/*     */   public static long alcOpenDevice(@NativeType("ALCchar const *") ByteBuffer deviceSpecifier) {
/*  65 */     if (Checks.CHECKS) {
/*  66 */       Checks.checkNT1Safe(deviceSpecifier);
/*     */     }
/*  68 */     return nalcOpenDevice(MemoryUtil.memAddressSafe(deviceSpecifier));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCdevice *")
/*     */   public static long alcOpenDevice(@NativeType("ALCchar const *") CharSequence deviceSpecifier) {
/*  74 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  76 */       stack.nUTF8Safe(deviceSpecifier, true);
/*  77 */       long deviceSpecifierEncoded = (deviceSpecifier == null) ? 0L : stack.getPointerAddress();
/*  78 */       return nalcOpenDevice(deviceSpecifierEncoded);
/*     */     } finally {
/*  80 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCboolean")
/*     */   public static boolean alcCloseDevice(@NativeType("ALCdevice const *") long deviceHandle) {
/*  89 */     long __functionAddress = (ALC.getICD()).alcCloseDevice;
/*  90 */     if (Checks.CHECKS) {
/*  91 */       Checks.check(deviceHandle);
/*     */     }
/*  93 */     return JNI.invokePZ(deviceHandle, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nalcCreateContext(long deviceHandle, long attrList) {
/* 100 */     long __functionAddress = (ALC.getICD()).alcCreateContext;
/* 101 */     if (Checks.CHECKS) {
/* 102 */       Checks.check(deviceHandle);
/*     */     }
/* 104 */     return JNI.invokePPP(deviceHandle, attrList, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCcontext *")
/*     */   public static long alcCreateContext(@NativeType("ALCdevice const *") long deviceHandle, @NativeType("ALCint const *") IntBuffer attrList) {
/* 110 */     if (Checks.CHECKS) {
/* 111 */       Checks.checkNTSafe(attrList);
/*     */     }
/* 113 */     return nalcCreateContext(deviceHandle, MemoryUtil.memAddressSafe(attrList));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCboolean")
/*     */   public static boolean alcMakeContextCurrent(@NativeType("ALCcontext *") long context) {
/* 121 */     long __functionAddress = (ALC.getICD()).alcMakeContextCurrent;
/* 122 */     return JNI.invokePZ(context, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcProcessContext(@NativeType("ALCcontext *") long context) {
/* 130 */     long __functionAddress = (ALC.getICD()).alcProcessContext;
/* 131 */     if (Checks.CHECKS) {
/* 132 */       Checks.check(context);
/*     */     }
/* 134 */     JNI.invokePV(context, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcSuspendContext(@NativeType("ALCcontext *") long context) {
/* 142 */     long __functionAddress = (ALC.getICD()).alcSuspendContext;
/* 143 */     if (Checks.CHECKS) {
/* 144 */       Checks.check(context);
/*     */     }
/* 146 */     JNI.invokePV(context, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcDestroyContext(@NativeType("ALCcontext *") long context) {
/* 154 */     long __functionAddress = (ALC.getICD()).alcDestroyContext;
/* 155 */     if (Checks.CHECKS) {
/* 156 */       Checks.check(context);
/*     */     }
/* 158 */     JNI.invokePV(context, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCcontext *")
/*     */   public static long alcGetCurrentContext() {
/* 166 */     long __functionAddress = (ALC.getICD()).alcGetCurrentContext;
/* 167 */     return JNI.invokeP(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCdevice *")
/*     */   public static long alcGetContextsDevice(@NativeType("ALCcontext *") long context) {
/* 175 */     long __functionAddress = (ALC.getICD()).alcGetContextsDevice;
/* 176 */     if (Checks.CHECKS) {
/* 177 */       Checks.check(context);
/*     */     }
/* 179 */     return JNI.invokePP(context, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean nalcIsExtensionPresent(long deviceHandle, long extName) {
/* 186 */     long __functionAddress = (ALC.getICD()).alcIsExtensionPresent;
/* 187 */     return JNI.invokePPZ(deviceHandle, extName, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCboolean")
/*     */   public static boolean alcIsExtensionPresent(@NativeType("ALCdevice const *") long deviceHandle, @NativeType("ALCchar const *") ByteBuffer extName) {
/* 193 */     if (Checks.CHECKS) {
/* 194 */       Checks.checkNT1(extName);
/*     */     }
/* 196 */     return nalcIsExtensionPresent(deviceHandle, MemoryUtil.memAddress(extName));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCboolean")
/*     */   public static boolean alcIsExtensionPresent(@NativeType("ALCdevice const *") long deviceHandle, @NativeType("ALCchar const *") CharSequence extName) {
/* 202 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 204 */       stack.nASCII(extName, true);
/* 205 */       long extNameEncoded = stack.getPointerAddress();
/* 206 */       return nalcIsExtensionPresent(deviceHandle, extNameEncoded);
/*     */     } finally {
/* 208 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nalcGetProcAddress(long deviceHandle, long funcName) {
/* 216 */     long __functionAddress = (ALC.getICD()).alcGetProcAddress;
/* 217 */     return JNI.invokePPP(deviceHandle, funcName, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid *")
/*     */   public static long alcGetProcAddress(@NativeType("ALCdevice const *") long deviceHandle, @NativeType("ALchar const *") ByteBuffer funcName) {
/* 223 */     if (Checks.CHECKS) {
/* 224 */       Checks.checkNT1(funcName);
/*     */     }
/* 226 */     return nalcGetProcAddress(deviceHandle, MemoryUtil.memAddress(funcName));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid *")
/*     */   public static long alcGetProcAddress(@NativeType("ALCdevice const *") long deviceHandle, @NativeType("ALchar const *") CharSequence funcName) {
/* 232 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 234 */       stack.nASCII(funcName, true);
/* 235 */       long funcNameEncoded = stack.getPointerAddress();
/* 236 */       return nalcGetProcAddress(deviceHandle, funcNameEncoded);
/*     */     } finally {
/* 238 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nalcGetEnumValue(long deviceHandle, long enumName) {
/* 246 */     long __functionAddress = (ALC.getICD()).alcGetEnumValue;
/* 247 */     return JNI.invokePPI(deviceHandle, enumName, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCenum")
/*     */   public static int alcGetEnumValue(@NativeType("ALCdevice const *") long deviceHandle, @NativeType("ALCchar const *") ByteBuffer enumName) {
/* 253 */     if (Checks.CHECKS) {
/* 254 */       Checks.checkNT1(enumName);
/*     */     }
/* 256 */     return nalcGetEnumValue(deviceHandle, MemoryUtil.memAddress(enumName));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCenum")
/*     */   public static int alcGetEnumValue(@NativeType("ALCdevice const *") long deviceHandle, @NativeType("ALCchar const *") CharSequence enumName) {
/* 262 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 264 */       stack.nASCII(enumName, true);
/* 265 */       long enumNameEncoded = stack.getPointerAddress();
/* 266 */       return nalcGetEnumValue(deviceHandle, enumNameEncoded);
/*     */     } finally {
/* 268 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCenum")
/*     */   public static int alcGetError(@NativeType("ALCdevice *") long deviceHandle) {
/* 277 */     long __functionAddress = (ALC.getICD()).alcGetError;
/* 278 */     return JNI.invokePI(deviceHandle, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nalcGetString(long deviceHandle, int token) {
/* 285 */     long __functionAddress = (ALC.getICD()).alcGetString;
/* 286 */     return JNI.invokePP(deviceHandle, token, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCchar const *")
/*     */   public static String alcGetString(@NativeType("ALCdevice *") long deviceHandle, @NativeType("ALCenum") int token) {
/* 292 */     long __result = nalcGetString(deviceHandle, token);
/* 293 */     return MemoryUtil.memUTF8Safe(__result);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalcGetIntegerv(long deviceHandle, int token, int size, long dest) {
/* 300 */     long __functionAddress = (ALC.getICD()).alcGetIntegerv;
/* 301 */     JNI.invokePPV(deviceHandle, token, size, dest, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcGetIntegerv(@NativeType("ALCdevice *") long deviceHandle, @NativeType("ALCenum") int token, @NativeType("ALCint *") IntBuffer dest) {
/* 307 */     nalcGetIntegerv(deviceHandle, token, dest.remaining(), MemoryUtil.memAddress(dest));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static int alcGetInteger(@NativeType("ALCdevice *") long deviceHandle, @NativeType("ALCenum") int token) {
/* 313 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 315 */       IntBuffer dest = stack.callocInt(1);
/* 316 */       nalcGetIntegerv(deviceHandle, token, 1, MemoryUtil.memAddress(dest));
/* 317 */       return dest.get(0);
/*     */     } finally {
/* 319 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCcontext *")
/*     */   public static long alcCreateContext(@NativeType("ALCdevice const *") long deviceHandle, @NativeType("ALCint const *") int[] attrList) {
/* 326 */     long __functionAddress = (ALC.getICD()).alcCreateContext;
/* 327 */     if (Checks.CHECKS) {
/* 328 */       Checks.check(deviceHandle);
/* 329 */       Checks.checkNTSafe(attrList);
/*     */     } 
/* 331 */     return JNI.invokePPP(deviceHandle, attrList, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcGetIntegerv(@NativeType("ALCdevice *") long deviceHandle, @NativeType("ALCenum") int token, @NativeType("ALCint *") int[] dest) {
/* 337 */     long __functionAddress = (ALC.getICD()).alcGetIntegerv;
/* 338 */     JNI.invokePPV(deviceHandle, token, dest.length, dest, __functionAddress);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\ALC10.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */