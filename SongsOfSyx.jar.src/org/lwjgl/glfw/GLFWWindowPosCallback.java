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
/*    */ public abstract class GLFWWindowPosCallback
/*    */   extends Callback
/*    */   implements GLFWWindowPosCallbackI
/*    */ {
/*    */   public static GLFWWindowPosCallback create(long functionPointer) {
/* 25 */     GLFWWindowPosCallbackI instance = (GLFWWindowPosCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWWindowPosCallback) ? (GLFWWindowPosCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWWindowPosCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWWindowPosCallback create(GLFWWindowPosCallbackI instance) {
/* 38 */     return (instance instanceof GLFWWindowPosCallback) ? (GLFWWindowPosCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWWindowPosCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWWindowPosCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWWindowPosCallback set(long window) {
/* 53 */     GLFW.glfwSetWindowPosCallback(window, this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWWindowPosCallback {
/*    */     private final GLFWWindowPosCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWWindowPosCallbackI delegate) {
/* 62 */       super(functionPointer);
/* 63 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long window, int xpos, int ypos) {
/* 68 */       this.delegate.invoke(window, xpos, ypos);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWWindowPosCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */