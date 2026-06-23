/*     */ package META-INF.versions.25.org.lwjgl.system.ffm.mapping;
/*     */ 
/*     */ import java.lang.foreign.MemorySegment;
/*     */ import java.lang.foreign.SegmentAllocator;
/*     */ import org.lwjgl.system.SegmentStack;
/*     */ import org.lwjgl.system.ffm.mapping.Mapping;
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
/*     */ public interface DataMapping<L extends java.lang.foreign.MemoryLayout>
/*     */   extends Mapping<L>
/*     */ {
/*     */   org.lwjgl.system.ffm.mapping.DataMapping<L> withByteAlignment(long paramLong);
/*     */   
/*     */   default Mapping.Sequence array(long elementCount) {
/*  35 */     return new Mapping.Sequence(this, elementCount);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MemorySegment mallocSegment(SegmentStack stack) {
/*  45 */     return stack.allocate(layout());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MemorySegment mallocSegment(SegmentStack stack, long elementCount) {
/*  55 */     return stack.allocate(layout(), elementCount);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MemorySegment allocateSegment(SegmentStack stack) {
/*  64 */     return stack.calloc(layout());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MemorySegment allocateSegment(SegmentAllocator allocator) {
/*  74 */     return allocator.allocate(layout());
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
/*     */ 
/*     */ 
/*     */   
/*     */   default MemorySegment allocateSegment(SegmentStack stack, long elementCount) {
/*  89 */     return stack.calloc(layout(), elementCount);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MemorySegment allocateSegment(SegmentAllocator allocator, long elementCount) {
/* 100 */     return allocator.allocate(layout(), elementCount);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\mapping\DataMapping.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */