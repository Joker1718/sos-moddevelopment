/*    */ package org.lwjgl.stb;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.Callback;
/*    */ import org.lwjgl.system.MemoryUtil;
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
/*    */ public abstract class STBIWriteCallback
/*    */   extends Callback
/*    */   implements STBIWriteCallbackI
/*    */ {
/*    */   public static STBIWriteCallback create(long functionPointer) {
/* 25 */     STBIWriteCallbackI instance = (STBIWriteCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof STBIWriteCallback) ? (STBIWriteCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static STBIWriteCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static STBIWriteCallback create(STBIWriteCallbackI instance) {
/* 38 */     return (instance instanceof STBIWriteCallback) ? (STBIWriteCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected STBIWriteCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   STBIWriteCallback(long functionPointer) {
/* 48 */     super(functionPointer);
/*    */   }
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
/*    */   public static ByteBuffer getData(long data, int size) {
/* 62 */     return MemoryUtil.memByteBuffer(data, size);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends STBIWriteCallback {
/*    */     private final STBIWriteCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, STBIWriteCallbackI delegate) {
/* 70 */       super(functionPointer);
/* 71 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public void invoke(long context, long data, int size) {
/* 76 */       this.delegate.invoke(context, data, size);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBIWriteCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */