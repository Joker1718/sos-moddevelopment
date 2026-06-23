/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   null(String $anonymous0) {
/* 139 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected AISTATE resume(Humanoid a, AIManager d) {
/* 143 */     if (!a.speed.isZero())
/* 144 */       return (AI.STATES()).STOP.activate(a, d); 
/* 145 */     if (d.subByte == 1) {
/* 146 */       d.subByte = (byte)(d.subByte + 1);
/* 147 */       return (AI.STATES()).anima.box.activate(a, d);
/*     */     } 
/* 149 */     if (d.subByte == 2) {
/* 150 */       d.subByte = (byte)(d.subByte + 1);
/* 151 */       return (AI.STATES()).STAND.activate(a, d, 0.20000000298023224D);
/*     */     } 
/* 153 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISTATE resumeInterrupted(Humanoid a, AIManager d, HEvent event) {
/* 158 */     if (d.subByte >= 2)
/* 159 */       return (AI.STATES()).STAND.activate(a, d, 0.20000000298023224D); 
/* 160 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISUBS$WorkHands$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */