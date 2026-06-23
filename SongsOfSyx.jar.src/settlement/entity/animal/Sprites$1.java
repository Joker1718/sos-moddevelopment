/*    */ package settlement.entity.animal;
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
/*    */ class null
/*    */   extends ComposerThings.ITileSheet
/*    */ {
/*    */   null(Path $anonymous0, int $anonymous1, int $anonymous2) throws IOException {
/* 22 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   protected TILE_SHEET init(ComposerUtil c, ComposerSources ss, ComposerDests d) {
/* 26 */     ComposerSources.Singles s = ss.singles;
/*    */     
/* 28 */     ComposerDests.Tile t = d.s32;
/* 29 */     s.init(0, 0, 3, 1, 2, 10, (ComposerDests.Dest)t);
/* 30 */     s.setVar(0);
/* 31 */     for (int i = 0; i < 5; i++) {
/* 32 */       s.setSkip(i * 2, 2).paste(3, true);
/*    */     }
/* 34 */     return t.saveGame();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\Sprites$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */