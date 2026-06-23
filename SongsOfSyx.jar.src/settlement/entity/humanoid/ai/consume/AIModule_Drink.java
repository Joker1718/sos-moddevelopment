/*    */ package settlement.entity.humanoid.ai.consume;
/*    */ 
/*    */ import init.resources.RBIT;
/*    */ import init.sprite.UI.UI;
/*    */ import init.type.NEEDS;
/*    */ import init.type.NEED_E;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIModule;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISTATE;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.D;
/*    */ 
/*    */ final class AIModule_Drink extends AIModule {
/* 20 */   public final NEED_E need = (NEEDS.TYPES()).THIRST;
/*    */   
/* 22 */   final RBIT.RBITImp bits = new RBIT.RBITImp();
/*    */   
/* 24 */   public final D_PlanDrunk drunk = new D_PlanDrunk();
/* 25 */   private final D_PlanDrinkGround ground = new D_PlanDrinkGround(this);
/*    */   
/* 27 */   private final PlansServices plans = new PlansServices((SPlanAbs<?>[])new SPlanAbs[] { new PlanTavern(this) });
/*    */   
/* 29 */   private static CharSequence ¤¤name = "¤drink";
/* 30 */   private static CharSequence ¤¤desc = "¤Consume drink off the ground or in a tavern.";
/*    */   
/*    */   static {
/* 33 */     D.ts(AIModule_Drink.class);
/*    */   }
/*    */   
/* 36 */   public final AISUB subdrink = (AISUB)new AISUB.Simple("subsDrinking")
/*    */     {
/*    */       
/*    */       protected AISTATE resume(Humanoid a, AIManager d)
/*    */       {
/* 41 */         d.subByte = (byte)(d.subByte + 1);
/* 42 */         switch (d.subByte) { case 1:
/* 43 */             return (AI.STATES()).STAND.activate(a, d, (2.0F + RND.rFloat(4.0D)));
/* 44 */           case 2: return (AI.STATES()).anima.fist.activate(a, d, 1.5D);
/* 45 */           case 3: return (AI.STATES()).STAND.activate(a, d, (2.0F + RND.rFloat(4.0D)));
/* 46 */           case 4: return (AI.STATES()).anima.fist.activate(a, d, 1.5D);
/* 47 */           case 5: return (AI.STATES()).STAND.activate(a, d, (2.0F + RND.rFloat(4.0D)));
/* 48 */           case 6: return (AI.STATES()).anima.fist.activate(a, d, 1.5D);
/* 49 */           case 7: return (AI.STATES()).STAND.activate(a, d, (2.0F + RND.rFloat(4.0D)));
/* 50 */           case 8: return (AI.STATES()).anima.fist.activate(a, d, 1.5D); }
/*    */         
/* 52 */         return null;
/*    */       }
/*    */     };
/*    */ 
/*    */ 
/*    */   
/*    */   public AIModule_Drink() {
/* 59 */     super((SPRITE)(UI.icons()).s.jug, ¤¤name, ¤¤desc);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/* 65 */     this.need.stat().fixMax(a.indu());
/* 66 */     AIPLAN.AiPlanActivation p = this.plans.getPlan(a, d);
/* 67 */     if (p != null)
/* 68 */       return p; 
/* 69 */     p = this.ground.activate(a, d);
/* 70 */     if (p == null) {
/* 71 */       STATS.FOOD().drink(a, 0, 0.0D);
/*    */     }
/* 73 */     return p;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int updateI) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public int getPriority(Humanoid a, AIManager d) {
/* 84 */     int prio = this.need.stat().getPrio(a);
/*    */     
/* 86 */     if (prio == 0) {
/* 87 */       return 0;
/*    */     }
/* 89 */     return 4;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\AIModule_Drink.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */