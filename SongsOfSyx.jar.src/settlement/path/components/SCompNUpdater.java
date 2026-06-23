/*     */ package settlement.path.components;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ final class SCompNUpdater
/*     */ {
/*     */   private final SCompNFactory factory;
/*     */   private final Rec bounds;
/*  16 */   private final Rec boundsC = new Rec();
/*     */   private final SComponentChecker checkerUnderlings;
/*     */   private final SComponentChecker checkerSelf;
/*     */   private final SComponentLevel lower;
/*     */   private final ArrayListResize<SComponent> upUnderlings;
/*     */   private final int size;
/*     */   private final SCompNLevel map;
/*     */   
/*     */   SCompNUpdater(SCompNLevel map, SCompNFactory f, SComponentLevel prev, int size) {
/*  25 */     this.lower = prev;
/*  26 */     this.factory = f;
/*  27 */     this.checkerUnderlings = new SComponentChecker(prev);
/*  28 */     this.checkerSelf = new SComponentChecker(map);
/*  29 */     this.upUnderlings = new ArrayListResize(SComp0Level.startSize >> map.level(), 2147483647);
/*  30 */     this.bounds = new Rec(size, size);
/*  31 */     this.size = size;
/*  32 */     this.map = map;
/*     */   }
/*     */ 
/*     */   
/*     */   void update() {
/*  37 */     this.checkerUnderlings.init();
/*  38 */     for (int i = 0; i < this.upUnderlings.size(); i++) {
/*  39 */       SComponent c = (SComponent)this.upUnderlings.get(i);
/*  40 */       if (!this.checkerUnderlings.isSetAndSet(c)) {
/*  41 */         update(c);
/*     */       }
/*     */     } 
/*     */     
/*  45 */     this.upUnderlings.clearSoft();
/*     */   }
/*     */   
/*     */   void remove(SComponent toBeRemoved) {
/*  49 */     if (toBeRemoved == null)
/*     */       return; 
/*  51 */     SCompN o = (SCompN)toBeRemoved;
/*  52 */     if (o.superComp() != null) {
/*  53 */       ((SCompNLevel)(SETT.PATH()).comps.levels.get(this.map.level())).remove(o.superComp());
/*     */     }
/*  55 */     GUTIL.filler().init(this);
/*  56 */     GUTIL.filler().fill(toBeRemoved.centreX(), toBeRemoved.centreY());
/*  57 */     while (GUTIL.filler().hasMore()) {
/*  58 */       COORDINATE c = GUTIL.filler().poll();
/*  59 */       SComponent ss = (SComponent)((SComponentLevel)(SETT.PATH()).comps.all.get(this.map.level() - 1)).get(c.x(), c.y());
/*  60 */       ss.superCompSet(null);
/*  61 */       SComponentEdge e = ss.edgefirst();
/*  62 */       while (e != null) {
/*  63 */         if (e.to().superComp() == toBeRemoved) {
/*  64 */           GUTIL.filler().fill(e.to().centreX(), e.to().centreY());
/*     */         }
/*  66 */         e = e.next();
/*     */       } 
/*     */     } 
/*  69 */     GUTIL.filler().done();
/*     */     
/*  71 */     this.factory.retire(o);
/*     */   }
/*     */ 
/*     */   
/*     */   void add(SComponent c) {
/*  76 */     this.upUnderlings.add(c);
/*     */   }
/*     */ 
/*     */   
/*     */   private void update(SComponent underling) {
/*  81 */     int qx1 = this.size * underling.centreX() / this.size;
/*  82 */     int qy1 = this.size * underling.centreY() / this.size;
/*  83 */     this.bounds.moveX1Y1(qx1, qy1);
/*  84 */     this.boundsC.clear();
/*     */ 
/*     */     
/*  87 */     if (underling.superComp() != null) {
/*  88 */       throw new RuntimeException("" + this.size + " " + this.size + " " + String.valueOf(underling.superComp()));
/*     */     }
/*     */     
/*  91 */     if (this.lower.get(underling.centreX(), underling.centreY()) != underling) {
/*  92 */       throw new RuntimeException("" + this.size + " " + this.size + " " + underling.centreX());
/*     */     }
/*     */     
/*  95 */     SCompN comp = this.factory.create();
/*     */     
/*  97 */     PathUtilOnline.Filler f = GUTIL.filler();
/*  98 */     f.init(this);
/*  99 */     f.fill(underling.centreX(), underling.centreY());
/*     */ 
/*     */     
/* 102 */     while (f.hasMore()) {
/* 103 */       COORDINATE coo = f.poll();
/* 104 */       SComponent c = (SComponent)this.lower.get(coo);
/* 105 */       if (c == null)
/* 106 */         throw new RuntimeException(); 
/* 107 */       this.checkerUnderlings.isSetAndSet(c);
/* 108 */       c.superCompSet(comp);
/* 109 */       this.boundsC.unify(coo.x(), coo.y());
/* 110 */       SComponentEdge e = c.edgefirst();
/*     */       
/* 112 */       while (e != null) {
/* 113 */         if (this.bounds.holdsPoint(e.to().centreX(), e.to().centreY()) && !this.checkerUnderlings.is(e.to())) {
/* 114 */           f.fill(e.to().centreX(), e.to().centreY());
/*     */         }
/* 116 */         e = e.next();
/*     */       } 
/*     */     } 
/* 119 */     f.done();
/*     */     
/* 121 */     comp.init(underling, (RECTANGLE)this.boundsC, this.lower, this.checkerSelf);
/*     */     
/* 123 */     (SETT.PATH()).comps.data.initComponentN(comp);
/*     */     
/* 125 */     if (this.map.level() < (SETT.PATH()).comps.levels.size())
/* 126 */       ((SCompNLevel)(SETT.PATH()).comps.levels.get(this.map.level())).addNew(comp); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SCompNUpdater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */