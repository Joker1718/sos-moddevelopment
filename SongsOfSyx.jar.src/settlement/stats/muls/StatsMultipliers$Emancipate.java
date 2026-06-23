/*     */ package settlement.stats.muls;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.EntityIterator;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Emancipate
/*     */   extends StatsMultipliers.StatMultiplierAction
/*     */ {
/* 539 */   private final HistoryInt data = new HistoryInt(32, (TIMECYCLE)TIME.days(), true);
/* 540 */   private final DOUBLE.DoubleImp timer = new DOUBLE.DoubleImp();
/* 541 */   private final double rate = 16.0D / (TIME.secondsPerDay() * 8);
/*     */   
/*     */   private Emancipate(StatsInit init, LISTE<StatsMultipliers.StatMultiplier> all) {
/* 544 */     super("SLAVES_FREED", init, all, 60000, 60000, (SPRITE)(SPRITES.icons()).m.chainsFree, new HCLASS[] { HCLASSES.SLAVE() });
/* 545 */     init.savers.put("SLAVES_FREED_DATA", this.data);
/* 546 */     init.savers.put("SLAVES_FREED_DATA_TIMER", this.timer);
/*     */   }
/*     */ 
/*     */   
/*     */   public double value(Induvidual h) {
/* 551 */     return (((STATS.POP()).TYPE.get(h) == (STATS.POP()).TYPE.FORMER_SLAVE) ? true : false);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canUnmark() {
/* 556 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean markIs(Induvidual a) {
/* 561 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int maxAmount(HCLASS cl, Race race) {
/* 566 */     return (STATS.POP()).POP.data(cl).get(race);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mark(HCLASS cl, Race race, int amount) {}
/*     */ 
/*     */   
/*     */   private class Ite
/*     */     extends EntityIterator.Humans
/*     */   {
/*     */     private int amount;
/*     */     
/*     */     private final Race race;
/*     */     
/*     */     Ite(int amount, Race race) {
/* 581 */       this.amount = amount;
/* 582 */       this.race = race;
/* 583 */       iterate();
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean processAndShouldBreakH(Humanoid h, int ie) {
/* 588 */       if (h.race() == this.race && h.indu().clas() == HCLASSES.SLAVE()) {
/* 589 */         StatsMultipliers.Emancipate.this.mark(h, true);
/* 590 */         this.amount--;
/* 591 */         if (this.amount <= 0)
/* 592 */           return true; 
/*     */       } 
/* 594 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double value(HCLASS cl, Race race, int daysBack) {
/* 601 */     if ((STATS.MULTIPLIERS()).PROSECUTION.value(cl, race, daysBack) > 0.0D)
/* 602 */       return 0.0D; 
/* 603 */     return this.data.get(daysBack) / (1.0D + (STATS.POP()).POP.data(cl).get(null));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/* 609 */     this.timer.incD(-this.rate * ds);
/* 610 */     if (this.timer.getD() > 0.0D)
/*     */       return; 
/* 612 */     this.timer.incD(1.0D);
/* 613 */     int tot = this.data.get();
/* 614 */     int pop = (STATS.POP()).POP.data(HCLASSES.SLAVE()).get(null);
/*     */     
/* 616 */     tot -= pop;
/* 617 */     tot = CLAMP.i(tot, 0, pop * 16);
/* 618 */     this.data.set(tot);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mark(Humanoid h, boolean set) {
/* 624 */     this.data.inc(16);
/* 625 */     if (h.indu().hType() == HTYPES.CHILD_SLAVE()) {
/* 626 */       h.HTypeSet(HTYPES.CHILD(), null, CAUSE_ARRIVES.EMANCIPATED());
/*     */     } else {
/* 628 */       h.HTypeSet(HTYPES.SUBJECT(), null, CAUSE_ARRIVES.EMANCIPATED());
/*     */     } 
/*     */     
/* 631 */     (STATS.POP()).TYPE.FORMER_SLAVE.set(h.indu());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void consume(Humanoid a) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean consumeIs(Induvidual a) {
/* 643 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int unmarkable(HCLASS cl, Race race) {
/* 648 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unmark(HCLASS cl, Race race) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int autoAmount(HCLASS cl, Race race) {
/* 659 */     return (STATS.POP()).POP.data(cl).get(race) - auto(cl, race).get();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canBeMarked(Induvidual a) {
/* 664 */     if (!this.classes[a.clas().index()] && !this.classes[a.hType().parentClass().index()])
/* 665 */       return false; 
/* 666 */     if (markIs(a))
/* 667 */       return false; 
/* 668 */     return (maxAmount(a.clas(), a.race()) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean available(HTYPE t) {
/* 673 */     return available(t.parentClass());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\muls\StatsMultipliers$Emancipate.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */