/*     */ package view.ui.profile;
/*     */ 
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.table.GScrollRows;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GScrollRows
/*     */ {
/*     */   null(Iterable<RENDEROBJ> $anonymous0, int $anonymous1, int $anonymous2) {
/*  91 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */   }
/*     */   
/*     */   protected boolean passesFilter(int i, RENDEROBJ o) {
/*  95 */     if (UIBonus.this.in.text().length() == 0)
/*  96 */       return true; 
/*  97 */     if (o instanceof UIBonus.Row) {
/*  98 */       UIBonus.Row r = (UIBonus.Row)o;
/*  99 */       if (Str.containsText(r.bo.name, (CharSequence)UIBonus.this.in.text()) || Str.containsText(r.bo.desc, (CharSequence)UIBonus.this.in.text()))
/* 100 */         return true; 
/* 101 */       return false;
/*     */     } 
/* 103 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\profile\UIBonus$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */