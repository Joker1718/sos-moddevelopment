/*     */ package view.sett.ui.subject;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GText;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends RENDEROBJ.RenderImp
/*     */ {
/*     */   final GText name;
/*     */   
/*     */   null(int $anonymous0, int $anonymous1) {
/*  91 */     super($anonymous0, $anonymous1);
/*     */     
/*  93 */     this.name = new GText((UI.FONT()).H2, 24);
/*     */   }
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  96 */     (GCOLOR.T()).H2.bind();
/*  97 */     this.name.clear();
/*  98 */     this.name.add(STATS.APPEARANCE().name(a.a.indu()));
/*  99 */     this.name.setMaxWidth(550);
/* 100 */     this.name.setMultipleLines(false);
/* 101 */     this.name.lablify();
/* 102 */     this.name.adjustWidth();
/* 103 */     this.name.renderC(r, body().cX(), body().cY());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectInfo$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */