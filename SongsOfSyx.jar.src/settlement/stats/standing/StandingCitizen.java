/*     */ package settlement.stats.standing;
/*     */ import game.GAME;
/*     */ import game.VERSION;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.faction.FACTIONS;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.paths.PATHS;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.info.INFO;
/*     */ import util.statistics.HistoryInt;
/*     */ import util.statistics.HistoryRace;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.updating.IUpdater;
/*     */ import view.sett.IDebugPanelSett;
/*     */ 
/*     */ public final class StandingCitizen {
/*  43 */   private static CharSequence ¤¤hap = "Happiness";
/*  44 */   private static CharSequence ¤¤hapD = "Happiness increases loyalty and immigration and is fulfillment in proportion to expectations. Fulfilment is gained by providing services and a just rule. Expectation increases with the number of citizens and slaves in your city. As your population increases, you need to fulfil more of your subjects' needs to maintain happiness.";
/*  45 */   private static CharSequence ¤¤loy = "Loyalty Target";
/*  46 */   private static CharSequence ¤¤loyT = "What your loyalty will be in a few days.";
/*     */   
/*  48 */   private static CharSequence ¤¤exp = "Expectations";
/*  49 */   private static CharSequence ¤¤expD = "As your population grows, so will your subjects' expectations. Expectation is tied to a species occurrence in the climate you've chosen to settle and grows linearly.";
/*  50 */   private static CharSequence ¤¤full = "Fulfillment";
/*  51 */   private static CharSequence ¤¤fullD = "A fulfillment modifier can be access to a tavern, or a road, or increased food servings. Each race has different weights tied to each modifier. Focus should be on the biggest modifiers first. Total Fulfillment is an exponential function of the sum of all your fulfillment modifiers divided by the sum of all max fulfillments."; private final HCLASS cl; public final CitizenBoost happiness; public final CitizenBoost loyaltyTarget;
/*     */   
/*     */   static {
/*  54 */     D.ts(StandingCitizen.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   public final CitizenThing expectation = new Expectation();
/*  63 */   public final CitizenThing fullfillment = new Fulfillment();
/*     */   
/*     */   public final CitizenThing loyalty;
/*  66 */   private double[] defs = new double[RACES.all().size()];
/*  67 */   private double[] maxes = new double[RACES.all().size()];
/*  68 */   private final double[] mains = new double[RACES.all().size()]; public final Boostable POW; public final Boostable MAX; public final Boostable bloyalty;
/*     */   public final Boostable bhappiness;
/*     */   private final IUpdater updater;
/*     */   private final double inter;
/*     */   
/*     */   void save(FilePutter file) {
/*  74 */     this.happiness.save(file);
/*  75 */     this.fullfillment.save(file);
/*  76 */     this.expectation.save(file);
/*  77 */     this.loyalty.save(file);
/*  78 */     this.loyaltyTarget.save(file);
/*  79 */     file.ds(this.mains);
/*     */   }
/*     */   
/*     */   void load(FileGetter file) throws IOException {
/*  83 */     this.happiness.load(file);
/*  84 */     this.fullfillment.load(file);
/*  85 */     this.expectation.load(file);
/*  86 */     this.loyalty.load(file);
/*  87 */     this.loyaltyTarget.load(file);
/*  88 */     file.ds(this.mains);
/*  89 */     setAll();
/*  90 */     if (VERSION.versionIsBefore(71, 20))
/*  91 */       StandingBuff.fakeLoad(file); 
/*     */   }
/*     */   
/*     */   void clear() {
/*  95 */     this.happiness.clear();
/*  96 */     this.fullfillment.clear();
/*  97 */     this.expectation.clear();
/*  98 */     this.loyalty.clear();
/*  99 */     this.loyaltyTarget.clear();
/* 100 */     Arrays.fill(this.mains, 0.0D);
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
/*     */   private void setAll() {
/* 164 */     for (Race r : RACES.all()) {
/* 165 */       double max = 0.0D;
/* 166 */       double def = 0.0D;
/* 167 */       for (STAT ss : r.stats().standings(this.cl)) {
/* 168 */         if (!(ss.standing().definition(r).get(this.cl)).dismiss) {
/* 169 */           max += (ss.standing().definition(r).get(this.cl)).max;
/* 170 */           def += ss.standing().def(this.cl, r);
/*     */         } 
/*     */       } 
/* 173 */       this.maxes[r.index] = max;
/* 174 */       this.defs[r.index] = def;
/*     */     } 
/*     */   }
/*     */   
/*     */   void update(double ds) {
/* 179 */     this.updater.update(ds);
/*     */   }
/*     */ 
/*     */   
/*     */   void init() {
/* 184 */     setAll();
/* 185 */     for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 186 */       Race r = (Race)RACES.all().get(ri);
/* 187 */       update(r, 0.0D);
/* 188 */       this.mains[ri] = this.loyaltyTarget.getD(r);
/* 189 */       this.loyalty.set(r, this.mains[ri]);
/*     */     } 
/*     */   }
/*     */   
/* 193 */   StandingCitizen(HCLASS cl, final Boostable bhappiness, Boostable bloyalty) { this.updater = new IUpdater(RACES.all().size(), 4.0D)
/*     */       {
/*     */         
/*     */         protected void update(int i, double timeSinceLast)
/*     */         {
/* 198 */           Race r = (Race)RACES.all().get(i);
/* 199 */           StandingCitizen.this.update(r, timeSinceLast);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 204 */     this.inter = 1.0D / 100.0D * TIME.secondsPerDay(); this.cl = cl; this.POW = BOOSTING.push("FULFILLMENT_EXPONENT_" + cl.key, (new Json((PATHS.CONFIG()).init.gets("Sett"))).d("HAPPINESS_EXPONENT"), Dic.empty, Dic.empty, (SPRITE)(UI.icons()).s.question, (BoostableCat.ALL()).WORLD_DUMP); this.MAX = BOOSTING.push("MAX_CITY_POP" + cl.key, 40000.0D * (new Json((PATHS.CONFIG()).init.gets("Sett"))).d("MAX_POP", 0.0D, 1.0D), Dic.empty, Dic.empty, (SPRITE)(UI.icons()).s.question, (BoostableCat.ALL()).WORLD_DUMP); this.bloyalty = bloyalty; this.bhappiness = bhappiness; this.loyalty = new Main(bloyalty); this.happiness = new CitizenBoost(¤¤hap, ¤¤hapD, bhappiness, cl); this.loyaltyTarget = new CitizenBoost(¤¤loy, ¤¤loyT, bloyalty, cl); IDebugPanelSett.add("happiness++", new ACTION() { public void exe() { for (Race race : RACES.all()) StandingCitizen.this.happiness.set(race, StandingCitizen.this.happiness.getD(race) + 0.1D);  } }
/*     */       ); BValue.BValuePop bValuePop = new BValue.BValuePop() { public double vGet(HCLASS_RACE reg) { return bhappiness.get((BOOSTABLE_O)reg) / 10.0D; } }
/* 206 */       ; (new BoosterValue((BValue)bValuePop, new BSourceInfo((this.happiness.info()).name, (SPRITE)this.happiness.bo.icon), 0.0D, 10.0D, false)).add(this.loyaltyTarget.bo); bValuePop = new BValue.BValuePop() { public double vGet(HCLASS_RACE reg) { Race r = reg.race; double sup = StandingCitizen.this.fullfillment.getD(r); double exp = StandingCitizen.this.expectation.getD(r); if (sup <= 0.0D) return 0.0D;  if (exp == 0.0D) return 1.0D;  sup /= exp; return sup / 10.0D; } }; (new BoosterValue((BValue)bValuePop, new BSourceInfo((this.fullfillment.info()).name, (SPRITE)(UI.icons()).s.heart), 0.0D, 10.0D, true)).add(this.happiness.bo); } private void update(Race race, double ds) { this.fullfillment.up(race, ds);
/* 207 */     this.expectation.up(race, ds);
/* 208 */     this.happiness.up(race, ds);
/* 209 */     this.loyaltyTarget.up(race, ds);
/* 210 */     this.loyalty.up(race, ds); }
/*     */ 
/*     */   
/*     */   final class Main
/*     */     extends CitizenThing {
/*     */     Main(Boostable bo) {
/* 216 */       super(bo.name, bo.desc, StandingCitizen.this.cl);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     double update(Race race, double ds) {
/* 222 */       double now = StandingCitizen.this.mains[race.index];
/*     */       
/* 224 */       int t = (int)(StandingCitizen.this.loyaltyTarget.getD(race) * 100.0D);
/* 225 */       int c = (int)(now * 100.0D);
/* 226 */       double d = (t - c);
/* 227 */       double mul = 1.0D + Math.abs(d) / 25.0D;
/* 228 */       d *= ds * StandingCitizen.this.inter * mul;
/* 229 */       double cur = now + d;
/* 230 */       if (d < 0.0D && cur < StandingCitizen.this.loyaltyTarget.getD(race)) {
/* 231 */         cur = StandingCitizen.this.loyaltyTarget.getD(race);
/* 232 */       } else if (d > 0.0D && cur > StandingCitizen.this.loyaltyTarget.getD(race)) {
/* 233 */         cur = StandingCitizen.this.loyaltyTarget.getD(race);
/*     */       } 
/* 235 */       StandingCitizen.this.mains[race.index] = cur;
/* 236 */       return cur;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final class Fulfillment
/*     */     extends CitizenThing
/*     */   {
/*     */     Fulfillment() {
/* 247 */       super(StandingCitizen.¤¤full, StandingCitizen.¤¤fullD, StandingCitizen.this.cl);
/*     */     }
/*     */ 
/*     */     
/*     */     double update(Race r, double ds) {
/* 252 */       double d = fullfillment(r);
/* 253 */       return CLAMP.d(d, 0.0D, 10.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double fullfillment(Race r) {
/* 259 */       return StandingCitizen.this.prognosis(0.0D, r);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double prognosis(double fulfillment, Race r) {
/* 270 */     double current = 0.0D;
/* 271 */     double max = this.maxes[r.index];
/* 272 */     double def = this.defs[r.index];
/* 273 */     for (STAT ss : r.stats().standings(this.cl)) {
/* 274 */       current += ss.standing().get(this.cl, r);
/*     */     }
/* 276 */     current += fulfillment;
/*     */     
/* 278 */     if (max <= 0.0D) {
/* 279 */       return 1.0D;
/*     */     }
/* 281 */     double d = 0.0D;
/* 282 */     if (current < def) {
/* 283 */       d = -current / def;
/*     */     } else {
/* 285 */       current -= def;
/* 286 */       max -= def;
/* 287 */       d = Math.pow(current / max, fullPow(r));
/*     */     } 
/*     */     
/* 290 */     if (GAME.player().race() == r) {
/* 291 */       double d1 = expectation(r, 6.0D, 0.0D);
/* 292 */       if (d < 0.0D)
/* 293 */         return d1 * -d; 
/* 294 */       return CLAMP.d(d1 + d, 0.0D, 10.0D);
/*     */     } 
/*     */     
/* 297 */     double min = expectation(r, 2.0D, 0.0D);
/* 298 */     if (d < 0.0D)
/* 299 */       return min * -d; 
/* 300 */     return CLAMP.d(min + d, 0.0D, 10.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public double fullPow(Race r) {
/* 305 */     return this.POW.get((BOOSTABLE_O)HCLASS_RACE.clP(r));
/*     */   }
/*     */ 
/*     */   
/*     */   final class Expectation
/*     */     extends CitizenThing
/*     */   {
/*     */     Expectation() {
/* 313 */       super(StandingCitizen.¤¤exp, StandingCitizen.¤¤expD, StandingCitizen.this.cl);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     double update(Race race, double ds) {
/* 320 */       return c(race);
/*     */     }
/*     */     
/*     */     private double c(Race race) {
/* 324 */       double pop = StandingCitizen.expectationPop(StandingCitizen.this.cl, race);
/* 325 */       double popOther = StandingCitizen.expectationPopTot() - pop;
/* 326 */       return StandingCitizen.this.expectation(race, pop, popOther);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double expectation(Race race, double amount, double other) {
/* 335 */     double tot = 1.0D + amount + other;
/*     */     
/* 337 */     double bo = Math.sqrt(amount / tot);
/* 338 */     double exp = tot / this.MAX.get((BOOSTABLE_O)HCLASS_RACE.clP(race));
/* 339 */     double pe = 1.0D / (race.population()).max;
/* 340 */     if (race != FACTIONS.player().race())
/* 341 */       bo *= 2.0D; 
/* 342 */     return bo * exp * pe;
/*     */   }
/*     */   
/*     */   public double current(Induvidual a) {
/* 346 */     Race r = a.race();
/* 347 */     double current = 0.0D;
/* 348 */     double max = this.maxes[r.index];
/* 349 */     double def = this.defs[r.index];
/* 350 */     for (STAT ss : r.stats().standings(this.cl)) {
/* 351 */       current += ss.standing().get(a);
/*     */     }
/*     */     
/* 354 */     double h = this.bhappiness.get((BOOSTABLE_O)a);
/*     */     
/* 356 */     if (max <= 0.0D) {
/* 357 */       return h;
/*     */     }
/* 359 */     double d = 0.0D;
/* 360 */     if (current < def) {
/* 361 */       d = -current / def;
/*     */     } else {
/* 363 */       current -= def;
/* 364 */       max -= def;
/* 365 */       d = Math.pow(current / max, fullPow(r));
/*     */     } 
/*     */     
/* 368 */     if (GAME.player().race() == r) {
/* 369 */       double min = expectation(r, 10.0D, 0.0D);
/* 370 */       if (d < 0.0D) {
/* 371 */         h = min * -d;
/*     */       } else {
/* 373 */         h = CLAMP.d(h * (min + d), 0.0D, 10.0D);
/*     */       } 
/*     */     } else {
/* 376 */       double min = expectation(r, 2.0D, 0.0D);
/* 377 */       if (d < 0.0D) {
/* 378 */         h = min * -d;
/*     */       } else {
/* 380 */         h = CLAMP.d(h * (min + d), 0.0D, 10.0D);
/*     */       } 
/*     */     } 
/* 383 */     double pop = expectationPop(this.cl, r);
/* 384 */     double popOther = expectationPopTot() - pop;
/* 385 */     h /= expectation(r, pop, popOther);
/*     */     
/* 387 */     return h;
/*     */   }
/*     */ 
/*     */   
/*     */   public double current() {
/* 392 */     return this.loyalty.getD(null);
/*     */   }
/*     */   
/*     */   public double target() {
/* 396 */     return this.loyaltyTarget.getD(null);
/*     */   }
/*     */   
/*     */   public INFO info() {
/* 400 */     return this.loyalty.info();
/*     */   }
/*     */   
/*     */   public static int expectationPop(HCLASS cl, Race r) {
/* 404 */     return POP.tot(cl, r);
/*     */   }
/*     */   
/*     */   public static int expectationPopTot() {
/* 408 */     return POP.tot(null, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class CitizenThing
/*     */   {
/* 414 */     private final HistoryInt total = new HistoryInt(32, (TIMECYCLE)TIME.days(), true);
/* 415 */     private final HistoryInt[] histories = new HistoryInt[RACES.all().size()];
/*     */     private final INFO info;
/*     */     private static final double dd = 1.0E7D;
/*     */     private final HCLASS cl;
/*     */     
/*     */     CitizenThing(INFO info, HCLASS cl) {
/* 421 */       this.info = info;
/* 422 */       for (int i = 0; i < this.histories.length; i++)
/* 423 */         this.histories[i] = new HistoryInt(32, (TIMECYCLE)TIME.days(), true); 
/* 424 */       this.cl = cl;
/*     */     }
/*     */     
/*     */     CitizenThing(CharSequence name, CharSequence desc, HCLASS cl) {
/* 428 */       this(new INFO(name, desc), cl);
/*     */     }
/*     */     
/*     */     final void up(Race race, double ds) {
/* 432 */       set(race, update(race, ds));
/*     */     }
/*     */ 
/*     */     
/*     */     abstract double update(Race param1Race, double param1Double);
/*     */     
/*     */     public double getD(Race t) {
/* 439 */       return getD(t, 0);
/*     */     }
/*     */     
/*     */     public double getD(Race t, int daysBack) {
/* 443 */       HistoryInt h = (t == null) ? this.total : this.histories[t.index];
/* 444 */       double d = h.get(daysBack) / 1.0E7D;
/* 445 */       return CLAMP.d(d, 0.0D, d);
/*     */     }
/*     */     
/*     */     void save(FilePutter file) {
/* 449 */       this.total.save(file); byte b; int i; HistoryInt[] arrayOfHistoryInt;
/* 450 */       for (i = (arrayOfHistoryInt = this.histories).length, b = 0; b < i; ) { HistoryInt historyInt = arrayOfHistoryInt[b];
/* 451 */         historyInt.save(file);
/*     */         b++; }
/*     */     
/*     */     } void load(FileGetter file) throws IOException {
/* 455 */       this.total.load(file); byte b; int i; HistoryInt[] arrayOfHistoryInt;
/* 456 */       for (i = (arrayOfHistoryInt = this.histories).length, b = 0; b < i; ) { HistoryInt historyInt = arrayOfHistoryInt[b];
/* 457 */         historyInt.load(file);
/*     */         b++; }
/*     */     
/*     */     } void clear() {
/* 461 */       this.total.clear(); byte b; int i; HistoryInt[] arrayOfHistoryInt;
/* 462 */       for (i = (arrayOfHistoryInt = this.histories).length, b = 0; b < i; ) { HistoryInt historyInt = arrayOfHistoryInt[b];
/* 463 */         historyInt.clear();
/*     */         b++; }
/*     */     
/*     */     }
/*     */     void set(Race race, double v) {
/* 468 */       this.histories[race.index].set((int)(v * 1.0E7D));
/* 469 */       double total = 0.0D;
/* 470 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 471 */         Race r = (Race)RACES.all().get(ri);
/* 472 */         total += CLAMP.d(getD(r), 0.0D, 10.0D) * (STATS.POP()).POP.data(this.cl).get(r, 0);
/*     */       } 
/* 474 */       double p = (STATS.POP()).POP.data(this.cl).get(null, 0);
/* 475 */       if (p == 0.0D)
/* 476 */         p = 1.0D; 
/* 477 */       total /= p;
/* 478 */       this.total.set((int)(total * 1.0E7D));
/*     */     }
/*     */     
/*     */     public INFO info() {
/* 482 */       return this.info;
/*     */     }
/*     */   }
/*     */   
/*     */   public class CitizenBoost
/*     */     extends CitizenThing
/*     */   {
/*     */     public final Boostable bo;
/* 490 */     private ArrayListGrower<HistoryRace> factors = new ArrayListGrower();
/* 491 */     private ArrayListGrower<HistoryInt> factorsTot = new ArrayListGrower();
/*     */     private static final double dd = 100000.0D;
/*     */     private static final double ddI = 1.0E-5D;
/*     */     
/*     */     CitizenBoost(CharSequence name, CharSequence desc, Boostable bo, HCLASS cl) {
/* 496 */       super(new INFO(name, desc), cl);
/* 497 */       this.bo = bo;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void save(FilePutter file) {
/* 503 */       file.i(this.factors.size());
/* 504 */       for (HistoryRace r : this.factors)
/* 505 */         r.save(file); 
/* 506 */       for (HistoryInt r : this.factorsTot)
/* 507 */         r.save(file); 
/* 508 */       super.save(file);
/*     */     }
/*     */ 
/*     */     
/*     */     void load(FileGetter file) throws IOException {
/* 513 */       int am = file.i();
/* 514 */       while (this.factors.size() <= am) {
/* 515 */         this.factors.add(new HistoryRace(32, (TIMECYCLE)TIME.days(), true));
/* 516 */         this.factorsTot.add(new HistoryInt(32, (TIMECYCLE)TIME.days(), true));
/*     */       }  int i;
/* 518 */       for (i = 0; i < am; i++)
/* 519 */         ((HistoryRace)this.factors.get(i)).load(file); 
/* 520 */       for (i = 0; i < am; i++)
/* 521 */         ((HistoryInt)this.factorsTot.get(i)).load(file); 
/* 522 */       super.load(file);
/*     */     }
/*     */ 
/*     */     
/*     */     void clear() {
/* 527 */       for (HistoryRace r : this.factors)
/* 528 */         r.clear(); 
/* 529 */       for (HistoryInt r : this.factorsTot)
/* 530 */         r.clear(); 
/*     */     }
/*     */     
/*     */     public double factor(Race race, int factorI, int fromZero) {
/* 534 */       while (this.factors.size() <= factorI) {
/* 535 */         this.factors.add(new HistoryRace(32, (TIMECYCLE)TIME.days(), true));
/* 536 */         this.factorsTot.add(new HistoryInt(32, (TIMECYCLE)TIME.days(), true));
/*     */       } 
/* 538 */       if (fromZero == 0)
/* 539 */         return ((Booster)this.bo.all().get(factorI)).get(HCLASS_RACE.clP(race, StandingCitizen.this.cl)); 
/* 540 */       if (race == null)
/* 541 */         return ((HistoryInt)this.factorsTot.get(factorI)).get(fromZero) * 1.0E-5D; 
/* 542 */       return ((HistoryRace)this.factors.get(factorI)).history(race).get(fromZero) * 1.0E-5D;
/*     */     }
/*     */ 
/*     */     
/*     */     double update(Race race, double ds) {
/* 547 */       for (int i = 0; i < this.bo.all().size(); i++) {
/* 548 */         while (this.factors.size() <= i) {
/* 549 */           this.factors.add(new HistoryRace(32, (TIMECYCLE)TIME.days(), true));
/* 550 */           this.factorsTot.add(new HistoryInt(32, (TIMECYCLE)TIME.days(), true));
/*     */         } 
/* 552 */         ((HistoryRace)this.factors.get(i)).set(race, (int)(100000.0D * ((Booster)this.bo.all().get(i)).get(HCLASS_RACE.clP(race, StandingCitizen.this.cl))));
/* 553 */         double total = 0.0D;
/* 554 */         for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 555 */           Race r = (Race)RACES.all().get(ri);
/* 556 */           total += factor(r, i, 0) * (STATS.POP()).POP.data(StandingCitizen.this.cl).get(r, 0);
/*     */         } 
/* 558 */         double p = (STATS.POP()).POP.data(StandingCitizen.this.cl).get(null, 0);
/* 559 */         if (p == 0.0D)
/* 560 */           p = 1.0D; 
/* 561 */         total /= p;
/* 562 */         ((HistoryInt)this.factorsTot.get(i)).set((int)(total * 100000.0D));
/*     */       } 
/* 564 */       return this.bo.get((BOOSTABLE_O)HCLASS_RACE.clP(race, StandingCitizen.this.cl));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\standing\StandingCitizen.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */