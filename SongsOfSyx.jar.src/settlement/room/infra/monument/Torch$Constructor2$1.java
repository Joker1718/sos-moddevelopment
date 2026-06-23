/*    */ package settlement.room.infra.monument;
/*    */ 
/*    */ import init.resources.RESOURCES;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.sprite.RoomSprite1x1;
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
/*    */ class null
/*    */   extends RoomSprite1x1
/*    */ {
/*    */   null(Json $anonymous0, String $anonymous1) throws IOException {
/* 54 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 58 */     super.render(r, s, data, it, degrade, isCandle);
/* 59 */     int am = (int)((1.0D - (SETT.ROOMS()).map.get(it.tx(), it.ty()).getDegrade(it.tx(), it.ty())) * 4.0D);
/* 60 */     RESOURCES.WOOD().renderLaying(r, it.x(), it.y(), it.ran(), am);
/* 61 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\monument\Torch$Constructor2$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */