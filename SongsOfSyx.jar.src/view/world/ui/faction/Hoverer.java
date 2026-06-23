/*     */ package view.world.ui.faction;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.superb.SuperBoostableObj;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FWorth;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import game.faction.royalty.opinion.RTrust;
/*     */ import game.faction.trade.TradeManager;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ class Hoverer {
/*  34 */   GuiSection s = new GuiSection();
/*     */   
/*     */   private final SPRITE ss;
/*     */   private FactionNPC f;
/*  38 */   private static CharSequence ¤¤powerBalance = "Power Balance compared to you";
/*  39 */   private static CharSequence ¤¤powerD = "The military might of this nation. High powered factions are harder to please.";
/*     */   
/*     */   static {
/*  42 */     D.ts(Hoverer.class);
/*     */   }
/*     */   
/*     */   public Hoverer() {
/*  46 */     this.s.add((RENDEROBJ)(new GStat((UI.FONT()).S)
/*     */         {
/*     */           
/*     */           public void update(GText text)
/*     */           {
/*  51 */             text.lablifySub().add((CharSequence)Hoverer.this.f.nameIntro);
/*     */           }
/*  54 */         }).r(DIR.N), 0, 0);
/*  55 */     this.s.addDownC(2, (RENDEROBJ)(new GStat((UI.FONT()).H2)
/*     */         {
/*     */           
/*     */           public void update(GText text)
/*     */           {
/*  60 */             text.lablify().add((CharSequence)Hoverer.this.f.name);
/*     */           }
/*  63 */         }).r(DIR.N));
/*     */     
/*  65 */     this.s.addRelBody(110, DIR.W, (SPRITE)new SPRITE.Imp(32)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/*  69 */             (Hoverer.this.f.banner()).BIG.render(r, X1, X2, Y1, Y2);
/*     */           }
/*     */         });
/*     */     
/*  73 */     this.s.addRelBody(110, DIR.E, (SPRITE)new SPRITE.Imp(32)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/*  77 */             (Hoverer.this.f.banner()).BIG.render(r, X1, X2, Y1, Y2);
/*     */           }
/*     */         });
/*     */     
/*  81 */     this.s.addRelBody(4, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  85 */             if (!RD.DIST().reachable((Faction)Hoverer.this.f)) {
/*  86 */               if (RD.DIST().factionCanAttackPlayerAllies((Faction)Hoverer.this.f)) {
/*  87 */                 text.add(Dic.¤¤FactionBorder);
/*     */               } else {
/*  89 */                 text.add(Dic.¤¤Distant);
/*     */               } 
/*     */             } else {
/*     */               
/*  93 */               text.add((DIP.get(Hoverer.this.f)).name);
/*     */             } 
/*     */           }
/*  96 */         }).r(DIR.N));
/*     */     
/*  98 */     GETTER<FactionNPC> g = new GETTER<FactionNPC>()
/*     */       {
/*     */         public FactionNPC get()
/*     */         {
/* 102 */           return Hoverer.this.f;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 108 */     this.s.add((RENDEROBJ)facts(g, 3, 100), this.s.body().x1(), this.s.body().y2());
/*     */     
/* 110 */     this.ss = this.s.asSprite();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static GuiSection facts(final GETTER<FactionNPC> f, int cols, int M) {
/* 116 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 120 */           if (f.get() == null)
/*     */             return; 
/* 122 */           super.render(r, ds);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 127 */           if (f.get() == null)
/*     */             return; 
/* 129 */           super.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */     
/* 133 */     int i = 0;
/*     */ 
/*     */ 
/*     */     
/* 137 */     GuiSection ss = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 140 */           if (f.get() == null || ((FactionNPC)f.get()).court().king() == null)
/*     */             return; 
/* 142 */           text.title(((((FactionNPC)f.get()).court().king().roy()).induvidual.race()).info.namePosessive);
/*     */         }
/*     */       };
/* 145 */     ss.add((SPRITE)(UI.icons()).s.crown, 0, 0);
/* 146 */     ss.addRightC(4, (RENDEROBJ)new RENDEROBJ.RenderImp(24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 150 */             ((((FactionNPC)f.get()).court().king().roy()).induvidual.race().appearance()).icon.render(r, (RECTANGLE)this.body);
/*     */           }
/*     */         });
/*     */     
/* 154 */     s.addGridD((RENDEROBJ)ss, i++, cols, M, 20, DIR.W);
/*     */ 
/*     */     
/* 157 */     s.addGridD((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 161 */             GFORMAT.f0(text, (int)(100.0D * ROPINION.get((FactionNPC)f.get())) / 100.0D);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 166 */             b.title(ROPINION.¤¤name);
/* 167 */             b.text(ROPINION.¤¤desc);
/* 168 */             b.sep();
/* 169 */             ROPINION.BOOST().hoverDetailed((GUI_BOX)b, (SuperBoostableObj)((FactionNPC)f.get()).court().king().roy());
/*     */           }
/* 173 */         }).hh((SPRITE)(ROPINION.BOOST()).bo.icon), i++, cols, M, 20, DIR.W);
/*     */     
/* 175 */     s.addGridD((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 179 */             GFORMAT.perc100(text, ROPINION.trust().get((FactionNPC)f.get()), 0);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 184 */             b.title((ROPINION.trust()).bo.name);
/* 185 */             b.text((ROPINION.trust()).bo.desc);
/* 186 */             b.sep();
/* 187 */             RTrust.BOOST().hoverDetailed((GUI_BOX)b, (SuperBoostableObj)((FactionNPC)f.get()).court().king().roy());
/*     */           }
/* 191 */         }).hh((SPRITE)(RTrust.BOOST()).bo.icon), i++, cols, M, 20, DIR.W);
/*     */     
/* 193 */     s.addGridD((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 197 */             GFORMAT.i(text, RD.DIST().distance((Faction)f.get()));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 202 */             b.add(RD.DIST().distance().info());
/* 203 */             b.NL();
/*     */             
/* 205 */             if (f.get() == null) {
/*     */               return;
/*     */             }
/* 208 */             b.textLL(Dic.¤¤Toll);
/* 209 */             b.tab(6);
/* 210 */             b.add((SPRITE)GFORMAT.f(b.text(), TradeManager.toll((FactionNPC)f.get())));
/* 211 */             b.NL();
/*     */             
/* 213 */             b.textLL(Dic.¤¤Tariff);
/* 214 */             b.tab(6);
/* 215 */             b.add((SPRITE)GFORMAT.f(b.text(), ROPINION.tradeCost((FactionNPC)f.get())));
/* 216 */             b.NL();
/*     */           }
/* 220 */         }).hh((SPRITE)(UI.icons()).s.wheel), i++, cols, M, 20, DIR.W);
/*     */     
/* 222 */     s.addGridD((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 226 */             GFORMAT.i(text, (int)((FactionNPC)f.get()).offensivePower());
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 231 */             b.title(Dic.¤¤Power);
/* 232 */             b.text(Hoverer.¤¤powerD);
/* 233 */             b.NL();
/* 234 */             b.text(Hoverer.¤¤powerBalance);
/* 235 */             b.add((SPRITE)GFORMAT.f1(b.text(), (((FactionNPC)f.get()).offensivePower() + 1.0D) / (FACTIONS.player().offensivePower() + 1.0D), 1.0D));
/*     */           }
/* 238 */         }).hh((SPRITE)(UI.icons()).s.fist), i++, cols, M, 20, DIR.W);
/*     */     
/* 240 */     s.addGridD((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 244 */             GFORMAT.i(text, (int)FACTIONS.WORTH().faction((Faction)f.get()));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 249 */             b.title(Dic.¤¤NetWorth);
/* 250 */             for (FWorth.WINT d : (FACTIONS.WORTH()).faction) {
/* 251 */               b.add(d.icon);
/* 252 */               b.textL(d.info.name);
/* 253 */               b.tab(6);
/* 254 */               b.add((SPRITE)GFORMAT.iIncr(b.text(), d.get((Faction)f.get())));
/* 255 */               b.NL();
/* 256 */               b.text(d.info.desc);
/* 257 */               b.NL(5);
/*     */ 
/*     */             
/*     */             }
/*     */           
/*     */           }
/* 263 */         }).hh((SPRITE)(UI.icons()).s.money), i++, cols, M, 20, DIR.W);
/*     */     
/* 265 */     s.addGridD((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 269 */             GFORMAT.i(text, (FACTIONS.player()).emissaries.spent((FactionNPC)f.get()));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 274 */             b.title(ROPINION.¤¤wEmmi);
/*     */           }
/* 277 */         }).hh((SPRITE)(BOOSTABLES.CIVICS()).DIPLOMACY.icon), i++, cols, M, 20, DIR.W);
/*     */ 
/*     */     
/* 280 */     s.addGridD((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 284 */             GFORMAT.i(text, (RD.RACES()).population.faction().get(f.get()));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 289 */             b.title(Dic.¤¤Subject);
/* 290 */             for (RDRace rr : (RD.RACES()).all) {
/* 291 */               b.add((SPRITE)(rr.race.appearance()).icon);
/* 292 */               b.text(rr.race.info.names);
/* 293 */               b.tab(7);
/* 294 */               b.add((SPRITE)GFORMAT.i(b.text(), rr.pop.faction().get(f.get())));
/* 295 */               b.NL();
/*     */             }
/*     */           
/*     */           }
/* 299 */         }).hh((SPRITE)(UI.icons()).s.human), i++, cols, M, 20, DIR.W);
/*     */     
/* 301 */     SPRITE.Imp imp = new SPRITE.Imp(140, 16)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 305 */           int am = DIP.WAR().all((Faction)f.get()).size();
/*     */           
/* 307 */           if (am == 0) {
/*     */             return;
/*     */           }
/* 310 */           int dx = (width() - 24) / am;
/*     */           
/* 312 */           dx = CLAMP.i(dx, 1, 24);
/*     */           
/* 314 */           double x1 = X1;
/* 315 */           for (Faction fa : DIP.WAR().all((Faction)f.get())) {
/* 316 */             (fa.banner()).MEDIUM.render(r, (int)x1, Y1);
/* 317 */             x1 += dx;
/* 318 */             if (x1 > X2) {
/*     */               break;
/*     */             }
/*     */           } 
/*     */         }
/*     */       };
/* 324 */     s.addGridD((RENDEROBJ)new GHeader.HeaderHorizontal((SPRITE)(UI.icons()).s.sword, (SPRITE)imp)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 328 */             GBox b = (GBox)text;
/* 329 */             b.title(Dic.¤¤Enemies);
/* 330 */             for (Faction fa : FACTIONS.all()) {
/* 331 */               if (fa.isActive() && DIP.WAR().is(fa, (Faction)f.get())) {
/* 332 */                 b.add((fa.banner()).BIG);
/* 333 */                 b.text((CharSequence)fa.name);
/* 334 */                 b.NL();
/*     */               }
/*     */             
/*     */             }
/*     */           
/*     */           }
/* 340 */         }i++, cols, M, 20, DIR.W);
/*     */     
/* 342 */     s.body().incrW(Math.max(M - s.body().width() - 20, 0));
/* 343 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void hover(GUI_BOX box, Faction f) {
/* 351 */     GBox b = (GBox)box;
/*     */     
/* 353 */     if (f == null) {
/* 354 */       b.title(Dic.¤¤NoRuler);
/* 355 */     } else if (f instanceof FactionNPC) {
/* 356 */       hoverFF(b, (FactionNPC)f);
/*     */     } else {
/* 358 */       box.title((CharSequence)f.name);
/*     */     } 
/*     */   }
/*     */   
/*     */   void hoverFF(GBox b, FactionNPC f) {
/* 363 */     this.f = f;
/* 364 */     b.add(this.ss);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\Hoverer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */