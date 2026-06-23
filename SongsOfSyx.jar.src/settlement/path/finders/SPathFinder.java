/*     */ package settlement.path.finders;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.constant.C;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SCOMPONENTS;
/*     */ import settlement.path.components.SComp0;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.components.SComponentChecker;
/*     */ import settlement.path.components.SComponentEdge;
/*     */ import settlement.path.components.SComponentLevel;
/*     */ import settlement.path.components.finder.SCompFinder;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SPathFinder
/*     */ {
/*     */   public double lastDistance;
/*     */   private final int chunkD;
/*  28 */   private final SPathUtilResult res = new SPathUtilResult();
/*  29 */   private final Coo coo = new Coo();
/*     */   
/*     */   private final PathUtilOnline p;
/*     */   
/*     */   public final SCompFinder cf;
/*     */   
/*     */   private final SPathFinderDest fDest;
/*     */   
/*     */   private final SComponentChecker CHECK;
/*     */   
/*     */   public SPathFinder(SCOMPONENTS comps, PathUtilOnline p, int chunks) {
/*  40 */     this.p = p;
/*  41 */     this.cf = new SCompFinder(comps, p);
/*  42 */     this.fDest = new SPathFinderDest(p);
/*  43 */     this.CHECK = new SComponentChecker((SComponentLevel)comps.zero);
/*  44 */     this.chunkD = chunks;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PathTile find(int startX, int startY, int destX, int destY, boolean full) {
/*  50 */     this.lastDistance = 0.0D;
/*  51 */     SCompFinder.SCompPath comp = this.cf.findDest(startX, startY, destX, destY);
/*  52 */     if (comp == null) {
/*  53 */       return null;
/*     */     }
/*  55 */     this.lastDistance = comp.distance();
/*     */ 
/*     */ 
/*     */     
/*  59 */     if (comp.path().size() > this.chunkD) {
/*  60 */       return findComp(comp, startX, startY, (SComponent)comp.path().get(comp.path().size() - this.chunkD));
/*     */     }
/*     */ 
/*     */     
/*  64 */     return find(comp, startX, startY, destX, destY, full);
/*     */   }
/*     */ 
/*     */   
/*     */   public PathTile cDebug(int startX, int startY, int destX, int destY, boolean full) {
/*  69 */     this.lastDistance = 0.0D;
/*  70 */     SCompFinder.SCompPath comp = this.cf.findDest(startX, startY, destX, destY);
/*  71 */     if (comp == null) {
/*  72 */       return null;
/*     */     }
/*  74 */     this.lastDistance = comp.distance();
/*     */ 
/*     */ 
/*     */     
/*  78 */     if (comp.path().size() > this.chunkD) {
/*  79 */       return findComp(comp, startX, startY, (SComponent)comp.path().get(comp.path().size() - this.chunkD));
/*     */     }
/*     */ 
/*     */     
/*  83 */     return find(comp, startX, startY, destX, destY, full);
/*     */   }
/*     */   
/*     */   public PathTile reverse(PathTile abs) {
/*  87 */     if (abs.getParent() != null) {
/*  88 */       PathTile p = abs.getParent();
/*  89 */       abs.parentSet(null);
/*  90 */       abs = reverse(abs, p);
/*     */     } 
/*  92 */     return abs;
/*     */   }
/*     */   
/*     */   private PathTile reverse(PathTile newParent, PathTile t) {
/*  96 */     if (t.getParent() == null) {
/*  97 */       t.parentSet(newParent);
/*  98 */       return t;
/*     */     } 
/* 100 */     PathTile res = reverse(t, t.getParent());
/* 101 */     t.parentSet(newParent);
/* 102 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private PathTile find(SCompFinder.SCompPath comp, int startX, int startY, int destX, int destY, boolean full) {
/* 108 */     PathUtilOnline.Flooder f = this.p.getFlooder();
/* 109 */     f.init(SPathFinder.class);
/*     */     
/* 111 */     f.pushSloppy(startX, startY, 0.0D);
/* 112 */     f.setValue2(startX, startY, 0.0D);
/* 113 */     OpDist.init(destX, destY);
/*     */     
/* 115 */     while (f.hasMore()) {
/* 116 */       PathTile t = f.pollSmallest();
/*     */       
/* 118 */       if (full && t.x() == destX && t.y() == destY) {
/* 119 */         f.done();
/* 120 */         return t;
/*     */       } 
/*     */       
/* 123 */       if (Math.abs(t.x() - destX) + Math.abs(t.y() - destY) == 1) {
/* 124 */         if (full) {
/* 125 */           t = f.force((short)destX, (short)destY, t.getValue2(), t);
/*     */         }
/* 127 */         f.done();
/* 128 */         return t;
/*     */       } 
/*     */       
/* 131 */       if (!comp.is((COORDINATE)t)) {
/*     */         continue;
/*     */       }
/* 134 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/* 135 */         DIR d = (DIR)DIR.ALL.get(i);
/* 136 */         int tx = t.x() + d.x();
/* 137 */         int ty = t.y() + d.y();
/*     */         
/* 139 */         if (SETT.IN_BOUNDS(tx, ty)) {
/*     */ 
/*     */           
/* 142 */           double cost = (SETT.PATH()).huristics.getCost(t.x(), t.y(), tx, ty);
/* 143 */           if (cost > 0.0D) {
/* 144 */             cost *= d.tileDistance();
/*     */             
/* 146 */             cost += t.getValue2();
/* 147 */             PathTile t2 = f.pushSmaller(tx, ty, cost + OpDist.get(tx, ty), t);
/* 148 */             if (t2 != null) {
/* 149 */               t2.setValue2(cost);
/*     */             
/*     */             }
/*     */           }
/* 153 */           else if (cost == -1.0D) {
/* 154 */             f.close(tx, ty, 0.0D);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 162 */     if (!SETT.PATH().willUpdate()) {
/* 163 */       GAME.Notify("" + startX + " " + startX + " -> " + startY + " " + destX + " " + destY);
/*     */     }
/*     */     
/* 166 */     f.done();
/* 167 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private PathTile findComp(SCompFinder.SCompPath comp, int startX, int startY, SComponent dest) {
/* 173 */     PathUtilOnline.Flooder f = this.p.getFlooder();
/* 174 */     f.init(this);
/* 175 */     SComponentChecker check = this.CHECK;
/* 176 */     check.init();
/*     */     
/* 178 */     SComp0 sComp0 = (SETT.PATH()).comps.zero.get(startX, startY);
/*     */     
/* 180 */     check.isSetAndSet(dest);
/* 181 */     SComponentEdge e = dest.edgefirst();
/* 182 */     while (e != null) {
/* 183 */       if (e.to() != sComp0) {
/* 184 */         check.isSetAndSet(e.to());
/*     */       }
/*     */       
/* 187 */       e = e.next();
/*     */     } 
/*     */ 
/*     */     
/* 191 */     OpDist.init(dest.centreX(), dest.centreY());
/* 192 */     f.pushSloppy(startX, startY, 0.0D);
/* 193 */     f.setValue2(startX, startY, 0.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 199 */     while (f.hasMore()) {
/* 200 */       PathTile t = f.pollSmallest();
/*     */       
/* 202 */       SComponent c = (SComponent)(SETT.PATH()).comps.zero.get((COORDINATE)t);
/* 203 */       if (check.is(c)) {
/* 204 */         f.done();
/* 205 */         return t;
/*     */       } 
/*     */ 
/*     */       
/* 209 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/* 210 */         DIR d = (DIR)DIR.ALL.get(i);
/* 211 */         int tx = t.x() + d.x();
/* 212 */         int ty = t.y() + d.y();
/* 213 */         if (comp.is(tx, ty)) {
/*     */           
/* 215 */           double cost = (SETT.PATH()).huristics.getCost(t.x(), t.y(), tx, ty);
/* 216 */           if (cost > 0.0D) {
/* 217 */             cost *= d.tileDistance();
/* 218 */             cost += t.getValue2();
/* 219 */             PathTile t2 = f.pushSmaller(tx, ty, cost + OpDist.get(tx, ty), t);
/* 220 */             if (t2 != null) {
/* 221 */               t2.setValue2(cost);
/*     */             }
/* 223 */           } else if (cost == -1.0D) {
/* 224 */             f.close(tx, ty, 0.0D);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 230 */     if (!SETT.PATH().willUpdate()) {
/* 231 */       GAME.Notify("" + startX + " " + startX + " -> " + startY + " " + dest.centreX());
/*     */     }
/*     */     
/* 234 */     f.done();
/* 235 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public COORDINATE findDest(int startX, int startY, SFINDER finder, int maxDistance) {
/* 241 */     this.lastDistance = 0.0D;
/* 242 */     SCompFinder.SCompPath comp = this.cf.find(startX, startY, finder, maxDistance);
/* 243 */     if (comp == null) {
/* 244 */       return null;
/*     */     }
/* 246 */     this.lastDistance = comp.distance();
/*     */     
/* 248 */     if (finder.isTile(startX, startY, 0)) {
/* 249 */       this.coo.set(startX, startY);
/* 250 */       return (COORDINATE)this.coo;
/*     */     } 
/*     */     
/* 253 */     PathTile t = this.fDest.findDest(startX, startY, comp, finder);
/* 254 */     if (t != null) {
/* 255 */       this.coo.set((COORDINATE)t);
/* 256 */       return (COORDINATE)this.coo;
/*     */     } 
/* 258 */     return null;
/*     */   }
/*     */   
/*     */   public COORDINATE findDest(RoomInstance startRoom, SFINDER finder, int maxDistance) {
/* 262 */     this.lastDistance = 0.0D;
/* 263 */     SCompFinder.SCompPath comp = this.cf.find(startRoom, finder, maxDistance);
/*     */     
/* 265 */     if (comp == null) {
/* 266 */       return null;
/*     */     }
/* 268 */     this.lastDistance = comp.distance();
/*     */     
/* 270 */     int startX = ((SComponent)comp.path().get(0)).centreX();
/* 271 */     int startY = ((SComponent)comp.path().get(0)).centreY();
/* 272 */     if (comp.path().size() > 1) {
/* 273 */       startX = ((SComponent)comp.path().get(1)).centreX();
/* 274 */       startY = ((SComponent)comp.path().get(1)).centreY();
/*     */     } 
/*     */ 
/*     */     
/* 278 */     PathTile t = this.fDest.findDest(startX, startY, comp, finder);
/* 279 */     if (t != null) {
/* 280 */       this.coo.set((COORDINATE)t);
/* 281 */       return (COORDINATE)this.coo;
/*     */     } 
/* 283 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SPathUtilResult find(int startX, int startY, SFINDER finder, int maxDistance) {
/* 288 */     SCompFinder.SCompPath comp = (SETT.PATH()).comps.pather.find(startX, startY, finder, maxDistance);
/* 289 */     SPathUtilResult r = find(startX, startY, finder, maxDistance, 
/* 290 */         comp);
/* 291 */     return r;
/*     */   }
/*     */ 
/*     */   
/*     */   SPathUtilResult find(int startX, int startY, SFINDER finder, int maxDistance, SCompFinder.SCompPath comp) {
/* 296 */     this.lastDistance = 0.0D;
/* 297 */     if (comp == null) {
/* 298 */       return null;
/*     */     }
/* 300 */     this.lastDistance = comp.distance();
/*     */     
/* 302 */     PathTile t = this.fDest.findDest(startX, startY, comp, finder);
/*     */     
/* 304 */     if (t != null) {
/* 305 */       if (comp.path().size() == 1 && t.getParent() != null) {
/* 306 */         this.res.destX = t.x();
/* 307 */         this.res.destY = t.y();
/* 308 */         this.res.t = t.getParent();
/* 309 */         return this.res;
/*     */       } 
/*     */       
/* 312 */       this.res.destX = t.x();
/* 313 */       this.res.destY = t.y();
/*     */       
/* 315 */       if (comp.path().size() > this.chunkD) {
/* 316 */         t = findComp(comp, startX, startY, (SComponent)comp.path().get(comp.path().size() - this.chunkD));
/* 317 */         if (t != null) {
/* 318 */           this.res.t = t;
/* 319 */           return this.res;
/*     */         } 
/* 321 */         return null;
/*     */       } 
/* 323 */       t = find(comp, startX, startY, t.x(), t.y(), false);
/* 324 */       if (t != null) {
/* 325 */         this.res.t = t;
/* 326 */         return this.res;
/*     */       } 
/*     */     } 
/* 329 */     if (!SETT.PATH().willUpdate()) {
/* 330 */       String ss = "";
/*     */       
/* 332 */       for (SComponent s : comp.path()) {
/* 333 */         ss = ss + ss + " " + s.centreX();
/* 334 */         ss = ss + ss;
/*     */       } 
/*     */       
/* 337 */       GAME.Notify(ss);
/*     */     } 
/*     */ 
/*     */     
/* 341 */     return null;
/*     */   }
/*     */   
/*     */   private static class OpDist
/*     */   {
/*     */     private static int destX;
/*     */     private static int destY;
/* 348 */     private static double weight = 0.7D;
/*     */     
/*     */     static void init(int dx, int dy) {
/* 351 */       destX = dx;
/* 352 */       destY = dy;
/*     */     }
/*     */     
/*     */     private static double get(int x, int y) {
/* 356 */       x = Math.abs(x - destX);
/* 357 */       y = Math.abs(y - destY);
/*     */       
/* 359 */       if (x > y)
/* 360 */         return weight * (C.SQR2 * y + x - y); 
/* 361 */       if (x < y) {
/* 362 */         return weight * (C.SQR2 * x + y - x);
/*     */       }
/* 364 */       return weight * C.SQR2 * x;
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class SPathUtilResult {
/*     */     public int destX;
/*     */     public int destY;
/*     */     public PathTile t;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SPathFinder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */