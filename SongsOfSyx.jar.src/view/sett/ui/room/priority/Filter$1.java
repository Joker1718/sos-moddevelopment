/*    */ package view.sett.ui.room.priority;
/*    */ 
/*    */ import snake2d.util.sets.LIST;
/*    */ import util.gui.misc.GButt;
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
/* 37 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 41 */     Filter.this.relavant = false;
/* 42 */     for (Filter.FilterEntry<T> e : (Iterable<Filter.FilterEntry<T>>)all)
/* 43 */       e.toggled = true; 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\priority\Filter$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */