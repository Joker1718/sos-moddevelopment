/*    */ package view.ui.wiki;
/*    */ 
/*    */ import util.gui.table.GTableBuilder;
/*    */ import view.main.VIEW;
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
/*    */   extends GTableBuilder
/*    */ {
/*    */   public int nrOFEntries() {
/* 61 */     return WikiList.this.filtered.size();
/*    */   }
/*    */ 
/*    */   
/*    */   public void click(int index) {
/* 66 */     Article e = (Article)WikiList.this.filtered.get(index);
/* 67 */     if (e != null) {
/* 68 */       (VIEW.UI()).wiki.set(e);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean selectedIs(int index) {
/* 74 */     Article a = (Article)WikiList.this.filtered.get(index);
/* 75 */     if (a == null)
/* 76 */       return false; 
/* 77 */     return ((VIEW.UI()).wiki.added().size() > 0 && (VIEW.UI()).wiki.added().get(0) == a);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\wiki\WikiList$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */