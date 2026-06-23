/*    */ package settlement.entity.humanoid.ai.consume;
/*    */ 
/*    */ import init.resources.Meal;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.datatypes.COORDINATE;
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
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 33 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 38 */     int da = F_SPlanCanteen.this.blue(d).grab((a.race().pref()).food, (STATS.FOOD()).FOOD.decree().get(a), d.planTile.x(), d.planTile.y());
/*    */     
/* 40 */     STATS.FOOD().eat(a, Meal.amount(da), Meal.pref(da));
/* 41 */     COORDINATE c = F_SPlanCanteen.this.blue(d).getChair(d.planTile.x(), d.planTile.y());
/*    */     
/* 43 */     if (c != null) {
/* 44 */       AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, c);
/* 45 */       if (s != null) {
/* 46 */         d.planTile.set(c);
/* 47 */         d.planObject = da;
/* 48 */         F_SPlanCanteen.this.walkTable.set(a, d);
/* 49 */         return s;
/*    */       } 
/*    */     } 
/* 52 */     return F_SPlanCanteen.this.eat.activate(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 57 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 62 */     return true;
/*    */   }
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\F_SPlanCanteen$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */