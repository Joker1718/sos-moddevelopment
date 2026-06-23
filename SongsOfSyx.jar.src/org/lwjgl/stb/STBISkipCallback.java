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
/*    */ public abstract class STBISkipCallback
/*    */   extends Callback
/*    */   implements STBISkipCallbackI
/*    */ {
/*    */   public static STBISkipCallback create(long functionPointer) {
/* 23 */     STBISkipCallbackI instance = (STBISkipCallbackI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof STBISkipCallback) ? (STBISkipCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static STBISkipCallback createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static STBISkipCallback create(STBISkipCallbackI instance) {
/* 36 */     return (instance instanceof STBISkipCallback) ? (STBISkipCallback)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected STBISkipCallback() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   STBISkipCallback(long functionPointer) {
/* 46 */     super(functionPointer);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends STBISkipCallback {
/*    */     private final STBISkipCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, STBISkipCallbackI delegate) {
/* 54 */       super(functionPointer);
/* 55 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long user, int n) {
/* 60 */       this.delegate.invoke(user, n);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBISkipCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */