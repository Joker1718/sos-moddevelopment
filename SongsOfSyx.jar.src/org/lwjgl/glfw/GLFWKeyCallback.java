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
/*    */ public abstract class GLFWKeyCallback
/*    */   extends Callback
/*    */   implements GLFWKeyCallbackI
/*    */ {
/*    */   public static GLFWKeyCallback create(long functionPointer) {
/* 25 */     GLFWKeyCallbackI instance = (GLFWKeyCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWKeyCallback) ? (GLFWKeyCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWKeyCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWKeyCallback create(GLFWKeyCallbackI instance) {
/* 38 */     return (instance instanceof GLFWKeyCallback) ? (GLFWKeyCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWKeyCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWKeyCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWKeyCallback set(long window) {
/* 53 */     GLFW.glfwSetKeyCallback(window, this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWKeyCallback {
/*    */     private final GLFWKeyCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWKeyCallbackI delegate) {
/* 62 */       super(functionPointer);
/* 63 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long window, int key, int scancode, int action, int mods) {
/* 68 */       this.delegate.invoke(window, key, scancode, action, mods);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWKeyCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */