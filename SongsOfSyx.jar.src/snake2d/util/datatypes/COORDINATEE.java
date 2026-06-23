/*     */ package snake2d.util.datatypes;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public interface COORDINATEE
/*     */   extends COORDINATE {
/*     */   boolean set(double paramDouble1, double paramDouble2);
/*     */   
/*     */   void xSet(double paramDouble);
/*     */   
/*     */   void ySet(double paramDouble);
/*     */   
/*     */   default boolean set(COORDINATE other) {
/*  14 */     return set(other.x(), other.y());
/*     */   }
/*     */ 
/*     */   
/*     */   void xIncrement(double paramDouble);
/*     */ 
/*     */   
/*     */   void yIncrement(double paramDouble);
/*     */ 
/*     */   
/*     */   void increment(COORDINATE paramCOORDINATE);
/*     */ 
/*     */   
/*     */   void increment(double paramDouble1, double paramDouble2);
/*     */ 
/*     */   
/*     */   void increment(COORDINATE paramCOORDINATE, double paramDouble);
/*     */ 
/*     */   
/*     */   void xInvert();
/*     */   
/*     */   void yInvert();
/*     */   
/*     */   void xMakePos();
/*     */   
/*     */   void xMakeNeg();
/*     */   
/*     */   void yMakePos();
/*     */   
/*     */   void yMakeNeg();
/*     */   
/*     */   void scale(double paramDouble1, double paramDouble2);
/*     */   
/*     */   void deScale(double paramDouble1, double paramDouble2);
/*     */   
/*     */   boolean isZero();
/*     */   
/*     */   public static abstract class Abs
/*     */     implements COORDINATEE
/*     */   {
/*     */     public boolean set(double x, double y) {
/*  55 */       if (x == x() && y == y()) {
/*  56 */         xSet(x);
/*  57 */         ySet(y);
/*  58 */         return false;
/*     */       } 
/*  60 */       xSet(x);
/*  61 */       ySet(y);
/*  62 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void xIncrement(double amount) {
/*  67 */       xSet(x() + amount);
/*     */     }
/*     */ 
/*     */     
/*     */     public void yIncrement(double amount) {
/*  72 */       ySet(y() + amount);
/*     */     }
/*     */ 
/*     */     
/*     */     public void increment(COORDINATE other) {
/*  77 */       increment(other.x(), other.y());
/*     */     }
/*     */ 
/*     */     
/*     */     public void increment(double x, double y) {
/*  82 */       xIncrement(x);
/*  83 */       yIncrement(y);
/*     */     }
/*     */ 
/*     */     
/*     */     public void increment(COORDINATE other, double factor) {
/*  88 */       increment(other.x() * factor, other.y() * factor);
/*     */     }
/*     */ 
/*     */     
/*     */     public void xInvert() {
/*  93 */       xSet(-x());
/*     */     }
/*     */ 
/*     */     
/*     */     public void yInvert() {
/*  98 */       ySet(-y());
/*     */     }
/*     */ 
/*     */     
/*     */     public void xMakePos() {
/* 103 */       if (x() < 0) {
/* 104 */         xInvert();
/*     */       }
/*     */     }
/*     */     
/*     */     public void xMakeNeg() {
/* 109 */       if (x() > 0) {
/* 110 */         xInvert();
/*     */       }
/*     */     }
/*     */     
/*     */     public void yMakePos() {
/* 115 */       if (y() < 0) {
/* 116 */         yInvert();
/*     */       }
/*     */     }
/*     */     
/*     */     public void yMakeNeg() {
/* 121 */       if (y() > 0) {
/* 122 */         yInvert();
/*     */       }
/*     */     }
/*     */     
/*     */     public void scale(double xScale, double yScale) {
/* 127 */       set(x() * xScale, y() * yScale);
/*     */     }
/*     */ 
/*     */     
/*     */     public void deScale(double factorX, double factorY) {
/* 132 */       increment(-x() * factorX, -y() * factorY);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isZero() {
/* 137 */       return (x() == 0 && y() == 0);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Imp
/*     */     implements Serializable, COORDINATEE
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     private double X;
/*     */     private double Y;
/*     */     
/*     */     public Imp() {
/* 149 */       this(0.0D, 0.0D);
/*     */     }
/*     */     
/*     */     public Imp(double x, double y) {
/* 153 */       this.X = x;
/* 154 */       this.Y = y;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean set(double x, double y) {
/* 159 */       boolean ret = !(x == x() && y == y());
/* 160 */       this.X = x;
/* 161 */       this.Y = y;
/* 162 */       return ret;
/*     */     }
/*     */ 
/*     */     
/*     */     public void xSet(double x) {
/* 167 */       set(x, this.Y);
/*     */     }
/*     */ 
/*     */     
/*     */     public void ySet(double y) {
/* 172 */       set(this.X, y);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean set(COORDINATE other) {
/* 177 */       return set(other.x(), other.y());
/*     */     }
/*     */ 
/*     */     
/*     */     public void xIncrement(double amount) {
/* 182 */       xSet(this.X + amount);
/*     */     }
/*     */ 
/*     */     
/*     */     public void yIncrement(double amount) {
/* 187 */       ySet(this.Y + amount);
/*     */     }
/*     */ 
/*     */     
/*     */     public void increment(COORDINATE other) {
/* 192 */       increment(other.x(), other.y());
/*     */     }
/*     */ 
/*     */     
/*     */     public void increment(double x, double y) {
/* 197 */       xSet(this.X + x);
/* 198 */       ySet(this.Y + y);
/*     */     }
/*     */ 
/*     */     
/*     */     public void increment(COORDINATE other, double factor) {
/* 203 */       increment(other.x() * factor, other.y() * factor);
/*     */     }
/*     */ 
/*     */     
/*     */     public void xInvert() {
/* 208 */       xSet(-this.X);
/*     */     }
/*     */ 
/*     */     
/*     */     public void yInvert() {
/* 213 */       ySet(-this.Y);
/*     */     }
/*     */ 
/*     */     
/*     */     public void xMakePos() {
/* 218 */       if (this.X < 0.0D) {
/* 219 */         xSet(-this.X);
/*     */       }
/*     */     }
/*     */     
/*     */     public void xMakeNeg() {
/* 224 */       if (this.X > 0.0D) {
/* 225 */         xSet(-this.X);
/*     */       }
/*     */     }
/*     */     
/*     */     public void yMakePos() {
/* 230 */       if (this.Y < 0.0D) {
/* 231 */         ySet(-this.Y);
/*     */       }
/*     */     }
/*     */     
/*     */     public void yMakeNeg() {
/* 236 */       if (this.Y > 0.0D) {
/* 237 */         ySet(-this.Y);
/*     */       }
/*     */     }
/*     */     
/*     */     public void scale(double xScale, double yScale) {
/* 242 */       set(this.X * xScale, this.Y * yScale);
/*     */     }
/*     */ 
/*     */     
/*     */     public void deScale(double factorX, double factorY) {
/* 247 */       set(this.X - this.X * factorX, this.Y - this.Y * factorY);
/*     */     }
/*     */ 
/*     */     
/*     */     public int x() {
/* 252 */       return (int)this.X;
/*     */     }
/*     */ 
/*     */     
/*     */     public int y() {
/* 257 */       return (int)this.Y;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 262 */       return String.valueOf(getClass().getName()) + " x:" + this.X + " y:" + this.Y;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isZero() {
/* 267 */       return (x() == 0 && y() == 0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\datatypes\COORDINATEE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */