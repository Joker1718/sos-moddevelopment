/*    */ package snake2d.util.iterators;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.Coo;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ 
/*    */ 
/*    */ public class RECedgeIter
/*    */   implements Iterator<COORDINATE>, Iterable<COORDINATE>
/*    */ {
/*    */   private int x1;
/*    */   private int x2;
/*    */   private int y1;
/* 15 */   public static final RECedgeIter TMP = new RECedgeIter(); private int y2; private int w; private int x; private int y;
/* 16 */   private final Coo res = new Coo();
/*    */   
/*    */   public RECedgeIter init(RECTANGLE r) {
/* 19 */     return init(r.x1(), r.x2(), r.y1(), r.y2());
/*    */   }
/*    */   
/*    */   public RECedgeIter init(int x1, int x2, int y1, int y2) {
/* 23 */     this.x = x1;
/* 24 */     this.y = y1;
/* 25 */     this.x1 = x1;
/* 26 */     this.x2 = x2;
/* 27 */     this.y1 = y1;
/* 28 */     this.y2 = y2;
/* 29 */     this.w = x2 - x1 - 1;
/* 30 */     if (this.w < 1)
/* 31 */       this.w = 1; 
/* 32 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hasNext() {
/* 37 */     return (this.x < this.x2 && this.y < this.y2);
/*    */   }
/*    */ 
/*    */   
/*    */   public COORDINATE next() {
/* 42 */     this.res.set(this.x, this.y);
/* 43 */     if (this.y == this.y1 || this.y == this.y2 - 1) {
/* 44 */       this.x++;
/*    */     } else {
/* 46 */       this.x += this.w;
/*    */     } 
/*    */     
/* 49 */     if (this.x >= this.x2) {
/* 50 */       this.x = this.x1;
/* 51 */       this.y++;
/*    */     } 
/* 53 */     return (COORDINATE)this.res;
/*    */   }
/*    */ 
/*    */   
/*    */   public Iterator<COORDINATE> iterator() {
/* 58 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\iterators\RECedgeIter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */