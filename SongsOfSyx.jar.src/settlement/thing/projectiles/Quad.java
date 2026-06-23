/*    */ package settlement.thing.projectiles;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.sets.ArrayListInt;
/*    */ 
/*    */ 
/*    */ final class Quad
/*    */ {
/* 10 */   private int first = -1;
/*    */   
/*    */   private final int qx;
/*    */   
/*    */   private final int qy;
/*    */ 
/*    */   
/*    */   public Quad(int qx, int qy) {
/* 18 */     this.qx = qx;
/* 19 */     this.qy = qy;
/*    */   }
/*    */   
/*    */   void add(int index) {
/* 23 */     (SETT.PROJS()).data.nextSet(index, this.first);
/* 24 */     this.first = index;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void remove(int e) {
/* 30 */     int first = this.first;
/* 31 */     this.first = -1;
/*    */ 
/*    */     
/* 34 */     while (first != -1) {
/* 35 */       int ee = first;
/* 36 */       first = (SETT.PROJS()).data.next(first);
/* 37 */       if (ee != e) {
/* 38 */         (SETT.PROJS()).data.nextSet(ee, this.first);
/* 39 */         this.first = ee;
/*    */       } 
/*    */     } 
/*    */     
/* 43 */     (SETT.PROJS()).data.nextSet(e, -1);
/*    */   }
/*    */   
/*    */   boolean contains(int e) {
/* 47 */     int di = this.first;
/* 48 */     while (di != -1) {
/* 49 */       if (di == e)
/* 50 */         return true; 
/* 51 */       di = (SETT.PROJS()).data.next(di);
/*    */     } 
/* 53 */     return false;
/*    */   }
/*    */   
/*    */   void clear() {
/* 57 */     this.first = -1;
/*    */   }
/*    */ 
/*    */   
/*    */   void fill(RECTANGLE bounds, ArrayListInt result) {
/* 62 */     int di = this.first;
/* 63 */     while (di != -1 && result.hasRoom()) {
/* 64 */       PData.Data data = (SETT.PROJS()).data.data(di);
/* 65 */       if (bounds.holdsPoint(data.x(), data.y())) {
/* 66 */         result.add(di);
/*    */       }
/* 68 */       di = (SETT.PROJS()).data.next(di);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\projectiles\Quad.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */