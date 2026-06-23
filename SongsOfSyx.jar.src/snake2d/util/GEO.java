/*    */ package snake2d.util;
/*    */ 
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GEO
/*    */ {
/*    */   public static boolean collides(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
/* 11 */     double uA = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3)) / ((y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1));
/* 12 */     double uB = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3)) / ((y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1));
/*    */ 
/*    */     
/* 15 */     if (uA >= 0.0D && uA <= 1.0D && uB >= 0.0D && uB <= 1.0D)
/*    */     {
/* 17 */       return true;
/*    */     }
/* 19 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static double leftOrRight(double ax, double ay, double bx, double by, double cx, double cy) {
/* 30 */     return (bx - ax) * (cy - ay) - (by - ay) * (cx - ax);
/*    */   }
/*    */   
/*    */   public static double leftOrRight(double px, double py, COORDINATE l1, COORDINATE l2) {
/* 34 */     return (l1.x() - px) * (l2.y() - py) - (l1.y() - py) * (l2.y() - px);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\GEO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */