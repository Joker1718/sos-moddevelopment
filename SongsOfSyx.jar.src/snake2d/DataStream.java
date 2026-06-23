/*     */ package snake2d;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.ShortBuffer;
/*     */ import java.nio.file.Path;
/*     */ import javax.sound.sampled.AudioFormat;
/*     */ import javax.sound.sampled.AudioInputStream;
/*     */ import javax.sound.sampled.AudioSystem;
/*     */ import org.lwjgl.openal.AL10;
/*     */ import snake2d.util.file.Alloc;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class DataStream
/*     */   implements DATA_STREAM
/*     */ {
/*     */   private static final int targetedBufferSize = 81920;
/*     */   private final int bufferSize;
/*     */   private final int lastBufferSize;
/*     */   private final int nrOfBuffers;
/*  56 */   private int currentBuffer = 0;
/*     */   
/*     */   private final byte[] bufferBytes;
/*     */   
/*     */   private final byte[] lastBuffer;
/*     */   
/*     */   private final int totalSize;
/*     */   
/*     */   private final int alFormat;
/*     */   private final int samplerate;
/*     */   private final float length;
/*     */   private AudioInputStream stream;
/*     */   private final String path;
/*     */   
/*     */   DataStream(Path path) {
/*  71 */     this.path = (String)path;
/*     */     
/*  73 */     if ((path.endsWith(".wav") | path.endsWith(".aiff")) == 0) {
/*  74 */       throw new RuntimeException("only wav and aiff formats are supported");
/*     */     }
/*     */     try {
/*  77 */       this.stream = AudioSystem.getAudioInputStream(path.toUri().toURL());
/*  78 */     } catch (Exception e) {
/*  79 */       e.printStackTrace();
/*  80 */       throw new RuntimeException("Problem creating sound: " + path);
/*     */     } 
/*     */     
/*  83 */     AudioFormat format = this.stream.getFormat();
/*     */ 
/*     */     
/*  86 */     this.length = (float)((this.stream.getFrameLength() + 0.0D) / format.getFrameRate());
/*  87 */     this.totalSize = (int)(this.stream.getFrameLength() * format.getFrameSize());
/*     */ 
/*     */ 
/*     */     
/*  91 */     this.bufferSize = 81920 / format.getFrameSize() * format.getFrameSize();
/*  92 */     this.nrOfBuffers = this.totalSize / this.bufferSize + ((this.totalSize % this.bufferSize == 0) ? 0 : 1);
/*  93 */     this.lastBufferSize = (this.totalSize % this.bufferSize == 0) ? this.bufferSize : (this.totalSize % this.bufferSize);
/*     */     
/*  95 */     this.samplerate = (int)format.getSampleRate();
/*     */     
/*  97 */     if (format.getChannels() == 1) {
/*  98 */       if (format.getSampleSizeInBits() == 8) {
/*  99 */         this.alFormat = 4352;
/* 100 */       } else if (format.getSampleSizeInBits() == 16) {
/* 101 */         this.alFormat = 4353;
/*     */       } else {
/* 103 */         throw new RuntimeException("Illegal sample size");
/*     */       } 
/* 105 */     } else if (format.getChannels() == 2) {
/* 106 */       if (format.getSampleSizeInBits() == 8) {
/* 107 */         this.alFormat = 4354;
/* 108 */       } else if (format.getSampleSizeInBits() == 16) {
/* 109 */         this.alFormat = 4355;
/*     */       } else {
/* 111 */         throw new RuntimeException("Illegal sample size: " + format.getSampleSizeInBits());
/*     */       } 
/*     */     } else {
/* 114 */       throw new RuntimeException("Only mono or stereo is supported");
/*     */     } 
/*     */     
/* 117 */     this.bufferBytes = Alloc.bb(this.bufferSize);
/* 118 */     this.lastBuffer = Alloc.bb(this.lastBufferSize);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasMoreBuffers() {
/* 124 */     if (this.currentBuffer < this.nrOfBuffers)
/* 125 */       return true; 
/* 126 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNext(int alBuff) {
/*     */     byte[] buf;
/* 134 */     if (this.currentBuffer == this.nrOfBuffers - 1) {
/* 135 */       buf = this.lastBuffer;
/*     */     } else {
/* 137 */       buf = this.bufferBytes;
/*     */     } 
/*     */     
/* 140 */     int read = 0, total = 0;
/*     */     
/*     */     try {
/* 143 */       while ((read = this.stream.read(buf, total, buf.length - total)) != -1 && 
/* 144 */         total < buf.length) {
/* 145 */         total += read;
/*     */       }
/* 147 */     } catch (IOException ioe) {
/* 148 */       ioe.printStackTrace();
/*     */     } 
/*     */     
/* 151 */     this.currentBuffer++;
/*     */     
/* 153 */     AL10.alBufferData(alBuff, this.alFormat, convertAudioBytes(this.stream.getFormat(), buf, (this.stream.getFormat().getSampleSizeInBits() == 16)), this.samplerate);
/*     */   }
/*     */ 
/*     */   
/*     */   public double getProgress() {
/* 158 */     if (this.currentBuffer > 0)
/* 159 */       return ((this.currentBuffer - 1) * this.bufferSize) / this.totalSize; 
/* 160 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getLengthInSeconds() {
/* 165 */     return this.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/*     */     try {
/* 171 */       this.stream.close();
/* 172 */     } catch (IOException e) {
/* 173 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ByteBuffer convertAudioBytes(AudioFormat format, byte[] audio_bytes, boolean two_bytes_data) {
/* 185 */     ByteBuffer dest = ByteBuffer.allocateDirect(audio_bytes.length);
/* 186 */     dest.order(ByteOrder.nativeOrder());
/* 187 */     ByteBuffer src = ByteBuffer.wrap(audio_bytes);
/*     */ 
/*     */     
/* 190 */     if (format.isBigEndian()) {
/* 191 */       src.order(ByteOrder.BIG_ENDIAN);
/*     */     } else {
/* 193 */       src.order(ByteOrder.LITTLE_ENDIAN);
/*     */     } 
/* 195 */     if (two_bytes_data) {
/* 196 */       ShortBuffer dest_short = dest.asShortBuffer();
/* 197 */       ShortBuffer src_short = src.asShortBuffer();
/* 198 */       while (src_short.hasRemaining())
/* 199 */         dest_short.put(src_short.get()); 
/*     */     } else {
/* 201 */       while (src.hasRemaining()) {
/* 202 */         byte b = src.get();
/* 203 */         if (format.getEncoding() == AudioFormat.Encoding.PCM_SIGNED) {
/* 204 */           b = (byte)(b + 127);
/*     */         }
/* 206 */         dest.put(b);
/*     */       } 
/*     */     } 
/* 209 */     dest.rewind();
/* 210 */     return dest;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void rewind() {
/*     */     try {
/* 217 */       this.stream.close();
/* 218 */       this.stream = AudioSystem.getAudioInputStream(new File(this.path));
/* 219 */     } catch (Exception e) {
/* 220 */       System.err.println("Unable to rewind audioStream");
/* 221 */       e.printStackTrace();
/*     */       return;
/*     */     } 
/* 224 */     this.currentBuffer = 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\DataStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */