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
/*    */ public abstract class GLFWCursorPosCallback
/*    */   extends Callback
/*    */   implements GLFWCursorPosCallbackI
/*    */ {
/*    */   public static GLFWCursorPosCallback create(long functionPointer) {
/* 25 */     GLFWCursorPosCallbackI instance = (GLFWCursorPosCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWCursorPosCallback) ? (GLFWCursorPosCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWCursorPosCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWCursorPosCallback create(GLFWCursorPosCallbackI instance) {
/* 38 */     return (instance instanceof GLFWCursorPosCallback) ? (GLFWCursorPosCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWCursorPosCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWCursorPosCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWCursorPosCallback set(long window) {
/* 53 */     GLFW.glfwSetCursorPosCallback(window, this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWCursorPosCallback {
/*    */     private final GLFWCursorPosCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWCursorPosCallbackI delegate) {
/* 62 */       super(functionPointer);
/* 63 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long window, double xpos, double ypos) {
/* 68 */       this.delegate.invoke(window, xpos, ypos);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWCursorPosCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */