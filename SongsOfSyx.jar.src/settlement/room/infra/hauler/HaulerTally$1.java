/*    */ package settlement.room.infra.hauler;
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
/*    */ class null
/*    */   extends HistoryResource
/*    */ {
/*    */   private final INFO info;
/*    */   
/*    */   null(int $anonymous0, TIMECYCLE $anonymous1, boolean $anonymous2) {
/* 24 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */     
/* 26 */     this.info = new INFO(
/* 27 */         MoveDic.¤¤Stored, MoveDic.¤¤StoredD);
/*    */   }
/*    */   
/*    */   public INFO info() {
/* 31 */     return this.info;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\hauler\HaulerTally$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */