/*    */ package init.race.appearence;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.util.sprite.TILE_SHEET;
/*    */ import util.spritecomposer.ComposerDests;
/*    */ import util.spritecomposer.ComposerSources;
/*    */ import util.spritecomposer.ComposerThings;
/*    */ import util.spritecomposer.ComposerUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends ComposerThings.ITileSheet
/*    */ {
/*    */   null(Path $anonymous0, int $anonymous1, int $anonymous2) throws IOException {
/* 18 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 22 */     int a = 18;
/* 23 */     s.singles.init(0, 0, 1, 1, 2, a, (ComposerDests.Dest)d.s24);
/* 24 */     for (int i = 0; i < a; i++) {
/* 25 */       s.singles.setSkip(i * 2, 2).paste(3, true);
/*    */     }
/* 27 */     return d.s24.saveGame();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RaceSheet$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */