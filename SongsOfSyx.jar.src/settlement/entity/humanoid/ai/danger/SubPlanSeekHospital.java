/*     */ package settlement.entity.humanoid.ai.danger;
/*     */ 
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.health.hospital.ROOM_HOSPITAL;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class SubPlanSeekHospital
/*     */ {
/*     */   private final AIPLAN.PLANRES.Resumer start;
/*  25 */   private final ROOM_HOSPITAL b = (SETT.ROOMS()).HOSPITAL;
/*  26 */   public final SoundRace sound = AUDIO.race("SICK_MOAN");
/*     */   
/*     */   AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*  29 */     if ((STATS.SERVICE()).hospital.accessRequest(a))
/*  30 */       return this.start.set(a, d); 
/*  31 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SubPlanSeekHospital(AIPLAN.PLANRES p) {
/*  36 */     p.getClass(); final AIPLAN.PLANRES.Resumer rest = new AIPLAN.PLANRES.Resumer(p, (this.b.service()).verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  40 */           d.planByte1 = (byte)(4 + RND.rInt(4));
/*  41 */           double liveChance = SubPlanSeekHospital.this.b.recoverRate(d.planTile.x(), d.planTile.y());
/*  42 */           if ((STATS.NEEDS()).INJURIES.inDanger(a.indu()) && 
/*  43 */             !(STATS.NEEDS()).INJURIES.willDie(a.indu(), liveChance)) {
/*  44 */             (STATS.NEEDS()).INJURIES.setNonDanger(a.indu());
/*     */           }
/*     */ 
/*     */           
/*  48 */           return (AI.SUBS()).LAY.activateTime(a, d, 15);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  53 */           FSERVICE s = SubPlanSeekHospital.this.b.service().service(d.planTile.x(), d.planTile.y());
/*  54 */           if (s == null) {
/*  55 */             return null;
/*     */           }
/*  57 */           SubPlanSeekHospital.this.sound.rnd(a);
/*  58 */           double liveChance = SubPlanSeekHospital.this.b.recoverRate(d.planTile.x(), d.planTile.y());
/*     */           
/*  60 */           if ((STATS.DISEASE().status(a.indu())).active && !STATS.DISEASE().diseaseIsDone(a, liveChance))
/*  61 */             return (AI.SUBS()).LAY.activateTime(a, d, 60); 
/*  62 */           return SubPlanSeekHospital.this.fix(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  68 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/*  73 */           FSERVICE s = SubPlanSeekHospital.this.b.service().service(d.planTile.x(), d.planTile.y());
/*  74 */           if (s != null && s.findableReservedIs()) {
/*  75 */             s.consume();
/*     */           }
/*     */         }
/*     */       };
/*  79 */     p.getClass(); this.start = new AIPLAN.PLANRES.Resumer(p, (this.b.service()).verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  83 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.service(a, d, (SFinderFindable)(SubPlanSeekHospital.this.b.service()).finder, SubPlanSeekHospital.this.b.service().radius());
/*  84 */           if (s != null) {
/*  85 */             d.planTile.set(d.path.destX(), d.path.destY());
/*     */           }
/*  87 */           return s;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  92 */           FSERVICE s = SubPlanSeekHospital.this.b.service().service(d.planTile.x(), d.planTile.y());
/*  93 */           if (s == null || !s.findableReservedIs()) {
/*  94 */             return null;
/*     */           }
/*  96 */           int x = d.planTile.x() * 64 + 32;
/*  97 */           int y = d.planTile.y() * 64 + 32;
/*  98 */           DIR dir = (SETT.ROOMS()).HOSPITAL.layCoo(d.planTile.x(), d.planTile.y());
/*  99 */           x += dir.x() * 30;
/* 100 */           y += dir.y() * 30;
/* 101 */           a.physics.body().moveC(x, y);
/* 102 */           a.speed.setDirCurrent(dir);
/* 103 */           return rest.set(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 109 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private AISUB.AISubActivation fix(Humanoid a, AIManager d) {
/* 123 */     FSERVICE s = this.b.service().service(d.planTile.x(), d.planTile.y());
/*     */     
/* 125 */     double liveChance = this.b.recoverRate(d.planTile.x(), d.planTile.y());
/* 126 */     if ((STATS.DISEASE().status(a.indu())).active && STATS.DISEASE().shouldDie(a) && RND.rFloat() > liveChance) {
/* 127 */       AIManager.dead = CAUSE_LEAVES.DISEASE();
/* 128 */       AIManager.deadGore = false;
/* 129 */       return (AI.SUBS()).LAY.activate(a, d);
/*     */     } 
/*     */ 
/*     */     
/* 133 */     if ((STATS.NEEDS()).INJURIES.willDie(a.indu(), liveChance)) {
/* 134 */       Humanoid.HumanoidResource.dead = (a.lastLeaveCause() != null) ? a.lastLeaveCause() : CAUSE_LEAVES.getAccident();
/* 135 */       AIManager.deadGore = false;
/* 136 */       return (AI.SUBS()).LAY.activate(a, d);
/*     */     } 
/*     */     
/* 139 */     if (s != null && s.findableReservedIs()) {
/* 140 */       s.consume();
/* 141 */       for (DIR dir : DIR.ORTHO) {
/* 142 */         if (!(SETT.PATH()).solidity.is(a.tc(), dir)) {
/* 143 */           int x = (a.tc().x() + dir.x()) * 64 + 32;
/* 144 */           int y = (a.tc().y() + dir.y()) * 64 + 32;
/* 145 */           a.physics.body().moveC(x, y);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 150 */     STATS.DISEASE().cure(a.indu(), true);
/* 151 */     (STATS.NEEDS()).INJURIES.setNonDanger(a.indu());
/*     */     
/* 153 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\danger\SubPlanSeekHospital.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */