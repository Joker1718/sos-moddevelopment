/*     */ package world.map.terrain;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.sets.LIST;
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
/*     */ class Sprites
/*     */ {
/*     */   private static final int colorA = 64;
/* 267 */   private final COLOR[][] colors = new COLOR[64][64];
/*     */   
/* 269 */   public final TILE_SHEET bg = (new ComposerThings.ITileSheet(PATHS.SPRITE_WORLD_MAP().get("Forest"), 972, 280)
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 272 */         ComposerDests.Tile t = d.s24;
/* 273 */         s.singles.init(0, 0, 1, 1, 16, 6, (ComposerDests.Dest)t);
/* 274 */         for (int i = 0; i < 3; i++)
/* 275 */           s.singles.setSkip(i * 16, 16).paste(true); 
/* 276 */         return t.saveGame();
/*     */       }
/* 279 */     }).get();
/*     */   
/* 281 */   public final TILE_SHEET sheet = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 284 */         ComposerDests.Tile t = d.s24;
/* 285 */         for (int i = 0; i < 3; i++)
/* 286 */           s.singles.setSkip((i + 3) * 16, 16).paste(true); 
/* 287 */         return t.saveGame();
/*     */       }
/* 290 */     }).get();
/*     */ 
/*     */   
/*     */   Sprites() throws IOException {
/* 294 */     ColorImp wa = new ColorImp();
/* 295 */     ColorImp wb = new ColorImp();
/*     */     
/* 297 */     int seasons = 4;
/* 298 */     double stepsPerSeason = 16.0D;
/*     */     
/* 300 */     int randoms = 4;
/* 301 */     double stepsPerRandom = 16.0D;
/* 302 */     LIST<COLOR> cols = (new ComposerThings.IColorSampler()
/*     */       {
/*     */         protected COLOR next(int i, ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 306 */           return s.singles.setSkip(i, 1).sample();
/*     */         }
/*     */ 
/*     */         
/*     */         protected int init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/* 311 */           s.singles.init(0, s.singles.body().y2(), 1, 1, 4, 4, (ComposerDests.Dest)d.s16);
/* 312 */           return 16;
/*     */         }
/* 314 */       }).getHalf();
/* 315 */     for (double y = 0.0D; y < 64.0D; y++) {
/*     */       
/* 317 */       int seasonFrom = (int)Math.floor(y / 16.0D);
/* 318 */       int seasonTo = (int)Math.ceil(y / 16.0D);
/* 319 */       seasonTo %= 4;
/* 320 */       double seasonDelta = (y - seasonFrom * 16.0D) / 16.0D;
/* 321 */       for (double r = 0.0D; r < 64.0D; r++) {
/* 322 */         int ranFrom = (int)Math.floor(r / 16.0D);
/* 323 */         int ranTo = (int)Math.ceil(r / 16.0D);
/* 324 */         ranTo %= 4;
/* 325 */         double ranDelta = (r - ranFrom * 16.0D) / 16.0D;
/*     */         
/* 327 */         wa.interpolate((COLOR)cols.get(seasonFrom * 4 + ranFrom), (COLOR)cols.get(seasonFrom * 4 + ranTo), 
/* 328 */             ranDelta);
/* 329 */         wb.interpolate((COLOR)cols.get(seasonTo * 4 + ranFrom), (COLOR)cols.get(seasonTo * 4 + ranTo), 
/* 330 */             ranDelta);
/* 331 */         ColorImp res = new ColorImp();
/* 332 */         res.interpolate((COLOR)wa, (COLOR)wb, seasonDelta);
/* 333 */         this.colors[(int)y][(int)r] = (COLOR)res;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldForest$Sprites.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */