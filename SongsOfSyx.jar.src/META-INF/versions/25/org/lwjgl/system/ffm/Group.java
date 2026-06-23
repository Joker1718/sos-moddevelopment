/*     */ package META-INF.versions.25.org.lwjgl.system.ffm;
/*     */ 
/*     */ import java.lang.foreign.MemorySegment;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface Group<L extends java.lang.foreign.GroupLayout, T extends org.lwjgl.system.ffm.Group<L, T>>
/*     */ {
/*     */   L layout();
/*     */   
/*     */   long address();
/*     */   
/*     */   T copyFrom(T paramT);
/*     */   
/*     */   T clear();
/*     */   
/*     */   T get(MemorySegment paramMemorySegment);
/*     */   
/*     */   T get(MemorySegment paramMemorySegment, long paramLong);
/*     */   
/*     */   T getAtIndex(MemorySegment paramMemorySegment, long paramLong);
/*     */   
/*     */   T set(MemorySegment paramMemorySegment);
/*     */   
/*     */   T set(MemorySegment paramMemorySegment, long paramLong);
/*     */   
/*     */   T setAtIndex(MemorySegment paramMemorySegment, long paramLong);
/*     */   
/*     */   default long sizeof() {
/* 117 */     return layout().byteSize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default long alignof() {
/* 124 */     return layout().byteAlignment();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MemorySegment asSegment() {
/* 132 */     return 
/* 133 */       MemorySegment.ofAddress(address())
/* 134 */       .reinterpret(layout().byteSize());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\Group.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */