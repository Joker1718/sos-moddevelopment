/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.JNI;
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
/*     */ public class SOFTEvents
/*     */ {
/*     */   public static final int AL_EVENT_CALLBACK_FUNCTION_SOFT = 6562;
/*     */   public static final int AL_EVENT_CALLBACK_USER_PARAM_SOFT = 6563;
/*     */   public static final int AL_EVENT_TYPE_BUFFER_COMPLETED_SOFT = 6564;
/*     */   public static final int AL_EVENT_TYPE_SOURCE_STATE_CHANGED_SOFT = 6565;
/*     */   public static final int AL_EVENT_TYPE_DISCONNECTED_SOFT = 6566;
/*     */   
/*     */   protected SOFTEvents() {
/*  32 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalEventControlSOFT(int count, long types, boolean enable) {
/*  39 */     long __functionAddress = (AL.getICD()).alEventControlSOFT;
/*  40 */     if (Checks.CHECKS) {
/*  41 */       Checks.check(__functionAddress);
/*     */     }
/*  43 */     JNI.invokePV(count, types, enable, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alEventControlSOFT(@NativeType("ALenum const *") IntBuffer types, @NativeType("ALboolean") boolean enable) {
/*  48 */     nalEventControlSOFT(types.remaining(), MemoryUtil.memAddress(types), enable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalEventControlDirectSOFT(long context, int count, long types, boolean enable) {
/*  55 */     long __functionAddress = (AL.getICD()).alEventControlDirectSOFT;
/*  56 */     if (Checks.CHECKS) {
/*  57 */       Checks.check(__functionAddress);
/*  58 */       Checks.check(context);
/*     */     } 
/*  60 */     JNI.invokePPV(context, count, types, enable, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alEventControlDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALenum const *") IntBuffer types, @NativeType("ALboolean") boolean enable) {
/*  65 */     nalEventControlDirectSOFT(context, types.remaining(), MemoryUtil.memAddress(types), enable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalEventCallbackSOFT(long callback, long userParam) {
/*  72 */     long __functionAddress = (AL.getICD()).alEventCallbackSOFT;
/*  73 */     if (Checks.CHECKS) {
/*  74 */       Checks.check(__functionAddress);
/*     */     }
/*  76 */     JNI.invokePPV(callback, userParam, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alEventCallbackSOFT(@NativeType("ALEVENTPROCSOFT") SOFTEventProcI callback, @NativeType("ALvoid *") long userParam) {
/*  81 */     nalEventCallbackSOFT(MemoryUtil.memAddressSafe((Pointer)callback), userParam);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalEventCallbackDirectSOFT(long context, long callback, long userParam) {
/*  88 */     long __functionAddress = (AL.getICD()).alEventCallbackDirectSOFT;
/*  89 */     if (Checks.CHECKS) {
/*  90 */       Checks.check(__functionAddress);
/*  91 */       Checks.check(context);
/*     */     } 
/*  93 */     JNI.invokePPPV(context, callback, userParam, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alEventCallbackDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALEVENTPROCSOFT") SOFTEventProcI callback, @NativeType("ALvoid *") long userParam) {
/*  98 */     nalEventCallbackDirectSOFT(context, MemoryUtil.memAddressSafe((Pointer)callback), userParam);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid *")
/*     */   public static long alGetPointerSOFT(@NativeType("ALenum") int pname) {
/* 106 */     long __functionAddress = (AL.getICD()).alGetPointerSOFT;
/* 107 */     if (Checks.CHECKS) {
/* 108 */       Checks.check(__functionAddress);
/*     */     }
/* 110 */     return JNI.invokeP(pname, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid *")
/*     */   public static long alGetPointerDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int pname) {
/* 118 */     long __functionAddress = (AL.getICD()).alGetPointerDirectSOFT;
/* 119 */     if (Checks.CHECKS) {
/* 120 */       Checks.check(__functionAddress);
/* 121 */       Checks.check(context);
/*     */     } 
/* 123 */     return JNI.invokePP(context, pname, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetPointervSOFT(int pname, long values) {
/* 130 */     long __functionAddress = (AL.getICD()).alGetPointervSOFT;
/* 131 */     if (Checks.CHECKS) {
/* 132 */       Checks.check(__functionAddress);
/*     */     }
/* 134 */     JNI.invokePV(pname, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alGetPointervSOFT(@NativeType("ALenum") int pname, @NativeType("ALvoid **") PointerBuffer values) {
/* 139 */     if (Checks.CHECKS) {
/* 140 */       Checks.check((CustomBuffer)values, 1);
/*     */     }
/* 142 */     nalGetPointervSOFT(pname, MemoryUtil.memAddress((CustomBuffer)values));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetPointervDirectSOFT(long context, int pname, long values) {
/* 149 */     long __functionAddress = (AL.getICD()).alGetPointervDirectSOFT;
/* 150 */     if (Checks.CHECKS) {
/* 151 */       Checks.check(__functionAddress);
/* 152 */       Checks.check(context);
/*     */     } 
/* 154 */     JNI.invokePPV(context, pname, values, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alGetPointervDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALenum") int pname, @NativeType("ALvoid **") PointerBuffer values) {
/* 159 */     if (Checks.CHECKS) {
/* 160 */       Checks.check((CustomBuffer)values, 1);
/*     */     }
/* 162 */     nalGetPointervDirectSOFT(context, pname, MemoryUtil.memAddress((CustomBuffer)values));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alEventControlSOFT(@NativeType("ALenum const *") int[] types, @NativeType("ALboolean") boolean enable) {
/* 167 */     long __functionAddress = (AL.getICD()).alEventControlSOFT;
/* 168 */     if (Checks.CHECKS) {
/* 169 */       Checks.check(__functionAddress);
/*     */     }
/* 171 */     JNI.invokePV(types.length, types, enable, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alEventControlDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALenum const *") int[] types, @NativeType("ALboolean") boolean enable) {
/* 176 */     long __functionAddress = (AL.getICD()).alEventControlDirectSOFT;
/* 177 */     if (Checks.CHECKS) {
/* 178 */       Checks.check(__functionAddress);
/* 179 */       Checks.check(context);
/*     */     } 
/* 181 */     JNI.invokePPV(context, types.length, types, enable, __functionAddress);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\SOFTEvents.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */