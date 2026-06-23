/*     */ package game.battle.thread.general.offence;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivPlacability;
/*     */ import game.battle.thread.general.StrategosUtil;
/*     */ import init.constant.Config;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import settlement.room.military.artillery.ROOM_ARTILLERY;
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.data.INT;
/*     */ 
/*     */ class StepLinesBacker
/*     */ {
/*     */   private final StrategosUtil u;
/*     */   private final ContextLines lines;
/*     */   private final Bitmap2D blob;
/*     */   private final Bitmap2D block;
/*     */   private final INT.IntImp lineI;
/*     */   private final Context c;
/*  32 */   private final double[] dists = new double[(Config.battle()).DIVISIONS_PER_ARMY];
/*     */ 
/*     */   
/*  35 */   private final Rec bounds = new Rec((SETT.TWIDTH - 80), (SETT.THEIGHT - 80)); private final VectorImp vec; private final ArrayListResize<ArtilleryInstance> ins;
/*     */   
/*  37 */   StepLinesBacker(StrategosUtil u, Context c) { this.bounds.centerIn(SETT.TILE_BOUNDS);
/*     */ 
/*     */     
/*  40 */     this.vec = new VectorImp();
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
/* 155 */     this.ins = new ArrayListResize(256); this.u = u; this.lines = c.lines;
/*     */     this.blob = c.blob;
/*     */     this.lineI = c.checkI;
/*     */     this.block = c.block;
/* 159 */     this.c = c; } private boolean shouldChill() { double aa = (GAME.ARMIES()).factors.casulties(GAME.ARMIES().enemy());
/* 160 */     double ab = (GAME.ARMIES()).factors.casulties(GAME.ARMIES().player());
/*     */     
/* 162 */     if (aa / (GAME.ARMIES().enemy().men() + 1.0D) > 0.05D && aa > ab * 0.75D) {
/* 163 */       return false;
/*     */     }
/* 165 */     double pow = 0.0D;
/* 166 */     double epow = 0.0D;
/*     */     int i;
/* 168 */     for (i = 0; i < (Config.battle()).DIVISIONS_PER_ARMY; i++) {
/* 169 */       pow += ((Div)this.u.getArmy().divisions().get(i)).settings().getPower();
/*     */     }
/* 171 */     for (i = 0; i < (Config.battle()).DIVISIONS_PER_ARMY; i++) {
/* 172 */       epow += ((Div)this.u.getArmy().enemy().divisions().get(i)).settings().getPower();
/*     */     }
/*     */     
/* 175 */     if (pow > epow * 1.5D) {
/* 176 */       return false;
/*     */     }
/* 178 */     int ally = 0;
/* 179 */     int enemy = 0;
/*     */     
/* 181 */     this.ins.clear();
/* 182 */     for (int ai = 0; ai < (SETT.ROOMS()).ARTILLERY.size(); ai++) {
/* 183 */       ((ROOM_ARTILLERY)(SETT.ROOMS()).ARTILLERY.get(ai)).threadInstances((LISTE)this.ins);
/*     */     }
/* 185 */     for (int ii = 0; ii < this.ins.size(); ii++) {
/* 186 */       ArtilleryInstance artilleryInstance = (ArtilleryInstance)this.ins.get(ii);
/* 187 */       if (artilleryInstance.isFiring()) {
/* 188 */         if (artilleryInstance.army() == this.u.getArmy()) {
/* 189 */           ally++;
/*     */         } else {
/* 191 */           enemy++;
/*     */         } 
/*     */       }
/*     */     } 
/* 195 */     if (enemy > ally) {
/* 196 */       return false;
/*     */     }
/* 198 */     return (ally > 0); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean retreatThroneLine() {
/* 205 */     if (this.lineI.get() >= this.lines.lines()) {
/* 206 */       return false;
/*     */     }
/* 208 */     ContextLines.Line l = this.lines.get(this.lineI.get());
/*     */     
/* 210 */     double length = getRetreat(l, l.blobID);
/*     */ 
/*     */     
/* 213 */     if (length < 0.0D) {
/* 214 */       this.lines.remove(this.lineI.get());
/* 215 */       return true;
/*     */     } 
/*     */     
/* 218 */     block(l, length);
/*     */     
/* 220 */     this.lineI.inc(1);
/*     */     
/* 222 */     this.vec.set(l.dx, l.dy);
/* 223 */     this.vec.rotate90();
/*     */     
/* 225 */     l.sx = (int)(l.sx + this.vec.nX() * length);
/* 226 */     l.sy = (int)(l.sy + this.vec.nY() * length);
/*     */ 
/*     */ 
/*     */     
/* 230 */     return true;
/*     */   } public void init() { this.lineI.set(0); this.block.clear(); PathUtilOnline.Flooder f = this.u.flooder.getFlooder(); f.init(this); for (int ty = 0; ty < SETT.THEIGHT; ty++) { for (int tx = 0; tx < SETT.TWIDTH; tx++) f.setValue2(tx, ty, 0.0D);  }  this.c.map.clear(); for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) { Div d = (Div)this.u.getArmy().divisions().get(di); if (d.active()) this.c.map.add(d);  }  for (int l = 0; l < this.lines.lines(); l++) { ContextLines.Line li = this.lines.get(l); int tx = li.cx() / 64; int k = li.cy() / 64; f.pushSloppy(tx, k, 0.0D); f.setValue2(tx, k, li.blobID); }  Arrays.fill(this.dists, Double.MAX_VALUE); while (f.hasMore()) { PathTile t = f.pollSmallest(); if (t.getParent() != null) t.setValue2(t.getParent().getValue2());  if (this.c.map.get(t.x(), t.y()).size() > 0) { double v = t.getValue(); int bi = (int)t.getValue2(); if (v < this.dists[bi])
/*     */           this.dists[bi] = v;  }  boolean b = this.blob.is((COORDINATE)t); for (int k = 0; k < DIR.ALL.size(); k++) { DIR d = (DIR)DIR.ALL.get(k); int dx = t.x() + d.x(); int dy = t.y() + d.y(); if (SETT.IN_BOUNDS(dx, dy))
/*     */           if (DivPlacability.tileIsOK(dx, dy, this.u.getArmy())) { double v = d.tileDistance() * ((!b && this.blob.is(dx, dy)) ? 5 : true); f.pushSmaller(dx, dy, v + t.getValue(), t); }   }  }  f.done(); boolean shouldShill = shouldChill(); for (int i = 0; i < this.dists.length; i++) { double closest = this.dists[i]; if (closest == Double.MAX_VALUE) { this.dists[i] = 0.0D; } else { if (!shouldShill)
/*     */           closest -= 32.0D;  closest = ((int)closest / 48); closest *= 48.0D; if (closest < 2.0D)
/*     */           closest = 2.0D;  if (closest > 256.0D)
/* 236 */           closest = 256.0D;  closest *= 64.0D; this.dists[i] = closest; }  }  for (int j = 0; j < this.lines.lines(); j++) { ContextLines.Line li = this.lines.get(j); li.blobID = (int)this.dists[li.blobID]; }  } private double getRetreat(ContextLines.Line n, double target) { this.vec.set(n.dx, n.dy);
/* 237 */     this.vec.rotate90();
/*     */ 
/*     */     
/* 240 */     for (int in = 64; in <= target; in += 64) {
/* 241 */       for (int r = 0; r <= n.length; r += 64) {
/*     */         
/* 243 */         int x = (int)(n.sx + this.vec.nX() * in + r * n.dx);
/* 244 */         int y = (int)(n.sy + this.vec.nY() * in + r * n.dy);
/* 245 */         x /= 64;
/* 246 */         y /= 64;
/*     */         
/* 248 */         if (!SETT.IN_BOUNDS(x, y)) {
/* 249 */           return (in - 512);
/*     */         }
/* 251 */         if (this.block.is(x, y)) {
/* 252 */           return (in - 512);
/*     */         }
/* 254 */         if (solid(x, y)) {
/* 255 */           return (in - 64);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 260 */     double awayFromBlobDist = target;
/*     */     
/* 262 */     int cx = n.cx();
/* 263 */     int cy = n.cy();
/* 264 */     int death = 0;
/*     */     while (true) {
/* 266 */       int x = (int)(cx + this.vec.nX() * awayFromBlobDist) / 64;
/* 267 */       int y = (int)(cy + this.vec.nY() * awayFromBlobDist) / 64;
/* 268 */       if (!SETT.IN_BOUNDS(x, y))
/*     */         break; 
/* 270 */       if (!this.blob.is(x, y))
/*     */         break; 
/* 272 */       if (death++ > 1000) {
/* 273 */         LOG.err("" + cx + " " + cx + " " + cy + " " + n.dx + " " + n.dy);
/*     */         break;
/*     */       } 
/* 276 */       awayFromBlobDist += 64.0D;
/*     */     } 
/*     */     
/* 279 */     for (int i = 64; i <= awayFromBlobDist; i += 64) {
/* 280 */       for (int r = 0; r <= n.length; r += 64) {
/*     */         
/* 282 */         int x = (int)(n.sx + this.vec.nX() * i + r * n.dx);
/* 283 */         int y = (int)(n.sy + this.vec.nY() * i + r * n.dy);
/* 284 */         x /= 64;
/* 285 */         y /= 64;
/* 286 */         this.block.set(x, y, true);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 293 */     return awayFromBlobDist; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void block(ContextLines.Line n, double awayFromBlobDist) {
/* 302 */     this.vec.set(n.dx, n.dy);
/* 303 */     this.vec.rotate90();
/*     */     
/* 305 */     for (int in = 64; in <= awayFromBlobDist; in += 64) {
/* 306 */       for (int r = 0; r <= n.length; r += 64) {
/*     */         
/* 308 */         int x = (int)(n.sx + this.vec.nX() * in + r * n.dx);
/* 309 */         int y = (int)(n.sy + this.vec.nY() * in + r * n.dy);
/* 310 */         x /= 64;
/* 311 */         y /= 64;
/* 312 */         this.block.set(x, y, true);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean solid(double dx, double dy) {
/* 320 */     int tx = (int)dx;
/* 321 */     int ty = (int)dy;
/* 322 */     if (!this.bounds.holdsPoint(tx, ty))
/* 323 */       return true; 
/* 324 */     if (!DivPlacability.tileIsOK(tx, ty, this.u.getArmy()))
/* 325 */       return true; 
/* 326 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\offence\StepLinesBacker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */