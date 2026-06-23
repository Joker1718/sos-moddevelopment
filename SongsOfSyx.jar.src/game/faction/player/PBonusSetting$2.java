/*     */ package game.faction.player;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.Boostable;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.STATS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements BValue.BValuePlayerOnly
/*     */ {
/*     */   public double vGet(FactionNPC f) {
/* 101 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Player f) {
/* 106 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(HCLASS_RACE t) {
/* 111 */     if (b == (BOOSTABLES.BEHAVIOUR()).HAPPI && 
/* 112 */       t.cl == HCLASSES.CITIZEN() && (STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(t.race) == 0) {
/* 113 */       return 0.0D;
/*     */     }
/* 115 */     return 1.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PBonusSetting$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */