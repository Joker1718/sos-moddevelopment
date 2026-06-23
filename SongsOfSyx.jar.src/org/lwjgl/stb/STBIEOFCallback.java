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
/*    */ public abstract class STBIEOFCallback
/*    */   extends Callback
/*    */   implements STBIEOFCallbackI
/*    */ {
/*    */   public static STBIEOFCallback create(long functionPointer) {
/* 23 */     STBIEOFCallbackI instance = (STBIEOFCallbackI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof STBIEOFCallback) ? (STBIEOFCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static STBIEOFCallback createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static STBIEOFCallback create(STBIEOFCallbackI instance) {
/* 36 */     return (instance instanceof STBIEOFCallback) ? (STBIEOFCallback)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected STBIEOFCallback() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   STBIEOFCallback(long functionPointer) {
/* 46 */     super(functionPointer);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends STBIEOFCallback {
/*    */     private final STBIEOFCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, STBIEOFCallbackI delegate) {
/* 54 */       super(functionPointer);
/* 55 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public int invoke(long user) {
/* 60 */       return this.delegate.invoke(user);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBIEOFCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */