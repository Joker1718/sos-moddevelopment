/*     */ package settlement.stats.standing;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.info.INFO;
/*     */ import util.statistics.HistoryInt;
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
/*     */ 
/*     */ public abstract class CitizenThing
/*     */ {
/* 414 */   private final HistoryInt total = new HistoryInt(32, (TIMECYCLE)TIME.days(), true);
/* 415 */   private final HistoryInt[] histories = new HistoryInt[RACES.all().size()];
/*     */   private final INFO info;
/*     */   private static final double dd = 1.0E7D;
/*     */   private final HCLASS cl;
/*     */   
/*     */   CitizenThing(INFO info, HCLASS cl) {
/* 421 */     this.info = info;
/* 422 */     for (int i = 0; i < this.histories.length; i++)
/* 423 */       this.histories[i] = new HistoryInt(32, (TIMECYCLE)TIME.days(), true); 
/* 424 */     this.cl = cl;
/*     */   }
/*     */   
/*     */   CitizenThing(CharSequence name, CharSequence desc, HCLASS cl) {
/* 428 */     this(new INFO(name, desc), cl);
/*     */   }
/*     */   
/*     */   final void up(Race race, double ds) {
/* 432 */     set(race, update(race, ds));
/*     */   }
/*     */ 
/*     */   
/*     */   abstract double update(Race paramRace, double paramDouble);
/*     */   
/*     */   public double getD(Race t) {
/* 439 */     return getD(t, 0);
/*     */   }
/*     */   
/*     */   public double getD(Race t, int daysBack) {
/* 443 */     HistoryInt h = (t == null) ? this.total : this.histories[t.index];
/* 444 */     double d = h.get(daysBack) / 1.0E7D;
/* 445 */     return CLAMP.d(d, 0.0D, d);
/*     */   }
/*     */   
/*     */   void save(FilePutter file) {
/* 449 */     this.total.save(file); byte b; int i; HistoryInt[] arrayOfHistoryInt;
/* 450 */     for (i = (arrayOfHistoryInt = this.histories).length, b = 0; b < i; ) { HistoryInt historyInt = arrayOfHistoryInt[b];
/* 451 */       historyInt.save(file);
/*     */       b++; }
/*     */   
/*     */   } void load(FileGetter file) throws IOException {
/* 455 */     this.total.load(file); byte b; int i; HistoryInt[] arrayOfHistoryInt;
/* 456 */     for (i = (arrayOfHistoryInt = this.histories).length, b = 0; b < i; ) { HistoryInt historyInt = arrayOfHistoryInt[b];
/* 457 */       historyInt.load(file);
/*     */       b++; }
/*     */   
/*     */   } void clear() {
/* 461 */     this.total.clear(); byte b; int i; HistoryInt[] arrayOfHistoryInt;
/* 462 */     for (i = (arrayOfHistoryInt = this.histories).length, b = 0; b < i; ) { HistoryInt historyInt = arrayOfHistoryInt[b];
/* 463 */       historyInt.clear();
/*     */       b++; }
/*     */   
/*     */   }
/*     */   void set(Race race, double v) {
/* 468 */     this.histories[race.index].set((int)(v * 1.0E7D));
/* 469 */     double total = 0.0D;
/* 470 */     for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 471 */       Race r = (Race)RACES.all().get(ri);
/* 472 */       total += CLAMP.d(getD(r), 0.0D, 10.0D) * (STATS.POP()).POP.data(this.cl).get(r, 0);
/*     */     } 
/* 474 */     double p = (STATS.POP()).POP.data(this.cl).get(null, 0);
/* 475 */     if (p == 0.0D)
/* 476 */       p = 1.0D; 
/* 477 */     total /= p;
/* 478 */     this.total.set((int)(total * 1.0E7D));
/*     */   }
/*     */   
/*     */   public INFO info() {
/* 482 */     return this.info;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\standing\StandingCitizen$CitizenThing.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */