/*     */ package settlement.entry;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BoosterImp;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.player.Player;
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CLIMATES;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import settlement.stats.standing.StandingCitizen;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.updating.IUpdater;
/*     */ import world.WORLD;
/*     */ 
/*     */ public class Immigration {
/*     */   public static final int MAX_POPULATION = 40000;
/*  43 */   private final Immigrator[] imms = new Immigrator[RACES.all().size()];
/*     */   
/*     */   boolean killall = false;
/*  46 */   private int killAllI = 0;
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
/*     */   private final IUpdater updater;
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
/*     */   final SAVABLE saver;
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
/*     */   private static abstract class Bo
/*     */     extends BoosterImp
/*     */   {
/*     */     public Bo(BSourceInfo info, double from, double to, boolean isMul) {
/*  86 */       super(info, from, to, isMul);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(HCLASS_RACE popTime) {
/*  91 */       if (popTime.cl != HCLASSES.CITIZEN()) {
/*  92 */         return vNOPInput();
/*     */       }
/*  94 */       if (popTime.race == null) {
/*  95 */         double tot = 0.0D;
/*  96 */         double res = 0.0D;
/*  97 */         for (Race r : RACES.all()) {
/*  98 */           double p = POP.pop(popTime.cl, r);
/*  99 */           tot += p;
/* 100 */           res += p * vGet(HCLASS_RACE.clP(r, popTime.cl));
/*     */         } 
/* 102 */         if (tot == 0.0D)
/* 103 */           return vNOPInput(); 
/* 104 */         return res / tot;
/*     */       } 
/*     */       
/* 107 */       if (WORLD.camps().available(popTime.race)) {
/* 108 */         return w(popTime.race);
/*     */       }
/* 110 */       return g(popTime.race);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Player f) {
/* 115 */       return vGet(HCLASS_RACE.clP(null, HCLASSES.CITIZEN()));
/*     */     }
/*     */     protected abstract double g(Race param1Race);
/*     */     
/*     */     protected double w(Race race) {
/* 120 */       return vNOPInput();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void update(double ds) {
/* 128 */     if (this.killall) {
/*     */       
/* 130 */       for (int k = 0; k < 10; k++) {
/* 131 */         int i = this.killAllI;
/* 132 */         ENTITY e = SETT.ENTITIES().getAllEnts()[i];
/* 133 */         if (e != null && e instanceof Humanoid) {
/* 134 */           Humanoid a = (Humanoid)e;
/* 135 */           (SETT.THINGS()).gore.cloud(SETT.ENTITIES().getAllEnts()[i], (a.race().appearance()).colors.blood);
/* 136 */           (SETT.THINGS()).gore.explode(SETT.ENTITIES().getAllEnts()[i], (a.race().appearance()).colors.blood);
/* 137 */           SETT.ENTITIES().getAllEnts()[i].helloMyNameIsInigoMontoyaYouKilledMyFatherPrepareToDie();
/*     */         } 
/* 139 */         this.killAllI++;
/* 140 */         if (this.killAllI >= (SETT.ENTITIES().getAllEnts()).length) {
/* 141 */           this.killAllI = 0;
/*     */         }
/*     */       } 
/*     */       return;
/*     */     } 
/* 146 */     this.updater.update(ds);
/*     */   }
/*     */   
/*     */   Immigration() {
/* 150 */     this.updater = new IUpdater(this.imms.length, 30.0D)
/*     */       {
/*     */         protected void update(int i, double timeSinceLast)
/*     */         {
/* 154 */           Immigration.this.imms[i].update(timeSinceLast);
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
/* 205 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/* 209 */           Immigration.this.updater.save(file);
/* 210 */           RACES.map().saver().save((SAVABLE[])Immigration.this.imms, file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 215 */           Immigration.this.updater.load(file);
/* 216 */           RACES.map().loader().load((SAVABLE[])Immigration.this.imms, file); } protected double g(Race race) { return (1.0D + POP.next(race) / 500.0D) / 1000.0D; }
/*     */       }).add((BOOSTABLES.CIVICS()).IMMIGRATION); (new Bo(new BSourceInfo((CLIMATES.INFO()).name, (SPRITE)(UI.icons()).s.heat), 0.0D, 1.0D, true) { protected double g(Race race) { return race.population().climate(SETT.ENV().climate()); } }; for (Race r : RACES.all())
/*     */       this.imms[r.index] = new Immigrator(r);  (new Bo(new BSourceInfo(Dic.¤¤Population, (SPRITE)(UI.icons()).s.human), 1.0D, 1000.0D, true) {
/*     */         public void clear() { byte b; int i;
/*     */           Immigration.Immigrator[] arrayOfImmigrator;
/* 221 */           for (i = (arrayOfImmigrator = Immigration.this.imms).length, b = 0; b < i; ) { Immigration.Immigrator immigrator = arrayOfImmigrator[b];
/* 222 */             immigrator.clear(); b++; }
/* 223 */            Immigration.this.killall = false;
/* 224 */           Immigration.this.killAllI = 0; } }
/*     */       ).add((BOOSTABLES.CIVICS()).IMMIGRATION); (new Bo(new BSourceInfo(¤¤camp, (SPRITE)(UI.icons()).s.minimap), 0.0D, 1000.0D, true) {
/*     */         protected double g(Race race) { return vNOPInput(); }
/*     */         protected double w(Race race) { return WORLD.camps().replenishPerDay((Faction)FACTIONS.player(), race) / 1000.0D; }
/*     */       }).add((BOOSTABLES.CIVICS()).IMMIGRATION);
/* 229 */   } public int admitted(Race race) { return SETT.ENTRY().onTheirWay(race, HTYPES.SUBJECT()); } public int wanted(Race race) { if (race == null) { int im = 0; for (int ri = 0; ri < RACES.all().size(); ri++) { Race r = (Race)RACES.all().get(ri); im += wanted(r); }  return CLAMP.i(im, 0, im); }  if ((GAME.events()).riot.shouldEmigrate(race)) return 0;  return CLAMP.i(this.imms[race.index].wanted() - SETT.ENTRY().onTheirWay(race, HTYPES.SUBJECT()), 0, 1000); } public final INT.INTE auto(Race race) { return (this.imms[race.index]).auto; } public void admit(Race race, int amount) { SETT.ENTRY().add(race, HTYPES.SUBJECT(), amount); (this.imms[race.index]).timer = CLAMP.d((this.imms[race.index]).timer - amount, 0.0D, (this.imms[race.index]).timer); } public int maxPop(Race race) { return (int)(40000.0D * (race.population()).max); } public double secondsTillNext(Race race) { return this.imms[race.index].secondsTillNext(); } public double immigrantsPerDay(Race race) { if (this.imms[race.index].secondsTillNext() == 0.0D) return 0.0D;  return this.imms[race.index].speed(1) * TIME.secondsPerDay(); } public void setHigher(Race race, int am) { (this.imms[race.index]).timer = Math.max((this.imms[race.index]).timer, am); } public boolean shouldEmmigrate(Race race) { return this.imms[race.index].shouldEmmigrate(); } public void clear() {
/*     */     byte b;
/*     */     int i;
/*     */     Immigrator[] arrayOfImmigrator;
/* 233 */     for (i = (arrayOfImmigrator = this.imms).length, b = 0; b < i; ) { Immigrator immigrator = arrayOfImmigrator[b];
/* 234 */       immigrator.clear();
/*     */       b++; }
/*     */   
/*     */   } public void clear(Race race) {
/* 238 */     this.imms[race.index()].clear();
/*     */   }
/*     */   
/*     */   private static final class Immigrator
/*     */     implements SAVABLE
/*     */   {
/* 244 */     private static double rate = 1.0D / TIME.secondsPerDay();
/*     */     
/*     */     private final Race race;
/* 247 */     private int autoAdmit = 0;
/* 248 */     private double timer = 0.0D;
/* 249 */     private double emmigrants = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final INT.INTE auto;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int wantedUltimately() {
/* 260 */       return Immigration.getImmigrants(this.race) - SETT.ENTRY().onTheirWay(this.race, HTYPES.SUBJECT());
/*     */     }
/*     */     
/*     */     private double speed(int wanted) {
/* 264 */       if (wanted <= 0) {
/* 265 */         return 0.0D;
/*     */       }
/* 267 */       if (WORLD.camps().available(this.race)) {
/* 268 */         return rate * WORLD.camps().replenishPerDay((Faction)FACTIONS.player(), this.race);
/*     */       }
/*     */ 
/*     */       
/* 272 */       return rate * (BOOSTABLES.CIVICS()).IMMIGRATION.get((BOOSTABLE_O)HCLASS_RACE.clP(this.race, HCLASSES.CITIZEN()));
/*     */     }
/*     */     
/*     */     public double secondsTillNext() {
/* 276 */       double rem = 1.0D - this.timer - (int)this.timer;
/* 277 */       double speed = speed(wantedUltimately());
/* 278 */       if (speed == 0.0D)
/* 279 */         return Double.NaN; 
/* 280 */       return rem / speed;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void update(double ds) {
/* 286 */       int wanted = wantedUltimately();
/*     */       
/* 288 */       if (wanted < 0) {
/* 289 */         this.emmigrants += -ds * wanted / 2.0D * TIME.secondsPerDay();
/* 290 */         this.timer = 0.0D;
/*     */         return;
/*     */       } 
/* 293 */       this.emmigrants = 0.0D;
/*     */       
/* 295 */       this.timer += speed(wanted) * ds;
/*     */       
/* 297 */       this.timer = CLAMP.d(this.timer, 0.0D, wanted);
/* 298 */       int a = this.auto.get();
/* 299 */       a -= POP.next(HCLASSES.CITIZEN(), this.race);
/* 300 */       int w = wanted();
/*     */ 
/*     */       
/* 303 */       if (a > 0 && w > 0) {
/* 304 */         int am = CLAMP.i(w, 0, a);
/* 305 */         SETT.ENTRY().add(this.race, HTYPES.SUBJECT(), am);
/* 306 */         this.timer -= am;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean shouldEmmigrate() {
/* 312 */       if (this.emmigrants > 1.0D) {
/* 313 */         this.emmigrants--;
/* 314 */         return true;
/*     */       } 
/* 316 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void save(FilePutter file) {
/* 322 */       file.d(this.timer);
/* 323 */       file.i(this.autoAdmit);
/* 324 */       file.d(this.emmigrants);
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/* 329 */       this.timer = file.d();
/* 330 */       this.autoAdmit = file.i();
/* 331 */       this.emmigrants = file.d();
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 336 */       this.timer = 0.0D;
/* 337 */       this.autoAdmit = 0;
/*     */     }
/*     */     
/*     */     public int wanted() {
/* 341 */       return CLAMP.i((int)this.timer, 0, wantedUltimately());
/*     */     }
/*     */     Immigrator(Race race) {
/* 344 */       this.auto = new INT.INTE()
/*     */         {
/*     */           public int get()
/*     */           {
/* 348 */             return ((Immigration.Immigrator.this.race.population()).max == 0.0D) ? 40000 : Immigration.Immigrator.this.autoAdmit;
/*     */           }
/*     */ 
/*     */           
/*     */           public int min() {
/* 353 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 358 */             return 40000;
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 363 */             Immigration.Immigrator.this.autoAdmit = t;
/*     */           }
/*     */         };
/*     */       this.race = race;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static int getImmigrants(Race r) {
/* 372 */     double pop = StandingCitizen.expectationPop(HCLASSES.CITIZEN(), r);
/*     */     
/* 374 */     if (WORLD.camps().available(r)) {
/* 375 */       return Math.max(WORLD.camps().current((Faction)FACTIONS.player(), r) - POP.next(HCLASSES.CITIZEN(), r), 0);
/*     */     }
/*     */     
/* 378 */     if (pop == 0.0D) {
/* 379 */       double d = (BOOSTABLES.BEHAVIOUR()).HAPPI.get((BOOSTABLE_O)HCLASS_RACE.clP(r, HCLASSES.CITIZEN()));
/* 380 */       return (int)Math.ceil(d - 0.1D);
/*     */     } 
/*     */ 
/*     */     
/* 384 */     double hap = (BOOSTABLES.BEHAVIOUR()).HAPPI.get((BOOSTABLE_O)HCLASS_RACE.clP(r, HCLASSES.CITIZEN()));
/*     */     
/* 386 */     hap = CLAMP.d(hap, 0.0D, 2.0D);
/*     */     
/* 388 */     hap -= threshold;
/* 389 */     if (hap <= 0.0D)
/* 390 */       return (int)(pop * hap / threshold); 
/* 391 */     hap *= 0.5D;
/* 392 */     double am = hap * (r.population()).max * pop;
/* 393 */     if (am > 1.0D) {
/* 394 */       double d = am / (am + pop);
/* 395 */       am = am * (1.0D - d) + d * Math.pow(am, 1.0D / STANDINGS.CITIZEN().fullPow(r));
/*     */     } 
/*     */     
/* 398 */     int res = (int)Math.ceil(am);
/*     */     
/* 400 */     return Math.max(res, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 405 */   private static double threshold = 0.9D;
/*     */   
/* 407 */   private static CharSequence ¤¤noImmi = "This subject class does not immigrate";
/* 408 */   private static CharSequence ¤¤available = "Available Now";
/* 409 */   private static CharSequence ¤¤attracted = "Attracted";
/* 410 */   private static CharSequence ¤¤camp = "Havens Max";
/* 411 */   private static CharSequence ¤¤immigrantD = "Immigrants are subjects from either your regional population, or camps that have joined your cause. These subjects will be attracted by your current happiness.";
/* 412 */   private static CharSequence ¤¤admitted = "Admitted";
/* 413 */   private static CharSequence ¤¤eta = "ETA next immigrant (s)";
/* 414 */   private static CharSequence ¤¤autoAdmit = "Auto admit limit";
/*     */   
/*     */   static {
/* 417 */     D.ts(Immigration.class);
/*     */   }
/*     */   
/*     */   public void hoverImmigrants(GUI_BOX box, HCLASS_RACE pop) {
/* 421 */     if (pop == null)
/*     */       return; 
/* 423 */     GBox b = (GBox)box;
/*     */     
/* 425 */     if (pop.cl != HCLASSES.CITIZEN()) {
/* 426 */       b.warn(¤¤noImmi);
/*     */       
/*     */       return;
/*     */     } 
/* 430 */     Race r = pop.race;
/* 431 */     if (r == null) {
/*     */       return;
/*     */     }
/* 434 */     StandingCitizen st = STANDINGS.CITIZEN();
/*     */ 
/*     */ 
/*     */     
/* 438 */     b.text(¤¤immigrantD);
/* 439 */     b.NL(4);
/*     */     
/* 441 */     b.textL(¤¤available);
/* 442 */     b.tab(7);
/* 443 */     b.add((SPRITE)GFORMAT.iBig(b.text(), wanted(r)));
/* 444 */     b.NL();
/*     */     
/* 446 */     b.textL(¤¤admitted);
/* 447 */     b.tab(7);
/* 448 */     b.add((SPRITE)GFORMAT.iBig(b.text(), admitted(r)));
/* 449 */     b.NL();
/*     */     
/* 451 */     b.textL(¤¤attracted);
/* 452 */     b.tab(7);
/* 453 */     b.add((SPRITE)GFORMAT.i(b.text(), Math.max(0, this.imms[r.index].wantedUltimately())));
/* 454 */     b.NL();
/*     */     
/* 456 */     b.textL(¤¤eta);
/* 457 */     b.tab(7);
/* 458 */     b.add((SPRITE)GFORMAT.i(b.text(), (int)this.imms[r.index].secondsTillNext()));
/* 459 */     b.NL();
/*     */     
/* 461 */     b.textL((st.happiness.info()).name);
/* 462 */     b.tab(7);
/* 463 */     b.add((SPRITE)GFORMAT.perc(b.text(), st.happiness.getD(r)));
/* 464 */     b.NL();
/*     */     
/* 466 */     if (WORLD.camps().available(r)) {
/* 467 */       b.textL(¤¤camp);
/* 468 */       b.tab(7);
/* 469 */       b.add((SPRITE)GFORMAT.iBig(b.text(), WORLD.camps().current((Faction)FACTIONS.player(), r)));
/* 470 */       b.NL();
/*     */     } else {
/* 472 */       (BOOSTABLES.CIVICS()).IMMIGRATION.hover(box, (BOOSTABLE_O)pop, true);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 477 */       b.NL();
/*     */     } 
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
/* 492 */     b.textLL(¤¤autoAdmit);
/* 493 */     b.tab(6);
/* 494 */     b.add((SPRITE)GFORMAT.i(b.text(), (this.imms[r.index]).autoAdmit));
/* 495 */     b.NL();
/*     */     
/* 497 */     b.textLL(Dic.¤¤Population);
/* 498 */     b.tab(6);
/* 499 */     b.add((SPRITE)GFORMAT.i(b.text(), -POP.tot(HCLASSES.CITIZEN(), r)));
/* 500 */     b.NL();
/*     */     
/* 502 */     b.textLL(Dic.¤¤Inbound);
/* 503 */     b.tab(6);
/* 504 */     b.add((SPRITE)GFORMAT.i(b.text(), -(POP.next(HCLASSES.CITIZEN(), r) - POP.tot(HCLASSES.CITIZEN(), r))));
/* 505 */     b.NL();
/*     */     
/* 507 */     b.textLL(Dic.¤¤Total);
/* 508 */     b.tab(6);
/* 509 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), Math.max(0, (this.imms[r.index]).autoAdmit - POP.next(HCLASSES.CITIZEN(), r))));
/* 510 */     b.NL();
/*     */     
/* 512 */     b.NL();
/*     */ 
/*     */     
/* 515 */     b.NL(8);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWanted(Race race, int am) {
/* 521 */     (this.imms[race.index()]).timer = am;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entry\Immigration.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */