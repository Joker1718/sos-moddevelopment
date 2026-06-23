/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.thing.ThingsCadavers;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.sets.Tuple;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 147 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 153 */     return (PlanOddHunt.this.getCadaver(a, d) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 163 */     ThingsCadavers.Cadaver c = PlanOddHunt.this.getPrey(a, d).slaugher();
/*     */     
/* 165 */     if (c != null) {
/* 166 */       d.planObject = c.index();
/* 167 */       Tuple<COORDINATE, RESOURCE> coo = (SETT.PATH()).finders.storage.reserve(a.tc().x(), a.tc().y(), (c.spec()).rBit, 2147483647);
/* 168 */       if (coo == null)
/* 169 */         return PlanOddHunt.this.butcher.set(a, d); 
/* 170 */       d.planTile.set((COORDINATE)coo.a());
/* 171 */       (SETT.PATH()).finders.storage.cancelReservation((COORDINATE)d.planTile, ((RESOURCE)coo.b()).bIndex());
/* 172 */       AISUB.AISubActivation ac = (AI.SUBS()).walkTo.drag(a, d, (SETT.THINGS()).cadavers.draggable, c.index(), (COORDINATE)d.planTile);
/* 173 */       if (ac != null)
/* 174 */         return ac; 
/* 175 */       return PlanOddHunt.this.butcher.set(a, d);
/*     */     } 
/* 177 */     can(a, d);
/* 178 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 183 */     return PlanOddHunt.this.butcher.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\PlanOddHunt$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */