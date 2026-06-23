/*     */ package snake2d;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import java.nio.file.Path;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.openal.AL10;
/*     */ import org.lwjgl.stb.STBVorbis;
/*     */ import org.lwjgl.stb.STBVorbisInfo;
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
/*     */ public final class DataStreamOgg
/*     */   implements DATA_STREAM
/*     */ {
/*     */   private static final int BUFFER_SIZE = 16384;
/*     */   private final ByteBuffer vorbis;
/*     */   private final long handle;
/*     */   private final int channels;
/*     */   private final int sampleRate;
/*     */   private int format;
/*     */   private final int lengthSamples;
/*     */   private final float lengthSeconds;
/*     */   private final ShortBuffer pcm;
/*     */   private int samplesLeft;
/*     */   private final String file;
/*     */   
/*     */   DataStreamOgg(Path filePath) {
/*  55 */     this.file = (String)filePath.getFileName().toAbsolutePath();
/*     */     try {
/*  57 */       this.vorbis = IOUtil.ioResourceToByteBuffer(filePath, 262144);
/*  58 */     } catch (IOException e) {
/*  59 */       throw error(filePath, e.getMessage());
/*     */     } 
/*     */     
/*  62 */     IntBuffer error = BufferUtils.createIntBuffer(1);
/*  63 */     this.handle = STBVorbis.stb_vorbis_open_memory(this.vorbis, error, null);
/*  64 */     if (this.handle == 0L) {
/*  65 */       throw error(filePath, "Error: " + error.get(0));
/*     */     }
/*     */ 
/*     */     
/*  69 */     Exception exception1 = null, exception2 = null; try { STBVorbisInfo info = STBVorbisInfo.malloc(); 
/*  70 */       try { getInfo(this.handle, info);
/*  71 */         this.channels = info.channels();
/*  72 */         this.sampleRate = info.sample_rate(); }
/*  73 */       finally { if (info != null) info.close();  }  } finally { exception2 = null; if (exception1 == null) { exception1 = exception2; } else if (exception1 != exception2) { exception1.addSuppressed(exception2); }
/*     */        }
/*     */ 
/*     */ 
/*     */     
/*  78 */     this.lengthSeconds = STBVorbis.stb_vorbis_stream_length_in_seconds(this.handle);
/*     */     
/*  80 */     this.pcm = BufferUtils.createShortBuffer(16384);
/*     */     
/*  82 */     this.samplesLeft = this.lengthSamples;
/*     */   }
/*     */   
/*     */   private Errors.DataError error(Path path, String error) {
/*  86 */     return new Errors.DataError("Could not process .ogg file. Make sure the audio file is truly encoded in ogg/vobis format" + System.lineSeparator() + error, path);
/*     */   }
/*     */ 
/*     */   
/*     */   static void getInfo(long decoder, STBVorbisInfo info) {
/*  91 */     STBVorbis.stb_vorbis_get_info(decoder, info);
/*     */   }
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
/*     */   private static int getFormat(int channels) {
/* 107 */     switch (channels) {
/*     */       case 1:
/* 109 */         return 4353;
/*     */       case 2:
/* 111 */         return 4355;
/*     */     } 
/* 113 */     throw new UnsupportedOperationException("Unsupported number of channels: " + channels);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasMoreBuffers() {
/* 119 */     return (this.samplesLeft > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setNext(int alBuff) {
/* 124 */     int samples = 0;
/*     */     
/* 126 */     while (samples < 16384) {
/* 127 */       this.pcm.position(samples);
/* 128 */       int samplesPerChannel = STBVorbis.stb_vorbis_get_samples_short_interleaved(this.handle, this.channels, this.pcm);
/* 129 */       if (samplesPerChannel == 0) {
/*     */         break;
/*     */       }
/*     */       
/* 133 */       samples += samplesPerChannel * this.channels;
/*     */     } 
/*     */     
/* 136 */     if (samples == 0) {
/* 137 */       throw new RuntimeException("getting nonexistant buffer " + this.file);
/*     */     }
/*     */     
/* 140 */     this.pcm.position(0);
/* 141 */     this.samplesLeft -= samples;
/*     */     
/* 143 */     AL10.alBufferData(alBuff, this.format, this.pcm, this.sampleRate);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double getProgress() {
/* 149 */     return 1.0D - this.samplesLeft / this.lengthSamples;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getLengthInSeconds() {
/* 154 */     return this.lengthSeconds;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rewind() {
/* 159 */     STBVorbis.stb_vorbis_seek_start(this.handle);
/* 160 */     this.samplesLeft = this.lengthSamples;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 165 */     STBVorbis.stb_vorbis_close(this.handle);
/*     */   }
/*     */   
/*     */   void skip(int direction) {
/* 169 */     seek(Math.min(Math.max(0, STBVorbis.stb_vorbis_get_sample_offset(this.handle) + direction * this.sampleRate), this.lengthSamples));
/*     */   }
/*     */   
/*     */   void skipTo(float offset0to1) {
/* 173 */     seek(Math.round(this.lengthSamples * offset0to1));
/*     */   }
/*     */   
/*     */   private void seek(int sample_number) {
/* 177 */     STBVorbis.stb_vorbis_seek(this.handle, sample_number);
/* 178 */     this.samplesLeft = this.lengthSamples - sample_number;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\DataStreamOgg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */