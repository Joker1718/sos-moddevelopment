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
/*    */ public abstract class CGEventTapCallBack
/*    */   extends Callback
/*    */   implements CGEventTapCallBackI
/*    */ {
/*    */   public static CGEventTapCallBack create(long functionPointer) {
/* 23 */     CGEventTapCallBackI instance = (CGEventTapCallBackI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof CGEventTapCallBack) ? (CGEventTapCallBack)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static CGEventTapCallBack createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CGEventTapCallBack create(CGEventTapCallBackI instance) {
/* 36 */     return (instance instanceof CGEventTapCallBack) ? (CGEventTapCallBack)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected CGEventTapCallBack() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   CGEventTapCallBack(long functionPointer) {
/* 46 */     super(functionPointer);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends CGEventTapCallBack {
/*    */     private final CGEventTapCallBackI delegate;
/*    */     
/*    */     Container(long functionPointer, CGEventTapCallBackI delegate) {
/* 54 */       super(functionPointer);
/* 55 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public long invoke(long proxy, int type, long event, long userInfo) {
/* 60 */       return this.delegate.invoke(proxy, type, event, userInfo);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\macosx\CGEventTapCallBack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */