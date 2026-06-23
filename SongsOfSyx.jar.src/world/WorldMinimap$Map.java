/*     */ package world;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import util.rendering.Minimap;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Map
/*     */ {
/* 308 */   public final Minimap map = new Minimap(256);
/* 309 */   private Bitmap1D changes = new Bitmap1D(1023, false);
/* 310 */   private int changedI = 1023;
/* 311 */   private final ColorImp cWork = new ColorImp();
/*     */   
/*     */   private void updateRegion(Region region) {
/* 314 */     this.changedI = Math.max(region.index(), this.changedI);
/* 315 */     this.changes.set(region.index(), true);
/*     */   }
/*     */   
/*     */   void clear() {
/* 319 */     this.changedI = 1023;
/* 320 */     this.changes.clear();
/*     */   }
/*     */   
/*     */   void redraw(int x1, int y1, int w, int h) {
/* 324 */     int px1 = CLAMP.i(this.map.width() * x1 / WORLD.TWIDTH(), 0, this.map.width());
/* 325 */     int py1 = CLAMP.i(this.map.height() * y1 / WORLD.THEIGHT(), 0, this.map.height());
/* 326 */     int px2 = CLAMP.i(this.map.width() * (x1 + w) / WORLD.TWIDTH(), 0, this.map.width());
/* 327 */     int py2 = CLAMP.i(this.map.height() * (y1 + h) / WORLD.THEIGHT(), 0, this.map.height());
/*     */     
/* 329 */     for (int py = py1; py < py2; py++) {
/* 330 */       for (int px = px1; px < px2; px++) {
/* 331 */         this.cWork.set(getColorP(px, py));
/* 332 */         this.cWork.shadeSelf(0.5D);
/* 333 */         this.map.putPixel(px, py, (COLOR)this.cWork);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 340 */   private static final COLOR cNone = (COLOR)new ColorImp(100, 100, 100);
/* 341 */   private final COLOR cBorderDark = (COLOR)new ColorImp(35, 35, 35);
/* 342 */   private final COLOR cBorderLight = (COLOR)new ColorImp(127, 127, 127);
/* 343 */   private final COLOR cOcean = (COLOR)new ColorImp(30, 35, 60);
/* 344 */   private final COLOR cOceanDeep = (COLOR)this.cOcean.shade(0.75D);
/* 345 */   private final COLOR cOceanBorder = (COLOR)this.cOcean.shade(0.5D);
/* 346 */   private final COLOR cMountainTop = (COLOR)new ColorImp(81, 75, 70);
/* 347 */   private final COLOR cMountainBorder = (COLOR)this.cMountainTop.shade(0.3D);
/*     */ 
/*     */ 
/*     */   
/*     */   private COLOR getColorP(int pixelX, int pixelY) {
/* 352 */     double dx = WORLD.TWIDTH();
/* 353 */     dx /= this.map.width();
/* 354 */     double dy = WORLD.THEIGHT();
/* 355 */     dy /= this.map.height();
/*     */     
/* 357 */     double wx = WORLD.TWIDTH() * pixelX / this.map.width();
/* 358 */     double wy = WORLD.THEIGHT() * pixelY / this.map.height();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 363 */     double rx = dx * 6.0D;
/* 364 */     double ry = dy * 6.0D;
/*     */     
/* 366 */     for (int y = (int)(wy - ry); y <= wy + ry; y++) {
/* 367 */       for (int x = (int)(wx - rx); x <= wx + rx; x++) {
/* 368 */         if (WORLD.IN_BOUNDS(x, y)) {
/*     */           
/* 370 */           Region r2 = (Region)(WORLD.REGIONS()).map.get(x, y);
/* 371 */           if (r2 != null && r2.capitol() && r2.info.cx() == x && r2.info.cy() == y) {
/* 372 */             int px = (int)(x / dx);
/* 373 */             int py = (int)(y / dy);
/* 374 */             int ddx = pixelX - px;
/* 375 */             int ddy = pixelY - py;
/* 376 */             double rad = (Math.abs(ddx) + Math.abs(ddy));
/*     */ 
/*     */             
/* 379 */             if (rad < 3.0D)
/* 380 */               return COLOR.BLACK; 
/* 381 */             if (rad == 3.0D) {
/* 382 */               return COLOR.WHITE100;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 389 */     Region r = (Region)(WORLD.REGIONS()).map.get((int)wx, (int)wy);
/*     */     
/* 391 */     if (r != null) {
/*     */       
/* 393 */       COLOR c = (r.faction() == null) ? cNone : (COLOR)r.faction().banner().colorBG();
/*     */       
/* 395 */       if (WORLD.IN_BOUNDS((int)(wx + dx), (int)wy) && !(WORLD.REGIONS()).map.is((int)(wx + dx), (int)wy, r))
/* 396 */         return (COLOR)ColorImp.TMP.interpolate(c, this.cBorderDark, 0.75D); 
/* 397 */       if (WORLD.IN_BOUNDS((int)wx, (int)(wy + dy)) && !(WORLD.REGIONS()).map.is((int)wx, (int)(wy + dy), r))
/* 398 */         return (COLOR)ColorImp.TMP.interpolate(c, this.cBorderDark, 0.75D); 
/* 399 */       if (WORLD.IN_BOUNDS((int)(wx - dx), (int)wy) && isDiffRealm((int)(wx - dx), (int)wy, r))
/* 400 */         return (COLOR)ColorImp.TMP.interpolate(c, this.cBorderLight, 0.75D); 
/* 401 */       if (WORLD.IN_BOUNDS((int)wx, (int)(wy - dy)) && isDiffRealm((int)wx, (int)(wy - dy), r)) {
/* 402 */         return (COLOR)ColorImp.TMP.interpolate(c, this.cBorderLight, 0.75D);
/*     */       }
/* 404 */       return c;
/*     */     } 
/*     */     
/* 407 */     int tx = (int)wx;
/* 408 */     int ty = (int)wy;
/* 409 */     if ((WORLD.WATER()).has.is(tx, ty) && (WORLD.WATER()).coversTile.is(tx, ty)) {
/* 410 */       for (DIR d : DIR.ORTHO) {
/* 411 */         int ddx = (int)(tx + d.x() * dx);
/* 412 */         int ddy = (int)(ty + d.y() * dy);
/* 413 */         if (!(WORLD.WATER()).coversTile.is(ddx, ddy) || (WORLD.REGIONS()).map.is(ddx, ddy))
/* 414 */           return this.cOceanBorder; 
/*     */       } 
/* 416 */       if ((WORLD.WATER()).OCEAN.deep.is(tx, ty) || (WORLD.WATER()).LAKE.deep.is(tx, ty))
/* 417 */         return this.cOceanDeep; 
/* 418 */       return this.cOcean;
/* 419 */     }  if (WORLD.MOUNTAIN().is(tx, ty)) {
/* 420 */       for (DIR d : DIR.ORTHO) {
/* 421 */         int ddx = (int)(tx + d.x() * dx);
/* 422 */         int ddy = (int)(ty + d.y() * dy);
/*     */         
/* 424 */         if (!WORLD.MOUNTAIN().is(tx, ty) || (WORLD.REGIONS()).map.is(ddx, ddy)) {
/* 425 */           return this.cMountainBorder;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 431 */       return (COLOR)ColorImp.TMP.interpolate(this.cMountainBorder, this.cMountainTop, WORLD.MOUNTAIN().getHeight(tx, ty) / 15.0D);
/*     */     } 
/* 433 */     return cNone;
/*     */   }
/*     */   
/*     */   private boolean isDiffRealm(int x, int y, Region r) {
/* 437 */     Region r2 = (Region)(WORLD.REGIONS()).map.get(x, y);
/* 438 */     if (r == r2)
/* 439 */       return false; 
/* 440 */     if (r2 == null)
/* 441 */       return true; 
/* 442 */     if (r.realm() == null || r2.realm() == null || r.realm() != r2.realm())
/* 443 */       return true; 
/* 444 */     return false;
/*     */   }
/*     */   
/*     */   public void repaint() {
/* 448 */     SPRITES.loader().print(WorldMinimap.¤¤painting);
/* 449 */     clear();
/* 450 */     int pWidth = this.map.width();
/* 451 */     int pHeight = this.map.height();
/*     */     
/* 453 */     byte[] pixels = Alloc.bb(pWidth * pHeight * 4);
/*     */     
/* 455 */     int i = 0;
/*     */     
/* 457 */     for (int py = 0; py < pHeight; py++) {
/* 458 */       for (int px = 0; px < pWidth; px++) {
/* 459 */         setPixel(pixels, i, getColorP(px, py));
/* 460 */         i += 4;
/*     */       } 
/*     */     } 
/*     */     
/* 464 */     this.map.putPixels(pixels);
/*     */   }
/*     */   
/*     */   private static void setPixel(byte[] pixels, int i, COLOR c) {
/* 468 */     pixels[i + 0] = (byte)(c.red() & 0xFF);
/* 469 */     pixels[i + 1] = (byte)(c.green() & 0xFF);
/* 470 */     pixels[i + 2] = (byte)(c.blue() & 0xFF);
/* 471 */     pixels[i + 3] = -1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\WorldMinimap$Map.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */