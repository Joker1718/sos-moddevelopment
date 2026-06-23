/*     */ package settlement.entity.humanoid.ai.types.guard;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SCompNLevel;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.components.SComponentEdge;
/*     */ import settlement.room.law.guard.GuardInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class AIModule_Guard
/*     */   extends AIModule {
/*     */   private final PlanWork guard;
/*     */   private final PlanGear gear;
/*     */   private final PlanPatrol patrol;
/*     */   private final PlanMop mop;
/*  27 */   private final PlanExecute execute = new PlanExecute();
/*     */   
/*  29 */   private static CharSequence ¤¤name = "Guard";
/*  30 */   private static CharSequence ¤¤desc = "Guard duty.";
/*     */   static {
/*  32 */     D.ts(AIModule_Guard.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public AIModule_Guard() {
/*  37 */     super((SPRITE)(UI.icons()).s.clock, ¤¤name, ¤¤desc);
/*  38 */     this.guard = new PlanWork();
/*  39 */     this.gear = new PlanGear();
/*  40 */     this.patrol = new PlanPatrol();
/*  41 */     this.mop = new PlanMop();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/*  47 */     AIPLAN.AiPlanActivation p = this.gear.activate(a, d);
/*     */     
/*  49 */     if (p != null) {
/*  50 */       return p;
/*     */     }
/*  52 */     p = this.execute.activate(a, d);
/*     */     
/*  54 */     if (p != null) {
/*  55 */       return p;
/*     */     }
/*  57 */     if ((SETT.ROOMS()).GUARD.emp.employ(a)) {
/*  58 */       (AI.modules()).work.swapInstance(a);
/*  59 */       p = this.guard.activate(a, d);
/*  60 */       if (p != null) {
/*  61 */         return p;
/*     */       }
/*     */     } 
/*  64 */     Humanoid c = (SETT.ROOMS()).GUARD.reporter.pollCriminal(null);
/*  65 */     if (c != null) {
/*  66 */       p = AI.listeners().catchCriminal(c).activate(a, d);
/*  67 */       if (p != null) {
/*  68 */         return p;
/*     */       }
/*     */     } 
/*  71 */     p = this.patrol.activate(a, d);
/*  72 */     if (p != null) {
/*  73 */       return p;
/*     */     }
/*  75 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void init(Humanoid a, AIManager d, HTYPE prev, HTYPE current) {}
/*     */ 
/*     */   
/*     */   public static boolean shouldBe(Humanoid a) {
/*  84 */     Div div = (Div)(STATS.BATTLE()).DIV.get(a);
/*  85 */     if (div != null && (SETT.ROOMS()).GUARD.activeDuty.is(div))
/*  86 */       return true; 
/*  87 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPriority(Humanoid a, AIManager d) {
/*  93 */     double w = (STATS.WORK()).WORK_TIME.indu().getD(a.indu());
/*  94 */     if (w >= 1.0D) {
/*  95 */       return 0;
/*     */     }
/*  97 */     if (w < 0.5D) {
/*  98 */       return 4;
/*     */     }
/* 100 */     GuardInstance ins = PlanWork.work(a);
/*     */     
/* 102 */     if (ins != null && ins.hasPotentialSpots()) {
/* 103 */       return 4;
/*     */     }
/*     */     
/* 106 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int updateOfDay) {
/* 112 */     if (hasEnemies(a, d)) {
/* 113 */       d.overwrite(a, (AIPLAN)this.mop);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean hasEnemies(Humanoid a, AIManager d) {
/* 119 */     if (STATS.POP().pop(HTYPES.ENEMY()) == 0 && STATS.POP().pop(HTYPES.RIOTER()) == 0)
/* 120 */       return false; 
/* 121 */     SComponent ss = (SComponent)((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).get(a.tc());
/* 122 */     if (ss == null)
/* 123 */       return false; 
/* 124 */     if ((SETT.PATH()).comps.data.people(a.indu().hostile()).get(ss) > 0)
/* 125 */       return true; 
/* 126 */     SComponentEdge e = ss.edgefirst();
/* 127 */     while (e != null) {
/* 128 */       if ((SETT.PATH()).comps.data.people(a.indu().hostile()).get(e.to()) > 0)
/* 129 */         return true; 
/* 130 */       e = e.next();
/*     */     } 
/* 132 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\guard\AIModule_Guard.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */