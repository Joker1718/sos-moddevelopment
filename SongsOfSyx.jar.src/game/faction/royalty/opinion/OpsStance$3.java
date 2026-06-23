/*     */ package game.faction.royalty.opinion;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.superb.SuperBoostableObj;
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
/* 101 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4, $anonymous5);
/*     */   }
/*     */   
/*     */   public double increase(Royalty roy) {
/* 105 */     if ((DIP.get(roy.court.faction)).ally && DIP.WAR().all((Faction)FACTIONS.player()).size() > 0)
/* 106 */       return 1.0D / year * 10.0D; 
/* 107 */     if ((DIP.get(roy.court.faction)).trades && DIP.WAR().all((Faction)FACTIONS.player()).size() > 0) {
/* 108 */       return 0.25D / year * 10.0D;
/*     */     }
/* 110 */     return -1.0D / year * 2.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double getModifier(Royalty roy) {
/* 116 */     return 1.0D / (0.25D + (BOOSTABLES.NOBLE()).AGRESSION.get((BOOSTABLE_O)roy.induvidual));
/*     */   }
/*     */ 
/*     */   
/*     */   protected double ptarget(Royalty roy) {
/* 121 */     if ((DIP.get(roy.court.faction)).ally && DIP.WAR().all((Faction)FACTIONS.player()).size() > 0)
/* 122 */       return 1.0D; 
/* 123 */     if ((DIP.get(roy.court.faction)).trades && DIP.WAR().all((Faction)FACTIONS.player()).size() > 0) {
/* 124 */       return 1.0D;
/*     */     }
/* 126 */     return 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\OpsStance$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */