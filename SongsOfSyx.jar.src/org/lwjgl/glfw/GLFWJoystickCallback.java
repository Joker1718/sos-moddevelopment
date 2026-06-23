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
/*    */ public abstract class GLFWJoystickCallback
/*    */   extends Callback
/*    */   implements GLFWJoystickCallbackI
/*    */ {
/*    */   public static GLFWJoystickCallback create(long functionPointer) {
/* 25 */     GLFWJoystickCallbackI instance = (GLFWJoystickCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWJoystickCallback) ? (GLFWJoystickCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWJoystickCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWJoystickCallback create(GLFWJoystickCallbackI instance) {
/* 38 */     return (instance instanceof GLFWJoystickCallback) ? (GLFWJoystickCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWJoystickCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWJoystickCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWJoystickCallback set() {
/* 53 */     GLFW.glfwSetJoystickCallback(this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWJoystickCallback {
/*    */     private final GLFWJoystickCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWJoystickCallbackI delegate) {
/* 62 */       super(functionPointer);
/* 63 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(int jid, int event) {
/* 68 */       this.delegate.invoke(jid, event);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWJoystickCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */