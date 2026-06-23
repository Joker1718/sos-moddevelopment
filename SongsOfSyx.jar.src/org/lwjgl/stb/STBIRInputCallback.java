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
/*    */ public abstract class STBIRInputCallback
/*    */   extends Callback
/*    */   implements STBIRInputCallbackI
/*    */ {
/*    */   public static STBIRInputCallback create(long functionPointer) {
/* 23 */     STBIRInputCallbackI instance = (STBIRInputCallbackI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof STBIRInputCallback) ? (STBIRInputCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static STBIRInputCallback createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static STBIRInputCallback create(STBIRInputCallbackI instance) {
/* 36 */     return (instance instanceof STBIRInputCallback) ? (STBIRInputCallback)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected STBIRInputCallback() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   STBIRInputCallback(long functionPointer) {
/* 46 */     super(functionPointer);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends STBIRInputCallback {
/*    */     private final STBIRInputCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, STBIRInputCallbackI delegate) {
/* 54 */       super(functionPointer);
/* 55 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long optional_output, long input_ptr, int num_pixels, int x, int y, long context) {
/* 60 */       this.delegate.invoke(optional_output, input_ptr, num_pixels, x, y, context);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBIRInputCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */