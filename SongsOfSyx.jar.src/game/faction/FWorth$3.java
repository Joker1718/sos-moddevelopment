/*     */ package game.faction;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
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
/*     */ class null
/*     */   extends FWorth.WINT
/*     */ {
/*     */   null(CharSequence $anonymous0, CharSequence $anonymous1, SPRITE $anonymous2) {
/*  93 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */   }
/*     */   public int pget(Faction f) {
/*  96 */     double cache = 0.0D;
/*  97 */     for (int ri = 0; ri < RACES.all().size(); ri++) {
/*  98 */       Race res = (Race)RACES.all().get(ri);
/*  99 */       cache += FACTIONS.PRICE().get((TRADABLE)TR.get(res)) * 0.25D * f.seller((TRADABLE)TR.get(res)).removeMax();
/*     */     } 
/* 101 */     return (int)cache;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\FWorth$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */