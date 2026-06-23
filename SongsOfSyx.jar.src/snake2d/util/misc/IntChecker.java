/*    */ package snake2d.util.misc;
/*    */ 
/*    */ public class IntChecker
/*    */ {
/*    */   private final short[] check;
/*  6 */   private int checkI = 1;
/*    */ 
/*    */   
/*    */   public IntChecker(int size) {
/* 10 */     this.check = new short[size];
/*    */   }
/*    */ 
/*    */   
/*    */   public IntChecker init() {
/* 15 */     this.checkI++;
/* 16 */     if (this.checkI == 65535) {
/* 17 */       for (int i = 0; i < this.check.length; i++)
/* 18 */         this.check[i] = 0; 
/* 19 */       this.checkI = 1;
/*    */     } 
/* 21 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isSet(int i) {
/* 30 */     return ((this.check[i] & 0xFFFF) == this.checkI);
/*    */   }
/*    */   
/*    */   public void unset(int i) {
/* 34 */     this.check[i] = 0;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isSetAndSet(int i) {
/* 45 */     if (!isSet(i)) {
/* 46 */       this.check[i] = (short)this.checkI;
/* 47 */       return false;
/*    */     } 
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   public int size() {
/* 53 */     return this.check.length;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\misc\IntChecker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */