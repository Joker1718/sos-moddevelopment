/*     */ package settlement.misc.placers;
/*     */ 
/*     */ import init.sprite.SPRITES;
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
/*     */ class Conpound
/*     */   implements Tile
/*     */ {
/*     */   final Tile[] tiles;
/*     */   
/*     */   Conpound(Tile... tiles) {
/* 162 */     this.tiles = tiles;
/*     */   } public boolean placable(int tx, int ty, TileGrid grid, int rx, int ry) {
/*     */     byte b;
/*     */     int i;
/*     */     Tile[] arrayOfTile;
/* 167 */     for (i = (arrayOfTile = this.tiles).length, b = 0; b < i; ) { Tile t = arrayOfTile[b];
/* 168 */       if (!t.placable(tx, ty, grid, rx, ry))
/* 169 */         return false;  b++; }
/* 170 */      return true;
/*     */   } public void place(int tx, int ty, TileGrid grid, int rx, int ry) {
/*     */     byte b;
/*     */     int i;
/*     */     Tile[] arrayOfTile;
/* 175 */     for (i = (arrayOfTile = this.tiles).length, b = 0; b < i; ) { Tile t = arrayOfTile[b];
/* 176 */       t.place(tx, ty, grid, rx, ry);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   public SPRITE sprite(TileGrid grid, int rx, int ry, int mask) {
/* 181 */     return (SPRITES.cons()).ICO.clear;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\placers\Tiles$Conpound.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */