/*    */ package view.tool;
/*    */ 
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ 
/*    */ public interface PLACABLE
/*    */ {
/* 10 */   public static final CharSequence E = "";
/*    */ 
/*    */ 
/*    */   
/*    */   SPRITE getIcon();
/*    */ 
/*    */ 
/*    */   
/*    */   CharSequence name();
/*    */ 
/*    */ 
/*    */   
/*    */   PLACABLE getUndo();
/*    */ 
/*    */   
/*    */   default LIST<CLICKABLE> getAdditionalButt() {
/* 26 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   default void hoverDesc(GBox box) {
/* 31 */     box.text(name());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PLACABLE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */