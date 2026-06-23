/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.religion.RELIGIONS;
/*     */ import init.religion.Religion;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class BB
/*     */   extends Booster
/*     */   implements BValue
/*     */ {
/* 482 */   private final Booster[] vv = new Booster[RELIGIONS.ALL().size()];
/*     */   private final double min;
/*     */   private final double max;
/*     */   private final double aa;
/*     */   
/*     */   public BB(Boostable bb, boolean isMul) {
/* 488 */     super(new BSourceInfo(Dic.¤¤Religion, (SPRITE)(UI.icons()).s.star), isMul);
/*     */     
/* 490 */     double min = Double.MAX_VALUE;
/* 491 */     double max = Double.MIN_VALUE;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 496 */     this.aa = (isMul ? true : false);
/*     */     
/* 498 */     for (Religion r : RELIGIONS.ALL()) {
/* 499 */       for (BoostSpec s : r.boosts.all()) {
/*     */         
/* 501 */         if (s.boostable == bb && s.booster.isMul == isMul && (s.boostable.cat.typeMask & 0x4) != 0) {
/* 502 */           this.vv[r.index()] = s.booster;
/*     */           
/* 504 */           min = Math.min(min, s.booster.from());
/* 505 */           max = Math.max(max, s.booster.to());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 510 */     this.min = min;
/* 511 */     this.max = max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double vGet(Region reg) {
/* 518 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Induvidual indu) {
/* 523 */     return vv(((StatsReligion.StatReligion)(STATS.RELIGION()).getter.get(indu)).religion, (STATS.RELIGION()).TEMPLE.TOTAL.indu().getD(indu));
/*     */   }
/*     */   
/*     */   private double vv(Religion rel, double v) {
/* 527 */     if (this.vv[rel.index()] == null)
/* 528 */       return this.aa; 
/* 529 */     return this.vv[rel.index()].getValue(v);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Div div) {
/* 534 */     double dd = 0.0D;
/* 535 */     for (int ri = 0; ri < RELIGIONS.ALL().size(); ri++) {
/* 536 */       StatsReligion.StatReligion rl = (StatsReligion.StatReligion)(STATS.RELIGION()).ALL.get(ri);
/* 537 */       double v = StatsReligion.this.TEMPLE.access(rl.religion).div().getD(div) * StatsReligion.this.TEMPLE.quality(rl.religion).div().getD(div);
/* 538 */       dd += vv(rl.religion, v) * rl.followers.div().getD(div);
/*     */     } 
/*     */     
/* 541 */     return dd;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(HCLASS_RACE popTime) {
/* 546 */     double dd = 0.0D;
/* 547 */     for (int ri = 0; ri < RELIGIONS.ALL().size(); ri++) {
/* 548 */       StatsReligion.StatReligion rl = (StatsReligion.StatReligion)(STATS.RELIGION()).ALL.get(ri);
/* 549 */       double v = StatsReligion.this.TEMPLE.access(rl.religion).data(popTime.cl).getD(popTime.race, 0) * StatsReligion.this.TEMPLE.quality(rl.religion).data(popTime.cl).getD(popTime.race, 0);
/* 550 */       dd += vv(rl.religion, v) * rl.followers.data(popTime.cl).getD(popTime.race, 0);
/*     */     } 
/* 552 */     return dd;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Player f) {
/* 557 */     return vGet(HCLASS_RACE.clP());
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(FactionNPC f) {
/* 562 */     if (f.court().king() == null || f.court().king().roy() == null)
/* 563 */       return 0.0D; 
/* 564 */     return vv(((StatsReligion.StatReligion)(STATS.RELIGION()).getter.get((f.court().king().roy()).induvidual)).religion, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public double getValue(double input) {
/* 569 */     return CLAMP.d(input, this.min, this.max);
/*     */   }
/*     */ 
/*     */   
/*     */   protected double pget(BOOSTABLE_O o) {
/* 574 */     return o.boostableValue(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public double from() {
/* 579 */     return this.min;
/*     */   }
/*     */ 
/*     */   
/*     */   public double to() {
/* 584 */     return this.max;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsReligion$BB.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */