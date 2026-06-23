/*   */ package view.sett;
/*   */ 
/*   */ import util.gui.misc.GBox;
/*   */ 
/*   */ public interface SETT_HOVERABLE {
/*   */   void hover(GBox paramGBox);
/*   */   
/*   */   default boolean canBeClicked() {
/* 9 */     return false;
/*   */   }
/*   */   
/*   */   default void click() {}
/*   */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\sett\SETT_HOVERABLE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */