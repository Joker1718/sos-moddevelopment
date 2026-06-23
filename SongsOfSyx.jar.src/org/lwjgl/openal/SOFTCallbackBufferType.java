/*    */ package org.lwjgl.openal;
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
/*    */ public abstract class SOFTCallbackBufferType
/*    */   extends Callback
/*    */   implements SOFTCallbackBufferTypeI
/*    */ {
/*    */   public static SOFTCallbackBufferType create(long functionPointer) {
/* 23 */     SOFTCallbackBufferTypeI instance = (SOFTCallbackBufferTypeI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof SOFTCallbackBufferType) ? (SOFTCallbackBufferType)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static SOFTCallbackBufferType createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static SOFTCallbackBufferType create(SOFTCallbackBufferTypeI instance) {
/* 36 */     return (instance instanceof SOFTCallbackBufferType) ? (SOFTCallbackBufferType)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected SOFTCallbackBufferType() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   SOFTCallbackBufferType(long functionPointer) {
/* 46 */     super(functionPointer);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends SOFTCallbackBufferType {
/*    */     private final SOFTCallbackBufferTypeI delegate;
/*    */     
/*    */     Container(long functionPointer, SOFTCallbackBufferTypeI delegate) {
/* 54 */       super(functionPointer);
/* 55 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public int invoke(long userptr, long sampledata, int numbytes) {
/* 60 */       return this.delegate.invoke(userptr, sampledata, numbytes);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\SOFTCallbackBufferType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */