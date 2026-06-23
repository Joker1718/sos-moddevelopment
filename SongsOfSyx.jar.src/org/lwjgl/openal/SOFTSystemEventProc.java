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
/*    */ public abstract class SOFTSystemEventProc
/*    */   extends Callback
/*    */   implements SOFTSystemEventProcI
/*    */ {
/*    */   public static SOFTSystemEventProc create(long functionPointer) {
/* 23 */     SOFTSystemEventProcI instance = (SOFTSystemEventProcI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof SOFTSystemEventProc) ? (SOFTSystemEventProc)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static SOFTSystemEventProc createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static SOFTSystemEventProc create(SOFTSystemEventProcI instance) {
/* 36 */     return (instance instanceof SOFTSystemEventProc) ? (SOFTSystemEventProc)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected SOFTSystemEventProc() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   SOFTSystemEventProc(long functionPointer) {
/* 46 */     super(functionPointer);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends SOFTSystemEventProc {
/*    */     private final SOFTSystemEventProcI delegate;
/*    */     
/*    */     Container(long functionPointer, SOFTSystemEventProcI delegate) {
/* 54 */       super(functionPointer);
/* 55 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(int eventType, int deviceType, long device, int length, long message, long userParam) {
/* 60 */       this.delegate.invoke(eventType, deviceType, device, length, message, userParam);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\SOFTSystemEventProc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */