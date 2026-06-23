/*     */ package game.faction.royalty;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.race.Race;
/*     */ import init.religion.Religion;
/*     */ import init.trade.TRADABLE;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsReligion;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.updating.RealmBuilder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements RealmBuilder
/*     */ {
/*     */   public double priority(Religion religion, Region reg) {
/*  91 */     if (((StatsReligion.StatReligion)(STATS.RELIGION()).getter.get((King.this.roy()).induvidual)).religion == religion)
/*  92 */       return 1.0D; 
/*  93 */     return (BOOSTABLES.NOBLE()).TOLERANCE.get((BOOSTABLE_O)(King.this.roy()).induvidual);
/*     */   }
/*     */ 
/*     */   
/*     */   public double priority(TRADABLE res, Region reg) {
/*  98 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double policy(Race race, Region reg) {
/* 103 */     double add = (BOOSTABLES.NOBLE()).TOLERANCE.get((BOOSTABLE_O)(King.this.roy()).induvidual) - 1.0D;
/* 104 */     if (race == (King.this.roy()).induvidual.race())
/* 105 */       return (4 * (RD.RACES()).all.size()) - add * (RD.RACES()).all.size(); 
/* 106 */     return -1.0D + (King.this.roy()).induvidual.race().pref().race(race) + add;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double military(Region reg) {
/* 114 */     double ran = RD.RAN().get(reg, 9, 8) / 255.0D;
/* 115 */     double v = 0.75D + (BOOSTABLES.NOBLE()).AGRESSION.get((BOOSTABLE_O)(King.this.roy()).induvidual) * 0.25D;
/* 116 */     ran = 0.5D + ran * 0.5D;
/* 117 */     v *= ran;
/* 118 */     return v;
/*     */   }
/*     */ 
/*     */   
/*     */   public double size() {
/* 123 */     double c = 0.125D * (BOOSTABLES.NOBLE()).COMPETANCE.get((BOOSTABLE_O)(King.this.roy()).induvidual);
/* 124 */     return CLAMP.d(c, 0.0D, 1.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\King$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */