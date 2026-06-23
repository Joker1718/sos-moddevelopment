/*     */ package init.race;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.stats.muls.StatsMultipliers;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.util.StatsJson;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.Tuple;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends StatsJson
/*     */ {
/*     */   null(String $anonymous0, Json $anonymous1) throws IOException {
/* 128 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void doWithMultiplier(StatsMultipliers.StatMultiplier m, Json j, String key) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void doWithTheJson(STAT s, Json j, String key) {
/* 138 */     RaceStats.this.arrival.add(new Tuple.TupleImp(s, Double.valueOf(j.d(key))));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\RaceStats$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */