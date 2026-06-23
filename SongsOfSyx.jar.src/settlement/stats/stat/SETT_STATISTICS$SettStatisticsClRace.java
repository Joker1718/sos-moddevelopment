/*     */ package settlement.stats.stat;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPE_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.statistics.HISTORY_INT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SettStatisticsClRace
/*     */   implements SETT_STATISTICS
/*     */ {
/*  43 */   private final DataRaces[] datas = new DataRaces[HCLASSES.ALL().size()]; private final DataRaces total; private final INFO info;
/*     */   private final INT_O<Div> div;
/*     */   private final INT_O<HTYPE_RACE> type;
/*     */   
/*     */   public SettStatisticsClRace(String key, StatsInit init, CharSequence name, CharSequence desc) {
/*  48 */     this(key, init, new StatInfo(name, desc));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SettStatisticsClRace(String key, StatsInit init, INFO info) {
/* 102 */     this.div = new INT_O<Div>()
/*     */       {
/*     */         public int get(Div t)
/*     */         {
/* 106 */           return SETT_STATISTICS.SettStatisticsClRace.this.data(HCLASSES.CITIZEN()).get(t.race());
/*     */         }
/*     */ 
/*     */         
/*     */         public int min(Div t) {
/* 111 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max(Div t) {
/* 116 */           return SETT_STATISTICS.SettStatisticsClRace.this.dataDivider() * SETT_STATISTICS.SettStatisticsClRace.this.popDivider(HCLASSES.CITIZEN(), t.race(), 0);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 171 */     this.type = new INT_O<HTYPE_RACE>()
/*     */       {
/*     */         public int get(HTYPE_RACE t)
/*     */         {
/* 175 */           return SETT_STATISTICS.SettStatisticsClRace.this.data(t.cl.CLASS).get(t.race);
/*     */         }
/*     */ 
/*     */         
/*     */         public int min(HTYPE_RACE t) {
/* 180 */           return 0; }
/*     */         public double getD(Race t, int fromZero) { double d = (SETT_STATISTICS.SettStatisticsClRace.this.popDivider((HCLASS)HCLASSES.ALL().get(k), t, fromZero) * SETT_STATISTICS.SettStatisticsClRace.this.dataDivider()); if (d == 0.0D)
/*     */             return 0.0D;  return get(t, fromZero) / d; } public int min(Race t) { return 0; } public int max(Race t) { return SETT_STATISTICS.SettStatisticsClRace.this.popDivider((HCLASS)HCLASSES.ALL().get(k), t, 0) * SETT_STATISTICS.SettStatisticsClRace.this.dataDivider(); } }; for (int c = 0; c < this.datas.length; c++) {
/*     */       final int k = c; this.datas[c] = new DataRaces(key + "_" + key, init, false)
/*     */         {
/* 185 */           public int max(HTYPE_RACE t) { return SETT_STATISTICS.SettStatisticsClRace.this.dataDivider() * SETT_STATISTICS.SettStatisticsClRace.this.popDivider(t.cl.CLASS, t.race, 0); }
/*     */         };
/*     */     }  this.info = info; this.total = new DataRaces(key + "_ALL", init, false) { public double getD(Race t, int fromZero) { double d = (SETT_STATISTICS.SettStatisticsClRace.this.popDivider(null, t, fromZero) * SETT_STATISTICS.SettStatisticsClRace.this.dataDivider());
/*     */           if (d == 0.0D)
/*     */             return 0.0D; 
/*     */           return get(t, fromZero) / d; } public int min(Race t) { return 0; } public int max(Race t) { return SETT_STATISTICS.SettStatisticsClRace.this.popDivider(null, t, 0) * SETT_STATISTICS.SettStatisticsClRace.this.dataDivider(); } }
/*     */       ;
/* 192 */   } public INT_O<HTYPE_RACE> type() { return this.type; }
/*     */ 
/*     */   
/*     */   public INFO info() {
/*     */     return this.info;
/*     */   }
/*     */   
/*     */   public HISTORY_INT.HISTORY_INT_OBJECT<Race> data() {
/*     */     return data(null);
/*     */   }
/*     */   
/*     */   public HISTORY_INT.HISTORY_INT_OBJECT<Race> data(HCLASS c) {
/*     */     if (c == null)
/*     */       return this.total; 
/*     */     return this.datas[c.index()];
/*     */   }
/*     */   
/*     */   public INT_O<Div> div() {
/*     */     return this.div;
/*     */   }
/*     */   
/*     */   public void inc(HCLASS c, Race r, int am) {
/*     */     this.datas[c.index()].set(r, this.datas[c.index()].get(r) + am);
/*     */     this.datas[c.index()].set((Race)null, this.datas[c.index()].get(null) + am);
/*     */     if (c.player) {
/*     */       this.total.set(r, this.total.get(r) + am);
/*     */       this.total.set((Race)null, this.total.get(null) + am);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void inc(Induvidual i, int d) {
/*     */     if (i.added())
/*     */       inc(i.clas(), i.race(), d); 
/*     */   }
/*     */   
/*     */   protected int popDivider(HCLASS c, Race r, int daysback) {
/*     */     return (STATS.POP()).POP.data(c).get(r, daysback);
/*     */   }
/*     */   
/*     */   public int dataDivider() {
/*     */     return 1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\SETT_STATISTICS$SettStatisticsClRace.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */