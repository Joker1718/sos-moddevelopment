/*    */ package settlement.room.main.placement;
/*    */ 
/*    */ import settlement.job.JobBuildStructure;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.map.MAP_BOOLEAN;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   implements MAP_BOOLEAN
/*    */ {
/*    */   public boolean is(int tx, int ty) {
/* 37 */     if (UtilWallPlacability.openingIsReal.is(tx, ty))
/* 38 */       return true; 
/* 39 */     if ((SETT.TERRAIN()).MOUNTAIN.is(tx, ty)) {
/* 40 */       return (UtilWallPlacability.placable((SETT.JOBS()).clearss.tunnel, tx, ty) == null);
/*    */     }
/* 42 */     return (UtilWallPlacability.placable(((JobBuildStructure)(SETT.JOBS()).build_structure.get(0)).ceiling, tx, ty) == null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(int tile) {
/* 47 */     return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\UtilWallPlacability$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */