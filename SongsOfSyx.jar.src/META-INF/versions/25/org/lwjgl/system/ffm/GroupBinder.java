/*     */ package META-INF.versions.25.org.lwjgl.system.ffm;
/*     */ 
/*     */ import java.lang.foreign.Arena;
/*     */ import java.lang.foreign.MemoryLayout;
/*     */ import java.lang.foreign.MemorySegment;
/*     */ import java.lang.foreign.SegmentAllocator;
/*     */ import java.lang.invoke.ConstantCallSite;
/*     */ import java.lang.invoke.MethodHandle;
/*     */ import java.lang.invoke.MethodHandles;
/*     */ import java.lang.invoke.MethodType;
/*     */ import java.lang.invoke.TypeDescriptor;
/*     */ import java.lang.runtime.ObjectMethods;
/*     */ import java.util.Iterator;
/*     */ import java.util.Objects;
/*     */ import java.util.Spliterator;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.stream.Stream;
/*     */ import java.util.stream.StreamSupport;
/*     */ import org.lwjgl.system.SegmentStack;
/*     */ import org.lwjgl.system.ffm.Binder;
/*     */ import org.lwjgl.system.ffm.GroupArray;
/*     */ import org.lwjgl.system.ffm.GroupSpliterator;
/*     */ import org.lwjgl.system.ffm.mapping.GroupMapping;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface GroupBinder<L extends java.lang.foreign.GroupLayout, T>
/*     */   extends Binder<T>, GroupMapping<L>
/*     */ {
/*     */   default long sizeof() {
/* 118 */     return layout().byteSize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default long alignof() {
/* 125 */     return layout().byteAlignment();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default T ofAddressSafe(long address) {
/* 134 */     return (address == 0L) ? null : ofAddress(address);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default long addressOfSafe(T value) {
/* 143 */     return (value == null) ? 0L : addressOf(value);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MemorySegment asSegment(T value) {
/* 215 */     return 
/* 216 */       MemorySegment.ofAddress(addressOf(value))
/* 217 */       .reinterpret(layout().byteSize());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default T malloc(SegmentStack stack) {
/* 227 */     return get(stack.allocate((MemoryLayout)layout()));
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
/*     */   default T allocate(SegmentStack stack) {
/* 246 */     return get(stack.calloc((MemoryLayout)layout()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default T allocate(SegmentAllocator allocator) {
/* 256 */     return get(allocator.allocate((MemoryLayout)layout()));
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
/*     */   default void forEach(MemorySegment segment, Consumer<? super T> action) {
/* 312 */     Objects.requireNonNull(action);
/*     */     
/* 314 */     long sizeof = sizeof();
/* 315 */     long fence = segment.byteSize(); long offset;
/* 316 */     for (offset = 0L; offset + sizeof <= fence; offset += sizeof) {
/* 317 */       action.accept(get(segment, offset));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default Iterable<T> iterable(MemorySegment segment) {
/* 329 */     return () -> iterator(segment);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default Iterator<T> iterator(MemorySegment segment) {
/* 340 */     return (Iterator<T>)new Object(this, segment);
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
/*     */   default Spliterator<T> spliterator(MemorySegment segment) {
/* 373 */     return (Spliterator<T>)new GroupSpliterator(this, segment, 0L, segment.byteSize() / sizeof());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default Stream<T> stream(MemorySegment segment) {
/* 384 */     return StreamSupport.stream(spliterator(segment), false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default Stream<T> parallelStream(MemorySegment segment) {
/* 395 */     return StreamSupport.stream(spliterator(segment), true);
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
/*     */   default MemorySegment asSlice(MemorySegment segment, long index) {
/* 409 */     return segment.asSlice(layout().byteSize() * index);
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
/*     */   default MemorySegment asSlice(MemorySegment segment, long index, long elementCount) {
/* 422 */     long sizeof = layout().byteSize();
/* 423 */     return segment.asSlice(sizeof * index, sizeof * elementCount, layout().byteAlignment());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default MemorySegment reinterpret(MemorySegment addr) {
/* 434 */     return addr.reinterpret(layout().byteSize());
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
/*     */   default MemorySegment reinterpret(MemorySegment addr, long elementCount) {
/* 446 */     return addr.reinterpret(layout().byteSize() * elementCount);
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
/*     */   default MemorySegment reinterpret(MemorySegment addr, Arena arena, Consumer<MemorySegment> cleanup) {
/* 458 */     return addr.reinterpret(layout().byteSize(), arena, cleanup);
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
/*     */   default MemorySegment reinterpret(MemorySegment addr, long elementCount, Arena arena, Consumer<MemorySegment> cleanup) {
/* 472 */     return addr.reinterpret(layout().byteSize() * elementCount, arena, cleanup);
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
/*     */   static Object bootstrapRecord(MethodHandles.Lookup lookup, String methodName, TypeDescriptor type, String names, String... getterNames) throws Throwable {
/*     */     Object callSite;
/* 498 */     Class<?> recordClass = lookup.lookupClass();
/*     */     
/* 500 */     MethodType methodType = (MethodType)type;
/*     */ 
/*     */     
/* 503 */     MethodHandle[] methodHandles = new MethodHandle[getterNames.length];
/* 504 */     for (int i = 0; i < getterNames.length; i++) {
/* 505 */       methodHandles[i] = lookup.unreflect(recordClass.getDeclaredMethod(getterNames[i], new Class[0]));
/*     */     }
/*     */ 
/*     */     
/* 509 */     if ("toString".equals(methodName)) {
/*     */       
/* 511 */       Class<?> recordInterface = recordClass.getInterfaces()[0];
/* 512 */       for (int j = 0; j < methodHandles.length; j++) {
/* 513 */         methodHandles[j] = methodHandles[j].asType(methodHandles[j].type().changeParameterType(0, recordInterface));
/*     */       }
/*     */ 
/*     */       
/* 517 */       callSite = ObjectMethods.bootstrap(lookup, methodName, methodType, recordInterface, names, methodHandles);
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 523 */       MethodHandle adapted = ((ConstantCallSite)ObjectMethods.bootstrap(lookup, methodName, methodType.changeParameterType(0, recordClass), recordClass, names, methodHandles)).getTarget().asType(methodType);
/*     */ 
/*     */       
/* 526 */       callSite = new ConstantCallSite(adapted);
/*     */     } 
/* 528 */     return callSite;
/*     */   }
/*     */   
/*     */   L layout();
/*     */   
/*     */   T ofAddress(long paramLong);
/*     */   
/*     */   long addressOf(T paramT);
/*     */   
/*     */   T copy(T paramT1, T paramT2);
/*     */   
/*     */   T clear(T paramT);
/*     */   
/*     */   T get(MemorySegment paramMemorySegment);
/*     */   
/*     */   T get(MemorySegment paramMemorySegment, long paramLong);
/*     */   
/*     */   T getAtIndex(MemorySegment paramMemorySegment, long paramLong);
/*     */   
/*     */   org.lwjgl.system.ffm.GroupBinder<L, T> set(MemorySegment paramMemorySegment, T paramT);
/*     */   
/*     */   org.lwjgl.system.ffm.GroupBinder<L, T> set(MemorySegment paramMemorySegment, long paramLong, T paramT);
/*     */   
/*     */   org.lwjgl.system.ffm.GroupBinder<L, T> setAtIndex(MemorySegment paramMemorySegment, long paramLong, T paramT);
/*     */   
/*     */   GroupArray<L, T> array(MemorySegment paramMemorySegment);
/*     */   
/*     */   GroupArray<L, T> array(MemorySegment paramMemorySegment, long paramLong);
/*     */   
/*     */   GroupArray<L, T> array(MemorySegment paramMemorySegment, long paramLong1, long paramLong2);
/*     */   
/*     */   GroupArray<L, T> malloc(SegmentStack paramSegmentStack, long paramLong);
/*     */   
/*     */   GroupArray<L, T> allocate(SegmentStack paramSegmentStack, long paramLong);
/*     */   
/*     */   GroupArray<L, T> allocate(SegmentAllocator paramSegmentAllocator, long paramLong);
/*     */   
/*     */   org.lwjgl.system.ffm.GroupBinder<L, T> apply(MemorySegment paramMemorySegment, long paramLong, Consumer<T> paramConsumer);
/*     */   
/*     */   org.lwjgl.system.ffm.GroupBinder<L, T> applyAtIndex(MemorySegment paramMemorySegment, long paramLong, Consumer<T> paramConsumer);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\ffm\GroupBinder.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */