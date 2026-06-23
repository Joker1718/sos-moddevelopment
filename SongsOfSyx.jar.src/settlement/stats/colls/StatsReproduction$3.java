/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.util.StatBooster;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends StatBooster
/*     */ {
/*     */   public double vGet(HCLASS_RACE t) {
/*  93 */     return (StatsReproduction.this.forcedSetting.get(t.index) ? true : false);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Div div) {
/*  98 */     return (StatsReproduction.this.forcedSetting.get((HCLASS_RACE.clP(div.race(), HCLASSES.CITIZEN())).index) ? true : false);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Induvidual indu) {
/* 103 */     return (StatsReproduction.this.forcedSetting.get((HCLASS_RACE.clP(indu.race(), indu.clas())).index) ? true : false);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsReproduction$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */