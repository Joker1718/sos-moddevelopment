/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.spirte.HSprite;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PUSH_TOWARDS
/*     */ {
/*     */   private final AISTATE state;
/*     */   
/*     */   public PUSH_TOWARDS(String key, final HSprite sprite) {
/* 392 */     this.state = new AISTATE(key, "pushing")
/*     */       {
/*     */         public HSprite sprite(Humanoid a)
/*     */         {
/* 396 */           return sprite;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean update(Humanoid a, AIManager d, double ds) {
/* 402 */           double dx = (d.X - a.body().cX());
/* 403 */           double dy = (d.Y - a.body().cY());
/* 404 */           if (ds == 0.0D) {
/* 405 */             return true;
/*     */           }
/* 407 */           if (dx == 0.0D && dy == 0.0D) {
/* 408 */             return false;
/*     */           }
/* 410 */           double nx = a.speed.x();
/* 411 */           double ny = a.speed.y();
/* 412 */           double mag = a.speed.magnitude();
/* 413 */           if (mag > 0.0D && (dx * nx < 0.0D || dy * ny < 0.0D)) {
/* 414 */             double m = mag - ds * (256.0D + a.speed.magnitude() * 0.1D);
/* 415 */             if (m < 0.0D) {
/* 416 */               m = 0.0D;
/* 417 */               a.speed.turn2(dx, dy);
/*     */             } 
/* 419 */             a.speed.magnitudeInit(m);
/* 420 */             a.speed.setDirCurrent(DIR.get(dx, dy));
/* 421 */             a.speed.setPrevDir();
/*     */           } else {
/* 423 */             if (same(dx, nx) != same(dy, ny)) {
/* 424 */               a.speed.setPrevDir();
/* 425 */               a.speed.turn2(dx, dy);
/*     */             } 
/*     */             
/* 428 */             a.speed.magnitudeAdjust(ds, 1.0D, 1.0D);
/*     */             
/* 430 */             double ddx = (a.body().cX() - d.X);
/* 431 */             double ddy = (a.body().cY() - d.Y);
/*     */             
/* 433 */             if (ddx * (ddx + Math.ceil(a.speed.x() * ds)) < 0.0D || ddy * (ddy + Math.ceil(a.speed.y() * ds)) < 0.0D) {
/* 434 */               a.physics.body().moveC(d.X, d.Y);
/* 435 */               return false;
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 442 */           d.stateTimer = (float)(d.stateTimer - ds);
/* 443 */           return (d.stateTimer > 0.0F);
/*     */         }
/*     */ 
/*     */         
/*     */         private double same(double dx, double sx) {
/* 448 */           if (dx == sx)
/* 449 */             return 1.0D; 
/* 450 */           if (dx == 0.0D) {
/* 451 */             return ((sx == 0.0D) ? true : false);
/*     */           }
/* 453 */           return dx / sx;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public AISTATE move(Humanoid a, AIManager d, int destX, int destY, double time, double speed) {
/* 460 */     d.X = destX;
/* 461 */     d.Y = destY;
/* 462 */     a.speed.magnitudeTargetSet(speed);
/* 463 */     d.stateTimer = (float)time;
/* 464 */     return this.state;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISTATES$PUSH_TOWARDS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */