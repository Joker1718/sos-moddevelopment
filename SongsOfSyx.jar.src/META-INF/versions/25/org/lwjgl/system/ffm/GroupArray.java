/*     */ package META-INF.versions.25.org.lwjgl.system.ffm;
/*     */ 
/*     */ import java.lang.foreign.MemorySegment;
/*     */ import java.util.Iterator;
/*     */ import java.util.Spliterator;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.stream.Stream;
/*     */ import org.lwjgl.system.Pointer;
/*     */ import org.lwjgl.system.ffm.GroupBinder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface GroupArray<L extends java.lang.foreign.GroupLayout, T>
/*     */   extends Pointer, Iterable<T>
/*     */ {
/*     */   long address();
/*     */   
/*     */   GroupBinder<L, T> binder();
/*     */   
/*     */   MemorySegment segment();
/*     */   
/*     */   T get(long paramLong);
/*     */   
/*     */   org.lwjgl.system.ffm.GroupArray<L, T> set(long paramLong, T paramT);
/*     */   
/*     */   <GA extends org.lwjgl.system.ffm.GroupArray<L, T>> org.lwjgl.system.ffm.GroupArray<L, T> copy(long paramLong1, GA paramGA, long paramLong2, long paramLong3);
/*     */   
/*     */   void clear(long paramLong1, long paramLong2);
/*     */   
/*     */   org.lwjgl.system.ffm.GroupArray<L, T> apply(long paramLong, Consumer<T> paramConsumer);
/*     */   
/*     */   org.lwjgl.system.ffm.GroupArray<L, T> slice(long paramLong);
/*     */   
/*     */   org.lwjgl.system.ffm.GroupArray<L, T> slice(long paramLong1, long paramLong2);
/*     */   
/*     */   default long length() {
/* 121 */     return segment().byteSize() / binder().sizeof();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default <GA extends org.lwjgl.system.ffm.GroupArray<L, T>> org.lwjgl.system.ffm.GroupArray<L, T> copy(GA dst) {
/* 132 */     return copy(0L, dst, 0L, length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default <GA extends org.lwjgl.system.ffm.GroupArray<L, T>> org.lwjgl.system.ffm.GroupArray<L, T> copy(GA dst, long length) {
/* 144 */     return copy(0L, dst, 0L, length);
/*     */   }
/*     */   
/*     */   default void clear() {
/* 148 */     clear(0L, length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default long sizeof() {
/* 155 */     return binder().sizeof() * length();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default long alignof() {
/* 162 */     return binder().alignof();
/*     */   }
/*     */   
/*     */   default void forEach(Consumer<? super T> action) {
/* 166 */     binder().forEach(segment(), action);
/*     */   }
/*     */ 
/*     */   
/*     */   default Iterator<T> iterator() {
/* 171 */     return binder().iterator(segment());
/*     */   }
/*     */ 
/*     */   
/*     */   default Spliterator<T> spliterator() {
/* 176 */     return binder().spliterator(segment());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default Stream<T> stream() {
/* 185 */     return binder().stream(segment());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default Stream<T> parallelStream() {
/* 194 */     return binder().parallelStream(segment());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\GroupArray.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */