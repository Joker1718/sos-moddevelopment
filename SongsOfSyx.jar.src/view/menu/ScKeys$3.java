/*    */ package view.menu;
/*    */ 
/*    */ import snake2d.util.gui.clickable.Scrollable;
/*    */ import util.gui.table.GScrollable;
/*    */ import view.keyboard.KEYS;
/*    */ import view.keyboard.KeyPage;
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
/*    */   extends GScrollable
/*    */ {
/*    */   null(Scrollable.ScrollRow... $anonymous0) {
/* 80 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public int nrOFEntries() {
/* 84 */     return (int)Math.ceil(((KeyPage)KEYS.pages().get(ScKeys.this.page)).all().size() / 2.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\menu\ScKeys$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */