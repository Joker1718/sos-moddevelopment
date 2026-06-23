/*     */ package snake2d.util.datatypes;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ public class ShortCoo
/*     */   implements Serializable, COORDINATEE, SAVABLE
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private short X;
/*     */   private short Y;
/*     */   
/*     */   public ShortCoo() {
/*  17 */     this(0.0D, 0.0D);
/*     */   }
/*     */   
/*     */   public ShortCoo(double x, double y) {
/*  21 */     this.X = (short)(int)x;
/*  22 */     this.Y = (short)(int)y;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean set(double x, double y) {
/*  27 */     boolean ret = !(x == this.X && y == this.Y);
/*  28 */     this.X = (short)(int)x;
/*  29 */     this.Y = (short)(int)y;
/*  30 */     return ret;
/*     */   }
/*     */   public void xSet(double x) {
/*  33 */     this.X = (short)(int)x;
/*     */   } public void ySet(double y) {
/*  35 */     this.Y = (short)(int)y;
/*     */   }
/*     */   public boolean set(COORDINATE other) {
/*  38 */     return set(other.x(), other.y());
/*     */   }
/*     */   public void xIncrement(double amount) {
/*  41 */     this.X = (short)(int)(this.X + amount);
/*     */   } public void yIncrement(double amount) {
/*  43 */     this.Y = (short)(int)(this.Y + amount);
/*     */   }
/*     */   public void increment(COORDINATE other) {
/*  46 */     this.X = (short)(this.X + other.x());
/*  47 */     this.Y = (short)(this.Y + other.y());
/*     */   }
/*     */   
/*     */   public void increment(double x, double y) {
/*  51 */     this.X = (short)(int)(this.X + x);
/*  52 */     this.Y = (short)(int)(this.Y + y);
/*     */   }
/*     */   
/*     */   public void increment(COORDINATE other, double factor) {
/*  56 */     this.X = (short)(int)(this.X + other.x() * factor);
/*  57 */     this.Y = (short)(int)(this.Y + other.y() * factor);
/*     */   }
/*     */   
/*     */   public void xInvert() {
/*  61 */     this.X = (short)(int)(this.X * -1.0F);
/*     */   } public void yInvert() {
/*  63 */     this.Y = (short)(int)(this.Y * -1.0F);
/*     */   } public void xMakePos() {
/*  65 */     if (this.X < 0) this.X = (short)-this.X; 
/*     */   } public void xMakeNeg() {
/*  67 */     if (this.X > 0) this.X = (short)-this.X; 
/*     */   } public void yMakePos() {
/*  69 */     if (this.Y < 0) this.Y = (short)-this.Y; 
/*     */   } public void yMakeNeg() {
/*  71 */     if (this.Y > 0) this.Y = (short)-this.Y; 
/*     */   }
/*     */   
/*     */   public void scale(double xScale, double yScale) {
/*  75 */     this.X = (short)(int)(this.X * xScale);
/*  76 */     this.Y = (short)(int)(this.Y * yScale);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void deScale(double factorX, double factorY) {
/*  86 */     this.X = (short)(int)(this.X - this.X * factorX);
/*  87 */     this.Y = (short)(int)(this.Y - this.Y * factorY);
/*     */   }
/*     */   
/*     */   public int x() {
/*  91 */     return this.X;
/*     */   } public int y() {
/*  93 */     return this.Y;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     return String.valueOf(getClass().getName()) + " x:" + this.X + " y:" + this.Y;
/*     */   }
/*     */   
/*     */   public void decrease(double amountX, double amountY) {
/* 101 */     if (this.X < -amountX) {
/* 102 */       this.X = (short)(int)(this.X + amountX);
/* 103 */     } else if (this.X > amountX) {
/* 104 */       this.X = (short)(int)(this.X - amountX);
/*     */     } else {
/* 106 */       this.X = 0;
/*     */     } 
/* 108 */     if (this.Y < -amountY) {
/* 109 */       this.Y = (short)(int)(this.Y + amountY);
/* 110 */     } else if (this.Y > amountY) {
/* 111 */       this.Y = (short)(int)(this.Y - amountY);
/*     */     } else {
/* 113 */       this.Y = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isZero() {
/* 119 */     return (x() == 0 && y() == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 124 */     file.s(this.X);
/* 125 */     file.s(this.Y);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 130 */     this.X = file.s();
/* 131 */     this.Y = file.s();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 136 */     this.X = 0;
/* 137 */     this.Y = 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\datatypes\ShortCoo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */