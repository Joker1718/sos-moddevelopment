/*     */ package world.map.pathing;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.SPRITE;
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
/*     */ class null
/*     */   extends WorldOverlays.OverlayTile
/*     */ {
/*     */   null(boolean $anonymous0, boolean $anonymous1) {
/*  88 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/*  93 */     if ((WORLD.PATH()).map.is.is(it.tile())) {
/*  94 */       COLOR.WHITE100.bind();
/*  95 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/*  96 */         DIR d = (DIR)DIR.ALL.get(di);
/*  97 */         if ((WORLD.PATH()).map.can(it.tx(), it.ty(), d))
/*  98 */           ((SPRITE)(SPRITES.cons()).ICO.arrows2.get(d.id())).render(r, it.x(), it.y()); 
/*     */       } 
/* 100 */       COLOR.unbind();
/*     */     } 
/* 102 */     if (Comps.Gen.this.mark.is(it.tx(), it.ty())) {
/* 103 */       COLOR.RED100.bind();
/* 104 */       (SPRITES.cons()).ICO.clear.render(r, it.x(), it.y());
/* 105 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\Comps$Gen$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */