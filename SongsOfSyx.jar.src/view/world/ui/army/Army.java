/*     */ package view.world.ui.army;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.SPRITES;
/*     */ import java.util.Arrays;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.common.UIPickerArmy;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.army.UIArmyCitySendOut;
/*     */ import view.ui.div.UIDivBannerEditor;
/*     */ import view.ui.div.UIDivEditor;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.army.ADDiv;
/*     */ import world.army.ADStats;
/*     */ import world.army.ADSupplies;
/*     */ import world.army.WDIV;
/*     */ import world.army.WDivRegional;
/*     */ import world.entity.army.WArmy;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ final class Army extends ISidePanel {
/*  59 */   private boolean[] selected = new boolean[(Config.battle()).DIVISIONS_PER_ARMY]; static WArmy army;
/*     */   private Button clicked;
/*     */   private boolean dragging;
/*  62 */   private ToolMove tool = new ToolMove(); private int selectedAm;
/*     */   
/*  64 */   private UIDivBannerEditor banner = new UIDivBannerEditor()
/*     */     {
/*     */       public void bannerISet(int bi)
/*     */       {
/*  68 */         super.bannerISet(bi);
/*  69 */         for (int i = 0; i < Army.this.selected.length; i++) {
/*  70 */           if (Army.this.selected[i] && 
/*  71 */             Army.army != null && Army.army.divs() != null && Army.army.divs().get(i) != null)
/*     */           {
/*  73 */             Army.army.divs().get(i).bannerSet(bi);
/*     */           }
/*     */         } 
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  80 */   private static CharSequence ¤¤RecruitD = "Recruit the local soldiers. These use up the conscripts pool of your realm, and once trained they will need to be supplied with resources from your capital through the 'military supply depot'.";
/*  81 */   private static CharSequence ¤¤RecruitDProb = "No conscripts are available in your realm.";
/*  82 */   private static CharSequence ¤¤RecruitSettD = "Have your city troops join this army.";
/*  83 */   private static CharSequence ¤¤DisbandArmy = "Disband entire army.";
/*  84 */   private static CharSequence ¤¤Sure = "Are you sure you wish to:";
/*  85 */   private static CharSequence ¤¤DisbandDiv = "Disband {0} divisions?";
/*     */   
/*  87 */   private final StringInputSprite name = new StringInputSprite(20, (UI.FONT()).H2)
/*     */     {
/*     */       protected void change() {
/*  90 */         Army.army.name.clear().add((CharSequence)text());
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public Army() {
/*  96 */     D.t(this);
/*  97 */     titleSet(Dic.¤¤Army);
/*     */     
/*  99 */     GETTER<WArmy> gg = new GETTER<WArmy>()
/*     */       {
/*     */         public WArmy get()
/*     */         {
/* 103 */           return Army.army;
/*     */         }
/*     */       };
/*     */     
/* 107 */     this.section = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 111 */           Army.this.selectedAm = 0; byte b; int i; boolean[] arrayOfBoolean;
/* 112 */           for (i = (arrayOfBoolean = Army.this.selected).length, b = 0; b < i; ) { boolean s = arrayOfBoolean[b];
/* 113 */             if (s)
/* 114 */               Army.this.selectedAm++;  b++; }
/*     */           
/* 116 */           super.render(r, ds);
/*     */           
/* 118 */           Army.this.dragging &= MButt.LEFT.isDown();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 124 */     this.section.add((RENDEROBJ)new GInput(this.name));
/*     */ 
/*     */     
/* 127 */     ADStats.ADStat[] sss = {
/* 128 */         (AD.stats()).wins, (AD.stats()).defeats, (AD.stats()).kills, (AD.stats()).losses, (AD.stats()).siegeWon
/*     */       };
/*     */     
/* 131 */     GuiSection sec = new GuiSection();
/* 132 */     int j = 0; byte b; int k; ADStats.ADStat[] arrayOfADStat1;
/* 133 */     for (k = (arrayOfADStat1 = sss).length, b = 0; b < k; ) { final ADStats.ADStat s = arrayOfADStat1[b];
/* 134 */       HOVERABLE hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text) {
/* 137 */             GFORMAT.iIncr(text, s.a().get(Army.army));
/*     */           }
/* 139 */         }).hh(aDStat.name, 180).hoverInfoSet(aDStat.desc);
/* 140 */       sec.addGridD((RENDEROBJ)hOVERABLE, j++, 2, this.section.body().width() / 2, 18, DIR.NW); b++; }
/*     */     
/* 142 */     sec.body().setWidth(this.section.body().width());
/* 143 */     this.section.addRelBody(4, DIR.S, (RENDEROBJ)sec);
/*     */     
/* 145 */     this.section.addRelBody(4, DIR.S, (SPRITE)new SPRITE.Imp(this.section.body().width(), 2)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 149 */             GCOLOR.UI().border().render(r, X1, X2, Y1, Y2 - 1);
/* 150 */             ColorImp.TMP.set(GCOLOR.UI().border()).shadeSelf(0.75D).render(r, X1, X2, Y2 - 1, Y2);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 157 */     GuiSection s = new GuiSection();
/* 158 */     s.add((RENDEROBJ)ArmyInfo.info(gg));
/*     */ 
/*     */ 
/*     */     
/* 162 */     s.addRelBody(8, DIR.S, (RENDEROBJ)ArmyInfo.supplies(gg));
/*     */     
/* 164 */     GuiSection guiSection1 = new GuiSection();
/* 165 */     guiSection1.add((RENDEROBJ)(new GButt.ButtPanel((SPRITE)new SPRITE.Twin((SPRITE)(SPRITES.icons()).m.crossair, (SPRITE)(SPRITES.icons()).m.anti))
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 169 */             Army.army.stop();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 174 */             activeSet(Army.army.path().moving(Army.army.body()));
/*     */           }
/* 177 */         }).pad(6, 2).hoverTitleSet(Dic.¤¤Stop));
/*     */     
/* 179 */     guiSection1.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.rebellion)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 183 */             Army.army.raid(!Army.army.raiding());
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 188 */             activeSet(Army.army.canRaid());
/* 189 */             selectedSet(Army.army.raiding());
/*     */           }
/* 192 */         }).pad(6, 2).hoverTitleSet(Dic.¤¤Raiding).hoverInfoSet(Dic.¤¤RaidingD));
/*     */     
/* 194 */     guiSection1.add((RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.cancel)
/*     */         {
/* 196 */           ACTION a = new ACTION()
/*     */             {
/*     */               public void exe()
/*     */               {
/* 200 */                 Army.army.disband();
/* 201 */                 Army.null.access$0(Army.null.this).last().remove(Army.null.access$0(Army.null.this));
/*     */               }
/*     */             };
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 207 */             Str.TMP.clear().add(Army.¤¤Sure).s().add(Army.¤¤DisbandArmy);
/* 208 */             (VIEW.inters()).yesNo.activate((CharSequence)Str.TMP, this.a, ACTION.NOP, true);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 213 */             activeSet((AD.menTarget(null).get(Army.army) == 0));
/*     */           }
/* 216 */         }).pad(6, 2).hoverTitleSet(Dic.¤¤Disband).hoverInfoSet(¤¤DisbandArmy), 0, guiSection1.body().y2());
/*     */     
/* 218 */     s.addRelBody(16, DIR.E, (RENDEROBJ)guiSection1);
/* 219 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 226 */     GuiSection ss = new GuiSection();
/* 227 */     int gi = 0;
/* 228 */     for (ADSupplies.ADArtillery a : AD.supplies().arts()) {
/* 229 */       INT.INTE ii = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/* 233 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 238 */             return a.target.max(Army.army);
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 243 */             return a.target.get(Army.army);
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 248 */             a.target.set(Army.army, t);
/*     */           }
/*     */         };
/* 251 */       GuiSection guiSection = new GuiSection()
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 255 */             super.hoverInfoGet(text);
/* 256 */             if (text.emptyIs()) {
/* 257 */               GBox b = (GBox)text;
/* 258 */               b.title(a.art.info.names);
/* 259 */               b.text(a.art.info.desc);
/* 260 */               b.NL();
/* 261 */               for (int i = 0; i < a.art.constructor().resources(); i++) {
/* 262 */                 RESOURCE res = a.art.constructor().resource(i);
/* 263 */                 int am = (int)Math.ceil(a.art.constructor().item(1).cost2(i, a.art.upgrades().max()));
/* 264 */                 b.add((SPRITE)res.icon());
/* 265 */                 b.add((SPRITE)GFORMAT.iIncr(b.text(), -am));
/* 266 */                 b.NL();
/*     */               } 
/* 268 */               b.NL();
/* 269 */               a.art.projectile.hover((GUI_BOX)b, Army.this.title, 1.0D, 0);
/*     */             } 
/*     */           }
/*     */         };
/*     */       
/* 274 */       guiSection.add((SPRITE)a.art.iconBig(), 0, 0);
/* 275 */       GSliderInt in = new GSliderInt(ii, 120, true);
/* 276 */       guiSection.addRight(8, (RENDEROBJ)in);
/* 277 */       ss.addGridD((RENDEROBJ)guiSection, gi++, 4, 220, 48, DIR.NW);
/*     */     } 
/* 279 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)ss);
/*     */ 
/*     */ 
/*     */     
/* 283 */     this.section.addRelBody(4, DIR.S, (SPRITE)new SPRITE.Imp(this.section.body().width(), 2)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 287 */             GCOLOR.UI().border().render(r, X1, X2, Y1, Y2 - 1);
/* 288 */             ColorImp.TMP.set(GCOLOR.UI().border()).shadeSelf(0.75D).render(r, X1, X2, Y2 - 1, Y2);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 294 */     ss = new GuiSection();
/*     */     
/* 296 */     ColorImp colorImp = COLOR.ORANGE100.makeSaturated(0.25D);
/*     */     
/* 298 */     ss.add((RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.for_muster)
/*     */         {
/* 300 */           private ArmyRecruit s = new ArmyRecruit();
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 304 */             (VIEW.inters()).popup.push((RENDEROBJ)this.s, (CLICKABLE)this);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 309 */             GBox b = (GBox)text;
/* 310 */             b.title(Dic.¤¤Recruit);
/* 311 */             b.text(Army.¤¤RecruitD);
/* 312 */             b.NL(8);
/*     */             
/* 314 */             if (AD.conscripts().available(null).get(FACTIONS.player()) <= 0) {
/* 315 */               b.error(Army.¤¤RecruitDProb);
/* 316 */               b.NL(8);
/*     */             } 
/*     */             
/* 319 */             for (RDRace r : (RD.RACES()).all) {
/* 320 */               b.add((SPRITE)(r.race.appearance()).icon);
/* 321 */               b.add((SPRITE)GFORMAT.iIncr(b.text(), AD.conscripts().available(r.race).get(FACTIONS.player())));
/* 322 */               b.NL();
/*     */             
/*     */             }
/*     */           
/*     */           }
/* 327 */         }).bg((COLOR)colorImp).pad(6, 2), 0, this.section.getLastY2() + 8);
/*     */     
/* 329 */     ss.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.city)
/*     */         {
/* 331 */           final UIArmyCitySendOut city = new UIArmyCitySendOut();
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 335 */             this.city.init(Army.army);
/* 336 */             (VIEW.inters()).popup.show((RENDEROBJ)this.city, (CLICKABLE)this);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 341 */             text.text(Army.¤¤RecruitSettD);
/*     */           }
/* 346 */         }).bg((COLOR)colorImp).pad(6, 2));
/*     */ 
/*     */     
/* 349 */     ss.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.coins)
/*     */         {
/* 351 */           private UIMerenaries s = new UIMerenaries();
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 355 */             (VIEW.inters()).popup.show((RENDEROBJ)this.s.get(), (CLICKABLE)this);
/*     */           }
/* 358 */         }).bg((COLOR)colorImp).pad(8, 2).hoverTitleSet(Dic.¤¤Mercenaries).hoverInfoSet(D.g("mercenaryD", "Hiring mercenaries is instant and they equip, feed and replenish themselves. They cost credits to hire and requires credits in upkeep.")));
/*     */ 
/*     */     
/* 361 */     ss.addRightC(48, (RENDEROBJ)new GButt.Glow((SPRITE)(SPRITES.icons()).m.questionmark)
/*     */         {
/*     */           protected void clickA() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 370 */             Str tmp = Str.TMP.clear().add(Dic.¤¤Unitinfo);
/* 371 */             tmp.insert(0, (KEYS.MAIN()).UNDO.repr());
/* 372 */             tmp.insert(1, (KEYS.MAIN()).MOD.repr());
/* 373 */             text.text((CharSequence)tmp);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 379 */     ss.addRightC(4, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.place_brush)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 383 */             if (activeIs()) {
/* 384 */               (VIEW.inters()).popup.show(Army.this.banner.view(), (CLICKABLE)this);
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 390 */             activeSet((Army.this.selectedAm > 0));
/*     */           }
/* 394 */         }).hoverTitleSet(Dic.¤¤Banner));
/*     */     
/* 396 */     ss.addRightC(4, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.menu)
/*     */         {
/*     */           UIDivEditor pop;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 421 */             for (int i = 0; i < Army.this.selected.length; i++) {
/* 422 */               if (Army.this.selected[i] && Army.army.divs().get(i) instanceof WDivRegional) {
/* 423 */                 WDivRegional d = (WDivRegional)Army.army.divs().get(i);
/* 424 */                 this.pop.div().copyFrom((DIV_SPEC)d.target);
/* 425 */                 this.pop.clearChanges();
/* 426 */                 (VIEW.inters()).popup.show((RENDEROBJ)this.pop, (CLICKABLE)this);
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 436 */             activeSet(false);
/* 437 */             for (int i = 0; i < Army.army.divs().size(); i++) {
/* 438 */               if (Army.this.selected[i] && Army.army.divs().get(i) instanceof WDivRegional) {
/* 439 */                 activeSet(true);
/*     */               
/*     */               }
/*     */             }
/*     */           
/*     */           }
/* 445 */         }).hoverTitleSet(Dic.¤¤Edit));
/*     */ 
/*     */     
/* 448 */     ss.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.arrow_right)
/*     */         {
/* 450 */           GETTER<Faction> g = (GETTER<Faction>)new GETTER.GETTER_IMP(FACTIONS.player());
/*     */ 
/*     */ 
/*     */           
/* 454 */           UIPickerArmy p = new UIPickerArmy(this.g, 400)
/*     */             {
/*     */               protected void pick(WArmy a)
/*     */               {
/* 458 */                 int off = 0;
/* 459 */                 for (int i = 0; i < (Army.null.access$0(Army.null.this)).selected.length; i++) {
/* 460 */                   if ((Army.null.access$0(Army.null.this)).selected[i]) {
/* 461 */                     Army.army.divs().get(i - off).reassign(a);
/* 462 */                     off++;
/* 463 */                     (Army.null.access$0(Army.null.this)).selected[i] = false;
/*     */                   } 
/*     */                 } 
/* 466 */                 (VIEW.inters()).popup.close();
/*     */               }
/*     */ 
/*     */ 
/*     */               
/*     */               protected boolean canBePicked(WArmy a) {
/* 472 */                 return (a != Army.army && a.divs().size() + (Army.null.access$0(Army.null.this)).selectedAm < (Config.battle()).DIVISIONS_PER_ARMY && Math.abs(a.ctx() - Army.army.ctx()) + Math.abs(a.cty() - Army.army.cty()) <= 0);
/*     */               }
/*     */             };
/*     */ 
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 479 */             activeSet(false);
/* 480 */             if (Army.this.selectedAm > 0) {
/* 481 */               for (WArmy a : FACTIONS.player().armies().all()) {
/* 482 */                 if (a != Army.army && Math.abs(a.ctx() - Army.army.ctx()) + Math.abs(a.cty() - Army.army.cty()) <= 0) {
/* 483 */                   activeSet(true);
/*     */                   return;
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 492 */             (VIEW.inters()).popup.show((RENDEROBJ)this.p, (CLICKABLE)this);
/*     */           }
/* 496 */         }).hoverTitleSet(Dic.¤¤Reassign).hoverInfoSet(D.g("MoveD", "Move this division to another army. The army must be on the same tile as the target army")));
/*     */     
/* 498 */     ss.addRightC(0, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.cancel)
/*     */         {
/* 500 */           ACTION a = new ACTION()
/*     */             {
/*     */               public void exe()
/*     */               {
/* 504 */                 int off = 0;
/* 505 */                 for (int i = 0; i < (Army.null.access$0(Army.null.this)).selected.length; i++) {
/* 506 */                   if ((Army.null.access$0(Army.null.this)).selected[i] && 
/* 507 */                     Army.army != null && Army.army.divs() != null && Army.army.divs().get(i - off) != null) {
/*     */                     
/* 509 */                     Army.army.divs().get(i - off).disband();
/* 510 */                     off++;
/* 511 */                     (Army.null.access$0(Army.null.this)).selected[i] = false;
/*     */                   } 
/*     */                 } 
/* 514 */                 (Army.null.access$0(Army.null.this)).clicked = null;
/* 515 */                 (Army.null.access$0(Army.null.this)).dragging = false;
/*     */               }
/*     */             };
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 521 */             Str.TMP.clear().add(Army.¤¤Sure).s().add(Army.¤¤DisbandDiv).insert(0, Army.this.selectedAm);
/* 522 */             (VIEW.inters()).yesNo.activate((CharSequence)Str.TMP, this.a, ACTION.NOP, true);
/* 523 */             Army.this.clicked = null;
/* 524 */             Army.this.dragging = false;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 529 */             activeSet(false); byte b; int i; boolean[] arrayOfBoolean;
/* 530 */             for (i = (arrayOfBoolean = Army.this.selected).length, b = 0; b < i; ) { boolean s = arrayOfBoolean[b];
/* 531 */               if (s) {
/* 532 */                 activeSet(true);
/*     */                 return;
/*     */               } 
/*     */               b++; }
/*     */           
/*     */           }
/*     */           public void hoverInfoGet(GUI_BOX box) {
/* 539 */             box.title(Dic.¤¤Disband);
/* 540 */             Str.TMP.clear().add(Army.¤¤DisbandDiv).insert(0, Army.this.selectedAm);
/* 541 */             box.text((CharSequence)Str.TMP);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 550 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)ss);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 555 */     ss = new GuiSection();
/* 556 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)ss);
/*     */ 
/*     */ 
/*     */     
/* 560 */     int am = 8;
/*     */     
/* 562 */     ArrayList<GuiSection> rows = new ArrayList((int)Math.ceil((Config.battle()).DIVISIONS_PER_ARMY / am));
/*     */     int i;
/* 564 */     for (i = 0; i < rows.max(); i++) {
/* 565 */       rows.add(new GuiSection());
/*     */     }
/*     */ 
/*     */     
/* 569 */     for (i = 0; i < (Config.battle()).DIVISIONS_PER_ARMY; i++) {
/*     */       
/* 571 */       GuiSection guiSection = (GuiSection)rows.get(i / am);
/* 572 */       guiSection.addRightC(2, (RENDEROBJ)new Button(i));
/*     */     } 
/*     */ 
/*     */     
/* 576 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)(new GScrollRows((Iterable)rows, HEIGHT - this.section.getLastY2() - 8)).view());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ISidePanel get(WArmy army) {
/* 584 */     Army.army = army;
/* 585 */     this.name.text().clear().add((CharSequence)army.name);
/* 586 */     this.dragging = false;
/* 587 */     Arrays.fill(this.selected, false);
/* 588 */     this.clicked = null;
/* 589 */     (VIEW.world()).tools.place((PLACABLE)this.tool, this.tool.config, false);
/* 590 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(float ds) {
/* 595 */     (WORLD.OVERLAY()).things.hover((RECTANGLE)army.body(), GCOLOR.MAP().get(army.faction()), false, 8);
/* 596 */     if (!army.added() && last() != null && last().added(this))
/* 597 */       last().remove(this); 
/*     */   }
/*     */   
/*     */   private class Button
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/*     */     private final int ii;
/*     */     
/*     */     Button(int ii) {
/* 606 */       this.ii = ii;
/* 607 */       this.body.setDim((DIMENSION)(VIEW.UI()).div.world);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 612 */       activeSet((this.ii < Army.army.divs().size()));
/* 613 */       if (this.ii >= Army.army.divs().size())
/*     */         return; 
/* 615 */       selectedSet(Army.this.selected[this.ii]);
/* 616 */       GCOLOR.UI().border().render(r, (RECTANGLE)this.body);
/* 617 */       ADDiv d = Army.army.divs().get(this.ii);
/* 618 */       (VIEW.UI()).div.world.render(r, body().x1(), body().y1(), 1, (WDIV)d, (d.men() > 0), isSelected, isHovered);
/*     */       
/* 620 */       if (Army.this.dragging && isHovered && Army.this.clicked != null && Army.this.clicked != this && !(KEYS.MAIN()).UNDO.isPressed() && !(KEYS.MAIN()).MOD.isPressed()) {
/* 621 */         COLOR.GREEN100.render(r, body().x1() - 2, body().x1() + 2, body().y1(), body().y2());
/* 622 */         if (!MButt.LEFT.isDown()) {
/* 623 */           Army.army.divs().insert(this.ii, Army.this.clicked.ii);
/* 624 */           Army.this.selected[Army.this.clicked.ii] = Army.this.selected[this.ii];
/* 625 */           Army.this.selected[this.ii] = false;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 635 */       if (this.ii >= Army.army.divs().size())
/*     */         return; 
/* 637 */       GBox b = (GBox)text;
/* 638 */       ADDiv d = Army.army.divs().get(this.ii);
/* 639 */       (VIEW.UI()).div.world.hover((WDIV)d, (GUI_BOX)b);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 645 */       if ((KEYS.MAIN()).UNDO.isPressed() && Army.this.clicked != null) {
/* 646 */         Arrays.fill(Army.this.selected, false);
/* 647 */         if (Army.this.clicked.ii < this.ii) {
/* 648 */           for (int i = Army.this.clicked.ii; i <= this.ii; i++) {
/* 649 */             Army.this.selected[i] = true;
/*     */           }
/*     */         }
/*     */         else {
/*     */           
/* 654 */           for (int i = this.ii; i <= Army.this.clicked.ii; i++) {
/* 655 */             Army.this.selected[i] = true;
/*     */           }
/*     */         }
/*     */       
/*     */       }
/* 660 */       else if ((KEYS.MAIN()).MOD.isPressed()) {
/* 661 */         Army.this.selected[this.ii] = !Army.this.selected[this.ii];
/*     */       } else {
/* 663 */         Arrays.fill(Army.this.selected, false);
/* 664 */         Army.this.selected[this.ii] = true;
/* 665 */         Army.this.clicked = this;
/* 666 */         Army.this.dragging = true;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\army\Army.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */