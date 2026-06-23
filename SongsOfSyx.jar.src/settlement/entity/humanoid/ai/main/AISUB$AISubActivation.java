/*    */ package settlement.entity.humanoid.ai.main;
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
/*    */ public class AISubActivation
/*    */ {
/* 16 */   private static AISubActivation i = new AISubActivation();
/*    */   private AISUB sub;
/*    */   private AISTATE state;
/* 19 */   private final AISubActivationI inter = new AISubActivationI();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public AISUB get() {
/* 26 */     AISUB s = this.sub;
/* 27 */     this.sub = null;
/* 28 */     return s;
/*    */   }
/*    */ 
/*    */   
/*    */   public AISUB peek() {
/* 33 */     return this.sub;
/*    */   }
/*    */   
/*    */   public AISTATE state() {
/* 37 */     return this.state;
/*    */   }
/*    */ 
/*    */   
/*    */   public AISubActivation setState(AISTATE state) {
/* 42 */     this.state = state;
/* 43 */     return this;
/*    */   }
/*    */   
/*    */   static AISubActivation make(AISUB s, AISTATE state) {
/* 47 */     i.sub = s;
/* 48 */     i.state = state;
/* 49 */     if (i.state == null)
/* 50 */       throw new RuntimeException(i.sub.getClass().getName()); 
/* 51 */     return i;
/*    */   }
/*    */   
/*    */   public AISubActivationI i() {
/* 55 */     return this.inter;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   class AISubActivationI
/*    */   {
/*    */     public AISUB get() {
/* 65 */       AISUB s = AISUB.AISubActivation.this.sub;
/* 66 */       AISUB.AISubActivation.this.sub = null;
/* 67 */       return s;
/*    */     }
/*    */     
/*    */     public AISTATE state() {
/* 71 */       return AISUB.AISubActivation.this.state;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISUB$AISubActivation.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */