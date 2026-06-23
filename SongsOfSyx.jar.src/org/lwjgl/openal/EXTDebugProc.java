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
/*    */ public abstract class EXTDebugProc
/*    */   extends Callback
/*    */   implements EXTDebugProcI
/*    */ {
/*    */   public static EXTDebugProc create(long functionPointer) {
/* 23 */     EXTDebugProcI instance = (EXTDebugProcI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof EXTDebugProc) ? (EXTDebugProc)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static EXTDebugProc createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static EXTDebugProc create(EXTDebugProcI instance) {
/* 36 */     return (instance instanceof EXTDebugProc) ? (EXTDebugProc)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected EXTDebugProc() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   EXTDebugProc(long functionPointer) {
/* 46 */     super(functionPointer);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends EXTDebugProc {
/*    */     private final EXTDebugProcI delegate;
/*    */     
/*    */     Container(long functionPointer, EXTDebugProcI delegate) {
/* 54 */       super(functionPointer);
/* 55 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(int source, int type, int id, int severity, int length, long message, long userParam) {
/* 60 */       this.delegate.invoke(source, type, id, severity, length, message, userParam);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\EXTDebugProc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */