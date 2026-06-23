/*     */ package snake2d.util.light;
/*     */ 
/*     */ import snake2d.CORE;
/*     */ import snake2d.util.color.RGB;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AmbientLight
/*     */   extends RGB.RGBImp
/*     */   implements LIGHT_AMBIENT
/*     */ {
/*  14 */   public static final AmbientLight Strongmoonlight = new AmbientLight(1.0D, 1.0D, 1.2999999523162842D, 135.0F, 35.0F);
/*  15 */   public static final AmbientLight none = new AmbientLight(0.0D, 0.0D, 0.0D, 90.0F, 90.0F);
/*  16 */   public static final AmbientLight full = new AmbientLight(1.0D, 1.0D, 1.0D, 0.0F, 90.0F);
/*     */   
/*     */   private double tilt;
/*     */   
/*     */   private double direction;
/*     */   
/*     */   private float dirX;
/*     */   
/*     */   private float dirY;
/*     */   private float dirZ;
/*     */   
/*     */   public AmbientLight() {
/*  28 */     setDir(0.0D);
/*  29 */     setTilt(90.0D);
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
/*     */   public AmbientLight(double d, double e, double f, float direction, float tilt) {
/*  43 */     r((float)d);
/*  44 */     g((float)e);
/*  45 */     b((float)f);
/*  46 */     setDir(direction);
/*  47 */     setTilt(tilt);
/*     */   }
/*     */   
/*     */   public AmbientLight Set(AmbientLight other, double i) {
/*  51 */     copy(other).shade(i);
/*     */     
/*  53 */     this.tilt = other.tilt;
/*  54 */     this.direction = other.direction;
/*  55 */     this.dirX = other.dirX;
/*  56 */     this.dirY = other.dirY;
/*  57 */     this.dirZ = other.dirZ;
/*  58 */     return this;
/*     */   }
/*     */   
/*     */   public void setFullLight() {
/*  62 */     set(1.0D, 1.0D, 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AmbientLight r(double red) {
/*  68 */     super.r(red);
/*  69 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public AmbientLight g(double green) {
/*  74 */     super.g(green);
/*  75 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public AmbientLight b(double blue) {
/*  80 */     super.b(blue);
/*  81 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AmbientLight setDir(double deg) {
/*  89 */     this.direction = deg;
/*  90 */     calc();
/*  91 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getTilt() {
/*  98 */     return this.tilt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AmbientLight setTilt(double tilt2) {
/* 106 */     if (tilt2 < -90.0D) {
/* 107 */       tilt2 = -90.0D;
/* 108 */     } else if (tilt2 > 90.0D) {
/* 109 */       tilt2 = 90.0D;
/* 110 */     }  this.tilt = tilt2;
/* 111 */     calc();
/* 112 */     return this;
/*     */   }
/*     */   
/*     */   public double getDir() {
/* 116 */     return this.direction;
/*     */   }
/*     */ 
/*     */   
/*     */   private void calc() {
/* 121 */     this.dirZ = (float)Math.sin(Math.toRadians(this.tilt));
/*     */     
/* 123 */     float q = (float)Math.cos(Math.toRadians(this.tilt));
/*     */     
/* 125 */     this.dirX = q * (float)Math.cos(Math.toRadians(this.direction));
/* 126 */     this.dirY = q * (float)Math.sin(Math.toRadians(this.direction));
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
/*     */   public void register(RECTANGLE r) {
/* 138 */     register(r.x1(), r.x2(), r.y1(), r.y2());
/*     */   }
/*     */   
/*     */   public void register(int x1, int x2, int y1, int y2) {
/* 142 */     CORE.renderer().registerAmbient(this, x1, x2, y1, y2);
/*     */   }
/*     */ 
/*     */   
/*     */   public float x() {
/* 147 */     return this.dirX;
/*     */   }
/*     */ 
/*     */   
/*     */   public float y() {
/* 152 */     return this.dirY;
/*     */   }
/*     */ 
/*     */   
/*     */   public float z() {
/* 157 */     return this.dirZ;
/*     */   }
/*     */   
/*     */   public void interpolate(AmbientLight from, AmbientLight to, double part) {
/* 161 */     interpolate(from, to, part);
/* 162 */     from.tilt += (to.tilt - from.tilt) * part;
/* 163 */     from.direction += (to.direction - from.direction) * part;
/* 164 */     calc();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\light\AmbientLight.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */