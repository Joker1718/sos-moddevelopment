/*     */ package snake2d.util.sets;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ public final class MapIntInt
/*     */   implements SAVABLE
/*     */ {
/*     */   private int[] keys;
/*     */   private int[] values;
/*     */   private int size;
/*     */   
/*     */   public MapIntInt() {
/*  17 */     this(16);
/*     */   }
/*     */   
/*     */   public MapIntInt(int initialCapacity) {
/*  21 */     this.keys = Alloc.ii(initialCapacity);
/*  22 */     this.values = Alloc.ii(initialCapacity);
/*  23 */     this.size = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int put(int key, int value) {
/*  31 */     int index = search(key);
/*     */     
/*  33 */     if (index >= 0) {
/*     */       
/*  35 */       this.values[index] = value;
/*  36 */       return index;
/*     */     } 
/*     */ 
/*     */     
/*  40 */     if (this.size >= this.keys.length) {
/*  41 */       grow();
/*     */     }
/*     */ 
/*     */     
/*  45 */     index = -(index + 1);
/*     */     
/*  47 */     for (int i = this.size; i > index; i--) {
/*  48 */       this.keys[i] = this.keys[i - 1];
/*  49 */       this.values[i] = this.values[i - 1];
/*     */     } 
/*     */     
/*  52 */     this.keys[index] = key;
/*  53 */     this.values[index] = value;
/*  54 */     this.size++;
/*  55 */     return index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int get(int key) {
/*  62 */     int index = search(key);
/*  63 */     return (index >= 0) ? this.values[index] : -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOrDefault(int key, int defaultValue) {
/*  70 */     int index = search(key);
/*  71 */     return (index >= 0) ? this.values[index] : defaultValue;
/*     */   }
/*     */   
/*     */   public boolean contains(int key) {
/*  75 */     return (search(key) >= 0);
/*     */   }
/*     */   
/*     */   public int size() {
/*  79 */     return this.size;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  83 */     return (this.size == 0);
/*     */   }
/*     */   
/*     */   public void clear() {
/*  87 */     this.size = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int keyAt(int i) {
/*  94 */     return this.keys[i];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int valueAt(int i) {
/* 101 */     return this.values[i];
/*     */   }
/*     */ 
/*     */   
/*     */   private int search(int key) {
/* 106 */     int low = 0;
/* 107 */     int high = this.size - 1;
/*     */     
/* 109 */     while (low <= high) {
/* 110 */       int mid = low + (high - low) / 2;
/* 111 */       if (this.keys[mid] < key) {
/* 112 */         low = mid + 1; continue;
/* 113 */       }  if (this.keys[mid] > key) {
/* 114 */         high = mid - 1; continue;
/*     */       } 
/* 116 */       return mid;
/*     */     } 
/*     */     
/* 119 */     return -(low + 1);
/*     */   }
/*     */   
/*     */   private void grow() {
/* 123 */     int newCapacity = this.keys.length * 2;
/* 124 */     int[] newKeys = Alloc.ii(newCapacity);
/* 125 */     int[] newValues = Alloc.ii(newCapacity);
/*     */     
/* 127 */     System.arraycopy(this.keys, 0, newKeys, 0, this.size);
/* 128 */     System.arraycopy(this.values, 0, newValues, 0, this.size);
/*     */     
/* 130 */     this.keys = newKeys;
/* 131 */     this.values = newValues;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 138 */     file.i(this.keys.length);
/* 139 */     file.is(this.keys);
/* 140 */     file.is(this.values);
/* 141 */     file.i(this.size);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 146 */     int capacity = file.i();
/* 147 */     this.keys = Alloc.ii(capacity);
/* 148 */     this.values = Alloc.ii(capacity);
/* 149 */     file.is(this.keys);
/* 150 */     file.is(this.values);
/* 151 */     this.size = file.i();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\MapIntInt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */