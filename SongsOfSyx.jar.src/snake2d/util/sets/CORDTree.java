/*     */ package snake2d.util.sets;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CORDTree
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  19 */   private CORD root = null;
/*  20 */   private int size = 0;
/*     */   
/*     */   private static final boolean RED = false;
/*     */   
/*     */   private static final boolean BLACK = true;
/*     */   
/*     */   public int size() {
/*  27 */     return this.size;
/*     */   }
/*     */   
/*     */   public void put(CORD key, double value) {
/*     */     CORD parent;
/*  32 */     key.value = (float)value;
/*  33 */     CORD t = this.root;
/*  34 */     if (t == null) {
/*  35 */       initTile(key, null);
/*  36 */       this.root = key;
/*  37 */       this.size = 1;
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     do {
/*  44 */       parent = t;
/*     */       
/*  46 */       if (key == t) {
/*  47 */         throw new RuntimeException();
/*     */       }
/*  49 */       if (key.value < t.value) {
/*  50 */         t = t.left;
/*     */       } else {
/*  52 */         t = t.right;
/*     */       }
/*     */     
/*  55 */     } while (t != null);
/*     */     
/*  57 */     initTile(key, parent);
/*  58 */     if (key.value < parent.value) {
/*  59 */       parent.left = key;
/*     */     } else {
/*  61 */       parent.right = key;
/*  62 */     }  fixAfterInsertion(key);
/*  63 */     this.size++;
/*     */   }
/*     */ 
/*     */   
/*     */   private void initTile(CORD t, CORD parent) {
/*  68 */     t.left = null;
/*  69 */     t.right = null;
/*  70 */     t.parent = parent;
/*  71 */     t.color = true;
/*     */   }
/*     */   
/*     */   public CORD pollSmallest() {
/*  75 */     CORD t = getFirstEntry();
/*  76 */     deleteEntry(t);
/*  77 */     return t;
/*     */   }
/*     */   
/*     */   public CORD pollGreatest() {
/*  81 */     CORD t = getLastEntry();
/*  82 */     deleteEntry(t);
/*  83 */     return t;
/*     */   }
/*     */   
/*     */   public CORD smallest() {
/*  87 */     return getFirstEntry();
/*     */   }
/*     */   
/*     */   public CORD greatest() {
/*  91 */     return getLastEntry();
/*     */   }
/*     */   
/*     */   public void remove(CORD p) {
/*  95 */     if (p == null)
/*     */       return; 
/*  97 */     deleteEntry(p);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 101 */     this.size = 0;
/* 102 */     this.root = null;
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
/*     */   private final CORD getFirstEntry() {
/* 115 */     CORD p = this.root;
/* 116 */     if (p != null)
/* 117 */       while (p.left != null)
/* 118 */         p = p.left;  
/* 119 */     return p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final CORD getLastEntry() {
/* 128 */     CORD p = this.root;
/* 129 */     if (p != null)
/* 130 */       while (p.right != null)
/* 131 */         p = p.right;  
/* 132 */     return p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CORD successor(CORD t) {
/* 139 */     if (t == null)
/* 140 */       return null; 
/* 141 */     if (t.right != null) {
/* 142 */       CORD cORD = t.right;
/* 143 */       while (cORD.left != null)
/* 144 */         cORD = cORD.left; 
/* 145 */       return cORD;
/*     */     } 
/* 147 */     CORD p = t.parent;
/* 148 */     CORD ch = t;
/* 149 */     while (p != null && ch == p.right) {
/* 150 */       ch = p;
/* 151 */       p = p.parent;
/*     */     } 
/* 153 */     return p;
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
/*     */   private static boolean colorOf(CORD p) {
/* 168 */     return (p == null) ? true : p.color;
/*     */   }
/*     */   
/*     */   private static CORD parentOf(CORD p) {
/* 172 */     return (p == null) ? null : p.parent;
/*     */   }
/*     */   
/*     */   private static void setColor(CORD p, boolean c) {
/* 176 */     if (p != null)
/* 177 */       p.color = c; 
/*     */   }
/*     */   
/*     */   private static CORD leftOf(CORD p) {
/* 181 */     return (p == null) ? null : p.left;
/*     */   }
/*     */   
/*     */   private static CORD rightOf(CORD p) {
/* 185 */     return (p == null) ? null : p.right;
/*     */   }
/*     */ 
/*     */   
/*     */   private void rotateLeft(CORD p) {
/* 190 */     if (p != null) {
/* 191 */       CORD r = p.right;
/* 192 */       p.right = r.left;
/* 193 */       if (r.left != null)
/* 194 */         r.left.parent = p; 
/* 195 */       r.parent = p.parent;
/* 196 */       if (p.parent == null) {
/* 197 */         this.root = r;
/* 198 */       } else if (p.parent.left == p) {
/* 199 */         p.parent.left = r;
/*     */       } else {
/* 201 */         p.parent.right = r;
/* 202 */       }  r.left = p;
/* 203 */       p.parent = r;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void rotateRight(CORD p) {
/* 209 */     if (p != null) {
/* 210 */       CORD l = p.left;
/* 211 */       p.left = l.right;
/* 212 */       if (l.right != null) l.right.parent = p; 
/* 213 */       l.parent = p.parent;
/* 214 */       if (p.parent == null)
/* 215 */       { this.root = l; }
/* 216 */       else if (p.parent.right == p)
/* 217 */       { p.parent.right = l; }
/* 218 */       else { p.parent.left = l; }
/* 219 */        l.right = p;
/* 220 */       p.parent = l;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void fixAfterInsertion(CORD x) {
/* 226 */     x.color = false;
/*     */     
/* 228 */     while (x != null && x != this.root && !x.parent.color) {
/* 229 */       if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
/* 230 */         CORD cORD = rightOf(parentOf(parentOf(x)));
/* 231 */         if (!colorOf(cORD)) {
/* 232 */           setColor(parentOf(x), true);
/* 233 */           setColor(cORD, true);
/* 234 */           setColor(parentOf(parentOf(x)), false);
/* 235 */           x = parentOf(parentOf(x)); continue;
/*     */         } 
/* 237 */         if (x == rightOf(parentOf(x))) {
/* 238 */           x = parentOf(x);
/* 239 */           rotateLeft(x);
/*     */         } 
/* 241 */         setColor(parentOf(x), true);
/* 242 */         setColor(parentOf(parentOf(x)), false);
/* 243 */         rotateRight(parentOf(parentOf(x)));
/*     */         continue;
/*     */       } 
/* 246 */       CORD y = leftOf(parentOf(parentOf(x)));
/* 247 */       if (!colorOf(y)) {
/* 248 */         setColor(parentOf(x), true);
/* 249 */         setColor(y, true);
/* 250 */         setColor(parentOf(parentOf(x)), false);
/* 251 */         x = parentOf(parentOf(x)); continue;
/*     */       } 
/* 253 */       if (x == leftOf(parentOf(x))) {
/* 254 */         x = parentOf(x);
/* 255 */         rotateRight(x);
/*     */       } 
/* 257 */       setColor(parentOf(x), true);
/* 258 */       setColor(parentOf(parentOf(x)), false);
/* 259 */       rotateLeft(parentOf(parentOf(x)));
/*     */     } 
/*     */ 
/*     */     
/* 263 */     this.root.color = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void deleteEntry(CORD p) {
/* 271 */     this.size--;
/*     */     
/* 273 */     if (this.size == 0) {
/* 274 */       this.root = null;
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 281 */     if (p.left != null && p.right != null) {
/*     */       
/* 283 */       CORD s = successor(p);
/* 284 */       switchLoc(s, p);
/*     */     } 
/*     */ 
/*     */     
/* 288 */     CORD replacement = (p.left != null) ? p.left : p.right;
/*     */     
/* 290 */     if (replacement != null) {
/*     */       
/* 292 */       replacement.parent = p.parent;
/* 293 */       if (p.parent == null) {
/* 294 */         this.root = replacement;
/* 295 */       } else if (p == p.parent.left) {
/* 296 */         p.parent.left = replacement;
/*     */       } else {
/* 298 */         p.parent.right = replacement;
/*     */       } 
/*     */       
/* 301 */       p.left = p.right = p.parent = null;
/*     */ 
/*     */       
/* 304 */       if (p.color)
/* 305 */         fixAfterDeletion(replacement); 
/* 306 */     } else if (p.parent == null) {
/* 307 */       this.root = null;
/*     */     } else {
/* 309 */       if (p.color) {
/* 310 */         fixAfterDeletion(p);
/*     */       }
/* 312 */       if (p.parent != null) {
/* 313 */         if (p == p.parent.left) {
/* 314 */           p.parent.left = null;
/* 315 */         } else if (p == p.parent.right) {
/* 316 */           p.parent.right = null;
/* 317 */         }  p.parent = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void switchLoc(CORD a, CORD b) {
/* 325 */     boolean ac = a.color;
/* 326 */     a.color = b.color;
/* 327 */     b.color = ac;
/*     */     
/* 329 */     if (a.parent == b && b != null)
/* 330 */     { CORD lc = a.left;
/* 331 */       CORD rc = a.right;
/*     */       
/* 333 */       if (b.left == a) {
/* 334 */         a.left = b;
/* 335 */         a.right = b.right;
/* 336 */         a.right.parent = a;
/*     */       } else {
/* 338 */         a.right = b;
/* 339 */         a.left = b.left;
/* 340 */         a.left.parent = a;
/*     */       } 
/*     */       
/* 343 */       a.parent = b.parent;
/*     */       
/* 345 */       if (a.parent != null) {
/* 346 */         if (a.parent.left == b) {
/* 347 */           a.parent.left = a;
/*     */         } else {
/* 349 */           a.parent.right = a;
/*     */         } 
/*     */       }
/* 352 */       b.parent = a;
/*     */       
/* 354 */       b.left = lc;
/* 355 */       if (lc != null)
/* 356 */         lc.parent = b; 
/* 357 */       b.right = rc;
/* 358 */       if (rc != null)
/* 359 */         rc.parent = b;  }
/* 360 */     else { if (b.parent == a && b != null) {
/* 361 */         throw new RuntimeException("should not happen!");
/*     */       }
/*     */       
/* 364 */       if (b.parent != null) {
/* 365 */         if (b.parent.left == b) {
/* 366 */           b.parent.left = a;
/*     */         } else {
/* 368 */           b.parent.right = a;
/*     */         } 
/*     */       }
/* 371 */       if (a.parent != null) {
/* 372 */         if (a.parent.left == a) {
/* 373 */           a.parent.left = b;
/*     */         } else {
/* 375 */           a.parent.right = b;
/*     */         } 
/*     */       }
/*     */       
/* 379 */       CORD ap = a.parent;
/* 380 */       a.parent = b.parent;
/* 381 */       b.parent = ap;
/*     */ 
/*     */       
/* 384 */       if (a.left != null)
/* 385 */         a.left.parent = b; 
/* 386 */       if (a.right != null)
/* 387 */         a.right.parent = b; 
/* 388 */       if (b.left != null)
/* 389 */         b.left.parent = a; 
/* 390 */       if (b.right != null) {
/* 391 */         b.right.parent = a;
/*     */       }
/*     */       
/* 394 */       CORD al = a.left;
/* 395 */       CORD ar = a.right;
/* 396 */       a.left = b.left;
/* 397 */       a.right = b.right;
/* 398 */       b.left = al;
/* 399 */       b.right = ar; }
/*     */ 
/*     */     
/* 402 */     if (a == this.root) {
/* 403 */       this.root = b;
/* 404 */     } else if (b == this.root) {
/* 405 */       this.root = a;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void fixAfterDeletion(CORD x) {
/* 412 */     while (x != this.root && colorOf(x)) {
/* 413 */       if (x == leftOf(parentOf(x))) {
/* 414 */         CORD cORD = rightOf(parentOf(x));
/*     */         
/* 416 */         if (!colorOf(cORD)) {
/* 417 */           setColor(cORD, true);
/* 418 */           setColor(parentOf(x), false);
/* 419 */           rotateLeft(parentOf(x));
/* 420 */           cORD = rightOf(parentOf(x));
/*     */         } 
/*     */         
/* 423 */         if (colorOf(leftOf(cORD)) && 
/* 424 */           colorOf(rightOf(cORD))) {
/* 425 */           setColor(cORD, false);
/* 426 */           x = parentOf(x); continue;
/*     */         } 
/* 428 */         if (colorOf(rightOf(cORD))) {
/* 429 */           setColor(leftOf(cORD), true);
/* 430 */           setColor(cORD, false);
/* 431 */           rotateRight(cORD);
/* 432 */           cORD = rightOf(parentOf(x));
/*     */         } 
/* 434 */         setColor(cORD, colorOf(parentOf(x)));
/* 435 */         setColor(parentOf(x), true);
/* 436 */         setColor(rightOf(cORD), true);
/* 437 */         rotateLeft(parentOf(x));
/* 438 */         x = this.root;
/*     */         continue;
/*     */       } 
/* 441 */       CORD sib = leftOf(parentOf(x));
/*     */       
/* 443 */       if (!colorOf(sib)) {
/* 444 */         setColor(sib, true);
/* 445 */         setColor(parentOf(x), false);
/* 446 */         rotateRight(parentOf(x));
/* 447 */         sib = leftOf(parentOf(x));
/*     */       } 
/*     */       
/* 450 */       if (colorOf(rightOf(sib)) && 
/* 451 */         colorOf(leftOf(sib))) {
/* 452 */         setColor(sib, false);
/* 453 */         x = parentOf(x); continue;
/*     */       } 
/* 455 */       if (colorOf(leftOf(sib))) {
/* 456 */         setColor(rightOf(sib), true);
/* 457 */         setColor(sib, false);
/* 458 */         rotateLeft(sib);
/* 459 */         sib = leftOf(parentOf(x));
/*     */       } 
/* 461 */       setColor(sib, colorOf(parentOf(x)));
/* 462 */       setColor(parentOf(x), true);
/* 463 */       setColor(leftOf(sib), true);
/* 464 */       rotateRight(parentOf(x));
/* 465 */       x = this.root;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 470 */     setColor(x, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class CORD
/*     */     implements COORDINATE, Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private short x;
/*     */     
/*     */     private short y;
/*     */     
/*     */     float value;
/*     */     
/*     */     CORD left;
/*     */     CORD right;
/*     */     CORD parent;
/*     */     boolean color;
/*     */     
/*     */     public int x() {
/* 491 */       return this.x;
/*     */     }
/*     */ 
/*     */     
/*     */     public int y() {
/* 496 */       return this.y;
/*     */     }
/*     */     
/*     */     public CORD set(int x, int y) {
/* 500 */       this.x = (short)x;
/* 501 */       this.y = (short)y;
/* 502 */       return this;
/*     */     }
/*     */     
/*     */     public double value() {
/* 506 */       return this.value;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\CORDTree.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */