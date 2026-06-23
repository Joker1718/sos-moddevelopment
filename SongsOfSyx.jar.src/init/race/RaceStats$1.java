/*    */ package init.race;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.stats.muls.StatsMultipliers;
/*    */ import settlement.stats.standing.StatStanding;
/*    */ import settlement.stats.stat.STAT;
/*    */ import settlement.stats.util.StatsJson;
/*    */ import snake2d.util.file.Json;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends StatsJson
/*    */ {
/*    */   null(Json $anonymous0) throws IOException {
/* 54 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void doWithTheJson(STAT s, Json j, String key) {
/* 58 */     j = j.json(key);
/* 59 */     boolean prio = j.has("PRIO");
/* 60 */     StatStanding.StandingDef def = new StatStanding.StandingDef(j);
/* 61 */     RaceStats.this.reps[s.index()] = def;
/* 62 */     if (!prio)
/* 63 */       (RaceStats.this.reps[s.index()]).prio = (s.standing().base()).prio; 
/*    */   }
/*    */   
/*    */   public void doWithMultiplier(StatsMultipliers.StatMultiplier m, Json j, String key) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\RaceStats$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */