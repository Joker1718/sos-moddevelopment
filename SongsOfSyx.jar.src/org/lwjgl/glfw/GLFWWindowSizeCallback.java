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
/*    */ public abstract class GLFWWindowSizeCallback
/*    */   extends Callback
/*    */   implements GLFWWindowSizeCallbackI
/*    */ {
/*    */   public static GLFWWindowSizeCallback create(long functionPointer) {
/* 25 */     GLFWWindowSizeCallbackI instance = (GLFWWindowSizeCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWWindowSizeCallback) ? (GLFWWindowSizeCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWWindowSizeCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWWindowSizeCallback create(GLFWWindowSizeCallbackI instance) {
/* 38 */     return (instance instanceof GLFWWindowSizeCallback) ? (GLFWWindowSizeCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWWindowSizeCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWWindowSizeCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWWindowSizeCallback set(long window) {
/* 53 */     GLFW.glfwSetWindowSizeCallback(window, this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWWindowSizeCallback {
/*    */     private final GLFWWindowSizeCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWWindowSizeCallbackI delegate) {
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


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWWindowSizeCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */