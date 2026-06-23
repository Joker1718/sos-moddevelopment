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
/*     */ 
/*     */ public class SOFTBufferSubData
/*     */ {
/*     */   public static final int AL_BYTE_RW_OFFSETS_SOFT = 4145;
/*     */   public static final int AL_SAMPLE_RW_OFFSETS_SOFT = 4146;
/*     */   
/*     */   protected SOFTBufferSubData() {
/*  23 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalBufferSubDataSOFT(int buffer, int format, long data, int offset, int length) {
/*  30 */     long __functionAddress = (AL.getICD()).alBufferSubDataSOFT;
/*  31 */     if (Checks.CHECKS) {
/*  32 */       Checks.check(__functionAddress);
/*     */     }
/*  34 */     JNI.invokePV(buffer, format, data, offset, length, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubDataSOFT(@NativeType("ALuint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid const *") ByteBuffer data, @NativeType("ALsizei") int offset) {
/*  39 */     nalBufferSubDataSOFT(buffer, format, MemoryUtil.memAddress(data), offset, data.remaining());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubDataSOFT(@NativeType("ALuint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid const *") ShortBuffer data, @NativeType("ALsizei") int offset) {
/*  44 */     nalBufferSubDataSOFT(buffer, format, MemoryUtil.memAddress(data), offset, data.remaining() << 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubDataSOFT(@NativeType("ALuint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid const *") IntBuffer data, @NativeType("ALsizei") int offset) {
/*  49 */     nalBufferSubDataSOFT(buffer, format, MemoryUtil.memAddress(data), offset, data.remaining() << 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubDataSOFT(@NativeType("ALuint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid const *") FloatBuffer data, @NativeType("ALsizei") int offset) {
/*  54 */     nalBufferSubDataSOFT(buffer, format, MemoryUtil.memAddress(data), offset, data.remaining() << 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalBufferSubDataDirectSOFT(long context, int buffer, int format, long data, int offset, int length) {
/*  61 */     long __functionAddress = (AL.getICD()).alBufferSubDataDirectSOFT;
/*  62 */     if (Checks.CHECKS) {
/*  63 */       Checks.check(__functionAddress);
/*  64 */       Checks.check(context);
/*     */     } 
/*  66 */     JNI.invokePPV(context, buffer, format, data, offset, length, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubDataDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid const *") ByteBuffer data, @NativeType("ALsizei") int offset) {
/*  71 */     nalBufferSubDataDirectSOFT(context, buffer, format, MemoryUtil.memAddress(data), offset, data.remaining());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubDataDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid const *") ShortBuffer data, @NativeType("ALsizei") int offset) {
/*  76 */     nalBufferSubDataDirectSOFT(context, buffer, format, MemoryUtil.memAddress(data), offset, data.remaining() << 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubDataDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid const *") IntBuffer data, @NativeType("ALsizei") int offset) {
/*  81 */     nalBufferSubDataDirectSOFT(context, buffer, format, MemoryUtil.memAddress(data), offset, data.remaining() << 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubDataDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid const *") FloatBuffer data, @NativeType("ALsizei") int offset) {
/*  86 */     nalBufferSubDataDirectSOFT(context, buffer, format, MemoryUtil.memAddress(data), offset, data.remaining() << 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubDataSOFT(@NativeType("ALuint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid const *") short[] data, @NativeType("ALsizei") int offset) {
/*  91 */     long __functionAddress = (AL.getICD()).alBufferSubDataSOFT;
/*  92 */     if (Checks.CHECKS) {
/*  93 */       Checks.check(__functionAddress);
/*     */     }
/*  95 */     JNI.invokePV(buffer, format, data, offset, data.length << 1, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubDataSOFT(@NativeType("ALuint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid const *") int[] data, @NativeType("ALsizei") int offset) {
/* 100 */     long __functionAddress = (AL.getICD()).alBufferSubDataSOFT;
/* 101 */     if (Checks.CHECKS) {
/* 102 */       Checks.check(__functionAddress);
/*     */     }
/* 104 */     JNI.invokePV(buffer, format, data, offset, data.length << 2, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubDataSOFT(@NativeType("ALuint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid const *") float[] data, @NativeType("ALsizei") int offset) {
/* 109 */     long __functionAddress = (AL.getICD()).alBufferSubDataSOFT;
/* 110 */     if (Checks.CHECKS) {
/* 111 */       Checks.check(__functionAddress);
/*     */     }
/* 113 */     JNI.invokePV(buffer, format, data, offset, data.length << 2, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubDataDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid const *") short[] data, @NativeType("ALsizei") int offset) {
/* 118 */     long __functionAddress = (AL.getICD()).alBufferSubDataDirectSOFT;
/* 119 */     if (Checks.CHECKS) {
/* 120 */       Checks.check(__functionAddress);
/* 121 */       Checks.check(context);
/*     */     } 
/* 123 */     JNI.invokePPV(context, buffer, format, data, offset, data.length << 1, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubDataDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid const *") int[] data, @NativeType("ALsizei") int offset) {
/* 128 */     long __functionAddress = (AL.getICD()).alBufferSubDataDirectSOFT;
/* 129 */     if (Checks.CHECKS) {
/* 130 */       Checks.check(__functionAddress);
/* 131 */       Checks.check(context);
/*     */     } 
/* 133 */     JNI.invokePPV(context, buffer, format, data, offset, data.length << 2, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubDataDirectSOFT(@NativeType("ALCcontext *") long context, @NativeType("ALuint") int buffer, @NativeType("ALenum") int format, @NativeType("ALvoid const *") float[] data, @NativeType("ALsizei") int offset) {
/* 138 */     long __functionAddress = (AL.getICD()).alBufferSubDataDirectSOFT;
/* 139 */     if (Checks.CHECKS) {
/* 140 */       Checks.check(__functionAddress);
/* 141 */       Checks.check(context);
/*     */     } 
/* 143 */     JNI.invokePPV(context, buffer, format, data, offset, data.length << 2, __functionAddress);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\SOFTBufferSubData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */