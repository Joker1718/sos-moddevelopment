/*    */ package snake2d;
/*    */ 
/*    */ import java.nio.file.Path;
/*    */ 
/*    */ interface DATA_STREAM {
/*    */   static DATA_STREAM getStream(Path path) {
/*  7 */     Path path1 = path.toAbsolutePath();
/*    */     
/*  9 */     if (path1.endsWith(".wav") || path1.endsWith(".aiff"))
/* 10 */       return new DataStream(path); 
/* 11 */     if (path1.endsWith(".ogg")) {
/* 12 */       return new DataStreamOgg(path);
/*    */     }
/* 14 */     throw new RuntimeException("only .wav, .aiff and .ogg formats are supported for streaming audio");
/*    */   }
/*    */   
/*    */   boolean hasMoreBuffers();
/*    */   
/*    */   void setNext(int paramInt);
/*    */   
/*    */   double getProgress();
/*    */   
/*    */   float getLengthInSeconds();
/*    */   
/*    */   void dispose();
/*    */   
/*    */   void rewind();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\DATA_STREAM.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */