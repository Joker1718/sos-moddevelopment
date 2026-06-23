/*     */ package view.world.ui.battle;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import world.army.AD;
/*     */ import world.battle.spec.BATTLE_RESULT;
/*     */ import world.battle.spec.WBattleResult;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends Battle.Butt
/*     */ {
/*     */   null(SPRITE $anonymous0, CharSequence $anonymous1) {
/* 114 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected void clickA() {
/* 118 */     close.exe();
/* 119 */     if (result.result == BATTLE_RESULT.VICTORY) {
/* 120 */       AD.stats().mercy().incD(FACTIONS.player(), Res.this.slaves.mercy());
/* 121 */       result.accept(Res.this.slaves.accepted(), Res.this.spoils.accepted());
/*     */     } else {
/* 123 */       result.accept(null, null);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\Res$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */