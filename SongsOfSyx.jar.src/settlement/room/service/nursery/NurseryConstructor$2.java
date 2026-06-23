/*    */ package settlement.room.service.nursery;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.room.sprite.RoomSprite;
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
/*    */   null(Json $anonymous0, String $anonymous1) throws IOException {
/* 72 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 76 */     boolean ret = super.render(r, s, data, it, degrade, isCandle);
/*    */     
/* 78 */     sAbove.render(r, s, data, it, degrade, isCandle);
/*    */ 
/*    */     
/* 81 */     return ret;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\nursery\NurseryConstructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */