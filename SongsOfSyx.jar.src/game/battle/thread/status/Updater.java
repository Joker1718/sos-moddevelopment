/*     */ package game.battle.thread.status;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivPosition;
/*     */ import game.battle.formation.DivPositionCopyable;
/*     */ import game.battle.formation.DivPositionImp;
/*     */ import init.constant.Config;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import settlement.room.military.artillery.ROOM_ARTILLERY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.MapInt;
/*     */ 
/*     */ final class Updater
/*     */ {
/*     */   volatile boolean stop = false;
/*  24 */   private final ArrayList<Div> list = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*  25 */   private final Surrounder surrounder = new Surrounder();
/*  26 */   private final Flanker flanker = new Flanker();
/*     */ 
/*     */   
/*     */   private final ArrayListResize<ArtilleryInstance> arts;
/*     */ 
/*     */ 
/*     */   
/*     */   void init(BattleContext u) {
/*  34 */     u.map.clear();
/*  35 */     u.quads.clear();
/*  36 */     u.space.clear(); byte b; int i; DivStatus[] arrayOfDivStatus;
/*  37 */     for (i = (arrayOfDivStatus = u.statuses).length, b = 0; b < i; ) { DivStatus s = arrayOfDivStatus[b];
/*  38 */       s.clear();
/*     */       b++; }
/*     */     
/*  41 */     addToMaps(u);
/*  42 */     setStats(u);
/*  43 */     addArtillery(u);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void addToMaps(BattleContext u) {
/*  49 */     for (short i = 0; i < u.statuses.length; i = (short)(i + 1)) {
/*  50 */       if (this.stop)
/*     */         return; 
/*  52 */       Div d = GAME.ARMIES().division(i);
/*  53 */       if (d.menNrOf() != 0) {
/*     */         
/*  55 */         DivPositionCopyable pos = d.current();
/*  56 */         if (pos.deployed() != 0) {
/*     */ 
/*     */           
/*  59 */           u.map.add(i, (DivPositionImp)pos);
/*  60 */           u.space.add(d, (DivPositionImp)pos);
/*  61 */           u.army.add(d, (DivPositionImp)pos);
/*  62 */           u.quads.add(d, d.centre().cUnitX(), d.centre().cUnitY());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void setStats(BattleContext u) {
/*  70 */     for (short i = 0; i < u.statuses.length; i = (short)(i + 1)) {
/*     */       
/*  72 */       if (this.stop)
/*     */         return; 
/*  74 */       Div d = GAME.ARMIES().division(i);
/*  75 */       if (d.menNrOf() != 0) {
/*     */         
/*  77 */         DivPositionCopyable divPositionCopyable = d.current();
/*  78 */         if (divPositionCopyable.deployed() != 0) {
/*     */ 
/*     */ 
/*     */           
/*  82 */           DivStatus s = u.statuses[i];
/*     */           
/*  84 */           double friends = d.settings().getPower();
/*     */ 
/*     */           
/*  87 */           this.list.clear();
/*     */           
/*  89 */           double distMax = 19200.0D;
/*  90 */           this.surrounder.init();
/*  91 */           u.quads.getNearest((LISTE<Div>)this.list, d.centre().cUnitX(), d.centre().cUnitY(), (int)distMax, d.armyEnemy(), d);
/*     */           
/*  93 */           double distMin = distMax * 0.5D;
/*  94 */           byte threatDirs = 0;
/*  95 */           double enemyThreats = 0.0D;
/*  96 */           int k = 0;
/*  97 */           for (Div e : this.list) {
/*     */ 
/*     */             
/* 100 */             int dx = e.centre().cUnitX() - d.centre().cUnitX();
/* 101 */             int dy = e.centre().cUnitY() - d.centre().cUnitY();
/* 102 */             double dist = Math.sqrt((dx * dx + dy * dy));
/* 103 */             if (dist > distMax) {
/*     */               continue;
/*     */             }
/* 106 */             double threat = Math.max(e.settings().getPower() * (1.0D - dist / distMax), 0.0D);
/*     */             
/* 108 */             this.surrounder.add(e.centre().cUnitX(), e.centre().cUnitY(), threat);
/* 109 */             enemyThreats += threat;
/* 110 */             DIR dir = DIR.get(dx, dy);
/* 111 */             if (dist < distMin)
/*     */             {
/* 113 */               if (dir.isOrtho()) {
/* 114 */                 threatDirs = (byte)(threatDirs | dir.mask());
/*     */               } else {
/* 116 */                 threatDirs = (byte)(threatDirs | dir.mask() << 4);
/*     */               } 
/*     */             }
/* 119 */             if (k < 8) {
/* 120 */               s.enemiesClosestSet(e.index(), (int)(Math.sqrt(dist) * 0.015625D));
/* 121 */               k++;
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 126 */           double encirclement = this.surrounder.getValue(d.centre().cUnitX(), d.centre().cUnitY());
/*     */           
/* 128 */           s.encirclement = encirclement;
/*     */ 
/*     */           
/* 131 */           s.enemyDirMask = threatDirs;
/* 132 */           s.enemyThreats = enemyThreats;
/*     */ 
/*     */ 
/*     */           
/* 136 */           this.list.clearSloppy();
/* 137 */           u.quads.getNearest((LISTE<Div>)this.list, d.centre().cUnitX(), d.centre().cUnitY(), (int)distMax, d.army(), d);
/* 138 */           k = 0;
/* 139 */           for (int ii = 0; ii < this.list.size(); ii++) {
/* 140 */             Div e = (Div)this.list.get(ii);
/* 141 */             s.friendlyClosestSet(e.index());
/*     */             
/* 143 */             int dx = e.centre().cUnitX() - d.centre().cUnitX();
/* 144 */             int dy = e.centre().cUnitY() - d.centre().cUnitY();
/* 145 */             double dist = Math.sqrt((dx * dx + dy * dy));
/*     */             
/* 147 */             if (dist < distMax) {
/* 148 */               friends += Math.max(e.settings().getPower() * (1.0D - dist / distMax), 0.0D);
/*     */             }
/*     */           } 
/*     */ 
/*     */           
/* 153 */           s.friends = friends;
/*     */ 
/*     */ 
/*     */           
/* 157 */           s.flanks = this.flanker.get2(u, d, (DivPosition)divPositionCopyable);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   Updater() {
/* 163 */     this.arts = new ArrayListResize(256);
/*     */   }
/*     */   
/*     */   private void addArtillery(BattleContext u) {
/* 167 */     for (int bi = 0; bi < (SETT.ROOMS()).ARTILLERY.size(); bi++) {
/* 168 */       ROOM_ARTILLERY ab = (ROOM_ARTILLERY)(SETT.ROOMS()).ARTILLERY.get(bi);
/* 169 */       this.arts.clearSoft();
/* 170 */       ab.threadInstances((LISTE)this.arts);
/* 171 */       for (ArtilleryInstance ins : this.arts) {
/* 172 */         u.quads.addArtillery(ins);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private static class Flanker
/*     */   {
/* 179 */     int size = Math.max((Config.battle()).DIVISIONS_PER_ARMY, (Config.battle()).MEN_PER_DIVISION);
/* 180 */     private final int[] engagedX = Alloc.ii(this.size);
/* 181 */     private final int[] engagedY = Alloc.ii(this.size);
/*     */ 
/*     */ 
/*     */     
/* 185 */     private int[] dirs = Alloc.ii(DIR.ALL.size());
/*     */     
/* 187 */     private final MapInt intmap = new MapInt();
/*     */ 
/*     */     
/*     */     public double get2(BattleContext u, Div d, DivPosition pos) {
/* 191 */       int deployed = pos.deployed();
/* 192 */       if (deployed == 0) {
/* 193 */         return 0.0D;
/*     */       }
/* 195 */       int centreX = 0;
/* 196 */       int centreY = 0;
/* 197 */       int soldiersTotal = 0;
/* 198 */       int engaged = 0;
/*     */       int pi;
/* 200 */       for (pi = 0; pi < pos.deployed(); pi++) {
/* 201 */         int px = pos.px(pi);
/* 202 */         int py = pos.py(pi);
/* 203 */         if (enemy(u, d, px, py)) {
/* 204 */           this.engagedX[engaged] = px;
/* 205 */           this.engagedY[engaged] = py;
/* 206 */           engaged++;
/* 207 */           centreX += px;
/* 208 */           centreY += py;
/* 209 */           soldiersTotal++;
/* 210 */         } else if (d.reporter.reachable(pi)) {
/* 211 */           centreX += px;
/* 212 */           centreY += py;
/* 213 */           soldiersTotal++;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 218 */       if (engaged == 0) {
/* 219 */         return 0.0D;
/*     */       }
/*     */       
/* 222 */       centreX /= soldiersTotal;
/* 223 */       centreY /= soldiersTotal;
/*     */       
/* 225 */       this.intmap.clear();
/* 226 */       Arrays.fill(this.dirs, 0);
/*     */       
/* 228 */       for (pi = 0; pi < pos.deployed(); pi++) {
/* 229 */         int px = pos.px(pi);
/* 230 */         int py = pos.py(pi);
/*     */         
/* 232 */         DIR dd = DIR.get(centreX, centreY, px, py);
/* 233 */         for (int di = -1; di <= 1; di++) {
/* 234 */           DIR dir = dd.next(di);
/* 235 */           int tx = (int)((px + dir.xN() * 64.0D) / 64.0D);
/* 236 */           int ty = (int)((py + dir.yN() * 64.0D) / 64.0D);
/* 237 */           if (SETT.IN_BOUNDS(tx, ty)) {
/* 238 */             int ii = tx + ty * SETT.TWIDTH;
/* 239 */             if (!this.intmap.contains(ii)) {
/* 240 */               this.intmap.add(ii);
/* 241 */               this.dirs[dir.id()] = this.dirs[dir.id()] + u.map.soldiers(d.army().enemy()).get(tx, ty);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 249 */       double res = 0.0D;
/*     */       
/* 251 */       for (int d1 = 0; d1 < DIR.ALL.size(); d1++) {
/* 252 */         DIR da = (DIR)DIR.ALL.get(d1);
/* 253 */         for (int d2 = d1 + 1; d2 < DIR.ALL.size(); d2++) {
/* 254 */           DIR bd = (DIR)DIR.ALL.get(d2);
/* 255 */           double dot = da.xN() * bd.xN() + da.yN() * bd.yN();
/* 256 */           if (dot < 0.0D) {
/* 257 */             res += Math.min(this.dirs[d1], this.dirs[d2]) * (1.0D - dot);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 262 */       return res;
/*     */     }
/*     */     
/*     */     private boolean enemy(BattleContext u, Div div, int px, int py) {
/* 266 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 267 */         DIR dir = (DIR)DIR.ALL.get(di);
/* 268 */         int tx = (int)((px + dir.xN() * 64.0D) / 64.0D);
/* 269 */         int ty = (int)((py + dir.yN() * 64.0D) / 64.0D);
/* 270 */         if (u.map.hasEnemy.is(tx, ty, div.army())) {
/* 271 */           return true;
/*     */         }
/*     */       } 
/*     */       
/* 275 */       return false;
/*     */     } }
/*     */   
/*     */   private static class Surrounder { private final VectorImp vec;
/*     */     int size;
/*     */     int current;
/*     */     
/*     */     private Surrounder() {
/* 283 */       this.vec = new VectorImp();
/* 284 */       this.size = Math.max((Config.battle()).DIVISIONS_PER_ARMY, (Config.battle()).MEN_PER_DIVISION);
/* 285 */       this.current = 0;
/* 286 */       this.dxs = new double[this.size];
/* 287 */       this.dys = new double[this.size];
/* 288 */       this.amounts = new double[this.size];
/*     */     } private final double[] dxs; private final double[] dys; private final double[] amounts;
/*     */     public void init() {
/* 291 */       this.current = 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public void add(double px, double py, double amount) {
/* 296 */       this.dxs[this.current] = px;
/* 297 */       this.dys[this.current] = py;
/* 298 */       this.amounts[this.current] = amount;
/* 299 */       this.current++;
/*     */     }
/*     */     
/*     */     public double getValue(double cx, double cy) {
/* 303 */       if (this.current == 0) {
/* 304 */         return 0.0D;
/*     */       }
/* 306 */       convertToVectors(cx, cy);
/*     */       
/* 308 */       double xs = 0.0D;
/* 309 */       double ys = 0.0D;
/* 310 */       double am = 0.0D;
/* 311 */       for (int i = 0; i < this.current; i++) {
/* 312 */         xs += this.dxs[i] * this.amounts[i];
/* 313 */         ys += this.dys[i] * this.amounts[i];
/* 314 */         am += this.amounts[i];
/*     */       } 
/*     */       
/* 317 */       if (am == 0.0D) {
/* 318 */         return 0.0D;
/*     */       }
/* 320 */       xs /= am;
/* 321 */       ys /= am;
/* 322 */       if (xs == 0.0D && ys == 0.0D) {
/* 323 */         xs = this.dxs[0];
/* 324 */         ys = this.dys[0];
/*     */       } 
/*     */       
/* 327 */       this.vec.set(xs, ys);
/* 328 */       xs = this.vec.nX();
/* 329 */       ys = this.vec.nY();
/*     */       
/* 331 */       double v = 0.0D;
/*     */       
/* 333 */       for (int j = 0; j < this.current; j++) {
/* 334 */         double dot = this.dxs[j] * xs + this.dys[j] * ys;
/* 335 */         if (dot < -0.6D) {
/* 336 */           dot = -dot;
/* 337 */           dot /= 0.4D;
/*     */ 
/*     */           
/* 340 */           v += dot * this.amounts[j];
/*     */         } 
/*     */       } 
/* 343 */       return v;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void convertToVectors(double cx, double cy) {
/* 349 */       for (int i = 0; i < this.current; i++) {
/* 350 */         double dx = this.dxs[i] - cx;
/* 351 */         double dy = this.dys[i] - cy;
/* 352 */         this.vec.set(dx, dy);
/* 353 */         dx = this.vec.nX();
/* 354 */         dy = this.vec.nY();
/* 355 */         this.dxs[i] = this.vec.nX();
/* 356 */         this.dys[i] = this.vec.nY();
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\status\Updater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */