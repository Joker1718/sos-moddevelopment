/*     */ package view.ui.div;
/*     */ 
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.Arrays;
/*     */ import settlement.room.military.training.ROOM_M_TRAINER;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.INT;
/*     */ import util.gui.common.UIPickerRace;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GAllocator;
/*     */ import util.gui.table.GRows;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class UIDivEditor
/*     */   extends GuiSection
/*     */ {
/*     */   private static final int width = 150;
/*     */   private static final int height = 42;
/*     */   private final Stats div;
/*  56 */   private final ArrayListGrower<Changer> changes = new ArrayListGrower();
/*     */   
/*     */   private final boolean changeOverlay;
/*     */   
/*     */   private final UIPickerRace race;
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  63 */     if (this.race.race() != this.div.race()) {
/*  64 */       this.race.set(this.div.race());
/*     */     }
/*  66 */     super.render(r, ds);
/*     */   }
/*     */ 
/*     */   
/*  70 */   private final UIDivBannerEditor ee = new UIDivBannerEditor();
/*     */   
/*     */   public DIV_SPEC.DIV_SPECE div() {
/*  73 */     return this.div;
/*     */   }
/*     */   
/*     */   public void clearChanges() {
/*  77 */     for (Changer c : this.changes)
/*  78 */       c.init(); 
/*     */   }
/*     */   
/*     */   public void copyChanges(DIV_SPEC.DIV_SPECE to) {
/*  82 */     for (Changer c : this.changes) {
/*  83 */       if (c.isChanged())
/*  84 */         c.copyTo(to); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean hasChanges() {
/*  89 */     for (Changer c : this.changes) {
/*  90 */       if (c.isChanged())
/*  91 */         return true; 
/*  92 */     }  return false;
/*     */   }
/*     */   
/*     */   public UIDivEditor(double maxTraining, boolean name, boolean experience, boolean changeOverlay, LIST<Race> races) {
/*  96 */     this.changeOverlay = changeOverlay;
/*  97 */     int xs = 3;
/*  98 */     int ys = 6;
/*  99 */     this.race = new UIPickerRace(races)
/*     */       {
/*     */         public void hover(GBox b, Race race)
/*     */         {
/* 103 */           b.title(race.info.names);
/* 104 */           b.text(race.info.desc);
/* 105 */           b.sep();
/*     */           
/* 107 */           race.boosts.hover((GUI_BOX)b, 1.0D, null, (BOOSTABLES.BATTLE()).filter, -1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int ri) {
/* 112 */           super.set(ri);
/* 113 */           Race r = race();
/* 114 */           UIDivEditor.this.div.raceSet(r);
/*     */           
/* 116 */           for (int ei = 0; ei < STATS.EQUIP().BATTLE_ALL().size(); ei++) {
/* 117 */             EquipBattle e = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(ei);
/* 118 */             if (!e.allowed(r)) {
/* 119 */               UIDivEditor.this.div.equipSet(e, 0.0D);
/*     */             }
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 127 */     this.div = new Stats(maxTraining);
/* 128 */     this.div.raceSet(this.race.race());
/* 129 */     this.div.name.clear().add((CharSequence)(this.div.race()).info.armyNames.rnd());
/* 130 */     if (name) {
/*     */       
/* 132 */       GInput gInput = new GInput(new StringInputSprite(20, (UI.FONT()).H2)
/*     */           {
/*     */             public void renAction() {
/* 135 */               text().clear().add((CharSequence)UIDivEditor.this.div.name);
/*     */             }
/*     */ 
/*     */             
/*     */             protected void change() {
/* 140 */               UIDivEditor.this.div.name.clear().add((CharSequence)text());
/*     */             }
/*     */           });
/*     */       
/* 144 */       Changer changer = new Changer(this, null)
/*     */         {
/* 146 */           final Str str = new Str(24);
/*     */ 
/*     */           
/*     */           void copyTo(DIV_SPEC.DIV_SPECE to) {
/* 150 */             to.nameE().clear().add(UIDivEditor.this.div.name());
/*     */           }
/*     */ 
/*     */           
/*     */           void init() {
/* 155 */             this.str.clear().add(UIDivEditor.this.div.name());
/*     */           }
/*     */ 
/*     */           
/*     */           boolean isChanged() {
/* 160 */             return !Str.isSame((CharSequence)this.str, UIDivEditor.this.div.name());
/*     */           }
/*     */         };
/* 163 */       add(change(changer, (RENDEROBJ)gInput));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 168 */     GuiSection s = new GuiSection();
/* 169 */     Changer ch = new Changer(this, null)
/*     */       {
/* 171 */         int i = -1;
/*     */ 
/*     */         
/*     */         void init() {
/* 175 */           this.i = UIDivEditor.this.ee.bannerI();
/*     */         }
/*     */ 
/*     */         
/*     */         boolean isChanged() {
/* 180 */           return (this.i != UIDivEditor.this.ee.bannerI());
/*     */         }
/*     */ 
/*     */         
/*     */         void copyTo(DIV_SPEC.DIV_SPECE to) {
/* 185 */           to.bannerISet(UIDivEditor.this.div.bannerI());
/*     */         }
/*     */       };
/* 188 */     s.add(change(ch, (RENDEROBJ)this.ee.butt()));
/*     */     
/* 190 */     ch = new Changer(this, this.div.race)
/*     */       {
/*     */         void copyTo(DIV_SPEC.DIV_SPECE to)
/*     */         {
/* 194 */           to.raceSet(UIDivEditor.this.div.race());
/*     */         }
/*     */       };
/* 197 */     s.addRightC(8, change(ch, (RENDEROBJ)this.race.section));
/*     */ 
/*     */     
/* 200 */     GStat st = new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 204 */           GFORMAT.i(text, UIDivEditor.this.div.men());
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GBox b) {
/* 210 */           b.title(Dic.¤¤SoldiersTarget);
/* 211 */           b.add((SPRITE)GFORMAT.i(b.text(), UIDivEditor.this.div.men()));
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 216 */     ch = new Changer(this, this.div.men)
/*     */       {
/*     */         void copyTo(DIV_SPEC.DIV_SPECE to)
/*     */         {
/* 220 */           to.menSet(UIDivEditor.this.div.men());
/*     */         }
/*     */       };
/* 223 */     s.addRightC(8, change(ch, (RENDEROBJ)new Spec((SPRITE)(SPRITES.icons()).m.citizen, (COLOR)COLOR.GREEN100.makeSaturated(0.7D), (INT.INTE)this.div.men, st)));
/*     */ 
/*     */     
/* 226 */     s.addRelBody(2, DIR.E, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).m.cancel)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 230 */             UIDivEditor.this.div.clear();
/*     */           }
/* 233 */         }).setDim(32, s.getLast().height()).hoverInfoSet(Dic.¤¤Clear));
/*     */ 
/*     */     
/* 236 */     addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 242 */     GRows rows = new GRows(xs);
/*     */     
/* 244 */     if (experience) {
/* 245 */       GStat gStat = new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 249 */             GFORMAT.perc(text, UIDivEditor.this.div.experience());
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 256 */             b.title(((STATS.BATTLE()).COMBAT_EXPERIENCE.info()).name);
/* 257 */             b.add((SPRITE)GFORMAT.perc(b.text(), UIDivEditor.this.div.experience()));
/* 258 */             b.NL();
/* 259 */             b.text(((STATS.BATTLE()).COMBAT_EXPERIENCE.info()).desc);
/* 260 */             b.sep();
/* 261 */             (STATS.BATTLE()).COMBAT_EXPERIENCE.boosters.hover((GUI_BOX)b, 1.0D, -1);
/* 262 */             (VIEW.inters()).mouseMessage.setAbove();
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 267 */       Changer changer = new Changer(this, this.div.experience)
/*     */         {
/*     */           void copyTo(DIV_SPEC.DIV_SPECE to)
/*     */           {
/* 271 */             to.experienceSet(UIDivEditor.this.div.experience());
/*     */           }
/*     */         };
/* 274 */       rows.add(change(changer, (RENDEROBJ)new Spec(((STATS.BATTLE()).COMBAT_EXPERIENCE.info()).icon, (COLOR)COLOR.RED100.makeSaturated(0.7D), (INT.INTE)this.div.experience, gStat)));
/*     */     } 
/*     */ 
/*     */     
/* 278 */     for (ROOM_M_TRAINER<?> t : (Iterable<ROOM_M_TRAINER<?>>)ROOM_M_TRAINER.ALL()) {
/*     */       
/* 280 */       GStat gStat = new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 284 */             GFORMAT.perc(text, UIDivEditor.this.div.training(t.training()));
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 290 */             b.title(t.tInfo.name);
/* 291 */             b.add((SPRITE)GFORMAT.perc(b.text(), UIDivEditor.this.div.training(t.training())));
/* 292 */             b.NL();
/* 293 */             b.text(t.tInfo.desc);
/* 294 */             b.sep();
/* 295 */             t.boosters.hover((GUI_BOX)b, 1.0D, -1);
/* 296 */             (VIEW.inters()).mouseMessage.setAbove();
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 301 */       Changer changer = new Changer(this, this.div.traini(t.training()))
/*     */         {
/*     */           void copyTo(DIV_SPEC.DIV_SPECE to)
/*     */           {
/* 305 */             to.trainingSet(t.training(), UIDivEditor.this.div.training(t.training()));
/*     */           }
/*     */         };
/* 308 */       rows.add(change(changer, (RENDEROBJ)new Spec((SPRITE)t.icon, (COLOR)COLOR.RED100.makeSaturated(0.7D), (INT.INTE)this.div.traini(t.training()), gStat)));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 316 */     for (EquipBattle m : STATS.EQUIP().BATTLE_ALL()) {
/* 317 */       GStat gStat = new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 321 */             GFORMAT.i(text, (UIDivEditor.this.div.men() * UIDivEditor.this.div.equipi(m).get()));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 326 */             m.hover((GUI_BOX)b);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 331 */       Spec sp = new Spec((SPRITE)m.resource().icon(), (COLOR)COLOR.ORANGE100.makeSaturated(0.7D), (INT.INTE)this.div.equipi(m), gStat)
/*     */         {
/*     */ 
/*     */           
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 337 */             super.render(r, ds);
/* 338 */             if (disabled()) {
/* 339 */               OPACITY.O50.bind();
/* 340 */               COLOR.BLACK.render(r, (RECTANGLE)body(), -1);
/* 341 */               OPACITY.unbind();
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           private boolean disabled() {
/* 347 */             if (UIDivEditor.this.div.equipi(m).get() == 0 && 
/* 348 */               !UIDivEditor.this.div.canSet(m)) {
/* 349 */               return true;
/*     */             }
/* 351 */             return false;
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 356 */             GBox b = (GBox)text;
/* 357 */             if (!m.allowed(UIDivEditor.this.div.race())) {
/* 358 */               b.error(EquipBattle.¤¤raceProblem);
/* 359 */             } else if (disabled()) {
/* 360 */               b.error(EquipBattle.¤¤combineProblem);
/*     */             } else {
/*     */               
/* 363 */               super.hoverInfoGet(text);
/*     */             } 
/* 365 */             b.NL(8);
/* 366 */             (VIEW.inters()).mouseMessage.setAbove();
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean click() {
/* 371 */             if (!m.allowed(UIDivEditor.this.div.race()))
/* 372 */               return false; 
/* 373 */             return super.click();
/*     */           }
/*     */         };
/*     */       
/* 377 */       Changer changer = new Changer(this, this.div.equipi(m))
/*     */         {
/*     */           void copyTo(DIV_SPEC.DIV_SPECE to)
/*     */           {
/* 381 */             to.equipSet(m, UIDivEditor.this.div.equip(m));
/*     */           }
/*     */         };
/*     */       
/* 385 */       rows.add(change(changer, (RENDEROBJ)sp));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 391 */     if (rows.rows().size() > ys) {
/* 392 */       addRelBody(8, DIR.S, (RENDEROBJ)(new GScrollRows((Iterable)rows.rows(), 42 * ys)).view());
/*     */     } else {
/* 394 */       boolean first = true;
/* 395 */       for (RENDEROBJ o : rows.rows()) {
/* 396 */         addRelBody(first ? 8 : 0, DIR.S, o);
/* 397 */         first = false;
/*     */       } 
/*     */     } 
/*     */     
/* 401 */     addRelBody(8, DIR.S, (RENDEROBJ)(new UIDivStats()).get((DIV_SPEC)this.div));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Spec
/*     */     extends GuiSection
/*     */   {
/*     */     private final GStat stat;
/*     */ 
/*     */ 
/*     */     
/*     */     public Spec(SPRITE icon, COLOR col, INT.INTE ii, GStat stat) {
/* 415 */       GAllocator g = new GAllocator(col, ii, 6, 12);
/*     */       
/* 417 */       body().setDim(150.0D, 42.0D);
/*     */       
/* 419 */       addC(icon, 20, body().cY());
/*     */       
/* 421 */       add((SPRITE)stat, 48, body().cY() - stat.height());
/* 422 */       add((RENDEROBJ)g, 40, body().cY() + 2);
/* 423 */       if (body().width() > 150) {
/* 424 */         body().incrW(4.0D);
/*     */       }
/* 426 */       this.stat = stat;
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 431 */       super.hoverInfoGet(text);
/* 432 */       if (text.emptyIs()) {
/* 433 */         this.stat.hoverInfoGet((GBox)text);
/*     */       }
/*     */     }
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 438 */       GCOLOR.UI().bg().render(r, (RECTANGLE)body());
/* 439 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/* 440 */       super.render(r, ds);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private abstract class Changer
/*     */   {
/* 448 */     int old = -1;
/*     */     private final INT.IntImp ii;
/*     */     
/*     */     Changer(INT.IntImp ii) {
/* 452 */       this.ii = ii;
/*     */     }
/*     */     
/*     */     void init() {
/* 456 */       this.old = this.ii.get();
/*     */     }
/*     */     
/*     */     boolean isChanged() {
/* 460 */       return (this.old != this.ii.get());
/*     */     }
/*     */ 
/*     */     
/*     */     abstract void copyTo(DIV_SPEC.DIV_SPECE param1DIV_SPECE);
/*     */   }
/*     */   
/*     */   private RENDEROBJ change(final Changer ch, RENDEROBJ ob) {
/* 468 */     GuiSection s = new GuiSection();
/* 469 */     s.add(ob);
/* 470 */     if (this.changeOverlay) {
/* 471 */       RENDEROBJ.RenderImp r = new RENDEROBJ.RenderImp(ob.body().width(), ob.body().height())
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 475 */             if (ch.isChanged())
/* 476 */               (UI.icons()).s.alert.renderC(r, body().x2() - 10, body().y1() + 10); 
/*     */           }
/*     */         };
/* 479 */       s.add((RENDEROBJ)r, 0, 0);
/*     */     } 
/*     */     
/* 482 */     this.changes.add(ch);
/* 483 */     return (RENDEROBJ)s;
/*     */   }
/*     */   
/*     */   private class Stats
/*     */     implements DIV_SPEC.DIV_SPECE
/*     */   {
/* 489 */     public final INT.IntImp[] training = new INT.IntImp[(STATS.BATTLE()).TRAINING_ALL.size()];
/* 490 */     public final Gear[] gear = new Gear[STATS.EQUIP().BATTLE_ALL().size()];
/* 491 */     public final INT.IntImp men = new INT.IntImp(1, (int)Math.ceil(((Config.battle()).MEN_PER_DIVISION / 10)));
/* 492 */     public final INT.IntImp experience = new INT.IntImp(0, 4);
/* 493 */     public INT.IntImp race = new INT.IntImp();
/* 494 */     public Str name = (new Str(24)).add(Dic.¤¤rename);
/* 495 */     public INT.IntImp faction = new INT.IntImp();
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
/*     */     private final double[] slots;
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
/*     */     public Stats(final double maxTraining) {
/* 520 */       this.slots = new double[8]; this.men.setD(0.75D); int i; for (i = 0; i < this.gear.length; i++)
/*     */         this.gear[i] = new Gear(i, this.gear);  for (i = 0; i < this.training.length; i++) { this.training[i] = new INT.IntImp(0, 10) { public int max() { int am = (int)(maxTraining * 10.0D); byte b; int i; INT.IntImp[] arrayOfIntImp; for (i = (arrayOfIntImp = UIDivEditor.Stats.this.training).length, b = 0; b < i; ) { INT.IntImp ii = arrayOfIntImp[b]; if (ii != this)
/*     */                   am -= ii.get();  b++; }  return CLAMP.i(am, 0, 10); } }; } 
/* 523 */     } private void setSlots() { Arrays.fill(this.slots, 0.0D); byte b; int i; Gear[] arrayOfGear;
/* 524 */       for (i = (arrayOfGear = this.gear).length, b = 0; b < i; ) { Gear g = arrayOfGear[b];
/* 525 */         if (g.get() > 0)
/* 526 */           for (int si = 0; si < this.slots.length; si++) {
/* 527 */             this.slots[si] = this.slots[si] + ((EquipBattle)STATS.EQUIP().BATTLE_ALL().get(g.gi)).slotUse(si);
/*     */           } 
/*     */         b++; }
/*     */        }
/*     */ 
/*     */     
/*     */     public boolean canSet(EquipBattle m) {
/* 534 */       if (!m.allowed((Race)RACES.all().get(this.race.get())))
/* 535 */         return false; 
/* 536 */       setSlots();
/* 537 */       for (int si = 0; si < this.slots.length; si++) {
/* 538 */         if (this.slots[si] + m.slotUse(si) > 1.0D) {
/* 539 */           return false;
/*     */         }
/*     */       } 
/* 542 */       return true;
/*     */     }
/*     */     
/*     */     private class Gear
/*     */       extends INT.IntImp {
/*     */       private final int gi;
/*     */       private final Gear[] other;
/*     */       
/*     */       Gear(int gi, Gear[] other) {
/* 551 */         super(0, ((EquipBattle)STATS.EQUIP().BATTLE_ALL().get(gi)).max());
/* 552 */         this.gi = gi;
/* 553 */         this.other = other;
/*     */       }
/*     */ 
/*     */       
/*     */       public void set(int t) {
/* 558 */         EquipBattle s = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(this.gi);
/* 559 */         if (t > 0) {
/* 560 */           Arrays.fill(UIDivEditor.Stats.this.slots, 0.0D); byte b; int i; Gear[] arrayOfGear;
/* 561 */           for (i = (arrayOfGear = UIDivEditor.Stats.this.gear).length, b = 0; b < i; ) { Gear g = arrayOfGear[b];
/* 562 */             if (g.get() > 0)
/* 563 */               for (int si = 0; si < UIDivEditor.Stats.this.slots.length; si++) {
/* 564 */                 if (g != this)
/* 565 */                   UIDivEditor.Stats.this.slots[si] = UIDivEditor.Stats.this.slots[si] + ((EquipBattle)STATS.EQUIP().BATTLE_ALL().get(g.gi)).slotUse(si); 
/*     */               }  
/*     */             b++; }
/*     */           
/* 569 */           for (int oi = 0; oi < STATS.EQUIP().BATTLE_ALL().size(); oi++) {
/* 570 */             EquipBattle o = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(oi);
/* 571 */             if (s != o) {
/* 572 */               for (int si = 0; si < UIDivEditor.Stats.this.slots.length; si++) {
/* 573 */                 if (UIDivEditor.Stats.this.slots[si] + s.slotUse(si) > 1.0D && o.slotUse(si) > 0.0D && this.other[oi].get() > 0) {
/* 574 */                   this.other[o.indexMilitary()].set(0);
/* 575 */                   UIDivEditor.Stats.this.slots[si] = UIDivEditor.Stats.this.slots[si] - o.slotUse(si);
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 587 */         super.set(t);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double training(StatsBattle.StatTraining tr) {
/* 594 */       return this.training[tr.tIndex].get() / 10.0D;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public INT.IntImp equipi(EquipBattle e) {
/* 602 */       return this.gear[e.indexMilitary()];
/*     */     }
/*     */     
/*     */     public INT.IntImp traini(StatsBattle.StatTraining tr) {
/* 606 */       return this.training[tr.tIndex];
/*     */     }
/*     */ 
/*     */     
/*     */     public double equip(EquipBattle e) {
/* 611 */       return this.gear[e.indexMilitary()].getD();
/*     */     }
/*     */ 
/*     */     
/*     */     public int men() {
/* 616 */       return this.men.get() * 10;
/*     */     }
/*     */ 
/*     */     
/*     */     public Race race() {
/* 621 */       return (Race)RACES.all().get(this.race.get());
/*     */     }
/*     */ 
/*     */     
/*     */     public void raceSet(Race race) {
/* 626 */       this.race.set(race.index);
/* 627 */       UIDivEditor.this.race.set(race);
/*     */     }
/*     */ 
/*     */     
/*     */     public double experience() {
/* 632 */       return this.experience.getD();
/*     */     }
/*     */ 
/*     */     
/*     */     public Faction faction() {
/* 637 */       return FACTIONS.getByIndex(this.faction.get());
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence name() {
/* 642 */       return (CharSequence)this.name;
/*     */     }
/*     */ 
/*     */     
/*     */     public int bannerI() {
/* 647 */       return UIDivEditor.this.ee.bannerI(); } public void clear() {
/*     */       byte b;
/*     */       int i;
/*     */       Gear[] arrayOfGear;
/* 651 */       for (i = (arrayOfGear = this.gear).length, b = 0; b < i; ) { INT.IntImp ii = arrayOfGear[b];
/* 652 */         ii.set(0); b++; }
/* 653 */        INT.IntImp[] arrayOfIntImp; for (i = (arrayOfIntImp = this.training).length, b = 0; b < i; ) { INT.IntImp ii = arrayOfIntImp[b];
/* 654 */         ii.set(0); b++; }
/* 655 */        this.experience.set(0);
/*     */     }
/*     */ 
/*     */     
/*     */     public void menSet(int men) {
/* 660 */       this.men.setD(men / (Config.battle()).MEN_PER_DIVISION);
/*     */     }
/*     */ 
/*     */     
/*     */     public void experienceSet(double experience) {
/* 665 */       this.experience.setD(experience);
/*     */     }
/*     */ 
/*     */     
/*     */     public Str nameE() {
/* 670 */       return this.name;
/*     */     }
/*     */ 
/*     */     
/*     */     public void bannerISet(int bannerI) {
/* 675 */       UIDivEditor.this.ee.bannerISet(bannerI);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void trainingSet(StatsBattle.StatTraining tr, double d) {
/* 682 */       this.training[tr.tIndex].set((int)Math.round(d * 10.0D));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void equipSet(EquipBattle e, double d) {
/* 688 */       this.gear[e.indexMilitary()].setD(d);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void factionSet(Faction faction) {
/* 694 */       this.faction.set((faction == null) ? 0 : faction.index());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDivEditor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */