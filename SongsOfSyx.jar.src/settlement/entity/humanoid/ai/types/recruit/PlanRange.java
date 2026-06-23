/*     */ package settlement.entity.humanoid.ai.types.recruit;
/*     */ 
/*     */ import init.type.HTYPES;
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
/*     */ import settlement.room.military.training.archery.ROOM_ARCHERY;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ final class PlanRange extends AIPLAN.PLANRES {
/*     */   private final AIModule_Recruit module;
/*     */   private final AIPLAN.PLANRES.Resumer done;
/*     */   final AIPLAN.PLANRES.Resumer inits;
/*     */   final AIPLAN.PLANRES.Resumer work;
/*     */   
/*     */   PlanRange(AIModule_Recruit module) {
/*  27 */     super("recRange");
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
/*  40 */           if (PlanRange.this.job(a, d) != null)
/*  41 */             PlanRange.this.job(a, d).jobReserveCancel(null); 
/*  42 */           return (AI.SUBS()).STAND.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  47 */           a.HTypeSet(HTYPES.SUBJECT(), null, null);
/*  48 */           return d.resumeOtherPlan(a, (AI.plans()).NOP);
/*     */         }
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
/*  63 */           JOBMANAGER_HASER w = PlanRange.this.work(a);
/*     */           
/*  65 */           if (w == null) {
/*  66 */             return PlanRange.this.done.set(a, d);
/*     */           }
/*  68 */           SETT_JOB j = w.getWork().getReservableJob(a.tc());
/*     */           
/*  70 */           if (j == null) {
/*  71 */             return PlanRange.this.done.set(a, d);
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
/*  82 */           return PlanRange.this.done.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  87 */           if (PlanRange.this.job(a, d) == null)
/*  88 */             return null; 
/*  89 */           DIR dir = PlanRange.this.blue(a).faceCoo(d.planTile.x(), d.planTile.y());
/*  90 */           a.speed.setDirCurrent(dir);
/*  91 */           a.speed.magnitudeTargetSet(0.0D);
/*  92 */           a.speed.magnitudeInit(0.0D);
/*  93 */           return PlanRange.this.work.set(a, d);
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
/* 109 */     this.work = new Res(this)
/*     */       {
/* 111 */         private final AISUB sub = (AISUB)new AISUB.Simple("BarracksRange")
/*     */           {
/*     */             protected AISTATE resume(Humanoid a, AIManager d)
/*     */             {
/* 115 */               d.subByte = (byte)(d.subByte + 1);
/* 116 */               if (d.subByte == 1)
/* 117 */                 return (AI.STATES()).STAND.activate(a, d, 10.0D); 
/* 118 */               if (d.subByte == 2)
/* 119 */                 return (AI.STATES()).anima.archer1.activate(a, d, 3.0D); 
/* 120 */               if (d.subByte == 3) {
/* 121 */                 if (PlanRange.null.access$0(PlanRange.null.this).blue(a) != null) {
/* 122 */                   DIR dir = PlanRange.null.access$0(PlanRange.null.this).blue(a).faceCoo(d.planTile.x(), d.planTile.y());
/* 123 */                   PlanRange.null.access$0(PlanRange.null.this).blue(a).fireArrow(a.tc().x(), a.tc().y(), a.body().cX() + dir.x() * 32, a.body().cY() + dir.y() * 32);
/*     */                 } 
/* 125 */                 return (AI.STATES()).anima.archer2.activate(a, d, 3.0D);
/*     */               } 
/* 127 */               return null;
/*     */             }
/*     */           };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 136 */           if (!PlanRange.this.module.planShouldContinue(a, d)) {
/* 137 */             can(a, d);
/* 138 */             return null;
/*     */           } 
/* 140 */           return this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d)
/*     */         {
/* 146 */           if (PlanRange.this.job(a, d) == null)
/* 147 */             return null; 
/* 148 */           return set(a, d);
/*     */         }
/*     */       };
/*     */     this.module = module;
/*     */   }
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     return this.inits.set(a, d);
/*     */   }
/* 156 */   private ROOM_ARCHERY blue(Humanoid a) { RoomInstance w = (RoomInstance)(STATS.WORK()).EMPLOYED.get(a);
/* 157 */     if (w != null && w.blueprintI() instanceof ROOM_ARCHERY)
/* 158 */       return (ROOM_ARCHERY)w.blueprintI(); 
/* 159 */     return null; }
/*     */ 
/*     */   
/*     */   private JOBMANAGER_HASER work(Humanoid a) {
/* 163 */     if (blue(a) != null)
/* 164 */       return (JOBMANAGER_HASER)(STATS.WORK()).EMPLOYED.get(a); 
/* 165 */     return null; } public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/*     */     if (e.type == HPoll.WORKING)
/*     */       return 1.0D; 
/*     */     return super.poll(a, d, e);
/*     */   } private SETT_JOB job(Humanoid a, AIManager d) {
/* 170 */     JOBMANAGER_HASER w = work(a);
/* 171 */     if (w != null) {
/*     */       
/* 173 */       SETT_JOB j = w.getWork().getJob((COORDINATE)d.planTile);
/* 174 */       if (j == null || !j.jobReservedIs(null)) {
/* 175 */         return null;
/*     */       }
/* 177 */       if (!this.module.planShouldContinue(a, d)) {
/* 178 */         j.jobReserveCancel(null);
/* 179 */         return null;
/*     */       } 
/*     */       
/* 182 */       return j;
/*     */     } 
/*     */     
/* 185 */     return null;
/*     */   }
/*     */   
/*     */   private abstract class Res extends AIPLAN.PLANRES.Resumer { private Res() {
/* 189 */       super(PlanRange.this);
/*     */     }
/*     */     
/*     */     public boolean con(Humanoid a, AIManager d) {
/* 193 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void can(Humanoid a, AIManager d) {
/* 198 */       SETT_JOB j = PlanRange.this.job(a, d);
/* 199 */       if (j != null) {
/* 200 */         j.jobReserveCancel(null);
/*     */       }
/*     */     }
/*     */     
/*     */     protected void name(Humanoid a, AIManager d, Str string) {
/* 205 */       JOBMANAGER_HASER bb = PlanRange.this.work(a);
/* 206 */       if (bb == null)
/*     */         return; 
/* 208 */       string.add((((RoomInstance)(STATS.WORK()).EMPLOYED.get(a)).blueprintI().employment()).verb);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\recruit\PlanRange.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */