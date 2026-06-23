/*     */ package settlement.entity.humanoid.ai.subwalk;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends AISUB.Resumable.Resumer
/*     */ {
/*     */   null(AISUB.Resumable paramResumable) {
/*  80 */     super(paramResumable);
/*     */   }
/*     */   
/*     */   protected AISTATE setAction(Humanoid a, AIManager d) {
/*  84 */     return res(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISTATE res(Humanoid a, AIManager d) {
/*  89 */     double m = a.speed.magnitude();
/*     */     
/*  91 */     a.speed.magnitudeInit(0.0D);
/*  92 */     ENTITY prey = SETT.ENTITIES().getByID(d.planObject);
/*     */     
/*  94 */     if (prey == null)
/*     */     {
/*  96 */       return AISub_follow.this.meet.set(a, d);
/*     */     }
/*  98 */     int dx = prey.physics.tileC().x() - a.physics.tileC().x();
/*  99 */     int dy = prey.physics.tileC().y() - a.physics.tileC().y();
/* 100 */     int dist = Math.abs(dx) + Math.abs(dy);
/*     */     
/* 102 */     if (dist == 0) {
/* 103 */       return AISub_follow.this.meet.set(a, d);
/*     */     }
/*     */     
/* 106 */     if (dist < 5) {
/* 107 */       AISTATE s = AISub_follow.this.state.free(a, d, prey.body().cX(), prey.body().cY());
/* 108 */       a.speed.magnitudeInit(m);
/* 109 */       return s;
/*     */     } 
/* 111 */     d.path.request(a.tc(), prey.tc());
/* 112 */     if (d.path.isSuccessful()) {
/* 113 */       AISTATE s = AISub_follow.this.activate(a, d).state();
/* 114 */       a.speed.magnitudeInit(m);
/* 115 */       return s;
/*     */     } 
/*     */     
/* 118 */     return AISub_follow.this.meet.set(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 123 */     if (e.event == HEvent.COLLISION_TILE) {
/* 124 */       ENTITY prey = SETT.ENTITIES().getByID(d.planObject);
/* 125 */       if (prey == null) {
/* 126 */         d.overwrite(a, AISub_follow.this.meet.set(a, d));
/* 127 */         return false;
/*     */       } 
/* 129 */       a.speed.magnitudeInit(0.0D);
/* 130 */       a.speed.magnitudeTargetSet(0.0D);
/* 131 */       d.path.request(a.tc(), prey.tc());
/* 132 */       if (d.path.isSuccessful()) {
/* 133 */         d.overwrite(a, AISub_follow.this.activate(a, d));
/* 134 */         return true;
/*     */       } 
/* 136 */       d.overwrite(a, AISub_follow.this.meet.set(a, d));
/* 137 */       return true;
/*     */     } 
/* 139 */     return super.event(a, d, e);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subwalk\AISub_follow$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */