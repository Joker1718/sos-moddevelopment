/*     */ package init.tech;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import settlement.stats.Induvidual;
/*     */ import util.data.DOUBLE_O;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements DOUBLE_O<Induvidual>
/*     */ {
/*     */   public double getD(Induvidual t) {
/*  98 */     if (t.faction() == FACTIONS.player()) {
/*  99 */       if ((FACTIONS.player()).tech.isPenaltyLocked(TECH.this))
/* 100 */         return 0.0D; 
/* 101 */       return (((FACTIONS.player()).tech.level(TECH.this) > 0) ? true : false);
/*     */     } 
/* 103 */     return 1.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\tech\TECH$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */