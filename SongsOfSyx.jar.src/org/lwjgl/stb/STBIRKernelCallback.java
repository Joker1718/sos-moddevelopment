/*    */ package org.lwjgl.stb;
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
/*    */ public abstract class STBIRKernelCallback
/*    */   extends Callback
/*    */   implements STBIRKernelCallbackI
/*    */ {
/*    */   public static STBIRKernelCallback create(long functionPointer) {
/* 23 */     STBIRKernelCallbackI instance = (STBIRKernelCallbackI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof STBIRKernelCallback) ? (STBIRKernelCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static STBIRKernelCallback createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static STBIRKernelCallback create(STBIRKernelCallbackI instance) {
/* 36 */     return (instance instanceof STBIRKernelCallback) ? (STBIRKernelCallback)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected STBIRKernelCallback() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   STBIRKernelCallback(long functionPointer) {
/* 46 */     super(functionPointer);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends STBIRKernelCallback {
/*    */     private final STBIRKernelCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, STBIRKernelCallbackI delegate) {
/* 54 */       super(functionPointer);
/* 55 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public float invoke(float x, float scale, long user_data) {
/* 60 */       return this.delegate.invoke(x, scale, user_data);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBIRKernelCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */