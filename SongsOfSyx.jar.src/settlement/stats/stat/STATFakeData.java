/*     */ package settlement.stats.stat;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPE_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.statistics.HISTORY_INT;
/*     */ 
/*     */ public abstract class STATFakeData
/*     */   extends STAT
/*     */   implements StatsInit.StatUpdatable {
/*     */   private final SETT_STATISTICS.SettStatisticsClRace stats;
/*     */   private final INT_O.INT_OE<Induvidual> indu;
/*     */   
/*     */   public STATFakeData(String key, StatsInit init) {
/*  22 */     this(key, init.coll.key + "_" + init.coll.key, init, null);
/*  23 */     if (key == null)
/*  24 */       throw new RuntimeException(); 
/*     */   }
/*     */   
/*     */   public STATFakeData(String key, String dkey, StatsInit init, StatInfo info) {
/*  28 */     super(key, init, info);
/*     */     
/*  30 */     this.stats = new SETT_STATISTICS.SettStatisticsClRace(dkey, init, info)
/*     */       {
/*     */         public int dataDivider()
/*     */         {
/*  34 */           return STATFakeData.this.dataDivider();
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  39 */     this.indu = new INT_O.INT_OE<Induvidual>()
/*     */       {
/*     */         public int get(Induvidual t)
/*     */         {
/*  43 */           return (int)(STATFakeData.this.indu(t) * 16.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public int min(Induvidual t) {
/*  48 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max(Induvidual t) {
/*  53 */           return STATFakeData.this.dataDivider() * 16;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void set(Induvidual t, int i) {}
/*     */       };
/*  63 */     init.upers.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected double indu(Induvidual t) {
/*  68 */     return (int)data(t.clas()).getD(t.race());
/*     */   }
/*     */ 
/*     */   
/*     */   public int dataDivider() {
/*  73 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public INT_O.INT_OE<Induvidual> indu() {
/*  78 */     return this.indu;
/*     */   }
/*     */ 
/*     */   
/*     */   public HISTORY_INT.HISTORY_INT_OBJECT<Race> data() {
/*  83 */     return data(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public HISTORY_INT.HISTORY_INT_OBJECT<Race> data(HCLASS c) {
/*  88 */     return this.stats.data(c);
/*     */   }
/*     */ 
/*     */   
/*     */   public INT_O<Div> div() {
/*  93 */     return this.stats.div();
/*     */   }
/*     */ 
/*     */   
/*     */   public INT_O<HTYPE_RACE> type() {
/*  98 */     return this.stats.type();
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract double getDD(HCLASS paramHCLASS, Race paramRace);
/*     */ 
/*     */   
/*     */   public void update(double ds) {
/* 106 */     for (int ci = 0; ci < HCLASSES.ALL().size(); ci++) {
/* 107 */       HCLASS cl = (HCLASS)HCLASSES.ALL().get(ci);
/* 108 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 109 */         Race r = (Race)RACES.all().get(ri);
/* 110 */         int am = (int)(getDD(cl, r) * this.stats.popDivider(cl, r, 0) * dataDivider());
/* 111 */         this.stats.inc(cl, r, am - this.stats.data(cl).get(r));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\STATFakeData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */