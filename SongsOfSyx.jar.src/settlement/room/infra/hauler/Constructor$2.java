/*    */ package settlement.room.infra.hauler;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import init.sprite.UI.Icon;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.sprite.RoomSprite;
/*    */ import settlement.room.sprite.RoomSprite1x1;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.OPACITY;
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
/*    */ class null
/*    */   extends RoomSprite1x1
/*    */ {
/*    */   null(RoomSprite $anonymous0) throws IOException {
/* 50 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 54 */     super.render(r, s, data, it, degrade, isCandle);
/*    */     
/* 56 */     HaulerInstance ins = (HaulerInstance)(SETT.ROOMS()).HAULER.getter.get(it.tile());
/* 57 */     if (ins == null) {
/* 58 */       return false;
/*    */     }
/* 60 */     Icon icon = (ins.resource() == null) ? (SPRITES.icons()).m.cancel : ins.resource().icon();
/* 61 */     OPACITY.O99.bind();
/* 62 */     icon.render(r, it.x(), it.x() + 64, it.y(), it.y() + 64);
/* 63 */     OPACITY.unbind();
/*    */     
/* 65 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\hauler\Constructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */