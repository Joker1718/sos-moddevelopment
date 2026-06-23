/*      */ package tools.path;
/*      */ 
/*      */ import java.awt.Rectangle;
/*      */ import snake2d.util.rnd.RND;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class PathingTest
/*      */ {
/*   14 */   private static final DIR[] dirs = new DIR[] {
/*   15 */       new DIR(0, -1), 
/*   16 */       new DIR(1, 0), 
/*   17 */       new DIR(0, 1), 
/*   18 */       new DIR(-1, 0)
/*      */     };
/*      */ 
/*      */   
/*      */   private static class FlooderOld
/*      */   {
/*      */     private final PathingTest.PathTile[][] tiles;
/*   25 */     int id = 0;
/*   26 */     final RBTileTree tree = new RBTileTree();
/*      */     
/*      */     private final Rectangle bounds;
/*      */     
/*      */     private Object user;
/*      */     
/*      */     FlooderOld(int size) {
/*   33 */       this.tiles = new PathingTest.PathTile[size][size];
/*   34 */       this.bounds = new Rectangle(0, 0, size, size);
/*   35 */       for (int y = 0; y < this.tiles.length; y++) {
/*   36 */         for (int x = 0; x < this.tiles.length; x++)
/*   37 */           this.tiles[y][x] = new PathingTest.PathTile((short)x, (short)y); 
/*      */       } 
/*      */     }
/*      */     
/*      */     public PathingTest.PathTile getTile(int x, int y) {
/*   42 */       return this.tiles[y][x];
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public PathingTest.PathTile pushSloppy(int x, int y, double value) {
/*   52 */       return pushSloppy(x, y, value, null);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public PathingTest.PathTile pushSloppy(int x, int y, double value, PathingTest.PathTile parent) {
/*   64 */       if (!this.bounds.contains(x, y)) {
/*   65 */         return null;
/*      */       }
/*   67 */       PathingTest.PathTile t = getTile(x, y);
/*      */       
/*   69 */       if (t.pathId == this.id) {
/*   70 */         return null;
/*      */       }
/*      */       
/*   73 */       t.pathId = this.id;
/*   74 */       t.value = (float)value;
/*   75 */       t.pathParent = parent;
/*   76 */       this.tree.put(t);
/*   77 */       t.closed = true;
/*   78 */       return t;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public PathingTest.PathTile pushSmaller(int x, int y, double value) {
/*   90 */       return pushSmaller(x, y, (float)value, null);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public PathingTest.PathTile pushSmaller(int x, int y, double value, PathingTest.PathTile parent) {
/*  106 */       PathingTest.PathTile t = getTile(x, y);
/*      */       
/*  108 */       if (t.pathId == this.id) {
/*  109 */         if (t.value <= value)
/*  110 */           return null; 
/*  111 */         if (t.closed)
/*  112 */           return null; 
/*  113 */         this.tree.remove(t);
/*      */       } 
/*      */       
/*  116 */       t.pathId = this.id;
/*  117 */       t.closed = false;
/*  118 */       t.value = (float)value;
/*  119 */       t.pathParent = parent;
/*  120 */       this.tree.put(t);
/*  121 */       return t;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public PathingTest.PathTile pollSmallest() {
/*  130 */       PathingTest.PathTile t = this.tree.pollSmallest();
/*  131 */       t.closed = true;
/*  132 */       return t;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasMore() {
/*  140 */       return (this.tree.size() > 0);
/*      */     }
/*      */     
/*      */     void init(Object user) {
/*  144 */       if (this.user != null) {
/*  145 */         throw new RuntimeException("already in use by: " + this.user.toString());
/*      */       }
/*  147 */       this.user = user;
/*  148 */       this.id++;
/*  149 */       if (this.id == 0) {
/*  150 */         for (int y = 0; y < this.tiles.length; y++) {
/*  151 */           for (int x = 0; x < this.tiles.length; x++)
/*  152 */             (this.tiles[y][x]).pathId = 0; 
/*  153 */         }  this.id = 1;
/*      */       } 
/*  155 */       this.tree.clear();
/*      */     }
/*      */     
/*      */     void done() {
/*  159 */       this.user = null;
/*      */     }
/*      */     
/*      */     static final class RBTileTree
/*      */     {
/*  164 */       private PathingTest.PathTile root = null;
/*  165 */       private int size = 0;
/*      */       
/*      */       private static final boolean RED = false;
/*      */       
/*      */       private static final boolean BLACK = true;
/*      */       
/*      */       public int size() {
/*  172 */         return this.size;
/*      */       }
/*      */       public void put(PathingTest.PathTile key) {
/*      */         int cmp;
/*  176 */         PathingTest.PathTile parent, t = this.root;
/*  177 */         if (t == null) {
/*  178 */           initTile(key, null);
/*  179 */           this.root = key;
/*  180 */           this.size = 1;
/*      */ 
/*      */           
/*      */           return;
/*      */         } 
/*      */         
/*      */         do {
/*  187 */           parent = t;
/*  188 */           cmp = key.compareTo(t);
/*  189 */           if (cmp < 0) {
/*  190 */             t = t.left;
/*  191 */           } else if (cmp > 0) {
/*  192 */             t = t.right;
/*      */           } else {
/*  194 */             throw new RuntimeException("shitstorm");
/*      */           }
/*      */         
/*  197 */         } while (t != null);
/*      */         
/*  199 */         initTile(key, parent);
/*  200 */         if (cmp < 0) {
/*  201 */           parent.left = key;
/*      */         } else {
/*  203 */           parent.right = key;
/*  204 */         }  fixAfterInsertion(key);
/*  205 */         this.size++;
/*      */       }
/*      */ 
/*      */       
/*      */       private void initTile(PathingTest.PathTile t, PathingTest.PathTile parent) {
/*  210 */         t.left = null;
/*  211 */         t.right = null;
/*  212 */         t.parent = parent;
/*  213 */         t.color = true;
/*      */       }
/*      */       
/*      */       public PathingTest.PathTile pollSmallest() {
/*  217 */         PathingTest.PathTile t = getFirstEntry();
/*  218 */         deleteEntry(t);
/*  219 */         return t;
/*      */       }
/*      */       
/*      */       public void remove(PathingTest.PathTile p) {
/*  223 */         if (p == null)
/*      */           return; 
/*  225 */         deleteEntry(p);
/*      */       }
/*      */       
/*      */       public void clear() {
/*  229 */         this.size = 0;
/*  230 */         this.root = null;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private final PathingTest.PathTile getFirstEntry() {
/*  243 */         PathingTest.PathTile p = this.root;
/*  244 */         if (p != null)
/*  245 */           while (p.left != null)
/*  246 */             p = p.left;  
/*  247 */         return p;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private PathingTest.PathTile successor(PathingTest.PathTile t) {
/*  254 */         if (t == null)
/*  255 */           return null; 
/*  256 */         if (t.right != null) {
/*  257 */           PathingTest.PathTile pathTile = t.right;
/*  258 */           while (pathTile.left != null)
/*  259 */             pathTile = pathTile.left; 
/*  260 */           return pathTile;
/*      */         } 
/*  262 */         PathingTest.PathTile p = t.parent;
/*  263 */         PathingTest.PathTile ch = t;
/*  264 */         while (p != null && ch == p.right) {
/*  265 */           ch = p;
/*  266 */           p = p.parent;
/*      */         } 
/*  268 */         return p;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private static boolean colorOf(PathingTest.PathTile p) {
/*  283 */         return (p == null) ? true : p.color;
/*      */       }
/*      */       
/*      */       private static PathingTest.PathTile parentOf(PathingTest.PathTile p) {
/*  287 */         return (p == null) ? null : p.parent;
/*      */       }
/*      */       
/*      */       private static void setColor(PathingTest.PathTile p, boolean c) {
/*  291 */         if (p != null)
/*  292 */           p.color = c; 
/*      */       }
/*      */       
/*      */       private static PathingTest.PathTile leftOf(PathingTest.PathTile p) {
/*  296 */         return (p == null) ? null : p.left;
/*      */       }
/*      */       
/*      */       private static PathingTest.PathTile rightOf(PathingTest.PathTile p) {
/*  300 */         return (p == null) ? null : p.right;
/*      */       }
/*      */ 
/*      */       
/*      */       private void rotateLeft(PathingTest.PathTile p) {
/*  305 */         if (p != null) {
/*  306 */           PathingTest.PathTile r = p.right;
/*  307 */           p.right = r.left;
/*  308 */           if (r.left != null)
/*  309 */             r.left.parent = p; 
/*  310 */           r.parent = p.parent;
/*  311 */           if (p.parent == null) {
/*  312 */             this.root = r;
/*  313 */           } else if (p.parent.left == p) {
/*  314 */             p.parent.left = r;
/*      */           } else {
/*  316 */             p.parent.right = r;
/*  317 */           }  r.left = p;
/*  318 */           p.parent = r;
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       private void rotateRight(PathingTest.PathTile p) {
/*  324 */         if (p != null) {
/*  325 */           PathingTest.PathTile l = p.left;
/*  326 */           p.left = l.right;
/*  327 */           if (l.right != null) l.right.parent = p; 
/*  328 */           l.parent = p.parent;
/*  329 */           if (p.parent == null)
/*  330 */           { this.root = l; }
/*  331 */           else if (p.parent.right == p)
/*  332 */           { p.parent.right = l; }
/*  333 */           else { p.parent.left = l; }
/*  334 */            l.right = p;
/*  335 */           p.parent = l;
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       private void fixAfterInsertion(PathingTest.PathTile x) {
/*  341 */         x.color = false;
/*      */         
/*  343 */         while (x != null && x != this.root && !x.parent.color) {
/*  344 */           if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
/*  345 */             PathingTest.PathTile pathTile = rightOf(parentOf(parentOf(x)));
/*  346 */             if (!colorOf(pathTile)) {
/*  347 */               setColor(parentOf(x), true);
/*  348 */               setColor(pathTile, true);
/*  349 */               setColor(parentOf(parentOf(x)), false);
/*  350 */               x = parentOf(parentOf(x)); continue;
/*      */             } 
/*  352 */             if (x == rightOf(parentOf(x))) {
/*  353 */               x = parentOf(x);
/*  354 */               rotateLeft(x);
/*      */             } 
/*  356 */             setColor(parentOf(x), true);
/*  357 */             setColor(parentOf(parentOf(x)), false);
/*  358 */             rotateRight(parentOf(parentOf(x)));
/*      */             continue;
/*      */           } 
/*  361 */           PathingTest.PathTile y = leftOf(parentOf(parentOf(x)));
/*  362 */           if (!colorOf(y)) {
/*  363 */             setColor(parentOf(x), true);
/*  364 */             setColor(y, true);
/*  365 */             setColor(parentOf(parentOf(x)), false);
/*  366 */             x = parentOf(parentOf(x)); continue;
/*      */           } 
/*  368 */           if (x == leftOf(parentOf(x))) {
/*  369 */             x = parentOf(x);
/*  370 */             rotateRight(x);
/*      */           } 
/*  372 */           setColor(parentOf(x), true);
/*  373 */           setColor(parentOf(parentOf(x)), false);
/*  374 */           rotateLeft(parentOf(parentOf(x)));
/*      */         } 
/*      */ 
/*      */         
/*  378 */         this.root.color = true;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private void deleteEntry(PathingTest.PathTile p) {
/*  386 */         this.size--;
/*      */         
/*  388 */         if (this.size == 0) {
/*  389 */           this.root = null;
/*      */ 
/*      */           
/*      */           return;
/*      */         } 
/*      */ 
/*      */         
/*  396 */         if (p.left != null && p.right != null) {
/*      */           
/*  398 */           PathingTest.PathTile s = successor(p);
/*  399 */           switchLoc(s, p);
/*      */         } 
/*      */ 
/*      */         
/*  403 */         PathingTest.PathTile replacement = (p.left != null) ? p.left : p.right;
/*      */         
/*  405 */         if (replacement != null) {
/*      */           
/*  407 */           replacement.parent = p.parent;
/*  408 */           if (p.parent == null) {
/*  409 */             this.root = replacement;
/*  410 */           } else if (p == p.parent.left) {
/*  411 */             p.parent.left = replacement;
/*      */           } else {
/*  413 */             p.parent.right = replacement;
/*      */           } 
/*      */           
/*  416 */           p.left = p.right = p.parent = null;
/*      */ 
/*      */           
/*  419 */           if (p.color)
/*  420 */             fixAfterDeletion(replacement); 
/*  421 */         } else if (p.parent == null) {
/*  422 */           this.root = null;
/*      */         } else {
/*  424 */           if (p.color) {
/*  425 */             fixAfterDeletion(p);
/*      */           }
/*  427 */           if (p.parent != null) {
/*  428 */             if (p == p.parent.left) {
/*  429 */               p.parent.left = null;
/*  430 */             } else if (p == p.parent.right) {
/*  431 */               p.parent.right = null;
/*  432 */             }  p.parent = null;
/*      */           } 
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       private void switchLoc(PathingTest.PathTile a, PathingTest.PathTile b) {
/*  440 */         boolean ac = a.color;
/*  441 */         a.color = b.color;
/*  442 */         b.color = ac;
/*      */         
/*  444 */         if (a.parent == b && b != null)
/*  445 */         { PathingTest.PathTile lc = a.left;
/*  446 */           PathingTest.PathTile rc = a.right;
/*      */           
/*  448 */           if (b.left == a) {
/*  449 */             a.left = b;
/*  450 */             a.right = b.right;
/*  451 */             a.right.parent = a;
/*      */           } else {
/*  453 */             a.right = b;
/*  454 */             a.left = b.left;
/*  455 */             a.left.parent = a;
/*      */           } 
/*      */           
/*  458 */           a.parent = b.parent;
/*      */           
/*  460 */           if (a.parent != null) {
/*  461 */             if (a.parent.left == b) {
/*  462 */               a.parent.left = a;
/*      */             } else {
/*  464 */               a.parent.right = a;
/*      */             } 
/*      */           }
/*  467 */           b.parent = a;
/*      */           
/*  469 */           b.left = lc;
/*  470 */           if (lc != null)
/*  471 */             lc.parent = b; 
/*  472 */           b.right = rc;
/*  473 */           if (rc != null)
/*  474 */             rc.parent = b;  }
/*  475 */         else { if (b.parent == a && b != null) {
/*  476 */             throw new RuntimeException("should not happen!");
/*      */           }
/*      */           
/*  479 */           if (b.parent != null) {
/*  480 */             if (b.parent.left == b) {
/*  481 */               b.parent.left = a;
/*      */             } else {
/*  483 */               b.parent.right = a;
/*      */             } 
/*      */           }
/*  486 */           if (a.parent != null) {
/*  487 */             if (a.parent.left == a) {
/*  488 */               a.parent.left = b;
/*      */             } else {
/*  490 */               a.parent.right = b;
/*      */             } 
/*      */           }
/*      */           
/*  494 */           PathingTest.PathTile ap = a.parent;
/*  495 */           a.parent = b.parent;
/*  496 */           b.parent = ap;
/*      */ 
/*      */           
/*  499 */           if (a.left != null)
/*  500 */             a.left.parent = b; 
/*  501 */           if (a.right != null)
/*  502 */             a.right.parent = b; 
/*  503 */           if (b.left != null)
/*  504 */             b.left.parent = a; 
/*  505 */           if (b.right != null) {
/*  506 */             b.right.parent = a;
/*      */           }
/*      */           
/*  509 */           PathingTest.PathTile al = a.left;
/*  510 */           PathingTest.PathTile ar = a.right;
/*  511 */           a.left = b.left;
/*  512 */           a.right = b.right;
/*  513 */           b.left = al;
/*  514 */           b.right = ar; }
/*      */ 
/*      */         
/*  517 */         if (a == this.root) {
/*  518 */           this.root = b;
/*  519 */         } else if (b == this.root) {
/*  520 */           this.root = a;
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       private void fixAfterDeletion(PathingTest.PathTile x) {
/*  527 */         while (x != this.root && colorOf(x)) {
/*  528 */           if (x == leftOf(parentOf(x))) {
/*  529 */             PathingTest.PathTile pathTile = rightOf(parentOf(x));
/*      */             
/*  531 */             if (!colorOf(pathTile)) {
/*  532 */               setColor(pathTile, true);
/*  533 */               setColor(parentOf(x), false);
/*  534 */               rotateLeft(parentOf(x));
/*  535 */               pathTile = rightOf(parentOf(x));
/*      */             } 
/*      */             
/*  538 */             if (colorOf(leftOf(pathTile)) && 
/*  539 */               colorOf(rightOf(pathTile))) {
/*  540 */               setColor(pathTile, false);
/*  541 */               x = parentOf(x); continue;
/*      */             } 
/*  543 */             if (colorOf(rightOf(pathTile))) {
/*  544 */               setColor(leftOf(pathTile), true);
/*  545 */               setColor(pathTile, false);
/*  546 */               rotateRight(pathTile);
/*  547 */               pathTile = rightOf(parentOf(x));
/*      */             } 
/*  549 */             setColor(pathTile, colorOf(parentOf(x)));
/*  550 */             setColor(parentOf(x), true);
/*  551 */             setColor(rightOf(pathTile), true);
/*  552 */             rotateLeft(parentOf(x));
/*  553 */             x = this.root;
/*      */             continue;
/*      */           } 
/*  556 */           PathingTest.PathTile sib = leftOf(parentOf(x));
/*      */           
/*  558 */           if (!colorOf(sib)) {
/*  559 */             setColor(sib, true);
/*  560 */             setColor(parentOf(x), false);
/*  561 */             rotateRight(parentOf(x));
/*  562 */             sib = leftOf(parentOf(x));
/*      */           } 
/*      */           
/*  565 */           if (colorOf(rightOf(sib)) && 
/*  566 */             colorOf(leftOf(sib))) {
/*  567 */             setColor(sib, false);
/*  568 */             x = parentOf(x); continue;
/*      */           } 
/*  570 */           if (colorOf(leftOf(sib))) {
/*  571 */             setColor(rightOf(sib), true);
/*  572 */             setColor(sib, false);
/*  573 */             rotateLeft(sib);
/*  574 */             sib = leftOf(parentOf(x));
/*      */           } 
/*  576 */           setColor(sib, colorOf(parentOf(x)));
/*  577 */           setColor(parentOf(x), true);
/*  578 */           setColor(leftOf(sib), true);
/*  579 */           rotateRight(parentOf(x));
/*  580 */           x = this.root;
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  585 */         setColor(x, true);
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static final class FlooderImproved
/*      */   {
/*      */     private final PathingTest.PathTile[][] tiles;
/*      */     
/*  595 */     private int id = 0;
/*      */     private final Rectangle bounds;
/*      */     private final FastTileHeap tree;
/*      */     
/*      */     public FlooderImproved(int size) {
/*  600 */       this.tiles = new PathingTest.PathTile[size][size];
/*  601 */       this.bounds = new Rectangle(0, 0, size, size);
/*      */       
/*  603 */       for (int y = 0; y < size; y++) {
/*  604 */         for (int x = 0; x < size; x++) {
/*  605 */           this.tiles[y][x] = new PathingTest.PathTile((short)x, (short)y);
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/*  610 */       this.tree = new FastTileHeap(size * size);
/*      */     }
/*      */     
/*      */     public void init() {
/*  614 */       this.id++;
/*  615 */       if (this.id == 0) {
/*  616 */         resetAllPathIds();
/*  617 */         this.id = 1;
/*      */       } 
/*  619 */       this.tree.clear(); } private void resetAllPathIds() {
/*      */       byte b;
/*      */       int i;
/*      */       PathingTest.PathTile[][] arrayOfPathTile;
/*  623 */       for (i = (arrayOfPathTile = this.tiles).length, b = 0; b < i; ) { PathingTest.PathTile[] row = arrayOfPathTile[b]; byte b1; int j; PathingTest.PathTile[] arrayOfPathTile1;
/*  624 */         for (j = (arrayOfPathTile1 = row).length, b1 = 0; b1 < j; ) { PathingTest.PathTile t = arrayOfPathTile1[b1]; t.pathId = 0; b1++; }
/*      */         
/*      */         b++; }
/*      */     
/*      */     } public PathingTest.PathTile pushSmaller(int x, int y, double value, PathingTest.PathTile parent) {
/*  629 */       if (!this.bounds.contains(x, y)) return null;
/*      */       
/*  631 */       PathingTest.PathTile t = this.tiles[y][x];
/*      */       
/*  633 */       if (t.pathId == this.id) {
/*  634 */         if (t.value <= value || t.closed) return null;
/*      */         
/*  636 */         t.value = (float)value;
/*  637 */         t.pathParent = parent;
/*  638 */         this.tree.decreaseKey(t);
/*  639 */         return t;
/*      */       } 
/*      */       
/*  642 */       t.pathId = this.id;
/*  643 */       t.closed = false;
/*  644 */       t.value = (float)value;
/*  645 */       t.pathParent = parent;
/*  646 */       t.heapIndex = 0;
/*  647 */       this.tree.insert(t);
/*  648 */       return t;
/*      */     }
/*      */     
/*      */     public PathingTest.PathTile pollSmallest() {
/*  652 */       PathingTest.PathTile t = this.tree.poll();
/*  653 */       if (t != null) {
/*  654 */         t.closed = true;
/*  655 */         t.heapIndex = 0;
/*      */       } 
/*  657 */       return t;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean hasMore() {
/*  662 */       return !this.tree.isEmpty();
/*      */     }
/*      */     
/*      */     public final class FastTileHeap
/*      */     {
/*      */       private PathingTest.PathTile[] heap;
/*  668 */       private int size = 0;
/*      */       
/*      */       public FastTileHeap(int capacity) {
/*  671 */         this.heap = new PathingTest.PathTile[capacity + 1];
/*      */       }
/*      */       
/*      */       public void clear() {
/*  675 */         this.size = 0;
/*      */       }
/*      */       
/*      */       public boolean isEmpty() {
/*  679 */         return (this.size == 0);
/*      */       }
/*      */       
/*      */       public void insert(PathingTest.PathTile tile) {
/*  683 */         if (this.size >= this.heap.length - 1) {
/*  684 */           resize();
/*      */         }
/*  686 */         this.heap[++this.size] = tile;
/*  687 */         tile.heapIndex = this.size;
/*  688 */         swim(this.size);
/*      */       }
/*      */       
/*      */       public PathingTest.PathTile poll() {
/*  692 */         if (this.size == 0) return null; 
/*  693 */         PathingTest.PathTile min = this.heap[1];
/*  694 */         this.heap[1] = this.heap[this.size];
/*  695 */         (this.heap[1]).heapIndex = 1;
/*  696 */         this.heap[this.size] = null;
/*  697 */         this.size--;
/*  698 */         if (this.size > 0) sink(1); 
/*  699 */         return min;
/*      */       }
/*      */       
/*      */       public void decreaseKey(PathingTest.PathTile tile) {
/*  703 */         if (tile.heapIndex > 0) {
/*  704 */           swim(tile.heapIndex);
/*      */         }
/*      */       }
/*      */       
/*      */       private void swim(int k) {
/*  709 */         PathingTest.PathTile tile = this.heap[k];
/*  710 */         while (k > 1) {
/*  711 */           int parent = k >>> 1;
/*  712 */           if (tile.value >= (this.heap[parent]).value)
/*  713 */             break;  this.heap[k] = this.heap[parent];
/*  714 */           (this.heap[k]).heapIndex = k;
/*  715 */           k = parent;
/*      */         } 
/*  717 */         this.heap[k] = tile;
/*  718 */         tile.heapIndex = k;
/*      */       }
/*      */       
/*      */       private void sink(int k) {
/*  722 */         PathingTest.PathTile tile = this.heap[k];
/*  723 */         while (k * 2 <= this.size) {
/*  724 */           int child = k * 2;
/*  725 */           if (child < this.size && (this.heap[child + 1]).value < (this.heap[child]).value) {
/*  726 */             child++;
/*      */           }
/*  728 */           if (tile.value <= (this.heap[child]).value)
/*  729 */             break;  this.heap[k] = this.heap[child];
/*  730 */           (this.heap[k]).heapIndex = k;
/*  731 */           k = child;
/*      */         } 
/*  733 */         this.heap[k] = tile;
/*  734 */         tile.heapIndex = k;
/*      */       }
/*      */       
/*      */       private void resize() {
/*  738 */         PathingTest.PathTile[] newHeap = new PathingTest.PathTile[this.heap.length * 2];
/*  739 */         System.arraycopy(this.heap, 0, newHeap, 0, this.heap.length);
/*  740 */         this.heap = newHeap;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static final class PathTile
/*      */     implements Comparable<PathTile>
/*      */   {
/*  748 */     int heapIndex = 0;
/*      */     final short x;
/*      */     final short y;
/*      */     float accCost;
/*      */     float value;
/*      */     PathTile pathParent;
/*  754 */     int pathId = 0;
/*      */     
/*      */     boolean closed;
/*      */     
/*      */     PathTile left;
/*      */     
/*      */     PathTile right;
/*      */     PathTile parent;
/*      */     boolean color;
/*      */     
/*      */     PathTile(short x, short y) {
/*  765 */       this.x = x;
/*  766 */       this.y = y;
/*      */     }
/*      */ 
/*      */     
/*      */     public int compareTo(PathTile o) {
/*  771 */       if (o == this)
/*  772 */         return 0; 
/*  773 */       return (this.value < o.value) ? -1 : 1;
/*      */     }
/*      */     
/*      */     public float getValue() {
/*  777 */       return this.value;
/*      */     }
/*      */     
/*      */     public float getValue2() {
/*  781 */       return this.accCost;
/*      */     }
/*      */     
/*      */     public void setValue2(double v) {
/*  785 */       this.accCost = (float)v;
/*      */     }
/*      */     
/*      */     public int x() {
/*  789 */       return this.x;
/*      */     }
/*      */     
/*      */     public int y() {
/*  793 */       return this.y;
/*      */     }
/*      */     
/*      */     public PathTile getParent() {
/*  797 */       return this.pathParent;
/*      */     }
/*      */     
/*      */     public final int parents() {
/*  801 */       int p = 0;
/*  802 */       PathTile pa = this.pathParent;
/*  803 */       while (pa != null) {
/*  804 */         p++;
/*  805 */         pa = pa.pathParent;
/*      */       } 
/*  807 */       return p;
/*      */     }
/*      */     
/*      */     public void parentSet(PathTile p) {
/*  811 */       this.pathParent = p;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/*  816 */       return "PathTile: (" + this.x + ", " + this.y + ")";
/*      */     }
/*      */   }
/*      */   
/*      */   static class DIR
/*      */   {
/*      */     final int x;
/*      */     final int y;
/*      */     
/*      */     DIR(int x, int y) {
/*  826 */       this.x = x;
/*  827 */       this.y = y;
/*      */     }
/*      */     
/*      */     public int x() {
/*  831 */       return this.x;
/*      */     }
/*      */     
/*      */     public int y() {
/*  835 */       return this.y;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void main(String[] args) {
/*  842 */     int size = 1024;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  847 */     short[][] obstacles = new short[size][size];
/*      */     
/*  849 */     for (int i = 0; i < size; i++) {
/*  850 */       obstacles[RND.rInt(size)][RND.rInt(size)] = 1;
/*      */     }
/*      */     
/*  853 */     int successes = 0;
/*  854 */     int itertations = 200;
/*      */     
/*  856 */     FlooderOld flooderOld2 = new FlooderOld(size);
/*  857 */     long now = System.currentTimeMillis();
/*      */     
/*      */     int j;
/*  860 */     for (j = 0; j < itertations; j++) {
/*      */       
/*  862 */       int destX = RND.rInt(size);
/*  863 */       int destY = RND.rInt(size);
/*      */       
/*  865 */       if (j % 10 == 0) {
/*  866 */         System.out.println(j);
/*      */       }
/*  868 */       flooderOld2.init(PathingTest.class);
/*  869 */       flooderOld2.pushSloppy(RND.rInt(size), RND.rInt(size), 0.0D);
/*      */       
/*  871 */       while (flooderOld2.hasMore()) {
/*  872 */         PathTile t = flooderOld2.pollSmallest();
/*  873 */         if (t.x() == destX && t.y == destY) {
/*  874 */           successes++; break;
/*      */         }  byte b;
/*      */         int k;
/*      */         DIR[] arrayOfDIR;
/*  878 */         for (k = (arrayOfDIR = dirs).length, b = 0; b < k; ) { DIR d = arrayOfDIR[b];
/*  879 */           int dx = t.x() + d.x;
/*  880 */           int dy = t.y() + d.y;
/*  881 */           if (flooderOld2.bounds.contains(dx, dy) && obstacles[dy][dx] == 0) {
/*  882 */             flooderOld2.pushSmaller(dx, dy, (t.getValue() + 1.0F));
/*      */           }
/*      */           b++; }
/*      */       
/*      */       } 
/*  887 */       flooderOld2.done();
/*      */     } 
/*      */     
/*  890 */     System.out.println("" + System.currentTimeMillis() - now + " " + System.currentTimeMillis() - now);
/*      */ 
/*      */ 
/*      */     
/*  894 */     FlooderImproved flooderImproved1 = new FlooderImproved(size);
/*  895 */     now = System.currentTimeMillis();
/*  896 */     successes = 0;
/*      */     
/*  898 */     for (j = 0; j < itertations; j++) {
/*      */       
/*  900 */       if (j % 10 == 0) {
/*  901 */         System.out.println(j);
/*      */       }
/*  903 */       int destX = RND.rInt(size);
/*  904 */       int destY = RND.rInt(size);
/*      */ 
/*      */       
/*  907 */       flooderImproved1.init();
/*  908 */       flooderImproved1.pushSmaller(RND.rInt(size), RND.rInt(size), 0.0D, null);
/*      */       
/*  910 */       while (flooderImproved1.hasMore()) {
/*  911 */         PathTile t = flooderImproved1.pollSmallest();
/*  912 */         if (t.x() == destX && t.y == destY) {
/*  913 */           successes++; break;
/*      */         }  byte b;
/*      */         int k;
/*      */         DIR[] arrayOfDIR;
/*  917 */         for (k = (arrayOfDIR = dirs).length, b = 0; b < k; ) { DIR d = arrayOfDIR[b];
/*  918 */           int dx = t.x() + d.x;
/*  919 */           int dy = t.y() + d.y;
/*  920 */           if (flooderImproved1.bounds.contains(dx, dy) && obstacles[dy][dx] == 0) {
/*  921 */             flooderImproved1.pushSmaller(dx, dy, (t.getValue() + 1.0F), null);
/*      */           }
/*      */           
/*      */           b++; }
/*      */       
/*      */       } 
/*      */     } 
/*  928 */     System.out.println("" + System.currentTimeMillis() - now + " " + System.currentTimeMillis() - now);
/*      */ 
/*      */ 
/*      */     
/*  932 */     FlooderOld flooderOld1 = new FlooderOld(size);
/*  933 */     now = System.currentTimeMillis();
/*      */ 
/*      */     
/*  936 */     for (j = 0; j < itertations; j++) {
/*      */       
/*  938 */       int destX = RND.rInt(size);
/*  939 */       int destY = RND.rInt(size);
/*      */       
/*  941 */       if (j % 10 == 0) {
/*  942 */         System.out.println(j);
/*      */       }
/*  944 */       flooderOld1.init(PathingTest.class);
/*  945 */       flooderOld1.pushSloppy(RND.rInt(size), RND.rInt(size), 0.0D);
/*      */       
/*  947 */       while (flooderOld1.hasMore()) {
/*  948 */         PathTile t = flooderOld1.pollSmallest();
/*  949 */         if (t.x() == destX && t.y == destY) {
/*  950 */           successes++; break;
/*      */         }  byte b;
/*      */         int k;
/*      */         DIR[] arrayOfDIR;
/*  954 */         for (k = (arrayOfDIR = dirs).length, b = 0; b < k; ) { DIR d = arrayOfDIR[b];
/*  955 */           int dx = t.x() + d.x;
/*  956 */           int dy = t.y() + d.y;
/*  957 */           if (flooderOld1.bounds.contains(dx, dy) && obstacles[dy][dx] == 0) {
/*  958 */             flooderOld1.pushSmaller(dx, dy, (t.getValue() + 1.0F));
/*      */           }
/*      */           b++; }
/*      */       
/*      */       } 
/*  963 */       flooderOld1.done();
/*      */     } 
/*      */     
/*  966 */     System.out.println("" + System.currentTimeMillis() - now + " " + System.currentTimeMillis() - now);
/*      */ 
/*      */ 
/*      */     
/*  970 */     FlooderImproved f = new FlooderImproved(size);
/*  971 */     now = System.currentTimeMillis();
/*  972 */     successes = 0;
/*      */     
/*  974 */     for (j = 0; j < itertations; j++) {
/*      */       
/*  976 */       if (j % 10 == 0) {
/*  977 */         System.out.println(j);
/*      */       }
/*  979 */       int destX = RND.rInt(size);
/*  980 */       int destY = RND.rInt(size);
/*      */ 
/*      */       
/*  983 */       f.init();
/*  984 */       f.pushSmaller(RND.rInt(size), RND.rInt(size), 0.0D, null);
/*      */       
/*  986 */       while (f.hasMore()) {
/*  987 */         PathTile t = f.pollSmallest();
/*  988 */         if (t.x() == destX && t.y == destY) {
/*  989 */           successes++; break;
/*      */         }  byte b;
/*      */         int k;
/*      */         DIR[] arrayOfDIR;
/*  993 */         for (k = (arrayOfDIR = dirs).length, b = 0; b < k; ) { DIR d = arrayOfDIR[b];
/*  994 */           int dx = t.x() + d.x;
/*  995 */           int dy = t.y() + d.y;
/*  996 */           if (f.bounds.contains(dx, dy) && obstacles[dy][dx] == 0) {
/*  997 */             f.pushSmaller(dx, dy, (t.getValue() + 1.0F), null);
/*      */           }
/*      */           
/*      */           b++; }
/*      */       
/*      */       } 
/*      */     } 
/* 1004 */     System.out.println("" + System.currentTimeMillis() - now + " " + System.currentTimeMillis() - now);
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\path\PathingTest.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */