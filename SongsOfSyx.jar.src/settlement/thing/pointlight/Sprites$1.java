/*    */ package settlement.thing.pointlight;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends ComposerThings.ITileSheet
/*    */ {
/*    */   null(Path $anonymous0, int $anonymous1, int $anonymous2) throws IOException {
/* 29 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   protected TILE_SHEET init(ComposerUtil c, ComposerSources ss, ComposerDests d) {
/* 33 */     ComposerDests.Tile t = d.s8;
/* 34 */     ComposerSources.Singles s = ss.singles;
/* 35 */     s.init(0, 0, 1, 1, 8, 4, (ComposerDests.Dest)t);
/* 36 */     s.setSkip(0, 8).paste(true);
/* 37 */     return t.saveGame();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\pointlight\Sprites$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */