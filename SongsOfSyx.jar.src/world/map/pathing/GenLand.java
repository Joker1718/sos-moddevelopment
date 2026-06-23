/*     */ package world.map.pathing;
/*     */ 
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.map.road.WTRAV;
/*     */ 
/*     */ final class GenLand {
/*  17 */   private final Bitmap2D tmp = new Bitmap2D((DIMENSION)WORLD.TBOUNDS(), false);
/*     */   private final ACTION u;
/*     */   
/*     */   GenLand(ACTION util) {
/*  21 */     this.u = util;
/*     */     
/*  23 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*  24 */     f.init(this);
/*     */     
/*  26 */     LinkedList<COORDINATE> nodes = new LinkedList();
/*     */     
/*  28 */     for (Region r : WORLD.REGIONS().all()) {
/*     */       
/*  30 */       if (r.info.area() > 0) {
/*  31 */         f.pushSloppy(r.cx(), r.cy(), 0.0D, null);
/*  32 */         f.setValue2(r.cx(), r.cy(), r.index());
/*     */       } 
/*     */     } 
/*     */     
/*  36 */     this.tmp.clear();
/*  37 */     while (f.hasMore()) {
/*     */       
/*  39 */       PathTile t = f.pollSmallest();
/*  40 */       if (t.getParent() != null) {
/*  41 */         t.setValue2(t.getParent().getValue2());
/*     */       }
/*  43 */       Region rr = (Region)(WORLD.REGIONS()).map.get((COORDINATE)t);
/*     */       
/*  45 */       for (DIR d : DIR.ALL) {
/*  46 */         if (WTRAV.can(t.x(), t.y(), d, true)) {
/*  47 */           Region other = (Region)(WORLD.REGIONS()).map.get((COORDINATE)t, d);
/*  48 */           if (other != rr) {
/*     */             continue;
/*     */           }
/*  51 */           f.pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance(), t);
/*     */         } 
/*     */       } 
/*     */     } 
/*  55 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*  56 */       if (f.hasBeenPushed(c.x(), c.y())) {
/*     */         
/*  58 */         int from = (int)f.getValue2(c.x(), c.y());
/*     */         
/*  60 */         if ((WORLD.ROADS()).harbour.is(c)) {
/*  61 */           Gen.connect(f.get(c.x(), c.y())); continue;
/*  62 */         }  if ((WORLD.WATER()).isBig.is(c)) {
/*     */           continue;
/*     */         }
/*  65 */         for (DIR d : DIR.ALL) {
/*  66 */           if (f.hasBeenPushed(c.x(), c.y(), d) && WTRAV.canLand(c.x(), c.y(), d, true)) {
/*  67 */             int regTo = (int)f.getValue2(c.x(), c.y(), d);
/*  68 */             if (from != regTo) {
/*  69 */               markAdd(f.get(c.x(), c.y()), nodes);
/*  70 */               markAdd(f.get(c.x() + d.x(), c.y() + d.y()), nodes);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  78 */     this.u.exe();
/*  79 */     f.done();
/*  80 */     int i = 0;
/*  81 */     while (!nodes.isEmpty()) {
/*  82 */       if (i++ % 10 == 0)
/*  83 */         this.u.exe(); 
/*  84 */       f.init(this);
/*  85 */       Region start = (Region)(WORLD.REGIONS()).map.get((COORDINATE)nodes.removeFirst());
/*  86 */       Region end = (Region)(WORLD.REGIONS()).map.get((COORDINATE)nodes.removeFirst());
/*  87 */       f.pushSloppy(start.cx(), start.cy(), 0.0D);
/*     */       
/*  89 */       while (f.hasMore()) {
/*     */         
/*  91 */         PathTile t = f.pollSmallest();
/*  92 */         if (t.isSameAs(end.cx(), end.cy())) {
/*     */           
/*  94 */           Gen.connect(t);
/*     */           
/*     */           break;
/*     */         } 
/*  98 */         for (DIR d : DIR.ALL) {
/*  99 */           if (this.tmp.is(t.x(), t.y(), d) && WTRAV.can(t.x(), t.y(), d, true)) {
/* 100 */             Region other = (Region)(WORLD.REGIONS()).map.get((COORDINATE)t, d);
/* 101 */             if (other != start && other != end) {
/*     */               continue;
/*     */             }
/* 104 */             double v = (WORLD.PATH()).map.can(t.x(), t.y(), d) ? 0.5D : 1.0D;
/* 105 */             f.pushSmaller((COORDINATE)t, d, t.getValue() + v * d.tileDistance(), t);
/*     */           } 
/*     */         } 
/*     */       } 
/* 109 */       f.done();
/*     */     } 
/*     */     
/* 112 */     util.exe();
/*     */   }
/*     */ 
/*     */   
/*     */   private void markAdd(PathTile t, LinkedList<COORDINATE> li) {
/* 117 */     while (t != null) {
/* 118 */       this.tmp.set((COORDINATE)t, true);
/* 119 */       if (t.getParent() == null)
/* 120 */         li.add(t); 
/* 121 */       t = t.getParent();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\GenLand.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */