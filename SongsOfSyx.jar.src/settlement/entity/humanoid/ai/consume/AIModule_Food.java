/*     */ package settlement.entity.humanoid.ai.consume;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.resources.RBIT;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.NEEDS;
/*     */ import init.type.NEED_E;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIData;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ 
/*     */ final class AIModule_Food
/*     */   extends AIModule {
/*  23 */   public final NEED_E need = (NEEDS.TYPES()).HUNGER;
/*  24 */   private final AIData.AIDataSuspender suspenderStarvation = AI.suspender("starve");
/*  25 */   private final AIData.AIDataSuspender suspenderService = AI.suspender("food_service");
/*  26 */   private final AIData.AIDataSuspender suspenderFind = AI.suspender("foodfind");
/*     */   
/*  28 */   final RBIT.RBITImp bits = new RBIT.RBITImp();
/*     */   
/*  30 */   public final AISUB eat = (AISUB)new AISUB.Simple("eating")
/*     */     {
/*     */       
/*     */       protected AISTATE resume(Humanoid a, AIManager d)
/*     */       {
/*  35 */         d.subByte = (byte)(d.subByte + 1);
/*  36 */         switch (d.subByte) { case 1:
/*  37 */             return (AI.STATES()).STAND.activate(a, d, (1.5F + RND.rFloat(4.0D)));
/*  38 */           case 2: return (AI.STATES()).anima.box.activate(a, d, 2.5D + RND.rFloat(2.0D));
/*  39 */           case 3: return (AI.STATES()).STAND.activate(a, d, (1.5F + RND.rFloat(4.0D)));
/*  40 */           case 4: return (AI.STATES()).anima.box.activate(a, d, 2.5D + RND.rFloat(2.0D)); }
/*     */         
/*  42 */         return null;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private final PlansServices plans;
/*     */   
/*  49 */   private final AIPLAN eatPlan = (AIPLAN)new F_PlanEat(this.eat);
/*  50 */   private final AIPLAN starve = (AIPLAN)new F_PlanStarve(this.eat, this.suspenderStarvation);
/*     */   
/*  52 */   private static CharSequence ¤¤name = "¤eat";
/*  53 */   private static CharSequence ¤¤desc = "¤Find food"; int dayI;
/*     */   
/*     */   static {
/*  56 */     D.ts(AIModule_Food.class);
/*     */   }
/*     */   int am;
/*     */   public AIModule_Food() {
/*  60 */     super((SPRITE)(UI.icons()).s.plate, ¤¤name, ¤¤desc);
/*     */ 
/*     */ 
/*     */     
/*  64 */     this.dayI = -1;
/*  65 */     this.am = 0;
/*     */     this.plans = new PlansServices((SPlanAbs<?>[])new SPlanAbs[] { new F_SPlanCanteen(this.eat), new F_SPlanEatery(this.eat) });
/*     */   }
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/*  70 */     if (this.dayI != TIME.days().bitsSinceStart()) {
/*  71 */       this.dayI = TIME.days().bitsSinceStart();
/*     */     }
/*     */ 
/*     */     
/*  75 */     this.am++;
/*     */     
/*  77 */     if (!this.suspenderService.is(d)) {
/*  78 */       AIPLAN.AiPlanActivation p = this.plans.getPlan(a, d);
/*  79 */       if (p == null) {
/*  80 */         this.suspenderService.suspend(d);
/*     */       } else {
/*  82 */         return p;
/*     */       } 
/*     */     } 
/*  85 */     int prio = this.need.stat().getPrio(a);
/*     */     
/*  87 */     if (prio >= 2 || !this.plans.worthTrying(a, d)) {
/*  88 */       if (!this.suspenderFind.is(d)) {
/*  89 */         AIPLAN.AiPlanActivation p = this.eatPlan.activate(a, d);
/*  90 */         if (p == null) {
/*  91 */           this.suspenderFind.suspend(d);
/*     */         } else {
/*  93 */           return p;
/*     */         } 
/*     */       } 
/*  96 */       if ((STATS.FOOD()).STARVATION.indu().getD(a.indu()) > 0.0D) {
/*  97 */         return this.starve.activate(a, d);
/*     */       }
/*     */     } 
/*     */     
/* 101 */     this.am--;
/*     */     
/* 103 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int updateI) {
/* 108 */     this.suspenderStarvation.update(d);
/* 109 */     this.suspenderFind.update(d);
/* 110 */     this.suspenderService.update(d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPriority(Humanoid a, AIManager d) {
/* 116 */     if ((STATS.FOOD()).STARVATION.indu().getD(a.indu()) > 0.0D)
/* 117 */       return 10; 
/* 118 */     int p = this.need.stat().getPrio(a);
/* 119 */     if (p == 0)
/* 120 */       return 0; 
/* 121 */     if (this.suspenderFind.is(d) && this.suspenderService.is(d)) {
/* 122 */       return 0;
/*     */     }
/* 124 */     if (p == 1) {
/* 125 */       return 4;
/*     */     }
/* 127 */     return 6;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\AIModule_Food.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */