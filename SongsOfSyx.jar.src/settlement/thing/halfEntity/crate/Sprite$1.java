/*    */ package settlement.thing.halfEntity.crate;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends ComposerThings.ITileSheet
/*    */ {
/*    */   null(Path $anonymous0, int $anonymous1, int $anonymous2) throws IOException {
/* 25 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 29 */     s.singles.init(0, 0, 1, 1, 2, 6, (ComposerDests.Dest)d.s32);
/* 30 */     for (int i = 0; i < 6; i++) {
/* 31 */       for (int r = 0; r < 4; r++) {
/* 32 */         s.singles.setSkip(i * 2, 1).pasteRotated(r, true);
/* 33 */         s.singles.setSkip(i * 2 + 1, 1).pasteRotated(r, true);
/*    */       } 
/*    */     } 
/*    */     
/* 37 */     return d.s32.saveGame();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\crate\Sprite$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */