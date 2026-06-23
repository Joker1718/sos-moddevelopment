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
/*    */ class null
/*    */   extends ComposerThings.ITileSheet
/*    */ {
/*    */   null(Path $anonymous0, int $anonymous1, int $anonymous2) throws IOException {
/* 30 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 33 */     s.house.init(0, 0, 4, 1, (ComposerDests.Dest)d.s16);
/* 34 */     for (int i = 0; i < 4; i++)
/* 35 */       s.house.setVar(i).paste(true); 
/* 36 */     s.full.init(0, s.house.body().y2(), 2, 4, 8, 8, d.s16);
/* 37 */     return d.s16.saveGame();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldGroundSprites$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */