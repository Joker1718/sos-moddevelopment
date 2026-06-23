/*     */ package settlement.room.service.food.eatery;
/*     */ 
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResG;
/*     */ import init.resources.ResGEat;
/*     */ import init.resources.ResGroup;
/*     */ import java.io.IOException;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.sprite.RoomSprite1x1;
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
/*     */ class null
/*     */   extends RoomSprite1x1
/*     */ {
/*     */   RoomSprite1x1 top;
/*     */   
/*     */   null(Json $anonymous0, String $anonymous1, Json paramJson1) throws IOException {
/*  92 */     super($anonymous0, $anonymous1);
/*     */     
/*  94 */     this.top = new RoomSprite1x1(paramJson1, "STALL_TOP_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  97 */           return Constructor.null.this.j(tx, ty, rx, ry, d, item);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 103 */     return j(tx, ty, rx, ry, d, item);
/*     */   }
/*     */   
/*     */   private boolean j(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 107 */     if (item.width() == 1 || item.height() == 1) {
/* 108 */       return (d.id() == item.rotation);
/*     */     }
/* 110 */     if ((((DIR)DIR.ORTHO.get(item.rotation)).x() * d.x() != 0 || ((DIR)DIR.ORTHO.get(item.rotation)).y() * d.y() != 0) && item.sprite(rx, ry) == this) {
/* 111 */       return true;
/*     */     }
/* 113 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 118 */     this.top.render(r, s, getData2(it), it, degrade, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 123 */     return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 128 */     super.render(r, s, data, it, degrade, isCandle);
/* 129 */     EateryInstance ins = (EateryInstance)blue.getter.get(it.tile());
/* 130 */     if (blue.dist.isWorked(it.tx(), it.ty())) {
/* 131 */       long ran = it.bigRan();
/* 132 */       ResGroup<ResGEat> es = RESOURCES.EDI();
/* 133 */       DIR dir = rot(data);
/*     */       
/* 135 */       int dim = 10;
/*     */ 
/*     */       
/* 138 */       int x1 = it.x() + 32 - (32 - dim) * dir.next(2).x();
/* 139 */       int y1 = it.y() + 32 - (32 - dim) * dir.next(2).y();
/* 140 */       x1 -= dim * dir.x();
/* 141 */       y1 -= dim * dir.y();
/* 142 */       int start = (int)ran % 6;
/* 143 */       ran >>= 3L;
/* 144 */       for (int i = 0; i < 6; i++) {
/* 145 */         int pos = i + start;
/* 146 */         pos %= 6;
/* 147 */         int x = x1 + dir.next(2).x() * pos * dim;
/* 148 */         int y = y1 + dir.next(2).y() * pos * dim;
/* 149 */         ResG res = (ResG)es.all().get(((int)ran & 0xF) % es.all().size());
/*     */         
/* 151 */         ran >>= 4L;
/*     */         
/* 153 */         double d = blue.dist.stored(res.resource).get(ins);
/* 154 */         if (d > (ran & 0x7L) / 7.0D)
/* 155 */           res.resource.renderOneC(r, x, y, (int)ran); 
/* 156 */         ran >>= 2L;
/*     */       } 
/*     */     } 
/* 159 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\eatery\Constructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */