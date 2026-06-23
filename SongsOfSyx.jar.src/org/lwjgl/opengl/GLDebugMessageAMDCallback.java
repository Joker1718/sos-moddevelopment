/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.Callback;
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
/*    */ public abstract class GLDebugMessageAMDCallback
/*    */   extends Callback
/*    */   implements GLDebugMessageAMDCallbackI
/*    */ {
/*    */   public static GLDebugMessageAMDCallback create(long functionPointer) {
/* 23 */     GLDebugMessageAMDCallbackI instance = (GLDebugMessageAMDCallbackI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof GLDebugMessageAMDCallback) ? (GLDebugMessageAMDCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLDebugMessageAMDCallback createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLDebugMessageAMDCallback create(GLDebugMessageAMDCallbackI instance) {
/* 36 */     return (instance instanceof GLDebugMessageAMDCallback) ? (GLDebugMessageAMDCallback)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLDebugMessageAMDCallback() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLDebugMessageAMDCallback(long functionPointer) {
/* 46 */     super(functionPointer);
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
/*    */   public static String getMessage(int length, long message) {
/* 60 */     return MemoryUtil.memUTF8(MemoryUtil.memByteBuffer(message, length));
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLDebugMessageAMDCallback {
/*    */     private final GLDebugMessageAMDCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLDebugMessageAMDCallbackI delegate) {
/* 68 */       super(functionPointer);
/* 69 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(int id, int category, int severity, int length, long message, long userParam) {
/* 74 */       this.delegate.invoke(id, category, severity, length, message, userParam);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLDebugMessageAMDCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */