/*     */ package world.army;
/*     */ 
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.faction.Faction;
/*     */ import init.constant.Config;
/*     */ import init.race.Race;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements DIV_SPEC.DIV_SPECE
/*     */ {
/*     */   public double training(StatsBattle.StatTraining tr) {
/* 329 */     return WDivRegional.this.trainingTarget[tr.tIndex] * 0.06666666666666667D;
/*     */   }
/*     */ 
/*     */   
/*     */   public int men() {
/* 334 */     return WDivRegional.this.menTarget;
/*     */   }
/*     */ 
/*     */   
/*     */   public double equip(EquipBattle e) {
/* 339 */     return WDivRegional.this.targets[e.indexMilitary()] / e.equipMax;
/*     */   }
/*     */ 
/*     */   
/*     */   public void trainingSet(StatsBattle.StatTraining tr, double d) {
/* 344 */     WDivRegional.this.trainingTarget[tr.tIndex] = (byte)(int)Math.round(15.0D * CLAMP.d(d, 0.0D, 1.0D));
/*     */   }
/*     */ 
/*     */   
/*     */   public void equipSet(EquipBattle tr, double am) {
/* 349 */     WDivRegional.this.report(-1);
/* 350 */     WDivRegional.this.targets[tr.indexMilitary()] = (byte)(int)Math.round(am * tr.max());
/* 351 */     WDivRegional.this.report(1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void menSet(int am) {
/* 357 */     WDivRegional.this.report(-1);
/* 358 */     WDivRegional.this.menTarget = (short)CLAMP.i(am, 0, (Config.battle()).MEN_PER_DIVISION);
/* 359 */     WDivRegional.this.trainingDay = 0;
/* 360 */     WDivRegional.this.men = (short)CLAMP.i(WDivRegional.this.men, 0, WDivRegional.this.menTarget);
/* 361 */     WDivRegional.this.report(1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double experience() {
/* 367 */     return WDivRegional.this.experience;
/*     */   }
/*     */ 
/*     */   
/*     */   public Faction faction() {
/* 372 */     return (WDivRegional.this.army() == null) ? null : WDivRegional.this.army().faction();
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name() {
/* 377 */     return WDivRegional.this.name();
/*     */   }
/*     */ 
/*     */   
/*     */   public int bannerI() {
/* 382 */     return WDivRegional.this.bannerI();
/*     */   }
/*     */ 
/*     */   
/*     */   public Race race() {
/* 387 */     return WDivRegional.this.race();
/*     */   }
/*     */ 
/*     */   
/*     */   public void raceSet(Race race) {
/* 392 */     WDivRegional.this.report(-1);
/* 393 */     WDivRegional.this.ri = (short)race.index;
/* 394 */     WDivRegional.this.report(1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void experienceSet(double experience) {
/* 399 */     WDivRegional.this.experience = (float)experience;
/*     */   }
/*     */ 
/*     */   
/*     */   public Str nameE() {
/* 404 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void bannerISet(int bannerI) {
/* 409 */     WDivRegional.this.bannerI = (short)bannerI;
/*     */   }
/*     */   
/*     */   public void factionSet(Faction faction) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\WDivRegional$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */