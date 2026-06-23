/*     */ package world.region;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RDOutput
/*     */ {
/*     */   public final Boostable boost;
/*     */   public final Boostable boostYearlyPart;
/*     */   public final INT_O.INT_OE<Region> yearlyAccumilation;
/*     */   
/*     */   RDOutput(Boostable boost, RD.RDInit init) {
/* 127 */     this.boost = boost;
/* 128 */     this.boostYearlyPart = BOOSTING.push(boost.key.split("WORLD")[1] + "_YEARLY", 0.0D, boost.name, RDOutputs.¤¤taxD, (SPRITE)boost.icon, (BoostableCat.ALL()).WORLD_DUMP);
/* 129 */     this.yearlyAccumilation = (INT_O.INT_OE<Region>)new DataO.DataInt(init.count, boost.key + "_ACC");
/*     */   }
/*     */   
/*     */   public int getDelivery(Region reg) {
/* 133 */     return (int)(this.boost.get((BOOSTABLE_O)reg) + this.boostYearlyPart.get((BOOSTABLE_O)reg));
/*     */   }
/*     */   
/*     */   public int loot(Region reg) {
/* 137 */     double d = 1.0D - (RD.DEVASTATION()).current.getD(reg);
/*     */     
/* 139 */     return (int)(d * (this.boost.get((BOOSTABLE_O)reg) + this.yearlyAccumilation.get(reg)));
/*     */   }
/*     */   
/*     */   public int daysUntilDailydelivery() {
/* 143 */     int d = 0;
/* 144 */     int now = TIME.days().bitsSinceStart() % (int)TIME.years().bitConversion((TIMECYCLE)TIME.days());
/* 145 */     int remain = MATH.ETA(now, d, (int)TIME.years().bitConversion((TIMECYCLE)TIME.days()));
/* 146 */     return remain;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDOutputs$RDOutput.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */