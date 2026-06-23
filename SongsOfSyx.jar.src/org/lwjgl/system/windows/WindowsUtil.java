/*    */ package org.lwjgl.system.windows;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class WindowsUtil
/*    */ {
/*    */   public static void windowsThrowException(String msg, IntBuffer GetLastError) {
/* 15 */     throw new RuntimeException(msg + " (error code = " + GetLastError.get(GetLastError.position()) + ")");
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\WindowsUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */