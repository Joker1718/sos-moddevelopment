/*     */ package settlement.entity.humanoid.ai.types.prisoner;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.CRIMES;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.entity.humanoid.ai.main.HAI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public final class AIModule_Prisoner extends AIModule {
/*     */   private static AIModule_Prisoner self;
/*     */   
/*     */   public static PrisonerData DATA() {
/*  33 */     return PrisonerData.self;
/*     */   }
/*     */   
/*  36 */   private final Jail jailed = new Jail();
/*  37 */   private final PlanExecuted executed = new PlanExecuted();
/*  38 */   private final Prison prison = new Prison();
/*  39 */   private final Judged judged = new Judged();
/*  40 */   private final AIPLAN[] executions = new AIPLAN[] {
/*  41 */       (AIPLAN)new ExecuteTemple(), 
/*  42 */       (AIPLAN)new ExecuteArena()
/*     */     };
/*  44 */   private final AIPLAN cannibal = (AIPLAN)new ExecuteCannibal();
/*  45 */   private final Stocked stocked = new Stocked();
/*  46 */   static final byte PRISON_DAYS = (byte)(int)(2.0D * TIME.years().bitConversion((TIMECYCLE)TIME.days())); private final AIPLAN plan;
/*     */   private final AIPLAN exile;
/*  48 */   private static CharSequence ¤¤name = "Atonement"; private final AIPLAN free;
/*     */   static {
/*  50 */     D.ts(AIModule_Prisoner.class);
/*     */   } private final AIPLAN slave;
/*     */   public AIModule_Prisoner() {
/*  53 */     super((SPRITE)(UI.icons()).s.bars, ¤¤name, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 205 */     this.plan = (AIPLAN)new AIPLAN.PLANRES("prisStart")
/*     */       {
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/* 209 */           return this.start.set(a, d);
/*     */         }
/*     */         
/* 212 */         AIPLAN.PLANRES.Resumer start = new AIPLAN.PLANRES.Resumer(this, "unconsious")
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 216 */               d.planByte1 = 0;
/* 217 */               return (AI.SUBS()).LAY.activateTime(a, d, 0);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 223 */               if (a.indu().hType() != HTYPES.PRISONER()) {
/* 224 */                 a.HTypeSet(HTYPES.PRISONER(), CAUSE_LEAVES.PUNISHED(), (a.indu().hType() == HTYPES.SLAVE()) ? CAUSE_ARRIVES.EMANCIPATED() : CAUSE_ARRIVES.BORN());
/* 225 */                 return (AI.SUBS()).LAY.activateTime(a, d, 10);
/*     */               } 
/* 227 */               return null;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 233 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */             
/*     */             public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 244 */               return false;
/*     */             }
/*     */ 
/*     */             
/*     */             public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 249 */               return 0.0D;
/*     */             }
/*     */           };
/*     */       };
/*     */     
/* 254 */     this.exile = (AIPLAN)new AIPLAN.PLANRES("prisLeave")
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/* 259 */           return this.start.set(a, d);
/*     */         }
/*     */         
/* 262 */         AIPLAN.PLANRES.Resumer start = new AIPLAN.PLANRES.Resumer(this, (CRIME_PUNISHMENTS.BANISH()).verb)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 266 */               if ((SETT.PATH()).finders.entryPoints.find(a.tc().x(), a.tc().y(), d.path, 2147483647)) {
/* 267 */                 return (AI.SUBS()).walkTo.pathFull(a, d);
/*     */               }
/* 269 */               return finish(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 274 */               return finish(a, d);
/*     */             }
/*     */             
/*     */             private AISUB.AISubActivation finish(Humanoid a, AIManager d) {
/* 278 */               AIModule_Prisoner.DATA().punish(a, d, CRIME_PUNISHMENTS.BANISH());
/* 279 */               AIManager.dead = CAUSE_LEAVES.EXILED();
/* 280 */               return (AI.SUBS()).LAY.activateTime(a, d, 10);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 285 */               if (AIModule_Prisoner.punishment(a, (HAI)d) != CRIME_PUNISHMENTS.BANISH()) {
/* 286 */                 RoomInstance ins = (SETT.ROOMS()).STOCKADE.registerPrisoner(a.tc());
/* 287 */                 if (ins != null) {
/* 288 */                   (SETT.ROOMS()).STOCKADE.unregisterPrisoner(ins.mX(), ins.mY());
/* 289 */                   return false;
/*     */                 } 
/*     */               } 
/*     */               
/* 293 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */             
/*     */             public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 304 */               return super.event(a, d, e);
/*     */             }
/*     */ 
/*     */             
/*     */             public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 309 */               return super.poll(a, d, e);
/*     */             }
/*     */           };
/*     */ 
/*     */         
/*     */         protected void cancel(Humanoid a, AIManager d) {
/* 315 */           super.cancel(a, d);
/*     */         }
/*     */       };
/*     */     
/* 319 */     this.free = (AIPLAN)new AIPLAN.PLANRES("prisFree")
/*     */       {
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/* 323 */           return this.start.set(a, d);
/*     */         }
/*     */         
/* 326 */         AIPLAN.PLANRES.Resumer start = new AIPLAN.PLANRES.Resumer(this, Dic.¤¤Free)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 330 */               return (AI.SUBS()).STAND.activate(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 335 */               return AIModule_Prisoner.null.this.free.set(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 340 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */ 
/*     */ 
/*     */         
/* 350 */         AIPLAN.PLANRES.Resumer free = new AIPLAN.PLANRES.Resumer(this, Dic.¤¤Free)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 354 */               return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 359 */               AIModule_Prisoner.DATA().punish(a, d, CRIME_PUNISHMENTS.PARDON());
/* 360 */               if (((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(a.indu())).cl == HCLASSES.SLAVE()) {
/* 361 */                 a.HTypeSet(HTYPES.SLAVE(), null, CAUSE_ARRIVES.PAROLE());
/*     */               } else {
/* 363 */                 a.HTypeSet(HTYPES.SUBJECT(), null, CAUSE_ARRIVES.PAROLE());
/*     */               } 
/* 365 */               (STATS.LAW()).EX_CON.indu().setD(a.indu(), 1.0D);
/* 366 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 371 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */       };
/* 382 */     this.slave = (AIPLAN)new AIPLAN.PLANRES("prisSlave")
/*     */       {
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/* 386 */           return this.start.set(a, d);
/*     */         }
/*     */         
/* 389 */         AIPLAN.PLANRES.Resumer start = new AIPLAN.PLANRES.Resumer(this, Dic.¤¤Free)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 393 */               return (AI.SUBS()).STAND.activate(a, d);
/*     */             }
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 398 */               AIModule_Prisoner.DATA().punish(a, d, CRIME_PUNISHMENTS.ENSLAVE());
/* 399 */               a.HTypeSet(HTYPES.SLAVE(), null, null);
/* 400 */               (STATS.LAW()).EX_CON.indu().setD(a.indu(), 1.0D);
/* 401 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 406 */               return true;
/*     */             }
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */       };
/*     */     self = this;
/*     */   }
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/*     */     CRIME_PUNISHMENTS.PUNISHMENT pp = punishment(a, (HAI)d);
/*     */     if (pp == CRIME_PUNISHMENTS.PARDON())
/*     */       return this.free.activate(a, d); 
/*     */     if ((DATA()).judged.get(d) == 0 && ((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(a.indu())).isJudged) {
/*     */       AIPLAN.AiPlanActivation aiPlanActivation = this.judged.activate(a, d);
/*     */       if (aiPlanActivation != null)
/*     */         return aiPlanActivation; 
/*     */       if ((SETT.ROOMS()).COURT.employment().employed() <= 0)
/*     */         (DATA()).judgeWait.set(d, (DATA()).judgeWait.max(d)); 
/*     */       if (!(DATA()).judgeWait.isMax(d)) {
/*     */         AIPLAN.AiPlanActivation p = this.jailed.activate(a, d);
/*     */         if (p != null)
/*     */           return p; 
/*     */       } 
/*     */     } 
/*     */     if (!TIME.light().nightIs() && ((DATA()).stocked.get(d) == 0 || (TIME.days().bitsSinceStart() + STATS.RAN().get(a.indu(), 3) & 0x7) == 0)) {
/*     */       (DATA()).stocked.setMax(d);
/*     */       AIPLAN.AiPlanActivation aiPlanActivation = this.stocked.activate(a, d);
/*     */       if (aiPlanActivation != null)
/*     */         return aiPlanActivation; 
/*     */     } 
/*     */     if (PrisonerData.self.prisonTimeLeft.get(d) == PRISON_DAYS + 1) {
/*     */       PrisonerData.self.prisonTimeLeft.inc(d, -1);
/*     */       AIPLAN.AiPlanActivation p = this.jailed.activate(a, d);
/*     */       if (p != null)
/*     */         return p; 
/*     */     } 
/*     */     AIPLAN.AiPlanActivation s = plan(a, d, pp);
/*     */     if (s != null)
/*     */       return s; 
/*     */     s = this.jailed.activate(a, d);
/*     */     if (s != null)
/*     */       return s; 
/*     */     return this.exile.activate(a, d);
/*     */   }
/*     */   
/*     */   public static CRIME_PUNISHMENTS.PUNISHMENT punishment(Humanoid a, HAI d) {
/*     */     CRIME_PUNISHMENTS.PUNISHMENT p = (CRIME_PUNISHMENTS.PUNISHMENT)(DATA()).punishmentSet.get(d);
/*     */     if (p != null && p != CRIME_PUNISHMENTS.STOCKS())
/*     */       return p; 
/*     */     return ((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(a.indu())).stat().punishment(a.indu());
/*     */   }
/*     */   
/*     */   private AIPLAN.AiPlanActivation plan(Humanoid a, AIManager d, CRIME_PUNISHMENTS.PUNISHMENT p) {
/*     */     if (p == CRIME_PUNISHMENTS.PRISON())
/*     */       return this.prison.activate(a, d); 
/*     */     if (PRISON_DAYS - PrisonerData.self.prisonTimeLeft.get(d) < STATS.RAN().get(a.indu(), 2) % 5) {
/*     */       PrisonerData.self.prisonTimeLeft.inc(d, -1);
/*     */       AIPLAN.AiPlanActivation s = this.jailed.activate(a, d);
/*     */       if (s != null)
/*     */         return s; 
/*     */     } 
/*     */     if (p == CRIME_PUNISHMENTS.HARVEST())
/*     */       return this.cannibal.activate(a, d); 
/*     */     if (p == CRIME_PUNISHMENTS.EXECUTE()) {
/*     */       for (int i = 0; i < this.executions.length; i++) {
/*     */         int o = RND.rInt(this.executions.length);
/*     */         AIPLAN old = this.executions[i];
/*     */         this.executions[i] = this.executions[o];
/*     */         this.executions[o] = old;
/*     */       } 
/*     */       byte b;
/*     */       int j;
/*     */       AIPLAN[] arrayOfAIPLAN;
/*     */       for (j = (arrayOfAIPLAN = this.executions).length, b = 0; b < j; ) {
/*     */         AIPLAN pl = arrayOfAIPLAN[b];
/*     */         AIPLAN.AiPlanActivation s = pl.activate(a, d);
/*     */         if (s != null)
/*     */           return s; 
/*     */         b++;
/*     */       } 
/*     */       return this.executed.activate(a, d);
/*     */     } 
/*     */     if (p == CRIME_PUNISHMENTS.ENSLAVE())
/*     */       return this.slave.activate(a, d); 
/*     */     if (p == CRIME_PUNISHMENTS.PARDON())
/*     */       return this.free.activate(a, d); 
/*     */     if (p == CRIME_PUNISHMENTS.BANISH())
/*     */       return this.exile.activate(a, d); 
/*     */     return null;
/*     */   }
/*     */   
/*     */   protected void init(Humanoid a, AIManager d, HTYPE prev, HTYPE current) {
/*     */     (STATS.MULTIPLIERS()).PROSECUTION.mark(a, false);
/*     */     DATA().init(a, d);
/*     */   }
/*     */   
/*     */   public static boolean isPrisoner(Humanoid a, RoomInstance room) {
/*     */     AIManager d = (AIManager)a.ai();
/*     */     if (room.blueprintI() == (SETT.ROOMS()).STOCKADE && d.plan() == self.jailed)
/*     */       return room.is((COORDINATE)d.planTile); 
/*     */     if (room.blueprintI() == (SETT.ROOMS()).PRISON && d.plan() == self.prison)
/*     */       return room.is((COORDINATE)AI.modules().coo(d)); 
/*     */     return false;
/*     */   }
/*     */   
/*     */   protected void cancel(Humanoid a, AIManager d) {
/*     */     super.cancel(a, d);
/*     */   }
/*     */   
/*     */   protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int updateOfDay) {
/*     */     (DATA()).stocked.inc(d, -1);
/*     */     if (newDay) {
/*     */       (DATA()).prisonTimeLeft.inc(d, -1);
/*     */       (DATA()).judgeWait.inc(d, 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getPriority(Humanoid a, AIManager d) {
/*     */     return 10;
/*     */   }
/*     */   
/*     */   public void makePrisoner(Humanoid h, AIManager m) {
/*     */     m.overwrite(h, this.plan);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\prisoner\AIModule_Prisoner.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */