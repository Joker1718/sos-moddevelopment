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
/*    */ public abstract class GLFWWindowRefreshCallback
/*    */   extends Callback
/*    */   implements GLFWWindowRefreshCallbackI
/*    */ {
/*    */   public static GLFWWindowRefreshCallback create(long functionPointer) {
/* 25 */     GLFWWindowRefreshCallbackI instance = (GLFWWindowRefreshCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWWindowRefreshCallback) ? (GLFWWindowRefreshCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWWindowRefreshCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWWindowRefreshCallback create(GLFWWindowRefreshCallbackI instance) {
/* 38 */     return (instance instanceof GLFWWindowRefreshCallback) ? (GLFWWindowRefreshCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWWindowRefreshCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWWindowRefreshCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWWindowRefreshCallback set(long window) {
/* 53 */     GLFW.glfwSetWindowRefreshCallback(window, this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWWindowRefreshCallback {
/*    */     private final GLFWWindowRefreshCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWWindowRefreshCallbackI delegate) {
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


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWWindowRefreshCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */