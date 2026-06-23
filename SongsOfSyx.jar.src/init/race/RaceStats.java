/*     */ package init.race;
/*     */ 
/*     */ import init.resources.RESOURCES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.TRAITS;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBurial;
/*     */ import settlement.stats.equip.Equip;
/*     */ import settlement.stats.muls.StatsMultipliers;
/*     */ import settlement.stats.service.StatServiceImp;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.util.StatsJson;
/*     */ import snake2d.Errors;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sets.Tuple;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RaceStats
/*     */ {
/*     */   private final StatStanding.StandingDef[] reps;
/*     */   private final double[][] repNormalized;
/*  30 */   private final ArrayList<LIST<STAT>> standings = new ArrayList(HCLASSES.ALL().size());
/*  31 */   private final LinkedList<Tuple<STAT, Double>> arrival = new LinkedList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RaceStats(Race race, Json json) throws IOException {
/*  38 */     TRAITS.serRaceData(race, json);
/*     */     
/*  40 */     RESOURCES.SUP().setEfficiency(race, json);
/*     */     
/*  42 */     this.reps = new StatStanding.StandingDef[STATS.all().size()];
/*  43 */     this.repNormalized = new double[HCLASSES.ALL().size()][this.reps.length];
/*     */     
/*  45 */     for (int i = 0; i < this.reps.length; i++) {
/*  46 */       this.reps[i] = ((STAT)STATS.all().get(i)).standing().base();
/*  47 */       for (HCLASS c : HCLASSES.ALL()) {
/*  48 */         this.repNormalized[c.index()][i] = 0.0D;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     for (HCLASS c : HCLASSES.ALL()) {
/*  81 */       double rmax = 0.0D;
/*     */       
/*  83 */       ArrayList<STAT> stats = new ArrayList(STATS.all().size());
/*     */       
/*  85 */       for (STAT s : STATS.all()) {
/*  86 */         StatStanding.StandingDef d = this.reps[s.index()];
/*  87 */         if ((d.get(c)).max > 0.0D) {
/*  88 */           stats.add(s);
/*  89 */           if ((d.get(c)).max > rmax) {
/*  90 */             rmax = (d.get(c)).max;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/*  95 */       if (rmax == 0.0D && (c == HCLASSES.CITIZEN() || c == HCLASSES.SLAVE())) {
/*  96 */         throw new Errors.GameError(String.valueOf(c.name) + ", race: " + String.valueOf(c.name) + " has no standing boosts!");
/*     */       }
/*  98 */       if (rmax <= 0.0D) {
/*  99 */         rmax = 1.0D;
/*     */       } else {
/*     */         
/* 102 */         for (STAT s : STATS.all()) {
/* 103 */           if ((this.reps[s.index()].get(c)).max > 0.0D) {
/* 104 */             this.repNormalized[c.index()][s.index()] = (this.reps[s.index()].get(c)).max / rmax;
/*     */           }
/*     */         } 
/*     */       } 
/* 108 */       this.standings.add(new ArrayList((Iterable)stats));
/*     */       
/* 110 */       for (StatServiceImp s : (STATS.SERVICE()).ALL) {
/* 111 */         StatStanding.StandingDef d = this.reps[s.total().index()];
/*     */         
/* 113 */         s.permission().set(c.get(race), ((d.get(c)).max > 0.0D));
/*     */       } 
/*     */       
/* 116 */       for (StatsBurial.StatGrave s : STATS.BURIAL().graves()) {
/* 117 */         StatStanding.StandingDef d = this.reps[s.index()];
/* 118 */         s.grave().permission().set(c, race, ((d.get(c)).max > 0.0D));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 126 */     if (json.has("STATS_ON_SPAWN"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<Tuple<STAT, Double>> arrivalStats() {
/* 146 */     return (LIST<Tuple<STAT, Double>>)this.arrival;
/*     */   }
/*     */   
/*     */   public int equipArrivalLevel(Equip e) {
/* 150 */     return 0;
/*     */   }
/*     */   
/*     */   public StatStanding.StandingDef def(StatStanding s) {
/* 154 */     return this.reps[s.stat().index()];
/*     */   }
/*     */   
/*     */   public double defNormalized(HCLASS c, StatStanding s) {
/* 158 */     return this.repNormalized[c.index()][s.stat().index()];
/*     */   }
/*     */   
/*     */   public LIST<STAT> standings(HCLASS c) {
/* 162 */     return (LIST<STAT>)this.standings.get(c.index());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\RaceStats.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */