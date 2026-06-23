/*     */ package view.ui.goods;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.deal.DealParty;
/*     */ import game.faction.npc.FactionNPC;
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
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GInputInt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import world.region.RD;
/*     */ 
/*     */ public class UIGoodsExport extends GuiSection {
/*  41 */   static CharSequence ¤¤name = "Export Settings";
/*  42 */   static CharSequence ¤¤special = "Special Orders";
/*     */   
/*  44 */   private static CharSequence ¤¤priceCapD = "¤The minimum price you are willing to sell this resource for.";
/*     */   
/*  46 */   public static final COLOR color = (COLOR)new ColorImp(100, 90, 70);
/*     */   
/*     */   static {
/*  49 */     D.ts(UIGoodsExport.class);
/*     */   }
/*     */   
/*  52 */   public GETTER.GETTER_IMP<TRADABLE> res = new GETTER.GETTER_IMP(TR.ALL().get(0));
/*     */ 
/*     */   
/*     */   public UIGoodsExport(boolean title) {
/*  56 */     addDown(6, (RENDEROBJ)amount());
/*  57 */     addDown(6, (RENDEROBJ)priceH());
/*  58 */     addDown(6, (RENDEROBJ)price());
/*     */ 
/*     */     
/*  61 */     addRelBody(16, DIR.E, (RENDEROBJ)new UIGoodsTraders(6)
/*     */         {
/*     */           protected int price(FactionNPC f)
/*     */           {
/*  65 */             return f.res((TRADABLE)UIGoodsExport.this.res.get()).priceBuyP();
/*     */           }
/*     */ 
/*     */           
/*     */           protected int sortValue(FactionNPC f) {
/*  70 */             return -f.res((TRADABLE)UIGoodsExport.this.res.get()).priceBuyP();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  75 */     addRelBody(8, DIR.S, (RENDEROBJ)problem());
/*     */     
/*  77 */     if (title) {
/*  78 */       GuiSection h = new GuiSection();
/*     */       
/*  80 */       h.add((RENDEROBJ)new HOVERABLE.HoverableAbs(24)
/*     */           {
/*     */             protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */             {
/*  84 */               ((TRADABLE)UIGoodsExport.this.res.get()).icon().render(r, (RECTANGLE)this.body);
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/*  89 */               text.title(((TRADABLE)UIGoodsExport.this.res.get()).name);
/*     */             }
/*     */           });
/*  92 */       h.addRightC(8, (RENDEROBJ)new GHeader(¤¤name));
/*  93 */       addRelBody(8, DIR.N, (RENDEROBJ)h);
/*     */     } 
/*     */ 
/*     */     
/*  97 */     GuiSection s = new GuiSection();
/*     */     
/*  99 */     GButt.ButtPanel b = new GButt.ButtPanel(UIGoodsImport.¤¤Best)
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */         {
/* 103 */           int i = isActive & (((FACTIONS.player()).trade.pricesSell.get((MAPPED)UIGoodsExport.this.res.get()) > 0 && ((TRADABLE)UIGoodsExport.this.res.get()).ps().playerOwned() > 0) ? 1 : 0);
/* 104 */           super.render(r, ds, i, isSelected, isHovered);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 109 */           FactionNPC f = best();
/*     */           
/* 111 */           if (f != null) {
/* 112 */             (VIEW.inters()).popup.close();
/* 113 */             (VIEW.UI()).manager.close();
/* 114 */             (VIEW.world()).UI.factions.openSell(f, (TRADABLE)UIGoodsExport.this.res.get());
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 120 */           super.hoverInfoGet(text);
/* 121 */           GBox b = (GBox)text;
/* 122 */           b.NL(8);
/* 123 */           CharSequence p = FACTIONS.player().seller((TRADABLE)UIGoodsExport.this.res.get()).problem();
/* 124 */           if (p != null)
/* 125 */             b.error(p); 
/* 126 */           b.NL();
/* 127 */           FactionNPC f = best();
/*     */           
/* 129 */           if (f != null) {
/* 130 */             b.add((f.banner()).MEDIUM);
/* 131 */             b.textLL((CharSequence)f.name);
/* 132 */             b.add((SPRITE)(UI.icons()).s.money);
/* 133 */             b.add((SPRITE)GFORMAT.i(b.text(), DealParty.manualPriceBuy(f, (TRADABLE)UIGoodsExport.this.res.get(), 1)));
/* 134 */             b.NL();
/*     */           } 
/*     */         }
/*     */         
/*     */         private FactionNPC best() {
/* 139 */           FactionNPC f = null;
/* 140 */           int pp = 0;
/*     */           
/* 142 */           for (int fi = 0; fi < FACTIONS.NPCs().size(); fi++) {
/* 143 */             FactionNPC ff = (FactionNPC)FACTIONS.NPCs().get(fi);
/* 144 */             int p = DealParty.manualPriceBuy(ff, (TRADABLE)UIGoodsExport.this.res.get(), 1);
/* 145 */             if (p > 0 && p > pp) {
/* 146 */               pp = p;
/* 147 */               f = ff;
/*     */             } 
/*     */           } 
/* 150 */           return f;
/*     */         }
/*     */       };
/* 153 */     b.hoverInfoSet(UIGoodsImport.¤¤BestD);
/* 154 */     b.icon((SPRITE)(UI.icons()).s.money);
/* 155 */     b.setDim(180);
/* 156 */     s.addRightC(0, (RENDEROBJ)b);
/*     */     
/* 158 */     b = new GButt.ButtPanel(UIGoodsImport.¤¤Closest)
/*     */       {
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */         {
/* 163 */           int i = isActive & (((FACTIONS.player()).trade.pricesSell.get((MAPPED)UIGoodsExport.this.res.get()) > 0 && ((TRADABLE)UIGoodsExport.this.res.get()).ps().playerOwned() > 0) ? 1 : 0);
/* 164 */           super.render(r, ds, i, isSelected, isHovered);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 169 */           FactionNPC f = null;
/* 170 */           int pp = Integer.MAX_VALUE;
/* 171 */           for (Faction fff : DIP.traders()) {
/* 172 */             FactionNPC ff = (FactionNPC)fff;
/* 173 */             int p = RD.DIST().distance((Faction)ff);
/* 174 */             if (ff.res((TRADABLE)UIGoodsExport.this.res.get()).priceSellP() > 0 && p < pp) {
/* 175 */               pp = p;
/* 176 */               f = ff;
/*     */             } 
/*     */           } 
/* 179 */           if (f != null) {
/* 180 */             (VIEW.inters()).popup.close();
/* 181 */             (VIEW.UI()).manager.close();
/* 182 */             (VIEW.world()).UI.factions.openSell(f, (TRADABLE)UIGoodsExport.this.res.get());
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 188 */           super.hoverInfoGet(text);
/* 189 */           GBox b = (GBox)text;
/* 190 */           b.NL(8);
/* 191 */           CharSequence p = FACTIONS.player().seller((TRADABLE)UIGoodsExport.this.res.get()).problem();
/* 192 */           if (p != null) {
/* 193 */             b.error(p);
/*     */           }
/*     */         }
/*     */       };
/* 197 */     b.hoverInfoSet(UIGoodsImport.¤¤ClosestD);
/* 198 */     b.icon((SPRITE)(UI.icons()).s.wheel);
/* 199 */     b.setDim(180);
/* 200 */     s.addRightC(0, (RENDEROBJ)b);
/*     */     
/* 202 */     addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RENDEROBJ mini(final TRADABLE res, final UIGoodsExport export) {
/* 213 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/* 217 */           FACTIONS.player().seller(res).hover(text);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 222 */     GETTER.GETTER_IMP<TRADABLE> get = new GETTER.GETTER_IMP(res);
/*     */     
/* 224 */     GButt.ButtPanel b = new GButt.ButtPanel((SPRITE)(UI.icons()).s.cog)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 228 */           export.res.set(res);
/* 229 */           (VIEW.inters()).popup.show((RENDEROBJ)export, (CLICKABLE)this);
/*     */         }
/*     */       };
/* 232 */     b.setDim(48, 48);
/*     */     
/* 234 */     s.addRelBody(0, DIR.E, (RENDEROBJ)b);
/* 235 */     s.addRelBody(0, DIR.S, (RENDEROBJ)capBar((GETTER<TRADABLE>)get, 48, 14));
/*     */ 
/*     */     
/* 238 */     RENDEROBJ.RenderImp renderImp = new RENDEROBJ.RenderImp(s.body().width(), s.body().height())
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 242 */           if (res.ps().exporting() != null) {
/* 243 */             OPACITY.O50.bind();
/* 244 */             COLOR.BLACK.render(r, (RECTANGLE)this.body);
/* 245 */             OPACITY.unbind();
/*     */           } else {
/* 247 */             if (FACTIONS.player().seller(res).problem() != null) {
/* 248 */               (GCOLOR.UI()).BAD.hovered.bind();
/* 249 */               (UI.icons()).s.alert.renderC(r, body().x2() - 8, body().y1());
/* 250 */             } else if (FACTIONS.player().seller(res).warning() != null) {
/* 251 */               (GCOLOR.UI()).SOSO.hovered.bind();
/* 252 */               (UI.icons()).s.alert.renderC(r, body().x2() - 8, body().y1());
/*     */             } 
/* 254 */             COLOR.unbind();
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 259 */     renderImp.body().centerIn((BODY_HOLDER)s);
/* 260 */     s.add((RENDEROBJ)renderImp);
/*     */ 
/*     */     
/* 263 */     return (RENDEROBJ)s;
/*     */   }
/*     */ 
/*     */   
/*     */   private GuiSection priceH() {
/* 268 */     GuiSection s = new GuiSection();
/* 269 */     s.add((RENDEROBJ)UIGoodsImport.priceChart((FACTIONS.player()).trade.pricesSell, Dic.¤¤sellPrice, (GETTER<TRADABLE>)this.res, 8, 64));
/*     */     
/* 271 */     s.addRelBody(8, DIR.W, (RENDEROBJ)icon((SPRITE)(UI.icons()).m.coins));
/* 272 */     return s;
/*     */   }
/*     */   
/*     */   private GuiSection price() {
/* 276 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/* 280 */           text.title(PBuyer.¤¤PriceCap);
/* 281 */           text.text(UIGoodsExport.¤¤priceCapD);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 286 */     INT.INTE in = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 290 */           return 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 295 */           return (FACTIONS.player().seller((TRADABLE)UIGoodsExport.this.res.get())).priceCapsI.max();
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 300 */           return (FACTIONS.player().seller((TRADABLE)UIGoodsExport.this.res.get())).priceCapsI.get();
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 305 */           (FACTIONS.player().seller((TRADABLE)UIGoodsExport.this.res.get())).priceCapsI.set(t);
/*     */         }
/*     */       };
/*     */     
/* 309 */     GInputInt sl = new GInputInt(in, true, true);
/*     */     
/* 311 */     s.addRightC(2, (RENDEROBJ)sl);
/*     */     
/* 313 */     s.addRelBody(8, DIR.W, (RENDEROBJ)icon((SPRITE)(UI.icons()).m.coins.twin((SPRITE)(UI.icons()).s.arrowUp, DIR.NE, 2)));
/* 314 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   private GuiSection amount() {
/* 319 */     GuiSection sl = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 322 */           FACTIONS.player().seller((TRADABLE)UIGoodsExport.this.res.get()).hoverCapacity(text);
/*     */         }
/*     */       };
/*     */     
/* 326 */     INT.INTE in = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 330 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 335 */           return (FACTIONS.player().seller((TRADABLE)UIGoodsExport.this.res.get())).limit.max();
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 340 */           return (FACTIONS.player().seller((TRADABLE)UIGoodsExport.this.res.get())).limit.get();
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 345 */           (FACTIONS.player().seller((TRADABLE)UIGoodsExport.this.res.get())).limit.set(t);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 350 */     sl.add((RENDEROBJ)new GSliderInt(in, 200, true, true));
/* 351 */     sl.addDown(0, (RENDEROBJ)new HOVERABLE.HoverableAbs(300, 24)
/*     */         {
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */           {
/* 355 */             double cap = ((TRADABLE)UIGoodsExport.this.res.get()).ps().capacityValue();
/* 356 */             GMeter.render(r, GMeter.C_ORANGE, cap, (RECTANGLE)body());
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 361 */     sl.addRelBody(12, DIR.W, (SPRITE)(UI.icons()).m.cog_big);
/*     */     
/* 363 */     return sl;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static HOVERABLE capBar(final GETTER<TRADABLE> res, int width, int height) {
/* 450 */     return (HOVERABLE)new HOVERABLE.HoverableAbs(width, height)
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */         {
/* 454 */           double cap = ((TRADABLE)res.get()).ps().capacityValue();
/* 455 */           GMeter.render(r, GMeter.C_ORANGE, cap, (RECTANGLE)body());
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private HOVERABLE problem() {
/* 464 */     GuiSection s = new GuiSection();
/* 465 */     s.add((RENDEROBJ)new HOVERABLE.HoverableAbs(564, 80)
/*     */         {
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */           {
/* 469 */             GCOLOR.UI().bg().render(r, (RECTANGLE)this.body);
/* 470 */             GCOLOR.UI().borderH(r, (RECTANGLE)this.body, 0);
/*     */             
/* 472 */             CharSequence p = FACTIONS.player().seller((TRADABLE)UIGoodsExport.this.res.get()).problem();
/*     */             
/* 474 */             if (p != null) {
/* 475 */               (GCOLOR.UI()).BAD.hovered.bind();
/* 476 */               (UI.FONT()).S.render(r, p, body().x1() + 8, body().y1() + 8, body().width() - 16, 1.0D);
/* 477 */               COLOR.unbind();
/*     */             }
/*     */             else {
/*     */               
/* 481 */               p = FACTIONS.player().seller((TRADABLE)UIGoodsExport.this.res.get()).warning();
/* 482 */               (GCOLOR.UI()).SOSO.hovered.bind();
/* 483 */               if (p != null)
/* 484 */                 (UI.FONT()).S.render(r, p, body().x1() + 8, body().y1() + 8, body().width() - 16, 1.0D); 
/* 485 */               COLOR.unbind();
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 491 */     s.hoverInfoSet(Dic.¤¤Problem);
/* 492 */     return (HOVERABLE)s;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static HOVERABLE icon(final SPRITE icon) {
/* 498 */     return (HOVERABLE)new HOVERABLE.HoverableAbs(32, 32)
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */         {
/* 502 */           icon.renderC(r, (RECTANGLE)body());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\goods\UIGoodsExport.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */