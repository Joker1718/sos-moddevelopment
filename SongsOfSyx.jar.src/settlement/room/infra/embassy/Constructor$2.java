/*    */ package settlement.room.infra.embassy;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import settlement.room.sprite.RoomSprite;
/*    */ import settlement.room.sprite.RoomSprite1x1;
/*    */ import settlement.room.sprite.RoomSpriteCombo;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.file.Json;
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
/*    */   extends RoomSpriteCombo
/*    */ {
/*    */   final RoomSprite top;
/*    */   
/*    */   null(RoomSprite $anonymous0, Json paramJson) throws IOException {
/* 60 */     super($anonymous0);
/*    */     
/* 62 */     this.top = (RoomSprite)new RoomSprite1x1(paramJson, "TABLE_TOP_1X1")
/*    */       {
/*    */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 65 */           if (d.orthoID() == item.rotation || d.perpendicular().orthoID() == item.rotation) {
/* 66 */             if (d.orthoID() == item.rotation && item.get(rx, ry) == null)
/* 67 */               return true; 
/* 68 */             if (item.get(rx, ry) != null && (item.get(rx, ry)).sprite instanceof RoomSpriteCombo) {
/* 69 */               return true;
/*    */             }
/*    */           } 
/* 72 */           return false;
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 78 */     if ((SETT.ROOMS()).fData.candle.is(it.tile()))
/*    */       return; 
/* 80 */     this.top.render(r, s, getData2(it), it, degrade, false);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 86 */     return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\embassy\Constructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */