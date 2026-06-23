/*    */ package settlement.job;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.tilemap.floor.Floors;
/*    */ import settlement.tilemap.terrain.TBuilding;
/*    */ import settlement.tilemap.terrain.TFence;
/*    */ import settlement.tilemap.terrain.TFortification;
/*    */ import settlement.tilemap.terrain.Terrain;
/*    */ import snake2d.util.map.MAP_OBJECT;
/*    */ 
/*    */ final class JobGetter
/*    */   implements MAP_OBJECT<Job>
/*    */ {
/*    */   public Job get(int tile) {
/* 15 */     return get(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*    */   }
/*    */ 
/*    */   
/*    */   public Job get(int tx, int ty) {
/* 20 */     if (!SETT.IN_BOUNDS(tx, ty)) {
/* 21 */       return null;
/*    */     }
/* 23 */     Job j = (Job)(SETT.JOBS()).getter.get(tx, ty);
/* 24 */     if (j != null) {
/* 25 */       return j;
/*    */     }
/* 27 */     Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/* 28 */     if (t instanceof TFortification.Tile) {
/* 29 */       return (Job)(SETT.JOBS()).build_fort.all.get(((TFortification.Tile)t).fort.index());
/*    */     }
/* 31 */     if (t instanceof TBuilding.BuildingComponent) {
/* 32 */       JobBuildStructure tt = (JobBuildStructure)(SETT.JOBS()).build_structure.get((((TBuilding.BuildingComponent)t).building()).structure.index());
/* 33 */       if (t instanceof TBuilding.Ceiling || t instanceof TBuilding.Ceiling.Opening)
/* 34 */         return tt.ceiling; 
/* 35 */       return tt.wall;
/*    */     } 
/* 37 */     if (t instanceof TFence.TFenceTile) {
/* 38 */       return (Job)(SETT.JOBS()).fences.get(((TFence.TFenceTile)t).fence.index());
/*    */     }
/* 40 */     if (t instanceof TFortification.Stairs) {
/* 41 */       return (SETT.JOBS()).build_fort.build_stairs;
/*    */     }
/*    */     
/* 44 */     if (t == (SETT.TERRAIN()).MOUNTAIN) {
/* 45 */       return (SETT.JOBS()).clearss.caveFill;
/*    */     }
/*    */ 
/*    */     
/* 49 */     Floors.Floor f = (Floors.Floor)(SETT.FLOOR()).getter.get(tx, ty);
/* 50 */     if (f != null && f.isRoad) {
/* 51 */       return (Job)(SETT.JOBS()).roads.all.get(f.indexRoad());
/*    */     }
/* 53 */     if (t == (SETT.TERRAIN()).CAVE) {
/* 54 */       return (SETT.JOBS()).clearss.tunnel;
/*    */     }
/* 56 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobGetter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */