/*    */ package org.lwjgl.glfw;
/*    */ 
/*    */ import org.lwjgl.system.Callback;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.Pointer;
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
/*    */ public abstract class GLFWDropCallback
/*    */   extends Callback
/*    */   implements GLFWDropCallbackI
/*    */ {
/*    */   public static GLFWDropCallback create(long functionPointer) {
/* 25 */     GLFWDropCallbackI instance = (GLFWDropCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof GLFWDropCallback) ? (GLFWDropCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWDropCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWDropCallback create(GLFWDropCallbackI instance) {
/* 38 */     return (instance instanceof GLFWDropCallback) ? (GLFWDropCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWDropCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWDropCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
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
/*    */   public static String getName(long names, int index) {
/* 62 */     return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(names + (Pointer.POINTER_SIZE * index)));
/*    */   }
/*    */ 
/*    */   
/*    */   public GLFWDropCallback set(long window) {
/* 67 */     GLFW.glfwSetDropCallback(window, this);
/* 68 */     return this;
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWDropCallback {
/*    */     private final GLFWDropCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWDropCallbackI delegate) {
/* 76 */       super(functionPointer);
/* 77 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long window, int count, long names) {
/* 82 */       this.delegate.invoke(window, count, names);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWDropCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */