/*     */ package settlement.entity.humanoid.ai.consume;
/*     */ 
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISTATES;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ final class D_PlanDrunk
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*  19 */   private static CharSequence ¤¤drunk = "Intoxicated";
/*  20 */   private static CharSequence ¤¤sobering = "Sobering Up"; private final AISUB walk; private final AIPLAN.PLANRES.Resumer walkWeird;
/*     */   
/*     */   static {
/*  23 */     D.ts(D_PlanDrunk.class);
/*     */   }
/*     */   private final AIPLAN.PLANRES.Resumer drink; private final AIPLAN.PLANRES.Resumer sleep;
/*     */   public D_PlanDrunk() {
/*  27 */     super("serDrunk");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  35 */     this.walk = (AISUB)new AISUB.Simple("DRUNK")
/*     */       {
/*     */         protected AISTATE resume(Humanoid a, AIManager d)
/*     */         {
/*  39 */           if (d.subByte == 0) {
/*  40 */             a.speed.turnRandom();
/*  41 */             AISTATE s = (AI.STATES()).WALK.activate(a, d, (4 + RND.rInt(5)));
/*  42 */             a.speed.magnitudeTargetSet(0.2D);
/*  43 */             a.speed.setDirCurrent((DIR)DIR.ALL.rnd());
/*  44 */             d.subByte = 1;
/*  45 */             return s;
/*     */           } 
/*  47 */           a.speed.magnitudeInit(0.0D);
/*  48 */           a.speed.magnitudeTargetSet(0.0D);
/*  49 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/*  54 */           if (e.event == HEvent.COLLISION_TILE) {
/*  55 */             return true;
/*     */           }
/*  57 */           return super.event(a, d, e);
/*     */         }
/*     */       };
/*     */     
/*  61 */     this.walkWeird = new AIPLAN.PLANRES.Resumer(this, ¤¤drunk)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  65 */           return D_PlanDrunk.this.walk.activate(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  71 */           if (RND.rBoolean())
/*  72 */             return setAction(a, d); 
/*  73 */           if (RND.oneIn(4)) {
/*  74 */             return D_PlanDrunk.this.sleep.set(a, d);
/*     */           }
/*  76 */           return D_PlanDrunk.this.drink.set(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  82 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/*  87 */           d.resourceCarriedSet(null);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/*  92 */           if (e.event == HEvent.COLLISION_TILE) {
/*  93 */             return true;
/*     */           }
/*  95 */           return super.event(a, d, e);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 100 */     this.drink = new AIPLAN.PLANRES.Resumer(this, ¤¤drunk)
/*     */       {
/* 102 */         private final AISTATES.Animation[] animi = new AISTATES.Animation[] {
/* 103 */             (AI.STATES()).anima.grab, 
/* 104 */             (AI.STATES()).anima.box, 
/* 105 */             (AI.STATES()).anima.fist, 
/* 106 */             (AI.STATES()).anima.work
/*     */           };
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 111 */           if (RND.rBoolean())
/* 112 */             return (AI.SUBS()).STAND.activateTime(a, d, 1 + RND.rInt(5)); 
/* 113 */           return (AI.SUBS()).single.activate(a, d, this.animi[RND.rInt(this.animi.length)], (RND.rFloat() * 4.0F));
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 118 */           if (RND.oneIn(8))
/* 119 */             return D_PlanDrunk.this.sleep.set(a, d); 
/* 120 */           return setAction(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 126 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 131 */           d.resourceCarriedSet(null);
/*     */         }
/*     */       };
/*     */     
/* 135 */     this.sleep = new AIPLAN.PLANRES.Resumer(this, ¤¤sobering)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 139 */           return (AI.SUBS()).LAY.activateTime(a, d, 20 + RND.rInt(40));
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 144 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 149 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 154 */           d.resourceCarriedSet(null);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     return this.walkWeird.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\D_PlanDrunk.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */