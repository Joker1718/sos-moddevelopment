/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import game.battle.div.Div;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class AIModule_Battle
/*     */   extends AIModule {
/*  19 */   private final AIPLAN march = (AIPLAN)new MarchPlan("BattleMarch");
/*  20 */   private final ManPlan planMan = new ManPlan("BattleMan");
/*  21 */   final PlanEscape escape = new PlanEscape();
/*  22 */   final MarchSubCutTo subCutTo = new MarchSubCutTo();
/*  23 */   final SubFight fight = new SubFight("battleFight");
/*  24 */   final MarchSoftCollision subSoft = new MarchSoftCollision();
/*  25 */   final PlanAttackTile tile = new PlanAttackTile("BAttleTile");
/*  26 */   final AIPLAN dessert = (AIPLAN)new PlanRout("BattleRout");
/*     */   
/*  28 */   public final SoundRace soundSword = AUDIO.race("SWORD");
/*     */   
/*  30 */   private static CharSequence ¤¤name = "Battle";
/*  31 */   private static CharSequence ¤¤desc = "Joining of mustered divisions and fighting.";
/*     */   static {
/*  33 */     D.ts(AIModule_Battle.class);
/*     */   }
/*     */   
/*     */   public AIModule_Battle() {
/*  37 */     super((SPRITE)(UI.icons()).s.sword, ¤¤name, ¤¤desc);
/*     */   }
/*     */ 
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/*  42 */     if ((STATS.BATTLE()).ROUTING.indu().get(a.indu()) == 1) {
/*  43 */       return this.dessert.activate(a, d);
/*     */     }
/*     */     
/*  46 */     if (a.indu().hostile()) {
/*  47 */       AIPLAN.AiPlanActivation p = this.march.activate(a, d);
/*  48 */       if (p == null)
/*  49 */         return this.planMan.activate(a, d); 
/*  50 */       return p;
/*     */     } 
/*     */     
/*  53 */     Div div = a.division();
/*  54 */     if (div != null) {
/*     */       
/*  56 */       AIPLAN.AiPlanActivation p = this.march.activate(a, d);
/*  57 */       if (p != null)
/*  58 */         return p; 
/*     */     } 
/*  60 */     return this.planMan.activate(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation fight(Humanoid a, AIManager d, ENTITY h) {
/*  65 */     d.otherEntitySet((Humanoid)h);
/*  66 */     return this.fight.activate(a, d);
/*     */   }
/*     */   
/*     */   public boolean breakTile(Humanoid a, AIManager d, int tx, int ty) {
/*  70 */     if (this.tile.shouldattackTile(d, a, tx, ty)) {
/*  71 */       this.tile.init(d, a, tx, ty);
/*  72 */       d.overwrite(a, (AIPLAN)this.tile);
/*  73 */       return true;
/*     */     } 
/*  75 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public AIPLAN interrrupt(Humanoid a, AIManager d) {
/*  80 */     return this.march;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(Humanoid a, AIManager ds, boolean newDay, int byteDelta, int updateI) {
/*  86 */     if (a.division() != null)
/*     */     {
/*  88 */       if ((a.division()).info.men() < a.division().men()) {
/*  89 */         (STATS.BATTLE()).DIV.set(a, null);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPriority(Humanoid a, AIManager ds) {
/* 101 */     if ((STATS.BATTLE()).ROUTING.indu().get(a.indu()) == 1) {
/* 102 */       return 11;
/*     */     }
/* 104 */     if (a.indu().hostile()) {
/* 105 */       return 11;
/*     */     }
/* 107 */     Div d = a.division();
/* 108 */     if (d != null && d.settings().mustering() && d.deployed() > 0) {
/* 109 */       return 9;
/*     */     }
/*     */     
/* 112 */     if (this.planMan.shouldMan(a, ds)) {
/* 113 */       return 8;
/*     */     }
/*     */     
/* 116 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\AIModule_Battle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */