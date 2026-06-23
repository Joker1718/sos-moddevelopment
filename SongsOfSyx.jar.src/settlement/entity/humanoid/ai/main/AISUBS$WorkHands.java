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
/*     */ 
/*     */ 
/*     */ public class WorkHands
/*     */ {
/* 139 */   private final AISUB.Simple sub = new AISUB.Simple("workhands")
/*     */     {
/*     */       protected AISTATE resume(Humanoid a, AIManager d)
/*     */       {
/* 143 */         if (!a.speed.isZero())
/* 144 */           return (AI.STATES()).STOP.activate(a, d); 
/* 145 */         if (d.subByte == 1) {
/* 146 */           d.subByte = (byte)(d.subByte + 1);
/* 147 */           return (AI.STATES()).anima.box.activate(a, d);
/*     */         } 
/* 149 */         if (d.subByte == 2) {
/* 150 */           d.subByte = (byte)(d.subByte + 1);
/* 151 */           return (AI.STATES()).STAND.activate(a, d, 0.20000000298023224D);
/*     */         } 
/* 153 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       protected AISTATE resumeInterrupted(Humanoid a, AIManager d, HEvent event) {
/* 158 */         if (d.subByte >= 2)
/* 159 */           return (AI.STATES()).STAND.activate(a, d, 0.20000000298023224D); 
/* 160 */         return null;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation activate(Humanoid a, AIManager d, double time) {
/* 166 */     AISUB.AISubActivation k = this.sub.activate(a, d, (AI.STATES()).anima.box.activate(a, d, time));
/* 167 */     if (time > 0.0D) {
/* 168 */       d.subByte = 1;
/*     */     } else {
/* 170 */       d.subByte = 2;
/* 171 */     }  return k;
/*     */   }
/*     */   
/*     */   AISUB.AISubActivation activate(Humanoid a, AIManager d, AISTATES.Animation animation, double time) {
/* 175 */     AISUB.AISubActivation k = this.sub.activate(a, d);
/* 176 */     d.subByte = 1;
/* 177 */     animation.activate(a, d, time);
/* 178 */     return k;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISUBS$WorkHands.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */