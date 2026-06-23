/*    */ package META-INF.versions.25.org.lwjgl.system.ffm;
/*    */ 
/*    */ import java.lang.foreign.GroupLayout;
/*    */ import java.lang.foreign.MemorySegment;
/*    */ import java.util.Comparator;
/*    */ import java.util.Objects;
/*    */ import java.util.Spliterator;
/*    */ import java.util.function.Consumer;
/*    */ import org.lwjgl.system.ffm.GroupBinder;
/*    */ 
/*    */ 
/*    */ 
/*    */ final class GroupSpliterator<L extends GroupLayout, T>
/*    */   implements Spliterator<T>
/*    */ {
/*    */   private final GroupBinder<L, T> binder;
/*    */   private final MemorySegment segment;
/*    */   private long index;
/*    */   private final long fence;
/*    */   
/*    */   GroupSpliterator(GroupBinder<L, T> binder, MemorySegment segment, long index, long fence) {
/* 22 */     this.binder = binder;
/* 23 */     this.segment = segment;
/* 24 */     this.index = index;
/* 25 */     this.fence = fence;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean tryAdvance(Consumer<? super T> action) {
/* 30 */     Objects.requireNonNull(action);
/*    */     
/* 32 */     if (this.index < this.fence) {
/* 33 */       action.accept((T)this.binder.getAtIndex(this.segment, this.index++));
/* 34 */       return true;
/*    */     } 
/*    */     
/* 37 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public Spliterator<T> trySplit() {
/* 42 */     long lo = this.index;
/* 43 */     long mid = lo + this.fence >>> 1L;
/*    */     
/* 45 */     return (lo < mid) ? 
/* 46 */       new org.lwjgl.system.ffm.GroupSpliterator(this.binder, this.segment, lo, this.index = mid) : 
/* 47 */       null;
/*    */   }
/*    */ 
/*    */   
/*    */   public long estimateSize() {
/* 52 */     return this.fence - this.index;
/*    */   }
/*    */ 
/*    */   
/*    */   public int characteristics() {
/* 57 */     return 17744;
/*    */   }
/*    */ 
/*    */   
/*    */   public void forEachRemaining(Consumer<? super T> action) {
/* 62 */     Objects.requireNonNull(action);
/* 63 */     long i = this.index;
/*    */     try {
/* 65 */       for (; i < this.fence; i++) {
/* 66 */         action.accept((T)this.binder.getAtIndex(this.segment, i));
/*    */       }
/*    */     } finally {
/* 69 */       this.index = i;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Comparator<? super T> getComparator() {
/* 75 */     throw new IllegalStateException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\GroupSpliterator.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */