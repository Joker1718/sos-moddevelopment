/*    */ package snake2d.util.datatypes;
/*    */ 
/*    */ import snake2d.util.file.Alloc;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Interval
/*    */ {
/*    */   private int[] x1;
/*    */   private int[] x2;
/*    */   
/*    */   public void add(int a, int b) {
/* 15 */     if (this.x1 == null) {
/* 16 */       this.x1 = new int[] { a };
/* 17 */       this.x2 = new int[] { b };
/*    */       return;
/*    */     } 
/* 20 */     int[] newX1 = Alloc.ii(this.x1.length + 1);
/* 21 */     int[] newX2 = Alloc.ii(this.x2.length + 1);
/* 22 */     int count = 0;
/*    */     int i;
/* 24 */     for (i = 0; i < newX1.length - 1; i++) {
/* 25 */       if (a <= this.x2[i] && b >= this.x1[i]) {
/* 26 */         a = (a < this.x1[i]) ? a : this.x1[i];
/* 27 */         b = (b > this.x2[i]) ? b : this.x2[i];
/*    */       } else {
/*    */         
/* 30 */         newX1[count] = this.x1[i];
/* 31 */         newX2[count] = this.x2[i];
/* 32 */         count++;
/*    */       } 
/*    */     } 
/* 35 */     newX1[count] = a;
/* 36 */     newX2[count] = b;
/*    */     
/* 38 */     this.x1 = Alloc.ii(count + 1);
/* 39 */     this.x2 = Alloc.ii(count + 1);
/*    */     
/* 41 */     for (i = 0; i < this.x1.length; i++) {
/* 42 */       this.x1[i] = newX1[i];
/* 43 */       this.x2[i] = newX2[i];
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean holds(int x) {
/* 50 */     if (this.x1 == null) {
/* 51 */       return false;
/*    */     }
/* 53 */     for (int i = 0; i < this.x1.length; i++) {
/* 54 */       if (x >= this.x1[i] && x < this.x2[i])
/* 55 */         return true; 
/*    */     } 
/* 57 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isEmpty() {
/* 63 */     return (this.x1 == null);
/*    */   }
/*    */   
/*    */   public void clear() {
/* 67 */     this.x1 = null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\datatypes\Interval.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */