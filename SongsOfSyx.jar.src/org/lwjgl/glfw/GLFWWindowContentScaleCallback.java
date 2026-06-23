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
/*    */ public abstract class GLFWWindowContentScaleCallback
/*    */   extends Callback
/*    */   implements GLFWWindowContentScaleCallbackI
/*    */ {
/*    */   public static GLFWWindowContentScaleCallback create(long functionPointer) {
/* 25 */     GLFWWindowContentScaleCallbackI instance = (GLFWWindowContentScaleCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWWindowContentScaleCallback) ? (GLFWWindowContentScaleCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWWindowContentScaleCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWWindowContentScaleCallback create(GLFWWindowContentScaleCallbackI instance) {
/* 38 */     return (instance instanceof GLFWWindowContentScaleCallback) ? (GLFWWindowContentScaleCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWWindowContentScaleCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWWindowContentScaleCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWWindowContentScaleCallback set(long window) {
/* 53 */     GLFW.glfwSetWindowContentScaleCallback(window, this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWWindowContentScaleCallback {
/*    */     private final GLFWWindowContentScaleCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWWindowContentScaleCallbackI delegate) {
/* 62 */       super(functionPointer);
/* 63 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long window, float xscale, float yscale) {
/* 68 */       this.delegate.invoke(window, xscale, yscale);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWWindowContentScaleCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */