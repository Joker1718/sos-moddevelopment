/*     */ package settlement.stats;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BValue;
/*     */ import game.debug.Profiler;
/*     */ import init.paths.PATH;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.value.GVALUES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.colls.StatsAccess;
/*     */ import settlement.stats.colls.StatsAppearance;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.colls.StatsBurial;
/*     */ import settlement.stats.colls.StatsEducation;
/*     */ import settlement.stats.colls.StatsEnv;
/*     */ import settlement.stats.colls.StatsFood;
/*     */ import settlement.stats.colls.StatsGovern;
/*     */ import settlement.stats.colls.StatsHome;
/*     */ import settlement.stats.colls.StatsNeeds;
/*     */ import settlement.stats.colls.StatsPopulation;
/*     */ import settlement.stats.colls.StatsReligion;
/*     */ import settlement.stats.colls.StatsStored;
/*     */ import settlement.stats.colls.StatsTraits;
/*     */ import settlement.stats.colls.StatsWork;
/*     */ import settlement.stats.disease.StatsDisease;
/*     */ import settlement.stats.equip.StatsEquip;
/*     */ import settlement.stats.event.StatsEvent;
/*     */ import settlement.stats.law.StatsLaw;
/*     */ import settlement.stats.muls.StatsMultipliers;
/*     */ import settlement.stats.relation.StatsRelations;
/*     */ import settlement.stats.service.StatsService;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import settlement.stats.util.StatBooster;
/*     */ import settlement.stats.util.StatsJson;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.misc.Dictionary;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.DataO;
/*     */ import util.data.DataRandom;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import util.updating.IUpdater;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class STATS
/*     */   extends SETT.SettResource
/*     */ {
/*     */   public static final int DAYS_SAVED = 32;
/*     */   private static STATS s;
/*     */   private final StatsBattle battle;
/*     */   private final StatsEnv environment;
/*     */   private final StatsAccess access;
/*     */   private final StatsPopulation population;
/*     */   private final StatsGovern govern;
/*     */   private final StatsLaw law;
/*     */   private final StatsWork work;
/*     */   private final StatsHome home;
/*     */   private final StatsService services;
/*     */   private final StatsNeeds needs;
/*     */   private final StatsFood food;
/*     */   private final StatsTraits traits;
/*     */   private final StatsDisease disease;
/*     */   private final StatsEvent event;
/*     */   private final StatsEquip equipables;
/*     */   private final StatsEducation education;
/*     */   private final StatsStored stored;
/*     */   private final StatsBurial burial;
/*     */   private final StatsReligion religion;
/*     */   private final StatsMultipliers multipliers;
/*     */   private final StatsAppearance appearance;
/*     */   private final StatsRelations relations;
/*     */   private final DataRandom<Induvidual> random;
/*     */   private final DataO<Induvidual> count;
/*     */   private final KeyMap<SAVABLE> savables;
/*     */   private final LIST<StatsInit.Addable> addables;
/*     */   private final LIST<StatsInit.StatUpdatableI> updaters;
/*     */   private final LIST<StatsInit.StatUpdatable> uppers;
/*     */   private final LIST<StatsInit.StatInitable> constructers;
/*     */   private final LIST<StatsInit.StatDisposable> disposables;
/*     */   private final LIST<STAT> stats;
/*     */   private final LIST<StatCollection> collections;
/*     */   private final KeyMap<StatCollection> mapColl;
/*     */   private final KeyMap<STAT> mapStat;
/*     */   private final IUpdater upper;
/* 122 */   private final short[] iOff = new short[256];
/*     */   
/*     */   public final INFO iStats;
/*     */   
/*     */   private final StatArrival arrival;
/*     */   
/*     */   final StatCopy copy;
/*     */ 
/*     */   
/*     */   public static void create() throws IOException {}
/*     */ 
/*     */   
/*     */   private STATS() throws IOException {
/* 135 */     super("STATS", true);
/* 136 */     StatsInit init = new StatsInit();
/*     */     
/* 138 */     STATS.s = this;
/*     */     
/* 140 */     D.gInit(this);
/* 141 */     this.iStats = new INFO(D.g("Status"), 
/* 142 */         D.g("desc", "Miscellaneous statistics about your city. Some affecting your subject's happiness."));
/*     */     
/* 144 */     this.random = new DataRandom(init.count, 4);
/* 145 */     init.onConstruct.add(new StatsInit.StatInitable()
/*     */         {
/*     */           public void init(Induvidual h)
/*     */           {
/* 149 */             STATS.this.random.randomize(h);
/*     */           }
/*     */         });
/*     */     
/* 153 */     CharSequence nn = D.g("random", "Random Chance");
/*     */     
/* 155 */     for (int i = 0; i < 8; i++) {
/* 156 */       final int k = 8 * i;
/*     */       
/* 158 */       INT_O<Induvidual> o = new INT_O<Induvidual>()
/*     */         {
/*     */           public int get(Induvidual t)
/*     */           {
/* 162 */             return STATS.this.random.get(t, 64 + k) & 0xFF;
/*     */           }
/*     */ 
/*     */           
/*     */           public int min(Induvidual t) {
/* 167 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max(Induvidual t) {
/* 172 */             return 255;
/*     */           }
/*     */         };
/*     */       
/* 176 */       GVALUES.INDU.push("RANDOM_" + i + "_F", nn, (SPRITE)(UI.icons()).s.question, (DOUBLE_O)o);
/* 177 */       GVALUES.INDU.pushI("RANDOM_" + i + "_I", nn, (SPRITE)(UI.icons()).s.question, o);
/*     */     } 
/*     */     
/* 180 */     this.population = new StatsPopulation(init);
/* 181 */     this.law = new StatsLaw(init);
/* 182 */     this.govern = new StatsGovern(init);
/* 183 */     this.equipables = new StatsEquip(init);
/* 184 */     this.work = new StatsWork(init);
/* 185 */     this.home = new StatsHome(init);
/* 186 */     this.food = new StatsFood(init);
/* 187 */     this.services = new StatsService(init);
/* 188 */     this.environment = new StatsEnv(init);
/* 189 */     this.access = new StatsAccess(init);
/*     */     
/* 191 */     this.battle = new StatsBattle(init);
/* 192 */     this.needs = new StatsNeeds(init);
/* 193 */     this.education = new StatsEducation(init);
/* 194 */     this.traits = new StatsTraits(init);
/* 195 */     this.disease = new StatsDisease(init);
/* 196 */     this.event = new StatsEvent(init);
/* 197 */     this.stored = new StatsStored(init);
/* 198 */     this.burial = new StatsBurial(init);
/* 199 */     this.religion = new StatsReligion(init);
/* 200 */     this.multipliers = new StatsMultipliers(init, this.services);
/*     */     
/* 202 */     this.appearance = new StatsAppearance(init);
/* 203 */     this.relations = new StatsRelations(init);
/*     */     
/* 205 */     this.addables = (LIST<StatsInit.Addable>)new ArrayList((Iterable)init.addable);
/*     */     
/* 207 */     this.savables = init.savers;
/*     */     
/* 209 */     this.updaters = (LIST<StatsInit.StatUpdatableI>)new ArrayList((Iterable)init.updatable);
/* 210 */     this.disposables = (LIST<StatsInit.StatDisposable>)new ArrayList((Iterable)init.disposable);
/* 211 */     this.stats = (LIST<STAT>)new ArrayList((Iterable)init.stats);
/* 212 */     this.collections = (LIST<StatCollection>)new ArrayList((Iterable)init.holders);
/* 213 */     this.constructers = (LIST<StatsInit.StatInitable>)new ArrayList((Iterable)init.onConstruct);
/* 214 */     this.uppers = (LIST<StatsInit.StatUpdatable>)new ArrayList((Iterable)init.upers);
/*     */     
/* 216 */     Arrays.fill(this.iOff, (short)-1);
/* 217 */     int v = 255;
/* 218 */     int div = 2;
/*     */     
/* 220 */     while (v >= 0) {
/* 221 */       int m = 256 / div;
/* 222 */       for (final int k = 1; k < div; k++) {
/* 223 */         if (this.iOff[k * m] == -1) {
/* 224 */           this.iOff[k * m] = (short)v;
/* 225 */           v--;
/*     */         } 
/*     */       } 
/* 228 */       div++;
/*     */     } 
/*     */ 
/*     */     
/* 232 */     this.count = init.count;
/*     */     
/* 234 */     this.mapColl = init.collMap;
/* 235 */     this.mapStat = init.statMap;
/*     */     
/* 237 */     this.upper = new IUpdater(this.uppers.size(), 8.0D)
/*     */       {
/*     */         protected void update(int i, double timeSinceLast)
/*     */         {
/* 241 */           ((StatsInit.StatUpdatable)STATS.this.uppers.get(i)).update(timeSinceLast);
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
/* 262 */     PATH p = init.pd.getFolder("loyalty"); byte b; int j; String[] arrayOfString;
/* 263 */     for (j = (arrayOfString = p.getFiles()).length, b = 0; b < j; ) { String f = arrayOfString[b];
/*     */       
/* 265 */       Json file = new Json(p.gets(f));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       b++; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 286 */     for (STAT s : all()) {
/* 287 */       if (s.standing == null) {
/* 288 */         s.standing = new StatStanding(s, 0.0D);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 293 */     p = init.pd.getFolder("bonus");
/* 294 */     for (j = (arrayOfString = p.getFiles()).length, b = 0; b < j; ) { String f = arrayOfString[b];
/*     */       
/* 296 */       Json file = new Json(p.gets(f));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       b++; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 316 */     this.arrival = new StatArrival(init);
/* 317 */     this.copy = new StatCopy(init);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static StatsBattle BATTLE() {
/* 323 */     return s.battle;
/*     */   }
/*     */   
/*     */   public static StatsEnv ENV() {
/* 327 */     return s.environment;
/*     */   }
/*     */   
/*     */   public static StatsAccess ACCESS() {
/* 331 */     return s.access;
/*     */   }
/*     */   
/*     */   public static StatsPopulation POP() {
/* 335 */     return s.population;
/*     */   }
/*     */   
/*     */   public static StatsLaw LAW() {
/* 339 */     return s.law;
/*     */   }
/*     */   
/*     */   public static StatsGovern GOVERN() {
/* 343 */     return s.govern;
/*     */   }
/*     */   
/*     */   public static StatsFood FOOD() {
/* 347 */     return s.food;
/*     */   }
/*     */   
/*     */   public static StatsAppearance APPEARANCE() {
/* 351 */     return s.appearance;
/*     */   }
/*     */   
/*     */   public static StatsTraits TRAITS() {
/* 355 */     return s.traits;
/*     */   }
/*     */   
/*     */   public static StatsEquip EQUIP() {
/* 359 */     return s.equipables;
/*     */   }
/*     */   
/*     */   public static StatsWork WORK() {
/* 363 */     return s.work;
/*     */   }
/*     */   
/*     */   public static StatsEducation EDUCATION() {
/* 367 */     return s.education;
/*     */   }
/*     */   
/*     */   public static StatsMultipliers MULTIPLIERS() {
/* 371 */     return s.multipliers;
/*     */   }
/*     */   
/*     */   public static StatsNeeds NEEDS() {
/* 375 */     return s.needs;
/*     */   }
/*     */ 
/*     */   
/*     */   public static StatsHome HOME() {
/* 380 */     return s.home;
/*     */   }
/*     */   
/*     */   public static StatsBurial BURIAL() {
/* 384 */     return s.burial;
/*     */   }
/*     */   
/*     */   public static StatsReligion RELIGION() {
/* 388 */     return s.religion;
/*     */   }
/*     */   
/*     */   public static StatsService SERVICE() {
/* 392 */     return s.services;
/*     */   }
/*     */   
/*     */   public static StatsStored STORED() {
/* 396 */     return s.stored;
/*     */   }
/*     */   
/*     */   public static LIST<StatCollection> COLLECTIONS() {
/* 400 */     return s.collections;
/*     */   }
/*     */   
/*     */   public static StatCollection COLLECTION(String key) {
/* 404 */     return (StatCollection)s.mapColl.get(key);
/*     */   }
/*     */   
/*     */   public static STAT STAT(String key) {
/* 408 */     return (STAT)s.mapStat.get(key);
/*     */   }
/*     */   
/*     */   public static DataRandom<Induvidual> RAN() {
/* 412 */     return s.random;
/*     */   }
/*     */   
/*     */   public static StatsDisease DISEASE() {
/* 416 */     return s.disease;
/*     */   }
/*     */   
/*     */   public static StatsEvent EVENT() {
/* 420 */     return s.event;
/*     */   }
/*     */   
/*     */   public static StatsRelations REL() {
/* 424 */     return s.relations;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LIST<STAT> all() {
/* 432 */     return s.stats;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static LIST<STAT> createThoseThatMatters(Race r) {
/* 438 */     if (r == null)
/* 439 */       return createThoseThatMatters(); 
/* 440 */     ArrayList<STAT> res = new ArrayList(all().size());
/*     */     
/* 442 */     for (STAT s : all()) {
/* 443 */       boolean added = false;
/* 444 */       for (HCLASS c : HCLASSES.ALL()) {
/* 445 */         if (!added && s.key() != null && s.standing().max(c, r) > 0.0D) {
/* 446 */           res.add(s);
/* 447 */           added = true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 452 */     return (LIST<STAT>)res;
/*     */   }
/*     */   
/*     */   public static LIST<STAT> createThoseThatMatters() {
/* 456 */     ArrayList<STAT> res = new ArrayList(all().size());
/*     */     
/* 458 */     for (STAT s : all()) {
/* 459 */       boolean added = false;
/* 460 */       for (HCLASS c : HCLASSES.ALL()) {
/* 461 */         for (Race r : RACES.all()) {
/* 462 */           if (!added && s.key() != null && s.standing().max(c, r) > 0.0D) {
/* 463 */             res.add(s);
/* 464 */             added = true;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 471 */     return (LIST<STAT>)res;
/*     */   }
/*     */   
/*     */   public static LIST<STAT> createMatterList(boolean indu, boolean standing, Race race) {
/* 475 */     ArrayList<STAT> res = new ArrayList(all().size());
/*     */     
/* 477 */     LIST<Race> races = (race == null) ? RACES.all() : (LIST<Race>)new ArrayList(race);
/*     */     
/* 479 */     for (STAT s : all()) {
/* 480 */       if (s.key() == null)
/*     */         continue; 
/* 482 */       if (!s.info().matters())
/*     */         continue; 
/* 484 */       if (indu && !s.info().indu()) {
/*     */         continue;
/*     */       }
/* 487 */       if (standing) {
/* 488 */         boolean added = false;
/* 489 */         for (HCLASS c : HCLASSES.ALL()) {
/* 490 */           for (Race r : races) {
/* 491 */             if (!added && s.key() != null && s.standing().max(c, r) > 0.0D) {
/* 492 */               res.add(s);
/* 493 */               added = true;
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         continue;
/*     */       } 
/* 500 */       res.add(s);
/*     */     } 
/*     */ 
/*     */     
/* 504 */     res.sort(new Comparator<STAT>()
/*     */         {
/*     */           public int compare(STAT o1, STAT o2)
/*     */           {
/* 508 */             return Dictionary.compare((o1.info()).name, (o2.info()).name);
/*     */           }
/*     */         });
/*     */     
/* 512 */     return (LIST<STAT>)res;
/*     */   }
/*     */   
/*     */   static LIST<StatsInit.Addable> addables() {
/* 516 */     return s.addables;
/*     */   }
/*     */   
/*     */   public static INFO info() {
/* 520 */     return s.iStats;
/*     */   }
/*     */   
/*     */   static DataO<Induvidual> count() {
/* 524 */     return s.count;
/*     */   }
/*     */   
/*     */   static STATS get() {
/* 528 */     return s;
/*     */   }
/*     */   
/*     */   static void update(Humanoid h, int updateI, boolean day) {
/* 532 */     int updateR = s.iOff[updateI];
/* 533 */     for (StatsInit.StatUpdatableI u : s.updaters) {
/* 534 */       u.update16(h, updateR, day, updateI);
/* 535 */       if (h.isRemoved())
/*     */         return; 
/*     */     } 
/*     */   }
/*     */   
/*     */   void add(Induvidual h) {
/* 541 */     for (StatsInit.Addable s : this.addables) {
/* 542 */       s.addH(h);
/*     */     }
/*     */   }
/*     */   
/*     */   void remove(Induvidual i) {
/* 547 */     for (StatsInit.Addable s : this.addables) {
/* 548 */       s.removeH(i);
/*     */     }
/*     */   }
/*     */   
/*     */   void construct(Induvidual i) {
/* 553 */     for (StatsInit.StatInitable in : s.constructers) {
/* 554 */       in.init(i);
/*     */     }
/*     */   }
/*     */   
/*     */   void cancel(Humanoid h) {
/* 559 */     for (StatsInit.StatDisposable i : s.disposables) {
/* 560 */       i.dispose(h);
/*     */     }
/* 562 */     remove(h.indu());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 568 */     file.i(this.savables.size());
/* 569 */     for (String k : this.savables.keys()) {
/* 570 */       file.chars(k);
/* 571 */       int pos = file.getPosition();
/* 572 */       file.i(0);
/* 573 */       ((SAVABLE)this.savables.get(k)).save(file);
/* 574 */       file.setAtPosition(pos, file.getPosition() - pos);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 580 */     clear();
/* 581 */     int am = file.i();
/*     */     
/* 583 */     for (int i = 0; i < am; i++) {
/* 584 */       String k = file.chars();
/* 585 */       int pos = file.getPosition();
/* 586 */       int l = file.i();
/*     */       
/* 588 */       if (this.savables.containsKey(k)) {
/* 589 */         ((SAVABLE)this.savables.get(k)).load(file);
/* 590 */         if (file.getPosition() != pos + l) {
/* 591 */           GAME.Warn(k);
/* 592 */           ((SAVABLE)this.savables.get(k)).clear();
/* 593 */           file.setPosition(pos + l);
/*     */         } 
/*     */       } else {
/*     */         
/* 597 */         file.setPosition(file.getPosition() + l);
/* 598 */         LOG.ln(k);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 606 */     for (SAVABLE a : this.savables.all()) {
/* 607 */       a.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void init(boolean loaded) {
/* 613 */     for (StatsInit.StatUpdatable i : this.uppers) {
/* 614 */       i.update(1.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void update(double ds, Profiler profiler) {
/* 619 */     this.upper.update(ds);
/*     */   }
/*     */   
/*     */   public static void Arrive(Humanoid h) {
/* 623 */     s.arrival.arrive(h);
/*     */   }
/*     */   
/*     */   private static final class StatArrival {
/*     */     private final ArrayList<StatsInit.StatInitable> inits;
/*     */     private final ArrayList<STAT> initsS;
/*     */     public final ArrayList<ACTION.ACTION_O<Induvidual>> onArrivalActions;
/*     */     
/*     */     private StatArrival(StatsInit init) {
/* 632 */       this.inits = new ArrayList((Iterable)init.onArrival);
/* 633 */       this.initsS = new ArrayList((Iterable)init.onArrivalStats);
/* 634 */       this.onArrivalActions = new ArrayList((Iterable)init.onArrivalActions);
/*     */     }
/*     */     
/*     */     public void arrive(Humanoid h) {
/* 638 */       for (StatsInit.StatInitable i : this.inits)
/* 639 */         i.init(h.indu()); 
/* 640 */       for (STAT s : this.initsS) {
/* 641 */         double d = s.data(h.indu().clas()).getD(h.race());
/*     */ 
/*     */ 
/*     */         
/* 645 */         d *= s.indu().max(h.indu());
/* 646 */         int v = (int)d;
/* 647 */         if (d - v > RND.rFloat()) {
/* 648 */           v++;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 653 */         v = CLAMP.i(v, 0, s.indu().max(h.indu()));
/* 654 */         s.indu().set(h.indu(), v);
/*     */       } 
/*     */ 
/*     */       
/* 658 */       for (ACTION.ACTION_O<Induvidual> a : this.onArrivalActions) {
/* 659 */         a.exe(h.indu());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static final class StatCopy
/*     */   {
/*     */     private final ArrayList<INT_O.INT_OE<Induvidual>> copies;
/*     */     
/*     */     private StatCopy(StatsInit init) {
/* 669 */       this.copies = new ArrayList((Iterable)init.copier);
/*     */     }
/*     */     
/*     */     public void copy(Induvidual dest, Induvidual source) {
/* 673 */       for (INT_O.INT_OE<Induvidual> ii : this.copies) {
/* 674 */         ii.set(dest, ii.get(source));
/*     */       }
/* 676 */       STATS.RAN().copyFrom(dest, source);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\STATS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */