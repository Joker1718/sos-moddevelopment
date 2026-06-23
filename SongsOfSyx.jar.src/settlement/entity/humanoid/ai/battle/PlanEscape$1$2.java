/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 198 */     if (!d.path.request(a, (a.division()).reporter.getTile(a).x(), (a.division()).reporter.getTile(a).y())) {
/* 199 */       return PlanEscape.null.this.fail.set(a, d);
/*     */     }
/* 201 */     return nextTile(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   private AISUB.AISubActivation nextTile(Humanoid a, AIManager d) {
/* 206 */     if ((a.division()).reporter.getTile(a).tileDistanceTo(d.path.destX(), d.path.destY()) > 2.0D) {
/* 207 */       return PlanEscape.null.this.init(a, d);
/*     */     }
/* 209 */     if (COORDINATE.tileDistance(a.body().cX(), a.body().cY(), d.path().getSettCX(), d.path().getSettCY()) < 16.0D) {
/* 210 */       if (d.path.hasNext()) {
/* 211 */         d.path.setNext();
/*     */       } else {
/* 213 */         return PlanEscape.null.this.fail.set(a, d);
/*     */       } 
/*     */     }
/* 216 */     if (!d.path.isSuccessful()) {
/* 217 */       return PlanEscape.null.this.fail.set(a, d);
/*     */     }
/* 219 */     AISTATE s = (AI.STATES()).PUSH_TO.move(a, d, d.path.getSettCX(), d.path.getSettCY(), 0.5D + RND.rFloat0(0.5D), 0.75D);
/* 220 */     return (AI.SUBS()).single.activate(a, d, s);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 225 */     if (!BattleUtil.shouldMoveIntoDivPosition(a, d))
/* 226 */       return null; 
/* 227 */     return nextTile(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 232 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 242 */     if (e.event == HEvent.MEET_ENEMY) {
/* 243 */       if (e.speedHasChanged)
/* 244 */         a.speed.setPrevDir(); 
/* 245 */       return true;
/*     */     } 
/*     */     
/* 248 */     if (e.event == HEvent.COLLISION_SOFT) {
/* 249 */       a.speed.setPrevDir();
/* 250 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 254 */     return InterBattle.listener.event(a, d, e);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\PlanEscape$1$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */