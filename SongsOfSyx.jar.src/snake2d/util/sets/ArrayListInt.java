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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArrayListInt
/*     */   implements Serializable, SAVABLE
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final int[] es;
/*     */   private final int size;
/*  26 */   private int last = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayListInt(int size) {
/*  34 */     this.size = size;
/*  35 */     this.es = Alloc.ii(size);
/*     */   }
/*     */   
/*     */   public int get(int index) {
/*  39 */     if (index < this.last)
/*  40 */       return this.es[index]; 
/*  41 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int add(int e) {
/*  50 */     if (!hasRoom())
/*  51 */       throw new RuntimeException("I'm full!"); 
/*  52 */     this.es[this.last] = e;
/*  53 */     this.last++;
/*  54 */     return this.last - 1;
/*     */   }
/*     */   
/*     */   public void set(int e, int index) {
/*  58 */     if (index >= this.last)
/*  59 */       throw new RuntimeException(); 
/*  60 */     this.es[index] = e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int remove(int index) {
/*  70 */     if (index >= this.last) {
/*  71 */       throw new RuntimeException();
/*     */     }
/*  73 */     int res = this.es[index];
/*     */     
/*  75 */     if (index == this.last - 1) {
/*  76 */       this.es[this.last - 1] = -1;
/*  77 */       this.last--;
/*     */     } else {
/*  79 */       this.es[index] = this.es[this.last - 1];
/*  80 */       this.es[this.last - 1] = -1;
/*  81 */       this.last--;
/*     */     } 
/*  83 */     return res;
/*     */   }
/*     */   
/*     */   public void removeShort(short s) {
/*  87 */     for (int i = 0; i < size(); i++) {
/*  88 */       if (get(i) == s) {
/*  89 */         remove(i);
/*     */         return;
/*     */       } 
/*     */     } 
/*  93 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public int remainingSlots() {
/*  97 */     return this.size - this.last;
/*     */   }
/*     */   
/*     */   public boolean hasRoom() {
/* 101 */     return (remainingSlots() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 106 */     this.last = 0;
/*     */   }
/*     */   
/*     */   public int size() {
/* 110 */     return this.last;
/*     */   }
/*     */   
/*     */   public int max() {
/* 114 */     return this.size;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 118 */     return (this.last <= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 123 */     file.is(this.es);
/* 124 */     file.i(this.last);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 129 */     file.is(this.es);
/* 130 */     this.last = file.i();
/*     */   }
/*     */   
/*     */   public void reverse() {
/* 134 */     int s = size() / 2;
/* 135 */     for (int i = 0; i < s; i++) {
/* 136 */       int o = this.es[i];
/* 137 */       this.es[i] = this.es[size() - 1 - i];
/* 138 */       this.es[size() - 1 - i] = o;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean contains(int s) {
/* 143 */     for (int i = 0; i < size(); i++) {
/* 144 */       if (get(i) == s) {
/* 145 */         return true;
/*     */       }
/*     */     } 
/* 148 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\ArrayListInt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */