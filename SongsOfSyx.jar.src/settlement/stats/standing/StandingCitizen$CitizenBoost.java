/*     */ package settlement.stats.standing;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import util.info.INFO;
/*     */ import util.statistics.HistoryInt;
/*     */ import util.statistics.HistoryRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CitizenBoost
/*     */   extends StandingCitizen.CitizenThing
/*     */ {
/*     */   public final Boostable bo;
/* 490 */   private ArrayListGrower<HistoryRace> factors = new ArrayListGrower();
/* 491 */   private ArrayListGrower<HistoryInt> factorsTot = new ArrayListGrower();
/*     */   private static final double dd = 100000.0D;
/*     */   private static final double ddI = 1.0E-5D;
/*     */   
/*     */   CitizenBoost(CharSequence name, CharSequence desc, Boostable bo, HCLASS cl) {
/* 496 */     super(new INFO(name, desc), cl);
/* 497 */     this.bo = bo;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void save(FilePutter file) {
/* 503 */     file.i(this.factors.size());
/* 504 */     for (HistoryRace r : this.factors)
/* 505 */       r.save(file); 
/* 506 */     for (HistoryInt r : this.factorsTot)
/* 507 */       r.save(file); 
/* 508 */     super.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   void load(FileGetter file) throws IOException {
/* 513 */     int am = file.i();
/* 514 */     while (this.factors.size() <= am) {
/* 515 */       this.factors.add(new HistoryRace(32, (TIMECYCLE)TIME.days(), true));
/* 516 */       this.factorsTot.add(new HistoryInt(32, (TIMECYCLE)TIME.days(), true));
/*     */     }  int i;
/* 518 */     for (i = 0; i < am; i++)
/* 519 */       ((HistoryRace)this.factors.get(i)).load(file); 
/* 520 */     for (i = 0; i < am; i++)
/* 521 */       ((HistoryInt)this.factorsTot.get(i)).load(file); 
/* 522 */     super.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   void clear() {
/* 527 */     for (HistoryRace r : this.factors)
/* 528 */       r.clear(); 
/* 529 */     for (HistoryInt r : this.factorsTot)
/* 530 */       r.clear(); 
/*     */   }
/*     */   
/*     */   public double factor(Race race, int factorI, int fromZero) {
/* 534 */     while (this.factors.size() <= factorI) {
/* 535 */       this.factors.add(new HistoryRace(32, (TIMECYCLE)TIME.days(), true));
/* 536 */       this.factorsTot.add(new HistoryInt(32, (TIMECYCLE)TIME.days(), true));
/*     */     } 
/* 538 */     if (fromZero == 0)
/* 539 */       return ((Booster)this.bo.all().get(factorI)).get(HCLASS_RACE.clP(race, StandingCitizen.this.cl)); 
/* 540 */     if (race == null)
/* 541 */       return ((HistoryInt)this.factorsTot.get(factorI)).get(fromZero) * 1.0E-5D; 
/* 542 */     return ((HistoryRace)this.factors.get(factorI)).history(race).get(fromZero) * 1.0E-5D;
/*     */   }
/*     */ 
/*     */   
/*     */   double update(Race race, double ds) {
/* 547 */     for (int i = 0; i < this.bo.all().size(); i++) {
/* 548 */       while (this.factors.size() <= i) {
/* 549 */         this.factors.add(new HistoryRace(32, (TIMECYCLE)TIME.days(), true));
/* 550 */         this.factorsTot.add(new HistoryInt(32, (TIMECYCLE)TIME.days(), true));
/*     */       } 
/* 552 */       ((HistoryRace)this.factors.get(i)).set(race, (int)(100000.0D * ((Booster)this.bo.all().get(i)).get(HCLASS_RACE.clP(race, StandingCitizen.this.cl))));
/* 553 */       double total = 0.0D;
/* 554 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 555 */         Race r = (Race)RACES.all().get(ri);
/* 556 */         total += factor(r, i, 0) * (STATS.POP()).POP.data(StandingCitizen.this.cl).get(r, 0);
/*     */       } 
/* 558 */       double p = (STATS.POP()).POP.data(StandingCitizen.this.cl).get(null, 0);
/* 559 */       if (p == 0.0D)
/* 560 */         p = 1.0D; 
/* 561 */       total /= p;
/* 562 */       ((HistoryInt)this.factorsTot.get(i)).set((int)(total * 100000.0D));
/*     */     } 
/* 564 */     return this.bo.get((BOOSTABLE_O)HCLASS_RACE.clP(race, StandingCitizen.this.cl));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\standing\StandingCitizen$CitizenBoost.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */