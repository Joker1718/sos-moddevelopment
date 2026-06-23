/*     */ package settlement.entry;
/*     */ 
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BoosterImp;
/*     */ import game.faction.player.Player;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.POP;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class Bo
/*     */   extends BoosterImp
/*     */ {
/*     */   public Bo(BSourceInfo info, double from, double to, boolean isMul) {
/*  86 */     super(info, from, to, isMul);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(HCLASS_RACE popTime) {
/*  91 */     if (popTime.cl != HCLASSES.CITIZEN()) {
/*  92 */       return vNOPInput();
/*     */     }
/*  94 */     if (popTime.race == null) {
/*  95 */       double tot = 0.0D;
/*  96 */       double res = 0.0D;
/*  97 */       for (Race r : RACES.all()) {
/*  98 */         double p = POP.pop(popTime.cl, r);
/*  99 */         tot += p;
/* 100 */         res += p * vGet(HCLASS_RACE.clP(r, popTime.cl));
/*     */       } 
/* 102 */       if (tot == 0.0D)
/* 103 */         return vNOPInput(); 
/* 104 */       return res / tot;
/*     */     } 
/*     */     
/* 107 */     if (WORLD.camps().available(popTime.race)) {
/* 108 */       return w(popTime.race);
/*     */     }
/* 110 */     return g(popTime.race);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Player f) {
/* 115 */     return vGet(HCLASS_RACE.clP(null, HCLASSES.CITIZEN()));
/*     */   }
/*     */ 
/*     */   
/*     */   protected double w(Race race) {
/* 120 */     return vNOPInput();
/*     */   }
/*     */   
/*     */   protected abstract double g(Race paramRace);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entry\Immigration$Bo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */