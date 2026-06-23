/*    */ package util.data;
/*    */ 
/*    */ import view.main.VIEW;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class DoubleOCached<T>
/*    */   implements DOUBLE_O<T>
/*    */ {
/* 25 */   private int upI = -1;
/* 26 */   private T upR = null;
/*    */   
/*    */   private double cache;
/*    */   
/*    */   public double getD(T t) {
/* 31 */     if (this.upI != VIEW.RI() || this.upR != t) {
/* 32 */       this.upI = VIEW.RI();
/* 33 */       this.upR = t;
/* 34 */       this.cache = getValue(t);
/*    */     } 
/* 36 */     return this.cache;
/*    */   }
/*    */   
/*    */   public abstract double getValue(T paramT);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\DOUBLE_O$DoubleOCached.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */