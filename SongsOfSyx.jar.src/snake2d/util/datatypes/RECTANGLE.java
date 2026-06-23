/*    */ package snake2d.util.datatypes;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import snake2d.UTIL;
/*    */ 
/*    */ 
/*    */ public interface RECTANGLE
/*    */   extends DIMENSION, Serializable, Iterable<COORDINATE>
/*    */ {
/*    */   int x1();
/*    */   
/*    */   int x2();
/*    */   
/*    */   int y1();
/*    */   
/*    */   default boolean holdsPoint(double x, double y) {
/* 17 */     return (x >= x1() && x < x2() && y >= y1() && y < y2());
/*    */   } int y2(); int cX();
/*    */   int cY();
/*    */   default boolean holdsPoint(double x, double y, DIR d) {
/* 21 */     return holdsPoint(x + d.x(), y + d.y());
/*    */   }
/*    */   
/*    */   default boolean holdsPoint(COORDINATE coo) {
/* 25 */     return holdsPoint(coo.x(), coo.y());
/*    */   }
/*    */   
/*    */   default boolean holdsPoint(COORDINATE c, DIR d) {
/* 29 */     return holdsPoint((c.x() + d.x()), (c.y() + d.y()));
/*    */   }
/*    */   
/*    */   default boolean touches(double x, double y) {
/* 33 */     return (x >= x1() && x <= x2() && y >= y1() && y <= y2());
/*    */   }
/*    */   
/*    */   default boolean touches(BODY_HOLDER other) {
/* 37 */     return touches(other.body());
/*    */   }
/*    */   
/*    */   default boolean touches(RECTANGLE other) {
/* 41 */     return (x1() < other.x2() && x2() > other.x1() && 
/* 42 */       y1() < other.y2() && y2() > other.y1());
/*    */   }
/*    */   
/*    */   default boolean touches(int x1, int x2, int y1, int y2) {
/* 46 */     return (x1() < x2 && x2() > x1 && 
/* 47 */       y1() < y2 && y2() > y1);
/*    */   }
/*    */   
/*    */   default boolean fitsIn(BODY_HOLDER other) {
/* 51 */     return isWithin(other.body());
/*    */   }
/*    */   
/*    */   default boolean isWithin(RECTANGLE other) {
/* 55 */     return (x1() >= other.x1() && x2() <= other.x2() && 
/* 56 */       y1() >= other.y1() && y2() <= other.y2());
/*    */   }
/*    */   
/*    */   default boolean isWithin(int x1, int x2, int y1, int y2) {
/* 60 */     return (x1() >= x1 && x2() <= x2 && 
/* 61 */       y1() >= y1 && y2() <= y2);
/*    */   }
/*    */   
/*    */   default boolean isSameAs(BODY_HOLDER other) {
/* 65 */     return isSameAs(other.body());
/*    */   }
/*    */   
/*    */   default boolean isSameAs(RECTANGLE other) {
/* 69 */     return !(x1() != other.x1() || x2() != other.x2() || 
/* 70 */       y1() != other.y1() || y2() != other.y2());
/*    */   }
/*    */   
/*    */   default int getDistance(RECTANGLE b) {
/* 74 */     int x = Math.abs(cX() - b.cX());
/* 75 */     int y = Math.abs(cY() - b.cY());
/*    */     
/* 77 */     if (x > y)
/* 78 */       return (int)(UTIL.SQRT2 * y) + x - y; 
/* 79 */     if (x < y) {
/* 80 */       return (int)(UTIL.SQRT2 * x) + y - x;
/*    */     }
/* 82 */     return (int)(UTIL.SQRT2 * x);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default boolean isOnEdge(int x, int y) {
/* 89 */     return (holdsPoint(x, y) && (x == x1() || x == x2() - 1 || y1() == y || y2() - 1 == y));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\datatypes\RECTANGLE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */