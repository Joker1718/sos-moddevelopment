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
/*    */ public abstract class GLFWPreeditCandidateCallback
/*    */   extends Callback
/*    */   implements GLFWPreeditCandidateCallbackI
/*    */ {
/*    */   public static GLFWPreeditCandidateCallback create(long functionPointer) {
/* 25 */     GLFWPreeditCandidateCallbackI instance = (GLFWPreeditCandidateCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWPreeditCandidateCallback) ? (GLFWPreeditCandidateCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWPreeditCandidateCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWPreeditCandidateCallback create(GLFWPreeditCandidateCallbackI instance) {
/* 38 */     return (instance instanceof GLFWPreeditCandidateCallback) ? (GLFWPreeditCandidateCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWPreeditCandidateCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWPreeditCandidateCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWPreeditCandidateCallback set(long window) {
/* 53 */     GLFW.glfwSetPreeditCandidateCallback(window, this);
/* 54 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWPreeditCandidateCallback {
/*    */     private final GLFWPreeditCandidateCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWPreeditCandidateCallbackI delegate) {
/* 62 */       super(functionPointer);
/* 63 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long window, int candidates_count, int selected_index, int page_start, int page_size) {
/* 68 */       this.delegate.invoke(window, candidates_count, selected_index, page_start, page_size);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWPreeditCandidateCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */