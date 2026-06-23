/*    */ package view.ui.util;
/*    */ 
/*    */ import game.GAME;
/*    */ import snake2d.CORE;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import view.main.VIEW;
/*    */ import view.subview.GameWindow;
/*    */ import world.WORLD;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 53 */     return (VIEW.world()).window;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(RECTANGLE bounds) {
/* 58 */     WORLD.OVERLAY().hide();
/* 59 */     boolean t = (WORLD.FOW()).toggled.is();
/* 60 */     (WORLD.FOW()).toggled.set(false);
/* 61 */     GAME.world().render(CORE.renderer(), 0.0F, 0, bounds, 0, 0);
/* 62 */     (WORLD.FOW()).toggled.set(t);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\u\\util\VideoMaker$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */