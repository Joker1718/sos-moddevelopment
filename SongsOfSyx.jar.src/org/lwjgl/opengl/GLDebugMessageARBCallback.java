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
/*    */ public abstract class GLDebugMessageARBCallback
/*    */   extends Callback
/*    */   implements GLDebugMessageARBCallbackI
/*    */ {
/*    */   public static GLDebugMessageARBCallback create(long functionPointer) {
/* 23 */     GLDebugMessageARBCallbackI instance = (GLDebugMessageARBCallbackI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof GLDebugMessageARBCallback) ? (GLDebugMessageARBCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLDebugMessageARBCallback createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLDebugMessageARBCallback create(GLDebugMessageARBCallbackI instance) {
/* 36 */     return (instance instanceof GLDebugMessageARBCallback) ? (GLDebugMessageARBCallback)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLDebugMessageARBCallback() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLDebugMessageARBCallback(long functionPointer) {
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
/*    */     extends GLDebugMessageARBCallback {
/*    */     private final GLDebugMessageARBCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLDebugMessageARBCallbackI delegate) {
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


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLDebugMessageARBCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */