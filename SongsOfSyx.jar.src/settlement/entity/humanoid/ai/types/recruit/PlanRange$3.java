/*     */ package settlement.entity.humanoid.ai.types.recruit;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import snake2d.util.datatypes.DIR;
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
/*     */ 
/*     */ class null
/*     */   extends PlanRange.Res
/*     */ {
/*     */   private final AISUB sub;
/*     */   
/*     */   null(PlanRange paramPlanRange2) {
/* 111 */     this.sub = (AISUB)new AISUB.Simple("BarracksRange")
/*     */       {
/*     */         protected AISTATE resume(Humanoid a, AIManager d)
/*     */         {
/* 115 */           d.subByte = (byte)(d.subByte + 1);
/* 116 */           if (d.subByte == 1)
/* 117 */             return (AI.STATES()).STAND.activate(a, d, 10.0D); 
/* 118 */           if (d.subByte == 2)
/* 119 */             return (AI.STATES()).anima.archer1.activate(a, d, 3.0D); 
/* 120 */           if (d.subByte == 3) {
/* 121 */             if (PlanRange.null.access$0(PlanRange.null.this).blue(a) != null) {
/* 122 */               DIR dir = PlanRange.null.access$0(PlanRange.null.this).blue(a).faceCoo(d.planTile.x(), d.planTile.y());
/* 123 */               PlanRange.null.access$0(PlanRange.null.this).blue(a).fireArrow(a.tc().x(), a.tc().y(), a.body().cX() + dir.x() * 32, a.body().cY() + dir.y() * 32);
/*     */             } 
/* 125 */             return (AI.STATES()).anima.archer2.activate(a, d, 3.0D);
/*     */           } 
/* 127 */           return null;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 136 */     if (!PlanRange.this.module.planShouldContinue(a, d)) {
/* 137 */       can(a, d);
/* 138 */       return null;
/*     */     } 
/* 140 */     return this.sub.activate(a, d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 146 */     if (PlanRange.this.job(a, d) == null)
/* 147 */       return null; 
/* 148 */     return set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\recruit\PlanRange$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */