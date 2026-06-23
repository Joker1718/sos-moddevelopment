/*     */ package settlement.entity.humanoid.ai.types.recruit;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.military.training.barracks.ROOM_BARRACKS;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ final class PlanBarracks extends AIPLAN.PLANRES {
/*     */   private final AIModule_Recruit module;
/*     */   private final AIPLAN.PLANRES.Resumer done;
/*     */   final AIPLAN.PLANRES.Resumer inits;
/*     */   final AIPLAN.PLANRES.Resumer walkLast;
/*     */   final AIPLAN.PLANRES.Resumer fight;
/*     */   
/*     */   PlanBarracks(AIModule_Recruit module) {
/*  27 */     super("recBarrack");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  36 */     this.done = new Res(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  40 */           if (PlanBarracks.this.job(a, d) != null)
/*  41 */             PlanBarracks.this.job(a, d).jobReserveCancel(null); 
/*  42 */           return (AI.SUBS()).STAND.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  47 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*  59 */     this.inits = new Res(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  63 */           JOBMANAGER_HASER w = PlanBarracks.this.work(a);
/*     */           
/*  65 */           if (w == null) {
/*  66 */             return PlanBarracks.this.done.set(a, d);
/*     */           }
/*  68 */           SETT_JOB j = w.getWork().getReservableJob(a.tc());
/*     */           
/*  70 */           if (j == null) {
/*  71 */             return PlanBarracks.this.done.set(a, d);
/*     */           }
/*  73 */           d.planTile.set(j.jobCoo());
/*  74 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, j.jobCoo());
/*     */           
/*  76 */           if (s != null) {
/*  77 */             j = w.getWork().getJob((COORDINATE)d.planTile);
/*  78 */             j.jobReserve(null);
/*  79 */             return s;
/*     */           } 
/*     */           
/*  82 */           return PlanBarracks.this.done.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  87 */           if (PlanBarracks.this.job(a, d) == null)
/*  88 */             return null; 
/*  89 */           return PlanBarracks.this.walkLast.set(a, d);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  94 */     this.walkLast = new Res(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  98 */           COORDINATE man = PlanBarracks.this.blue(a).faceCoo(d.planTile.x(), d.planTile.y());
/*  99 */           DIR dir = DIR.get((COORDINATE)d.planTile, man);
/* 100 */           AISTATE s = (AI.STATES()).WALK2.edge(a, d, dir);
/* 101 */           a.speed.setDirCurrent(dir);
/* 102 */           return (AI.SUBS()).DUMMY.activate(a, d, s);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 107 */           if (PlanBarracks.this.job(a, d) == null)
/* 108 */             return null; 
/* 109 */           a.speed.magnitudeTargetSet(0.0D);
/* 110 */           a.speed.magnitudeInit(0.0D);
/* 111 */           return PlanBarracks.this.fight.set(a, d);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 116 */     this.fight = new Res(this)
/*     */       {
/* 118 */         private final AISUB.Simple sub = new AISUB.Simple("Barracksfight")
/*     */           {
/*     */             protected AISTATE resume(Humanoid a, AIManager d) {
/* 121 */               d.subByte = (byte)(d.subByte + 1);
/* 122 */               if (PlanBarracks.null.access$0(PlanBarracks.null.this).job(a, d) == null)
/* 123 */                 return null; 
/* 124 */               if (d.subByte == 1)
/* 125 */                 return (AI.STATES()).anima.sword_out.activate(a, d); 
/* 126 */               if (d.subByte == 2) {
/* 127 */                 PlanBarracks.null.access$0(PlanBarracks.null.this).job(a, d).jobSound().rnd(a);
/* 128 */                 return (AI.STATES()).anima.sword_in.activate(a, d);
/*     */               } 
/*     */               
/* 131 */               return null;
/*     */             }
/*     */           };
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 137 */           SETT_JOB j = PlanBarracks.this.job(a, d);
/* 138 */           j.jobStartPerforming();
/* 139 */           return this.sub.activate(a, d, (AI.STATES()).anima.sword.activate(a, d, (5.0F + RND.rFloat(5.0D))));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 144 */           if (PlanBarracks.this.job(a, d) == null)
/* 145 */             return null; 
/* 146 */           if (!PlanBarracks.this.module.planShouldContinue(a, d)) {
/* 147 */             can(a, d);
/* 148 */             return null;
/*     */           } 
/*     */           
/* 151 */           return this.sub.activate(a, d, (AI.STATES()).anima.sword.activate(a, d, (5.0F + RND.rFloat(5.0D))));
/*     */         }
/*     */       };
/*     */     this.module = module;
/*     */   }
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 158 */     if (e.type == HPoll.WORKING)
/* 159 */       return 1.0D; 
/* 160 */     return super.poll(a, d, e);
/*     */   } protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     return this.inits.set(a, d);
/*     */   } private ROOM_BARRACKS blue(Humanoid a) {
/* 164 */     RoomInstance w = (RoomInstance)(STATS.WORK()).EMPLOYED.get(a);
/* 165 */     if (w != null && w.blueprintI() instanceof ROOM_BARRACKS)
/* 166 */       return (ROOM_BARRACKS)w.blueprintI(); 
/* 167 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private JOBMANAGER_HASER work(Humanoid a) {
/* 172 */     if (blue(a) != null)
/* 173 */       return (JOBMANAGER_HASER)(STATS.WORK()).EMPLOYED.get(a); 
/* 174 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private SETT_JOB job(Humanoid a, AIManager d) {
/* 179 */     JOBMANAGER_HASER w = work(a);
/* 180 */     if (w != null) {
/*     */       
/* 182 */       SETT_JOB j = w.getWork().getJob((COORDINATE)d.planTile);
/* 183 */       if (j == null || !j.jobReservedIs(null)) {
/* 184 */         return null;
/*     */       }
/* 186 */       if (!this.module.planShouldContinue(a, d)) {
/* 187 */         j.jobReserveCancel(null);
/* 188 */         return null;
/*     */       } 
/*     */       
/* 191 */       return j;
/*     */     } 
/*     */     
/* 194 */     return null;
/*     */   }
/*     */   
/*     */   private abstract class Res extends AIPLAN.PLANRES.Resumer { private Res() {
/* 198 */       super(PlanBarracks.this);
/*     */     }
/*     */     
/*     */     public boolean con(Humanoid a, AIManager d) {
/* 202 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void can(Humanoid a, AIManager d) {
/* 207 */       SETT_JOB j = PlanBarracks.this.job(a, d);
/* 208 */       if (j != null) {
/* 209 */         j.jobReserveCancel(null);
/*     */       }
/*     */     }
/*     */     
/*     */     protected void name(Humanoid a, AIManager d, Str string) {
/* 214 */       JOBMANAGER_HASER bb = PlanBarracks.this.work(a);
/* 215 */       if (bb == null)
/*     */         return; 
/* 217 */       string.add((((RoomInstance)(STATS.WORK()).EMPLOYED.get(a)).blueprintI().employment()).verb);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\recruit\PlanBarracks.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */