/*    */ package settlement.path.components;
/*    */ 
/*    */ import snake2d.util.sets.ArrayList;
/*    */ 
/*    */ public final class SComponentEdge
/*    */ {
/*    */   private SComponentEdge next;
/*    */   private SComponent to;
/*    */   private float cost;
/*    */   private float distance;
/* 11 */   private static ArrayList<SComponentEdge> chache = new ArrayList(2048);
/* 12 */   private static int count = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SComponent to() {
/* 20 */     return this.to;
/*    */   }
/*    */   
/*    */   public double cost2() {
/* 24 */     return this.cost;
/*    */   }
/*    */   
/*    */   public double distance() {
/* 28 */     return this.distance;
/*    */   }
/*    */   
/*    */   void retire() {
/* 32 */     this.next = null;
/* 33 */     this.to = null;
/* 34 */     count--;
/* 35 */     if (chache.hasRoom())
/* 36 */       chache.add(this); 
/*    */   }
/*    */   
/*    */   static SComponentEdge create(SComponent to, double cost, double distance, SComponentEdge next) {
/* 40 */     count++;
/* 41 */     SComponentEdge e = null;
/* 42 */     if (!chache.isEmpty()) {
/* 43 */       e = (SComponentEdge)chache.removeLast();
/*    */     } else {
/* 45 */       e = new SComponentEdge();
/* 46 */     }  e.to = to;
/* 47 */     e.cost = (float)cost;
/* 48 */     e.distance = (float)distance;
/* 49 */     e.next = next;
/* 50 */     return e;
/*    */   }
/*    */   
/*    */   static int count() {
/* 54 */     return count;
/*    */   }
/*    */   
/*    */   void setNext(SComponentEdge e) {
/* 58 */     this.next = e;
/*    */   }
/*    */   
/*    */   public SComponentEdge next() {
/* 62 */     return this.next;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SComponentEdge.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */