/*    */ package menu;
/*    */ 
/*    */ import snake2d.CORE;
/*    */ import snake2d.KeyBoard;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ 
/*    */ interface SC {
/*    */   boolean hover(COORDINATE paramCOORDINATE);
/*    */   
/*    */   boolean click();
/*    */   
/*    */   default void renderBackground(Background back, float ds, COORDINATE mCoo) {
/* 14 */     back.render((SPRITE_RENDERER)CORE.renderer(), ds);
/*    */   }
/*    */   
/*    */   void render(SPRITE_RENDERER paramSPRITE_RENDERER, float paramFloat);
/*    */   
/*    */   boolean back(Menu paramMenu);
/*    */   
/*    */   default void poll(KeyBoard.KeyEvent e) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\SC.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */