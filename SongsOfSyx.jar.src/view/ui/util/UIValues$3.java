/*    */ package view.ui.util;
/*    */ 
/*    */ import init.value.Value;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.LIST;
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
/*    */ class null
/*    */   extends GScrollRows
/*    */ {
/*    */   null(Iterable<? extends RENDEROBJ> $anonymous0, int $anonymous1) {
/* 64 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected boolean passesFilter(int i, RENDEROBJ o) {
/* 68 */     if (filter.text().length() == 0)
/* 69 */       return true; 
/* 70 */     if (Str.containsText(((Value)all.get(i)).key, (CharSequence)filter.text()) || Str.containsText(((Value)all.get(i)).name, (CharSequence)filter.text()))
/* 71 */       return true; 
/* 72 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\u\\util\UIValues$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */