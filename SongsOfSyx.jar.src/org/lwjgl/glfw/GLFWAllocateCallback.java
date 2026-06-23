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
/*    */ public abstract class GLFWAllocateCallback
/*    */   extends Callback
/*    */   implements GLFWAllocateCallbackI
/*    */ {
/*    */   public static GLFWAllocateCallback create(long functionPointer) {
/* 23 */     GLFWAllocateCallbackI instance = (GLFWAllocateCallbackI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof GLFWAllocateCallback) ? (GLFWAllocateCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWAllocateCallback createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWAllocateCallback create(GLFWAllocateCallbackI instance) {
/* 36 */     return (instance instanceof GLFWAllocateCallback) ? (GLFWAllocateCallback)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWAllocateCallback() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWAllocateCallback(long functionPointer) {
/* 46 */     super(functionPointer);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWAllocateCallback {
/*    */     private final GLFWAllocateCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWAllocateCallbackI delegate) {
/* 54 */       super(functionPointer);
/* 55 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public long invoke(long size, long user) {
/* 60 */       return this.delegate.invoke(size, user);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWAllocateCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */