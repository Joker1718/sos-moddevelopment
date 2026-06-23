/*     */ package settlement.room.industry.workshop;
/*     */ 
/*     */ import init.sprite.game.SheetPair;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public int frame(SheetPair a, RenderData.RenderIterator it) {
/* 130 */     this.animationSpeed = 0.0D;
/* 131 */     if (blue.is(it.tile())) {
/* 132 */       int d = (SETT.ROOMS()).data.get(it.tx(), it.ty());
/* 133 */       if (blue.job.FETCH.working(d)) {
/* 134 */         this.animationSpeed = 1.0D;
/*     */       }
/*     */     } 
/* 137 */     return super.frame(a, it);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 142 */     rx -= d.x();
/* 143 */     ry -= d.y();
/* 144 */     if ((GUTIL.ran2().get(tx, ty) & 0x3) == 0) {
/* 145 */       d = d.next(2);
/* 146 */     } else if ((GUTIL.ran2().get(tx, ty) & 0x3) == 1) {
/* 147 */       d = d.next(-2);
/*     */     } 
/* 149 */     rx += d.x();
/* 150 */     ry += d.y();
/* 151 */     return (item.sprite(rx, ry) == sChair);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\workshop\Constructor$6$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */