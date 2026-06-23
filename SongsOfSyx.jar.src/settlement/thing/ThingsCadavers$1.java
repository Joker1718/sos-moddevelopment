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
/*    */ class null
/*    */   extends IUpdater
/*    */ {
/*    */   null(int $anonymous0, double $anonymous1) {
/* 40 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void update(int i, double timeSinceLast) {
/* 45 */     if (!ThingsCadavers.this.cadavers[i].isRemoved())
/* 46 */       ThingsCadavers.this.cadavers[i].update((float)timeSinceLast); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\ThingsCadavers$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */