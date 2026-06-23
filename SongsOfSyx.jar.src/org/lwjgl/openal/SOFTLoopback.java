/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
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
/*     */ public class SOFTLoopback
/*     */ {
/*     */   public static final int ALC_BYTE_SOFT = 5120;
/*     */   public static final int ALC_UNSIGNED_BYTE_SOFT = 5121;
/*     */   public static final int ALC_SHORT_SOFT = 5122;
/*     */   public static final int ALC_UNSIGNED_SHORT_SOFT = 5123;
/*     */   public static final int ALC_INT_SOFT = 5124;
/*     */   public static final int ALC_UNSIGNED_INT_SOFT = 5125;
/*     */   public static final int ALC_FLOAT_SOFT = 5126;
/*     */   public static final int ALC_MONO_SOFT = 5376;
/*     */   public static final int ALC_STEREO_SOFT = 5377;
/*     */   public static final int ALC_QUAD_SOFT = 5379;
/*     */   public static final int ALC_5POINT1_SOFT = 5380;
/*     */   public static final int ALC_6POINT1_SOFT = 5381;
/*     */   public static final int ALC_7POINT1_SOFT = 5382;
/*     */   public static final int ALC_FORMAT_CHANNELS_SOFT = 6544;
/*     */   public static final int ALC_FORMAT_TYPE_SOFT = 6545;
/*     */   
/*     */   protected SOFTLoopback() {
/*  43 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nalcLoopbackOpenDeviceSOFT(long deviceName) {
/*  50 */     long __functionAddress = (ALC.getICD()).alcLoopbackOpenDeviceSOFT;
/*  51 */     if (Checks.CHECKS) {
/*  52 */       Checks.check(__functionAddress);
/*     */     }
/*  54 */     return JNI.invokePP(deviceName, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCdevice *")
/*     */   public static long alcLoopbackOpenDeviceSOFT(@NativeType("ALCchar const *") ByteBuffer deviceName) {
/*  60 */     if (Checks.CHECKS) {
/*  61 */       Checks.checkNT1Safe(deviceName);
/*     */     }
/*  63 */     return nalcLoopbackOpenDeviceSOFT(MemoryUtil.memAddressSafe(deviceName));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCdevice *")
/*     */   public static long alcLoopbackOpenDeviceSOFT(@NativeType("ALCchar const *") CharSequence deviceName) {
/*  69 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  71 */       stack.nUTF8Safe(deviceName, true);
/*  72 */       long deviceNameEncoded = (deviceName == null) ? 0L : stack.getPointerAddress();
/*  73 */       return nalcLoopbackOpenDeviceSOFT(deviceNameEncoded);
/*     */     } finally {
/*  75 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCboolean")
/*     */   public static boolean alcIsRenderFormatSupportedSOFT(@NativeType("ALCdevice *") long device, @NativeType("ALCsizei") int frequency, @NativeType("ALCenum") int channels, @NativeType("ALCenum") int type) {
/*  84 */     long __functionAddress = (ALC.getICD()).alcIsRenderFormatSupportedSOFT;
/*  85 */     if (Checks.CHECKS) {
/*  86 */       Checks.check(__functionAddress);
/*  87 */       Checks.check(device);
/*     */     } 
/*  89 */     return JNI.invokePZ(device, frequency, channels, type, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalcRenderSamplesSOFT(long device, long buffer, int samples) {
/*  96 */     long __functionAddress = (ALC.getICD()).alcRenderSamplesSOFT;
/*  97 */     if (Checks.CHECKS) {
/*  98 */       Checks.check(__functionAddress);
/*  99 */       Checks.check(device);
/*     */     } 
/* 101 */     JNI.invokePPV(device, buffer, samples, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcRenderSamplesSOFT(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") ByteBuffer buffer, @NativeType("ALCsizei") int samples) {
/* 107 */     nalcRenderSamplesSOFT(device, MemoryUtil.memAddress(buffer), samples);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcRenderSamplesSOFT(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") ShortBuffer buffer, @NativeType("ALCsizei") int samples) {
/* 113 */     nalcRenderSamplesSOFT(device, MemoryUtil.memAddress(buffer), samples);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcRenderSamplesSOFT(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") IntBuffer buffer, @NativeType("ALCsizei") int samples) {
/* 119 */     nalcRenderSamplesSOFT(device, MemoryUtil.memAddress(buffer), samples);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcRenderSamplesSOFT(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") FloatBuffer buffer, @NativeType("ALCsizei") int samples) {
/* 125 */     nalcRenderSamplesSOFT(device, MemoryUtil.memAddress(buffer), samples);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcRenderSamplesSOFT(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") short[] buffer, @NativeType("ALCsizei") int samples) {
/* 131 */     long __functionAddress = (ALC.getICD()).alcRenderSamplesSOFT;
/* 132 */     if (Checks.CHECKS) {
/* 133 */       Checks.check(__functionAddress);
/* 134 */       Checks.check(device);
/*     */     } 
/* 136 */     JNI.invokePPV(device, buffer, samples, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcRenderSamplesSOFT(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") int[] buffer, @NativeType("ALCsizei") int samples) {
/* 142 */     long __functionAddress = (ALC.getICD()).alcRenderSamplesSOFT;
/* 143 */     if (Checks.CHECKS) {
/* 144 */       Checks.check(__functionAddress);
/* 145 */       Checks.check(device);
/*     */     } 
/* 147 */     JNI.invokePPV(device, buffer, samples, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcRenderSamplesSOFT(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") float[] buffer, @NativeType("ALCsizei") int samples) {
/* 153 */     long __functionAddress = (ALC.getICD()).alcRenderSamplesSOFT;
/* 154 */     if (Checks.CHECKS) {
/* 155 */       Checks.check(__functionAddress);
/* 156 */       Checks.check(device);
/*     */     } 
/* 158 */     JNI.invokePPV(device, buffer, samples, __functionAddress);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\SOFTLoopback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */