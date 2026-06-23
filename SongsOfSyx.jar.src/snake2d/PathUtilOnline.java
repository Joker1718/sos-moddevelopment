/*     */ package snake2d;
/*     */ 
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.map.MAP_BOOLEANE;
/*     */ import snake2d.util.map.MAP_DOUBLEE;
/*     */ import snake2d.util.map.MAP_INTE;
/*     */ import snake2d.util.map.MAP_SETTER;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PathUtilOnline
/*     */ {
/*     */   private final PathTile[][] tiles;
/*  24 */   int id = 0;
/*  25 */   final RBTileTree tree = new RBTileTree();
/*  26 */   private final Flooder flooder = new Flooder();
/*     */   public final Filler filler;
/*  28 */   public final AStar astar = new AStar(null);
/*  29 */   public final Marker marker = new Marker();
/*     */ 
/*     */   
/*     */   private final RECTANGLEE bounds;
/*     */ 
/*     */   
/*     */   private Object user;
/*     */ 
/*     */   
/*     */   private final LIST<DIR> ortho;
/*     */   
/*     */   private final LIST<DIR> northo;
/*     */ 
/*     */   
/*     */   private void lock(Object user) {
/*  44 */     if (this.user != null) {
/*  45 */       throw new RuntimeException("already in use by: " + this.user.toString());
/*     */     }
/*  47 */     this.user = user;
/*  48 */     this.id++;
/*  49 */     if (this.id == 0) {
/*  50 */       for (int y = 0; y < this.tiles.length; y++) {
/*  51 */         for (int x = 0; x < this.tiles.length; x++)
/*  52 */           (this.tiles[y][x]).pathId = 0; 
/*  53 */       }  this.id = 1;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isLocked() {
/*  58 */     return (this.user != null);
/*     */   }
/*     */   
/*     */   private void unlock() {
/*  62 */     this.user = null;
/*     */   }
/*     */   
/*     */   public PathTile getTile(int x, int y) {
/*  66 */     return this.tiles[y][x];
/*     */   }
/*     */   
/*     */   public Flooder getFlooder() {
/*  70 */     return this.flooder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class Flooder
/*     */   {
/*     */     public void init(Object user) {
/*  83 */       PathUtilOnline.this.lock(user);
/*  84 */       PathUtilOnline.this.tree.clear();
/*     */     }
/*     */     
/*     */     public void done() {
/*  88 */       PathUtilOnline.this.unlock();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PathTile pushGreater(int x, int y, double value) {
/* 100 */       return pushGreater(x, y, value, (PathTile)null);
/*     */     }
/*     */     
/*     */     public PathTile pushGreater(COORDINATE c, double value) {
/* 104 */       return pushGreater(c.x(), c.y(), value, (PathTile)null);
/*     */     }
/*     */     
/*     */     public PathTile pushGreater(COORDINATE c, DIR d, double value) {
/* 108 */       return pushGreater(c.x() + d.x(), c.y() + d.y(), value, (PathTile)null);
/*     */     }
/*     */     
/*     */     public PathTile pushGreater(int x, int y, DIR d, double value) {
/* 112 */       return pushGreater(x + d.x(), y + d.y(), value, (PathTile)null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PathTile pushGreater(int x, int y, double value, PathTile parent) {
/* 126 */       if (!PathUtilOnline.this.bounds.holdsPoint(x, y)) {
/* 127 */         return null;
/*     */       }
/* 129 */       PathTile t = PathUtilOnline.this.getTile(x, y);
/*     */       
/* 131 */       if (t.pathId == PathUtilOnline.this.id) {
/* 132 */         if (t.value >= value)
/* 133 */           return t; 
/* 134 */         if (t.closed)
/* 135 */           return t; 
/* 136 */         PathUtilOnline.this.tree.remove(t);
/*     */       } 
/*     */       
/* 139 */       t.pathId = PathUtilOnline.this.id;
/* 140 */       t.closed = false;
/* 141 */       t.value = (float)value;
/* 142 */       t.pathParent = parent;
/* 143 */       PathUtilOnline.this.tree.put(t);
/* 144 */       return t;
/*     */     }
/*     */     
/*     */     public void setValue(int tx, int ty, double v) {
/* 148 */       (PathUtilOnline.this.getTile(tx, ty)).value = (float)v;
/*     */     }
/*     */     
/*     */     public boolean hasBeenPushed(int tx, int ty) {
/* 152 */       if (!PathUtilOnline.this.bounds.holdsPoint(tx, ty))
/* 153 */         return true; 
/* 154 */       PathTile t = PathUtilOnline.this.getTile(tx, ty);
/* 155 */       return (t.pathId == PathUtilOnline.this.id);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void unclose(int tx, int ty) {
/* 161 */       PathTile t = PathUtilOnline.this.getTile(tx, ty);
/* 162 */       t.closed = false;
/*     */     }
/*     */     
/*     */     public boolean hasBeenPushed(COORDINATE c) {
/* 166 */       return hasBeenPushed(c.x(), c.y());
/*     */     }
/*     */     
/*     */     public boolean hasBeenPushed(COORDINATE c, DIR d) {
/* 170 */       return hasBeenPushed(c.x() + d.x(), c.y() + d.y());
/*     */     }
/*     */     
/*     */     public boolean hasBeenPushed(int tx, int ty, DIR d) {
/* 174 */       return hasBeenPushed(tx + d.x(), ty + d.y());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PathTile pushSloppy(int x, int y, double value) {
/* 184 */       return pushSloppy(x, y, value, (PathTile)null);
/*     */     }
/*     */     
/*     */     public PathTile pushSloppy(COORDINATE c, double value) {
/* 188 */       return pushSloppy(c.x(), c.y(), value, (PathTile)null);
/*     */     }
/*     */     
/*     */     public PathTile pushSloppy(COORDINATE c, DIR d, double value) {
/* 192 */       return pushSloppy(c.x() + d.x(), c.y() + d.y(), value, (PathTile)null);
/*     */     }
/*     */     
/*     */     public PathTile pushSloppy(int x, int y, DIR d, double value) {
/* 196 */       return pushSloppy(x + d.x(), y + d.y(), value, (PathTile)null);
/*     */     }
/*     */     
/*     */     public PathTile pushSloppy(int x, int y, DIR d, double value, PathTile parent) {
/* 200 */       return pushSloppy(x + d.x(), y + d.y(), value, parent);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PathTile pushSloppy(int x, int y, double value, PathTile parent) {
/* 212 */       if (!PathUtilOnline.this.bounds.holdsPoint(x, y)) {
/* 213 */         return null;
/*     */       }
/* 215 */       PathTile t = PathUtilOnline.this.getTile(x, y);
/*     */       
/* 217 */       if (t.pathId == PathUtilOnline.this.id) {
/* 218 */         return null;
/*     */       }
/*     */       
/* 221 */       t.pathId = PathUtilOnline.this.id;
/* 222 */       t.value = (float)value;
/* 223 */       t.pathParent = parent;
/* 224 */       PathUtilOnline.this.tree.put(t);
/* 225 */       t.closed = true;
/* 226 */       return t;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PathTile pushSmaller(int x, int y, double value) {
/* 238 */       return pushSmaller(x, y, (float)value, (PathTile)null);
/*     */     }
/*     */     
/*     */     public PathTile pushSmaller(COORDINATE c, double value) {
/* 242 */       return pushSmaller(c.x(), c.y(), (float)value, (PathTile)null);
/*     */     }
/*     */     
/*     */     public PathTile pushSmaller(int x, int y, DIR d, double value) {
/* 246 */       return pushSmaller(x + d.x(), y + d.y(), (float)value, (PathTile)null);
/*     */     }
/*     */     
/*     */     public PathTile pushSmaller(int x, int y, DIR d, double value, PathTile parent) {
/* 250 */       return pushSmaller(x + d.x(), y + d.y(), (float)value, parent);
/*     */     }
/*     */     
/*     */     public PathTile pushSmaller(COORDINATE c, double value, PathTile parent) {
/* 254 */       return pushSmaller(c.x(), c.y(), (float)value, parent);
/*     */     }
/*     */     
/*     */     public PathTile pushSmaller(COORDINATE c, DIR d, double value) {
/* 258 */       return pushSmaller(c.x() + d.x(), c.y() + d.y(), (float)value, (PathTile)null);
/*     */     }
/*     */     
/*     */     public PathTile pushSmaller(COORDINATE c, DIR d, double value, PathTile parent) {
/* 262 */       return pushSmaller(c.x() + d.x(), c.y() + d.y(), (float)value, parent);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PathTile pushSmaller(int x, int y, double value, PathTile parent) {
/* 276 */       PathTile t = PathUtilOnline.this.getTile(x, y);
/*     */       
/* 278 */       if (t.pathId == PathUtilOnline.this.id) {
/* 279 */         if (t.value <= value)
/* 280 */           return null; 
/* 281 */         if (t.closed)
/* 282 */           return null; 
/* 283 */         PathUtilOnline.this.tree.remove(t);
/*     */       } 
/*     */       
/* 286 */       t.pathId = PathUtilOnline.this.id;
/* 287 */       t.closed = false;
/* 288 */       t.value = (float)value;
/* 289 */       t.pathParent = parent;
/* 290 */       PathUtilOnline.this.tree.put(t);
/* 291 */       return t;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PathTile pollAndReopen() {
/* 300 */       PathTile t = PathUtilOnline.this.tree.pollGreatest();
/* 301 */       t.pathId = PathUtilOnline.this.id - 1;
/* 302 */       return t;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PathTile pollGreatest() {
/* 310 */       PathTile t = PathUtilOnline.this.tree.pollGreatest();
/* 311 */       t.closed = true;
/* 312 */       return t;
/*     */     }
/*     */     
/*     */     public int pushed() {
/* 316 */       return PathUtilOnline.this.tree.size();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PathTile pollSmallest() {
/* 324 */       PathTile t = PathUtilOnline.this.tree.pollSmallest();
/* 325 */       t.closed = true;
/* 326 */       return t;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void closeGreater(int x, int y, double value) {
/* 338 */       PathTile t = PathUtilOnline.this.tiles[y][x];
/* 339 */       if (t.pathId == PathUtilOnline.this.id && value > t.value)
/* 340 */         t.value = (float)value; 
/* 341 */       t.pathId = PathUtilOnline.this.id;
/* 342 */       t.closed = true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PathTile close(int x, int y, double value) {
/* 353 */       PathTile t = PathUtilOnline.this.tiles[y][x];
/*     */       
/* 355 */       t.value = (float)value;
/* 356 */       t.pathId = PathUtilOnline.this.id;
/* 357 */       t.closed = true;
/* 358 */       return t;
/*     */     }
/*     */     
/*     */     public PathTile close(COORDINATE c, DIR d, double value) {
/* 362 */       return close(c.x() + d.x(), c.y() + d.y(), value);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PathTile close(int x, int y, double value, PathTile parent) {
/* 373 */       PathTile t = PathUtilOnline.this.tiles[y][x];
/* 374 */       t.value = (float)value;
/* 375 */       t.pathId = PathUtilOnline.this.id;
/* 376 */       t.closed = true;
/* 377 */       t.pathParent = parent;
/* 378 */       return t;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getValue(int x, int y) {
/* 388 */       PathTile t = PathUtilOnline.this.getTile(x, y);
/* 389 */       if (t.pathId == PathUtilOnline.this.id) {
/* 390 */         return t.value;
/*     */       }
/* 392 */       return 0.0F;
/*     */     }
/*     */     
/*     */     public PathTile get(COORDINATE c) {
/* 396 */       PathTile t = PathUtilOnline.this.getTile(c.x(), c.y());
/* 397 */       if (t.pathId == PathUtilOnline.this.id) {
/* 398 */         return t;
/*     */       }
/* 400 */       return null;
/*     */     }
/*     */     
/*     */     public PathTile get(int x, int y) {
/* 404 */       PathTile t = PathUtilOnline.this.getTile(x, y);
/* 405 */       if (t.pathId == PathUtilOnline.this.id) {
/* 406 */         return t;
/*     */       }
/* 408 */       return null;
/*     */     }
/*     */     
/*     */     public float getValue(COORDINATE c) {
/* 412 */       return getValue(c.x(), c.y());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasMore() {
/* 420 */       return (PathUtilOnline.this.tree.size() > 0);
/*     */     }
/*     */     
/*     */     public float getValue2(COORDINATE c) {
/* 424 */       PathTile t = PathUtilOnline.this.getTile(c.x(), c.y());
/* 425 */       return t.getValue2();
/*     */     }
/*     */     
/*     */     public float getValue2(int x, int y) {
/* 429 */       PathTile t = PathUtilOnline.this.getTile(x, y);
/* 430 */       return t.getValue2();
/*     */     }
/*     */     
/*     */     public float getValue2(int x, int y, DIR d) {
/* 434 */       PathTile t = PathUtilOnline.this.getTile(x + d.x(), y + d.y());
/* 435 */       return t.getValue2();
/*     */     }
/*     */     
/*     */     public void setValue2(COORDINATE c, double f) {
/* 439 */       setValue2(c.x(), c.y(), f);
/*     */     }
/*     */     
/*     */     public void setValue2(COORDINATE c, DIR d, double f) {
/* 443 */       setValue2(c.x() + d.x(), c.y() + d.y(), f);
/*     */     }
/*     */     
/*     */     public void setValue2(int x, int y, double f) {
/* 447 */       PathTile t = PathUtilOnline.this.getTile(x, y);
/* 448 */       t.setValue2(f);
/*     */     }
/*     */     
/*     */     public void setValue2(int x, int y, DIR d, double f) {
/* 452 */       setValue2(x + d.x(), y + d.y(), f);
/*     */     }
/*     */     
/*     */     public PathTile force(short x, short y, float value, PathTile parent) {
/* 456 */       PathTile t = PathUtilOnline.this.tiles[y][x];
/* 457 */       t.value = value;
/* 458 */       t.pathId = PathUtilOnline.this.id;
/* 459 */       t.closed = true;
/* 460 */       t.pathParent = parent;
/* 461 */       return t;
/*     */     }
/*     */     
/*     */     public PathTile reverse(PathTile t) {
/* 465 */       init(this);
/*     */       
/* 467 */       PathTile p = t.pathParent;
/* 468 */       t.pathParent = null;
/* 469 */       t = reverse(p, t);
/*     */       
/* 471 */       done();
/*     */ 
/*     */       
/* 474 */       return t;
/*     */     }
/*     */     
/*     */     private PathTile reverse(PathTile t, PathTile newparent) {
/* 478 */       if (t == null)
/* 479 */         return newparent; 
/* 480 */       PathTile parent = t.pathParent;
/* 481 */       t.pathParent = newparent;
/* 482 */       return reverse(parent, t);
/*     */     }
/*     */ 
/*     */     
/*     */     public void reopen(PathTile t) {
/* 487 */       if (!t.closed)
/* 488 */         throw new RuntimeException(); 
/* 489 */       t.closed = false;
/* 490 */       t.pathId = PathUtilOnline.this.id - 1;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class Filler
/*     */   {
/*     */     private PathTile last;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void init(Object user) {
/* 507 */       PathUtilOnline.this.lock(user);
/* 508 */       this.last = null;
/*     */     }
/*     */     
/*     */     public void done() {
/* 512 */       PathUtilOnline.this.unlock();
/*     */     }
/*     */     
/*     */     public boolean fill(COORDINATE c) {
/* 516 */       return fill(c.x(), c.y());
/*     */     }
/*     */     
/*     */     public boolean fill(COORDINATE c, DIR d) {
/* 520 */       return fill(c.x() + d.x(), c.y() + d.y());
/*     */     }
/*     */     
/*     */     public boolean fill(int x, int y, DIR d) {
/* 524 */       return fill(x + d.x(), y + d.y());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean fill(int x, int y) {
/* 529 */       if (!PathUtilOnline.this.bounds.holdsPoint(x, y)) {
/* 530 */         return false;
/*     */       }
/* 532 */       PathTile t = PathUtilOnline.this.getTile(x, y);
/*     */       
/* 534 */       if (t.pathId == PathUtilOnline.this.id) {
/* 535 */         return false;
/*     */       }
/*     */       
/* 538 */       t.pathId = PathUtilOnline.this.id;
/*     */       
/* 540 */       if (this.last == null) {
/* 541 */         t.pathParent = null;
/*     */       } else {
/* 543 */         t.pathParent = this.last;
/*     */       } 
/* 545 */       this.last = t;
/* 546 */       return true;
/*     */     }
/*     */     
/* 549 */     public final MAP_SETTER filler = new MAP_SETTER()
/*     */       {
/*     */         public MAP_SETTER set(int tx, int ty)
/*     */         {
/* 553 */           PathUtilOnline.Filler.this.fill(tx, ty);
/* 554 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_SETTER set(int tile) {
/* 559 */           throw new RuntimeException();
/*     */         }
/*     */       };
/*     */     
/* 563 */     public final MAP_SETTER closer = new MAP_SETTER()
/*     */       {
/*     */         public MAP_SETTER set(int x, int y)
/*     */         {
/* 567 */           if (!(PathUtilOnline.Filler.access$0(PathUtilOnline.Filler.this)).bounds.holdsPoint(x, y)) {
/* 568 */             return this;
/*     */           }
/* 570 */           PathTile t = PathUtilOnline.Filler.access$0(PathUtilOnline.Filler.this).getTile(x, y);
/* 571 */           t.pathId = (PathUtilOnline.Filler.access$0(PathUtilOnline.Filler.this)).id;
/* 572 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_SETTER set(int tile) {
/* 577 */           throw new RuntimeException();
/*     */         }
/*     */       };
/*     */     
/* 581 */     public final MAP_DOUBLEE value = new MAP_DOUBLEE()
/*     */       {
/*     */         
/*     */         public double get(int tx, int ty)
/*     */         {
/* 586 */           return (PathUtilOnline.Filler.access$0(PathUtilOnline.Filler.this).getTile(tx, ty)).value;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(int tile) {
/* 591 */           throw new RuntimeException();
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tx, int ty, double value) {
/* 596 */           (PathUtilOnline.Filler.access$0(PathUtilOnline.Filler.this).getTile(tx, ty)).value = (float)value;
/* 597 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tile, double value) {
/* 602 */           throw new RuntimeException();
/*     */         }
/*     */       };
/*     */     
/* 606 */     public MAP_BOOLEAN isser = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 610 */           return ((PathUtilOnline.Filler.access$0(PathUtilOnline.Filler.this)).bounds.holdsPoint(tx, ty) && (PathUtilOnline.Filler.access$0(PathUtilOnline.Filler.this).getTile(tx, ty)).pathId == (PathUtilOnline.Filler.access$0(PathUtilOnline.Filler.this)).id);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 615 */           throw new RuntimeException();
/*     */         }
/*     */       };
/*     */     
/*     */     public boolean hasMore() {
/* 620 */       return (this.last != null);
/*     */     }
/*     */     
/*     */     public COORDINATE poll() {
/* 624 */       PathTile t = this.last;
/* 625 */       this.last = t.pathParent;
/* 626 */       return t;
/*     */     }
/*     */     
/*     */     public boolean isFilled(int tx, int ty) {
/* 630 */       return ((PathUtilOnline.this.getTile(tx, ty)).pathId == PathUtilOnline.this.id);
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
/*     */   
/*     */   public final class Marker
/*     */     implements MAP_BOOLEANE
/*     */   {
/*     */     public void init(Object user) {
/* 646 */       PathUtilOnline.this.lock(user);
/*     */     }
/*     */     
/* 649 */     public final MAP_DOUBLEE v1 = new MAP_DOUBLEE()
/*     */       {
/*     */         public double get(int tx, int ty)
/*     */         {
/* 653 */           if (!(PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).bounds.holdsPoint(tx, ty))
/* 654 */             return 0.0D; 
/* 655 */           PathTile t = (PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).tiles[ty][tx];
/* 656 */           return t.value;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(int tile) {
/* 661 */           int x = tile % (PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).bounds.width();
/* 662 */           int y = tile / (PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).bounds.width();
/* 663 */           return get(x, y);
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tx, int ty, double value) {
/* 668 */           if (!(PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).bounds.holdsPoint(tx, ty))
/* 669 */             return this; 
/* 670 */           PathTile t = (PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).tiles[ty][tx];
/* 671 */           t.value = (float)value;
/* 672 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tile, double value) {
/* 677 */           int x = tile % (PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).bounds.width();
/* 678 */           int y = tile / (PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).bounds.width();
/* 679 */           return set(x, y, value);
/*     */         }
/*     */       };
/*     */     
/* 683 */     public final MAP_DOUBLEE v2 = new MAP_DOUBLEE()
/*     */       {
/*     */         public double get(int tx, int ty)
/*     */         {
/* 687 */           if (!(PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).bounds.holdsPoint(tx, ty))
/* 688 */             return 0.0D; 
/* 689 */           PathTile t = (PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).tiles[ty][tx];
/* 690 */           return t.getValue2();
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(int tile) {
/* 695 */           int x = tile % (PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).bounds.width();
/* 696 */           int y = tile / (PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).bounds.width();
/* 697 */           return get(x, y);
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tx, int ty, double value) {
/* 702 */           if (!(PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).bounds.holdsPoint(tx, ty))
/* 703 */             return this; 
/* 704 */           PathTile t = (PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).tiles[ty][tx];
/* 705 */           t.setValue2(value);
/* 706 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tile, double value) {
/* 711 */           int x = tile % (PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).bounds.width();
/* 712 */           int y = tile / (PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).bounds.width();
/* 713 */           return set(x, y, value);
/*     */         }
/*     */       };
/*     */     
/* 717 */     public final MAP_INTE ii = new MAP_INTE()
/*     */       {
/*     */         public int get(int tx, int ty)
/*     */         {
/* 721 */           if (!(PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).bounds.holdsPoint(tx, ty))
/* 722 */             return 0; 
/* 723 */           PathTile t = (PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).tiles[ty][tx];
/* 724 */           return t.pathId;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get(int tile) {
/* 729 */           int x = tile % (PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).bounds.width();
/* 730 */           int y = tile / (PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).bounds.width();
/* 731 */           return get(x, y);
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_INTE set(int tx, int ty, int value) {
/* 736 */           if (!(PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).bounds.holdsPoint(tx, ty))
/* 737 */             return this; 
/* 738 */           PathTile t = (PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).tiles[ty][tx];
/* 739 */           t.pathId = value;
/* 740 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_INTE set(int tile, int value) {
/* 745 */           int x = tile % (PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).bounds.width();
/* 746 */           int y = tile / (PathUtilOnline.Marker.access$0(PathUtilOnline.Marker.this)).bounds.width();
/* 747 */           return set(x, y, value);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*     */     public void done() {
/* 753 */       PathUtilOnline.this.unlock();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean is(int tile) {
/* 758 */       int x = tile % PathUtilOnline.this.bounds.width();
/* 759 */       int y = tile / PathUtilOnline.this.bounds.width();
/* 760 */       return is(x, y);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean is(int tx, int ty) {
/* 765 */       if (!PathUtilOnline.this.bounds.holdsPoint(tx, ty))
/* 766 */         return true; 
/* 767 */       PathTile t = PathUtilOnline.this.tiles[ty][tx];
/* 768 */       return (t.pathId == PathUtilOnline.this.id);
/*     */     }
/*     */ 
/*     */     
/*     */     public MAP_BOOLEANE set(int tile, boolean value) {
/* 773 */       int x = tile % PathUtilOnline.this.bounds.width();
/* 774 */       int y = tile / PathUtilOnline.this.bounds.width();
/* 775 */       return set(x, y, value);
/*     */     }
/*     */ 
/*     */     
/*     */     public MAP_BOOLEANE set(int tx, int ty, boolean value) {
/* 780 */       if (!PathUtilOnline.this.bounds.holdsPoint(tx, ty))
/* 781 */         return this; 
/* 782 */       PathTile t = PathUtilOnline.this.tiles[ty][tx];
/* 783 */       t.pathId = PathUtilOnline.this.id;
/* 784 */       return this;
/*     */     } }
/*     */   
/*     */   public PathUtilOnline(int size) {
/* 788 */     this.ortho = (LIST<DIR>)new ArrayList((Iterable)DIR.ORTHO);
/* 789 */     this.northo = (LIST<DIR>)new ArrayList((Iterable)DIR.ALL);
/*     */     this.tiles = new PathTile[size][size];
/*     */     this.bounds = (RECTANGLEE)new Rec(0.0D, size, 0.0D, size);
/*     */     for (int y = 0; y < this.tiles.length; y++) {
/*     */       for (int x = 0; x < this.tiles.length; x++)
/*     */         this.tiles[y][x] = new PathTile((short)x, (short)y); 
/*     */     } 
/*     */     this.filler = new Filler();
/* 797 */   } public class AStar { private final PathUtilOnline.SHORTEST s = new PathUtilOnline.SHORTEST();
/*     */     
/*     */     public void close(int x, int y) {
/* 800 */       PathTile t = PathUtilOnline.this.getTile(x, y);
/* 801 */       t.pathId = PathUtilOnline.this.id;
/* 802 */       t.closed = true;
/*     */     }
/*     */     
/*     */     public final boolean getShortest(PathGame.PathFancy p, PathGame.COST cost, int startX, int startY, int endX, int endY) {
/* 806 */       return getShortest(p, cost, startX, startY, endX, endY, false);
/*     */     }
/*     */     
/*     */     public final boolean getShortest(PathGame.PathFancy p, PathGame.COST cost, int startX, int startY, int endX, int endY, boolean includeLast) {
/* 810 */       return getShortest(p, cost, startX, startY, endX, endY, includeLast, PathUtilOnline.this.northo);
/*     */     }
/*     */     
/*     */     public final boolean getShortestNoDiagonal(PathGame.PathFancy p, PathGame.COST cost, int startX, int startY, int endX, int endY) {
/* 814 */       return getShortest(p, cost, startX, startY, endX, endY, true, PathUtilOnline.this.ortho);
/*     */     }
/*     */     
/*     */     public final PathTile getShortest(PathGame.COST cost, int startX, int startY, int endX, int endY) {
/* 818 */       return getShortest(cost, startX, startY, endX, endY, false);
/*     */     }
/*     */     
/*     */     public final PathTile getShortest(PathGame.COST cost, int startX, int startY, int endX, int endY, boolean includeLast) {
/* 822 */       return getShortest(cost, startX, startY, endX, endY, includeLast, PathUtilOnline.this.northo);
/*     */     }
/*     */     
/*     */     public final PathTile getShortestNoDiagonal(PathGame.COST cost, int startX, int startY, int endX, int endY) {
/* 826 */       return getShortest(cost, startX, startY, endX, endY, true, PathUtilOnline.this.ortho);
/*     */     }
/*     */     
/*     */     private final boolean getShortest(PathGame.PathFancy p, PathGame.COST cost, int startX, int startY, int endX, int endY, boolean includeLast, LIST<DIR> dirs) {
/* 830 */       if (startX == endX && startY == endY) {
/* 831 */         p.setOne(startX, startY);
/* 832 */         return true;
/*     */       } 
/* 834 */       PathTile t = getShortest(cost, startX, startY, endX, endY, includeLast, dirs);
/* 835 */       if (t != null) {
/* 836 */         p.set(t);
/* 837 */         return true;
/*     */       } 
/* 839 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     private final PathTile getShortest(PathGame.COST cost, int startX, int startY, int endX, int endY, boolean includeLast, LIST<DIR> dirs) {
/* 844 */       if (!PathUtilOnline.this.bounds.holdsPoint(endX, endY))
/* 845 */         return null; 
/* 846 */       if (!PathUtilOnline.this.bounds.holdsPoint(startX, startY)) {
/* 847 */         return null;
/*     */       }
/* 849 */       PathUtilOnline.SHORTEST dest = this.s;
/* 850 */       dest.set(endX, endY);
/* 851 */       return find(cost, dest, startX, startY, includeLast, dirs);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean getNearest(PathGame.PathFancy p, PathGame.COST cost, PathGame.DEST dest, int startX, int startY) {
/* 856 */       PathTile t = find(cost, dest, startX, startY, true, PathUtilOnline.this.northo);
/* 857 */       if (t != null) {
/* 858 */         p.set(t);
/* 859 */         return true;
/*     */       } 
/* 861 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public PathTile find(PathGame.COST cost, PathGame.DEST dest, int startX, int startY, boolean includeLast, LIST<DIR> dirs) {
/* 866 */       PathUtilOnline.this.lock(null);
/* 867 */       PathUtilOnline.this.tree.clear();
/* 868 */       PathTile t = PathUtilOnline.this.getTile(startX, startY);
/* 869 */       add2OpenSet(t, null, 0.0D, dest);
/*     */       
/* 871 */       while (PathUtilOnline.this.tree.size() > 0) {
/* 872 */         t = PathUtilOnline.this.tree.pollSmallest();
/* 873 */         int x = t.x;
/* 874 */         int y = t.y;
/* 875 */         t.closed = true;
/*     */         
/* 877 */         if (includeLast && dest.isDest(x, y)) {
/* 878 */           return t;
/*     */         }
/*     */         
/* 881 */         for (DIR dir : dirs) {
/*     */           
/* 883 */           int xtemp = x + dir.x();
/* 884 */           int ytemp = y + dir.y();
/*     */           
/* 886 */           if (!PathUtilOnline.this.bounds.holdsPoint(xtemp, ytemp)) {
/*     */             continue;
/*     */           }
/* 889 */           if (!includeLast && dest.isDest(xtemp, ytemp)) {
/* 890 */             return t;
/*     */           }
/*     */           
/* 893 */           PathTile next = PathUtilOnline.this.getTile(xtemp, ytemp);
/* 894 */           if (next.pathId == PathUtilOnline.this.id && next.closed) {
/*     */             continue;
/*     */           }
/* 897 */           double tempCost = cost.getCost(x, y, xtemp, ytemp);
/* 898 */           if (tempCost < 0.0D) {
/* 899 */             if (tempCost == -1.0D) {
/* 900 */               close(xtemp, ytemp);
/*     */             }
/*     */             continue;
/*     */           } 
/* 904 */           tempCost *= dir.tileDistance();
/* 905 */           tempCost += t.accCost;
/*     */           
/* 907 */           if (next.pathId == PathUtilOnline.this.id) {
/* 908 */             if (tempCost >= next.accCost)
/*     */               continue; 
/* 910 */             PathUtilOnline.this.tree.remove(next);
/*     */           } 
/* 912 */           add2OpenSet(next, t, tempCost, dest);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 917 */       return null;
/*     */     }
/*     */     
/*     */     private PathTile add2OpenSet(PathTile t, PathTile parent, double accCost, PathGame.DEST method) {
/* 921 */       t.accCost = (float)accCost;
/* 922 */       t.value = (float)(accCost + method.getOptDistance(t.x, t.y));
/* 923 */       t.pathId = PathUtilOnline.this.id;
/* 924 */       t.closed = false;
/* 925 */       t.pathParent = parent;
/* 926 */       PathUtilOnline.this.tree.put(t);
/* 927 */       return t;
/*     */     }
/*     */     
/*     */     private AStar() {} }
/*     */   
/*     */   static final class SHORTEST extends PathGame.DEST {
/*     */     int destX;
/*     */     int destY;
/* 935 */     private static final float SQRT2 = (float)Math.sqrt(2.0D);
/*     */     
/*     */     public final void set(int destX, int destY) {
/* 938 */       this.destX = destX;
/* 939 */       this.destY = destY;
/*     */     }
/*     */ 
/*     */     
/*     */     protected final float getOptDistance(int x, int y) {
/* 944 */       x = Math.abs(x - this.destX);
/* 945 */       y = Math.abs(y - this.destY);
/*     */       
/* 947 */       if (x > y)
/* 948 */         return SQRT2 * y + x - y; 
/* 949 */       if (x < y) {
/* 950 */         return SQRT2 * x + y - x;
/*     */       }
/* 952 */       return SQRT2 * x;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final boolean isDest(int x, int y) {
/* 958 */       return (x == this.destX && y == this.destY);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\PathUtilOnline.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */