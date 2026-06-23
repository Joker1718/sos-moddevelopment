/*    */ package settlement.thing.halfEntity.dingy;
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
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends ComposerThings.ITileSheet
/*    */ {
/*    */   null(Path $anonymous0, int $anonymous1, int $anonymous2) throws IOException {
/* 20 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 24 */     s.singles.init(0, 0, 1, 1, 2, 5, (ComposerDests.Dest)d.s32);
/* 25 */     for (int i = 0; i < 4; i++) {
/* 26 */       for (int r = 0; r < 4; r++) {
/* 27 */         s.singles.setSkip(i * 2, 1).pasteRotated(r, true);
/* 28 */         s.singles.setSkip(i * 2 + 1, 1).pasteRotated(r, true);
/*    */       } 
/*    */     } 
/*    */     
/* 32 */     return d.s32.saveGame();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\dingy\Sprite$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */