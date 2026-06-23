/*     */ package settlement.entity.humanoid.ai.work;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.law.police.ROOM_POLICE;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.text.D;
/*     */ 
/*     */ final class WorkPolice extends WorkAbs {
/*  20 */   private static CharSequence ¤¤finding = "¤finding suspect";
/*  21 */   private static CharSequence ¤¤bringing = "¤bringing suspect back";
/*  22 */   private static CharSequence ¤¤being = "¤being interrogated";
/*     */   static {
/*  24 */     D.ts(WorkPolice.class);
/*     */   }
/*     */   
/*  27 */   private final ROOM_POLICE b = (SETT.ROOMS()).POLICE; private final AIPLAN.PLANRES.Resumer findingSuspect;
/*     */   
/*     */   protected WorkPolice(AIModule_Work module, PlanBlueprint[] map, WorkAbs.Works works) {
/*  30 */     super(module, (RoomBlueprintIns<?>)(SETT.ROOMS()).POLICE, map, works);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  77 */     this.findingSuspect = new AIPLAN.PLANRES.Resumer(this, ¤¤finding)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  81 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  86 */           if (!WorkPolice.this.reserved(d)) {
/*  87 */             can(a, d);
/*  88 */             return null;
/*     */           } 
/*     */ 
/*     */           
/*  92 */           if ((AI.SUBS()).walkTo.followSucess(a, d))
/*  93 */             return WorkPolice.this.knockSuspect.set(a, d); 
/*  94 */           if ((STATS.WORK()).WORK_TIME.indu().getD(a.indu()) < 0.5D) {
/*  95 */             AISUB.AISubActivation s = (AI.SUBS()).walkTo.follow(a, d, (ENTITY)WorkPolice.this.victim(d), false, (byte)20);
/*  96 */             if (s != null) {
/*  97 */               return s;
/*     */             }
/*     */           } 
/* 100 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 105 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 110 */           SETT_JOB j = WorkPolice.this.work(d);
/* 111 */           if (j != null && j.jobReservedIs(null)) {
/* 112 */             j.jobReserveCancel(null);
/*     */           }
/*     */         }
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 117 */           if (e.event == HEvent.MEET_HARMLESS && 
/* 118 */             e.other == WorkPolice.this.victim(d)) {
/* 119 */             d.overwrite(a, WorkPolice.this.knockSuspect.set(a, d));
/*     */             
/* 121 */             return true;
/*     */           } 
/*     */           
/* 124 */           return super.event(a, d, e);
/*     */         }
/*     */       };
/*     */     
/* 128 */     this.knockSuspect = new AIPLAN.PLANRES.Resumer(this, ¤¤finding)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 132 */           Humanoid e = WorkPolice.this.victim(d);
/* 133 */           if (e == null) {
/* 134 */             WorkPolice.this.findingSuspect.can(a, d);
/* 135 */             return null;
/*     */           } 
/* 137 */           if (!WorkPolice.this.reserved(d)) {
/* 138 */             can(a, d);
/* 139 */             return null;
/*     */           } 
/* 141 */           a.speed.turn2(a.body(), e.body());
/* 142 */           a.speed.magnitudeInit(0.0D);
/* 143 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.box, (AI.STATES()).anima.box.time);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 148 */           return WorkPolice.this.dragBack.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 153 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 158 */           SETT_JOB j = WorkPolice.this.work(d);
/* 159 */           if (j != null && j.jobReservedIs(null)) {
/* 160 */             j.jobReserveCancel(null);
/*     */           }
/*     */         }
/*     */       };
/* 164 */     this.dragBack = new AIPLAN.PLANRES.Resumer(this, ¤¤bringing)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 168 */           Humanoid v = WorkPolice.this.victim(d);
/* 169 */           if (v == null || !WorkPolice.this.reserved(d)) {
/* 170 */             can(a, d);
/* 171 */             return null;
/*     */           } 
/* 173 */           WorkPolice.this.victim(d).knockOut();
/* 174 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.drag(a, d, (SETT.HUMANOIDS()).draggable, v.id(), (COORDINATE)d.planTile);
/* 175 */           if (s != null)
/* 176 */             return s; 
/* 177 */           WorkPolice.this.victim(d).interrupt();
/* 178 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 183 */           SETT_JOB j = WorkPolice.this.work(d);
/*     */           
/* 185 */           if (!WorkPolice.this.reserved(d)) {
/* 186 */             can(a, d);
/* 187 */             return null;
/*     */           } 
/* 189 */           j.jobPerform(a, null, 0);
/* 190 */           Humanoid v = WorkPolice.this.victim(d);
/* 191 */           if (v == null) {
/* 192 */             can(a, d);
/* 193 */             return null;
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 198 */           v.physics.body().moveC((j.jobCoo().x() * 64 + 32), (j.jobCoo().y() * 64 + 32));
/*     */           
/* 200 */           AIManager d2 = (AIManager)v.ai();
/* 201 */           d2.overwrite(v, (AIPLAN)WorkPolice.this.plan);
/*     */           
/* 203 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 209 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 214 */           SETT_JOB j = WorkPolice.this.work(d);
/* 215 */           if (j != null && j.jobReservedIs(null))
/* 216 */             j.jobReserveCancel(null); 
/* 217 */           if (WorkPolice.this.victim(d) != null) {
/* 218 */             WorkPolice.this.victim(d).interrupt();
/*     */           }
/*     */         }
/*     */       };
/*     */     
/* 223 */     this.plan = new AIPLAN.PLANRES("POLICE_IMPRISONED")
/*     */       {
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/* 227 */           d.planTile.set(a.tc());
/* 228 */           (STATS.WORK()).incap.stat.indu().set(a.indu(), 1);
/* 229 */           (STATS.WORK()).EMPLOYED.set(a, null);
/* 230 */           return this.res.set(a, d);
/*     */         }
/*     */         
/* 233 */         final AIPLAN.PLANRES.Resumer res = new AIPLAN.PLANRES.Resumer(this, WorkPolice.¤¤being)
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/* 237 */               (STATS.POP()).NAKED.set(a.indu(), 1);
/*     */               
/* 239 */               a.speed.setDirCurrent((WorkPolice.null.access$0(WorkPolice.null.this)).b.work.victimDir(d.planTile.x(), d.planTile.y()));
/* 240 */               if ((WorkPolice.null.access$0(WorkPolice.null.this)).b.work.isLay(d.planTile.x(), d.planTile.y())) {
/* 241 */                 return (AI.SUBS()).LAY.activateTime(a, d, 40);
/*     */               }
/* 243 */               return (AI.SUBS()).STAND.activateTime(a, d, 40);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 249 */               SETT_JOB j = WorkPolice.null.access$0(WorkPolice.null.this).work(d);
/*     */               
/* 251 */               if (j == null) {
/* 252 */                 return null;
/*     */               }
/* 254 */               (STATS.NEEDS()).DIRTINESS.incD(a.indu(), 0.1D);
/*     */               
/* 256 */               a.speed.setDirCurrent((WorkPolice.null.access$0(WorkPolice.null.this)).b.work.victimDir(d.planTile.x(), d.planTile.y()));
/* 257 */               if ((WorkPolice.null.access$0(WorkPolice.null.this)).b.work.isLay(d.planTile.x(), d.planTile.y())) {
/* 258 */                 return (AI.SUBS()).LAY.activateTime(a, d, 40);
/*     */               }
/* 260 */               return (AI.SUBS()).STAND.activateTime(a, d, 40);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/* 266 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */             
/*     */             public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 276 */               return false;
/*     */             }
/*     */ 
/*     */             
/*     */             public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 281 */               return 0.0D;
/*     */             }
/*     */           };
/*     */       };
/*     */   }
/*     */   
/*     */   private final AIPLAN.PLANRES.Resumer knockSuspect;
/*     */   final AIPLAN.PLANRES.Resumer dragBack;
/*     */   private final AIPLAN.PLANRES plan;
/*     */   
/*     */   protected AISUB.AISubActivation initBegin(Humanoid a, AIManager d, SETT_JOB j, JOB_MANAGER jm) {
/*     */     d.planTile.set(j.jobCoo());
/*     */     if ((STATS.WORK()).WORK_TIME.indu().getD(a.indu()) < 0.75D) {
/*     */       Humanoid victim = this.b.work.clientToFetch(j.jobCoo().x(), j.jobCoo().y());
/*     */       if (victim != null) {
/*     */         d.planObject = victim.id();
/*     */         AISUB.AISubActivation s = (AI.SUBS()).walkTo.follow(a, d, (ENTITY)victim, false, (byte)20);
/*     */         if (s != null) {
/*     */           work(d).jobReserve(null);
/*     */           this.b.work.deliverClient(d.planTile.x(), d.planTile.y());
/*     */           this.findingSuspect.set(a, d);
/*     */           return s;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     return super.initBegin(a, d, j, jm);
/*     */   }
/*     */   
/*     */   private Humanoid victim(AIManager d) {
/*     */     ENTITY prey = SETT.ENTITIES().getByID(d.planObject);
/*     */     if (prey != null && prey instanceof Humanoid)
/*     */       return (Humanoid)prey; 
/*     */     return null;
/*     */   }
/*     */   
/*     */   private SETT_JOB work(AIManager d) {
/*     */     return this.b.work.job(d.planTile.x(), d.planTile.y());
/*     */   }
/*     */   
/*     */   private boolean reserved(AIManager d) {
/*     */     SETT_JOB j = work(d);
/*     */     return (j != null && j.jobReservedIs(null));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkPolice.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */