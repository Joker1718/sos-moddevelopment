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
/*    */ public abstract class GLFWDeallocateCallback
/*    */   extends Callback
/*    */   implements GLFWDeallocateCallbackI
/*    */ {
/*    */   public static GLFWDeallocateCallback create(long functionPointer) {
/* 23 */     GLFWDeallocateCallbackI instance = (GLFWDeallocateCallbackI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof GLFWDeallocateCallback) ? (GLFWDeallocateCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static GLFWDeallocateCallback createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static GLFWDeallocateCallback create(GLFWDeallocateCallbackI instance) {
/* 36 */     return (instance instanceof GLFWDeallocateCallback) ? (GLFWDeallocateCallback)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected GLFWDeallocateCallback() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   GLFWDeallocateCallback(long functionPointer) {
/* 46 */     super(functionPointer);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends GLFWDeallocateCallback {
/*    */     private final GLFWDeallocateCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, GLFWDeallocateCallbackI delegate) {
/* 54 */       super(functionPointer);
/* 55 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long block, long user) {
/* 60 */       this.delegate.invoke(block, user);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\glfw\GLFWDeallocateCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */