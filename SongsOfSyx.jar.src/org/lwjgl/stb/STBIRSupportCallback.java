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
/*    */ public abstract class STBIRSupportCallback
/*    */   extends Callback
/*    */   implements STBIRSupportCallbackI
/*    */ {
/*    */   public static STBIRSupportCallback create(long functionPointer) {
/* 23 */     STBIRSupportCallbackI instance = (STBIRSupportCallbackI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof STBIRSupportCallback) ? (STBIRSupportCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static STBIRSupportCallback createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static STBIRSupportCallback create(STBIRSupportCallbackI instance) {
/* 36 */     return (instance instanceof STBIRSupportCallback) ? (STBIRSupportCallback)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected STBIRSupportCallback() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   STBIRSupportCallback(long functionPointer) {
/* 46 */     super(functionPointer);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends STBIRSupportCallback {
/*    */     private final STBIRSupportCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, STBIRSupportCallbackI delegate) {
/* 54 */       super(functionPointer);
/* 55 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public float invoke(float scale, long user_data) {
/* 60 */       return this.delegate.invoke(scale, user_data);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBIRSupportCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */