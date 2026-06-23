/*     */ package settlement.thing.projectiles;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import snake2d.LOG;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Trajectory
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   static final double G = 640.0D;
/*     */   public static final double FRICTION = 16.0D;
/*     */   static final double ANGLE45 = 0.125D;
/*     */   private static final double ANGLE75 = 0.20833333333333334D;
/*     */   static final double ANGLEMIN60 = -0.16666666666666666D;
/*     */   static final double EMARGIN2 = 1024.0D;
/*     */   public static final int HIT_HEIGHT = 128;
/*     */   public static final int RELEASE_HEIGHT = 133;
/*     */   private double vz;
/*     */   private double vx;
/*     */   private double vy;
/*     */   private static final int TFAR = 1;
/*     */   private static final int TSHORT = -1;
/*     */   private static final int THIT = 0;
/*     */   
/*     */   public double vx() {
/*  34 */     return this.vx;
/*     */   }
/*     */   
/*     */   public double vy() {
/*  38 */     return this.vy;
/*     */   }
/*     */   
/*     */   public double vz() {
/*  42 */     return this.vz;
/*     */   }
/*     */ 
/*     */   
/*     */   public static double range(int h, double maxAngle, double velocity) {
/*  47 */     if (maxAngle > 45.0D)
/*  48 */     { maxAngle = 0.125D; }
/*  49 */     else { if (maxAngle <= 0.0D) {
/*  50 */         return 0.0D;
/*     */       }
/*  52 */       maxAngle /= 360.0D; }
/*     */ 
/*     */     
/*  55 */     return length(h, maxAngle, velocity);
/*     */   }
/*     */   
/*     */   public void set(double vx, double vy, double vz) {
/*  59 */     this.vx = vx;
/*  60 */     this.vy = vy;
/*  61 */     this.vz = vz;
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
/*     */   public boolean calcLow(int height, int startX, int startY, int destX, int destY, double maxAngle, double velocity) {
/*  75 */     double minAngle = -0.16666666666666666D;
/*  76 */     if (maxAngle > 45.0D)
/*  77 */     { maxAngle = 0.125D; }
/*  78 */     else { if (maxAngle <= 0.0D) {
/*  79 */         return false;
/*     */       }
/*  81 */       maxAngle /= 360.0D; }
/*     */ 
/*     */     
/*  84 */     double dx = (destX - startX);
/*  85 */     double dy = (destY - startY);
/*  86 */     double L2 = dx * dx + dy * dy;
/*     */     
/*  88 */     int direction = test(L2, height, maxAngle, velocity);
/*  89 */     switch (direction) { case 0:
/*  90 */         set(dx, dy, maxAngle, velocity); return true;
/*     */       case -1:
/*  92 */         return false; }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  97 */     double delta = maxAngle - minAngle;
/*  98 */     delta /= 2.0D;
/*     */ 
/*     */     
/* 101 */     minAngle -= 0.005D;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     double angle = minAngle + delta;
/*     */     
/* 108 */     direction = test(L2, height, angle, velocity);
/*     */     
/* 110 */     delta /= 2.0D;
/*     */ 
/*     */     
/* 113 */     int am = 0;
/* 114 */     while (am++ < 500) {
/* 115 */       int newDirection = test(L2, height, angle, velocity);
/*     */ 
/*     */ 
/*     */       
/* 119 */       if (newDirection == 0) {
/* 120 */         set(dx, dy, angle, velocity);
/* 121 */         if (this.vz < 0.0D && height < 0)
/* 122 */           this.vz = -this.vz; 
/* 123 */         return true;
/* 124 */       }  if (newDirection == 1) {
/* 125 */         if (angle < minAngle)
/* 126 */           return false; 
/* 127 */       } else if (newDirection == -1 && 
/* 128 */         angle > maxAngle) {
/* 129 */         return false;
/*     */       } 
/*     */       
/* 132 */       if (newDirection != direction) {
/* 133 */         direction = newDirection;
/* 134 */         delta /= 2.0D;
/*     */       } 
/*     */       
/* 137 */       angle -= direction * delta;
/*     */       
/* 139 */       if (angle < minAngle || angle > maxAngle) {
/* 140 */         return false;
/*     */       }
/*     */     } 
/* 143 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean calcHigh(int height, int startX, int startY, int destX, int destY, double maxAngle, double velocity) {
/* 148 */     if (maxAngle <= 45.0D)
/* 149 */       return false; 
/* 150 */     if (maxAngle > 75.0D) {
/* 151 */       maxAngle = 0.20833333333333334D;
/*     */     } else {
/*     */       
/* 154 */       maxAngle /= 360.0D;
/*     */     } 
/* 156 */     double minAngle = 0.125D;
/*     */     
/* 158 */     double dx = (destX - startX);
/* 159 */     double dy = (destY - startY);
/* 160 */     double L2 = dx * dx + dy * dy;
/*     */     
/* 162 */     switch (test(L2, height, 0.125D, velocity)) { case 0:
/* 163 */         set(dx, dy, 0.125D, velocity); return true;
/*     */       case -1:
/* 165 */         return false; }
/*     */ 
/*     */     
/* 168 */     switch (test(L2, height, maxAngle, velocity)) { case 0:
/* 169 */         set(dx, dy, maxAngle, velocity); return true;
/* 170 */       case 1: return false; }
/*     */ 
/*     */ 
/*     */     
/* 174 */     double delta = maxAngle - minAngle;
/* 175 */     delta /= 2.0D;
/*     */ 
/*     */     
/* 178 */     minAngle -= 0.005D;
/* 179 */     maxAngle += 0.005D;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 184 */     double angle = minAngle + delta;
/*     */     
/* 186 */     int direction = test(L2, height, angle, velocity);
/*     */     
/* 188 */     delta /= 2.0D;
/*     */ 
/*     */     
/* 191 */     int am = 0;
/* 192 */     while (am++ < 500) {
/* 193 */       int newDirection = test(L2, height, angle, velocity);
/*     */       
/* 195 */       if (newDirection == 0) {
/* 196 */         set(dx, dy, angle, velocity);
/* 197 */         if (this.vz < 0.0D && height < 0)
/* 198 */           this.vz = -this.vz; 
/* 199 */         return true;
/* 200 */       }  if (newDirection == 1) {
/* 201 */         if (angle < minAngle)
/* 202 */           return false; 
/* 203 */       } else if (newDirection == -1 && 
/* 204 */         angle > maxAngle) {
/* 205 */         return false;
/*     */       } 
/*     */       
/* 208 */       if (newDirection != direction) {
/* 209 */         direction = newDirection;
/* 210 */         delta /= 2.0D;
/*     */       } 
/*     */       
/* 213 */       angle += direction * delta;
/*     */     } 
/*     */     
/* 216 */     return false;
/*     */   }
/*     */   
/*     */   private int test(double L2, double height, double angle, double velocity) {
/* 220 */     double l = length(height, angle, velocity);
/* 221 */     double m = L2 - l * l;
/* 222 */     if (m < -1024.0D)
/* 223 */       return 1; 
/* 224 */     if (m > 1024.0D) {
/* 225 */       return -1;
/*     */     }
/* 227 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   private void set(double dx, double dy, double angle, double velocity) {
/* 232 */     this.vz = Math.sin(angle * 2.0D * Math.PI) * velocity;
/* 233 */     double v = Math.cos(angle * 2.0D * Math.PI) * velocity;
/* 234 */     double l = Math.sqrt(dx * dx + dy * dy);
/* 235 */     this.vx = v * dx / l;
/* 236 */     this.vy = v * dy / l;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static double length(double height, double angle, double velocity) {
/* 242 */     double vz = Math.sin(angle * 2.0D * Math.PI) * velocity;
/* 243 */     double v = Math.cos(angle * 2.0D * Math.PI) * velocity;
/* 244 */     double t = getTime(height, vz);
/*     */     
/* 246 */     return getLength(v, t);
/*     */   }
/*     */   
/*     */   public double getTime(double height) {
/* 250 */     return getTime(height, this.vz);
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
/*     */   public static double getTime(double height, double vz) {
/* 262 */     double a = 320.0D;
/* 263 */     double b = -vz;
/* 264 */     double c = -height;
/*     */     
/* 266 */     double discriminant = b * b - 4.0D * a * c;
/* 267 */     if (discriminant < 0.0D) return Double.NaN;
/*     */     
/* 269 */     double sqrtD = Math.sqrt(discriminant);
/*     */ 
/*     */     
/* 272 */     double t1 = (-b + sqrtD) / 2.0D * a;
/* 273 */     double t2 = (-b - sqrtD) / 2.0D * a;
/*     */ 
/*     */     
/* 276 */     if (t1 >= 0.0D && t2 >= 0.0D) return Math.max(t1, t2); 
/* 277 */     if (t1 >= 0.0D) return t1; 
/* 278 */     if (t2 >= 0.0D) return t2; 
/* 279 */     return Double.NaN;
/*     */   }
/*     */   
/*     */   public static double getRange(double v, double time, double FRICTION) {
/* 283 */     if (v <= 0.0D) return 0.0D; 
/* 284 */     return v * time - 0.5D * FRICTION * time * time;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static double getLength(double v, double time) {
/* 290 */     return time * v - 8.0D * time * time;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void debug(int i, double L2, double height, double angle, double velocity) {
/* 295 */     double vz = Math.sin(angle * 2.0D * Math.PI) * velocity;
/* 296 */     double v = Math.cos(angle * 2.0D * Math.PI) * velocity;
/* 297 */     double t = getTime(height, vz);
/* 298 */     double l = getLength(v, t);
/* 299 */     LOG.ln("" + i + " " + i + " " + (int)(angle * 360.0D) + " " + v + " " + t + " " + l);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\projectiles\Trajectory.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */