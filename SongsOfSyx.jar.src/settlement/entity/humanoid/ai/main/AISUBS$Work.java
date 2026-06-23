/*    */ package settlement.entity.humanoid.ai.main;
/*    */ 
/*    */ import settlement.entity.humanoid.HEvent;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Work
/*    */ {
/* 54 */   private final AISUB.Simple sub = new AISUB.Simple("working")
/*    */     {
/*    */       protected AISTATE resume(Humanoid a, AIManager d)
/*    */       {
/* 58 */         if (!a.speed.isZero())
/* 59 */           return (AI.STATES()).STOP.activate(a, d); 
/* 60 */         if (d.subByte == 1) {
/* 61 */           d.subByte = (byte)(d.subByte + 1);
/* 62 */           return (AI.STATES()).WORK.state;
/*    */         } 
/* 64 */         if (d.subByte == 2) {
/* 65 */           d.subByte = (byte)(d.subByte + 1);
/* 66 */           return (AI.STATES()).STAND.activate(a, d, 0.20000000298023224D);
/*    */         } 
/* 68 */         return null;
/*    */       }
/*    */ 
/*    */       
/*    */       protected AISTATE resumeInterrupted(Humanoid a, AIManager d, HEvent event) {
/* 73 */         if (d.subByte >= 2)
/* 74 */           return (AI.STATES()).STAND.activate(a, d, 0.20000000298023224D); 
/* 75 */         return null;
/*    */       }
/*    */     };
/*    */ 
/*    */   
/*    */   public AISUB.AISubActivation activate(Humanoid a, AIManager d, double time) {
/* 81 */     AISUB.AISubActivation k = this.sub.activate(a, d, (AI.STATES()).WORK.activate(a, d, time));
/* 82 */     if (time > 0.0D) {
/* 83 */       d.subByte = 1;
/*    */     } else {
/* 85 */       d.subByte = 2;
/* 86 */     }  return k;
/*    */   }
/*    */   
/*    */   AISUB.AISubActivation activate(Humanoid a, AIManager d, AISTATES.Animation animation, double time) {
/* 90 */     AISUB.AISubActivation k = this.sub.activate(a, d);
/* 91 */     d.subByte = 1;
/* 92 */     animation.activate(a, d, time);
/* 93 */     return k;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISUBS$Work.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */