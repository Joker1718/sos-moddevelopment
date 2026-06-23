/*    */ package org.lwjgl.system.macosx;
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
/*    */ public abstract class EnumerationMutationHandler
/*    */   extends Callback
/*    */   implements EnumerationMutationHandlerI
/*    */ {
/*    */   public static EnumerationMutationHandler create(long functionPointer) {
/* 23 */     EnumerationMutationHandlerI instance = (EnumerationMutationHandlerI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof EnumerationMutationHandler) ? (EnumerationMutationHandler)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static EnumerationMutationHandler createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static EnumerationMutationHandler create(EnumerationMutationHandlerI instance) {
/* 36 */     return (instance instanceof EnumerationMutationHandler) ? (EnumerationMutationHandler)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected EnumerationMutationHandler() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   EnumerationMutationHandler(long functionPointer) {
/* 46 */     super(functionPointer);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends EnumerationMutationHandler {
/*    */     private final EnumerationMutationHandlerI delegate;
/*    */     
/*    */     Container(long functionPointer, EnumerationMutationHandlerI delegate) {
/* 54 */       super(functionPointer);
/* 55 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long id) {
/* 60 */       this.delegate.invoke(id);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\macosx\EnumerationMutationHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */