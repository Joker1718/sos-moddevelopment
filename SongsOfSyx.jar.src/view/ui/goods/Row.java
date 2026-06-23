/*     */ package view.ui.goods;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.trade.TRADABLE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.RoomProduction;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import view.main.VIEW;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ final class Row extends GuiSection {
/*     */   private static final int w = 5;
/*  44 */   private static int amount = FACTIONS.player().res().total().history(((RESOURCE)RESOURCES.ALL().get(0)).tr()).historyRecords();
/*     */   
/*     */   private static final int height = 60;
/*     */   private final GStaples[] dias;
/*     */   private int hi;
/*     */   private final GETTER<RESOURCE> res;
/*     */   
/*     */   Row(GETTER<RESOURCE> r, Pop pop) {
/*  52 */     this.res = r;
/*  53 */     INT.IntImp intImp = new INT.IntImp();
/*  54 */     intImp.set(-1);
/*     */     
/*  56 */     add((RENDEROBJ)new HOVERABLE.HoverableAbs(48)
/*     */         {
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */           {
/*  60 */             SPRITE s = (Row.this.res.get() == null) ? (SPRITES.icons()).m.urn.big : (SPRITE)((RESOURCE)Row.this.res.get()).icon();
/*  61 */             s.render(r, (RECTANGLE)this.body);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/*  66 */             if (Row.this.res.get() != null) {
/*  67 */               ((RESOURCE)Row.this.res.get()).hoverDetailed(text);
/*     */             } else {
/*  69 */               text.title(Dic.¤¤Total);
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/*  74 */     this.dias = new GStaples[] {
/*  75 */         new StorageDiagram(r), 
/*  76 */         new ProductionDiagram(r) }; byte b;
/*     */     int i;
/*     */     GStaples[] arrayOfGStaples;
/*  79 */     for (i = (arrayOfGStaples = this.dias).length, b = 0; b < i; ) { GStaples ss = arrayOfGStaples[b];
/*  80 */       addRelBody(4, DIR.E, (RENDEROBJ)ss); b++; }
/*     */     
/*  82 */     addRelBody(4, DIR.E, prod(r, pop));
/*  83 */     pad(2, 6);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  88 */     this.hi = -1; byte b; int i; GStaples[] arrayOfGStaples;
/*  89 */     for (i = (arrayOfGStaples = this.dias).length, b = 0; b < i; ) { GStaples ss = arrayOfGStaples[b];
/*  90 */       if (ss.hoveredIs())
/*  91 */         this.hi = ss.hoverI(); 
/*     */       b++; }
/*     */     
/*  94 */     if (this.hi >= 0) {
/*  95 */       for (i = (arrayOfGStaples = this.dias).length, b = 0; b < i; ) { GStaples ss = arrayOfGStaples[b];
/*  96 */         ss.setHovered(this.hi);
/*     */         b++; }
/*     */     
/*     */     }
/* 100 */     super.render(r, ds);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 105 */     if (this.hi < 0) {
/* 106 */       super.hoverInfoGet(text);
/*     */       return;
/*     */     } 
/* 109 */     GBox b = (GBox)text;
/*     */     
/* 111 */     int si = amount - this.hi - 1;
/*     */ 
/*     */     
/* 114 */     GText t = b.text();
/* 115 */     t.lablify();
/* 116 */     DicTime.setAgo((Str)t, si * (GAME.player().res()).time.bitSeconds());
/* 117 */     b.add((SPRITE)t);
/* 118 */     b.NL(4);
/*     */ 
/*     */     
/* 121 */     RESOURCE res = (RESOURCE)this.res.get();
/*     */ 
/*     */     
/* 124 */     b.textL(Dic.¤¤Stored);
/* 125 */     b.tab(6);
/* 126 */     b.add((SPRITE)GFORMAT.i(b.text(), (SETT.ROOMS()).STOCKPILE.tally().amountsDay().history((MAPPED)res).get(si)));
/* 127 */     b.NL(8);
/*     */ 
/*     */     
/* 130 */     FResources rr = FACTIONS.player().res();
/* 131 */     for (FResources.RTYPE rTYPE : FResources.RTYPE.all) {
/* 132 */       b.add((SPRITE)b.text().normalify().add(rTYPE.name));
/* 133 */       b.tab(6);
/* 134 */       b.add((SPRITE)GFORMAT.iIncr(b.text(), rr.in(rTYPE).history(tr(res)).get(si)));
/* 135 */       b.tab(8);
/* 136 */       b.add((SPRITE)GFORMAT.iIncr(b.text(), -rr.out(rTYPE).history(tr(res)).get(si)));
/* 137 */       b.NL();
/*     */     } 
/*     */     
/* 140 */     b.NL(4);
/* 141 */     b.textL(Dic.¤¤Net);
/* 142 */     b.tab(6);
/* 143 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), GAME.player().res().total().history(tr(res)).get(si)));
/*     */ 
/*     */ 
/*     */     
/* 147 */     b.NL(8);
/* 148 */     si = amount - this.hi - 1;
/* 149 */     b.text(Dic.¤¤buyPrice);
/* 150 */     b.tab(6);
/* 151 */     b.add((SPRITE)GFORMAT.i(b.text(), (FACTIONS.player()).trade.pricesBuy.history((MAPPED)tr(res)).get(si)));
/* 152 */     b.NL();
/* 153 */     b.text(Dic.¤¤sellPrice);
/* 154 */     b.tab(6);
/* 155 */     b.add((SPRITE)GFORMAT.i(b.text(), (FACTIONS.player()).trade.pricesSell.history((MAPPED)tr(res)).get(si)));
/* 156 */     b.NL();
/* 157 */     if (res != null) {
/* 158 */       b.text(Dic.¤¤avePrice);
/* 159 */       b.tab(6);
/* 160 */       b.add((SPRITE)GFORMAT.i(b.text(), ((si == 0) ? FACTIONS.PRICE().get(tr(res)) : (FACTIONS.player()).trade.pricesAve.history((MAPPED)tr(res)).get(si))));
/* 161 */       b.NL();
/*     */     } 
/*     */ 
/*     */     
/* 165 */     b.textL(Dic.¤¤Earnings);
/* 166 */     b.tab(6);
/* 167 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), ((GAME.player()).trade.inExported.history((MAPPED)tr(res)).get(si) - (GAME.player()).trade.outImported.history((MAPPED)tr(res)).get(si))));
/* 168 */     b.text(Dic.¤¤Curr);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class StorageDiagram
/*     */     extends GStaples
/*     */   {
/*     */     private final GETTER<RESOURCE> res;
/*     */ 
/*     */     
/* 178 */     private GStat t = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 182 */           GFORMAT.iofkNoColor(text, (SETT.ROOMS()).STOCKPILE.tally().amountTotal((RESOURCE)Row.StorageDiagram.this.res.get()), ((SETT.ROOMS()).STOCKPILE.tally()).space.total((RESOURCE)Row.StorageDiagram.this.res.get()));
/*     */         }
/* 184 */       }).bg();
/*     */     
/*     */     StorageDiagram(GETTER<RESOURCE> res) {
/* 187 */       super(Row.amount);
/* 188 */       this.res = res;
/* 189 */       body().setWidth((5 * Row.amount)).setHeight(60.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 195 */       super.render(r, ds, hoveredIs());
/* 196 */       this.t.render(r, body().x1() + 5, body().y1() + 2);
/*     */     }
/*     */ 
/*     */     
/*     */     protected double getValue(int stapleI) {
/* 201 */       double c = ((SETT.ROOMS()).STOCKPILE.tally()).space.total((RESOURCE)this.res.get());
/* 202 */       double d = (SETT.ROOMS()).STOCKPILE.tally().amountsDay().history((MAPPED)this.res.get()).get(Row.amount - 1 - stapleI);
/* 203 */       if (c == 0.0D) {
/* 204 */         d = ((d > 0.0D) ? true : false);
/*     */       } else {
/* 206 */         d /= c;
/*     */       } 
/* 208 */       d = CLAMP.d(d, 0.0D, 1.0D);
/* 209 */       return d;
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
/* 220 */       c.set((GCOLOR.UI()).SOSO.normal);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ProductionDiagram extends GStaples {
/*     */     private final GETTER<RESOURCE> res;
/*     */     
/* 227 */     private GStat t = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 231 */           GFORMAT.iIncr(text, GAME.player().res().total().history(Row.tr(Row.ProductionDiagram.this.res)).get(1));
/*     */         }
/* 233 */       }).bg();
/*     */     
/*     */     ProductionDiagram(GETTER<RESOURCE> res) {
/* 236 */       super(Row.amount, false);
/* 237 */       this.res = res;
/* 238 */       body().setWidth((5 * Row.amount)).setHeight(60.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 244 */       super.render(r, ds, hoveredIs());
/* 245 */       this.t.render(r, body().x1() + 5, body().y1() + 2);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected double getValue(int stapleI) {
/* 251 */       return Math.abs(GAME.player().res().total().history(Row.tr(this.res)).get(Row.amount - 1 - stapleI));
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
/* 262 */       if (GAME.player().res().total().history(Row.tr(this.res)).get(Row.amount - 1 - x) < 0) {
/* 263 */         c.set((GCOLOR.UI()).BAD.normal);
/*     */       } else {
/* 265 */         c.set((GCOLOR.UI()).GOOD.normal);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private static TRADABLE tr(GETTER<RESOURCE> g) {
/* 271 */     if (g.get() == null)
/* 272 */       return null; 
/* 273 */     return ((RESOURCE)g.get()).tr();
/*     */   }
/*     */   
/*     */   private static TRADABLE tr(RESOURCE res) {
/* 277 */     if (res == null)
/* 278 */       return null; 
/* 279 */     return res.tr();
/*     */   }
/*     */ 
/*     */   
/*     */   private static RENDEROBJ prod(final GETTER<RESOURCE> gres, final Pop pop) {
/* 284 */     final GStat s = new GStat()
/*     */       {
/*     */         
/*     */         public void update(GText text)
/*     */         {
/* 289 */           double tot = 0.0D;
/*     */           
/* 291 */           RESOURCE res = (RESOURCE)gres.get();
/* 292 */           for (RoomProduction.Source rr : (SETT.ROOMS()).PROD.producers(res)) {
/* 293 */             if (rr.am() == 0.0D)
/*     */               continue; 
/* 295 */             tot += rr.am();
/*     */           } 
/* 297 */           for (RoomProduction.Source rr : (SETT.ROOMS()).PROD.consumers(res)) {
/* 298 */             if (rr.am() == 0.0D)
/*     */               continue; 
/* 300 */             tot -= rr.am();
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 306 */           GFORMAT.iIncr(text, (long)tot);
/*     */         }
/*     */       };
/*     */     
/* 310 */     CLICKABLE.ClickableAbs c = new CLICKABLE.ClickableAbs()
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */         {
/* 314 */           if (gres.get() == null)
/*     */             return; 
/* 316 */           GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 317 */           GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/* 318 */           s.renderC(r, (RECTANGLE)this.body);
/* 319 */           for (int i = 0; i < FACTIONS.player().realm().regions(); i++) {
/* 320 */             Region re = FACTIONS.player().realm().region(i);
/* 321 */             if (RD.OUTPUT().get(Row.tr(gres)).getDelivery(re) > 0) {
/*     */               return;
/*     */             }
/*     */           } 
/* 325 */           OPACITY.O50.bind();
/* 326 */           COLOR.BLACK.render(r, (RECTANGLE)this.body);
/* 327 */           OPACITY.unbind();
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 332 */           if (gres.get() == null)
/*     */             return; 
/* 334 */           for (int i = 0; i < FACTIONS.player().realm().regions(); i++) {
/* 335 */             Region re = FACTIONS.player().realm().region(i);
/* 336 */             if (RD.OUTPUT().get(Row.tr(gres)).getDelivery(re) > 0) {
/* 337 */               pop.res = (RESOURCE)gres.get();
/* 338 */               (VIEW.inters()).popup.show((RENDEROBJ)pop, (CLICKABLE)this);
/*     */               return;
/*     */             } 
/*     */           } 
/* 342 */           super.clickA();
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 347 */           if (gres.get() == null)
/*     */             return; 
/* 349 */           ((RESOURCE)gres.get()).hoverDetailed(text);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 354 */     c.body.setDim(64.0D, 62.0D);
/*     */ 
/*     */     
/* 357 */     return (RENDEROBJ)c;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\goods\Row.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */