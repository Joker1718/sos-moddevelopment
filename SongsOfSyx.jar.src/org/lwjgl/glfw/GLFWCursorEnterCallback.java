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
/*    */ public abstract class GLFWCursorEnterCallback
/*    */   extends Callback
/*    */   implements GLFWCursorEnterCallbackI
/*    */ {
/*    */   public static GLFWCursorEnterCallback create(long functionPointer) {
/* 25 */     GLFWCursorEnterCallbackI instance = (GLFWCursorEnterCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWCursorEnterCallback) ? (GLFWCursorEnterCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWCursorEnterCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWCursorEnterCallback create(GLFWCursorEnterCallbackI instance) {
/* 38 */     return (instance instanceof GLFWCursorEnterCallback) ? (GLFWCursorEnterCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWCursorEnterCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWCursorEnterCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWCursorEnterCallback set(long window) {
/* 53 */     GLFW.glfwSetCursorEnterCallback(window, this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWCursorEnterCallback {
/*    */     private final GLFWCursorEnterCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWCursorEnterCallbackI delegate) {
/* 62 */       super(functionPointer);
/* 63 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long window, boolean entered) {
/* 68 */       this.delegate.invoke(window, entered);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWCursorEnterCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */