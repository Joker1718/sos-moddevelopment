/*    */ package org.lwjgl.system.windows;
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
/*    */ public abstract class WindowProc
/*    */   extends Callback
/*    */   implements WindowProcI
/*    */ {
/*    */   public static WindowProc create(long functionPointer) {
/* 23 */     WindowProcI instance = (WindowProcI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof WindowProc) ? (WindowProc)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static WindowProc createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static WindowProc create(WindowProcI instance) {
/* 36 */     return (instance instanceof WindowProc) ? (WindowProc)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected WindowProc() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   WindowProc(long functionPointer) {
/* 46 */     super(functionPointer);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends WindowProc {
/*    */     private final WindowProcI delegate;
/*    */     
/*    */     Container(long functionPointer, WindowProcI delegate) {
/* 54 */       super(functionPointer);
/* 55 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public long invoke(long hwnd, int uMsg, long wParam, long lParam) {
/* 60 */       return this.delegate.invoke(hwnd, uMsg, wParam, lParam);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\WindowProc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */