/*     */ package tools.path;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class RBTileTree
/*     */ {
/* 164 */   private PathingTest.PathTile root = null;
/* 165 */   private int size = 0;
/*     */   
/*     */   private static final boolean RED = false;
/*     */   
/*     */   private static final boolean BLACK = true;
/*     */   
/*     */   public int size() {
/* 172 */     return this.size;
/*     */   }
/*     */   public void put(PathingTest.PathTile key) {
/*     */     int cmp;
/* 176 */     PathingTest.PathTile parent, t = this.root;
/* 177 */     if (t == null) {
/* 178 */       initTile(key, null);
/* 179 */       this.root = key;
/* 180 */       this.size = 1;
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     do {
/* 187 */       parent = t;
/* 188 */       cmp = key.compareTo(t);
/* 189 */       if (cmp < 0) {
/* 190 */         t = t.left;
/* 191 */       } else if (cmp > 0) {
/* 192 */         t = t.right;
/*     */       } else {
/* 194 */         throw new RuntimeException("shitstorm");
/*     */       }
/*     */     
/* 197 */     } while (t != null);
/*     */     
/* 199 */     initTile(key, parent);
/* 200 */     if (cmp < 0) {
/* 201 */       parent.left = key;
/*     */     } else {
/* 203 */       parent.right = key;
/* 204 */     }  fixAfterInsertion(key);
/* 205 */     this.size++;
/*     */   }
/*     */ 
/*     */   
/*     */   private void initTile(PathingTest.PathTile t, PathingTest.PathTile parent) {
/* 210 */     t.left = null;
/* 211 */     t.right = null;
/* 212 */     t.parent = parent;
/* 213 */     t.color = true;
/*     */   }
/*     */   
/*     */   public PathingTest.PathTile pollSmallest() {
/* 217 */     PathingTest.PathTile t = getFirstEntry();
/* 218 */     deleteEntry(t);
/* 219 */     return t;
/*     */   }
/*     */   
/*     */   public void remove(PathingTest.PathTile p) {
/* 223 */     if (p == null)
/*     */       return; 
/* 225 */     deleteEntry(p);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 229 */     this.size = 0;
/* 230 */     this.root = null;
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
/*     */   private final PathingTest.PathTile getFirstEntry() {
/* 243 */     PathingTest.PathTile p = this.root;
/* 244 */     if (p != null)
/* 245 */       while (p.left != null)
/* 246 */         p = p.left;  
/* 247 */     return p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PathingTest.PathTile successor(PathingTest.PathTile t) {
/* 254 */     if (t == null)
/* 255 */       return null; 
/* 256 */     if (t.right != null) {
/* 257 */       PathingTest.PathTile pathTile = t.right;
/* 258 */       while (pathTile.left != null)
/* 259 */         pathTile = pathTile.left; 
/* 260 */       return pathTile;
/*     */     } 
/* 262 */     PathingTest.PathTile p = t.parent;
/* 263 */     PathingTest.PathTile ch = t;
/* 264 */     while (p != null && ch == p.right) {
/* 265 */       ch = p;
/* 266 */       p = p.parent;
/*     */     } 
/* 268 */     return p;
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
/*     */   private static boolean colorOf(PathingTest.PathTile p) {
/* 283 */     return (p == null) ? true : p.color;
/*     */   }
/*     */   
/*     */   private static PathingTest.PathTile parentOf(PathingTest.PathTile p) {
/* 287 */     return (p == null) ? null : p.parent;
/*     */   }
/*     */   
/*     */   private static void setColor(PathingTest.PathTile p, boolean c) {
/* 291 */     if (p != null)
/* 292 */       p.color = c; 
/*     */   }
/*     */   
/*     */   private static PathingTest.PathTile leftOf(PathingTest.PathTile p) {
/* 296 */     return (p == null) ? null : p.left;
/*     */   }
/*     */   
/*     */   private static PathingTest.PathTile rightOf(PathingTest.PathTile p) {
/* 300 */     return (p == null) ? null : p.right;
/*     */   }
/*     */ 
/*     */   
/*     */   private void rotateLeft(PathingTest.PathTile p) {
/* 305 */     if (p != null) {
/* 306 */       PathingTest.PathTile r = p.right;
/* 307 */       p.right = r.left;
/* 308 */       if (r.left != null)
/* 309 */         r.left.parent = p; 
/* 310 */       r.parent = p.parent;
/* 311 */       if (p.parent == null) {
/* 312 */         this.root = r;
/* 313 */       } else if (p.parent.left == p) {
/* 314 */         p.parent.left = r;
/*     */       } else {
/* 316 */         p.parent.right = r;
/* 317 */       }  r.left = p;
/* 318 */       p.parent = r;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void rotateRight(PathingTest.PathTile p) {
/* 324 */     if (p != null) {
/* 325 */       PathingTest.PathTile l = p.left;
/* 326 */       p.left = l.right;
/* 327 */       if (l.right != null) l.right.parent = p; 
/* 328 */       l.parent = p.parent;
/* 329 */       if (p.parent == null)
/* 330 */       { this.root = l; }
/* 331 */       else if (p.parent.right == p)
/* 332 */       { p.parent.right = l; }
/* 333 */       else { p.parent.left = l; }
/* 334 */        l.right = p;
/* 335 */       p.parent = l;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void fixAfterInsertion(PathingTest.PathTile x) {
/* 341 */     x.color = false;
/*     */     
/* 343 */     while (x != null && x != this.root && !x.parent.color) {
/* 344 */       if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
/* 345 */         PathingTest.PathTile pathTile = rightOf(parentOf(parentOf(x)));
/* 346 */         if (!colorOf(pathTile)) {
/* 347 */           setColor(parentOf(x), true);
/* 348 */           setColor(pathTile, true);
/* 349 */           setColor(parentOf(parentOf(x)), false);
/* 350 */           x = parentOf(parentOf(x)); continue;
/*     */         } 
/* 352 */         if (x == rightOf(parentOf(x))) {
/* 353 */           x = parentOf(x);
/* 354 */           rotateLeft(x);
/*     */         } 
/* 356 */         setColor(parentOf(x), true);
/* 357 */         setColor(parentOf(parentOf(x)), false);
/* 358 */         rotateRight(parentOf(parentOf(x)));
/*     */         continue;
/*     */       } 
/* 361 */       PathingTest.PathTile y = leftOf(parentOf(parentOf(x)));
/* 362 */       if (!colorOf(y)) {
/* 363 */         setColor(parentOf(x), true);
/* 364 */         setColor(y, true);
/* 365 */         setColor(parentOf(parentOf(x)), false);
/* 366 */         x = parentOf(parentOf(x)); continue;
/*     */       } 
/* 368 */       if (x == leftOf(parentOf(x))) {
/* 369 */         x = parentOf(x);
/* 370 */         rotateRight(x);
/*     */       } 
/* 372 */       setColor(parentOf(x), true);
/* 373 */       setColor(parentOf(parentOf(x)), false);
/* 374 */       rotateLeft(parentOf(parentOf(x)));
/*     */     } 
/*     */ 
/*     */     
/* 378 */     this.root.color = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void deleteEntry(PathingTest.PathTile p) {
/* 386 */     this.size--;
/*     */     
/* 388 */     if (this.size == 0) {
/* 389 */       this.root = null;
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 396 */     if (p.left != null && p.right != null) {
/*     */       
/* 398 */       PathingTest.PathTile s = successor(p);
/* 399 */       switchLoc(s, p);
/*     */     } 
/*     */ 
/*     */     
/* 403 */     PathingTest.PathTile replacement = (p.left != null) ? p.left : p.right;
/*     */     
/* 405 */     if (replacement != null) {
/*     */       
/* 407 */       replacement.parent = p.parent;
/* 408 */       if (p.parent == null) {
/* 409 */         this.root = replacement;
/* 410 */       } else if (p == p.parent.left) {
/* 411 */         p.parent.left = replacement;
/*     */       } else {
/* 413 */         p.parent.right = replacement;
/*     */       } 
/*     */       
/* 416 */       p.left = p.right = p.parent = null;
/*     */ 
/*     */       
/* 419 */       if (p.color)
/* 420 */         fixAfterDeletion(replacement); 
/* 421 */     } else if (p.parent == null) {
/* 422 */       this.root = null;
/*     */     } else {
/* 424 */       if (p.color) {
/* 425 */         fixAfterDeletion(p);
/*     */       }
/* 427 */       if (p.parent != null) {
/* 428 */         if (p == p.parent.left) {
/* 429 */           p.parent.left = null;
/* 430 */         } else if (p == p.parent.right) {
/* 431 */           p.parent.right = null;
/* 432 */         }  p.parent = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void switchLoc(PathingTest.PathTile a, PathingTest.PathTile b) {
/* 440 */     boolean ac = a.color;
/* 441 */     a.color = b.color;
/* 442 */     b.color = ac;
/*     */     
/* 444 */     if (a.parent == b && b != null)
/* 445 */     { PathingTest.PathTile lc = a.left;
/* 446 */       PathingTest.PathTile rc = a.right;
/*     */       
/* 448 */       if (b.left == a) {
/* 449 */         a.left = b;
/* 450 */         a.right = b.right;
/* 451 */         a.right.parent = a;
/*     */       } else {
/* 453 */         a.right = b;
/* 454 */         a.left = b.left;
/* 455 */         a.left.parent = a;
/*     */       } 
/*     */       
/* 458 */       a.parent = b.parent;
/*     */       
/* 460 */       if (a.parent != null) {
/* 461 */         if (a.parent.left == b) {
/* 462 */           a.parent.left = a;
/*     */         } else {
/* 464 */           a.parent.right = a;
/*     */         } 
/*     */       }
/* 467 */       b.parent = a;
/*     */       
/* 469 */       b.left = lc;
/* 470 */       if (lc != null)
/* 471 */         lc.parent = b; 
/* 472 */       b.right = rc;
/* 473 */       if (rc != null)
/* 474 */         rc.parent = b;  }
/* 475 */     else { if (b.parent == a && b != null) {
/* 476 */         throw new RuntimeException("should not happen!");
/*     */       }
/*     */       
/* 479 */       if (b.parent != null) {
/* 480 */         if (b.parent.left == b) {
/* 481 */           b.parent.left = a;
/*     */         } else {
/* 483 */           b.parent.right = a;
/*     */         } 
/*     */       }
/* 486 */       if (a.parent != null) {
/* 487 */         if (a.parent.left == a) {
/* 488 */           a.parent.left = b;
/*     */         } else {
/* 490 */           a.parent.right = b;
/*     */         } 
/*     */       }
/*     */       
/* 494 */       PathingTest.PathTile ap = a.parent;
/* 495 */       a.parent = b.parent;
/* 496 */       b.parent = ap;
/*     */ 
/*     */       
/* 499 */       if (a.left != null)
/* 500 */         a.left.parent = b; 
/* 501 */       if (a.right != null)
/* 502 */         a.right.parent = b; 
/* 503 */       if (b.left != null)
/* 504 */         b.left.parent = a; 
/* 505 */       if (b.right != null) {
/* 506 */         b.right.parent = a;
/*     */       }
/*     */       
/* 509 */       PathingTest.PathTile al = a.left;
/* 510 */       PathingTest.PathTile ar = a.right;
/* 511 */       a.left = b.left;
/* 512 */       a.right = b.right;
/* 513 */       b.left = al;
/* 514 */       b.right = ar; }
/*     */ 
/*     */     
/* 517 */     if (a == this.root) {
/* 518 */       this.root = b;
/* 519 */     } else if (b == this.root) {
/* 520 */       this.root = a;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void fixAfterDeletion(PathingTest.PathTile x) {
/* 527 */     while (x != this.root && colorOf(x)) {
/* 528 */       if (x == leftOf(parentOf(x))) {
/* 529 */         PathingTest.PathTile pathTile = rightOf(parentOf(x));
/*     */         
/* 531 */         if (!colorOf(pathTile)) {
/* 532 */           setColor(pathTile, true);
/* 533 */           setColor(parentOf(x), false);
/* 534 */           rotateLeft(parentOf(x));
/* 535 */           pathTile = rightOf(parentOf(x));
/*     */         } 
/*     */         
/* 538 */         if (colorOf(leftOf(pathTile)) && 
/* 539 */           colorOf(rightOf(pathTile))) {
/* 540 */           setColor(pathTile, false);
/* 541 */           x = parentOf(x); continue;
/*     */         } 
/* 543 */         if (colorOf(rightOf(pathTile))) {
/* 544 */           setColor(leftOf(pathTile), true);
/* 545 */           setColor(pathTile, false);
/* 546 */           rotateRight(pathTile);
/* 547 */           pathTile = rightOf(parentOf(x));
/*     */         } 
/* 549 */         setColor(pathTile, colorOf(parentOf(x)));
/* 550 */         setColor(parentOf(x), true);
/* 551 */         setColor(rightOf(pathTile), true);
/* 552 */         rotateLeft(parentOf(x));
/* 553 */         x = this.root;
/*     */         continue;
/*     */       } 
/* 556 */       PathingTest.PathTile sib = leftOf(parentOf(x));
/*     */       
/* 558 */       if (!colorOf(sib)) {
/* 559 */         setColor(sib, true);
/* 560 */         setColor(parentOf(x), false);
/* 561 */         rotateRight(parentOf(x));
/* 562 */         sib = leftOf(parentOf(x));
/*     */       } 
/*     */       
/* 565 */       if (colorOf(rightOf(sib)) && 
/* 566 */         colorOf(leftOf(sib))) {
/* 567 */         setColor(sib, false);
/* 568 */         x = parentOf(x); continue;
/*     */       } 
/* 570 */       if (colorOf(leftOf(sib))) {
/* 571 */         setColor(rightOf(sib), true);
/* 572 */         setColor(sib, false);
/* 573 */         rotateLeft(sib);
/* 574 */         sib = leftOf(parentOf(x));
/*     */       } 
/* 576 */       setColor(sib, colorOf(parentOf(x)));
/* 577 */       setColor(parentOf(x), true);
/* 578 */       setColor(leftOf(sib), true);
/* 579 */       rotateRight(parentOf(x));
/* 580 */       x = this.root;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 585 */     setColor(x, true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\path\PathingTest$FlooderOld$RBTileTree.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */