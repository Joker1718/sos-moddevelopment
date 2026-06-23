/*     */ package snake2d.util.sets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Tree<T>
/*     */   implements ADDABLE<T>
/*     */ {
/*     */   private final Nodes nodes;
/*  17 */   private Node root = null; private static final boolean RED = false;
/*     */   
/*     */   public Tree(int size) {
/*  20 */     this.nodes = new Nodes(size);
/*     */   }
/*     */   private static final boolean BLACK = true;
/*     */   public int size() {
/*  24 */     return this.nodes.current;
/*     */   }
/*     */ 
/*     */   
/*     */   public int tryAdd(T e) {
/*  29 */     if (this.nodes.current >= this.nodes.nodes.length)
/*  30 */       return -1; 
/*  31 */     return add(e);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasRoom() {
/*  36 */     if (this.nodes.current >= this.nodes.nodes.length)
/*  37 */       return false; 
/*  38 */     return true;
/*     */   }
/*     */   
/*     */   public int add(T element) {
/*     */     boolean greater;
/*     */     Node parent;
/*  44 */     if (this.nodes.current >= this.nodes.nodes.length)
/*  45 */       throw new RuntimeException("full"); 
/*  46 */     Node key = this.nodes.getNext();
/*  47 */     key.element = element;
/*     */     
/*  49 */     Node t = this.root;
/*  50 */     if (t == null) {
/*  51 */       initTile(key, null);
/*  52 */       this.root = key;
/*  53 */       return 1;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/*  59 */       parent = t;
/*  60 */       greater = isGreaterThan(element, (T)t.element);
/*     */       
/*  62 */       if (!greater) {
/*  63 */         t = t.left;
/*     */       } else {
/*  65 */         t = t.right;
/*     */       } 
/*  67 */     } while (t != null);
/*     */     
/*  69 */     initTile(key, parent);
/*  70 */     if (!greater) {
/*  71 */       parent.left = key;
/*     */     } else {
/*  73 */       parent.right = key;
/*  74 */     }  fixAfterInsertion(key);
/*  75 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(T element) {
/*  81 */     Node t = this.root;
/*  82 */     if (t == null) {
/*  83 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/*  89 */       Node parent = t;
/*  90 */       if (parent.element.equals(element))
/*  91 */         return true; 
/*  92 */       boolean greater = isGreaterThan(element, (T)t.element);
/*     */       
/*  94 */       if (!greater) {
/*  95 */         t = t.left;
/*     */       } else {
/*  97 */         t = t.right;
/*     */       } 
/*  99 */     } while (t != null);
/*     */     
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeElement(T element) {
/* 106 */     Node t = this.root;
/* 107 */     if (t == null) {
/* 108 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/* 114 */       Node parent = t;
/* 115 */       if (parent.element.equals(element)) {
/* 116 */         deleteEntry(parent);
/* 117 */         return true;
/*     */       } 
/* 119 */       boolean greater = isGreaterThan(element, (T)t.element);
/*     */       
/* 121 */       if (!greater) {
/* 122 */         t = t.left;
/*     */       } else {
/* 124 */         t = t.right;
/*     */       } 
/* 126 */     } while (t != null);
/*     */     
/* 128 */     return false;
/*     */   }
/*     */   
/*     */   protected abstract boolean isGreaterThan(T paramT1, T paramT2);
/*     */   
/*     */   private void initTile(Node t, Node parent) {
/* 134 */     t.left = null;
/* 135 */     t.right = null;
/* 136 */     t.parent = parent;
/* 137 */     t.color = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public T pollSmallest() {
/* 142 */     Node t = getFirstEntry();
/* 143 */     deleteEntry(t);
/* 144 */     return (T)t.element;
/*     */   }
/*     */ 
/*     */   
/*     */   public T pollGreatest() {
/* 149 */     Node t = getLastEntry();
/* 150 */     deleteEntry(t);
/* 151 */     return (T)t.element;
/*     */   }
/*     */ 
/*     */   
/*     */   public T smallest() {
/* 156 */     return (T)(getFirstEntry()).element;
/*     */   }
/*     */ 
/*     */   
/*     */   public T greatest() {
/* 161 */     return (T)(getLastEntry()).element;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 165 */     this.nodes.clear();
/* 166 */     this.root = null;
/*     */   }
/*     */   
/*     */   public int capacity() {
/* 170 */     return this.nodes.nodes.length;
/*     */   }
/*     */   
/*     */   public boolean hasMore() {
/* 174 */     return (this.root != null);
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
/*     */   private final Node getFirstEntry() {
/* 187 */     Node p = this.root;
/* 188 */     if (p != null)
/* 189 */       while (p.left != null)
/* 190 */         p = p.left;  
/* 191 */     return p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Node getLastEntry() {
/* 200 */     Node p = this.root;
/* 201 */     if (p != null)
/* 202 */       while (p.right != null)
/* 203 */         p = p.right;  
/* 204 */     return p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Node successor(Node t) {
/* 211 */     if (t == null)
/* 212 */       return null; 
/* 213 */     if (t.right != null) {
/* 214 */       Node node = t.right;
/* 215 */       while (node.left != null)
/* 216 */         node = node.left; 
/* 217 */       return node;
/*     */     } 
/* 219 */     Node p = t.parent;
/* 220 */     Node ch = t;
/* 221 */     while (p != null && ch == p.right) {
/* 222 */       ch = p;
/* 223 */       p = p.parent;
/*     */     } 
/* 225 */     return p;
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
/*     */   private static boolean colorOf(Node p) {
/* 239 */     return (p == null) ? true : p.color;
/*     */   }
/*     */   
/*     */   private static Node parentOf(Node p) {
/* 243 */     return (p == null) ? null : p.parent;
/*     */   }
/*     */   
/*     */   private static void setColor(Node p, boolean c) {
/* 247 */     if (p != null)
/* 248 */       p.color = c; 
/*     */   }
/*     */   
/*     */   private static Node leftOf(Node p) {
/* 252 */     return (p == null) ? null : p.left;
/*     */   }
/*     */   
/*     */   private static Node rightOf(Node p) {
/* 256 */     return (p == null) ? null : p.right;
/*     */   }
/*     */ 
/*     */   
/*     */   private void rotateLeft(Node p) {
/* 261 */     if (p != null) {
/* 262 */       Node r = p.right;
/* 263 */       p.right = r.left;
/* 264 */       if (r.left != null)
/* 265 */         r.left.parent = p; 
/* 266 */       r.parent = p.parent;
/* 267 */       if (p.parent == null) {
/* 268 */         this.root = r;
/* 269 */       } else if (p.parent.left == p) {
/* 270 */         p.parent.left = r;
/*     */       } else {
/* 272 */         p.parent.right = r;
/* 273 */       }  r.left = p;
/* 274 */       p.parent = r;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void rotateRight(Node p) {
/* 280 */     if (p != null) {
/* 281 */       Node l = p.left;
/* 282 */       p.left = l.right;
/* 283 */       if (l.right != null)
/* 284 */         l.right.parent = p; 
/* 285 */       l.parent = p.parent;
/* 286 */       if (p.parent == null) {
/* 287 */         this.root = l;
/* 288 */       } else if (p.parent.right == p) {
/* 289 */         p.parent.right = l;
/*     */       } else {
/* 291 */         p.parent.left = l;
/* 292 */       }  l.right = p;
/* 293 */       p.parent = l;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void fixAfterInsertion(Node x) {
/* 299 */     x.color = false;
/*     */     
/* 301 */     while (x != null && x != this.root && !x.parent.color) {
/* 302 */       if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
/* 303 */         Node node = rightOf(parentOf(parentOf(x)));
/* 304 */         if (!colorOf(node)) {
/* 305 */           setColor(parentOf(x), true);
/* 306 */           setColor(node, true);
/* 307 */           setColor(parentOf(parentOf(x)), false);
/* 308 */           x = parentOf(parentOf(x)); continue;
/*     */         } 
/* 310 */         if (x == rightOf(parentOf(x))) {
/* 311 */           x = parentOf(x);
/* 312 */           rotateLeft(x);
/*     */         } 
/* 314 */         setColor(parentOf(x), true);
/* 315 */         setColor(parentOf(parentOf(x)), false);
/* 316 */         rotateRight(parentOf(parentOf(x)));
/*     */         continue;
/*     */       } 
/* 319 */       Node y = leftOf(parentOf(parentOf(x)));
/* 320 */       if (!colorOf(y)) {
/* 321 */         setColor(parentOf(x), true);
/* 322 */         setColor(y, true);
/* 323 */         setColor(parentOf(parentOf(x)), false);
/* 324 */         x = parentOf(parentOf(x)); continue;
/*     */       } 
/* 326 */       if (x == leftOf(parentOf(x))) {
/* 327 */         x = parentOf(x);
/* 328 */         rotateRight(x);
/*     */       } 
/* 330 */       setColor(parentOf(x), true);
/* 331 */       setColor(parentOf(parentOf(x)), false);
/* 332 */       rotateLeft(parentOf(parentOf(x)));
/*     */     } 
/*     */ 
/*     */     
/* 336 */     this.root.color = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void deleteEntry(Node p) {
/* 344 */     this.nodes.returnNode(p);
/*     */     
/* 346 */     if (this.nodes.current == 0) {
/* 347 */       this.root = null;
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 353 */     if (p.left != null && p.right != null) {
/*     */       
/* 355 */       Node s = successor(p);
/* 356 */       switchLoc(s, p);
/*     */     } 
/*     */ 
/*     */     
/* 360 */     Node replacement = (p.left != null) ? p.left : p.right;
/*     */     
/* 362 */     if (replacement != null) {
/*     */       
/* 364 */       replacement.parent = p.parent;
/* 365 */       if (p.parent == null) {
/* 366 */         this.root = replacement;
/* 367 */       } else if (p == p.parent.left) {
/* 368 */         p.parent.left = replacement;
/*     */       } else {
/* 370 */         p.parent.right = replacement;
/*     */       } 
/*     */       
/* 373 */       p.parent = null; p.right = null; p.left = null;
/*     */ 
/*     */       
/* 376 */       if (p.color)
/* 377 */         fixAfterDeletion(replacement); 
/* 378 */     } else if (p.parent == null) {
/* 379 */       this.root = null;
/*     */     } else {
/* 381 */       if (p.color) {
/* 382 */         fixAfterDeletion(p);
/*     */       }
/* 384 */       if (p.parent != null) {
/* 385 */         if (p == p.parent.left) {
/* 386 */           p.parent.left = null;
/* 387 */         } else if (p == p.parent.right) {
/* 388 */           p.parent.right = null;
/* 389 */         }  p.parent = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void switchLoc(Node a, Node b) {
/* 397 */     boolean ac = a.color;
/* 398 */     a.color = b.color;
/* 399 */     b.color = ac;
/*     */     
/* 401 */     if (a.parent == b && b != null)
/* 402 */     { Node lc = a.left;
/* 403 */       Node rc = a.right;
/*     */       
/* 405 */       if (b.left == a) {
/* 406 */         a.left = b;
/* 407 */         a.right = b.right;
/* 408 */         a.right.parent = a;
/*     */       } else {
/* 410 */         a.right = b;
/* 411 */         a.left = b.left;
/* 412 */         a.left.parent = a;
/*     */       } 
/*     */       
/* 415 */       a.parent = b.parent;
/*     */       
/* 417 */       if (a.parent != null) {
/* 418 */         if (a.parent.left == b) {
/* 419 */           a.parent.left = a;
/*     */         } else {
/* 421 */           a.parent.right = a;
/*     */         } 
/*     */       }
/* 424 */       b.parent = a;
/*     */       
/* 426 */       b.left = lc;
/* 427 */       if (lc != null)
/* 428 */         lc.parent = b; 
/* 429 */       b.right = rc;
/* 430 */       if (rc != null)
/* 431 */         rc.parent = b;  }
/* 432 */     else { if (b.parent == a && b != null) {
/* 433 */         throw new RuntimeException("should not happen!");
/*     */       }
/*     */       
/* 436 */       if (b.parent != null) {
/* 437 */         if (b.parent.left == b) {
/* 438 */           b.parent.left = a;
/*     */         } else {
/* 440 */           b.parent.right = a;
/*     */         } 
/*     */       }
/* 443 */       if (a.parent != null) {
/* 444 */         if (a.parent.left == a) {
/* 445 */           a.parent.left = b;
/*     */         } else {
/* 447 */           a.parent.right = b;
/*     */         } 
/*     */       }
/*     */       
/* 451 */       Node ap = a.parent;
/* 452 */       a.parent = b.parent;
/* 453 */       b.parent = ap;
/*     */ 
/*     */       
/* 456 */       if (a.left != null)
/* 457 */         a.left.parent = b; 
/* 458 */       if (a.right != null)
/* 459 */         a.right.parent = b; 
/* 460 */       if (b.left != null)
/* 461 */         b.left.parent = a; 
/* 462 */       if (b.right != null) {
/* 463 */         b.right.parent = a;
/*     */       }
/*     */       
/* 466 */       Node al = a.left;
/* 467 */       Node ar = a.right;
/* 468 */       a.left = b.left;
/* 469 */       a.right = b.right;
/* 470 */       b.left = al;
/* 471 */       b.right = ar; }
/*     */ 
/*     */     
/* 474 */     if (a == this.root) {
/* 475 */       this.root = b;
/* 476 */     } else if (b == this.root) {
/* 477 */       this.root = a;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void fixAfterDeletion(Node x) {
/* 484 */     while (x != this.root && colorOf(x)) {
/* 485 */       if (x == leftOf(parentOf(x))) {
/* 486 */         Node node = rightOf(parentOf(x));
/*     */         
/* 488 */         if (!colorOf(node)) {
/* 489 */           setColor(node, true);
/* 490 */           setColor(parentOf(x), false);
/* 491 */           rotateLeft(parentOf(x));
/* 492 */           node = rightOf(parentOf(x));
/*     */         } 
/*     */         
/* 495 */         if (colorOf(leftOf(node)) && colorOf(rightOf(node))) {
/* 496 */           setColor(node, false);
/* 497 */           x = parentOf(x); continue;
/*     */         } 
/* 499 */         if (colorOf(rightOf(node))) {
/* 500 */           setColor(leftOf(node), true);
/* 501 */           setColor(node, false);
/* 502 */           rotateRight(node);
/* 503 */           node = rightOf(parentOf(x));
/*     */         } 
/* 505 */         setColor(node, colorOf(parentOf(x)));
/* 506 */         setColor(parentOf(x), true);
/* 507 */         setColor(rightOf(node), true);
/* 508 */         rotateLeft(parentOf(x));
/* 509 */         x = this.root;
/*     */         continue;
/*     */       } 
/* 512 */       Node sib = leftOf(parentOf(x));
/*     */       
/* 514 */       if (!colorOf(sib)) {
/* 515 */         setColor(sib, true);
/* 516 */         setColor(parentOf(x), false);
/* 517 */         rotateRight(parentOf(x));
/* 518 */         sib = leftOf(parentOf(x));
/*     */       } 
/*     */       
/* 521 */       if (colorOf(rightOf(sib)) && colorOf(leftOf(sib))) {
/* 522 */         setColor(sib, false);
/* 523 */         x = parentOf(x); continue;
/*     */       } 
/* 525 */       if (colorOf(leftOf(sib))) {
/* 526 */         setColor(rightOf(sib), true);
/* 527 */         setColor(sib, false);
/* 528 */         rotateLeft(sib);
/* 529 */         sib = leftOf(parentOf(x));
/*     */       } 
/* 531 */       setColor(sib, colorOf(parentOf(x)));
/* 532 */       setColor(parentOf(x), true);
/* 533 */       setColor(leftOf(sib), true);
/* 534 */       rotateRight(parentOf(x));
/* 535 */       x = this.root;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 540 */     setColor(x, true);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Node
/*     */   {
/*     */     private int index;
/*     */     
/*     */     private Node left;
/*     */     
/*     */     private Node right;
/*     */     private Node parent;
/*     */     private boolean color;
/*     */     private Object element;
/*     */     
/*     */     private Node() {}
/*     */   }
/*     */   
/*     */   private static class Nodes
/*     */   {
/* 560 */     private int current = 0;
/*     */     private Tree.Node[] nodes;
/*     */     
/*     */     Nodes(int size) {
/* 564 */       this.nodes = new Tree.Node[size];
/* 565 */       for (int i = 0; i < size; i++)
/* 566 */         this.nodes[i] = new Tree.Node(null); 
/*     */     }
/*     */     
/*     */     private Tree.Node getNext() {
/* 570 */       Tree.Node n = this.nodes[this.current];
/* 571 */       n.index = this.current;
/* 572 */       this.current++;
/* 573 */       return n;
/*     */     }
/*     */     
/*     */     private void returnNode(Tree.Node n) {
/* 577 */       if (n.index >= this.current)
/* 578 */         throw new RuntimeException(); 
/* 579 */       if (n.index != this.current - 1) {
/* 580 */         (this.nodes[this.current - 1]).index = n.index;
/* 581 */         this.nodes[n.index] = this.nodes[this.current - 1];
/* 582 */         this.nodes[this.current - 1] = n;
/*     */       } 
/* 584 */       this.current--;
/*     */     }
/*     */ 
/*     */     
/*     */     private void clear() {
/* 589 */       this.current = 0;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\Tree.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */