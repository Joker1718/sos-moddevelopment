/*    */ package settlement.entity.humanoid.ai.consume;
/*    */ 
/*    */ import settlement.entity.animal.ANIMAL_ROOM_RUINER;
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.finders.SFinderMisc;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.tilemap.terrain.TGrowable;
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
/*    */   extends SFinderMisc.FinderMiscWithoutDest
/*    */ {
/*    */   null(int $anonymous0) {
/* 46 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected boolean has() {
/* 50 */     return (SETT.WEATHER()).growthRipe.cropsAreRipe();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isTile(int tx, int ty) {
/* 55 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 56 */     if (r != null && r instanceof ANIMAL_ROOM_RUINER) {
/* 57 */       return ((ANIMAL_ROOM_RUINER)r).canBeGraced(tx, ty);
/*    */     }
/* 59 */     return (SETT.TERRAIN().get(tx, ty) instanceof TGrowable && ((TGrowable)SETT.TERRAIN().get(tx, ty)).isEdible(tx, ty) && ((TGrowable)SETT.TERRAIN().get(tx, ty)).size.get(tx, ty) > 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\F_PlanStarve$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */