/*     */ package util.statistics;
/*     */ 
/*     */ import game.time.TIMECYCLE;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.data.DOUBLE;
/*     */ import util.info.INFO;
/*     */ 
/*     */ public class HistoryInt
/*     */   implements HISTORY_INT.HISTORY_INTE, SAVABLE {
/*     */   private final int[] history;
/*  18 */   private int bitSinceStart = -1;
/*     */   private final TIMECYCLE c;
/*     */   private final boolean keep;
/*     */   private INFO info;
/*     */   private final int max;
/*     */   
/*     */   public HistoryInt(int size, TIMECYCLE c, boolean keep) {
/*  25 */     this(null, null, size, c, keep, 2147483647);
/*     */   }
/*     */   
/*     */   public HistoryInt(CharSequence name, CharSequence desc, int size, TIMECYCLE c, boolean keep) {
/*  29 */     this(name, desc, size, c, keep, 2147483647);
/*     */   }
/*     */   
/*     */   public HistoryInt(CharSequence name, CharSequence desc, int size, TIMECYCLE c, boolean keep, int max) {
/*  33 */     this.history = Alloc.ii(size);
/*  34 */     this.bitSinceStart = c.bitsSinceStart();
/*  35 */     this.c = c;
/*  36 */     this.keep = keep;
/*  37 */     if (name != null)
/*  38 */       this.info = new INFO(name, desc); 
/*  39 */     this.max = max;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(int fromZero) {
/*  44 */     update();
/*  45 */     int i = this.history.length - 1 - fromZero;
/*  46 */     i = CLAMP.i(i, 0, this.history.length - 1);
/*  47 */     return this.history[i];
/*     */   }
/*     */   
/*     */   private void update() {
/*  51 */     if (this.bitSinceStart == this.c.bitsSinceStart()) {
/*     */       return;
/*     */     }
/*  54 */     int d = Math.abs(this.c.bitsSinceStart() - this.bitSinceStart);
/*     */     
/*  56 */     int dd = 0;
/*  57 */     if (this.keep) {
/*  58 */       dd = this.history[this.history.length - 1];
/*     */     }
/*     */     
/*  61 */     if (d >= this.history.length) {
/*  62 */       for (int i = 0; i < this.history.length; i++)
/*  63 */         this.history[i] = dd; 
/*     */     } else {
/*  65 */       int i; for (i = 0; i + d < this.history.length; i++) {
/*  66 */         this.history[i] = this.history[i + d];
/*     */       }
/*  68 */       for (i = this.history.length - d; i < this.history.length; i++)
/*  69 */         this.history[i] = dd; 
/*     */     } 
/*  71 */     this.bitSinceStart = this.c.bitsSinceStart();
/*     */   }
/*     */ 
/*     */   
/*     */   public final TIMECYCLE time() {
/*  76 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  81 */     update();
/*  82 */     file.is(this.history);
/*  83 */     file.i(this.bitSinceStart);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  88 */     file.is(this.history);
/*  89 */     this.bitSinceStart = file.i();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  94 */     for (int i = 0; i < this.history.length; i++) {
/*  95 */       this.history[i] = 0;
/*     */     }
/*  97 */     this.bitSinceStart = this.c.bitsSinceStart();
/*     */   }
/*     */   
/*     */   public void randomize() {
/* 101 */     for (int i = 0; i < this.history.length; i++) {
/* 102 */       this.history[i] = RND.rInt(50000);
/*     */     }
/*     */   }
/*     */   
/*     */   public void add(HistoryInt other) {
/* 107 */     for (int i = 0; i < other.history.length && i < this.history.length; i++) {
/* 108 */       this.history[i] = this.history[i] + other.history[i];
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void set(int amount) {
/* 114 */     update();
/* 115 */     int old = this.history[this.history.length - 1];
/* 116 */     this.history[this.history.length - 1] = CLAMP.i(amount, min(), max());
/* 117 */     change(old, this.history[this.history.length - 1]);
/*     */   }
/*     */   
/*     */   public void fill(int amount) {
/* 121 */     Arrays.fill(this.history, amount);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void change(int old, int current) {}
/*     */ 
/*     */   
/*     */   public int get() {
/* 130 */     return get(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int min() {
/* 135 */     return Integer.MIN_VALUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max() {
/* 140 */     return this.max;
/*     */   }
/*     */ 
/*     */   
/*     */   public int historyRecords() {
/* 145 */     return this.history.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getD(int fromZero) {
/* 150 */     return get(fromZero) / max();
/*     */   }
/*     */ 
/*     */   
/*     */   public INFO info() {
/* 155 */     return this.info;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\statistics\HistoryInt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */