/*     */ package snake2d.util.datatypes;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import snake2d.util.iterators.RECIter;
/*     */ 
/*     */ public abstract class RecFacade
/*     */   implements RECTANGLEE
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  10 */   private final RECIter inter = new RECIter(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RecFacade set(double x1, double x2, double y1, double y2) {
/*  18 */     moveX1(x1);
/*  19 */     setWidth(x2 - x1);
/*  20 */     moveY1(y1);
/*  21 */     setHeight(y2 - y1);
/*  22 */     return this;
/*     */   }
/*     */   
/*     */   public RecFacade makePositive() {
/*  26 */     int x1 = x1();
/*  27 */     int x2 = x2();
/*  28 */     int y1 = y1();
/*  29 */     int y2 = y2();
/*  30 */     if (x2 < x1) {
/*  31 */       int x = x1;
/*  32 */       x1 = x2;
/*  33 */       x2 = x;
/*     */     } 
/*     */     
/*  36 */     if (y2 < y1) {
/*  37 */       int y = y1;
/*  38 */       y1 = y2;
/*  39 */       y2 = y;
/*     */     } 
/*  41 */     return set(x1, x2, y1, y2);
/*     */   }
/*     */   
/*     */   public RecFacade set(RECTANGLE other) {
/*  45 */     moveX1(other.x1());
/*  46 */     moveY1(other.y1());
/*  47 */     setWidth(other.width());
/*  48 */     setHeight(other.height());
/*  49 */     return this;
/*     */   }
/*     */   
/*     */   public RecFacade set(BODY_HOLDER other) {
/*  53 */     set(other.body());
/*  54 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade incr(double x, double y) {
/*  59 */     incrX(x);
/*  60 */     incrY(y);
/*  61 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade incrX(double amount) {
/*  66 */     moveX1(x1() + amount);
/*  67 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade incrY(double amount) {
/*  72 */     moveY1(y1() + amount);
/*  73 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade incr(COORDINATE vector, double factor) {
/*  78 */     moveX1(x1() + vector.x() * factor);
/*  79 */     moveY1(y1() + vector.y() * factor);
/*  80 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade incr(COORDINATE vector) {
/*  85 */     incrX(vector.x());
/*  86 */     incrY(vector.y());
/*  87 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade moveX1Y1(double X, double Y) {
/*  92 */     moveX1(X);
/*  93 */     moveY1(Y);
/*  94 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade moveX2(double X2) {
/*  99 */     moveX1(X2 - width());
/* 100 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade moveY2(double Y2) {
/* 105 */     moveY1(Y2 - height());
/* 106 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade moveX1Y1(COORDINATE vector) {
/* 111 */     moveX1Y1(vector.x(), vector.y());
/* 112 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RecFacade setDim(double width, double height) {
/* 119 */     setWidth(width);
/* 120 */     setHeight(height);
/* 121 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RecFacade setDim(double dim) {
/* 127 */     setWidth(dim);
/* 128 */     setHeight(dim);
/* 129 */     return this;
/*     */   }
/*     */   
/*     */   public RecFacade setDim(DIMENSION other) {
/* 133 */     setWidth(other.width());
/* 134 */     setHeight(other.height());
/* 135 */     return this;
/*     */   }
/*     */   
/*     */   public RecFacade scale(double Xmultiplier, double Ymultiplier) {
/* 139 */     setWidth(width() * Xmultiplier);
/* 140 */     setHeight(height() * Ymultiplier);
/* 141 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade centerIn(RECTANGLE other) {
/* 146 */     centerX(other.x1(), other.x2());
/* 147 */     centerY(other.y1(), other.y2());
/* 148 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade centerIn(double x1, double x2, double y1, double y2) {
/* 153 */     centerX(x1, x2);
/* 154 */     centerY(y1, y2);
/* 155 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade centerX(double x1, double x2) {
/* 160 */     moveX1(x1 + (x2 - x1 - width()) / 2.0D);
/* 161 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade centerY(double y1, double y2) {
/* 166 */     moveY1(y1 + (y2 - y1 - height()) / 2.0D);
/* 167 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade centerX(RECTANGLE other) {
/* 172 */     centerX(other.x1(), other.x2());
/* 173 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade centerY(RECTANGLE other) {
/* 178 */     centerY(other.y1(), other.y2());
/* 179 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade moveC(COORDINATE v) {
/* 184 */     moveC(v.x(), v.y());
/* 185 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade moveC(double X, double Y) {
/* 190 */     moveX1(X - (width() / 2));
/* 191 */     moveY1(Y - (height() / 2));
/* 192 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade moveCX(double X) {
/* 197 */     moveX1(X - (width() / 2));
/* 198 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade moveCY(double Y) {
/* 203 */     moveY1(Y - (height() / 2));
/* 204 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int x2() {
/* 210 */     return x1() + width();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int y2() {
/* 217 */     return y1() + height();
/*     */   }
/*     */ 
/*     */   
/*     */   public int cX() {
/* 222 */     return x1() + width() / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int cY() {
/* 227 */     return y1() + height() / 2;
/*     */   }
/*     */   
/*     */   public RecFacade scale(double scale) {
/* 231 */     scale(scale, scale);
/* 232 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 238 */     return String.valueOf(getClass().getName()) + " x1:" + x1() + " x2:" + x2() + 
/* 239 */       " y1:" + y1() + " y2:" + y2();
/*     */   }
/*     */   
/*     */   public RecFacade incrW(double dWidth) {
/* 243 */     setWidth(width() + dWidth);
/* 244 */     return this;
/*     */   }
/*     */   
/*     */   public void incrH(double dHeight) {
/* 248 */     setHeight(height() + dHeight);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<COORDINATE> iterator() {
/* 254 */     return (Iterator<COORDINATE>)this.inter.init();
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract RecFacade setWidth(double paramDouble);
/*     */   
/*     */   public abstract RecFacade setHeight(double paramDouble);
/*     */   
/*     */   public static abstract class RecFacadePoint
/*     */     implements RECTANGLE
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/* 266 */     private final RECIter inter = new RECIter(this);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int x2() {
/* 272 */       return x1() + width();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int y2() {
/* 278 */       return y1() + height();
/*     */     }
/*     */ 
/*     */     
/*     */     public int cX() {
/* 283 */       return x1() + width() / 2;
/*     */     }
/*     */ 
/*     */     
/*     */     public int cY() {
/* 288 */       return y1() + height() / 2;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 293 */       return String.valueOf(getClass().getName()) + " x1:" + x1() + " x2:" + x2() + 
/* 294 */         " y1:" + y1() + " y2:" + y2();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Iterator<COORDINATE> iterator() {
/* 300 */       return (Iterator<COORDINATE>)this.inter.init();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\datatypes\RecFacade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */