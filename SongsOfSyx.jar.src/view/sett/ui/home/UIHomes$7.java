/*     */ package view.sett.ui.home;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.Dic;
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
/*     */ class null
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/* 122 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void clickA() {
/* 126 */     UIHomes.this.overlay = !(!UIHomes.this.overlay && !(SETT.OVERLAY()).HOMELESS.added());
/* 127 */     UIHomes.this.overlay = !UIHomes.this.overlay;
/* 128 */     if (!UIHomes.this.overlay) {
/* 129 */       (VIEW.s()).overlayThing.set(null);
/*     */     }
/*     */   }
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 134 */     text.title(Dic.¤¤Overlay);
/* 135 */     text.text((SETT.OVERLAY()).HOMELESS.desc);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 140 */     selectedSet(!(!UIHomes.this.overlay && !(SETT.OVERLAY()).HOMELESS.added()));
/* 141 */     if (UIHomes.this.overlay)
/* 142 */       (SETT.OVERLAY()).HOMELESS.add(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\home\UIHomes$7.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */