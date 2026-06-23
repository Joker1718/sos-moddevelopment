/*    */ package init.race.appearence;
/*    */ 
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import util.spritecomposer.ComposerDests;
/*    */ import util.spritecomposer.ComposerSources;
/*    */ import util.spritecomposer.ComposerThings;
/*    */ import util.spritecomposer.ComposerUtil;
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
/*    */   extends ComposerThings.ITileSheet
/*    */ {
/*    */   protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 35 */     int a = 6;
/* 36 */     s.singles.init(s.singles.body().x2(), 0, 1, 1, 4, 3, (ComposerDests.Dest)d.s32);
/* 37 */     for (int i = 0; i < a; i++) {
/* 38 */       s.singles.setSkip(i * 2, 2).paste(3, true);
/*    */     }
/* 40 */     return d.s32.saveGame();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RaceSheet$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */