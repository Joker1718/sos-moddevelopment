/*    */ package settlement.entity.humanoid.ai.consume;
/*    */ 
/*    */ import init.resources.Meal;
/*    */ import init.type.NEEDS;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import settlement.room.service.food.eatery.ROOM_EATERY;
/*    */ import settlement.stats.STATS;
/*    */ 
/*    */ final class F_SPlanEatery extends SPlanAbs<ROOM_EATERY> {
/*    */   private final AISUB eat;
/*    */   final AIPLAN.PLANRES.Resumer first;
/*    */   
/*    */   public F_SPlanEatery(AISUB eat) {
/* 19 */     super("Eatery", (SETT.ROOMS()).EATERIES, false);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 28 */     this.first = new AIPLAN.PLANRES.Resumer(this, "")
/*    */       {
/*    */         
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 33 */           return F_SPlanEatery.this.eat.activate(a, d);
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 39 */           int da = F_SPlanEatery.this.blue(d).eat((a.race().pref()).food, (STATS.FOOD()).FOOD.decree().get(a), d.planTile.x(), d.planTile.y());
/*    */           
/* 41 */           STATS.FOOD().eat(a, Meal.amount(da), Meal.pref(da));
/* 42 */           if ((NEEDS.TYPES()).HUNGER.stat().getPrio(a) > 0)
/* 43 */             return F_SPlanEatery.this.init(a, d); 
/* 44 */           return null;
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 49 */           return true;
/*    */         }
/*    */ 
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {
/* 54 */           FSERVICE ss = F_SPlanEatery.this.blue(d).service().service(d.planTile.x(), d.planTile.y());
/* 55 */           if (ss != null)
/* 56 */             ss.findableReserveCancel(); 
/*    */         }
/*    */       };
/*    */     this.eat = eat;
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation arrive(Humanoid a, AIManager d) {
/*    */     return this.first.set(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\F_SPlanEatery.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */