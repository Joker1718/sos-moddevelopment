/*     */ package game.faction.royalty.opinion;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.superb.SuperBoostableObj;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.royalty.Royalty;
/*     */ import game.tourism.TOURISM;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 130 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4, $anonymous5);
/*     */   }
/*     */   
/*     */   public double getModifier(Royalty roy) {
/* 134 */     return 1.0D - 0.5D * (BOOSTABLES.NOBLE()).TOLERANCE.get((BOOSTABLE_O)roy.induvidual);
/*     */   }
/*     */ 
/*     */   
/*     */   public double pget(Royalty roy) {
/* 139 */     double c = 0.0D;
/* 140 */     Race ra = roy.induvidual.race();
/* 141 */     c += (STATS.MULTIPLIERS()).PROSECUTION.value(HCLASSES.CITIZEN(), ra, 0);
/* 142 */     c += (20 * POP.tot(HCLASSES.SLAVE(), ra) / (1 + POP.tot(null, null)));
/* 143 */     RDRace rr = RD.RACE(ra);
/* 144 */     if (rr != null) {
/* 145 */       c += (RD.RACES()).edicts.sanction.realm(rr).getD(FACTIONS.player()) * 0.25D;
/* 146 */       c += (RD.RACES()).edicts.exile.realm(rr).getD(FACTIONS.player()) * 0.5D;
/* 147 */       c += (RD.RACES()).edicts.massacre.realm(rr).getD(FACTIONS.player());
/*     */     } 
/*     */     
/* 150 */     if (!TOURISM.permit(ra)) {
/* 151 */       c += 0.1D;
/*     */     }
/*     */     
/* 154 */     c = CLAMP.d(c, 0.0D, 1.0D);
/* 155 */     return c;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double ptarget(Royalty bo) {
/* 160 */     return 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\OpsOther$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */