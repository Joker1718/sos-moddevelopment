/*     */ package view.ui.economy;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.Icons;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TRADABLE;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ import util.statistics.HistoryTradable;
/*     */ 
/*     */ class RRowPriceDia
/*     */   extends GStaples
/*     */ {
/*     */   private final COLOR col;
/*     */   private final HistoryTradable hres;
/*     */   private final TRADABLE res;
/*     */   private final int amount;
/*     */   
/*  31 */   private GStat tbuy = (new GStat()
/*     */     {
/*     */       public void update(GText text)
/*     */       {
/*  35 */         int b = RRowPriceDia.this.hres.get((MAPPED)RRowPriceDia.this.res);
/*  36 */         if (RRowPriceDia.this.res == null)
/*  37 */           b /= RESOURCES.ALL().size(); 
/*  38 */         GFORMAT.i(text, b);
/*     */       }
/*  40 */     }).bg();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   RRowPriceDia(TRADABLE res, COLOR color, HistoryTradable hres, int height) {
/*  57 */     super(32, false);
/*  58 */     this.amount = 32;
/*  59 */     this.col = color;
/*  60 */     this.res = res;
/*  61 */     this.hres = hres;
/*  62 */     body().setWidth((5 * this.amount)).setHeight(height);
/*  63 */     normalize(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/*  69 */     super.render(r, ds, hoveredIs());
/*  70 */     this.tbuy.render(r, body().x1() + 4, body().y1() + 4);
/*     */ 
/*     */     
/*  73 */     COLOR c = (GCOLOR.UI()).GOOD.hovered;
/*  74 */     Icons.S.IconS iconS = (UI.icons()).s.chevron(DIR.E);
/*  75 */     double d = SETT.TRADE().buyer(this.res).tradeValue();
/*     */     
/*  77 */     if (this.hres == (FACTIONS.player()).trade.pricesBuy) {
/*  78 */       c = (GCOLOR.UI()).BAD.hovered;
/*  79 */       iconS = (UI.icons()).s.chevron(DIR.W);
/*  80 */       d = SETT.TRADE().seller(this.res).tradeValue();
/*     */     } 
/*     */     
/*  83 */     int am = (int)Math.round(d * 5.0D);
/*  84 */     if (am > 8)
/*  85 */       am = 8; 
/*  86 */     int x1 = this.body.x1() + 4;
/*     */     
/*  88 */     if (am > 0) {
/*  89 */       OPACITY.O66.bind();
/*  90 */       COLOR.BLACK.render(r, x1 - 1, x1 + 4 + 16 + (am - 1) * 16 / 2, this.body.y2() - 2 - 16, this.body.y2() - 2);
/*  91 */       OPACITY.unbind();
/*     */       
/*  93 */       c.bind();
/*  94 */       for (int i = 0; i < am; i++) {
/*     */         
/*  96 */         iconS.render(r, x1, body().y2() - 4 - 16);
/*  97 */         x1 += 8;
/*     */       } 
/*  99 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double getValue(int stapleI) {
/* 111 */     return this.hres.history((MAPPED)this.res).get(this.amount - 1 - stapleI);
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
/* 122 */     c.set(this.col);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\economy\RRowPriceDia.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */