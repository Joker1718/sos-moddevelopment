/*    */ package settlement.room.food.cannibal;
/*    */ 
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.sprite.RoomSpriteCombo;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
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
/*    */ class null
/*    */   extends RoomSpriteCombo
/*    */ {
/*    */   null(Json $anonymous0, String $anonymous1) throws IOException {
/* 60 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 65 */     super.render(r, s, data, it, degrade, isCandle);
/* 66 */     if (blue.is(it.tile())) {
/* 67 */       (((Race)RACES.all().get(Job.race.get((SETT.ROOMS()).data.get(it.tile())))).appearance()).colors.blood.bind();
/* 68 */       long ran = it.bigRan();
/* 69 */       int a = Job.gore.get((SETT.ROOMS()).data.get(it.tile()));
/* 70 */       int cx = it.x() + 32;
/* 71 */       int cy = it.y() + 32;
/* 72 */       for (int i = 0; i < a; i++) {
/* 73 */         int xx = (int)(cx + (-4L + (ran & 0x7L)) * 4L);
/* 74 */         ran >>= 3L;
/* 75 */         int yy = (int)(cy + (-4L + (ran & 0x7L)) * 4L);
/* 76 */         ran >>= 3L;
/* 77 */         (SETT.THINGS()).sprites.bloodPool.render(r, (int)(ran & 0xFL), xx, yy);
/* 78 */         ran >>= 4L;
/*    */       } 
/* 80 */       COLOR.unbind();
/*    */     } 
/* 82 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\cannibal\Constructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */