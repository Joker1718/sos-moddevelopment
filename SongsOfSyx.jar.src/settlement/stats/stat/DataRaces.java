/*     */ package settlement.stats.stat;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import util.statistics.HISTORY_INT;
/*     */ 
/*     */ 
/*     */ public abstract class DataRaces
/*     */   implements HISTORY_INT.HISTORY_INT_OBJECT<Race>, SAVABLE
/*     */ {
/*  21 */   private int bitSinceStart = -1;
/*  22 */   private final int[][] data = Alloc.i2(33, RACES.all().size());
/*  23 */   private final int[] total = Alloc.ii(33);
/*     */   private final boolean clear;
/*     */   
/*     */   public DataRaces(String key, StatsInit init, boolean clear) {
/*  27 */     init.savers.put(key, this);
/*  28 */     this.clear = clear;
/*     */   }
/*     */   
/*     */   void set(Race r, int a) {
/*  32 */     init();
/*  33 */     if (r == null) {
/*  34 */       this.total[0] = a;
/*     */     } else {
/*  36 */       this.data[0][r.index] = a;
/*     */     } 
/*     */   }
/*     */   public void incrFull(Induvidual i, int d) {
/*  40 */     init();
/*  41 */     this.data[0][(i.race()).index] = this.data[0][(i.race()).index] + d;
/*  42 */     this.total[0] = this.total[0] + d;
/*     */   }
/*     */   
/*     */   private void pushday() {
/*  46 */     for (int i = 31; i > 0; i--) {
/*  47 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/*  48 */         this.data[i][ri] = this.data[i - 1][ri];
/*     */       }
/*  50 */       this.total[i] = this.total[i - 1];
/*     */     } 
/*     */   }
/*     */   
/*     */   private void init() {
/*  55 */     if (this.bitSinceStart == TIME.days().bitsSinceStart()) {
/*     */       return;
/*     */     }
/*  58 */     int am = Math.abs(this.bitSinceStart - TIME.days().bitsSinceStart());
/*  59 */     if (am > 0)
/*  60 */       for (int i = 0; i < am; i++) {
/*  61 */         pushday();
/*     */       } 
/*  63 */     this.bitSinceStart = TIME.days().bitsSinceStart();
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  68 */     file.i(this.bitSinceStart);
/*  69 */     file.isE(this.data);
/*  70 */     file.isE(this.total);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  75 */     this.bitSinceStart = file.i();
/*  76 */     file.isE(this.data);
/*  77 */     file.isE(this.total);
/*  78 */     if (this.clear) {
/*  79 */       this.total[0] = 0;
/*  80 */       Arrays.fill(this.data[0], 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  86 */     for (int i = 0; i < (this.data[0]).length; i++)
/*  87 */       this.data[0][i] = 0; 
/*  88 */     this.total[0] = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(Race group, int daysBack) {
/*  93 */     init();
/*  94 */     if (group == null)
/*  95 */       return this.total[daysBack]; 
/*  96 */     return this.data[daysBack][group.index];
/*     */   }
/*     */ 
/*     */   
/*     */   public TIMECYCLE time() {
/* 101 */     return (TIMECYCLE)TIME.days();
/*     */   }
/*     */ 
/*     */   
/*     */   public int historyRecords() {
/* 106 */     return 32;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\DataRaces.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */