/*     */ package settlement.entity.humanoid.ai.types.guard;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.law.guard.GuardInstance;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.COORDINATEE;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ final class PlanWork extends AIPLAN.PLANRES {
/*     */   final AIPLAN.PLANRES.Resumer walk;
/*     */   
/*     */   protected PlanWork() {
/*  22 */     super("GUARD_GUARD");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  37 */     this.walk = new AIPLAN.PLANRES.Resumer(this, ((SETT.ROOMS()).GUARD.employment()).verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  41 */           GuardInstance ins = PlanWork.work(a);
/*     */           
/*  43 */           if (!ins.guardSpot((COORDINATEE)d.planTile, a.tc())) {
/*  44 */             return null;
/*     */           }
/*     */           
/*  47 */           if (d.planTile.isSameAs(a.tc())) {
/*  48 */             return PlanWork.this.guard.set(a, d);
/*     */           }
/*  50 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, (COORDINATE)d.planTile);
/*     */           
/*  52 */           if (s == null) {
/*  53 */             ins.guardSpotReturn(d.planTile.x(), d.planTile.y());
/*     */           }
/*  55 */           return s;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  60 */           return PlanWork.this.guard.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  65 */           return (PlanWork.work(a) != null);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/*  70 */           GuardInstance ins = PlanWork.work(a);
/*  71 */           if (ins != null) {
/*  72 */             ins.guardSpotReturn(d.planTile.x(), d.planTile.y());
/*     */           }
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  78 */     this.guard = new AIPLAN.PLANRES.Resumer(this, ((SETT.ROOMS()).GUARD.employment()).verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  82 */           GuardInstance ins = PlanWork.work(a);
/*  83 */           a.speed.turn2(ins.guardDir(a.tc().x(), a.tc().y()));
/*  84 */           d.planByte1 = (byte)(2 + RND.rInt(5));
/*     */           
/*  86 */           if ((STATS.WORK()).WORK_TIME.indu().getD(a.indu()) > 0.8D) {
/*  87 */             d.planByte2 = 1;
/*  88 */             can(a, d);
/*  89 */             d.planByte2 = 0;
/*     */           } else {
/*  91 */             d.planByte2 = 1;
/*     */           } 
/*  93 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).STAND_SWORD.activate(a, d, (5 + RND.rInt(5))));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 100 */           GuardInstance ins = PlanWork.work(a);
/*     */           
/* 102 */           if (!AIModules.current(d).moduleCanContinue(a, d) || (STATS.WORK()).WORK_TIME.indu().getD(a.indu()) > 1.0D) {
/* 103 */             can(a, d);
/* 104 */             return null;
/*     */           } 
/*     */           
/* 107 */           if (d.planByte2 == 0 && 
/* 108 */             SETT.ENTITIES().getAtTileSingle(a.tc().x(), a.tc().y()) instanceof Humanoid) {
/* 109 */             return null;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 114 */           Humanoid c = (SETT.ROOMS()).GUARD.reporter.pollCriminal(ins);
/*     */           
/* 116 */           if (c != null) {
/* 117 */             can(a, d);
/* 118 */             return d.resumeOtherPlan(a, AI.listeners().catchCriminal(c));
/*     */           } 
/*     */           
/* 121 */           d.planByte1 = (byte)(d.planByte1 - 1);
/*     */           
/* 123 */           if (d.planByte1 <= 0) {
/* 124 */             can(a, d);
/* 125 */             if ((SETT.ROOMS()).GUARD.instancesSize() > 1 && RND.oneIn(10) && (STATS.WORK()).WORK_TIME.indu().get(a.indu()) <= 0.5D)
/* 126 */               return PlanWork.this.patrol.set(a, d); 
/* 127 */             return null;
/*     */           } 
/* 129 */           a.speed.turn2(ins.guardDir(a.tc().x(), a.tc().y()));
/* 130 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).STAND_SWORD.activate(a, d, (15 + RND.rInt(5))));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 136 */           return (PlanWork.work(a) != null);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 141 */           if (d.planByte2 == 1) {
/* 142 */             GuardInstance ins = PlanWork.work(a);
/* 143 */             if (ins != null) {
/* 144 */               ins.guardSpotReturn(d.planTile.x(), d.planTile.y());
/*     */             }
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 150 */     this.patrol = new AIPLAN.PLANRES.Resumer(this, ((SETT.ROOMS()).GUARD.employment()).verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 154 */           int i = RND.rInt((SETT.ROOMS()).GUARD.instancesSize());
/* 155 */           if ((SETT.ROOMS()).GUARD.getInstance(i) == PlanWork.work(a)) {
/* 156 */             i++;
/* 157 */             i %= (SETT.ROOMS()).GUARD.instancesSize();
/*     */           } 
/*     */           
/* 160 */           d.planByte1 = (byte)(2 + RND.rInt(5));
/* 161 */           return (AI.SUBS()).walkTo.room(a, d, (SETT.ROOMS()).GUARD.getInstance(i));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 166 */           d.planByte1 = (byte)(d.planByte1 - 1);
/* 167 */           if (d.planByte1 <= 0) {
/* 168 */             can(a, d);
/* 169 */             return null;
/*     */           } 
/* 171 */           a.speed.setRaw(a.speed.dir().next(1 * (RND.rBoolean() ? 1 : -1)), 0.0D);
/* 172 */           return (AI.SUBS()).STAND.activateTime(a, d, 5 + RND.rInt(5));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 178 */           return (PlanWork.work(a) != null);
/*     */         }
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */   private final AIPLAN.PLANRES.Resumer guard; private final AIPLAN.PLANRES.Resumer patrol;
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     return this.walk.set(a, d);
/*     */   }
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 189 */     if (e.event == HEvent.NOTIFY_CRIME && 
/* 190 */       e.other instanceof Humanoid) {
/* 191 */       d.overwrite(a, AI.listeners().catchCriminal((Humanoid)e.other));
/* 192 */       return true;
/*     */     } 
/*     */     
/* 195 */     return super.event(a, d, e);
/*     */   }
/*     */ 
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 200 */     if (e.type == HPoll.WORKING)
/* 201 */       return 1.0D; 
/* 202 */     return super.poll(a, d, e);
/*     */   }
/*     */   
/*     */   static GuardInstance work(Humanoid a) {
/*     */     RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(a);
/*     */     if (ins != null && ins instanceof GuardInstance)
/*     */       return (GuardInstance)ins; 
/*     */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\guard\PlanWork.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */