/*     */ package settlement.stats.stat;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HTYPE_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import util.data.INT_O;
/*     */ import util.statistics.HISTORY_INT;
/*     */ 
/*     */ public class STATInduOnly
/*     */   extends STAT
/*     */ {
/*     */   private final INT_O.INT_OE<Induvidual> indu;
/*     */   
/*  19 */   private static final HISTORY_INT.HISTORY_INT_OBJECT<Race> data = new HISTORY_INT.HISTORY_INT_OBJECT<Race>()
/*     */     {
/*     */       public int min(Race t)
/*     */       {
/*  23 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public int max(Race t) {
/*  28 */         return 1;
/*     */       }
/*     */ 
/*     */       
/*     */       public double getD(Race t, int fromZero) {
/*  33 */         return 0.0D;
/*     */       }
/*     */ 
/*     */       
/*     */       public TIMECYCLE time() {
/*  38 */         return (TIMECYCLE)TIME.days();
/*     */       }
/*     */ 
/*     */       
/*     */       public int historyRecords() {
/*  43 */         return 32;
/*     */       }
/*     */ 
/*     */       
/*     */       public int get(Race t, int fromZero) {
/*  48 */         return 0;
/*     */       }
/*     */     };
/*     */   
/*  52 */   private static final INT_O<Div> div = new INT_O<Div>()
/*     */     {
/*     */       public int get(Div t)
/*     */       {
/*  56 */         return 0;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public int min(Div t) {
/*  62 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public int max(Div t) {
/*  67 */         return 1;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  72 */   private static final INT_O<HTYPE_RACE> type = new INT_O<HTYPE_RACE>()
/*     */     {
/*     */       public int get(HTYPE_RACE t)
/*     */       {
/*  76 */         return 0;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public int min(HTYPE_RACE t) {
/*  82 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public int max(HTYPE_RACE t) {
/*  87 */         return 1;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   public STATInduOnly(String key, StatsInit init, INT_O.INT_OE<Induvidual> data) {
/*  94 */     super(key, init, null);
/*  95 */     this.indu = data;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int pdivider(HCLASS c, Race r, int daysback) {
/* 100 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int dataDivider() {
/* 105 */     return this.indu.max(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public INT_O.INT_OE<Induvidual> indu() {
/* 110 */     return this.indu;
/*     */   }
/*     */ 
/*     */   
/*     */   public HISTORY_INT.HISTORY_INT_OBJECT<Race> data() {
/* 115 */     return data(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public HISTORY_INT.HISTORY_INT_OBJECT<Race> data(HCLASS c) {
/* 120 */     return data;
/*     */   }
/*     */ 
/*     */   
/*     */   public INT_O<Div> div() {
/* 125 */     return div;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasIndu() {
/* 130 */     return (this.key != null && this.key.length() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public INT_O<HTYPE_RACE> type() {
/* 135 */     return type;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\STATInduOnly.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */