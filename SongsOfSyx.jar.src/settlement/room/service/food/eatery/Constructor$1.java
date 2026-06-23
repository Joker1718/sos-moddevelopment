/*    */ package settlement.room.service.food.eatery;
/*    */ 
/*    */ import init.resources.RESOURCES;
/*    */ import init.resources.ResG;
/*    */ import init.resources.ResGEat;
/*    */ import init.resources.ResGroup;
/*    */ import java.io.IOException;
/*    */ import settlement.room.sprite.RoomSprite;
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
/*    */ class null
/*    */   extends RoomSprite1x1
/*    */ {
/*    */   RoomSprite top;
/*    */   
/*    */   null(Json $anonymous0, String $anonymous1, Json paramJson1) throws IOException {
/* 60 */     super($anonymous0, $anonymous1);
/*    */ 
/*    */     
/* 63 */     this.top = (RoomSprite)new RoomSprite1x1(paramJson1, "CRATE_TOP_1X1");
/*    */   }
/*    */   
/*    */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 67 */     this.top.render(r, s, data, it, degrade, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 72 */     super.render(r, s, data, it, degrade, isCandle);
/* 73 */     EateryInstance i = (EateryInstance)blue.getter.get(it.tile());
/* 74 */     if (i != null) {
/* 75 */       int ran = it.ran();
/* 76 */       ResGroup<ResGEat> es = RESOURCES.EDI();
/* 77 */       for (int ri = 1; ri <= 2; ri++) {
/* 78 */         ResG res = (ResG)es.all().get((ran & 0xF) % es.all().size());
/* 79 */         ran >>= 4;
/* 80 */         double d = blue.dist.stored(res.resource).get(i);
/* 81 */         d /= (i.distData.maxAmount * ri);
/* 82 */         d *= 16.0D;
/* 83 */         ran >>= 4;
/* 84 */         res.resource.renderLaying(r, it.x(), it.y(), ran, d);
/*    */       } 
/*    */     } 
/*    */     
/* 88 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\eatery\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */