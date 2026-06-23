/*     */ package settlement.room.food.pasture;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.overlay.Addable;
/*     */ import settlement.tilemap.ground.GroundType;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.colors.GCOLOR;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends Addable
/*     */ {
/*     */   null(boolean $anonymous0, boolean $anonymous1) {
/* 174 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/* 177 */     double d = fertility(it.tx(), it.ty());
/* 178 */     d *= d;
/* 179 */     renderUnder(d, r, it, false);
/* 180 */     if (!(SETT.ROOMS()).placement.embryo.is(it.tile()) && SETT.TERRAIN().get(it.tile()).clearing().can()) {
/* 181 */       double w = (SETT.GROUND()).MOISTURE_TOT.get(it.tile()) * 2.0D;
/* 182 */       w = CLAMP.d(w, 0.0D, 1.0D);
/* 183 */       if (w > 0.0D) {
/* 184 */         ColorImp.TMP.interpolate((GCOLOR.MAP()).OVERLAY_BAD, (GCOLOR.MAP()).OVERLAY_GOOD, w).bind();
/* 185 */         int s = (int)(16.0D + w * 3.0D * 64.0D / 4.0D);
/* 186 */         int x1 = it.x() + (64 - s) / 2;
/* 187 */         int y1 = it.y() + (64 - s) / 2;
/*     */         
/* 189 */         (UI.icons()).s.drop.render((SPRITE_RENDERER)r, x1, x1 + s, y1, y1 + s);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private double fertility(int tx, int ty) {
/* 195 */     if (ConstructorOutdoor.this.mustBeIndoors()) {
/* 196 */       if ((SETT.TERRAIN()).MOUNTAIN.isMountain(tx, ty))
/* 197 */         return 1.0D; 
/* 198 */       return 0.5D;
/*     */     } 
/* 200 */     double f = ((GroundType)(SETT.GROUND()).MAP.get(tx, ty)).farm - 0.1D;
/* 201 */     f *= f;
/* 202 */     return 0.4D + 0.6D * f;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\pasture\ConstructorOutdoor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */