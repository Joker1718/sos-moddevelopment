/*    */ package view.menu;
/*    */ 
/*    */ import game.save.GameLoader;
/*    */ import game.save.SaveFile;
/*    */ import init.paths.PATH;
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.util.color.COLOR;
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends MenuScreenLoad
/*    */ {
/*    */   null(CharSequence $anonymous0, COLOR $anonymous1, boolean $anonymous2, PATH $anonymous3) {
/* 15 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*    */   }
/*    */   
/*    */   protected void load(SaveFile f) {
/* 19 */     SPRITES.loader().printempty();
/* 20 */     (new GameLoader(f.path, new String[0])).set();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void back() {
/* 25 */     m.setMain();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\menu\IMenuLoad$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */