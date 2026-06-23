/*    */ package org.lwjgl.openal;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ALUtil
/*    */ {
/*    */   public static List<String> getStringList(long deviceHandle, int token) {
/* 28 */     long __result = ALC10.nalcGetString(deviceHandle, token);
/* 29 */     if (__result == 0L) {
/* 30 */       return null;
/*    */     }
/*    */     
/* 33 */     ByteBuffer buffer = MemoryUtil.memByteBuffer(__result, 2147483639);
/*    */     
/* 35 */     List<String> strings = new ArrayList<>();
/*    */     
/* 37 */     int offset = 0;
/*    */     while (true) {
/* 39 */       if (buffer.get() == 0) {
/* 40 */         int limit = buffer.position() - 1;
/* 41 */         if (limit == offset) {
/*    */           break;
/*    */         }
/*    */         
/* 45 */         strings.add(MemoryUtil.memUTF8(buffer, limit - offset, offset));
/* 46 */         offset = buffer.position();
/*    */       } 
/*    */     } 
/*    */     
/* 50 */     return strings;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\ALUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */