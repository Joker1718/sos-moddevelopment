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
/*    */ public abstract class GLFWFramebufferSizeCallback
/*    */   extends Callback
/*    */   implements GLFWFramebufferSizeCallbackI
/*    */ {
/*    */   public static GLFWFramebufferSizeCallback create(long functionPointer) {
/* 25 */     GLFWFramebufferSizeCallbackI instance = (GLFWFramebufferSizeCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWFramebufferSizeCallback) ? (GLFWFramebufferSizeCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWFramebufferSizeCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWFramebufferSizeCallback create(GLFWFramebufferSizeCallbackI instance) {
/* 38 */     return (instance instanceof GLFWFramebufferSizeCallback) ? (GLFWFramebufferSizeCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWFramebufferSizeCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWFramebufferSizeCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWFramebufferSizeCallback set(long window) {
/* 53 */     GLFW.glfwSetFramebufferSizeCallback(window, this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWFramebufferSizeCallback {
/*    */     private final GLFWFramebufferSizeCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWFramebufferSizeCallbackI delegate) {
/* 62 */       super(functionPointer);
/* 63 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long window, int width, int height) {
/* 68 */       this.delegate.invoke(window, width, height);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWFramebufferSizeCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */