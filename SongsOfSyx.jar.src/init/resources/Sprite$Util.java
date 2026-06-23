/*    */ package init.resources;
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
/*    */ class Util
/*    */ {
/*    */   public TILE_SHEET getMinable(Path path) throws IOException {
/* 63 */     return (new ComposerThings.ITileSheet(path, 364, 94)
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */         {
/* 67 */           s.singles.init(0, 0, 1, 1, 8, 4, (ComposerDests.Dest)d.s16);
/* 68 */           s.singles.paste(true);
/* 69 */           return d.s16.saveGame();
/*    */         }
/* 71 */       }).get();
/*    */   }
/*    */   
/*    */   public TILE_SHEET getGrowable(Path path) throws IOException {
/* 75 */     return (new ComposerThings.ITileSheet(path, 364, 182)
/*    */       {
/*    */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*    */         {
/* 79 */           s.singles.init(0, 0, 1, 1, 8, 8, (ComposerDests.Dest)d.s16);
/* 80 */           s.singles.paste(true);
/* 81 */           return d.s16.saveGame();
/*    */         }
/* 83 */       }).get();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\Sprite$Util.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */