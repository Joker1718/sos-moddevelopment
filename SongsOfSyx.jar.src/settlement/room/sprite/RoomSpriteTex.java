/*    */ package settlement.room.sprite;
/*    */ 
/*    */ import init.sprite.game.SheetPair;
/*    */ import init.sprite.game.SheetType;
/*    */ import java.io.IOException;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.file.Json;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ 
/*    */ public class RoomSpriteTex
/*    */   extends RoomSpriteImp
/*    */ {
/*    */   public RoomSpriteTex(Json sp, String key) throws IOException {
/* 19 */     super((SheetType)SheetType.sTex, sp, key);
/*    */   }
/*    */   
/*    */   public RoomSpriteTex(RoomSprite other) throws IOException {
/* 23 */     super(other);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 30 */     int ran = it.ran();
/* 31 */     SheetPair sheet = sheetPair(it, ran);
/* 32 */     if (sheet == null)
/* 33 */       return false; 
/* 34 */     sheet.d.color(ran).bind();
/* 35 */     ran >>= 4;
/*    */     
/* 37 */     int tile = type().tile(sheet.s, sheet.d, 0, frame(sheet, it), 0);
/*    */     
/* 39 */     sheet.s.render(sheet.d, it.x(), it.y(), it, r, tile, ran, degrade);
/* 40 */     COLOR.unbind();
/* 41 */     if (s != null)
/* 42 */       sheet.s.renderShadow(sheet.d, it.x(), it.y(), it, s, tile, ran); 
/* 43 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 50 */     SheetType.sTex.renderOverlay(
/* 51 */         x, y, r, (item.get(rx, ry)).availability, 
/* 52 */         0, this.rotates ? data : -1, (item.width() == 1 && item.height() == 1));
/*    */   }
/*    */ 
/*    */   
/*    */   public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 57 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 62 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public SheetType type() {
/* 67 */     return (SheetType)SheetType.sTex;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\sprite\RoomSpriteTex.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */