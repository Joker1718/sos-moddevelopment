/*    */ package snake2d.util.iterators;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Iterator;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RECIter
/*    */   implements Iterator<COORDINATE>, Iterable<COORDINATE>, COORDINATE, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final RECTANGLE rec;
/*    */   private int ix;
/*    */   private int iy;
/*    */   
/*    */   public RECIter(RECTANGLE rec) {
/* 19 */     this.rec = rec;
/*    */   }
/*    */   
/*    */   public RECIter init() {
/* 23 */     this.ix = this.rec.x1() - 1;
/* 24 */     this.iy = this.rec.y1();
/* 25 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public int x() {
/* 30 */     return this.ix;
/*    */   }
/*    */ 
/*    */   
/*    */   public int y() {
/* 35 */     return this.iy;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasNext() {
/* 40 */     return !(this.ix >= this.rec.x2() - 1 && this.iy >= this.rec.y2() - 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public COORDINATE next() {
/* 45 */     this.ix++;
/* 46 */     if (this.ix >= this.rec.x2()) {
/* 47 */       if (this.iy >= this.rec.y2())
/* 48 */         throw new RuntimeException(); 
/* 49 */       this.iy++;
/* 50 */       this.ix = this.rec.x1();
/*    */     } 
/* 52 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 57 */     return String.valueOf(getClass().getSimpleName()) + " " + this.ix + " " + this.iy;
/*    */   }
/*    */ 
/*    */   
/*    */   public Iterator<COORDINATE> iterator() {
/* 62 */     this.ix = this.rec.x1() - 1;
/* 63 */     this.iy = this.rec.y1();
/* 64 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\iterators\RECIter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */