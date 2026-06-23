/*     */ package view.battle;
/*     */ 
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import view.interrupter.ISidePanels;
/*     */ import view.ui.top.UIPanelTop;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends UIPanelTop.Butt
/*     */ {
/*     */   null(SPRITE $anonymous0, int $anonymous1) {
/* 116 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   protected void clickA() {
/* 119 */     if (p.added(BattlePanel.this.cards_enemy)) {
/* 120 */       p.remove(BattlePanel.this.cards_enemy);
/*     */     } else {
/* 122 */       p.add(BattlePanel.this.cards_enemy, true, true);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void renAction() {
/* 127 */     selectedSet(p.added(BattlePanel.this.cards_enemy));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\BattlePanel$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */