/*     */ package world.region.updating;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import world.WORLD;
/*     */ import world.entity.caravan.Shipment;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.RDOutputs;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Shipper
/*     */ {
/*     */   public void ship(Region r, double seconds) {
/*  26 */     Faction f = r.faction();
/*     */     
/*  28 */     if (f == null) {
/*     */       return;
/*     */     }
/*  31 */     if (r.besieged()) {
/*     */       return;
/*     */     }
/*  34 */     if (f.capitolRegion() == null) {
/*     */       return;
/*     */     }
/*  37 */     double days = seconds * TIME.secondsPerDayI();
/*  38 */     int am = 0;
/*     */     
/*  40 */     if (f == FACTIONS.player() && 
/*  41 */       r.capitol()) {
/*     */       return;
/*     */     }
/*     */     
/*  45 */     f.credits().inc((RD.OUTPUT()).MONEY.boost.get((BOOSTABLE_O)r) * days, FCredits.CTYPE.TAX);
/*     */     
/*  47 */     for (RDOutputs.RDResource res : (RD.OUTPUT()).RES) {
/*  48 */       count(res, r, seconds);
/*  49 */       am += amount(res, r, seconds);
/*     */     } 
/*     */ 
/*     */     
/*  53 */     if (am <= 0) {
/*     */       return;
/*     */     }
/*  56 */     Shipment c = (WORLD.ENTITIES()).caravans.create(r, f.capitolRegion(), TRADE_TYPE.tax);
/*  57 */     if (c != null) {
/*  58 */       for (RDOutputs.RDResource res : (RD.OUTPUT()).RES) {
/*  59 */         int a = amount(res, r, seconds);
/*  60 */         if (a > 0) {
/*  61 */           c.loadAndReserve(res.res, a);
/*  62 */           clear(res, r);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void count(RDOutputs.RDResource res, Region r, double seconds) {
/*  71 */     double am = res.boostYearlyPart.get((BOOSTABLE_O)r) * seconds * TIME.secondsPerDayI();
/*  72 */     int a = (int)am;
/*  73 */     if (am - a > RND.rFloat()) {
/*  74 */       a++;
/*     */     }
/*  76 */     res.yearlyAccumilation.inc(r, a);
/*     */   }
/*     */   
/*     */   private void clear(RDOutputs.RDResource res, Region r) {
/*  80 */     if (res.daysUntilDailydelivery() == 0) {
/*  81 */       res.yearlyAccumilation.set(r, 0);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int amount(RDOutputs.RDResource res, Region r, double seconds) {
/*  88 */     int am = (int)Math.ceil(res.boost.get((BOOSTABLE_O)r) * seconds * TIME.secondsPerDayI());
/*     */     
/*  90 */     if (res.daysUntilDailydelivery() == 0) {
/*  91 */       am += res.yearlyAccumilation.get(r);
/*     */     }
/*  93 */     return am;
/*     */   }
/*     */ 
/*     */   
/*     */   public void shipAll(Faction f, double days) {
/*  98 */     for (int ri = 0; ri < f.realm().regions(); ri++) {
/*  99 */       Region reg = f.realm().region(ri);
/* 100 */       for (RDOutputs.RDResource res : (RD.OUTPUT()).RES) {
/* 101 */         int a = (int)Math.ceil(res.boost.get((BOOSTABLE_O)reg) * days);
/* 102 */         if (a > 0)
/* 103 */           f.buyer(res.res).addReserveAndDeliver(a, TRADE_TYPE.tax); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\regio\\updating\Shipper.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */