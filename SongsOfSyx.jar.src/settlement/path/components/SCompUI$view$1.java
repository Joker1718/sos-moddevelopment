/*     */ package settlement.path.components;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.ON_TOP_RENDERABLE;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
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
/*     */ class null
/*     */   extends ON_TOP_RENDERABLE
/*     */ {
/*     */   public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {
/*  84 */     RenderData.RenderIterator it = data.onScreenTiles();
/*  85 */     SComponentLevel prev = (SCompUI.view.access$0(SCompUI.view.this)).l;
/*  86 */     SComponentLevel current = (SCompUI.view.access$0(SCompUI.view.this)).l;
/*     */     
/*  88 */     if ((SCompUI.view.access$0(SCompUI.view.this)).l.level() > 0) {
/*  89 */       prev = (SComponentLevel)(SETT.PATH()).comps.all.get((SCompUI.view.access$0(SCompUI.view.this)).l.level() - 1);
/*     */     }
/*     */     
/*  92 */     while (it.has()) {
/*  93 */       SComponent c = (SComponent)prev.get(it.tile());
/*  94 */       if (c != null) {
/*  95 */         int m = 0;
/*  96 */         for (DIR d : DIR.ORTHO) {
/*  97 */           if (c.is(it.tx(), it.ty(), d))
/*  98 */             m |= d.mask(); 
/*     */         } 
/* 100 */         SComponent cc = (SComponent)current.get(it.tile());
/* 101 */         if (cc != null) {
/* 102 */           if (cc == SCompUI.view.this.comp) {
/* 103 */             COLOR.WHITE100.bind();
/*     */           } else {
/* 105 */             ((COLOR)COLOR.UNIQUE.getC(cc.index())).bind();
/* 106 */           }  if (m != 15)
/* 107 */             (SPRITES.cons()).BIG.dashed_hollow.render((SPRITE_RENDERER)r, m, it.x(), it.y()); 
/* 108 */           if (it.tx() == cc.centreX() && it.ty() == cc.centreY()) {
/* 109 */             (SPRITES.cons()).ICO.crosshair.render((SPRITE_RENDERER)r, it.x(), it.y());
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 116 */       it.next();
/*     */     } 
/* 118 */     COLOR.unbind();
/* 119 */     remove();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SCompUI$view$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */