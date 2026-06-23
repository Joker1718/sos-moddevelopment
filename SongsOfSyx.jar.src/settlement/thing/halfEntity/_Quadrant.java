/*    */ package settlement.thing.halfEntity;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ 
/*    */ 
/*    */ class _Quadrant
/*    */   implements Iterable<HalfEntity>
/*    */ {
/*    */   private HalfEntity first;
/*    */   private HalfEntity last;
/*    */   private final Iter iter;
/*    */   
/*    */   void add(HalfEntity e) {
/*    */     e.renderNext = null;
/*    */     if (this.first == null) {
/*    */       this.first = e;
/*    */       this.last = e;
/*    */     } else {
/*    */       this.last.renderNext = e;
/*    */       this.last = e;
/*    */     } 
/*    */   }
/*    */   
/*    */   void remove(HalfEntity e) {
/*    */     HalfEntity f = this.first;
/*    */     this.first = null;
/*    */     this.last = null;
/*    */     boolean removed = false;
/*    */     while (f != null) {
/*    */       HalfEntity n = f.renderNext;
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
/*    */   public Iterator<HalfEntity> iterator() {
/*    */     this.iter.current = this.first;
/*    */     return this.iter;
/*    */   }
/*    */   
/*    */   _Quadrant() {
/* 54 */     this.iter = new Iter();
/*    */   }
/*    */ 
/*    */   
/*    */   private final class Iter
/*    */     implements Iterator<HalfEntity>
/*    */   {
/*    */     public boolean hasNext() {
/* 62 */       return (this.current != null);
/*    */     }
/*    */ 
/*    */     
/*    */     public HalfEntity next() {
/* 67 */       HalfEntity e = this.current;
/* 68 */       this.current = e.renderNext;
/* 69 */       return e;
/*    */     }
/*    */     
/*    */     HalfEntity current;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\_Quadrant.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */