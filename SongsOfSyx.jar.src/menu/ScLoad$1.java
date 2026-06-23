/*    */ package menu;
/*    */ 
/*    */ import game.save.GameLoader;
/*    */ import game.save.SaveFile;
/*    */ import init.paths.PATH;
/*    */ import snake2d.CORE_STATE;
/*    */ import snake2d.util.color.COLOR;
/*    */ import view.menu.MenuScreenLoad;
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
/*    */   extends MenuScreenLoad
/*    */ {
/*    */   null(CharSequence $anonymous0, COLOR $anonymous1, boolean $anonymous2, PATH $anonymous3) {
/* 78 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*    */   }
/*    */   
/*    */   protected void load(SaveFile f) {
/* 82 */     menu.start((CORE_STATE.Constructor)new GameLoader(f.path, new String[0]));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void back() {
/* 87 */     menu.switchScreen(menu.main);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScLoad$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */