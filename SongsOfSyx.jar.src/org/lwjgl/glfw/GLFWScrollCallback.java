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
/*    */ public abstract class GLFWScrollCallback
/*    */   extends Callback
/*    */   implements GLFWScrollCallbackI
/*    */ {
/*    */   public static GLFWScrollCallback create(long functionPointer) {
/* 25 */     GLFWScrollCallbackI instance = (GLFWScrollCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWScrollCallback) ? (GLFWScrollCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWScrollCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWScrollCallback create(GLFWScrollCallbackI instance) {
/* 38 */     return (instance instanceof GLFWScrollCallback) ? (GLFWScrollCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWScrollCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWScrollCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWScrollCallback set(long window) {
/* 53 */     GLFW.glfwSetScrollCallback(window, this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWScrollCallback {
/*    */     private final GLFWScrollCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWScrollCallbackI delegate) {
/* 62 */       super(functionPointer);
/* 63 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long window, double xoffset, double yoffset) {
/* 68 */       this.delegate.invoke(window, xoffset, yoffset);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWScrollCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */