/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   private final AISUB sub;
/*     */   
/*     */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 227 */     super(paramPLANRES, $anonymous0);
/*     */     
/* 229 */     this.sub = (AISUB)new AISUB.Simple("MarchPath")
/*     */       {
/*     */         protected AISTATE resume(Humanoid a, AIManager d) {
/* 232 */           d.subByte = (byte)(d.subByte + 1);
/* 233 */           if (d.subByte == 1) {
/* 234 */             Div div = a.division();
/* 235 */             if ((div.settings()).running) {
/* 236 */               return (AI.STATES()).RUN2.path(a, d);
/*     */             }
/* 238 */             return (AI.STATES()).WALK2.path(a, d);
/*     */           } 
/*     */           
/* 241 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 246 */           return InterBattle.listener.event(a, d, e);
/*     */         }
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 251 */           return InterBattle.listener.poll(a, d, e);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 259 */     Div div = a.division();
/* 260 */     if (div.deployed() == 0)
/* 261 */       return MarchPlan.this.waitForSpot.set(a, d); 
/* 262 */     if (!div.reporter.posHas(a)) {
/* 263 */       return null;
/*     */     }
/* 265 */     COORDINATE c = div.reporter.getDestTile(a);
/* 266 */     int sx = c.x();
/* 267 */     int sy = c.y();
/* 268 */     COORDINATE dest = (SETT.PATH()).finders.arround.find(sx, sy, 0.0D, 15.0D);
/* 269 */     if (dest == null)
/* 270 */       return null; 
/* 271 */     d.planByte1 = 0;
/* 272 */     d.path.request(a.physics.tileC(), dest.x(), dest.y());
/* 273 */     if (!d.path.isSuccessful()) {
/* 274 */       return null;
/*     */     }
/* 276 */     return res(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 281 */     if (!d.path.isSuccessful())
/* 282 */       return null; 
/* 283 */     if (d.path.isDest()) {
/* 284 */       return MarchPlan.this.waitInDestination.set(a, d);
/*     */     }
/* 286 */     d.path.setNext();
/* 287 */     Div div = a.division();
/* 288 */     if (!div.reporter.posHas(a))
/* 289 */       return null; 
/* 290 */     COORDINATE c = div.reporter.getDestTile(a);
/* 291 */     int tx = c.x();
/* 292 */     int ty = c.y();
/* 293 */     if (COORDINATE.tileDistance(tx, ty, d.path.destX(), d.path.destY()) > 15.0D) {
/* 294 */       return MarchPlan.this.retry(a, d);
/*     */     }
/* 296 */     d.planByte1 = (byte)(d.planByte1 + 1);
/* 297 */     if (d.planByte1 == 5) {
/* 298 */       c = div.reporter.getTile(a);
/* 299 */       if (c != null && SETT.PATH().isInTheNeighbourhood(c.x(), c.y(), a.physics.tileC().x(), a.physics.tileC().y())) {
/*     */         
/* 301 */         a.speed.magnitudeInit(0.0D);
/* 302 */         return MarchPlan.this.pathToPosition.set(a, d);
/*     */       } 
/* 304 */       d.planByte1 = 0;
/*     */     } 
/*     */     
/* 307 */     return this.sub.activate(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 312 */     return MarchPlan.this.conn(a, d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 324 */     return InterBattle.listener.event(a, d, e);
/*     */   }
/*     */ 
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 329 */     return InterBattle.listener.poll(a, d, e);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\MarchPlan$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */