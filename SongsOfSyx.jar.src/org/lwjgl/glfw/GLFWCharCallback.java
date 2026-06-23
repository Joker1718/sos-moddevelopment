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
/*    */ public abstract class GLFWCharCallback
/*    */   extends Callback
/*    */   implements GLFWCharCallbackI
/*    */ {
/*    */   public static GLFWCharCallback create(long functionPointer) {
/* 25 */     GLFWCharCallbackI instance = (GLFWCharCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWCharCallback) ? (GLFWCharCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWCharCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWCharCallback create(GLFWCharCallbackI instance) {
/* 38 */     return (instance instanceof GLFWCharCallback) ? (GLFWCharCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWCharCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWCharCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWCharCallback set(long window) {
/* 53 */     GLFW.glfwSetCharCallback(window, this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWCharCallback {
/*    */     private final GLFWCharCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWCharCallbackI delegate) {
/* 62 */       super(functionPointer);
/* 63 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long window, int codepoint) {
/* 68 */       this.delegate.invoke(window, codepoint);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWCharCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */