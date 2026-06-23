/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import init.type.WGROUP;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.home.HOME;
/*     */ import settlement.room.infra.elderly.ROOM_RESTHOME;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.employment.RoomEmploymentSimple;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.SETT_STATISTICS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.STATFake;
/*     */ import settlement.stats.stat.STATFakeData;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import settlement.stats.stat.StatDecree;
/*     */ import settlement.stats.stat.StatInfo;
/*     */ import settlement.stats.stat.StatObject;
/*     */ import settlement.stats.util.StatHoverer;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.GETTER_TRANS;
/*     */ import util.data.INT_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMapInt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StatsWork
/*     */   extends StatCollection
/*     */ {
/*  71 */   private static CharSequence ¤¤lim = "Decree";
/*  72 */   private static CharSequence ¤¤estimated = "Estimated Retirees";
/*  73 */   private static CharSequence ¤¤employment = "Employment";
/*  74 */   private static CharSequence ¤¤employmentD = "This subject's place of work.";
/*  75 */   private static CharSequence ¤¤retTarget = "Retirement age target";
/*  76 */   private static CharSequence ¤¤accessD = "Access to retirement activities.";
/*  77 */   private static CharSequence ¤¤qualityD = "Quality and Degrade of retirement activities.";
/*  78 */   private static CharSequence ¤¤Type = "Type";
/*  79 */   private static CharSequence ¤¤TypeD = "Subjects will try and find the activity that suits them best. (Highest work fulfillment)\")";
/*     */   
/*  81 */   private static CharSequence ¤¤name = "Work";
/*  82 */   private static CharSequence ¤¤desc = "Work related stats."; public final Retirement RET; public final StatObject<RoomInstance> EMPLOYED; public final STAT WORK_FULFILLMENT; public final STAT WORK_TIME; private final SETT_STATISTICS.SettStatistics health; public final GETTER_TRANS.GETTER_TRANSE<Induvidual, RoomBlueprintImp> profession; public final Incapacitated incap; public final INT_O.INT_OE<Induvidual> proximity; public final INT_O.INT_OE<Induvidual> fetchProximity; public final INT_O.INT_OE<Induvidual> slack; public final LIST<STAT> workStats;
/*     */   
/*     */   static {
/*  85 */     D.ts(StatsWork.class);
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
/* 102 */   private long[] fvalues = new long[HCLASS_RACE.MAP().all().size()];
/* 103 */   private long[] fRetvalues = new long[HCLASS_RACE.MAP().all().size()]; private final StatsInit.StatUpdatableI updater; private static final int sMask = 16383;
/*     */   private static final int onMask = 16384;
/*     */   
/* 106 */   public StatsWork(StatsInit init) { super(init, "WORK", ¤¤name, ¤¤desc);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 260 */     this.updater = new StatsInit.StatUpdatableI()
/*     */       {
/*     */         protected double getDD(HCLASS cl, Race race) { double v = CLAMP.d(d(cl, race), 0.0D, 1.0D); return v; }
/*     */         private double d(HCLASS cl, Race race) { double v = StatsWork.this.fvalues[(HCLASS_RACE.clP(race, cl)).index] / 256.0D; double pop = 0.0D; if (cl == HCLASSES.SLAVE()) { pop = STATS.POP().pop(race, HTYPES.SLAVE()); } else { pop = (STATS.POP().pop(race, HTYPES.STUDENT()) + STATS.POP().pop(race, HTYPES.RECRUIT()) + STATS.POP().pop(race, HTYPES.SUBJECT()) + STATS.POP().pop(race, HTYPES.GUARD())); }  if (pop > 0.0D)
/*     */             return v / pop;  return 0.0D; } protected double indu(Induvidual t) { RoomInstance ins = (RoomInstance)StatsWork.this.EMPLOYED.get(t); if (ins != null)
/* 265 */             return t.race().pref().getWork(ins.blueprintI().employment());  return 0.0D; } public void update16(Humanoid h, int updateR, boolean day, int ui) { Induvidual i = h.indu();
/*     */ 
/*     */           
/* 268 */           if (day) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 274 */             StatsWork.this.WORK_TIME.indu().inc(i, -(Humanoid.WORK_TICKS + ((RND.rFloat() < 0.6D) ? 1 : 0)));
/*     */             
/* 276 */             if ((STATS.MULTIPLIERS()).OVERTIME.markIs(h)) {
/* 277 */               (STATS.MULTIPLIERS()).OVERTIME.consume(h);
/* 278 */             } else if ((STATS.MULTIPLIERS()).DAY_OFF.markIs(h)) {
/* 279 */               (STATS.MULTIPLIERS()).DAY_OFF.consume(h);
/* 280 */               StatsWork.this.WORK_TIME.indu().setD(i, 1.0D);
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 285 */           if (HPoll.Handler.works(h)) {
/* 286 */             StatsWork.this.WORK_TIME.indu().inc(i, 1);
/*     */           }
/*     */           
/* 289 */           if (h.indu().hType() == HTYPES.RETIREE() && StatsWork.this.EMPLOYED.get(h) != null && ((RoomInstance)StatsWork.this.EMPLOYED.get(h)).blueprint() instanceof ROOM_RESTHOME) {
/* 290 */             double d = ((ROOM_RESTHOME)((RoomInstance)StatsWork.this.EMPLOYED.get(h)).blueprint()).quality((RoomInstance)StatsWork.this.EMPLOYED.get(h));
/* 291 */             StatsWork.this.RET.RETIREMENT_HOME_QUALITY.indu().setD(h.indu(), d);
/*     */           }  }
/*     */       }; this.profession = new Profession(init); this.EMPLOYED = new Work(init); init.count.getClass(); this.WORK_TIME = (STAT)new STATData("WORK_TIME", "WORK_TIME", init, (INT_O.INT_OE)new DataO.DataNibble1(init.count, "WORK_TIME", Humanoid.WORK_TICKS + Humanoid.WORK_TICKS / 2)); init.count.getClass(); this.proximity = (INT_O.INT_OE<Induvidual>)new DataO.DataShort(init.count, "WORK_PROXIMITY"); init.count.getClass(); this.fetchProximity = (INT_O.INT_OE<Induvidual>)new DataO.DataShort(init.count, "WORK_FETCH_PROXIMITY"); init.count.getClass(); this.slack = (INT_O.INT_OE<Induvidual>)new DataO.DataShort(init.count, "WORK_SLACK"); this.WORK_FULFILLMENT = (STAT)new STATFakeData("FULFILLMENT", init) {
/*     */         public void hover(GUI_BOX text, HCLASS cl, Race type) { GBox b = (GBox)text; b.textLL(Dic.¤¤BaseValue); b.tab(16); b.add((SPRITE)GFORMAT.perc(b.text(), d(cl, type))); b.NL(); super.hover(text, cl, type); }
/*     */       }; (this.WORK_FULFILLMENT.info()).icon = (SPRITE)(UI.icons()).m.heart; this.RET = new Retirement(init, this.fRetvalues); init.savers.put("WORK_FULFILL", new SAVABLE() {
/*     */           public void save(FilePutter file) {}
/*     */           public void load(FileGetter file) throws IOException {} public void clear() { Arrays.fill(StatsWork.this.fvalues, 0L); Arrays.fill(StatsWork.this.fRetvalues, 0L); }
/*     */         }); this.health = new SETT_STATISTICS.SettStatistics("WORK_HEALTH", init, "", ""); double m = 1.0D; for (RoomEmploymentSimple s : (SETT.ROOMS()).employment.ALLS())
/*     */       m = Math.min(m, 1.0D - s.healthFactor);  BValue vv = new BValue() {
/*     */         public double vGet(Player f) { return vGet(HCLASS_RACE.clP()); } public double vGet(Region reg) { return 0.0D; } public double vGet(Induvidual indu) { RoomInstance r = (RoomInstance)StatsWork.this.EMPLOYED.get(indu); if (r != null)
/*     */             return 1.0D - (r.blueprintI().employment()).healthFactor;  return 0.0D; } public double vGet(Div div) { return 0.0D; } public double vGet(HCLASS_RACE time) { int emp = StatsWork.this.EMPLOYED.stat().data(time.cl).get(time.race); int tot = (STATS.POP()).POP.data(time.cl).get(time.race); if (tot == 0)
/*     */             return 0.0D;  double d = (emp / tot); return d * (1.0D - StatsWork.this.health.data(time.cl).get(time.race) / emp * 256.0D); } public double vGet(FactionNPC f) { return 0.0D; }
/*     */       }; (new BoosterValue(vv, new BSourceInfo(Dic.¤¤Employment, (SPRITE)(UI.icons()).s.hammer), 1.0D, m, true)).add((BOOSTABLES.PHYSICS()).HEALTH); this.incap = new Incapacitated(init); this.workStats = (LIST<STAT>)new ArrayList((Object[])new STAT[] { this.EMPLOYED.stat(), this.WORK_FULFILLMENT, this.WORK_TIME, this.incap.stat }); init.updatable.add(this.updater); } private static class StatRet extends STATData {
/*     */     StatRet(StatsInit init, DataO<Induvidual>.DataAbs data, CharSequence name, CharSequence desc) { super(null, init, data, new StatInfo(name, desc)); info().setMatters(false, true); } public int pdivider(HCLASS c, Race r, int daysback) { return STATS.POP().pop(r, HTYPES.RETIREE(), daysback); }
/*     */   } private final class Work extends StatObject<RoomInstance> implements StatsInit.StatDisposable {
/* 306 */     Work(StatsInit init) { super(StatsWork.¤¤employment, StatsWork.¤¤employmentD);
/* 307 */       init.count.getClass(); this.data = (INT_O.INT_OE<Induvidual>)new DataO.DataInt(init.count, "WORK_WORKI");
/*     */ 
/*     */       
/* 310 */       INT_O.INT_OE<Induvidual> b = new INT_O.INT_OE<Induvidual>()
/*     */         {
/*     */           public int get(Induvidual t)
/*     */           {
/* 314 */             return (t.hType() == HTYPES.GUARD() || (t.hType().isWorks() && StatsWork.Work.this.data.get(t) != 0)) ? 1 : 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int min(Induvidual t) {
/* 319 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max(Induvidual t) {
/* 324 */             return 1;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void set(Induvidual t, int i) {}
/*     */         };
/* 334 */       this.stat = new STATData("EMPLOYED", "WORK_WORKI", init, b)
/*     */         {
/*     */           public int pdivider(HCLASS c, Race r, int daysback)
/*     */           {
/* 338 */             if (c == HCLASSES.SLAVE())
/* 339 */               return STATS.POP().pop(r, HTYPES.SLAVE(), daysback); 
/* 340 */             return STATS.POP().pop(r, HTYPES.STUDENT(), daysback) + STATS.POP().pop(r, HTYPES.RECRUIT(), daysback) + STATS.POP().pop(r, HTYPES.GUARD(), daysback) + STATS.POP().pop(r, HTYPES.SUBJECT(), daysback);
/*     */           }
/*     */ 
/*     */           
/*     */           public void addPrivate(Induvidual i) {
/* 345 */             RoomInstance ins = StatsWork.Work.this.get(i);
/*     */ 
/*     */             
/* 348 */             if (ins != null) {
/* 349 */               if (i.hType() == HTYPES.RETIREE()) {
/* 350 */                 (StatsWork.Work.access$2(StatsWork.Work.this)).fRetvalues[i.popCL().index()] = (StatsWork.Work.access$2(StatsWork.Work.this)).fRetvalues[i.popCL().index()] + (int)(i.race().pref().getWork(ins.blueprintI().employment()) * 256.0D);
/*     */               } else {
/* 352 */                 (StatsWork.Work.access$2(StatsWork.Work.this)).fvalues[i.popCL().index()] = (StatsWork.Work.access$2(StatsWork.Work.this)).fvalues[i.popCL().index()] + (int)(i.race().pref().getWork(ins.blueprintI().employment()) * 256.0D);
/* 353 */               }  (StatsWork.Work.access$2(StatsWork.Work.this)).health.inc(i.hType(), i.race(), (int)((ins.blueprintI().employment()).healthFactor * 256.0D), -1);
/*     */             } else {
/* 355 */               StatsWork.Work.this.data.set(i, 0);
/*     */             } 
/* 357 */             super.addPrivate(i);
/*     */           }
/*     */ 
/*     */           
/*     */           public void removePrivate(Induvidual i) {
/* 362 */             RoomInstance ins = StatsWork.Work.this.get(i);
/* 363 */             if (ins != null) {
/* 364 */               if (i.hType() == HTYPES.RETIREE()) {
/* 365 */                 (StatsWork.Work.access$2(StatsWork.Work.this)).fRetvalues[i.popCL().index()] = (StatsWork.Work.access$2(StatsWork.Work.this)).fRetvalues[i.popCL().index()] - (int)(i.race().pref().getWork(ins.blueprintI().employment()) * 256.0D);
/*     */               } else {
/* 367 */                 (StatsWork.Work.access$2(StatsWork.Work.this)).fvalues[i.popCL().index()] = (StatsWork.Work.access$2(StatsWork.Work.this)).fvalues[i.popCL().index()] - (int)(i.race().pref().getWork(ins.blueprintI().employment()) * 256.0D);
/* 368 */               }  (StatsWork.Work.access$2(StatsWork.Work.this)).health.inc(i.hType(), i.race(), -((int)((StatsWork.Work.this.get(i).blueprintI().employment()).healthFactor * 256.0D)), -1);
/*     */             } 
/*     */ 
/*     */             
/* 372 */             super.removePrivate(i);
/*     */           }
/*     */         };
/*     */       
/* 376 */       (this.stat.info()).icon = (SPRITE)(UI.icons()).m.workshop;
/*     */       
/* 378 */       init.disposable.add(this); }
/*     */     
/*     */     private final INT_O.INT_OE<Induvidual> data;
/*     */     private final STATData stat;
/*     */     
/*     */     public RoomInstance get(Induvidual f) {
/* 384 */       int i = this.data.get(f);
/* 385 */       if (i > 0)
/* 386 */         return (RoomInstance)(SETT.ROOMS()).map.getByIndex(i - 1); 
/* 387 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public void dispose(Humanoid h) {
/* 392 */       set(h, (RoomInstance)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void set(Humanoid h, RoomInstance t) {
/* 398 */       if (t != null && (
/* 399 */         !t.employees().active() || !t.active())) {
/* 400 */         GAME.Notify("shit!");
/*     */       }
/*     */ 
/*     */       
/* 404 */       HOME home = (STATS.HOME()).GETTER.get(h, this);
/* 405 */       (STATS.HOME()).GETTER.set(h, null);
/*     */       
/* 407 */       Induvidual f = h.indu();
/*     */       
/* 409 */       if (!f.added())
/* 410 */         throw new RuntimeException(); 
/* 411 */       this.stat.removeH(f);
/* 412 */       if (get(f) != null) {
/* 413 */         get(f).employees().fire(h);
/*     */       }
/* 415 */       if (t != null) {
/* 416 */         StatsWork.this.profession.set(f, t.blueprintI());
/* 417 */         this.data.set(f, t.index() + 1);
/* 418 */         t.employees().employ(h);
/*     */       } else {
/*     */         
/* 421 */         this.data.set(f, 0);
/*     */       } 
/*     */       
/* 424 */       this.stat.addH(f);
/*     */       
/* 426 */       setData(f, t);
/* 427 */       if (home != null) {
/*     */         
/* 429 */         if (home.canOccupy(h) && (
/* 430 */           get(f) != null || home.occupants() < home.occupantsMax())) {
/* 431 */           (STATS.HOME()).GETTER.set(h, home);
/*     */         }
/*     */       } else {
/* 434 */         (STATS.HOME()).GETTER.hasSearched.indu().set(f, 0);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private void setData(Induvidual f, RoomInstance t) {
/* 440 */       StatsWork.this.RET.RETIREMENT_HOME_ACCESS.indu().setD(f, 0.0D);
/* 441 */       StatsWork.this.RET.RETIREMENT_HOME_QUALITY.indu().setD(f, 0.0D);
/* 442 */       StatsWork.this.RET.RETIREMENT_HOME_TYPE.indu().setD(f, 0.0D);
/* 443 */       if (t == null) {
/*     */         return;
/*     */       }
/* 446 */       if (f.hType() == HTYPES.RETIREE() && t.blueprint() instanceof ROOM_RESTHOME) {
/* 447 */         StatsWork.this.RET.RETIREMENT_HOME_ACCESS.indu().setD(f, 1.0D);
/* 448 */         StatsWork.this.RET.RETIREMENT_HOME_QUALITY.indu().setD(f, ((ROOM_RESTHOME)t.blueprint()).quality(t));
/* 449 */         StatsWork.this.RET.RETIREMENT_HOME_TYPE.indu().setD(f, f.race().pref().getWork(t.blueprintI().employment()));
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public STAT stat() {
/* 456 */       return (STAT)this.stat;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Profession
/*     */     implements GETTER_TRANS.GETTER_TRANSE<Induvidual, RoomBlueprintImp>
/*     */   {
/*     */     private final INT_O.INT_OE<Induvidual> ii;
/*     */ 
/*     */     
/*     */     Profession(StatsInit init) {
/* 468 */       init.count.getClass(); this.ii = (INT_O.INT_OE<Induvidual>)new DataO.DataShort(init.count, "WORK_PROF");
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(Induvidual f, RoomBlueprintImp t) {
/* 473 */       int i = (t == null) ? 0 : (t.index() + 1);
/* 474 */       this.ii.set(f, i);
/*     */     }
/*     */ 
/*     */     
/*     */     public RoomBlueprintImp get(Induvidual i) {
/* 479 */       int in = this.ii.get(i);
/* 480 */       if (in == 0)
/* 481 */         return null; 
/* 482 */       if (SETT.ROOMS().all().get(in - 1) instanceof RoomBlueprintImp)
/* 483 */         return (RoomBlueprintImp)SETT.ROOMS().all().get(in - 1); 
/* 484 */       return null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getWorkPriority(Humanoid h) {
/* 492 */     return (this.WORK_TIME.indu().isMax(h.indu()) ? false : true);
/*     */   }
/*     */   
/*     */   public boolean shouldReportForWork(Humanoid h) {
/* 496 */     return (this.WORK_TIME.indu().getD(h.indu()) < 0.4D);
/*     */   }
/*     */   
/*     */   public int workforce() {
/* 500 */     int am = STATS.POP().pop(HTYPES.SUBJECT()) - this.incap.get(HTYPES.SUBJECT());
/* 501 */     am += STATS.POP().pop(HTYPES.SLAVE()) - this.incap.get(HTYPES.SLAVE());
/* 502 */     return am;
/*     */   }
/*     */   
/*     */   public int workforce(Race race, int daysBack) {
/* 506 */     return STATS.POP().pop(race, HTYPES.SUBJECT(), daysBack) + STATS.POP().pop(race, HTYPES.SLAVE(), daysBack);
/*     */   }
/*     */   
/*     */   public int workforce(Race race) {
/* 510 */     int am = STATS.POP().pop(race, HTYPES.SUBJECT()) - this.incap.get(HTYPES.SUBJECT(), race);
/* 511 */     am += STATS.POP().pop(race, HTYPES.SLAVE()) - this.incap.get(HTYPES.SLAVE(), race);
/* 512 */     return am;
/*     */   }
/*     */   
/*     */   public int workforce(WGROUP g) {
/* 516 */     if (g == null)
/* 517 */       return workforce(); 
/* 518 */     return STATS.POP().pop(g.race, g.type) - this.incap.get(g.type, g.race);
/*     */   }
/*     */   
/*     */   public void fetchProximityStart(Humanoid a) {
/* 522 */     pStart(a, this.fetchProximity);
/*     */   }
/*     */   
/*     */   public void fetchProximityEnd(Humanoid a) {
/* 526 */     int v = pEnd(a, this.fetchProximity);
/* 527 */     if (v != 0) {
/* 528 */       RoomInstance work = (RoomInstance)this.EMPLOYED.get(a);
/* 529 */       work.employees().reportFetchSeconds(v);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void proximityStart(Humanoid a) {
/* 534 */     pStart(a, this.proximity);
/*     */   }
/*     */ 
/*     */   
/*     */   public void proximityEnd(Humanoid a) {
/* 539 */     int v = pEnd(a, this.proximity);
/* 540 */     if (v != 0) {
/* 541 */       RoomInstance work = (RoomInstance)this.EMPLOYED.get(a);
/* 542 */       work.employees().reportWalkSeconds(v);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void slackStart(Humanoid a) {
/* 547 */     pStart(a, this.slack);
/*     */   }
/*     */   
/*     */   public void slackEnd(Humanoid a, boolean slacking) {
/* 551 */     int v = pEnd(a, this.slack);
/* 552 */     if (v != 0) {
/* 553 */       RoomInstance work = (RoomInstance)this.EMPLOYED.get(a);
/* 554 */       work.employees().reportWorkSuccess(v, !slacking);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void pStart(Humanoid a, INT_O.INT_OE<Induvidual> proximity) {
/* 562 */     int v = (int)(TIME.currentSecond() + 0.5D) & 0x3FFF;
/* 563 */     v |= 0x4000;
/* 564 */     proximity.set(a.indu(), v);
/*     */   }
/*     */   
/*     */   private int pEnd(Humanoid a, INT_O.INT_OE<Induvidual> proximity) {
/* 568 */     int v = proximity.get(a.indu());
/* 569 */     proximity.set(a.indu(), 0);
/*     */     
/* 571 */     if ((v & 0x4000) != 0) {
/* 572 */       RoomInstance work = (RoomInstance)this.EMPLOYED.get(a);
/* 573 */       if (work != null) {
/* 574 */         int now = (int)(TIME.currentSecond() + 0.5D) & 0x3FFF;
/* 575 */         v &= 0x3FFF;
/* 576 */         if (v <= now) {
/* 577 */           v = now - v;
/* 578 */           return v;
/*     */         } 
/* 580 */         if (v > now) {
/* 581 */           v = 16383 - v + 1;
/* 582 */           v += now;
/* 583 */           return v;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 588 */     return 0;
/*     */   }
/*     */   
/*     */   public static final class Incapacitated
/*     */   {
/*     */     private final DataO<Induvidual>.DataAbs data;
/* 594 */     private final int[] htypes = Alloc.ii(HTYPES.ALL().size());
/* 595 */     private final int[] etypes = Alloc.ii(HTYPES.ALL().size() * RACES.all().size());
/*     */     
/*     */     public final STAT stat;
/*     */     
/*     */     private Incapacitated(StatsInit init) {
/* 600 */       init.count.getClass(); this.data = (DataO<Induvidual>.DataAbs)new DataO<Induvidual>.DataBit(init.count, "WORK_INCA")
/*     */         {
/*     */           public void set(Induvidual t, int s) {
/* 603 */             if (t.added()) {
/* 604 */               StatsWork.Incapacitated.this.htypes[t.hType().index()] = StatsWork.Incapacitated.this.htypes[t.hType().index()] - get(t);
/* 605 */               StatsWork.Incapacitated.this.etypes[t.hType().index() * RACES.all().size() + (t.race()).index] = StatsWork.Incapacitated.this.etypes[t.hType().index() * RACES.all().size() + (t.race()).index] - get(t);
/*     */             } 
/* 607 */             super.set(t, s);
/* 608 */             if (t.added()) {
/* 609 */               StatsWork.Incapacitated.this.htypes[t.hType().index()] = StatsWork.Incapacitated.this.htypes[t.hType().index()] + get(t);
/* 610 */               StatsWork.Incapacitated.this.etypes[t.hType().index() * RACES.all().size() + (t.race()).index] = StatsWork.Incapacitated.this.etypes[t.hType().index() * RACES.all().size() + (t.race()).index] + get(t);
/*     */             } 
/*     */           }
/*     */         };
/*     */       
/* 615 */       init.addable.add(new StatsInit.Addable()
/*     */           {
/*     */             public void removePrivate(Induvidual t)
/*     */             {
/* 619 */               StatsWork.Incapacitated.this.htypes[t.hType().index()] = StatsWork.Incapacitated.this.htypes[t.hType().index()] - StatsWork.Incapacitated.this.data.get(t);
/* 620 */               StatsWork.Incapacitated.this.etypes[t.hType().index() * RACES.all().size() + (t.race()).index] = StatsWork.Incapacitated.this.etypes[t.hType().index() * RACES.all().size() + (t.race()).index] - StatsWork.Incapacitated.this.data.get(t);
/*     */             }
/*     */ 
/*     */             
/*     */             public void addPrivate(Induvidual t) {
/* 625 */               StatsWork.Incapacitated.this.htypes[t.hType().index()] = StatsWork.Incapacitated.this.htypes[t.hType().index()] + StatsWork.Incapacitated.this.data.get(t);
/* 626 */               StatsWork.Incapacitated.this.etypes[t.hType().index() * RACES.all().size() + (t.race()).index] = StatsWork.Incapacitated.this.etypes[t.hType().index() * RACES.all().size() + (t.race()).index] + StatsWork.Incapacitated.this.data.get(t);
/*     */             }
/*     */           });
/*     */       
/* 630 */       init.savers.put("work_incap", new SAVABLE()
/*     */           {
/*     */             public void save(FilePutter file) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void load(FileGetter file) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void clear() {
/* 646 */               Arrays.fill(StatsWork.Incapacitated.this.htypes, 0);
/*     */             }
/*     */           });
/*     */       
/* 650 */       this.stat = (STAT)new STATData("INCAPACITATED", init, this.data);
/*     */     }
/*     */ 
/*     */     
/*     */     public int get(HTYPE t) {
/* 655 */       return this.htypes[t.index()];
/*     */     }
/*     */     
/*     */     public int get() {
/* 659 */       return get(HTYPES.SUBJECT()) + get(HTYPES.SLAVE());
/*     */     }
/*     */     
/*     */     public int get(HTYPE t, Race race) {
/* 663 */       if (race == null)
/* 664 */         return get(t); 
/* 665 */       return this.etypes[t.index() * RACES.all().size() + race.index];
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Retirement
/*     */   {
/*     */     public final STAT RETIREMENT_AGE;
/*     */     
/*     */     public final STAT RETIREMENT_HOME;
/*     */     private final STAT RETIREMENT_HOME_ACCESS;
/*     */     private final STAT RETIREMENT_HOME_QUALITY;
/*     */     private final STATFakeData RETIREMENT_HOME_TYPE;
/*     */     
/*     */     Retirement(StatsInit init, final long[] fValues) {
/* 680 */       int DD = 16384;
/* 681 */       double DEFAULT = 0.25D;
/*     */       
/* 683 */       final RMapInt.RMapIntTwo<HCLASS, Race> count = new RMapInt.RMapIntTwo(HCLASSES.MAP(), RACES.map(), -16384, 16384);
/* 684 */       final StatDecree dec = new StatDecree("RETIREMENT_AGE_DEC", init, 0, 100, 1, StatsWork.¤¤retTarget, 25);
/*     */       
/* 686 */       init.savers.put("WORK_RETIREMENT_AGE_COUNT", count);
/* 687 */       this.RETIREMENT_AGE = (STAT)new STATFake("RETIREMENT_AGE", init)
/*     */         {
/*     */           protected double getDD(HCLASS s, Race r, int daysBack)
/*     */           {
/* 691 */             if (s == null) {
/* 692 */               s = HCLASSES.CITIZEN();
/*     */             }
/* 694 */             if (r == null) {
/* 695 */               double tot = 0.0D;
/* 696 */               double tt = 0.0D;
/* 697 */               double pop = 0.0D;
/* 698 */               for (Race ra : RACES.all()) {
/* 699 */                 double p = (STATS.POP()).POP.data(s).get(ra);
/* 700 */                 tt += count.get((MAPPED)s).getD(ra);
/* 701 */                 tot += count.get((MAPPED)s).getD(ra) * p;
/* 702 */                 pop += p;
/*     */               } 
/* 704 */               if (pop == 0.0D)
/* 705 */                 return tt / RACES.all().size(); 
/* 706 */               return 0.25D + tot / pop;
/*     */             } 
/* 708 */             return 0.25D + count.get((MAPPED)s).getD(r);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hover(GUI_BOX text, HCLASS cl, Race type) {
/* 713 */             StatHoverer.hover(text, (STAT)this);
/* 714 */             GBox b = (GBox)text;
/* 715 */             b.sep();
/*     */             
/* 717 */             b.textLL(StatsWork.¤¤lim);
/* 718 */             b.add((SPRITE)GFORMAT.perc(b.text(), decree().getD(cl, type)));
/* 719 */             b.NL();
/*     */             
/* 721 */             b.textLL(StatsWork.¤¤estimated);
/*     */             
/* 723 */             b.add((SPRITE)GFORMAT.i(b.text(), StatsWork.Retirement.this.estimate(cl, type, decree().getD(cl, type))));
/* 724 */             b.NL();
/*     */ 
/*     */             
/* 727 */             b.sep();
/* 728 */             StatHoverer.hover(text, (STAT)this, cl, type);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hover(GUI_BOX text, Induvidual indu) {
/* 733 */             hover(text, indu.clas(), indu.race());
/*     */           }
/*     */         };
/*     */       
/* 737 */       (this.RETIREMENT_AGE.info()).icon = (SPRITE)(UI.icons()).m.time;
/* 738 */       init.upers.add(new StatsInit.StatUpdatable()
/*     */           {
/* 740 */             int ri = 0;
/*     */             
/*     */             public void update(double ds) {
/* 743 */               ds *= (RACES.all().size() * 16384);
/* 744 */               ds /= TIME.secondsPerDay() * 4.0D;
/* 745 */               if (this.ri >= RACES.all().size()) {
/* 746 */                 this.ri = 0;
/*     */               }
/* 748 */               int ids = (int)ds;
/* 749 */               if (RND.rFloat() < ds - ids) {
/* 750 */                 ids++;
/*     */               }
/*     */               
/* 753 */               Race r = (Race)RACES.all().get(this.ri);
/* 754 */               this.ri++;
/*     */               
/* 756 */               for (HCLASS cl : HCLASSES.ALLP()) {
/* 757 */                 double dd = dec.getD(cl, r);
/* 758 */                 int current = count.get((MAPPED)cl).get((MAPPED)r);
/*     */                 
/* 760 */                 if (dd < 0.25D) {
/* 761 */                   dd = -(0.25D - dd);
/*     */                 } else {
/* 763 */                   dd -= 0.25D;
/*     */                 } 
/* 765 */                 int target = (int)(16384.0D * dd);
/* 766 */                 if (current < target) {
/* 767 */                   current += ids;
/* 768 */                   if (current > target)
/* 769 */                     current = target; 
/* 770 */                 } else if (current > target) {
/* 771 */                   current -= ids;
/* 772 */                   if (current < target)
/* 773 */                     current = target; 
/*     */                 } 
/* 775 */                 count.get((MAPPED)cl).set((MAPPED)r, current);
/*     */               } 
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 781 */       this.RETIREMENT_AGE.standing = new StatStanding(this.RETIREMENT_AGE, 0.25D);
/* 782 */       this.RETIREMENT_AGE.addDecree(dec);
/*     */ 
/*     */ 
/*     */       
/* 786 */       this.RETIREMENT_HOME = (STAT)new STATFake("RETIREMENT", init)
/*     */         {
/*     */ 
/*     */           
/*     */           protected double getDD(HCLASS cl, Race r, int daysBack)
/*     */           {
/* 792 */             double am = STATS.POP().pop(r, HTYPES.RETIREE(), 0);
/* 793 */             double dRet = 5.0D * am / (STATS.POP()).POP.data().get(r);
/* 794 */             dRet = CLAMP.d(dRet, 0.0D, 1.0D);
/*     */ 
/*     */ 
/*     */             
/* 798 */             double access = StatsWork.Retirement.this.RETIREMENT_HOME_ACCESS.data(cl).getD(r, 0);
/* 799 */             double quality = StatsWork.Retirement.this.RETIREMENT_HOME_QUALITY.data(cl).getD(r, 0);
/* 800 */             double type = StatsWork.Retirement.this.RETIREMENT_HOME_TYPE.data(cl).getD(r, 0);
/*     */             
/* 802 */             double res = dRet * access * (0.5D + quality * 0.5D * type);
/*     */             
/* 804 */             return 0.2D * dRet + 0.8D * res;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public int pdivider(HCLASS c, Race r, int daysback) {
/* 810 */             return 1;
/*     */           }
/*     */ 
/*     */           
/*     */           public void hover(GUI_BOX text, HCLASS cl, Race r) {
/* 815 */             StatHoverer.hover(text, (STAT)this);
/*     */             
/* 817 */             GBox b = (GBox)text;
/* 818 */             b.sep();
/* 819 */             b.NL();
/* 820 */             double am = STATS.POP().pop(r, HTYPES.RETIREE(), 0);
/* 821 */             double dRet = Math.sqrt(5.0D * am / (STATS.POP()).POP.data().get(r));
/* 822 */             dRet = CLAMP.d(dRet, 0.0D, 1.0D);
/*     */             
/* 824 */             b.textL((HTYPES.RETIREE()).names);
/* 825 */             b.tab(6);
/* 826 */             b.add((SPRITE)GFORMAT.i(b.text(), (int)am));
/* 827 */             b.add((SPRITE)(UI.icons()).s.arrow_right);
/* 828 */             b.add((SPRITE)GFORMAT.i(b.text(), ((STATS.POP()).POP.data().get(r) / 5)));
/* 829 */             b.NL();
/*     */             
/* 831 */             double access = StatsWork.Retirement.this.RETIREMENT_HOME_ACCESS.data(cl).getD(r, 0);
/* 832 */             double quality = StatsWork.Retirement.this.RETIREMENT_HOME_QUALITY.data(cl).getD(r, 0);
/* 833 */             double type = StatsWork.Retirement.this.RETIREMENT_HOME_TYPE.data(cl).getD(r, 0);
/*     */             
/* 835 */             b.textL((StatsWork.Retirement.this.RETIREMENT_HOME_ACCESS.info()).name);
/* 836 */             b.tab(6);
/* 837 */             b.add((SPRITE)GFORMAT.perc(b.text(), access));
/* 838 */             b.NL();
/*     */             
/* 840 */             b.textL((StatsWork.Retirement.this.RETIREMENT_HOME_QUALITY.info()).name);
/* 841 */             b.tab(6);
/* 842 */             b.add((SPRITE)GFORMAT.perc(b.text(), quality));
/* 843 */             b.NL();
/*     */             
/* 845 */             b.textL((StatsWork.Retirement.this.RETIREMENT_HOME_TYPE.info()).name);
/* 846 */             b.tab(6);
/* 847 */             b.add((SPRITE)GFORMAT.perc(b.text(), type));
/* 848 */             b.NL();
/*     */             
/* 850 */             b.sep();
/* 851 */             StatHoverer.hover(text, (STAT)this, cl, r);
/*     */           }
/*     */         };
/*     */       
/* 855 */       (this.RETIREMENT_HOME.info()).icon = ((ROOM_RESTHOME)(SETT.ROOMS()).RESTHOMES.get(0)).icon.medium;
/*     */       
/* 857 */       init.count.getClass(); this.RETIREMENT_HOME_ACCESS = (STAT)new StatsWork.StatRet(init, (DataO<Induvidual>.DataAbs)new DataO.DataBit(init.count, "WORK_RA"), 
/* 858 */           Dic.¤¤Access, StatsWork.¤¤accessD);
/* 859 */       init.count.getClass(); this.RETIREMENT_HOME_QUALITY = (STAT)new StatsWork.StatRet(init, (DataO<Induvidual>.DataAbs)new DataO.DataNibble(init.count, "WORK_RQ"), 
/* 860 */           Dic.¤¤Quality, StatsWork.¤¤qualityD);
/* 861 */       this.RETIREMENT_HOME_TYPE = new STATFakeData(null, "WORK_RT", init, new StatInfo(StatsWork.¤¤Type, StatsWork.¤¤TypeD))
/*     */         {
/*     */           protected double getDD(HCLASS cl, Race race)
/*     */           {
/* 865 */             double v = fValues[(HCLASS_RACE.clP(race, cl)).index] / 256.0D;
/* 866 */             double pop = STATS.POP().pop(race, HTYPES.RETIREE());
/* 867 */             if (pop > 0.0D) {
/* 868 */               return v / pop;
/*     */             }
/* 870 */             return 0.0D;
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean shoudRetire(Induvidual i) {
/* 877 */       int oa = (STATS.POP()).age.lifespan(i);
/* 878 */       double oldAge = oa * (0.4D + 0.6D * (1.0D - this.RETIREMENT_AGE.decree().getD(i.clas(), i.race())));
/* 879 */       return ((STATS.POP()).age.DAYS.get(i) >= oldAge);
/*     */     }
/*     */     
/*     */     public int estimate(HCLASS cl, Race race, double dec) {
/* 883 */       double fromD = 1.0D - 0.6D * dec;
/* 884 */       fromD *= (STATS.POP().demography().historyRecords() - 1);
/* 885 */       double am = 0.0D;
/* 886 */       am += (1.0D - fromD - (int)fromD) * STATS.POP().demography().getD(race, (int)fromD);
/* 887 */       int fi = (int)fromD;
/* 888 */       fi++;
/* 889 */       for (; fi < STATS.POP().demography().historyRecords(); fi++) {
/* 890 */         am += STATS.POP().demography().getD(race, fi);
/*     */       }
/* 892 */       return (int)Math.ceil(am);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsWork.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */