/*     */ package snake2d.util.light;
/*     */ 
/*     */ import snake2d.CORE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PointLight
/*     */   extends Coo
/*     */   implements LIGHT_POINT
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  15 */   private float red = 3.0F;
/*  16 */   private float green = 3.0F;
/*  17 */   private float blue = 3.0F;
/*  18 */   private float z = 50.0F;
/*  19 */   private float falloff = 2.0F;
/*     */   
/*     */   private int radius;
/*     */   private int index;
/*     */   
/*     */   public PointLight() {
/*  25 */     setRadius(100);
/*     */   }
/*     */ 
/*     */   
/*     */   public PointLight(double red, double green, double blue) {
/*  30 */     setRed(red);
/*  31 */     setGreen(green);
/*  32 */     setBlue(blue);
/*  33 */     setRadius(300);
/*     */   }
/*     */ 
/*     */   
/*     */   public PointLight(double red, double green, double blue, int x, int y, int height) {
/*  38 */     setRed(red);
/*  39 */     setGreen(green);
/*  40 */     setBlue(blue);
/*  41 */     set(x, y);
/*  42 */     setRadius(300);
/*  43 */     setZ(height);
/*     */   }
/*     */ 
/*     */   
/*     */   public PointLight(double red, double green, double blue, int x, int y, int height, int radius) {
/*  48 */     setRed(red);
/*  49 */     setGreen(green);
/*  50 */     setBlue(blue);
/*  51 */     set(x, y);
/*  52 */     setRadius(radius);
/*  53 */     setZ(height);
/*     */   }
/*     */   
/*     */   public static PointLight getFlashLight() {
/*  57 */     PointLight p = new PointLight();
/*  58 */     p.setRed(3.0D);
/*  59 */     p.setGreen(3.0D);
/*  60 */     p.setBlue(3.0D);
/*  61 */     p.setZ(45);
/*  62 */     p.setRadius(300);
/*  63 */     return p;
/*     */   }
/*     */   
/*     */   public static PointLight getFlashLight2() {
/*  67 */     PointLight p = new PointLight();
/*  68 */     p.setRed(3.0D);
/*  69 */     p.setGreen(3.0D);
/*  70 */     p.setBlue(3.0D);
/*  71 */     p.setZ(145);
/*  72 */     p.setRadius(300);
/*  73 */     return p;
/*     */   }
/*     */   
/*     */   public void register() {
/*  77 */     CORE.renderer().registerLight(this, x() - this.radius, x() + this.radius, y() - this.radius, y() + this.radius);
/*     */   }
/*     */   
/*     */   public void register(byte ne, byte se, byte sw, byte nw) {
/*  81 */     CORE.renderer().registerLight(this, x() - this.radius, x() + this.radius, y() - this.radius, y() + this.radius, ne, se, sw, nw);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getRed() {
/*  87 */     return this.red;
/*     */   }
/*     */   
/*     */   public PointLight setRed(double red) {
/*  91 */     this.red = (float)red;
/*  92 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getGreen() {
/*  97 */     return this.green;
/*     */   }
/*     */   
/*     */   public PointLight setGreen(double green) {
/* 101 */     this.green = (float)green;
/* 102 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getBlue() {
/* 107 */     return this.blue;
/*     */   }
/*     */   
/*     */   public PointLight setBlue(double blue) {
/* 111 */     this.blue = (float)blue;
/* 112 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public float cz() {
/* 117 */     return this.z;
/*     */   }
/*     */   
/*     */   public void setZ(int height) {
/* 121 */     this.z = height;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getFalloff() {
/* 126 */     return this.falloff;
/*     */   }
/*     */   
/*     */   public void setFalloff(float falloff) {
/* 130 */     this.falloff = falloff;
/*     */   }
/*     */   
/*     */   public int getIndex() {
/* 134 */     return this.index;
/*     */   }
/*     */   
/*     */   public void setIndex(int index) {
/* 138 */     this.index = index;
/*     */   }
/*     */   
/*     */   public void setRadius(int radius) {
/* 142 */     this.radius = radius;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRadius() {
/* 147 */     return this.radius;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWithinRec(RECTANGLE other) {
/* 153 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public float cx() {
/* 158 */     return x();
/*     */   }
/*     */ 
/*     */   
/*     */   public float cy() {
/* 163 */     return y();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\light\PointLight.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */