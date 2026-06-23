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
/*    */ public abstract class STBIROutputCallback
/*    */   extends Callback
/*    */   implements STBIROutputCallbackI
/*    */ {
/*    */   public static STBIROutputCallback create(long functionPointer) {
/* 23 */     STBIROutputCallbackI instance = (STBIROutputCallbackI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof STBIROutputCallback) ? (STBIROutputCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static STBIROutputCallback createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static STBIROutputCallback create(STBIROutputCallbackI instance) {
/* 36 */     return (instance instanceof STBIROutputCallback) ? (STBIROutputCallback)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected STBIROutputCallback() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   STBIROutputCallback(long functionPointer) {
/* 46 */     super(functionPointer);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends STBIROutputCallback {
/*    */     private final STBIROutputCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, STBIROutputCallbackI delegate) {
/* 54 */       super(functionPointer);
/* 55 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long output_ptr, int num_pixels, int x, int y, long context) {
/* 60 */       this.delegate.invoke(output_ptr, num_pixels, x, y, context);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBIROutputCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */