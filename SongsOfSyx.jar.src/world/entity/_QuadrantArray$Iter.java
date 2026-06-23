/*    */ package world.entity;
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
/*    */   implements Iterator<WEntity>
/*    */ {
/*    */   WEntity current;
/*    */   
/*    */   public boolean hasNext() {
/* 62 */     return (this.current != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public WEntity next() {
/* 67 */     WEntity e = this.current;
/* 68 */     this.current = e.renderNext;
/* 69 */     return e;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\_QuadrantArray$Iter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */