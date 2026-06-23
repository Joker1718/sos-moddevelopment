/*     */ package snake2d.util.rnd;
/*     */ 
/*     */ import java.io.File;
/*     */ import snake2d.Printer;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.SnakeImage;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.map.MAP_BOOLEANE;
/*     */ import snake2d.util.map.MAP_INT;
/*     */ 
/*     */ public class Polymap implements BODY_HOLDER {
/*     */   private final int width;
/*     */   private final int height;
/*     */   private final RECTANGLE bounds;
/*     */   private final int[] ids;
/*     */   private final double r;
/*     */   private final double ri;
/*     */   private int checkI;
/*     */   private int[] checkers;
/*     */   private final RECTANGLE body;
/*     */   public final MAP_BOOLEANE checker;
/*     */   public MAP_INT getter;
/*     */   public MAP_BOOLEAN isEdge;
/*     */   
/*     */   public Polymap(int width, int height) {
/*  33 */     this(width, height, 1.0D);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Polymap(int width, int height, double scale)
/*     */   {
/*  69 */     this.getter = new MAP_INT()
/*     */       {
/*     */         public int get(int tx, int ty)
/*     */         {
/*  73 */           return get(tx + ty * Polymap.this.width);
/*     */         }
/*     */ 
/*     */         
/*     */         public int get(int tile) {
/*  78 */           return Polymap.this.ids[tile];
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 236 */     this.isEdge = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 240 */           if (!Polymap.this.bounds.holdsPoint(tx, ty)) {
/* 241 */             return false;
/*     */           }
/* 243 */           int id = Polymap.this.ids[tx + ty * Polymap.this.width];
/* 244 */           DIR d = DIR.E;
/*     */           
/* 246 */           for (int i = 0; i < 2; i++) {
/*     */             
/* 248 */             int x = tx + d.x();
/* 249 */             int y = ty + d.y();
/* 250 */             if (Polymap.this.bounds.holdsPoint(x, y) && 
/* 251 */               id != Polymap.this.ids[x + y * Polymap.this.width]) {
/* 252 */               return true;
/*     */             }
/* 254 */             d = d.next(2);
/*     */           } 
/* 256 */           return false;
/*     */         }
/*     */         
/*     */         public boolean is(int tile)
/*     */         {
/* 261 */           return is(tile % Polymap.this.bounds.width(), tile / Polymap.this.bounds.width()); } }; this.width = width; this.height = height; this.ids = Alloc.ii(height * width); this.bounds = (RECTANGLE)new Rec(width, height); float[][] heights = new float[height][width]; double a = scale * width * height / 163.0D; int id = 1; this.r = 64.0D * scale; this.ri = 1.0D / this.r; for (int i = 0; i < a; i++) polly(RND.rInt(width), RND.rInt(height), id++, heights);  this.checkers = Alloc.ii(id); this.body = (RECTANGLE)new Rec(width, height); this.checker = (MAP_BOOLEANE)new MAP_BOOLEANE.BooleanMapE(width, height) { public MAP_BOOLEANE set(int tile, boolean value) { if (value) { Polymap.this.checkers[Polymap.this.ids[tile]] = Polymap.this.checkI; } else { Polymap.this.checkers[Polymap.this.ids[tile]] = Polymap.this.checkI - 1; }  return (MAP_BOOLEANE)this; } public boolean is(int tile) { return (Polymap.this.checkers[Polymap.this.ids[tile]] == Polymap.this.checkI); } }; } public Polymap(int width, int height, int size, double relaxation) { this.getter = new MAP_INT() { public int get(int tx, int ty) { return get(tx + ty * Polymap.this.width); } public int get(int tile) { return Polymap.this.ids[tile]; } }; this.isEdge = new MAP_BOOLEAN() { public boolean is(int tx, int ty) { if (!Polymap.this.bounds.holdsPoint(tx, ty)) return false;  int id = Polymap.this.ids[tx + ty * Polymap.this.width]; DIR d = DIR.E; for (int i = 0; i < 2; i++) { int x = tx + d.x(); int y = ty + d.y(); if (Polymap.this.bounds.holdsPoint(x, y) && id != Polymap.this.ids[x + y * Polymap.this.width]) return true;  d = d.next(2); }  return false; } public MAP_BOOLEANE set(int tile, boolean value) { if (value) { Polymap.this.checkers[Polymap.this.ids[tile]] = Polymap.this.checkI; } else { Polymap.this.checkers[Polymap.this.ids[tile]] = Polymap.this.checkI - 1; }  return (MAP_BOOLEANE)this; } }; this.width = width; this.height = height; this.ids = Alloc.ii(height * width); this.bounds = (RECTANGLE)new Rec(width, height); float[][] heights = new float[height][width]; int id = 1; this.r = (width / size); this.ri = 1.0D / this.r; double dx = width / size; double dy = height / size; for (int y = 0; y < size; y++) { for (int x = 0; x < size; x++) { double qx = dx * x; double qy = dy * y; qx += dx / 2.0D; qy += dy / 2.0D; qx += dx * Math.pow(RND.rFloat(), relaxation) * (RND.rBoolean() ? 0.5D : -0.5D); qy += dy * Math.pow(RND.rFloat(), relaxation) * (RND.rBoolean() ? 0.5D : -0.5D); polly((int)qx, (int)qy, id++, heights); }  }  this.checkers = Alloc.ii(id); this.body = (RECTANGLE)new Rec(width, height); this.checker = (MAP_BOOLEANE)new MAP_BOOLEANE.BooleanMapE(width, height) { public boolean is(int tile) { return is(tile % Polymap.this.bounds.width(), tile / Polymap.this.bounds.width()); } public boolean is(int tile) { return (Polymap.this.checkers[Polymap.this.ids[tile]] == Polymap.this.checkI); } }; } public Polymap(RECTANGLE bounds, int cellsize, double randomness) { this.getter = new MAP_INT() { public int get(int tx, int ty) { return get(tx + ty * Polymap.this.width); } public int get(int tile) { return Polymap.this.ids[tile]; } }; this.isEdge = new MAP_BOOLEAN() { public boolean is(int tx, int ty) { if (!Polymap.this.bounds.holdsPoint(tx, ty)) return false;  int id = Polymap.this.ids[tx + ty * Polymap.this.width]; DIR d = DIR.E; for (int i = 0; i < 2; i++) { int x = tx + d.x(); int y = ty + d.y(); if (Polymap.this.bounds.holdsPoint(x, y) && id != Polymap.this.ids[x + y * Polymap.this.width]) return true;  d = d.next(2); }  return false; } public boolean is(int tile) { return is(tile % Polymap.this.bounds.width(), tile / Polymap.this.bounds.width()); } }; this.width = bounds.width(); this.height = bounds.height(); this.ids = Alloc.ii(this.height * this.width); this.bounds = (RECTANGLE)new Rec(this.width, this.height); float[][] heights = new float[this.height][this.width]; int id = 1; this.r = cellsize; this.ri = 1.0D / this.r; int d = cellsize / 2; for (int y = -cellsize; y < this.height + cellsize; y += cellsize) { for (int x = -cellsize; x < this.width + cellsize; x += cellsize) { double qx = x; double qy = y; qx += d; qy += d; qx += RND.rSign() * RND.rFloat(d) * randomness; qy += RND.rSign() * RND.rFloat(d) * randomness; polly((int)qx, (int)qy, id++, heights); }  }  this.checkers = Alloc.ii(id); this.body = (RECTANGLE)new Rec(this.width, this.height); this.checker = (MAP_BOOLEANE)new MAP_BOOLEANE.BooleanMapE(this.width, this.height) { public MAP_BOOLEANE set(int tile, boolean value) { if (value) { Polymap.this.checkers[Polymap.this.ids[tile]] = Polymap.this.checkI; } else { Polymap.this.checkers[Polymap.this.ids[tile]] = Polymap.this.checkI - 1; }  return (MAP_BOOLEANE)this; } public boolean is(int tile) { return (Polymap.this.checkers[Polymap.this.ids[tile]] == Polymap.this.checkI); } }
/*     */       ; } public MAP_BOOLEANE getScaled(final double scale) { return new MAP_BOOLEANE() { public boolean is(int tile) { int x = tile % Polymap.this.width; int y = tile / Polymap.this.width; return is(x, y); }
/*     */         public boolean is(int tx, int ty) { return Polymap.this.checker.is((int)(tx * scale) % Polymap.this.width, (int)(ty * scale) % Polymap.this.height); }
/*     */         public MAP_BOOLEANE set(int tile, boolean value) { int x = tile % Polymap.this.width; int y = tile / Polymap.this.width; return set(x, y, value); }
/*     */         public MAP_BOOLEANE set(int tx, int ty, boolean value) { Polymap.this.checker.set((int)(tx * scale) % Polymap.this.width, (int)(ty * scale) % Polymap.this.height, value); return this; } }
/*     */       ; }
/* 267 */   public boolean isEdge(int tx, int ty) { int id = this.ids[tx + ty * this.width];
/* 268 */     DIR d = DIR.E;
/*     */     
/* 270 */     for (int i = 0; i < 2; i++) {
/*     */       
/* 272 */       int x = tx + d.x();
/* 273 */       int y = ty + d.y();
/* 274 */       if (this.bounds.holdsPoint(x, y) && 
/* 275 */         id != this.ids[x + y * this.width]) {
/* 276 */         return true;
/*     */       }
/* 278 */       d = d.next(2);
/*     */     } 
/*     */     
/* 281 */     return false; } private void polly(int x, int y, int id, float[][] heights) { if (this.bounds.holdsPoint(x, y) && heights[y][x] == 1.0F)
/*     */       return;  for (int y1 = (int)-this.r; y1 < this.r; y1++) { int ty = y1 + y; if (ty >= 0 && ty < this.height)
/*     */         for (int x1 = (int)-this.r; x1 < this.r; x1++) { int tx = x + x1; if (tx >= 0 && tx < this.width) { double d = Math.sqrt((x1 * x1 + y1 * y1)); if (d <= this.r) { double v = 1.0D - this.ri * d; if (v > heights[ty][tx]) { heights[ty][tx] = (float)v; this.ids[tx + this.width * ty] = id; }  }  }  }
/*     */           }
/*     */      }
/* 286 */   public void checkInit() { this.checkI++; }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 291 */     int width = 512;
/* 292 */     int height = 512;
/*     */     
/* 294 */     SnakeImage im = new SnakeImage(width, height);
/* 295 */     Polymap p = new Polymap(width, height, 2.0D);
/*     */     
/* 297 */     int cols = 128;
/* 298 */     int colM = cols - 1;
/* 299 */     COLOR[] co = new COLOR[128];
/*     */     
/* 301 */     for (int i = 0; i < cols; i++) {
/* 302 */       co[i] = (COLOR)new ColorImp(RND.rInt(255), RND.rInt(255), RND.rInt(255));
/*     */     }
/* 304 */     for (COORDINATE coo : p.body()) {
/*     */       
/* 306 */       int id = p.ids[coo.x() + coo.y() * width];
/* 307 */       COLOR c = co[id & colM];
/*     */       
/* 309 */       im.rgb.set(coo.x(), coo.y(), c.red(), c.green(), c.red(), 255);
/*     */     } 
/*     */ 
/*     */     
/* 313 */     String path = (new File("PollyTest.png")).getAbsolutePath();
/* 314 */     Printer.ln(path);
/* 315 */     im.save(path);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RECTANGLE body() {
/* 321 */     return this.body;
/*     */   }
/*     */   
/*     */   public int get(int tx, int ty) {
/* 325 */     return this.ids[tx + ty * this.width];
/*     */   }
/*     */   
/*     */   public int polys() {
/* 329 */     return this.checkers.length;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\rnd\Polymap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */