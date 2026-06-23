/*    */ package world.entity.army;
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
/*    */   protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 33 */     s.singles.init(0, 0, 2, 1, 2, 6, (ComposerDests.Dest)d.s8);
/* 34 */     s.singles.setVar(0); int i;
/* 35 */     for (i = 0; i < 7; i++) {
/* 36 */       s.singles.setSkip(i * 2, 2);
/* 37 */       s.singles.paste(3, true);
/*    */     } 
/* 39 */     s.singles.setVar(1);
/* 40 */     for (i = 0; i < 7; i++) {
/* 41 */       s.singles.setSkip(i * 2, 2);
/* 42 */       s.singles.paste(3, true);
/*    */     } 
/*    */ 
/*    */     
/* 46 */     return d.s8.saveGame();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\army\WArmySprite$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */