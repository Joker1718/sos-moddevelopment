/*     */ package world.map.road;
/*     */ 
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_DOUBLE;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.IntChecker;
/*     */ import snake2d.util.rnd.Polymap;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.Tree;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class GenRoad
/*     */ {
/*  22 */   private final IntChecker dests = new IntChecker(1023);
/*     */   private final MAP_DOUBLE u;
/*  24 */   public final RReg[] all = new RReg[1023];
/*  25 */   private double[] dists = new double[1023];
/*  26 */   public final Polymap polly = new Polymap(WORLD.TBOUNDS(), 6, 1.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final MAP_OBJECT<RReg> map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean findNextConnection(RReg r) {
/*  74 */     this.dests.init();
/*     */     
/*  76 */     double longest = 0.0D;
/*  77 */     for (RDistance d : r.neighs) {
/*  78 */       this.dests.isSetAndSet(d.to.reg.index());
/*  79 */       this.dists[d.to.reg.index()] = d.dist;
/*  80 */       longest = Math.max(longest, d.dist);
/*     */     } 
/*     */     
/*  83 */     RReg nn = tryNeighs(r, this.dests, longest);
/*     */     
/*  85 */     if (nn != null) {
/*  86 */       nn.remove(r);
/*  87 */       r.remove(nn);
/*  88 */       return true;
/*     */     } 
/*     */     
/*  91 */     PathTile t = r.findNext(this.dests);
/*     */ 
/*     */ 
/*     */     
/*  95 */     if (t == null) {
/*  96 */       return false;
/*     */     }
/*  98 */     connect(t);
/*  99 */     RReg to = (RReg)this.map.get((COORDINATE)t);
/* 100 */     to.remove(r);
/* 101 */     r.remove(to);
/*     */     
/* 103 */     to.dists.add(new RDistance(r, t.getValue()));
/* 104 */     r.dists.add(new RDistance(to, t.getValue()));
/*     */     
/* 106 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RReg tryNeighs(RReg home, IntChecker check, double longest) {
/* 113 */     if (home.dists.size() == 0) {
/* 114 */       return null;
/*     */     }
/* 116 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 117 */     f.init(this);
/*     */     
/* 119 */     for (RDistance d : home.dists) {
/* 120 */       if (!check.isSet(d.to.reg.index())) {
/* 121 */         f.pushSloppy(d.to.reg.cx(), d.to.reg.cy(), 0.0D);
/*     */       }
/*     */     } 
/* 124 */     while (f.hasMore()) {
/* 125 */       PathTile t = f.pollSmallest();
/* 126 */       if (t.getValue() > longest) {
/*     */         break;
/*     */       }
/* 129 */       RReg current = (RReg)this.map.get((COORDINATE)t);
/*     */       
/* 131 */       if (check.isSet(current.reg.index()) && 
/* 132 */         t.getValue() < this.dists[current.reg.index()]) {
/* 133 */         f.done();
/* 134 */         return current;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 139 */       for (RDistance d : current.dists) {
/* 140 */         if (d.to != home) {
/* 141 */           f.pushSmaller(d.to.reg.cx(), d.to.reg.cy(), t.getValue() + d.dist, t);
/*     */         }
/*     */       } 
/*     */     } 
/* 145 */     f.done();
/* 146 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void connect(PathTile t) {
/* 156 */     WTRAV.makeRoad(t);
/*     */   }
/*     */ 
/*     */   
/*     */   private class RReg
/*     */   {
/*     */     public final Region reg;
/*     */     
/* 164 */     private double lastValue = Double.MAX_VALUE;
/* 165 */     private final ArrayListGrower<GenRoad.RDistance> neighs = new ArrayListGrower();
/* 166 */     public final ArrayListGrower<GenRoad.RDistance> dists = new ArrayListGrower();
/*     */     boolean changed = false;
/*     */     
/*     */     RReg(Region home) {
/* 170 */       this.reg = home;
/*     */     }
/*     */     
/*     */     void remove(RReg to) {
/* 174 */       for (GenRoad.RDistance d : this.neighs) {
/* 175 */         if (d.to == to) {
/* 176 */           this.neighs.remove(d);
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/* 181 */       this.changed = true;
/* 182 */       this.lastValue = Double.MAX_VALUE;
/* 183 */       for (GenRoad.RDistance d : this.neighs) {
/* 184 */         if (d.dist < this.lastValue) {
/* 185 */           this.lastValue = d.dist;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     void init(IntChecker check) {
/* 192 */       check.init();
/*     */       
/* 194 */       for (GenRoad.RDistance d : this.neighs) {
/* 195 */         check.isSetAndSet(d.to.reg.index());
/*     */       }
/*     */ 
/*     */       
/* 199 */       PathUtilOnline.Flooder f = GUTIL.flooder();
/* 200 */       f.init(this);
/* 201 */       f.pushSloppy(this.reg.info.cx(), this.reg.info.cy(), 0.0D);
/* 202 */       while (f.hasMore()) {
/* 203 */         PathTile t = f.pollSmallest();
/* 204 */         RReg current = (RReg)GenRoad.this.map.get((COORDINATE)t);
/* 205 */         if (current == null) {
/*     */           continue;
/*     */         }
/* 208 */         if (current != this)
/* 209 */           if (!check.isSet(current.reg.index())) {
/* 210 */             if (t.isSameAs(current.reg.cx(), current.reg.cy())) {
/* 211 */               check.isSetAndSet(current.reg.index());
/* 212 */               this.neighs.add(new GenRoad.RDistance(current, t.getValue()));
/* 213 */               current.neighs.add(new GenRoad.RDistance(this, t.getValue()));
/* 214 */               if (t.getValue() < this.lastValue) {
/* 215 */                 this.lastValue = t.getValue();
/*     */               }
/*     */             } 
/*     */           } else {
/*     */             continue;
/*     */           }  
/* 221 */         push(t);
/*     */       } 
/*     */       
/* 224 */       f.done();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     PathTile findNext(IntChecker check) {
/* 231 */       if (this.neighs.size() == 0) {
/* 232 */         return null;
/*     */       }
/* 234 */       check.init();
/*     */       
/* 236 */       for (GenRoad.RDistance d : this.neighs) {
/* 237 */         check.isSetAndSet(d.to.reg.index());
/*     */       }
/*     */ 
/*     */       
/* 241 */       PathUtilOnline.Flooder f = GUTIL.flooder();
/* 242 */       f.init(this);
/* 243 */       f.pushSloppy(this.reg.info.cx(), this.reg.info.cy(), 0.0D);
/* 244 */       while (f.hasMore()) {
/* 245 */         PathTile t = f.pollSmallest();
/* 246 */         RReg current = (RReg)GenRoad.this.map.get((COORDINATE)t);
/* 247 */         if (current == null) {
/*     */           continue;
/*     */         }
/* 250 */         if (current != this) {
/* 251 */           if (check.isSet(current.reg.index())) {
/* 252 */             if (t.isSameAs(current.reg.cx(), current.reg.cy())) {
/* 253 */               f.done();
/* 254 */               return t;
/*     */             } 
/*     */           } else {
/*     */             continue;
/*     */           } 
/*     */         }
/* 260 */         push(t);
/*     */       } 
/*     */       
/* 263 */       f.done();
/* 264 */       this.neighs.clear();
/* 265 */       return null;
/*     */     }
/*     */     
/*     */     private void push(PathTile t) {
/* 269 */       RReg current = (RReg)GenRoad.this.map.get((COORDINATE)t);
/* 270 */       for (DIR d : DIR.ALL) {
/* 271 */         int dx = t.x() + d.x();
/* 272 */         int dy = t.y() + d.y();
/* 273 */         if (WTRAV.canLand(t.x(), t.y(), d, false)) {
/* 274 */           double v = GenRoad.this.u.get(dx, dy) + WTRAV.extracost(dx, dy, d);
/* 275 */           RReg to = (RReg)GenRoad.this.map.get(dx, dy);
/* 276 */           if (to != current && !d.isOrtho())
/*     */             continue; 
/* 278 */           if (current != this && current != to)
/*     */             continue; 
/* 280 */           if (WTRAV.canLand(t.x(), t.y(), d, true)) {
/* 281 */             v *= 0.5D;
/* 282 */           } else if ((WORLD.WATER()).isBig.is(dx, dy)) {
/* 283 */             v += 32.0D;
/*     */           } 
/* 285 */           GUTIL.flooder().pushSmaller(dx, dy, t.getValue() + v * d.tileDistance(), t);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class RDistance
/*     */   {
/*     */     final GenRoad.RReg to;
/*     */     
/*     */     final double dist;
/*     */     
/*     */     RDistance(GenRoad.RReg to, double dist) {
/* 299 */       this.to = to;
/* 300 */       this.dist = dist;
/*     */     }
/*     */   }
/*     */   
/*     */   public GenRoad(ACTION util, MAP_DOUBLE infra) {
/* 305 */     this.map = new MAP_OBJECT<RReg>()
/*     */       {
/*     */         public GenRoad.RReg get(int tile) {
/* 308 */           Region r = (Region)(WORLD.REGIONS()).map.get(tile);
/* 309 */           if (r != null)
/* 310 */             return GenRoad.this.all[r.index()]; 
/* 311 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public GenRoad.RReg get(int tx, int ty) {
/* 316 */           Region r = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 317 */           if (r != null)
/* 318 */             return GenRoad.this.all[r.index()]; 
/* 319 */           return null;
/*     */         }
/*     */       };
/*     */     this.u = infra;
/*     */     for (Region r : WORLD.REGIONS().all()) {
/*     */       if (r.info.area() > 0)
/*     */         this.all[r.index()] = new RReg(r); 
/*     */     } 
/*     */     Tree<RReg> sort = new Tree<RReg>(1023) {
/*     */         protected boolean isGreaterThan(GenRoad.RReg current, GenRoad.RReg cmp) {
/*     */           return (current.lastValue > cmp.lastValue);
/*     */         }
/*     */       };
/*     */     byte b;
/*     */     int i;
/*     */     RReg[] arrayOfRReg;
/*     */     for (i = (arrayOfRReg = this.all).length, b = 0; b < i; ) {
/*     */       RReg r = arrayOfRReg[b];
/*     */       if (r != null) {
/*     */         r.init(this.dests);
/*     */         sort.add(r);
/*     */       } 
/*     */       b++;
/*     */     } 
/*     */     util.exe();
/*     */     int a = 0;
/*     */     while (sort.hasMore()) {
/*     */       RReg r = (RReg)sort.pollSmallest();
/*     */       if (a++ > 10) {
/*     */         a = 0;
/*     */         util.exe();
/*     */       } 
/*     */       if (r.changed) {
/*     */         r.changed = false;
/*     */         sort.add(r);
/*     */         continue;
/*     */       } 
/*     */       if (findNextConnection(r))
/*     */         sort.add(r); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\road\GenRoad.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */