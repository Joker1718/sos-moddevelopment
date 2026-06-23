/*     */ package view.ui.economy;
/*     */ 
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.gui.misc.GButt;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   null(Iterable<? extends RENDEROBJ> $anonymous0, int $anonymous1) {
/* 126 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected boolean passesFilter(int i, RENDEROBJ o) {
/* 130 */     if (unused.selectedIs())
/* 131 */       return true; 
/* 132 */     TRADABLE res = (TRADABLE)TR.ALL().get(i);
/* 133 */     if (impot.selectedIs() && res.pb().importing())
/* 134 */       return true; 
/* 135 */     if (export.selectedIs() && res.ps().exporting() == null)
/* 136 */       return true; 
/* 137 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\economy\UITreasury$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */