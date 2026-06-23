/*    */ package settlement.room.spirit.grave;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import settlement.room.sprite.RoomSprite1xN;
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
/*    */   extends RoomSprite1xN
/*    */ {
/*    */   final RoomSprite1xN lid;
/*    */   
/*    */   null(Json $anonymous0, String $anonymous1, boolean $anonymous2, Json paramJson1) throws IOException {
/* 61 */     super($anonymous0, $anonymous1, $anonymous2);
/* 62 */     this.lid = new RoomSprite1xN(paramJson1, "HEAD_TOP_1X1", false);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 68 */     super.render(r, s, data, it, degrade, isCandle);
/* 69 */     if (blue.is(it.tile())) {
/* 70 */       int x = it.tx() + offX(data);
/* 71 */       int y = it.ty() + offY(data);
/* 72 */       if (Grave.isUsed(x, y)) {
/* 73 */         this.lid.render(r, s, getData2(it), it, degrade, isCandle);
/*    */       }
/*    */     } 
/* 76 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 81 */     return this.lid.getData(tx, ty, rx, ry, item, itemRan);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\grave\CTomb$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */