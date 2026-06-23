/*    */ package snake2d.util.sets;
/*    */ 
/*    */ public interface Tuple<A, B>
/*    */ {
/*    */   A a();
/*    */   
/*    */   B b();
/*    */   
/*    */   public static class TupleImp<A, B>
/*    */     implements Tuple<A, B>
/*    */   {
/*    */     public A a;
/*    */     public B b;
/*    */     
/*    */     public TupleImp() {}
/*    */     
/*    */     public TupleImp(A a, B b) {
/* 18 */       this.a = a;
/* 19 */       this.b = b;
/*    */     }
/*    */ 
/*    */     
/*    */     public A a() {
/* 24 */       return this.a;
/*    */     }
/*    */ 
/*    */     
/*    */     public B b() {
/* 29 */       return this.b;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public static class TupleD<A>
/*    */   {
/*    */     public final A a;
/*    */     
/*    */     public double d;
/*    */     
/*    */     public TupleD(A a) {
/* 41 */       this.a = a;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\Tuple.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */