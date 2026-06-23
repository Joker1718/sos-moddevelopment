/*      */ package settlement.stats.muls;
/*      */ 
/*      */ import game.GAME;
/*      */ import game.battle.div.Div;
/*      */ import game.boosting.BOOSTING;
/*      */ import game.boosting.BValue;
/*      */ import game.boosting.BoostSpec;
/*      */ import game.boosting.BoostSpecs;
/*      */ import game.faction.FACTIONS;
/*      */ import game.faction.FCredits;
/*      */ import game.faction.npc.FactionNPC;
/*      */ import game.faction.player.Player;
/*      */ import game.time.TIME;
/*      */ import game.time.TIMECYCLE;
/*      */ import init.race.RACES;
/*      */ import init.race.Race;
/*      */ import init.sprite.SPRITES;
/*      */ import init.sprite.UI.UI;
/*      */ import init.type.CAUSE_ARRIVES;
/*      */ import init.type.CRIMES;
/*      */ import init.type.HCLASS;
/*      */ import init.type.HCLASSES;
/*      */ import init.type.HCLASS_RACE;
/*      */ import init.type.HTYPE;
/*      */ import init.type.HTYPES;
/*      */ import java.io.IOException;
/*      */ import java.util.Arrays;
/*      */ import settlement.entity.ENTITY;
/*      */ import settlement.entity.EntityIterator;
/*      */ import settlement.entity.humanoid.Humanoid;
/*      */ import settlement.main.SETT;
/*      */ import settlement.room.main.RoomBlueprint;
/*      */ import settlement.room.main.RoomBlueprintImp;
/*      */ import settlement.room.main.RoomInstance;
/*      */ import settlement.room.main.employment.RoomEmploymentSimple;
/*      */ import settlement.stats.Induvidual;
/*      */ import settlement.stats.STATS;
/*      */ import settlement.stats.StatsInit;
/*      */ import settlement.stats.service.StatsService;
/*      */ import settlement.stats.stat.SETT_STATISTICS;
/*      */ import snake2d.util.file.Alloc;
/*      */ import snake2d.util.file.FileGetter;
/*      */ import snake2d.util.file.FilePutter;
/*      */ import snake2d.util.file.Json;
/*      */ import snake2d.util.file.SAVABLE;
/*      */ import snake2d.util.misc.ACTION;
/*      */ import snake2d.util.misc.CLAMP;
/*      */ import snake2d.util.rnd.RND;
/*      */ import snake2d.util.sets.ArrayInt;
/*      */ import snake2d.util.sets.ArrayList;
/*      */ import snake2d.util.sets.ArrayListGrower;
/*      */ import snake2d.util.sets.INDEXED;
/*      */ import snake2d.util.sets.LIST;
/*      */ import snake2d.util.sets.LISTE;
/*      */ import snake2d.util.sets.LinkedList;
/*      */ import snake2d.util.sprite.SPRITE;
/*      */ import util.data.DOUBLE;
/*      */ import util.data.DataO;
/*      */ import util.data.INT;
/*      */ import util.data.INT_O;
/*      */ import util.gui.misc.GBox;
/*      */ import util.info.GFORMAT;
/*      */ import util.info.INFO;
/*      */ import util.keymap.MAPPED;
/*      */ import util.keymap.RMAP;
/*      */ import util.keymap.RMapInt;
/*      */ import util.statistics.HistoryInt;
/*      */ import util.statistics.HistoryRace;
/*      */ import util.text.Dic;
/*      */ import world.map.regions.Region;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class StatsMultipliers
/*      */ {
/*      */   private static final String pre = "EVENT_";
/*      */   private final LIST<LIST<StatMultiplier>> classes;
/*      */   private final LIST<StatMultiplier> all;
/*      */   public final StatMultiplier KILLER;
/*      */   public final StatMultiplierAction PROSECUTION;
/*      */   public final StatMultiplierAction EMANCIPATE;
/*      */   public final StatMultiplierAction HANDOUT;
/*      */   public final StatMultiplierAction DAY_OFF;
/*      */   public final StatMultiplierWork OVERTIME;
/*      */   public final RMAP<StatMultiplier> MAP;
/*      */   
/*      */   public StatsMultipliers(StatsInit init, StatsService service) {
/*   92 */     LinkedList<StatMultiplier> all = new LinkedList();
/*      */     
/*   94 */     this.KILLER = new Killer(init, (LISTE<StatMultiplier>)all);
/*   95 */     this.PROSECUTION = new Prosecution(init, (LISTE<StatMultiplier>)all);
/*   96 */     this.EMANCIPATE = new Emancipate(init, (LISTE<StatMultiplier>)all);
/*      */     
/*   98 */     this.HANDOUT = new Handout("HANDOUT", init, (LISTE<StatMultiplier>)all, (SPRITE)(SPRITES.icons()).s.money, new HCLASS[] { HCLASSES.CITIZEN() });
/*   99 */     this.DAY_OFF = new StatMultiplierActionImp("DAY_OFF", init, (LISTE<StatMultiplier>)all, (SPRITE)new SPRITE.Twin((SPRITE)(SPRITES.icons()).m.workshop, (SPRITE)(SPRITES.icons()).m.anti), new HCLASS[] { HCLASSES.CITIZEN() });
/*  100 */     this.OVERTIME = new StatMultiplierWork("OVERTIME", init, (LISTE<StatMultiplier>)all, (SPRITE)new SPRITE.Twin((SPRITE)(SPRITES.icons()).m.workshop, (SPRITE)(SPRITES.icons()).m.arrow_up), new HCLASS[] { HCLASSES.CITIZEN() });
/*      */     
/*  102 */     this.all = (LIST<StatMultiplier>)new ArrayList((Iterable)all);
/*      */ 
/*      */ 
/*      */     
/*  106 */     ArrayList<LIST<StatMultiplier>> classes = new ArrayList(HCLASSES.ALL().size());
/*      */     
/*  108 */     for (HCLASS cl : HCLASSES.ALL()) {
/*  109 */       all = new LinkedList();
/*  110 */       for (StatMultiplier m : this.all) {
/*  111 */         if (m.classes[cl.index()])
/*  112 */           all.add(m); 
/*      */       } 
/*  114 */       ArrayList arrayList = new ArrayList((Iterable)all);
/*  115 */       classes.add(arrayList);
/*      */     } 
/*      */     
/*  118 */     this.classes = (LIST<LIST<StatMultiplier>>)classes;
/*      */     
/*  120 */     init.upers.add(new StatsInit.StatUpdatable()
/*      */         {
/*      */           public void update(double ds)
/*      */           {
/*  124 */             for (StatsMultipliers.StatMultiplier m : StatsMultipliers.this.all) {
/*  125 */               m.update(ds);
/*      */             }
/*      */           }
/*      */         });
/*      */ 
/*      */ 
/*      */     
/*  132 */     this.MAP = new RMAP("MULTIPLIERS", this.all);
/*      */   }
/*      */   
/*      */   public void setBoost(final StatMultiplier m, Json json, String key) {
/*  136 */     BValue b = new BValue()
/*      */       {
/*      */         public double vGet(Div div)
/*      */         {
/*  140 */           return 0.0D;
/*      */         }
/*      */ 
/*      */         
/*      */         public double vGet(Induvidual indu) {
/*  145 */           return m.value(indu);
/*      */         }
/*      */ 
/*      */         
/*      */         public double vGet(Region reg) {
/*  150 */           return 0.0D;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public double vGet(Player f) {
/*  156 */           return vGet(HCLASS_RACE.clP());
/*      */         }
/*      */ 
/*      */         
/*      */         public double vGet(FactionNPC f) {
/*  161 */           return 0.0D;
/*      */         }
/*      */ 
/*      */         
/*      */         public double vGet(HCLASS_RACE t) {
/*  166 */           return m.value(t.cl, t.race, 0);
/*      */         }
/*      */       };
/*      */     
/*  170 */     m.boosters.read(key, json, b);
/*      */   }
/*      */   
/*      */   public LIST<StatMultiplier> get(HCLASS cl) {
/*  174 */     return (LIST<StatMultiplier>)this.classes.get(cl.index());
/*      */   }
/*      */   
/*      */   public LIST<StatMultiplier> all() {
/*  178 */     return this.all;
/*      */   }
/*      */   
/*      */   public static abstract class StatMultiplier
/*      */     extends INFO implements MAPPED {
/*      */     private final int index;
/*      */     public final String key;
/*      */     public final CharSequence verb;
/*  186 */     protected boolean[] classes = new boolean[HCLASSES.ALL().size()];
/*      */     public final BoostSpecs boosters;
/*      */     
/*      */     private StatMultiplier(StatsMultipliers.C cc, LISTE<StatMultiplier> all, HCLASS... cl) {
/*  190 */       super(cc.name, cc.desc);
/*  191 */       this.verb = cc.verb;
/*  192 */       this.index = all.add(this);
/*  193 */       this.key = cc.key;
/*      */       
/*  195 */       this.boosters = new BoostSpecs(cc.name, (SPRITE)(UI.icons()).s.crown, true); byte b; int i;
/*      */       HCLASS[] arrayOfHCLASS;
/*  197 */       for (i = (arrayOfHCLASS = cl).length, b = 0; b < i; ) { HCLASS c = arrayOfHCLASS[b];
/*  198 */         this.classes[c.index()] = true;
/*      */         b++; }
/*      */     
/*      */     }
/*      */     
/*      */     public int index() {
/*  204 */       return this.index;
/*      */     }
/*      */     
/*      */     public boolean available(HCLASS cl) {
/*  208 */       return this.classes[cl.index()];
/*      */     }
/*      */     
/*      */     public boolean available(HTYPE t) {
/*  212 */       return this.classes[t.CLASS.index()];
/*      */     }
/*      */     
/*      */     public boolean available(Induvidual i) {
/*  216 */       return available(i.clas());
/*      */     }
/*      */ 
/*      */     
/*      */     public abstract double value(Induvidual param1Induvidual);
/*      */     
/*      */     public abstract double value(HCLASS param1HCLASS, Race param1Race, int param1Int);
/*      */     
/*      */     protected abstract void update(double param1Double);
/*      */     
/*      */     public String key() {
/*  227 */       return this.key;
/*      */     }
/*      */   }
/*      */   
/*      */   private static class Killer
/*      */     extends StatMultiplier
/*      */   {
/*  234 */     private final StatsMultipliers.Data data = new StatsMultipliers.Data();
/*      */     private static final double di = 0.001D;
/*      */     
/*      */     private Killer(StatsInit init, LISTE<StatsMultipliers.StatMultiplier> all) {
/*  238 */       super(new StatsMultipliers.C("SERIAL_KILLER", init), all, new HCLASS[] { HCLASSES.CITIZEN(), HCLASSES.SLAVE() });
/*  239 */       init.savers.put("SERIAL_KILLER_DATA", this.data);
/*      */     }
/*      */ 
/*      */     
/*      */     public double value(HCLASS cl, Race race, int daysBack) {
/*  244 */       if (cl == null) {
/*  245 */         double v = 0.0D;
/*  246 */         double am = 0.0D;
/*  247 */         for (int ci = 0; ci < HCLASSES.ALL().size(); ci++) {
/*  248 */           HCLASS cll = (HCLASS)HCLASSES.ALL().get(ci);
/*  249 */           if (cll.player) {
/*  250 */             double p = (STATS.POP()).POP.data(cll).get(race);
/*  251 */             v += value(cll, race, daysBack) * p;
/*  252 */             am += p;
/*      */           } 
/*      */         } 
/*  255 */         if (am == 0.0D)
/*  256 */           return 0.0D; 
/*  257 */         return 0.001D * v / am;
/*      */       } 
/*      */       
/*  260 */       if (race == null) {
/*  261 */         double v = 0.0D;
/*  262 */         double am = 0.0D;
/*  263 */         for (int ri = 0; ri < RACES.all().size(); ri++) {
/*  264 */           Race r = (Race)RACES.all().get(ri);
/*  265 */           double p = (STATS.POP()).POP.data(cl).get(r);
/*  266 */           v += this.data.get(cl).history(r).get(daysBack) * p;
/*  267 */           am += p;
/*      */         } 
/*  269 */         if (am == 0.0D)
/*  270 */           return 0.0D; 
/*  271 */         return 0.001D * v / am;
/*      */       } 
/*  273 */       return this.data.get(cl).history(race).get(daysBack) * 0.001D;
/*      */     }
/*      */ 
/*      */     
/*      */     protected void update(double ds) {
/*  278 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/*  279 */         Race r = (Race)RACES.all().get(ri);
/*  280 */         double ra = ((GAME.events()).killer.victimRace() == r) ? (GAME.events()).killer.rate() : 0.0D;
/*  281 */         this.data.get(HCLASSES.CITIZEN()).set(r, (int)(1000.0D * ra));
/*  282 */         this.data.get(HCLASSES.SLAVE()).set(r, (int)(1000.0D * ra));
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public double value(Induvidual h) {
/*  289 */       return value(h.clas(), h.race(), 0);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static abstract class StatMultiplierAction
/*      */     extends StatMultiplier
/*      */   {
/*      */     public final SPRITE icon;
/*  298 */     private final ArrayListGrower<INT.IntImp> auto = new ArrayListGrower();
/*      */ 
/*      */     
/*      */     private StatMultiplierAction(String key, StatsInit init, LISTE<StatsMultipliers.StatMultiplier> all, final int autoDef, int autoMax, SPRITE icon, HCLASS... cl) {
/*  302 */       super(new StatsMultipliers.C(key, init), all, cl);
/*  303 */       this.icon = icon;
/*      */       
/*  305 */       for (HCLASS_RACE c : HCLASS_RACE.ALL()) {
/*  306 */         this.auto.add(new INT.IntImp(autoDef, 0, autoMax));
/*      */       }
/*  308 */       init.savers.put("MUL_AUTO_" + key, new SAVABLE()
/*      */           {
/*      */             public void save(FilePutter file)
/*      */             {
/*  312 */               HCLASS_RACE.MAP().saver().save((LIST)StatsMultipliers.StatMultiplierAction.this.auto, file);
/*      */             }
/*      */ 
/*      */             
/*      */             public void load(FileGetter file) throws IOException {
/*  317 */               HCLASS_RACE.MAP().loader().load((LIST)StatsMultipliers.StatMultiplierAction.this.auto, file);
/*      */             }
/*      */ 
/*      */             
/*      */             public void clear() {
/*  322 */               for (INT.IntImp i : StatsMultipliers.StatMultiplierAction.this.auto) {
/*  323 */                 i.set(autoDef);
/*      */               }
/*      */             }
/*      */           });
/*  327 */       init.upers.add(new StatsInit.StatUpdatable()
/*      */           {
/*      */             int ii;
/*      */ 
/*      */             
/*      */             public void update(double ds) {
/*  333 */               if (this.ii >= 60000)
/*  334 */                 this.ii = 0; 
/*  335 */               ENTITY e = SETT.ENTITIES().getAllEnts()[this.ii];
/*  336 */               if (e != null && e instanceof Humanoid) {
/*  337 */                 Humanoid h = (Humanoid)e;
/*  338 */                 if (StatsMultipliers.StatMultiplierAction.this.autoAmount(h.indu().clas(), h.indu().race()) > 0 && StatsMultipliers.StatMultiplierAction.this.canBeMarked(h.indu())) {
/*  339 */                   StatsMultipliers.StatMultiplierAction.this.mark(h, true);
/*      */                 }
/*      */               } 
/*  342 */               this.ii++;
/*      */             }
/*      */           });
/*      */     }
/*      */ 
/*      */     
/*      */     private StatMultiplierAction(StatsMultipliers.C c, LISTE<StatsMultipliers.StatMultiplier> all, SPRITE icon, HCLASS... cl) {
/*  349 */       super(c, all, cl);
/*  350 */       this.icon = icon;
/*      */     }
/*      */     public abstract boolean canUnmark();
/*      */     public abstract int unmarkable(HCLASS param1HCLASS, Race param1Race);
/*      */     public abstract void unmark(HCLASS param1HCLASS, Race param1Race);
/*      */     
/*      */     public boolean markIs(Humanoid a) {
/*  357 */       return markIs(a.indu());
/*      */     }
/*      */     public abstract boolean markIs(Induvidual param1Induvidual);
/*      */     public boolean canBeMarked(Induvidual a) {
/*  361 */       if (!this.classes[a.clas().index()])
/*  362 */         return false; 
/*  363 */       if (markIs(a))
/*  364 */         return false; 
/*  365 */       return (maxAmount(a.clas(), a.race()) > 0);
/*      */     }
/*      */     public abstract void mark(HCLASS param1HCLASS, Race param1Race, int param1Int);
/*      */     public abstract void mark(Humanoid param1Humanoid, boolean param1Boolean);
/*      */     public abstract void consume(Humanoid param1Humanoid);
/*      */     public final boolean consumeIs(Humanoid a) {
/*  371 */       return consumeIs(a.indu());
/*      */     }
/*      */     public abstract boolean consumeIs(Induvidual param1Induvidual);
/*      */     
/*      */     public abstract int maxAmount(HCLASS param1HCLASS, Race param1Race);
/*      */     
/*      */     public void info(GBox box, int amount) {}
/*      */     
/*      */     public abstract int autoAmount(HCLASS param1HCLASS, Race param1Race);
/*      */     
/*      */     public INT.IntImp auto(HCLASS cl, Race race) {
/*  382 */       return (INT.IntImp)this.auto.get((HCLASS_RACE.clP(race, cl)).index);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class Prosecution
/*      */     extends StatMultiplierAction
/*      */   {
/*      */     private final INT_O.INT_OE<Induvidual> in;
/*  391 */     protected final ArrayInt count = new ArrayInt(HCLASS_RACE.ALL().size());
/*      */     
/*      */     private Prosecution(StatsInit init, LISTE<StatsMultipliers.StatMultiplier> all) {
/*  394 */       super("PROSECUTION", init, all, 60000, 60000, (SPRITE)(SPRITES.icons()).m.slave, new HCLASS[] { HCLASSES.CITIZEN(), HCLASSES.SLAVE() });
/*  395 */       init.savers.put("PROSECUTION_COUNT", new SAVABLE()
/*      */           {
/*      */             public void save(FilePutter file) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public void load(FileGetter file) throws IOException {
/*  405 */               StatsMultipliers.Prosecution.this.count.clear();
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*      */             public void clear() {
/*  411 */               StatsMultipliers.Prosecution.this.count.clear();
/*      */             }
/*      */           });
/*  414 */       init.count.getClass(); this.in = (INT_O.INT_OE<Induvidual>)new DataO.DataBit(init.count, "MUL_PROSECUTION");
/*  415 */       init.addable.add(new StatsInit.Addable()
/*      */           {
/*      */             public void removePrivate(Induvidual i)
/*      */             {
/*  419 */               if (i.player()) {
/*  420 */                 StatsMultipliers.Prosecution.this.count.inc((INDEXED)i.popCL(), -StatsMultipliers.Prosecution.this.in.get(i));
/*      */               } else {
/*  422 */                 StatsMultipliers.Prosecution.this.in.set(i, 0);
/*      */               } 
/*      */             }
/*      */             
/*      */             public void addPrivate(Induvidual i) {
/*  427 */               if (i.player()) {
/*  428 */                 StatsMultipliers.Prosecution.this.count.inc((INDEXED)i.popCL(), StatsMultipliers.Prosecution.this.in.get(i));
/*      */               } else {
/*  430 */                 StatsMultipliers.Prosecution.this.in.set(i, 0);
/*      */               } 
/*      */             }
/*      */           });
/*      */     }
/*      */ 
/*      */     
/*      */     public double value(HCLASS cl, Race race, int daysBack) {
/*  438 */       return CLAMP.d(STATS.LAW().persecution(cl, race), 0.0D, 1.0D);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void update(double ds) {}
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean markIs(Induvidual a) {
/*  449 */       return (this.in.get(a) == 1);
/*      */     }
/*      */ 
/*      */     
/*      */     public void mark(Humanoid a, boolean set) {
/*  454 */       this.count.inc((INDEXED)a.indu().popCL(), -this.in.get(a.indu()));
/*  455 */       this.in.set(a.indu(), set ? 1 : 0);
/*  456 */       if (set)
/*  457 */         CRIMES.PERSECUTED().stat().commit(a.indu()); 
/*  458 */       this.count.inc((INDEXED)a.indu().popCL(), this.in.get(a.indu()));
/*      */     }
/*      */ 
/*      */     
/*      */     public int maxAmount(HCLASS cl, Race race) {
/*  463 */       return (STATS.POP()).POP.data(cl).get(race) - this.count.get((INDEXED)cl.get(race));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void mark(HCLASS cl, Race race, int amount) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean canUnmark() {
/*  486 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public int unmarkable(HCLASS cl, Race race) {
/*  491 */       return this.count.get((INDEXED)cl.get(race));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void unmark(HCLASS cl, Race race) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void consume(Humanoid a) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public double value(Induvidual h) {
/*  516 */       return ((this.in.get(h) == 1) ? true : false);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean consumeIs(Induvidual a) {
/*  521 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public void info(GBox box, int amount) {
/*  526 */       if ((SETT.ROOMS()).GUARD.employment().employed() == 0) {
/*  527 */         box.add((SPRITE)box.text().add(((SETT.ROOMS()).GUARD.employment()).verb).add(':').s().add('0'));
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public int autoAmount(HCLASS cl, Race race) {
/*  533 */       return (STATS.POP()).POP.data(cl).get(race) - auto(cl, race).get();
/*      */     }
/*      */   }
/*      */   
/*      */   private static class Emancipate
/*      */     extends StatMultiplierAction {
/*  539 */     private final HistoryInt data = new HistoryInt(32, (TIMECYCLE)TIME.days(), true);
/*  540 */     private final DOUBLE.DoubleImp timer = new DOUBLE.DoubleImp();
/*  541 */     private final double rate = 16.0D / (TIME.secondsPerDay() * 8);
/*      */     
/*      */     private Emancipate(StatsInit init, LISTE<StatsMultipliers.StatMultiplier> all) {
/*  544 */       super("SLAVES_FREED", init, all, 60000, 60000, (SPRITE)(SPRITES.icons()).m.chainsFree, new HCLASS[] { HCLASSES.SLAVE() });
/*  545 */       init.savers.put("SLAVES_FREED_DATA", this.data);
/*  546 */       init.savers.put("SLAVES_FREED_DATA_TIMER", this.timer);
/*      */     }
/*      */ 
/*      */     
/*      */     public double value(Induvidual h) {
/*  551 */       return (((STATS.POP()).TYPE.get(h) == (STATS.POP()).TYPE.FORMER_SLAVE) ? true : false);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean canUnmark() {
/*  556 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean markIs(Induvidual a) {
/*  561 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public int maxAmount(HCLASS cl, Race race) {
/*  566 */       return (STATS.POP()).POP.data(cl).get(race);
/*      */     }
/*      */ 
/*      */     
/*      */     public void mark(HCLASS cl, Race race, int amount) {}
/*      */ 
/*      */     
/*      */     private class Ite
/*      */       extends EntityIterator.Humans
/*      */     {
/*      */       private int amount;
/*      */       
/*      */       private final Race race;
/*      */       
/*      */       Ite(int amount, Race race) {
/*  581 */         this.amount = amount;
/*  582 */         this.race = race;
/*  583 */         iterate();
/*      */       }
/*      */ 
/*      */       
/*      */       protected boolean processAndShouldBreakH(Humanoid h, int ie) {
/*  588 */         if (h.race() == this.race && h.indu().clas() == HCLASSES.SLAVE()) {
/*  589 */           StatsMultipliers.Emancipate.this.mark(h, true);
/*  590 */           this.amount--;
/*  591 */           if (this.amount <= 0)
/*  592 */             return true; 
/*      */         } 
/*  594 */         return false;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public double value(HCLASS cl, Race race, int daysBack) {
/*  601 */       if ((STATS.MULTIPLIERS()).PROSECUTION.value(cl, race, daysBack) > 0.0D)
/*  602 */         return 0.0D; 
/*  603 */       return this.data.get(daysBack) / (1.0D + (STATS.POP()).POP.data(cl).get(null));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected void update(double ds) {
/*  609 */       this.timer.incD(-this.rate * ds);
/*  610 */       if (this.timer.getD() > 0.0D)
/*      */         return; 
/*  612 */       this.timer.incD(1.0D);
/*  613 */       int tot = this.data.get();
/*  614 */       int pop = (STATS.POP()).POP.data(HCLASSES.SLAVE()).get(null);
/*      */       
/*  616 */       tot -= pop;
/*  617 */       tot = CLAMP.i(tot, 0, pop * 16);
/*  618 */       this.data.set(tot);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void mark(Humanoid h, boolean set) {
/*  624 */       this.data.inc(16);
/*  625 */       if (h.indu().hType() == HTYPES.CHILD_SLAVE()) {
/*  626 */         h.HTypeSet(HTYPES.CHILD(), null, CAUSE_ARRIVES.EMANCIPATED());
/*      */       } else {
/*  628 */         h.HTypeSet(HTYPES.SUBJECT(), null, CAUSE_ARRIVES.EMANCIPATED());
/*      */       } 
/*      */       
/*  631 */       (STATS.POP()).TYPE.FORMER_SLAVE.set(h.indu());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void consume(Humanoid a) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean consumeIs(Induvidual a) {
/*  643 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public int unmarkable(HCLASS cl, Race race) {
/*  648 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void unmark(HCLASS cl, Race race) {}
/*      */ 
/*      */ 
/*      */     
/*      */     public int autoAmount(HCLASS cl, Race race) {
/*  659 */       return (STATS.POP()).POP.data(cl).get(race) - auto(cl, race).get();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean canBeMarked(Induvidual a) {
/*  664 */       if (!this.classes[a.clas().index()] && !this.classes[a.hType().parentClass().index()])
/*  665 */         return false; 
/*  666 */       if (markIs(a))
/*  667 */         return false; 
/*  668 */       return (maxAmount(a.clas(), a.race()) > 0);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean available(HTYPE t) {
/*  673 */       return available(t.parentClass());
/*      */     }
/*      */   }
/*      */   
/*      */   private static class StatMultiplierActionImp
/*      */     extends StatMultiplierAction
/*      */     implements StatsInit.StatUpdatableI
/*      */   {
/*      */     protected final SETT_STATISTICS.SettStatistics active;
/*  682 */     protected final RMapInt.RMapIntTwo<HCLASS, Race> selected = new RMapInt.RMapIntTwo(HCLASSES.MAP(), RACES.map());
/*      */     
/*      */     protected final INT_O.INT_OE<Induvidual> iActive;
/*      */     protected final INT_O.INT_OE<Induvidual> iActiveCount;
/*      */     protected final INT_O.INT_OE<Induvidual> iSelected;
/*      */     
/*      */     private StatMultiplierActionImp(String key, StatsInit init, LISTE<StatsMultipliers.StatMultiplier> all, SPRITE icon, HCLASS... cl) {
/*  689 */       super(key, init, all, 0, 100, icon, cl);
/*  690 */       this.active = new SETT_STATISTICS.SettStatistics("MUL_" + key, init, null);
/*  691 */       init.savers.put(key + "SEL", new SAVABLE()
/*      */           {
/*      */             public void save(FilePutter file)
/*      */             {
/*  695 */               StatsMultipliers.StatMultiplierActionImp.this.selected.save(file);
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*      */             public void load(FileGetter file) throws IOException {
/*  701 */               StatsMultipliers.StatMultiplierActionImp.this.selected.load(file);
/*  702 */               StatsMultipliers.StatMultiplierActionImp.this.selected.clear();
/*      */             }
/*      */ 
/*      */             
/*      */             public void clear() {
/*  707 */               StatsMultipliers.StatMultiplierActionImp.this.selected.clear();
/*      */             }
/*      */           });
/*  710 */       this.iActive = (INT_O.INT_OE<Induvidual>)new DataO.DataBit(init.count, "MUL_" + key + "_ACTIVE");
/*  711 */       this.iActiveCount = (INT_O.INT_OE<Induvidual>)new DataO.DataCrumb(init.count, "MUL_" + key + "_ACOUNT");
/*  712 */       this.iSelected = (INT_O.INT_OE<Induvidual>)new DataO.DataBit(init.count, "MUL_" + key + "_SEL");
/*      */       
/*  714 */       init.addable.add(new StatsInit.Addable()
/*      */           {
/*      */             public void removePrivate(Induvidual i)
/*      */             {
/*  718 */               StatsMultipliers.StatMultiplierActionImp.this.selected.get((MAPPED)i.clas()).inc(i.race(), -StatsMultipliers.StatMultiplierActionImp.this.iSelected.get(i));
/*  719 */               StatsMultipliers.StatMultiplierActionImp.this.active.inc(i, -StatsMultipliers.StatMultiplierActionImp.this.iActive.get(i));
/*      */             }
/*      */ 
/*      */             
/*      */             public void addPrivate(Induvidual i) {
/*  724 */               StatsMultipliers.StatMultiplierActionImp.this.selected.get((MAPPED)i.clas()).inc(i.race(), StatsMultipliers.StatMultiplierActionImp.this.iSelected.get(i));
/*  725 */               StatsMultipliers.StatMultiplierActionImp.this.active.inc(i, StatsMultipliers.StatMultiplierActionImp.this.iActive.get(i));
/*      */             }
/*      */           });
/*  728 */       init.updatable.add(this);
/*      */     }
/*      */     
/*      */     private void remove(Induvidual i) {
/*  732 */       if (i.added()) {
/*  733 */         this.selected.get((MAPPED)i.clas()).inc(i.race(), -this.iSelected.get(i));
/*  734 */         this.active.inc(i, -this.iActive.get(i));
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void add(Induvidual i) {
/*  742 */       if (i.added()) {
/*  743 */         this.selected.get((MAPPED)i.clas()).inc(i.race(), this.iSelected.get(i));
/*  744 */         this.active.inc(i, this.iActive.get(i));
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void update16(Humanoid h, int updateR, boolean day, int updateI) {
/*  750 */       if ((updateI & 0xF) == 0 && this.iActive.get(h.indu()) > 0) {
/*  751 */         Induvidual i = h.indu();
/*  752 */         if (this.iActiveCount.get(i) == 0) {
/*  753 */           remove(i);
/*  754 */           this.iActive.inc(i, -1);
/*  755 */           add(i);
/*      */         } else {
/*  757 */           this.iActiveCount.inc(h.indu(), -1);
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean markIs(Induvidual a) {
/*  764 */       return (this.iSelected.get(a) != 0);
/*      */     }
/*      */ 
/*      */     
/*      */     public void consume(Humanoid a) {
/*  769 */       remove(a.indu());
/*  770 */       this.iActive.setD(a.indu(), 1.0D);
/*  771 */       this.iActiveCount.set(a.indu(), 2 + RND.rInt(1));
/*  772 */       this.iSelected.set(a.indu(), 0);
/*  773 */       add(a.indu());
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean consumeIs(Induvidual a) {
/*  778 */       return (this.iActive.get(a) != 0);
/*      */     }
/*      */ 
/*      */     
/*      */     public void mark(Humanoid a, boolean set) {
/*  783 */       remove(a.indu());
/*  784 */       this.iActive.setD(a.indu(), 0.0D);
/*  785 */       this.iSelected.set(a.indu(), set ? 1 : 0);
/*  786 */       add(a.indu());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void mark(HCLASS cl, Race race, int amount) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public double value(Induvidual h) {
/*  808 */       return this.iActive.get(h);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public double value(HCLASS cl, Race race, int daysBack) {
/*  814 */       return this.active.data(cl).get(race, daysBack) / (1.0D + (STATS.POP()).POP.data(cl).get(race));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void update(double ds) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int maxAmount(HCLASS cl, Race race) {
/*  826 */       return (STATS.POP()).POP.data(cl).get(race) - this.selected.get((MAPPED)cl).get((MAPPED)race) - this.active.data(cl).get(race);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean canUnmark() {
/*  831 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public int unmarkable(HCLASS cl, Race race) {
/*  836 */       return this.selected.get((MAPPED)cl).get((MAPPED)race);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void unmark(HCLASS cl, Race race) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int autoAmount(HCLASS cl, Race race) {
/*  855 */       return (int)(maxAmount(cl, race) * auto(cl, race).getD());
/*      */     }
/*      */   }
/*      */   
/*      */   public static class StatMultiplierWork
/*      */     extends StatMultiplierActionImp
/*      */     implements StatsInit.StatUpdatableI
/*      */   {
/*      */     public final LIST<RoomBlueprintImp> ROOMS;
/*  864 */     private final boolean[] roomsB = new boolean[(SETT.ROOMS()).AMOUNT_OF_BLUEPRINTS];
/*  865 */     private int[][] available = Alloc.i2(HCLASSES.ALL().size(), RACES.all().size() + 1);
/*  866 */     private int ai = -121;
/*      */     private final EntityIterator.Humans iter;
/*      */     
/*  869 */     private StatMultiplierWork(String key, StatsInit init, LISTE<StatsMultipliers.StatMultiplier> all, SPRITE icon, HCLASS... cl) { super(key, init, all, icon, cl);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  896 */       this.iter = new EntityIterator.Humans() { public void exe() { for (BoostSpec s : StatsMultipliers.StatMultiplierWork.this.boosters.all()) { for (RoomEmploymentSimple b : (SETT.ROOMS()).employment.ALLS()) { if (b.blueprint().bonus() == s.boostable)
/*      */                   StatsMultipliers.StatMultiplierWork.this.roomsB[b.blueprint().index()] = true;  }
/*      */                }
/*      */              } }
/*  900 */         ; LinkedList<RoomBlueprintImp> rooms = new LinkedList(); this.ROOMS = (LIST<RoomBlueprintImp>)new ArrayList((Iterable)rooms); BOOSTING.connecter(new ACTION() { protected boolean processAndShouldBreakH(Humanoid h, int ie) { if (StatsMultipliers.StatMultiplierWork.this.canBeMarked(h.indu())) {
/*  901 */                 StatsMultipliers.StatMultiplierWork.this.available[h.indu().clas().index()][(h.race()).index] = StatsMultipliers.StatMultiplierWork.this.available[h.indu().clas().index()][(h.race()).index] + 1;
/*  902 */                 StatsMultipliers.StatMultiplierWork.this.available[h.indu().clas().index()][RACES.all().size()] = StatsMultipliers.StatMultiplierWork.this.available[h.indu().clas().index()][RACES.all().size()] + 1;
/*      */               } 
/*  904 */               return false; }
/*      */              }
/*      */         ); }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int maxAmount(HCLASS cl, Race race) {
/*  912 */       if (Math.abs(this.ai - GAME.updateI()) > 120) {
/*  913 */         this.ai = GAME.updateI(); byte b; int i, arrayOfInt[][];
/*  914 */         for (i = (arrayOfInt = this.available).length, b = 0; b < i; ) { int[] arrayOfInt1 = arrayOfInt[b];
/*  915 */           Arrays.fill(arrayOfInt1, 0); b++; }
/*  916 */          this.iter.iterate();
/*      */       } 
/*      */       
/*  919 */       int ri = (race == null) ? RACES.all().size() : race.index();
/*  920 */       return this.available[cl.index()][ri];
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void mark(HCLASS cl, Race race, int amount) {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean canMark(RoomBlueprint b) {
/*  942 */       return this.roomsB[b.index()];
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean canBeMarked(Induvidual a) {
/*  947 */       if (a.player() && !markIs(a) && !consumeIs(a)) {
/*  948 */         RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(a);
/*  949 */         if (ins != null && this.roomsB[ins.blueprint().index()]) {
/*  950 */           return true;
/*      */         }
/*      */       } 
/*  953 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   private static class Handout
/*      */     extends StatMultiplierActionImp
/*      */   {
/*  960 */     private final int amount = 400;
/*      */     
/*      */     Handout(String key, StatsInit init, LISTE<StatsMultipliers.StatMultiplier> all, SPRITE icon, HCLASS... cl) {
/*  963 */       super(key, init, all, icon, cl);
/*      */     }
/*      */ 
/*      */     
/*      */     public int maxAmount(HCLASS cl, Race race) {
/*  968 */       int creds = (int)FACTIONS.player().credits().credits();
/*  969 */       creds /= 400;
/*  970 */       int am = super.maxAmount(cl, race);
/*  971 */       return Math.min(creds, am);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void mark(Humanoid a, boolean set) {
/*  977 */       super.mark(a, set);
/*  978 */       FACTIONS.player().credits().inc(-400.0D, FCredits.CTYPE.MISC);
/*  979 */       if (set) {
/*  980 */         consume(a);
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public void info(GBox box, int amount) {
/*  986 */       box.textL(Dic.¤¤Curr);
/*  987 */       box.tab(5);
/*  988 */       box.add((SPRITE)GFORMAT.iIncr(box.text(), (-amount * 400)));
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean canUnmark() {
/*  993 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean canBeMarked(Induvidual a) {
/*  998 */       if (FACTIONS.player().credits().credits() < 400.0D)
/*  999 */         return false; 
/* 1000 */       return super.canBeMarked(a);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class Data
/*      */     implements SAVABLE
/*      */   {
/* 1015 */     private final HistoryRace[] iii = new HistoryRace[HCLASSES.ALL().size()];
/*      */     
/*      */     Data() {
/* 1018 */       for (int ci = 0; ci < HCLASSES.ALL().size(); ci++) {
/* 1019 */         this.iii[ci] = new HistoryRace(32, (TIMECYCLE)TIME.days(), true);
/*      */       }
/*      */     }
/*      */     
/*      */     public HistoryRace get(HCLASS cl) {
/* 1024 */       return this.iii[cl.index()];
/*      */     }
/*      */ 
/*      */     
/*      */     public void save(FilePutter file) {
/* 1029 */       HCLASSES.MAP().saver().save((SAVABLE[])this.iii, file);
/*      */     }
/*      */ 
/*      */     
/*      */     public void load(FileGetter file) throws IOException {
/* 1034 */       HCLASSES.MAP().loader().load((SAVABLE[])this.iii, file);
/*      */     } public void clear() {
/*      */       byte b;
/*      */       int i;
/*      */       HistoryRace[] arrayOfHistoryRace;
/* 1039 */       for (i = (arrayOfHistoryRace = this.iii).length, b = 0; b < i; ) { HistoryRace historyRace = arrayOfHistoryRace[b];
/* 1040 */         historyRace.clear();
/*      */         b++; }
/*      */     
/*      */     }
/*      */   }
/*      */   
/*      */   private static abstract class Iter extends EntityIterator.Humans {
/*      */     int amount;
/*      */     final Race race;
/*      */     final HCLASS cl;
/*      */     
/*      */     Iter(HCLASS cl, Race race, int amount) {
/* 1052 */       this.amount = amount;
/* 1053 */       this.race = race;
/* 1054 */       this.cl = cl;
/* 1055 */       iterate();
/*      */     }
/*      */   }
/*      */   
/*      */   private static class C
/*      */     extends INFO
/*      */   {
/*      */     private final CharSequence verb;
/*      */     private final String key;
/*      */     
/*      */     C(String key, StatsInit init) {
/* 1066 */       super(init.dText.json("EVENT_" + key));
/* 1067 */       key = "EVENT_" + key;
/* 1068 */       this.verb = init.dText.json(key).text("VERB");
/* 1069 */       this.key = key;
/*      */     }
/*      */     
/*      */     C(String key, CharSequence name, CharSequence desc, CharSequence verb) {
/* 1073 */       super(name, desc);
/* 1074 */       this.verb = verb;
/* 1075 */       this.key = key;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\muls\StatsMultipliers.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */