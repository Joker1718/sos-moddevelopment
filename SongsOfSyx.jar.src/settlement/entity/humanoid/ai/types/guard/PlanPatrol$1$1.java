/*     */ package settlement.entity.humanoid.ai.types.guard;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.room.law.guard.Patrol;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends AISUB.Simple
/*     */ {
/* 110 */   private final int distFar = 9216;
/* 111 */   private final double distFarI = 1.0850694444444444E-4D;
/* 112 */   private final int distClose = 512;
/* 113 */   private final double distCloseI = 0.001953125D;
/*     */ 
/*     */   
/*     */   protected AISTATE resume(Humanoid a, AIManager d) {
/* 117 */     d.subByte = (byte)(d.subByte + 1);
/* 118 */     if (!PlanPatrol.null.access$0(PlanPatrol.null.this).valid(d)) {
/* 119 */       return null;
/*     */     }
/* 121 */     Coo coo = PlanPatrol.null.access$0(PlanPatrol.null.this).coo(d);
/*     */     
/* 123 */     if (PlanPatrol.null.access$0(PlanPatrol.null.this).isInPosition((COORDINATE)coo, a, d)) {
/* 124 */       a.speed.magnitudeInit(0.0D);
/* 125 */       if (d.subByte == 1)
/* 126 */         return (AI.STATES()).STAND.activate(a, d, 0.05D); 
/* 127 */       return null;
/*     */     } 
/*     */     
/* 130 */     double speed = Patrol.speed * 64.0D;
/*     */     
/* 132 */     int distX = coo.x() - a.physics.body().cX();
/* 133 */     int distY = coo.y() - a.physics.body().cY();
/* 134 */     double dist = (distX * distX + distY * distY);
/*     */     
/* 136 */     if (dist > 9216.0D) {
/* 137 */       speed += a.speed.magintudeMax() * (dist - 9216.0D) * 1.0850694444444444E-4D;
/* 138 */     } else if (dist < 512.0D) {
/* 139 */       speed *= dist * 0.001953125D;
/*     */     } 
/*     */     
/* 142 */     speed = CLAMP.d(speed, 0.0D, a.speed.magintudeMax());
/*     */ 
/*     */ 
/*     */     
/* 146 */     AISTATE s = (AI.STATES()).MOVE_TO.move(a, d, coo.x(), coo.y(), 0.05D, speed);
/*     */     
/* 148 */     return s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\guard\PlanPatrol$1$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */