/*     */ package game.faction.royalty.opinion;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.royalty.Royalty;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends ROpper.ROpperDown
/*     */ {
/*     */   null(String $anonymous0, CharSequence $anonymous1, CharSequence $anonymous2, SPRITE $anonymous3, double $anonymous4, boolean $anonymous5, double $anonymous6) {
/*  98 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4, $anonymous5, $anonymous6);
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(Royalty roy, double time) {
/* 103 */     double t = OpsEmi.this.assasinationsPerYear(roy, (FACTIONS.player()).emissaries.penaltyMul());
/* 104 */     t = time * t / year;
/* 105 */     int a = (int)this.state.getD(roy);
/* 106 */     this.state.incD(roy, t);
/* 107 */     int n = (int)this.state.getD(roy);
/* 108 */     if (a != n) {
/* 109 */       this.state.incD(roy, -n);
/* 110 */       long ran = STATS.RAN().getL(roy.induvidual, a % 32);
/* 111 */       if ((ran & 0x3L) == 0L) {
/* 112 */         OpsEmi.this.assasinate(roy, true);
/* 113 */         (GAME.count()).ROYALTIES_KILLED.inc(1);
/*     */       } else {
/* 115 */         OpsEmi.this.assasinate(roy, false);
/*     */       } 
/*     */     } 
/* 118 */     super.update(roy, time);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\OpsEmi$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */