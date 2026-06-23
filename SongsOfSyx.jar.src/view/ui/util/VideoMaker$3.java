/*    */ package view.ui.util;
/*    */ 
/*    */ import game.GAME;
/*    */ import snake2d.CORE;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import view.main.VIEW;
/*    */ import view.sett.ui.minimap.UIMinimapSettConfig;
/*    */ import view.subview.GameWindow;
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
/*    */   extends VideoMaker.Mode
/*    */ {
/*    */   public GameWindow window() {
/* 83 */     return VIEW.b().getWindow();
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(RECTANGLE bounds) {
/* 88 */     GAME.s().render(CORE.renderer(), 0.0F, 0, bounds, 0, 0, UIMinimapSettConfig.NORMAL);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\u\\util\VideoMaker$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */