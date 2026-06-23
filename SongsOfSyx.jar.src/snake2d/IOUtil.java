/*    */ package snake2d;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Path;
/*    */ import org.lwjgl.BufferUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class IOUtil
/*    */ {
/*    */   private static ByteBuffer resizeBuffer(ByteBuffer buffer, int newCapacity) {
/* 25 */     ByteBuffer newBuffer = BufferUtils.createByteBuffer(newCapacity);
/* 26 */     buffer.flip();
/* 27 */     newBuffer.put(buffer);
/* 28 */     return newBuffer;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ByteBuffer ioResourceToByteBuffer(Path resource, int bufferSize) throws IOException {
/*    */     ByteBuffer buffer;
/* 44 */     Path path = resource;
/* 45 */     if (Files.isReadable(path)) {
/* 46 */       Exception exception2, exception1 = null;
/*    */ 
/*    */     
/*    */     }
/*    */     else {
/*    */ 
/*    */       
/* 53 */       Exception exception2, exception1 = null;
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 71 */     buffer.flip();
/* 72 */     return buffer;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\IOUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */