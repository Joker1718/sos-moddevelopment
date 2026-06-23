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
/*    */ public abstract class GLFWWindowIconifyCallback
/*    */   extends Callback
/*    */   implements GLFWWindowIconifyCallbackI
/*    */ {
/*    */   public static GLFWWindowIconifyCallback create(long functionPointer) {
/* 25 */     GLFWWindowIconifyCallbackI instance = (GLFWWindowIconifyCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWWindowIconifyCallback) ? (GLFWWindowIconifyCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWWindowIconifyCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWWindowIconifyCallback create(GLFWWindowIconifyCallbackI instance) {
/* 38 */     return (instance instanceof GLFWWindowIconifyCallback) ? (GLFWWindowIconifyCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWWindowIconifyCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWWindowIconifyCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWWindowIconifyCallback set(long window) {
/* 53 */     GLFW.glfwSetWindowIconifyCallback(window, this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWWindowIconifyCallback {
/*    */     private final GLFWWindowIconifyCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWWindowIconifyCallbackI delegate) {
/* 62 */       super(functionPointer);
/* 63 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long window, boolean iconified) {
/* 68 */       this.delegate.invoke(window, iconified);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWWindowIconifyCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */