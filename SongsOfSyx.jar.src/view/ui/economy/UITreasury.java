/*     */ package view.ui.economy;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.common.UIPickerRace;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.ui.goods.UIGoodsExport;
/*     */ import view.ui.goods.UIGoodsImport;
/*     */ import view.ui.manage.IFullView;
/*     */ 
/*     */ public final class UITreasury extends IFullView {
/*  40 */   private static CharSequence ¤¤unused = "Show resources not actively traded";
/*  41 */   private static CharSequence ¤¤import = "Show resources that are imported.";
/*  42 */   private static CharSequence ¤¤export = "Show resources that are exported.";
/*  43 */   private static CharSequence ¤¤economy = "Economy & Trade";
/*  44 */   private static CharSequence ¤¤priceDesc = "The average global price, the total production rate without boosts, and the price multiplied with the production rate. This might give you a sense of what industries are profitable for you. The last two columns shows your current average bonus of selected race.";
/*     */   
/*     */   private GScrollRows ta;
/*     */   
/*     */   static {
/*  49 */     D.ts(UITreasury.class);
/*     */   }
/*     */   
/*     */   public UITreasury() {
/*  53 */     super(¤¤economy, (SPRITE)(UI.icons()).l.coin);
/*     */     
/*  55 */     this.section.body().setWidth(WIDTH).setHeight(1.0D);
/*  56 */     final INT.IntImp ii = new INT.IntImp();
/*  57 */     final GETTER.GETTER_IMP<TRADABLE> gres = new GETTER.GETTER_IMP();
/*     */ 
/*     */     
/*  60 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public boolean hover(COORDINATE mCoo)
/*     */         {
/*  64 */           ii.set(-1);
/*  65 */           gres.set(null);
/*  66 */           return super.hover(mCoo);
/*     */         }
/*     */       };
/*     */     
/*  70 */     s.addDownC(0, (RENDEROBJ)new MainChart(HEIGHT, ii, 10));
/*     */     
/*  72 */     s.addRight(32, (RENDEROBJ)new MainDetails(ii));
/*     */     
/*  74 */     GuiSection f = new GuiSection();
/*     */     
/*  76 */     GButt.ButtPanel oo = (new GButt.ButtPanel((UI.icons()).m.coins.resized(32)) {
/*  77 */         GuiSection s = new UITreasury.Prices();
/*     */ 
/*     */         
/*     */         protected void clickA() {
/*  81 */           (VIEW.inters()).popup.show((RENDEROBJ)this.s, (CLICKABLE)this);
/*     */         }
/*  83 */       }).pad(2, 4);
/*  84 */     f.addDown(0, (RENDEROBJ)oo);
/*  85 */     final GButt.ButtPanel unused = (new GButt.ButtPanel((UI.icons()).m.questionmark.resized(32))
/*     */       {
/*     */         protected void clickA() {
/*  88 */           selectedToggle();
/*     */         }
/*  90 */       }).pad(2, 4);
/*  91 */     unused.hoverInfoSet(¤¤unused);
/*  92 */     unused.selectedSet(true);
/*  93 */     f.addDown(0, (RENDEROBJ)unused);
/*  94 */     final GButt.ButtPanel impot = (new GButt.ButtPanel((SPRITE)(SETT.ROOMS()).IMPORT.icon)
/*     */       {
/*     */         protected void clickA() {
/*  97 */           selectedToggle();
/*     */         }
/*  99 */       }).pad(2, 4);
/* 100 */     impot.hoverInfoSet(¤¤import);
/* 101 */     impot.selectedSet(true);
/* 102 */     f.addDown(0, (RENDEROBJ)impot);
/* 103 */     final GButt.ButtPanel export = (new GButt.ButtPanel((SPRITE)(SETT.ROOMS()).EXPORT.icon)
/*     */       {
/*     */         protected void clickA() {
/* 106 */           selectedToggle();
/*     */         }
/* 108 */       }).pad(2, 4);
/* 109 */     export.hoverInfoSet(¤¤export);
/* 110 */     export.selectedSet(true);
/* 111 */     f.addDown(0, (RENDEROBJ)export);
/*     */     
/* 113 */     s.add((RENDEROBJ)f, s.body().x2() + 32, s.body().y2() - f.body().height());
/*     */ 
/*     */ 
/*     */     
/* 117 */     UIGoodsImport im = new UIGoodsImport();
/* 118 */     UIGoodsExport ex = new UIGoodsExport(true);
/* 119 */     ArrayList<RENDEROBJ> rows = new ArrayList(TR.ALL().size());
/* 120 */     for (TRADABLE res : TR.ALL()) {
/* 121 */       rows.add(new RRow(res, (INT.INTE)ii, (GETTER.GETTERE<TRADABLE>)gres, 12, im, ex));
/*     */     }
/* 123 */     int height = HEIGHT - s.body().height() - 16;
/* 124 */     height /= ((RENDEROBJ)rows.get(0)).body().height();
/* 125 */     height *= ((RENDEROBJ)rows.get(0)).body().height();
/* 126 */     this.ta = new GScrollRows((Iterable)rows, height)
/*     */       {
/*     */         protected boolean passesFilter(int i, RENDEROBJ o)
/*     */         {
/* 130 */           if (unused.selectedIs())
/* 131 */             return true; 
/* 132 */           TRADABLE res = (TRADABLE)TR.ALL().get(i);
/* 133 */           if (impot.selectedIs() && res.pb().importing())
/* 134 */             return true; 
/* 135 */           if (export.selectedIs() && res.ps().exporting() == null)
/* 136 */             return true; 
/* 137 */           return false;
/*     */         }
/*     */       };
/* 140 */     s.add((RENDEROBJ)this.ta.view(), s.body().x1() - 58, s.body().y2() + 8);
/*     */     
/* 142 */     s.add((RENDEROBJ)new Factions(HEIGHT), s.body().x2() + 16, s.body().y1());
/* 143 */     this.section.addRelBody(16, DIR.S, (RENDEROBJ)s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX box) {
/* 151 */     GBox b = (GBox)box;
/* 152 */     b.title(¤¤economy);
/*     */     
/* 154 */     b.textLL(Dic.¤¤Treasury);
/* 155 */     b.tab(6);
/* 156 */     b.add((SPRITE)GFORMAT.i(b.text(), (long)FACTIONS.player().credits().getD()));
/* 157 */     b.NL();
/*     */     
/* 159 */     for (TRADABLE res : TR.ALL()) {
/* 160 */       if (res.pb().importing()) {
/* 161 */         GText t = b.text();
/* 162 */         CharSequence p = FACTIONS.player().buyer(res).problem();
/* 163 */         if (p != null) {
/* 164 */           b.add(res.icon());
/* 165 */           b.add((SPRITE)t.errorify().add(p));
/* 166 */           b.NL();
/*     */         } else {
/* 168 */           p = FACTIONS.player().buyer(res).warning();
/* 169 */           if (p != null) {
/* 170 */             b.add(res.icon());
/* 171 */             b.add((SPRITE)t.warnify().add(p));
/* 172 */             b.NL();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 177 */       if (res.ps().exporting() == null) {
/* 178 */         GText t = b.text();
/* 179 */         CharSequence p = FACTIONS.player().seller(res).problem();
/*     */ 
/*     */         
/* 182 */         if (p != null) {
/* 183 */           b.add(res.icon());
/* 184 */           b.add((SPRITE)t.errorify().add(p));
/* 185 */           b.NL(); continue;
/*     */         } 
/* 187 */         p = FACTIONS.player().seller(res).warning();
/* 188 */         if (p != null) {
/* 189 */           b.add(res.icon());
/* 190 */           b.add((SPRITE)t.warnify().add(p));
/* 191 */           b.NL();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Prices
/*     */     extends GuiSection
/*     */   {
/*     */     Prices() {
/* 204 */       final UIPickerRace pick = new UIPickerRace();
/* 205 */       pick.set((FACTIONS.player().race()).index);
/*     */       
/* 207 */       GTableBuilder bu = new GTableBuilder()
/*     */         {
/*     */           public int nrOFEntries()
/*     */           {
/* 211 */             return TR.ALL().size();
/*     */           }
/*     */         };
/*     */       
/* 215 */       bu.column("", 24, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(final GETTER<Integer> ier)
/*     */             {
/* 219 */               return (RENDEROBJ)new RENDEROBJ.RenderImp(24)
/*     */                 {
/*     */                   public void render(SPRITE_RENDERER r, float ds)
/*     */                   {
/* 223 */                     ((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue())).icon().render(r, (RECTANGLE)this.body);
/*     */                   }
/*     */                 };
/*     */             }
/*     */           });
/*     */       
/* 229 */       bu.column(Dic.¤¤Price, 120, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(final GETTER<Integer> ier)
/*     */             {
/* 233 */               return (RENDEROBJ)(new GStat()
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 237 */                     GFORMAT.i(text, FACTIONS.PRICE().get((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue())));
/*     */                   }
/* 239 */                 }).r(DIR.NW);
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */       
/* 245 */       bu.column(Dic.¤¤Rate, 120, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(final GETTER<Integer> ier)
/*     */             {
/* 249 */               return (RENDEROBJ)(new GStat()
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 253 */                     GFORMAT.f(text, 1.0D / (SETT.RECIPES()).ratesV.vanillaRate((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue())));
/*     */                   }
/* 255 */                 }).r(DIR.NW);
/*     */             }
/*     */           });
/*     */       
/* 259 */       if ((S.get()).developer) {
/* 260 */         bu.column("dRate", 120, new GTableBuilder.GRowBuilder()
/*     */             {
/*     */               public RENDEROBJ build(final GETTER<Integer> ier)
/*     */               {
/* 264 */                 return (RENDEROBJ)(new GStat()
/*     */                   {
/*     */                     public void update(GText text)
/*     */                     {
/* 268 */                       TRADABLE res = (TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue());
/* 269 */                       double rr = 0.0D;
/* 270 */                       double p = 0.0D;
/* 271 */                       for (FactionNPC f : FACTIONS.NPCs()) {
/* 272 */                         p += f.citizens(null);
/* 273 */                         rr += f.res(res).rateTot() * f.citizens(null);
/*     */                       } 
/* 275 */                       rr /= p;
/* 276 */                       double r = (SETT.RECIPES()).ratesV.vanillaRate(res) / 1.0D / rr;
/* 277 */                       GFORMAT.f(text, r);
/*     */                     }
/* 279 */                   }).r(DIR.NW);
/*     */               }
/*     */             });
/*     */       }
/*     */       
/* 284 */       bu.column(String.valueOf(Dic.¤¤Rate) + " x " + String.valueOf(Dic.¤¤Rate), 120, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(final GETTER<Integer> ier)
/*     */             {
/* 288 */               return (RENDEROBJ)(new GStat()
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 292 */                     GFORMAT.f(text, FACTIONS.PRICE().get((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue())) / (SETT.RECIPES()).ratesV.vanillaRate((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue())));
/*     */                   }
/* 294 */                 }).r(DIR.NW);
/*     */             }
/*     */           });
/*     */       
/* 298 */       bu.column(String.valueOf(Dic.¤¤Rate) + "*", 120, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(final GETTER<Integer> ier)
/*     */             {
/* 302 */               return (RENDEROBJ)(new GStat()
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 306 */                     GFORMAT.f(text, 1.0D / (SETT.RECIPES()).rates.rateTotal((BOOSTABLE_O)HCLASS_RACE.clP(pick.race()), (TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue())));
/*     */                   }
/* 308 */                 }).r(DIR.NW);
/*     */             }
/*     */           });
/*     */       
/* 312 */       bu.column(String.valueOf(Dic.¤¤Rate) + " x " + String.valueOf(Dic.¤¤Rate) + "*", 120, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(final GETTER<Integer> ier)
/*     */             {
/* 316 */               return (RENDEROBJ)(new GStat()
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 320 */                     GFORMAT.f(text, FACTIONS.PRICE().get((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue())) / (SETT.RECIPES()).rates.rateTotal((BOOSTABLE_O)HCLASS_RACE.clP(pick.race()), (TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue())));
/*     */                   }
/* 322 */                 }).r(DIR.NW);
/*     */             }
/*     */           });
/*     */       
/* 326 */       add((RENDEROBJ)bu.create(16, true));
/*     */       
/* 328 */       addRelBody(16, DIR.N, (RENDEROBJ)pick.section);
/*     */       
/* 330 */       GText t = new GText((UI.FONT()).S, UITreasury.¤¤priceDesc);
/* 331 */       t.setMaxWidth(400);
/* 332 */       t.setMultipleLines(true);
/*     */ 
/*     */ 
/*     */       
/* 336 */       addRelBody(4, DIR.N, (SPRITE)t);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\economy\UITreasury.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */