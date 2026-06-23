/*     */ package settlement.room.industry.workshop;
/*     */ 
/*     */ import init.sprite.game.SheetPair;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.GUTIL;
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
/*     */   extends Constructor.STable
/*     */ {
/*     */   final RoomSprite1x1 under;
/*     */   final RoomSprite1x1 above;
/*     */   
/*     */   null(Json $anonymous0, Json paramJson1, final ROOM_WORKSHOP blue) throws IOException {
/* 109 */     super($anonymous0);
/*     */     
/* 111 */     this.under = new RoomSprite1x1(paramJson1, "WORK_BELOW_1X1")
/*     */       {
/*     */         public int frame(SheetPair a, RenderData.RenderIterator it)
/*     */         {
/* 115 */           this.animationSpeed = 0.0D;
/* 116 */           if (blue.is(it.tile())) {
/* 117 */             int d = (SETT.ROOMS()).data.get(it.tx(), it.ty());
/* 118 */             if (blue.job.FETCH.working(d)) {
/* 119 */               this.animationSpeed = 1.0D;
/*     */             }
/*     */           } 
/* 122 */           return super.frame(a, it);
/*     */         }
/*     */       };
/*     */     
/* 126 */     this.above = new RoomSprite1x1(paramJson1, "WORK_ABOVE_1X1")
/*     */       {
/*     */         public int frame(SheetPair a, RenderData.RenderIterator it)
/*     */         {
/* 130 */           this.animationSpeed = 0.0D;
/* 131 */           if (blue.is(it.tile())) {
/* 132 */             int d = (SETT.ROOMS()).data.get(it.tx(), it.ty());
/* 133 */             if (blue.job.FETCH.working(d)) {
/* 134 */               this.animationSpeed = 1.0D;
/*     */             }
/*     */           } 
/* 137 */           return super.frame(a, it);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 142 */           rx -= d.x();
/* 143 */           ry -= d.y();
/* 144 */           if ((GUTIL.ran2().get(tx, ty) & 0x3) == 0) {
/* 145 */             d = d.next(2);
/* 146 */           } else if ((GUTIL.ran2().get(tx, ty) & 0x3) == 1) {
/* 147 */             d = d.next(-2);
/*     */           } 
/* 149 */           rx += d.x();
/* 150 */           ry += d.y();
/* 151 */           return (item.sprite(rx, ry) == sChair);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 160 */     super.render(r, s, data, it, degrade, isCandle);
/* 161 */     this.under.render(r, s, getData2(it), it, degrade, isCandle);
/* 162 */     if (blue.is(it.tile())) {
/* 163 */       int d = (SETT.ROOMS()).data.get(it.tx(), it.ty());
/* 164 */       if (blue.job.FETCH.working(d)) {
/* 165 */         WorkshopInstance ins = (WorkshopInstance)blue.get(it.tile());
/* 166 */         DIR dir = (DIR)DIR.ORTHO.get((SETT.ROOMS()).fData.spriteData2.get(it.tile()) & 0x3);
/*     */         
/* 168 */         ((IndustryResource)ins.industry().outs().get(0)).resource.renderOne(r, it.x() + dir.x() * 8, it.y() + dir.y() * 8, it.ran());
/*     */       } 
/*     */     } 
/* 171 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 176 */     this.above.render(r, s, getData2(it), it, degrade, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 182 */     return this.above.getData(tx, ty, rx, ry, item, itemRan);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\workshop\Constructor$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */