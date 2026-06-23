/*     */ package view.ui.goods;
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.deal.DealParty;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import settlement.trade.PBuyer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GInputInt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ import util.statistics.HistoryTradable;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import view.main.VIEW;
/*     */ import world.region.RD;
/*     */ 
/*     */ public class UIGoodsImport extends GuiSection {
/*  48 */   static CharSequence ¤¤name = "Import Settings";
/*  49 */   static CharSequence ¤¤Best = "¤Best";
/*  50 */   static CharSequence ¤¤BestD = "¤Make a custom order of this resource from the trade partner with the most favourable price.";
/*  51 */   static CharSequence ¤¤Closest = "¤Closest";
/*  52 */   static CharSequence ¤¤ClosestD = "¤Make a speedy custom order of this resource from the trade partner that is closest.";
/*  53 */   static CharSequence ¤¤Stockpile = "¤Current warehouse stock:";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   private static CharSequence ¤¤priceCapD = "¤The maximum price you are willing to pay for this resource.";
/*  59 */   private static CharSequence ¤¤minCredsD = "¤The minimum credits needed before a purchase is undertaken.";
/*     */ 
/*     */   
/*  62 */   public static final COLOR color = (COLOR)new ColorImp(80, 80, 100);
/*  63 */   private static final COLOR colorDark = (COLOR)color.shade(0.75D);
/*     */   
/*     */   static {
/*  66 */     D.ts(UIGoodsImport.class);
/*     */   }
/*     */   
/*  69 */   public GETTER.GETTER_IMP<TRADABLE> res = new GETTER.GETTER_IMP(TR.ALL().get(0));
/*     */ 
/*     */   
/*     */   public UIGoodsImport() {
/*  73 */     addDown(12, (RENDEROBJ)amount());
/*  74 */     addDown(12, (RENDEROBJ)priceH());
/*  75 */     addDown(12, (RENDEROBJ)price());
/*  76 */     addDown(12, (RENDEROBJ)credlim());
/*     */ 
/*     */     
/*  79 */     addRelBody(16, DIR.E, (RENDEROBJ)new UIGoodsTraders(6)
/*     */         {
/*     */           protected int price(FactionNPC f)
/*     */           {
/*  83 */             return f.res((TRADABLE)UIGoodsImport.this.res.get()).priceSellP();
/*     */           }
/*     */ 
/*     */           
/*     */           protected int sortValue(FactionNPC f) {
/*  88 */             return f.res((TRADABLE)UIGoodsImport.this.res.get()).priceSellP();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  93 */     addRelBody(8, DIR.S, (RENDEROBJ)problem());
/*     */ 
/*     */     
/*  96 */     GuiSection h = new GuiSection();
/*     */     
/*  98 */     h.add((RENDEROBJ)new HOVERABLE.HoverableAbs(24)
/*     */         {
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */           {
/* 102 */             ((TRADABLE)UIGoodsImport.this.res.get()).icon().render(r, (RECTANGLE)this.body);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 107 */             text.title(((TRADABLE)UIGoodsImport.this.res.get()).name);
/*     */           }
/*     */         });
/* 110 */     h.addRightC(8, (RENDEROBJ)new GHeader(¤¤name));
/* 111 */     addRelBody(8, DIR.N, (RENDEROBJ)h);
/*     */ 
/*     */     
/* 114 */     GuiSection s = new GuiSection();
/*     */     
/* 116 */     GButt.ButtPanel b = new GButt.ButtPanel(¤¤Best)
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */         {
/* 120 */           int i = isActive & (((FACTIONS.player()).trade.pricesBuy.get((MAPPED)UIGoodsImport.this.res.get()) > 0) ? 1 : 0);
/* 121 */           super.render(r, ds, i, isSelected, isHovered);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 126 */           FactionNPC f = best();
/*     */           
/* 128 */           if (f != null) {
/* 129 */             (VIEW.inters()).popup.close();
/* 130 */             (VIEW.UI()).manager.close();
/* 131 */             (VIEW.world()).UI.factions.openBuy(f, (TRADABLE)UIGoodsImport.this.res.get());
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 137 */           super.hoverInfoGet(text);
/* 138 */           GBox b = (GBox)text;
/* 139 */           b.NL(8);
/* 140 */           CharSequence p = FACTIONS.player().buyer((TRADABLE)UIGoodsImport.this.res.get()).problem();
/* 141 */           if (p != null) {
/* 142 */             b.error(p);
/*     */           }
/* 144 */           b.NL();
/*     */           
/* 146 */           FactionNPC f = best();
/*     */           
/* 148 */           if (f != null) {
/* 149 */             b.add((f.banner()).MEDIUM);
/* 150 */             b.textLL((CharSequence)f.name);
/* 151 */             b.add((SPRITE)(UI.icons()).s.money);
/* 152 */             b.add((SPRITE)GFORMAT.i(b.text(), DealParty.manualPriceSell(f, (TRADABLE)UIGoodsImport.this.res.get(), 1)));
/* 153 */             b.NL();
/*     */           } 
/*     */         }
/*     */         
/*     */         private FactionNPC best() {
/* 158 */           FactionNPC f = null;
/* 159 */           int pp = Integer.MAX_VALUE;
/*     */           
/* 161 */           for (int fi = 0; fi < FACTIONS.NPCs().size(); fi++) {
/* 162 */             FactionNPC ff = (FactionNPC)FACTIONS.NPCs().get(fi);
/* 163 */             int p = DealParty.manualPriceSell(ff, (TRADABLE)UIGoodsImport.this.res.get(), 1);
/* 164 */             if (p > 0 && ff.seller((TRADABLE)UIGoodsImport.this.res.get()).removeMax() > 0 && p < pp) {
/* 165 */               pp = p;
/* 166 */               f = ff;
/*     */             } 
/*     */           } 
/* 169 */           return f;
/*     */         }
/*     */       };
/* 172 */     b.hoverInfoSet(¤¤BestD);
/* 173 */     b.icon((SPRITE)(UI.icons()).s.money);
/* 174 */     b.setDim(180);
/* 175 */     s.addRightC(0, (RENDEROBJ)b);
/*     */ 
/*     */ 
/*     */     
/* 179 */     b = new GButt.ButtPanel(¤¤Closest)
/*     */       {
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */         {
/* 184 */           int i = isActive & (((FACTIONS.player()).trade.pricesBuy.get((MAPPED)UIGoodsImport.this.res.get()) > 0) ? 1 : 0);
/* 185 */           super.render(r, ds, i, isSelected, isHovered);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 190 */           FactionNPC f = null;
/* 191 */           int pp = Integer.MAX_VALUE;
/* 192 */           for (Faction fff : DIP.traders()) {
/* 193 */             FactionNPC ff = (FactionNPC)fff;
/* 194 */             int p = RD.DIST().distance((Faction)ff);
/* 195 */             if (ff.res((TRADABLE)UIGoodsImport.this.res.get()).priceSellP() > 0 && ff.seller((TRADABLE)UIGoodsImport.this.res.get()).removeMax() > 0 && p < pp) {
/* 196 */               pp = p;
/* 197 */               f = ff;
/*     */             } 
/*     */           } 
/* 200 */           if (f != null) {
/* 201 */             (VIEW.inters()).popup.close();
/* 202 */             (VIEW.UI()).manager.close();
/* 203 */             (VIEW.world()).UI.factions.openBuy(f, (TRADABLE)UIGoodsImport.this.res.get());
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 209 */           super.hoverInfoGet(text);
/* 210 */           GBox b = (GBox)text;
/* 211 */           b.NL(8);
/* 212 */           CharSequence p = FACTIONS.player().buyer((TRADABLE)UIGoodsImport.this.res.get()).problem();
/* 213 */           if (p != null) {
/* 214 */             b.error(p);
/*     */           }
/*     */         }
/*     */       };
/* 218 */     b.hoverInfoSet(¤¤ClosestD);
/* 219 */     b.icon((SPRITE)(UI.icons()).s.wheel);
/* 220 */     b.setDim(180);
/* 221 */     s.addRightC(0, (RENDEROBJ)b);
/* 222 */     s.addRelBody(10, DIR.N, (RENDEROBJ)new GHeader(UIGoodsExport.¤¤special, (UI.FONT()).S));
/* 223 */     addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private GuiSection priceH() {
/* 235 */     GuiSection s = new GuiSection();
/* 236 */     s.add((RENDEROBJ)priceChart((FACTIONS.player()).trade.pricesBuy, Dic.¤¤buyPrice, (GETTER<TRADABLE>)this.res, 8, 64));
/*     */     
/* 238 */     s.addRelBody(8, DIR.W, (RENDEROBJ)icon((SPRITE)(UI.icons()).m.coins));
/* 239 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static HOVERABLE priceChart(final HistoryTradable hi, CharSequence title, final GETTER<TRADABLE> res, int ww, int height) {
/* 245 */     final int amount = hi.get(0).historyRecords();
/* 246 */     GStaples s = new GStaples(amount, false)
/*     */       {
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */         {
/* 251 */           super.render(r, ds, hoveredIs());
/* 252 */           Str.TMP.clear();
/* 253 */           Str.TMP.add(hi.get((MAPPED)res.get()));
/* 254 */           int w = (UI.FONT()).S.getDim((CharSequence)Str.TMP).x();
/* 255 */           OPACITY.O50.bind();
/* 256 */           COLOR.BLACK.render(r, body().x1(), body().x1() + w + 4, this.body.y1(), this.body.y1() + 18);
/* 257 */           OPACITY.unbind();
/* 258 */           (UI.FONT()).S.render(r, (CharSequence)Str.TMP, body().x1() + 2, this.body.y1() + 1);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected double getValue(int stapleI) {
/* 264 */           double v = hi.history((MAPPED)res.get()).get(amount - 1 - stapleI);
/* 265 */           if (res.get() == null)
/* 266 */             v /= RESOURCES.ALL().size(); 
/* 267 */           return v;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void hover(GBox b, int stapleI) {
/* 272 */           int si = amount - stapleI - 1;
/* 273 */           b.title(Dic.¤¤buyPrice);
/* 274 */           GText t = b.text();
/* 275 */           t.lablify();
/* 276 */           DicTime.setAgo((Str)t, si * (GAME.player().res()).time.bitSeconds());
/* 277 */           b.add((SPRITE)t);
/* 278 */           b.NL(4);
/*     */           
/* 280 */           b.add((SPRITE)GFORMAT.i(b.text(), (long)getValue(stapleI)));
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 285 */     s.body().setWidth((ww * amount)).setHeight(height);
/* 286 */     return (HOVERABLE)s;
/*     */   }
/*     */   
/*     */   private GuiSection price() {
/* 290 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/* 294 */           text.title(PBuyer.¤¤PriceCap);
/* 295 */           text.text(UIGoodsImport.¤¤priceCapD);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 300 */     INT.INTE in = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 304 */           return 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 309 */           return (FACTIONS.player().buyer((TRADABLE)UIGoodsImport.this.res.get())).priceCapsI.max();
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 314 */           return (FACTIONS.player().buyer((TRADABLE)UIGoodsImport.this.res.get())).priceCapsI.get();
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 319 */           (FACTIONS.player().buyer((TRADABLE)UIGoodsImport.this.res.get())).priceCapsI.set(t);
/*     */         }
/*     */       };
/*     */     
/* 323 */     GInputInt sl = new GInputInt(in, true, true);
/*     */     
/* 325 */     s.addRightC(2, (RENDEROBJ)sl);
/*     */     
/* 327 */     s.addRelBody(8, DIR.W, (RENDEROBJ)icon((SPRITE)(UI.icons()).m.coins.twin((SPRITE)(UI.icons()).s.cog, DIR.NE, 2)));
/* 328 */     return s;
/*     */   }
/*     */   
/*     */   private GuiSection credlim() {
/* 332 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/* 336 */           text.title(PBuyer.¤¤TreasuryLim);
/* 337 */           text.text(UIGoodsImport.¤¤minCredsD);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 342 */     INT.INTE in = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 346 */           return 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 351 */           return (FACTIONS.player().buyer((TRADABLE)UIGoodsImport.this.res.get())).minMoney.max();
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 356 */           return (FACTIONS.player().buyer((TRADABLE)UIGoodsImport.this.res.get())).minMoney.get();
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 361 */           (FACTIONS.player().buyer((TRADABLE)UIGoodsImport.this.res.get())).minMoney.set(t);
/*     */         }
/*     */       };
/*     */     
/* 365 */     GInputInt sl = new GInputInt(in, true, true);
/*     */     
/* 367 */     s.addRightC(2, (RENDEROBJ)sl);
/*     */     
/* 369 */     s.addRelBody(8, DIR.W, (RENDEROBJ)icon((SPRITE)(UI.icons()).m.coins.twin((SPRITE)(UI.icons()).s.arrowUp, DIR.NE, 2)));
/* 370 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   private GuiSection amount() {
/* 375 */     INT.INTE limit = new INT.INTE()
/*     */       {
/*     */         public int get()
/*     */         {
/* 379 */           return (FACTIONS.player().buyer((TRADABLE)UIGoodsImport.this.res.get())).limit.get();
/*     */         }
/*     */ 
/*     */         
/*     */         public int min() {
/* 384 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 389 */           return (FACTIONS.player().buyer((TRADABLE)UIGoodsImport.this.res.get())).limit.max();
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 394 */           (FACTIONS.player().buyer((TRADABLE)UIGoodsImport.this.res.get())).limit.set(t);
/*     */         }
/*     */       };
/* 397 */     final GSliderInt sl = new GSliderInt(limit, 200, true, true)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/*     */         protected void renderMidColor(SPRITE_RENDERER r, int x1, int width, int widthFull, int y1, int y2)
/*     */         {
/* 404 */           COLOR col = (width != widthFull) ? UIGoodsImport.colorDark : UIGoodsImport.color;
/* 405 */           col.render(r, x1, x1 + width, y1, y2);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 410 */           GBox b = (GBox)text;
/* 411 */           b.title(Dic.¤¤ImportLevel);
/*     */ 
/*     */           
/* 414 */           b.NL(4);
/*     */           
/* 416 */           FACTIONS.player().buyer((TRADABLE)UIGoodsImport.this.res.get()).hoverCapacity(b);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 421 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/* 425 */           sl.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */     
/* 429 */     s.add((RENDEROBJ)sl);
/*     */ 
/*     */     
/* 432 */     s.addDown(0, (RENDEROBJ)new HOVERABLE.HoverableAbs(300, 24)
/*     */         {
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */           {
/* 436 */             double cap = ((TRADABLE)UIGoodsImport.this.res.get()).pb().capacityValue();
/* 437 */             GMeter.render(r, GMeter.C_ORANGE, cap, (RECTANGLE)body());
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 442 */     s.addRelBody(8, DIR.W, (RENDEROBJ)icon((SPRITE)(UI.icons()).m.cog_big));
/*     */     
/* 444 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private HOVERABLE problem() {
/* 520 */     GuiSection s = new GuiSection();
/* 521 */     s.add((RENDEROBJ)new HOVERABLE.HoverableAbs(550, 80)
/*     */         {
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */           {
/* 525 */             GCOLOR.UI().bg().render(r, (RECTANGLE)this.body);
/* 526 */             GCOLOR.UI().borderH(r, (RECTANGLE)this.body, 0);
/*     */             
/* 528 */             CharSequence p = FACTIONS.player().buyer((TRADABLE)UIGoodsImport.this.res.get()).problem();
/*     */             
/* 530 */             if (p != null) {
/* 531 */               (GCOLOR.UI()).BAD.hovered.bind();
/* 532 */               (UI.FONT()).S.render(r, p, body().x1() + 8, body().y1() + 8, body().width() - 16, 1.0D);
/* 533 */               COLOR.unbind();
/*     */             }
/*     */             else {
/*     */               
/* 537 */               p = FACTIONS.player().buyer((TRADABLE)UIGoodsImport.this.res.get()).warning();
/* 538 */               (GCOLOR.UI()).SOSO.hovered.bind();
/* 539 */               if (p != null)
/* 540 */                 (UI.FONT()).S.render(r, p, body().x1() + 8, body().y1() + 8, body().width() - 16, 1.0D); 
/* 541 */               COLOR.unbind();
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 547 */     s.hoverInfoSet(Dic.¤¤Problem);
/* 548 */     return (HOVERABLE)s;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static HOVERABLE icon(final SPRITE icon) {
/* 554 */     return (HOVERABLE)new HOVERABLE.HoverableAbs(32, 32)
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */         {
/* 558 */           icon.renderC(r, (RECTANGLE)body());
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static RENDEROBJ miniControl(final TRADABLE res, final UIGoodsImport setting) {
/* 566 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/* 570 */           FACTIONS.player().buyer(res).hover(text);
/* 571 */           text.title(UIGoodsImport.¤¤name);
/*     */         }
/*     */       };
/*     */     
/* 575 */     GButt.ButtPanel b = new GButt.ButtPanel((SPRITE)(UI.icons()).s.cog)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 579 */           setting.res.set(res);
/* 580 */           (VIEW.inters()).popup.show((RENDEROBJ)setting, (CLICKABLE)this);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 586 */           super.render(r, ds, isActive, isSelected, isHovered);
/*     */         }
/*     */       };
/*     */     
/* 590 */     b.setDim(48, 48);
/*     */     
/* 592 */     s.addRelBody(0, DIR.E, (RENDEROBJ)b);
/*     */     
/* 594 */     HOVERABLE.HoverableAbs hoverableAbs = new HOVERABLE.HoverableAbs(48, 14)
/*     */       {
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */         {
/* 600 */           double cap = res.pb().capacityValue();
/* 601 */           GMeter.render(r, GMeter.C_ORANGE, cap, (RECTANGLE)body());
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 609 */     s.addRelBody(0, DIR.S, (RENDEROBJ)hoverableAbs);
/*     */     
/* 611 */     RENDEROBJ.RenderImp renderImp = new RENDEROBJ.RenderImp(s.body().width(), s.body().height())
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 615 */           if (FACTIONS.player().buyer(res).importing()) {
/* 616 */             if (FACTIONS.player().buyer(res).problem() != null) {
/* 617 */               (GCOLOR.UI()).BAD.hovered.bind();
/* 618 */               (UI.icons()).s.alert.renderC(r, body().x2() - 8, body().y1());
/* 619 */             } else if (FACTIONS.player().buyer(res).warning() != null) {
/* 620 */               (GCOLOR.UI()).SOSO.hovered.bind();
/* 621 */               (UI.icons()).s.alert.renderC(r, body().x2() - 8, body().y1());
/*     */             } 
/* 623 */             COLOR.unbind();
/*     */           } else {
/* 625 */             OPACITY.O75.bind();
/* 626 */             COLOR.BLACK.render(r, (RECTANGLE)this.body);
/* 627 */             OPACITY.unbind();
/*     */           } 
/*     */         }
/*     */       };
/* 631 */     renderImp.body().centerIn((BODY_HOLDER)s);
/* 632 */     s.add((RENDEROBJ)renderImp);
/*     */     
/* 634 */     return (RENDEROBJ)s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\goods\UIGoodsImport.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */