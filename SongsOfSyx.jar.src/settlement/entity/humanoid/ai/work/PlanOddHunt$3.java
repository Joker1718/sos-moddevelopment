/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.thing.ThingsCadavers;
/*     */ import snake2d.util.datatypes.DIR;
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
/*     */ class null
/*     */   extends PlanOddHunt.HResumer
/*     */ {
/*     */   null(PlanOddHunt paramPlanOddHunt2, AIPLAN.PLANRES $anonymous0) {
/* 187 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 191 */     ThingsCadavers.Cadaver prey = PlanOddHunt.this.getCadaver(a, d);
/*     */     
/* 193 */     if (prey == null) {
/* 194 */       can(a, d);
/* 195 */       return null;
/*     */     } 
/* 197 */     a.speed.setDirCurrent(DIR.get(a.tc(), prey.ctx(), prey.cty()));
/* 198 */     if (prey.resHas()) {
/* 199 */       RESOURCE r = prey.resRemove();
/* 200 */       (SETT.THINGS()).resources.create(prey.ctx(), prey.cty(), r, 1);
/* 201 */       FACTIONS.player().res().inc(r, FResources.RTYPE.PRODUCED, 1);
/*     */     } 
/*     */     
/* 204 */     if (prey.resHas()) {
/* 205 */       PlanOddHunt.this.sound.rnd(a);
/* 206 */       return (AI.SUBS()).WORK_HANDS.activate(a, d, 5.0D);
/*     */     } 
/* 208 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 215 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 225 */     return (AI.SUBS()).WORK_HANDS.activate(a, d, 12.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\PlanOddHunt$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */