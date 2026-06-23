/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPES;
/*     */ import init.type.HTYPE_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.info.INFO;
/*     */ import util.statistics.HISTORY;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Demography
/*     */   implements HISTORY.HISTORY_OBJECT<Race>, StatsInit.Addable
/*     */ {
/* 476 */   private static int size = 32;
/* 477 */   private int[][] perRace = Alloc.i2(32, RACES.all().size()); Demography(StatsInit init) {
/* 478 */     D.gInit(StatsPopulation.class);
/* 479 */     this.info = new INFO(D.g("Demography"), D.g("DemographyDesc", "The different age groups of your citizens"));
/*     */ 
/*     */     
/* 482 */     init.addable.add(this);
/*     */   }
/*     */   
/*     */   private final INFO info;
/*     */   
/*     */   public double getD(Race t, int fromZero) {
/* 488 */     if (t == null) {
/* 489 */       double acc = 0.0D;
/* 490 */       int pop = 0;
/* 491 */       for (int i = 0; i < RACES.all().size(); i++) {
/* 492 */         Race r = (Race)RACES.all().get(i);
/* 493 */         int p = (STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(r) + (STATS.POP()).POP.type().get(HTYPE_RACE.get(r, HTYPES.CHILD()));
/* 494 */         acc += getD(r, fromZero) * p;
/* 495 */         pop += p;
/*     */       } 
/* 497 */       if (pop == 0)
/* 498 */         return 0.0D; 
/* 499 */       return acc / pop;
/*     */     } 
/* 501 */     if (fromZero == 0)
/* 502 */       return STATS.POP().pop(HTYPES.PARENT()); 
/* 503 */     return this.perRace[fromZero][t.index];
/*     */   }
/*     */ 
/*     */   
/*     */   public INFO info() {
/* 508 */     return this.info;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addPrivate(Induvidual i) {
/* 514 */     if (i.hType().parentClass() == HCLASSES.CITIZEN()) {
/* 515 */       this.perRace[getT(i)][(i.race()).index] = this.perRace[getT(i)][(i.race()).index] + 1;
/* 516 */       if (i.hType() == HTYPES.PARENT()) {
/* 517 */         this.perRace[0][(i.race()).index] = this.perRace[0][(i.race()).index] + 1;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void removePrivate(Induvidual i) {
/* 524 */     if (i.hType().parentClass() == HCLASSES.CITIZEN()) {
/* 525 */       this.perRace[getT(i)][(i.race()).index] = this.perRace[getT(i)][(i.race()).index] - 1;
/* 526 */       if (i.hType() == HTYPES.PARENT()) {
/* 527 */         this.perRace[0][(i.race()).index] = this.perRace[0][(i.race()).index] - 1;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private int getT(Induvidual i) {
/* 533 */     int max = (int)Math.ceil(i.race().bvalue((BOOSTABLES.PHYSICS()).DEATH_AGE) * TIME.years().bitConversion((TIMECYCLE)TIME.days()));
/* 534 */     int c = (STATS.POP()).age.DAYS.get(i);
/* 535 */     int ii = (size - 2) * c / max;
/* 536 */     ii = CLAMP.i(ii, 0, size - 2);
/* 537 */     return ii;
/*     */   }
/*     */ 
/*     */   
/*     */   public TIMECYCLE time() {
/* 542 */     return (TIMECYCLE)TIME.days();
/*     */   }
/*     */ 
/*     */   
/*     */   public int historyRecords() {
/* 547 */     return size;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getD(Race t) {
/* 552 */     return getD(t, 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsPopulation$Demography.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */