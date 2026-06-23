/*    */ package settlement.room.service.market;
/*    */ 
/*    */ import init.race.RACES;
/*    */ import init.race.RaceResources;
/*    */ import java.io.IOException;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends RoomSprite1x1
/*    */ {
/*    */   null(Json $anonymous0, String $anonymous1) throws IOException {
/* 59 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 64 */     super.render(r, s, data, it, degrade, isCandle);
/* 65 */     MarketInstance i = (MarketInstance)blue.getter.get(it.tile());
/* 66 */     if (i != null) {
/* 67 */       int ran = it.ran();
/* 68 */       for (int ri = 1; ri <= 2; ri++) {
/* 69 */         RaceResources.RaceResource res = (RaceResources.RaceResource)(RACES.res()).ALL.get((ran & 0xFF) % (RACES.res()).ALL.size());
/* 70 */         ran >>= 4;
/* 71 */         double d = blue.dist.stored(res.res).get(i);
/* 72 */         d /= (i.distData.maxAmount * ri);
/* 73 */         d *= 16.0D;
/* 74 */         ran >>= 4;
/* 75 */         res.res.renderLaying(r, it.x(), it.y(), ran, d);
/*    */       } 
/*    */     } 
/*    */     
/* 79 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\market\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */