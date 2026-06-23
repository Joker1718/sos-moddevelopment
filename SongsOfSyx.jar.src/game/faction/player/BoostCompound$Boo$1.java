/*     */ package game.faction.player;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.Boostable;
/*     */ import game.faction.npc.FactionNPC;
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
/*     */ class null
/*     */   extends BValue.BValueFaction
/*     */ {
/*     */   null(Boostable $anonymous0) {
/* 113 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public double vGet(Player f) {
/* 117 */     int ci = GAME.updateI();
/* 118 */     if (ci != BoostCompound.Boo.this.cacheI) {
/* 119 */       BoostCompound.Boo.this.cacheI = GAME.updateI();
/* 120 */       BoostCompound.Boo.this.cache = 0.0D;
/* 121 */       if (BoostCompound.Boo.this.isMul) {
/* 122 */         for (BoostCompound<T>.Value v : all) {
/* 123 */           BoostCompound.Boo.this.cache += v.bo.booster.getValue(BoostCompound.Boo.access$1(BoostCompound.Boo.this).getValue(v.t)) - 1.0D;
/*     */         }
/* 125 */         BoostCompound.Boo.this.cache++;
/* 126 */         BoostCompound.Boo.this.cache = Math.max(0.0D, BoostCompound.Boo.this.cache);
/*     */       } else {
/* 128 */         for (BoostCompound<T>.Value v : all) {
/* 129 */           BoostCompound.Boo.this.cache += v.bo.booster.getValue(BoostCompound.Boo.access$1(BoostCompound.Boo.this).getValue(v.t));
/*     */         }
/*     */       } 
/*     */     } 
/* 133 */     return BoostCompound.Boo.this.cache;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(FactionNPC f) {
/* 138 */     return BoostCompound.Boo.this.defV;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\BoostCompound$Boo$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */