/*     */ package snake2d.util.sets;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.NoSuchElementException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ 
/*     */ public class ArrayListShortResize
/*     */   implements SAVABLE
/*     */ {
/*     */   private short[] es;
/*     */   private final int maxSize;
/*     */   private final int minSize;
/*  16 */   private int last = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayListShortResize(int minSize, int maxSize) {
/*  23 */     this.maxSize = maxSize;
/*  24 */     this.minSize = minSize;
/*  25 */     this.es = new short[minSize];
/*     */   }
/*     */   
/*     */   private void increase() {
/*  29 */     if (this.last == this.es.length - 1 && this.es.length != this.maxSize) {
/*  30 */       int size = this.es.length * 2;
/*  31 */       if (size > this.maxSize)
/*  32 */         size = this.maxSize; 
/*  33 */       short[] esNew = new short[size];
/*  34 */       for (int i = 0; i < this.last; i++) {
/*  35 */         esNew[i] = this.es[i];
/*     */       }
/*  37 */       this.es = esNew;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void decrease() {
/*  42 */     if (this.es.length != this.minSize && this.last < this.es.length / 2) {
/*  43 */       int size = this.es.length / 2;
/*  44 */       if (size < this.minSize)
/*  45 */         size = this.minSize; 
/*  46 */       short[] esNew = new short[size];
/*  47 */       for (int i = 0; i < this.last; i++) {
/*  48 */         esNew[i] = this.es[i];
/*     */       }
/*  50 */       this.es = esNew;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int get(int index) {
/*  55 */     if (index < this.last)
/*  56 */       return this.es[index]; 
/*  57 */     throw new NoSuchElementException("no element at index: " + index);
/*     */   }
/*     */ 
/*     */   
/*     */   public int add(short e) {
/*  62 */     increase();
/*  63 */     if (!hasRoom())
/*  64 */       return -1; 
/*  65 */     this.es[this.last] = e;
/*  66 */     this.last++;
/*  67 */     return this.last - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean remove(int i) {
/*  77 */     if (i >= this.last) {
/*  78 */       return false;
/*     */     }
/*  80 */     if (i == this.last - 1) {
/*  81 */       this.last--;
/*  82 */       decrease();
/*  83 */       return true;
/*     */     } 
/*     */     
/*  86 */     this.es[i] = this.es[this.last - 1];
/*  87 */     this.last--;
/*  88 */     decrease();
/*  89 */     return true;
/*     */   }
/*     */   
/*     */   public void removeShort(short s) {
/*  93 */     remove(indexOf(s));
/*     */   }
/*     */   
/*     */   public int indexOf(short s) {
/*  97 */     for (int i = 0; i < this.last; i++) {
/*  98 */       if (this.es[i] == s)
/*  99 */         return i; 
/* 100 */     }  return -1;
/*     */   }
/*     */   
/*     */   public int remainingSlots() {
/* 104 */     return this.maxSize - this.last;
/*     */   }
/*     */   
/*     */   public boolean hasRoom() {
/* 108 */     return (remainingSlots() > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 116 */     if (this.es.length != this.minSize)
/* 117 */       this.es = new short[this.minSize]; 
/* 118 */     this.last = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 123 */     file.i(this.es.length);
/* 124 */     file.i(this.last);
/* 125 */     file.ss(this.es);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 130 */     int l = file.i();
/* 131 */     this.last = file.i();
/* 132 */     if (this.es.length != l)
/* 133 */       this.es = new short[l]; 
/* 134 */     file.ss(this.es);
/*     */   }
/*     */   
/*     */   public int size() {
/* 138 */     return this.last;
/*     */   }
/*     */   
/*     */   public int max() {
/* 142 */     return this.maxSize;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 146 */     return (this.last == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void trim() {
/* 151 */     short[] no = new short[this.last];
/* 152 */     for (int i = 0; i < this.last; i++)
/* 153 */       no[i] = this.es[i]; 
/* 154 */     this.es = no;
/*     */   }
/*     */   
/*     */   public int getLast() {
/* 158 */     return get(this.last - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void swap(int indexA, int indexB) {
/* 163 */     if (indexA < 0 || indexB >= size() || indexB < 0 || indexB >= size())
/* 164 */       throw new RuntimeException(); 
/* 165 */     short a = this.es[indexA];
/* 166 */     this.es[indexA] = this.es[indexB];
/* 167 */     this.es[indexB] = a;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\ArrayListShortResize.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */