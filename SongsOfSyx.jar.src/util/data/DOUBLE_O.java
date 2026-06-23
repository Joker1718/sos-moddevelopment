/*    */ package util.data;
/*    */ 
/*    */ import util.info.INFO;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ public interface DOUBLE_O<T>
/*    */ {
/*    */   double getD(T paramT);
/*    */   
/*    */   public static interface DOUBLE_OE<T>
/*    */     extends DOUBLE_O<T> {
/*    */     default DOUBLE_OE<T> incD(T t, double d) {
/* 13 */       setD(t, getD(t) + d);
/* 14 */       return this;
/*    */     }
/*    */     
/*    */     DOUBLE_OE<T> setD(T param1T, double param1Double); }
/*    */   
/*    */   default INFO info() {
/* 20 */     return null;
/*    */   }
/*    */   
/*    */   public static abstract class DoubleOCached<T>
/*    */     implements DOUBLE_O<T> {
/* 25 */     private int upI = -1;
/* 26 */     private T upR = null;
/*    */     
/*    */     private double cache;
/*    */     
/*    */     public double getD(T t) {
/* 31 */       if (this.upI != VIEW.RI() || this.upR != t) {
/* 32 */         this.upI = VIEW.RI();
/* 33 */         this.upR = t;
/* 34 */         this.cache = getValue(t);
/*    */       } 
/* 36 */       return this.cache;
/*    */     }
/*    */     
/*    */     public abstract double getValue(T param1T);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\DOUBLE_O.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */