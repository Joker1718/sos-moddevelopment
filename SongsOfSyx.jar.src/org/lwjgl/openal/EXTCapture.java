/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
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
/*     */ public class EXTCapture
/*     */ {
/*     */   public static final int ALC_CAPTURE_DEVICE_SPECIFIER = 784;
/*     */   public static final int ALC_CAPTURE_DEFAULT_DEVICE_SPECIFIER = 785;
/*     */   public static final int ALC_CAPTURE_SAMPLES = 786;
/*     */   
/*     */   protected EXTCapture() {
/*  25 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nalcCaptureOpenDevice(long deviceName, int frequency, int format, int samples) {
/*  32 */     return ALC11.nalcCaptureOpenDevice(deviceName, frequency, format, samples);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCdevice *")
/*     */   public static long alcCaptureOpenDevice(@NativeType("ALCchar const *") ByteBuffer deviceName, @NativeType("ALCuint") int frequency, @NativeType("ALCenum") int format, @NativeType("ALCsizei") int samples) {
/*  38 */     return ALC11.alcCaptureOpenDevice(deviceName, frequency, format, samples);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCdevice *")
/*     */   public static long alcCaptureOpenDevice(@NativeType("ALCchar const *") CharSequence deviceName, @NativeType("ALCuint") int frequency, @NativeType("ALCenum") int format, @NativeType("ALCsizei") int samples) {
/*  44 */     return ALC11.alcCaptureOpenDevice(deviceName, frequency, format, samples);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCboolean")
/*     */   public static boolean alcCaptureCloseDevice(@NativeType("ALCdevice *") long device) {
/*  52 */     return ALC11.alcCaptureCloseDevice(device);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureStart(@NativeType("ALCdevice *") long device) {
/*  60 */     ALC11.alcCaptureStart(device);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureStop(@NativeType("ALCdevice *") long device) {
/*  68 */     ALC11.alcCaptureStop(device);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalcCaptureSamples(long device, long buffer, int samples) {
/*  75 */     ALC11.nalcCaptureSamples(device, buffer, samples);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") ByteBuffer buffer, @NativeType("ALCsizei") int samples) {
/*  81 */     ALC11.alcCaptureSamples(device, buffer, samples);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") ShortBuffer buffer, @NativeType("ALCsizei") int samples) {
/*  87 */     ALC11.alcCaptureSamples(device, buffer, samples);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") IntBuffer buffer, @NativeType("ALCsizei") int samples) {
/*  93 */     ALC11.alcCaptureSamples(device, buffer, samples);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") FloatBuffer buffer, @NativeType("ALCsizei") int samples) {
/*  99 */     ALC11.alcCaptureSamples(device, buffer, samples);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") short[] buffer, @NativeType("ALCsizei") int samples) {
/* 105 */     ALC11.alcCaptureSamples(device, buffer, samples);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") int[] buffer, @NativeType("ALCsizei") int samples) {
/* 111 */     ALC11.alcCaptureSamples(device, buffer, samples);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long device, @NativeType("ALCvoid *") float[] buffer, @NativeType("ALCsizei") int samples) {
/* 117 */     ALC11.alcCaptureSamples(device, buffer, samples);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\EXTCapture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */