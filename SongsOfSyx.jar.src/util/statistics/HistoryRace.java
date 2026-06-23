/*     */ package util.statistics;
/*     */ 
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ 
/*     */ public class HistoryRace
/*     */   implements HISTORY_COLLECTION<Race>, INT_O.INT_OE<Race>, SAVABLE
/*     */ {
/*     */   private final HistoryInt total;
/*  17 */   private final HistoryInt[] histories = new HistoryInt[RACES.all().size()];
/*     */   private final INFO info;
/*     */   
/*     */   public HistoryRace(int size, TIMECYCLE time, boolean keep) {
/*  21 */     this.total = new HistoryInt(size, time, keep);
/*  22 */     for (int i = 0; i < RACES.all().size(); i++) {
/*  23 */       final Race r = (Race)RACES.all().get(i);
/*  24 */       this.histories[i] = new HistoryInt(size, time, keep)
/*     */         {
/*     */           protected void change(int old, int current) {
/*  27 */             HistoryRace.this.total.inc(-old);
/*  28 */             HistoryRace.this.total.inc(current);
/*  29 */             HistoryRace.this.change(r, old, current);
/*     */           }
/*     */           
/*     */           public int max() {
/*  33 */             return HistoryRace.this.max(r);
/*     */           }
/*     */           
/*     */           public int min() {
/*  37 */             return HistoryRace.this.min(r);
/*     */           }
/*     */         };
/*     */     } 
/*     */ 
/*     */     
/*  43 */     this.info = null;
/*     */   }
/*     */   
/*     */   public HistoryRace(int size, TIMECYCLE time, boolean keep, CharSequence name, CharSequence desc) {
/*  47 */     this.total = new HistoryInt(size, time, keep);
/*  48 */     for (int i = 0; i < RACES.all().size(); i++) {
/*  49 */       final Race r = (Race)RACES.all().get(i);
/*  50 */       this.histories[i] = new HistoryInt(size, time, keep)
/*     */         {
/*     */           protected void change(int old, int current) {
/*  53 */             HistoryRace.this.total.inc(-old);
/*  54 */             HistoryRace.this.total.inc(current);
/*  55 */             HistoryRace.this.change(r, old, current);
/*     */           }
/*     */         };
/*     */     } 
/*  59 */     this.info = new INFO(name, desc);
/*     */   }
/*     */ 
/*     */   
/*     */   public HISTORY_INT.HISTORY_INTE history(Race r) {
/*  64 */     if (r == null)
/*  65 */       return this.total; 
/*  66 */     return this.histories[r.index];
/*     */   }
/*     */ 
/*     */   
/*     */   public HISTORY_INT.HISTORY_INTE total() {
/*  71 */     return this.total;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  76 */     RACES.map().saver().save((SAVABLE[])this.histories, file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  81 */     RACES.map().loader().load((SAVABLE[])this.histories, file);
/*  82 */     this.total.clear();
/*  83 */     for (Race r : RACES.all()) {
/*  84 */       this.total.add(this.histories[r.index]);
/*     */     }
/*     */   }
/*     */   
/*     */   public void clear() {
/*  89 */     for (Race r : RACES.all())
/*  90 */       this.histories[r.index].clear(); 
/*  91 */     this.total.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(Race t) {
/*  96 */     if (t == null)
/*  97 */       return this.total.get(); 
/*  98 */     return history(t).get();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void change(Race r, int old, int current) {}
/*     */ 
/*     */   
/*     */   public INFO info() {
/* 107 */     return this.info;
/*     */   }
/*     */ 
/*     */   
/*     */   public int min(Race t) {
/* 112 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max(Race t) {
/* 117 */     return Integer.MAX_VALUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(Race t, int i) {
/* 122 */     history(t).set(i);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\statistics\HistoryRace.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */