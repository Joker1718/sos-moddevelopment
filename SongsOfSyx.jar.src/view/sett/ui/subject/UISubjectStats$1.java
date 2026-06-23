/*    */ package view.sett.ui.subject;
/*    */ 
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.gui.misc.GInput;
/*    */ import util.gui.table.GScrollRows;
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
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GScrollRows
/*    */ {
/*    */   null(Iterable<RENDEROBJ> $anonymous0, int $anonymous1, int $anonymous2) {
/* 81 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   protected boolean passesFilter(int i, RENDEROBJ o) {
/* 84 */     if (in.text() == null || in.text().length() == 0)
/* 85 */       return true; 
/* 86 */     if (o instanceof UISubjectStats.Row) {
/* 87 */       return Str.containsText((((UISubjectStats.Row)o).s.info()).name, (CharSequence)in.text());
/*    */     }
/* 89 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectStats$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */