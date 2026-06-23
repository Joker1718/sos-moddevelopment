/*     */ package settlement.entity.humanoid.ai.service;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIData;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.service.hygine.bath.Bath;
/*     */ import settlement.room.service.hygine.bath.BathInstance;
/*     */ import settlement.room.service.hygine.bath.ROOM_BATH;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ final class M_PlanBath extends MPlan<ROOM_BATH> {
/*     */   private final AISUB sub;
/*     */   private final AIPLAN.PLANRES.Resumer first;
/*     */   
/*     */   public M_PlanBath() {
/*  26 */     super("Bath", (SETT.ROOMS()).BATHS, true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  34 */     this.sub = (AISUB)new AISUB.Simple("Bathing")
/*     */       {
/*     */         
/*     */         protected AISTATE resume(Humanoid a, AIManager d)
/*     */         {
/*  39 */           if (!a.speed.isZero()) {
/*  40 */             a.speed.magnitudeInit(0.0D);
/*     */           }
/*  42 */           d.subByte = (byte)(d.subByte + 1);
/*     */           
/*  44 */           if (d.subByte > 20) {
/*  45 */             cancel(a, d);
/*  46 */             return null;
/*     */           } 
/*     */           
/*  49 */           if (d.subByte == 1) {
/*  50 */             for (DIR dir : DIR.ORTHO) {
/*  51 */               int x = a.physics.tileC().x() + dir.x();
/*  52 */               int y = a.physics.tileC().y() + dir.y();
/*  53 */               if (ROOM_BATH.isPool(x, y))
/*  54 */                 return (AI.STATES()).WALK2.dirTile(a, d, dir); 
/*     */             } 
/*  56 */             d.debug(a, "No bath!");
/*  57 */             return (AI.STATES()).STAND.aDirRND(a, d, 1.0F + RND.rFloat(2.0D));
/*     */           } 
/*     */           
/*  60 */           if (d.subByte > 1) {
/*  61 */             (STATS.POP()).NAKED.set(a.indu(), 0);
/*     */           }
/*     */           
/*  64 */           return (AI.STATES()).STAND.aDirRND(a, d, 1.0F + RND.rFloat(2.0D));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager ai, HEvent.HEventData e) {
/*  70 */           if (e.event == HEvent.MEET_HARMLESS) {
/*  71 */             if (a.speed.isZero()) {
/*  72 */               DIR d = (DIR)DIR.ORTHO.get(RND.rInt(4));
/*  73 */               for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*  74 */                 int x = a.physics.tileC().x() + d.x();
/*  75 */                 int y = a.physics.tileC().y() + d.y();
/*  76 */                 if (ROOM_BATH.isPool(x, y) && !SETT.ENTITIES().hasAtTile((ENTITY)a, x, y)) {
/*  77 */                   ai.overwrite(a, (AI.STATES()).WALK2.tile(a, ai, x, y));
/*     */                 }
/*  79 */                 d = d.next(2);
/*     */               } 
/*     */             } 
/*     */             
/*  83 */             return false;
/*     */           } 
/*  85 */           return super.event(a, ai, e);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  90 */     this.first = new AIPLAN.PLANRES.Resumer(this, "1")
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  94 */           (STATS.POP()).NAKED.set(a.indu(), 1);
/*  95 */           return M_PlanBath.this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 100 */           can(a, d);
/*     */           
/* 102 */           (STATS.NEEDS()).EXPOSURE.fix(a.indu());
/* 103 */           (STATS.NEEDS()).DIRTINESS.set(a.indu(), 0);
/* 104 */           return M_PlanBath.this.walk2Bench.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 109 */           Bath bath = M_PlanBath.this.blue(d).bath(d.planTile.x(), d.planTile.y());
/* 110 */           return (bath != null && bath.findableReservedIs());
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 115 */           Bath s = M_PlanBath.this.blue(d).bath(d.planTile.x(), d.planTile.y());
/* 116 */           if (s != null && s.findableReservedIs()) {
/* 117 */             s.consume();
/*     */           }
/* 119 */           (STATS.POP()).NAKED.set(a.indu(), 0);
/*     */         }
/*     */       };
/* 122 */     this.walk2Bench = new AIPLAN.PLANRES.Resumer(this, "2")
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 126 */           BathInstance b = (BathInstance)M_PlanBath.this.blue(d).get(a.physics.tileC().x(), a.physics.tileC().y());
/* 127 */           if (b != null) {
/* 128 */             COORDINATE c = b.getBench();
/* 129 */             if (c != null) {
/* 130 */               (STATS.POP()).NAKED.set(a.indu(), 1);
/* 131 */               return M_PlanBath.trySub(a, d, (AI.SUBS()).walkTo.cooFull(a, d, c), null);
/*     */             } 
/*     */           } 
/* 134 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 139 */           return M_PlanBath.this.relax.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 144 */           return M_PlanBath.this.blue(d).isBench(d.path.destX(), d.path.destY());
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 149 */           BathInstance b = (BathInstance)M_PlanBath.this.blue(d).get(a.physics.tileC().x(), a.physics.tileC().y());
/* 150 */           if (b != null) {
/* 151 */             b.returnBench(d.path.destX(), d.path.destY());
/*     */           }
/*     */           
/* 154 */           (STATS.POP()).NAKED.set(a.indu(), 0);
/*     */         }
/*     */       };
/* 157 */     this.relax = new AIPLAN.PLANRES.Resumer(this, "3")
/*     */       {
/* 159 */         final AISUB sub = (AISUB)new AISUB.Simple("Relaxing")
/*     */           {
/*     */             protected AISTATE resume(Humanoid a, AIManager d)
/*     */             {
/* 163 */               d.subByte = (byte)(d.subByte + 1);
/* 164 */               if (d.subByte == 1)
/* 165 */                 return (AI.STATES()).anima.layoff.activate(a, d, (10 + RND.rInt(20))); 
/* 166 */               return null;
/*     */             }
/*     */           };
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 172 */           DIR dir = M_PlanBath.this.blue(d).getBenchDir(a.physics.tileC().x(), a.physics.tileC().y());
/* 173 */           a.speed.setDirCurrent(dir.perpendicular());
/* 174 */           return this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 179 */           can(a, d);
/* 180 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 185 */           return M_PlanBath.this.blue(d).isBench(d.path.destX(), d.path.destY());
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 190 */           BathInstance b = (BathInstance)M_PlanBath.this.blue(d).get(a.physics.tileC().x(), a.physics.tileC().y());
/* 191 */           if (b != null) {
/* 192 */             b.returnBench(d.path.destX(), d.path.destY());
/*     */           }
/* 194 */           (STATS.POP()).NAKED.set(a.indu(), 0);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private final AIPLAN.PLANRES.Resumer walk2Bench;
/*     */   private final AIPLAN.PLANRES.Resumer relax;
/*     */   
/*     */   protected AISUB.AISubActivation arrive(Humanoid a, AIManager d) {
/*     */     return this.first.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\M_PlanBath.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */