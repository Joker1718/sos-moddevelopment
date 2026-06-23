/*     */ package settlement.room.service.food.tavern;
/*     */ 
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResGDrink;
/*     */ import java.io.IOException;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
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
/*     */ class null
/*     */   extends RoomSprite1x1
/*     */ {
/*     */   null(Json $anonymous0, String $anonymous1) throws IOException {
/*  89 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  93 */     return (item.sprite(rx - d.x() * 2, ry - d.y() * 2) == sChair);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  99 */     if (blue.dist.service(it.tx(), it.ty()) == null) {
/*     */       return;
/*     */     }
/* 102 */     DIR dir = rot(data);
/* 103 */     int ran = it.ran();
/*     */ 
/*     */     
/* 106 */     if (blue.dist.isWorked(it.tx(), it.ty())) {
/* 107 */       ResGDrink drink = (ResGDrink)RESOURCES.DRINKS().all().getC(ran);
/*     */       
/* 109 */       int sx = 8 - dir.x() * 5 * 4;
/* 110 */       int sy = 8 - dir.y() * 5 * 4;
/* 111 */       it.setOff(sx, sy);
/* 112 */       Constructor.this.sJug.renderRandom(r, s, it, ran, 0.0D);
/* 113 */       Constructor.this.sFill.renderRandom(r, s, it, ran, degrade, drink.color);
/* 114 */       ran >>= 3;
/*     */     } 
/*     */ 
/*     */     
/* 118 */     int used = blue.dist.usedAmount(it.tx(), it.ty());
/* 119 */     if (!blue.dist.isWorked(it.tx(), it.ty())) {
/* 120 */       used = 4;
/*     */     }
/*     */     
/* 123 */     if (used > 0) {
/* 124 */       int dd = 16;
/* 125 */       DIR d = dir.next(-2);
/* 126 */       if ((ran & 0x1) == 1)
/* 127 */         d = d.perpendicular(); 
/* 128 */       ran >>= 1;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 133 */       used = CLAMP.i(used, 0, 4);
/* 134 */       for (int i = 0; i < used; i++) {
/* 135 */         int sx = -d.x() * 6 * 4 + d.x() * i * dd + -1 + (ran & 0x3);
/* 136 */         ran >>= 2;
/* 137 */         int sy = -d.y() * 6 * 4 + d.y() * i * dd + -1 + (ran & 0x3);
/* 138 */         ran >>= 2;
/* 139 */         it.setOff(sx, sy);
/* 140 */         Constructor.this.sJug.renderRandom(r, s, it, ran, 0.0D);
/* 141 */         ran >>= 3;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\tavern\Constructor$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */