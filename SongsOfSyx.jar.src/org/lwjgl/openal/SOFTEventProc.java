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
/*    */ public abstract class SOFTEventProc
/*    */   extends Callback
/*    */   implements SOFTEventProcI
/*    */ {
/*    */   public static SOFTEventProc create(long functionPointer) {
/* 23 */     SOFTEventProcI instance = (SOFTEventProcI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof SOFTEventProc) ? (SOFTEventProc)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static SOFTEventProc createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static SOFTEventProc create(SOFTEventProcI instance) {
/* 36 */     return (instance instanceof SOFTEventProc) ? (SOFTEventProc)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected SOFTEventProc() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   SOFTEventProc(long functionPointer) {
/* 46 */     super(functionPointer);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends SOFTEventProc {
/*    */     private final SOFTEventProcI delegate;
/*    */     
/*    */     Container(long functionPointer, SOFTEventProcI delegate) {
/* 54 */       super(functionPointer);
/* 55 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(int eventType, int object, int param, int length, long message, long userParam) {
/* 60 */       this.delegate.invoke(eventType, object, param, length, message, userParam);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\SOFTEventProc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */