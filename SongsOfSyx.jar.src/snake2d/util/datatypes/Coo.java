/*     */ package snake2d.util.datatypes;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ public class Coo
/*     */   implements Serializable, COORDINATEE, SAVABLE
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  13 */   public static final Coo TMP = new Coo();
/*  14 */   public static final Coo TMP2 = new Coo();
/*     */   
/*     */   double X;
/*     */   double Y;
/*     */   
/*     */   public Coo() {
/*  20 */     this(0.0D, 0.0D);
/*     */   }
/*     */   
/*     */   public Coo(COORDINATE c) {
/*  24 */     this(c.x(), c.y());
/*     */   }
/*     */   
/*     */   public Coo(double x, double y) {
/*  28 */     this.X = x;
/*  29 */     this.Y = y;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean set(double x, double y) {
/*  34 */     boolean ret = !(x == this.X && y == this.Y);
/*  35 */     this.X = x;
/*  36 */     this.Y = y;
/*  37 */     return ret;
/*     */   }
/*     */   public void xSet(double x) {
/*  40 */     this.X = x;
/*     */   } public void ySet(double y) {
/*  42 */     this.Y = y;
/*     */   }
/*     */   public boolean set(COORDINATE other) {
/*  45 */     return set(other.x(), other.y());
/*     */   }
/*     */   public void xIncrement(double amount) {
/*  48 */     this.X += amount;
/*     */   } public void yIncrement(double amount) {
/*  50 */     this.Y += amount;
/*     */   }
/*     */   public void increment(COORDINATE other) {
/*  53 */     this.X += other.x();
/*  54 */     this.Y += other.y();
/*     */   }
/*     */   
/*     */   public void increment(double x, double y) {
/*  58 */     this.X += x;
/*  59 */     this.Y += y;
/*     */   }
/*     */   
/*     */   public void increment(COORDINATE other, double factor) {
/*  63 */     this.X += other.x() * factor;
/*  64 */     this.Y += other.y() * factor;
/*     */   }
/*     */   
/*     */   public void xInvert() {
/*  68 */     this.X *= -1.0D;
/*     */   } public void yInvert() {
/*  70 */     this.Y *= -1.0D;
/*     */   } public void xMakePos() {
/*  72 */     if (this.X < 0.0D) this.X = -this.X; 
/*     */   } public void xMakeNeg() {
/*  74 */     if (this.X > 0.0D) this.X = -this.X; 
/*     */   } public void yMakePos() {
/*  76 */     if (this.Y < 0.0D) this.Y = -this.Y; 
/*     */   } public void yMakeNeg() {
/*  78 */     if (this.Y > 0.0D) this.Y = -this.Y; 
/*     */   }
/*     */   
/*     */   public void scale(double xScale, double yScale) {
/*  82 */     this.X *= xScale;
/*  83 */     this.Y *= yScale;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void deScale(double factorX, double factorY) {
/*  93 */     this.X -= this.X * factorX;
/*  94 */     this.Y -= this.Y * factorY;
/*     */   }
/*     */   
/*     */   public int x() {
/*  98 */     return (int)this.X;
/*     */   } public int y() {
/* 100 */     return (int)this.Y;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 104 */     return String.valueOf(getClass().getSimpleName()) + " --> (" + this.X + ", " + this.Y + ")";
/*     */   }
/*     */   
/*     */   public void decrease(double amountX, double amountY) {
/* 108 */     if (this.X < -amountX) {
/* 109 */       this.X += amountX;
/* 110 */     } else if (this.X > amountX) {
/* 111 */       this.X -= amountX;
/*     */     } else {
/* 113 */       this.X = 0.0D;
/*     */     } 
/* 115 */     if (this.Y < -amountY) {
/* 116 */       this.Y += amountY;
/* 117 */     } else if (this.Y > amountY) {
/* 118 */       this.Y -= amountY;
/*     */     } else {
/* 120 */       this.Y = 0.0D;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isZero() {
/* 126 */     return (x() == 0 && y() == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 131 */     file.d(this.X);
/* 132 */     file.d(this.Y);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 137 */     this.X = file.d();
/* 138 */     this.Y = file.d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 143 */     this.X = -1.0D;
/* 144 */     this.Y = -1.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\datatypes\Coo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */