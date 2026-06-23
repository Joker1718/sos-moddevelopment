/*    */ package settlement.room.service.arena.grand;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import settlement.room.sprite.RoomSprite;
/*    */ import settlement.room.sprite.RoomSprite1x1;
/*    */ import settlement.room.sprite.RoomSpriteBoxN;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends RoomSprite1x1
/*    */ {
/*    */   final RoomSprite ss;
/*    */   
/*    */   null(Json $anonymous0, String $anonymous1, RoomSprite paramRoomSprite) throws IOException {
/* 65 */     super($anonymous0, $anonymous1);
/*    */     
/* 67 */     this.ss = (RoomSprite)new RoomSpriteBoxN(paramRoomSprite)
/*    */       {
/*    */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*    */         {
/* 71 */           return true;
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 77 */     return (CUtil.this.getLevel(tx, ty) == -1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 83 */     return this.ss.render(r, s, getData2(it), it, degrade, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 88 */     super.render(r, s, data, it, degrade, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 93 */     return this.ss.getData(tx, ty, rx, ry, item, itemRan);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\arena\grand\CUtil$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */