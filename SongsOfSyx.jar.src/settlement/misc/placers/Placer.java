/*    */ package settlement.misc.placers;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import view.tool.PlacableFixedImp;
/*    */ 
/*    */ class Placer
/*    */   extends PlacableFixedImp {
/*    */   private final CharSequence name;
/*    */   private final TileGrid grid;
/*    */   
/*    */   Placer(CharSequence name, TileGrid grid) {
/* 15 */     super(name, 1, 1);
/* 16 */     this.name = name;
/* 17 */     this.grid = grid;
/*    */   }
/*    */ 
/*    */   
/*    */   public SPRITE getIcon() {
/* 22 */     return (SPRITE)(SPRITES.icons()).m.cancel;
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence name() {
/* 27 */     return this.name;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, int rx, int ry, boolean isPlacable, boolean areaIsPlacable) {
/* 33 */     this.grid.get(rx, ry).sprite(this.grid, rx, ry, mask).render(r, x, y);
/*    */   }
/*    */ 
/*    */   
/*    */   public int width() {
/* 38 */     return this.grid.width();
/*    */   }
/*    */ 
/*    */   
/*    */   public int height() {
/* 43 */     return this.grid.height();
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence placable(int tx, int ty, int rx, int ry) {
/* 48 */     return (SETT.IN_BOUNDS(tx, ty) && this.grid.get(rx, ry).placable(tx, ty, this.grid, rx, ry)) ? null : E;
/*    */   }
/*    */ 
/*    */   
/*    */   public void place(int tx, int ty, int rx, int ry) {
/* 53 */     this.grid.get(rx, ry).place(tx, ty, this.grid, rx, ry);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\placers\Placer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */