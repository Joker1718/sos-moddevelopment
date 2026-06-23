/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STATFake;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends STATFake
/*     */ {
/*     */   null(String $anonymous0, StatsInit $anonymous1) {
/* 109 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected double getDD(HCLASS s, Race r, int daysBack) {
/* 113 */     if (r == null) {
/* 114 */       double p = 0.0D;
/* 115 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 116 */         p += getDD(s, (Race)RACES.all().get(ri), daysBack) * (STATS.POP()).POP.data(s).get(RACES.all().get(ri), daysBack);
/*     */       }
/* 118 */       if (p == 0.0D)
/* 119 */         return 0.0D; 
/* 120 */       return p / (STATS.POP()).POP.data(s).get(null, daysBack);
/*     */     } 
/*     */     
/* 123 */     double pop = (STATS.POP()).POP.data(s).get(r, daysBack);
/* 124 */     if (pop == 0.0D)
/* 125 */       return 1.0D; 
/* 126 */     pop = 0.0D;
/* 127 */     double tot = 0.0D;
/* 128 */     for (Race rr : RACES.all()) {
/* 129 */       double p = (STATS.POP()).POP.data(s).get(rr, daysBack);
/* 130 */       pop += p;
/* 131 */       tot += p * r.pref().race(rr);
/*     */     } 
/* 133 */     if (pop == 0.0D)
/* 134 */       return 1.0D; 
/* 135 */     tot /= pop;
/* 136 */     return CLAMP.d(tot, 0.0D, 1.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsEnv$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */