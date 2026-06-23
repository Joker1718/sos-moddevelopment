/*     */ package util.data;
/*     */ 
/*     */ import util.info.INFO;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class DataOSimple<T>
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
/*  22 */     this.countLong = -1;
/*     */     
/*  24 */     this.cInt = new Count(32, null);
/*  25 */     this.cShort = new Count(16, this.cInt);
/*  26 */     this.cByte = new Count(8, this.cShort);
/*  27 */     this.cNibble = new Count(4, this.cByte);
/*  28 */     this.cCrumb = new Count(2, this.cNibble);
/*  29 */     this.cBit = new Count(1, this.cCrumb);
/*     */   } protected abstract long[] data(T paramT);
/*     */   public int longCount() {
/*     */     return this.countLong + 1;
/*     */   }
/*  34 */   private class Count { private int pScroll = 0; private final int size;
/*     */     private int longI;
/*  36 */     private int count = 1;
/*     */     private final Count next;
/*     */     
/*     */     Count(int size, Count next) {
/*  40 */       this.size = size;
/*  41 */       this.next = next;
/*     */     }
/*     */     
/*     */     Count count() {
/*  45 */       if (this.next == null) {
/*  46 */         this.count++;
/*  47 */         if (this.count > 1) {
/*  48 */           DataOSimple.this.countLong++;
/*  49 */           this.count = 0;
/*  50 */           this.longI = DataOSimple.this.countLong;
/*     */         } 
/*     */         
/*  53 */         return this;
/*     */       } 
/*     */ 
/*     */       
/*  57 */       this.count++;
/*  58 */       if (this.count > 1) {
/*  59 */         this.next.count();
/*  60 */         this.pScroll = this.next.scroll();
/*  61 */         this.count = 0;
/*  62 */         this.longI = this.next.longI;
/*     */       } 
/*     */       
/*  65 */       return this;
/*     */     }
/*     */     
/*     */     int scroll() {
/*  69 */       return this.pScroll + this.count * this.size;
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
/*     */     public DataAbs(INFO info, DataOSimple<T>.Count c) {
/*  83 */       c.count();
/*  84 */       this.scroll = c.scroll();
/*  85 */       this.mask = (1L << c.size) - 1L;
/*  86 */       this.iLong = c.longI;
/*  87 */       this.info = info;
/*     */ 
/*     */       
/*  90 */       long cc = this.mask;
/*  91 */       cc <<= this.scroll;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public INFO info() {
/*  97 */       return this.info;
/*     */     }
/*     */ 
/*     */     
/*     */     public int get(T t) {
/* 102 */       return (int)(DataOSimple.this.data(t)[this.iLong] >>> this.scroll & this.mask);
/*     */     }
/*     */ 
/*     */     
/*     */     public int min(T t) {
/* 107 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(T t) {
/* 112 */       return (int)this.mask;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(T t, int s) {
/* 117 */       if (s < min(t) || s > max(t))
/* 118 */         throw new RuntimeException("" + s + " " + s + " " + min(t)); 
/* 119 */       long c = this.mask;
/* 120 */       s = (int)(s & this.mask);
/* 121 */       DataOSimple.this.data(t)[this.iLong] = DataOSimple.this.data(t)[this.iLong] & (this.mask << this.scroll ^ 0xFFFFFFFFFFFFFFFFL);
/* 122 */       c = s & 0xFFFFFFFFL;
/* 123 */       c <<= this.scroll;
/* 124 */       DataOSimple.this.data(t)[this.iLong] = DataOSimple.this.data(t)[this.iLong] | c;
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataBit
/*     */     extends DataAbs
/*     */     implements BOOLEANO.BOOLEAN_OE<T>
/*     */   {
/*     */     public DataBit(INFO info) {
/* 133 */       super(info, DataOSimple.this.cBit);
/*     */     }
/*     */     
/*     */     public DataBit() {
/* 137 */       this(null);
/*     */     }
/*     */     
/*     */     public DataBit(CharSequence name, CharSequence desc) {
/* 141 */       this(new INFO(name, desc));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean is(T t) {
/* 146 */       return (get(t) == 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public BOOLEANO.BOOLEAN_OE<T> set(T t, boolean b) {
/* 151 */       set(t, b ? 1 : 0);
/* 152 */       return this;
/*     */     }
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
/*     */   public class DataNibble
/*     */     extends DataAbs
/*     */     implements INT_O.INT_OE<T>
/*     */   {
/*     */     private final int max;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DataNibble(INFO info, int max) {
/* 178 */       super(info, DataOSimple.this.cNibble);
/* 179 */       this.max = max;
/*     */     }
/*     */     
/*     */     public DataNibble() {
/* 183 */       this(null, 15);
/*     */     }
/*     */     
/*     */     public DataNibble(int max) {
/* 187 */       this(null, max);
/*     */     }
/*     */     
/*     */     public DataNibble(CharSequence name, CharSequence desc) {
/* 191 */       this(new INFO(name, desc), 15);
/*     */     }
/*     */     
/*     */     public DataNibble(CharSequence name, CharSequence desc, int max) {
/* 195 */       this(new INFO(name, desc), max);
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(T t) {
/* 200 */       return this.max;
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataByte
/*     */     extends DataAbs
/*     */     implements INT_O.INT_OE<T> {
/*     */     private final int max;
/*     */     
/*     */     public DataByte(INFO info, int max) {
/* 210 */       super(info, DataOSimple.this.cByte);
/* 211 */       this.max = max;
/*     */     }
/*     */     
/*     */     public DataByte(INFO info) {
/* 215 */       this(info, 255);
/*     */     }
/*     */     
/*     */     public DataByte(int max) {
/* 219 */       this((INFO)null, max);
/*     */     }
/*     */     
/*     */     public DataByte() {
/* 223 */       this(null);
/*     */     }
/*     */     
/*     */     public DataByte(CharSequence name, CharSequence desc) {
/* 227 */       this(new INFO(name, desc));
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(T t) {
/* 232 */       return this.max;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(T t, int s) {
/* 237 */       if (s < min(t) || s > max(t))
/* 238 */         throw new RuntimeException("" + s); 
/* 239 */       super.set(t, s);
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataShort
/*     */     extends DataAbs
/*     */     implements INT_O.INT_OE<T> {
/*     */     private final int max;
/*     */     
/*     */     public DataShort(INFO info, int max) {
/* 249 */       super(info, DataOSimple.this.cShort);
/* 250 */       this.max = max;
/*     */     }
/*     */     
/*     */     public DataShort(INFO info) {
/* 254 */       this(info, 65535);
/*     */     }
/*     */     
/*     */     public DataShort() {
/* 258 */       this(null);
/*     */     }
/*     */     
/*     */     public DataShort(CharSequence name, CharSequence desc) {
/* 262 */       this(new INFO(name, desc));
/*     */     }
/*     */     
/*     */     public DataShort(CharSequence name, CharSequence desc, int max) {
/* 266 */       this(new INFO(name, desc), max);
/*     */     }
/*     */ 
/*     */     
/*     */     public int min(T t) {
/* 271 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(T t) {
/* 276 */       return this.max;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(T t, int s) {
/* 281 */       if (s < min(t) || s > max(t))
/* 282 */         throw new RuntimeException("" + s); 
/* 283 */       super.set(t, s);
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataInt
/*     */     extends DataAbs
/*     */     implements INT_O.INT_OE<T> {
/*     */     private final int max;
/*     */     
/*     */     public DataInt(INFO info, int max) {
/* 293 */       super(info, DataOSimple.this.cInt);
/* 294 */       this.max = max;
/*     */     }
/*     */     
/*     */     public DataInt() {
/* 298 */       this(null, 2147483647);
/*     */     }
/*     */     
/*     */     public DataInt(INFO info) {
/* 302 */       this(info, 2147483647);
/*     */     }
/*     */     
/*     */     public DataInt(CharSequence name, CharSequence desc) {
/* 306 */       this(new INFO(name, desc), 2147483647);
/*     */     }
/*     */     
/*     */     public int max(T t) {
/* 310 */       return this.max;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(T t, int s) {
/* 315 */       if (s < min(t) || s > max(t))
/* 316 */         throw new RuntimeException("" + s); 
/* 317 */       super.set(t, s);
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataFloat
/*     */     implements DOUBLE_O.DOUBLE_OE<T>
/*     */   {
/* 324 */     private final DataOSimple<T>.DataInt dd = new DataOSimple.DataInt();
/*     */     private INFO info;
/*     */     
/*     */     public DataFloat(INFO info) {
/* 328 */       this.info = info;
/*     */     }
/*     */     
/*     */     public DataFloat() {
/* 332 */       this(null);
/*     */     }
/*     */ 
/*     */     
/*     */     public double getD(T t) {
/* 337 */       return Float.intBitsToFloat(this.dd.get(t));
/*     */     }
/*     */ 
/*     */     
/*     */     public DOUBLE_O.DOUBLE_OE<T> setD(T t, double d) {
/* 342 */       int i = Float.floatToIntBits((float)d);
/* 343 */       this.dd.set(t, i);
/* 344 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public INFO info() {
/* 349 */       return this.info;
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
/* 361 */       this.longI = ++DataOSimple.this.countLong;
/*     */     }
/*     */ 
/*     */     
/*     */     public long get(T t) {
/* 366 */       return DataOSimple.this.data(t)[this.longI];
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(T t, long i) {
/* 371 */       DataOSimple.this.data(t)[this.longI] = i;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public class DataDouble
/*     */     implements DOUBLE_O.DOUBLE_OE<T>
/*     */   {
/* 380 */     private final DataOSimple<T>.DataLong dd = new DataOSimple.DataLong();
/*     */     private INFO info;
/*     */     
/*     */     public DataDouble(INFO info) {
/* 384 */       this.info = info;
/*     */     }
/*     */     
/*     */     public DataDouble() {
/* 388 */       this(null);
/*     */     }
/*     */ 
/*     */     
/*     */     public double getD(T t) {
/* 393 */       return Double.longBitsToDouble(this.dd.get(t));
/*     */     }
/*     */ 
/*     */     
/*     */     public DOUBLE_O.DOUBLE_OE<T> setD(T t, double d) {
/* 398 */       long i = Double.doubleToLongBits(d);
/* 399 */       this.dd.set(t, i);
/* 400 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public INFO info() {
/* 405 */       return this.info;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\DataOSimple.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */