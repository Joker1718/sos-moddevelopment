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
/*     */ class null
/*     */   extends UIPanelTop.Butt
/*     */ {
/*     */   null(SPRITE $anonymous0, int $anonymous1) {
/*  95 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   protected void clickA() {
/*  98 */     if (p.added(BattlePanel.this.cards_cata)) {
/*  99 */       p.remove(BattlePanel.this.cards_cata);
/*     */     } else {
/* 101 */       p.add(BattlePanel.this.cards_cata, false, true);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void renAction() {
/* 106 */     selectedSet(p.added(BattlePanel.this.cards_cata));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\BattlePanel$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */