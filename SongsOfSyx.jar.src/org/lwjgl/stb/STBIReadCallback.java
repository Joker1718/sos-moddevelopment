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
/*    */ public abstract class STBIReadCallback
/*    */   extends Callback
/*    */   implements STBIReadCallbackI
/*    */ {
/*    */   public static STBIReadCallback create(long functionPointer) {
/* 25 */     STBIReadCallbackI instance = (STBIReadCallbackI)Callback.get(functionPointer);
/* 26 */     return (instance instanceof STBIReadCallback) ? (STBIReadCallback)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static STBIReadCallback createSafe(long functionPointer) {
/* 33 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static STBIReadCallback create(STBIReadCallbackI instance) {
/* 38 */     return (instance instanceof STBIReadCallback) ? (STBIReadCallback)instance : new Container(instance
/*    */         
/* 40 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected STBIReadCallback() {
/* 44 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   STBIReadCallback(long functionPointer) {
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
/*    */     extends STBIReadCallback {
/*    */     private final STBIReadCallbackI delegate;
/*    */     
/*    */     Container(long functionPointer, STBIReadCallbackI delegate) {
/* 70 */       super(functionPointer);
/* 71 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public int invoke(long user, long data, int size) {
/* 76 */       return this.delegate.invoke(user, data, size);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBIReadCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */