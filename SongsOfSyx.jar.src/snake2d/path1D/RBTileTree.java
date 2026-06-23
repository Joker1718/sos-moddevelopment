/*     */ package snake2d.path1D;
/*     */ 
/*     */ 
/*     */ 
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
/*  16 */   private PTile1D root = null;
/*  17 */   private int size = 0;
/*     */   
/*     */   private static final boolean RED = false;
/*     */   
/*     */   private static final boolean BLACK = true;
/*     */   
/*     */   public int size() {
/*  24 */     return this.size;
/*     */   }
/*     */   public void put(PTile1D key) {
/*     */     int cmp;
/*  28 */     PTile1D parent, t = this.root;
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
/*     */       
/*  41 */       cmp = cmp(key, t);
/*  42 */       if (cmp < 0) {
/*  43 */         t = t.left;
/*  44 */       } else if (cmp > 0) {
/*  45 */         t = t.right;
/*     */       } else {
/*  47 */         throw new RuntimeException("shitstorm");
/*     */       }
/*     */     
/*     */     }
/*  51 */     while (t != null);
/*     */     
/*  53 */     initTile(key, parent);
/*  54 */     if (cmp < 0) {
/*  55 */       parent.left = key;
/*     */     } else {
/*  57 */       parent.right = key;
/*  58 */     }  fixAfterInsertion(key);
/*  59 */     this.size++;
/*     */   }
/*     */ 
/*     */   
/*     */   private int cmp(PTile1D key, PTile1D t) {
/*  64 */     if (key == t)
/*  65 */       throw new RuntimeException("shitstorm"); 
/*  66 */     if (key.value < t.value)
/*  67 */       return -1; 
/*  68 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   private void initTile(PTile1D t, PTile1D parent) {
/*  73 */     t.left = null;
/*  74 */     t.right = null;
/*  75 */     t.parent = parent;
/*  76 */     t.color = true;
/*     */   }
/*     */   
/*     */   public PTile1D pollSmallest() {
/*  80 */     PTile1D t = getFirstEntry();
/*  81 */     deleteEntry(t);
/*  82 */     return t;
/*     */   }
/*     */   
/*     */   public PTile1D pollGreatest() {
/*  86 */     PTile1D t = getLastEntry();
/*  87 */     deleteEntry(t);
/*  88 */     return t;
/*     */   }
/*     */   
/*     */   public PTile1D smallest() {
/*  92 */     return getFirstEntry();
/*     */   }
/*     */   
/*     */   public PTile1D greatest() {
/*  96 */     return getLastEntry();
/*     */   }
/*     */   
/*     */   public void remove(PTile1D p) {
/* 100 */     if (p == null)
/*     */       return; 
/* 102 */     deleteEntry(p);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 106 */     this.size = 0;
/* 107 */     this.root = null;
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
/*     */   private final PTile1D getFirstEntry() {
/* 120 */     PTile1D p = this.root;
/* 121 */     if (p != null)
/* 122 */       while (p.left != null)
/* 123 */         p = p.left;  
/* 124 */     return p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final PTile1D getLastEntry() {
/* 133 */     PTile1D p = this.root;
/* 134 */     if (p != null)
/* 135 */       while (p.right != null)
/* 136 */         p = p.right;  
/* 137 */     return p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PTile1D successor(PTile1D t) {
/* 144 */     if (t == null)
/* 145 */       return null; 
/* 146 */     if (t.right != null) {
/* 147 */       PTile1D pTile1D = t.right;
/* 148 */       while (pTile1D.left != null)
/* 149 */         pTile1D = pTile1D.left; 
/* 150 */       return pTile1D;
/*     */     } 
/* 152 */     PTile1D p = t.parent;
/* 153 */     PTile1D ch = t;
/* 154 */     while (p != null && ch == p.right) {
/* 155 */       ch = p;
/* 156 */       p = p.parent;
/*     */     } 
/* 158 */     return p;
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
/*     */   private static boolean colorOf(PTile1D p) {
/* 173 */     return (p == null) ? true : p.color;
/*     */   }
/*     */   
/*     */   private static PTile1D parentOf(PTile1D p) {
/* 177 */     return (p == null) ? null : p.parent;
/*     */   }
/*     */   
/*     */   private static void setColor(PTile1D p, boolean c) {
/* 181 */     if (p != null)
/* 182 */       p.color = c; 
/*     */   }
/*     */   
/*     */   private static PTile1D leftOf(PTile1D p) {
/* 186 */     return (p == null) ? null : p.left;
/*     */   }
/*     */   
/*     */   private static PTile1D rightOf(PTile1D p) {
/* 190 */     return (p == null) ? null : p.right;
/*     */   }
/*     */ 
/*     */   
/*     */   private void rotateLeft(PTile1D p) {
/* 195 */     if (p != null) {
/* 196 */       PTile1D r = p.right;
/* 197 */       p.right = r.left;
/* 198 */       if (r.left != null)
/* 199 */         r.left.parent = p; 
/* 200 */       r.parent = p.parent;
/* 201 */       if (p.parent == null) {
/* 202 */         this.root = r;
/* 203 */       } else if (p.parent.left == p) {
/* 204 */         p.parent.left = r;
/*     */       } else {
/* 206 */         p.parent.right = r;
/* 207 */       }  r.left = p;
/* 208 */       p.parent = r;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void rotateRight(PTile1D p) {
/* 214 */     if (p != null) {
/* 215 */       PTile1D l = p.left;
/* 216 */       p.left = l.right;
/* 217 */       if (l.right != null) l.right.parent = p; 
/* 218 */       l.parent = p.parent;
/* 219 */       if (p.parent == null)
/* 220 */       { this.root = l; }
/* 221 */       else if (p.parent.right == p)
/* 222 */       { p.parent.right = l; }
/* 223 */       else { p.parent.left = l; }
/* 224 */        l.right = p;
/* 225 */       p.parent = l;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void fixAfterInsertion(PTile1D x) {
/* 231 */     x.color = false;
/*     */     
/* 233 */     while (x != null && x != this.root && !x.parent.color) {
/* 234 */       if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
/* 235 */         PTile1D pTile1D = rightOf(parentOf(parentOf(x)));
/* 236 */         if (!colorOf(pTile1D)) {
/* 237 */           setColor(parentOf(x), true);
/* 238 */           setColor(pTile1D, true);
/* 239 */           setColor(parentOf(parentOf(x)), false);
/* 240 */           x = parentOf(parentOf(x)); continue;
/*     */         } 
/* 242 */         if (x == rightOf(parentOf(x))) {
/* 243 */           x = parentOf(x);
/* 244 */           rotateLeft(x);
/*     */         } 
/* 246 */         setColor(parentOf(x), true);
/* 247 */         setColor(parentOf(parentOf(x)), false);
/* 248 */         rotateRight(parentOf(parentOf(x)));
/*     */         continue;
/*     */       } 
/* 251 */       PTile1D y = leftOf(parentOf(parentOf(x)));
/* 252 */       if (!colorOf(y)) {
/* 253 */         setColor(parentOf(x), true);
/* 254 */         setColor(y, true);
/* 255 */         setColor(parentOf(parentOf(x)), false);
/* 256 */         x = parentOf(parentOf(x)); continue;
/*     */       } 
/* 258 */       if (x == leftOf(parentOf(x))) {
/* 259 */         x = parentOf(x);
/* 260 */         rotateRight(x);
/*     */       } 
/* 262 */       setColor(parentOf(x), true);
/* 263 */       setColor(parentOf(parentOf(x)), false);
/* 264 */       rotateLeft(parentOf(parentOf(x)));
/*     */     } 
/*     */ 
/*     */     
/* 268 */     this.root.color = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void deleteEntry(PTile1D p) {
/* 276 */     this.size--;
/*     */     
/* 278 */     if (this.size == 0) {
/* 279 */       this.root = null;
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 286 */     if (p.left != null && p.right != null) {
/*     */       
/* 288 */       PTile1D s = successor(p);
/* 289 */       switchLoc(s, p);
/*     */     } 
/*     */ 
/*     */     
/* 293 */     PTile1D replacement = (p.left != null) ? p.left : p.right;
/*     */     
/* 295 */     if (replacement != null) {
/*     */       
/* 297 */       replacement.parent = p.parent;
/* 298 */       if (p.parent == null) {
/* 299 */         this.root = replacement;
/* 300 */       } else if (p == p.parent.left) {
/* 301 */         p.parent.left = replacement;
/*     */       } else {
/* 303 */         p.parent.right = replacement;
/*     */       } 
/*     */       
/* 306 */       p.left = p.right = p.parent = null;
/*     */ 
/*     */       
/* 309 */       if (p.color)
/* 310 */         fixAfterDeletion(replacement); 
/* 311 */     } else if (p.parent == null) {
/* 312 */       this.root = null;
/*     */     } else {
/* 314 */       if (p.color) {
/* 315 */         fixAfterDeletion(p);
/*     */       }
/* 317 */       if (p.parent != null) {
/* 318 */         if (p == p.parent.left) {
/* 319 */           p.parent.left = null;
/* 320 */         } else if (p == p.parent.right) {
/* 321 */           p.parent.right = null;
/* 322 */         }  p.parent = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void switchLoc(PTile1D a, PTile1D b) {
/* 330 */     boolean ac = a.color;
/* 331 */     a.color = b.color;
/* 332 */     b.color = ac;
/*     */     
/* 334 */     if (a.parent == b && b != null)
/* 335 */     { PTile1D lc = a.left;
/* 336 */       PTile1D rc = a.right;
/*     */       
/* 338 */       if (b.left == a) {
/* 339 */         a.left = b;
/* 340 */         a.right = b.right;
/* 341 */         a.right.parent = a;
/*     */       } else {
/* 343 */         a.right = b;
/* 344 */         a.left = b.left;
/* 345 */         a.left.parent = a;
/*     */       } 
/*     */       
/* 348 */       a.parent = b.parent;
/*     */       
/* 350 */       if (a.parent != null) {
/* 351 */         if (a.parent.left == b) {
/* 352 */           a.parent.left = a;
/*     */         } else {
/* 354 */           a.parent.right = a;
/*     */         } 
/*     */       }
/* 357 */       b.parent = a;
/*     */       
/* 359 */       b.left = lc;
/* 360 */       if (lc != null)
/* 361 */         lc.parent = b; 
/* 362 */       b.right = rc;
/* 363 */       if (rc != null)
/* 364 */         rc.parent = b;  }
/* 365 */     else { if (b.parent == a && b != null) {
/* 366 */         throw new RuntimeException("should not happen!");
/*     */       }
/*     */       
/* 369 */       if (b.parent != null) {
/* 370 */         if (b.parent.left == b) {
/* 371 */           b.parent.left = a;
/*     */         } else {
/* 373 */           b.parent.right = a;
/*     */         } 
/*     */       }
/* 376 */       if (a.parent != null) {
/* 377 */         if (a.parent.left == a) {
/* 378 */           a.parent.left = b;
/*     */         } else {
/* 380 */           a.parent.right = b;
/*     */         } 
/*     */       }
/*     */       
/* 384 */       PTile1D ap = a.parent;
/* 385 */       a.parent = b.parent;
/* 386 */       b.parent = ap;
/*     */ 
/*     */       
/* 389 */       if (a.left != null)
/* 390 */         a.left.parent = b; 
/* 391 */       if (a.right != null)
/* 392 */         a.right.parent = b; 
/* 393 */       if (b.left != null)
/* 394 */         b.left.parent = a; 
/* 395 */       if (b.right != null) {
/* 396 */         b.right.parent = a;
/*     */       }
/*     */       
/* 399 */       PTile1D al = a.left;
/* 400 */       PTile1D ar = a.right;
/* 401 */       a.left = b.left;
/* 402 */       a.right = b.right;
/* 403 */       b.left = al;
/* 404 */       b.right = ar; }
/*     */ 
/*     */     
/* 407 */     if (a == this.root) {
/* 408 */       this.root = b;
/* 409 */     } else if (b == this.root) {
/* 410 */       this.root = a;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void fixAfterDeletion(PTile1D x) {
/* 417 */     while (x != this.root && colorOf(x)) {
/* 418 */       if (x == leftOf(parentOf(x))) {
/* 419 */         PTile1D pTile1D = rightOf(parentOf(x));
/*     */         
/* 421 */         if (!colorOf(pTile1D)) {
/* 422 */           setColor(pTile1D, true);
/* 423 */           setColor(parentOf(x), false);
/* 424 */           rotateLeft(parentOf(x));
/* 425 */           pTile1D = rightOf(parentOf(x));
/*     */         } 
/*     */         
/* 428 */         if (colorOf(leftOf(pTile1D)) && 
/* 429 */           colorOf(rightOf(pTile1D))) {
/* 430 */           setColor(pTile1D, false);
/* 431 */           x = parentOf(x); continue;
/*     */         } 
/* 433 */         if (colorOf(rightOf(pTile1D))) {
/* 434 */           setColor(leftOf(pTile1D), true);
/* 435 */           setColor(pTile1D, false);
/* 436 */           rotateRight(pTile1D);
/* 437 */           pTile1D = rightOf(parentOf(x));
/*     */         } 
/* 439 */         setColor(pTile1D, colorOf(parentOf(x)));
/* 440 */         setColor(parentOf(x), true);
/* 441 */         setColor(rightOf(pTile1D), true);
/* 442 */         rotateLeft(parentOf(x));
/* 443 */         x = this.root;
/*     */         continue;
/*     */       } 
/* 446 */       PTile1D sib = leftOf(parentOf(x));
/*     */       
/* 448 */       if (!colorOf(sib)) {
/* 449 */         setColor(sib, true);
/* 450 */         setColor(parentOf(x), false);
/* 451 */         rotateRight(parentOf(x));
/* 452 */         sib = leftOf(parentOf(x));
/*     */       } 
/*     */       
/* 455 */       if (colorOf(rightOf(sib)) && 
/* 456 */         colorOf(leftOf(sib))) {
/* 457 */         setColor(sib, false);
/* 458 */         x = parentOf(x); continue;
/*     */       } 
/* 460 */       if (colorOf(leftOf(sib))) {
/* 461 */         setColor(rightOf(sib), true);
/* 462 */         setColor(sib, false);
/* 463 */         rotateLeft(sib);
/* 464 */         sib = leftOf(parentOf(x));
/*     */       } 
/* 466 */       setColor(sib, colorOf(parentOf(x)));
/* 467 */       setColor(parentOf(x), true);
/* 468 */       setColor(leftOf(sib), true);
/* 469 */       rotateRight(parentOf(x));
/* 470 */       x = this.root;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 475 */     setColor(x, true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\path1D\RBTileTree.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */