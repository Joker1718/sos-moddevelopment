/*     */ package snake2d.util.datatypes;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.iterators.RECIter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Rec
/*     */   extends RecFacade
/*     */   implements SAVABLE
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  18 */   public static final Rec TEMP = new Rec();
/*     */   
/*     */   protected double x;
/*     */   
/*     */   protected double y;
/*     */   
/*     */   protected double width;
/*     */   protected double height;
/*     */   
/*     */   public Rec() {}
/*     */   
/*     */   public Rec(FileGetter f) throws IOException {
/*  30 */     load(f);
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec(double dim) {
/*  35 */     set(0.0D, dim, 0.0D, dim);
/*     */   }
/*     */   
/*     */   public Rec(double width, double height) {
/*  39 */     set(0.0D, width, 0.0D, height);
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec(double x1, double x2, double y1, double y2) {
/*  44 */     set(x1, x2, y1, y2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rec(RECTANGLE other) {
/*  53 */     moveX1(other.x1());
/*  54 */     moveY1(other.y1());
/*  55 */     setWidth(other.width());
/*  56 */     setHeight(other.height());
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec moveX1(double X1) {
/*  61 */     this.x = X1;
/*  62 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec moveY1(double Y1) {
/*  67 */     this.y = Y1;
/*  68 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec incr(double x, double y) {
/*  73 */     incrX(x);
/*  74 */     incrY(y);
/*  75 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec incrX(double amount) {
/*  80 */     moveX1(this.x + amount);
/*  81 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec incrY(double amount) {
/*  86 */     moveY1(this.y + amount);
/*  87 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec incr(COORDINATE vector, double factor) {
/*  92 */     moveX1(this.x + vector.x() * factor);
/*  93 */     moveY1(this.y + vector.y() * factor);
/*  94 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec incr(COORDINATE vector) {
/*  99 */     incrX(vector.x());
/* 100 */     incrY(vector.y());
/* 101 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec moveX1Y1(double X, double Y) {
/* 106 */     moveX1(X);
/* 107 */     moveY1(Y);
/* 108 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec moveX2(double X2) {
/* 113 */     moveX1(X2 - this.width);
/* 114 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec moveY2(double Y2) {
/* 119 */     moveY1(Y2 - this.height);
/* 120 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec moveX1Y1(COORDINATE vector) {
/* 125 */     moveX1Y1(vector.x(), vector.y());
/* 126 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec setWidth(double width) {
/* 131 */     this.width = width;
/* 132 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec setHeight(double height) {
/* 137 */     this.height = height;
/* 138 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec setDim(double width, double height) {
/* 143 */     setWidth(width);
/* 144 */     setHeight(height);
/* 145 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec setDim(double dim) {
/* 150 */     setWidth(dim);
/* 151 */     setHeight(dim);
/* 152 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec setDim(DIMENSION other) {
/* 157 */     setWidth(other.width());
/* 158 */     setHeight(other.height());
/* 159 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec scale(double Xmultiplier, double Ymultiplier) {
/* 164 */     setWidth(this.width * Xmultiplier);
/* 165 */     setHeight(this.height * Ymultiplier);
/* 166 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec centerIn(RECTANGLE other) {
/* 171 */     centerX(other.x1(), other.x2());
/* 172 */     centerY(other.y1(), other.y2());
/* 173 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec centerIn(double x1, double x2, double y1, double y2) {
/* 178 */     centerX(x1, x2);
/* 179 */     centerY(y1, y2);
/* 180 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec centerX(double x1, double x2) {
/* 185 */     moveX1(x1 + (x2 - x1 - this.width) / 2.0D);
/* 186 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec centerY(double y1, double y2) {
/* 191 */     moveY1(y1 + (y2 - y1 - this.height) / 2.0D);
/* 192 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec centerX(RECTANGLE other) {
/* 197 */     centerX(other.x1(), other.x2());
/* 198 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec centerY(RECTANGLE other) {
/* 203 */     centerY(other.y1(), other.y2());
/* 204 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec moveC(COORDINATE v) {
/* 209 */     moveC(v.x(), v.y());
/* 210 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec moveC(double X, double Y) {
/* 215 */     moveX1(X - this.width / 2.0D);
/* 216 */     moveY1(Y - this.height / 2.0D);
/* 217 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec moveCX(double X) {
/* 222 */     moveX1(X - this.width / 2.0D);
/* 223 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec moveCY(double Y) {
/* 228 */     moveY1(Y - this.height / 2.0D);
/* 229 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int x1() {
/* 234 */     return (int)this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public int x2() {
/* 239 */     return (int)(this.x + this.width);
/*     */   }
/*     */ 
/*     */   
/*     */   public int y1() {
/* 244 */     return (int)this.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public int y2() {
/* 249 */     return (int)(this.y + this.height);
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/* 254 */     return (int)this.height;
/*     */   }
/*     */ 
/*     */   
/*     */   public int width() {
/* 259 */     return (int)this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int cX() {
/* 264 */     return (int)(this.x + this.width / 2.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public int cY() {
/* 269 */     return (int)(this.y + this.height / 2.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec scale(double scale) {
/* 274 */     scale(scale, scale);
/* 275 */     return this;
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
/*     */   public void unify(RECTANGLE o) {
/* 303 */     if (o.x1() < this.x) {
/* 304 */       this.width += this.x - o.x1();
/* 305 */       this.x = o.x1();
/*     */     } 
/* 307 */     if (o.x2() > x2()) {
/* 308 */       this.width = (o.x2() - x1());
/*     */     }
/* 310 */     if (o.y1() < this.y) {
/* 311 */       this.height += this.y - o.y1();
/* 312 */       this.y = o.y1();
/*     */     } 
/* 314 */     if (o.y2() > y2()) {
/* 315 */       this.height = (o.y2() - y1());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void unify(int xx, int yy) {
/* 321 */     if (this.width <= 0.0D) {
/* 322 */       this.width = 1.0D;
/* 323 */       this.x = xx;
/*     */     } 
/* 325 */     if (this.height <= 0.0D) {
/* 326 */       this.height = 1.0D;
/* 327 */       this.y = yy;
/*     */     } 
/*     */     
/* 330 */     if (xx < this.x) {
/* 331 */       this.width += this.x - xx;
/* 332 */       this.x = xx;
/*     */     } 
/* 334 */     if (xx >= x2()) {
/* 335 */       this.width = (xx - x1() + 1);
/*     */     }
/* 337 */     if (yy < this.y) {
/* 338 */       this.height += this.y - yy;
/* 339 */       this.y = yy;
/*     */     } 
/* 341 */     if (yy >= y2()) {
/* 342 */       this.height = (yy - y1() + 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 349 */     return String.valueOf(getClass().getName()) + " x1:" + x1() + " x2:" + x2() + 
/* 350 */       " y1:" + y1() + " y2:" + y2();
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec incrW(double dWidth) {
/* 355 */     setWidth(this.width += dWidth);
/* 356 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void incrH(double dHeight) {
/* 361 */     setHeight(this.height + dHeight);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 366 */     file.d(this.x);
/* 367 */     file.d(this.y);
/* 368 */     file.d(this.width);
/* 369 */     file.d(this.height);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 374 */     this.x = file.d();
/* 375 */     this.y = file.d();
/* 376 */     this.width = file.d();
/* 377 */     this.height = file.d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 384 */     this.x = -1.0D;
/* 385 */     this.y = -1.0D;
/* 386 */     this.width = 0.0D;
/* 387 */     this.height = 0.0D;
/*     */   }
/*     */   
/*     */   public double dx1() {
/* 391 */     return this.x;
/*     */   }
/*     */   
/*     */   public double dy1() {
/* 395 */     return this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class RecThreadSafe
/*     */     extends Rec
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/* 403 */     private final RECIter iter = new RECIter(this);
/*     */     
/*     */     public Iterator<COORDINATE> iterator() {
/* 406 */       return (Iterator<COORDINATE>)this.iter.init();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void pad(int w, int h) {
/* 412 */     this.x -= w;
/* 413 */     this.y -= h;
/* 414 */     this.width += (w * 2);
/* 415 */     this.height += (h * 2);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\datatypes\Rec.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */