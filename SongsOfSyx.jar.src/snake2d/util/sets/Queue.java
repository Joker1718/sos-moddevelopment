/*     */ package snake2d.util.sets;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ 
/*     */ public final class Queue<T>
/*     */   implements Iterable<T> {
/*     */   private final Object[] queue;
/*     */   private int front;
/*   9 */   private int rear = -1;
/*  10 */   private int currentSize = 0;
/*     */ 
/*     */   
/*     */   private final Iter iter;
/*     */ 
/*     */ 
/*     */   
/*     */   public void push(T i) {
/*  18 */     if (!hasRoom())
/*  19 */       throw new RuntimeException(); 
/*  20 */     this.rear++;
/*  21 */     if (this.rear == this.queue.length - 1) {
/*  22 */       this.rear = 0;
/*     */     }
/*  24 */     this.queue[this.rear] = i;
/*  25 */     this.currentSize++;
/*     */   }
/*     */   
/*     */   public boolean hasNext() {
/*  29 */     return (this.currentSize > 0 && this.front >= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public T peek() {
/*  34 */     if (!hasNext()) {
/*  35 */       throw new RuntimeException();
/*     */     }
/*  37 */     return (T)this.queue[this.front];
/*     */   }
/*     */ 
/*     */   
/*     */   public T poll() {
/*  42 */     if (!hasNext()) {
/*  43 */       throw new RuntimeException();
/*     */     }
/*  45 */     Object tmp = this.queue[this.front];
/*  46 */     this.currentSize--;
/*  47 */     this.front++;
/*  48 */     if (this.front == this.queue.length - 1) {
/*  49 */       this.front = 0;
/*     */     }
/*  51 */     return (T)tmp;
/*     */   }
/*     */   
/*     */   public boolean hasRoom() {
/*  55 */     return (this.currentSize < this.queue.length - 1);
/*     */   }
/*     */   
/*     */   public boolean isFull() {
/*  59 */     return (remaining() == 0);
/*     */   }
/*     */   
/*     */   public int remaining() {
/*  63 */     return capacity() - size();
/*     */   }
/*     */   
/*     */   public int capacity() {
/*  67 */     return this.queue.length - 1;
/*     */   }
/*     */   
/*     */   public int size() {
/*  71 */     return this.currentSize;
/*     */   }
/*     */   
/*     */   public boolean contains(T i) {
/*  75 */     int f = this.front;
/*  76 */     int c = this.currentSize;
/*  77 */     while (c > 0) {
/*  78 */       if (this.queue[f] == i)
/*  79 */         return true; 
/*  80 */       c--;
/*  81 */       f++;
/*  82 */       if (f == this.queue.length - 1) {
/*  83 */         f = 0;
/*     */       }
/*     */     } 
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public void clear() {
/*  90 */     this.front = 0;
/*  91 */     this.rear = -1;
/*  92 */     this.currentSize = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<T> iterator() {
/*  97 */     this.iter.ii = 0;
/*  98 */     this.iter.f = this.front;
/*  99 */     return this.iter;
/*     */   }
/*     */   public Queue(int size) {
/* 102 */     this.iter = new Iter(null);
/*     */     this.queue = new Object[size + 1];
/*     */     clear();
/*     */   }
/* 106 */   private class Iter implements Iterator<T> { int ii = 0;
/* 107 */     int f = 0;
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 111 */       return (this.ii < Queue.this.currentSize && this.f >= 0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public T next() {
/* 118 */       Object tmp = Queue.this.queue[this.f];
/* 119 */       this.ii++;
/* 120 */       this.f++;
/* 121 */       if (this.f == Queue.this.queue.length - 1) {
/* 122 */         this.f = 0;
/*     */       }
/* 124 */       return (T)tmp;
/*     */     }
/*     */     
/*     */     private Iter() {} }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\Queue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */