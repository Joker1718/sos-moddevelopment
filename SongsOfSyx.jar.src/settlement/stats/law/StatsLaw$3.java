/*     */ package settlement.stats.law;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STATFakeData;
/*     */ import snake2d.util.gui.GUI_BOX;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends STATFakeData
/*     */ {
/*     */   null(String $anonymous0, StatsInit $anonymous1) {
/* 172 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected double getDD(HCLASS cl, Race race) {
/* 177 */     double pop = (STATS.POP()).POP.data().get(null);
/* 178 */     double g = (SETT.ROOMS()).GUARD.power.get() * 0.25D;
/*     */     
/* 180 */     if (pop <= 0.0D) {
/* 181 */       return 0.0D;
/*     */     }
/* 183 */     g /= pop;
/* 184 */     g = Math.sqrt(g);
/*     */     
/* 186 */     g = CLAMP.d(g, 0.0D, 1.0D);
/*     */     
/* 188 */     return CLAMP.d(g + StatsLaw.this.debug, 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, HCLASS cl, Race type) {
/* 194 */     StatsLaw.this.hoverGuards(text, cl, type);
/*     */     
/* 196 */     super.hover(text, cl, type);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\law\StatsLaw$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */