/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResG;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.NEEDS;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.service.food.canteen.ROOM_CANTEEN;
/*     */ import settlement.room.service.food.eatery.ROOM_EATERY;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STATFakeRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends STATFakeRace
/*     */ {
/*     */   private double am;
/*     */   private int lastT;
/*     */   
/*     */   null(String $anonymous0, StatsInit $anonymous1) {
/*  71 */     super($anonymous0, $anonymous1);
/*     */ 
/*     */     
/*  74 */     this.lastT = -1;
/*     */   }
/*     */   
/*     */   public int dataDivider() {
/*  78 */     return 24;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double getDD(Race race) {
/*  83 */     if (GAME.updateI() == this.lastT) {
/*  84 */       return this.am;
/*     */     }
/*  86 */     this.lastT = GAME.updateI();
/*     */     
/*  88 */     double a = 0.0D;
/*  89 */     for (int ei = 0; ei < RESOURCES.EDI().all().size(); ei++) {
/*  90 */       ResG r = (ResG)RESOURCES.EDI().all().get(ei);
/*  91 */       double aa = (SETT.ROOMS()).STOCKPILE.tally().amountTotal(r.resource);
/*  92 */       a += aa;
/*     */     } 
/*     */     int ri;
/*  95 */     for (ri = 0; ri < (SETT.ROOMS()).EATERIES.size(); ri++) {
/*  96 */       ROOM_EATERY e = (ROOM_EATERY)(SETT.ROOMS()).EATERIES.get(ri);
/*  97 */       double aa = e.totalFood();
/*  98 */       a += aa;
/*     */     } 
/*     */     
/* 101 */     for (ri = 0; ri < (SETT.ROOMS()).CANTEENS.size(); ri++) {
/* 102 */       ROOM_CANTEEN e = (ROOM_CANTEEN)(SETT.ROOMS()).CANTEENS.get(ri);
/* 103 */       double aa = e.totalFood();
/* 104 */       a += aa;
/*     */     } 
/*     */     
/* 107 */     double needed = 0.0D;
/*     */     
/* 109 */     for (int ci = 0; ci < HCLASSES.ALL().size(); ci++) {
/* 110 */       HCLASS c = (HCLASS)HCLASSES.ALL().get(ci);
/* 111 */       if (c.player) {
/* 112 */         for (int i = 0; i < RACES.all().size(); i++) {
/* 113 */           Race r = (Race)RACES.all().get(i);
/* 114 */           needed += (NEEDS.TYPES()).HUNGER.rate.get((BOOSTABLE_O)c.get(r)) * POP.physical(c, r) * StatsFood.this.FOOD.decree().get(c, r);
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     if (needed == 0.0D) {
/* 123 */       this.am = ((a > 0.0D) ? true : false);
/*     */     } else {
/* 125 */       this.am = a / needed;
/* 126 */     }  this.am /= dataDivider();
/* 127 */     return this.am;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsFood$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */