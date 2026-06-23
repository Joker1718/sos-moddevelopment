/*     */ package init.sprite.game;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.Errors;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.SnakeImage;
/*     */ import snake2d.util.sets.ArrayList;
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
/*     */ public class c1X1
/*     */   extends SheetType
/*     */ {
/*     */   c1X1() {
/* 222 */     super("1x1", 1, 22, 22, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<TILE_SHEET> make(String key, Json error) throws IOException {
/* 229 */     PATH pp = PATHS.SPRITE_GAME().getFolder(this.path);
/*     */     
/* 231 */     if (!pp.exists(key)) {
/* 232 */       if (error != null) {
/* 233 */         GAME.WarnLight(error.path());
/*     */       }
/* 235 */       GAME.WarnLight("The sprite file: " + key + " does not exist in the folder: " + String.valueOf(pp.get()) + error.path());
/* 236 */       return (LIST<TILE_SHEET>)new ArrayList(DUMMY);
/*     */     } 
/*     */     
/* 239 */     Path p = pp.get(key);
/*     */     
/* 241 */     SnakeImage im = new SnakeImage(p);
/*     */     
/* 243 */     int iwidth = im.width / 2;
/* 244 */     int iheight = im.height;
/* 245 */     im.dispose();
/*     */     
/* 247 */     int tilesX = iwidth / 22;
/*     */     
/* 249 */     if (tilesX * 22 != iwidth) {
/* 250 */       throw new Errors.DataError("Image is width is not a multiple of: 22", p);
/*     */     }
/*     */     
/* 253 */     int houseYs = size(iheight, p);
/* 254 */     int houseHeight = 6 + houseYs * 16;
/*     */ 
/*     */ 
/*     */     
/* 258 */     int houses = houseYs * iheight / houseHeight;
/*     */ 
/*     */ 
/*     */     
/* 262 */     ArrayList<TILE_SHEET> res = new ArrayList(houses);
/*     */     
/* 264 */     if (houseYs == 1) {
/* 265 */       for (int yy = 0; yy < houses; yy++) {
/* 266 */         TILE_SHEET s = make(tilesX, yy * houseHeight);
/* 267 */         res.add(s);
/*     */       } 
/*     */     } else {
/* 270 */       for (int yy = 0; yy < houses; yy++) {
/* 271 */         int y = houseHeight * yy / houseYs;
/* 272 */         if (yy % houseYs == 0) {
/* 273 */           TILE_SHEET s = makeFirst(tilesX, y);
/* 274 */           res.add(s);
/*     */         } else {
/* 276 */           y += 16 * yy % houseYs;
/* 277 */           TILE_SHEET s = make(tilesX, y);
/* 278 */           res.add(s);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 286 */     return (LIST<TILE_SHEET>)res;
/*     */   }
/*     */   
/*     */   private int size(int h, Path p) {
/* 290 */     for (int i = 1; i < 9; i++) {
/* 291 */       if (h % (16 * i + 6) == 0) {
/* 292 */         return i;
/*     */       }
/*     */     } 
/* 295 */     throw new Errors.DataError("Image has wrong dimensions. Image height must be a multiple of x*16+6 pixels. x = how many tiles. Yeah, I can't explain it better...", p);
/*     */   }
/*     */   
/*     */   private TILE_SHEET makeFirst(final int w, final int y1) throws IOException {
/* 299 */     return (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 303 */           s.full2.init(0, y1, w, 1, 1, 1, d.s16);
/* 304 */           for (int i = 0; i < w; i++) {
/* 305 */             s.full2.setVar(i).pasteRotated(2, true);
/* 306 */             s.full2.setVar(i).pasteRotated(3, true);
/* 307 */             s.full2.setVar(i).pasteRotated(0, true);
/* 308 */             s.full2.setVar(i).pasteRotated(1, true);
/*     */           } 
/* 310 */           return d.s16.saveGame();
/*     */         }
/* 312 */       }).get();
/*     */   }
/*     */ 
/*     */   
/*     */   public TILE_SHEET make(final int w, final int y1) throws IOException {
/* 317 */     return (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 321 */           s.full2.init(0, y1, w, 1, 1, 1, d.s16);
/* 322 */           for (int i = 0; i < w; i++) {
/* 323 */             s.full2.setVar(i).paste(3, true);
/*     */           }
/* 325 */           return d.s16.saveGame();
/*     */         }
/* 327 */       }).get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int tile(Sheet sheet, SheetData da, int data, int variation, int rotation) {
/* 334 */     variation &= 0xFFFF;
/* 335 */     int am = sheet.tiles;
/* 336 */     int tt = sheet.hasRotation ? 4 : 1;
/* 337 */     if (sheet.hasShadow) {
/* 338 */       am -= tt;
/*     */     }
/* 340 */     variation = getVar(variation, am / tt, da.circular);
/*     */     
/* 342 */     if (rotation >= 0 && sheet.hasRotation) {
/* 343 */       return (variation * tt % am & 0xFFFFFFFC) + (rotation & 0x3);
/*     */     }
/* 345 */     return variation % am;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderOverlay(int x, int y, SPRITE_RENDERER r, AVAILABILITY a, int data, int rotation, boolean single) {
/* 351 */     if (rotation < 0) {
/*     */       
/* 353 */       if (a.player < 0.0D) {
/* 354 */         (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/* 355 */       } else if (a.from > 1.0D || a.player > AVAILABILITY.ROOM.player) {
/* 356 */         (SPRITES.cons()).BIG.dashedThick.render(r, 0, x, y);
/*     */       } else {
/* 358 */         (SPRITES.cons()).BIG.outline.render(r, 0, x, y);
/*     */       } 
/*     */     } else {
/* 361 */       int var = 0;
/*     */ 
/*     */       
/* 364 */       if (a.player >= 0.0D)
/*     */       {
/* 366 */         if (a.from > 1.0D) {
/* 367 */           var = 1;
/*     */         } else {
/* 369 */           var = 2;
/* 370 */         }  }  if (single) {
/* 371 */         var += 3;
/*     */       }
/*     */       
/* 374 */       Sheet ss = SPRITES.GAME().overlay(this);
/* 375 */       int t = tile(ss, SheetData.DUMMY, 0, var, rotation);
/* 376 */       ss.render(null, x, y, null, r, t, 0, 0.0D);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\game\SheetType$c1X1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */