/*     */ package META-INF.versions.25.org.lwjgl.system;
/*     */ 
/*     */ import java.lang.foreign.Arena;
/*     */ import java.lang.foreign.MemoryLayout;
/*     */ import java.lang.foreign.MemorySegment;
/*     */ import java.lang.foreign.SequenceLayout;
/*     */ import java.lang.foreign.ValueLayout;
/*     */ import java.util.Arrays;
/*     */ import java.util.Objects;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.Configuration;
/*     */ import org.lwjgl.system.SegmentStack;
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
/*     */ public class SegmentStack
/*     */   implements StackAllocator<SegmentStack>, AutoCloseable
/*     */ {
/*  27 */   private static final long DEFAULT_STACK_SIZE = ((Integer)Configuration.STACK_SIZE.get(Integer.valueOf(64))).intValue() * 1024L;
/*     */   
/*     */   private static final int DEFAULT_STACK_FRAMES = 8;
/*  30 */   private static final ThreadLocal<SegmentStack> TLS = ThreadLocal.withInitial(SegmentStack::create);
/*     */   
/*     */   static {
/*  33 */     if (DEFAULT_STACK_SIZE < 0L) {
/*  34 */       throw new IllegalStateException("Invalid stack size.");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final MemorySegment container;
/*     */ 
/*     */   
/*     */   private final long size;
/*     */ 
/*     */   
/*     */   private long pointer;
/*     */ 
/*     */   
/*     */   private long[] frames;
/*     */   
/*     */   protected int frameIndex;
/*     */ 
/*     */   
/*     */   protected SegmentStack(MemorySegment container) {
/*  55 */     this.container = container;
/*     */     
/*  57 */     this.size = container.byteSize();
/*  58 */     this.pointer = container.byteSize();
/*     */     
/*  60 */     this.frames = new long[8];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SegmentStack create() {
/*  69 */     return create(DEFAULT_STACK_SIZE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SegmentStack create(long capacity) {
/*  80 */     return create(Arena.ofAuto().allocate(capacity));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SegmentStack create(MemorySegment segment) {
/*  91 */     return ((Boolean)Configuration.DEBUG_STACK.get(Boolean.valueOf(false))).booleanValue() ? 
/*  92 */       (SegmentStack)new DebugMemoryStack(segment) : 
/*  93 */       new SegmentStack(segment);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SegmentStack push() {
/* 113 */     if (this.frameIndex == this.frames.length) {
/* 114 */       frameOverflow();
/*     */     }
/*     */     
/* 117 */     this.frames[this.frameIndex++] = this.pointer;
/* 118 */     return this;
/*     */   }
/*     */   
/*     */   private void frameOverflow() {
/* 122 */     if (Checks.DEBUG) {
/* 123 */       APIUtil.apiLog("[WARNING] Out of frame stack space (" + this.frames.length + ") in thread: " + String.valueOf(Thread.currentThread()));
/*     */     }
/* 125 */     this.frames = Arrays.copyOf(this.frames, this.frames.length * 3 / 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SegmentStack pop() {
/* 135 */     this.pointer = this.frames[--this.frameIndex];
/* 136 */     return this;
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
/*     */   public void close() {
/* 148 */     pop();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getAddress() {
/* 212 */     return this.container.address();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getSize() {
/* 221 */     return this.container.byteSize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFrameIndex() {
/* 230 */     return this.frameIndex;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPointerAddress() {
/* 235 */     return this.container.address() + this.pointer;
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
/*     */   public long getPointer() {
/* 247 */     return this.pointer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPointer(long pointer) {
/* 257 */     if (Checks.CHECKS) {
/* 258 */       checkPointer(pointer);
/*     */     }
/*     */     
/* 261 */     this.pointer = pointer;
/*     */   }
/*     */   
/*     */   private void checkPointer(long pointer) {
/* 265 */     if (pointer < 0L || this.size < pointer) {
/* 266 */       throw new IndexOutOfBoundsException("Invalid stack pointer");
/*     */     }
/*     */   }
/*     */   
/*     */   private static void checkAlignment(long alignment) {
/* 271 */     if (Long.bitCount(alignment) != 1) {
/* 272 */       throw new IllegalArgumentException("Alignment must be a power-of-two value.");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MemorySegment allocate(long byteSize) {
/* 279 */     return allocate(byteSize, ValueLayout.ADDRESS.byteAlignment());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MemorySegment allocate(long byteSize, long byteAlignment) {
/* 285 */     if (Checks.DEBUG) {
/* 286 */       checkAlignment(byteAlignment);
/*     */     }
/*     */     
/* 289 */     long address = this.container.address() + this.pointer - byteSize & -byteAlignment;
/*     */     
/* 291 */     this.pointer = address - this.container.address();
/* 292 */     if (Checks.CHECKS && this.pointer < 0L) {
/* 293 */       throw new OutOfMemoryError("Out of stack space.");
/*     */     }
/*     */     
/* 296 */     return this.container.asSlice(this.pointer, byteSize, 1L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MemorySegment allocate(MemoryLayout layout) {
/* 305 */     Objects.requireNonNull(layout);
/* 306 */     return allocate(layout.byteSize(), layout.byteAlignment());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MemorySegment allocate(MemoryLayout elementLayout, long count) {
/* 313 */     Objects.requireNonNull(elementLayout);
/* 314 */     if (count < 0L) {
/* 315 */       throw new IllegalArgumentException("Negative array size");
/*     */     }
/* 317 */     SequenceLayout layout = MemoryLayout.sequenceLayout(count, elementLayout);
/* 318 */     return allocate(layout.byteSize(), layout.byteAlignment());
/*     */   }
/*     */ 
/*     */   
/*     */   public MemorySegment calloc(long byteSize) {
/* 323 */     return allocate(byteSize)
/* 324 */       .fill((byte)0);
/*     */   }
/*     */ 
/*     */   
/*     */   public MemorySegment calloc(long byteSize, long byteAlignment) {
/* 329 */     return allocate(byteSize, byteAlignment)
/* 330 */       .fill((byte)0);
/*     */   }
/*     */ 
/*     */   
/*     */   public MemorySegment calloc(MemoryLayout layout) {
/* 335 */     return allocate(layout)
/* 336 */       .fill((byte)0);
/*     */   }
/*     */ 
/*     */   
/*     */   public MemorySegment calloc(MemoryLayout elementLayout, long count) {
/* 341 */     return allocate(elementLayout, count)
/* 342 */       .fill((byte)0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SegmentStack stackGet() {
/* 351 */     return TLS.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SegmentStack stackPush() {
/* 361 */     return stackGet().push();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\SegmentStack.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */