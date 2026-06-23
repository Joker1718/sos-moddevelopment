/*    */ package org.lwjgl.glfw;
/*    */ 
/*    */ import org.lwjgl.system.Callback;
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
/*    */ public abstract class GLFWIMEStatusCallback
/*    */   extends Callback
/*    */   implements GLFWIMEStatusCallbackI
/*    */ {
/*    */   public static GLFWIMEStatusCallback create(long functionPointer) {
/* 25 */     GLFWIMEStatusCallbackI instance = (GLFWIMEStatusCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWIMEStatusCallback) ? (GLFWIMEStatusCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWIMEStatusCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWIMEStatusCallback create(GLFWIMEStatusCallbackI instance) {
/* 38 */     return (instance instanceof GLFWIMEStatusCallback) ? (GLFWIMEStatusCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWIMEStatusCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWIMEStatusCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWIMEStatusCallback set(long window) {
/* 53 */     GLFW.glfwSetIMEStatusCallback(window, this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWIMEStatusCallback {
/*    */     private final GLFWIMEStatusCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWIMEStatusCallbackI delegate) {
/* 62 */       super(functionPointer);
/* 63 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long window) {
/* 68 */       this.delegate.invoke(window);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWIMEStatusCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */