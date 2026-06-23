/*     */ package util.statistics;
/*     */ 
/*     */ import game.time.TIMECYCLE;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMAPS;
/*     */ 
/*     */ public class HistoryObject<T extends MAPPED>
/*     */   implements HISTORY_COLLECTION<T>, INT_O.INT_OE<T>, SAVABLE
/*     */ {
/*     */   private final RMAPS<T> map;
/*     */   private final HistoryInt total;
/*     */   private final HistoryInt[] histories;
/*     */   private final INFO info;
/*     */   
/*     */   public HistoryObject(int size, TIMECYCLE time, boolean keep, RMAPS<T> map) {
/*  22 */     this(null, size, time, keep, map);
/*     */   }
/*     */   
/*     */   public HistoryObject(INFO info, int size, TIMECYCLE time, boolean keep, RMAPS<T> map) {
/*  26 */     this.map = map;
/*  27 */     this.total = new HistoryInt(size, time, keep);
/*  28 */     this.histories = new HistoryInt[map.all().size()];
/*  29 */     for (int i = 0; i < map.all().size(); i++) {
/*  30 */       this.histories[i] = new H((T)map.all().get(i), size, time, keep);
/*     */     }
/*  32 */     this.info = info;
/*     */   }
/*     */   
/*     */   public HistoryObject(int size, TIMECYCLE time, boolean keep, CharSequence name, CharSequence desc, RMAPS<T> map) {
/*  36 */     this(new INFO(name, desc), size, time, keep, map);
/*     */   }
/*     */ 
/*     */   
/*     */   public INFO info() {
/*  41 */     return this.info;
/*     */   }
/*     */ 
/*     */   
/*     */   public HISTORY_INT total() {
/*  46 */     return this.total;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  51 */     this.map.saver().save((SAVABLE[])this.histories, file);
/*  52 */     this.total.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  57 */     this.map.loader().load((SAVABLE[])this.histories, file);
/*  58 */     this.total.load(file);
/*  59 */     this.total.set(0); byte b; int i; HistoryInt[] arrayOfHistoryInt;
/*  60 */     for (i = (arrayOfHistoryInt = this.histories).length, b = 0; b < i; ) { HistoryInt ii = arrayOfHistoryInt[b];
/*  61 */       this.total.inc(ii.get());
/*     */       b++; }
/*     */      } public void clear() { byte b;
/*     */     int i;
/*     */     HistoryInt[] arrayOfHistoryInt;
/*  66 */     for (i = (arrayOfHistoryInt = this.histories).length, b = 0; b < i; ) { HistoryInt historyInt = arrayOfHistoryInt[b];
/*  67 */       historyInt.clear(); b++; }
/*  68 */      this.total.clear(); }
/*     */ 
/*     */   
/*     */   public HISTORY_INT.HISTORY_INTE get(int rI) {
/*  72 */     return this.histories[rI];
/*     */   }
/*     */ 
/*     */   
/*     */   public HISTORY_INT.HISTORY_INTE history(T r) {
/*  77 */     if (r == null)
/*  78 */       return this.total; 
/*  79 */     return get(r.index());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void change(T r, int old, int current) {}
/*     */   
/*     */   private class H
/*     */     extends HistoryInt
/*     */   {
/*     */     final T r;
/*     */     
/*     */     public H(T r, int size, TIMECYCLE c, boolean keep) {
/*  91 */       super(size, c, keep);
/*  92 */       this.r = r;
/*     */     }
/*     */     
/*     */     protected void change(int old, int current) {
/*  96 */       HistoryObject.this.total.inc(-old);
/*  97 */       HistoryObject.this.total.inc(current);
/*  98 */       HistoryObject.this.change(this.r, old, current);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(T t) {
/* 104 */     return history(t).get();
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(T t, int i) {
/* 109 */     history(t).set(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public int min(T t) {
/* 114 */     return Integer.MIN_VALUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max(T t) {
/* 119 */     return Integer.MAX_VALUE;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\statistics\HistoryObject.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */