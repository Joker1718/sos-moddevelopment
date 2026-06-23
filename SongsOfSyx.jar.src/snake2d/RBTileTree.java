/*     */ package snake2d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class RBTileTree
/*     */ {
/*  16 */   private PathTile root = null;
/*  17 */   private int size = 0;
/*     */   
/*     */   private static final boolean RED = false;
/*     */   
/*     */   private static final boolean BLACK = true;
/*     */   
/*     */   public int size() {
/*  24 */     return this.size;
/*     */   }
/*     */   public void put(PathTile key) {
/*     */     int cmp;
/*  28 */     PathTile parent, t = this.root;
/*  29 */     if (t == null) {
/*  30 */       initTile(key, null);
/*  31 */       this.root = key;
/*  32 */       this.size = 1;
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     do {
/*  39 */       parent = t;
/*  40 */       cmp = key.compareTo(t);
/*  41 */       if (cmp < 0) {
/*  42 */         t = t.left;
/*  43 */       } else if (cmp > 0) {
/*  44 */         t = t.right;
/*     */       } else {
/*  46 */         throw new RuntimeException("shitstorm");
/*     */       }
/*     */     
/*  49 */     } while (t != null);
/*     */     
/*  51 */     initTile(key, parent);
/*  52 */     if (cmp < 0) {
/*  53 */       parent.left = key;
/*     */     } else {
/*  55 */       parent.right = key;
/*  56 */     }  fixAfterInsertion(key);
/*  57 */     this.size++;
/*     */   }
/*     */ 
/*     */   
/*     */   private void initTile(PathTile t, PathTile parent) {
/*  62 */     t.left = null;
/*  63 */     t.right = null;
/*  64 */     t.parent = parent;
/*  65 */     t.color = true;
/*     */   }
/*     */   
/*     */   public PathTile pollSmallest() {
/*  69 */     PathTile t = getFirstEntry();
/*  70 */     deleteEntry(t);
/*  71 */     return t;
/*     */   }
/*     */   
/*     */   public PathTile pollGreatest() {
/*  75 */     PathTile t = getLastEntry();
/*  76 */     deleteEntry(t);
/*  77 */     return t;
/*     */   }
/*     */   
/*     */   public PathTile smallest() {
/*  81 */     return getFirstEntry();
/*     */   }
/*     */   
/*     */   public PathTile greatest() {
/*  85 */     return getLastEntry();
/*     */   }
/*     */   
/*     */   public void remove(PathTile p) {
/*  89 */     if (p == null)
/*     */       return; 
/*  91 */     deleteEntry(p);
/*     */   }
/*     */   
/*     */   public void clear() {
/*  95 */     this.size = 0;
/*  96 */     this.root = null;
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
/*     */   private final PathTile getFirstEntry() {
/* 109 */     PathTile p = this.root;
/* 110 */     if (p != null)
/* 111 */       while (p.left != null)
/* 112 */         p = p.left;  
/* 113 */     return p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final PathTile getLastEntry() {
/* 122 */     PathTile p = this.root;
/* 123 */     if (p != null)
/* 124 */       while (p.right != null)
/* 125 */         p = p.right;  
/* 126 */     return p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PathTile successor(PathTile t) {
/* 133 */     if (t == null)
/* 134 */       return null; 
/* 135 */     if (t.right != null) {
/* 136 */       PathTile pathTile = t.right;
/* 137 */       while (pathTile.left != null)
/* 138 */         pathTile = pathTile.left; 
/* 139 */       return pathTile;
/*     */     } 
/* 141 */     PathTile p = t.parent;
/* 142 */     PathTile ch = t;
/* 143 */     while (p != null && ch == p.right) {
/* 144 */       ch = p;
/* 145 */       p = p.parent;
/*     */     } 
/* 147 */     return p;
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
/*     */   private static boolean colorOf(PathTile p) {
/* 162 */     return (p == null) ? true : p.color;
/*     */   }
/*     */   
/*     */   private static PathTile parentOf(PathTile p) {
/* 166 */     return (p == null) ? null : p.parent;
/*     */   }
/*     */   
/*     */   private static void setColor(PathTile p, boolean c) {
/* 170 */     if (p != null)
/* 171 */       p.color = c; 
/*     */   }
/*     */   
/*     */   private static PathTile leftOf(PathTile p) {
/* 175 */     return (p == null) ? null : p.left;
/*     */   }
/*     */   
/*     */   private static PathTile rightOf(PathTile p) {
/* 179 */     return (p == null) ? null : p.right;
/*     */   }
/*     */ 
/*     */   
/*     */   private void rotateLeft(PathTile p) {
/* 184 */     if (p != null) {
/* 185 */       PathTile r = p.right;
/* 186 */       p.right = r.left;
/* 187 */       if (r.left != null)
/* 188 */         r.left.parent = p; 
/* 189 */       r.parent = p.parent;
/* 190 */       if (p.parent == null) {
/* 191 */         this.root = r;
/* 192 */       } else if (p.parent.left == p) {
/* 193 */         p.parent.left = r;
/*     */       } else {
/* 195 */         p.parent.right = r;
/* 196 */       }  r.left = p;
/* 197 */       p.parent = r;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void rotateRight(PathTile p) {
/* 203 */     if (p != null) {
/* 204 */       PathTile l = p.left;
/* 205 */       p.left = l.right;
/* 206 */       if (l.right != null) l.right.parent = p; 
/* 207 */       l.parent = p.parent;
/* 208 */       if (p.parent == null)
/* 209 */       { this.root = l; }
/* 210 */       else if (p.parent.right == p)
/* 211 */       { p.parent.right = l; }
/* 212 */       else { p.parent.left = l; }
/* 213 */        l.right = p;
/* 214 */       p.parent = l;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void fixAfterInsertion(PathTile x) {
/* 220 */     x.color = false;
/*     */     
/* 222 */     while (x != null && x != this.root && !x.parent.color) {
/* 223 */       if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
/* 224 */         PathTile pathTile = rightOf(parentOf(parentOf(x)));
/* 225 */         if (!colorOf(pathTile)) {
/* 226 */           setColor(parentOf(x), true);
/* 227 */           setColor(pathTile, true);
/* 228 */           setColor(parentOf(parentOf(x)), false);
/* 229 */           x = parentOf(parentOf(x)); continue;
/*     */         } 
/* 231 */         if (x == rightOf(parentOf(x))) {
/* 232 */           x = parentOf(x);
/* 233 */           rotateLeft(x);
/*     */         } 
/* 235 */         setColor(parentOf(x), true);
/* 236 */         setColor(parentOf(parentOf(x)), false);
/* 237 */         rotateRight(parentOf(parentOf(x)));
/*     */         continue;
/*     */       } 
/* 240 */       PathTile y = leftOf(parentOf(parentOf(x)));
/* 241 */       if (!colorOf(y)) {
/* 242 */         setColor(parentOf(x), true);
/* 243 */         setColor(y, true);
/* 244 */         setColor(parentOf(parentOf(x)), false);
/* 245 */         x = parentOf(parentOf(x)); continue;
/*     */       } 
/* 247 */       if (x == leftOf(parentOf(x))) {
/* 248 */         x = parentOf(x);
/* 249 */         rotateRight(x);
/*     */       } 
/* 251 */       setColor(parentOf(x), true);
/* 252 */       setColor(parentOf(parentOf(x)), false);
/* 253 */       rotateLeft(parentOf(parentOf(x)));
/*     */     } 
/*     */ 
/*     */     
/* 257 */     this.root.color = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void deleteEntry(PathTile p) {
/* 265 */     this.size--;
/*     */     
/* 267 */     if (this.size == 0) {
/* 268 */       this.root = null;
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 275 */     if (p.left != null && p.right != null) {
/*     */       
/* 277 */       PathTile s = successor(p);
/* 278 */       switchLoc(s, p);
/*     */     } 
/*     */ 
/*     */     
/* 282 */     PathTile replacement = (p.left != null) ? p.left : p.right;
/*     */     
/* 284 */     if (replacement != null) {
/*     */       
/* 286 */       replacement.parent = p.parent;
/* 287 */       if (p.parent == null) {
/* 288 */         this.root = replacement;
/* 289 */       } else if (p == p.parent.left) {
/* 290 */         p.parent.left = replacement;
/*     */       } else {
/* 292 */         p.parent.right = replacement;
/*     */       } 
/*     */       
/* 295 */       p.left = p.right = p.parent = null;
/*     */ 
/*     */       
/* 298 */       if (p.color)
/* 299 */         fixAfterDeletion(replacement); 
/* 300 */     } else if (p.parent == null) {
/* 301 */       this.root = null;
/*     */     } else {
/* 303 */       if (p.color) {
/* 304 */         fixAfterDeletion(p);
/*     */       }
/* 306 */       if (p.parent != null) {
/* 307 */         if (p == p.parent.left) {
/* 308 */           p.parent.left = null;
/* 309 */         } else if (p == p.parent.right) {
/* 310 */           p.parent.right = null;
/* 311 */         }  p.parent = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void switchLoc(PathTile a, PathTile b) {
/* 319 */     boolean ac = a.color;
/* 320 */     a.color = b.color;
/* 321 */     b.color = ac;
/*     */     
/* 323 */     if (a.parent == b && b != null)
/* 324 */     { PathTile lc = a.left;
/* 325 */       PathTile rc = a.right;
/*     */       
/* 327 */       if (b.left == a) {
/* 328 */         a.left = b;
/* 329 */         a.right = b.right;
/* 330 */         a.right.parent = a;
/*     */       } else {
/* 332 */         a.right = b;
/* 333 */         a.left = b.left;
/* 334 */         a.left.parent = a;
/*     */       } 
/*     */       
/* 337 */       a.parent = b.parent;
/*     */       
/* 339 */       if (a.parent != null) {
/* 340 */         if (a.parent.left == b) {
/* 341 */           a.parent.left = a;
/*     */         } else {
/* 343 */           a.parent.right = a;
/*     */         } 
/*     */       }
/* 346 */       b.parent = a;
/*     */       
/* 348 */       b.left = lc;
/* 349 */       if (lc != null)
/* 350 */         lc.parent = b; 
/* 351 */       b.right = rc;
/* 352 */       if (rc != null)
/* 353 */         rc.parent = b;  }
/* 354 */     else { if (b.parent == a && b != null) {
/* 355 */         throw new RuntimeException("should not happen!");
/*     */       }
/*     */       
/* 358 */       if (b.parent != null) {
/* 359 */         if (b.parent.left == b) {
/* 360 */           b.parent.left = a;
/*     */         } else {
/* 362 */           b.parent.right = a;
/*     */         } 
/*     */       }
/* 365 */       if (a.parent != null) {
/* 366 */         if (a.parent.left == a) {
/* 367 */           a.parent.left = b;
/*     */         } else {
/* 369 */           a.parent.right = b;
/*     */         } 
/*     */       }
/*     */       
/* 373 */       PathTile ap = a.parent;
/* 374 */       a.parent = b.parent;
/* 375 */       b.parent = ap;
/*     */ 
/*     */       
/* 378 */       if (a.left != null)
/* 379 */         a.left.parent = b; 
/* 380 */       if (a.right != null)
/* 381 */         a.right.parent = b; 
/* 382 */       if (b.left != null)
/* 383 */         b.left.parent = a; 
/* 384 */       if (b.right != null) {
/* 385 */         b.right.parent = a;
/*     */       }
/*     */       
/* 388 */       PathTile al = a.left;
/* 389 */       PathTile ar = a.right;
/* 390 */       a.left = b.left;
/* 391 */       a.right = b.right;
/* 392 */       b.left = al;
/* 393 */       b.right = ar; }
/*     */ 
/*     */     
/* 396 */     if (a == this.root) {
/* 397 */       this.root = b;
/* 398 */     } else if (b == this.root) {
/* 399 */       this.root = a;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void fixAfterDeletion(PathTile x) {
/* 406 */     while (x != this.root && colorOf(x)) {
/* 407 */       if (x == leftOf(parentOf(x))) {
/* 408 */         PathTile pathTile = rightOf(parentOf(x));
/*     */         
/* 410 */         if (!colorOf(pathTile)) {
/* 411 */           setColor(pathTile, true);
/* 412 */           setColor(parentOf(x), false);
/* 413 */           rotateLeft(parentOf(x));
/* 414 */           pathTile = rightOf(parentOf(x));
/*     */         } 
/*     */         
/* 417 */         if (colorOf(leftOf(pathTile)) && 
/* 418 */           colorOf(rightOf(pathTile))) {
/* 419 */           setColor(pathTile, false);
/* 420 */           x = parentOf(x); continue;
/*     */         } 
/* 422 */         if (colorOf(rightOf(pathTile))) {
/* 423 */           setColor(leftOf(pathTile), true);
/* 424 */           setColor(pathTile, false);
/* 425 */           rotateRight(pathTile);
/* 426 */           pathTile = rightOf(parentOf(x));
/*     */         } 
/* 428 */         setColor(pathTile, colorOf(parentOf(x)));
/* 429 */         setColor(parentOf(x), true);
/* 430 */         setColor(rightOf(pathTile), true);
/* 431 */         rotateLeft(parentOf(x));
/* 432 */         x = this.root;
/*     */         continue;
/*     */       } 
/* 435 */       PathTile sib = leftOf(parentOf(x));
/*     */       
/* 437 */       if (!colorOf(sib)) {
/* 438 */         setColor(sib, true);
/* 439 */         setColor(parentOf(x), false);
/* 440 */         rotateRight(parentOf(x));
/* 441 */         sib = leftOf(parentOf(x));
/*     */       } 
/*     */       
/* 444 */       if (colorOf(rightOf(sib)) && 
/* 445 */         colorOf(leftOf(sib))) {
/* 446 */         setColor(sib, false);
/* 447 */         x = parentOf(x); continue;
/*     */       } 
/* 449 */       if (colorOf(leftOf(sib))) {
/* 450 */         setColor(rightOf(sib), true);
/* 451 */         setColor(sib, false);
/* 452 */         rotateLeft(sib);
/* 453 */         sib = leftOf(parentOf(x));
/*     */       } 
/* 455 */       setColor(sib, colorOf(parentOf(x)));
/* 456 */       setColor(parentOf(x), true);
/* 457 */       setColor(leftOf(sib), true);
/* 458 */       rotateRight(parentOf(x));
/* 459 */       x = this.root;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 464 */     setColor(x, true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\RBTileTree.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */