/*     */ package settlement.room.service.food.canteen;
/*     */ 
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResG;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends RoomSpriteCombo
/*     */ {
/*     */   null(Json $anonymous0, String $anonymous1) throws IOException {
/*  96 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 101 */     if ((SETT.ROOMS()).fData.candle.is(it.tile()))
/*     */       return; 
/* 103 */     CanteenInstance ins = (CanteenInstance)blue.getter.get(it.tile());
/* 104 */     if (ins == null) {
/*     */       return;
/*     */     }
/* 107 */     int ran = it.ran();
/* 108 */     int dist = 21;
/* 109 */     int ri = ran % RESOURCES.EDI().all().size();
/* 110 */     for (int i = 0; i < 9; i++) {
/*     */       
/* 112 */       ResG e = (ResG)RESOURCES.EDI().all().get(ri % RESOURCES.EDI().all().size());
/*     */       
/* 114 */       double a = 7.0D * ins.amount(e) / ins.maxAmount;
/* 115 */       if (a > 0.0D && a >= (ran & 0x7)) {
/* 116 */         DIR dir = (DIR)DIR.ALLC.get(ri % DIR.ALLC.size());
/* 117 */         it.setOff(dir.x() * dist, dir.y() * dist);
/* 118 */         Constructor.this.renderDish(r, s, e.resource, it, ran);
/*     */       } 
/* 120 */       ri++;
/* 121 */       ran >>>= 3;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 127 */     return !(!super.joins(tx, ty, rx, ry, d, item) && item.sprite(rx, ry) != spriteOven);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\canteen\Constructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */