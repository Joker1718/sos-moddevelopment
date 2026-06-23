/*     */ package snake2d.util.sets;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ public final class MapInt
/*     */   implements SAVABLE
/*     */ {
/*     */   private int[] table;
/*     */   private int last;
/*     */   
/*     */   public MapInt() {
/*  18 */     this(20);
/*     */   }
/*     */   
/*     */   public MapInt(int initialCapacity) {
/*  22 */     this.table = Alloc.ii(initialCapacity);
/*  23 */     this.last = 0;
/*     */   }
/*     */   
/*     */   public void remove(int e) {
/*  27 */     int i = search(e);
/*  28 */     if (i < 0)
/*  29 */       throw new RuntimeException(); 
/*  30 */     this.last--;
/*  31 */     for (; i < this.last; i++) {
/*  32 */       this.table[i] = this.table[i + 1];
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeIndex(int index) {
/*  37 */     if (index < 0 || index >= this.last)
/*  38 */       throw new RuntimeException(); 
/*  39 */     this.last--;
/*  40 */     for (; index < this.last; index++) {
/*  41 */       this.table[index] = this.table[index + 1];
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean contains(int i) {
/*  46 */     return (search(i) >= 0);
/*     */   }
/*     */   
/*     */   public int size() {
/*  50 */     return this.last;
/*     */   }
/*     */   
/*     */   public int atIndex(int i) {
/*  54 */     return this.table[i];
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/*  58 */     return (this.last == 0);
/*     */   }
/*     */   
/*     */   public int poll() {
/*  62 */     this.last--;
/*  63 */     return this.table[this.last];
/*     */   }
/*     */   
/*     */   public int peek() {
/*  67 */     return this.table[this.last - 1];
/*     */   }
/*     */ 
/*     */   
/*     */   public int add(int e) {
/*  72 */     this.last++;
/*  73 */     if (this.last >= this.table.length) {
/*  74 */       int[] table2 = Alloc.ii(this.table.length * 2);
/*  75 */       for (int j = 0; j < this.table.length; j++) {
/*  76 */         table2[j] = this.table[j];
/*     */       }
/*  78 */       this.table = table2;
/*     */     } 
/*  80 */     for (int i = this.last - 1; i >= 0; i--) {
/*  81 */       if (i == 0) {
/*  82 */         this.table[i] = e;
/*  83 */         return 0;
/*     */       } 
/*  85 */       if (e > this.table[i - 1]) {
/*  86 */         this.table[i] = e;
/*  87 */         return i;
/*     */       } 
/*  89 */       if (e == this.table[i - 1])
/*  90 */         throw new RuntimeException(); 
/*  91 */       this.table[i] = this.table[i - 1];
/*     */     } 
/*     */     
/*  94 */     return -1;
/*     */   }
/*     */   
/*     */   public boolean tryAdd(int e) {
/*  98 */     if (!contains(e)) {
/*  99 */       add(e);
/* 100 */       return true;
/*     */     } 
/* 102 */     return false;
/*     */   }
/*     */   
/*     */   private int search(int value) {
/* 106 */     return runBinarySearchIteratively(value, 0, this.last - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   private int runBinarySearchIteratively(int key, int low, int high) {
/* 111 */     while (low <= high) {
/* 112 */       int mid = low + (high - low) / 2;
/* 113 */       if (this.table[mid] < key) {
/* 114 */         low = mid + 1; continue;
/* 115 */       }  if (this.table[mid] > key) {
/* 116 */         high = mid - 1; continue;
/* 117 */       }  if (this.table[mid] == key) {
/* 118 */         return mid;
/*     */       }
/*     */     } 
/* 121 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 126 */     this.last = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 131 */     int[] in = Alloc.ii(500);
/* 132 */     int st = RND.rInt();
/* 133 */     MapInt map = new MapInt();
/* 134 */     int a = 0;
/* 135 */     for (int k = 0; k < in.length; k++) {
/* 136 */       in[k] = st + k;
/* 137 */       if ((k & 0x1) == 0) {
/* 138 */         map.add(in[k]);
/* 139 */         a++;
/*     */       } 
/*     */     }  byte b;
/*     */     int i, arrayOfInt1[];
/* 143 */     for (i = (arrayOfInt1 = in).length, b = 0; b < i; ) { int t = arrayOfInt1[b];
/* 144 */       if (map.contains(t))
/* 145 */         a--;  b++; }
/*     */     
/* 147 */     LOG.ln(String.valueOf(a) + " " + in.length + " " + map.contains(in[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 154 */     file.i(this.table.length);
/* 155 */     file.is(this.table);
/* 156 */     file.i(this.last);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 162 */     this.table = Alloc.ii(file.i());
/* 163 */     file.is(this.table);
/* 164 */     this.last = file.i();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\MapInt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */