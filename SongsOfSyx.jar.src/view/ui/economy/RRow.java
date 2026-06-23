/*     */ package view.ui.economy;
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import init.trade.TRADABLE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.ui.goods.UIGoodsExport;
/*     */ import view.ui.goods.UIGoodsImport;
/*     */ 
/*     */ final class RRow extends GuiSection {
/*  30 */   public static final COLOR colorExport = (COLOR)new ColorImp(100, 90, 70);
/*  31 */   public static final COLOR colorInport = (COLOR)new ColorImp(80, 80, 100);
/*     */   
/*     */   private final int w;
/*  34 */   private static int amount = 32;
/*     */   
/*     */   private static final int height = 60;
/*     */   
/*     */   private final GStaples[] dias;
/*     */   private INT.INTE hi;
/*     */   private final TRADABLE res;
/*     */   private final GETTER.GETTERE<TRADABLE> rcurrent;
/*  42 */   private static CharSequence ¤¤Imports = "Imports";
/*  43 */   private static CharSequence ¤¤Exports = "Exports";
/*  44 */   private static CharSequence ¤¤Lowest = "Lowest";
/*  45 */   private static CharSequence ¤¤Highest = "Highest";
/*  46 */   private static CharSequence ¤¤Unit = "Unit";
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  51 */     D.ts(RRow.class);
/*     */   }
/*     */   
/*     */   RRow(TRADABLE r, INT.INTE hi, GETTER.GETTERE<TRADABLE> rcurrent, int w, UIGoodsImport im, UIGoodsExport ex) {
/*  55 */     this.res = r;
/*  56 */     this.hi = hi;
/*  57 */     this.w = w;
/*  58 */     this.rcurrent = rcurrent;
/*  59 */     this.dias = new GStaples[] {
/*  60 */         new TradeDiagram(r), 
/*  61 */         new RRowPriceDia(r, (GCOLOR.UI()).BAD.hovered, (FACTIONS.player()).trade.pricesBuy, 60), 
/*  62 */         new RRowPriceDia(r, (GCOLOR.UI()).GOOD.hovered, (FACTIONS.player()).trade.pricesSell, 60)
/*     */       };
/*     */     
/*  65 */     addRelBody(0, DIR.E, (RENDEROBJ)this.dias[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     addRelBody(12, DIR.E, (RENDEROBJ)this.dias[1]);
/*  71 */     addRelBody(0, DIR.E, UIGoodsImport.miniControl(r, im));
/*     */     
/*  73 */     addRelBody(12, DIR.E, (RENDEROBJ)this.dias[2]);
/*  74 */     addRelBody(0, DIR.E, UIGoodsExport.mini(r, ex));
/*     */ 
/*     */     
/*  77 */     addRelBody(8, DIR.W, this.res.icon().scaled(2.0D));
/*     */     
/*  79 */     pad(2, 6);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/*  84 */     boolean b = super.hover(mCoo); byte b1; int i; GStaples[] arrayOfGStaples;
/*  85 */     for (i = (arrayOfGStaples = this.dias).length, b1 = 0; b1 < i; ) { GStaples ss = arrayOfGStaples[b1];
/*  86 */       if (ss.hoveredIs()) {
/*  87 */         this.hi.set(ss.hoverI());
/*  88 */         this.rcurrent.set(this.res);
/*     */       }  b1++; }
/*     */     
/*  91 */     if (this.hi.get() >= 0 && this.rcurrent.get() == this.res)
/*  92 */       for (i = (arrayOfGStaples = this.dias).length, b1 = 0; b1 < i; ) { GStaples ss = arrayOfGStaples[b1];
/*  93 */         ss.setHovered(this.hi.get());
/*     */         b1++; }
/*     */        
/*  96 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 101 */     if (this.hi.get() < 0) {
/* 102 */       super.hoverInfoGet(text);
/*     */       return;
/*     */     } 
/* 105 */     if (this.rcurrent.get() != this.res) {
/* 106 */       super.hoverInfoGet(text);
/*     */       return;
/*     */     } 
/* 109 */     GBox b = (GBox)text;
/* 110 */     b.title(this.res.names);
/*     */     
/* 112 */     int si = amount - this.hi.get() - 1;
/*     */ 
/*     */     
/* 115 */     GText t = b.text();
/* 116 */     t.lablify();
/* 117 */     DicTime.setAgo((Str)t, si * (GAME.player().res()).time.bitSeconds());
/* 118 */     b.add((SPRITE)t);
/* 119 */     b.sep();
/*     */ 
/*     */ 
/*     */     
/* 123 */     b.textLL(Dic.¤¤Stored);
/* 124 */     b.tab(6);
/* 125 */     b.add((SPRITE)GFORMAT.i(b.text(), FACTIONS.player().seller(this.res).storedHistorically(si)));
/* 126 */     b.NL();
/* 127 */     b.textLL(Dic.¤¤avePrice);
/* 128 */     b.tab(6);
/* 129 */     b.add((SPRITE)GFORMAT.i(b.text(), (FACTIONS.player()).trade.pricesAve.history((MAPPED)this.res).get(si)));
/* 130 */     b.NL();
/* 131 */     b.sep();
/*     */ 
/*     */ 
/*     */     
/* 135 */     b.textLL(¤¤Imports);
/* 136 */     b.NL();
/* 137 */     b.add((SPRITE)b.text().add(Dic.¤¤Price).s().add('(').add(¤¤Lowest).add(')'));
/* 138 */     b.tab(6);
/* 139 */     b.add((SPRITE)GFORMAT.i(b.text(), (FACTIONS.player()).trade.pricesBuy.history((MAPPED)this.res).get(si)));
/* 140 */     b.NL();
/* 141 */     b.add((SPRITE)b.text().add(Dic.¤¤Bought));
/* 142 */     b.tab(6);
/* 143 */     b.add((SPRITE)GFORMAT.i(b.text(), (FACTIONS.player()).trade.unitsImported.history((MAPPED)this.res).get(si)));
/* 144 */     b.NL();
/* 145 */     b.add((SPRITE)b.text().add(Dic.¤¤Earnings).s().add('/').s().add(¤¤Unit));
/* 146 */     b.tab(6);
/* 147 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), -(FACTIONS.player()).trade.priceImported.history((MAPPED)this.res).get(si)));
/* 148 */     b.NL();
/* 149 */     b.add((SPRITE)b.text().add(Dic.¤¤Earnings));
/* 150 */     b.tab(6);
/* 151 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), -(FACTIONS.player()).trade.outImported.history((MAPPED)this.res).get(si)));
/* 152 */     b.NL();
/*     */     
/* 154 */     b.NL(8);
/*     */     
/* 156 */     b.textLL(¤¤Exports);
/* 157 */     b.NL();
/* 158 */     b.add((SPRITE)b.text().add(Dic.¤¤Price).s().add('(').add(¤¤Highest).add(')'));
/* 159 */     b.tab(6);
/* 160 */     b.add((SPRITE)GFORMAT.i(b.text(), (FACTIONS.player()).trade.pricesSell.history((MAPPED)this.res).get(si)));
/* 161 */     b.NL();
/* 162 */     b.add((SPRITE)b.text().add(Dic.¤¤Sold));
/* 163 */     b.tab(6);
/* 164 */     b.add((SPRITE)GFORMAT.i(b.text(), (FACTIONS.player()).trade.unitsExported.history((MAPPED)this.res).get(si)));
/* 165 */     b.NL();
/* 166 */     b.add((SPRITE)b.text().add(Dic.¤¤Earnings).s().add('/').s().add(¤¤Unit));
/* 167 */     b.tab(6);
/* 168 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), (FACTIONS.player()).trade.priceExported.history((MAPPED)this.res).get(si)));
/* 169 */     b.NL();
/* 170 */     b.add((SPRITE)b.text().add(Dic.¤¤Earnings));
/* 171 */     b.tab(6);
/* 172 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), (FACTIONS.player()).trade.inExported.history((MAPPED)this.res).get(si)));
/* 173 */     b.NL();
/*     */     
/* 175 */     b.sep();
/* 176 */     b.textL(Dic.¤¤Total);
/* 177 */     b.tab(6);
/* 178 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), ((GAME.player()).trade.inExported.history((MAPPED)this.res).get(si) - (GAME.player()).trade.outImported.history((MAPPED)this.res).get(si))));
/* 179 */     b.NL();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class TradeDiagram
/*     */     extends GStaples
/*     */   {
/*     */     private final TRADABLE res;
/*     */ 
/*     */ 
/*     */     
/* 191 */     private GStat tprofits = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 195 */           GFORMAT.iIncr(text, ((GAME.player()).trade.inExported.history((MAPPED)RRow.TradeDiagram.this.res).get(1) - (GAME.player()).trade.outImported.history((MAPPED)RRow.TradeDiagram.this.res).get(1)));
/*     */         }
/* 197 */       }).bg();
/*     */     
/*     */     TradeDiagram(TRADABLE res) {
/* 200 */       super(RRow.amount, false);
/* 201 */       this.res = res;
/* 202 */       body().setWidth((RRow.this.w * RRow.amount)).setHeight(60.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 208 */       super.render(r, ds, hoveredIs());
/* 209 */       this.tprofits.render(r, body().x1() + RRow.this.w, body().y1() + RRow.this.w / 2);
/*     */     }
/*     */ 
/*     */     
/*     */     protected double getValue(int stapleI) {
/* 214 */       stapleI = RRow.amount - 1 - stapleI;
/* 215 */       return Math.abs((GAME.player()).trade.inExported.history((MAPPED)this.res).get(stapleI) - (GAME.player()).trade.outImported.history((MAPPED)this.res).get(stapleI));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void hover(GBox box, int stapleI) {}
/*     */ 
/*     */ 
/*     */     
/*     */     protected void setColor(ColorImp c, int x, double value) {
/* 226 */       x = RRow.amount - 1 - x;
/* 227 */       if ((GAME.player()).trade.inExported.history((MAPPED)this.res).get(x) - (GAME.player()).trade.outImported.history((MAPPED)this.res).get(x) < 0) {
/* 228 */         c.set((GCOLOR.UI()).BAD.normal);
/*     */       } else {
/* 230 */         c.set((GCOLOR.UI()).GOOD.normal);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\economy\RRow.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */