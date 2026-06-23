/*    */ package settlement.entity.humanoid.ai.main;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import snake2d.util.rnd.RND;
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
/*    */ class null
/*    */   extends AISUB.Simple
/*    */ {
/*    */   null(String $anonymous0) {
/* 25 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected AISTATE resume(Humanoid a, AIManager d) {
/* 29 */     if (!a.speed.isZero())
/* 30 */       return (AI.STATES()).STOP.activate(a, d); 
/* 31 */     d.subByte = (byte)(d.subByte + 1);
/* 32 */     if (d.subByte == 1)
/* 33 */       return (AI.STATES()).STAND.activate(a, d, (0.5F + RND.rFloat())); 
/* 34 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean isSuccessful(Humanoid a, AIManager d) {
/* 39 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISUBS$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */