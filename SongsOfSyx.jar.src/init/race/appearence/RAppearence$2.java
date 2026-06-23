/*     */ package init.race.appearence;
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
/*     */ class null
/*     */   extends ComposerThings.ITileSheet
/*     */ {
/*     */   null(Path $anonymous0, int $anonymous1, int $anonymous2) throws IOException {
/* 100 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */   }
/*     */ 
/*     */   
/*     */   protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 105 */     s.full2.init(0, 0, 8, 1, 1, 1, d.s16);
/*     */     
/* 107 */     for (int i = 0; i < 4; i++) {
/* 108 */       int k; for (k = 0; k < 4; k++) {
/* 109 */         s.full2.setVar(4 + k).pasteRotated(i, true);
/*     */       }
/* 111 */       for (k = 0; k < 4; k++) {
/* 112 */         s.full2.setVar(k).pasteRotated((i + 1) % 4, true);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 118 */     return d.s16.saveGame();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\appearence\RAppearence$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */