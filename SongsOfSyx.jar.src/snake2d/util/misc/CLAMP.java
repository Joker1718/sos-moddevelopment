/*    */ package snake2d.util.misc;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class CLAMP
/*    */ {
/*    */   public static int i(int v, int min, int max) {
/* 10 */     if (v < min)
/* 11 */       return min; 
/* 12 */     if (v > max)
/* 13 */       return max; 
/* 14 */     return v;
/*    */   }
/*    */   
/*    */   public static byte b(byte v, int min, int max) {
/* 18 */     if (v < min)
/* 19 */       return (byte)min; 
/* 20 */     if (v > max)
/* 21 */       return (byte)max; 
/* 22 */     return v;
/*    */   }
/*    */   
/*    */   public static double d(double v, double min, double max) {
/* 26 */     if (Double.isNaN(v))
/* 27 */       return 0.0D; 
/* 28 */     if (v == Double.NEGATIVE_INFINITY)
/* 29 */       return min; 
/* 30 */     if (v == Double.POSITIVE_INFINITY)
/* 31 */       return max; 
/* 32 */     if (v < min)
/* 33 */       return min; 
/* 34 */     if (v > max)
/* 35 */       return max; 
/* 36 */     return v;
/*    */   }
/*    */ 
/*    */   
/*    */   public static double c(double v, double max) {
/* 41 */     if (v < max) {
/* 42 */       return v;
/*    */     }
/*    */     
/* 45 */     if (v > max) {
/*    */       
/* 47 */       double d = v % max;
/*    */ 
/*    */       
/* 50 */       int i = (int)(v / max);
/* 51 */       if ((i & 0x1) == 1) {
/* 52 */         return max - d;
/*    */       }
/* 54 */       return d;
/*    */     } 
/*    */     
/* 57 */     return v;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\misc\CLAMP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */