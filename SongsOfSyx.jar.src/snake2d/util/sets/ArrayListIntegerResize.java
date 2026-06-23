/*     */ package snake2d.util.sets;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.NoSuchElementException;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ 
/*     */ public class ArrayListIntegerResize
/*     */   implements SAVABLE
/*     */ {
/*     */   private int[] es;
/*     */   private final int maxSize;
/*     */   private final int minSize;
/*  17 */   private int last = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayListIntegerResize(int minSize, int maxSize) {
/*  24 */     this.maxSize = maxSize;
/*  25 */     this.minSize = minSize;
/*  26 */     this.es = Alloc.ii(minSize);
/*     */   }
/*     */   
/*     */   private void increase() {
/*  30 */     if (this.last == this.es.length - 1 && this.es.length != this.maxSize) {
/*  31 */       int size = this.es.length * 2;
/*  32 */       if (size > this.maxSize)
/*  33 */         size = this.maxSize; 
/*  34 */       int[] esNew = Alloc.ii(size);
/*  35 */       for (int i = 0; i < this.last; i++) {
/*  36 */         esNew[i] = this.es[i];
/*     */       }
/*  38 */       this.es = esNew;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void decrease() {
/*  43 */     if (this.es.length != this.minSize && this.last < this.es.length / 2) {
/*  44 */       int size = this.es.length / 2;
/*  45 */       if (size < this.minSize)
/*  46 */         size = this.minSize; 
/*  47 */       int[] esNew = Alloc.ii(size);
/*  48 */       for (int i = 0; i < this.last; i++) {
/*  49 */         esNew[i] = this.es[i];
/*     */       }
/*  51 */       this.es = esNew;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int get(int index) {
/*  56 */     if (index < this.last)
/*  57 */       return this.es[index]; 
/*  58 */     throw new NoSuchElementException("no element at index: " + index);
/*     */   }
/*     */ 
/*     */   
/*     */   public int add(int e) {
/*  63 */     increase();
/*  64 */     if (!hasRoom())
/*  65 */       return -1; 
/*  66 */     this.es[this.last] = e;
/*  67 */     this.last++;
/*  68 */     return this.last - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean remove(int i) {
/*  78 */     if (i >= this.last) {
/*  79 */       return false;
/*     */     }
/*  81 */     if (i == this.last - 1) {
/*  82 */       this.last--;
/*  83 */       decrease();
/*  84 */       return true;
/*     */     } 
/*     */     
/*  87 */     this.es[i] = this.es[this.last - 1];
/*  88 */     this.last--;
/*  89 */     decrease();
/*  90 */     return true;
/*     */   }
/*     */   
/*     */   public int remainingSlots() {
/*  94 */     return this.maxSize - this.last;
/*     */   }
/*     */   
/*     */   public boolean hasRoom() {
/*  98 */     return (remainingSlots() > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 106 */     if (this.es.length != this.minSize)
/* 107 */       this.es = Alloc.ii(this.minSize); 
/* 108 */     this.last = 0;
/*     */   }
/*     */   
/*     */   public int size() {
/* 112 */     return this.last;
/*     */   }
/*     */   
/*     */   public int max() {
/* 116 */     return this.maxSize;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 120 */     return (this.last == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void trim() {
/* 125 */     int[] no = Alloc.ii(this.last);
/* 126 */     for (int i = 0; i < this.last; i++)
/* 127 */       no[i] = this.es[i]; 
/* 128 */     this.es = no;
/*     */   }
/*     */   
/*     */   public int getLast() {
/* 132 */     return get(this.last - 1);
/*     */   }
/*     */   
/*     */   public void swap(int indexA, int indexB) {
/* 136 */     if (indexA < 0 || indexB >= size() || indexB < 0 || indexB >= size())
/* 137 */       throw new RuntimeException(); 
/* 138 */     int a = this.es[indexA];
/* 139 */     this.es[indexA] = this.es[indexB];
/* 140 */     this.es[indexB] = a;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 145 */     file.i(this.last);
/* 146 */     for (int i = 0; i < size(); i++) {
/* 147 */       file.i(get(i));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 153 */     clear();
/* 154 */     int m = file.i();
/* 155 */     for (int i = 0; i < m; i++)
/* 156 */       add(file.i()); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\ArrayListIntegerResize.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */