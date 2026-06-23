/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.race.home.RaceHomeClass;
/*     */ import init.resources.RES_AMOUNT;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STATFake;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  82 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected double getDD(HCLASS s, Race r, int daysBack) {
/*  86 */     double am = 0.0D;
/*  87 */     for (StatsHome.StatFurniture ss : StatsHome.this.currents)
/*  88 */       am += ss.current.data(s).get(r); 
/*  89 */     double div = pdivider(s, r, daysBack);
/*  90 */     if (div == 0.0D)
/*  91 */       return 0.0D; 
/*  92 */     return am / div;
/*     */   }
/*     */ 
/*     */   
/*     */   public double induGet(Induvidual t) {
/*  97 */     double am = 0.0D;
/*  98 */     for (StatsHome.StatFurniture ss : StatsHome.this.currents) {
/*  99 */       am += ss.current.indu().get(t);
/*     */     }
/* 101 */     double max = 0.0D;
/* 102 */     RaceHomeClass cc = t.race().home().clas(t.clas());
/* 103 */     for (RES_AMOUNT a : cc.resources())
/* 104 */       max += a.amount(); 
/* 105 */     if (max == 0.0D)
/* 106 */       return 1.0D; 
/* 107 */     return am / max;
/*     */   }
/*     */   
/*     */   public int dataDivider() {
/* 111 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int pdivider(HCLASS c, Race r, int daysback) {
/* 116 */     if (r == null) {
/* 117 */       int am = 0;
/* 118 */       for (Race rr : RACES.all()) {
/* 119 */         am += pdivider(c, rr, daysback);
/*     */       }
/* 121 */       return am;
/*     */     } 
/* 123 */     if (r == null || r.home() == null)
/* 124 */       throw new RuntimeException(String.valueOf(c) + " " + String.valueOf(c) + " " + String.valueOf(r)); 
/* 125 */     RaceHomeClass cc = r.home().clas(c);
/* 126 */     if (cc == null)
/* 127 */       return (STATS.POP()).POP.data(c).get(r); 
/* 128 */     return cc.amountTotal() * (STATS.POP()).POP.data(c).get(r);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsHome$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */