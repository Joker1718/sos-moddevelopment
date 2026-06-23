/*     */ package snake2d.util.sets;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class MapIndexed<T extends INDEXED>
/*     */   implements ADDABLE<T>
/*     */ {
/*  14 */   private INDEXED[] table = new INDEXED[0];
/*  15 */   private int last = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MapIndexed(INDEXED[] ts) {
/*  23 */     this.table = new INDEXED[ts.length];
/*  24 */     this.last = this.table.length;
/*  25 */     for (int i = 0; i < this.table.length; i++)
/*  26 */       this.table[i] = ts[i]; 
/*  27 */     Arrays.sort(this.table, new Comparator<INDEXED>()
/*     */         {
/*     */           public int compare(INDEXED o1, INDEXED o2)
/*     */           {
/*  31 */             return o1.index() - o2.index();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T get(int hash) {
/*  39 */     return (T)this.table[search(hash)];
/*     */   }
/*     */ 
/*     */   
/*     */   public T getTry(int index) {
/*  44 */     int ss = search(index);
/*  45 */     if (ss >= 0)
/*  46 */       return (T)this.table[ss]; 
/*  47 */     return null;
/*     */   }
/*     */   
/*     */   public void remove(int hash) {
/*  51 */     int i = search(hash);
/*  52 */     if (i < 0)
/*  53 */       throw new RuntimeException(); 
/*  54 */     this.last--;
/*  55 */     for (; i < this.last; i++) {
/*  56 */       this.table[i] = this.table[i + 1];
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean contains(T object) {
/*  61 */     return (search(object.index()) >= 0);
/*     */   }
/*     */   
/*     */   public boolean contains(int hash) {
/*  65 */     return (search(hash) >= 0);
/*     */   }
/*     */   
/*     */   public int size() {
/*  69 */     return this.last;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  73 */     return (this.last == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int add(T e) {
/*  78 */     this.last++;
/*  79 */     if (this.last >= this.table.length) {
/*  80 */       INDEXED[] table2 = new INDEXED[this.table.length + 1];
/*  81 */       for (int j = 0; j < this.table.length; j++) {
/*  82 */         table2[j] = this.table[j];
/*     */       }
/*  84 */       this.table = table2;
/*     */     } 
/*  86 */     for (int i = this.last - 1; i >= 0; i--) {
/*  87 */       if (i == 0) {
/*  88 */         this.table[i] = (INDEXED)e;
/*  89 */         return 0;
/*     */       } 
/*  91 */       if (e.index() > this.table[i - 1].index()) {
/*  92 */         this.table[i] = (INDEXED)e;
/*  93 */         return i;
/*     */       } 
/*  95 */       if (e.index() == this.table[i - 1].index())
/*  96 */         throw new RuntimeException(); 
/*  97 */       this.table[i] = this.table[i - 1];
/*     */     } 
/*     */     
/* 100 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasRoom() {
/* 105 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int tryAdd(T e) {
/* 110 */     return add(e);
/*     */   }
/*     */   
/*     */   private int search(int value) {
/* 114 */     return runBinarySearchIteratively(value, 0, this.last - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   private int runBinarySearchIteratively(int key, int low, int high) {
/* 119 */     while (low <= high) {
/* 120 */       int mid = low + (high - low) / 2;
/* 121 */       if (this.table[mid].index() < key) {
/* 122 */         low = mid + 1; continue;
/* 123 */       }  if (this.table[mid].index() > key) {
/* 124 */         high = mid - 1; continue;
/* 125 */       }  if (this.table[mid].index() == key) {
/* 126 */         return mid;
/*     */       }
/*     */     } 
/* 129 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<T> toList() {
/* 134 */     ArrayList<T> tt = new ArrayList<>(this.last);
/* 135 */     for (int i = 0; i < this.last; i++)
/* 136 */       tt.add((T)this.table[i]); 
/* 137 */     return tt;
/*     */   }
/*     */   
/*     */   public MapIndexed() {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\MapIndexed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */