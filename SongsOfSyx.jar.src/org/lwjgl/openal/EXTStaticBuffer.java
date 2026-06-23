/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EXTStaticBuffer
/*     */ {
/*     */   protected EXTStaticBuffer() {
/*  19 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalBufferDataStatic(int buffer, int format, long data, int len, int freq) {
/*  26 */     long __functionAddress = (AL.getICD()).alBufferDataStatic;
/*  27 */     if (Checks.CHECKS) {
/*  28 */       Checks.check(__functionAddress);
/*     */     }
/*  30 */     JNI.invokePV(buffer, format, data, len, freq, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStatic(@NativeType("ALint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid *") ByteBuffer data, @NativeType("ALsizei") int freq) {
/*  36 */     nalBufferDataStatic(buffer, format, MemoryUtil.memAddress(data), data.remaining(), freq);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStatic(@NativeType("ALint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid *") ShortBuffer data, @NativeType("ALsizei") int freq) {
/*  42 */     nalBufferDataStatic(buffer, format, MemoryUtil.memAddress(data), data.remaining() << 1, freq);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStatic(@NativeType("ALint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid *") IntBuffer data, @NativeType("ALsizei") int freq) {
/*  48 */     nalBufferDataStatic(buffer, format, MemoryUtil.memAddress(data), data.remaining() << 2, freq);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStatic(@NativeType("ALint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid *") FloatBuffer data, @NativeType("ALsizei") int freq) {
/*  54 */     nalBufferDataStatic(buffer, format, MemoryUtil.memAddress(data), data.remaining() << 2, freq);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalBufferDataStaticDirect(long context, int buffer, int format, long data, int len, int freq) {
/*  61 */     long __functionAddress = (AL.getICD()).alBufferDataStaticDirect;
/*  62 */     if (Checks.CHECKS) {
/*  63 */       Checks.check(__functionAddress);
/*  64 */       Checks.check(context);
/*     */     } 
/*  66 */     JNI.invokePPV(context, buffer, format, data, len, freq, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStaticDirect(@NativeType("ALCcontext *") long context, @NativeType("ALint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid *") ByteBuffer data, @NativeType("ALsizei") int freq) {
/*  72 */     nalBufferDataStaticDirect(context, buffer, format, MemoryUtil.memAddress(data), data.remaining(), freq);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStaticDirect(@NativeType("ALCcontext *") long context, @NativeType("ALint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid *") ShortBuffer data, @NativeType("ALsizei") int freq) {
/*  78 */     nalBufferDataStaticDirect(context, buffer, format, MemoryUtil.memAddress(data), data.remaining() << 1, freq);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStaticDirect(@NativeType("ALCcontext *") long context, @NativeType("ALint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid *") IntBuffer data, @NativeType("ALsizei") int freq) {
/*  84 */     nalBufferDataStaticDirect(context, buffer, format, MemoryUtil.memAddress(data), data.remaining() << 2, freq);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStaticDirect(@NativeType("ALCcontext *") long context, @NativeType("ALint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid *") FloatBuffer data, @NativeType("ALsizei") int freq) {
/*  90 */     nalBufferDataStaticDirect(context, buffer, format, MemoryUtil.memAddress(data), data.remaining() << 2, freq);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStatic(@NativeType("ALint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid *") short[] data, @NativeType("ALsizei") int freq) {
/*  96 */     long __functionAddress = (AL.getICD()).alBufferDataStatic;
/*  97 */     if (Checks.CHECKS) {
/*  98 */       Checks.check(__functionAddress);
/*     */     }
/* 100 */     JNI.invokePV(buffer, format, data, data.length << 1, freq, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStatic(@NativeType("ALint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid *") int[] data, @NativeType("ALsizei") int freq) {
/* 106 */     long __functionAddress = (AL.getICD()).alBufferDataStatic;
/* 107 */     if (Checks.CHECKS) {
/* 108 */       Checks.check(__functionAddress);
/*     */     }
/* 110 */     JNI.invokePV(buffer, format, data, data.length << 2, freq, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStatic(@NativeType("ALint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid *") float[] data, @NativeType("ALsizei") int freq) {
/* 116 */     long __functionAddress = (AL.getICD()).alBufferDataStatic;
/* 117 */     if (Checks.CHECKS) {
/* 118 */       Checks.check(__functionAddress);
/*     */     }
/* 120 */     JNI.invokePV(buffer, format, data, data.length << 2, freq, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStaticDirect(@NativeType("ALCcontext *") long context, @NativeType("ALint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid *") short[] data, @NativeType("ALsizei") int freq) {
/* 126 */     long __functionAddress = (AL.getICD()).alBufferDataStaticDirect;
/* 127 */     if (Checks.CHECKS) {
/* 128 */       Checks.check(__functionAddress);
/* 129 */       Checks.check(context);
/*     */     } 
/* 131 */     JNI.invokePPV(context, buffer, format, data, data.length << 1, freq, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStaticDirect(@NativeType("ALCcontext *") long context, @NativeType("ALint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid *") int[] data, @NativeType("ALsizei") int freq) {
/* 137 */     long __functionAddress = (AL.getICD()).alBufferDataStaticDirect;
/* 138 */     if (Checks.CHECKS) {
/* 139 */       Checks.check(__functionAddress);
/* 140 */       Checks.check(context);
/*     */     } 
/* 142 */     JNI.invokePPV(context, buffer, format, data, data.length << 2, freq, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStaticDirect(@NativeType("ALCcontext *") long context, @NativeType("ALint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid *") float[] data, @NativeType("ALsizei") int freq) {
/* 148 */     long __functionAddress = (AL.getICD()).alBufferDataStaticDirect;
/* 149 */     if (Checks.CHECKS) {
/* 150 */       Checks.check(__functionAddress);
/* 151 */       Checks.check(context);
/*     */     } 
/* 153 */     JNI.invokePPV(context, buffer, format, data, data.length << 2, freq, __functionAddress);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\EXTStaticBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */