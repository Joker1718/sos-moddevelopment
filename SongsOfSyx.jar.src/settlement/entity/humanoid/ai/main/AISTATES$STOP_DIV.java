/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.spirte.HSprite;
/*     */ import settlement.entity.humanoid.spirte.HSprites;
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
/*     */ public class STOP_DIV
/*     */ {
/*     */   private final AISTATE state;
/* 214 */   private final double max = 65536.0D;
/*     */   
/*     */   public STOP_DIV(String key, final HSprite s) {
/* 217 */     this.state = new AISTATE(key, "stopping div")
/*     */       {
/*     */         public HSprite sprite(Humanoid a)
/*     */         {
/* 221 */           return (a.speed.magnitude() >= a.speed.magintudeMax()) ? HSprites.LAY : s;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean update(Humanoid a, AIManager d, double ds) {
/* 227 */           if (a.speed.isZero()) {
/* 228 */             d.stateTimer = (float)(d.stateTimer - ds);
/* 229 */             return (d.stateTimer > 0.0F);
/*     */           } 
/*     */           
/* 232 */           if (!AISTATES.STOP_DIV.this.goingTowardsDiv(a, d))
/* 233 */             a.speed.brake(ds); 
/* 234 */           return true;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean goingTowardsDiv(Humanoid a, AIManager d) {
/* 241 */     Div div = a.division();
/* 242 */     if (div != null)
/*     */     {
/* 244 */       if (div.reporter.posHas(a)) {
/* 245 */         COORDINATE dest = div.reporter.getPixel(a);
/* 246 */         double dx = (dest.x() - a.body().cX());
/* 247 */         double dy = (dest.y() - a.body().cY());
/*     */ 
/*     */ 
/*     */         
/* 251 */         if (dx * dx + dy * dy < 65536.0D && 
/* 252 */           dx * a.speed.nX() >= 0.0D && dy * a.speed.nY() >= 0.0D) {
/* 253 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 258 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AISTATE activate(Humanoid a, AIManager d, double time) {
/* 285 */     d.stateTimer = (float)time;
/* 286 */     a.speed.magnitudeTargetSet(0.0D);
/*     */     
/* 288 */     return this.state;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISTATES$STOP_DIV.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */