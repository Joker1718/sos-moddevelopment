/*     */ package settlement.path.components;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ final class SComp0Updater
/*     */ {
/*     */   private final SComp0Map map;
/*     */   private final SComp0Factory factory;
/*  17 */   private final Rec bounds = new Rec();
/*     */   private final SComponentChecker checker;
/*  19 */   private boolean[][] assigned = new boolean[8][8];
/*     */   
/*     */   SComp0Updater(SComp0Map map, SComp0Factory f, SComp0Level c) {
/*  22 */     this.map = map;
/*  23 */     this.factory = f;
/*  24 */     this.checker = new SComponentChecker(c);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void remove(RECTANGLE r, SComp0Quads sComp0Quads) {
/*  30 */     for (int y = r.y1(); y < r.y2(); y++) {
/*  31 */       for (int x = r.x1(); x < r.x2(); x++) {
/*  32 */         SComp0 c = this.map.get(x, y);
/*  33 */         if (c != null && !c.retired()) {
/*  34 */           this.factory.retire(c);
/*     */         }
/*  36 */         this.map.set(x, y, (SComp0)null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void removeSuperComp(RECTANGLE r, SComp0Quads sComp0Quads) {
/*  44 */     for (int y = r.y1(); y < r.y2(); y++) {
/*  45 */       for (int x = r.x1(); x < r.x2(); x++) {
/*  46 */         SComp0 c = this.map.get(x, y);
/*  47 */         if (c != null && c.superComp() != null)
/*  48 */           ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).remove(c.superComp()); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   void assign(RECTANGLE r, SComp0Quads sComp0Quads) {
/*     */     int y;
/*  55 */     for (y = r.y1(); y < r.y2(); y++) {
/*  56 */       for (int x = r.x1(); x < r.x2(); x++) {
/*  57 */         this.assigned[y - r.y1()][x - r.x1()] = false;
/*     */       }
/*     */     } 
/*     */     
/*  61 */     for (y = r.y1(); y < r.y2(); y++) {
/*  62 */       for (int x = r.x1(); x < r.x2(); x++) {
/*  63 */         if (!this.assigned[y - r.y1()][x - r.x1()]) {
/*  64 */           assign(r, x, y);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void assign(RECTANGLE r, int tx, int ty) {
/*  72 */     if (this.map.get(tx, ty) != null) {
/*     */       return;
/*     */     }
/*  75 */     AVAILABILITY a = (SETT.PATH()).availability.get(tx, ty);
/*  76 */     if (a.player < 0.0D) {
/*     */       return;
/*     */     }
/*  79 */     GUTIL.flooder().init(this);
/*  80 */     GUTIL.flooder().pushSloppy(tx, ty, 0.0D);
/*  81 */     SComp0 c = this.factory.create();
/*  82 */     this.bounds.clear();
/*  83 */     int size = 0;
/*     */     
/*  85 */     boolean other = false;
/*     */     
/*  87 */     while (GUTIL.flooder().hasMore()) {
/*  88 */       PathTile t = GUTIL.flooder().pollSmallest();
/*  89 */       this.map.set((COORDINATE)t, c);
/*  90 */       this.assigned[t.y() - r.y1()][t.x() - r.x1()] = true;
/*  91 */       size++;
/*  92 */       this.bounds.unify(t.x(), t.y());
/*  93 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/*  94 */         int dx = t.x() + ((DIR)DIR.ALL.get(di)).x();
/*  95 */         int dy = t.y() + ((DIR)DIR.ALL.get(di)).y();
/*  96 */         if ((SETT.PATH()).coster.player.getCost(t.x(), t.y(), dx, dy) > 0.0D) {
/*  97 */           if (r.holdsPoint(dx, dy)) {
/*  98 */             if (this.map.get(dx, dy) == null) {
/*  99 */               double v = t.getValue() + ((DIR)DIR.ALL.get(di)).tileDistance();
/* 100 */               GUTIL.flooder().pushSmaller(dx, dy, v);
/*     */             } 
/* 102 */           } else if (!other) {
/* 103 */             other = true;
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     GUTIL.flooder().done();
/*     */     
/* 114 */     if (!other) {
/* 115 */       for (int y = this.bounds.y1(); y < this.bounds.y2(); y++) {
/* 116 */         for (int x = this.bounds.x1(); x < this.bounds.x2(); x++) {
/* 117 */           if (this.map.get(x, y) == c) {
/* 118 */             this.map.set(x, y, (SComp0)null);
/*     */           }
/*     */         } 
/*     */       } 
/* 122 */       this.factory.retire(c);
/*     */       
/*     */       return;
/*     */     } 
/* 126 */     c.init((RECTANGLE)this.bounds, size, this.checker);
/*     */ 
/*     */ 
/*     */     
/* 130 */     if (c.edgefirst() != null && c.edgefirst().next() == null) r.width() * r.height() / 2;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 135 */     (SETT.PATH()).comps.data.initComponent0(c, (RECTANGLE)this.bounds);
/* 136 */     ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).addNew(c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initData(RECTANGLE r) {
/* 145 */     this.checker.init();
/*     */     
/* 147 */     for (int y = r.y1(); y < r.y2(); y++) {
/* 148 */       for (int x = r.x1(); x < r.x2(); x++) {
/* 149 */         SComp0 c = this.map.get(x, y);
/* 150 */         if (c != null && !this.checker.isSetAndSet(c)) {
/* 151 */           ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).remove(c.superComp());
/* 152 */           ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).addNew(c);
/* 153 */           (SETT.PATH()).comps.data.initComponent0(c, r);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SComp0Updater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */