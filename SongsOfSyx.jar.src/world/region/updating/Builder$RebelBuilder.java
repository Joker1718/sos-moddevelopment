/*     */ package world.region.updating;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.religion.Religion;
/*     */ import init.trade.TRADABLE;
/*     */ import settlement.stats.STATS;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.RDReligions;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class RebelBuilder
/*     */   implements RealmBuilder
/*     */ {
/* 430 */   private Region cacheReg = null;
/* 431 */   private double[] races = new double[RACES.all().size()];
/* 432 */   private double[] religions = new double[RACES.all().size()];
/*     */   private double mil;
/*     */   
/*     */   private void init(Region reg) {
/* 436 */     if (this.cacheReg == reg)
/*     */       return; 
/* 438 */     this.cacheReg = reg;
/* 439 */     this.mil = RD.RAN().get(reg, 20, 8) / 1024.0D;
/*     */     
/* 441 */     double max = -1.7976931348623157E308D;
/* 442 */     RDRace mrace = null;
/* 443 */     int ri = (RD.OWNER()).ownerI.get(reg);
/* 444 */     for (RDRace rr : (RD.RACES()).all) {
/* 445 */       double d = rr.pop.base(reg) * (0.25D + RD.RAN().get(reg, ri + rr.race.index() * 3, 3) / 7.0D);
/* 446 */       double dr = RD.RAN().get(reg, ri + rr.race.index() * 5, 4);
/* 447 */       dr /= 7.0D;
/* 448 */       this.races[rr.race.index()] = -1.0D + dr;
/* 449 */       if (d > max) {
/* 450 */         mrace = rr;
/* 451 */         max = d;
/*     */       } 
/*     */     } 
/*     */     
/* 455 */     double rasism = (STATS.ENV()).OTHERS.standing().definitionD(mrace.race);
/*     */     
/* 457 */     for (RDRace rr : (RD.RACES()).all) {
/* 458 */       if (rr == mrace) {
/* 459 */         this.races[rr.race.index()] = 1.0D + 2.0D * rasism;
/*     */         continue;
/*     */       } 
/* 462 */       this.races[rr.race.index()] = this.races[rr.race.index()] + mrace.race.pref().race(rr.race);
/* 463 */       this.races[rr.race.index()] = this.races[rr.race.index()] * rasism;
/*     */     } 
/*     */     
/* 466 */     RDReligions.RDReligion tr = (RDReligions.RDReligion)RD.RELIGION().all().get(0);
/* 467 */     max = 0.0D;
/* 468 */     for (RDReligions.RDReligion rr : RD.RELIGION().all()) {
/* 469 */       this.religions[rr.religion.index()] = 0.0D;
/* 470 */       if (rr.current.get(reg) > max) {
/* 471 */         max = rr.current.get(reg);
/* 472 */         tr = rr;
/*     */       } 
/*     */     } 
/* 475 */     this.religions[tr.religion.index()] = 1.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double policy(Race race, Region reg) {
/* 482 */     init(reg);
/* 483 */     return this.races[race.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public double priority(TRADABLE res, Region reg) {
/* 488 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double priority(Religion religion, Region reg) {
/* 493 */     init(reg);
/* 494 */     return this.religions[religion.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public double military(Region reg) {
/* 499 */     return this.mil;
/*     */   }
/*     */ 
/*     */   
/*     */   public double size() {
/* 504 */     return 0.25D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\regio\\updating\Builder$RebelBuilder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */