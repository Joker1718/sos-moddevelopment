/*    */ package launcher;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import snake2d.CORE;
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
/*    */   extends GUI.BText
/*    */ {
/*    */   null(RES $anonymous0, CharSequence $anonymous1, int $anonymous2) {
/* 52 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 57 */     if (PATHS.SCRIPT().hasExternal(l.s.mods.get()) || (l.s.mods.get()).length > 0) {
/* 58 */       l.setModWarning();
/*    */       
/*    */       return;
/*    */     } 
/* 62 */     l.s.save();
/* 63 */     Launcher.startGame = true;
/* 64 */     CORE.annihilate();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\ScreenMods$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */