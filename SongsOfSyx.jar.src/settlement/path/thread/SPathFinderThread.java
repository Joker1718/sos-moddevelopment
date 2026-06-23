/*     */ package settlement.path.thread;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.constant.C;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SCOMPONENTS;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.components.SComponentChecker;
/*     */ import settlement.path.components.SComponentEdge;
/*     */ import settlement.path.components.SComponentLevel;
/*     */ import settlement.path.components.finder.SCompFinder;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class SPathFinderThread
/*     */ {
/*     */   double lastDistance;
/*     */   private final int chunkD;
/*     */   private final PathUtilOnline p;
/*     */   private final SCompFinder cf;
/*     */   private final SComponentChecker CHECK;
/*     */   
/*     */   SPathFinderThread(SCOMPONENTS comps, PathUtilOnline p, int chunks) {
/*  30 */     this.p = p;
/*  31 */     this.cf = new SCompFinder(comps, p);
/*  32 */     this.CHECK = new SComponentChecker((SComponentLevel)comps.zero);
/*  33 */     this.chunkD = chunks;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PathTile find(int startX, int startY, int destX, int destY, boolean full) {
/*  39 */     this.lastDistance = 0.0D;
/*  40 */     SCompFinder.SCompPath comp = this.cf.findDest(startX, startY, destX, destY);
/*  41 */     if (comp == null) {
/*  42 */       return null;
/*     */     }
/*  44 */     this.lastDistance = comp.distance();
/*     */     
/*  46 */     if (comp.path().size() > this.chunkD) {
/*  47 */       return findComp(comp, startX, startY, (SComponent)comp.path().get(comp.path().size() - this.chunkD));
/*     */     }
/*  49 */     return find(comp, startX, startY, destX, destY, full);
/*     */   }
/*     */ 
/*     */   
/*     */   private PathTile find(SCompFinder.SCompPath comp, int startX, int startY, int destX, int destY, boolean full) {
/*  54 */     PathUtilOnline.Flooder f = this.p.getFlooder();
/*  55 */     f.init(SPathFinderThread.class);
/*     */     
/*  57 */     f.pushSloppy(startX, startY, 0.0D);
/*  58 */     f.setValue2(startX, startY, 0.0D);
/*  59 */     OpDist.init(destX, destY);
/*     */     
/*  61 */     while (f.hasMore()) {
/*  62 */       PathTile t = f.pollSmallest();
/*     */       
/*  64 */       if (full && t.x() == destX && t.y() == destY) {
/*  65 */         f.done();
/*  66 */         return t;
/*     */       } 
/*     */       
/*  69 */       if (Math.abs(t.x() - destX) + Math.abs(t.y() - destY) == 1) {
/*  70 */         if (full) {
/*  71 */           t = f.force((short)destX, (short)destY, t.getValue2(), t);
/*     */         }
/*  73 */         f.done();
/*  74 */         return t;
/*     */       } 
/*     */       
/*  77 */       if (!comp.is((COORDINATE)t)) {
/*     */         continue;
/*     */       }
/*  80 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/*  81 */         DIR d = (DIR)DIR.ALL.get(i);
/*  82 */         int tx = t.x() + d.x();
/*  83 */         int ty = t.y() + d.y();
/*     */         
/*  85 */         if (SETT.IN_BOUNDS(tx, ty)) {
/*     */ 
/*     */           
/*  88 */           double cost = (SETT.PATH()).huristics.getCost(t.x(), t.y(), tx, ty);
/*  89 */           if (cost > 0.0D) {
/*  90 */             cost *= d.tileDistance();
/*     */             
/*  92 */             cost += t.getValue2();
/*  93 */             PathTile t2 = f.pushSmaller(tx, ty, cost + OpDist.get(tx, ty), t);
/*  94 */             if (t2 != null) {
/*  95 */               t2.setValue2(cost);
/*     */             
/*     */             }
/*     */           }
/*  99 */           else if (cost == -1.0D) {
/* 100 */             f.close(tx, ty, 0.0D);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 108 */     if (!SETT.PATH().willUpdate()) {
/* 109 */       GAME.Notify("" + startX + " " + startX + " -> " + startY + " " + destX + " " + destY);
/*     */     }
/*     */     
/* 112 */     f.done();
/* 113 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private PathTile findComp(SCompFinder.SCompPath comp, int startX, int startY, SComponent dest) {
/* 119 */     PathUtilOnline.Flooder f = this.p.getFlooder();
/* 120 */     f.init(this);
/* 121 */     SComponentChecker check = this.CHECK;
/* 122 */     check.init();
/*     */     
/* 124 */     check.isSetAndSet(dest);
/* 125 */     SComponentEdge e = dest.edgefirst();
/* 126 */     while (e != null) {
/* 127 */       check.isSetAndSet(e.to());
/* 128 */       e = e.next();
/*     */     } 
/*     */ 
/*     */     
/* 132 */     OpDist.init(dest.centreX(), dest.centreY());
/* 133 */     f.pushSloppy(startX, startY, 0.0D);
/* 134 */     f.setValue2(startX, startY, 0.0D);
/* 135 */     while (f.hasMore()) {
/* 136 */       PathTile t = f.pollSmallest();
/*     */       
/* 138 */       SComponent c = (SComponent)(SETT.PATH()).comps.zero.get((COORDINATE)t);
/* 139 */       if (check.is(c)) {
/* 140 */         f.done();
/* 141 */         return t;
/*     */       } 
/*     */ 
/*     */       
/* 145 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/* 146 */         DIR d = (DIR)DIR.ALL.get(i);
/* 147 */         int tx = t.x() + d.x();
/* 148 */         int ty = t.y() + d.y();
/* 149 */         if (comp.is(tx, ty)) {
/*     */           
/* 151 */           double cost = (SETT.PATH()).huristics.getCost(t.x(), t.y(), tx, ty);
/* 152 */           if (cost > 0.0D) {
/* 153 */             cost *= d.tileDistance();
/* 154 */             cost += t.getValue2();
/* 155 */             PathTile t2 = f.pushSmaller(tx, ty, cost + OpDist.get(tx, ty), t);
/* 156 */             if (t2 != null) {
/* 157 */               t2.setValue2(cost);
/*     */             }
/* 159 */           } else if (cost == -1.0D) {
/* 160 */             f.close(tx, ty, 0.0D);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 166 */     if (!SETT.PATH().willUpdate()) {
/* 167 */       GAME.Notify("" + startX + " " + startX + " -> " + startY + " " + dest.centreX());
/*     */     }
/*     */     
/* 170 */     f.done();
/* 171 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class OpDist
/*     */   {
/*     */     private static int destX;
/*     */     private static int destY;
/* 179 */     private static double weight = 0.7D;
/*     */     
/*     */     static void init(int dx, int dy) {
/* 182 */       destX = dx;
/* 183 */       destY = dy;
/*     */     }
/*     */     
/*     */     private static double get(int x, int y) {
/* 187 */       x = Math.abs(x - destX);
/* 188 */       y = Math.abs(y - destY);
/*     */       
/* 190 */       if (x > y)
/* 191 */         return weight * (C.SQR2 * y + x - y); 
/* 192 */       if (x < y) {
/* 193 */         return weight * (C.SQR2 * x + y - x);
/*     */       }
/* 195 */       return weight * C.SQR2 * x;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\thread\SPathFinderThread.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */