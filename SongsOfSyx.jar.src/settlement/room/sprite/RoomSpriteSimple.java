/*    */ package settlement.room.sprite;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ public class RoomSpriteSimple
/*    */   extends RoomSprite.Imp
/*    */ {
/*    */   private final int tileStart;
/*    */   public final int tileEnd;
/*    */   private final TILE_SHEET sheet;
/*    */   private final int variations;
/*    */   
/*    */   public RoomSpriteSimple(TILE_SHEET sheet, int startTile, int variations) {
/* 19 */     this(sheet, startTile, variations, 0, 3);
/*    */   }
/*    */   
/*    */   private RoomSpriteSimple(TILE_SHEET sheet, int startTile, int variations, int shadHeight, int shadLength) {
/* 23 */     this.sheet = sheet;
/* 24 */     this.tileStart = startTile;
/* 25 */     this.variations = variations;
/* 26 */     this.tileEnd = startTile + variations;
/* 27 */     this.shadowHeight = shadHeight;
/* 28 */     this.shadowDist = shadLength;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 34 */     int x = it.x();
/* 35 */     int y = it.y();
/* 36 */     data += getTileOffset(it, data);
/* 37 */     int tile = data + this.tileStart + it.ran() % this.variations;
/* 38 */     this.sheet.render(r, tile, x, y);
/* 39 */     renderDegrade(this.sheet, r, tile, it, degrade);
/*    */     
/* 41 */     if (this.shadowHeight > 0 || this.shadowDist > 0) {
/* 42 */       s.setDistance2Ground(this.shadowHeight).setHeight(this.shadowDist);
/* 43 */       this.sheet.render((SPRITE_RENDERER)s, tile, x, y);
/*    */     } 
/*    */     
/* 46 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 52 */     if (item.get(rx, ry) != null && item.get(rx, ry).isBlocker()) {
/* 53 */       (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/*    */     } else {
/* 55 */       (SPRITES.cons()).BIG.dashedThick.render(r, 0, x, y);
/*    */     } 
/*    */   }
/*    */   protected int getTileOffset(RenderData.RenderIterator it, int data) {
/* 59 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 64 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\sprite\RoomSpriteSimple.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */