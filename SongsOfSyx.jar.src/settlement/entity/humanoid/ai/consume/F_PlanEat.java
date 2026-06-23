/*    */ package settlement.entity.humanoid.ai.consume;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.FResources;
/*    */ import init.resources.RBIT;
/*    */ import init.resources.RESOURCES;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.stats.STATS;
/*    */ import util.text.D;
/*    */ 
/*    */ final class F_PlanEat
/*    */   extends AIPLAN.PLANRES
/*    */ {
/*    */   private final AISUB sub;
/* 19 */   private static CharSequence ¤¤name = "Finding food"; private final AIPLAN.PLANRES.Resumer fetchRaw;
/*    */   
/*    */   static {
/* 22 */     D.ts(F_PlanEat.class);
/*    */   }
/*    */   private final AIPLAN.PLANRES.Resumer eat;
/*    */   public F_PlanEat(AISUB sub) {
/* 26 */     super("SerEat");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 36 */     this.fetchRaw = new AIPLAN.PLANRES.Resumer(this, ¤¤name)
/*    */       {
/* 38 */         final RBIT.RBITImp bits = new RBIT.RBITImp();
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 42 */           this.bits.clearSet((RESOURCES.EDI()).mask);
/* 43 */           if ((STATS.FOOD()).STARVATION.indu().get(a.indu()) <= 0) {
/* 44 */             this.bits.and(STATS.FOOD().fetchMask(a));
/*    */           }
/* 46 */           return (AI.SUBS()).walkTo.resource(a, d, (RBIT)this.bits, 2147483647);
/*    */         }
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 51 */           STATS.FOOD().eat(a, 1, 0.0D);
/* 52 */           return F_PlanEat.this.eat.set(a, d);
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 57 */           return true;
/*    */         }
/*    */ 
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {
/* 62 */           d.resourceCarriedSet(null);
/*    */         }
/*    */       };
/*    */     
/* 66 */     this.eat = new AIPLAN.PLANRES.Resumer(this, ¤¤name)
/*    */       {
/*    */         public AISUB.AISubActivation res(Humanoid a, AIManager d)
/*    */         {
/* 70 */           if (d.resourceCarried() != null && RESOURCES.EDI().is(d.resourceCarried())) {
/* 71 */             FACTIONS.player().res().inc(d.resourceCarried(), FResources.RTYPE.CONSUMED, -1);
/*    */           }
/* 73 */           d.resourceCarriedSet(null);
/* 74 */           return null;
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 79 */           return true;
/*    */         }
/*    */ 
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {
/* 84 */           d.resourceCarriedSet(null);
/*    */         }
/*    */ 
/*    */         
/*    */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 89 */           return F_PlanEat.this.sub.activate(a, d);
/*    */         }
/*    */       };
/*    */     this.sub = sub;
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*    */     return this.fetchRaw.set(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\F_PlanEat.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */