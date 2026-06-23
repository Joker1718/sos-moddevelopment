/*    */ package view.battle;
/*    */ 
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import view.interrupter.ISidePanels;
/*    */ import view.ui.top.UIPanelTop;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends UIPanelTop.Butt
/*    */ {
/*    */   null(SPRITE $anonymous0, int $anonymous1) {
/* 78 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   protected void clickA() {
/* 81 */     if (p.added(BattlePanel.this.cards_player)) {
/* 82 */       p.remove(BattlePanel.this.cards_player);
/*    */     } else {
/* 84 */       p.add(BattlePanel.this.cards_player, false, true);
/*    */     } 
/*    */   }
/*    */   
/*    */   protected void renAction() {
/* 89 */     selectedSet(p.added(BattlePanel.this.cards_player));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\BattlePanel$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */