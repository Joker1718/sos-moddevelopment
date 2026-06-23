/*    */ package view.ui.diplomacy;
/*    */ 
/*    */ import game.faction.royalty.opinion.ROPINION;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GButt;
/*    */ import util.info.GFORMAT;
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
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 60 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void renAction() {
/* 64 */     activeSet(UIDipMessAction.this.pactive());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 69 */     UIDipMessAction.this.accepted = true;
/* 70 */     ROPINION.GIFTS().makeDeal(UIDipMessAction.this.intro.faction(), UIDipMessAction.this.happiness);
/* 71 */     UIDipMessAction.this.accept(UIDipMessAction.this.intro.faction(), UIDipMessAction.this.of.faction());
/* 72 */     UIDipMessAction.access$0(UIDipMessAction.this);
/* 73 */     UIDipMessAction.this.aa = 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 78 */     GBox b = (GBox)text;
/* 79 */     b.text(UIDipMessDeal.¤¤AcceptD);
/* 80 */     b.NL();
/* 81 */     b.add((SPRITE)GFORMAT.f0(b.text(), UIDipMessAction.this.happiness));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\diplomacy\UIDipMessAction$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */