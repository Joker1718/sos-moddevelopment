/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RES_AMOUNT;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.food.cannibal.CannibalInstance;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.thing.ThingsCorpses;
/*     */ import snake2d.util.datatypes.COORDINATE;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends AIPLAN.PLANRES.Resumer
/*     */ {
/*     */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 193 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 198 */     ThingsCorpses.Corpse prey = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 199 */     if (prey == null) {
/* 200 */       can(a, d);
/* 201 */       return null;
/*     */     } 
/*     */     
/* 204 */     produce(prey, a, d);
/*     */     
/* 206 */     if (prey.isRemoved()) {
/* 207 */       can(a, d);
/* 208 */       return null;
/*     */     } 
/* 210 */     WorkCannibal.this.b.employment().sound().rnd(a);
/* 211 */     return (AI.SUBS()).WORK_HANDS.activate(a, d, 5.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void produce(ThingsCorpses.Corpse corpse, Humanoid a, AIManager d) {
/* 217 */     (SETT.ROOMS()).CANNIBAL.reportCannibal(corpse.race());
/*     */     
/* 219 */     if (corpse.resLeft() <= 0.0D) {
/* 220 */       if (corpse.indu().race().resources().size() > 0) {
/* 221 */         RES_AMOUNT rr = (RES_AMOUNT)corpse.indu().race().resources().rnd();
/* 222 */         produce(rr.resource(), 1, a, d);
/*     */       } 
/* 224 */       corpse.remove();
/*     */       
/*     */       return;
/*     */     } 
/* 228 */     double dd = corpse.resLeft();
/* 229 */     if (dd > 0.25D) {
/* 230 */       dd = 0.25D;
/*     */     }
/* 232 */     for (RES_AMOUNT rr : corpse.indu().race().resources()) {
/* 233 */       int am = (int)(1.0D + rr.amount() * dd);
/* 234 */       produce(rr.resource(), am, a, d);
/*     */     } 
/*     */     
/* 237 */     (STATS.NEEDS()).INJURIES.COUNT.indu().incD(corpse.indu(), 0.1D);
/* 238 */     corpse.resRemove();
/*     */     
/* 240 */     if (corpse.resLeft() <= 0.0D) {
/* 241 */       corpse.remove();
/*     */     }
/*     */   }
/*     */   
/*     */   private void produce(RESOURCE res, int am, Humanoid a, AIManager d) {
/* 246 */     CannibalInstance in = (CannibalInstance)WorkCannibal.work(a);
/* 247 */     int kk = in.produce(res, am);
/*     */     
/* 249 */     in.gore((COORDINATE)d.planTile);
/*     */     
/* 251 */     DIR dd = a.speed.dir().next((kk == 0) ? -1 : 1);
/* 252 */     (SETT.THINGS()).resources.create(a.tc().x() + dd.x(), a.tc().y() + dd.y(), res, am);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 258 */     CannibalInstance in = (CannibalInstance)WorkCannibal.work(a);
/* 259 */     if (in == null)
/* 260 */       return false; 
/* 261 */     if (in.getWork((COORDINATE)d.planTile) == null || !in.getWork((COORDINATE)d.planTile).jobReservedIs(null))
/* 262 */       return false; 
/* 263 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 268 */     ThingsCorpses.Corpse prey = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 269 */     if (prey != null) {
/* 270 */       prey.findableReserveCancel();
/* 271 */       d.planObject = -1;
/*     */     } 
/* 273 */     CannibalInstance in = (CannibalInstance)WorkCannibal.work(a);
/* 274 */     if (in == null)
/*     */       return; 
/* 276 */     if (in.getWork((COORDINATE)d.planTile) == null || !in.getWork((COORDINATE)d.planTile).jobReservedIs(null))
/*     */       return; 
/* 278 */     in.getWork((COORDINATE)d.planTile).jobReserveCancel(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 283 */     ThingsCorpses.Corpse prey = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 284 */     prey.drag(DIR.N, d.planTile.x() * 64 + 32, d.planTile.y() * 64 + 32, 0);
/* 285 */     CannibalInstance in = (CannibalInstance)WorkCannibal.work(a);
/* 286 */     in.resetGore((COORDINATE)d.planTile);
/* 287 */     return (AI.SUBS()).WORK_HANDS.activate(a, d, 12.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkCannibal$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */