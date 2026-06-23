/*    */ package settlement.entity.animal.spawning;
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
/*    */ class null
/*    */   extends IUpdater
/*    */ {
/*    */   null(int $anonymous0, double $anonymous1) {
/* 22 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   protected void update(int i, double timeSinceLast) {
/* 25 */     AnimalSpawnSpot sp = (AnimalSpawnSpot)AnimalSpawning.this.spots.get(i);
/* 26 */     if (sp.active())
/* 27 */       AnimalSpawning.this.max -= sp.max(); 
/* 28 */     sp.update(0.01D);
/* 29 */     if (sp.active())
/* 30 */       AnimalSpawning.this.max += sp.max(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\spawning\AnimalSpawning$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */