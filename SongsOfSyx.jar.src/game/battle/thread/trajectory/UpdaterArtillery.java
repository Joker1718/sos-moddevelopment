/*     */ package game.battle.thread.trajectory;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.Army;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.thread.status.BattleStatus;
/*     */ import init.constant.C;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import settlement.room.military.artillery.ROOM_ARTILLERY;
/*     */ import settlement.thing.projectiles.Trajectory;
/*     */ import snake2d.CircleCooIterator;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.GUTIL;
/*     */ 
/*     */ class UpdaterArtillery
/*     */ {
/*  24 */   private final ArrayList<Div> res = new ArrayList(32);
/*  25 */   private final CircleCooIterator cIt = new CircleCooIterator(4, GUTIL.flooder());
/*  26 */   private final ArrayListResize<ArtilleryInstance> threadSafe = new ArrayListResize(256);
/*     */   
/*     */   void update() {
/*  29 */     this.threadSafe.clearSoft();
/*  30 */     for (int bi = 0; bi < (SETT.ROOMS()).ARTILLERY.size(); bi++) {
/*  31 */       ROOM_ARTILLERY b = (ROOM_ARTILLERY)(SETT.ROOMS()).ARTILLERY.get(bi);
/*     */       
/*  33 */       b.threadInstances((LISTE)this.threadSafe);
/*     */     } 
/*  35 */     for (int i = 0; i < this.threadSafe.size(); i++) {
/*  36 */       ArtilleryInstance ins = (ArtilleryInstance)this.threadSafe.get(i);
/*     */       
/*  38 */       if (ins.mustered())
/*     */       {
/*  40 */         if (!setCurrentTarget(ins)) {
/*  41 */           setTarget(ins);
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   boolean setCurrentTarget(ArtilleryInstance ins) {
/*  50 */     COORDINATE tar = ins.targetCooGet();
/*  51 */     if (tar != null) {
/*  52 */       int x = tar.x();
/*  53 */       int y = tar.y();
/*  54 */       if (ins.testTarget(x, y, this.traj, false) == null) {
/*     */         
/*  56 */         if (ins.bombarding()) {
/*  57 */           ins.setTrajectory(this.traj);
/*  58 */           return true;
/*     */         } 
/*  60 */         int tx = x >> 6;
/*  61 */         int ty = y >> 6;
/*  62 */         if (!(GAME.ARMIES()).map.attackable.is(tx, ty, ins.army())) {
/*  63 */           int i = 0;
/*  64 */           while (this.cIt.radius(i) <= 3) {
/*  65 */             int dx = tx + this.cIt.get(i).x();
/*  66 */             int dy = ty + this.cIt.get(i).y();
/*  67 */             if ((GAME.ARMIES()).map.attackable.is(dx, dy, ins.army())) {
/*  68 */               dx <<= 38;
/*  69 */               dy <<= 38;
/*  70 */               if (ins.testTarget(dx, dy, this.traj, false) == null) {
/*  71 */                 ins.targetCooSet(dx, dy, false, ins.targetIsUserSet());
/*  72 */                 ins.setTrajectory(this.traj);
/*  73 */                 return true;
/*     */               } 
/*     */             } 
/*  76 */             i++;
/*     */           } 
/*     */         } else {
/*  79 */           ins.setTrajectory(this.traj);
/*  80 */           return true;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  85 */       ins.setTrajectory(null);
/*  86 */       if (ins.targetIsUserSet()) {
/*  87 */         return true;
/*     */       }
/*  89 */       ins.clearTarget();
/*  90 */       return false;
/*     */     } 
/*     */     
/*  93 */     Div ddd = ins.targetDivGet();
/*  94 */     if (ddd != null) {
/*  95 */       if (!ddd.active()) {
/*  96 */         ins.clearTarget();
/*  97 */         ins.setTrajectory(null);
/*  98 */         return false;
/*     */       } 
/* 100 */       if (ins.testTarget(ddd.centre().cUnitX(), ddd.centre().cUnitY(), this.traj, true) == null) {
/* 101 */         ins.setTrajectory(this.traj);
/* 102 */         return true;
/*     */       } 
/*     */       
/* 105 */       if (ins.targetIsUserSet()) {
/* 106 */         return true;
/*     */       }
/* 108 */       ins.clearTarget();
/* 109 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 113 */     return false;
/*     */   }
/*     */   
/* 116 */   private final int[] dirs = new int[] {
/* 117 */       0, 1, -1 };
/*     */   private int ox;
/*     */   private int oy;
/*     */   
/*     */   void setTarget(ArtilleryInstance ins) {
/* 122 */     if (!ins.fireAtWill()) {
/* 123 */       ins.setTrajectory(null);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 130 */     this.ox = -1;
/* 131 */     this.oy = -1;
/*     */     
/* 133 */     DIR dir = ins.dir();
/* 134 */     int dimension = 2048;
/* 135 */     int startX = ins.body().x1() * 64 + ins.body().width() * 64 / 2 + ins.dir().x();
/* 136 */     int startY = ins.body().y1() * 64 + ins.body().height() * 64 / 2 + ins.dir().y();
/*     */     
/* 138 */     double minRange = ins.rangeMin() / C.SQR2;
/* 139 */     double maxRange = ins.rangeMax();
/* 140 */     double range = maxRange - minRange;
/* 141 */     range = CLAMP.d(range, 0.0D, SETT.PWIDTH);
/* 142 */     double current = 0.0D;
/*     */     
/* 144 */     while (current < range) {
/*     */       
/* 146 */       double cx = startX + (minRange + current) * dir.x();
/* 147 */       double cy = startY + (minRange + current) * dir.y();
/*     */       
/* 149 */       if (cx >= SETT.PWIDTH || cy >= SETT.PHEIGHT) {
/*     */         break;
/*     */       }
/*     */       
/* 153 */       double sideAmount = 0.0D;
/* 154 */       while (sideAmount < current) {
/* 155 */         byte b; int i; int[] arrayOfInt; for (i = (arrayOfInt = this.dirs).length, b = 0; b < i; ) { int di = arrayOfInt[b];
/* 156 */           int tx = (int)(cx + dir.next(di).x() * sideAmount);
/* 157 */           int ty = (int)(cy + dir.next(di).y() * sideAmount);
/* 158 */           if (tx >= 0 && ty >= 0 && tx < SETT.PWIDTH && ty < SETT.PHEIGHT) {
/*     */ 
/*     */             
/* 161 */             tx >>= 6;
/* 162 */             ty >>= 6;
/*     */             
/* 164 */             if (trySet(ins, tx, ty))
/*     */               return; 
/*     */           }  b++; }
/*     */         
/* 168 */         sideAmount += dimension;
/*     */       } 
/*     */       
/* 171 */       current += dimension;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setTarget2(ArtilleryInstance ins) {
/* 180 */     if (!ins.fireAtWill()) {
/* 181 */       ins.setTrajectory(null);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 188 */     this.ox = -1;
/* 189 */     this.oy = -1;
/* 190 */     int dddd = 2048;
/* 191 */     int fx = ins.body().x1() * 64 + ins.body().width() * 64 / 2;
/* 192 */     int fy = ins.body().y1() * 64 + ins.body().height() * 64 / 2;
/* 193 */     fx += 64 * ins.dir().x();
/* 194 */     fy += 64 * ins.dir().y();
/*     */     
/* 196 */     double min = ins.rangeMin() / C.SQR2;
/* 197 */     double max = ins.rangeMax();
/* 198 */     double dist = max - min;
/* 199 */     dist = CLAMP.d(dist, 0.0D, SETT.PWIDTH);
/*     */ 
/*     */ 
/*     */     
/* 203 */     double wStart = min + dddd - 1.0D;
/* 204 */     int steps = (int)Math.ceil(dist / dddd);
/* 205 */     double dStep = dist / steps;
/*     */     
/* 207 */     while (steps > 0) {
/* 208 */       double sx = fx + ins.dir().x() * min;
/* 209 */       double sy = fy + ins.dir().y() * min;
/*     */       
/* 211 */       for (int s = 0; s < wStart; s += dddd) {
/* 212 */         for (int di = -2; di < 5; di += 4) {
/* 213 */           DIR d = ins.dir().next(di);
/* 214 */           int tx = (int)(sx + (s * d.x())) >> 6;
/* 215 */           int ty = (int)(sy + (s * d.y())) >> 6;
/* 216 */           if (SETT.IN_BOUNDS(tx, ty))
/*     */           {
/*     */             
/* 219 */             if (trySet(ins, tx, ty)) {
/*     */               return;
/*     */             }
/*     */           }
/*     */         } 
/*     */       } 
/* 225 */       dist += 2048.0D;
/* 226 */       wStart += dStep;
/* 227 */       steps--;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/* 232 */   private final Rec bounds = new Rec(2048.0D);
/* 233 */   private final Trajectory traj = new Trajectory();
/*     */   
/*     */   private boolean trySet(ArtilleryInstance ins, int tx, int ty) {
/* 236 */     Army enemy = ins.army().enemy();
/* 237 */     int qx = tx / 32;
/* 238 */     int qy = ty / 32;
/* 239 */     if (this.ox == qx && this.oy == qy)
/* 240 */       return false; 
/* 241 */     this.ox = qx;
/* 242 */     this.oy = qy;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 247 */     int fx = ins.body().x1() * 64 + ins.body().width() * 64 / 2;
/* 248 */     int fy = ins.body().y1() * 64 + ins.body().height() * 64 / 2;
/* 249 */     this.res.clearSloppy();
/*     */ 
/*     */ 
/*     */     
/* 253 */     BattleStatus.quads().getInQuad((LISTE)this.res, tx, ty, enemy);
/* 254 */     Div best = null;
/* 255 */     int bestDist = Integer.MAX_VALUE;
/* 256 */     for (Div div : this.res) {
/* 257 */       if (ins.testTarget(div.centre().cUnitX(), div.centre().cUnitY(), this.traj, true) == null) {
/* 258 */         int dist = (div.centre().cUnitX() - fx) * (div.centre().cUnitX() - fx) + (div.centre().cUnitY() - fy) * (div.centre().cUnitY() - fy);
/* 259 */         if (dist < bestDist) {
/* 260 */           best = div;
/* 261 */           bestDist = dist;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 266 */     if (best != null) {
/* 267 */       ins.targetDivSet(best, false);
/* 268 */       ins.setTrajectory(this.traj);
/* 269 */       return true;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 274 */     this.bounds.moveX1Y1((qx * 64 * 32), (qy * 64 * 32));
/*     */     
/* 276 */     if ((BattleStatus.quads()).ART.is(tx, ty, enemy))
/*     */     {
/* 278 */       for (int i = 0; i < this.threadSafe.size(); i++) {
/* 279 */         ArtilleryInstance other = (ArtilleryInstance)this.threadSafe.get(i);
/* 280 */         if (other.army() != ins.army()) {
/* 281 */           int j = other.body().x1() * 64 + other.body().width() * 64 / 2;
/* 282 */           int k = other.body().y1() * 64 + other.body().height() * 64 / 2;
/* 283 */           if (this.bounds.touches(j, k) && 
/* 284 */             ins.testTarget(j, k, this.traj, false) == null) {
/* 285 */             ins.targetCooSet(j, k, false, false);
/* 286 */             ins.setTrajectory(this.traj);
/* 287 */             return true;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 294 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\trajectory\UpdaterArtillery.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */