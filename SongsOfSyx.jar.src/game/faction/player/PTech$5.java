/*     */ package game.faction.player;
/*     */ 
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.tech.TECH;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends BoostCompound<TECH>
/*     */ {
/*     */   null(BoostSpecs $anonymous0, LIST<TECH> $anonymous1) {
/* 153 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected BoostSpecs bos(TECH t) {
/* 157 */     BoostSpecs bos = new BoostSpecs(t.boosters.info.name, t.boosters.info.icon, false);
/* 158 */     for (BoostSpec s : t.boosters.all()) {
/* 159 */       double to = s.booster.isMul ? ((s.booster.to() - 1.0D) * t.levelMax + 1.0D) : (s.booster.to() * t.levelMax);
/* 160 */       BoosterValue b = new BoosterValue(BValue.VALUE1, t.boosters.info, s.booster.from(), to, s.booster.isMul);
/* 161 */       bos.push((Booster)b, s.boostable);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 166 */     return bos;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double getValue(TECH t) {
/* 171 */     return (1.0D - PTech.this.penalties[t.index()]) * PTech.this.level(t) / t.levelMax;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double get(Boostable bo, FactionNPC f, boolean isMul) {
/* 176 */     return super.get(bo, f, isMul) * PTech.this.npcAmount[bo.index() % PTech.this.npcAmount.length];
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PTech$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */