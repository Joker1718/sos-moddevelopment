/*    */ package util.data;
/*    */ 
/*    */ public interface GETTER<T> {
/*    */   T get();
/*    */   
/*    */   public static interface GETTERE<T> extends GETTER<T> {
/*    */     void set(T param1T);
/*    */   }
/*    */   
/*    */   public static class GETTER_IMP<T> implements GETTERE<T> {
/*    */     public T a;
/*    */     
/*    */     public GETTER_IMP() {}
/*    */     
/*    */     public GETTER_IMP(T t) {
/* 16 */       this.a = t;
/*    */     }
/*    */ 
/*    */     
/*    */     public void set(T t) {
/* 21 */       this.a = t;
/*    */     }
/*    */ 
/*    */     
/*    */     public T get() {
/* 26 */       return this.a;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\GETTER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */