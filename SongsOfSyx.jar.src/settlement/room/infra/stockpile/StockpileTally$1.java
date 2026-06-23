/*    */ package settlement.room.infra.stockpile;
/*    */ 
/*    */ import game.time.TIMECYCLE;
/*    */ import settlement.room.infra.logistics.MoveDic;
/*    */ import util.info.INFO;
/*    */ import util.statistics.HistoryResource;
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
/*    */ class null
/*    */   extends HistoryResource
/*    */ {
/*    */   private final INFO info;
/*    */   
/*    */   null(int $anonymous0, TIMECYCLE $anonymous1, boolean $anonymous2) {
/* 28 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */     
/* 30 */     this.info = new INFO(
/* 31 */         MoveDic.¤¤Stored, MoveDic.¤¤Stored);
/*    */   }
/*    */   
/*    */   public INFO info() {
/* 35 */     return this.info;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\stockpile\StockpileTally$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */