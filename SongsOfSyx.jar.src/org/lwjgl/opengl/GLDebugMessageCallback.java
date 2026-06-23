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
/*    */ public abstract class GLDebugMessageCallback
/*    */   extends Callback
/*    */   implements GLDebugMessageCallbackI
/*    */ {
/*    */   public static GLDebugMessageCallback create(long functionPointer) {
/* 23 */     GLDebugMessageCallbackI instance = (GLDebugMessageCallbackI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof GLDebugMessageCallback) ? (GLDebugMessageCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLDebugMessageCallback createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLDebugMessageCallback create(GLDebugMessageCallbackI instance) {
/* 36 */     return (instance instanceof GLDebugMessageCallback) ? (GLDebugMessageCallback)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLDebugMessageCallback() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLDebugMessageCallback(long functionPointer) {
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
/*    */     extends GLDebugMessageCallback {
/*    */     private final GLDebugMessageCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLDebugMessageCallbackI delegate) {
/* 68 */       super(functionPointer);
/* 69 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(int source, int type, int id, int severity, int length, long message, long userParam) {
/* 74 */       this.delegate.invoke(source, type, id, severity, length, message, userParam);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLDebugMessageCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */