/*     */ package settlement.entity.humanoid.ai.types.prisoner;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.law.execution.ExecutionStation;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ class PlanExecuted
/*     */   extends AIPLAN.PLANRES {
/*     */   public PlanExecuted() {
/*  22 */     super("prisExe");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  35 */     this.walk = new AIPLAN.PLANRES.Resumer(this, (CRIME_PUNISHMENTS.EXECUTE()).verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  39 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, (COORDINATE)d.planTile);
/*  40 */           if (s != null)
/*  41 */             return s; 
/*  42 */           PlanExecuted.this.cancel(a, d);
/*  43 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  48 */           return PlanExecuted.this.ready.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  53 */           ExecutionStation.Client s = PlanExecuted.this.s(d);
/*  54 */           if (s == null || !s.clientReserved())
/*  55 */             return false; 
/*  56 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/*  61 */           ExecutionStation.Client s = PlanExecuted.this.s(d);
/*  62 */           if (s != null) {
/*  63 */             s.clientCancel();
/*     */           }
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
/*  75 */     this.ready = new AIPLAN.PLANRES.Resumer(this, (CRIME_PUNISHMENTS.EXECUTE()).verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  79 */           ExecutionStation.Client s = PlanExecuted.this.s(d);
/*  80 */           s.clientUse();
/*  81 */           d.planByte1 = (byte)TIME.hours().bitCurrent();
/*  82 */           d.planByte2 = (byte)TIME.days().bitCurrent();
/*  83 */           return res(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  89 */           if (d.planByte2 != TIME.days().bitCurrent() && TIME.hours().bitCurrent() > d.planByte1) {
/*  90 */             PlanExecuted.this.walk.can(a, d);
/*  91 */             return null;
/*     */           } 
/*     */           
/*  94 */           if (!PlanExecuted.this.walk.con(a, d)) {
/*  95 */             PlanExecuted.this.walk.can(a, d);
/*  96 */             return null;
/*     */           } 
/*     */           
/*  99 */           ExecutionStation.Client s = PlanExecuted.this.s(d);
/* 100 */           a.speed.setDirCurrent(s.clientDir());
/*     */           
/* 102 */           int type = PlanExecuted.this.ss().type(d.planTile.x(), d.planTile.y());
/*     */           
/* 104 */           if (type == 1) {
/* 105 */             return (AI.SUBS()).LAY.activateTime(a, d, 1);
/*     */           }
/*     */           
/* 108 */           if (s.clientBeingExecuted()) {
/* 109 */             if (type == 2)
/* 110 */               return PlanExecuted.this.strangled.set(a, d); 
/* 111 */             if (type == 3)
/* 112 */               return PlanExecuted.this.gibbited.set(a, d); 
/* 113 */             if (type == 4)
/* 114 */               return PlanExecuted.this.crucified.set(a, d); 
/*     */           } 
/* 116 */           return (AI.SUBS()).STAND.activateTime(a, d, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 121 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 126 */           PlanExecuted.this.walk.can(a, d);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 133 */     this.strangled = new AIPLAN.PLANRES.Resumer(this, (CRIME_PUNISHMENTS.EXECUTE()).verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 137 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.strangle, (10 + RND.rInt(40)));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 142 */           AIManager.dead = CAUSE_LEAVES.EXECUTED();
/* 143 */           PlanExecuted.this.cancel(a, d);
/* 144 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 149 */           return PlanExecuted.this.walk.con(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 154 */           PlanExecuted.this.walk.can(a, d);
/*     */         }
/*     */       };
/*     */     
/* 158 */     this.gibbited = new AIPLAN.PLANRES.Resumer(this, (CRIME_PUNISHMENTS.EXECUTE()).verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 162 */           (STATS.POP()).NAKED.set(a.indu(), 1);
/* 163 */           return (AI.SUBS()).STAND.activateRndDir(a, d, 45);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 169 */           (NEEDS.TYPES()).HUNGER.stat().stat().indu().inc(a.indu(), 1);
/*     */           
/* 171 */           if ((STATS.FOOD()).STARVATION.indu().get(a.indu()) > 0) {
/* 172 */             AIManager.dead = CAUSE_LEAVES.EXECUTED();
/*     */           }
/*     */           
/* 175 */           return (AI.SUBS()).STAND.activateRndDir(a, d, 45);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 180 */           return PlanExecuted.this.walk.con(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 185 */           PlanExecuted.this.walk.can(a, d);
/*     */         }
/*     */       };
/*     */     
/* 189 */     this.crucified = new AIPLAN.PLANRES.Resumer(this, (CRIME_PUNISHMENTS.EXECUTE()).verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 193 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.armsOut, (10 + RND.rInt(40)));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 199 */           (STATS.NEEDS()).INJURIES.COUNT.indu().inc(a.indu(), 10);
/* 200 */           (SETT.THINGS()).gore.bleed((ENTITY)a, (a.race().appearance()).colors.blood);
/*     */           
/* 202 */           if ((STATS.NEEDS()).INJURIES.COUNT.indu().isMax(a.indu())) {
/* 203 */             AIManager.dead = CAUSE_LEAVES.EXECUTED();
/*     */           }
/* 205 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.armsOut, (10 + RND.rInt(40)));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 210 */           return PlanExecuted.this.walk.con(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 215 */           PlanExecuted.this.walk.can(a, d);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private final AIPLAN.PLANRES.Resumer walk;
/*     */   private final AIPLAN.PLANRES.Resumer ready;
/*     */   private final AIPLAN.PLANRES.Resumer strangled;
/*     */   private final AIPLAN.PLANRES.Resumer gibbited;
/*     */   private final AIPLAN.PLANRES.Resumer crucified;
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     ExecutionStation.Client s = (SETT.ROOMS()).EXECUTION.stations.exectuionReserve();
/*     */     if (s == null)
/*     */       return null; 
/*     */     d.planTile.set(s.coo());
/*     */     return this.walk.set(a, d);
/*     */   }
/*     */   
/*     */   private ExecutionStation.Client s(AIManager d) {
/*     */     return (SETT.ROOMS()).EXECUTION.stations.client(d.planTile.x(), d.planTile.y());
/*     */   }
/*     */   
/*     */   private ExecutionStation ss() {
/*     */     return (SETT.ROOMS()).EXECUTION.stations;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\prisoner\PlanExecuted.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */