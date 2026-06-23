/*     */ package settlement.stats.law;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.StatsInit;
/*     */ import util.statistics.HISTORY_COLLECTION;
/*     */ import util.statistics.HistoryObject;
/*     */ import world.army.AD;
/*     */ 
/*     */ 
/*     */ public class StatPunishment
/*     */ {
/*  20 */   private final HistoryObject<HCLASS_RACE> success = new HistoryObject(32, (TIMECYCLE)TIME.days(), false, HCLASS_RACE.MAP());
/*     */   
/*     */   public final CRIME_PUNISHMENTS.PUNISHMENT punish;
/*  23 */   private double[] rates = new double[HCLASS_RACE.ALL().size()];
/*     */   
/*     */   StatPunishment(StatsInit init, CRIME_PUNISHMENTS.PUNISHMENT type) {
/*  26 */     this.punish = type;
/*     */     
/*  28 */     init.savers.put("LAW_PUNISHMENT_COUNT_" + type.key, this.success);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void report(HCLASS_RACE cc) {
/*  36 */     if (cc.cl == HCLASSES.OTHER() && this.punish != CRIME_PUNISHMENTS.STOCKS()) {
/*  37 */       double cruelty = this.punish.crueltyPerPerson(cc.cl, cc.race);
/*  38 */       AD.stats().mercy().incD(FACTIONS.player(), -cruelty);
/*  39 */       cruelty = this.punish.mercyPerPerson(cc.cl, cc.race);
/*  40 */       AD.stats().mercy().incD(FACTIONS.player(), cruelty);
/*     */     } 
/*     */     
/*  43 */     this.success.inc(cc, 1);
/*     */     
/*  45 */     double dd = 1.0D / CRIME_PUNISHMENTS.get(cc.cl).size();
/*     */     
/*  47 */     this.rates[cc.index()] = this.rates[cc.index()] + 1.0D;
/*  48 */     for (CRIME_PUNISHMENTS.PUNISHMENT p : CRIME_PUNISHMENTS.ALL()) {
/*  49 */       (p.stat()).rates[cc.index] = (p.stat()).rates[cc.index] - dd;
/*  50 */       if ((p.stat()).rates[cc.index] < 0.0D) {
/*  51 */         (p.stat()).rates[cc.index] = 0.0D;
/*     */       }
/*     */     } 
/*  54 */     double tot = 0.0D;
/*  55 */     for (CRIME_PUNISHMENTS.PUNISHMENT p : CRIME_PUNISHMENTS.get(cc.cl)) {
/*  56 */       tot += (p.stat()).rates[cc.index()];
/*     */     }
/*     */     
/*  59 */     if (tot > 0.0D) {
/*  60 */       for (CRIME_PUNISHMENTS.PUNISHMENT p : CRIME_PUNISHMENTS.get(cc.cl)) {
/*  61 */         (p.stat()).rates[cc.index()] = (p.stat()).rates[cc.index()] / tot;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public double rate(HCLASS cl, Race race) {
/*  68 */     double tot = 0.0D;
/*  69 */     for (int pi = 0; pi < CRIME_PUNISHMENTS.get(cl).size(); pi++) {
/*  70 */       CRIME_PUNISHMENTS.PUNISHMENT p = (CRIME_PUNISHMENTS.PUNISHMENT)CRIME_PUNISHMENTS.get(cl).get(pi);
/*  71 */       tot += p.stat().recent(cl, race);
/*     */     } 
/*  73 */     if (tot == 0.0D) {
/*  74 */       return 0.0D;
/*     */     }
/*  76 */     return recent(cl, race) / tot;
/*     */   }
/*     */   
/*     */   public double recent(HCLASS cl, Race race) {
/*  80 */     if (cl == null) {
/*  81 */       double tot = 0.0D;
/*  82 */       for (int i = 0; i < HCLASSES.ALLP().size(); i++) {
/*  83 */         tot += recent((HCLASS)HCLASSES.ALLP().get(i), race);
/*     */       }
/*  85 */       return tot;
/*     */     } 
/*     */     
/*  88 */     if (race == null) {
/*  89 */       double tot = 0.0D;
/*  90 */       for (int i = 0; i < RACES.all().size(); i++) {
/*  91 */         tot += recent(cl, (Race)RACES.all().get(i));
/*     */       }
/*  93 */       return tot;
/*     */     } 
/*     */     
/*  96 */     return this.rates[HCLASS_RACE.clP(race, cl).index()];
/*     */   }
/*     */   
/*     */   void decRate(HCLASS_RACE cc) {
/* 100 */     boolean dec = false;
/* 101 */     for (CRIME_PUNISHMENTS.PUNISHMENT p : CRIME_PUNISHMENTS.get(cc.cl)) {
/* 102 */       if ((p.stat()).rates[cc.index()] > 1.0D) {
/* 103 */         dec = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 107 */     if (dec) {
/* 108 */       for (CRIME_PUNISHMENTS.PUNISHMENT p : CRIME_PUNISHMENTS.get(cc.cl)) {
/* 109 */         (p.stat()).rates[cc.index()] = (p.stat()).rates[cc.index()] * 0.85D;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public HISTORY_COLLECTION<HCLASS_RACE> success() {
/* 115 */     return (HISTORY_COLLECTION<HCLASS_RACE>)this.success;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\law\StatPunishment.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */