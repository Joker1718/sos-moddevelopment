/*     */ package game.faction.royalty.opinion;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.superb.SuperBoostableObj;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.royalty.Royalty;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends ROpper
/*     */ {
/*     */   null(String $anonymous0, CharSequence $anonymous1, CharSequence $anonymous2, SPRITE $anonymous3, double $anonymous4, boolean $anonymous5) {
/* 108 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4, $anonymous5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double getModifier(Royalty roy) {
/* 114 */     return (BOOSTABLES.NOBLE()).TOLERANCE.get((BOOSTABLE_O)roy.induvidual);
/*     */   }
/*     */ 
/*     */   
/*     */   public double pget(Royalty roy) {
/* 119 */     double d = roy.induvidual.race().pref().race(FACTIONS.player().race());
/* 120 */     d = 1.0D - CLAMP.d(d, 0.0D, 1.0D);
/* 121 */     return d;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double ptarget(Royalty bo) {
/* 126 */     return pget(bo);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\OpsOther$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */