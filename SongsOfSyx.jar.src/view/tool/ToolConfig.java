/*    */ package view.tool;
/*    */ 
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.LISTE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface ToolConfig
/*    */ {
/*    */   default void addUI(LISTE<RENDEROBJ> uis) {}
/*    */   
/*    */   default void activateAction() {}
/*    */   
/*    */   default void deactivateAction() {}
/*    */   
/*    */   default boolean back() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   default void update(boolean UIHovered) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\ToolConfig.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */