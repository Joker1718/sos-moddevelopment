/*     */ package view.ui.economy;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.trade.TRADABLE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class TradeDiagram
/*     */   extends GStaples
/*     */ {
/*     */   private final TRADABLE res;
/*     */   
/* 191 */   private GStat tprofits = (new GStat()
/*     */     {
/*     */       public void update(GText text)
/*     */       {
/* 195 */         GFORMAT.iIncr(text, ((GAME.player()).trade.inExported.history((MAPPED)RRow.TradeDiagram.this.res).get(1) - (GAME.player()).trade.outImported.history((MAPPED)RRow.TradeDiagram.this.res).get(1)));
/*     */       }
/* 197 */     }).bg();
/*     */   
/*     */   TradeDiagram(TRADABLE res) {
/* 200 */     super(RRow.amount, false);
/* 201 */     this.res = res;
/* 202 */     body().setWidth((paramRRow.w * RRow.amount)).setHeight(60.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 208 */     super.render(r, ds, hoveredIs());
/* 209 */     this.tprofits.render(r, body().x1() + RRow.this.w, body().y1() + RRow.this.w / 2);
/*     */   }
/*     */ 
/*     */   
/*     */   protected double getValue(int stapleI) {
/* 214 */     stapleI = RRow.amount - 1 - stapleI;
/* 215 */     return Math.abs((GAME.player()).trade.inExported.history((MAPPED)this.res).get(stapleI) - (GAME.player()).trade.outImported.history((MAPPED)this.res).get(stapleI));
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
/* 226 */     x = RRow.amount - 1 - x;
/* 227 */     if ((GAME.player()).trade.inExported.history((MAPPED)this.res).get(x) - (GAME.player()).trade.outImported.history((MAPPED)this.res).get(x) < 0) {
/* 228 */       c.set((GCOLOR.UI()).BAD.normal);
/*     */     } else {
/* 230 */       c.set((GCOLOR.UI()).GOOD.normal);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\economy\RRow$TradeDiagram.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */