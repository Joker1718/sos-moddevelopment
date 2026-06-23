/*    */ package settlement.room.service.food.canteen;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
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
/*    */ class null
/*    */   extends RoomSpriteCombo
/*    */ {
/*    */   final RoomSprite1x1 beneath;
/*    */   final RoomSprite1x1 beneath_used;
/*    */   final RoomSprite1x1 oven;
/*    */   
/*    */   null(Json $anonymous0, String $anonymous1, Json paramJson1) throws IOException {
/* 52 */     super($anonymous0, $anonymous1);
/*    */     
/* 54 */     this.beneath = new RoomSprite1x1(paramJson1, "OVEN_BENEATH_1X1");
/* 55 */     this.beneath_used = new RoomSprite1x1(paramJson1, "OVEN_BENEATH_USED_1X1");
/* 56 */     this.oven = new RoomSprite1x1(paramJson1, "OVEN_1X1")
/*    */       {
/*    */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 59 */           return (item.get(rx, ry) == null);
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 66 */     super.render(r, s, data, it, degrade, isCandle);
/* 67 */     this.beneath.render(r, s, getData2(it), it, degrade, isCandle);
/* 68 */     CanteenInstance i = (CanteenInstance)blue.getter.get(it.tile());
/* 69 */     if (i == null)
/* 70 */       return false; 
/* 71 */     SWork o = blue.job.get(it.tx(), it.ty());
/* 72 */     if (o == null)
/* 73 */       return false; 
/* 74 */     if (o.hasCoal()) {
/* 75 */       this.beneath_used.render(r, s, getData2(it), it, degrade, isCandle);
/*    */     }
/* 77 */     if (o.res() != null) {
/* 78 */       (o.res()).resource.renderOne(r, it.x(), it.y(), it.ran());
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 85 */     this.oven.render(r, s, getData2(it), it, degrade, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 90 */     return this.oven.getData(tx, ty, rx, ry, item, itemRan);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\canteen\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */