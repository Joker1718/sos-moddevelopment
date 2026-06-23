/*    */ package snake2d.path1D;
/*    */ 
/*    */ public class PTile1D
/*    */ {
/*    */   public final int index;
/*    */   public float value2;
/*    */   float value;
/*    */   public PTile1D pathParent;
/*  9 */   int pathId = 0;
/*    */   boolean closed;
/*    */   PTile1D left;
/*    */   PTile1D right;
/*    */   PTile1D parent;
/*    */   boolean color;
/*    */   
/*    */   PTile1D(int index) {
/* 17 */     this.index = index;
/*    */   }
/*    */   
/*    */   public float getValue() {
/* 21 */     return this.value;
/*    */   }
/*    */   
/*    */   public PTile1D getParent() {
/* 25 */     return this.pathParent;
/*    */   }
/*    */   
/*    */   public final int parents() {
/* 29 */     int p = 0;
/* 30 */     PTile1D pa = this.pathParent;
/* 31 */     while (pa != null) {
/* 32 */       p++;
/* 33 */       pa = pa.pathParent;
/*    */     } 
/* 35 */     return p;
/*    */   }
/*    */   
/*    */   public void parentSet(PTile1D p) {
/* 39 */     this.pathParent = p;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 44 */     return "PathTile: (" + this.index + ")";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\path1D\PTile1D.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */