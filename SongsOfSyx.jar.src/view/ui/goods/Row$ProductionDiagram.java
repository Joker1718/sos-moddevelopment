/*     */ package view.ui.goods;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.resources.RESOURCE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ProductionDiagram
/*     */   extends GStaples
/*     */ {
/*     */   private final GETTER<RESOURCE> res;
/*     */   
/* 227 */   private GStat t = (new GStat()
/*     */     {
/*     */       public void update(GText text)
/*     */       {
/* 231 */         GFORMAT.iIncr(text, GAME.player().res().total().history(Row.tr(Row.ProductionDiagram.this.res)).get(1));
/*     */       }
/* 233 */     }).bg();
/*     */   
/*     */   ProductionDiagram(GETTER<RESOURCE> res) {
/* 236 */     super(Row.amount, false);
/* 237 */     this.res = res;
/* 238 */     body().setWidth((5 * Row.amount)).setHeight(60.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 244 */     super.render(r, ds, hoveredIs());
/* 245 */     this.t.render(r, body().x1() + 5, body().y1() + 2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected double getValue(int stapleI) {
/* 251 */     return Math.abs(GAME.player().res().total().history(Row.tr(this.res)).get(Row.amount - 1 - stapleI));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, int stapleI) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setColor(ColorImp c, int x, double value) {
/* 262 */     if (GAME.player().res().total().history(Row.tr(this.res)).get(Row.amount - 1 - x) < 0) {
/* 263 */       c.set((GCOLOR.UI()).BAD.normal);
/*     */     } else {
/* 265 */       c.set((GCOLOR.UI()).GOOD.normal);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\goods\Row$ProductionDiagram.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */