/*    */ package settlement.room.main.throne;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.D;
/*    */ import view.tool.PLACABLE;
/*    */ import view.tool.PlacableFixedImp;
/*    */ import view.tool.PlacableMessages;
/*    */ 
/*    */ 
/*    */ class Placer
/*    */   extends PlacableFixedImp
/*    */ {
/* 16 */   private static CharSequence ¤¤name = "Move Throne";
/* 17 */   private static CharSequence ¤¤desc = "Creates a new construction site that will become the new throne room when finished. The throne is the center of your city and subjects that don't have a clear path to it will function poorly.";
/*    */   
/* 19 */   private int px = -1, py = -1;
/*    */   
/*    */   static {
/* 22 */     D.ts(Placer.class);
/*    */   }
/*    */   
/*    */   Placer(THRONE t) {
/* 26 */     super(¤¤name, 4, 1, ¤¤desc, t.icon());
/*    */   }
/*    */ 
/*    */   
/*    */   public void place(int tx, int ty, int rx, int ry) {
/* 31 */     if (rx == 0 && ry == 0 && this.px != tx && this.py != ty) {
/* 32 */       this.px = tx;
/* 33 */       this.py = ty;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CharSequence placable(int tx, int ty, int rx, int ry) {
/* 40 */     if ((SETT.ROOMS()).map.get(tx, ty) instanceof InstanceConstruction) {
/* 41 */       return null;
/*    */     }
/* 43 */     if ((SETT.ROOMS()).map.is(tx, ty)) {
/* 44 */       return PlacableMessages.¤¤ROOM_BLOCK;
/*    */     }
/* 46 */     if (!SETT.TERRAIN().get(tx, ty).clearing().can() && !SETT.TERRAIN().get(tx, ty).roofIs()) {
/* 47 */       return PlacableMessages.¤¤TERRAIN_BLOCK;
/*    */     }
/* 49 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, int rx, int ry, boolean isPlacable, boolean areaIsPlacable) {
/* 55 */     ((SPRITE)(SPRITES.cons()).ICO.arrows.get(rot())).render(r, x, y);
/*    */   }
/*    */ 
/*    */   
/*    */   public int width() {
/* 60 */     return Sprite.width(rot());
/*    */   }
/*    */ 
/*    */   
/*    */   public int height() {
/* 65 */     return Sprite.height(rot());
/*    */   }
/*    */ 
/*    */   
/*    */   public PLACABLE getUndo() {
/* 70 */     return (PLACABLE)(SETT.ROOMS()).DELETE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\throne\Placer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */