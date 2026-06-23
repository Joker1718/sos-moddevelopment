/*     */ package settlement.misc.placers;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
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
/*     */ class Resource
/*     */   implements Tile
/*     */ {
/*     */   final RESOURCE r;
/*     */   final int amount;
/*     */   
/*     */   Resource(RESOURCE r, int amount) {
/* 135 */     this.r = r;
/* 136 */     this.amount = amount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean placable(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 142 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 147 */     (SETT.THINGS()).resources.createPrecise(tx, ty, this.r, this.amount);
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE sprite(TileGrid grid, int rx, int ry, int mask) {
/* 152 */     return (SPRITES.cons()).ICO.clear;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\placers\Tiles$Resource.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */