/*    */ package settlement.entity.humanoid.ai.home;
/*    */ 
/*    */ import init.resources.RBIT;
/*    */ import init.resources.RESOURCE;
/*    */ import init.resources.RESOURCES;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIModules;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.equip.WearableResource;
/*    */ import util.text.D;
/*    */ 
/*    */ final class PlanReturn
/*    */   extends AIPLAN.PLANRES {
/* 20 */   private static CharSequence ¤¤sName = "Returning Furniture"; private final RBIT.RBITImp bits; final AIPLAN.PLANRES.Resumer walk;
/*    */   
/*    */   static {
/* 23 */     D.ts(PlanReturn.class);
/*    */   }
/*    */   
/*    */   public PlanReturn() {
/* 27 */     super("SerHomeEquip");
/*    */ 
/*    */     
/* 30 */     this.bits = new RBIT.RBITImp();
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
/* 60 */     this.walk = new AIPLAN.PLANRES.Resumer(this, ¤¤sName)
/*    */       {
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 64 */           return (AI.SUBS()).walkTo.depositInited(a, d, (RESOURCE)RESOURCES.ALL().get(d.planByte1));
/*    */         }
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 69 */           if (AIModules.current(d).moduleCanContinue(a, d)) {
/* 70 */             return PlanReturn.this.init(a, d);
/*    */           }
/* 72 */           return null;
/*    */         }
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d)
/*    */         {
/* 77 */           return true;
/*    */         }
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {}
/*    */       };
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void remOne(Humanoid a, AIManager d, RESOURCE res) {
/* 90 */     for (WearableResource e : STATS.HOME().getTmp(a.indu())) {
/* 91 */       if (e.needed(a.indu()) < 0 && e.resource(a.indu()) == res) {
/* 92 */         e.inc(a.indu(), -1); return;
/*    */       } 
/*    */     } 
/*    */   } protected AISUB.AISubActivation init(Humanoid a, AIManager d) { Induvidual i = a.indu(); this.bits.clear(); for (WearableResource e : STATS.HOME().getTmp(i)) { if (e.needed(i) < 0)
/*    */         this.bits.or(e.resource(i));  }
/*    */      if (this.bits.isClear())
/*    */       return null;  RESOURCE res = (SETT.PATH()).finders.storage.reserve(a.tc(), (RBIT)this.bits, d.path, 200); if (res == null) { dump(a, d); return null; }
/* 99 */      d.planByte1 = res.bIndex(); remOne(a, d, res); return this.walk.set(a, d); } private void dump(Humanoid a, AIManager d) { STATS.HOME().dump(a); }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\home\PlanReturn.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */