/*    */ package snake2d.util.datatypes;
/*    */ 
/*    */ public interface DIMENSION
/*    */ {
/*    */   int width();
/*    */   
/*    */   int height();
/*    */   
/*    */   public static class Imp
/*    */     implements DIMENSION
/*    */   {
/*    */     private double w;
/*    */     private double h;
/*    */     
/*    */     public int width() {
/* 16 */       return (int)this.w;
/*    */     }
/*    */ 
/*    */     
/*    */     public int height() {
/* 21 */       return (int)this.h;
/*    */     }
/*    */     
/*    */     public Imp widthSet(double w) {
/* 25 */       this.w = w;
/* 26 */       return this;
/*    */     }
/*    */     
/*    */     public Imp heightSet(double h) {
/* 30 */       this.h = h;
/* 31 */       return this;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\datatypes\DIMENSION.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */