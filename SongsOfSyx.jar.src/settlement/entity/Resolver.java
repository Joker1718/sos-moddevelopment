/*     */ package settlement.entity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Resolver
/*     */ {
/*   9 */   private final ECollision ca = new ECollision();
/*  10 */   private final ECollision cb = new ECollision();
/*     */ 
/*     */ 
/*     */   
/*     */   void resolveCollision(ENTITY a, ENTITY b) {
/*  15 */     if (!a.collidesWithOthers(b) || !b.collidesWithOthers(a)) {
/*  16 */       a.meet(b);
/*  17 */       b.meet(a);
/*     */       
/*     */       return;
/*     */     } 
/*  21 */     if (!a.willCollideWith(b) && !b.willCollideWith(a)) {
/*  22 */       a.meet(b);
/*  23 */       b.meet(a);
/*     */       
/*     */       return;
/*     */     } 
/*  27 */     double ya1 = a.physics.getZ();
/*  28 */     double ya2 = ya1 + a.physics.getHeight();
/*  29 */     double yb1 = b.physics.getZ();
/*  30 */     double yb2 = yb1 + b.physics.getHeight();
/*     */     
/*  32 */     if (ya1 > yb2 || ya2 < yb1) {
/*     */       return;
/*     */     }
/*     */     
/*  36 */     double distX = (b.body().cX() - a.body().cX());
/*  37 */     double distY = (b.body().cY() - a.body().cY());
/*     */ 
/*     */     
/*  40 */     double norLength = Math.sqrt(distX * distX + distY * distY);
/*     */     
/*  42 */     if (norLength == 0.0D) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  49 */     double norX = distX / norLength;
/*  50 */     double norY = distY / norLength;
/*     */     
/*  52 */     double mA = a.physics.getMass();
/*  53 */     double mB = b.physics.getMass();
/*     */     
/*  55 */     if (mA <= 0.0D || mB <= 0.0D) {
/*     */       return;
/*     */     }
/*  58 */     ESpeed.Imp va = a.speed;
/*  59 */     ESpeed.Imp vb = b.speed;
/*  60 */     double vAX = va.x();
/*  61 */     double vAY = va.y();
/*  62 */     double vBX = vb.x();
/*  63 */     double vBY = vb.y();
/*     */     
/*  65 */     double dVX = vBX - vAX;
/*  66 */     double dVY = vBY - vAY;
/*  67 */     if (dVX * norX > 0.0D && dVY * norY > 0.0D) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  73 */     double momX = (dVX * norX < 0.0D) ? dVX : 0.0D;
/*  74 */     double momY = (dVY * norY < 0.0D) ? dVY : 0.0D;
/*     */     
/*  76 */     double mom = Math.sqrt(momX * momX + momY * momY);
/*     */     
/*  78 */     double speedDotA = (1.0D + a.speed.dir().xN() * norX + a.speed.dir().yN() * norY) * 0.5D;
/*  79 */     double speedDotB = (1.0D - b.speed.dir().xN() * norX - b.speed.dir().yN() * norY) * 0.5D;
/*  80 */     this.ca.other = b;
/*  81 */     this.ca.dirDot = speedDotA;
/*  82 */     this.ca.dirDotOther = speedDotB;
/*  83 */     this.ca.norX = norX;
/*  84 */     this.ca.norY = norY;
/*  85 */     this.ca.tileMomentum = 0.0D;
/*  86 */     this.ca.damagetileStrength = 0.0D;
/*  87 */     this.ca.speedHasChanged = false;
/*  88 */     this.ca.leave = null;
/*     */ 
/*     */ 
/*     */     
/*  92 */     this.cb.other = a;
/*  93 */     this.cb.dirDot = speedDotB;
/*  94 */     this.cb.dirDotOther = speedDotA;
/*  95 */     this.cb.norX = -norX;
/*  96 */     this.cb.norY = -norY;
/*  97 */     this.cb.tileMomentum = 0.0D;
/*  98 */     this.cb.damagetileStrength = 0.0D;
/*  99 */     this.cb.speedHasChanged = false;
/* 100 */     this.cb.leave = null;
/*     */ 
/*     */     
/* 103 */     a.setCollideDamage(this.ca, this.cb);
/* 104 */     b.setCollideDamage(this.cb, this.ca);
/*     */     
/* 106 */     if (mom > 0.0D) {
/*     */       
/* 108 */       mom *= 1.0D + (a.physics.getRestitution() + b.physics.getRestitution()) * 0.5D;
/*     */       
/* 110 */       if (mA <= 0.0D) {
/* 111 */         solidCollision(a, b, -norX, -norY, mA);
/* 112 */         this.ca.speedHasChanged = true;
/* 113 */         this.cb.speedHasChanged = true;
/* 114 */         this.ca.tileMomentum += mom;
/* 115 */         a.collide(this.ca);
/* 116 */         this.cb.tileMomentum += mom;
/* 117 */         b.collide(this.cb);
/*     */         return;
/*     */       } 
/* 120 */       if (mB <= 0.0D) {
/* 121 */         solidCollision(b, a, norX, norY, mB);
/* 122 */         mom *= mA;
/* 123 */         this.ca.speedHasChanged = true;
/* 124 */         this.cb.speedHasChanged = true;
/* 125 */         this.ca.tileMomentum += mom;
/* 126 */         a.collide(this.ca);
/* 127 */         this.cb.tileMomentum = mom;
/* 128 */         b.collide(this.cb);
/*     */         return;
/*     */       } 
/* 131 */       double magScale = 1.0D;
/* 132 */       if (mA > mB) {
/* 133 */         dVX /= mom;
/* 134 */         dVY /= mom;
/* 135 */         mom *= mB;
/* 136 */         magScale -= 0.3D * mB / mA;
/*     */       } else {
/* 138 */         dVX /= mom;
/* 139 */         dVY /= mom;
/* 140 */         mom *= mA;
/* 141 */         magScale -= 0.3D * mA / mB;
/*     */       } 
/*     */       
/* 144 */       collidePair(a, b, -norX, -norY, mom, dVX, dVY, magScale);
/* 145 */       this.ca.tileMomentum += mom;
/* 146 */       this.cb.tileMomentum += mom;
/* 147 */       this.ca.speedHasChanged = true;
/* 148 */       this.cb.speedHasChanged = true;
/* 149 */       a.collide(this.ca);
/* 150 */       b.collide(this.cb);
/*     */     } else {
/*     */       
/* 153 */       a.collide(this.ca);
/* 154 */       b.collide(this.cb);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void collidePair(ENTITY a, ENTITY b, double norX, double norY, double mom, double dx, double dy, double magScale) {
/* 163 */     if (mom == 0.0D) {
/* 164 */       mom = 1.0D;
/*     */     }
/* 166 */     ESpeed.Imp va = a.speed;
/* 167 */     ESpeed.Imp vb = b.speed;
/*     */     
/* 169 */     double x = mom, y = mom;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     x *= norX;
/* 175 */     y *= norY;
/*     */     
/* 177 */     va.setRaw(va.x() + x * a.physics.massI, va.y() + y * a.physics.massI);
/* 178 */     vb.setRaw(vb.x() - x * b.physics.massI, vb.y() - y * b.physics.massI);
/*     */     
/* 180 */     va.magnitudeInit(va.magnitude() * magScale);
/* 181 */     vb.magnitudeInit(vb.magnitude() * magScale);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static double solidCollision(ENTITY p, ENTITY solid, double norX, double norY, double m) {
/* 187 */     double vAX = p.speed.nX();
/* 188 */     double vAY = p.speed.nY();
/*     */ 
/*     */     
/* 191 */     if (vAX * norX + vAY * norY >= 0.0D) {
/* 192 */       return 0.0D;
/*     */     }
/* 194 */     double r = (p.physics.getRestitution() + solid.physics.getRestitution()) / 2.0D;
/* 195 */     double resX = 5.0D * norX;
/* 196 */     double resY = 5.0D * norY;
/*     */     
/* 198 */     if (vAX * norX > 0.0D) {
/* 199 */       resX -= vAX * r;
/*     */     } else {
/* 201 */       resX += vAX;
/*     */     } 
/* 203 */     if (vAY * norY > 0.0D) {
/* 204 */       resY -= vAY * r;
/*     */     } else {
/* 206 */       resY += vAY;
/*     */     } 
/*     */     
/* 209 */     p.speed.setRaw(resX, resY);
/* 210 */     double momX = vAX - resX;
/* 211 */     double momY = vAY - resY;
/* 212 */     return p.physics.getMass() * Math.sqrt(momX * momX + momY * momY);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\Resolver.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */