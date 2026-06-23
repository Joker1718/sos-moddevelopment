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
/*    */   extends PlacableMulti
/*    */ {
/*    */   null(CharSequence $anonymous0, CharSequence $anonymous1, SPRITE $anonymous2) {
/* 62 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 66 */     Room ff = (SETT.ROOMS()).map.get(tx, ty);
/* 67 */     if (ff != null && ff.constructor() != null && ff.constructor().dia(tx, ty) != null) {
/* 68 */       ff.constructor().dia(tx, ty).setDia(tx, ty, false);
/*    */     }
/* 70 */     if (!(SETT.ROOMS()).map.is(tx, ty) && (SETT.FLOOR()).getter.get(tx, ty) != null)
/* 71 */       (SETT.FLOOR()).square.set(tx, ty, true); 
/* 72 */     if (SETT.TERRAIN().get(tx, ty) instanceof TerrainDiagonal.Diagonalizer) {
/* 73 */       TerrainDiagonal.Diagonalizer t = (TerrainDiagonal.Diagonalizer)SETT.TERRAIN().get(tx, ty);
/* 74 */       t.setDia(tx, ty, false);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 81 */     Room ff = (SETT.ROOMS()).map.get(tx, ty);
/* 82 */     if (ff != null && ff.constructor() != null && ff.constructor().dia(tx, ty) != null) {
/* 83 */       return null;
/*    */     }
/* 85 */     if (!(SETT.ROOMS()).map.is(tx, ty) && (SETT.FLOOR()).getter.get(tx, ty) != null)
/* 86 */       return null; 
/* 87 */     if (SETT.TERRAIN().get(tx, ty) instanceof TerrainDiagonal.Diagonalizer)
/* 88 */       return null; 
/* 89 */     return TerrainDiagonal.¤¤problem;
/*    */   }
/*    */   
/*    */   public PLACABLE getUndo() {
/* 93 */     return (PLACABLE)TerrainDiagonal.this.placer;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TerrainDiagonal$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */