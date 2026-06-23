/*     */ package settlement.stats.stat;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import init.constant.Config;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPE_RACE;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.statistics.HISTORY_INT;
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface SETT_STATISTICS
/*     */ {
/*     */   INFO info();
/*     */   
/*     */   HISTORY_INT.HISTORY_INT_OBJECT<Race> data();
/*     */   
/*     */   HISTORY_INT.HISTORY_INT_OBJECT<Race> data(HCLASS paramHCLASS);
/*     */   
/*     */   INT_O<Div> div();
/*     */   
/*     */   INT_O<HTYPE_RACE> type();
/*     */   
/*     */   default int dataDivider() {
/*  38 */     return 1;
/*     */   }
/*     */   
/*     */   public static class SettStatisticsClRace
/*     */     implements SETT_STATISTICS {
/*  43 */     private final DataRaces[] datas = new DataRaces[HCLASSES.ALL().size()]; private final DataRaces total; private final INFO info;
/*     */     private final INT_O<Div> div;
/*     */     private final INT_O<HTYPE_RACE> type;
/*     */     
/*     */     public SettStatisticsClRace(String key, StatsInit init, CharSequence name, CharSequence desc) {
/*  48 */       this(key, init, new StatInfo(name, desc));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SettStatisticsClRace(String key, StatsInit init, INFO info) {
/* 102 */       this.div = new INT_O<Div>()
/*     */         {
/*     */           public int get(Div t)
/*     */           {
/* 106 */             return SETT_STATISTICS.SettStatisticsClRace.this.data(HCLASSES.CITIZEN()).get(t.race());
/*     */           }
/*     */ 
/*     */           
/*     */           public int min(Div t) {
/* 111 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max(Div t) {
/* 116 */             return SETT_STATISTICS.SettStatisticsClRace.this.dataDivider() * SETT_STATISTICS.SettStatisticsClRace.this.popDivider(HCLASSES.CITIZEN(), t.race(), 0);
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 171 */       this.type = new INT_O<HTYPE_RACE>()
/*     */         {
/*     */           public int get(HTYPE_RACE t)
/*     */           {
/* 175 */             return SETT_STATISTICS.SettStatisticsClRace.this.data(t.cl.CLASS).get(t.race);
/*     */           }
/*     */ 
/*     */           
/*     */           public int min(HTYPE_RACE t) {
/* 180 */             return 0; }
/*     */           public double getD(Race t, int fromZero) { double d = (SETT_STATISTICS.SettStatisticsClRace.this.popDivider((HCLASS)HCLASSES.ALL().get(k), t, fromZero) * SETT_STATISTICS.SettStatisticsClRace.this.dataDivider()); if (d == 0.0D)
/*     */               return 0.0D;  return get(t, fromZero) / d; } public int min(Race t) { return 0; } public int max(Race t) { return SETT_STATISTICS.SettStatisticsClRace.this.popDivider((HCLASS)HCLASSES.ALL().get(k), t, 0) * SETT_STATISTICS.SettStatisticsClRace.this.dataDivider(); } }; for (int c = 0; c < this.datas.length; c++)
/*     */       { final int k = c; this.datas[c] = new DataRaces(key + "_" + key, init, false)
/*     */           {
/* 185 */             public int max(HTYPE_RACE t) { return SETT_STATISTICS.SettStatisticsClRace.this.dataDivider() * SETT_STATISTICS.SettStatisticsClRace.this.popDivider(t.cl.CLASS, t.race, 0); }
/*     */           }; }  this.info = info; this.total = new DataRaces(key + "_ALL", init, false) {
/*     */           public double getD(Race t, int fromZero) { double d = (SETT_STATISTICS.SettStatisticsClRace.this.popDivider(null, t, fromZero) * SETT_STATISTICS.SettStatisticsClRace.this.dataDivider()); if (d == 0.0D) return 0.0D;  return get(t, fromZero) / d; }
/*     */           public int min(Race t) { return 0; }
/*     */           public int max(Race t) { return SETT_STATISTICS.SettStatisticsClRace.this.popDivider(null, t, 0) * SETT_STATISTICS.SettStatisticsClRace.this.dataDivider(); }
/*     */         };
/*     */     }
/* 192 */     public INFO info() { return this.info; } public HISTORY_INT.HISTORY_INT_OBJECT<Race> data() { return data(null); } public HISTORY_INT.HISTORY_INT_OBJECT<Race> data(HCLASS c) { if (c == null) return this.total;  return this.datas[c.index()]; } public INT_O<Div> div() { return this.div; } public INT_O<HTYPE_RACE> type() { return this.type; } public void inc(HCLASS c, Race r, int am) { this.datas[c.index()].set(r, this.datas[c.index()].get(r) + am);
/*     */       this.datas[c.index()].set((Race)null, this.datas[c.index()].get(null) + am);
/*     */       if (c.player) {
/*     */         this.total.set(r, this.total.get(r) + am);
/*     */         this.total.set((Race)null, this.total.get(null) + am);
/*     */       }  }
/*     */     public void inc(Induvidual i, int d) { if (i.added())
/*     */         inc(i.clas(), i.race(), d);  }
/*     */     protected int popDivider(HCLASS c, Race r, int daysback) { return (STATS.POP()).POP.data(c).get(r, daysback); }
/*     */     public int dataDivider() { return 1; } }
/* 202 */   public static class SettStatistics implements SETT_STATISTICS { private final DataRaces[] datas = new DataRaces[HCLASSES.ALL().size()];
/*     */     private final DataRaces total;
/* 204 */     private int[] divData = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY * 2);
/* 205 */     private int[] typeData = Alloc.ii(HTYPE_RACE.ALL().size()); private final INFO info; private final INT_O<Div> div;
/*     */     private final INT_O<HTYPE_RACE> type;
/*     */     
/*     */     public SettStatistics(String key, StatsInit init, CharSequence name, CharSequence desc) {
/* 209 */       this(key, init, new StatInfo(name, desc));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public SettStatistics(String key, StatsInit init, INFO info) {
/* 283 */       this.div = new INT_O<Div>()
/*     */         {
/*     */           public int get(Div t)
/*     */           {
/* 287 */             return SETT_STATISTICS.SettStatistics.this.divData[t.index()];
/*     */           }
/*     */ 
/*     */           
/*     */           public int min(Div t) {
/* 292 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public double getD(Div t) {
/* 297 */             double p = (STATS.POP()).POP.div().get(t);
/* 298 */             if (p == 0.0D)
/* 299 */               return 0.0D; 
/* 300 */             return get(t) / SETT_STATISTICS.SettStatistics.this.dataDivider() * p;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max(Div t) {
/* 305 */             return Integer.MAX_VALUE;
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 374 */       this.type = new INT_O<HTYPE_RACE>()
/*     */         {
/*     */           public int get(HTYPE_RACE t)
/*     */           {
/* 378 */             return SETT_STATISTICS.SettStatistics.this.typeData[t.index()];
/*     */           }
/*     */ 
/*     */           
/*     */           public int min(HTYPE_RACE t) {
/* 383 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public double getD(HTYPE_RACE t) {
/* 388 */             double p = (STATS.POP()).POP.type().get(t);
/* 389 */             if (p == 0.0D)
/* 390 */               return 0.0D; 
/* 391 */             return get(t) / SETT_STATISTICS.SettStatistics.this.dataDivider() * p;
/*     */           }
/*     */           
/*     */           public int max(HTYPE_RACE t)
/*     */           {
/* 396 */             return Integer.MAX_VALUE; } }; for (int c = 0; c < this.datas.length; c++) { final int k = c; this.datas[c] = new DataRaces(key + "_" + key, init, true) { public double getD(Race t, int fromZero) { double d = (SETT_STATISTICS.SettStatistics.this.popDivider((HCLASS)HCLASSES.ALL().get(k), t, fromZero) * SETT_STATISTICS.SettStatistics.this.dataDivider()); if (d == 0.0D) return 0.0D;  return get(t, fromZero) / d; } public int min(Race t) { return 0; } public int max(Race t) { return SETT_STATISTICS.SettStatistics.this.popDivider((HCLASS)HCLASSES.ALL().get(k), t, 0) * SETT_STATISTICS.SettStatistics.this.dataDivider(); } }
/*     */           ; }  this.info = info; this.total = new DataRaces(key + "_ALL", init, true) { public double getD(Race t, int fromZero) { double d = (SETT_STATISTICS.SettStatistics.this.popDivider(null, t, fromZero) * SETT_STATISTICS.SettStatistics.this.dataDivider()); if (d == 0.0D) return 0.0D;  return get(t, fromZero) / d; } public int min(Race t) { return 0; } public int max(Race t) { return SETT_STATISTICS.SettStatistics.this.popDivider(null, t, 0) * SETT_STATISTICS.SettStatistics.this.dataDivider(); } }
/*     */         ; init.savers.put(key + "_DIV", new SAVABLE() { public void save(FilePutter file) {} public void load(FileGetter file) throws IOException {} public void clear() { Arrays.fill(SETT_STATISTICS.SettStatistics.this.divData, 0); Arrays.fill(SETT_STATISTICS.SettStatistics.this.typeData, 0); } }
/*     */         );
/*     */     }
/*     */     public INFO info() { return this.info; }
/*     */     public HISTORY_INT.HISTORY_INT_OBJECT<Race> data() { return data(null); }
/* 403 */     public INT_O<HTYPE_RACE> type() { return this.type; }
/*     */ 
/*     */     
/*     */     public HISTORY_INT.HISTORY_INT_OBJECT<Race> data(HCLASS c) {
/*     */       if (c == null)
/*     */         return this.total; 
/*     */       return this.datas[c.index()];
/*     */     }
/*     */     
/*     */     public INT_O<Div> div() {
/*     */       return this.div;
/*     */     }
/*     */     
/*     */     public void inc(HTYPE type, Race r, int am, int divi) {
/*     */       this.typeData[(HTYPE_RACE.get(r, type)).index] = this.typeData[(HTYPE_RACE.get(r, type)).index] + am;
/*     */       this.typeData[(HTYPE_RACE.get(null, type)).index] = this.typeData[(HTYPE_RACE.get(null, type)).index] + am;
/*     */       this.typeData[(HTYPE_RACE.get(r, null)).index] = this.typeData[(HTYPE_RACE.get(r, null)).index] + am;
/*     */       HCLASS c = type.CLASS;
/*     */       this.datas[c.index()].set(r, this.datas[c.index()].get(r) + am);
/*     */       this.datas[c.index()].set((Race)null, this.datas[c.index()].get(null) + am);
/*     */       if (c.player) {
/*     */         this.total.set(r, this.total.get(r) + am);
/*     */         this.total.set((Race)null, this.total.get(null) + am);
/*     */       } 
/*     */       if (divi != -1)
/*     */         this.divData[divi] = this.divData[divi] + am; 
/*     */     }
/*     */     
/*     */     public void inc(Induvidual i, int d) {
/*     */       if (i.added()) {
/*     */         Div div = (STATS.BATTLE()).DIV.get(i);
/*     */         inc(i.hType(), i.race(), d, (div == null) ? -1 : div.index());
/*     */       } 
/*     */     }
/*     */     
/*     */     protected int popDivider(HCLASS c, Race r, int daysback) {
/*     */       return (STATS.POP()).POP.data(c).get(r, daysback);
/*     */     }
/*     */     
/*     */     public int dataDivider() {
/*     */       return 1;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\SETT_STATISTICS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */