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
/*    */ class null
/*    */   extends AISUB.Simple
/*    */ {
/*    */   null(String $anonymous0) {
/* 30 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISTATE resume(Humanoid a, AIManager d) {
/* 35 */     d.subByte = (byte)(d.subByte + 1);
/* 36 */     switch (d.subByte) { case 1:
/* 37 */         return (AI.STATES()).STAND.activate(a, d, (1.5F + RND.rFloat(4.0D)));
/* 38 */       case 2: return (AI.STATES()).anima.box.activate(a, d, 2.5D + RND.rFloat(2.0D));
/* 39 */       case 3: return (AI.STATES()).STAND.activate(a, d, (1.5F + RND.rFloat(4.0D)));
/* 40 */       case 4: return (AI.STATES()).anima.box.activate(a, d, 2.5D + RND.rFloat(2.0D)); }
/*    */     
/* 42 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\AIModule_Food$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */