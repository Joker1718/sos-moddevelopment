/*     */ package settlement.misc.placers;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Floor
/*     */   implements Tile
/*     */ {
/*     */   final Floors.Floor f;
/*     */   final double degrade;
/*     */   
/*     */   Floor(Floors.Floor f) {
/* 102 */     this(f, 1.0D);
/*     */   }
/*     */   
/*     */   Floor(Floors.Floor f, double degrade) {
/* 106 */     this.f = f;
/* 107 */     this.degrade = degrade;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean placable(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 112 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 117 */     this.f.placeFixed(tx, ty);
/* 118 */     if (SETT.TERRAIN().get(tx, ty).clearing().isEasilyCleared()) {
/* 119 */       (SETT.TERRAIN()).NADA.placeFixed(tx, ty);
/*     */     }
/*     */   }
/*     */   
/*     */   public SPRITE sprite(TileGrid grid, int rx, int ry, int mask) {
/* 124 */     return (SPRITES.cons()).BIG.dashed.get(0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\placers\Tiles$Floor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */