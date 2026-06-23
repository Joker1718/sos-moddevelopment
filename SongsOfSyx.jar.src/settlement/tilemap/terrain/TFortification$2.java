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
/*     */ class null
/*     */   extends ComposerThings.ITileSheet
/*     */ {
/*     */   null(Path $anonymous0, int $anonymous1, int $anonymous2) throws IOException {
/* 102 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */   }
/*     */   
/*     */   protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 106 */     s.house.init(0, 0, 4, 2, (ComposerDests.Dest)d.s16);
/* 107 */     s.house.setVar(0).paste(true);
/* 108 */     s.house.setVar(0).pasteRotated(2, true);
/* 109 */     s.house.setVar(1).paste(true);
/* 110 */     s.house.setVar(1).pasteRotated(2, true);
/* 111 */     s.house.setVar(2).paste(true);
/* 112 */     s.house.setVar(2).pasteRotated(2, true);
/* 113 */     s.house.setVar(3).paste(true);
/* 114 */     s.house.setVar(3).pasteRotated(2, true);
/*     */     
/* 116 */     s.house.setVar(0).setSkip(0, 1).pasteEdges(true);
/*     */     
/* 118 */     s.house.setVar(4).setSkip(0, 16).paste(true);
/* 119 */     s.house.setVar(4).pasteRotated(2, true);
/* 120 */     s.house.setVar(5).paste(true);
/* 121 */     s.house.setVar(5).pasteRotated(2, true);
/*     */     
/* 123 */     s.full.init(144, 72, 1, 1, 8, 1, d.s16);
/* 124 */     s.full.paste(true);
/* 125 */     s.full.pasteRotated(2, true);
/* 126 */     s.full.init(s.full.body().x1(), s.full.body().y2(), 1, 1, 8, 1, d.s16);
/* 127 */     s.full.paste(true);
/* 128 */     s.full.pasteRotated(2, true);
/*     */     
/* 130 */     return d.s16.saveGame();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TFortification$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */