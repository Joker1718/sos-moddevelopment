/*    */ package snake2d.util.bit;
/*    */ 
/*    */ public class BitsLong
/*    */ {
/*    */   public final int scroll;
/*    */   public final long mask;
/*    */   
/*    */   public BitsLong(long mask) {
/*  9 */     this.scroll = Long.numberOfTrailingZeros(mask);
/* 10 */     long m = mask;
/* 11 */     m >>>= this.scroll;
/*    */     
/* 13 */     this.mask = m;
/*    */   }
/*    */   
/*    */   public long set(long data, long value) {
/* 17 */     if (value < 0L || value > this.mask) {
/* 18 */       throw new RuntimeException(value);
/*    */     }
/* 20 */     value <<= this.scroll;
/* 21 */     data &= this.mask << this.scroll ^ 0xFFFFFFFFFFFFFFFFL;
/* 22 */     data |= value;
/* 23 */     return data;
/*    */   }
/*    */   
/*    */   public int get(long data) {
/* 27 */     return (int)(data >> this.scroll & this.mask);
/*    */   }
/*    */   
/*    */   public long inc(long data, long inc) {
/* 31 */     long a = get(data) + inc;
/* 32 */     if (a < 0L)
/* 33 */       a = 0L; 
/* 34 */     if (a > this.mask)
/* 35 */       a = this.mask; 
/* 36 */     return set(data, a);
/*    */   }
/*    */   
/*    */   public boolean isMaximum(int data) {
/* 40 */     return (get(data) == this.mask);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\bit\BitsLong.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */