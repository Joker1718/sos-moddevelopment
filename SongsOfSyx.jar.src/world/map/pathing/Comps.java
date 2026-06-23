/*     */ package world.map.pathing;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.misc.IntChecker;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.Bitsmap2D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.overlay.WorldOverlays;
/*     */ 
/*     */ public final class Comps
/*     */   implements MAP_OBJECT<Comps.WComp>
/*     */ {
/*     */   private final Bitsmap2D is;
/*     */   public final WComp[] all;
/*     */   public final Finder finder;
/*     */   
/*     */   private Comps(Bitmap2D is, WComp[] comps, WDirMap m) {
/*  40 */     this.all = new WComp[comps.length + 1];
/*  41 */     int bits = 32 - Integer.numberOfLeadingZeros(this.all.length);
/*  42 */     this.is = new Bitsmap2D(0, bits, (DIMENSION)WORLD.TBOUNDS());
/*  43 */     for (COORDINATE c : WORLD.TBOUNDS())
/*  44 */       this.is.set(c, this.all.length - 1);  byte b;
/*     */     int i;
/*     */     WComp[] arrayOfWComp;
/*  47 */     for (i = (arrayOfWComp = comps).length, b = 0; b < i; ) { WComp c = arrayOfWComp[b];
/*  48 */       this.is.set(c.tx, c.ty, c.id);
/*  49 */       this.all[c.id] = c; b++; }
/*     */     
/*  51 */     this.finder = new Finder(this, m);
/*     */   }
/*     */ 
/*     */   
/*     */   Comps(WDirMap m) {
/*  56 */     this(new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false), new WComp[0], m);
/*     */   }
/*     */ 
/*     */   
/*     */   public WComp get(int tile) {
/*  61 */     int o = this.is.get(tile);
/*  62 */     return this.all[o];
/*     */   }
/*     */ 
/*     */   
/*     */   public WComp get(int tx, int ty) {
/*  67 */     return get(tx + ty * WORLD.TWIDTH());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static Comps generate(ACTION aa, WDirMap m) {
/*  73 */     Gen gen = new Gen(aa, m);
/*  74 */     return new Comps(gen.mark, gen.comps, m);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Gen
/*     */   {
/*     */     private final Comps.WComp[] comps;
/*     */     private final WDirMap m;
/*  82 */     private Bitmap2D mark = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false);
/*     */     private boolean log = false;
/*  84 */     private static double dist = 8.0D;
/*     */     
/*     */     Gen(ACTION aa, WDirMap m) {
/*  87 */       this.m = m;
/*  88 */       (WORLD.OVERLAY()).debug = (WorldOverlays.Overlay)new WorldOverlays.OverlayTile(true, false)
/*     */         {
/*     */           
/*     */           protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it)
/*     */           {
/*  93 */             if ((WORLD.PATH()).map.is.is(it.tile())) {
/*  94 */               COLOR.WHITE100.bind();
/*  95 */               for (int di = 0; di < DIR.ALL.size(); di++) {
/*  96 */                 DIR d = (DIR)DIR.ALL.get(di);
/*  97 */                 if ((WORLD.PATH()).map.can(it.tx(), it.ty(), d))
/*  98 */                   ((SPRITE)(SPRITES.cons()).ICO.arrows2.get(d.id())).render(r, it.x(), it.y()); 
/*     */               } 
/* 100 */               COLOR.unbind();
/*     */             } 
/* 102 */             if (Comps.Gen.this.mark.is(it.tx(), it.ty())) {
/* 103 */               COLOR.RED100.bind();
/* 104 */               (SPRITES.cons()).ICO.clear.render(r, it.x(), it.y());
/* 105 */               COLOR.unbind();
/*     */             } 
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 111 */       LinkedList<Comps.WComp> comps = new LinkedList();
/* 112 */       int id = 0;
/*     */ 
/*     */ 
/*     */       
/* 116 */       for (COORDINATE c : WORLD.TBOUNDS()) {
/* 117 */         if (isComp(c)) {
/* 118 */           this.mark.set(c, true);
/* 119 */           comps.add(new Comps.WComp(c.x(), c.y(), id));
/* 120 */           id++;
/*     */         } 
/*     */       } 
/*     */       
/* 124 */       createAdditional(comps, aa);
/*     */ 
/*     */       
/* 127 */       this.comps = new Comps.WComp[comps.size()];
/* 128 */       id = 0;
/* 129 */       for (Comps.WComp c : comps) {
/* 130 */         this.comps[id++] = c;
/*     */       }
/*     */       
/* 133 */       if (this.log) {
/* 134 */         LOG.ln("Components " + comps.size());
/*     */       }
/* 136 */       int ii = 0;
/* 137 */       final Bitmap1D check = new Bitmap1D(this.comps.length, false);
/*     */       
/* 139 */       final Bitmap2D tmp = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false);
/* 140 */       (WORLD.OVERLAY()).debug = (WorldOverlays.Overlay)new WorldOverlays.OverlayTile(true, false)
/*     */         {
/*     */           
/*     */           protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it)
/*     */           {
/* 145 */             if ((WORLD.PATH()).map.is.is(it.tile())) {
/*     */               
/* 147 */               if (tmp.is(it.tile())) {
/* 148 */                 COLOR.ORANGE100.bind();
/*     */               } else {
/* 150 */                 COLOR.WHITE100.bind();
/* 151 */               }  for (int di = 0; di < DIR.ALL.size(); di++) {
/* 152 */                 DIR d = (DIR)DIR.ALL.get(di);
/* 153 */                 if ((WORLD.PATH()).map.can(it.tx(), it.ty(), d))
/* 154 */                   ((SPRITE)(SPRITES.cons()).ICO.arrows2.get(d.id())).render(r, it.x(), it.y()); 
/*     */               } 
/* 156 */               COLOR.unbind();
/*     */             } 
/*     */ 
/*     */             
/* 160 */             if (Comps.Gen.this.mark.is(it.tx(), it.ty())) {
/* 161 */               (check.get((int)GUTIL.flooder().getValue2(it.tx(), it.ty())) ? COLOR.GREEN100 : COLOR.RED100).bind();
/* 162 */               (SPRITES.cons()).ICO.clear.render(r, it.x(), it.y());
/* 163 */               COLOR.unbind();
/*     */             } 
/*     */           }
/*     */         };
/*     */       
/* 168 */       for (COORDINATE c : WORLD.TBOUNDS())
/* 169 */         GUTIL.flooder().setValue2(c, -1.0D);  byte b;
/*     */       int i;
/*     */       Comps.WComp[] arrayOfWComp;
/* 172 */       for (i = (arrayOfWComp = this.comps).length, b = 0; b < i; ) { Comps.WComp c = arrayOfWComp[b];
/* 173 */         GUTIL.flooder().setValue2(c.tx, c.ty, c.id);
/*     */         b++; }
/*     */       
/* 176 */       for (i = (arrayOfWComp = this.comps).length, b = 0; b < i; ) { Comps.WComp c = arrayOfWComp[b];
/* 177 */         if (!check.get((int)GUTIL.flooder().getValue2(c.tx, c.ty))) {
/* 178 */           init(c, check, tmp);
/* 179 */           if (ii++ % 5 == 0)
/* 180 */             aa.exe(); 
/*     */         } 
/*     */         b++; }
/*     */       
/* 184 */       for (COORDINATE c : WORLD.TBOUNDS()) {
/* 185 */         if (m.is.is(c) && !tmp.is(c)) {
/* 186 */           m.remove(c.x(), c.y());
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean isComp(COORDINATE c) {
/* 193 */       if ((WORLD.REGIONS()).cTile.is(c))
/* 194 */         return true; 
/* 195 */       if (!this.m.is.is(c)) {
/* 196 */         return false;
/*     */       }
/* 198 */       if ((WORLD.WATER()).isBig.is(c)) {
/* 199 */         boolean water = false;
/* 200 */         boolean land = false;
/*     */         
/* 202 */         for (int di = 0; di < DIR.ALL.size(); di++) {
/* 203 */           DIR d = (DIR)DIR.ALL.get(di);
/* 204 */           if (this.m.can(c, d)) {
/* 205 */             if ((WORLD.WATER()).isBig.is(c, d)) {
/* 206 */               water = true;
/*     */             } else {
/*     */               
/* 209 */               land = true;
/*     */             } 
/*     */           }
/*     */         } 
/* 213 */         if (water && land) {
/* 214 */           return true;
/*     */         }
/*     */       } 
/*     */       
/* 218 */       Region h = (Region)(WORLD.PATH()).regMap.get(c);
/* 219 */       if (h != null) {
/* 220 */         for (int di = 0; di < DIR.ALL.size(); di++) {
/* 221 */           DIR d = (DIR)DIR.ALL.get(di);
/* 222 */           if (this.m.can(c, d) && (WORLD.PATH()).regMap.get(c, d) != h) {
/* 223 */             return true;
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 228 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     private void createAdditional(LinkedList<Comps.WComp> comps, ACTION aa) {
/* 233 */       for (COORDINATE c : WORLD.TBOUNDS()) {
/* 234 */         GUTIL.flooder().setValue2(c, 0.0D);
/*     */       }
/*     */ 
/*     */       
/* 238 */       for (int i = 0; i < 20; i++) {
/* 239 */         aa.exe();
/* 240 */         createAdditionalP(comps);
/*     */       } 
/*     */     }
/*     */     
/*     */     private boolean createAdditionalP(LinkedList<Comps.WComp> comps) {
/* 245 */       PathUtilOnline.Flooder f = GUTIL.flooder();
/* 246 */       f.init(this);
/*     */       
/* 248 */       int id = 0;
/* 249 */       int pp = 0;
/* 250 */       for (Comps.WComp c : comps) {
/* 251 */         if (f.getValue2(c.tx, c.ty) == 0.0F) {
/* 252 */           f.pushSloppy(c.tx, c.ty, 0.0D);
/* 253 */           pp++;
/*     */         } 
/* 255 */         id++;
/*     */       } 
/*     */       
/* 258 */       if (pp == 0) {
/* 259 */         f.done();
/* 260 */         return false;
/*     */       } 
/*     */       
/* 263 */       while (f.hasMore()) {
/* 264 */         PathTile t = f.pollSmallest();
/* 265 */         if (t.getValue2() != 0.0F) {
/*     */           continue;
/*     */         }
/* 268 */         if (t.getValue() > dist) {
/* 269 */           int c = 0;
/* 270 */           for (int di = 0; di < DIR.ALL.size(); di++) {
/* 271 */             DIR d = (DIR)DIR.ALL.get(di);
/* 272 */             if (this.m.can((COORDINATE)t, d)) {
/* 273 */               c++;
/*     */             }
/*     */           } 
/* 276 */           if (c == 2) {
/* 277 */             comps.add(new Comps.WComp(t.x(), t.y(), id++));
/* 278 */             this.mark.set((COORDINATE)t, true);
/* 279 */             t = t.getParent();
/* 280 */             while (t != null) {
/* 281 */               f.setValue2((COORDINATE)t, 1.0D);
/* 282 */               t = t.getParent();
/*     */             } 
/*     */             continue;
/*     */           } 
/*     */         } 
/* 287 */         this.m.pushSimple(t);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 292 */       f.done();
/* 293 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     private void init(Comps.WComp start, Bitmap1D check, Bitmap2D tmp) {
/* 298 */       PathUtilOnline.Flooder f = GUTIL.flooder();
/* 299 */       f.init(this);
/* 300 */       f.pushSloppy(start.tx, start.ty, 0.0D);
/*     */       
/* 302 */       int home = (int)f.getValue2(start.tx, start.ty);
/*     */       
/* 304 */       while (f.hasMore()) {
/*     */         
/* 306 */         PathTile t = f.pollSmallest();
/* 307 */         int id = (int)t.getValue2();
/* 308 */         if (id >= 0 && id != home) {
/* 309 */           if (!check.get(id)) {
/* 310 */             this.comps[home].push(id, t.getValue());
/* 311 */             this.comps[id].push(home, t.getValue());
/* 312 */             while (t != null) {
/* 313 */               tmp.set((COORDINATE)t, true);
/* 314 */               t = t.getParent();
/*     */             } 
/*     */           } 
/*     */           
/*     */           continue;
/*     */         } 
/* 320 */         this.m.push(t, t.getValue());
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 325 */       check.set(home, true);
/* 326 */       f.done();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class Finder
/*     */   {
/*     */     Comps cc;
/*     */     
/*     */     private final WDirMap m;
/*     */     
/*     */     private final ArrayList<PathTile> result;
/*     */     
/*     */     private final IntChecker destCheck;
/*     */     
/*     */     private final IntChecker absPath;
/*     */     
/*     */     private final short[] prevRegion;
/*     */     
/*     */     Finder(Comps cc, WDirMap m) {
/* 346 */       this.cc = cc;
/* 347 */       this.m = m;
/* 348 */       this.prevRegion = new short[cc.all.length];
/* 349 */       this.result = new ArrayList(cc.all.length);
/* 350 */       this.destCheck = new IntChecker(cc.all.length);
/* 351 */       this.absPath = new IntChecker(cc.all.length);
/*     */     }
/*     */ 
/*     */     
/*     */     public PathTile find(COORDINATE start, int endX, int endY, WRegFinder.Treaty trav) {
/* 356 */       return find(start.x(), start.y(), endX, endY, trav);
/*     */     }
/*     */     
/*     */     public PathTile find(int startX, int startY, COORDINATE end, WRegFinder.Treaty trav) {
/* 360 */       return find(startX, startY, end.x(), end.y(), trav);
/*     */     }
/*     */     
/*     */     public PathTile find(COORDINATE start, COORDINATE end, WRegFinder.Treaty trav) {
/* 364 */       return find(start.x(), start.y(), end.x(), end.y(), trav);
/*     */     }
/*     */ 
/*     */     
/*     */     public PathTile find(int startX, int startY, int endX, int endY, WRegFinder.Treaty trav) {
/* 369 */       PathUtilOnline.Flooder f = GUTIL.flooder();
/* 370 */       f.init(this);
/*     */ 
/*     */ 
/*     */       
/* 374 */       PathTile start = f.pushSloppy(endX, endY, 0.0D);
/*     */       
/* 376 */       if (startX == endX && startY == endY) {
/* 377 */         f.done();
/* 378 */         return start;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 385 */       this.destCheck.init();
/* 386 */       this.result.clearSloppy();
/* 387 */       boolean succ = false;
/* 388 */       while (f.hasMore()) {
/* 389 */         PathTile t = f.pollSmallest();
/*     */         
/* 391 */         if (t.isSameAs(startX, startY)) {
/* 392 */           f.done();
/* 393 */           return f.reverse(t);
/*     */         } 
/*     */         
/* 396 */         Comps.WComp c = (Comps.WComp)this.cc.get((COORDINATE)t);
/* 397 */         if (c != null) {
/* 398 */           this.destCheck.isSetAndSet(c.id);
/* 399 */           this.result.add(t);
/* 400 */           t.setValue2(t.getValue());
/* 401 */           c.wayBackDest = t.getParent();
/* 402 */           succ = true;
/*     */           
/*     */           continue;
/*     */         } 
/* 406 */         this.m.push(t, t.getValue());
/*     */       } 
/* 408 */       if (!succ) {
/* 409 */         f.done();
/* 410 */         return null;
/*     */       } 
/* 412 */       for (PathTile c : this.result) {
/* 413 */         f.reopen(c);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 423 */       this.result.clearSloppy();
/* 424 */       f.pushSloppy(startX, startY, 0.0D);
/* 425 */       while (f.hasMore()) {
/* 426 */         PathTile t = f.pollSmallest();
/* 427 */         Comps.WComp c = (Comps.WComp)this.cc.get((COORDINATE)t);
/* 428 */         if (c != null) {
/*     */           
/* 430 */           if (t.isSameAs(endX, endY)) {
/* 431 */             f.done();
/* 432 */             return t;
/*     */           } 
/* 434 */           this.result.add(t);
/* 435 */           c.wayBack = t.getParent();
/* 436 */           f.setValue2((COORDINATE)t, t.getValue());
/*     */           
/*     */           continue;
/*     */         } 
/* 440 */         this.m.push(t, t.getValue());
/*     */       } 
/*     */       
/* 443 */       if (this.result.size() == 0) {
/* 444 */         f.done();
/* 445 */         return null;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 451 */       f.done();
/*     */       
/* 453 */       Region origin = (Region)(WORLD.PATH()).regMap.get(startX, startY);
/*     */ 
/*     */       
/* 456 */       boolean bool1 = false;
/*     */       
/* 458 */       f.init(f);
/*     */       
/* 460 */       this.absPath.init();
/*     */       
/* 462 */       for (PathTile c : this.result) {
/* 463 */         f.pushSloppy(c.x(), c.y(), c.getValue2());
/* 464 */         regSetStart(c);
/*     */       } 
/*     */       
/* 467 */       while (f.hasMore()) {
/* 468 */         PathTile t = f.pollSmallest();
/* 469 */         Comps.WComp c = (Comps.WComp)this.cc.get((COORDINATE)t);
/*     */         
/* 471 */         Region from = regSet(t);
/*     */         
/* 473 */         if (this.destCheck.isSet(c.id)) {
/* 474 */           while (t != null) {
/* 475 */             this.absPath.isSetAndSet(((Comps.WComp)this.cc.get((COORDINATE)t)).id);
/* 476 */             t = t.getParent();
/*     */           } 
/*     */           
/* 479 */           bool1 = true;
/*     */           
/*     */           break;
/*     */         } 
/* 483 */         for (int i = 0; i < c.neighs.length; i++) {
/* 484 */           Comps.WComp n = this.cc.all[c.neighs[i]];
/* 485 */           double v = (c.dists[i] + t.getValue());
/* 486 */           if (this.destCheck.isSet(n.id)) {
/* 487 */             v += f.getValue2(n.tx, n.ty);
/*     */           }
/* 489 */           Region to = (Region)(WORLD.PATH()).regMap.get(n.tx, n.ty);
/* 490 */           if (trav.can(origin, from, to, n.tx, n.ty, v)) {
/* 491 */             f.pushSmaller(n.tx, n.ty, v, t);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 496 */       f.done();
/* 497 */       if (!bool1) {
/* 498 */         return null;
/*     */       }
/*     */       
/* 501 */       f.init(this);
/*     */       
/* 503 */       for (PathTile t : this.result) {
/* 504 */         Comps.WComp c = (Comps.WComp)this.cc.get((COORDINATE)t);
/* 505 */         if (this.absPath.isSet(c.id)) {
/* 506 */           f.pushSloppy(t.x(), t.y(), t.getValue(), c.wayBack);
/*     */           
/* 508 */           PathTile w = c.wayBack;
/* 509 */           while (w != null) {
/* 510 */             f.close(w.x(), w.y(), w.getValue());
/* 511 */             w = w.getParent();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 517 */       while (f.hasMore()) {
/*     */         
/* 519 */         PathTile t = f.pollSmallest();
/* 520 */         Comps.WComp c = (Comps.WComp)this.cc.get((COORDINATE)t);
/*     */         
/* 522 */         if (c != null && this.destCheck.isSet(c.id)) {
/* 523 */           double v = t.getValue();
/*     */           
/* 525 */           while (c.wayBackDest != null) {
/* 526 */             PathTile p = c.wayBackDest;
/* 527 */             c.wayBackDest = c.wayBackDest.getParent();
/* 528 */             p.parentSet(t);
/*     */             
/* 530 */             t = p;
/* 531 */             if (p.isSameAs(startX, startY)) {
/* 532 */               p.parentSet(null);
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/* 537 */           f.setValue(t.x(), t.y(), v);
/* 538 */           f.done();
/* 539 */           return t;
/*     */         } 
/*     */         
/* 542 */         if (c != null && !this.absPath.isSet(c.id)) {
/*     */           continue;
/*     */         }
/* 545 */         int md = this.m.get(t);
/* 546 */         for (int di = 0; di < DIR.ALL.size(); di++) {
/* 547 */           DIR d = (DIR)DIR.ALL.get(di);
/* 548 */           if ((md & d.bit) != 0) {
/* 549 */             Comps.WComp to = (Comps.WComp)this.cc.get((COORDINATE)t, d);
/* 550 */             double v = t.getValue() + d.tileDistance() * WDirMap.cost(t.x(), t.y(), d);
/* 551 */             if (to != null && this.destCheck.isSet(to.id) && to.wayBackDest != null) {
/* 552 */               v += to.wayBackDest.getValue();
/*     */             }
/* 554 */             f.pushSmaller((COORDINATE)t, d, v, t);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 559 */       f.done();
/* 560 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public LIST<PathTile> getComps(int sx, int sy) {
/* 568 */       this.result.clearSloppy();
/* 569 */       PathUtilOnline.Flooder f = GUTIL.flooder();
/* 570 */       f.init(this);
/* 571 */       f.pushSloppy(sx, sy, 0.0D);
/*     */       
/* 573 */       while (f.hasMore()) {
/* 574 */         PathTile t = f.pollSmallest();
/* 575 */         Comps.WComp c = (Comps.WComp)this.cc.get((COORDINATE)t);
/* 576 */         if (c != null) {
/* 577 */           this.result.add(t);
/*     */           
/*     */           continue;
/*     */         } 
/* 581 */         this.m.push(t, t.getValue());
/*     */       } 
/*     */       
/* 584 */       f.done();
/* 585 */       return (LIST<PathTile>)this.result;
/*     */     }
/*     */     
/*     */     public double dist(int startX, int startY, int endX, int endY, WRegFinder.Treaty treaty) {
/* 589 */       this.destCheck.init();
/* 590 */       for (PathTile t : getComps(endX, endY)) {
/* 591 */         t.setValue2(t.getValue());
/* 592 */         this.destCheck.isSetAndSet(((Comps.WComp)this.cc.get((COORDINATE)t)).id);
/*     */       } 
/*     */       
/* 595 */       Region origin = (Region)(WORLD.PATH()).regMap.get(startX, startY);
/*     */       
/* 597 */       LIST<PathTile> ss = getComps(startX, startY);
/* 598 */       PathUtilOnline.Flooder f = GUTIL.flooder();
/* 599 */       f.init(this);
/* 600 */       for (PathTile t : ss) {
/* 601 */         f.pushSloppy(t.x(), t.y(), t.getValue());
/* 602 */         regSetStart(t);
/*     */       } 
/*     */       
/* 605 */       while (f.hasMore()) {
/* 606 */         PathTile t = f.pollSmallest();
/* 607 */         Region prev = regSet(t);
/* 608 */         Comps.WComp c = (Comps.WComp)this.cc.get((COORDINATE)t);
/* 609 */         if (this.destCheck.isSet(c.id)) {
/* 610 */           f.done();
/* 611 */           return t.getValue();
/*     */         } 
/* 613 */         for (int i = 0; i < c.neighs.length; i++) {
/* 614 */           Comps.WComp n = this.cc.all[c.neighs[i]];
/* 615 */           double v = (c.dists[i] + t.getValue());
/* 616 */           if (this.destCheck.isSet(n.id)) {
/* 617 */             v += f.getValue2(n.tx, n.ty);
/*     */           }
/* 619 */           if (treaty.can(origin, prev, (Region)(WORLD.PATH()).regMap.get(n.tx, n.ty), n.tx, n.ty, v)) {
/* 620 */             f.pushSmaller(n.tx, n.ty, v, t);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 625 */       f.done();
/* 626 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     private Region regSet(PathTile t) {
/* 631 */       Region reg = (Region)(WORLD.PATH()).regMap.get((COORDINATE)t);
/* 632 */       if (reg != null) {
/* 633 */         this.prevRegion[((Comps.WComp)this.cc.get((COORDINATE)t)).id] = (short)(reg.index() + 1);
/* 634 */         return reg;
/* 635 */       }  if (t.getParent() != null) {
/* 636 */         short i = this.prevRegion[((Comps.WComp)this.cc.get((COORDINATE)t.getParent())).id];
/* 637 */         if (i == 0)
/* 638 */           return null; 
/* 639 */         return WORLD.REGIONS().getByIndex(i);
/*     */       } 
/* 641 */       return null;
/*     */     }
/*     */     
/*     */     private void regSetStart(PathTile t) {
/* 645 */       Region reg = (Region)(WORLD.PATH()).regMap.get((COORDINATE)t);
/* 646 */       this.prevRegion[((Comps.WComp)this.cc.get((COORDINATE)t)).id] = (reg != null) ? (short)(reg.index() + 1) : 0;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class WComp
/*     */     implements COORDINATE
/*     */   {
/*     */     public final short tx;
/*     */     public final short ty;
/* 655 */     private short[] neighs = new short[0];
/* 656 */     private short[] dists = new short[0];
/*     */     
/*     */     public final int id;
/*     */     private PathTile wayBack;
/*     */     private PathTile wayBackDest;
/*     */     
/*     */     WComp(int tx, int ty, int id) {
/* 663 */       this.tx = (short)tx;
/* 664 */       this.ty = (short)ty;
/* 665 */       this.id = id;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void push(int to, double dist) {
/* 671 */       short[] n = new short[this.neighs.length + 1];
/* 672 */       short[] d = new short[this.neighs.length + 1];
/*     */       
/* 674 */       for (int i = 0; i < this.neighs.length; i++) {
/* 675 */         n[i + 1] = this.neighs[i];
/* 676 */         d[i + 1] = this.dists[i];
/*     */       } 
/* 678 */       n[0] = (short)to;
/* 679 */       d[0] = (short)CLAMP.i((int)dist, 0, 32767);
/* 680 */       this.neighs = n;
/* 681 */       this.dists = d;
/*     */     }
/*     */     
/*     */     public int neighs() {
/* 685 */       return this.neighs.length;
/*     */     }
/*     */     
/*     */     public WComp neigh(int i) {
/* 689 */       return (WORLD.PATH()).comps.all[this.neighs[i]];
/*     */     }
/*     */     
/*     */     public double dist(int i) {
/* 693 */       return this.dists[i];
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int x() {
/* 699 */       return this.tx;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int y() {
/* 705 */       return this.ty;
/*     */     }
/*     */   }
/*     */   
/*     */   static final class DebugOverlay
/*     */     extends WorldOverlays.OverlayTile
/*     */   {
/*     */     private Comps.WComp hovered;
/* 713 */     private IntChecker check = new IntChecker(1); Str str;
/*     */     
/*     */     DebugOverlay() {
/* 716 */       super(true, false);
/*     */ 
/*     */ 
/*     */       
/* 720 */       this.str = new Str(16);
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderAbove(Renderer r, ShadowBatch s, RenderData data) {
/* 725 */       this.hovered = (Comps.WComp)(WORLD.PATH()).comps.get(mouse(data));
/*     */       
/* 727 */       if (this.check.size() < (WORLD.PATH()).comps.all.length)
/* 728 */         this.check = new IntChecker((WORLD.PATH()).comps.all.length); 
/* 729 */       if (this.hovered != null) {
/*     */         
/* 731 */         this.check.init();
/* 732 */         for (int i = 0; i < this.hovered.neighs.length; i++) {
/* 733 */           this.check.isSetAndSet(this.hovered.neighs[i]);
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 740 */       super.renderAbove(r, s, data);
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 745 */       if ((WORLD.PATH()).map.is.is(it.tile())) {
/* 746 */         COLOR.ORANGE100.bind();
/* 747 */         for (int di = 0; di < DIR.ALL.size(); di++) {
/* 748 */           DIR d = (DIR)DIR.ALL.get(di);
/* 749 */           if ((WORLD.PATH()).map.can(it.tx(), it.ty(), d))
/* 750 */             ((SPRITE)(SPRITES.cons()).ICO.arrows2.get(d.id())).render(r, it.x(), it.y()); 
/*     */         } 
/* 752 */         COLOR.unbind();
/*     */       } 
/*     */       
/* 755 */       if ((WORLD.PATH()).comps.get(it.tx(), it.ty()) != null) {
/* 756 */         (this.check.isSet(((WORLD.PATH()).comps.get(it.tx(), it.ty())).id) ? COLOR.GREEN100 : COLOR.RED100).bind();
/* 757 */         (SPRITES.cons()).ICO.clear.render(r, it.x(), it.y());
/* 758 */         COLOR.unbind();
/*     */       } 
/*     */       
/* 761 */       this.hovered = null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\Comps.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */