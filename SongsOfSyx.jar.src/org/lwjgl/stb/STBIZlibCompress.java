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
/*    */ public abstract class STBIZlibCompress
/*    */   extends Callback
/*    */   implements STBIZlibCompressI
/*    */ {
/*    */   public static STBIZlibCompress create(long functionPointer) {
/* 23 */     STBIZlibCompressI instance = (STBIZlibCompressI)Callback.get(functionPointer);
/* 24 */     return (instance instanceof STBIZlibCompress) ? (STBIZlibCompress)instance : new Container(functionPointer, instance);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static STBIZlibCompress createSafe(long functionPointer) {
/* 31 */     return (functionPointer == 0L) ? null : create(functionPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static STBIZlibCompress create(STBIZlibCompressI instance) {
/* 36 */     return (instance instanceof STBIZlibCompress) ? (STBIZlibCompress)instance : new Container(instance
/*    */         
/* 38 */         .address(), instance);
/*    */   }
/*    */   
/*    */   protected STBIZlibCompress() {
/* 42 */     super(DESCRIPTOR);
/*    */   }
/*    */   
/*    */   STBIZlibCompress(long functionPointer) {
/* 46 */     super(functionPointer);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends STBIZlibCompress {
/*    */     private final STBIZlibCompressI delegate;
/*    */     
/*    */     Container(long functionPointer, STBIZlibCompressI delegate) {
/* 54 */       super(functionPointer);
/* 55 */       this.delegate = delegate;
/*    */     }
/*    */ 
/*    */     
/*    */     public long invoke(long data, int data_len, long out_len, int quality) {
/* 60 */       return this.delegate.invoke(data, data_len, out_len, quality);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\stb\STBIZlibCompress.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */