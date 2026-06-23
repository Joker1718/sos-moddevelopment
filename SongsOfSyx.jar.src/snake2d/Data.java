/*     */ package snake2d;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.ShortBuffer;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import javax.sound.sampled.AudioFormat;
/*     */ import javax.sound.sampled.AudioInputStream;
/*     */ import javax.sound.sampled.AudioSystem;
/*     */ import snake2d.util.file.Alloc;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Data
/*     */ {
/*     */   final ByteBuffer data;
/*     */   final int sizeInBytes;
/*     */   final int alFormat;
/*     */   final int channels;
/*     */   final int samplerate;
/*     */   final float length;
/*     */   
/*     */   Data(Path path) {
/*     */     AudioInputStream ais;
/*  30 */     if (!path.toAbsolutePath().endsWith(".wav")) {
/*  31 */       throw new Errors.DataError("only wav and aiff formats are supported", path);
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/*  36 */       ais = AudioSystem.getAudioInputStream(
/*  37 */           new BufferedInputStream(Files.newInputStream(path, new java.nio.file.OpenOption[0])));
/*  38 */     } catch (Exception e) {
/*  39 */       e.printStackTrace();
/*  40 */       throw new RuntimeException("Problem creating sound: " + path);
/*     */     } 
/*     */     
/*  43 */     AudioFormat audioformat = ais.getFormat();
/*     */     
/*  45 */     this.length = (float)((ais.getFrameLength() + 0.0D) / audioformat.getFrameRate());
/*  46 */     if (this.length > 10.0F) {
/*  47 */       throw new Errors.DataError("Sound effects more than 10s should not be used as sound effects!", path);
/*     */     }
/*     */ 
/*     */     
/*  51 */     if (audioformat.getChannels() == 1)
/*  52 */     { this.channels = 1;
/*  53 */       if (audioformat.getSampleSizeInBits() == 8) {
/*  54 */         this.alFormat = 4352;
/*  55 */       } else if (audioformat.getSampleSizeInBits() == 16) {
/*  56 */         this.alFormat = 4353;
/*     */       } else {
/*  58 */         throw new Errors.DataError("Illegal sample size", path);
/*     */       }  }
/*  60 */     else { if (audioformat.getChannels() == 2) {
/*  61 */         throw new Errors.DataError("stereo sounds can't be sound effects", path);
/*     */       }
/*  63 */       throw new Errors.DataError("Only mono or stereo is supported", path); }
/*     */ 
/*     */ 
/*     */     
/*  67 */     byte[] buf = 
/*  68 */       Alloc.bb(audioformat.getChannels() * 
/*  69 */         (int)ais.getFrameLength() * 
/*  70 */         audioformat.getSampleSizeInBits() / 
/*  71 */         8);
/*  72 */     int read = 0, total = 0;
/*     */     try {
/*  74 */       while ((read = ais.read(buf, total, buf.length - total)) != -1 && 
/*  75 */         total < buf.length) {
/*  76 */         total += read;
/*     */       }
/*  78 */     } catch (IOException ioe) {
/*  79 */       ioe.printStackTrace();
/*     */     } 
/*     */     
/*  82 */     this.data = convertAudioBytes(audioformat, buf, (audioformat.getSampleSizeInBits() == 16));
/*     */     
/*     */     try {
/*  85 */       ais.close();
/*  86 */     } catch (IOException ioe) {
/*  87 */       ioe.printStackTrace();
/*  88 */       throw new RuntimeException("Couldn't close stream!");
/*     */     } 
/*     */     
/*  91 */     this.samplerate = (int)audioformat.getSampleRate();
/*  92 */     this.sizeInBytes = this.data.capacity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 100 */     this.data.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ByteBuffer convertAudioBytes(AudioFormat format, byte[] audio_bytes, boolean two_bytes_data) {
/* 111 */     ByteBuffer dest = ByteBuffer.allocateDirect(audio_bytes.length);
/* 112 */     dest.order(ByteOrder.nativeOrder());
/* 113 */     ByteBuffer src = ByteBuffer.wrap(audio_bytes);
/*     */     
/* 115 */     if (format.isBigEndian()) {
/* 116 */       src.order(ByteOrder.BIG_ENDIAN);
/*     */     } else {
/* 118 */       src.order(ByteOrder.LITTLE_ENDIAN);
/* 119 */     }  if (two_bytes_data) {
/* 120 */       ShortBuffer dest_short = dest.asShortBuffer();
/* 121 */       ShortBuffer src_short = src.asShortBuffer();
/* 122 */       while (src_short.hasRemaining())
/* 123 */         dest_short.put(src_short.get()); 
/*     */     } else {
/* 125 */       while (src.hasRemaining()) {
/* 126 */         byte b = src.get();
/* 127 */         if (format.getEncoding() == AudioFormat.Encoding.PCM_SIGNED) {
/* 128 */           b = (byte)(b + 127);
/*     */         }
/* 130 */         dest.put(b);
/*     */       } 
/*     */     } 
/* 133 */     dest.rewind();
/* 134 */     return dest;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\Data.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */