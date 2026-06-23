/*     */ package view.sett.ui.army;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.data.GETTER;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GuiSection
/*     */ {
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  95 */     int x1 = body().x1();
/*  96 */     int y1 = body().y1();
/*  97 */     clear();
/*  98 */     for (int i = 0; i < DivList.xs; i++) {
/*  99 */       int k = ((Integer)ier.get()).intValue() * DivList.xs + i;
/* 100 */       if (k >= DivList.this.current.size()) {
/*     */         break;
/*     */       }
/* 103 */       addRightC(0, (RENDEROBJ)DivList.this.current.get(k));
/*     */     } 
/*     */     
/* 106 */     body().moveX1Y1(x1, y1);
/* 107 */     body().setWidth(((VIEW.UI()).div.settCivic.width() * DivList.scale * DivList.xs));
/* 108 */     body().setHeight(((VIEW.UI()).div.settCivic.height() * DivList.scale));
/* 109 */     super.render(r, ds);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\DivList$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */