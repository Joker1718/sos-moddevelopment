/*     */ package settlement.room.infra.station;
/*     */ 
/*     */ import game.GAME;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
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
/*     */ class null
/*     */   extends RoomSprite1x1
/*     */ {
/*     */   null(Json $anonymous0, String $anonymous1) throws IOException {
/*  89 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*  92 */     return (item.sprite(rx, ry) == this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  98 */     StationInstance ins = (StationInstance)blue.get(it.tx(), it.ty());
/*  99 */     if (ins != null && 
/* 100 */       ins.prepD() + (GUTIL.ran2().get(it.tile()) & 0xFF) * 0.00392156862745098D >= 1.0D) {
/* 101 */       DIR d = (DIR)DIR.ORTHO.get(((FurnisherItem)(SETT.ROOMS()).fData.item.get(it.tile())).rotation);
/*     */       
/* 103 */       double mov = (GAME.intervals().get05() + it.ran() & 0xFF);
/* 104 */       mov /= 255.0D;
/* 105 */       SETT.ANIMALS().renderCaravan(r, s, mov, it.x() + 32 + d.x() * 32, it.y() + 32 + d.y() * 32, null, 0, false, d.id(), it.ran());
/*     */     } 
/*     */ 
/*     */     
/* 109 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 114 */     s.setSoft();
/* 115 */     super.render(r, s, data, it, degrade, false);
/* 116 */     s.setPrev();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\station\Constructor$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */