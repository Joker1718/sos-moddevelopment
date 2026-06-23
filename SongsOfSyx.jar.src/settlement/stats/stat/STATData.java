/*     */ package settlement.stats.stat;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HTYPE_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.statistics.HISTORY_INT;
/*     */ 
/*     */ public class STATData
/*     */   extends STAT
/*     */   implements StatsInit.Addable {
/*     */   public final SETT_STATISTICS.SettStatistics stats;
/*     */   private final INT_O.INT_OE<Induvidual> indu;
/*     */   
/*     */   public STATData(String key, String dkey, StatsInit init, INT_O.INT_OE<Induvidual> data) {
/*  22 */     this(key, dkey, init, data, (StatInfo)null);
/*     */   }
/*     */   
/*     */   public STATData(String key, StatsInit init, DataO<Induvidual>.DataAbs data) {
/*  26 */     this(key, data.key, init, (INT_O.INT_OE<Induvidual>)data, (StatInfo)null);
/*     */   }
/*     */   
/*     */   public STATData(String key, StatsInit init, DataO<Induvidual>.DataAbs data, StatInfo info) {
/*  30 */     this(key, data.key, init, (INT_O.INT_OE<Induvidual>)data, info);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STATData(String key, String dkey, StatsInit init, final INT_O.INT_OE<Induvidual> data, StatInfo info) {
/*  40 */     super(key, init, info);
/*     */     
/*  42 */     this.stats = new SETT_STATISTICS.SettStatistics(dkey, init, this.info)
/*     */       {
/*     */         protected int popDivider(HCLASS c, Race r, int daysback)
/*     */         {
/*  46 */           return STATData.this.pdivider(c, r, daysback);
/*     */         }
/*     */ 
/*     */         
/*     */         public int dataDivider() {
/*  51 */           return STATData.this.dataDivider();
/*     */         }
/*     */       };
/*     */     
/*  55 */     this.indu = new INT_O.INT_OE<Induvidual>()
/*     */       {
/*     */         public int get(Induvidual t)
/*     */         {
/*  59 */           return data.get(t);
/*     */         }
/*     */ 
/*     */         
/*     */         public int min(Induvidual t) {
/*  64 */           return data.min(t);
/*     */         }
/*     */ 
/*     */         
/*     */         public int max(Induvidual t) {
/*  69 */           return data.max(t);
/*     */         }
/*     */ 
/*     */         
/*     */         public double getD(Induvidual t) {
/*  74 */           return data.getD(t);
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(Induvidual t, int i) {
/*  79 */           STATData.this.removeH(t);
/*  80 */           data.set(t, i);
/*  81 */           STATData.this.addH(t);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  86 */     init.addable.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int pdivider(HCLASS c, Race r, int daysback) {
/*  91 */     return (STATS.POP()).POP.data(c).get(r, daysback);
/*     */   }
/*     */ 
/*     */   
/*     */   public int dataDivider() {
/*  96 */     return this.indu.max(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addPrivate(Induvidual i) {
/* 101 */     this.stats.inc(i, this.indu.get(i));
/*     */   }
/*     */ 
/*     */   
/*     */   public void removePrivate(Induvidual i) {
/* 106 */     this.stats.inc(i, -this.indu.get(i));
/*     */   }
/*     */ 
/*     */   
/*     */   public INT_O.INT_OE<Induvidual> indu() {
/* 111 */     return this.indu;
/*     */   }
/*     */ 
/*     */   
/*     */   public HISTORY_INT.HISTORY_INT_OBJECT<Race> data() {
/* 116 */     return data((HCLASS)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public HISTORY_INT.HISTORY_INT_OBJECT<Race> data(HCLASS c) {
/* 121 */     return this.stats.data(c);
/*     */   }
/*     */ 
/*     */   
/*     */   public INT_O<Div> div() {
/* 126 */     return this.stats.div();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasIndu() {
/* 131 */     return (this.key != null && this.key.length() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public INT_O<HTYPE_RACE> type() {
/* 136 */     return this.stats.type();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\STATData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */