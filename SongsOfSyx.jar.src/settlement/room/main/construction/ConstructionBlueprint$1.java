/*    */ package settlement.room.main.construction;
/*    */ 
/*    */ import settlement.job.Job;
/*    */ import settlement.main.SETT;
/*    */ import settlement.tilemap.terrain.Terrain;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import view.tool.PLACER_TYPE;
/*    */ import view.tool.PlacableMulti;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends PlacableMulti
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 39 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 43 */     if ((SETT.ROOMS()).map.is(tx, ty)) {
/* 44 */       ConstructionBlueprint.this.construct(tx, ty);
/*    */     } else {
/* 46 */       Job j = (Job)(SETT.JOBS()).getter.get(tx, ty);
/* 47 */       if (j != null) {
/* 48 */         Terrain.TerrainTile tt = j.becomes(tx, ty);
/* 49 */         (SETT.JOBS()).clearer.set(tx, ty);
/* 50 */         tt.placeFixed(tx, ty);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 57 */     return (ConstructionBlueprint.this.is(tx, ty) || (SETT.JOBS()).getter.get(tx, ty) != null) ? null : "";
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 62 */     if (ConstructionBlueprint.this.is(fromX, fromY)) {
/* 63 */       if (ConstructionBlueprint.this.is(toX, toY))
/* 64 */         return true; 
/* 65 */       if ((SETT.JOBS()).getter.get(toX, toY) != null)
/* 66 */         return true; 
/*    */     } 
/* 68 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\construction\ConstructionBlueprint$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */