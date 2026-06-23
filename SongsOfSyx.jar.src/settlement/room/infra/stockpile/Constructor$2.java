/*    */ package settlement.room.infra.stockpile;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import init.resources.RESOURCES;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.job.StorageCrate;
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
/*    */ class null
/*    */   extends RoomSprite1x1
/*    */ {
/*    */   final RoomSprite top;
/*    */   final RoomSprite topf;
/*    */   
/*    */   null(Json $anonymous0, String $anonymous1, Json paramJson1) throws IOException {
/* 60 */     super($anonymous0, $anonymous1);
/*    */     
/* 62 */     this.top = (RoomSprite)new RoomSprite1x1(paramJson1, "CRATE_TOP_1X1");
/* 63 */     this.topf = (RoomSprite)new RoomSprite1x1(paramJson1, "CRATE_TOP_FOOD_1X1");
/*    */   }
/*    */   
/*    */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 67 */     RoomSprite top = this.top;
/* 68 */     if ((SETT.ROOMS()).STOCKPILE.is(it.tile())) {
/* 69 */       StockpileInstance ins = (StockpileInstance)blue.getter.get(it.tx(), it.ty());
/* 70 */       StorageCrate cr = blue.crate.get(it.tx(), it.ty(), ins, ins.sdata);
/* 71 */       RESOURCE res = cr.resource();
/* 72 */       if (res != null && RESOURCES.EDI().is(res)) {
/* 73 */         top = this.topf;
/*    */       }
/*    */     } 
/* 76 */     top.render(r, s, data, it, degrade, this.rotates);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 81 */     super.render(r, s, data, it, degrade, false);
/* 82 */     if ((SETT.ROOMS()).STOCKPILE.is(it.tile())) {
/* 83 */       StockpileInstance ins = (StockpileInstance)blue.getter.get(it.tx(), it.ty());
/* 84 */       StorageCrate cr = blue.crate.get(it.tx(), it.ty(), ins, ins.sdata);
/* 85 */       RESOURCE res = cr.resource();
/* 86 */       if (res != null) {
/* 87 */         double a = cr.amount();
/* 88 */         res.renderLayingRel(r, it.x(), it.y(), it.ran(), a / blue.upgrades().boost(((StockpileInstance)(SETT.ROOMS()).STOCKPILE.getter.get(it.tx(), it.ty())).upgrade()));
/*    */       } 
/*    */     } 
/* 91 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\stockpile\Constructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */