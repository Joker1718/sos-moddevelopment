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
/*    */ public abstract class GLFWMonitorCallback
/*    */   extends Callback
/*    */   implements GLFWMonitorCallbackI
/*    */ {
/*    */   public static GLFWMonitorCallback create(long functionPointer) {
/* 25 */     GLFWMonitorCallbackI instance = (GLFWMonitorCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWMonitorCallback) ? (GLFWMonitorCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWMonitorCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWMonitorCallback create(GLFWMonitorCallbackI instance) {
/* 38 */     return (instance instanceof GLFWMonitorCallback) ? (GLFWMonitorCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWMonitorCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWMonitorCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWMonitorCallback set() {
/* 53 */     GLFW.glfwSetMonitorCallback(this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWMonitorCallback {
/*    */     private final GLFWMonitorCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWMonitorCallbackI delegate) {
/* 62 */       super(functionPointer);
/* 63 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long monitor, int event) {
/* 68 */       this.delegate.invoke(monitor, event);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWMonitorCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */