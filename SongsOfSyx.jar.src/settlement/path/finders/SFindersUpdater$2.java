/*    */ package settlement.path.finders;
/*    */ 
/*    */ import game.time.TIME;
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
/*    */ class null
/*    */   extends IUpdater
/*    */ {
/*    */   null(int $anonymous0, double $anonymous1) {
/* 23 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void update(int i, double timeSinceLast) {
/* 27 */     boolean d = ((TIME.days().bitsSinceStart() & 0x1) == 1);
/* 28 */     for (SFinderFindable a : SFinderFindable.all)
/* 29 */       a.map.update(i, d); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFindersUpdater$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */