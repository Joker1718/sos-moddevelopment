/*    */ package settlement.thing.halfEntity;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class Iter
/*    */   implements Iterator<HalfEntity>
/*    */ {
/*    */   HalfEntity current;
/*    */   
/*    */   public boolean hasNext() {
/* 62 */     return (this.current != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public HalfEntity next() {
/* 67 */     HalfEntity e = this.current;
/* 68 */     this.current = e.renderNext;
/* 69 */     return e;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\_Quadrant$Iter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */