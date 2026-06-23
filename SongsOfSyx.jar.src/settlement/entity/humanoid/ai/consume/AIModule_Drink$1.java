/*    */ package settlement.entity.humanoid.ai.consume;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AISTATE;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
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
/* 36 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISTATE resume(Humanoid a, AIManager d) {
/* 41 */     d.subByte = (byte)(d.subByte + 1);
/* 42 */     switch (d.subByte) { case 1:
/* 43 */         return (AI.STATES()).STAND.activate(a, d, (2.0F + RND.rFloat(4.0D)));
/* 44 */       case 2: return (AI.STATES()).anima.fist.activate(a, d, 1.5D);
/* 45 */       case 3: return (AI.STATES()).STAND.activate(a, d, (2.0F + RND.rFloat(4.0D)));
/* 46 */       case 4: return (AI.STATES()).anima.fist.activate(a, d, 1.5D);
/* 47 */       case 5: return (AI.STATES()).STAND.activate(a, d, (2.0F + RND.rFloat(4.0D)));
/* 48 */       case 6: return (AI.STATES()).anima.fist.activate(a, d, 1.5D);
/* 49 */       case 7: return (AI.STATES()).STAND.activate(a, d, (2.0F + RND.rFloat(4.0D)));
/* 50 */       case 8: return (AI.STATES()).anima.fist.activate(a, d, 1.5D); }
/*    */     
/* 52 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\AIModule_Drink$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */