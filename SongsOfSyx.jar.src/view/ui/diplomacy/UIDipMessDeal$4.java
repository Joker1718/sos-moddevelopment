/*     */ package view.ui.diplomacy;
/*     */ 
/*     */ import game.time.TIME;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 147 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void renAction() {
/* 151 */     boolean a = true;
/* 152 */     if (UIDipMessDeal.this.aa == 1)
/* 153 */       a = false; 
/* 154 */     if (UIDipMessDeal.this.aa == -1)
/* 155 */       a = false; 
/* 156 */     if (Math.abs(TIME.currentSecond() - UIDipMessDeal.this.time) > TIME.secondsPerDay())
/* 157 */       a = false; 
/* 158 */     if (UIDipMessDeal.this.save.f() == null)
/* 159 */       a = false; 
/* 160 */     activeSet(a);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 165 */     UIDipMessDeal.this.aa = -1;
/* 166 */     (UIDipMessDeal.this.save.f()).request.expire();
/* 167 */     VIEW.messages().hide();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 172 */     GBox b = (GBox)text;
/* 173 */     b.text(UIDipMessDeal.¤¤DeclineD);
/* 174 */     b.NL();
/* 175 */     b.add((SPRITE)GFORMAT.f0(b.text(), UIDipMessDeal.this.decline));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\diplomacy\UIDipMessDeal$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */