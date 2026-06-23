/*    */ package util.data;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GETTER_IMP<T>
/*    */   implements GETTER.GETTERE<T>
/*    */ {
/*    */   public T a;
/*    */   
/*    */   public GETTER_IMP() {}
/*    */   
/*    */   public GETTER_IMP(T t) {
/* 16 */     this.a = t;
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(T t) {
/* 21 */     this.a = t;
/*    */   }
/*    */ 
/*    */   
/*    */   public T get() {
/* 26 */     return this.a;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\GETTER$GETTER_IMP.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */