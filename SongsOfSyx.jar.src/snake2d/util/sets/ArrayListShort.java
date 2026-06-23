/*     */ package snake2d.util.sets;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
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
/*     */ public class ArrayListShort
/*     */   implements Serializable, SAVABLE
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final short[] es;
/*     */   private final int size;
/*  25 */   private int last = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayListShort(int size) {
/*  33 */     this.size = size;
/*  34 */     this.es = new short[size];
/*     */   }
/*     */   
/*     */   public int get(int index) {
/*  38 */     if (index < this.last)
/*  39 */       return this.es[index]; 
/*  40 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int add(int e) {
/*  49 */     if (!hasRoom())
/*  50 */       throw new RuntimeException("I'm full!"); 
/*  51 */     this.es[this.last] = (short)e;
/*  52 */     this.last++;
/*  53 */     return this.last - 1;
/*     */   }
/*     */   
/*     */   public void set(int e, int index) {
/*  57 */     if (index >= this.last)
/*  58 */       throw new RuntimeException(); 
/*  59 */     this.es[index] = (short)e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int remove(int index) {
/*  69 */     if (index >= this.last) {
/*  70 */       throw new RuntimeException();
/*     */     }
/*  72 */     int res = this.es[index];
/*     */     
/*  74 */     if (index == this.last - 1) {
/*  75 */       this.es[this.last - 1] = -1;
/*  76 */       this.last--;
/*     */     } else {
/*  78 */       this.es[index] = this.es[this.last - 1];
/*  79 */       this.es[this.last - 1] = -1;
/*  80 */       this.last--;
/*     */     } 
/*  82 */     return res;
/*     */   }
/*     */   
/*     */   public void removeShort(short s) {
/*  86 */     for (int i = 0; i < size(); i++) {
/*  87 */       if (get(i) == s) {
/*  88 */         remove(i);
/*     */         return;
/*     */       } 
/*     */     } 
/*  92 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public int remainingSlots() {
/*  96 */     return this.size - this.last;
/*     */   }
/*     */   
/*     */   public boolean hasRoom() {
/* 100 */     return (remainingSlots() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 105 */     this.last = 0;
/*     */   }
/*     */   
/*     */   public int size() {
/* 109 */     return this.last;
/*     */   }
/*     */   
/*     */   public int max() {
/* 113 */     return this.size;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 117 */     return (this.last <= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 122 */     file.ss(this.es);
/* 123 */     file.i(this.last);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 128 */     file.ss(this.es);
/* 129 */     this.last = file.i();
/*     */   }
/*     */   
/*     */   public void reverse() {
/* 133 */     int s = size() / 2;
/* 134 */     for (int i = 0; i < s; i++) {
/* 135 */       short o = this.es[i];
/* 136 */       this.es[i] = this.es[size() - 1 - i];
/* 137 */       this.es[size() - 1 - i] = o;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean contains(short s) {
/* 142 */     for (int i = 0; i < size(); i++) {
/* 143 */       if (get(i) == s) {
/* 144 */         return true;
/*     */       }
/*     */     } 
/* 147 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\ArrayListShort.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */