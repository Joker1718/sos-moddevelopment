/*     */ package view.ui.diplomacy;
/*     */ 
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.deal.Deal;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.info.GFORMAT;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 117 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void renAction() {
/* 121 */     activeSet((UIDipMessDeal.this.pactive() == null));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 126 */     Deal d = DIP.TMP();
/* 127 */     if (UIDipMessDeal.this.pactive() != null) {
/*     */       return;
/*     */     }
/* 130 */     d.execute(false);
/* 131 */     (UIDipMessDeal.this.save.f()).request.clear();
/* 132 */     ROPINION.GIFTS().makeDeal(d.npc.npc(), UIDipMessDeal.this.happiness);
/* 133 */     UIDipMessDeal.this.aa = 1;
/* 134 */     VIEW.messages().hide();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 139 */     GBox b = (GBox)text;
/* 140 */     b.text(UIDipMessDeal.¤¤AcceptD);
/* 141 */     b.NL();
/* 142 */     b.add((SPRITE)GFORMAT.f0(b.text(), UIDipMessDeal.this.happiness));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\diplomacy\UIDipMessDeal$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */