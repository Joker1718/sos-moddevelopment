/*    */ package settlement.entity.humanoid.ai.main;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.spirte.HSprite;
/*    */ import settlement.entity.humanoid.spirte.HSprites;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends AISTATE
/*    */ {
/*    */   null(String $anonymous0, String $anonymous1) {
/* 63 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public HSprite sprite(Humanoid a) {
/* 67 */     return HSprites.SLEEP;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean update(Humanoid a, AIManager d, double ds) {
/* 72 */     d.stateTimer = (float)(d.stateTimer - ds);
/* 73 */     if (d.stateTimer <= 0.0F) {
/* 74 */       return false;
/*    */     }
/* 76 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISTATES$SLEEP$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */