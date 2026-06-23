/*    */ package settlement.thing;
/*    */ 
/*    */ import util.updating.IUpdater;
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
/*    */ class null
/*    */   extends IUpdater
/*    */ {
/*    */   null(int $anonymous0, double $anonymous1) {
/* 69 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void update(int i, double timeSinceLast) {
/* 73 */     if (!ThingsCorpses.this.corpses[i].isRemoved())
/* 74 */       ThingsCorpses.this.corpses[i].update(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\ThingsCorpses$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */