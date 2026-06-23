/*     */ package world.map.pathing;
/*     */ 
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.IntChecker;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Finder
/*     */ {
/*     */   Comps cc;
/*     */   private final WDirMap m;
/*     */   private final ArrayList<PathTile> result;
/*     */   private final IntChecker destCheck;
/*     */   private final IntChecker absPath;
/*     */   private final short[] prevRegion;
/*     */   
/*     */   Finder(Comps cc, WDirMap m) {
/* 346 */     this.cc = cc;
/* 347 */     this.m = m;
/* 348 */     this.prevRegion = new short[cc.all.length];
/* 349 */     this.result = new ArrayList(cc.all.length);
/* 350 */     this.destCheck = new IntChecker(cc.all.length);
/* 351 */     this.absPath = new IntChecker(cc.all.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public PathTile find(COORDINATE start, int endX, int endY, WRegFinder.Treaty trav) {
/* 356 */     return find(start.x(), start.y(), endX, endY, trav);
/*     */   }
/*     */   
/*     */   public PathTile find(int startX, int startY, COORDINATE end, WRegFinder.Treaty trav) {
/* 360 */     return find(startX, startY, end.x(), end.y(), trav);
/*     */   }
/*     */   
/*     */   public PathTile find(COORDINATE start, COORDINATE end, WRegFinder.Treaty trav) {
/* 364 */     return find(start.x(), start.y(), end.x(), end.y(), trav);
/*     */   }
/*     */ 
/*     */   
/*     */   public PathTile find(int startX, int startY, int endX, int endY, WRegFinder.Treaty trav) {
/* 369 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 370 */     f.init(this);
/*     */ 
/*     */ 
/*     */     
/* 374 */     PathTile start = f.pushSloppy(endX, endY, 0.0D);
/*     */     
/* 376 */     if (startX == endX && startY == endY) {
/* 377 */       f.done();
/* 378 */       return start;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 385 */     this.destCheck.init();
/* 386 */     this.result.clearSloppy();
/* 387 */     boolean succ = false;
/* 388 */     while (f.hasMore()) {
/* 389 */       PathTile t = f.pollSmallest();
/*     */       
/* 391 */       if (t.isSameAs(startX, startY)) {
/* 392 */         f.done();
/* 393 */         return f.reverse(t);
/*     */       } 
/*     */       
/* 396 */       Comps.WComp c = (Comps.WComp)this.cc.get((COORDINATE)t);
/* 397 */       if (c != null) {
/* 398 */         this.destCheck.isSetAndSet(c.id);
/* 399 */         this.result.add(t);
/* 400 */         t.setValue2(t.getValue());
/* 401 */         c.wayBackDest = t.getParent();
/* 402 */         succ = true;
/*     */         
/*     */         continue;
/*     */       } 
/* 406 */       this.m.push(t, t.getValue());
/*     */     } 
/* 408 */     if (!succ) {
/* 409 */       f.done();
/* 410 */       return null;
/*     */     } 
/* 412 */     for (PathTile c : this.result) {
/* 413 */       f.reopen(c);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 423 */     this.result.clearSloppy();
/* 424 */     f.pushSloppy(startX, startY, 0.0D);
/* 425 */     while (f.hasMore()) {
/* 426 */       PathTile t = f.pollSmallest();
/* 427 */       Comps.WComp c = (Comps.WComp)this.cc.get((COORDINATE)t);
/* 428 */       if (c != null) {
/*     */         
/* 430 */         if (t.isSameAs(endX, endY)) {
/* 431 */           f.done();
/* 432 */           return t;
/*     */         } 
/* 434 */         this.result.add(t);
/* 435 */         c.wayBack = t.getParent();
/* 436 */         f.setValue2((COORDINATE)t, t.getValue());
/*     */         
/*     */         continue;
/*     */       } 
/* 440 */       this.m.push(t, t.getValue());
/*     */     } 
/*     */     
/* 443 */     if (this.result.size() == 0) {
/* 444 */       f.done();
/* 445 */       return null;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 451 */     f.done();
/*     */     
/* 453 */     Region origin = (Region)(WORLD.PATH()).regMap.get(startX, startY);
/*     */ 
/*     */     
/* 456 */     boolean bool1 = false;
/*     */     
/* 458 */     f.init(f);
/*     */     
/* 460 */     this.absPath.init();
/*     */     
/* 462 */     for (PathTile c : this.result) {
/* 463 */       f.pushSloppy(c.x(), c.y(), c.getValue2());
/* 464 */       regSetStart(c);
/*     */     } 
/*     */     
/* 467 */     while (f.hasMore()) {
/* 468 */       PathTile t = f.pollSmallest();
/* 469 */       Comps.WComp c = (Comps.WComp)this.cc.get((COORDINATE)t);
/*     */       
/* 471 */       Region from = regSet(t);
/*     */       
/* 473 */       if (this.destCheck.isSet(c.id)) {
/* 474 */         while (t != null) {
/* 475 */           this.absPath.isSetAndSet(((Comps.WComp)this.cc.get((COORDINATE)t)).id);
/* 476 */           t = t.getParent();
/*     */         } 
/*     */         
/* 479 */         bool1 = true;
/*     */         
/*     */         break;
/*     */       } 
/* 483 */       for (int i = 0; i < c.neighs.length; i++) {
/* 484 */         Comps.WComp n = this.cc.all[c.neighs[i]];
/* 485 */         double v = (c.dists[i] + t.getValue());
/* 486 */         if (this.destCheck.isSet(n.id)) {
/* 487 */           v += f.getValue2(n.tx, n.ty);
/*     */         }
/* 489 */         Region to = (Region)(WORLD.PATH()).regMap.get(n.tx, n.ty);
/* 490 */         if (trav.can(origin, from, to, n.tx, n.ty, v)) {
/* 491 */           f.pushSmaller(n.tx, n.ty, v, t);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 496 */     f.done();
/* 497 */     if (!bool1) {
/* 498 */       return null;
/*     */     }
/*     */     
/* 501 */     f.init(this);
/*     */     
/* 503 */     for (PathTile t : this.result) {
/* 504 */       Comps.WComp c = (Comps.WComp)this.cc.get((COORDINATE)t);
/* 505 */       if (this.absPath.isSet(c.id)) {
/* 506 */         f.pushSloppy(t.x(), t.y(), t.getValue(), c.wayBack);
/*     */         
/* 508 */         PathTile w = c.wayBack;
/* 509 */         while (w != null) {
/* 510 */           f.close(w.x(), w.y(), w.getValue());
/* 511 */           w = w.getParent();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 517 */     while (f.hasMore()) {
/*     */       
/* 519 */       PathTile t = f.pollSmallest();
/* 520 */       Comps.WComp c = (Comps.WComp)this.cc.get((COORDINATE)t);
/*     */       
/* 522 */       if (c != null && this.destCheck.isSet(c.id)) {
/* 523 */         double v = t.getValue();
/*     */         
/* 525 */         while (c.wayBackDest != null) {
/* 526 */           PathTile p = c.wayBackDest;
/* 527 */           c.wayBackDest = c.wayBackDest.getParent();
/* 528 */           p.parentSet(t);
/*     */           
/* 530 */           t = p;
/* 531 */           if (p.isSameAs(startX, startY)) {
/* 532 */             p.parentSet(null);
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 537 */         f.setValue(t.x(), t.y(), v);
/* 538 */         f.done();
/* 539 */         return t;
/*     */       } 
/*     */       
/* 542 */       if (c != null && !this.absPath.isSet(c.id)) {
/*     */         continue;
/*     */       }
/* 545 */       int md = this.m.get(t);
/* 546 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 547 */         DIR d = (DIR)DIR.ALL.get(di);
/* 548 */         if ((md & d.bit) != 0) {
/* 549 */           Comps.WComp to = (Comps.WComp)this.cc.get((COORDINATE)t, d);
/* 550 */           double v = t.getValue() + d.tileDistance() * WDirMap.cost(t.x(), t.y(), d);
/* 551 */           if (to != null && this.destCheck.isSet(to.id) && to.wayBackDest != null) {
/* 552 */             v += to.wayBackDest.getValue();
/*     */           }
/* 554 */           f.pushSmaller((COORDINATE)t, d, v, t);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 559 */     f.done();
/* 560 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<PathTile> getComps(int sx, int sy) {
/* 568 */     this.result.clearSloppy();
/* 569 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 570 */     f.init(this);
/* 571 */     f.pushSloppy(sx, sy, 0.0D);
/*     */     
/* 573 */     while (f.hasMore()) {
/* 574 */       PathTile t = f.pollSmallest();
/* 575 */       Comps.WComp c = (Comps.WComp)this.cc.get((COORDINATE)t);
/* 576 */       if (c != null) {
/* 577 */         this.result.add(t);
/*     */         
/*     */         continue;
/*     */       } 
/* 581 */       this.m.push(t, t.getValue());
/*     */     } 
/*     */     
/* 584 */     f.done();
/* 585 */     return (LIST<PathTile>)this.result;
/*     */   }
/*     */   
/*     */   public double dist(int startX, int startY, int endX, int endY, WRegFinder.Treaty treaty) {
/* 589 */     this.destCheck.init();
/* 590 */     for (PathTile t : getComps(endX, endY)) {
/* 591 */       t.setValue2(t.getValue());
/* 592 */       this.destCheck.isSetAndSet(((Comps.WComp)this.cc.get((COORDINATE)t)).id);
/*     */     } 
/*     */     
/* 595 */     Region origin = (Region)(WORLD.PATH()).regMap.get(startX, startY);
/*     */     
/* 597 */     LIST<PathTile> ss = getComps(startX, startY);
/* 598 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 599 */     f.init(this);
/* 600 */     for (PathTile t : ss) {
/* 601 */       f.pushSloppy(t.x(), t.y(), t.getValue());
/* 602 */       regSetStart(t);
/*     */     } 
/*     */     
/* 605 */     while (f.hasMore()) {
/* 606 */       PathTile t = f.pollSmallest();
/* 607 */       Region prev = regSet(t);
/* 608 */       Comps.WComp c = (Comps.WComp)this.cc.get((COORDINATE)t);
/* 609 */       if (this.destCheck.isSet(c.id)) {
/* 610 */         f.done();
/* 611 */         return t.getValue();
/*     */       } 
/* 613 */       for (int i = 0; i < c.neighs.length; i++) {
/* 614 */         Comps.WComp n = this.cc.all[c.neighs[i]];
/* 615 */         double v = (c.dists[i] + t.getValue());
/* 616 */         if (this.destCheck.isSet(n.id)) {
/* 617 */           v += f.getValue2(n.tx, n.ty);
/*     */         }
/* 619 */         if (treaty.can(origin, prev, (Region)(WORLD.PATH()).regMap.get(n.tx, n.ty), n.tx, n.ty, v)) {
/* 620 */           f.pushSmaller(n.tx, n.ty, v, t);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 625 */     f.done();
/* 626 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   private Region regSet(PathTile t) {
/* 631 */     Region reg = (Region)(WORLD.PATH()).regMap.get((COORDINATE)t);
/* 632 */     if (reg != null) {
/* 633 */       this.prevRegion[((Comps.WComp)this.cc.get((COORDINATE)t)).id] = (short)(reg.index() + 1);
/* 634 */       return reg;
/* 635 */     }  if (t.getParent() != null) {
/* 636 */       short i = this.prevRegion[((Comps.WComp)this.cc.get((COORDINATE)t.getParent())).id];
/* 637 */       if (i == 0)
/* 638 */         return null; 
/* 639 */       return WORLD.REGIONS().getByIndex(i);
/*     */     } 
/* 641 */     return null;
/*     */   }
/*     */   
/*     */   private void regSetStart(PathTile t) {
/* 645 */     Region reg = (Region)(WORLD.PATH()).regMap.get((COORDINATE)t);
/* 646 */     this.prevRegion[((Comps.WComp)this.cc.get((COORDINATE)t)).id] = (reg != null) ? (short)(reg.index() + 1) : 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\Comps$Finder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */