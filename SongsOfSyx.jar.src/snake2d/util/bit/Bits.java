/*    */ package snake2d.util.bit;
/*    */ 
/*    */ public class Bits
/*    */ {
/*    */   public final int scroll;
/*    */   public final int mask;
/*    */   
/*    */   public Bits(int mask) {
/*  9 */     this.scroll = Long.numberOfTrailingZeros(mask);
/* 10 */     long m = mask & 0xFFFFFFFFL;
/* 11 */     m >>= this.scroll;
/*    */     
/* 13 */     this.mask = (int)m;
/*    */   }
/*    */   
/*    */   public int set(int data, int value) {
/* 17 */     if ((value & (this.mask ^ 0xFFFFFFFF)) != 0) {
/* 18 */       throw new RuntimeException(value);
/*    */     }
/* 20 */     value <<= this.scroll;
/* 21 */     data &= this.mask << this.scroll ^ 0xFFFFFFFF;
/* 22 */     data |= value;
/* 23 */     return data;
/*    */   }
/*    */   
/*    */   public int get(int data) {
/* 27 */     return data >> this.scroll & this.mask;
/*    */   }
/*    */   
/*    */   public int inc(int data, int inc) {
/* 31 */     int a = get(data) + inc;
/* 32 */     if (a < 0)
/* 33 */       a = 0; 
/* 34 */     if (a > this.mask)
/* 35 */       a = this.mask; 
/* 36 */     return set(data, a);
/*    */   }
/*    */   
/*    */   public boolean isMaximum(int data) {
/* 40 */     return (get(data) == this.mask);
/*    */   }
/*    */   
/*    */   public static int getDistance(int a, int b, int mask) {
/* 44 */     a &= mask;
/* 45 */     b &= mask;
/*    */     
/* 47 */     if (b >= a) {
/* 48 */       return b - a;
/*    */     }
/* 50 */     return mask - a + b;
/*    */   }
/*    */   
/*    */   public static double getDistanceD(int a, int b, int mask) {
/* 54 */     return getDistanceD(a, b, mask) / mask;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\bit\Bits.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */