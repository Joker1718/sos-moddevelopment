/*     */ package settlement.entity.humanoid.ai.types.recruit;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HTYPE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.military.training.ROOM_M_TRAINER;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ public final class AIModule_Recruit
/*     */   extends AIModule
/*     */ {
/*  22 */   private final PlanBarracks plan = new PlanBarracks(this);
/*  23 */   private final PlanRange range = new PlanRange(this);
/*     */   
/*  25 */   private static CharSequence ¤¤name = "Training";
/*  26 */   private static CharSequence ¤¤desc = "Spend time in a training facility to hone skills";
/*     */   private final double trainingD = 0.0625D;
/*  28 */   static { D.ts(AIModule_Recruit.class); }
/*     */   public boolean canBecome(Humanoid h, AIManager d) { return ((SETT.BATTLE()).info.updateAndGetEmployment(h, null) != null); }
/*     */   public void debugBecome(Humanoid a, AIManager d) {} public void debugRemove(Humanoid a, AIManager d) {} public boolean setEmploy(Humanoid a, AIManager d) { ROOM_M_TRAINER<?> current = current(a); ROOM_M_TRAINER<?> tar = (SETT.BATTLE()).info.updateAndGetEmployment(a, current); if (tar == null) { (STATS.WORK()).EMPLOYED.set(a, null); return false; }
/*     */      if (current != tar) {
/*     */       tar.emp.employ(a); return true;
/*  33 */     }  return true; } public AIModule_Recruit() { super((SPRITE)(UI.icons()).s.shield, ¤¤name, ¤¤desc);
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
/*     */ 
/*     */     
/* 148 */     this.trainingD = 0.0625D; }
/*     */   public void updateNonRecruit(Humanoid a, AIManager d) { Div div = (Div)(STATS.BATTLE()).RECRUIT.get(a); if (div != null) { if (div.info.men() < div.men())
/*     */         (STATS.BATTLE()).RECRUIT.set(a, null);  }
/*     */     else { div = a.division(); if (div != null && div.info.men() < div.men())
/*     */         (STATS.BATTLE()).DIV.set(a, null);  }
/* 153 */      } protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int upI) { RoomInstance r = (RoomInstance)(STATS.WORK()).EMPLOYED.get(a);
/*     */     
/* 155 */     if (r != null && r.blueprint() instanceof ROOM_M_TRAINER)
/* 156 */       ((ROOM_M_TRAINER)r.blueprint()).train(a, r, 0.0625D);  } public boolean shouldRemain(Humanoid a, AIManager d) { ROOM_M_TRAINER<?> current = current(a); ROOM_M_TRAINER<?> tar = (SETT.BATTLE()).info.updateAndGetEmployment(a, current); if (tar == null || tar != current)
/*     */       return false;  return true; }
/*     */   public ROOM_M_TRAINER<?> current(Humanoid a) { RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(a);
/*     */     if (ins != null && ins.blueprintI() instanceof ROOM_M_TRAINER)
/*     */       return (ROOM_M_TRAINER)ins.blueprintI(); 
/*     */     return null; }
/*     */   boolean planShouldContinue(Humanoid a, AIManager d) { return (shouldRemain(a, d) && moduleCanContinue(a, d) && !((RoomInstance)(STATS.WORK()).EMPLOYED.get(a)).employees().isOverstaffed()); }
/* 163 */   public int getPriority(Humanoid a, AIManager d) { return ((STATS.WORK()).WORK_TIME.indu().getD(a.indu()) < 1.0D) ? 4 : 0; }
/*     */ 
/*     */   
/*     */   private boolean reinit(Humanoid a, AIManager d) {
/*     */     (STATS.WORK()).EMPLOYED.set(a, null);
/*     */     setEmploy(a, d);
/*     */     return ((STATS.WORK()).EMPLOYED.get(a) != null);
/*     */   }
/*     */   
/*     */   protected void init(Humanoid a, AIManager d, HTYPE prev, HTYPE current) {
/*     */     if (!setEmploy(a, d))
/*     */       throw new RuntimeException(); 
/*     */   }
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/*     */     if (!planShouldContinue(a, d))
/*     */       reinit(a, d); 
/*     */     (AI.modules()).work.swapInstance(a);
/*     */     RoomInstance w = (RoomInstance)(STATS.WORK()).EMPLOYED.get(a);
/*     */     if (w == null)
/*     */       return null; 
/*     */     if (w.blueprintI() instanceof settlement.room.military.training.barracks.ROOM_BARRACKS)
/*     */       return this.plan.activate(a, d); 
/*     */     if (w.blueprintI() instanceof settlement.room.military.training.archery.ROOM_ARCHERY)
/*     */       return this.range.activate(a, d); 
/*     */     throw new RuntimeException("No logic for: " + String.valueOf(w.blueprintI()));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\recruit\AIModule_Recruit.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */