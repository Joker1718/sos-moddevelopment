/*     */ package view.world.ui.army;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import util.gui.misc.GButt;
/*     */ import view.main.VIEW;
/*     */ import world.army.AD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(CharSequence $anonymous0) {
/*  98 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void renAction() {
/* 102 */     activeSet((Army.army.added() && Army.army.divs().canAdd() && UIMerenaries.this.cost() > 0 && UIMerenaries.this.cost() <= FACTIONS.player().credits().credits()));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 107 */     for (UIMerenaries.Card c : UIMerenaries.this.active) {
/* 108 */       if (c.selectedIs() && Army.army.divs().canAdd()) {
/* 109 */         int cost = AD.mercenaries().signingCost(c.ii);
/* 110 */         if (cost < FACTIONS.player().credits().credits()) {
/* 111 */           c.div.reassign(Army.army);
/* 112 */           GAME.player().credits().inc(-AD.mercenaries().signingCost(c.ii), FCredits.CTYPE.MERCINARIES);
/*     */         } 
/*     */       } 
/*     */     } 
/* 116 */     (VIEW.inters()).popup.close();
/* 117 */     super.clickA();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\army\UIMerenaries$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */