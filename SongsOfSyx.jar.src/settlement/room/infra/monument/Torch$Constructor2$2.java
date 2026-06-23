/*    */ package settlement.room.infra.monument;
/*    */ 
/*    */ import init.resources.RESOURCES;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
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
/* 65 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 70 */     super.render(r, s, data, it, degrade, isCandle);
/* 71 */     if ((data & DIR.N.mask()) != 0 && (data & DIR.W.mask()) != 0) {
/* 72 */       int am = (int)((1.0D - (SETT.ROOMS()).map.get(it.tx(), it.ty()).getDegrade(it.tx(), it.ty())) * 8.0D);
/* 73 */       RESOURCES.WOOD().renderLaying(r, it.x() - 32, it.y() - 32, it.ran(), am);
/*    */     } 
/* 75 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\monument\Torch$Constructor2$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */