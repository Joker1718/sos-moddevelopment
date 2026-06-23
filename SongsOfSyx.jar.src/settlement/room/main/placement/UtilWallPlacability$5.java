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
/*    */   implements MAP_BOOLEAN
/*    */ {
/*    */   public boolean is(int tx, int ty) {
/* 83 */     if (UtilWallPlacability.wallisReal.is(tx, ty))
/* 84 */       return true; 
/* 85 */     if ((SETT.TERRAIN()).CAVE.is(tx, ty)) {
/* 86 */       return (UtilWallPlacability.placable((SETT.JOBS()).clearss.caveFill, tx, ty) == null);
/*    */     }
/* 88 */     return (UtilWallPlacability.placable(((JobBuildStructure)(SETT.JOBS()).build_structure.get(0)).wall, tx, ty) == null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(int tile) {
/* 93 */     return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\UtilWallPlacability$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */