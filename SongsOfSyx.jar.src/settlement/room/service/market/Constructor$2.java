/*     */ package settlement.room.service.market;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import java.io.IOException;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.sprite.RoomSprite1x1;
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
/*     */ class null
/*     */   extends RoomSpriteCombo
/*     */ {
/*     */   RoomSprite1x1 top;
/*     */   
/*     */   null(Json $anonymous0, String $anonymous1, Json paramJson1) throws IOException {
/*  83 */     super($anonymous0, $anonymous1);
/*     */     
/*  85 */     this.top = new RoomSprite1x1(paramJson1, "STALL_TOP_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  88 */           return Constructor.null.this.j(tx, ty, rx, ry, d, item);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  94 */     return (item.sprite(rx, ry) == this);
/*     */   }
/*     */   
/*     */   private boolean j(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  98 */     if (item.width() == 1 || item.height() == 1) {
/*  99 */       return (d.id() == item.rotation);
/*     */     }
/* 101 */     if ((((DIR)DIR.ORTHO.get(item.rotation)).x() * d.x() != 0 || ((DIR)DIR.ORTHO.get(item.rotation)).y() * d.y() != 0) && item.sprite(rx, ry) == this) {
/* 102 */       return true;
/*     */     }
/* 104 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 109 */     this.top.render(r, s, getData2(it), it, degrade, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 114 */     return this.top.getData(tx, ty, rx, ry, item, itemRan);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 119 */     super.render(r, s, data, it, degrade, isCandle);
/* 120 */     MarketInstance ins = (MarketInstance)blue.getter.get(it.tile());
/* 121 */     if (blue.dist.isWorked(it.tx(), it.ty())) {
/* 122 */       long ran = it.bigRan();
/* 123 */       DIR dir = this.top.rot(data);
/*     */       
/* 125 */       int dim = 10;
/*     */ 
/*     */       
/* 128 */       int x1 = it.x() + 32 - (32 - dim) * dir.next(2).x();
/* 129 */       int y1 = it.y() + 32 - (32 - dim) * dir.next(2).y();
/* 130 */       x1 -= dim * dir.x();
/* 131 */       y1 -= dim * dir.y();
/* 132 */       int start = (int)ran % 6;
/* 133 */       ran >>= 3L;
/* 134 */       for (int i = 0; i < 6; i++) {
/* 135 */         int pos = i + start;
/* 136 */         pos %= 6;
/* 137 */         int x = x1 + dir.next(2).x() * pos * dim;
/* 138 */         int y = y1 + dir.next(2).y() * pos * dim;
/* 139 */         RESOURCE res = (RESOURCE)blue.dist.all.get(((int)ran & 0xF) % blue.dist.all.size());
/*     */         
/* 141 */         ran >>= 4L;
/*     */         
/* 143 */         double d = blue.dist.stored(res).get(ins);
/* 144 */         if (d > (ran & 0x7L) / 7.0D)
/* 145 */           res.renderOneC(r, x, y, (int)ran); 
/* 146 */         ran >>= 2L;
/*     */       } 
/*     */     } 
/* 149 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\market\Constructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */