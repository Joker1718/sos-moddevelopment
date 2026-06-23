/*    */ package world;
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
/*    */ class null
/*    */   extends ComposerThings.ITileSheet
/*    */ {
/*    */   null(Path $anonymous0, int $anonymous1, int $anonymous2) throws IOException {
/* 17 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 20 */     ComposerDests.Tile t = d.s16;
/* 21 */     ComposerSources.Full f = s.full;
/* 22 */     f.init(0, 0, 1, 1, 36, 1, t);
/* 23 */     f.setVar(0).paste(true);
/* 24 */     return t.saveGame();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\Sprites$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */