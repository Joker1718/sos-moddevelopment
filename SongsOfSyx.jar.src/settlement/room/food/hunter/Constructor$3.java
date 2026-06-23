/*     */ package settlement.room.food.hunter;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import settlement.thing.ThingsCadavers;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
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
/*     */ class null
/*     */   extends RoomSpriteCombo
/*     */ {
/*     */   null(Json $anonymous0, String $anonymous1) throws IOException {
/*  82 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  88 */     boolean ret = super.render(r, s, data, it, degrade, isCandle);
/*  89 */     if (isCandle)
/*  90 */       return ret; 
/*  91 */     ThingsCadavers.Cadaver ca = (ThingsCadavers.Cadaver)(SETT.THINGS()).cadavers.tGet.get(it.tx(), it.ty());
/*  92 */     if (ca != null) {
/*  93 */       (ca.spec()).blood.bind();
/*  94 */       long ran = it.bigRan();
/*  95 */       int a = Job.gore.get((SETT.ROOMS()).data.get(it.tile()));
/*  96 */       int cx = it.x() + 32;
/*  97 */       int cy = it.y() + 32;
/*  98 */       for (int i = 0; i < a; i++) {
/*  99 */         int xx = (int)(cx + (-4L + (ran & 0x7L)) * 4L);
/* 100 */         ran >>= 3L;
/* 101 */         int yy = (int)(cy + (-4L + (ran & 0x7L)) * 4L);
/* 102 */         ran >>= 3L;
/*     */         
/* 104 */         (SETT.THINGS()).sprites.bloodPool.render(r, (int)(ran & 0xFL), xx, yy);
/* 105 */         ran >>= 4L;
/*     */       } 
/* 107 */       COLOR.unbind();
/*     */     } 
/* 109 */     return ret;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\hunter\Constructor$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */