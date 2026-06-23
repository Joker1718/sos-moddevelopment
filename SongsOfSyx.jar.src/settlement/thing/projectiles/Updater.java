/*     */ package settlement.thing.projectiles;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.Army;
/*     */ import game.battle.thread.status.BattleStatus;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.util.GEO;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ final class Updater
/*     */ {
/*     */   private final SProjectiles p;
/*  23 */   private static final VectorImp vec = new VectorImp();
/*  24 */   private final double max = 0.015625D;
/*     */ 
/*     */   
/*     */   private final Rec rTile;
/*     */ 
/*     */ 
/*     */   
/*     */   void update(int i, double dd) {
/*  32 */     float ds = 0.015625F;
/*  33 */     while (dd > 0.0D) {
/*     */       
/*  35 */       dd -= 0.015625D;
/*  36 */       PData.Data d = this.p.data.data(i);
/*     */       
/*  38 */       d.dzSet(d.dz() - 640.0D * ds);
/*     */       
/*  40 */       float z = d.z() + d.dz() * ds;
/*  41 */       if (z <= 0.0F) {
/*  42 */         ds *= d.z() / (d.z() - z);
/*  43 */         z = d.z() + d.dz() * ds;
/*     */       } 
/*  45 */       d.zSet(z);
/*     */       
/*  47 */       double mag = d.dMagnitude();
/*  48 */       mag -= 16.0D * ds;
/*  49 */       if (mag < 0.0D)
/*  50 */         mag = 0.0D; 
/*  51 */       d.magnitudeSet(mag);
/*     */       
/*  53 */       float x = (float)(d.x() + d.speedX() * ds);
/*  54 */       float y = (float)(d.y() + d.speedY() * ds);
/*     */ 
/*     */       
/*  57 */       if (d.z() <= 0.0F) {
/*  58 */         if (collide(i, d, x, y, this.p.data.type(i)))
/*     */           return; 
/*  60 */         this.p.data.type(i).soundHit().rnd((int)x, (int)y, 1.0D);
/*  61 */         this.p.data.type(i).impact(this.p.data.ref(i), x, y, d.speedX(), d.speedY(), d.dz());
/*  62 */         this.p.data.remove(i);
/*     */         
/*     */         return;
/*     */       } 
/*  66 */       if (collide(i, d, x, y, this.p.data.type(i))) {
/*     */         return;
/*     */       }
/*  69 */       if (!this.p.data.move(i, x, y)) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Updater(SProjectiles p) {
/*  78 */     this.rTile = new Rec(64.0D);
/*     */     this.p = p;
/*     */   }
/*     */   private boolean collide(int e, PData.Data d, float destX, float destY, Projectile type) {
/*  82 */     destY /= 64.0F;
/*  83 */     destX /= 64.0F;
/*     */     
/*  85 */     double startX = (d.x() / 64.0F);
/*  86 */     double startY = (d.y() / 64.0F);
/*     */     
/*  88 */     if ((int)destX == (int)startX && (int)destY == (int)startY && d.z() > 0.0F) {
/*  89 */       return false;
/*     */     }
/*  91 */     double dx = destX - startX;
/*  92 */     double dy = destY - startY;
/*  93 */     double adx = Math.abs(dx);
/*  94 */     double ady = Math.abs(dy);
/*  95 */     double mag = 0.0D;
/*  96 */     if (adx > ady) {
/*  97 */       mag = adx;
/*     */     }
/*  99 */     else if (ady <= 0.0D) {
/* 100 */       mag = 1.0D;
/*     */     } else {
/* 102 */       mag = ady;
/*     */     } 
/*     */     
/* 105 */     dx /= mag;
/* 106 */     dy /= mag;
/*     */     
/* 108 */     double x = startX;
/* 109 */     double y = startY;
/*     */ 
/*     */     
/* 112 */     while (mag > 0.0D) {
/* 113 */       double dd = CLAMP.d(mag, 0.0D, 1.0D);
/* 114 */       double ox = x;
/* 115 */       double oy = y;
/* 116 */       x += dx * dd;
/* 117 */       y += dy * dd;
/* 118 */       mag--;
/* 119 */       int tx = (int)x;
/* 120 */       int ty = (int)y;
/*     */       
/* 122 */       if (!SETT.IN_BOUNDS(tx, ty)) {
/* 123 */         this.p.data.remove(e);
/* 124 */         return true;
/*     */       } 
/* 126 */       Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/* 127 */       int min = t.heightStart(tx, ty) * 64;
/* 128 */       int max = t.heightEnd(tx, ty) * 64;
/*     */       
/* 130 */       boolean tree = (SETT.TERRAIN()).TREES.isTree(tx, ty);
/*     */       
/* 132 */       if (!tree || (e & 0x1) != 0)
/*     */       {
/* 134 */         if (d.z() <= 0.0F || (d.z() > min && d.z() < max)) {
/*     */           
/* 136 */           this.p.data.type(e).soundHit().rnd((int)(x * 64.0D), (int)(y * 64.0D), 1.0D);
/* 137 */           double mom = d.dMagnitude() * this.p.data.type(e).mass(this.p.data.ref(e));
/* 138 */           double str = (GAME.ARMIES()).map.strength.get(tx, ty);
/* 139 */           if (this.p.data.live(e) && mom > str * RND.rFloat()) {
/* 140 */             (GAME.ARMIES()).map.breakIt(tx, ty);
/* 141 */             double ddd = (mom - str) / mom;
/* 142 */             ddd = Math.max(ddd, 0.0D);
/* 143 */             d.magnitudeSet(d.dMagnitude() * ddd);
/*     */             
/*     */             continue;
/*     */           } 
/* 147 */           type.impact(this.p.data.ref(e), x * 64.0D, y * 64.0D, d.speedX(), d.speedY(), d.dz());
/*     */ 
/*     */           
/* 150 */           if (d.z() > 0.0F && !tree && RND.oneIn(5)) {
/*     */ 
/*     */             
/* 153 */             double cx = tx + 0.5D;
/* 154 */             double cy = ty + 0.5D;
/* 155 */             double prevX = x - dx * dd;
/* 156 */             double prevY = y - dy * dd;
/* 157 */             double ddx = Math.abs(cx - prevX);
/* 158 */             double ddy = Math.abs(cy - prevY);
/* 159 */             double r = RND.rFloat();
/* 160 */             d.magnitudeSet(d.dMagnitude() * r);
/* 161 */             if (ddx > ddy) {
/* 162 */               d.nxSet(-d.nx());
/*     */             } else {
/* 164 */               d.nySet(-d.ny());
/*     */             } 
/* 166 */             this.p.data.move(e, prevX * 64.0D, prevY * 64.0D);
/*     */           }
/*     */           else {
/*     */             
/* 170 */             this.p.data.remove(e);
/*     */           } 
/*     */           
/* 173 */           return true;
/*     */         } 
/*     */       }
/* 176 */       int hel = t.heightEnt(tx, ty) * 64;
/* 177 */       int heh = hel + 128;
/* 178 */       if (d.z() >= hel && d.z() < heh) {
/* 179 */         this.rTile.moveC(x * 64.0D, y * 64.0D);
/* 180 */         for (ENTITY ent : SETT.ENTITIES().fill((RECTANGLE)this.rTile)) {
/*     */           
/* 182 */           if (!intesects(ent, ox, oy, x, y)) {
/*     */             continue;
/*     */           }
/* 185 */           double ref = this.p.data.ref(e);
/*     */ 
/*     */           
/* 188 */           if (ent instanceof Humanoid) {
/* 189 */             Humanoid a = (Humanoid)ent;
/* 190 */             if (a.division() != null) {
/* 191 */               (GAME.ARMIES()).factors.reportProjectile(a.division());
/*     */             }
/*     */           } 
/* 194 */           double esx = ent.speed.x();
/* 195 */           double esy = ent.speed.y();
/* 196 */           double xs = d.speedX() - esx;
/* 197 */           double ys = d.speedY() - esy;
/* 198 */           double speed = Math.sqrt(xs * xs + ys * ys + (d.dz() * d.dz()));
/*     */ 
/*     */ 
/*     */           
/* 202 */           vec.set(ox * 64.0D, oy * 64.0D, ent.body().cX(), ent.body().cY());
/* 203 */           if ((GAME.battle()).fight.projectileAttack(ent, dx, dy, speed, type, ref)) {
/* 204 */             this.p.data.type(e).soundHit().rnd((int)(x * 64.0D), (int)(y * 64.0D), 1.0D);
/*     */             
/* 206 */             if (ent.isRemoved()) {
/*     */ 
/*     */               
/* 209 */               ENTITY o = this.p.data.shooter(e);
/* 210 */               if (o != null && o instanceof Humanoid) {
/* 211 */                 Humanoid a = (Humanoid)o;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 217 */                 STATS.BATTLE().makeAKill(a);
/*     */               } 
/*     */ 
/*     */               
/* 221 */               double mom = type.mass(ref) * speed;
/* 222 */               double momExchange = ent.physics.getMass() * 64.0D * 4.0D;
/* 223 */               if (mom - momExchange > 0.0D) {
/*     */                 
/* 225 */                 mom -= momExchange;
/* 226 */                 mom /= type.mass(ref);
/* 227 */                 double ddd = mom / speed;
/* 228 */                 d.magnitudeSet(d.dMagnitude() * ddd); continue;
/*     */               } 
/* 230 */               type.impact(ref, x * 64.0D, y * 64.0D, d.speedX(), d.speedY(), d.dz());
/* 231 */               this.p.data.remove(e);
/* 232 */               return true;
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 237 */             type.impact(ref, x * 64.0D, y * 64.0D, d.speedX(), d.speedY(), d.dz());
/* 238 */             this.p.data.remove(e);
/* 239 */             return true;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 249 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static CharSequence test(Army ally, Trajectory traj, double height, double sx, double sy) {
/* 255 */     double time = traj.getTime(height);
/* 256 */     float vz = (float)traj.vz();
/*     */ 
/*     */     
/* 259 */     double mag = vec.set(traj.vx(), traj.vy());
/* 260 */     double length = Trajectory.getLength(mag, time);
/*     */     
/* 262 */     length *= 0.015625D;
/*     */     
/* 264 */     double ds = time / length;
/* 265 */     int imax = (int)Math.ceil(length);
/*     */ 
/*     */     
/* 268 */     double x = sx;
/* 269 */     double y = sy;
/* 270 */     double z = height;
/*     */     
/* 272 */     for (int i = 0; i < imax; i++) {
/*     */ 
/*     */       
/* 275 */       mag -= 16.0D * ds;
/* 276 */       if (mag < 0.0D) {
/* 277 */         mag = 0.0D;
/*     */       }
/* 279 */       vz = (float)(vz - 640.0D * ds);
/*     */       
/* 281 */       x += vec.nX() * mag * ds;
/* 282 */       y += vec.nY() * mag * ds;
/* 283 */       z += vz * ds;
/*     */       
/* 285 */       float zz = (float)(z + vz * ds);
/* 286 */       if (zz <= 0.0F) {
/* 287 */         ds *= z / (vz - zz);
/*     */       }
/*     */       
/* 290 */       if (z <= 0.0D)
/* 291 */         return null; 
/* 292 */       int tx = (int)x >> 6;
/* 293 */       int ty = (int)y >> 6;
/*     */       
/* 295 */       if (!SETT.IN_BOUNDS(tx, ty)) {
/* 296 */         return null;
/*     */       }
/* 298 */       Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/* 299 */       int min = t.heightStart(tx, ty) * 64;
/* 300 */       int max = t.heightEnd(tx, ty) * 64;
/*     */       
/* 302 */       if (!(SETT.TERRAIN()).TREES.isTree(tx, ty) && z > min && z < max) {
/* 303 */         if (imax - i < 10)
/* 304 */           return null; 
/* 305 */         return SProjectiles.¤¤TERRAIN;
/*     */       } 
/* 307 */       int eh = t.heightEnt(tx, ty) * 64;
/* 308 */       if (z >= eh && z <= (eh + 128)) {
/* 309 */         if ((BattleStatus.map()).hasAlly.is(tx, ty, ally)) {
/* 310 */           return SProjectiles.¤¤FRIENDLIES;
/*     */         }
/* 312 */         if ((BattleStatus.map()).hasEnemy.is(tx, ty, ally))
/* 313 */           return null; 
/* 314 */         for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 315 */           DIR dir = (DIR)DIR.ORTHO.get(di);
/* 316 */           if ((BattleStatus.map()).hasAlly.is(tx, ty, dir, ally)) {
/* 317 */             return SProjectiles.¤¤FRIENDLIES;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 326 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean intesects(ENTITY e, double ox, double oy, double nx, double ny) {
/* 331 */     double x1 = ox;
/* 332 */     double y1 = oy;
/* 333 */     double x2 = nx;
/* 334 */     double y2 = ny;
/*     */     
/* 336 */     double w = e.body().width() * 0.015625D;
/* 337 */     double x = e.body().x1() * 0.015625D;
/* 338 */     double y = e.body().y1() * 0.015625D;
/* 339 */     if (GEO.collides(x1, y1, x2, y2, x, y, x + w, y))
/* 340 */       return true; 
/* 341 */     if (GEO.collides(x1, y1, x2, y2, x + w, y, x + w, y + w))
/* 342 */       return true; 
/* 343 */     if (GEO.collides(x1, y1, x2, y2, x + w, y + w, x, y + w))
/* 344 */       return true; 
/* 345 */     if (GEO.collides(x1, y1, x2, y2, x, y + w, x, y))
/* 346 */       return true; 
/* 347 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\projectiles\Updater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */