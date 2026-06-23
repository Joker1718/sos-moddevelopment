/*    */ package util.statistics;
/*    */ 
/*    */ import game.time.TIMECYCLE;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class H
/*    */   extends HistoryInt
/*    */ {
/*    */   final T r;
/*    */   
/*    */   public H(T r, int size, TIMECYCLE c, boolean keep) {
/* 91 */     super(size, c, keep);
/* 92 */     this.r = r;
/*    */   }
/*    */   
/*    */   protected void change(int old, int current) {
/* 96 */     HistoryObject.this.total.inc(-old);
/* 97 */     HistoryObject.this.total.inc(current);
/* 98 */     HistoryObject.this.change(this.r, old, current);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\statistics\HistoryObject$H.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */