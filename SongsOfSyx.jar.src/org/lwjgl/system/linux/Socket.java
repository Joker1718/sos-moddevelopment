/*    */ package org.lwjgl.system.linux;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.Library;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Socket
/*    */ {
/*    */   public static final int SHUT_RD = 0;
/*    */   public static final int SHUT_WR = 1;
/*    */   public static final int SHUT_RDWR = 2;
/*    */   
/*    */   static {
/* 19 */     Library.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Socket() {
/* 27 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int socket(@NativeType("int *") IntBuffer _errno, int __domain, int __type, int __protocol) {
/* 37 */     if (Checks.CHECKS) {
/* 38 */       Checks.checkSafe(_errno, 1);
/*    */     }
/* 40 */     return nsocket(MemoryUtil.memAddressSafe(_errno), __domain, __type, __protocol);
/*    */   }
/*    */   
/*    */   public static native int nsocket(long paramLong, int paramInt1, int paramInt2, int paramInt3);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\linux\Socket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */