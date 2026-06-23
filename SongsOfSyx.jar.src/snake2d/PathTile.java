/*    */ package snake2d;
/*    */ 
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ 
/*    */ public class PathTile
/*    */   implements Comparable<PathTile>, COORDINATE {
/*    */   final short x;
/*    */   final short y;
/*    */   float accCost;
/*    */   float value;
/*    */   PathTile pathParent;
/* 12 */   int pathId = 0;
/*    */   
/*    */   boolean closed;
/*    */   
/*    */   PathTile left;
/*    */   
/*    */   PathTile right;
/*    */   PathTile parent;
/*    */   boolean color;
/*    */   
/*    */   PathTile(short x, short y) {
/* 23 */     this.x = x;
/* 24 */     this.y = y;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compareTo(PathTile o) {
/* 29 */     if (o == this)
/* 30 */       return 0; 
/* 31 */     return (this.value < o.value) ? -1 : 1;
/*    */   }
/*    */   
/*    */   public float getValue() {
/* 35 */     return this.value;
/*    */   }
/*    */   
/*    */   public float getValue2() {
/* 39 */     return this.accCost;
/*    */   }
/*    */   
/*    */   public void setValue2(double v) {
/* 43 */     this.accCost = (float)v;
/*    */   }
/*    */ 
/*    */   
/*    */   public int x() {
/* 48 */     return this.x;
/*    */   }
/*    */ 
/*    */   
/*    */   public int y() {
/* 53 */     return this.y;
/*    */   }
/*    */   
/*    */   public PathTile getParent() {
/* 57 */     return this.pathParent;
/*    */   }
/*    */   
/*    */   public final int parents() {
/* 61 */     int p = 0;
/* 62 */     PathTile pa = this.pathParent;
/* 63 */     while (pa != null) {
/* 64 */       p++;
/* 65 */       pa = pa.pathParent;
/*    */     } 
/* 67 */     return p;
/*    */   }
/*    */   
/*    */   public void parentSet(PathTile p) {
/* 71 */     this.pathParent = p;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 76 */     return "PathTile: (" + this.x + ", " + this.y + ")";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\PathTile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */