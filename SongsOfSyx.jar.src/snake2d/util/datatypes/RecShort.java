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
/*     */ public class RecShort
/*     */   extends RecFacade
/*     */   implements SAVABLE
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  18 */   public static final RecShort TEMP = new RecShort();
/*     */   
/*     */   protected short x;
/*     */   
/*     */   protected short y;
/*     */   
/*     */   protected short width;
/*     */   protected short height;
/*     */   
/*     */   public RecShort() {}
/*     */   
/*     */   public RecShort(FileGetter f) throws IOException {
/*  30 */     load(f);
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort(double dim) {
/*  35 */     set(0.0D, dim, 0.0D, dim);
/*     */   }
/*     */   
/*     */   public RecShort(double width, double height) {
/*  39 */     set(0.0D, width, 0.0D, height);
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort(double x1, double x2, double y1, double y2) {
/*  44 */     set(x1, x2, y1, y2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RecShort(RECTANGLE other) {
/*  53 */     moveX1(other.x1());
/*  54 */     moveY1(other.y1());
/*  55 */     setWidth(other.width());
/*  56 */     setHeight(other.height());
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort moveX1(double X1) {
/*  61 */     this.x = (short)(int)X1;
/*  62 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort moveY1(double Y1) {
/*  67 */     this.y = (short)(int)Y1;
/*  68 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort incr(double x, double y) {
/*  73 */     incrX(x);
/*  74 */     incrY(y);
/*  75 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort incrX(double amount) {
/*  80 */     moveX1(this.x + amount);
/*  81 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort incrY(double amount) {
/*  86 */     moveY1(this.y + amount);
/*  87 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort incr(COORDINATE vector, double factor) {
/*  92 */     moveX1(this.x + vector.x() * factor);
/*  93 */     moveY1(this.y + vector.y() * factor);
/*  94 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort incr(COORDINATE vector) {
/*  99 */     incrX(vector.x());
/* 100 */     incrY(vector.y());
/* 101 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort moveX1Y1(double X, double Y) {
/* 106 */     moveX1(X);
/* 107 */     moveY1(Y);
/* 108 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort moveX2(double X2) {
/* 113 */     moveX1(X2 - this.width);
/* 114 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort moveY2(double Y2) {
/* 119 */     moveY1(Y2 - this.height);
/* 120 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort moveX1Y1(COORDINATE vector) {
/* 125 */     moveX1Y1(vector.x(), vector.y());
/* 126 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort setWidth(double width) {
/* 131 */     this.width = (short)(int)width;
/* 132 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort setHeight(double height) {
/* 137 */     this.height = (short)(int)height;
/* 138 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort setDim(double width, double height) {
/* 143 */     setWidth(width);
/* 144 */     setHeight(height);
/* 145 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort setDim(double dim) {
/* 150 */     setWidth(dim);
/* 151 */     setHeight(dim);
/* 152 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort setDim(DIMENSION other) {
/* 157 */     setWidth(other.width());
/* 158 */     setHeight(other.height());
/* 159 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort scale(double Xmultiplier, double Ymultiplier) {
/* 164 */     setWidth(this.width * Xmultiplier);
/* 165 */     setHeight(this.height * Ymultiplier);
/* 166 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort centerIn(RECTANGLE other) {
/* 171 */     centerX(other.x1(), other.x2());
/* 172 */     centerY(other.y1(), other.y2());
/* 173 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort centerIn(double x1, double x2, double y1, double y2) {
/* 178 */     centerX(x1, x2);
/* 179 */     centerY(y1, y2);
/* 180 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort centerX(double x1, double x2) {
/* 185 */     moveX1(x1 + (x2 - x1 - this.width) / 2.0D);
/* 186 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort centerY(double y1, double y2) {
/* 191 */     moveY1(y1 + (y2 - y1 - this.height) / 2.0D);
/* 192 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort centerX(RECTANGLE other) {
/* 197 */     centerX(other.x1(), other.x2());
/* 198 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort centerY(RECTANGLE other) {
/* 203 */     centerY(other.y1(), other.y2());
/* 204 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort moveC(COORDINATE v) {
/* 209 */     moveC(v.x(), v.y());
/* 210 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort moveC(double X, double Y) {
/* 215 */     moveX1(X - (this.width / 2));
/* 216 */     moveY1(Y - (this.height / 2));
/* 217 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort moveCX(double X) {
/* 222 */     moveX1(X - (this.width / 2));
/* 223 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort moveCY(double Y) {
/* 228 */     moveY1(Y - (this.height / 2));
/* 229 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int x1() {
/* 234 */     return this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public int x2() {
/* 239 */     return this.x + this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int y1() {
/* 244 */     return this.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public int y2() {
/* 249 */     return this.y + this.height;
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/* 254 */     return this.height;
/*     */   }
/*     */ 
/*     */   
/*     */   public int width() {
/* 259 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int cX() {
/* 264 */     return this.x + this.width / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int cY() {
/* 269 */     return this.y + this.height / 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort scale(double scale) {
/* 274 */     scale(scale, scale);
/* 275 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 282 */     return String.valueOf(getClass().getName()) + " x1:" + x1() + " x2:" + x2() + 
/* 283 */       " y1:" + y1() + " y2:" + y2();
/*     */   }
/*     */ 
/*     */   
/*     */   public RecShort incrW(double dWidth) {
/* 288 */     setWidth((this.width = (short)(int)(this.width + dWidth)));
/* 289 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void incrH(double dHeight) {
/* 294 */     setHeight(this.height + dHeight);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 299 */     file.s(this.x);
/* 300 */     file.s(this.y);
/* 301 */     file.s(this.width);
/* 302 */     file.s(this.height);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 307 */     this.x = file.s();
/* 308 */     this.y = file.s();
/* 309 */     this.width = file.s();
/* 310 */     this.height = file.s();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 317 */     this.x = -1;
/* 318 */     this.y = -1;
/* 319 */     this.width = 0;
/* 320 */     this.height = 0;
/*     */   }
/*     */   
/*     */   public double dx1() {
/* 324 */     return this.x;
/*     */   }
/*     */   
/*     */   public double dy1() {
/* 328 */     return this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class RecThreadSafe
/*     */     extends RecShort
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/* 336 */     private final RECIter iter = new RECIter(this);
/*     */     
/*     */     public Iterator<COORDINATE> iterator() {
/* 339 */       return (Iterator<COORDINATE>)this.iter.init();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\datatypes\RecShort.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */