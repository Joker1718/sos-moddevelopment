/*     */ package game.faction.royalty.opinion;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.royalty.Royalty;
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
/*     */ class null
/*     */   extends ROpper
/*     */ {
/*     */   null(String $anonymous0, CharSequence $anonymous1, CharSequence $anonymous2, SPRITE $anonymous3, double $anonymous4, boolean $anonymous5) {
/*  90 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4, $anonymous5);
/*     */   }
/*     */ 
/*     */   
/*     */   public double pget(Royalty bo) {
/*  95 */     Royalty roy = bo;
/*  96 */     if (DIP.overlord((Faction)roy.court.faction) == FACTIONS.player()) {
/*  97 */       return super.pget(bo);
/*     */     }
/*  99 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double ptarget(Royalty bo) {
/* 104 */     return 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\OpsOther$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */