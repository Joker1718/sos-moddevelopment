/*     */ package snake2d.util.sets;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class QueueInteger
/*     */   implements Serializable, SAVABLE
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final int[] queue;
/*     */   private int front;
/*  20 */   private int rear = -1;
/*  21 */   private int currentSize = 0;
/*     */   
/*     */   public QueueInteger(int size) {
/*  24 */     this.queue = Alloc.ii(size + 1);
/*  25 */     clear();
/*     */   }
/*     */   
/*     */   public void push(int i) {
/*  29 */     if (!hasRoom())
/*  30 */       throw new RuntimeException(); 
/*  31 */     this.rear++;
/*  32 */     if (this.rear == this.queue.length - 1) {
/*  33 */       this.rear = 0;
/*     */     }
/*  35 */     this.queue[this.rear] = i;
/*  36 */     this.currentSize++;
/*     */   }
/*     */   
/*     */   public boolean hasNext() {
/*  40 */     return (this.currentSize > 0 && this.front >= 0);
/*     */   }
/*     */   
/*     */   public int peek() {
/*  44 */     if (!hasNext()) {
/*  45 */       throw new RuntimeException();
/*     */     }
/*  47 */     int tmp = this.queue[this.front];
/*  48 */     return tmp;
/*     */   }
/*     */   
/*     */   public int poll() {
/*  52 */     if (!hasNext()) {
/*  53 */       throw new RuntimeException();
/*     */     }
/*  55 */     int tmp = this.queue[this.front];
/*  56 */     this.currentSize--;
/*  57 */     this.front++;
/*  58 */     if (this.front == this.queue.length - 1) {
/*  59 */       this.front = 0;
/*     */     }
/*  61 */     return tmp;
/*     */   }
/*     */   
/*     */   public boolean hasRoom() {
/*  65 */     return (this.currentSize < this.queue.length - 1);
/*     */   }
/*     */   
/*     */   public boolean isFull() {
/*  69 */     return (remaining() == 0);
/*     */   }
/*     */   
/*     */   public int remaining() {
/*  73 */     return capacity() - size();
/*     */   }
/*     */   
/*     */   public int capacity() {
/*  77 */     return this.queue.length - 1;
/*     */   }
/*     */   
/*     */   public int size() {
/*  81 */     return this.currentSize;
/*     */   }
/*     */   
/*     */   public boolean contains(int i) {
/*  85 */     int f = this.front;
/*  86 */     int c = this.currentSize;
/*  87 */     while (c > 0) {
/*  88 */       if (this.queue[f] == i)
/*  89 */         return true; 
/*  90 */       c--;
/*  91 */       f++;
/*  92 */       if (f == this.queue.length - 1) {
/*  93 */         f = 0;
/*     */       }
/*     */     } 
/*  96 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 101 */     this.front = 0;
/* 102 */     this.rear = -1;
/* 103 */     this.currentSize = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 110 */     file.is(this.queue);
/* 111 */     file.i(this.front);
/* 112 */     file.i(this.rear);
/* 113 */     file.i(this.currentSize);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 119 */     file.is(this.queue);
/* 120 */     this.front = file.i();
/* 121 */     this.rear = file.i();
/* 122 */     this.currentSize = file.i();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\QueueInteger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */