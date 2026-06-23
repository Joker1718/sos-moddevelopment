/*     */ package world.map.regions.centre;
/*     */ 
/*     */ import java.io.IOException;
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
/*     */ class Size
/*     */ {
/* 304 */   private final TILE_SHEET corners = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/* 308 */         ComposerSources.Full f = s.full;
/* 309 */         for (int i = 0; i <= 1; i++) {
/* 310 */           f.setVar(var + 5 * i);
/* 311 */           f.setSkip(1, 0).paste(true);
/* 312 */           f.setSkip(1, 5).paste(true);
/* 313 */           f.setSkip(1, 30).paste(true);
/* 314 */           f.setSkip(1, 35).paste(true);
/*     */         } 
/*     */         
/* 317 */         return d.s8.saveGame();
/*     */       }
/* 320 */     }).get();
/*     */   
/* 322 */   private final TILE_SHEET gate = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/* 326 */         ComposerSources.Full f = s.full;
/* 327 */         for (int i = 0; i <= 1; i++) {
/* 328 */           f.setVar(var + 5 * i);
/* 329 */           f.setSkip(1, 2).paste(true);
/* 330 */           f.setSkip(1, 3).paste(true);
/* 331 */           f.setSkip(1, 12).paste(true);
/* 332 */           f.setSkip(1, 18).paste(true);
/* 333 */           f.setSkip(1, 17).paste(true);
/* 334 */           f.setSkip(1, 23).paste(true);
/* 335 */           f.setSkip(1, 32).paste(true);
/* 336 */           f.setSkip(1, 33).paste(true);
/*     */         } 
/*     */         
/* 339 */         return d.s8.saveGame();
/*     */       }
/* 342 */     }).get();
/*     */   
/* 344 */   private final TILE_SHEET walls = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/* 348 */         ComposerSources.Full f = s.full;
/* 349 */         for (int i = 0; i <= 1; i++) {
/* 350 */           f.setVar(var + 5 * i);
/* 351 */           f.setSkip(1, 1).paste(true);
/* 352 */           f.setSkip(1, 4).paste(true);
/* 353 */           f.setSkip(1, 6).paste(true);
/* 354 */           f.setSkip(1, 11).paste(true);
/* 355 */           f.setSkip(1, 24).paste(true);
/* 356 */           f.setSkip(1, 29).paste(true);
/* 357 */           f.setSkip(1, 31).paste(true);
/* 358 */           f.setSkip(1, 34).paste(true);
/*     */         } 
/*     */         
/* 361 */         return d.s8.saveGame();
/*     */       }
/* 364 */     }).get();
/*     */   
/*     */   Size(final int var) throws IOException {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\centre\WorldRaceSheet$WallSteriods$Size.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */