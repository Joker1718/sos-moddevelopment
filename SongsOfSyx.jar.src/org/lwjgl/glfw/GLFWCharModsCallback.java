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
/*    */ public abstract class GLFWCharModsCallback
/*    */   extends Callback
/*    */   implements GLFWCharModsCallbackI
/*    */ {
/*    */   public static GLFWCharModsCallback create(long functionPointer) {
/* 25 */     GLFWCharModsCallbackI instance = (GLFWCharModsCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWCharModsCallback) ? (GLFWCharModsCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWCharModsCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWCharModsCallback create(GLFWCharModsCallbackI instance) {
/* 38 */     return (instance instanceof GLFWCharModsCallback) ? (GLFWCharModsCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWCharModsCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWCharModsCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWCharModsCallback set(long window) {
/* 53 */     GLFW.glfwSetCharModsCallback(window, this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWCharModsCallback {
/*    */     private final GLFWCharModsCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWCharModsCallbackI delegate) {
/* 62 */       super(functionPointer);
/* 63 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long window, int codepoint, int mods) {
/* 68 */       this.delegate.invoke(window, codepoint, mods);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWCharModsCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */