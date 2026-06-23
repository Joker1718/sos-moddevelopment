/*     */ package view.battle;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DIV_FORMATION;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.thread.order.BattleOrderTask;
/*     */ import game.battle.thread.trajectory.BattleTrajectories;
/*     */ import game.battle.util.Copyable;
/*     */ import game.time.TIME;
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import settlement.room.military.artillery.ROOM_ARTILLERY;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.EquipRange;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.InterManager;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.keyboard.KEYS;
/*     */ import view.keyboard.KeyButt;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public final class UISelection extends Interrupter {
/*  52 */   private final GuiSection section = new GuiSection(); private final DivSelection selection;
/*  53 */   private final DivFormationImp tmp = new DivFormationImp();
/*     */   
/*     */   private int iFormationTight;
/*     */   private int iFormationLoose;
/*     */   private int iRunning;
/*     */   private int iCharging;
/*     */   private int iMustered;
/*     */   private int trajectories;
/*     */   private int iMopping;
/*     */   private int iRangedHasAny;
/*     */   private boolean hasRanged = false;
/*  64 */   private int[] iRangedHas = Alloc.ii(STATS.EQUIP().RANGED().size());
/*  65 */   private int[] iOutOfAmmo = Alloc.ii(STATS.EQUIP().RANGED().size());
/*  66 */   private int[] iRangedSelected = Alloc.ii(STATS.EQUIP().RANGED().size());
/*     */   private int iInGuard;
/*     */   private int ifiresAtWill;
/*     */   private int ifiresWait;
/*  70 */   private final BattleOrderTask task = new BattleOrderTask();
/*     */   
/*     */   private int men;
/*  73 */   private static CharSequence ¤¤dPosition = "¤To position your troops, left-click on the ground and hold.";
/*  74 */   private static CharSequence ¤¤dAdd = "¤To add troops to your selection, hold {0}, then click and drag over the additional troops.";
/*  75 */   private static CharSequence ¤¤dMove = "¤To reposition your troops, use the arrow keys ({0}).";
/*  76 */   private static CharSequence ¤¤dSpin = "¤To rotate your selection, hold  {0}, click and hold where the center should be.";
/*  77 */   private static CharSequence ¤¤dSelectAll = "¤To select all divisions, press {0}.";
/*  78 */   private static CharSequence ¤¤dStopAll = "¤Stop all divisions and clear targets ({0}).";
/*  79 */   private static CharSequence ¤¤dFireAtWill = "¤Toggle fire at will. Allows soldiers and artillery to fire at enemies within reach.";
/*  80 */   private static CharSequence ¤¤dFireStandGround = "¤When enabled, ranged units will stay put, and only attack targets that are within range, without attempting to walk into range first.";
/*     */   
/*  82 */   private static CharSequence ¤¤Attack = "¤To attack an enemy division, left click on it. If ranged, to attack an enemy division melee, hold {0} and left click.";
/*  83 */   private static CharSequence ¤¤MopUp = "¤When soldiers are in position, they'll break it and go chasing enemy soldiers or rioteers. Morale will be very weak while doing this.";
/*  84 */   private static CharSequence ¤¤Targets = "¤Potential targets";
/*  85 */   private static CharSequence ¤¤Run = "¤Run";
/*  86 */   private static CharSequence ¤¤RunD = "Toggles running. Your troops will be faster, but tire much quicker.";
/*     */   static {
/*  88 */     D.ts(UISelection.class);
/*     */   }
/*     */   
/*     */   public UISelection(InterManager m, final DivSelection s, boolean muster) {
/*  92 */     this.selection = s;
/*     */     
/*  94 */     this.section.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  98 */             GFORMAT.i(text, UISelection.this.men);
/*     */           }
/* 100 */         }).decrease().hh((SPRITE)(SPRITES.icons()).s.sword));
/*     */ 
/*     */     
/* 103 */     this.section.addRightC(64, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 107 */             GFORMAT.i(text, s.artillery.selection().size());
/*     */           }
/* 109 */         }).decrease().hh(((ROOM_ARTILLERY)(SETT.ROOMS()).ARTILLERY.get(0)).icon.small));
/*     */ 
/*     */     
/* 112 */     this.section.body().incrW(60.0D);
/*     */     
/* 114 */     this.section.addRelBody(5, DIR.S, (RENDEROBJ)makeCommands(muster));
/*     */     
/* 116 */     GPanel f = new GPanel();
/* 117 */     f.inner().set((BODY_HOLDER)this.section);
/*     */     
/* 119 */     f.body().centerX(C.DIM());
/* 120 */     f.body().moveY1(80.0D);
/* 121 */     this.section.body().centerIn((RECTANGLE)f.inner());
/* 122 */     f.setButt();
/* 123 */     this.section.add((RENDEROBJ)f);
/* 124 */     this.section.moveLastToBack();
/*     */     
/* 126 */     ACTION a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 130 */           UISelection.this.selection.clear();
/*     */         }
/*     */       };
/* 133 */     f.clickActionSet(a);
/*     */     
/* 135 */     pin();
/* 136 */     show(m);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 141 */     if ((this.selection.isClear() || this.men == 0) && this.selection.artillery.isClear())
/* 142 */       return false; 
/* 143 */     return this.section.hover(mCoo);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 148 */     if ((this.selection.isClear() || this.men == 0) && this.selection.artillery.isClear())
/*     */       return; 
/* 150 */     if (button == MButt.LEFT) {
/* 151 */       this.section.click();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/* 156 */     if ((this.selection.isClear() || this.men == 0) && this.selection.artillery.isClear())
/*     */       return; 
/* 158 */     this.section.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 163 */     if ((this.selection.isClear() || this.men == 0) && this.selection.artillery.isClear())
/* 164 */       return true; 
/* 165 */     this.section.render((SPRITE_RENDERER)r, ds);
/* 166 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 171 */     this.iFormationLoose = 0;
/* 172 */     this.iFormationTight = 0;
/* 173 */     this.iRunning = 0;
/* 174 */     this.iCharging = 0;
/* 175 */     this.iMustered = 0;
/*     */     
/* 177 */     this.iInGuard = 0;
/* 178 */     this.ifiresAtWill = 0;
/* 179 */     this.ifiresWait = 0;
/* 180 */     this.iMopping = 0;
/* 181 */     this.trajectories = 0;
/* 182 */     this.men = 0;
/* 183 */     this.hasRanged = false;
/* 184 */     this.iRangedHasAny = 0;
/* 185 */     Arrays.fill(this.iOutOfAmmo, 0);
/* 186 */     Arrays.fill(this.iRangedHas, 0);
/* 187 */     Arrays.fill(this.iRangedSelected, 0);
/*     */     
/* 189 */     for (Div d : this.selection.selection()) {
/* 190 */       (d.order()).task.get((Copyable)this.task);
/* 191 */       if ((d.settings()).running)
/* 192 */         this.iRunning++; 
/* 193 */       if ((d.settings()).formation == DIV_FORMATION.LOOSE)
/* 194 */         this.iFormationLoose++; 
/* 195 */       if ((d.settings()).formation == DIV_FORMATION.TIGHT) {
/* 196 */         this.iFormationTight++;
/*     */       }
/*     */       
/* 199 */       if (this.task.task() == BattleOrderTask.DIVTASK.CHARGE)
/* 200 */         this.iCharging++; 
/* 201 */       if (d.settings().mustering())
/* 202 */         this.iMustered++; 
/* 203 */       if (d.settings().moppingUp())
/* 204 */         this.iMopping++; 
/* 205 */       if ((d.settings()).guard)
/* 206 */         this.iInGuard++; 
/* 207 */       for (EquipRange a : STATS.EQUIP().RANGED()) {
/* 208 */         if (a.stat().div().get(d) > 0) {
/*     */           
/* 210 */           if (d.settings().ammo() == a) {
/* 211 */             this.iRangedSelected[a.tIndex] = this.iRangedSelected[a.tIndex] + 1;
/*     */           }
/* 213 */           if (a.ammoD(d) == 0.0D) {
/* 214 */             this.iOutOfAmmo[a.tIndex] = this.iOutOfAmmo[a.tIndex] + 1; continue;
/*     */           } 
/* 216 */           this.iRangedHas[a.tIndex] = this.iRangedHas[a.tIndex] + 1;
/* 217 */           this.iRangedHasAny++;
/* 218 */           this.hasRanged = true;
/* 219 */           if ((d.settings()).fireAtWill) {
/* 220 */             this.ifiresAtWill++;
/*     */           }
/*     */           
/* 223 */           if ((d.settings()).shouldNotMoveToFire) {
/* 224 */             this.ifiresWait++;
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 231 */       this.trajectories += BattleTrajectories.trajectories(d);
/*     */       
/* 233 */       this.men += d.menNrOf();
/*     */     } 
/* 235 */     for (ArtilleryInstance c : this.selection.artillery.selection()) {
/* 236 */       if (c.mustered())
/* 237 */         this.iMustered++; 
/* 238 */       if (c.fireAtWill()) {
/* 239 */         this.ifiresAtWill++;
/*     */       }
/* 241 */       this.iRangedHasAny++;
/*     */     } 
/*     */ 
/*     */     
/* 245 */     if ((KEYS.BATTLE()).FORM_LOOSE.consumeClick()) {
/* 246 */       loose();
/*     */     }
/* 248 */     if ((KEYS.BATTLE()).FORM_TIGHT.consumeClick()) {
/* 249 */       ltight();
/*     */     }
/* 251 */     if ((KEYS.BATTLE()).GUARD.consumeClick()) {
/* 252 */       guard();
/*     */     }
/* 254 */     if ((KEYS.MAIN()).ROTATE.consumeClick()) {
/* 255 */       run();
/*     */     }
/* 257 */     if ((KEYS.BATTLE()).CHARGE.consumeClick()) {
/* 258 */       charge();
/*     */     }
/* 260 */     return true;
/*     */   }
/*     */   
/*     */   private void loose() {
/* 264 */     for (Div d : this.selection.selection())
/* 265 */       (d.settings()).formation = DIV_FORMATION.LOOSE; 
/*     */   }
/*     */   
/*     */   private void ltight() {
/* 269 */     for (Div d : this.selection.selection())
/* 270 */       (d.settings()).formation = DIV_FORMATION.TIGHT; 
/*     */   }
/*     */   
/*     */   private void guard() {
/* 274 */     boolean charge = (this.iInGuard < this.selection.selection().size());
/* 275 */     for (Div d : this.selection.selection()) {
/* 276 */       (d.settings()).guard = charge;
/*     */     }
/*     */   }
/*     */   
/*     */   protected void run() {
/* 281 */     if (this.iRunning == this.selection.selection().size()) {
/* 282 */       for (Div d : this.selection.selection())
/* 283 */         (d.settings()).running = false; 
/*     */     } else {
/* 285 */       for (Div d : this.selection.selection()) {
/* 286 */         (d.settings()).running = true;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void charge() {
/* 296 */     for (Div d : this.selection.selection()) {
/* 297 */       if (this.iCharging > 0) {
/* 298 */         this.task.stop(d);
/*     */       } else {
/* 300 */         this.task.charge(d);
/* 301 */       }  (d.order()).task.set((Copyable)this.task);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private GuiSection makeCommands(boolean muster) {
/* 307 */     GuiSection sec = new GuiSection();
/* 308 */     sec.body().setWidth(240.0D);
/* 309 */     GGrid g = new GGrid(sec, 6);
/*     */ 
/*     */     
/* 312 */     g.add((RENDEROBJ)KeyButt.wrap((CLICKABLE)new BB((SPRITE)(SPRITES.icons()).m.b_for_loose)
/*     */           {
/*     */             protected void clickA() {
/* 315 */               UISelection.this.loose();
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 320 */               activeSet((UISelection.this.selection.selection().size() > 0));
/* 321 */               selectedSet((activeIs() && UISelection.this.iFormationLoose == UISelection.this.selection.selection().size()));
/*     */             }
/* 326 */           }(KEYS.BATTLE()).FORM_LOOSE));
/* 327 */     g.add((RENDEROBJ)KeyButt.wrap((CLICKABLE)new BB((SPRITE)(SPRITES.icons()).m.b_for_tight)
/*     */           {
/*     */             protected void clickA() {
/* 330 */               UISelection.this.ltight();
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 335 */               activeSet((UISelection.this.selection.selection().size() > 0));
/* 336 */               selectedSet((activeIs() && UISelection.this.iFormationTight == UISelection.this.selection.selection().size()));
/*     */             }
/* 338 */           }(KEYS.BATTLE()).FORM_TIGHT));
/*     */     
/* 340 */     g.skip();
/*     */     
/* 342 */     g.add((RENDEROBJ)KeyButt.wrap((CLICKABLE)new BB((SPRITE)(SPRITES.icons()).m.b_guard)
/*     */           {
/*     */             protected void clickA() {
/* 345 */               UISelection.this.guard();
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 350 */               activeSet((UISelection.this.selection.selection().size() > 0));
/* 351 */               selectedSet((activeIs() && UISelection.this.iInGuard == UISelection.this.selection.selection().size()));
/*     */             }
/* 353 */           }(KEYS.BATTLE()).GUARD));
/*     */     
/* 355 */     g.add((RENDEROBJ)(new BB((SPRITE)(SPRITES.icons()).m.b_run)
/*     */         {
/*     */           protected void clickA() {
/* 358 */             UISelection.this.run();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 363 */             activeSet((UISelection.this.selection.selection().size() > 0));
/* 364 */             selectedSet((activeIs() && UISelection.this.iRunning == UISelection.this.selection.selection().size()));
/*     */           }
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 368 */             Text t = text.text();
/* 369 */             t.insert(0, (KEYS.MAIN()).ROTATE.repr());
/* 370 */             text.add((SPRITE)t);
/*     */           }
/* 372 */         }).hoverTitleSet(¤¤Run).hoverInfoSet(¤¤RunD));
/*     */     
/* 374 */     g.add((RENDEROBJ)new BB((SPRITE)(SPRITES.icons()).m.b_stop)
/*     */         {
/*     */           
/*     */           protected void clickA()
/*     */           {
/* 379 */             for (Div d : UISelection.this.selection.selection()) {
/* 380 */               UISelection.this.task.stop(d);
/* 381 */               (d.order()).task.set((Copyable)UISelection.this.task);
/*     */             } 
/* 383 */             for (ArtilleryInstance c : UISelection.this.selection.artillery.selection()) {
/* 384 */               c.clearTarget();
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 390 */             activeSet(true);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 395 */             Text t = text.text();
/* 396 */             t.add(UISelection.¤¤dStopAll);
/* 397 */             t.insert(0, (KEYS.MAIN()).BACKSPACE.repr());
/* 398 */             text.add((SPRITE)t);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 404 */     g.NL();
/*     */ 
/*     */     
/* 407 */     g.add((RENDEROBJ)(new BB((SPRITE)(SPRITES.icons()).m.b_chase)
/*     */         {
/*     */           protected void clickA() {
/* 410 */             boolean shouldMuster = (UISelection.this.iMopping < UISelection.this.selection.selection().size());
/* 411 */             for (Div d : UISelection.this.selection.selection()) {
/* 412 */               if (d.menNrOf() > 0 && d.position().deployed() > 0)
/* 413 */                 d.settings().moppingSet(shouldMuster); 
/*     */             } 
/*     */           }
/*     */           
/*     */           protected void renAction() {
/* 418 */             activeSet(false);
/* 419 */             if (UISelection.this.selection.selection().size() > 0) {
/* 420 */               activeSet(true);
/* 421 */               boolean mustered = (UISelection.this.iMopping == UISelection.this.selection.selection().size());
/* 422 */               selectedSet(mustered);
/*     */ 
/*     */             
/*     */             }
/*     */           
/*     */           }
/* 428 */         }).hoverInfoSet(¤¤MopUp));
/*     */ 
/*     */ 
/*     */     
/* 432 */     g.add((RENDEROBJ)KeyButt.wrap((CLICKABLE)new BB((SPRITE)(SPRITES.icons()).m.b_charge)
/*     */           {
/*     */             protected void clickA() {
/* 435 */               UISelection.this.charge();
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 440 */               activeSet((UISelection.this.selection.selection().size() > 0));
/* 441 */               selectedSet((activeIs() && UISelection.this.iCharging == UISelection.this.selection.selection().size()));
/*     */             }
/* 443 */           }(KEYS.BATTLE()).CHARGE));
/*     */     
/* 445 */     g.skip();
/*     */     
/* 447 */     g.add((RENDEROBJ)new BB((SPRITE)(SPRITES.icons()).m.b_fire)
/*     */         {
/*     */           
/*     */           protected void clickA()
/*     */           {
/* 452 */             boolean charge = (UISelection.this.ifiresAtWill == 0);
/* 453 */             for (Div d : UISelection.this.selection.selection()) {
/* 454 */               (d.settings()).fireAtWill = charge;
/*     */             }
/* 456 */             for (ArtilleryInstance c : UISelection.this.selection.artillery.selection()) {
/* 457 */               c.fireAtWill(charge);
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 463 */             GBox b = (GBox)text;
/* 464 */             text.text(UISelection.¤¤dFireAtWill);
/* 465 */             b.NL(8);
/* 466 */             b.textL(UISelection.¤¤Targets);
/* 467 */             b.add((SPRITE)GFORMAT.i(b.text(), UISelection.this.trajectories));
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 472 */             activeSet(UISelection.this.hasRanged);
/* 473 */             selectedSet((UISelection.this.ifiresAtWill > 0));
/*     */           }
/*     */         });
/*     */     
/* 477 */     g.add((RENDEROBJ)(new BB((SPRITE)(SPRITES.icons()).m.b_fire_stop)
/*     */         {
/*     */           
/*     */           protected void clickA()
/*     */           {
/* 482 */             boolean charge = (UISelection.this.ifiresWait == 0);
/* 483 */             for (Div d : UISelection.this.selection.selection()) {
/* 484 */               (d.settings()).shouldNotMoveToFire = charge;
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 490 */             activeSet((UISelection.this.iRangedHasAny > 0));
/* 491 */             selectedSet((UISelection.this.ifiresWait > 0));
/*     */           }
/* 493 */         }).hoverInfoSet(¤¤dFireStandGround));
/*     */ 
/*     */ 
/*     */     
/* 497 */     final GuiSection s = new GuiSection();
/* 498 */     for (EquipRange a : STATS.EQUIP().RANGED()) {
/*     */ 
/*     */       
/* 501 */       s.addDownC(0, (RENDEROBJ)(new BB((SPRITE)a.resource.icon())
/*     */           {
/*     */             protected void clickA() {
/* 504 */               for (Div d : UISelection.this.selection.selection()) {
/* 505 */                 if (a.stat().div().get(d) > 0)
/* 506 */                   (d.settings()).ammoI = a.tIndex; 
/*     */               } 
/* 508 */               (VIEW.inters()).popup.close();
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 513 */               activeSet((UISelection.this.iRangedHas[a.tIndex] > 0));
/* 514 */               selectedSet((activeIs() && UISelection.this.iRangedSelected[a.tIndex] > 0));
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 520 */               super.render(r, ds, isActive, isSelected, isHovered);
/* 521 */               if (UISelection.this.iOutOfAmmo[a.tIndex] > 0) {
/* 522 */                 OPACITY.O0To25.bind();
/* 523 */                 COLOR.BLACK.render(r, (RECTANGLE)this.body);
/* 524 */                 OPACITY.unbind();
/*     */               } 
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 532 */               a.hover(text);
/* 533 */               int ammo = 0;
/*     */               
/* 535 */               for (Div d : UISelection.this.selection.selection())
/*     */               {
/* 537 */                 ammo = (int)(ammo + a.ammoPerMan(d));
/*     */               }
/*     */ 
/*     */               
/* 541 */               GBox b = (GBox)text;
/*     */               
/* 543 */               b.textLL(Dic.¤¤Ammunition);
/* 544 */               b.tab(6);
/* 545 */               b.add((SPRITE)GFORMAT.i(b.text(), ammo));
/*     */               
/* 547 */               if (UISelection.this.iOutOfAmmo[a.tIndex] > 0) {
/* 548 */                 Str.TMP.clear().add(Dic.¤¤ReloadingXX);
/* 549 */                 Str.TMP.insert(0, a.ammoReplenishHours * TIME.secondsPerHour(), 4);
/* 550 */                 text.text((CharSequence)Str.TMP);
/*     */               
/*     */               }
/*     */             
/*     */             }
/* 555 */           }).hoverInfoSet(a.resource.name));
/*     */     } 
/*     */ 
/*     */     
/* 559 */     SPRITE.Imp imp = new SPRITE.Imp(24)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 563 */           EquipRange bb = null;
/* 564 */           for (EquipRange a : STATS.EQUIP().RANGED()) {
/* 565 */             if (UISelection.this.iRangedSelected[a.tIndex] > 0 && (bb == null || UISelection.this.iRangedSelected[a.tIndex] > UISelection.this.iRangedSelected[bb.tIndex]))
/* 566 */               bb = a; 
/*     */           } 
/* 568 */           if (bb != null) {
/* 569 */             (UI.icons()).s.chevron(DIR.S).renderCX(r, X1 + (X2 - X1) / 2, Y2);
/* 570 */             bb.resource.icon().render(r, X1, X2, Y1, Y2);
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 576 */     g.add((RENDEROBJ)new BB((SPRITE)imp)
/*     */         {
/*     */           protected void clickA() {
/* 579 */             (VIEW.inters()).popup.show((RENDEROBJ)s, (CLICKABLE)this);
/* 580 */             super.clickA();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 585 */             EquipRange bb = null;
/* 586 */             for (EquipRange a : STATS.EQUIP().RANGED()) {
/* 587 */               if (UISelection.this.iRangedSelected[a.tIndex] > 0 && (bb == null || UISelection.this.iRangedSelected[a.tIndex] > UISelection.this.iRangedSelected[bb.tIndex]))
/* 588 */                 bb = a; 
/*     */             } 
/* 590 */             activeSet((bb != null));
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 598 */     s = new GuiSection();
/* 599 */     s.addRightC(0, (RENDEROBJ)new HOVERABLE.Sprite((SPRITE)(SPRITES.icons()).m.questionmark)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 603 */             text.text(UISelection.¤¤dPosition);
/* 604 */             text.NL(4);
/*     */ 
/*     */             
/* 607 */             Text t = text.text();
/* 608 */             t.add(UISelection.¤¤dAdd);
/* 609 */             t.insert(0, (KEYS.MAIN()).UNDO.repr());
/* 610 */             text.add((SPRITE)t);
/* 611 */             text.NL(4);
/*     */             
/* 613 */             t = text.text();
/* 614 */             t.add(UISelection.¤¤dMove);
/* 615 */             t.insert(0, (KEYS.BATTLE()).UP.repr());
/* 616 */             text.add((SPRITE)t);
/* 617 */             text.NL(4);
/*     */             
/* 619 */             t = text.text();
/* 620 */             t.add(UISelection.¤¤dSpin);
/* 621 */             t.insert(0, (KEYS.MAIN()).MOD.repr());
/* 622 */             text.add((SPRITE)t);
/* 623 */             text.NL(4);
/*     */             
/* 625 */             t = text.text();
/* 626 */             t.add(UISelection.¤¤Attack);
/* 627 */             t.insert(0, (KEYS.MAIN()).UNDO.repr());
/* 628 */             text.add((SPRITE)t);
/* 629 */             text.NL(4);
/*     */             
/* 631 */             t = text.text();
/* 632 */             t.add(UISelection.¤¤dSelectAll);
/* 633 */             t.insert(0, (KEYS.BATTLE()).SELECT_ALL.repr());
/* 634 */             text.add((SPRITE)t);
/* 635 */             text.NL(4);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 644 */     if (muster) {
/* 645 */       s.addDownC(0, (RENDEROBJ)new BB((SPRITE)(SPRITES.icons()).m.b_muster)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 649 */               boolean shouldMuster = (UISelection.this.iMustered < UISelection.this.selection.allSelected());
/* 650 */               for (Div d : UISelection.this.selection.selection()) {
/* 651 */                 if (shouldMuster && d.menNrOf() > 0 && d.position().deployed() > 0) {
/* 652 */                   d.settings().musteringSet(shouldMuster); continue;
/* 653 */                 }  if (!shouldMuster)
/* 654 */                   d.settings().musteringSet(false); 
/* 655 */               }  for (ArtilleryInstance c : UISelection.this.selection.artillery.selection()) {
/* 656 */                 c.muster(shouldMuster);
/*     */               }
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 662 */               boolean mustered = (UISelection.this.iMustered == UISelection.this.selection.allSelected());
/* 663 */               selectedSet(mustered);
/* 664 */               if (!mustered) {
/* 665 */                 activeSet(!(positions() != 0 && UISelection.this.selection.artillery.selection().size() <= 0));
/*     */               } else {
/* 667 */                 activeSet(true);
/*     */               } 
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 673 */               GBox b = (GBox)text;
/* 674 */               b.title(Dic.¤¤Muster);
/* 675 */               b.text(BattlePanel.¤¤MusterDesc);
/* 676 */               b.NL(8);
/*     */               
/* 678 */               int p = positions();
/* 679 */               if (p > 0) {
/* 680 */                 if (UISelection.this.selection.selection().size() == 1) {
/* 681 */                   b.error(BattlePanel.¤¤MusterProblem);
/*     */                 } else {
/* 683 */                   b.error(BattlePanel.¤¤MusterOneProblem);
/*     */                 } 
/*     */               }
/*     */             }
/*     */ 
/*     */             
/*     */             private int positions() {
/* 690 */               int i = 0;
/* 691 */               for (Div d : UISelection.this.selection.selection()) {
/* 692 */                 if (d.menNrOf() > 0) {
/* 693 */                   (d.order()).dest.get((Copyable)UISelection.this.tmp);
/* 694 */                   if (UISelection.this.tmp.deployed() == 0)
/* 695 */                     i++; 
/*     */                 } 
/*     */               } 
/* 698 */               return i;
/*     */             }
/*     */           });
/*     */     }
/*     */     
/* 703 */     g.section.addRelBody(8, DIR.W, (RENDEROBJ)s);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 708 */     return g.section;
/*     */   }
/*     */   
/*     */   static class BB
/*     */     extends GButt.ButtPanel {
/*     */     public BB(SPRITE label) {
/* 714 */       super(label);
/* 715 */       setDim(40, 40);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\UISelection.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */