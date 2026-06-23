/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SOFTBufferSamples
/*     */ {
/*     */   public static final int AL_MONO8_SOFT = 4352;
/*     */   public static final int AL_MONO16_SOFT = 4353;
/*     */   public static final int AL_MONO32F_SOFT = 65552;
/*     */   public static final int AL_STEREO8_SOFT = 4354;
/*     */   public static final int AL_STEREO16_SOFT = 4355;
/*     */   public static final int AL_STEREO32F_SOFT = 65553;
/*     */   public static final int AL_QUAD8_SOFT = 4612;
/*     */   public static final int AL_QUAD16_SOFT = 4613;
/*     */   public static final int AL_QUAD32F_SOFT = 4614;
/*     */   public static final int AL_REAR8_SOFT = 4615;
/*     */   public static final int AL_REAR16_SOFT = 4616;
/*     */   public static final int AL_REAR32F_SOFT = 4617;
/*     */   public static final int AL_5POINT1_8_SOFT = 4618;
/*     */   public static final int AL_5POINT1_16_SOFT = 4619;
/*     */   public static final int AL_5POINT1_32F_SOFT = 4620;
/*     */   public static final int AL_6POINT1_8_SOFT = 4621;
/*     */   public static final int AL_6POINT1_16_SOFT = 4622;
/*     */   public static final int AL_6POINT1_32F_SOFT = 4623;
/*     */   public static final int AL_7POINT1_8_SOFT = 4624;
/*     */   public static final int AL_7POINT1_16_SOFT = 4625;
/*     */   public static final int AL_7POINT1_32F_SOFT = 4626;
/*     */   public static final int AL_MONO_SOFT = 5376;
/*     */   public static final int AL_STEREO_SOFT = 5377;
/*     */   public static final int AL_QUAD_SOFT = 5378;
/*     */   public static final int AL_REAR_SOFT = 5379;
/*     */   public static final int AL_5POINT1_SOFT = 5380;
/*     */   public static final int AL_6POINT1_SOFT = 5381;
/*     */   public static final int AL_7POINT1_SOFT = 5382;
/*     */   public static final int AL_BYTE_SOFT = 5120;
/*     */   public static final int AL_UNSIGNED_BYTE_SOFT = 5121;
/*     */   public static final int AL_SHORT_SOFT = 5122;
/*     */   public static final int AL_UNSIGNED_SHORT_SOFT = 5123;
/*     */   public static final int AL_INT_SOFT = 5124;
/*     */   public static final int AL_UNSIGNED_INT_SOFT = 5125;
/*     */   public static final int AL_FLOAT_SOFT = 5126;
/*     */   public static final int AL_DOUBLE_SOFT = 5127;
/*     */   public static final int AL_BYTE3_SOFT = 5128;
/*     */   public static final int AL_UNSIGNED_BYTE3_SOFT = 5129;
/*     */   public static final int AL_INTERNAL_FORMAT_SOFT = 8200;
/*     */   public static final int AL_BYTE_LENGTH_SOFT = 8201;
/*     */   public static final int AL_SAMPLE_LENGTH_SOFT = 8202;
/*     */   public static final int AL_SEC_LENGTH_SOFT = 8203;
/*     */   public static final int AL_BYTE_RW_OFFSETS_SOFT = 4145;
/*     */   public static final int AL_SAMPLE_RW_OFFSETS_SOFT = 4146;
/*     */   
/*     */   protected SOFTBufferSamples() {
/*  74 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalBufferSamplesSOFT(int buffer, int samplerate, int internalformat, int samples, int channels, int type, long data) {
/*  81 */     long __functionAddress = (AL.getICD()).alBufferSamplesSOFT;
/*  82 */     if (Checks.CHECKS) {
/*  83 */       Checks.check(__functionAddress);
/*     */     }
/*  85 */     JNI.invokePV(buffer, samplerate, internalformat, samples, channels, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALuint") int samplerate, @NativeType("ALenum") int internalformat, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid const *") ByteBuffer data) {
/*  90 */     nalBufferSamplesSOFT(buffer, samplerate, internalformat, samples, channels, type, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALuint") int samplerate, @NativeType("ALenum") int internalformat, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid const *") ShortBuffer data) {
/*  95 */     nalBufferSamplesSOFT(buffer, samplerate, internalformat, samples, channels, type, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALuint") int samplerate, @NativeType("ALenum") int internalformat, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid const *") IntBuffer data) {
/* 100 */     nalBufferSamplesSOFT(buffer, samplerate, internalformat, samples, channels, type, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALuint") int samplerate, @NativeType("ALenum") int internalformat, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid const *") FloatBuffer data) {
/* 105 */     nalBufferSamplesSOFT(buffer, samplerate, internalformat, samples, channels, type, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALuint") int samplerate, @NativeType("ALenum") int internalformat, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid const *") DoubleBuffer data) {
/* 110 */     nalBufferSamplesSOFT(buffer, samplerate, internalformat, samples, channels, type, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalBufferSubSamplesSOFT(int buffer, int offset, int samples, int channels, int type, long data) {
/* 117 */     long __functionAddress = (AL.getICD()).alBufferSubSamplesSOFT;
/* 118 */     if (Checks.CHECKS) {
/* 119 */       Checks.check(__functionAddress);
/*     */     }
/* 121 */     JNI.invokePV(buffer, offset, samples, channels, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALsizei") int offset, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid const *") ByteBuffer data) {
/* 126 */     nalBufferSubSamplesSOFT(buffer, offset, samples, channels, type, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALsizei") int offset, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid const *") ShortBuffer data) {
/* 131 */     nalBufferSubSamplesSOFT(buffer, offset, samples, channels, type, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALsizei") int offset, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid const *") IntBuffer data) {
/* 136 */     nalBufferSubSamplesSOFT(buffer, offset, samples, channels, type, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALsizei") int offset, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid const *") FloatBuffer data) {
/* 141 */     nalBufferSubSamplesSOFT(buffer, offset, samples, channels, type, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALsizei") int offset, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid const *") DoubleBuffer data) {
/* 146 */     nalBufferSubSamplesSOFT(buffer, offset, samples, channels, type, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetBufferSamplesSOFT(int buffer, int offset, int samples, int channels, int type, long data) {
/* 153 */     long __functionAddress = (AL.getICD()).alGetBufferSamplesSOFT;
/* 154 */     if (Checks.CHECKS) {
/* 155 */       Checks.check(__functionAddress);
/*     */     }
/* 157 */     JNI.invokePV(buffer, offset, samples, channels, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alGetBufferSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALsizei") int offset, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid *") ByteBuffer data) {
/* 162 */     nalGetBufferSamplesSOFT(buffer, offset, samples, channels, type, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alGetBufferSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALsizei") int offset, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid *") ShortBuffer data) {
/* 167 */     nalGetBufferSamplesSOFT(buffer, offset, samples, channels, type, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alGetBufferSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALsizei") int offset, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid *") IntBuffer data) {
/* 172 */     nalGetBufferSamplesSOFT(buffer, offset, samples, channels, type, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alGetBufferSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALsizei") int offset, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid *") FloatBuffer data) {
/* 177 */     nalGetBufferSamplesSOFT(buffer, offset, samples, channels, type, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alGetBufferSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALsizei") int offset, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid *") DoubleBuffer data) {
/* 182 */     nalGetBufferSamplesSOFT(buffer, offset, samples, channels, type, MemoryUtil.memAddress(data));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALboolean")
/*     */   public static boolean alIsBufferFormatSupportedSOFT(@NativeType("ALenum") int format) {
/* 190 */     long __functionAddress = (AL.getICD()).alIsBufferFormatSupportedSOFT;
/* 191 */     if (Checks.CHECKS) {
/* 192 */       Checks.check(__functionAddress);
/*     */     }
/* 194 */     return JNI.invokeZ(format, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALuint") int samplerate, @NativeType("ALenum") int internalformat, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid const *") short[] data) {
/* 199 */     long __functionAddress = (AL.getICD()).alBufferSamplesSOFT;
/* 200 */     if (Checks.CHECKS) {
/* 201 */       Checks.check(__functionAddress);
/*     */     }
/* 203 */     JNI.invokePV(buffer, samplerate, internalformat, samples, channels, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALuint") int samplerate, @NativeType("ALenum") int internalformat, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid const *") int[] data) {
/* 208 */     long __functionAddress = (AL.getICD()).alBufferSamplesSOFT;
/* 209 */     if (Checks.CHECKS) {
/* 210 */       Checks.check(__functionAddress);
/*     */     }
/* 212 */     JNI.invokePV(buffer, samplerate, internalformat, samples, channels, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALuint") int samplerate, @NativeType("ALenum") int internalformat, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid const *") float[] data) {
/* 217 */     long __functionAddress = (AL.getICD()).alBufferSamplesSOFT;
/* 218 */     if (Checks.CHECKS) {
/* 219 */       Checks.check(__functionAddress);
/*     */     }
/* 221 */     JNI.invokePV(buffer, samplerate, internalformat, samples, channels, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALuint") int samplerate, @NativeType("ALenum") int internalformat, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid const *") double[] data) {
/* 226 */     long __functionAddress = (AL.getICD()).alBufferSamplesSOFT;
/* 227 */     if (Checks.CHECKS) {
/* 228 */       Checks.check(__functionAddress);
/*     */     }
/* 230 */     JNI.invokePV(buffer, samplerate, internalformat, samples, channels, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALsizei") int offset, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid const *") short[] data) {
/* 235 */     long __functionAddress = (AL.getICD()).alBufferSubSamplesSOFT;
/* 236 */     if (Checks.CHECKS) {
/* 237 */       Checks.check(__functionAddress);
/*     */     }
/* 239 */     JNI.invokePV(buffer, offset, samples, channels, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALsizei") int offset, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid const *") int[] data) {
/* 244 */     long __functionAddress = (AL.getICD()).alBufferSubSamplesSOFT;
/* 245 */     if (Checks.CHECKS) {
/* 246 */       Checks.check(__functionAddress);
/*     */     }
/* 248 */     JNI.invokePV(buffer, offset, samples, channels, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALsizei") int offset, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid const *") float[] data) {
/* 253 */     long __functionAddress = (AL.getICD()).alBufferSubSamplesSOFT;
/* 254 */     if (Checks.CHECKS) {
/* 255 */       Checks.check(__functionAddress);
/*     */     }
/* 257 */     JNI.invokePV(buffer, offset, samples, channels, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alBufferSubSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALsizei") int offset, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid const *") double[] data) {
/* 262 */     long __functionAddress = (AL.getICD()).alBufferSubSamplesSOFT;
/* 263 */     if (Checks.CHECKS) {
/* 264 */       Checks.check(__functionAddress);
/*     */     }
/* 266 */     JNI.invokePV(buffer, offset, samples, channels, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alGetBufferSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALsizei") int offset, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid *") short[] data) {
/* 271 */     long __functionAddress = (AL.getICD()).alGetBufferSamplesSOFT;
/* 272 */     if (Checks.CHECKS) {
/* 273 */       Checks.check(__functionAddress);
/*     */     }
/* 275 */     JNI.invokePV(buffer, offset, samples, channels, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alGetBufferSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALsizei") int offset, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid *") int[] data) {
/* 280 */     long __functionAddress = (AL.getICD()).alGetBufferSamplesSOFT;
/* 281 */     if (Checks.CHECKS) {
/* 282 */       Checks.check(__functionAddress);
/*     */     }
/* 284 */     JNI.invokePV(buffer, offset, samples, channels, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alGetBufferSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALsizei") int offset, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid *") float[] data) {
/* 289 */     long __functionAddress = (AL.getICD()).alGetBufferSamplesSOFT;
/* 290 */     if (Checks.CHECKS) {
/* 291 */       Checks.check(__functionAddress);
/*     */     }
/* 293 */     JNI.invokePV(buffer, offset, samples, channels, type, data, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alGetBufferSamplesSOFT(@NativeType("ALuint") int buffer, @NativeType("ALsizei") int offset, @NativeType("ALsizei") int samples, @NativeType("ALenum") int channels, @NativeType("ALenum") int type, @NativeType("ALvoid *") double[] data) {
/* 298 */     long __functionAddress = (AL.getICD()).alGetBufferSamplesSOFT;
/* 299 */     if (Checks.CHECKS) {
/* 300 */       Checks.check(__functionAddress);
/*     */     }
/* 302 */     JNI.invokePV(buffer, offset, samples, channels, type, data, __functionAddress);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\SOFTBufferSamples.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */