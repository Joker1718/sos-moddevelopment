/*     */ package view.sett.ui.subject;
/*     */ 
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.STRING_RECIEVER;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
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
/*     */ class null
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   STRING_RECIEVER r;
/*     */   
/*     */   null(SPRITE $anonymous0) {
/*  81 */     super($anonymous0);
/*     */     
/*  83 */     this.r = new STRING_RECIEVER()
/*     */       {
/*     */         public void acceptString(CharSequence string)
/*     */         {
/*  87 */           if (string != null && string.length() > 0)
/*  88 */             STATS.APPEARANCE().setCustomName(a.a.indu(), String.valueOf(string)); 
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected void clickA() {
/*  94 */     (VIEW.inters()).input.requestInput(this.r, UISubjectActions.¤¤rename, STATS.APPEARANCE().name(a.a.indu()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/*  99 */     text.text(UISubjectActions.¤¤rename);
/* 100 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectActions$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */