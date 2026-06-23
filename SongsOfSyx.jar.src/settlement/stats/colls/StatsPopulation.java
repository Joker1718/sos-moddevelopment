/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CAUSE_ARRIVE;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import init.type.HTYPE_RACE;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.DataRaces;
/*     */ import settlement.stats.stat.SETT_STATISTICS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.STATFake;
/*     */ import settlement.stats.stat.STATFakeData;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import settlement.stats.stat.StatInfo;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.DataO;
/*     */ import util.data.GETTER_TRANS;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMapD;
/*     */ import util.statistics.HISTORY;
/*     */ import util.statistics.HISTORY_COLLECTION;
/*     */ import util.statistics.HISTORY_INT;
/*     */ import util.statistics.HistoryInt;
/*     */ import util.statistics.HistoryRace;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StatsPopulation
/*     */   extends StatCollection
/*     */ {
/*     */   public final SETT_STATISTICS POP;
/*  72 */   private final DataRaces[] pops = new DataRaces[HTYPES.ALL().size()];
/*  73 */   private final int[] popDiv = Alloc.ii((Config.battle()).DIVISIONS_PER_BATTLE * HTYPES.ALL().size());
/*     */   
/*     */   public final STAT NOBLES;
/*     */   
/*     */   public final PopType TYPE;
/*     */   public final STAT TRAPPED;
/*     */   public final STAT EMMIGRATING;
/*     */   public final STAT MAJORITY;
/*     */   public final Age age;
/*     */   public final StatsReproduction reproduction;
/*     */   public final STAT SLAVES_SELF;
/*     */   public final STAT SLAVES_OTHER;
/*     */   public final STAT WRONGFUL;
/*     */   public final StatsDeath COUNT;
/*  87 */   private final HistoryInt popYearly = new HistoryInt(32, (TIMECYCLE)TIME.years(), false);
/*     */   
/*     */   private final Demography demo;
/*     */   public final INT_O.INT_OE<Induvidual> NAKED;
/*  91 */   final int dy = (int)TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */   
/*     */   public final GETTER_TRANS.GETTER_TRANSE<Induvidual, ENTITY> FRIEND;
/*  94 */   private static CharSequence ¤¤name = "Population";
/*  95 */   private static CharSequence ¤¤desc = "Statistics regarding population."; private final StatsInit.StatUpdatableI updater;
/*     */   
/*     */   static {
/*  98 */     D.ts(StatsPopulation.class);
/*     */   }
/*     */   
/*     */   public StatsPopulation(StatsInit init) {
/* 102 */     super(init, "POPULATION", ¤¤name, ¤¤desc);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 278 */     this.updater = new StatsInit.StatUpdatableI() { public int popDivider(HCLASS c, Race r, int daysback) { return 1; } }
/*     */       ;
/*     */     this.POP = (SETT_STATISTICS)pPOP;
/*     */     this.WRONGFUL = (STAT)new STATFakeData("WRONGFUL_DEATHS", init) { public int dataDivider() { return 1; } protected double getDD(HCLASS cl, Race r) { return StatsPopulation.this.COUNT.wrongful.get((MAPPED)cl).getD((MAPPED)r) * 50.0D / (STATS.POP()).POP.data(cl).get(r); } }
/*     */       ;
/*     */     this.WRONGFUL.info().setMatters(true, false);
/*     */     (this.WRONGFUL.info()).icon = (SPRITE)(UI.icons()).m.skull;
/*     */     this.NOBLES = (STAT)new STATFake("NOBLES", init) {
/* 286 */         public void update16(Humanoid h, int updateI, boolean day, int ui) { Induvidual i = h.indu();
/*     */           
/* 288 */           if (day) {
/* 289 */             StatsPopulation.this.age.DAYS.inc(i, 1);
/*     */           }
/*     */           
/* 292 */           if ((updateI & 0xF) == (STATS.RAN().get(i, 100, 4) & 0xF))
/*     */           {
/* 294 */             if (StatsPopulation.this.age.shouldDieOfOldAge(i))
/* 295 */               Humanoid.HumanoidResource.dead = CAUSE_LEAVES.AGE();  }  } }
/*     */       ; D.gInit(this); this.age = new Age(init); this.reproduction = new StatsReproduction(init); this.demo = new Demography(init); init.count.getClass(); this.NAKED = (INT_O.INT_OE<Induvidual>)new DataO.DataBit(init.count, "POP_NAKED"); final SETT_STATISTICS.SettStatistics pPOP = new SETT_STATISTICS.SettStatistics("POP_POP", init, (INFO)new StatInfo(Dic.¤¤Population, "")) { protected double getDD(HCLASS s, Race r, int daysBack) { double n = StatsPopulation.this.POP.data(HCLASSES.NOBLE()).get(r, daysBack); double p = StatsPopulation.this.POP.data(HCLASSES.NOBLE()).get(null, daysBack); if (p == 0.0D) return ((n > 0.0D) ? true : false);  return n / p; } protected double induGet(Induvidual t) { return ((t.clas() == HCLASSES.NOBLE()) ? true : false); }
/*     */       }; this.NOBLES.info().setInt(); this.NOBLES.info().setMatters(true, false); (this.NOBLES.info()).icon = (SPRITE)(UI.icons()).m.noble; this.TYPE = new PopType(init); init.count.getClass(); this.TRAPPED = (STAT)new STATData("TRAPPED", init, (DataO.DataAbs)new DataO.DataBit(init.count, "POP_TRAPPED")); this.TRAPPED.info().setInt(); init.count.getClass(); this.EMMIGRATING = (STAT)new STATData("EMIGRATING", init, (DataO.DataAbs)new DataO.DataBit(init.count, "POP_EMMI")); this.EMMIGRATING.info().setInt(); this.MAJORITY = (STAT)new STATFake("MAJORITY", init) { protected double getDD(HCLASS s, Race r, int daysBack) { double pop = StatsPopulation.this.POP.data(s).get(null, daysBack); if (pop == 0.0D) return 0.0D;  return StatsPopulation.this.POP.data(s).get(r, daysBack) / pop; } }
/*     */       ; this.MAJORITY.standing = new StatStanding(this.MAJORITY, 1.0D); this.MAJORITY.info().setMatters(true, false); (this.MAJORITY.info()).icon = (SPRITE)(UI.icons()).m.plus; this.SLAVES_SELF = (STAT)new STATFake("SLAVES_SELF", init) { protected double getDD(HCLASS s, Race r, int daysBack) { double p = ((STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(r, daysBack) + 1); return (STATS.POP()).POP.data(HCLASSES.SLAVE()).get(r, daysBack) / p; } }
/*     */       ; this.SLAVES_SELF.info().setMatters(true, false); (this.SLAVES_SELF.info()).icon = (SPRITE)(UI.icons()).m.slave; this.SLAVES_OTHER = (STAT)new STATFake("SLAVES_OTHER", init) { protected double getDD(HCLASS s, Race r, int daysBack) { double slaves = (STATS.POP()).POP.data(HCLASSES.SLAVE()).get(null, daysBack); double p = (STATS.POP()).POP.data(null).get(null, daysBack); if (p == 0.0D) return 0.0D;  return slaves / p; } }
/*     */       ; this.SLAVES_OTHER.info().setMatters(true, false); (this.SLAVES_OTHER.info()).icon = (SPRITE)(UI.icons()).m.slave; init.updatable.add(this.updater); this.COUNT = new StatsDeath(init); this.FRIEND = new Friend(init); for (HTYPE t : HTYPES.ALL()) { this.pops[t.index()] = new DataRaces("POPIPOP" + t.key, init, true) {
/*     */           public double getD(Race t, int fromZero) { double d = get(t, fromZero); double p = StatsPopulation.this.POP.data().get(t); if (p == 0.0D) return CLAMP.d(d, 0.0D, 1.0D);  return CLAMP.d(d / p, 0.0D, 1.0D); } public int min(Race t) { return 0; } public int max(Race t) { return StatsPopulation.this.POP.data().get(t); }
/*     */         }; }  init.addable.add(new StatsInit.Addable() {
/*     */           public void removePrivate(Induvidual i) { pPOP.inc(i, -1); StatsPopulation.this.pops[i.hType().index()].incrFull(i, -1); Div d = (Div)(STATS.BATTLE()).DIV.get(i); if (d != null) StatsPopulation.this.popDiv[i.hType().index() * (Config.battle()).DIVISIONS_PER_BATTLE + d.index()] = StatsPopulation.this.popDiv[i.hType().index() * (Config.battle()).DIVISIONS_PER_BATTLE + d.index()] - 1;  if ((i.clas()).player) StatsPopulation.this.popYearly.inc(-1);  } public void addPrivate(Induvidual i) { pPOP.inc(i, 1); StatsPopulation.this.pops[i.hType().index()].incrFull(i, 1); Div d = (Div)(STATS.BATTLE()).DIV.get(i); if (d != null) StatsPopulation.this.popDiv[i.hType().index() * (Config.battle()).DIVISIONS_PER_BATTLE + d.index()] = StatsPopulation.this.popDiv[i.hType().index() * (Config.battle()).DIVISIONS_PER_BATTLE + d.index()] + 1;  if ((i.clas()).player) StatsPopulation.this.popYearly.inc(1);  }
/*     */         });
/* 305 */   } public int pop(HTYPE type, Div div) { return this.popDiv[type.index() * (Config.battle()).DIVISIONS_PER_BATTLE + div.index()]; }
/*     */    public HISTORY_INT popYearly() {
/*     */     return (HISTORY_INT)this.popYearly;
/*     */   } public int pop(HTYPE type) {
/* 309 */     return this.POP.type().get(HTYPE_RACE.get(null, type));
/*     */   }
/*     */   
/*     */   public int pop(Race r, HTYPE type) {
/* 313 */     return this.POP.type().get(HTYPE_RACE.get(r, type));
/*     */   }
/*     */   
/*     */   public int pop(Race r, HTYPE type, int daysBack) {
/* 317 */     if (r == null)
/* 318 */       return pop(type); 
/* 319 */     return this.pops[type.index()].get(r, daysBack);
/*     */   }
/*     */   
/*     */   public int total(HTYPE type) {
/* 323 */     int am = 0;
/* 324 */     for (Race r : RACES.all())
/* 325 */       am += pop(r, type); 
/* 326 */     return am;
/*     */   }
/*     */   
/*     */   public HISTORY.HISTORY_OBJECT<Race> demography() {
/* 330 */     return this.demo;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Age
/*     */   {
/*     */     public final STAT AGE_DAYS;
/*     */     
/*     */     public final INT_O.INT_OE<Induvidual> DAYS;
/*     */     private final INT_O.INT_OE<Induvidual> DEATH;
/* 340 */     private final double yy = TIME.years().bitConversion((TIMECYCLE)TIME.days());
/* 341 */     private final double yI = 1.0D / this.yy;
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
/*     */     public DOUBLE_O.DOUBLE_OE<Induvidual> years;
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
/*     */     public DOUBLE_O.DOUBLE_OE<Induvidual> dage;
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
/*     */     Age(StatsInit init) {
/* 416 */       this.years = new DOUBLE_O.DOUBLE_OE<Induvidual>()
/*     */         {
/*     */           public double getD(Induvidual t)
/*     */           {
/* 420 */             return StatsPopulation.Age.this.DAYS.get(t) * StatsPopulation.Age.this.yI;
/*     */           }
/*     */ 
/*     */           
/*     */           public DOUBLE_O.DOUBLE_OE<Induvidual> setD(Induvidual t, double d) {
/* 425 */             int am = (int)Math.round(d * StatsPopulation.Age.this.yy);
/* 426 */             StatsPopulation.Age.this.DAYS.set(t, am);
/* 427 */             return this;
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 432 */       this.dage = new DOUBLE_O.DOUBLE_OE<Induvidual>()
/*     */         {
/*     */           public double getD(Induvidual t)
/*     */           {
/* 436 */             return StatsPopulation.Age.this.DAYS.getD(t);
/*     */           }
/*     */           
/*     */           public DOUBLE_O.DOUBLE_OE<Induvidual> setD(Induvidual t, double d)
/*     */           {
/* 441 */             int am = (int)Math.round(d * StatsPopulation.Age.this.yy * t.race().bvalue((BOOSTABLES.PHYSICS()).DEATH_AGE));
/* 442 */             StatsPopulation.Age.this.DAYS.set(t, am);
/* 443 */             return this;
/*     */           } }; init.count.getClass(); DataO<Induvidual>.DataInt days = new DataO<Induvidual>.DataInt(init.count, "POP_AGE_DAYS") { public void set(Induvidual i, int v) { (STATS.POP()).demo.removeH(i); super.set(i, v); (STATS.POP()).demo.addH(i); (STATS.POP()).reproduction.set(i); } public double getD(Induvidual t) { double de = 1.0D + Math.ceil(t.race().bvalue((BOOSTABLES.PHYSICS()).DEATH_AGE) * StatsPopulation.Age.this.yy); int da = StatsPopulation.Age.this.DAYS.get(t); return CLAMP.d(da / de, 0.0D, 1.0D); } public DOUBLE_O.DOUBLE_OE<Induvidual> setD(Induvidual t, double d) { int am = (int)Math.round(d * StatsPopulation.Age.this.yy); StatsPopulation.Age.this.DAYS.set(t, am); return (DOUBLE_O.DOUBLE_OE<Induvidual>)this; } }
/*     */         ; init.count.getClass(); this.DEATH = (INT_O.INT_OE<Induvidual>)new DataO.DataByte(init.count, "DEATH_AGE"); STATData sTATData = new STATData("AGE", init, (DataO.DataAbs)days) { public int dataDivider() { return 1; } }
/*     */         ; this.DAYS = sTATData.indu(); this.AGE_DAYS = (STAT)sTATData; this.AGE_DAYS.info().setInt(); init.onConstruct.add(new StatsInit.StatInitable() { public void init(Induvidual i) { int min = (i.race()).physics.adultDay + 1; int max = (int)(0.5D * (BOOSTABLES.PHYSICS()).DEATH_AGE.get((BOOSTABLE_O)i) * StatsPopulation.Age.this.yy); int d = max - min; if (d <= 0) d = 1;  d = min + RND.rInt(d); StatsPopulation.Age.this.DAYS.set(i, d); StatsPopulation.Age.this.DEATH.setD(i, StatsPopulation.death()); if (StatsPopulation.Age.this.shouldDieOfOldAge(i))
/*     */                 StatsPopulation.Age.this.DEATH.inc(i, 1 + RND.rInt(5));  } }
/*     */         ); init.copier.add(days); init.copier.add(this.DEATH);
/* 449 */     } public int lifespan(Induvidual i) { return (int)(i.race().bvalue((BOOSTABLES.PHYSICS()).DEATH_AGE) * this.yy); }
/*     */ 
/*     */     
/*     */     public boolean shouldDieOfOldAge(Induvidual i) {
/* 453 */       int now = this.DAYS.get(i);
/* 454 */       int death = deathDay(i);
/* 455 */       return (now >= death);
/*     */     }
/*     */     
/*     */     public int deathDay(Induvidual i) {
/* 459 */       int ll = (int)i.race().bvalue((BOOSTABLES.PHYSICS()).DEATH_AGE);
/* 460 */       ll = (int)(ll * this.DEATH.getD(i));
/* 461 */       int yy = (int)TIME.years().bitConversion((TIMECYCLE)TIME.days());
/* 462 */       ll *= yy;
/* 463 */       ll += STATS.RAN().get(i, 13) % yy;
/* 464 */       return ll;
/*     */     }
/*     */     
/*     */     public boolean isAdult(Induvidual i) {
/* 468 */       return (this.DAYS.get(i) >= (i.race()).physics.adultDay);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Demography
/*     */     implements HISTORY.HISTORY_OBJECT<Race>, StatsInit.Addable
/*     */   {
/* 476 */     private static int size = 32;
/* 477 */     private int[][] perRace = Alloc.i2(32, RACES.all().size()); private final INFO info; Demography(StatsInit init) {
/* 478 */       D.gInit(StatsPopulation.class);
/* 479 */       this.info = new INFO(D.g("Demography"), D.g("DemographyDesc", "The different age groups of your citizens"));
/*     */ 
/*     */       
/* 482 */       init.addable.add(this);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double getD(Race t, int fromZero) {
/* 488 */       if (t == null) {
/* 489 */         double acc = 0.0D;
/* 490 */         int pop = 0;
/* 491 */         for (int i = 0; i < RACES.all().size(); i++) {
/* 492 */           Race r = (Race)RACES.all().get(i);
/* 493 */           int p = (STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(r) + (STATS.POP()).POP.type().get(HTYPE_RACE.get(r, HTYPES.CHILD()));
/* 494 */           acc += getD(r, fromZero) * p;
/* 495 */           pop += p;
/*     */         } 
/* 497 */         if (pop == 0)
/* 498 */           return 0.0D; 
/* 499 */         return acc / pop;
/*     */       } 
/* 501 */       if (fromZero == 0)
/* 502 */         return STATS.POP().pop(HTYPES.PARENT()); 
/* 503 */       return this.perRace[fromZero][t.index];
/*     */     }
/*     */ 
/*     */     
/*     */     public INFO info() {
/* 508 */       return this.info;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void addPrivate(Induvidual i) {
/* 514 */       if (i.hType().parentClass() == HCLASSES.CITIZEN()) {
/* 515 */         this.perRace[getT(i)][(i.race()).index] = this.perRace[getT(i)][(i.race()).index] + 1;
/* 516 */         if (i.hType() == HTYPES.PARENT()) {
/* 517 */           this.perRace[0][(i.race()).index] = this.perRace[0][(i.race()).index] + 1;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void removePrivate(Induvidual i) {
/* 524 */       if (i.hType().parentClass() == HCLASSES.CITIZEN()) {
/* 525 */         this.perRace[getT(i)][(i.race()).index] = this.perRace[getT(i)][(i.race()).index] - 1;
/* 526 */         if (i.hType() == HTYPES.PARENT()) {
/* 527 */           this.perRace[0][(i.race()).index] = this.perRace[0][(i.race()).index] - 1;
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*     */     private int getT(Induvidual i) {
/* 533 */       int max = (int)Math.ceil(i.race().bvalue((BOOSTABLES.PHYSICS()).DEATH_AGE) * TIME.years().bitConversion((TIMECYCLE)TIME.days()));
/* 534 */       int c = (STATS.POP()).age.DAYS.get(i);
/* 535 */       int ii = (size - 2) * c / max;
/* 536 */       ii = CLAMP.i(ii, 0, size - 2);
/* 537 */       return ii;
/*     */     }
/*     */ 
/*     */     
/*     */     public TIMECYCLE time() {
/* 542 */       return (TIMECYCLE)TIME.days();
/*     */     }
/*     */ 
/*     */     
/*     */     public int historyRecords() {
/* 547 */       return size;
/*     */     }
/*     */ 
/*     */     
/*     */     public double getD(Race t) {
/* 552 */       return getD(t, 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class StatsDeath
/*     */   {
/*     */     private final LIST<PopData> deaths;
/*     */     private final LIST<PopData> enters;
/* 561 */     private double newEntries = 0.0D;
/* 562 */     private double timer = 0.0D;
/*     */     
/*     */     public final GETTER_TRANS.GETTER_TRANSE<Induvidual, CAUSE_ARRIVE> arrive;
/* 565 */     private final RMapD.RMapDTwo<HCLASS, Race> wrongful = new RMapD.RMapDTwo(HCLASSES.MAP(), RACES.map());
/*     */ 
/*     */     
/*     */     StatsDeath(StatsInit init) {
/* 569 */       ArrayList<PopData> deaths = new ArrayList(CAUSE_LEAVES.ALL().size());
/* 570 */       for (CAUSE_LEAVE l : CAUSE_LEAVES.ALL()) {
/* 571 */         deaths.add(new PopData("L_" + l.key, (INFO)l, init, true));
/*     */       }
/*     */       
/* 574 */       this.deaths = (LIST<PopData>)deaths;
/*     */       
/* 576 */       ArrayList<PopData> enters = new ArrayList(CAUSE_ARRIVES.ALL().size());
/* 577 */       for (CAUSE_ARRIVE l : CAUSE_ARRIVES.ALL()) {
/* 578 */         enters.add(new PopData("A_" + l.index(), (INFO)l, init, true));
/*     */       }
/* 580 */       this.enters = (LIST<PopData>)enters;
/*     */       
/* 582 */       if (CAUSE_ARRIVES.ALL().size() > 16) {
/* 583 */         throw new RuntimeException("Change to bigger data");
/*     */       }
/* 585 */       init.count.getClass(); final DataO.DataNibble data = new DataO.DataNibble(init.count, "POP_ARRIVE");
/*     */       
/* 587 */       this.arrive = new GETTER_TRANS.GETTER_TRANSE<Induvidual, CAUSE_ARRIVE>()
/*     */         {
/*     */           public CAUSE_ARRIVE get(Induvidual f)
/*     */           {
/* 591 */             return (CAUSE_ARRIVE)CAUSE_ARRIVES.ALL().get(data.get(f));
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(Induvidual f, CAUSE_ARRIVE t) {
/* 596 */             data.set(f, t.index());
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 601 */       init.savers.put("WRONG_DEATH_DATA", this.wrongful);
/*     */       
/* 603 */       init.savers.put("DEATH_MISC", new SAVABLE()
/*     */           {
/*     */             public void save(FilePutter file)
/*     */             {
/* 607 */               file.d(StatsPopulation.StatsDeath.this.timer);
/* 608 */               file.d(StatsPopulation.StatsDeath.this.newEntries);
/*     */             }
/*     */ 
/*     */             
/*     */             public void load(FileGetter file) throws IOException {
/* 613 */               StatsPopulation.StatsDeath.this.timer = file.d();
/* 614 */               StatsPopulation.StatsDeath.this.newEntries = file.d();
/*     */             }
/*     */ 
/*     */             
/*     */             public void clear() {
/* 619 */               StatsPopulation.StatsDeath.this.timer = 0.0D;
/* 620 */               StatsPopulation.StatsDeath.this.newEntries = 0.0D;
/*     */             }
/*     */           });
/*     */       
/* 624 */       init.upers.add(new StatsInit.StatUpdatable()
/*     */           {
/*     */             
/*     */             public void update(double ds)
/*     */             {
/* 629 */               double d = StatsPopulation.StatsDeath.this.newEntries / 128.0D;
/* 630 */               if (d < 1.0D)
/* 631 */                 d = 1.0D; 
/* 632 */               StatsPopulation.StatsDeath.this.newEntries -= d * ds;
/* 633 */               StatsPopulation.StatsDeath.this.newEntries = CLAMP.d(StatsPopulation.StatsDeath.this.newEntries, 0.0D, Double.MAX_VALUE);
/*     */               
/* 635 */               StatsPopulation.StatsDeath.this.timer += ds;
/* 636 */               if (StatsPopulation.StatsDeath.this.timer < TIME.secondsPerDay()) {
/*     */                 return;
/*     */               }
/*     */               
/* 640 */               StatsPopulation.StatsDeath.this.timer -= TIME.secondsPerDay();
/* 641 */               for (int ci = 0; ci < HCLASSES.ALL().size(); ci++) {
/* 642 */                 HCLASS cc = (HCLASS)HCLASSES.ALL().get(ci);
/* 643 */                 for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 644 */                   double c = StatsPopulation.StatsDeath.this.wrongful.get((MAPPED)cc).getD((MAPPED)RACES.all().get(ri));
/*     */                   
/* 646 */                   double d1 = c * 0.1D;
/* 647 */                   if (d1 - (int)d1 > RND.rFloat())
/* 648 */                     d1 = ((int)d1 + 1); 
/* 649 */                   if (d1 < 1.0D)
/* 650 */                     d1 = 1.0D; 
/* 651 */                   c -= d1;
/* 652 */                   c = CLAMP.d(c, 0.0D, c);
/* 653 */                   StatsPopulation.StatsDeath.this.wrongful.get((MAPPED)cc).setD((MAPPED)RACES.all().get(ri), c);
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double newEntries() {
/* 664 */       return this.newEntries / 128.0D;
/*     */     }
/*     */     
/*     */     public LIST<PopData> leaves() {
/* 668 */       return this.deaths;
/*     */     }
/*     */     
/*     */     public LIST<PopData> enters() {
/* 672 */       return this.enters;
/*     */     }
/*     */     
/*     */     public void reg(Induvidual i, CAUSE_ARRIVE c) {
/* 676 */       if (c != null) {
/* 677 */         this.arrive.set(i, c);
/* 678 */         ((PopData)this.enters.get(c.index())).inc(i);
/* 679 */         if (c.fromoutside && i.player())
/* 680 */           this.newEntries++; 
/*     */       } 
/*     */     }
/*     */     
/*     */     public void reg(Induvidual i, CAUSE_LEAVE c) {
/* 685 */       if (c != null) {
/* 686 */         ((PopData)this.deaths.get(c.index())).inc(i);
/* 687 */         if (!c.natural) {
/* 688 */           this.wrongful.get((MAPPED)i.hType().parentClass()).incD(i.race(), c.defaultStanding());
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*     */     public static class PopData
/*     */     {
/* 695 */       private final HistoryRace[] data = new HistoryRace[HCLASSES.ALL().size()];
/* 696 */       private final HistoryRace total = new HistoryRace(32, (TIMECYCLE)TIME.days(), false);
/*     */       private final INFO info;
/*     */       
/*     */       PopData(String key, INFO info, StatsInit init, boolean save) {
/* 700 */         this.info = info;
/* 701 */         for (int i = 0; i < this.data.length; i++) {
/* 702 */           this.data[i] = new HistoryRace(32, (TIMECYCLE)TIME.days(), false);
/*     */         }
/*     */         
/* 705 */         init.savers.put("POPDATA_" + key, new SAVABLE()
/*     */             {
/*     */               public void save(FilePutter file)
/*     */               {
/* 709 */                 HCLASSES.MAP().saver().save((SAVABLE[])StatsPopulation.StatsDeath.PopData.this.data, file);
/*     */               }
/*     */ 
/*     */ 
/*     */               
/*     */               public void load(FileGetter file) throws IOException {
/* 715 */                 HCLASSES.MAP().loader().load((SAVABLE[])StatsPopulation.StatsDeath.PopData.this.data, file);
/*     */               } public void clear() {
/*     */                 byte b;
/*     */                 int i;
/*     */                 HistoryRace[] arrayOfHistoryRace;
/* 720 */                 for (i = (arrayOfHistoryRace = StatsPopulation.StatsDeath.PopData.this.data).length, b = 0; b < i; ) { HistoryRace r = arrayOfHistoryRace[b];
/* 721 */                   r.clear();
/*     */                   b++; }
/*     */               
/*     */               }
/*     */             });
/*     */       }
/*     */       public HISTORY_COLLECTION<Race> statistics(HCLASS c) {
/* 728 */         if (c == null)
/* 729 */           return (HISTORY_COLLECTION<Race>)this.total; 
/* 730 */         return (HISTORY_COLLECTION<Race>)this.data[c.index()];
/*     */       }
/*     */       
/*     */       void inc(Induvidual i) {
/* 734 */         if (i.player()) {
/* 735 */           this.total.inc(i.race(), 1);
/*     */         }
/* 737 */         this.data[i.clas().index()].inc(i.race(), 1);
/*     */       }
/*     */       
/*     */       public INFO info() {
/* 741 */         return this.info;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class PopType
/*     */     implements GETTER_TRANS<Induvidual, PopType.Type>
/*     */   {
/*     */     private final INT_O.INT_OE<Induvidual> d;
/*     */ 
/*     */     
/* 755 */     private final ArrayListGrower<Type> all = new ArrayListGrower();
/*     */     
/*     */     public final Type IMMIGRANT;
/*     */     public final Type NATIVE;
/*     */     public final Type FORMER_SLAVE;
/*     */     
/*     */     PopType(StatsInit init) {
/* 762 */       init.count.getClass(); this.d = (INT_O.INT_OE<Induvidual>)new DataO.DataNibble(init.count, "POP_TYPE");
/* 763 */       this.IMMIGRANT = (Type)this.all.addReturn(new Type(0, "IMMIGRANTS", init, (SPRITE)(UI.icons()).m.arrow_right));
/* 764 */       this.NATIVE = (Type)this.all.addReturn(new Type(1, "NATIVES", init, (SPRITE)(UI.icons()).m.citizen));
/* 765 */       this.FORMER_SLAVE = (Type)this.all.addReturn(new Type(2, "FORMER_SLAVES", init, (SPRITE)(UI.icons()).m.chainsFree));
/*     */       
/* 767 */       for (Type t : this.all) {
/* 768 */         t.info().setInt();
/*     */       }
/* 770 */       init.addable.add(new StatsInit.Addable()
/*     */           {
/*     */             public void removePrivate(Induvidual i)
/*     */             {
/* 774 */               if ((i.clas()).player && i.clas() != HCLASSES.SLAVE()) {
/* 775 */                 ((StatsPopulation.PopType.Type)StatsPopulation.PopType.this.all.getC(StatsPopulation.PopType.this.d.get(i))).data.inc(-1);
/*     */               }
/*     */             }
/*     */             
/*     */             public void addPrivate(Induvidual i) {
/* 780 */               if ((i.clas()).player && i.clas() != HCLASSES.SLAVE()) {
/* 781 */                 ((StatsPopulation.PopType.Type)StatsPopulation.PopType.this.all.get(StatsPopulation.PopType.this.d.get(i))).data.inc(1);
/*     */               }
/*     */             }
/*     */           });
/* 785 */       init.copier.add(new INT_O.INT_OE<Induvidual>()
/*     */           {
/*     */             public int get(Induvidual t)
/*     */             {
/* 789 */               return (StatsPopulation.PopType.this.get(t)).index;
/*     */             }
/*     */ 
/*     */             
/*     */             public int min(Induvidual t) {
/* 794 */               return 0;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max(Induvidual t) {
/* 799 */               return StatsPopulation.PopType.this.all.size() - 1;
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(Induvidual t, int i) {
/* 804 */               ((StatsPopulation.PopType.Type)StatsPopulation.PopType.this.all.getC(i)).set(t);
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Type get(Induvidual f) {
/* 813 */       return (Type)this.all.getC(this.d.get(f));
/*     */     }
/*     */     
/*     */     public Type getByIndex(int in) {
/* 817 */       return (Type)this.all.get(in);
/*     */     }
/*     */     
/*     */     public LIST<Type> all() {
/* 821 */       return (LIST<Type>)this.all;
/*     */     }
/*     */     
/*     */     public class Type extends STATFake {
/*     */       public final int index;
/*     */       
/* 827 */       private final HistoryInt data = new HistoryInt(32, (TIMECYCLE)TIME.days(), true)
/*     */         {
/*     */           public void load(FileGetter file) throws IOException
/*     */           {
/* 831 */             super.load(file);
/* 832 */             set(0);
/*     */           }
/*     */         };
/*     */       
/*     */       Type(int index, String key, StatsInit init, SPRITE icon) {
/* 837 */         super(key, init, null);
/* 838 */         this.index = index;
/* 839 */         init.savers.put("PTYPE_" + key, this.data);
/* 840 */         this.info.icon = icon;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       protected double induGet(Induvidual t) {
/* 846 */         return ((StatsPopulation.PopType.this.d.get(t) == this.index) ? true : false);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       protected double getDD(HCLASS s, Race r, int daysBack) {
/* 852 */         double pop = (STATS.POP()).POP.data().get(null, daysBack);
/* 853 */         double type = this.data.get(daysBack);
/*     */         
/* 855 */         if (pop <= 0.0D)
/* 856 */           return 0.0D; 
/* 857 */         double v = type / pop;
/* 858 */         v = CLAMP.d(v, 0.0D, 1.0D);
/*     */         
/* 860 */         return v;
/*     */       }
/*     */ 
/*     */       
/*     */       public int pdivider(HCLASS c, Race r, int daysback) {
/* 865 */         return (STATS.POP()).POP.data().get(null, daysback);
/*     */       }
/*     */       
/*     */       public void set(Induvidual f) {
/* 869 */         if (f.added() && (f.clas()).player && f.clas() != HCLASSES.SLAVE()) {
/* 870 */           ((Type)StatsPopulation.PopType.this.all.getC(StatsPopulation.PopType.this.d.get(f))).data.inc(-1);
/* 871 */           StatsPopulation.PopType.this.d.set(f, this.index);
/* 872 */           this.data.inc(1);
/*     */         } else {
/* 874 */           StatsPopulation.PopType.this.d.set(f, this.index);
/*     */         } 
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Friend
/*     */     implements GETTER_TRANS.GETTER_TRANSE<Induvidual, ENTITY>
/*     */   {
/*     */     private final INT_O.INT_OE<Induvidual> i;
/*     */ 
/*     */ 
/*     */     
/*     */     Friend(StatsInit init) {
/* 890 */       init.count.getClass(); this.i = (INT_O.INT_OE<Induvidual>)new DataO.DataInt(init.count, "POP_FRIEND");
/*     */     }
/*     */ 
/*     */     
/*     */     public ENTITY get(Induvidual f) {
/* 895 */       int i = this.i.get(f);
/* 896 */       if (i == 0)
/* 897 */         return null; 
/* 898 */       ENTITY e = SETT.ENTITIES().getByID(i - 1);
/* 899 */       if (e == null || e.isRemoved())
/* 900 */         return null; 
/* 901 */       return e;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(Induvidual f, ENTITY t) {
/* 906 */       if (t == null) {
/* 907 */         this.i.set(f, 0);
/*     */       } else {
/* 909 */         this.i.set(f, t.id() + 1);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 916 */     int[] dd = Alloc.ii(100);
/*     */     
/* 918 */     for (int i = 0; i < dd.length * 200; i++) {
/* 919 */       int di = (int)(death() * dd.length);
/* 920 */       dd[di] = dd[di] + 1;
/*     */     } 
/*     */     
/* 923 */     int k = 0; byte b; int j, arrayOfInt1[];
/* 924 */     for (j = (arrayOfInt1 = dd).length, b = 0; b < j; ) { int d = arrayOfInt1[b];
/* 925 */       d = (int)Math.ceil((d = (int)(d / 10.0D)));
/* 926 */       String s = "" + k++;
/* 927 */       s = s + "\t";
/* 928 */       while (d-- > 0) {
/* 929 */         s = s + "*";
/*     */       }
/* 931 */       LOG.ln(s);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   static double death() {
/* 937 */     double ran = Math.abs(RND.rFloat());
/*     */     
/* 939 */     if (ran < 0.9D) {
/* 940 */       ran /= 0.9D;
/* 941 */       ran = Math.pow(ran, 0.2D);
/* 942 */       ran *= 0.9D;
/*     */     } else {
/* 944 */       ran -= 0.9D;
/* 945 */       ran /= 0.1D;
/* 946 */       ran = Math.pow(ran, 0.4D);
/* 947 */       ran = 1.0D - ran;
/* 948 */       ran = 0.9D + 0.1D * ran;
/*     */     } 
/*     */     
/* 951 */     return 0.45D + 0.55D * ran;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsPopulation.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */