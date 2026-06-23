/*     */ package META-INF.versions.25.org.lwjgl.system;
/*     */ 
/*     */ import java.lang.foreign.MemorySegment;
/*     */ import java.util.Arrays;
/*     */ import java.util.Objects;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.SegmentStack;
/*     */ import org.lwjgl.system.StackWalkUtil;
/*     */ import org.lwjgl.system.ffm.StackAllocator;
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
/*     */ class DebugMemoryStack
/*     */   extends SegmentStack
/*     */ {
/*     */   private Object[] debugFrames;
/*     */   
/*     */   DebugMemoryStack(MemorySegment container) {
/* 157 */     super(container);
/* 158 */     this.debugFrames = new Object[8];
/*     */   }
/*     */ 
/*     */   
/*     */   public SegmentStack push() {
/* 163 */     if (this.frameIndex == this.debugFrames.length) {
/* 164 */       frameOverflow();
/*     */     }
/*     */     
/* 167 */     this.debugFrames[this.frameIndex] = StackWalkUtil.stackWalkGetMethod(SegmentStack.class);
/*     */     
/* 169 */     return super.push();
/*     */   }
/*     */   
/*     */   private void frameOverflow() {
/* 173 */     this.debugFrames = Arrays.copyOf(this.debugFrames, this.debugFrames.length * 3 / 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public SegmentStack pop() {
/* 178 */     Object pushed = Objects.requireNonNull(this.debugFrames[this.frameIndex - 1]);
/* 179 */     Object popped = StackWalkUtil.stackWalkCheckPop(SegmentStack.class, pushed);
/* 180 */     if (popped != null) {
/* 181 */       reportAsymmetricPop(pushed, popped);
/*     */     }
/*     */     
/* 184 */     this.debugFrames[this.frameIndex - 1] = null;
/* 185 */     return super.pop();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 191 */     this.debugFrames[this.frameIndex - 1] = null;
/* 192 */     super.pop();
/*     */   }
/*     */   
/*     */   private static void reportAsymmetricPop(Object pushed, Object popped) {
/* 196 */     APIUtil.DEBUG_STREAM.format("[LWJGL] Asymmetric pop detected:\n\tPUSHED: %s\n\tPOPPED: %s\n\tTHREAD: %s\n", new Object[] { pushed, popped, 
/*     */ 
/*     */ 
/*     */           
/* 200 */           Thread.currentThread() });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\SegmentStack$DebugMemoryStack.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */