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
/*    */ public abstract class GLFWReallocateCallback
/*    */   extends Callback
/*    */   implements GLFWReallocateCallbackI
/*    */ {
/*    */   public static GLFWReallocateCallback create(long functionPointer) {
/* 23 */     GLFWReallocateCallbackI instance = (GLFWReallocateCallbackI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof GLFWReallocateCallback) ? (GLFWReallocateCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWReallocateCallback createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWReallocateCallback create(GLFWReallocateCallbackI instance) {
/* 36 */     return (instance instanceof GLFWReallocateCallback) ? (GLFWReallocateCallback)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWReallocateCallback() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWReallocateCallback(long functionPointer) {
/* 46 */     super(functionPointer);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWReallocateCallback {
/*    */     private final GLFWReallocateCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWReallocateCallbackI delegate) {
/* 54 */       super(functionPointer);
/* 55 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public long invoke(long block, long size, long user) {
/* 60 */       return this.delegate.invoke(block, size, user);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWReallocateCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */