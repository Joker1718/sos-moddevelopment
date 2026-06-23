/*    */ package settlement.entity.humanoid.ai.consume;
/*    */ 
/*    */ import init.resources.RBIT;
/*    */ import init.sprite.UI.UI;
/*    */ import init.type.NEEDS;
/*    */ import init.type.NEED_E;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIModule;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.equip.WearableResource;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.D;
/*    */ 
/*    */ final class AIModule_Shop extends AIModule {
/* 17 */   public final NEED_E need = (NEEDS.TYPES()).SHOPPING;
/* 18 */   final RBIT.RBITImp bits = new RBIT.RBITImp();
/*    */   
/* 20 */   public final M_PlanEquip ground = new M_PlanEquip();
/* 21 */   public final M_PlanReturn ret = new M_PlanReturn();
/* 22 */   private final PlansServices plans = new PlansServices((SPlanAbs<?>[])new SPlanAbs[] { new M_PlanMarket(this) });
/* 23 */   private static CharSequence ¤¤name = "Shopping";
/* 24 */   private static CharSequence ¤¤desc = "Browse the local markets or warehouses for equipment and Furniture.";
/*    */   static {
/* 26 */     D.ts(AIModule_Shop.class);
/*    */   }
/*    */ 
/*    */   
/*    */   AIModule_Shop() {
/* 31 */     super((SPRITE)(UI.icons()).s.storage, ¤¤name, ¤¤desc);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/* 37 */     this.need.stat().fixMax(a.indu());
/*    */ 
/*    */ 
/*    */     
/* 41 */     AIPLAN.AiPlanActivation p = this.ret.activate(a, d);
/* 42 */     if (p != null) {
/* 43 */       return p;
/*    */     }
/* 45 */     p = this.plans.getPlan(a, d);
/* 46 */     if (p == null) {
/* 47 */       return this.ground.activate(a, d);
/*    */     }
/*    */     
/* 50 */     return p;
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
/* 61 */     for (WearableResource e : STATS.EQUIP().BATTLE_ALL()) {
/* 62 */       if (e.needed(a.indu()) < 0) {
/* 63 */         return 2;
/*    */       }
/*    */     } 
/*    */     
/* 67 */     int prio = this.need.stat().getPrio(a);
/*    */     
/* 69 */     if (prio == 0) {
/* 70 */       return 0;
/*    */     }
/* 72 */     return 4;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\AIModule_Shop.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */