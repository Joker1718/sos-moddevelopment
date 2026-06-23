/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Objects;
/*     */ import java.util.Spliterator;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.stream.Stream;
/*     */ import java.util.stream.StreamSupport;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class StructBuffer<T extends Struct<T>, SELF extends StructBuffer<T, SELF>>
/*     */   extends CustomBuffer<SELF>
/*     */   implements Iterable<T>
/*     */ {
/*     */   protected StructBuffer(ByteBuffer container, int remaining) {
/*  21 */     super(MemoryUtil.memAddress(container), container, -1, 0, remaining, remaining);
/*     */   }
/*     */   
/*     */   protected StructBuffer(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
/*  25 */     super(address, container, mark, position, limit, capacity);
/*     */   }
/*     */ 
/*     */   
/*     */   public int sizeof() {
/*  30 */     return getElementFactory().sizeof();
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
/*     */   public T get() {
/*  44 */     T factory = getElementFactory();
/*  45 */     return factory.create(this.address + Integer.toUnsignedLong(nextGetIndex()) * factory.sizeof(), this.container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SELF get(T value) {
/*  56 */     int sizeof = getElementFactory().sizeof();
/*  57 */     MemoryUtil.memCopy(this.address + Integer.toUnsignedLong(nextGetIndex()) * sizeof, value.address(), sizeof);
/*  58 */     return self();
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
/*     */   public SELF put(T value) {
/*  74 */     int sizeof = getElementFactory().sizeof();
/*  75 */     MemoryUtil.memCopy(value.address(), this.address + Integer.toUnsignedLong(nextPutIndex()) * sizeof, sizeof);
/*  76 */     return self();
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
/*     */   public T get(int index) {
/*  92 */     T factory = getElementFactory();
/*  93 */     return factory.create(this.address + Integer.toUnsignedLong(check(index, this.limit)) * factory.sizeof(), this.container);
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
/*     */   public SELF get(int index, T value) {
/* 106 */     int sizeof = getElementFactory().sizeof();
/* 107 */     MemoryUtil.memCopy(this.address + Checks.check(index, this.limit) * sizeof, value.address(), sizeof);
/* 108 */     return self();
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
/*     */   public SELF put(int index, T value) {
/* 125 */     int sizeof = getElementFactory().sizeof();
/* 126 */     MemoryUtil.memCopy(value.address(), this.address + Checks.check(index, this.limit) * sizeof, sizeof);
/* 127 */     return self();
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
/*     */   public SELF apply(Consumer<T> consumer) {
/* 140 */     consumer.accept(get());
/* 141 */     return self();
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
/*     */   public SELF apply(int index, Consumer<T> consumer) {
/* 156 */     consumer.accept(get(index));
/* 157 */     return self();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<T> iterator() {
/* 164 */     return new StructIterator<>(this.address, this.container, getElementFactory(), this.position, this.limit);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class StructIterator<T extends Struct<T>>
/*     */     implements Iterator<T>
/*     */   {
/*     */     private long address;
/*     */     
/*     */     private ByteBuffer container;
/*     */     
/*     */     private T factory;
/*     */     
/*     */     private int index;
/*     */     private int fence;
/*     */     
/*     */     StructIterator(long address, ByteBuffer container, T factory, int position, int limit) {
/* 181 */       this.address = address;
/* 182 */       this.container = container;
/* 183 */       this.factory = factory;
/* 184 */       this.index = position;
/* 185 */       this.fence = limit;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 189 */       return (this.index < this.fence);
/*     */     }
/*     */     
/*     */     public T next() {
/* 193 */       if (Checks.CHECKS && this.fence <= this.index) {
/* 194 */         throw new NoSuchElementException();
/*     */       }
/* 196 */       return this.factory.create(this.address + Integer.toUnsignedLong(this.index++) * this.factory.sizeof(), this.container);
/*     */     }
/*     */     
/*     */     public void forEachRemaining(Consumer<? super T> action) {
/* 200 */       Objects.requireNonNull(action);
/* 201 */       int i = this.index;
/*     */       try {
/* 203 */         for (int sizeof = this.factory.sizeof(); i < this.fence; i++) {
/* 204 */           action.accept(this.factory.create(this.address + Integer.toUnsignedLong(i) * sizeof, this.container));
/*     */         }
/*     */       } finally {
/* 207 */         this.index = i;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void forEach(Consumer<? super T> action) {
/* 214 */     Objects.requireNonNull(action);
/* 215 */     T factory = getElementFactory();
/* 216 */     for (int i = this.position, fence = this.limit, sizeof = factory.sizeof(); i < fence; i++) {
/* 217 */       action.accept(factory.create(this.address + Integer.toUnsignedLong(i) * sizeof(), this.container));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Spliterator<T> spliterator() {
/* 223 */     return new StructSpliterator<>(this.address, this.container, getElementFactory(), this.position, this.limit);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class StructSpliterator<T extends Struct<T>>
/*     */     implements Spliterator<T>
/*     */   {
/*     */     private long address;
/*     */     private ByteBuffer container;
/*     */     private T factory;
/*     */     private int index;
/*     */     private int fence;
/*     */     
/*     */     StructSpliterator(long address, ByteBuffer container, T factory, int position, int limit) {
/* 237 */       this.address = address;
/* 238 */       this.container = container;
/* 239 */       this.factory = factory;
/* 240 */       this.index = position;
/* 241 */       this.fence = limit;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean tryAdvance(Consumer<? super T> action) {
/* 246 */       Objects.requireNonNull(action);
/*     */       
/* 248 */       if (this.index < this.fence) {
/* 249 */         action.accept(this.factory.create(this.address + Integer.toUnsignedLong(this.index++) * this.factory.sizeof(), this.container));
/* 250 */         return true;
/*     */       } 
/*     */       
/* 253 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Spliterator<T> trySplit() {
/* 258 */       int lo = this.index;
/* 259 */       int mid = lo + this.fence >>> 1;
/*     */       
/* 261 */       return (lo < mid) ? new StructSpliterator(this.address, this.container, this.factory, lo, this.index = mid) : null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long estimateSize() {
/* 268 */       return (this.fence - this.index);
/*     */     }
/*     */ 
/*     */     
/*     */     public int characteristics() {
/* 273 */       return 17744;
/*     */     }
/*     */ 
/*     */     
/*     */     public void forEachRemaining(Consumer<? super T> action) {
/* 278 */       Objects.requireNonNull(action);
/* 279 */       int i = this.index;
/*     */       try {
/* 281 */         for (int sizeof = this.factory.sizeof(); i < this.fence; i++) {
/* 282 */           action.accept(this.factory.create(this.address + Integer.toUnsignedLong(i) * sizeof, this.container));
/*     */         }
/*     */       } finally {
/* 285 */         this.index = i;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public Comparator<? super T> getComparator() {
/* 291 */       throw new IllegalStateException();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Stream<T> stream() {
/* 297 */     return StreamSupport.stream(spliterator(), false);
/*     */   }
/*     */ 
/*     */   
/*     */   public Stream<T> parallelStream() {
/* 302 */     return StreamSupport.stream(spliterator(), true);
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract T getElementFactory();
/*     */ 
/*     */   
/*     */   private static int check(int index, int length) {
/* 310 */     if (Checks.CHECKS && (index < 0 || length <= index)) {
/* 311 */       throw new IndexOutOfBoundsException();
/*     */     }
/* 313 */     return index;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\StructBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */