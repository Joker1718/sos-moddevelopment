/*     */ package settlement.stats.muls;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.sets.LISTE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Killer
/*     */   extends StatsMultipliers.StatMultiplier
/*     */ {
/* 234 */   private final StatsMultipliers.Data data = new StatsMultipliers.Data();
/*     */   private static final double di = 0.001D;
/*     */   
/*     */   private Killer(StatsInit init, LISTE<StatsMultipliers.StatMultiplier> all) {
/* 238 */     super(new StatsMultipliers.C("SERIAL_KILLER", init), all, new HCLASS[] { HCLASSES.CITIZEN(), HCLASSES.SLAVE() });
/* 239 */     init.savers.put("SERIAL_KILLER_DATA", this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public double value(HCLASS cl, Race race, int daysBack) {
/* 244 */     if (cl == null) {
/* 245 */       double v = 0.0D;
/* 246 */       double am = 0.0D;
/* 247 */       for (int ci = 0; ci < HCLASSES.ALL().size(); ci++) {
/* 248 */         HCLASS cll = (HCLASS)HCLASSES.ALL().get(ci);
/* 249 */         if (cll.player) {
/* 250 */           double p = (STATS.POP()).POP.data(cll).get(race);
/* 251 */           v += value(cll, race, daysBack) * p;
/* 252 */           am += p;
/*     */         } 
/*     */       } 
/* 255 */       if (am == 0.0D)
/* 256 */         return 0.0D; 
/* 257 */       return 0.001D * v / am;
/*     */     } 
/*     */     
/* 260 */     if (race == null) {
/* 261 */       double v = 0.0D;
/* 262 */       double am = 0.0D;
/* 263 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 264 */         Race r = (Race)RACES.all().get(ri);
/* 265 */         double p = (STATS.POP()).POP.data(cl).get(r);
/* 266 */         v += this.data.get(cl).history(r).get(daysBack) * p;
/* 267 */         am += p;
/*     */       } 
/* 269 */       if (am == 0.0D)
/* 270 */         return 0.0D; 
/* 271 */       return 0.001D * v / am;
/*     */     } 
/* 273 */     return this.data.get(cl).history(race).get(daysBack) * 0.001D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/* 278 */     for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 279 */       Race r = (Race)RACES.all().get(ri);
/* 280 */       double ra = ((GAME.events()).killer.victimRace() == r) ? (GAME.events()).killer.rate() : 0.0D;
/* 281 */       this.data.get(HCLASSES.CITIZEN()).set(r, (int)(1000.0D * ra));
/* 282 */       this.data.get(HCLASSES.SLAVE()).set(r, (int)(1000.0D * ra));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double value(Induvidual h) {
/* 289 */     return value(h.clas(), h.race(), 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\muls\StatsMultipliers$Killer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */