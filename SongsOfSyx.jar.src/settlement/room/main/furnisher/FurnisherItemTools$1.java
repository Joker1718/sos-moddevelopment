/*    */ package settlement.room.main.furnisher;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.sprite.RoomSprite;
/*    */ import settlement.tilemap.floor.Floors;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
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
/*    */   extends RoomSprite.Imp
/*    */ {
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 33 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 38 */     SETT.FLOOR().renderOntop(it, floor, getRes(it.tx(), it.ty()));
/* 39 */     super.renderBelow(r, s, data, it, degrade);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 45 */     int res = getRes(tx, ty);
/* 46 */     (SPRITES.cons()).BIG.dashedThick.render(r, res, x, y);
/*    */   }
/*    */   
/*    */   private int getRes(int tx, int ty) {
/* 50 */     int res = 0;
/*    */     
/* 52 */     if ((SETT.ROOMS()).placement.factory.is(tx, ty)) {
/* 53 */       for (int di = 0; di < 4; di++) {
/* 54 */         DIR d = (DIR)DIR.ORTHO.get(di);
/* 55 */         int dx = tx + d.x();
/* 56 */         int dy = ty + d.y();
/* 57 */         if ((SETT.ROOMS()).placement.factory.is(dx, dy) && is(dx, dy)) {
/* 58 */           res |= d.mask();
/*    */         }
/*    */       } 
/*    */     } else {
/* 62 */       Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 63 */       if (r == null)
/* 64 */         return 0; 
/* 65 */       for (int di = 0; di < 4; di++) {
/* 66 */         DIR d = (DIR)DIR.ORTHO.get(di);
/* 67 */         int dx = tx + d.x();
/* 68 */         int dy = ty + d.y();
/* 69 */         if (r.isSame(tx, ty, dx, dy) && is(dx, dy)) {
/* 70 */           res |= d.mask();
/*    */         }
/*    */       } 
/*    */     } 
/* 74 */     return res;
/*    */   }
/*    */   
/*    */   private boolean is(int dx, int dy) {
/* 78 */     FurnisherItemTile t = (FurnisherItemTile)f.tiles.get((SETT.ROOMS()).fData.tIndex.get(dx, dy));
/* 79 */     return (t != null && t.sprite() == this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 86 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\furnisher\FurnisherItemTools$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */