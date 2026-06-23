/*     */ package settlement.entity;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.constant.C;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.path.PATHING;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ResolverTile
/*     */ {
/*     */   private static double attack(int tx, int ty, double m, ENTITY e) {
/*  24 */     if (!SETT.IN_BOUNDS(tx, ty)) {
/*  25 */       return m;
/*     */     }
/*     */     
/*  28 */     if (e instanceof Humanoid && (GAME.ARMIES()).map.attackableI.is(tx, ty, ((Humanoid)e).indu())) {
/*  29 */       double str = (GAME.ARMIES()).map.strength.get(tx, ty) * 2.0D;
/*  30 */       str += RND.rFloat() * str;
/*     */       
/*  32 */       if (m > str + RND.rFloat() * str) {
/*  33 */         (GAME.ARMIES()).map.breakIt(tx, ty);
/*  34 */         return str;
/*     */       } 
/*  36 */       if (!collides(tx, ty, e)) {
/*  37 */         return CLAMP.d(m - str, 0.0D, m);
/*     */       }
/*     */     } 
/*     */     
/*  41 */     return m;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void resolve(int tx, int ty, ENTITY a, EPHYSICS.Solid p) {
/*  47 */     double targetX, targetY, x1 = p.body().x1();
/*  48 */     double ox1 = p.x1;
/*  49 */     double y1 = p.body().y1();
/*  50 */     double oy1 = p.y1;
/*  51 */     double size = p.body().width();
/*     */     
/*  53 */     double vx = x1 - ox1;
/*     */     
/*  55 */     if (vx > 0.0D) {
/*  56 */       targetX = (tx << 6) - size - 1.0D;
/*  57 */     } else if (vx < 0.0D) {
/*  58 */       targetX = ((tx << 6) + 64 + 1);
/*     */     } else {
/*  60 */       targetX = x1;
/*     */     } 
/*     */     
/*  63 */     double vy = y1 - oy1;
/*     */     
/*  65 */     if (vy > 0.0D) {
/*  66 */       targetY = (ty << 6) - size - 1.0D;
/*  67 */     } else if (vy < 0.0D) {
/*  68 */       targetY = ((ty << 6) + 64 + 1);
/*     */     } else {
/*  70 */       targetY = y1;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  75 */     if (vy == 0.0D && vx == 0.0D) {
/*  76 */       GAME.Notify("entity stuck in tile, but havent moved " + tx + " " + ty);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*  87 */     else if (vx == 0.0D) {
/*  88 */       p.hitbox.moveY1(targetY);
/*  89 */       if (vy * a.speed.nY() > 0.0D) {
/*  90 */         double m = Math.abs(a.speed.y() * p.getMass());
/*  91 */         double m2 = attack(tx, ty, m, a);
/*  92 */         boolean broken = (m2 < m);
/*  93 */         if (a.collideTile(broken, 0.0D, ((vy < 0.0D) ? -1 : true), m2 * a.physics.massI, tx, ty)) {
/*  94 */           if (broken) {
/*  95 */             double ny = m2 * p.getMassI();
/*  96 */             if (a.speed.nY() < 0.0D)
/*  97 */               ny = -ny; 
/*  98 */             a.speed.setRaw(a.speed.x(), ny);
/*     */           } else {
/* 100 */             a.speed.setRaw(a.speed.x(), -a.speed.y() * p.getRestitution());
/*     */           } 
/* 102 */         } else if (!broken) {
/* 103 */           a.speed.magnitudeInit(0.0D);
/*     */         }
/*     */       
/*     */       } 
/* 107 */     } else if (vy == 0.0D) {
/* 108 */       p.hitbox.moveX1(targetX);
/* 109 */       if (vx * a.speed.nX() > 0.0D) {
/* 110 */         double m = Math.abs(a.speed.x() * p.getMass());
/* 111 */         double m2 = attack(tx, ty, m, a);
/* 112 */         boolean broken = (m2 < m);
/* 113 */         if (a.collideTile(broken, ((vx < 0.0D) ? -1 : true), 0.0D, m2 * a.physics.massI, tx, ty)) {
/* 114 */           if (broken) {
/* 115 */             double nx = m2 * p.getMassI();
/* 116 */             if (a.speed.nX() < 0.0D)
/* 117 */               nx = -nx; 
/* 118 */             a.speed.setRaw(nx, a.speed.y());
/*     */           } else {
/* 120 */             a.speed.setRaw(-a.speed.x() * p.getRestitution(), a.speed.y());
/*     */           } 
/* 122 */         } else if (!broken) {
/* 123 */           a.speed.magnitudeInit(0.0D);
/*     */         } 
/*     */       } 
/*     */     } else {
/* 127 */       double dx = targetX - x1;
/* 128 */       double dy = targetY - y1;
/* 129 */       double xx = Math.abs(dx / vx);
/* 130 */       double yy = Math.abs(dy / vy);
/* 131 */       if (xx == yy) {
/* 132 */         p.hitbox.moveX1(targetX);
/* 133 */         p.hitbox.moveY1(targetY);
/* 134 */         double mres = 0.0D;
/* 135 */         double sx = a.speed.x();
/* 136 */         double sy = a.speed.y();
/* 137 */         if (vx * a.speed.nX() > 0.0D) {
/* 138 */           double m = Math.abs(a.speed.x() * p.getMass());
/* 139 */           double m2 = attack(tx, ty, m, a);
/* 140 */           if (m2 < m) {
/* 141 */             if (a.speed.x() < 0.0D)
/* 142 */               m2 *= -1.0D; 
/* 143 */             mres += m2;
/* 144 */             sx = m2 * p.getMassI();
/*     */           } else {
/* 146 */             mres += m;
/* 147 */             sx = -a.speed.x() * p.getRestitution();
/*     */           } 
/*     */         } 
/* 150 */         if (vy * a.speed.nY() > 0.0D) {
/* 151 */           double m = Math.abs(a.speed.y() * p.getMass());
/* 152 */           double m2 = attack(tx, ty, m, a);
/* 153 */           if (m2 < m) {
/* 154 */             if (a.speed.y() < 0.0D)
/* 155 */               m2 *= -1.0D; 
/* 156 */             sy = m2 * p.getMassI();
/* 157 */             mres += m2;
/*     */           } else {
/* 159 */             sy = -a.speed.y() * p.getRestitution();
/* 160 */             mres += m;
/*     */           } 
/*     */         } 
/*     */         
/* 164 */         if (a.collideTile(false, ((vx < 0.0D) ? -1 : true), ((vy < 0.0D) ? -1 : true), mres * a.physics.massI, tx, ty)) {
/* 165 */           a.speed.setRaw(sx, sy);
/*     */         } else {
/* 167 */           a.speed.magnitudeInit(0.0D);
/*     */         }
/*     */       
/* 170 */       } else if (xx < yy) {
/* 171 */         p.hitbox.moveX1(targetX);
/* 172 */         double d = xx / yy;
/* 173 */         p.hitbox.incrY(-vy * d);
/* 174 */         if (vx * a.speed.nX() > 0.0D) {
/*     */           
/* 176 */           double m = Math.abs(a.speed.x() * p.getMass());
/* 177 */           double m2 = attack(tx, ty, m, a);
/* 178 */           boolean broken = (m2 < m);
/* 179 */           if (a.collideTile(broken, ((vx < 0.0D) ? -1 : true), 0.0D, m2 * a.physics.massI, tx, ty)) {
/* 180 */             if (broken) {
/* 181 */               double nx = m2 * p.getMassI();
/* 182 */               if (a.speed.nX() < 0.0D)
/* 183 */                 nx = -nx; 
/* 184 */               a.speed.setRaw(nx, a.speed.y());
/*     */             } else {
/* 186 */               a.speed.setRaw(-a.speed.x() * p.getRestitution(), a.speed.y());
/*     */             } 
/* 188 */           } else if (!broken) {
/* 189 */             a.speed.magnitudeInit(0.0D);
/*     */           } 
/*     */         } 
/*     */       } else {
/*     */         
/* 194 */         p.hitbox.moveY1(targetY);
/* 195 */         double d = yy / xx;
/* 196 */         p.hitbox.incrX(-vx * d);
/* 197 */         p.hitbox.moveY1(targetY);
/* 198 */         if (vy * a.speed.nY() > 0.0D) {
/*     */           
/* 200 */           double m = Math.abs(a.speed.y() * p.getMass());
/* 201 */           double m2 = attack(tx, ty, m, a);
/* 202 */           boolean broken = (m2 < m);
/* 203 */           if (a.collideTile(broken, 0.0D, ((vy < 0.0D) ? -1 : true), m2 * a.physics.massI, tx, ty)) {
/* 204 */             if (broken) {
/* 205 */               double ny = m2 * p.getMassI();
/* 206 */               if (a.speed.nY() < 0.0D)
/* 207 */                 ny = -ny; 
/* 208 */               a.speed.setRaw(a.speed.x(), ny);
/*     */             } else {
/* 210 */               a.speed.setRaw(a.speed.x(), -a.speed.y() * p.getRestitution());
/*     */             } 
/* 212 */           } else if (!broken) {
/* 213 */             a.speed.magnitudeInit(0.0D);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean collides(int tx, int ty, ENTITY e) {
/* 223 */     AVAILABILITY a = map().getAvailability(tx, ty);
/* 224 */     if (!a.tileCollide)
/* 225 */       return false; 
/* 226 */     if (e instanceof Humanoid) {
/* 227 */       return a.isSolid(((Humanoid)e).indu().army());
/*     */     }
/* 229 */     return (a.player < 0.0D);
/*     */   }
/*     */   
/*     */   private static boolean resolve(ENTITY a, EPHYSICS.Solid p) {
/* 233 */     int tx1 = p.hitbox.x1() >> 6;
/* 234 */     int ty1 = p.hitbox.y1() >> 6;
/* 235 */     int tx2 = p.hitbox.x2() >> 6;
/* 236 */     int ty2 = p.hitbox.y2() >> 6;
/* 237 */     if (tx1 == p.tx1 && ty1 == p.ty1 && tx2 == p.tx2 && ty2 == p.ty2) {
/* 238 */       return false;
/*     */     }
/*     */     
/* 241 */     if (collides(tx1, ty1, a)) {
/* 242 */       resolve(tx1, ty1, a, p);
/* 243 */       return true;
/*     */     } 
/* 245 */     if (tx1 != tx2 && collides(tx2, ty1, a)) {
/* 246 */       resolve(tx2, ty1, a, p);
/* 247 */       return true;
/*     */     } 
/* 249 */     if (ty1 != ty2 && collides(tx1, ty2, a)) {
/* 250 */       resolve(tx1, ty2, a, p);
/* 251 */       return true;
/*     */     } 
/* 253 */     if (tx1 != tx2 && ty1 != ty2 && collides(tx2, ty2, a)) {
/* 254 */       resolve(tx2, ty2, a, p);
/* 255 */       return true;
/*     */     } 
/*     */     
/* 258 */     p.tx1 = (short)tx1;
/* 259 */     p.ty1 = (short)ty1;
/* 260 */     p.tx2 = (short)tx2;
/* 261 */     p.ty2 = (short)ty2;
/*     */     
/* 263 */     if ((map().getAvailability(p.tileC().x(), p.tileC().y())).player < 0.0D) {
/* 264 */       a.collideUnconnected();
/*     */     }
/* 266 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean collide(ENTITY a) {
/* 271 */     EPHYSICS.Solid p = a.physics;
/*     */     
/* 273 */     if (resolve(a, p)) {
/*     */       
/* 275 */       int i = 0;
/* 276 */       while (resolve(a, p)) {
/* 277 */         i++;
/* 278 */         if (i > 4) {
/* 279 */           GAME.Notify("killing trapped entity... solong " + String.valueOf(a.physics.tileC()));
/* 280 */           a.helloMyNameIsInigoMontoyaYouKilledMyFatherPrepareToDie();
/* 281 */           return false;
/*     */         } 
/*     */       } 
/*     */       
/* 285 */       int tx1 = p.hitbox.x1() >> 6;
/* 286 */       int ty1 = p.hitbox.y1() >> 6;
/* 287 */       int tx2 = p.hitbox.x2() >> 6;
/* 288 */       int ty2 = p.hitbox.y2() >> 6;
/*     */       
/* 290 */       p.tx1 = (short)tx1;
/* 291 */       p.ty1 = (short)ty1;
/* 292 */       p.tx2 = (short)tx2;
/* 293 */       p.ty2 = (short)ty2;
/* 294 */       return true;
/*     */     } 
/*     */     
/* 297 */     return false;
/*     */   }
/*     */   
/*     */   private static PATHING map() {
/* 301 */     return SETT.PATH();
/*     */   }
/*     */ 
/*     */   
/*     */   static boolean trapped(ENTITY a) {
/* 306 */     EPHYSICS.Solid p = a.physics;
/*     */     
/* 308 */     int cx = p.hitbox.cX();
/* 309 */     int cy = p.hitbox.cY();
/* 310 */     int tx = cx >> 6;
/* 311 */     int ty = cy >> 6;
/* 312 */     int index = 0;
/*     */     
/* 314 */     while (index < GUTIL.circle().length()) {
/* 315 */       index++;
/* 316 */       if (GUTIL.circle().radius(index) > 10)
/*     */         break; 
/* 318 */       COORDINATE c = GUTIL.circle().get(index);
/* 319 */       int dx = c.x() + tx;
/* 320 */       int dy = c.y() + ty;
/* 321 */       if (!SETT.IN_BOUNDS(dx, dy))
/*     */         continue; 
/* 323 */       if (!collides(dx, dy, a)) {
/*     */ 
/*     */         
/* 326 */         p.hitbox.moveC(((dx << 6) + 32), ((dy << 6) + 32));
/*     */         
/* 328 */         double norX = (dx - tx);
/* 329 */         double norY = (dy - ty);
/*     */         
/* 331 */         p.hitbox.moveC(((dx << 6) + 32), ((dy << 6) + 32));
/*     */         
/* 333 */         if (norX < 0.0D) {
/*     */           
/* 335 */           norX = -1.0D;
/* 336 */         } else if (norX > 0.0D) {
/*     */           
/* 338 */           norX = 1.0D;
/*     */         } 
/* 340 */         if (norY < 0.0D) {
/*     */           
/* 342 */           norY = -1.0D;
/* 343 */         } else if (norY > 0.0D) {
/*     */           
/* 345 */           norY = 1.0D;
/*     */         } 
/*     */         
/* 348 */         if (norX != 0.0D && norY != 0.0D) {
/* 349 */           norX *= C.SQR2I;
/* 350 */           norY *= C.SQR2I;
/*     */         } 
/*     */         
/* 353 */         a.collideTile(false, norX, norY, 0.0D, tx, ty);
/*     */         
/* 355 */         int tx1 = p.hitbox.x1() >> 6;
/* 356 */         int ty1 = p.hitbox.y1() >> 6;
/* 357 */         int tx2 = p.hitbox.x2() >> 6;
/* 358 */         int ty2 = p.hitbox.y2() >> 6;
/*     */         
/* 360 */         p.tx1 = (short)tx1;
/* 361 */         p.ty1 = (short)ty1;
/* 362 */         p.tx2 = (short)tx2;
/* 363 */         p.ty2 = (short)ty2;
/* 364 */         return true;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 369 */     System.err.println("killing trapped entity... solong");
/* 370 */     a.helloMyNameIsInigoMontoyaYouKilledMyFatherPrepareToDie();
/* 371 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\ResolverTile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */