/*    */ package settlement.room.infra.elderly;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 76 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 81 */     super.render(r, s, data, it, degrade, isCandle);
/* 82 */     if (blue.job.used(it.tx(), it.ty())) {
/* 83 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 84 */         if ((SETT.ROOMS()).fData.sprite.get(it.tx(), it.ty(), (DIR)DIR.ORTHO.get(i)) == sChair_table) {
/* 85 */           sOnTopCards.render(r, s, i, it, degrade, isCandle);
/*    */         }
/*    */       } 
/*    */     }
/*    */     
/* 90 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\elderly\ResthomeConstructor$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */