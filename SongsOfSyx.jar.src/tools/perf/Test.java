/*     */ package tools.perf;
/*     */ 
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayListGrower;
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
/*     */ public class Test
/*     */ {
/*     */   private static final int size = 262144;
/*     */   private static final int iterations = 1000;
/*     */   
/*     */   public static void main(String[] args) {
/*  22 */     objects();
/*  23 */     hybrid();
/*  24 */     data();
/*  25 */     objects();
/*  26 */     hybrid();
/*  27 */     data();
/*  28 */     objects();
/*  29 */     hybrid();
/*  30 */     data();
/*  31 */     objects();
/*  32 */     hybrid();
/*  33 */     data();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void objects() {
/*  42 */     EntityObject[] objects = new EntityObject[262144];
/*  43 */     for (int i = 0; i < objects.length; i++) {
/*  44 */       objects[i] = new EntityObject();
/*     */     }
/*     */     
/*  47 */     double physics = 0.0D;
/*  48 */     double mood = 0.0D;
/*     */     
/*  50 */     long now = System.currentTimeMillis();
/*  51 */     for (int j = 0; j < 1000; j++) {
/*  52 */       byte b; int k; EntityObject[] arrayOfEntityObject; for (k = (arrayOfEntityObject = objects).length, b = 0; b < k; ) { EntityObject o = arrayOfEntityObject[b];
/*  53 */         physics += (o.getPhysics()).x;
/*  54 */         physics += (o.getPhysics()).y;
/*  55 */         physics += (o.getPhysics()).z;
/*     */         
/*  57 */         mood += (o.getMood()).a;
/*  58 */         mood += (o.getMood()).b;
/*  59 */         mood += (o.getMood()).c;
/*     */         b++; }
/*     */     
/*     */     } 
/*  63 */     System.out.println("OBJECTS " + (int)(System.currentTimeMillis() - now) + " " + mood + physics);
/*     */   }
/*     */   
/*     */   private static void hybrid() {
/*  67 */     DataOSimple<EntityObject.EntityDataOld> dataMaker = new DataOSimple<EntityObject.EntityDataOld>()
/*     */       {
/*     */         protected long[] data(EntityObject.EntityDataOld t)
/*     */         {
/*  71 */           return t.data;
/*     */         }
/*     */       };
/*     */     
/*  75 */     dataMaker.getClass(); INT_O.INT_OE<EntityObject.EntityDataOld> px = new DataOSimple.DataInt();
/*  76 */     dataMaker.getClass(); INT_O.INT_OE<EntityObject.EntityDataOld> py = new DataOSimple.DataInt();
/*  77 */     dataMaker.getClass(); INT_O.INT_OE<EntityObject.EntityDataOld> pz = new DataOSimple.DataInt();
/*     */     
/*  79 */     dataMaker.getClass(); INT_O.INT_OE<EntityObject.EntityDataOld> mx = new DataOSimple.DataInt();
/*  80 */     dataMaker.getClass(); INT_O.INT_OE<EntityObject.EntityDataOld> my = new DataOSimple.DataInt();
/*  81 */     dataMaker.getClass(); INT_O.INT_OE<EntityObject.EntityDataOld> mz = new DataOSimple.DataInt();
/*     */ 
/*     */ 
/*     */     
/*  85 */     EntityObject.EntityDataOld[] objects = new EntityObject.EntityDataOld[262144];
/*  86 */     for (int i = 0; i < objects.length; i++) {
/*  87 */       objects[i] = new EntityObject.EntityDataOld(dataMaker.longCount());
/*  88 */       px.setD(objects[i], RND.rFloat());
/*  89 */       py.setD(objects[i], RND.rFloat());
/*  90 */       pz.setD(objects[i], RND.rFloat());
/*     */       
/*  92 */       mx.setD(objects[i], RND.rFloat());
/*  93 */       my.setD(objects[i], RND.rFloat());
/*  94 */       mz.setD(objects[i], RND.rFloat());
/*     */     } 
/*     */     
/*  97 */     double physics = 0.0D;
/*  98 */     double mood = 0.0D;
/*     */     
/* 100 */     long now = System.currentTimeMillis();
/* 101 */     for (int j = 0; j < 1000; j++) {
/* 102 */       byte b; int k; EntityObject.EntityDataOld[] arrayOfEntityDataOld; for (k = (arrayOfEntityDataOld = objects).length, b = 0; b < k; ) { EntityObject.EntityDataOld o = arrayOfEntityDataOld[b];
/* 103 */         physics += px.get(o);
/* 104 */         physics += py.get(o);
/* 105 */         physics += pz.get(o);
/*     */         
/* 107 */         mood += mx.get(o);
/* 108 */         mood += my.get(o);
/* 109 */         mood += mz.get(o);
/*     */         b++; }
/*     */     
/*     */     } 
/* 113 */     System.out.println("HYBRID " + (int)(System.currentTimeMillis() - now) + " " + mood + physics);
/*     */   }
/*     */   
/*     */   private static void data() {
/* 117 */     DataCreator dataMaker = new DataCreator(262144);
/*     */     
/* 119 */     DataInt px = new DataInt(dataMaker);
/* 120 */     DataInt py = new DataInt(dataMaker);
/* 121 */     DataInt pz = new DataInt(dataMaker);
/*     */     
/* 123 */     DataInt mx = new DataInt(dataMaker);
/* 124 */     DataInt my = new DataInt(dataMaker);
/* 125 */     DataInt mz = new DataInt(dataMaker);
/*     */     
/* 127 */     for (int i = 0; i < 262144; i++) {
/*     */       
/* 129 */       px.set(i, RND.rInt());
/* 130 */       py.set(i, RND.rInt());
/* 131 */       pz.set(i, RND.rInt());
/*     */       
/* 133 */       mx.set(i, RND.rInt());
/* 134 */       my.set(i, RND.rInt());
/* 135 */       mz.set(i, RND.rInt());
/*     */     } 
/*     */     
/* 138 */     double physics = 0.0D;
/* 139 */     double mood = 0.0D;
/*     */     
/* 141 */     long now = System.currentTimeMillis();
/* 142 */     for (int k = 0; k < 1000; k++) {
/* 143 */       for (int o = 0; o < 262144; o++) {
/* 144 */         physics += px.get(o);
/* 145 */         physics += py.get(o);
/* 146 */         physics += pz.get(o);
/*     */         
/* 148 */         mood += mx.get(o);
/* 149 */         mood += my.get(o);
/* 150 */         mood += mz.get(o);
/*     */       } 
/*     */     } 
/*     */     
/* 154 */     System.out.println("DATA " + (int)(System.currentTimeMillis() - now) + " " + mood + physics);
/*     */   }
/*     */ 
/*     */   
/*     */   static abstract class DataOSimple<T>
/*     */   {
/*     */     private int countLong;
/*     */     
/*     */     private final Count cInt;
/*     */     private final Count cShort;
/*     */     private final Count cByte;
/*     */     private final Count cNibble;
/*     */     private final Count cCrumb;
/*     */     private final Count cBit;
/*     */     
/*     */     public DataOSimple() {
/* 170 */       this.countLong = -1;
/*     */       
/* 172 */       this.cInt = new Count(32, null);
/* 173 */       this.cShort = new Count(16, this.cInt);
/* 174 */       this.cByte = new Count(8, this.cShort);
/* 175 */       this.cNibble = new Count(4, this.cByte);
/* 176 */       this.cCrumb = new Count(2, this.cNibble);
/* 177 */       this.cBit = new Count(1, this.cCrumb);
/*     */     } protected abstract long[] data(T param1T);
/*     */     public int longCount() {
/*     */       return this.countLong + 1;
/*     */     }
/* 182 */     private class Count { private final int size; private int pScroll = 0;
/*     */       private int longI;
/* 184 */       private int count = 1;
/*     */       private final Count next;
/*     */       
/*     */       Count(int size, Count next) {
/* 188 */         this.size = size;
/* 189 */         this.next = next;
/*     */       }
/*     */       
/*     */       Count count() {
/* 193 */         if (this.next == null) {
/* 194 */           this.count++;
/* 195 */           if (this.count > 1) {
/* 196 */             Test.DataOSimple.this.countLong++;
/* 197 */             this.count = 0;
/* 198 */             this.longI = Test.DataOSimple.this.countLong;
/*     */           } 
/*     */           
/* 201 */           return this;
/*     */         } 
/*     */ 
/*     */         
/* 205 */         this.count++;
/* 206 */         if (this.count > 1) {
/* 207 */           this.next.count();
/* 208 */           this.pScroll = this.next.scroll();
/* 209 */           this.count = 0;
/* 210 */           this.longI = this.next.longI;
/*     */         } 
/*     */         
/* 213 */         return this;
/*     */       }
/*     */       
/*     */       int scroll() {
/* 217 */         return this.pScroll + this.count * this.size;
/*     */       } }
/*     */ 
/*     */ 
/*     */     
/*     */     private class DataAbs
/*     */       implements INT_O.INT_OE<T>
/*     */     {
/*     */       private final int iLong;
/*     */       private final int scroll;
/*     */       private final long mask;
/*     */       private final INFO info;
/*     */       
/*     */       public DataAbs(INFO info, Test.DataOSimple<T>.Count c) {
/* 231 */         c.count();
/* 232 */         this.scroll = c.scroll();
/* 233 */         this.mask = (1L << c.size) - 1L;
/* 234 */         this.iLong = c.longI;
/* 235 */         this.info = info;
/*     */ 
/*     */         
/* 238 */         long cc = this.mask;
/* 239 */         cc <<= this.scroll;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public INFO info() {
/* 245 */         return this.info;
/*     */       }
/*     */ 
/*     */       
/*     */       public int get(T t) {
/* 250 */         return (int)(Test.DataOSimple.this.data(t)[this.iLong] >>> this.scroll & this.mask);
/*     */       }
/*     */ 
/*     */       
/*     */       public int min(T t) {
/* 255 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public int max(T t) {
/* 260 */         return (int)this.mask;
/*     */       }
/*     */ 
/*     */       
/*     */       public void set(T t, int s) {
/* 265 */         if (s < min(t) || s > max(t))
/* 266 */           throw new RuntimeException("" + s + " " + s + " " + min(t)); 
/* 267 */         long c = this.mask;
/* 268 */         s = (int)(s & this.mask);
/* 269 */         Test.DataOSimple.this.data(t)[this.iLong] = Test.DataOSimple.this.data(t)[this.iLong] & (this.mask << this.scroll ^ 0xFFFFFFFFFFFFFFFFL);
/* 270 */         c = s & 0xFFFFFFFFL;
/* 271 */         c <<= this.scroll;
/* 272 */         Test.DataOSimple.this.data(t)[this.iLong] = Test.DataOSimple.this.data(t)[this.iLong] | c;
/*     */       }
/*     */     }
/*     */     
/*     */     public class DataBit
/*     */       extends DataAbs
/*     */       implements BOOLEANO.BOOLEAN_OE<T>
/*     */     {
/*     */       public DataBit(INFO info) {
/* 281 */         super(info, Test.DataOSimple.this.cBit);
/*     */       }
/*     */       
/*     */       public DataBit() {
/* 285 */         this(null);
/*     */       }
/*     */       
/*     */       public DataBit(CharSequence name, CharSequence desc) {
/* 289 */         this(new INFO(name, desc));
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean is(T t) {
/* 294 */         return (get(t) == 1);
/*     */       }
/*     */ 
/*     */       
/*     */       public BOOLEANO.BOOLEAN_OE<T> set(T t, boolean b) {
/* 299 */         set(t, b ? 1 : 0);
/* 300 */         return this;
/*     */       }
/*     */     }
/*     */     
/*     */     public class DataNibble
/*     */       extends DataAbs
/*     */       implements INT_O.INT_OE<T> {
/*     */       private final int max;
/*     */       
/*     */       public DataNibble(INFO info, int max) {
/* 310 */         super(info, Test.DataOSimple.this.cNibble);
/* 311 */         this.max = max;
/*     */       }
/*     */       
/*     */       public DataNibble() {
/* 315 */         this(null, 15);
/*     */       }
/*     */       
/*     */       public DataNibble(int max) {
/* 319 */         this(null, max);
/*     */       }
/*     */       
/*     */       public DataNibble(CharSequence name, CharSequence desc) {
/* 323 */         this(new INFO(name, desc), 15);
/*     */       }
/*     */       
/*     */       public DataNibble(CharSequence name, CharSequence desc, int max) {
/* 327 */         this(new INFO(name, desc), max);
/*     */       }
/*     */ 
/*     */       
/*     */       public int max(T t) {
/* 332 */         return this.max;
/*     */       }
/*     */     }
/*     */     
/*     */     public class DataByte
/*     */       extends DataAbs
/*     */       implements INT_O.INT_OE<T> {
/*     */       private final int max;
/*     */       
/*     */       public DataByte(INFO info, int max) {
/* 342 */         super(info, Test.DataOSimple.this.cByte);
/* 343 */         this.max = max;
/*     */       }
/*     */       
/*     */       public DataByte(INFO info) {
/* 347 */         this(info, 255);
/*     */       }
/*     */       
/*     */       public DataByte(int max) {
/* 351 */         this((INFO)null, max);
/*     */       }
/*     */       
/*     */       public DataByte() {
/* 355 */         this(null);
/*     */       }
/*     */       
/*     */       public DataByte(CharSequence name, CharSequence desc) {
/* 359 */         this(new INFO(name, desc));
/*     */       }
/*     */ 
/*     */       
/*     */       public int max(T t) {
/* 364 */         return this.max;
/*     */       }
/*     */ 
/*     */       
/*     */       public void set(T t, int s) {
/* 369 */         if (s < min(t) || s > max(t))
/* 370 */           throw new RuntimeException("" + s); 
/* 371 */         super.set(t, s);
/*     */       }
/*     */     }
/*     */     
/*     */     public class DataShort
/*     */       extends DataAbs
/*     */       implements INT_O.INT_OE<T> {
/*     */       private final int max;
/*     */       
/*     */       public DataShort(INFO info, int max) {
/* 381 */         super(info, Test.DataOSimple.this.cShort);
/* 382 */         this.max = max;
/*     */       }
/*     */       
/*     */       public DataShort(INFO info) {
/* 386 */         this(info, 65535);
/*     */       }
/*     */       
/*     */       public DataShort() {
/* 390 */         this(null);
/*     */       }
/*     */       
/*     */       public DataShort(CharSequence name, CharSequence desc) {
/* 394 */         this(new INFO(name, desc));
/*     */       }
/*     */       
/*     */       public DataShort(CharSequence name, CharSequence desc, int max) {
/* 398 */         this(new INFO(name, desc), max);
/*     */       }
/*     */ 
/*     */       
/*     */       public int min(T t) {
/* 403 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public int max(T t) {
/* 408 */         return this.max;
/*     */       }
/*     */ 
/*     */       
/*     */       public void set(T t, int s) {
/* 413 */         if (s < min(t) || s > max(t))
/* 414 */           throw new RuntimeException("" + s); 
/* 415 */         super.set(t, s);
/*     */       }
/*     */     }
/*     */     
/*     */     public class DataInt
/*     */       extends DataAbs
/*     */       implements INT_O.INT_OE<T> {
/*     */       private final int max;
/*     */       
/*     */       public DataInt(INFO info, int max) {
/* 425 */         super(info, Test.DataOSimple.this.cInt);
/* 426 */         this.max = max;
/*     */       }
/*     */       
/*     */       public DataInt() {
/* 430 */         this(null, 2147483647);
/*     */       }
/*     */       
/*     */       public DataInt(INFO info) {
/* 434 */         this(info, 2147483647);
/*     */       }
/*     */       
/*     */       public DataInt(CharSequence name, CharSequence desc) {
/* 438 */         this(new INFO(name, desc), 2147483647);
/*     */       }
/*     */       
/*     */       public int max(T t) {
/* 442 */         return this.max;
/*     */       }
/*     */ 
/*     */       
/*     */       public void set(T t, int s) {
/* 447 */         if (s < min(t) || s > max(t))
/* 448 */           throw new RuntimeException("" + s); 
/* 449 */         super.set(t, s);
/*     */       }
/*     */     }
/*     */     
/*     */     public class DataFloat
/*     */       implements DOUBLE_O.DOUBLE_OE<T>
/*     */     {
/* 456 */       private final Test.DataOSimple<T>.DataInt dd = new Test.DataOSimple.DataInt();
/*     */       private INFO info;
/*     */       
/*     */       public DataFloat(INFO info) {
/* 460 */         this.info = info;
/*     */       }
/*     */       
/*     */       public DataFloat() {
/* 464 */         this(null);
/*     */       }
/*     */ 
/*     */       
/*     */       public double getD(T t) {
/* 469 */         return Float.intBitsToFloat(this.dd.get(t));
/*     */       }
/*     */ 
/*     */       
/*     */       public DOUBLE_O.DOUBLE_OE<T> setD(T t, double d) {
/* 474 */         int i = Float.floatToIntBits((float)d);
/* 475 */         this.dd.set(t, i);
/* 476 */         return this;
/*     */       }
/*     */ 
/*     */       
/*     */       public INFO info() {
/* 481 */         return this.info;
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public class DataLong
/*     */       implements LONG_O.LONG_OE<T>
/*     */     {
/*     */       private final int longI;
/*     */ 
/*     */       
/*     */       public DataLong() {
/* 493 */         this.longI = ++Test.DataOSimple.this.countLong;
/*     */       }
/*     */ 
/*     */       
/*     */       public long get(T t) {
/* 498 */         return Test.DataOSimple.this.data(t)[this.longI];
/*     */       }
/*     */ 
/*     */       
/*     */       public void set(T t, long i) {
/* 503 */         Test.DataOSimple.this.data(t)[this.longI] = i;
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public class DataDouble
/*     */       implements DOUBLE_O.DOUBLE_OE<T>
/*     */     {
/* 512 */       private final Test.DataOSimple<T>.DataLong dd = new Test.DataOSimple.DataLong();
/*     */       private INFO info;
/*     */       
/*     */       public DataDouble(INFO info) {
/* 516 */         this.info = info;
/*     */       }
/*     */       
/*     */       public DataDouble() {
/* 520 */         this(null);
/*     */       }
/*     */ 
/*     */       
/*     */       public double getD(T t) {
/* 525 */         return Double.longBitsToDouble(this.dd.get(t));
/*     */       }
/*     */ 
/*     */       
/*     */       public DOUBLE_O.DOUBLE_OE<T> setD(T t, double d) {
/* 530 */         long i = Double.doubleToLongBits(d);
/* 531 */         this.dd.set(t, i);
/* 532 */         return this;
/*     */       }
/*     */       
/*     */       public INFO info()
/*     */       {
/* 537 */         return this.info; }
/*     */     } } public class DataInt extends DataOSimple<T>.DataAbs implements INT_O.INT_OE<T> { private final int max; public DataInt(INFO info, int max) {
/*     */       super((Test.DataOSimple)this$0, info, ((Test.DataOSimple)this$0).cInt);
/*     */       this.max = max;
/*     */     } public DataInt() {
/*     */       this((Test.DataOSimple)this$0, (INFO)null, 2147483647);
/*     */     } public DataInt(INFO info) {
/*     */       this((Test.DataOSimple)this$0, info, 2147483647);
/*     */     } public DataInt(CharSequence name, CharSequence desc) {
/*     */       this((Test.DataOSimple)this$0, new INFO(name, desc), 2147483647);
/*     */     } public int max(T t) {
/*     */       return this.max;
/*     */     } public void set(T t, int s) {
/*     */       if (s < min(t) || s > max(t))
/*     */         throw new RuntimeException("" + s); 
/*     */       super.set(t, s);
/*     */     } } static class Data { public void finalize() {
/* 554 */       this.data = new long[262144 * longCount()];
/*     */     }
/*     */     long[] data;
/*     */     public int longCount() {
/* 558 */       return this.countLong + 1;
/*     */     }
/*     */     
/* 561 */     private int countLong = -1;
/*     */     
/* 563 */     private final Count cInt = new Count(32, null);
/* 564 */     private final Count cShort = new Count(16, this.cInt);
/* 565 */     private final Count cByte = new Count(8, this.cShort);
/* 566 */     private final Count cNibble = new Count(4, this.cByte);
/* 567 */     private final Count cCrumb = new Count(2, this.cNibble);
/* 568 */     private final Count cBit = new Count(1, this.cCrumb);
/*     */     
/*     */     private class Count
/*     */     {
/*     */       private final int size;
/* 573 */       private int pScroll = 0;
/*     */       private int longI;
/* 575 */       private int count = 1;
/*     */       private final Count next;
/*     */       
/*     */       Count(int size, Count next) {
/* 579 */         this.size = size;
/* 580 */         this.next = next;
/*     */       }
/*     */       
/*     */       Count count() {
/* 584 */         if (this.next == null) {
/* 585 */           this.count++;
/* 586 */           if (this.count > 1) {
/* 587 */             Test.Data.this.countLong++;
/* 588 */             this.count = 0;
/* 589 */             this.longI = Test.Data.this.countLong;
/*     */           } 
/*     */           
/* 592 */           return this;
/*     */         } 
/*     */ 
/*     */         
/* 596 */         this.count++;
/* 597 */         if (this.count > 1) {
/* 598 */           this.next.count();
/* 599 */           this.pScroll = this.next.scroll();
/* 600 */           this.count = 0;
/* 601 */           this.longI = this.next.longI;
/*     */         } 
/*     */         
/* 604 */         return this;
/*     */       }
/*     */       
/*     */       int scroll() {
/* 608 */         return this.pScroll + this.count * this.size;
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     private class DataAbs
/*     */     {
/*     */       private final int iLong;
/*     */       
/*     */       private final int scroll;
/*     */       private final long mask;
/*     */       
/*     */       public DataAbs(INFO info, Test.Data.Count c) {
/* 621 */         c.count();
/* 622 */         this.scroll = c.scroll();
/* 623 */         this.mask = (1L << c.size) - 1L;
/* 624 */         this.iLong = c.longI;
/*     */ 
/*     */         
/* 627 */         long cc = this.mask;
/* 628 */         cc <<= this.scroll;
/*     */       }
/*     */ 
/*     */       
/*     */       public int get(int ref) {
/* 633 */         return (int)(Test.Data.this.data[ref * Test.Data.this.countLong + this.iLong] >>> this.scroll & this.mask);
/*     */       }
/*     */       
/*     */       public int min(int ref) {
/* 637 */         return 0;
/*     */       }
/*     */       
/*     */       public int max(int ref) {
/* 641 */         return (int)this.mask;
/*     */       }
/*     */       
/*     */       public void set(int ref, int s) {
/* 645 */         if (s < min(ref) || s > max(ref))
/* 646 */           throw new RuntimeException("" + s + " " + s + " " + min(ref)); 
/* 647 */         long c = this.mask;
/* 648 */         s = (int)(s & this.mask);
/* 649 */         Test.Data.this.data[ref * Test.Data.this.countLong + this.iLong] = Test.Data.this.data[ref * Test.Data.this.countLong + this.iLong] & (this.mask << this.scroll ^ 0xFFFFFFFFFFFFFFFFL);
/* 650 */         c = s & 0xFFFFFFFFL;
/* 651 */         c <<= this.scroll;
/* 652 */         Test.Data.this.data[ref * Test.Data.this.countLong + this.iLong] = Test.Data.this.data[ref * Test.Data.this.countLong + this.iLong] | c;
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public class DataInt
/*     */       extends DataAbs
/*     */     {
/*     */       private final int max;
/*     */       
/*     */       public DataInt(INFO info, int max) {
/* 663 */         super(info, Test.Data.this.cInt);
/* 664 */         this.max = max;
/*     */       }
/*     */       
/*     */       public DataInt() {
/* 668 */         this(null, 2147483647);
/*     */       }
/*     */       
/*     */       public DataInt(INFO info) {
/* 672 */         this(info, 2147483647);
/*     */       }
/*     */       
/*     */       public DataInt(CharSequence name, CharSequence desc) {
/* 676 */         this(new INFO(name, desc), 2147483647);
/*     */       }
/*     */ 
/*     */       
/*     */       public int min(int ref) {
/* 681 */         return Integer.MIN_VALUE;
/*     */       }
/*     */       
/*     */       public int max(int ref) {
/* 685 */         return this.max;
/*     */       }
/*     */ 
/*     */       
/*     */       public void set(int ref, int s) {
/* 690 */         if (s < min(ref) || s > max(ref))
/* 691 */           throw new RuntimeException("" + s); 
/* 692 */         super.set(ref, s);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public class DataLong
/*     */     {
/*     */       private final int longI;
/*     */ 
/*     */       
/*     */       public DataLong() {
/* 704 */         this.longI = ++Test.Data.this.countLong;
/*     */       }
/*     */       
/*     */       public long get(int ref) {
/* 708 */         return Test.Data.this.data[ref * Test.Data.this.countLong + this.longI];
/*     */       }
/*     */       
/*     */       public void set(int ref, long i) {
/* 712 */         Test.Data.this.data[ref * Test.Data.this.countLong + this.longI] = i;
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public class DataDouble
/*     */     {
/* 721 */       private final Test.Data.DataLong dd = new Test.Data.DataLong();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public double getD(int ref) {
/* 728 */         return Double.longBitsToDouble(this.dd.get(ref));
/*     */       }
/*     */       
/*     */       public void setD(int ref, double d) {
/* 732 */         long i = Double.doubleToLongBits(d);
/* 733 */         this.dd.set(ref, i);
/*     */       }
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class DataPure
/*     */   {
/*     */     int[] data;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void finalize() {
/* 752 */       this.data = Alloc.ii(262144 * this.cInt);
/*     */     }
/*     */     
/* 755 */     private int cInt = 0;
/*     */ 
/*     */     
/*     */     public class DataInt
/*     */     {
/*     */       private final int max;
/*     */       
/*     */       private final int off;
/*     */       
/*     */       public DataInt(int max) {
/* 765 */         this.max = max;
/* 766 */         this.off = Test.DataPure.this.cInt;
/* 767 */         Test.DataPure.this.cInt++;
/*     */       }
/*     */       
/*     */       public DataInt() {
/* 771 */         this(2147483647);
/*     */       }
/*     */ 
/*     */       
/*     */       public int min(int ref) {
/* 776 */         return Integer.MIN_VALUE;
/*     */       }
/*     */       
/*     */       public int max(int ref) {
/* 780 */         return this.max;
/*     */       }
/*     */       
/*     */       public void set(int ref, int s) {
/* 784 */         Test.DataPure.this.data[ref * Test.DataPure.this.cInt + this.off] = s;
/*     */       }
/*     */       
/*     */       public int get(int ref) {
/* 788 */         return Test.DataPure.this.data[ref * Test.DataPure.this.cInt + this.off];
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class DataCreator
/*     */   {
/*     */     public int size;
/*     */ 
/*     */     
/* 800 */     private final ArrayListGrower<Test.DataInt> all = new ArrayListGrower();
/*     */     
/*     */     DataCreator(int amountOfObjects) {
/* 803 */       this.size = amountOfObjects;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class DataInt
/*     */   {
/*     */     final int[] data;
/*     */     
/*     */     private final int max;
/*     */     private final int min;
/*     */     
/*     */     public DataInt(Test.DataCreator creator, int min, int max, String name, String desc) {
/* 816 */       this.max = max;
/* 817 */       this.min = min;
/* 818 */       this.data = Alloc.ii(creator.size);
/* 819 */       creator.all.add(this);
/*     */     }
/*     */     
/*     */     public DataInt(Test.DataCreator creator) {
/* 823 */       this(creator, -2147483648, 2147483647, "", "");
/*     */     }
/*     */     
/*     */     public int min(int ref) {
/* 827 */       return this.min;
/*     */     }
/*     */     
/*     */     public int max(int ref) {
/* 831 */       return this.max;
/*     */     }
/*     */     
/*     */     public void set(int ref, int s) {
/* 835 */       this.data[ref] = s;
/*     */     }
/*     */     
/*     */     public int get(int ref) {
/* 839 */       return this.data[ref];
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\perf\Test.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */