/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import init.race.appearence.RType;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements StatsInit.StatInitable
/*     */ {
/*     */   public void init(Induvidual h) {
/*  94 */     double ri = RND.rFloat((h.race().appearance()).tMax);
/*  95 */     int gi = 0;
/*  96 */     for (RType t : (h.race().appearance()).types) {
/*  97 */       ri -= t.spec.occurrence;
/*  98 */       if (ri <= 0.0D) {
/*  99 */         gi = CLAMP.i(gi, 0, (h.race().appearance()).types.size() - 1);
/* 100 */         StatsAppearance.this.gender.set(h, gi);
/*     */         break;
/*     */       } 
/* 103 */       gi++;
/*     */     } 
/* 105 */     StatsAppearance.this.nameFirst.randmoize(h);
/* 106 */     StatsAppearance.this.nameLast.randmoize(h);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsAppearance$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */