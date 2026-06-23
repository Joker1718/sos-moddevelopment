/*    */ package settlement.entity.humanoid.ai.consume;
/*    */ 
/*    */ import init.resources.Meal;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import settlement.room.service.food.tavern.ROOM_TAVERN;
/*    */ import settlement.room.service.module.RoomServiceAccess;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.rnd.RND;
/*    */ 
/*    */ final class PlanTavern extends SPlanAbs<ROOM_TAVERN> {
/*    */   private final AIModule_Drink m;
/*    */   AIPLAN.PLANRES.Resumer eat;
/*    */   
/*    */   public PlanTavern(AIModule_Drink m) {
/* 20 */     super("Tavern", (SETT.ROOMS()).TAVERNS, false);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 29 */     this.eat = new AIPLAN.PLANRES.Resumer(this, "eat")
/*    */       {
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 35 */           d.planByte1 = (byte)(STATS.FOOD()).DRINK.decree().get(a);
/* 36 */           d.planByte2 = 0;
/*    */ 
/*    */           
/* 39 */           FSERVICE f = PlanTavern.this.get(a, d);
/* 40 */           f.startUsing();
/* 41 */           return PlanTavern.this.m.subdrink.activate(a, d);
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 47 */           FSERVICE f = PlanTavern.this.get(a, d);
/* 48 */           f.startUsing();
/*    */ 
/*    */           
/* 51 */           d.planByte2 = (byte)(d.planByte2 + 1);
/* 52 */           if (d.planByte2 >= (STATS.FOOD()).DRINK.decree().get(a)) {
/* 53 */             int rr = PlanTavern.this.blue(d).consume((a.race().pref()).drink, (STATS.FOOD()).DRINK.decree().get(a), d.planTile.x(), d.planTile.y());
/* 54 */             STATS.FOOD().drink(a, Meal.amount(rr), Meal.pref(rr));
/* 55 */             can(a, d);
/* 56 */             if (RND.rFloat() < (STATS.FOOD()).DRINK.indu().getD(a.indu()))
/* 57 */               return d.resumeOtherPlan(a, (AIPLAN)PlanTavern.this.m.drunk); 
/* 58 */             return null;
/*    */           } 
/*    */           
/* 61 */           return PlanTavern.this.m.subdrink.activate(a, d);
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 67 */           FSERVICE f = PlanTavern.this.get(a, d);
/* 68 */           return (f != null && f.findableReservedIs());
/*    */         }
/*    */         
/*    */         public void can(Humanoid a, AIManager d)
/*    */         {
/* 73 */           FSERVICE f = PlanTavern.this.get(a, d);
/* 74 */           if (f != null && f.findableReservedIs())
/* 75 */             f.consume(); 
/*    */         }
/*    */       };
/*    */     this.m = m;
/*    */   } public boolean worthTrying(Humanoid a, AIManager d) {
/* 80 */     for (RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER s : (SETT.ROOMS()).FOOD) {
/* 81 */       RoomServiceAccess b = s.service();
/* 82 */       if (b.accessRequest(a) && b.finder.has(a.tc())) {
/* 83 */         return true;
/*    */       }
/*    */     } 
/* 86 */     return false;
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation arrive(Humanoid a, AIManager d) {
/*    */     return this.eat.set(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\PlanTavern.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */