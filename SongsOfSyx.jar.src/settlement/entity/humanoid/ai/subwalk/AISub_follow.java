/*     */ package settlement.entity.humanoid.ai.subwalk;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISTATES;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ final class AISub_follow extends PathWalker {
/*     */   final AISUB.Resumable.Resumer last;
/*     */   
/*     */   AISub_follow(String key, AISTATES.WALK_DEST state, CharSequence name) {
/*  18 */     super(key, state, name);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     this.last = new AISUB.Resumable.Resumer(this)
/*     */       {
/*     */         protected AISTATE setAction(Humanoid a, AIManager d)
/*     */         {
/*  84 */           return res(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISTATE res(Humanoid a, AIManager d) {
/*  89 */           double m = a.speed.magnitude();
/*     */           
/*  91 */           a.speed.magnitudeInit(0.0D);
/*  92 */           ENTITY prey = SETT.ENTITIES().getByID(d.planObject);
/*     */           
/*  94 */           if (prey == null)
/*     */           {
/*  96 */             return AISub_follow.this.meet.set(a, d);
/*     */           }
/*  98 */           int dx = prey.physics.tileC().x() - a.physics.tileC().x();
/*  99 */           int dy = prey.physics.tileC().y() - a.physics.tileC().y();
/* 100 */           int dist = Math.abs(dx) + Math.abs(dy);
/*     */           
/* 102 */           if (dist == 0) {
/* 103 */             return AISub_follow.this.meet.set(a, d);
/*     */           }
/*     */           
/* 106 */           if (dist < 5) {
/* 107 */             AISTATE s = AISub_follow.this.state.free(a, d, prey.body().cX(), prey.body().cY());
/* 108 */             a.speed.magnitudeInit(m);
/* 109 */             return s;
/*     */           } 
/* 111 */           d.path.request(a.tc(), prey.tc());
/* 112 */           if (d.path.isSuccessful()) {
/* 113 */             AISTATE s = AISub_follow.this.activate(a, d).state();
/* 114 */             a.speed.magnitudeInit(m);
/* 115 */             return s;
/*     */           } 
/*     */           
/* 118 */           return AISub_follow.this.meet.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 123 */           if (e.event == HEvent.COLLISION_TILE) {
/* 124 */             ENTITY prey = SETT.ENTITIES().getByID(d.planObject);
/* 125 */             if (prey == null) {
/* 126 */               d.overwrite(a, AISub_follow.this.meet.set(a, d));
/* 127 */               return false;
/*     */             } 
/* 129 */             a.speed.magnitudeInit(0.0D);
/* 130 */             a.speed.magnitudeTargetSet(0.0D);
/* 131 */             d.path.request(a.tc(), prey.tc());
/* 132 */             if (d.path.isSuccessful()) {
/* 133 */               d.overwrite(a, AISub_follow.this.activate(a, d));
/* 134 */               return true;
/*     */             } 
/* 136 */             d.overwrite(a, AISub_follow.this.meet.set(a, d));
/* 137 */             return true;
/*     */           } 
/* 139 */           return super.event(a, d, e);
/*     */         }
/*     */       };
/*     */     
/* 143 */     this.collide = new AISUB.Resumable.Resumer(this)
/*     */       {
/*     */         public AISTATE res(Humanoid a, AIManager d)
/*     */         {
/* 147 */           ENTITY prey = SETT.ENTITIES().getByID(d.planObject);
/* 148 */           if (prey == null) {
/* 149 */             return AISub_follow.this.meet.set(a, d);
/*     */           }
/* 151 */           d.path.request(a.tc(), prey.tc());
/* 152 */           if (d.path.isSuccessful()) {
/*     */             
/* 154 */             AISTATE s = AISub_follow.this.activate(a, d).state();
/* 155 */             return s;
/*     */           } 
/* 157 */           return AISub_follow.this.meet.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean success(Humanoid a, AIManager d) {
/* 162 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public AISTATE setAction(Humanoid a, AIManager d) {
/* 167 */           a.speed.magnitudeInit(0.0D);
/* 168 */           return (AI.STATES()).STAND.activate(a, d, 0.05D);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 173 */           AISub_follow.this.abort(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 178 */           if (e.event != HEvent.COLLISION_SOFT)
/* 179 */             super.event(a, d, e); 
/* 180 */           return false;
/*     */         }
/*     */       };
/*     */     
/* 184 */     this.meet = new AISUB.Resumable.Resumer(this)
/*     */       {
/*     */         public AISTATE res(Humanoid a, AIManager d)
/*     */         {
/* 188 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean success(Humanoid a, AIManager d) {
/* 193 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public AISTATE setAction(Humanoid a, AIManager d) {
/* 198 */           a.speed.magnitudeInit(0.0D);
/* 199 */           return (AI.STATES()).STAND.activate(a, d, 0.1D);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 204 */           AISub_follow.this.abort(a, d);
/*     */         }
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e)
/*     */         {
/* 209 */           if (e.event != HEvent.MEET_HARMLESS) {
/* 210 */             super.event(a, d, e);
/*     */           }
/* 212 */           return false;
/*     */         }
/*     */       };
/*     */   }
/*     */   final AISUB.Resumable.Resumer collide; final AISUB.Resumable.Resumer meet;
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 218 */     if (e.event == HEvent.MEET_HARMLESS) {
/* 219 */       ENTITY target = SETT.ENTITIES().getByID(d.planObject);
/* 220 */       if (target != null && target == e.other) {
/* 221 */         d.overwrite(a, this.meet.set(a, d));
/*     */       }
/*     */     }
/* 224 */     else if (e.event == HEvent.COLLISION_SOFT) {
/*     */       
/* 226 */       d.overwrite(a, this.collide.set(a, d));
/*     */     } else {
/*     */       
/* 229 */       return super.event(a, d, e);
/*     */     } 
/* 231 */     return false;
/*     */   }
/*     */   
/*     */   AISUB.AISubActivation activate(Humanoid a, AIManager d, ENTITY other, byte tries) {
/*     */     d.planObject = other.id();
/*     */     d.subPathByte = tries;
/*     */     d.path.request(a.tc(), other.tc());
/*     */     if (d.path.isSuccessful())
/*     */       return activate(a, d); 
/*     */     return activate(a, d, this.meet);
/*     */   }
/*     */   
/*     */   protected boolean hasFailed(Humanoid a, AIManager d) {
/*     */     if (SETT.ENTITIES().getByID(d.planObject) == null)
/*     */       return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   protected void arrive(Humanoid a, AIManager d) {}
/*     */   
/*     */   protected void abort(Humanoid a, AIManager d) {}
/*     */   
/*     */   protected AISTATE setLast(Humanoid a, AIManager d) {
/*     */     return this.last.set(a, d);
/*     */   }
/*     */   
/*     */   public AISTATE resume(Humanoid a, AIManager d) {
/*     */     if (RND.oneIn(5)) {
/*     */       ENTITY prey = SETT.ENTITIES().getByID(d.planObject);
/*     */       if (prey == null)
/*     */         return this.meet.set(a, d); 
/*     */     } 
/*     */     return super.resume(a, d);
/*     */   }
/*     */   
/*     */   public boolean isSuccess(Humanoid a, AIManager d) {
/*     */     ENTITY prey = SETT.ENTITIES().getByID(d.planObject);
/*     */     if (prey == null)
/*     */       return false; 
/*     */     int dx = prey.physics.tileC().x() - a.physics.tileC().x();
/*     */     int dy = prey.physics.tileC().y() - a.physics.tileC().y();
/*     */     int dist = Math.abs(dx) + Math.abs(dy);
/*     */     return (dist <= 1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subwalk\AISub_follow.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */