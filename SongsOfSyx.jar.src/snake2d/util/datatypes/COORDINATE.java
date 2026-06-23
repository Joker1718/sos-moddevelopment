/*     */ package snake2d.util.datatypes;
/*     */ 
/*     */ import snake2d.UTIL;
/*     */ 
/*     */ public interface COORDINATE {
/*     */   int x();
/*     */   
/*     */   int y();
/*     */   
/*     */   default boolean isWithinRec(BODY_HOLDER shape) {
/*  11 */     return isWithinRec(shape.body());
/*     */   }
/*     */   default boolean isWithinRec(RECTANGLE shape) {
/*  14 */     if (x() <= shape.x1() || x() > shape.x2() || y() <= shape.y1() || y() > shape.y2())
/*  15 */       return false; 
/*  16 */     return true;
/*     */   }
/*     */   default boolean isWithin(int x1, int x2, int y1, int y2) {
/*  19 */     if (x() <= x1 || x() > x2 || y() <= y1 || y() > y2)
/*  20 */       return false; 
/*  21 */     return true;
/*     */   }
/*     */   
/*     */   default boolean touchesRec(BODY_HOLDER h) {
/*  25 */     return touchesRec(h.body());
/*     */   }
/*     */   
/*     */   default boolean touchesRec(RECTANGLE shape) {
/*  29 */     if (x() < shape.x1() || x() > shape.x2() || y() < shape.y1() || y() > shape.y2())
/*  30 */       return false; 
/*  31 */     return true;
/*     */   }
/*     */   
/*     */   default double tileDistance() {
/*  35 */     return tileDistance(x(), y(), 0.0D, 0.0D);
/*     */   }
/*     */   
/*     */   default double tileDistanceTo(COORDINATE b) {
/*  39 */     return tileDistance(x(), y(), b.x(), b.y());
/*     */   }
/*     */   
/*     */   default double tileDistanceTo(double bx, double by) {
/*  43 */     return tileDistance(x(), y(), bx, by);
/*     */   }
/*     */   
/*     */   default double distance(double bx, double by) {
/*  47 */     double dx = bx - x();
/*  48 */     double dy = by - y();
/*  49 */     return Math.sqrt(dx * dx + dy * dy);
/*     */   }
/*     */   
/*     */   default double distance(COORDINATE c) {
/*  53 */     double dx = (c.x() - x());
/*  54 */     double dy = (c.y() - y());
/*  55 */     return Math.sqrt(dx * dx + dy * dy);
/*     */   }
/*     */ 
/*     */   
/*     */   static double tileDistance(double x1, double y1, double x2, double y2) {
/*  60 */     double x = Math.abs(x1 - x2);
/*  61 */     double y = Math.abs(y1 - y2);
/*     */     
/*  63 */     if (x > y)
/*  64 */       return UTIL.SQRT2 * y + x - y; 
/*  65 */     if (x < y) {
/*  66 */       return UTIL.SQRT2 * x + y - x;
/*     */     }
/*  68 */     return UTIL.SQRT2 * x;
/*     */   }
/*     */ 
/*     */   
/*     */   static double tileDistance(COORDINATE a, COORDINATE b) {
/*  73 */     return tileDistance(a.x(), a.y(), b.x(), b.y());
/*     */   }
/*     */   
/*     */   static double tileDistance(COORDINATE a, double x2, double y2) {
/*  77 */     return tileDistance(a.x(), a.y(), x2, y2);
/*     */   }
/*     */   
/*     */   static double tileDistance(double x1, double y1, COORDINATE b) {
/*  81 */     return tileDistance(x1, y1, b.x(), b.y());
/*     */   }
/*     */   
/*     */   static double properDistance(double x1, double y1, double x2, double y2) {
/*  85 */     double x = x1 - x2;
/*  86 */     double y = y1 - y2;
/*  87 */     return Math.sqrt(x * x + y * y);
/*     */   }
/*     */   
/*     */   default double absSum() {
/*  91 */     return (Math.abs(x()) + Math.abs(y()));
/*     */   }
/*     */   
/*     */   default boolean isSameAs(COORDINATE other) {
/*  95 */     if (other == null)
/*  96 */       return false; 
/*  97 */     return (other.x() == x() && other.y() == y());
/*     */   }
/*     */   
/*     */   default boolean isSameAs(double x, double y) {
/* 101 */     return (x == x() && y == y());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\datatypes\COORDINATE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */