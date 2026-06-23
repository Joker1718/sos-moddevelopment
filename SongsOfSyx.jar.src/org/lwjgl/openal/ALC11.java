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
/*     */ public class ALC11
/*     */   extends ALC10
/*     */ {
/*     */   public static final int ALC_MONO_SOURCES = 4112;
/*     */   public static final int ALC_STEREO_SOURCES = 4113;
/*     */   public static final int ALC_DEFAULT_ALL_DEVICES_SPECIFIER = 4114;
/*     */   public static final int ALC_ALL_DEVICES_SPECIFIER = 4115;
/*     */   public static final int ALC_CAPTURE_DEVICE_SPECIFIER = 784;
/*     */   public static final int ALC_CAPTURE_DEFAULT_DEVICE_SPECIFIER = 785;
/*     */   public static final int ALC_CAPTURE_SAMPLES = 786;
/*     */   
/*     */   protected ALC11() {
/*  34 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nalcCaptureOpenDevice(long deviceName, int frequency, int format, int samples) {
/*  41 */     long __functionAddress = (ALC.getICD()).alcCaptureOpenDevice;
/*  42 */     if (Checks.CHECKS) {
/*  43 */       Checks.check(__functionAddress);
/*     */     }
/*  45 */     return JNI.invokePP(deviceName, frequency, format, samples, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCdevice *")
/*     */   public static long alcCaptureOpenDevice(@NativeType("ALCchar const *") ByteBuffer deviceName, @NativeType("ALCuint") int frequency, @NativeType("ALCenum") int format, @NativeType("ALCsizei") int samples) {
/*  51 */     if (Checks.CHECKS) {
/*  52 */       Checks.checkNT1Safe(deviceName);
/*     */     }
/*  54 */     return nalcCaptureOpenDevice(MemoryUtil.memAddressSafe(deviceName), frequency, format, samples);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCdevice *")
/*     */   public static long alcCaptureOpenDevice(@NativeType("ALCchar const *") CharSequence deviceName, @NativeType("ALCuint") int frequency, @NativeType("ALCenum") int format, @NativeType("ALCsizei") int samples) {
/*  60 */     MemoryStack stack = MemoryStack.stackGet(); int stackPointer = stack.getPointer();
/*     */     try {
/*  62 */       stack.nUTF8Safe(deviceName, true);
/*  63 */       long deviceNameEncoded = (deviceName == null) ? 0L : stack.getPointerAddress();
/*  64 */       return nalcCaptureOpenDevice(deviceNameEncoded, frequency, format, samples);
/*     */     } finally {
/*  66 */       stack.setPointer(stackPointer);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCboolean")
/*     */   public static boolean alcCaptureCloseDevice(@NativeType("ALCdevice *") long device) {
/*  75 */     long __functionAddress = (ALC.getICD()).alcCaptureCloseDevice;
/*  76 */     if (Checks.CHECKS) {
/*  77 */       Checks.check(__functionAddress);
/*  78 */       Checks.check(device);
/*     */     } 
/*  80 */     return JNI.invokePZ(device, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureStart(@NativeType("ALCdevice *") long device) {
/*  88 */     long __functionAddress = (ALC.getICD()).alcCaptureStart;
/*  89 */     if (Checks.CHECKS) {
/*  90 */       Checks.check(__functionAddress);
/*  91 */       Checks.check(device);
/*     */     } 
/*  93 */     JNI.invokePV(device, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureStop(@NativeType("ALCdevice *") long device) {
/* 101 */     long __functionAddress = (ALC.getICD()).alcCaptureStop;
/* 102 */     if (Checks.CHECKS) {
/* 103 */       Checks.check(__functionAddress);
/* 104 */       Checks.check(device);
/*     */     } 
/* 106 */     JNI.invokePV(device, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalcCaptureSamples(long device, long buffer, int samples) {
/* 113 */     long __functionAddress = (ALC.getICD()).alcCaptureSamples;
/* 114 */     if (Checks.CHECKS) {
/* 115 */       Checks.check(__functionAddress);
/* 116 */       Checks.check(device);
/*     */     } 
/* 118 */     JNI.invokePPV(device, buffer, samples, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") ByteBuffer buffer, @NativeType("ALCsizei") int samples) {
/* 124 */     nalcCaptureSamples(device, MemoryUtil.memAddress(buffer), samples);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") ShortBuffer buffer, @NativeType("ALCsizei") int samples) {
/* 130 */     nalcCaptureSamples(device, MemoryUtil.memAddress(buffer), samples);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") IntBuffer buffer, @NativeType("ALCsizei") int samples) {
/* 136 */     nalcCaptureSamples(device, MemoryUtil.memAddress(buffer), samples);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") FloatBuffer buffer, @NativeType("ALCsizei") int samples) {
/* 142 */     nalcCaptureSamples(device, MemoryUtil.memAddress(buffer), samples);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") short[] buffer, @NativeType("ALCsizei") int samples) {
/* 148 */     long __functionAddress = (ALC.getICD()).alcCaptureSamples;
/* 149 */     if (Checks.CHECKS) {
/* 150 */       Checks.check(__functionAddress);
/* 151 */       Checks.check(device);
/*     */     } 
/* 153 */     JNI.invokePPV(device, buffer, samples, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") int[] buffer, @NativeType("ALCsizei") int samples) {
/* 159 */     long __functionAddress = (ALC.getICD()).alcCaptureSamples;
/* 160 */     if (Checks.CHECKS) {
/* 161 */       Checks.check(__functionAddress);
/* 162 */       Checks.check(device);
/*     */     } 
/* 164 */     JNI.invokePPV(device, buffer, samples, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") float[] buffer, @NativeType("ALCsizei") int samples) {
/* 170 */     long __functionAddress = (ALC.getICD()).alcCaptureSamples;
/* 171 */     if (Checks.CHECKS) {
/* 172 */       Checks.check(__functionAddress);
/* 173 */       Checks.check(device);
/*     */     } 
/* 175 */     JNI.invokePPV(device, buffer, samples, __functionAddress);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\ALC11.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */