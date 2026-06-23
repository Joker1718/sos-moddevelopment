/*     */ package settlement.entity.humanoid.ai.consume;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCES;
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.text.D;
/*     */ 
/*     */ final class D_PlanDrinkGround
/*     */   extends AIPLAN.PLANRES {
/*  20 */   private static CharSequence ¤¤sDrink = "Having a drink"; private final AIModule_Drink m;
/*  21 */   private static final RBIT.RBITImp bi = new RBIT.RBITImp();
/*     */   
/*     */   static {
/*  24 */     D.ts(D_PlanDrinkGround.class);
/*     */   }
/*     */   private final AIPLAN.PLANRES.Resumer walk;
/*     */   private final AIPLAN.PLANRES.Resumer drink;
/*     */   
/*     */   D_PlanDrinkGround(AIModule_Drink m) {
/*  30 */     super("SerDrink");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  45 */     this.walk = new AIPLAN.PLANRES.Resumer(this, ¤¤sDrink)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  49 */           D_PlanDrinkGround.bi.clearSet((RESOURCES.DRINKS()).mask).and(STATS.FOOD().fetchMask(a));
/*  50 */           return (AI.SUBS()).walkTo.resource(a, d, (RBIT)D_PlanDrinkGround.bi);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  57 */           GAME.player().res().inc(d.resourceCarried(), FResources.RTYPE.CONSUMED, -1);
/*  58 */           (NEEDS.TYPES()).THIRST.stat().fix(a.indu());
/*     */           
/*  60 */           (STATS.FOOD()).DRINK.indu().set(a.indu(), 1);
/*     */           
/*  62 */           return D_PlanDrinkGround.this.drink.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  67 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/*  72 */           d.resourceCarriedSet(null);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  77 */     this.drink = new AIPLAN.PLANRES.Resumer(this, ¤¤sDrink)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  81 */           if (RND.rBoolean())
/*  82 */             return (AI.SUBS()).STAND.activateTime(a, d, 1 + RND.rInt(5)); 
/*  83 */           d.resourceCarriedSet(null);
/*  84 */           return D_PlanDrinkGround.this.m.subdrink.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  89 */           d.resourceCarriedSet(null);
/*  90 */           if (RND.rFloat() < (STATS.FOOD()).DRINK.indu().getD(a.indu()))
/*  91 */             return d.resumeOtherPlan(a, (AIPLAN)D_PlanDrinkGround.this.m.drunk); 
/*  92 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  98 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 103 */           d.resourceCarriedSet(null);
/*     */         }
/*     */       };
/*     */     this.m = m;
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     return this.walk.set(a, d);
/*     */   }
/*     */   
/*     */   public boolean has(Humanoid a, AIManager d) {
/*     */     bi.clearSet((RESOURCES.DRINKS()).mask).and(STATS.FOOD().fetchMask(a));
/*     */     return (SETT.PATH()).finders.resource.has(a.tc().x(), a.tc().y(), (RBIT)bi);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\D_PlanDrinkGround.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */