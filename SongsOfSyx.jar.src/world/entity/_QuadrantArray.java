/*    */ package world.entity;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ 
/*    */ 
/*    */ 
/*    */ class _QuadrantArray
/*    */   implements Iterable<WEntity>
/*    */ {
/*    */   private WEntity first;
/*    */   private WEntity last;
/*    */   private final Iter iter;
/*    */   
/*    */   void add(WEntity e) {
/*    */     if (this.first == null) {
/*    */       this.first = e;
/*    */       this.last = e;
/*    */     } else {
/*    */       this.last.renderNext = e;
/*    */       this.last = e;
/*    */     } 
/*    */   }
/*    */   
/*    */   void remove(WEntity e) {
/*    */     WEntity f = this.first;
/*    */     this.first = null;
/*    */     this.last = null;
/*    */     boolean removed = false;
/*    */     while (f != null) {
/*    */       WEntity n = f.renderNext;
/*    */       f.renderNext = null;
/*    */       if (f == e) {
/*    */         removed = true;
/*    */       } else {
/*    */         add(f);
/*    */       } 
/*    */       f = n;
/*    */     } 
/*    */     if (!removed)
/*    */       throw new RuntimeException(); 
/*    */   }
/*    */   
/*    */   void clear() {
/*    */     this.first = null;
/*    */     this.last = null;
/*    */   }
/*    */   
/*    */   public Iterator<WEntity> iterator() {
/*    */     this.iter.current = this.first;
/*    */     return this.iter;
/*    */   }
/*    */   
/*    */   _QuadrantArray() {
/* 54 */     this.iter = new Iter();
/*    */   }
/*    */ 
/*    */   
/*    */   private final class Iter
/*    */     implements Iterator<WEntity>
/*    */   {
/*    */     public boolean hasNext() {
/* 62 */       return (this.current != null);
/*    */     }
/*    */ 
/*    */     
/*    */     public WEntity next() {
/* 67 */       WEntity e = this.current;
/* 68 */       this.current = e.renderNext;
/* 69 */       return e;
/*    */     }
/*    */     
/*    */     WEntity current;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\_QuadrantArray.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */