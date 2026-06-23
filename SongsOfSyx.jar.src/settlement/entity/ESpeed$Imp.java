/*     */ package settlement.entity;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Imp
/*     */   implements ESpeed
/*     */ {
/*  19 */   private double x = 0.0D;
/*  20 */   private double y = -1.0D;
/*  21 */   private double magnitude = 0.0D;
/*  22 */   private double targetMagnitude = 0.0D;
/*  23 */   private double acceleration = 640.0D;
/*  24 */   private double topMagnitude = 640.0D;
/*     */ 
/*     */   
/*  27 */   private DIR dir = DIR.N;
/*  28 */   private byte lastDir = (byte)this.dir.id();
/*     */   
/*     */   protected static final double AIR_REDUCER = 0.0025D;
/*     */ 
/*     */   
/*     */   public Imp accelerationInit(double a) {
/*  34 */     this.acceleration = a;
/*  35 */     return this;
/*     */   }
/*     */   
/*     */   public Imp magnitudeMaxInit(double topSpeed) {
/*  39 */     this.topMagnitude = topSpeed;
/*  40 */     return this;
/*     */   }
/*     */   
/*     */   public double magnitudeMax() {
/*  44 */     return this.topMagnitude;
/*     */   }
/*     */   
/*     */   public Imp magnitudeInit(double m) {
/*  48 */     this.magnitude = m;
/*  49 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRaw(double x, double y) {
/*  60 */     this.x = x;
/*  61 */     this.y = y;
/*  62 */     this.magnitude = normalize();
/*  63 */     setDir();
/*     */   }
/*     */   
/*     */   public void setRawNormalized(double x, double y, double magnitude) {
/*  67 */     this.x = x;
/*  68 */     this.y = y;
/*  69 */     this.magnitude = magnitude;
/*  70 */     setDir();
/*     */   }
/*     */   
/*     */   public void setRaw(DIR d, double magnitude) {
/*  74 */     this.x = d.xN();
/*  75 */     this.y = d.yN();
/*  76 */     this.magnitude = magnitude;
/*  77 */     setDirCurrent(d);
/*     */   }
/*     */   
/*     */   public Imp set(Imp master) {
/*  81 */     this.x = master.x;
/*  82 */     this.y = master.y;
/*  83 */     this.magnitude = master.magnitude;
/*  84 */     this.acceleration = master.acceleration;
/*  85 */     this.topMagnitude = master.topMagnitude;
/*  86 */     magnitudeTargetSetPrecise(master.targetMagnitude);
/*  87 */     setDirCurrent(master.dir);
/*  88 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Imp turn2(double x, double y) {
/* 100 */     double ox = this.x;
/* 101 */     double oy = this.y;
/* 102 */     this.x = x;
/* 103 */     this.y = y;
/* 104 */     normalize();
/* 105 */     setDir();
/*     */     
/* 107 */     if (this.magnitude > 0.0D) {
/* 108 */       double dot = ox * this.x + oy * this.y;
/* 109 */       dot++;
/* 110 */       dot /= 2.0D;
/* 111 */       this.magnitude *= dot;
/*     */     } 
/* 113 */     return this;
/*     */   }
/*     */   
/*     */   public Imp turn2(DIR d) {
/* 117 */     double ox = this.x;
/* 118 */     double oy = this.y;
/* 119 */     this.x = d.xN();
/* 120 */     this.y = d.yN();
/* 121 */     setDirCurrent(d);
/*     */     
/* 123 */     if (this.magnitude > 0.0D) {
/* 124 */       double dot = ox * this.x + oy * this.y;
/* 125 */       dot++;
/* 126 */       dot /= 2.0D;
/* 127 */       this.magnitude *= dot;
/*     */     } 
/* 129 */     return this;
/*     */   }
/*     */   
/*     */   public Imp turn2(BODY_HOLDER h, double x, double y) {
/* 133 */     return turn2(h.body().cX(), h.body().cY(), x, y);
/*     */   }
/*     */   
/*     */   public Imp turn2(double aX, double aY, double bX, double bY) {
/* 137 */     return turn2(bX - aX, bY - aY);
/*     */   }
/*     */   
/*     */   public Imp turn2(COORDINATE a, COORDINATE b) {
/* 141 */     return turn2((b.x() - a.x()), (b.y() - a.y()));
/*     */   }
/*     */   
/*     */   public Imp turn2(RECTANGLE a, RECTANGLE b) {
/* 145 */     return turn2(a.cX(), a.cY(), b.cX(), b.cY());
/*     */   }
/*     */   
/*     */   public Imp turnRandom() {
/* 149 */     turn2Angle((RND.rFloat() * 2.0F));
/* 150 */     return this;
/*     */   }
/*     */   
/*     */   public Imp turn2Angle(double angle) {
/* 154 */     double ox = this.x;
/* 155 */     double oy = this.y;
/* 156 */     angle *= Math.PI;
/* 157 */     this.x = Math.sin(angle);
/* 158 */     this.y = Math.cos(angle);
/* 159 */     setDir();
/* 160 */     if (this.magnitude > 0.0D) {
/* 161 */       double dot = ox * this.x + oy * this.y;
/* 162 */       dot++;
/* 163 */       dot /= 2.0D;
/* 164 */       this.magnitude *= dot;
/*     */     } 
/* 166 */     return this;
/*     */   }
/*     */   
/*     */   public Imp turnWithAngel(double degrees) {
/* 170 */     double ox = this.x;
/* 171 */     double oy = this.y;
/* 172 */     double radians = Math.toRadians(degrees);
/* 173 */     double sin = Math.sin(radians);
/* 174 */     double cos = Math.cos(radians);
/* 175 */     double newX = this.x * cos - this.y * sin;
/* 176 */     double newY = this.x * sin + this.y * cos;
/* 177 */     this.x = newX;
/* 178 */     this.y = newY;
/* 179 */     setDir();
/* 180 */     if (this.magnitude > 0.0D) {
/* 181 */       double dot = ox * this.x + oy * this.y;
/* 182 */       dot++;
/* 183 */       dot /= 2.0D;
/* 184 */       this.magnitude *= dot;
/*     */     } 
/* 186 */     return this;
/*     */   }
/*     */   
/*     */   public Imp turn90() {
/* 190 */     double newX = this.y;
/* 191 */     double newY = -this.x;
/* 192 */     this.x = newX;
/* 193 */     this.y = newY;
/* 194 */     if (this.magnitude > 0.0D) {
/* 195 */       this.magnitude *= 0.5D;
/*     */     }
/* 197 */     setDir();
/* 198 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public double magnitude() {
/* 203 */     return this.magnitude;
/*     */   }
/*     */   
/*     */   public boolean impulseBreak(double power) {
/* 207 */     this.magnitude -= this.topMagnitude * power;
/* 208 */     if (this.magnitude < 0.0D) {
/* 209 */       this.magnitude = 0.0D;
/* 210 */       return true;
/*     */     } 
/* 212 */     return (this.magnitude == 0.0D);
/*     */   }
/*     */   
/*     */   public Imp sprint(double power) {
/* 216 */     this.magnitude += this.topMagnitude * power;
/* 217 */     if (this.magnitude > this.topMagnitude)
/* 218 */       this.magnitude = this.topMagnitude; 
/* 219 */     return this;
/*     */   }
/*     */   
/*     */   public double magintudeMax() {
/* 223 */     return this.topMagnitude;
/*     */   }
/*     */   
/*     */   public double magnitudeTarget() {
/* 227 */     return this.targetMagnitude;
/*     */   }
/*     */   
/*     */   public Imp magnitudeTargetSet(double scale) {
/* 231 */     magnitudeTargetSetPrecise(scale * this.topMagnitude);
/* 232 */     return this;
/*     */   }
/*     */   
/*     */   public Imp magnitudeTargetSetPrecise(double scale) {
/* 236 */     this.targetMagnitude = scale;
/* 237 */     return this;
/*     */   }
/*     */   
/*     */   public double magnitudeRelative() {
/* 241 */     return this.magnitude / this.topMagnitude;
/*     */   }
/*     */ 
/*     */   
/*     */   public double nX() {
/* 246 */     return this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public double nY() {
/* 251 */     return this.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public DIR dir() {
/* 256 */     return this.dir;
/*     */   }
/*     */   
/*     */   private void setDir() {
/* 260 */     setDirCurrent((DIR)DIR.ALL.get(getDirNr()));
/*     */   }
/*     */   
/*     */   public Imp setDirCurrent(DIR d) {
/* 264 */     this.lastDir = (byte)this.dir.id();
/*     */     
/* 266 */     if (d == DIR.C)
/* 267 */       d = DIR.N; 
/* 268 */     this.dir = d;
/* 269 */     return this;
/*     */   }
/*     */   
/*     */   public DIR getPrevDir() {
/* 273 */     return (this.lastDir < 0) ? DIR.N : (DIR)DIR.ALL.get(this.lastDir);
/*     */   }
/*     */   
/*     */   public void setPrevDir() {
/* 277 */     setDirCurrent(getPrevDir());
/*     */   }
/*     */ 
/*     */   
/*     */   public double x() {
/* 282 */     return this.x * this.magnitude;
/*     */   }
/*     */ 
/*     */   
/*     */   public double y() {
/* 287 */     return this.y * this.magnitude;
/*     */   }
/*     */   
/*     */   public Imp reverseX() {
/* 291 */     this.x = -this.x;
/* 292 */     setDir();
/* 293 */     return this;
/*     */   }
/*     */   
/*     */   public Imp reverseY() {
/* 297 */     this.y = -this.y;
/* 298 */     setDir();
/* 299 */     return this;
/*     */   }
/*     */   
/*     */   private double normalize() {
/* 303 */     double length = Math.sqrt(this.x * this.x + this.y * this.y);
/* 304 */     if (length == 0.0D) {
/* 305 */       this.y = -1.0D;
/* 306 */       this.x = 0.0D;
/* 307 */       length = 1.0D;
/*     */     } else {
/* 309 */       this.x /= length;
/* 310 */       this.y /= length;
/*     */     } 
/* 312 */     return length;
/*     */   }
/*     */ 
/*     */   
/*     */   private int getDirNr() {
/* 317 */     double abs = Math.abs(this.x);
/*     */     
/* 319 */     if (abs < 0.38D) {
/* 320 */       if (this.y > 0.0D)
/* 321 */         return 4; 
/* 322 */       return 0;
/* 323 */     }  if (abs > 0.92D) {
/* 324 */       if (this.x > 0.0D)
/* 325 */         return 2; 
/* 326 */       return 6;
/* 327 */     }  if (this.y > 0.0D) {
/* 328 */       if (this.x > 0.0D)
/* 329 */         return 3; 
/* 330 */       return 5;
/*     */     } 
/* 332 */     if (this.x > 0.0D)
/* 333 */       return 1; 
/* 334 */     return 7;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 341 */     return "vector x: " + this.x + ", y:" + this.y + ", m:" + this.magnitude;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean magnitudeAdjust(double ds, double d, double bonus) {
/* 357 */     double min = this.topMagnitude * 0.25D;
/* 358 */     double target = this.targetMagnitude * bonus;
/* 359 */     if (target >= min && this.magnitude < min)
/* 360 */       this.magnitude = min; 
/* 361 */     if (this.magnitude < target) {
/* 362 */       this.magnitude += this.acceleration * d * ds;
/* 363 */       if (this.magnitude > target) {
/* 364 */         this.magnitude = target;
/* 365 */         return true;
/*     */       } 
/* 367 */       return false;
/* 368 */     }  if (this.magnitude > target) {
/* 369 */       this.magnitude -= this.acceleration * d * ds;
/* 370 */       if (this.magnitude < target) {
/* 371 */         this.magnitude = target;
/* 372 */         return true;
/*     */       } 
/* 374 */       return false;
/*     */     } 
/* 376 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void brake(double ds) {
/* 382 */     this.magnitude -= ds * (512.0D + this.magnitude * 0.1D);
/* 383 */     if (this.magnitude < 0.0D) {
/* 384 */       this.magnitude = 0.0D;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyAirFriction(float ds) {
/* 391 */     double m = this.magnitude * 0.0025D;
/* 392 */     this.magnitude -= m * ds;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isZero() {
/* 397 */     return (this.magnitude == 0.0D);
/*     */   }
/*     */   
/*     */   public void check() {
/* 401 */     if (!Double.isFinite(this.magnitude) || !Double.isFinite(this.x) || !Double.isFinite(this.y))
/* 402 */       throw new RuntimeException("" + this.magnitude + " " + this.magnitude + " " + this.x); 
/*     */   }
/*     */   
/*     */   public double dot(double norX, double norY) {
/* 406 */     return Math.abs(this.x * norX + this.y * norY);
/*     */   }
/*     */   
/*     */   public void save(FilePutter file) {
/* 410 */     file.d(this.x).d(this.y).d(this.magnitude).d(this.targetMagnitude).d(this.acceleration).d(this.topMagnitude);
/* 411 */     file.b((byte)this.dir.id());
/* 412 */     file.b(this.lastDir);
/*     */   }
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 416 */     this.x = file.d();
/* 417 */     this.y = file.d();
/* 418 */     this.magnitude = file.d();
/* 419 */     this.targetMagnitude = file.d();
/* 420 */     this.acceleration = file.d();
/* 421 */     this.topMagnitude = file.d();
/* 422 */     this.dir = (DIR)DIR.ALL.get(file.b());
/* 423 */     this.lastDir = file.b();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\ESpeed$Imp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */