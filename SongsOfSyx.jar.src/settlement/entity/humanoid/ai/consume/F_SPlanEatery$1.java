/*    */ package settlement.entity.humanoid.ai.consume;
/*    */ 
/*    */ import init.resources.Meal;
/*    */ import init.type.NEEDS;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import settlement.stats.STATS;
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
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 28 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 33 */     return F_SPlanEatery.this.eat.activate(a, d);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 39 */     int da = F_SPlanEatery.this.blue(d).eat((a.race().pref()).food, (STATS.FOOD()).FOOD.decree().get(a), d.planTile.x(), d.planTile.y());
/*    */     
/* 41 */     STATS.FOOD().eat(a, Meal.amount(da), Meal.pref(da));
/* 42 */     if ((NEEDS.TYPES()).HUNGER.stat().getPrio(a) > 0)
/* 43 */       return F_SPlanEatery.this.init(a, d); 
/* 44 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 49 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 54 */     FSERVICE ss = F_SPlanEatery.this.blue(d).service().service(d.planTile.x(), d.planTile.y());
/* 55 */     if (ss != null)
/* 56 */       ss.findableReserveCancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\F_SPlanEatery$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */