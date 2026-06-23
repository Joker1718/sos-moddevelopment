/*    */ package game.faction;
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
/*    */ class null
/*    */   extends IUpdater
/*    */ {
/*    */   null(int $anonymous0, double $anonymous1) {
/* 40 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void update(int i, double timeSinceLast) {
/* 44 */     if (((Faction)FACTIONS.this.all.get(i)).isActive())
/* 45 */       ((Faction)FACTIONS.this.all.get(i)).update(timeSinceLast); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\FACTIONS$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */