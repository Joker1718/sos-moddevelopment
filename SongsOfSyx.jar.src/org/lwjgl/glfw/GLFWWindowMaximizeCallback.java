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
/*    */ public abstract class GLFWWindowMaximizeCallback
/*    */   extends Callback
/*    */   implements GLFWWindowMaximizeCallbackI
/*    */ {
/*    */   public static GLFWWindowMaximizeCallback create(long functionPointer) {
/* 25 */     GLFWWindowMaximizeCallbackI instance = (GLFWWindowMaximizeCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWWindowMaximizeCallback) ? (GLFWWindowMaximizeCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWWindowMaximizeCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWWindowMaximizeCallback create(GLFWWindowMaximizeCallbackI instance) {
/* 38 */     return (instance instanceof GLFWWindowMaximizeCallback) ? (GLFWWindowMaximizeCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWWindowMaximizeCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWWindowMaximizeCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWWindowMaximizeCallback set(long window) {
/* 53 */     GLFW.glfwSetWindowMaximizeCallback(window, this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWWindowMaximizeCallback {
/*    */     private final GLFWWindowMaximizeCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWWindowMaximizeCallbackI delegate) {
/* 62 */       super(functionPointer);
/* 63 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long window, boolean maximized) {
/* 68 */       this.delegate.invoke(window, maximized);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWWindowMaximizeCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */