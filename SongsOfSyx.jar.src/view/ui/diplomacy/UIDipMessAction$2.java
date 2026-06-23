/*     */ package view.ui.diplomacy;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  86 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void renAction() {
/*  90 */     boolean a = true;
/*  91 */     if (UIDipMessAction.this.accepted)
/*  92 */       a = false; 
/*  93 */     if (Math.abs(TIME.currentSecond() - UIDipMessAction.this.time) > TIME.secondsPerDay())
/*  94 */       a = false; 
/*  95 */     if (UIDipMessAction.this.intro.faction() == null || UIDipMessAction.this.of.faction() == null)
/*  96 */       a = false; 
/*  97 */     activeSet(a);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 102 */     UIDipMessAction.this.accepted = true;
/* 103 */     (UIDipMessAction.this.intro.faction()).request.expire();
/* 104 */     UIDipMessAction.access$0(UIDipMessAction.this);
/* 105 */     UIDipMessAction.this.aa = -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 110 */     GBox b = (GBox)text;
/* 111 */     b.text(UIDipMessDeal.¤¤DeclineD);
/* 112 */     b.NL();
/* 113 */     b.add((SPRITE)GFORMAT.f0(b.text(), UIDipMessAction.this.declinePenalty));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\diplomacy\UIDipMessAction$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */