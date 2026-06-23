/*     */ package world.region;
/*     */ 
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.Growable;
/*     */ import init.resources.RESOURCES;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import snake2d.util.MATH;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RDResource
/*     */   extends RDOutputs.RDOutput
/*     */ {
/*     */   public final TRADABLE res;
/*     */   private final Growable g;
/*     */   
/*     */   RDResource(RD.RDInit init, TRADABLE res) {
/* 157 */     super(BOOSTING.push("PRODUCTION_" + res.key(), 0.0D, String.valueOf(Dic.¤¤Production) + ": " + String.valueOf(Dic.¤¤Production), res.desc, res.icon(), (BoostableCat.ALL()).WORLD_PRODUCTION), init);
/* 158 */     this.res = res;
/*     */     
/* 160 */     this.g = g(res);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Growable g(TRADABLE t) {
/* 166 */     for (Growable g : RESOURCES.growable().all()) {
/* 167 */       if (TR.get(g.resource) == t)
/* 168 */         return g; 
/*     */     } 
/* 170 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int daysUntilDailydelivery() {
/* 176 */     if (this.g != null) {
/* 177 */       int d = (int)(this.g.seasonalOffset * TIME.years().bitConversion((TIMECYCLE)TIME.days()));
/* 178 */       int now = TIME.days().bitsSinceStart() % (int)TIME.years().bitConversion((TIMECYCLE)TIME.days());
/* 179 */       int remain = MATH.ETA(now, d, (int)TIME.years().bitConversion((TIMECYCLE)TIME.days()));
/* 180 */       return remain;
/*     */     } 
/*     */ 
/*     */     
/* 184 */     return super.daysUntilDailydelivery();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDOutputs$RDResource.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */