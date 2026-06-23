/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Age
/*     */ {
/*     */   public final STAT AGE_DAYS;
/*     */   public final INT_O.INT_OE<Induvidual> DAYS;
/*     */   private final INT_O.INT_OE<Induvidual> DEATH;
/* 340 */   private final double yy = TIME.years().bitConversion((TIMECYCLE)TIME.days());
/* 341 */   private final double yI = 1.0D / this.yy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DOUBLE_O.DOUBLE_OE<Induvidual> years;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DOUBLE_O.DOUBLE_OE<Induvidual> dage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Age(StatsInit init) {
/* 416 */     this.years = new DOUBLE_O.DOUBLE_OE<Induvidual>()
/*     */       {
/*     */         public double getD(Induvidual t)
/*     */         {
/* 420 */           return StatsPopulation.Age.this.DAYS.get(t) * StatsPopulation.Age.this.yI;
/*     */         }
/*     */ 
/*     */         
/*     */         public DOUBLE_O.DOUBLE_OE<Induvidual> setD(Induvidual t, double d) {
/* 425 */           int am = (int)Math.round(d * StatsPopulation.Age.this.yy);
/* 426 */           StatsPopulation.Age.this.DAYS.set(t, am);
/* 427 */           return this;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 432 */     this.dage = new DOUBLE_O.DOUBLE_OE<Induvidual>()
/*     */       {
/*     */         public double getD(Induvidual t)
/*     */         {
/* 436 */           return StatsPopulation.Age.this.DAYS.getD(t);
/*     */         } public void set(Induvidual i, int v) { (STATS.POP()).demo.removeH(i); super.set(i, v); (STATS.POP()).demo.addH(i); (STATS.POP()).reproduction.set(i); } public double getD(Induvidual t) { double de = 1.0D + Math.ceil(t.race().bvalue((BOOSTABLES.PHYSICS()).DEATH_AGE) * StatsPopulation.Age.this.yy); int da = StatsPopulation.Age.this.DAYS.get(t); return CLAMP.d(da / de, 0.0D, 1.0D); } public DOUBLE_O.DOUBLE_OE<Induvidual> setD(Induvidual t, double d) { int am = (int)Math.round(d * StatsPopulation.Age.this.yy); StatsPopulation.Age.this.DAYS.set(t, am); return (DOUBLE_O.DOUBLE_OE<Induvidual>)this; }
/*     */       }; init.count.getClass(); DataO<Induvidual>.DataInt days = new DataO<Induvidual>.DataInt(init.count, "POP_AGE_DAYS") { public int dataDivider() { return 1; } }
/*     */       ; init.count.getClass(); this.DEATH = (INT_O.INT_OE<Induvidual>)new DataO.DataByte(init.count, "DEATH_AGE");
/*     */     STATData sTATData = new STATData("AGE", init, (DataO.DataAbs)days) {
/* 441 */         public DOUBLE_O.DOUBLE_OE<Induvidual> setD(Induvidual t, double d) { int am = (int)Math.round(d * StatsPopulation.Age.this.yy * t.race().bvalue((BOOSTABLES.PHYSICS()).DEATH_AGE));
/* 442 */           StatsPopulation.Age.this.DAYS.set(t, am);
/* 443 */           return this; }
/*     */       }; this.DAYS = sTATData.indu(); this.AGE_DAYS = (STAT)sTATData; this.AGE_DAYS.info().setInt(); init.onConstruct.add(new StatsInit.StatInitable() { public void init(Induvidual i) { int min = (i.race()).physics.adultDay + 1; int max = (int)(0.5D * (BOOSTABLES.PHYSICS()).DEATH_AGE.get((BOOSTABLE_O)i) * StatsPopulation.Age.this.yy); int d = max - min; if (d <= 0)
/*     */               d = 1;  d = min + RND.rInt(d); StatsPopulation.Age.this.DAYS.set(i, d); StatsPopulation.Age.this.DEATH.setD(i, StatsPopulation.death());
/*     */             if (StatsPopulation.Age.this.shouldDieOfOldAge(i))
/*     */               StatsPopulation.Age.this.DEATH.inc(i, 1 + RND.rInt(5));  } });
/*     */     init.copier.add(days);
/* 449 */     init.copier.add(this.DEATH); } public int lifespan(Induvidual i) { return (int)(i.race().bvalue((BOOSTABLES.PHYSICS()).DEATH_AGE) * this.yy); }
/*     */ 
/*     */   
/*     */   public boolean shouldDieOfOldAge(Induvidual i) {
/* 453 */     int now = this.DAYS.get(i);
/* 454 */     int death = deathDay(i);
/* 455 */     return (now >= death);
/*     */   }
/*     */   
/*     */   public int deathDay(Induvidual i) {
/* 459 */     int ll = (int)i.race().bvalue((BOOSTABLES.PHYSICS()).DEATH_AGE);
/* 460 */     ll = (int)(ll * this.DEATH.getD(i));
/* 461 */     int yy = (int)TIME.years().bitConversion((TIMECYCLE)TIME.days());
/* 462 */     ll *= yy;
/* 463 */     ll += STATS.RAN().get(i, 13) % yy;
/* 464 */     return ll;
/*     */   }
/*     */   
/*     */   public boolean isAdult(Induvidual i) {
/* 468 */     return (this.DAYS.get(i) >= (i.race()).physics.adultDay);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsPopulation$Age.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */