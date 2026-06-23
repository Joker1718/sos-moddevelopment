/*    */ package snake2d.util.sets;
/*    */ 
/*    */ public interface Valued<T> {
/*    */   T t();
/*    */   
/*    */   double value();
/*    */   
/*    */   public static class ValuedImp<T>
/*    */     implements Valued<T> {
/*    */     public final T t;
/*    */     public double value;
/*    */     
/*    */     public ValuedImp(T t) {
/* 14 */       this.t = t;
/*    */     }
/*    */ 
/*    */     
/*    */     public T t() {
/* 19 */       return this.t;
/*    */     }
/*    */ 
/*    */     
/*    */     public double value() {
/* 24 */       return this.value;
/*    */     }
/*    */     
/*    */     public ValuedImp<T> set(double d) {
/* 28 */       this.value = d;
/* 29 */       return this;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\Valued.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */