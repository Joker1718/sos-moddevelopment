/*    */ package settlement.room.health.hospital;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import settlement.room.sprite.RoomSprite;
/*    */ import settlement.room.sprite.RoomSprite1x1;
/*    */ import settlement.room.sprite.RoomSpriteCombo;
/*    */ import snake2d.SPRITE_RENDERER;
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
/*    */ class null
/*    */   extends RoomSpriteCombo
/*    */ {
/*    */   private final RoomSprite top;
/*    */   
/*    */   null(Json $anonymous0, String $anonymous1, Json paramJson1) throws IOException {
/* 55 */     super($anonymous0, $anonymous1);
/*    */     
/* 57 */     this.top = (RoomSprite)new RoomSprite1x1(paramJson1, "TABLE_ONTOP_1X1");
/*    */   }
/*    */   
/*    */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 61 */     if (!(SETT.ROOMS()).fData.candle.is(it.tile())) {
/* 62 */       this.top.render(r, s, (SETT.ROOMS()).fData.spriteData2.get(it.tile()), it, degrade, false);
/*    */     }
/*    */   }
/*    */   
/*    */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 67 */     return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\hospital\Constructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */