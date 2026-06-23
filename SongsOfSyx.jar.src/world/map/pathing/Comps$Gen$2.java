/*     */ package world.map.pathing;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import world.WORLD;
/*     */ import world.overlay.WorldOverlays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends WorldOverlays.OverlayTile
/*     */ {
/*     */   null(boolean $anonymous0, boolean $anonymous1) {
/* 140 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 145 */     if ((WORLD.PATH()).map.is.is(it.tile())) {
/*     */       
/* 147 */       if (tmp.is(it.tile())) {
/* 148 */         COLOR.ORANGE100.bind();
/*     */       } else {
/* 150 */         COLOR.WHITE100.bind();
/* 151 */       }  for (int di = 0; di < DIR.ALL.size(); di++) {
/* 152 */         DIR d = (DIR)DIR.ALL.get(di);
/* 153 */         if ((WORLD.PATH()).map.can(it.tx(), it.ty(), d))
/* 154 */           ((SPRITE)(SPRITES.cons()).ICO.arrows2.get(d.id())).render(r, it.x(), it.y()); 
/*     */       } 
/* 156 */       COLOR.unbind();
/*     */     } 
/*     */ 
/*     */     
/* 160 */     if (Comps.Gen.this.mark.is(it.tx(), it.ty())) {
/* 161 */       (check.get((int)GUTIL.flooder().getValue2(it.tx(), it.ty())) ? COLOR.GREEN100 : COLOR.RED100).bind();
/* 162 */       (SPRITES.cons()).ICO.clear.render(r, it.x(), it.y());
/* 163 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\Comps$Gen$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */