/*    */ package settlement.stats.law;
/*    */ 
/*    */ import game.boosting.BOOSTABLES;
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import init.type.HCLASS_RACE;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import util.keymap.MAPPED;
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
/*    */ class null
/*    */   extends IUpdater
/*    */ {
/*    */   null(int $anonymous0, double $anonymous1) {
/* 71 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void update(int cli, double ds) {
/* 75 */     if (cli == 0) {
/* 76 */       CrimesData.this.escapedPrisoners -= 0.5D + (STATS.POP()).POP.data().get(null) * 0.01D;
/* 77 */       CrimesData.this.escapedPrisoners = CLAMP.d(CrimesData.this.escapedPrisoners, 0.0D, (STATS.POP()).POP.data().get(null));
/*    */     } 
/*    */     
/* 80 */     CrimesData.this.lawHistory.set((MAPPED)HCLASS_RACE.ALL().get(cli), (int)(10000.0D * (BOOSTABLES.CIVICS()).LAW.get((BOOSTABLE_O)HCLASS_RACE.ALL().get(cli))));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\law\CrimesData$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */