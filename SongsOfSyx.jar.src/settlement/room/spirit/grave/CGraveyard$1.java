/*    */ package settlement.room.spirit.grave;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.room.sprite.RoomSprite;
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
/*    */ class null
/*    */   extends RoomSprite1xN
/*    */ {
/*    */   final RoomSprite made;
/*    */   
/*    */   null(Json $anonymous0, String $anonymous1, boolean $anonymous2, Json paramJson1) throws IOException {
/* 60 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */     
/* 62 */     this.made = (RoomSprite)new RoomSprite1xN(paramJson1, "GRAVE_B_TOP_1X1", true);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 67 */     if (blue.is(it.tile()) && 
/* 68 */       Grave.isUsed(it.tx() + rot(data).x(), it.ty() + rot(data).y())) {
/* 69 */       return this.made.render(r, s, data, it, degrade, isCandle);
/*    */     }
/*    */     
/* 72 */     return super.render(r, s, data, it, degrade, isCandle);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\grave\CGraveyard$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */