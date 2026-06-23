/*     */ package game.faction.player;
/*     */ 
/*     */ import game.boosting.BoostSpecs;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends BoostCompound<PLevels.Level>
/*     */ {
/*     */   null(BoostSpecs $anonymous0, LIST<PLevels.Level> $anonymous1) {
/*  92 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected double getValue(PLevels.Level t) {
/*  96 */     return ((PLevels.this.current.index >= t.index) ? true : false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected BoostSpecs bos(PLevels.Level t) {
/* 101 */     return t.boosters;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PLevels$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */