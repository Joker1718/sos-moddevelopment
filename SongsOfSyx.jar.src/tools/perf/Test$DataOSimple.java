/*     */ package tools.perf;
/*     */ 
/*     */ import util.data.BOOLEANO;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.INT_O;
/*     */ import util.data.LONG_O;
/*     */ import util.info.INFO;
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
/*     */ 
/*     */ abstract class DataOSimple<T>
/*     */ {
/*     */   private int countLong;
/*     */   private final Count cInt;
/*     */   private final Count cShort;
/*     */   private final Count cByte;
/*     */   private final Count cNibble;
/*     */   private final Count cCrumb;
/*     */   private final Count cBit;
/*     */   
/*     */   public DataOSimple() {
/* 170 */     this.countLong = -1;
/*     */     
/* 172 */     this.cInt = new Count(32, null);
/* 173 */     this.cShort = new Count(16, this.cInt);
/* 174 */     this.cByte = new Count(8, this.cShort);
/* 175 */     this.cNibble = new Count(4, this.cByte);
/* 176 */     this.cCrumb = new Count(2, this.cNibble);
/* 177 */     this.cBit = new Count(1, this.cCrumb);
/*     */   } protected abstract long[] data(T paramT);
/*     */   public int longCount() {
/*     */     return this.countLong + 1;
/*     */   }
/* 182 */   private class Count { private int pScroll = 0; private final int size;
/*     */     private int longI;
/* 184 */     private int count = 1;
/*     */     private final Count next;
/*     */     
/*     */     Count(int size, Count next) {
/* 188 */       this.size = size;
/* 189 */       this.next = next;
/*     */     }
/*     */     
/*     */     Count count() {
/* 193 */       if (this.next == null) {
/* 194 */         this.count++;
/* 195 */         if (this.count > 1) {
/* 196 */           Test.DataOSimple.this.countLong++;
/* 197 */           this.count = 0;
/* 198 */           this.longI = Test.DataOSimple.this.countLong;
/*     */         } 
/*     */         
/* 201 */         return this;
/*     */       } 
/*     */ 
/*     */       
/* 205 */       this.count++;
/* 206 */       if (this.count > 1) {
/* 207 */         this.next.count();
/* 208 */         this.pScroll = this.next.scroll();
/* 209 */         this.count = 0;
/* 210 */         this.longI = this.next.longI;
/*     */       } 
/*     */       
/* 213 */       return this;
/*     */     }
/*     */     
/*     */     int scroll() {
/* 217 */       return this.pScroll + this.count * this.size;
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   private class DataAbs
/*     */     implements INT_O.INT_OE<T>
/*     */   {
/*     */     private final int iLong;
/*     */     private final int scroll;
/*     */     private final long mask;
/*     */     private final INFO info;
/*     */     
/*     */     public DataAbs(INFO info, Test.DataOSimple<T>.Count c) {
/* 231 */       c.count();
/* 232 */       this.scroll = c.scroll();
/* 233 */       this.mask = (1L << c.size) - 1L;
/* 234 */       this.iLong = c.longI;
/* 235 */       this.info = info;
/*     */ 
/*     */       
/* 238 */       long cc = this.mask;
/* 239 */       cc <<= this.scroll;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public INFO info() {
/* 245 */       return this.info;
/*     */     }
/*     */ 
/*     */     
/*     */     public int get(T t) {
/* 250 */       return (int)(Test.DataOSimple.this.data(t)[this.iLong] >>> this.scroll & this.mask);
/*     */     }
/*     */ 
/*     */     
/*     */     public int min(T t) {
/* 255 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(T t) {
/* 260 */       return (int)this.mask;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(T t, int s) {
/* 265 */       if (s < min(t) || s > max(t))
/* 266 */         throw new RuntimeException("" + s + " " + s + " " + min(t)); 
/* 267 */       long c = this.mask;
/* 268 */       s = (int)(s & this.mask);
/* 269 */       Test.DataOSimple.this.data(t)[this.iLong] = Test.DataOSimple.this.data(t)[this.iLong] & (this.mask << this.scroll ^ 0xFFFFFFFFFFFFFFFFL);
/* 270 */       c = s & 0xFFFFFFFFL;
/* 271 */       c <<= this.scroll;
/* 272 */       Test.DataOSimple.this.data(t)[this.iLong] = Test.DataOSimple.this.data(t)[this.iLong] | c;
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataBit
/*     */     extends DataAbs
/*     */     implements BOOLEANO.BOOLEAN_OE<T>
/*     */   {
/*     */     public DataBit(INFO info) {
/* 281 */       super(info, Test.DataOSimple.this.cBit);
/*     */     }
/*     */     
/*     */     public DataBit() {
/* 285 */       this(null);
/*     */     }
/*     */     
/*     */     public DataBit(CharSequence name, CharSequence desc) {
/* 289 */       this(new INFO(name, desc));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean is(T t) {
/* 294 */       return (get(t) == 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public BOOLEANO.BOOLEAN_OE<T> set(T t, boolean b) {
/* 299 */       set(t, b ? 1 : 0);
/* 300 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataNibble
/*     */     extends DataAbs
/*     */     implements INT_O.INT_OE<T> {
/*     */     private final int max;
/*     */     
/*     */     public DataNibble(INFO info, int max) {
/* 310 */       super(info, Test.DataOSimple.this.cNibble);
/* 311 */       this.max = max;
/*     */     }
/*     */     
/*     */     public DataNibble() {
/* 315 */       this(null, 15);
/*     */     }
/*     */     
/*     */     public DataNibble(int max) {
/* 319 */       this(null, max);
/*     */     }
/*     */     
/*     */     public DataNibble(CharSequence name, CharSequence desc) {
/* 323 */       this(new INFO(name, desc), 15);
/*     */     }
/*     */     
/*     */     public DataNibble(CharSequence name, CharSequence desc, int max) {
/* 327 */       this(new INFO(name, desc), max);
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(T t) {
/* 332 */       return this.max;
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataByte
/*     */     extends DataAbs
/*     */     implements INT_O.INT_OE<T> {
/*     */     private final int max;
/*     */     
/*     */     public DataByte(INFO info, int max) {
/* 342 */       super(info, Test.DataOSimple.this.cByte);
/* 343 */       this.max = max;
/*     */     }
/*     */     
/*     */     public DataByte(INFO info) {
/* 347 */       this(info, 255);
/*     */     }
/*     */     
/*     */     public DataByte(int max) {
/* 351 */       this((INFO)null, max);
/*     */     }
/*     */     
/*     */     public DataByte() {
/* 355 */       this(null);
/*     */     }
/*     */     
/*     */     public DataByte(CharSequence name, CharSequence desc) {
/* 359 */       this(new INFO(name, desc));
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(T t) {
/* 364 */       return this.max;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(T t, int s) {
/* 369 */       if (s < min(t) || s > max(t))
/* 370 */         throw new RuntimeException("" + s); 
/* 371 */       super.set(t, s);
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataShort
/*     */     extends DataAbs
/*     */     implements INT_O.INT_OE<T> {
/*     */     private final int max;
/*     */     
/*     */     public DataShort(INFO info, int max) {
/* 381 */       super(info, Test.DataOSimple.this.cShort);
/* 382 */       this.max = max;
/*     */     }
/*     */     
/*     */     public DataShort(INFO info) {
/* 386 */       this(info, 65535);
/*     */     }
/*     */     
/*     */     public DataShort() {
/* 390 */       this(null);
/*     */     }
/*     */     
/*     */     public DataShort(CharSequence name, CharSequence desc) {
/* 394 */       this(new INFO(name, desc));
/*     */     }
/*     */     
/*     */     public DataShort(CharSequence name, CharSequence desc, int max) {
/* 398 */       this(new INFO(name, desc), max);
/*     */     }
/*     */ 
/*     */     
/*     */     public int min(T t) {
/* 403 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(T t) {
/* 408 */       return this.max;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(T t, int s) {
/* 413 */       if (s < min(t) || s > max(t))
/* 414 */         throw new RuntimeException("" + s); 
/* 415 */       super.set(t, s);
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataInt
/*     */     extends DataAbs
/*     */     implements INT_O.INT_OE<T> {
/*     */     private final int max;
/*     */     
/*     */     public DataInt(INFO info, int max) {
/* 425 */       super(info, Test.DataOSimple.this.cInt);
/* 426 */       this.max = max;
/*     */     }
/*     */     
/*     */     public DataInt() {
/* 430 */       this(null, 2147483647);
/*     */     }
/*     */     
/*     */     public DataInt(INFO info) {
/* 434 */       this(info, 2147483647);
/*     */     }
/*     */     
/*     */     public DataInt(CharSequence name, CharSequence desc) {
/* 438 */       this(new INFO(name, desc), 2147483647);
/*     */     }
/*     */     
/*     */     public int max(T t) {
/* 442 */       return this.max;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(T t, int s) {
/* 447 */       if (s < min(t) || s > max(t))
/* 448 */         throw new RuntimeException("" + s); 
/* 449 */       super.set(t, s);
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataFloat
/*     */     implements DOUBLE_O.DOUBLE_OE<T>
/*     */   {
/* 456 */     private final Test.DataOSimple<T>.DataInt dd = new Test.DataOSimple.DataInt();
/*     */     private INFO info;
/*     */     
/*     */     public DataFloat(INFO info) {
/* 460 */       this.info = info;
/*     */     }
/*     */     
/*     */     public DataFloat() {
/* 464 */       this(null);
/*     */     }
/*     */ 
/*     */     
/*     */     public double getD(T t) {
/* 469 */       return Float.intBitsToFloat(this.dd.get(t));
/*     */     }
/*     */ 
/*     */     
/*     */     public DOUBLE_O.DOUBLE_OE<T> setD(T t, double d) {
/* 474 */       int i = Float.floatToIntBits((float)d);
/* 475 */       this.dd.set(t, i);
/* 476 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public INFO info() {
/* 481 */       return this.info;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public class DataLong
/*     */     implements LONG_O.LONG_OE<T>
/*     */   {
/*     */     private final int longI;
/*     */ 
/*     */     
/*     */     public DataLong() {
/* 493 */       this.longI = ++Test.DataOSimple.this.countLong;
/*     */     }
/*     */ 
/*     */     
/*     */     public long get(T t) {
/* 498 */       return Test.DataOSimple.this.data(t)[this.longI];
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(T t, long i) {
/* 503 */       Test.DataOSimple.this.data(t)[this.longI] = i;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public class DataDouble
/*     */     implements DOUBLE_O.DOUBLE_OE<T>
/*     */   {
/* 512 */     private final Test.DataOSimple<T>.DataLong dd = new Test.DataOSimple.DataLong();
/*     */     private INFO info;
/*     */     
/*     */     public DataDouble(INFO info) {
/* 516 */       this.info = info;
/*     */     }
/*     */     
/*     */     public DataDouble() {
/* 520 */       this(null);
/*     */     }
/*     */ 
/*     */     
/*     */     public double getD(T t) {
/* 525 */       return Double.longBitsToDouble(this.dd.get(t));
/*     */     }
/*     */ 
/*     */     
/*     */     public DOUBLE_O.DOUBLE_OE<T> setD(T t, double d) {
/* 530 */       long i = Double.doubleToLongBits(d);
/* 531 */       this.dd.set(t, i);
/* 532 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public INFO info() {
/* 537 */       return this.info;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\perf\Test$DataOSimple.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */