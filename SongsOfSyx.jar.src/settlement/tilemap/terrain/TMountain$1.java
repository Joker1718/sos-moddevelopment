/*    */ package settlement.tilemap.terrain;
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
/*    */ class null
/*    */   extends ComposerThings.ITileSheet
/*    */ {
/*    */   null(Path $anonymous0, int $anonymous1, int $anonymous2) throws IOException {
/* 49 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 53 */     ComposerDests.Tile t = d.s16;
/* 54 */     s.house2.init(0, 0, 3, 1, (ComposerDests.Dest)t);
/* 55 */     s.house2.setVar(0).paste(1, true);
/* 56 */     s.house2.setVar(1).paste(2, true);
/* 57 */     s.house2.setVar(2).paste(2, true);
/*    */     
/* 59 */     s.full.init(0, s.house2.body().y2(), 1, 1, 16, 1, t);
/* 60 */     s.full.setSkip(16, 0).paste(true);
/*    */ 
/*    */     
/* 63 */     return t.saveGame();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TMountain$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */