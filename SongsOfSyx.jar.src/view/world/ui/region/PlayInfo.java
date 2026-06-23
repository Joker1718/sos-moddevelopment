/*     */ package view.world.ui.region;
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.tmp.TmpBoostingButt;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FBanner;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.pathing.WRegSel;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.building.RDBuildPoints;
/*     */ 
/*     */ final class PlayInfo extends GuiSection {
/*  46 */   private static CharSequence ¤¤abandon = "Abandon Region";
/*  47 */   private static CharSequence ¤¤abandonQ = "Do you wish to abandon this region? It will be turned over into the hands of rebels.";
/*     */   
/*  49 */   private static CharSequence ¤¤autonomy = "Give Autonomy";
/*  50 */   private static CharSequence ¤¤autonomyD = "Do you wish to give this region autonomy and bestow upon it self-rule? The new faction will be in your debt.";
/*  51 */   private static CharSequence ¤¤autonomyE = "There simply are no suitable faction rulers to appoint a new king here. Perhaps we can gift this region to an ally or vassal instead?";
/*     */   
/*  53 */   private static CharSequence ¤¤DistanceToCapitol = "Distance to Capitol";
/*     */   
/*     */   static {
/*  56 */     D.ts(PlayInfo.class);
/*     */   }
/*     */ 
/*     */   
/*     */   PlayInfo(final GETTER.GETTER_IMP<Region> g, int WIDTH) {
/*  61 */     int i = 0;
/*  62 */     int cols = 7;
/*  63 */     int width = 78;
/*  64 */     int height = 48;
/*  65 */     DIR align = DIR.C;
/*     */ 
/*     */ 
/*     */     
/*  69 */     SPRITE.Imp imp2 = new SPRITE.Imp(48, 16)
/*     */       {
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/*  74 */           double c = get(RD.HEALTH().getD(g.get()));
/*  75 */           double t = get((RD.HEALTH()).boostablee.get((BOOSTABLE_O)g.get()));
/*     */           
/*  77 */           GMeter.renderC(r, c, t, X1, X2, Y1, Y2);
/*     */           
/*  79 */           if ((RD.HEALTH()).outbreak.get((Region)g.get()) == 1) {
/*  80 */             Y1 -= 24;
/*  81 */             OPACITY.O25TO100.bind();
/*  82 */             (UI.icons()).m.disease.render(r, X1, Y1);
/*  83 */             OPACITY.unbind();
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         private double get(double d) {
/*  90 */           return CLAMP.d(d, 0.0D, 1.0D);
/*     */         }
/*     */       };
/*     */     
/*  94 */     GHeader.HeaderVertical h = new GHeader.HeaderVertical((SPRITE)(UI.icons()).m.heart, (SPRITE)imp2)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  97 */           GBox b = (GBox)text;
/*  98 */           RD.HEALTH().hover(b, (Region)g.get());
/*     */         }
/*     */       };
/*     */     
/* 102 */     addGridD((RENDEROBJ)h, i++, cols, width, height, align);
/*     */ 
/*     */ 
/*     */     
/* 106 */     HOVERABLE hOVERABLE3 = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 110 */           GFORMAT.perc(text, CLAMP.d((RD.DIST()).bProximity.get((BOOSTABLE_O)g.get()), 0.0D, 1.0D));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GBox b) {
/* 116 */           b.textLL(PlayInfo.¤¤DistanceToCapitol);
/* 117 */           b.add((SPRITE)GFORMAT.i(b.text(), RD.DIST().distance().get(g.get())));
/* 118 */           b.NL();
/* 119 */           b.textLL(Dic.¤¤Neighbours);
/* 120 */           b.NL();
/* 121 */           for (WRegFinder.RegDist d : (WORLD.PATH()).regFinder.all((Region)g.get(), WRegFinder.Treaty.REG_NEIGHS, WRegSel.DUMMY())) {
/* 122 */             Region reg = d.reg;
/* 123 */             if (reg.faction() == null) {
/* 124 */               b.add(FBanner.rebel.MEDIUM);
/*     */             } else {
/* 126 */               b.add((reg.faction().banner()).MEDIUM);
/*     */             } 
/* 128 */             b.textL((CharSequence)reg.info.name());
/* 129 */             b.tab(7);
/* 130 */             b.add((SPRITE)GFORMAT.i(b.text(), d.distance));
/* 131 */             b.NL();
/*     */           } 
/*     */           
/* 134 */           b.sep();
/*     */           
/* 136 */           b.title((RD.DIST()).bProximity.name);
/* 137 */           b.text((RD.DIST()).bProximity.desc);
/* 138 */           b.sep();
/* 139 */           (RD.DIST()).bProximity.hover((GUI_BOX)b, (BOOSTABLE_O)g.get(), null, true);
/*     */         }
/* 142 */       }).hv((SPRITE)(UI.icons()).m.wheel);
/*     */     
/* 144 */     addGridD((RENDEROBJ)hOVERABLE3, i++, cols, width, height, align);
/*     */ 
/*     */ 
/*     */     
/* 148 */     SPRITE.Imp imp1 = new SPRITE.Imp(48, 16)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 152 */           GMeter.render(r, GMeter.C_REDGREEN, (RD.OWNER()).affiliation.getD(g.get()), X1, X2, Y1, Y2);
/*     */         }
/*     */       };
/*     */     
/* 156 */     h = new GHeader.HeaderVertical((SPRITE)(UI.icons()).m.flag, (SPRITE)imp1)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 159 */           GBox b = (GBox)text;
/* 160 */           b.textLL(Dic.¤¤Current);
/* 161 */           b.tab(6);
/* 162 */           b.add((SPRITE)GFORMAT.perc(b.text(), (RD.OWNER()).affiliation.getD(g.get())));
/* 163 */           b.NL(8);
/* 164 */           b.add((RD.OWNER()).affiliation.info());
/*     */         }
/*     */       };
/*     */     
/* 168 */     addGridD((RENDEROBJ)h, i++, cols, width, height, align);
/*     */ 
/*     */ 
/*     */     
/* 172 */     HOVERABLE hOVERABLE2 = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 176 */           GFORMAT.percInv(text, (RD.DEVASTATION()).current.getD(g.get()));
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GBox b) {
/* 181 */           b.add((RD.DEVASTATION()).current.info());
/*     */         }
/* 184 */       }).hv((SPRITE)(UI.icons()).m.skull);
/* 185 */     addGridD((RENDEROBJ)hOVERABLE2, i++, cols, width, height, align);
/*     */ 
/*     */ 
/*     */     
/* 189 */     HOVERABLE hOVERABLE1 = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 193 */           double v = CLAMP.d((GAME.raiders()).entry.get((Region)g.get()).security(), -1.0D, 1.0D);
/* 194 */           GFORMAT.perc(text, v, 0);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GBox b) {
/* 200 */           (GAME.raiders()).entry.get((Region)g.get()).hoverInfoGet((GUI_BOX)b);
/*     */         }
/* 203 */       }).hv((SPRITE)(UI.icons()).m.raider);
/* 204 */     addGridD((RENDEROBJ)hOVERABLE1, i++, cols, width, height, align);
/*     */ 
/*     */     
/* 207 */     for (RDBuildPoints.RDBuildPoint c : (RD.BUILDINGS()).costs.ALL) {
/* 208 */       HOVERABLE hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 212 */             GFORMAT.iIncr(text, (int)c.bo.get((BOOSTABLE_O)g.get()));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 217 */             c.hover((GUI_BOX)b, (Region)g.get());
/*     */           }
/* 223 */         }).hv(c.icon);
/* 224 */       addGridD((RENDEROBJ)hOVERABLE, i++, cols, width, height, align);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 230 */     addRelBody(4, DIR.N, (RENDEROBJ)actions(g, width));
/* 231 */     pad((WIDTH - body().width()) / 2, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static GuiSection actions(final GETTER.GETTER_IMP<Region> g, int WIDTH) {
/* 237 */     GuiSection butts = new GuiSection();
/*     */     
/* 239 */     butts.addRightC(0, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.noble, g)
/*     */         {
/* 241 */           ACTION aa = new ACTION()
/*     */             {
/*     */               
/*     */               public void exe()
/*     */               {
/* 246 */                 RD.setFaction((Region)g.get(), null, true);
/* 247 */                 FactionNPC f = FACTIONS.activateNext((Region)g.get(), null, true);
/* 248 */                 f.generate(RD.RACES().get(FACTIONS.player().race()), true);
/* 249 */                 ROPINION.OTHER().liberate(f);
/* 250 */                 DIP.VASSAL().set((Faction)f, (Faction)FACTIONS.player());
/* 251 */                 (GAME.events()).world.dip.dismissWelcome(f);
/*     */               }
/*     */             };
/*     */ 
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 258 */             if (FACTIONS.frees() > 5) {
/* 259 */               (VIEW.inters()).yesNo.activate(PlayInfo.¤¤autonomyD, this.aa, ACTION.NOP, true);
/*     */             }
/*     */           }
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 264 */             text.title(PlayInfo.¤¤autonomy);
/* 265 */             if (FACTIONS.frees() <= 5) {
/* 266 */               ((GBox)text).error(PlayInfo.¤¤autonomyE);
/*     */             }
/*     */           }
/*     */         });
/*     */     
/* 271 */     butts.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).m.cancel, g)
/*     */         {
/* 273 */           ACTION aa = new ACTION()
/*     */             {
/*     */               public void exe()
/*     */               {
/* 277 */                 RD.setFaction((Region)g.get(), null, true);
/*     */               }
/*     */             };
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 283 */             (VIEW.inters()).yesNo.activate(PlayInfo.¤¤abandonQ, this.aa, ACTION.NOP, true);
/*     */           }
/* 286 */         }).hoverTitleSet(¤¤abandon));
/*     */ 
/*     */     
/* 289 */     final GuiSection pop = MiscBasics.info((GETTER<Region>)g);
/* 290 */     final StringInputSprite name = new StringInputSprite(24, (UI.FONT()).H2)
/*     */       {
/*     */         protected void change() {
/* 293 */           ((Region)g.get()).info.name().clear().add((CharSequence)text());
/*     */         }
/*     */       };
/* 296 */     pop.add((RENDEROBJ)new GInput(name), 0, -48);
/*     */     
/* 298 */     butts.addRightC(0, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.questionmark)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 302 */             name.text().clear().add((CharSequence)((Region)g.get()).info.name());
/* 303 */             (VIEW.inters()).popup.show((RENDEROBJ)pop, (CLICKABLE)this);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 308 */             text.title(Dic.¤¤Info);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 313 */     butts.addRightC(0, (RENDEROBJ)TmpBoostingButt.make((GETTER)g, (GAME.BOOST()).regions));
/*     */     
/* 315 */     if ((S.get()).developer)
/*     */     {
/* 317 */       butts.addRightC(0, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.cog)
/*     */           {
/* 319 */             PlayDebug dd = new PlayDebug();
/*     */ 
/*     */             
/*     */             protected void clickA() {
/* 323 */               this.dd.reg = (Region)g.get();
/* 324 */               (VIEW.inters()).popup.show((RENDEROBJ)this.dd, (CLICKABLE)this);
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 331 */     return butts;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayInfo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */