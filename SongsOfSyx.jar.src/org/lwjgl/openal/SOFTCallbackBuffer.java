/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
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
/*     */ public class SOFTCallbackBuffer
/*     */ {
/*     */   public static final int AL_BUFFER_CALLBACK_FUNCTION_SOFT = 6560;
/*     */   public static final int AL_BUFFER_CALLBACK_USER_PARAM_SOFT = 6561;
/*     */   
/*     */   protected SOFTCallbackBuffer() {
/*  24 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalBufferCallbackSOFT(int buffer, int format, int freq, long callback, long userptr) {
/*  31 */     long __functionAddress = (AL.getICD()).alBufferCallbackSOFT;
/*  32 */     if (Checks.CHECKS) {
/*  33 */       Checks.check(__functionAddress);
/*  34 */       Checks.check(userptr);
/*     */     } 
/*  36 */     JNI.invokePPV(buffer, format, freq, callback, userptr, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferCallbackSOFT(@NativeType("ALuint") int buffer, @NativeType("ALenum") int format, @NativeType("ALsizei") int freq, @NativeType("ALBUFFERCALLBACKTYPESOFT") SOFTCallbackBufferTypeI callback, @NativeType("ALvoid *") long userptr) {
/*  42 */     nalBufferCallbackSOFT(buffer, format, freq, callback.address(), userptr);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalBufferCallbackDirectSOFT(long context, int buffer, int format, int freq, long callback, long userptr) {
/*  49 */     long __functionAddress = (AL.getICD()).alBufferCallbackDirectSOFT;
/*  50 */     if (Checks.CHECKS) {
/*  51 */       Checks.check(__functionAddress);
/*  52 */       Checks.check(context);
/*  53 */       Checks.check(userptr);
/*     */     } 
/*  55 */     JNI.invokePPPV(context, buffer, format, freq, callback, userptr, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferCallbackDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int format, @NativeType("ALsizei") int freq, @NativeType("ALBUFFERCALLBACKTYPESOFT") SOFTCallbackBufferTypeI callback, @NativeType("ALvoid *") long userptr) {
/*  61 */     nalBufferCallbackDirectSOFT(context, buffer, format, freq, callback.address(), userptr);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBufferPtrSOFT(int buffer, int param, long ptr) {
/*  68 */     long __functionAddress = (AL.getICD()).alGetBufferPtrSOFT;
/*  69 */     if (Checks.CHECKS) {
/*  70 */       Checks.check(__functionAddress);
/*     */     }
/*  72 */     JNI.invokePV(buffer, param, ptr, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBufferPtrSOFT(@NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALvoid **") PointerBuffer ptr) {
/*  78 */     if (Checks.CHECKS) {
/*  79 */       Checks.check((CustomBuffer)ptr, 1);
/*     */     }
/*  81 */     nalGetBufferPtrSOFT(buffer, param, MemoryUtil.memAddress((CustomBuffer)ptr));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static long alGetBufferPtrSOFT(@NativeType("ALuint") int buffer, @NativeType("ALenum") int param) {
/*  87 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  89 */       PointerBuffer ptr = stack.callocPointer(1);
/*  90 */       nalGetBufferPtrSOFT(buffer, param, MemoryUtil.memAddress((CustomBuffer)ptr));
/*  91 */       return ptr.get(0);
/*     */     } finally {
/*  93 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBufferPtrDirectSOFT(long context, int buffer, int param, long ptr) {
/* 101 */     long __functionAddress = (AL.getICD()).alGetBufferPtrDirectSOFT;
/* 102 */     if (Checks.CHECKS) {
/* 103 */       Checks.check(__functionAddress);
/* 104 */       Checks.check(context);
/*     */     } 
/* 106 */     JNI.invokePPV(context, buffer, param, ptr, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBufferPtrDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALvoid **") PointerBuffer ptr) {
/* 112 */     if (Checks.CHECKS) {
/* 113 */       Checks.check((CustomBuffer)ptr, 1);
/*     */     }
/* 115 */     nalGetBufferPtrDirectSOFT(context, buffer, param, MemoryUtil.memAddress((CustomBuffer)ptr));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static long alGetBufferPtrDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int param) {
/* 121 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/* 123 */       PointerBuffer ptr = stack.callocPointer(1);
/* 124 */       nalGetBufferPtrDirectSOFT(context, buffer, param, MemoryUtil.memAddress((CustomBuffer)ptr));
/* 125 */       return ptr.get(0);
/*     */     } finally {
/* 127 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBuffer3PtrSOFT(int buffer, int param, long ptr0, long ptr1, long ptr2) {
/* 135 */     long __functionAddress = (AL.getICD()).alGetBuffer3PtrSOFT;
/* 136 */     if (Checks.CHECKS) {
/* 137 */       Checks.check(__functionAddress);
/*     */     }
/* 139 */     JNI.invokePPPV(buffer, param, ptr0, ptr1, ptr2, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBuffer3PtrSOFT(@NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALvoid **") PointerBuffer ptr0, @NativeType("ALvoid **") PointerBuffer ptr1, @NativeType("ALvoid **") PointerBuffer ptr2) {
/* 145 */     if (Checks.CHECKS) {
/* 146 */       Checks.check((CustomBuffer)ptr0, 1);
/* 147 */       Checks.check((CustomBuffer)ptr1, 1);
/* 148 */       Checks.check((CustomBuffer)ptr2, 1);
/*     */     } 
/* 150 */     nalGetBuffer3PtrSOFT(buffer, param, MemoryUtil.memAddress((CustomBuffer)ptr0), MemoryUtil.memAddress((CustomBuffer)ptr1), MemoryUtil.memAddress((CustomBuffer)ptr2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBuffer3PtrDirectSOFT(long context, int buffer, int param, long ptr0, long ptr1, long ptr2) {
/* 157 */     long __functionAddress = (AL.getICD()).alGetBuffer3PtrDirectSOFT;
/* 158 */     if (Checks.CHECKS) {
/* 159 */       Checks.check(__functionAddress);
/* 160 */       Checks.check(context);
/*     */     } 
/* 162 */     JNI.invokePPPPV(context, buffer, param, ptr0, ptr1, ptr2, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBuffer3PtrDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALvoid **") PointerBuffer ptr0, @NativeType("ALvoid **") PointerBuffer ptr1, @NativeType("ALvoid **") PointerBuffer ptr2) {
/* 168 */     if (Checks.CHECKS) {
/* 169 */       Checks.check((CustomBuffer)ptr0, 1);
/* 170 */       Checks.check((CustomBuffer)ptr1, 1);
/* 171 */       Checks.check((CustomBuffer)ptr2, 1);
/*     */     } 
/* 173 */     nalGetBuffer3PtrDirectSOFT(context, buffer, param, MemoryUtil.memAddress((CustomBuffer)ptr0), MemoryUtil.memAddress((CustomBuffer)ptr1), MemoryUtil.memAddress((CustomBuffer)ptr2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBufferPtrvSOFT(int buffer, int param, long ptr) {
/* 180 */     long __functionAddress = (AL.getICD()).alGetBufferPtrvSOFT;
/* 181 */     if (Checks.CHECKS) {
/* 182 */       Checks.check(__functionAddress);
/*     */     }
/* 184 */     JNI.invokePV(buffer, param, ptr, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBufferPtrvSOFT(@NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALvoid **") PointerBuffer ptr) {
/* 190 */     if (Checks.CHECKS) {
/* 191 */       Checks.check((CustomBuffer)ptr, 1);
/*     */     }
/* 193 */     nalGetBufferPtrvSOFT(buffer, param, MemoryUtil.memAddress((CustomBuffer)ptr));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBufferPtrvDirectSOFT(long context, int buffer, int param, long ptr) {
/* 200 */     long __functionAddress = (AL.getICD()).alGetBufferPtrvDirectSOFT;
/* 201 */     if (Checks.CHECKS) {
/* 202 */       Checks.check(__functionAddress);
/* 203 */       Checks.check(context);
/*     */     } 
/* 205 */     JNI.invokePPV(context, buffer, param, ptr, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alGetBufferPtrvDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int param, @NativeType("ALvoid **") PointerBuffer ptr) {
/* 211 */     if (Checks.CHECKS) {
/* 212 */       Checks.check((CustomBuffer)ptr, 1);
/*     */     }
/* 214 */     nalGetBufferPtrvDirectSOFT(context, buffer, param, MemoryUtil.memAddress((CustomBuffer)ptr));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\SOFTCallbackBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */