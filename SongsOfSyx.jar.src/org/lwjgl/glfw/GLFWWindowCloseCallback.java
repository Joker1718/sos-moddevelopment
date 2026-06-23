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
/*    */ public abstract class GLFWWindowCloseCallback
/*    */   extends Callback
/*    */   implements GLFWWindowCloseCallbackI
/*    */ {
/*    */   public static GLFWWindowCloseCallback create(long functionPointer) {
/* 25 */     GLFWWindowCloseCallbackI instance = (GLFWWindowCloseCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWWindowCloseCallback) ? (GLFWWindowCloseCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWWindowCloseCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWWindowCloseCallback create(GLFWWindowCloseCallbackI instance) {
/* 38 */     return (instance instanceof GLFWWindowCloseCallback) ? (GLFWWindowCloseCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWWindowCloseCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWWindowCloseCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWWindowCloseCallback set(long window) {
/* 53 */     GLFW.glfwSetWindowCloseCallback(window, this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWWindowCloseCallback {
/*    */     private final GLFWWindowCloseCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWWindowCloseCallbackI delegate) {
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


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWWindowCloseCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */