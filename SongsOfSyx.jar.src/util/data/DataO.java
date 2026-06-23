/*     */ package util.data;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.save.Savable;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
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
/*     */ public abstract class DataO<T>
/*     */ {
/*     */   private int countLong;
/*     */   private final Entries entries;
/*     */   private final Count cInt;
/*     */   private final Count cShort;
/*     */   private final Count cByte;
/*     */   private final Count cNibble;
/*     */   private final Count cCrumb;
/*     */   private final Count cBit;
/*     */   private DataOSaver saver;
/*     */   private DataOLoader loader;
/*     */   
/*     */   public DataO(String key) {
/*  70 */     this.countLong = -1;
/*     */     
/*  72 */     this.entries = new Entries();
/*  73 */     this.cInt = new Count(32, null);
/*  74 */     this.cShort = new Count(16, this.cInt);
/*  75 */     this.cByte = new Count(8, this.cShort);
/*  76 */     this.cNibble = new Count(4, this.cByte);
/*  77 */     this.cCrumb = new Count(2, this.cNibble);
/*  78 */     this.cBit = new Count(1, this.cCrumb); GAME.saver().addSpecialSaver(new Savable(key) { public void save(FilePutter file) { DataO.this.saver = new DataO.DataOSaver(file); } public void load(FileGetter file) throws IOException { DataO.this.loader = new DataO.DataOLoader(file); } }); } private DataO(boolean hack) { this.countLong = -1; this.entries = new Entries(); this.cInt = new Count(32, null); this.cShort = new Count(16, this.cInt); this.cByte = new Count(8, this.cShort); this.cNibble = new Count(4, this.cByte); this.cCrumb = new Count(2, this.cNibble); this.cBit = new Count(1, this.cCrumb); } protected abstract long[] data(T paramT); public int longCount() { return this.countLong + 1; } public INT_O.INT_OE<T> create(String key, int max) { if (max <= 1) return new DataBit(key);  if (max <= 3) return new DataCrumb(key);  if (max <= 15) return new DataNibble(key, max);  if (max <= 31) return new DataNibble1(key, max);  if (max <= 255) return new DataByte(key, max);  if (max <= 65535)
/*     */       return new DataShort(key, null, max);  if (max <= 16777215)
/*     */       return new DataShortE(key, max);  if (max <= -1)
/*     */       return new DataInt(key, null, max);  throw new RuntimeException("" + max); } private class Count
/*     */   {
/*  83 */     private int pScroll = 0; private final int size;
/*     */     private int longI;
/*  85 */     private int count = 1;
/*     */     private final Count next;
/*     */     
/*     */     Count(int size, Count next) {
/*  89 */       this.size = size;
/*  90 */       this.next = next;
/*     */     }
/*     */     
/*     */     Count count() {
/*  94 */       if (this.next == null) {
/*  95 */         this.count++;
/*  96 */         if (this.count > 1) {
/*  97 */           DataO.this.countLong++;
/*  98 */           this.count = 0;
/*  99 */           this.longI = DataO.this.countLong;
/*     */         } 
/*     */         
/* 102 */         return this;
/*     */       } 
/*     */       
/* 105 */       this.count++;
/* 106 */       if (this.count > 1) {
/* 107 */         this.next.count();
/* 108 */         this.pScroll = this.next.scroll();
/* 109 */         this.count = 0;
/* 110 */         this.longI = this.next.longI;
/*     */       } 
/*     */       
/* 113 */       return this;
/*     */     }
/*     */     
/*     */     int scroll() {
/* 117 */       return this.pScroll + this.count * this.size;
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataAbs
/*     */     implements INT_O.INT_OE<T>
/*     */   {
/*     */     private final int iLong;
/*     */     private final int scroll;
/*     */     private final long mask;
/*     */     private final INFO info;
/*     */     public final String key;
/*     */     
/*     */     private DataAbs(String key, INFO info, DataO<T>.Count c) {
/* 131 */       c.count();
/* 132 */       this.key = key;
/* 133 */       this.scroll = c.scroll();
/* 134 */       this.mask = (1L << c.size) - 1L;
/* 135 */       this.iLong = c.longI;
/* 136 */       this.info = info;
/*     */       
/* 138 */       long cc = this.mask;
/* 139 */       cc <<= this.scroll;
/* 140 */       DataO.this.entries.push(key, c.size, new LONG_O.LONG_OE<T>()
/*     */           {
/*     */             public long get(T t)
/*     */             {
/* 144 */               return DataO.DataAbs.this.get(t);
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(T t, long i) {
/* 149 */               DataO.DataAbs.this.set(t, (int)i);
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public INFO info() {
/* 158 */       return this.info;
/*     */     }
/*     */ 
/*     */     
/*     */     public int get(T t) {
/* 163 */       return (int)(DataO.this.data(t)[this.iLong] >>> this.scroll & this.mask);
/*     */     }
/*     */ 
/*     */     
/*     */     public int min(T t) {
/* 168 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(T t) {
/* 173 */       return (int)this.mask;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(T t, int s) {
/* 178 */       if (s < min(t) || s > max(t))
/* 179 */         throw new RuntimeException("" + s + " " + s + " " + min(t)); 
/* 180 */       long c = this.mask;
/* 181 */       s = (int)(s & this.mask);
/* 182 */       DataO.this.data(t)[this.iLong] = DataO.this.data(t)[this.iLong] & (this.mask << this.scroll ^ 0xFFFFFFFFFFFFFFFFL);
/* 183 */       c = s & 0xFFFFFFFFL;
/* 184 */       c <<= this.scroll;
/* 185 */       DataO.this.data(t)[this.iLong] = DataO.this.data(t)[this.iLong] | c;
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataBit
/*     */     extends DataAbs
/*     */     implements BOOLEANO.BOOLEAN_OE<T>
/*     */   {
/*     */     public DataBit(String key, INFO info) {
/* 194 */       super(key, info, DataO.this.cBit);
/*     */     }
/*     */     
/*     */     public DataBit(String key) {
/* 198 */       this(key, (INFO)null);
/*     */     }
/*     */     
/*     */     public DataBit(String key, CharSequence name, CharSequence desc) {
/* 202 */       this(key, new INFO(name, desc));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean is(T t) {
/* 207 */       return (get(t) == 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public BOOLEANO.BOOLEAN_OE<T> set(T t, boolean b) {
/* 212 */       set(t, b ? 1 : 0);
/* 213 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataCrumb
/*     */     extends DataAbs
/*     */     implements INT_O.INT_OE<T> {
/*     */     public DataCrumb(String key, INFO info) {
/* 221 */       super(key, info, DataO.this.cCrumb);
/*     */     }
/*     */     
/*     */     public DataCrumb(String key) {
/* 225 */       this(key, null);
/*     */     }
/*     */     
/*     */     public DataCrumb(String key, CharSequence name, CharSequence desc) {
/* 229 */       this(key, new INFO(name, desc));
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataNibble
/*     */     extends DataAbs
/*     */     implements INT_O.INT_OE<T> {
/*     */     private final int max;
/*     */     
/*     */     public DataNibble(String key, INFO info, int max) {
/* 239 */       super(key, info, DataO.this.cNibble);
/* 240 */       this.max = max;
/*     */     }
/*     */     
/*     */     public DataNibble(String key) {
/* 244 */       this(key, (INFO)null, 15);
/*     */     }
/*     */     
/*     */     public DataNibble(String key, int max) {
/* 248 */       this(key, (INFO)null, max);
/*     */     }
/*     */     
/*     */     public DataNibble(String key, CharSequence name, CharSequence desc) {
/* 252 */       this(key, new INFO(name, desc), 15);
/*     */     }
/*     */     
/*     */     public DataNibble(String key, CharSequence name, CharSequence desc, int max) {
/* 256 */       this(key, new INFO(name, desc), max);
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(T t) {
/* 261 */       return this.max;
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataNibble1
/*     */     implements INT_O.INT_OE<T>
/*     */   {
/*     */     private final DataO<T>.DataBit bit;
/*     */     private final DataO<T>.DataNibble nibble;
/*     */     private final int max;
/*     */     
/*     */     public DataNibble1(String key) {
/* 273 */       this(key, 31);
/*     */     }
/*     */     
/*     */     public DataNibble1(String key, int max) {
/* 277 */       this.bit = new DataO.DataBit(key);
/* 278 */       this.nibble = new DataO.DataNibble(key);
/* 279 */       this.max = max;
/*     */     }
/*     */ 
/*     */     
/*     */     public int get(T t) {
/* 284 */       return (this.bit.get(t) << 4) + this.nibble.get(t);
/*     */     }
/*     */ 
/*     */     
/*     */     public int min(T t) {
/* 289 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(T t) {
/* 294 */       return this.max;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(T t, int v) {
/* 299 */       int b = v >> 4 & 0x1;
/* 300 */       this.bit.set(t, b);
/* 301 */       this.nibble.set(t, v & 0xF);
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataByte
/*     */     extends DataAbs
/*     */     implements INT_O.INT_OE<T> {
/*     */     private final int max;
/*     */     
/*     */     public DataByte(String key, INFO info, int max) {
/* 311 */       super(key, info, DataO.this.cByte);
/* 312 */       this.max = max;
/*     */     }
/*     */     
/*     */     public DataByte(String key, INFO info) {
/* 316 */       this(key, info, 255);
/*     */     }
/*     */     
/*     */     public DataByte(String key, int max) {
/* 320 */       this(key, (INFO)null, max);
/*     */     }
/*     */     
/*     */     public DataByte(String key) {
/* 324 */       this(key, (INFO)null);
/*     */     }
/*     */     
/*     */     public DataByte(String key, CharSequence name, CharSequence desc) {
/* 328 */       this(key, new INFO(name, desc));
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(T t) {
/* 333 */       return this.max;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(T t, int s) {
/* 338 */       if (s < min(t) || s > max(t))
/* 339 */         throw new RuntimeException("" + s); 
/* 340 */       super.set(t, s);
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataShort
/*     */     extends DataAbs
/*     */     implements INT_O.INT_OE<T> {
/*     */     private final int max;
/*     */     
/*     */     public DataShort(String key, INFO info, int max) {
/* 350 */       super(key, info, DataO.this.cShort);
/* 351 */       this.max = max;
/*     */     }
/*     */     
/*     */     public DataShort(String key, INFO info) {
/* 355 */       this(key, info, 65535);
/*     */     }
/*     */     
/*     */     public DataShort(String key) {
/* 359 */       this(key, null);
/*     */     }
/*     */     
/*     */     public DataShort(String key, CharSequence name, CharSequence desc) {
/* 363 */       this(key, new INFO(name, desc));
/*     */     }
/*     */     
/*     */     public DataShort(String key, CharSequence name, CharSequence desc, int max) {
/* 367 */       this(key, new INFO(name, desc), max);
/*     */     }
/*     */ 
/*     */     
/*     */     public int min(T t) {
/* 372 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(T t) {
/* 377 */       return this.max;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(T t, int s) {
/* 382 */       if (s < min(t) || s > max(t))
/* 383 */         throw new RuntimeException("" + s); 
/* 384 */       super.set(t, s);
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataShortE
/*     */     implements INT_O.INT_OE<T>
/*     */   {
/*     */     private final DataO<T>.DataByte by;
/*     */     private final DataO<T>.DataShort sh;
/*     */     private final int max;
/*     */     
/*     */     public DataShortE(String key) {
/* 396 */       this(key, 16777215);
/*     */     }
/*     */     
/*     */     public DataShortE(String key, int max) {
/* 400 */       this.by = new DataO.DataByte(key);
/* 401 */       this.sh = new DataO.DataShort(key);
/* 402 */       this.max = max;
/*     */     }
/*     */ 
/*     */     
/*     */     public int get(T t) {
/* 407 */       return (this.by.get(t) << 16) + this.sh.get(t);
/*     */     }
/*     */ 
/*     */     
/*     */     public int min(T t) {
/* 412 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(T t) {
/* 417 */       return this.max;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(T t, int v) {
/* 422 */       int b = v >> 16 & 0xFF;
/* 423 */       this.by.set(t, b);
/* 424 */       this.sh.set(t, v & 0xFFFF);
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataInt
/*     */     extends DataAbs
/*     */     implements INT_O.INT_OE<T> {
/*     */     private final int max;
/*     */     
/*     */     public DataInt(String key, INFO info, int max) {
/* 434 */       super(key, info, DataO.this.cInt);
/* 435 */       this.max = max;
/*     */     }
/*     */     
/*     */     public DataInt(String key) {
/* 439 */       this(key, (INFO)null, 2147483647);
/*     */     }
/*     */     
/*     */     public DataInt(String key, INFO info) {
/* 443 */       this(key, info, 2147483647);
/*     */     }
/*     */     
/*     */     public DataInt(String key, CharSequence name, CharSequence desc) {
/* 447 */       this(key, new INFO(name, desc), 2147483647);
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(T t) {
/* 452 */       return this.max;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(T t, int s) {
/* 457 */       if (s < min(t) || s > max(t))
/* 458 */         throw new RuntimeException("" + s); 
/* 459 */       super.set(t, s);
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataFloat
/*     */     implements DOUBLE_O.DOUBLE_OE<T>
/*     */   {
/*     */     private final DataO<T>.DataInt dd;
/*     */     private INFO info;
/*     */     
/*     */     public DataFloat(String key, INFO info) {
/* 470 */       this.info = info;
/* 471 */       this.dd = new DataO<T>.DataInt(DataO.this, key)
/*     */         {
/*     */           public int min(T t) {
/* 474 */             return Integer.MIN_VALUE;
/*     */           }
/*     */         };
/*     */     }
/*     */     
/*     */     public DataFloat(String key) {
/* 480 */       this(key, null);
/*     */     }
/*     */ 
/*     */     
/*     */     public double getD(T t) {
/* 485 */       return Float.intBitsToFloat(this.dd.get(t));
/*     */     }
/*     */ 
/*     */     
/*     */     public DOUBLE_O.DOUBLE_OE<T> setD(T t, double d) {
/* 490 */       int i = Float.floatToIntBits((float)d);
/* 491 */       this.dd.set(t, i);
/* 492 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public INFO info() {
/* 497 */       return this.info;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public class DataLong
/*     */     implements LONG_O.LONG_OE<T>
/*     */   {
/*     */     private final int longI;
/*     */     
/*     */     public DataLong(String key) {
/* 508 */       this.longI = ++DataO.this.countLong;
/* 509 */       DataO.this.entries.push(key, 64, this);
/*     */     }
/*     */ 
/*     */     
/*     */     public long get(T t) {
/* 514 */       return DataO.this.data(t)[this.longI];
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(T t, long i) {
/* 519 */       DataO.this.data(t)[this.longI] = i;
/*     */     }
/*     */   }
/*     */   
/*     */   public class DataDouble
/*     */     implements DOUBLE_O.DOUBLE_OE<T>
/*     */   {
/*     */     private final DataO<T>.DataLong dd;
/*     */     private INFO info;
/*     */     
/*     */     public DataDouble(String key, INFO info) {
/* 530 */       this.info = info;
/* 531 */       this.dd = new DataO.DataLong(key);
/*     */     }
/*     */     
/*     */     public DataDouble(String key) {
/* 535 */       this(key, null);
/*     */     }
/*     */ 
/*     */     
/*     */     public double getD(T t) {
/* 540 */       return Double.longBitsToDouble(this.dd.get(t));
/*     */     }
/*     */ 
/*     */     
/*     */     public DOUBLE_O.DOUBLE_OE<T> setD(T t, double d) {
/* 545 */       long i = Double.doubleToLongBits(d);
/* 546 */       this.dd.set(t, i);
/* 547 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public INFO info() {
/* 552 */       return this.info;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataOSaver saver() {
/* 561 */     return this.saver;
/*     */   }
/*     */   
/*     */   public DataOLoader loader() throws IOException {
/* 565 */     return this.loader;
/*     */   }
/*     */   
/*     */   public final class DataOSaver
/*     */   {
/*     */     private DataOSaver(FilePutter f) {
/* 571 */       f.i(DataO.this.longCount());
/* 572 */       f.i(DataO.this.entries.entries.size());
/*     */       
/* 574 */       for (DataO<T>.Entries.Entry e : DataO.this.entries.entries) {
/* 575 */         f.chars(e.key);
/* 576 */         f.i(e.type);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void save(T t, FilePutter f) {
/* 581 */       f.ls(DataO.this.data(t));
/*     */     }
/*     */     
/*     */     public void save(Object[] tt, FilePutter f) {
/* 585 */       f.i(tt.length); byte b; int i; Object[] arrayOfObject;
/* 586 */       for (i = (arrayOfObject = tt).length, b = 0; b < i; ) { T t = (T)arrayOfObject[b];
/* 587 */         save(t, f);
/*     */         b++; }
/*     */     
/*     */     } public void save(LIST<T> tt, FilePutter f) {
/* 591 */       f.i(tt.size());
/* 592 */       for (T t : tt) {
/* 593 */         save(t, f);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public final class DataOLoader
/*     */   {
/* 600 */     DataO<T> old = null;
/*     */     private long[] tmp;
/*     */     private final int longCount;
/*     */     
/*     */     private DataOLoader(FileGetter f) throws IOException {
/* 605 */       boolean isSame = true;
/* 606 */       this.longCount = f.i();
/* 607 */       int kk = f.i();
/* 608 */       int j = isSame & ((this.longCount == DataO.this.longCount()) ? 1 : 0);
/*     */       
/* 610 */       this.old = new DataO<T>(false)
/*     */         {
/*     */           protected long[] data(T t)
/*     */           {
/* 614 */             return DataO.DataOLoader.this.tmp;
/*     */           }
/*     */         };
/*     */       
/*     */       int i;
/* 619 */       for (i = 0; i < kk; i++) {
/* 620 */         String k = f.chars();
/* 621 */         int t = f.i();
/* 622 */         switch (t) {
/*     */           case 1:
/* 624 */             this.old.getClass();
/*     */             break;
/*     */           case 2:
/* 627 */             this.old.getClass();
/*     */             break;
/*     */           case 4:
/* 630 */             this.old.getClass();
/*     */             break;
/*     */           case 8:
/* 633 */             this.old.getClass();
/*     */             break;
/*     */           case 16:
/* 636 */             this.old.getClass();
/*     */             break;
/*     */           case 32:
/* 639 */             this.old.getClass();
/*     */             break;
/*     */           case 64:
/* 642 */             this.old.getClass();
/*     */             break;
/*     */         } 
/*     */       
/*     */       } 
/* 647 */       j = (this.old.entries.entries.size() == DataO.this.entries.entries.size()) ? 1 : 0;
/*     */       
/* 649 */       for (i = 0; i < DataO.this.entries.entries.size() && j != 0; i++) {
/*     */         
/* 651 */         if (!((DataO.Entries.Entry)this.old.entries.entries.get(i)).mkey.equals(((DataO.Entries.Entry)DataO.this.entries.entries.get(i)).mkey)) {
/* 652 */           LOG.ln(((DataO.Entries.Entry)this.old.entries.entries.get(i)).mkey + " " + ((DataO.Entries.Entry)this.old.entries.entries.get(i)).mkey);
/* 653 */           j = 0;
/*     */         } 
/*     */       } 
/*     */       
/* 657 */       if (j != 0) {
/* 658 */         this.old = null;
/*     */       } else {
/* 660 */         LOG.ln(String.valueOf(DataO.this));
/*     */       } 
/*     */     }
/*     */     
/*     */     public void wash(T t, long[] oldData) {
/* 665 */       if (this.old == null) {
/* 666 */         for (int i = 0; i < oldData.length; i++) {
/* 667 */           DataO.this.data(t)[i] = oldData[i];
/*     */         }
/*     */         return;
/*     */       } 
/* 671 */       this.tmp = oldData;
/* 672 */       Arrays.fill(DataO.this.data(t), 0L);
/* 673 */       for (DataO<T>.Entries.Entry e : this.old.entries.entries) {
/* 674 */         DataO<T>.Entries.Entry o = (DataO.Entries.Entry)DataO.this.entries.map.get(e.mkey);
/* 675 */         if (o != null && e.type == o.type) {
/* 676 */           o.ii.set(t, e.ii.get(t));
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void load(T t, FileGetter f) {
/* 684 */       if (this.old == null) {
/* 685 */         f.ls(DataO.this.data(t));
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 691 */       this.tmp = new long[this.longCount];
/* 692 */       f.ls(this.tmp);
/*     */ 
/*     */       
/* 695 */       Arrays.fill(DataO.this.data(t), 0L);
/*     */       
/* 697 */       for (DataO<T>.Entries.Entry e : this.old.entries.entries) {
/* 698 */         DataO<T>.Entries.Entry o = (DataO.Entries.Entry)DataO.this.entries.map.get(e.mkey);
/* 699 */         if (o != null && e.type == o.type) {
/* 700 */           o.ii.set(t, e.ii.get(t));
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(Object[] tt, FileGetter f) throws IOException {
/* 707 */       int am = f.i();
/*     */       int i;
/* 709 */       for (i = 0; i < am; i++) {
/* 710 */         if (i > tt.length) {
/* 711 */           long[] ll = new long[this.longCount];
/* 712 */           f.ls(ll);
/*     */         } else {
/* 714 */           load((T)tt[i], f);
/*     */         } 
/*     */       } 
/* 717 */       for (i = am; i < tt.length; i++) {
/* 718 */         Arrays.fill(DataO.this.data(tt[i]), 0L);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(LIST<T> tt, FileGetter f) throws IOException {
/* 724 */       int am = f.i(); int i;
/* 725 */       for (i = 0; i < am; i++) {
/* 726 */         if (i > tt.size()) {
/* 727 */           long[] ll = new long[this.longCount];
/* 728 */           f.ls(ll);
/*     */         } else {
/* 730 */           load((T)tt.get(i), f);
/*     */         } 
/*     */       } 
/* 733 */       for (i = am; i < tt.size(); i++)
/* 734 */         Arrays.fill(DataO.this.data(tt.get(i)), 0L); 
/*     */     }
/*     */   }
/*     */   
/*     */   private class Entries {
/*     */     private KeyMap<Entry> map;
/*     */     private final ArrayListGrower<Entry> entries;
/*     */     
/*     */     private Entries() {
/* 743 */       this.map = new KeyMap();
/* 744 */       this.entries = new ArrayListGrower();
/*     */     }
/*     */     String push(String key, int cc, LONG_O.LONG_OE<T> ii) {
/* 747 */       String mkey = key + key;
/* 748 */       if (this.map.containsKey(mkey)) {
/* 749 */         ((Entry)this.map.get(mkey)).ee.printStackTrace();
/* 750 */         throw new RuntimeException(mkey);
/*     */       } 
/* 752 */       Entry e = new Entry();
/* 753 */       e.key = key;
/* 754 */       e.mkey = mkey;
/* 755 */       e.type = cc;
/* 756 */       e.ii = ii;
/* 757 */       this.map.put(mkey, e);
/* 758 */       this.entries.add(e);
/* 759 */       e.ee = new RuntimeException();
/* 760 */       return mkey;
/*     */     }
/*     */     
/*     */     private class Entry {
/*     */       public String key;
/*     */       public String mkey;
/*     */       public int type;
/*     */       public LONG_O.LONG_OE<T> ii;
/*     */       public RuntimeException ee;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\DataO.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */