/*    */ package settlement.tilemap.terrain;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.Room;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import view.tool.PLACABLE;
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
/*    */ class null
/*    */   extends PlacableMulti
/*    */ {
/*    */   null(CharSequence $anonymous0, CharSequence $anonymous1, SPRITE $anonymous2) {
/* 26 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 30 */     Room ff = (SETT.ROOMS()).map.get(tx, ty);
/* 31 */     if (ff != null && ff.constructor() != null && ff.constructor().dia(tx, ty) != null) {
/* 32 */       ff.constructor().dia(tx, ty).setDia(tx, ty, true);
/*    */     }
/* 34 */     if (!(SETT.ROOMS()).map.is(tx, ty) && (SETT.FLOOR()).getter.get(tx, ty) != null)
/* 35 */       (SETT.FLOOR()).square.set(tx, ty, false); 
/* 36 */     if (SETT.TERRAIN().get(tx, ty) instanceof TerrainDiagonal.Diagonalizer) {
/* 37 */       TerrainDiagonal.Diagonalizer t = (TerrainDiagonal.Diagonalizer)SETT.TERRAIN().get(tx, ty);
/* 38 */       t.setDia(tx, ty, true);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 44 */     Room ff = (SETT.ROOMS()).map.get(tx, ty);
/* 45 */     if (ff != null && ff.constructor() != null && ff.constructor().dia(tx, ty) != null) {
/* 46 */       return null;
/*    */     }
/* 48 */     if (!(SETT.ROOMS()).map.is(tx, ty) && (SETT.FLOOR()).getter.get(tx, ty) != null)
/* 49 */       return null; 
/* 50 */     if (SETT.TERRAIN().get(tx, ty) instanceof TerrainDiagonal.Diagonalizer)
/* 51 */       return null; 
/* 52 */     return TerrainDiagonal.¤¤problem;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public PLACABLE getUndo() {
/* 58 */     return (PLACABLE)TerrainDiagonal.this.undo;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TerrainDiagonal$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */