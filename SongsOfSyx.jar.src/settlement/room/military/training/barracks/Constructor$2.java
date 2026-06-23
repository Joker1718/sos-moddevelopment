/*    */ package settlement.room.military.training.barracks;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
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
/*    */ class null
/*    */   extends RoomSpriteBoxN
/*    */ {
/*    */   null(Json $anonymous0, String $anonymous1) throws IOException {
/* 52 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 55 */     return (item.sprite(rx, ry) != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 60 */     super.render(r, s, data, it, degrade, false);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 66 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\training\barracks\Constructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */