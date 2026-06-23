/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends ComposerThings.ITileSheet
/*     */ {
/*     */   null(Path $anonymous0, int $anonymous1, int $anonymous2) throws IOException {
/* 114 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */   }
/*     */   
/*     */   protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 118 */     ComposerDests.Tile t = d.s16;
/* 119 */     s.house.init(0, 0, 4, 2, (ComposerDests.Dest)t);
/*     */     
/* 121 */     s.house.setVar(0).paste(1, true);
/* 122 */     s.house.setVar(1).pasteRotated(2, true);
/* 123 */     s.house.setVar(1).pasteRotated(3, true);
/*     */ 
/*     */     
/* 126 */     s.house.setVar(2).paste(1, true);
/* 127 */     s.house.setVar(3).pasteRotated(2, true);
/* 128 */     s.house.setVar(3).pasteRotated(3, true);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 133 */     s.house.setVar(4).paste(1, true);
/* 134 */     s.house.setVar(5).pasteRotated(2, true);
/* 135 */     s.house.setVar(5).pasteRotated(3, true);
/*     */     
/* 137 */     s.house.setVar(0).pasteEdges(true);
/* 138 */     s.house.setVar(1).pasteEdges(true);
/* 139 */     s.house.setVar(2).pasteEdges(true);
/* 140 */     s.house.setVar(3).pasteEdges(true);
/*     */     
/* 142 */     s.full.init(0, s.house.body().y2(), 1, 1, 16, 1, t);
/* 143 */     s.full.paste(true);
/*     */     
/* 145 */     s.full.init(0, s.full.body().y2(), 1, 1, 16, 1, t);
/* 146 */     s.full.paste(true);
/*     */     
/* 148 */     return t.saveGame();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TBuilding$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */