/*     */ package tools.perf;
/*     */ 
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
/*     */ class Data
/*     */ {
/*     */   long[] data;
/*     */   
/*     */   public void finalize() {
/* 554 */     this.data = new long[262144 * longCount()];
/*     */   }
/*     */   
/*     */   public int longCount() {
/* 558 */     return this.countLong + 1;
/*     */   }
/*     */   
/* 561 */   private int countLong = -1;
/*     */   
/* 563 */   private final Count cInt = new Count(32, null);
/* 564 */   private final Count cShort = new Count(16, this.cInt);
/* 565 */   private final Count cByte = new Count(8, this.cShort);
/* 566 */   private final Count cNibble = new Count(4, this.cByte);
/* 567 */   private final Count cCrumb = new Count(2, this.cNibble);
/* 568 */   private final Count cBit = new Count(1, this.cCrumb);
/*     */   
/*     */   private class Count
/*     */   {
/*     */     private final int size;
/* 573 */     private int pScroll = 0;
/*     */     private int longI;
/* 575 */     private int count = 1;
/*     */     private final Count next;
/*     */     
/*     */     Count(int size, Count next) {
/* 579 */       this.size = size;
/* 580 */       this.next = next;
/*     */     }
/*     */     
/*     */     Count count() {
/* 584 */       if (this.next == null) {
/* 585 */         this.count++;
/* 586 */         if (this.count > 1) {
/* 587 */           Test.Data.this.countLong++;
/* 588 */           this.count = 0;
/* 589 */           this.longI = Test.Data.this.countLong;
/*     */         } 
/*     */         
/* 592 */         return this;
/*     */       } 
/*     */ 
/*     */       
/* 596 */       this.count++;
/* 597 */       if (this.count > 1) {
/* 598 */         this.next.count();
/* 599 */         this.pScroll = this.next.scroll();
/* 600 */         this.count = 0;
/* 601 */         this.longI = this.next.longI;
/*     */       } 
/*     */       
/* 604 */       return this;
/*     */     }
/*     */     
/*     */     int scroll() {
/* 608 */       return this.pScroll + this.count * this.size;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class DataAbs
/*     */   {
/*     */     private final int iLong;
/*     */     
/*     */     private final int scroll;
/*     */     private final long mask;
/*     */     
/*     */     public DataAbs(INFO info, Test.Data.Count c) {
/* 621 */       c.count();
/* 622 */       this.scroll = c.scroll();
/* 623 */       this.mask = (1L << c.size) - 1L;
/* 624 */       this.iLong = c.longI;
/*     */ 
/*     */       
/* 627 */       long cc = this.mask;
/* 628 */       cc <<= this.scroll;
/*     */     }
/*     */ 
/*     */     
/*     */     public int get(int ref) {
/* 633 */       return (int)(Test.Data.this.data[ref * Test.Data.this.countLong + this.iLong] >>> this.scroll & this.mask);
/*     */     }
/*     */     
/*     */     public int min(int ref) {
/* 637 */       return 0;
/*     */     }
/*     */     
/*     */     public int max(int ref) {
/* 641 */       return (int)this.mask;
/*     */     }
/*     */     
/*     */     public void set(int ref, int s) {
/* 645 */       if (s < min(ref) || s > max(ref))
/* 646 */         throw new RuntimeException("" + s + " " + s + " " + min(ref)); 
/* 647 */       long c = this.mask;
/* 648 */       s = (int)(s & this.mask);
/* 649 */       Test.Data.this.data[ref * Test.Data.this.countLong + this.iLong] = Test.Data.this.data[ref * Test.Data.this.countLong + this.iLong] & (this.mask << this.scroll ^ 0xFFFFFFFFFFFFFFFFL);
/* 650 */       c = s & 0xFFFFFFFFL;
/* 651 */       c <<= this.scroll;
/* 652 */       Test.Data.this.data[ref * Test.Data.this.countLong + this.iLong] = Test.Data.this.data[ref * Test.Data.this.countLong + this.iLong] | c;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public class DataInt
/*     */     extends DataAbs
/*     */   {
/*     */     private final int max;
/*     */     
/*     */     public DataInt(INFO info, int max) {
/* 663 */       super(info, Test.Data.this.cInt);
/* 664 */       this.max = max;
/*     */     }
/*     */     
/*     */     public DataInt() {
/* 668 */       this(null, 2147483647);
/*     */     }
/*     */     
/*     */     public DataInt(INFO info) {
/* 672 */       this(info, 2147483647);
/*     */     }
/*     */     
/*     */     public DataInt(CharSequence name, CharSequence desc) {
/* 676 */       this(new INFO(name, desc), 2147483647);
/*     */     }
/*     */ 
/*     */     
/*     */     public int min(int ref) {
/* 681 */       return Integer.MIN_VALUE;
/*     */     }
/*     */     
/*     */     public int max(int ref) {
/* 685 */       return this.max;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(int ref, int s) {
/* 690 */       if (s < min(ref) || s > max(ref))
/* 691 */         throw new RuntimeException("" + s); 
/* 692 */       super.set(ref, s);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public class DataLong
/*     */   {
/*     */     private final int longI;
/*     */ 
/*     */     
/*     */     public DataLong() {
/* 704 */       this.longI = ++Test.Data.this.countLong;
/*     */     }
/*     */     
/*     */     public long get(int ref) {
/* 708 */       return Test.Data.this.data[ref * Test.Data.this.countLong + this.longI];
/*     */     }
/*     */     
/*     */     public void set(int ref, long i) {
/* 712 */       Test.Data.this.data[ref * Test.Data.this.countLong + this.longI] = i;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class DataDouble
/*     */   {
/* 721 */     private final Test.Data.DataLong dd = new Test.Data.DataLong();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double getD(int ref) {
/* 728 */       return Double.longBitsToDouble(this.dd.get(ref));
/*     */     }
/*     */     
/*     */     public void setD(int ref, double d) {
/* 732 */       long i = Double.doubleToLongBits(d);
/* 733 */       this.dd.set(ref, i);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\tools\perf\Test$Data.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */