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
/*    */ public abstract class GLFWMouseButtonCallback
/*    */   extends Callback
/*    */   implements GLFWMouseButtonCallbackI
/*    */ {
/*    */   public static GLFWMouseButtonCallback create(long functionPointer) {
/* 25 */     GLFWMouseButtonCallbackI instance = (GLFWMouseButtonCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWMouseButtonCallback) ? (GLFWMouseButtonCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWMouseButtonCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWMouseButtonCallback create(GLFWMouseButtonCallbackI instance) {
/* 38 */     return (instance instanceof GLFWMouseButtonCallback) ? (GLFWMouseButtonCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWMouseButtonCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWMouseButtonCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWMouseButtonCallback set(long window) {
/* 53 */     GLFW.glfwSetMouseButtonCallback(window, this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWMouseButtonCallback {
/*    */     private final GLFWMouseButtonCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWMouseButtonCallbackI delegate) {
/* 62 */       super(functionPointer);
/* 63 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long window, int button, int action, int mods) {
/* 68 */       this.delegate.invoke(window, button, action, mods);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWMouseButtonCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */