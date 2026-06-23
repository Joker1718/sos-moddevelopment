/*    */ package world.map.terrain;
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
/*    */ class null
/*    */   extends ComposerThings.ITileSheet
/*    */ {
/*    */   null(Path $anonymous0, int $anonymous1, int $anonymous2) throws IOException {
/* 52 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 56 */     ComposerDests.Tile t = d.s16;
/* 57 */     s.house2.init(0, 0, 3, 3, (ComposerDests.Dest)t);
/*    */     
/* 59 */     s.house2.setVar(0).paste(2, true);
/* 60 */     s.house2.setVar(1).paste(2, true);
/* 61 */     s.house2.setVar(2).paste(1, true);
/*    */     
/* 63 */     s.house2.setVar(3).paste(2, true);
/* 64 */     s.house2.setVar(4).paste(2, true);
/* 65 */     s.house2.setVar(5).paste(1, true);
/*    */     
/* 67 */     s.house2.setVar(6).paste(true);
/* 68 */     s.house2.setVar(7).paste(true);
/* 69 */     s.house2.setVar(8).paste(1, true);
/*    */     
/* 71 */     s.full.init(0, s.house2.body().y2(), 1, 1, 16, 3, t);
/* 72 */     s.full.setSkip(16, 0).paste(1, true);
/* 73 */     s.full.setSkip(4, 16).paste(3, true);
/* 74 */     return t.saveGame();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldMountain$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */