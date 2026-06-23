/*     */ package snake2d.util.datatypes;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ public class VectorImp
/*     */   implements SAVABLE, VECTOR
/*     */ {
/*  12 */   private double x = 0.0D;
/*  13 */   private double y = -1.0D;
/*  14 */   private double magnitude = 0.0D;
/*  15 */   private DIR dir = DIR.N;
/*     */   
/*     */   public VectorImp() {}
/*     */   
/*     */   public VectorImp(double x, double y) {
/*  20 */     set(x, y);
/*     */   }
/*     */   
/*     */   public double set(double x, double y) {
/*  24 */     this.x = x;
/*  25 */     this.y = y;
/*  26 */     double d = normalize();
/*  27 */     this.dir = (DIR)DIR.ALL.get(getDirNr(this.x, this.y));
/*  28 */     return d;
/*     */   }
/*     */   
/*     */   public VectorImp set(VECTOR v) {
/*  32 */     this.x = v.nX();
/*  33 */     this.y = v.nY();
/*  34 */     this.magnitude = v.magnitude();
/*  35 */     this.dir = v.dir();
/*  36 */     return this;
/*     */   }
/*     */   
/*     */   public double set(double aX, double aY, double bX, double bY) {
/*  40 */     return set(bX - aX, bY - aY);
/*     */   }
/*     */   
/*     */   public double set(double aX, double aY, COORDINATE b) {
/*  44 */     return set(b.x() - aX, b.y() - aY);
/*     */   }
/*     */   
/*     */   public double set(COORDINATE a, COORDINATE b) {
/*  48 */     return set((b.x() - a.x()), (b.y() - a.y()));
/*     */   }
/*     */   
/*     */   public double set(RECTANGLE a, RECTANGLE b) {
/*  52 */     return set(a.cX(), a.cY(), b.cX(), b.cY());
/*     */   }
/*     */   
/*     */   public double set(RECTANGLE a, double bX, double bY) {
/*  56 */     return set(a.cX(), a.cY(), bX, bY);
/*     */   }
/*     */ 
/*     */   
/*     */   public void randomize() {
/*  61 */     setAngle((RND.rFloat() * 2.0F));
/*     */   }
/*     */   
/*     */   public void setAngle(double radians) {
/*  65 */     radians *= Math.PI;
/*  66 */     this.x = Math.sin(radians);
/*  67 */     this.y = Math.cos(radians);
/*  68 */     this.dir = (DIR)DIR.ALL.get(getDirNr(this.x, this.y));
/*     */   }
/*     */ 
/*     */   
/*     */   public double magnitude() {
/*  73 */     return this.magnitude;
/*     */   }
/*     */   
/*     */   public void setMagnitude(double m) {
/*  77 */     this.magnitude = m;
/*     */   }
/*     */ 
/*     */   
/*     */   public double nX() {
/*  82 */     return this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public double nY() {
/*  87 */     return this.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public DIR dir() {
/*  92 */     return this.dir;
/*     */   }
/*     */ 
/*     */   
/*     */   public double x() {
/*  97 */     return this.x * this.magnitude;
/*     */   }
/*     */ 
/*     */   
/*     */   public double y() {
/* 102 */     return this.y * this.magnitude;
/*     */   }
/*     */   
/*     */   public void reverseX() {
/* 106 */     this.x = -this.x;
/* 107 */     this.dir = (DIR)DIR.ALL.get(getDirNr(this.x, this.y));
/*     */   }
/*     */   
/*     */   public void reverseY() {
/* 111 */     this.y = -this.y;
/* 112 */     this.dir = (DIR)DIR.ALL.get(getDirNr(this.x, this.y));
/*     */   }
/*     */   
/*     */   private double normalize() {
/* 116 */     if (this.x == 0.0D && this.y == 0.0D) {
/* 117 */       return 0.0D;
/*     */     }
/* 119 */     double length = Math.sqrt(this.x * this.x + this.y * this.y);
/* 120 */     this.x /= length;
/* 121 */     this.y /= length;
/* 122 */     return length;
/*     */   }
/*     */   
/*     */   public void rotate(double degrees) {
/* 126 */     double radians = Math.toRadians(degrees);
/* 127 */     double sin = Math.sin(radians);
/* 128 */     double cos = Math.cos(radians);
/* 129 */     double newX = this.x * cos - this.y * sin;
/* 130 */     double newY = this.x * sin + this.y * cos;
/* 131 */     this.x = newX;
/* 132 */     this.y = newY;
/* 133 */     this.dir = (DIR)DIR.ALL.get(getDirNr(this.x, this.y));
/*     */   }
/*     */   
/*     */   public void rotateRad(double radians) {
/* 137 */     double sin = Math.sin(radians);
/* 138 */     double cos = Math.cos(radians);
/* 139 */     double newX = this.x * cos - this.y * sin;
/* 140 */     double newY = this.x * sin + this.y * cos;
/* 141 */     this.x = newX;
/* 142 */     this.y = newY;
/* 143 */     this.dir = (DIR)DIR.ALL.get(getDirNr(this.x, this.y));
/*     */   }
/*     */   
/*     */   public VectorImp rotate90() {
/* 147 */     double newX = -this.y;
/* 148 */     double newY = this.x;
/* 149 */     this.x = newX;
/* 150 */     this.y = newY;
/* 151 */     this.dir = (DIR)DIR.ALL.get(getDirNr(this.x, this.y));
/* 152 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int getDirNr(double x, double y) {
/* 157 */     double abs = Math.abs(x);
/*     */     
/* 159 */     if (abs < 0.38D) {
/* 160 */       if (y > 0.0D)
/* 161 */         return 4; 
/* 162 */       return 0;
/* 163 */     }  if (abs > 0.92D) {
/* 164 */       if (x > 0.0D)
/* 165 */         return 2; 
/* 166 */       return 6;
/* 167 */     }  if (y > 0.0D) {
/* 168 */       if (x > 0.0D)
/* 169 */         return 3; 
/* 170 */       return 5;
/*     */     } 
/* 172 */     if (x > 0.0D)
/* 173 */       return 1; 
/* 174 */     return 7;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 181 */     return "vector x: " + this.x + ", y:" + this.y + ", m:" + this.magnitude;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 186 */     file.d(this.x);
/* 187 */     file.d(this.y);
/* 188 */     file.d(this.magnitude);
/* 189 */     file.b((byte)this.dir.id());
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 194 */     this.x = file.d();
/* 195 */     this.y = file.d();
/* 196 */     this.magnitude = file.d();
/* 197 */     this.dir = (DIR)DIR.ALL.get(file.b());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 203 */     this.x = 0.0D;
/* 204 */     this.y = 0.0D;
/* 205 */     this.magnitude = 0.0D;
/* 206 */     this.dir = DIR.C;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\datatypes\VectorImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */