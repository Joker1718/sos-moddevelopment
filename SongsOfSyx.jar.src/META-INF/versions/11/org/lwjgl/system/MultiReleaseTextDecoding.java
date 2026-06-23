/*    */ package META-INF.versions.11.org.lwjgl.system;
/*    */ 
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import org.lwjgl.system.APIUtil;
/*    */ import org.lwjgl.system.MemoryUtil;
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
/*    */ final class MultiReleaseTextDecoding
/*    */ {
/*    */   static {
/* 23 */     APIUtil.apiLog("Java 11 text decoding enabled");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static String decodeUTF8(long source, int length) {
/* 31 */     if (length <= 0) {
/* 32 */       return "";
/*    */     }
/*    */     
/* 35 */     byte[] bytes = (length <= MemoryUtil.ARRAY_TLC_SIZE) ? MemoryUtil.ARRAY_TLC_BYTE.get() : new byte[length];
/* 36 */     MemoryUtil.memByteBuffer(source, length).get(bytes, 0, length);
/* 37 */     return new String(bytes, 0, length, StandardCharsets.UTF_8);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\11\org\lwjgl\system\MultiReleaseTextDecoding.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */