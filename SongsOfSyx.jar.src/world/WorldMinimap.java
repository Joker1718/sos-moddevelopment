/*     */ package world;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.colors.GCOLOR;
/*     */ import util.rendering.Minimap;
/*     */ import util.text.D;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class WorldMinimap
/*     */ {
/*     */   public static final int WIDTH = 256;
/*     */   public static final int HEIGHT = 256;
/*  36 */   private final Map map = new Map();
/*  37 */   private final int dc = 8;
/*     */   private final Chunk[][] chunks;
/*  39 */   private Chunk[][] regionMap = new Chunk[1023][];
/*     */   
/*     */   private boolean dirty;
/*  42 */   private final byte Ivisible = 1;
/*  43 */   private final byte ItmpVisible = 2;
/*  44 */   private final byte ItmpHilit = 4;
/*     */   
/*     */   private boolean repaint = true;
/*  47 */   private static CharSequence ¤¤painting = "¤Painting world minimap"; private Coo cUp;
/*     */   static {
/*  49 */     D.ts(WorldMinimap.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void repaint() {
/*  75 */     this.repaint = true;
/*  76 */     this.dirty = true;
/*     */   }
/*     */   
/*     */   private void prepaint() {
/*  80 */     this.map.repaint();
/*  81 */     int[][] map = Alloc.i2(this.chunks.length, (this.chunks[0]).length);
/*  82 */     for (Region reg : WORLD.REGIONS().active()) {
/*  83 */       LinkedList<Chunk> chunks = new LinkedList();
/*  84 */       for (COORDINATE c : reg.info.bounds()) {
/*  85 */         if (!reg.is(c))
/*     */           continue; 
/*  87 */         Chunk ch = chunk(c.x(), c.y());
/*  88 */         if (map[ch.y][ch.x] != reg.index()) {
/*  89 */           chunks.add(ch);
/*  90 */           map[ch.y][ch.x] = reg.index();
/*     */         } 
/*     */       } 
/*  93 */       this.regionMap[reg.index()] = new Chunk[chunks.size()];
/*  94 */       int j = 0;
/*  95 */       for (Chunk c : chunks) {
/*  96 */         this.regionMap[reg.index()][j++] = c;
/*  97 */         c.dirty = false;
/*     */       } 
/*     */     }  byte b; int i; Chunk[][] arrayOfChunk;
/* 100 */     for (i = (arrayOfChunk = this.chunks).length, b = 0; b < i; ) { Chunk[] cs = arrayOfChunk[b]; byte b1; int j; Chunk[] arrayOfChunk1;
/* 101 */       for (j = (arrayOfChunk1 = cs).length, b1 = 0; b1 < j; ) { Chunk c = arrayOfChunk1[b1];
/* 102 */         c.dirty = false; b1++; }  b++; }
/* 103 */      this.dirty = true;
/*     */   }
/*     */   
/*     */   public void setDirty() {
/* 107 */     this.dirty = true;
/*     */   }
/*     */   
/* 110 */   public WorldMinimap(int width, int height) throws IOException { this.cUp = new Coo(); this.chunks = new Chunk[(int)Math.ceil(width / 8.0D)][(int)Math.ceil(height / 8.0D)]; for (int y = 0; y < this.chunks.length; y++) {
/*     */       for (int x = 0; x < (this.chunks[y]).length; x++)
/*     */         this.chunks[y][x] = new Chunk(x, y); 
/* 113 */     }  } public void update() { if (this.repaint) {
/* 114 */       this.repaint = false;
/* 115 */       prepaint();
/*     */     } 
/*     */     
/* 118 */     for (int i = 0; i < 5; i++) {
/* 119 */       int x = this.cUp.x();
/* 120 */       int y = this.cUp.y();
/*     */       
/* 122 */       Chunk c = this.chunks[y][x];
/*     */       
/* 124 */       if (c.dirty) {
/* 125 */         c.dirty = false;
/* 126 */         this.map.redraw(c.x * 8, c.y * 8, 8, 8);
/*     */       } 
/*     */       
/* 129 */       this.cUp.xIncrement(1.0D);
/* 130 */       if (this.cUp.x() >= (this.chunks[0]).length) {
/* 131 */         this.cUp.xSet(0.0D);
/* 132 */         this.cUp.yIncrement(1.0D);
/* 133 */         if (this.cUp.y() >= this.chunks.length) {
/* 134 */           this.cUp.ySet(0.0D);
/*     */         }
/*     */       } 
/*     */     }  }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int x1, int y1) {
/* 142 */     if (this.dirty) {
/* 143 */       this.dirty = false; byte b1; int j;
/*     */       Chunk[][] arrayOfChunk1;
/* 145 */       for (j = (arrayOfChunk1 = this.chunks).length, b1 = 0; b1 < j; ) { Chunk[] cs = arrayOfChunk1[b1]; byte b2; int k; Chunk[] arrayOfChunk2;
/* 146 */         for (k = (arrayOfChunk2 = cs).length, b2 = 0; b2 < k; ) { Chunk c = arrayOfChunk2[b2];
/* 147 */           c.type = (byte)(c.type & 0xFFFFFFFE); b2++; }
/*     */          b1++; }
/*     */       
/* 150 */       for (Region reg : WORLD.REGIONS().active()) {
/* 151 */         if (reg.faction() == FACTIONS.player() || RD.DIST().reachable(reg) || (reg.faction() != null && RD.DIST().reachable(reg.faction()))) {
/* 152 */           set(reg, (byte)1);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 158 */     this.map.map.render(r, x1, y1);
/*     */     
/* 160 */     for (int ai = 0; ai < (WORLD.ENTITIES()).armies.max(); ai++) {
/* 161 */       WArmy a = (WORLD.ENTITIES()).armies.get(ai);
/* 162 */       if (a != null)
/*     */       {
/*     */         
/* 165 */         if (a.faction() == FACTIONS.player()) {
/*     */           
/* 167 */           (chunk(a.ctx(), a.cty())).type = (byte)((chunk(a.ctx(), a.cty())).type | 0x2);
/* 168 */           for (DIR d : DIR.ALL) {
/* 169 */             int dx = (int)(a.ctx() + d.xN() * 4.0D);
/* 170 */             int dy = (int)(a.cty() + d.yN() * 4.0D);
/* 171 */             if (WORLD.TBOUNDS().holdsPoint(dx, dy)) {
/* 172 */               (chunk(dx, dy)).type = (byte)((chunk(dx, dy)).type | 0x2);
/*     */             }
/*     */           }
/*     */         
/*     */         }
/* 177 */         else if (!WORLD.FOW().is(a.ctx(), a.cty())) {
/*     */ 
/*     */           
/* 180 */           int cx = this.map.map.width() * a.ctx() / WORLD.TWIDTH();
/* 181 */           int cy = this.map.map.height() * a.cty() / WORLD.THEIGHT();
/*     */           
/* 183 */           cx += x1;
/* 184 */           cy += y1;
/* 185 */           OPACITY.O25TO100.bind();
/* 186 */           COLOR.BLACK.render(r, cx - 4, cx + 4, cy - 4, cy + 4);
/* 187 */           COLOR.WHITE100.render(r, cx - 3, cx + 3, cy - 3, cy + 3);
/* 188 */           COLOR c = GCOLOR.MAP().get(a.faction());
/*     */           
/* 190 */           c.render(r, cx - 2, cx + 2, cy - 2, cy + 2);
/*     */         }  } 
/*     */     } 
/* 193 */     OPACITY.unbind();
/* 194 */     COLOR.unbind();
/*     */     
/* 196 */     int ci = 0;
/*     */     
/* 198 */     OPACITY.O50.bind(); byte b; int i; Chunk[][] arrayOfChunk;
/* 199 */     for (i = (arrayOfChunk = this.chunks).length, b = 0; b < i; ) { Chunk[] cs = arrayOfChunk[b]; byte b1; int j; Chunk[] arrayOfChunk1;
/* 200 */       for (j = (arrayOfChunk1 = cs).length, b1 = 0; b1 < j; ) { Chunk c = arrayOfChunk1[b1];
/*     */         
/* 202 */         if (ci < 5 && c.dirty) {
/* 203 */           c.dirty = false;
/* 204 */           ci++;
/* 205 */           this.map.redraw(c.x * 8, c.y * 8, 8, 8);
/*     */         } 
/*     */         
/* 208 */         if ((c.type & 0x4) != 0) {
/* 209 */           int x = x1 + c.x * 8;
/* 210 */           int y = y1 + c.y * 8;
/* 211 */           COLOR.WHITE120_2_WHITE150.render(r, x, x + 8, y, y + 8);
/* 212 */         } else if ((WORLD.FOW()).toggled.is() && (c.type & 0x1) == 0 && (c.type & 0x2) == 0) {
/*     */ 
/*     */ 
/*     */           
/* 216 */           int x = x1 + c.x * 8;
/* 217 */           int y = y1 + c.y * 8;
/* 218 */           COLOR.BLACK.render(r, x, x + 8, y, y + 8);
/*     */         } 
/*     */         
/* 221 */         c.type = (byte)(c.type & 0x1);
/*     */         b1++; }
/*     */       
/*     */       b++; }
/*     */     
/* 226 */     OPACITY.unbind();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hilight(Faction fac) {
/* 232 */     for (int i = 0; i < fac.realm().regions(); i++)
/* 233 */       hilight(fac.realm().region(i)); 
/*     */   }
/*     */   
/*     */   public void hilight(Region reg) {
/* 237 */     set(reg, (byte)4);
/*     */   }
/*     */ 
/*     */   
/*     */   private void set(Region reg, byte mask) {
/* 242 */     if (this.regionMap[reg.index()] == null)
/*     */       return;  byte b; int i; Chunk[] arrayOfChunk;
/* 244 */     for (i = (arrayOfChunk = this.regionMap[reg.index()]).length, b = 0; b < i; ) { Chunk c = arrayOfChunk[b];
/* 245 */       c.type = (byte)(c.type | mask);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   private Chunk chunk(int tx, int ty) {
/* 250 */     return this.chunks[ty / 8][tx / 8];
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateRegion(Region c) {
/* 255 */     int px1 = c.info.bounds().x1() / 8 - 4;
/* 256 */     int py1 = c.info.bounds().y1() / 8 - 4;
/* 257 */     int px2 = c.info.bounds().x2() / 8 + 4;
/* 258 */     int py2 = c.info.bounds().y2() / 8 + 4;
/*     */     
/* 260 */     for (int y = py1; y < py2; y++) {
/* 261 */       if (y >= 0 && y < this.chunks.length) {
/* 262 */         for (int x = px1; x < px2; x++) {
/* 263 */           if (x >= 0 && x < this.chunks.length) {
/* 264 */             (this.chunks[y][x]).dirty = true;
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(int tx, int ty) {
/* 273 */     int px1 = tx / 8 - 4;
/* 274 */     int py1 = ty / 8 - 4;
/* 275 */     int px2 = tx / 8 + 4;
/* 276 */     int py2 = ty / 8 + 4;
/*     */     
/* 278 */     for (int y = py1; y < py2; y++) {
/* 279 */       if (y >= 0 && y < this.chunks.length) {
/* 280 */         for (int x = px1; x < px2; x++) {
/* 281 */           if (x >= 0 && x < this.chunks.length) {
/* 282 */             (this.chunks[y][x]).dirty = true;
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private static class Chunk
/*     */   {
/*     */     private final int x;
/*     */     private final int y;
/*     */     private byte type;
/*     */     private boolean dirty;
/*     */     
/*     */     Chunk(int x, int y) {
/* 297 */       this.x = x;
/* 298 */       this.y = y;
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class Map {
/*     */     public final Minimap map;
/*     */     private Bitmap1D changes;
/*     */     private int changedI;
/*     */     private final ColorImp cWork;
/*     */     
/* 308 */     Map() throws IOException { this.map = new Minimap(256);
/* 309 */       this.changes = new Bitmap1D(1023, false);
/* 310 */       this.changedI = 1023;
/* 311 */       this.cWork = new ColorImp();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 341 */       this.cBorderDark = (COLOR)new ColorImp(35, 35, 35);
/* 342 */       this.cBorderLight = (COLOR)new ColorImp(127, 127, 127);
/* 343 */       this.cOcean = (COLOR)new ColorImp(30, 35, 60);
/* 344 */       this.cOceanDeep = (COLOR)this.cOcean.shade(0.75D);
/* 345 */       this.cOceanBorder = (COLOR)this.cOcean.shade(0.5D);
/* 346 */       this.cMountainTop = (COLOR)new ColorImp(81, 75, 70);
/* 347 */       this.cMountainBorder = (COLOR)this.cMountainTop.shade(0.3D); }
/*     */     private void updateRegion(Region region) { this.changedI = Math.max(region.index(), this.changedI); this.changes.set(region.index(), true); }
/*     */     void clear() { this.changedI = 1023; this.changes.clear(); }
/*     */     void redraw(int x1, int y1, int w, int h) { int px1 = CLAMP.i(this.map.width() * x1 / WORLD.TWIDTH(), 0, this.map.width()); int py1 = CLAMP.i(this.map.height() * y1 / WORLD.THEIGHT(), 0, this.map.height()); int px2 = CLAMP.i(this.map.width() * (x1 + w) / WORLD.TWIDTH(), 0, this.map.width()); int py2 = CLAMP.i(this.map.height() * (y1 + h) / WORLD.THEIGHT(), 0, this.map.height()); for (int py = py1; py < py2; py++) { for (int px = px1; px < px2; px++) { this.cWork.set(getColorP(px, py)); this.cWork.shadeSelf(0.5D); this.map.putPixel(px, py, (COLOR)this.cWork); }
/*     */          }
/* 352 */        } private static final COLOR cNone = (COLOR)new ColorImp(100, 100, 100); private final COLOR cBorderDark; private COLOR getColorP(int pixelX, int pixelY) { double dx = WORLD.TWIDTH();
/* 353 */       dx /= this.map.width();
/* 354 */       double dy = WORLD.THEIGHT();
/* 355 */       dy /= this.map.height();
/*     */       
/* 357 */       double wx = WORLD.TWIDTH() * pixelX / this.map.width();
/* 358 */       double wy = WORLD.THEIGHT() * pixelY / this.map.height();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 363 */       double rx = dx * 6.0D;
/* 364 */       double ry = dy * 6.0D;
/*     */       
/* 366 */       for (int y = (int)(wy - ry); y <= wy + ry; y++) {
/* 367 */         for (int x = (int)(wx - rx); x <= wx + rx; x++) {
/* 368 */           if (WORLD.IN_BOUNDS(x, y)) {
/*     */             
/* 370 */             Region r2 = (Region)(WORLD.REGIONS()).map.get(x, y);
/* 371 */             if (r2 != null && r2.capitol() && r2.info.cx() == x && r2.info.cy() == y) {
/* 372 */               int px = (int)(x / dx);
/* 373 */               int py = (int)(y / dy);
/* 374 */               int ddx = pixelX - px;
/* 375 */               int ddy = pixelY - py;
/* 376 */               double rad = (Math.abs(ddx) + Math.abs(ddy));
/*     */ 
/*     */               
/* 379 */               if (rad < 3.0D)
/* 380 */                 return COLOR.BLACK; 
/* 381 */               if (rad == 3.0D) {
/* 382 */                 return COLOR.WHITE100;
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 389 */       Region r = (Region)(WORLD.REGIONS()).map.get((int)wx, (int)wy);
/*     */       
/* 391 */       if (r != null) {
/*     */         
/* 393 */         COLOR c = (r.faction() == null) ? cNone : (COLOR)r.faction().banner().colorBG();
/*     */         
/* 395 */         if (WORLD.IN_BOUNDS((int)(wx + dx), (int)wy) && !(WORLD.REGIONS()).map.is((int)(wx + dx), (int)wy, r))
/* 396 */           return (COLOR)ColorImp.TMP.interpolate(c, this.cBorderDark, 0.75D); 
/* 397 */         if (WORLD.IN_BOUNDS((int)wx, (int)(wy + dy)) && !(WORLD.REGIONS()).map.is((int)wx, (int)(wy + dy), r))
/* 398 */           return (COLOR)ColorImp.TMP.interpolate(c, this.cBorderDark, 0.75D); 
/* 399 */         if (WORLD.IN_BOUNDS((int)(wx - dx), (int)wy) && isDiffRealm((int)(wx - dx), (int)wy, r))
/* 400 */           return (COLOR)ColorImp.TMP.interpolate(c, this.cBorderLight, 0.75D); 
/* 401 */         if (WORLD.IN_BOUNDS((int)wx, (int)(wy - dy)) && isDiffRealm((int)wx, (int)(wy - dy), r)) {
/* 402 */           return (COLOR)ColorImp.TMP.interpolate(c, this.cBorderLight, 0.75D);
/*     */         }
/* 404 */         return c;
/*     */       } 
/*     */       
/* 407 */       int tx = (int)wx;
/* 408 */       int ty = (int)wy;
/* 409 */       if ((WORLD.WATER()).has.is(tx, ty) && (WORLD.WATER()).coversTile.is(tx, ty)) {
/* 410 */         for (DIR d : DIR.ORTHO) {
/* 411 */           int ddx = (int)(tx + d.x() * dx);
/* 412 */           int ddy = (int)(ty + d.y() * dy);
/* 413 */           if (!(WORLD.WATER()).coversTile.is(ddx, ddy) || (WORLD.REGIONS()).map.is(ddx, ddy))
/* 414 */             return this.cOceanBorder; 
/*     */         } 
/* 416 */         if ((WORLD.WATER()).OCEAN.deep.is(tx, ty) || (WORLD.WATER()).LAKE.deep.is(tx, ty))
/* 417 */           return this.cOceanDeep; 
/* 418 */         return this.cOcean;
/* 419 */       }  if (WORLD.MOUNTAIN().is(tx, ty)) {
/* 420 */         for (DIR d : DIR.ORTHO) {
/* 421 */           int ddx = (int)(tx + d.x() * dx);
/* 422 */           int ddy = (int)(ty + d.y() * dy);
/*     */           
/* 424 */           if (!WORLD.MOUNTAIN().is(tx, ty) || (WORLD.REGIONS()).map.is(ddx, ddy)) {
/* 425 */             return this.cMountainBorder;
/*     */           }
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 431 */         return (COLOR)ColorImp.TMP.interpolate(this.cMountainBorder, this.cMountainTop, WORLD.MOUNTAIN().getHeight(tx, ty) / 15.0D);
/*     */       } 
/* 433 */       return cNone; }
/*     */     
/*     */     private final COLOR cBorderLight; private final COLOR cOcean; private final COLOR cOceanDeep; private final COLOR cOceanBorder; private final COLOR cMountainTop; private final COLOR cMountainBorder;
/*     */     private boolean isDiffRealm(int x, int y, Region r) {
/* 437 */       Region r2 = (Region)(WORLD.REGIONS()).map.get(x, y);
/* 438 */       if (r == r2)
/* 439 */         return false; 
/* 440 */       if (r2 == null)
/* 441 */         return true; 
/* 442 */       if (r.realm() == null || r2.realm() == null || r.realm() != r2.realm())
/* 443 */         return true; 
/* 444 */       return false;
/*     */     }
/*     */     
/*     */     public void repaint() {
/* 448 */       SPRITES.loader().print(WorldMinimap.¤¤painting);
/* 449 */       clear();
/* 450 */       int pWidth = this.map.width();
/* 451 */       int pHeight = this.map.height();
/*     */       
/* 453 */       byte[] pixels = Alloc.bb(pWidth * pHeight * 4);
/*     */       
/* 455 */       int i = 0;
/*     */       
/* 457 */       for (int py = 0; py < pHeight; py++) {
/* 458 */         for (int px = 0; px < pWidth; px++) {
/* 459 */           setPixel(pixels, i, getColorP(px, py));
/* 460 */           i += 4;
/*     */         } 
/*     */       } 
/*     */       
/* 464 */       this.map.putPixels(pixels);
/*     */     }
/*     */     
/*     */     private static void setPixel(byte[] pixels, int i, COLOR c) {
/* 468 */       pixels[i + 0] = (byte)(c.red() & 0xFF);
/* 469 */       pixels[i + 1] = (byte)(c.green() & 0xFF);
/* 470 */       pixels[i + 2] = (byte)(c.blue() & 0xFF);
/* 471 */       pixels[i + 3] = -1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\WorldMinimap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */