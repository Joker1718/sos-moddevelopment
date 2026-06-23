/*     */ package settlement.room.water;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.Queue;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ final class Updater
/*     */ {
/*     */   private final ROOM_WATER w;
/*  26 */   private Grid grid1 = new Grid();
/*  27 */   private final ArrayListResize<PumpInstance> pumps = new ArrayListResize(128);
/*  28 */   private final LIST<DIR> dirs = DIR.ORTHO.join((Object[])new DIR[] { DIR.C });
/*  29 */   private final LIST<DIR> ortho = (LIST<DIR>)new ArrayList((Iterable)DIR.ORTHO);
/*  30 */   private final double tilesPerSecond = 1.0D;
/*     */   
/*     */   private double timer;
/*  33 */   public int ops = 0;
/*     */   
/*  35 */   public final SAVABLE saver = new SAVABLE()
/*     */     {
/*     */       public void save(FilePutter file)
/*     */       {
/*  39 */         file.d(Updater.this.timer);
/*  40 */         Updater.this.grid1.save(file);
/*     */       }
/*     */ 
/*     */       
/*     */       public void load(FileGetter file) throws IOException {
/*  45 */         Updater.this.timer = file.d();
/*  46 */         Updater.this.grid1.load(file);
/*     */       }
/*     */ 
/*     */       
/*     */       public void clear() {
/*  51 */         Updater.this.timer = 0.0D;
/*  52 */         Updater.this.grid1.clear();
/*     */       }
/*     */     };
/*     */   
/*     */   public Updater(ROOM_WATER water) {
/*  57 */     this.w = water;
/*     */   }
/*     */ 
/*     */   
/*     */   public void reportChange(int tx, int ty, int radius) {
/*  62 */     int i = 0;
/*  63 */     while (GUTIL.circle().radius(i) < radius) {
/*  64 */       this.ops++;
/*  65 */       int dx = GUTIL.circle().get(i).x() + tx;
/*  66 */       int dy = GUTIL.circle().get(i).y() + ty;
/*  67 */       if (this.w.pumpable.get(dx, dy) != null) {
/*  68 */         this.grid1.mark(dx, dy);
/*     */       }
/*     */       
/*  71 */       i++;
/*     */     } 
/*     */     
/*  74 */     for (DIR d : this.dirs) {
/*  75 */       if (SETT.IN_BOUNDS(tx, ty, d)) {
/*  76 */         this.grid1.mark(tx + d.x(), ty + d.y());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void update(double ds) {
/*  89 */     this.timer += ds * 1.0D;
/*  90 */     if (this.timer < 1.0D) {
/*     */       return;
/*     */     }
/*  93 */     this.timer -= (int)this.timer;
/*     */ 
/*     */     
/*  96 */     this.ops = 0;
/*     */     
/*  98 */     RECTANGLE bb = this.grid1.pollNext();
/*  99 */     while (bb != null) {
/*     */       
/* 101 */       for (COORDINATE c : bb) {
/* 102 */         if (this.grid1.mark.is(c)) {
/* 103 */           this.grid1.mark.set(c, false);
/* 104 */           if (this.w.pumpable.get(c.x(), c.y()) != null) {
/* 105 */             this.pumps.clearSoft();
/* 106 */             this.ops++;
/* 107 */             drain(c.x(), c.y(), this.pumps);
/* 108 */             if (this.pumps.size() > 0) {
/* 109 */               fill((LIST<PumpInstance>)this.pumps); continue;
/*     */             } 
/* 111 */             fail(c.x(), c.y());
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 117 */       bb = this.grid1.pollNext();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void drain(int tx, int ty, ArrayListResize<PumpInstance> pumps) {
/* 125 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 126 */     f.init(this);
/* 127 */     f.pushSloppy(tx, ty, 0.0D);
/*     */     
/* 129 */     while (f.hasMore()) {
/* 130 */       PathTile t = f.pollSmallest();
/* 131 */       RoomPumpable p = (RoomPumpable)this.w.pumpable.get(t.x(), t.y());
/*     */       
/* 133 */       t.setValue2(p.dirmask(t.x(), t.y()));
/*     */       
/* 135 */       p.drain(t.x(), t.y());
/* 136 */       this.grid1.mark.set((COORDINATE)t, false);
/* 137 */       this.ops++;
/*     */       
/* 139 */       if (p.radius() > 0) {
/* 140 */         int rr = p.radius();
/* 141 */         int i = 0;
/* 142 */         while (GUTIL.circle().radius(i) < rr) {
/* 143 */           this.ops++;
/* 144 */           int dx = GUTIL.circle().get(i).x() + t.x();
/* 145 */           int dy = GUTIL.circle().get(i).y() + t.y();
/* 146 */           if (this.w.pumpable.get(dx, dy) == p) {
/* 147 */             f.pushSmaller(dx, dy, (t.getValue() + GUTIL.circle().radius(i)), t);
/*     */           }
/*     */           
/* 150 */           i++;
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 156 */       for (DIR d : this.ortho) {
/* 157 */         if (this.w.pumpable.get((COORDINATE)t, d) != null) {
/* 158 */           f.pushSmaller((COORDINATE)t, d, (t.getValue() + 1.0F), t); continue;
/*     */         } 
/* 160 */         PumpInstance ins = (PumpInstance)this.w.pump.get(t.x() + d.x(), t.y() + d.y());
/* 161 */         if (ins != null && ins.ox() == t.x() + d.x() && ins.oy() == t.y() + d.y()) {
/* 162 */           pumps.add(ins);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 170 */     f.done();
/*     */   }
/*     */ 
/*     */   
/*     */   private void fail(int tx, int ty) {
/* 175 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 176 */     f.init(this);
/* 177 */     f.pushSloppy(tx, ty, 0.0D);
/*     */     
/* 179 */     while (f.hasMore()) {
/* 180 */       PathTile t = f.pollSmallest();
/* 181 */       RoomPumpable p = (RoomPumpable)this.w.pumpable.get(t.x(), t.y());
/* 182 */       p.pumpFail(t.x(), t.y(), (int)t.getValue2());
/*     */       
/* 184 */       if (p.radius() > 0) {
/* 185 */         int rr = p.radius();
/* 186 */         int i = 0;
/* 187 */         while (GUTIL.circle().radius(i) < rr) {
/* 188 */           this.ops++;
/* 189 */           int dx = GUTIL.circle().get(i).x() + t.x();
/* 190 */           int dy = GUTIL.circle().get(i).y() + t.y();
/* 191 */           if (this.w.pumpable.get(dx, dy) == p) {
/* 192 */             f.pushSmaller(dx, dy, (t.getValue() + GUTIL.circle().radius(i)), t);
/*     */           }
/*     */           
/* 195 */           i++;
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 201 */       for (DIR d : this.ortho) {
/* 202 */         if (this.w.pumpable.get((COORDINATE)t, d) != null) {
/* 203 */           f.pushSmaller((COORDINATE)t, d, (t.getValue() + 1.0F), t);
/*     */         }
/*     */       } 
/*     */     } 
/* 207 */     f.done();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void fill(LIST<PumpInstance> pumps) {
/* 213 */     if (pumps.size() == 0) {
/*     */       return;
/*     */     }
/* 216 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 217 */     f.init(this);
/* 218 */     double am = 0.0D;
/* 219 */     for (PumpInstance ins : pumps) {
/* 220 */       int a = ins.output();
/* 221 */       am += a;
/* 222 */       if (a > 0) {
/* 223 */         f.pushSloppy(ins.ox(), ins.oy(), 0.0D);
/*     */       }
/*     */     } 
/* 226 */     while (f.hasMore()) {
/* 227 */       PathTile t = f.pollSmallest();
/* 228 */       this.ops++;
/* 229 */       RoomPumpable p = (RoomPumpable)this.w.pumpable.get((COORDINATE)t);
/* 230 */       if (p != null) {
/* 231 */         if (am <= 0.0D) {
/* 232 */           p.pumpFail(t.x(), t.y(), (int)t.getValue2());
/*     */         } else {
/*     */           
/* 235 */           if (t.getParent() != null)
/* 236 */             p.pump(t.x(), t.y(), DIR.get((COORDINATE)t.getParent(), (COORDINATE)t), (int)t.getValue2()); 
/* 237 */           am -= p.suckAmount(t.x(), t.y());
/*     */ 
/*     */           
/* 240 */           if (p.radius() > 0) {
/* 241 */             int rr = p.radius();
/* 242 */             int i = 0;
/* 243 */             while (GUTIL.circle().radius(i) < rr - 2) {
/* 244 */               this.ops++;
/* 245 */               int dx = GUTIL.circle().get(i).x() + t.x();
/* 246 */               int dy = GUTIL.circle().get(i).y() + t.y();
/*     */               
/* 248 */               if (this.w.pumpable.get(dx, dy) == p) {
/* 249 */                 f.pushSmaller(dx, dy, (t.getValue() + GUTIL.circle().radius(i)), t);
/*     */               }
/*     */               
/* 252 */               i++;
/*     */             } 
/* 254 */             am -= p.radius();
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 261 */         for (DIR d : this.ortho) {
/* 262 */           if (this.w.pumpable.get((COORDINATE)t, d) != null && p.pumpsTo(t.x(), t.y(), t.x() + d.x(), t.y() + d.y())) {
/* 263 */             f.pushSmaller((COORDINATE)t, d, (t.getValue() + 1.0F), t);
/*     */           }
/*     */         } 
/*     */         continue;
/*     */       } 
/* 268 */       for (DIR d : this.ortho) {
/* 269 */         if (this.w.pumpable.get((COORDINATE)t, d) != null) {
/* 270 */           f.pushSmaller((COORDINATE)t, d, (t.getValue() + 1.0F), t);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 278 */     f.done();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Grid
/*     */     implements SAVABLE
/*     */   {
/* 286 */     final int w = (int)Math.ceil(SETT.TWIDTH / 16.0D);
/* 287 */     final int h = (int)Math.ceil(SETT.THEIGHT / 16.0D);
/* 288 */     private final Queue<GridTile> active = new Queue(this.w * this.h);
/* 289 */     private final GridTile[][] grid = new GridTile[this.w][this.h];
/* 290 */     private final Bitmap2D mark = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/*     */     
/*     */     Grid() {
/* 293 */       for (int y = 0; y < this.h; y++) {
/* 294 */         for (int x = 0; x < this.w; x++)
/* 295 */           this.grid[y][x] = new GridTile(x, y); 
/*     */       } 
/*     */     }
/*     */     public void save(FilePutter file) {
/*     */       byte b;
/*     */       int i;
/*     */       GridTile[][] arrayOfGridTile;
/* 302 */       for (i = (arrayOfGridTile = this.grid).length, b = 0; b < i; ) { GridTile[] tt = arrayOfGridTile[b]; byte b1; int j; GridTile[] arrayOfGridTile1;
/* 303 */         for (j = (arrayOfGridTile1 = tt).length, b1 = 0; b1 < j; ) { GridTile t = arrayOfGridTile1[b1];
/* 304 */           file.bool(t.marked); b1++; }
/*     */          b++; }
/* 306 */        this.mark.save(file);
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/* 311 */       this.active.clear(); byte b; int i; GridTile[][] arrayOfGridTile;
/* 312 */       for (i = (arrayOfGridTile = this.grid).length, b = 0; b < i; ) { GridTile[] tt = arrayOfGridTile[b]; byte b1; int j; GridTile[] arrayOfGridTile1;
/* 313 */         for (j = (arrayOfGridTile1 = tt).length, b1 = 0; b1 < j; ) { GridTile t = arrayOfGridTile1[b1];
/* 314 */           t.marked = file.bool();
/* 315 */           if (t.marked) {
/* 316 */             t.marked = false;
/* 317 */             mark(t.body.cX(), t.body.cY());
/*     */           }  b1++; }
/*     */          b++; }
/*     */       
/* 321 */       this.mark.load(file);
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 326 */       this.mark.clear();
/* 327 */       this.active.clear(); byte b; int i; GridTile[][] arrayOfGridTile;
/* 328 */       for (i = (arrayOfGridTile = this.grid).length, b = 0; b < i; ) { GridTile[] tt = arrayOfGridTile[b]; byte b1; int j; GridTile[] arrayOfGridTile1;
/* 329 */         for (j = (arrayOfGridTile1 = tt).length, b1 = 0; b1 < j; ) { GridTile t = arrayOfGridTile1[b1];
/* 330 */           t.marked = false;
/*     */           b1++; }
/*     */         
/*     */         b++; }
/*     */     
/*     */     } public RECTANGLE pollNext() {
/* 336 */       if (this.active.size() == 0)
/* 337 */         return null; 
/* 338 */       GridTile t = (GridTile)this.active.poll();
/* 339 */       t.marked = false;
/* 340 */       return t.body;
/*     */     }
/*     */     
/*     */     public void mark(int tx, int ty) {
/* 344 */       this.mark.set(tx, ty, true);
/* 345 */       tx /= 16;
/* 346 */       ty /= 16;
/* 347 */       GridTile t = this.grid[ty][tx];
/* 348 */       if (!t.marked) {
/* 349 */         t.marked = true;
/* 350 */         this.active.push(t);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private static class GridTile
/*     */     {
/*     */       public static final int size = 16;
/*     */       private final RECTANGLE body;
/*     */       private boolean marked = false;
/*     */       
/*     */       GridTile(int gx, int gy) {
/* 362 */         int x2 = Math.min(gx * 16 + 16, SETT.TWIDTH);
/* 363 */         int y2 = Math.min(gy * 16 + 16, SETT.THEIGHT);
/*     */         
/* 365 */         this.body = (RECTANGLE)new Rec((gx * 16), x2, (gy * 16), y2);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\Updater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */