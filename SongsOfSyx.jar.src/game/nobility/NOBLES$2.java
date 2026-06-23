/*     */ package game.nobility;
/*     */ 
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Boostable;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.BoostCompound;
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
/*     */ class null
/*     */   extends BoostCompound<NobleOffice>
/*     */ {
/*     */   null(BoostSpecs $anonymous0, LIST<NobleOffice> $anonymous1) {
/*  90 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected BoostSpecs bos(NobleOffice t) {
/*  96 */     return t.boosts;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double get(Boostable bo, FactionNPC f, boolean isMul) {
/* 101 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double getValue(NobleOffice t) {
/* 106 */     return t.value(NOBLES.this.allocations(t));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\nobility\NOBLES$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */