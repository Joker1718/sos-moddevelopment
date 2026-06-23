/*     */ package world.map.road;
/*     */ 
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.IntChecker;
/*     */ import snake2d.util.sets.ArrayListGrower;
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
/*     */ class RReg
/*     */ {
/*     */   public final Region reg;
/* 164 */   private double lastValue = Double.MAX_VALUE;
/* 165 */   private final ArrayListGrower<GenRoad.RDistance> neighs = new ArrayListGrower();
/* 166 */   public final ArrayListGrower<GenRoad.RDistance> dists = new ArrayListGrower();
/*     */   boolean changed = false;
/*     */   
/*     */   RReg(Region home) {
/* 170 */     this.reg = home;
/*     */   }
/*     */   
/*     */   void remove(RReg to) {
/* 174 */     for (GenRoad.RDistance d : this.neighs) {
/* 175 */       if (d.to == to) {
/* 176 */         this.neighs.remove(d);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 181 */     this.changed = true;
/* 182 */     this.lastValue = Double.MAX_VALUE;
/* 183 */     for (GenRoad.RDistance d : this.neighs) {
/* 184 */       if (d.dist < this.lastValue) {
/* 185 */         this.lastValue = d.dist;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void init(IntChecker check) {
/* 192 */     check.init();
/*     */     
/* 194 */     for (GenRoad.RDistance d : this.neighs) {
/* 195 */       check.isSetAndSet(d.to.reg.index());
/*     */     }
/*     */ 
/*     */     
/* 199 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 200 */     f.init(this);
/* 201 */     f.pushSloppy(this.reg.info.cx(), this.reg.info.cy(), 0.0D);
/* 202 */     while (f.hasMore()) {
/* 203 */       PathTile t = f.pollSmallest();
/* 204 */       RReg current = (RReg)GenRoad.this.map.get((COORDINATE)t);
/* 205 */       if (current == null) {
/*     */         continue;
/*     */       }
/* 208 */       if (current != this)
/* 209 */         if (!check.isSet(current.reg.index())) {
/* 210 */           if (t.isSameAs(current.reg.cx(), current.reg.cy())) {
/* 211 */             check.isSetAndSet(current.reg.index());
/* 212 */             this.neighs.add(new GenRoad.RDistance(current, t.getValue()));
/* 213 */             current.neighs.add(new GenRoad.RDistance(this, t.getValue()));
/* 214 */             if (t.getValue() < this.lastValue) {
/* 215 */               this.lastValue = t.getValue();
/*     */             }
/*     */           } 
/*     */         } else {
/*     */           continue;
/*     */         }  
/* 221 */       push(t);
/*     */     } 
/*     */     
/* 224 */     f.done();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PathTile findNext(IntChecker check) {
/* 231 */     if (this.neighs.size() == 0) {
/* 232 */       return null;
/*     */     }
/* 234 */     check.init();
/*     */     
/* 236 */     for (GenRoad.RDistance d : this.neighs) {
/* 237 */       check.isSetAndSet(d.to.reg.index());
/*     */     }
/*     */ 
/*     */     
/* 241 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 242 */     f.init(this);
/* 243 */     f.pushSloppy(this.reg.info.cx(), this.reg.info.cy(), 0.0D);
/* 244 */     while (f.hasMore()) {
/* 245 */       PathTile t = f.pollSmallest();
/* 246 */       RReg current = (RReg)GenRoad.this.map.get((COORDINATE)t);
/* 247 */       if (current == null) {
/*     */         continue;
/*     */       }
/* 250 */       if (current != this) {
/* 251 */         if (check.isSet(current.reg.index())) {
/* 252 */           if (t.isSameAs(current.reg.cx(), current.reg.cy())) {
/* 253 */             f.done();
/* 254 */             return t;
/*     */           } 
/*     */         } else {
/*     */           continue;
/*     */         } 
/*     */       }
/* 260 */       push(t);
/*     */     } 
/*     */     
/* 263 */     f.done();
/* 264 */     this.neighs.clear();
/* 265 */     return null;
/*     */   }
/*     */   
/*     */   private void push(PathTile t) {
/* 269 */     RReg current = (RReg)GenRoad.this.map.get((COORDINATE)t);
/* 270 */     for (DIR d : DIR.ALL) {
/* 271 */       int dx = t.x() + d.x();
/* 272 */       int dy = t.y() + d.y();
/* 273 */       if (WTRAV.canLand(t.x(), t.y(), d, false)) {
/* 274 */         double v = GenRoad.this.u.get(dx, dy) + WTRAV.extracost(dx, dy, d);
/* 275 */         RReg to = (RReg)GenRoad.this.map.get(dx, dy);
/* 276 */         if (to != current && !d.isOrtho())
/*     */           continue; 
/* 278 */         if (current != this && current != to)
/*     */           continue; 
/* 280 */         if (WTRAV.canLand(t.x(), t.y(), d, true)) {
/* 281 */           v *= 0.5D;
/* 282 */         } else if ((WORLD.WATER()).isBig.is(dx, dy)) {
/* 283 */           v += 32.0D;
/*     */         } 
/* 285 */         GUTIL.flooder().pushSmaller(dx, dy, t.getValue() + v * d.tileDistance(), t);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\road\GenRoad$RReg.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */