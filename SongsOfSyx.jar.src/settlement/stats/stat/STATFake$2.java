/*     */ package settlement.stats.stat;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.stats.STATS;
/*     */ import util.statistics.HISTORY_INT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements HISTORY_INT.HISTORY_INT_OBJECT<Race>
/*     */ {
/*     */   public int min(Race t) {
/*  74 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max(Race t) {
/*  79 */     return STATFake.this.dataDivider() * STATFake.this.pdivider(null, t, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public double getD(Race t, int fromZero) {
/*  84 */     double am = 0.0D;
/*  85 */     for (int hi = 0; hi < HCLASSES.ALL().size(); hi++) {
/*  86 */       HCLASS cl = (HCLASS)HCLASSES.ALL().get(hi);
/*  87 */       if (cl.player) {
/*  88 */         am += (STATS.POP()).POP.data(cl).get(null, fromZero) * STATFake.this.getDD(cl, null, fromZero);
/*     */       }
/*     */     } 
/*  91 */     double pop = (STATS.POP()).POP.data().get(null, fromZero);
/*  92 */     if (pop == 0.0D)
/*  93 */       return ((am > 0.0D) ? true : false); 
/*  94 */     return am / pop;
/*     */   }
/*     */ 
/*     */   
/*     */   public TIMECYCLE time() {
/*  99 */     return (TIMECYCLE)TIME.days();
/*     */   }
/*     */ 
/*     */   
/*     */   public int historyRecords() {
/* 104 */     return 32;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(Race t, int fromZero) {
/* 109 */     double d = (STATFake.this.dataDivider() * STATFake.this.pdivider(null, t, fromZero));
/* 110 */     return (int)(getD(t, fromZero) * d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\STATFake$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */