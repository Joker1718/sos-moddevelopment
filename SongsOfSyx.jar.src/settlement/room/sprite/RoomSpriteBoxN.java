/*    */ package settlement.room.sprite;
/*    */ 
/*    */ import init.sprite.game.SheetPair;
/*    */ import init.sprite.game.SheetType;
/*    */ import java.io.IOException;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import settlement.room.main.furnisher.FurnisherItemTile;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.rnd.RND;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ public class RoomSpriteBoxN
/*    */   extends RoomSpriteImp
/*    */ {
/*    */   public RoomSpriteBoxN(Json json, String key) throws IOException {
/* 20 */     super((SheetType)SheetType.sBox, json, key);
/*    */   }
/*    */   
/*    */   public RoomSpriteBoxN(RoomSprite other) throws IOException {
/* 24 */     super(other);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 31 */     int k = data >> 5 & 0x7;
/* 32 */     int rot = data >> 4 & 0x1;
/* 33 */     SheetPair sheet = sheetPair(it, k);
/* 34 */     if (sheet == null)
/* 35 */       return false; 
/* 36 */     sheet.d.color(k).bind();
/* 37 */     int ran = it.ran();
/*    */     
/* 39 */     int tile = type().tile(sheet.s, sheet.d, data & 0xF, frame(sheet, it), rot);
/*    */     
/* 41 */     sheet.s.render(sheet.d, it.x(), it.y(), it, r, tile, ran, degrade);
/* 42 */     COLOR.unbind();
/* 43 */     if (s != null)
/* 44 */       sheet.s.renderShadow(sheet.d, it.x(), it.y(), it, s, tile, ran); 
/* 45 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 53 */     type().renderOverlay(x, y, r, (item.get(rx, ry)).availability, 
/* 54 */         data & 0xF, 0, false);
/*    */   }
/*    */   
/*    */   public int rotMask(int data) {
/* 58 */     return data & 0xF;
/*    */   }
/*    */ 
/*    */   
/*    */   public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 63 */     int m = 0;
/* 64 */     int ri = RND.rInt(DIR.ORTHO.size());
/* 65 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 66 */       int rr = (ri + i) % DIR.ORTHO.size();
/* 67 */       DIR d = (DIR)DIR.ORTHO.get(rr);
/* 68 */       if (joins(tx + d.x(), ty + d.y(), rx + d.x(), ry + d.y(), d, item))
/* 69 */         m |= d.mask(); 
/*    */     } 
/* 71 */     m |= 16 * (item.rotation & 0x1);
/* 72 */     return (byte)(m | itemRan << 5);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 77 */     FurnisherItemTile t = item.get(rx, ry);
/* 78 */     return (t != null && t.sprite != null && t.sprite instanceof RoomSpriteBoxN);
/*    */   }
/*    */ 
/*    */   
/*    */   public SheetType type() {
/* 83 */     return (SheetType)SheetType.sBox;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\sprite\RoomSpriteBoxN.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */