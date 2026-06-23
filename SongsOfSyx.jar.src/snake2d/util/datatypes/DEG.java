/*    */ package snake2d.util.datatypes;
/*    */ 
/*    */ import snake2d.util.rnd.RND;
/*    */ 
/*    */ public class DEG
/*    */ {
/*  7 */   private static double[][] PRE = new double[360][2];
/*    */   static {
/*  9 */     for (int i = 0; i < PRE.length; i++) {
/* 10 */       PRE[i][0] = Math.cos(Math.toRadians(i));
/* 11 */       PRE[i][1] = Math.sin(Math.toRadians(i));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static int currentI;
/*    */   
/*    */   private static int tmpI;
/*    */ 
/*    */   
/*    */   public static void set(COORDINATE coo) {
/* 23 */     set(coo.x(), coo.y());
/*    */   }
/*    */   
/*    */   public static void set(VECTOR vec) {
/* 27 */     set(vec.x(), vec.y());
/*    */   }
/*    */   
/*    */   public static void set(double x, double y) {
/* 31 */     currentI = (int)Math.toDegrees(Math.atan2(y, x));
/* 32 */     if (currentI < 0)
/* 33 */       currentI += 360; 
/*    */   }
/*    */   
/*    */   public static double getCurrentX() {
/* 37 */     return PRE[currentI][0];
/*    */   }
/*    */   
/*    */   public static double getCurrentY() {
/* 41 */     return PRE[currentI][1];
/*    */   }
/*    */   
/*    */   public static double getTmpX() {
/* 45 */     return PRE[tmpI][0];
/*    */   }
/*    */   
/*    */   public static double getTmpY() {
/* 49 */     return PRE[tmpI][1];
/*    */   }
/*    */   
/*    */   public static void moveTmp(int deg) {
/* 53 */     tmpI = currentI + deg;
/* 54 */     if (tmpI < 0) {
/* 55 */       tmpI += 360;
/* 56 */     } else if (tmpI >= 360) {
/* 57 */       tmpI -= 360;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void setRandom() {
/* 62 */     currentI = RND.rInt(360);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\datatypes\DEG.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */