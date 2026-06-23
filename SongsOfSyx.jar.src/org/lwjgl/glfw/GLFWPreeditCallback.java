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
/*    */ public abstract class GLFWPreeditCallback
/*    */   extends Callback
/*    */   implements GLFWPreeditCallbackI
/*    */ {
/*    */   public static GLFWPreeditCallback create(long functionPointer) {
/* 25 */     GLFWPreeditCallbackI instance = (GLFWPreeditCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWPreeditCallback) ? (GLFWPreeditCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWPreeditCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWPreeditCallback create(GLFWPreeditCallbackI instance) {
/* 38 */     return (instance instanceof GLFWPreeditCallback) ? (GLFWPreeditCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWPreeditCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWPreeditCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWPreeditCallback set(long window) {
/* 53 */     GLFW.glfwSetPreeditCallback(window, this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWPreeditCallback {
/*    */     private final GLFWPreeditCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWPreeditCallbackI delegate) {
/* 62 */       super(functionPointer);
/* 63 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long window, int preedit_count, long preedit_string, int block_count, long block_sizes, int focused_block, int caret) {
/* 68 */       this.delegate.invoke(window, preedit_count, preedit_string, block_count, block_sizes, focused_block, caret);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWPreeditCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */