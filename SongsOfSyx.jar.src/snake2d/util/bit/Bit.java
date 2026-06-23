/*    */ package snake2d.util.bit;
/*    */ 
/*    */ public class Bit
/*    */ {
/*    */   public final int mask;
/*    */   
/*    */   public Bit(int mask) {
/*  8 */     this.mask = mask;
/*  9 */     if (mask == 0 || (mask - 1 & mask) != 0)
/* 10 */       throw new RuntimeException(); 
/*    */   }
/*    */   
/*    */   public boolean is(int data) {
/* 14 */     return ((data & this.mask) != 0);
/*    */   }
/*    */   
/*    */   public int set(int data) {
/* 18 */     return data | this.mask;
/*    */   }
/*    */   
/*    */   public int set(int data, boolean b) {
/* 22 */     if (b)
/* 23 */       return set(data); 
/* 24 */     return clear(data);
/*    */   }
/*    */   
/*    */   public int clear(int data) {
/* 28 */     return data & (this.mask ^ 0xFFFFFFFF);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\bit\Bit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */