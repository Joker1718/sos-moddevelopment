/*    */ package settlement.room.service.food.tavern;
/*    */ 
/*    */ import init.resources.RESOURCES;
/*    */ import init.resources.ResGDrink;
/*    */ import init.resources.ResGroup;
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
/* 56 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 60 */     if ((SETT.ROOMS()).fData.candle.is(it.tile()))
/*    */       return; 
/* 62 */     TavernInstance i = (TavernInstance)blue.getter.get(it.tile());
/* 63 */     if (i != null) {
/* 64 */       int ran = it.ran();
/* 65 */       ResGroup<ResGDrink> es = RESOURCES.DRINKS();
/* 66 */       for (int ri = 1; ri <= 2; ri++) {
/* 67 */         ResGDrink res = (ResGDrink)es.all().get((ran & 0xF) % es.all().size());
/* 68 */         ran >>= 4;
/* 69 */         double d = blue.dist.stored(res.resource).get(i);
/* 70 */         d /= (i.distData.maxAmount * ri);
/* 71 */         d *= 16.0D;
/* 72 */         ran >>= 4;
/* 73 */         res.resource.renderLaying(r, it.x(), it.y(), ran, d);
/*    */       } 
/*    */     } 
/* 76 */     super.renderAbove(r, s, data, it, degrade);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\tavern\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */