/*     */ package view.battle;
/*     */ import game.GAME;
/*     */ import game.battle.Army;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.state.BattleState;
/*     */ import game.battle.state.BattleStateExiter;
/*     */ import game.battle.state.BattleStateResult;
/*     */ import game.battle.util.Copyable;
/*     */ import game.save.GameLoader;
/*     */ import init.constant.Config;
/*     */ import init.paths.PATHS;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPES;
/*     */ import java.nio.file.Path;
/*     */ import menu.Menu;
/*     */ import settlement.entity.EntityIterator;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import settlement.room.military.artillery.ROOM_ARTILLERY;
/*     */ import snake2d.CORE;
/*     */ import snake2d.CORE_STATE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanels;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.ui.top.UIPanelTop;
/*     */ import world.battle.spec.BATTLE_RESULT;
/*     */ 
/*     */ public final class BattlePanel {
/*     */   private final UIPanelArtillery cards_cata;
/*  54 */   public static CharSequence ¤¤MusterDesc = "¤Muster Men. Calls to arm and have your subjects form up in their division and man artillery, or un-muster men and have them return to their civil duties."; private final UIPanelUnitCards cards_player; private final UIPanelUnitCards cards_enemy;
/*  55 */   public static CharSequence ¤¤MusterOneProblem = "¤One or more divisions do not have a position. Set a position by clicking the division, then click and drag on the ground where you want them.";
/*  56 */   public static CharSequence ¤¤MusterProblem = "¤The division do not have a position. Set a position by clicking the division, then click and drag on the ground where you want them.";
/*  57 */   public static CharSequence ¤¤notMustered = "¤Some of your available units are not mustered.";
/*  58 */   private static CharSequence ¤¤exp = "In order to deploy and use your army, press the muster button to the left. Click and drag to select an area of troops, or click the unit cards. You can use control to toggle unit card selection and shift to select several.";
/*  59 */   public static CharSequence ¤¤restart = "restart";
/*  60 */   private static CharSequence ¤¤restartD = "restart";
/*     */   
/*  62 */   private static CharSequence ¤¤retreat = "Retreat";
/*  63 */   private static CharSequence ¤¤retreatD = "Retreat and lose {0} soldiers.";
/*  64 */   private static CharSequence ¤¤retreatQ = "Are you sure you wish to retreat and lose {0} soldiers?";
/*     */   
/*  66 */   private static CharSequence ¤¤throne = "When enemies are standing by the throne, this timer will tick down, and once it reaches 0, the battle will be lost.";
/*     */   
/*     */   static {
/*  69 */     D.ts(BattlePanel.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BattlePanel(final ISidePanels p, final GameWindow w, UIPanelTop top, DivSelection selection, boolean battleview) {
/*  76 */     GuiSection butts = new GuiSection();
/*     */     
/*  78 */     UIPanelTop.Butt butt = new UIPanelTop.Butt((SPRITE)(SPRITES.icons()).m.sword, 8)
/*     */       {
/*     */         protected void clickA() {
/*  81 */           if (p.added(BattlePanel.this.cards_player)) {
/*  82 */             p.remove(BattlePanel.this.cards_player);
/*     */           } else {
/*  84 */             p.add(BattlePanel.this.cards_player, false, true);
/*     */           } 
/*     */         }
/*     */         
/*     */         protected void renAction() {
/*  89 */           selectedSet(p.added(BattlePanel.this.cards_player));
/*     */         }
/*     */       };
/*  92 */     butt.hoverInfoSet(Dic.¤¤Army);
/*  93 */     butts.addRight(0, (RENDEROBJ)butt);
/*     */     
/*  95 */     butt = new UIPanelTop.Butt((SPRITE)((ROOM_ARTILLERY)(SETT.ROOMS()).ARTILLERY.get(0)).iconBig(), 8)
/*     */       {
/*     */         protected void clickA() {
/*  98 */           if (p.added(BattlePanel.this.cards_cata)) {
/*  99 */             p.remove(BattlePanel.this.cards_cata);
/*     */           } else {
/* 101 */             p.add(BattlePanel.this.cards_cata, false, true);
/*     */           } 
/*     */         }
/*     */         
/*     */         protected void renAction() {
/* 106 */           selectedSet(p.added(BattlePanel.this.cards_cata));
/*     */         }
/*     */       };
/* 109 */     butt.hoverInfoSet(Dic.¤¤Artillery);
/* 110 */     butts.addRight(0, (RENDEROBJ)butt);
/*     */ 
/*     */ 
/*     */     
/* 114 */     if ((S.get()).developer) {
/*     */       
/* 116 */       butt = new UIPanelTop.Butt((SPRITE)(SPRITES.icons()).m.sword, 8)
/*     */         {
/*     */           protected void clickA() {
/* 119 */             if (p.added(BattlePanel.this.cards_enemy)) {
/* 120 */               p.remove(BattlePanel.this.cards_enemy);
/*     */             } else {
/* 122 */               p.add(BattlePanel.this.cards_enemy, true, true);
/*     */             } 
/*     */           }
/*     */           
/*     */           protected void renAction() {
/* 127 */             selectedSet(p.added(BattlePanel.this.cards_enemy));
/*     */           }
/*     */         };
/* 130 */       butt.hoverInfoSet("armyEnemy");
/* 131 */       butts.addRight(0, (RENDEROBJ)butt);
/*     */     } 
/*     */     
/* 134 */     if (!battleview) {
/* 135 */       butt = new UIPanelTop.Butt((SPRITE)(SPRITES.icons()).m.for_muster)
/*     */         {
/* 137 */           private DivFormationImp tmp = new DivFormationImp();
/*     */           
/*     */           boolean shouldmuster;
/*     */           boolean problem;
/*     */           
/*     */           protected void clickA() {
/* 143 */             for (Div d : GAME.ARMIES().player().divisions())
/* 144 */               d.settings().musteringSet(this.shouldmuster); 
/* 145 */             for (ROOM_ARTILLERY c : (SETT.ROOMS()).ARTILLERY) {
/* 146 */               for (int i = 0; i < c.instancesSize(); i++) {
/* 147 */                 if (((ArtilleryInstance)c.getInstance(i)).army() == GAME.ARMIES().player()) {
/* 148 */                   ((ArtilleryInstance)c.getInstance(i)).muster(this.shouldmuster);
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           }
/*     */           
/*     */           protected void renAction() {
/* 155 */             this.shouldmuster = false;
/* 156 */             this.problem = false;
/* 157 */             for (Div d : GAME.ARMIES().player().divisions()) {
/*     */               
/* 159 */               if (d.menNrOf() > 0) {
/* 160 */                 this.shouldmuster |= (d.menNrOf() > 0 && !d.settings().mustering()) ? 1 : 0;
/* 161 */                 if (!this.problem) {
/* 162 */                   (d.order()).dest.get((Copyable)this.tmp);
/* 163 */                   if (this.tmp.deployed() == 0) {
/* 164 */                     this.problem = true;
/*     */                   }
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */             
/* 170 */             for (ROOM_ARTILLERY c : (SETT.ROOMS()).ARTILLERY) {
/* 171 */               for (int i = 0; i < c.instancesSize(); i++) {
/* 172 */                 this.shouldmuster |= (((ArtilleryInstance)c.getInstance(i)).army() == GAME.ARMIES().player() && !((ArtilleryInstance)c.getInstance(i)).mustered()) ? 1 : 0;
/*     */               }
/*     */             } 
/* 175 */             selectedSet(!this.shouldmuster);
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 182 */             super.render(r, ds, isActive, isSelected, isHovered);
/* 183 */             if (this.problem) {
/* 184 */               (GCOLOR.UI()).BAD.hovered.bind();
/* 185 */               (UI.icons()).s.alert.render(r, this.body.x2() - 16, this.body.y1());
/* 186 */             } else if (this.shouldmuster) {
/* 187 */               (GCOLOR.UI()).SOSO.hovered.bind();
/* 188 */               (UI.icons()).s.alert.render(r, this.body.x2() - 16, this.body.y1());
/*     */             } 
/* 190 */             COLOR.unbind();
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 195 */             GBox b = (GBox)text;
/* 196 */             b.title(Dic.¤¤Muster);
/* 197 */             b.text(BattlePanel.¤¤MusterDesc);
/* 198 */             b.sep();
/* 199 */             if (this.problem) {
/* 200 */               b.error(BattlePanel.¤¤MusterOneProblem);
/*     */             }
/* 202 */             if (this.shouldmuster) {
/* 203 */               b.warn(BattlePanel.¤¤notMustered);
/*     */             }
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */       
/* 210 */       butts.addRight(4, (RENDEROBJ)butt);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 215 */     GButt.BStat2 bStat2 = new GButt.BStat2((SPRITE)(SPRITES.icons()).s.standard, (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 219 */             GFORMAT.perc(text, ((Army)GAME.ARMIES().armies().get(0)).morale());
/*     */           }
/* 221 */         }).decrease())
/*     */       {
/*     */         protected void clickA() {}
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void renAction() {}
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 234 */           GBox b = (GBox)text;
/* 235 */           b.title(Dic.¤¤Morale);
/* 236 */           b.text(Dic.¤¤MoraleD);
/* 237 */           b.NL(8);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 254 */     butts.addRightC(4, (RENDEROBJ)bStat2);
/*     */     
/* 256 */     if ((S.get()).developer) {
/* 257 */       bStat2 = new GButt.BStat2((SPRITE)(SPRITES.icons()).s.standard, (new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 261 */               GFORMAT.perc(text, ((Army)GAME.ARMIES().armies().get(0)).morale());
/*     */             }
/* 263 */           }).decrease())
/*     */         {
/*     */           protected void clickA() {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           protected void renAction() {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 276 */             GBox b = (GBox)text;
/* 277 */             b.title(Dic.¤¤Morale);
/* 278 */             b.text(Dic.¤¤MoraleD);
/* 279 */             b.NL(8);
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 296 */       butts.addRightC(4, (RENDEROBJ)bStat2);
/*     */     } 
/*     */     
/* 299 */     CLICKABLE cLICKABLE = (new GButt.BStat2((SPRITE)(SPRITES.icons()).s.human, new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 303 */             GFORMAT.i(text, ((Army)GAME.ARMIES().armies().get(1)).men());
/* 304 */             text.errorify();
/*     */           }
/*     */         })
/*     */       {
/* 308 */         int di = 0;
/*     */         
/*     */         protected void clickA() {
/* 311 */           if (((Army)GAME.ARMIES().armies().get(1)).men() > 0)
/*     */           {
/*     */             
/* 314 */             for (int i = 0; i < (Config.battle()).DIVISIONS_PER_ARMY; i++) {
/* 315 */               this.di++;
/*     */               
/* 317 */               this.di %= (Config.battle()).DIVISIONS_PER_ARMY;
/* 318 */               Div d = (Div)((Army)GAME.ARMIES().armies().get(1)).divisions().get(this.di);
/* 319 */               if (d.menNrOf() > 0) {
/* 320 */                 w.centerer.set(d.centre().cUnitX(), d.centre().cUnitY());
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void renAction() {}
/* 332 */       }).hoverInfoSet((HTYPES.ENEMY()).names);
/* 333 */     butts.addRightC(4, (RENDEROBJ)cLICKABLE);
/*     */     
/* 335 */     if (!battleview) {
/* 336 */       cLICKABLE = (new GButt.Panel((SPRITE)(SPRITES.icons()).m.questionmark)).hoverInfoSet(¤¤exp);
/* 337 */       butts.addRelBody(8, DIR.E, (RENDEROBJ)cLICKABLE);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 343 */     this.cards_cata = new UIPanelArtillery(GAME.ARMIES().player(), selection.artillery);
/* 344 */     this.cards_player = new UIPanelUnitCards(GAME.ARMIES().player(), selection);
/* 345 */     this.cards_enemy = new UIPanelUnitCards(GAME.ARMIES().enemy(), selection);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 350 */     top.addLeft(butts);
/*     */     
/* 352 */     p.add(this.cards_player, true, true);
/*     */     
/* 354 */     if (battleview) {
/* 355 */       GuiSection r = new GuiSection();
/* 356 */       UIPanelTop.Butt butt1 = new UIPanelTop.Butt((SPRITE)(SPRITES.icons()).m.rotate, 8)
/*     */         {
/* 358 */           private ACTION a = new ACTION()
/*     */             {
/*     */               public void exe()
/*     */               {
/* 362 */                 VIEW.b().state().reloadBattle();
/*     */               }
/*     */             };
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 368 */             (VIEW.inters()).yesNo.activate(BattlePanel.¤¤restartD, this.a, null, true);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 373 */             text.title(BattlePanel.¤¤restart);
/*     */           }
/*     */         };
/*     */       
/* 377 */       r.addRightC(0, (RENDEROBJ)butt1);
/* 378 */       butt1 = new UIPanelTop.Butt((SPRITE)(SPRITES.icons()).m.flag, 8)
/*     */         {
/* 380 */           private ACTION a = new ACTION()
/*     */             {
/*     */               public void exe()
/*     */               {
/* 384 */                 VIEW.b().state().liveRetreat();
/*     */               }
/*     */             };
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 390 */             Str.TMP.clear().add(BattlePanel.¤¤retreatQ).insert(0, VIEW.b().state().liveRetreatLosses());
/* 391 */             (VIEW.inters()).yesNo.activate((CharSequence)Str.TMP, this.a, null, true);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 396 */             text.title(BattlePanel.¤¤retreat);
/* 397 */             Text t = text.text();
/* 398 */             t.add(BattlePanel.¤¤retreatD).insert(0, VIEW.b().state().liveRetreatLosses());
/* 399 */             text.add((SPRITE)t);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 404 */       r.addRightC(0, (RENDEROBJ)butt1);
/*     */       
/* 406 */       r.addRightC(8, (RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 410 */               if (VIEW.b().state() == null) {
/*     */                 return;
/*     */               }
/* 413 */               int tt = (int)VIEW.b().state().throneTimer();
/* 414 */               GFORMAT.iBig(text, (int)VIEW.b().state().throneTimer());
/*     */               
/* 416 */               if (tt < 75) {
/* 417 */                 text.color(GCOLOR.UI().badFlash());
/* 418 */               } else if (tt < 300) {
/* 419 */                 text.color((GCOLOR.UI()).SOSO.normal);
/*     */               } else {
/* 421 */                 text.color((GCOLOR.UI()).GOOD.normal);
/*     */               } 
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GBox b) {
/* 428 */               super.hoverInfoGet(b);
/*     */             }
/* 430 */           }).hh((SPRITE)(SPRITES.icons()).m.noble).hoverInfoSet(¤¤throne));
/*     */       
/* 432 */       if ((S.get()).developer) {
/*     */         
/* 434 */         r.addRightC(48, (RENDEROBJ)new GButt.ButtPanel("win")
/*     */             {
/*     */ 
/*     */               
/*     */               protected void clickA()
/*     */               {
/* 440 */                 (new EntityIterator.Humans()
/*     */                   {
/*     */                     protected boolean processAndShouldBreakH(Humanoid h, int ie)
/*     */                     {
/* 444 */                       if (h.indu().clas() == HCLASSES.OTHER()) {
/* 445 */                         h.helloMyNameIsInigoMontoyaYouKilledMyFatherPrepareToDie();
/*     */                       }
/* 447 */                       return false;
/*     */                     }
/* 449 */                   }).iterate();
/*     */               }
/*     */             });
/*     */ 
/*     */         
/* 454 */         final BattleStateExiter exit = new BattleStateExiter()
/*     */           {
/*     */             public void exit(BATTLE_RESULT res, int plosses, int elosses)
/*     */             {
/* 458 */               CORE.setCurrentState(new CORE_STATE.Constructor()
/*     */                   {
/*     */                     public CORE_STATE getState() {
/* 461 */                       return (CORE_STATE)Menu.make();
/*     */                     }
/*     */                   });
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void afterExit(BattleStateResult res) {}
/*     */           };
/* 472 */         r.addRightC(0, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.arrow_up.twin((SPRITE)(UI.icons()).s.star, DIR.NE, 1))
/*     */             {
/*     */ 
/*     */               
/*     */               protected void clickA()
/*     */               {
/* 478 */                 if (PATHS.local().save().exists(BattleState.debugLoad)) {
/* 479 */                   (new GameLoader(PATHS.local().save().get(BattleState.debugLoad), new String[0])
/*     */                     {
/*     */                       public void doAfterSet() {
/* 482 */                         BattleState.setLoaded(exit, PATHS.local().save().get(BattleState.debugLoad), true);
/*     */                       }
/* 484 */                     }).set();
/*     */                 }
/*     */               }
/*     */             });
/*     */ 
/*     */         
/* 490 */         r.addRightC(0, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.arrow_up)
/*     */             {
/*     */ 
/*     */               
/*     */               protected void clickA()
/*     */               {
/* 496 */                 (new GameLoader(PATHS.local().save().get(BattleState.debugLoad), new String[0])
/*     */                   {
/*     */                     public void doAfterSet() {
/* 499 */                       BattleState.setLoaded(exit, PATHS.local().save().get(BattleState.debugLoad), false);
/*     */                     }
/* 501 */                   }).set();
/*     */               }
/*     */             });
/*     */ 
/*     */         
/* 506 */         r.addRightC(0, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.arrow_down)
/*     */             {
/*     */ 
/*     */               
/*     */               protected void clickA()
/*     */               {
/* 512 */                 GAME.saver().save(BattleState.debugLoad);
/*     */               }
/*     */             });
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 519 */       top.addRight(r);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\BattlePanel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */