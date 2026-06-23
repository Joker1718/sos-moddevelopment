/*     */ package settlement.stats.stat;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HTYPE_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.data.INT_O;
/*     */ import util.statistics.HISTORY_INT;
/*     */ 
/*     */ public abstract class STATFakeRace
/*     */   extends STAT
/*     */   implements StatsInit.StatUpdatable
/*     */ {
/*     */   private final DataRaces history;
/*     */   private final INT_O.INT_OE<Induvidual> indu;
/*     */   private final INT_O.INT_OE<Div> div;
/*     */   private final INT_O.INT_OE<HTYPE_RACE> type;
/*     */   
/*     */   public STATFakeRace(String key, StatsInit init) {
/*  24 */     this(key, init, null);
/*  25 */     if (key == null)
/*  26 */       throw new RuntimeException(); 
/*     */   }
/*     */   
/*     */   public STATFakeRace(String key, StatsInit init, StatInfo info) {
/*  30 */     super(key, init, info);
/*     */     
/*  32 */     this.history = new DataRaces(key, init, false)
/*     */       {
/*     */         public double getD(Race t, int fromZero)
/*     */         {
/*  36 */           double d = STATFakeRace.this.dataDivider();
/*  37 */           if (d == 0.0D)
/*  38 */             return 0.0D; 
/*  39 */           return get(t, fromZero) / d;
/*     */         }
/*     */ 
/*     */         
/*     */         public int min(Race t) {
/*  44 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max(Race t) {
/*  49 */           return Integer.MAX_VALUE;
/*     */         }
/*     */       };
/*     */     
/*  53 */     this.indu = new II<Induvidual>()
/*     */       {
/*     */         public int get(Induvidual t)
/*     */         {
/*  57 */           return STATFakeRace.this.history.get(t.race());
/*     */         }
/*     */ 
/*     */         
/*     */         public double getD(Induvidual t) {
/*  62 */           return STATFakeRace.this.history.getD(t.race());
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  67 */     this.div = new II<Div>()
/*     */       {
/*     */         public int get(Div t)
/*     */         {
/*  71 */           return STATFakeRace.this.history.get(t.race());
/*     */         }
/*     */ 
/*     */         
/*     */         public double getD(Div t) {
/*  76 */           return STATFakeRace.this.history.getD(t.race());
/*     */         }
/*     */       };
/*     */     
/*  80 */     this.type = new II<HTYPE_RACE>()
/*     */       {
/*     */         public int get(HTYPE_RACE t)
/*     */         {
/*  84 */           return STATFakeRace.this.history.get(t.race);
/*     */         }
/*     */ 
/*     */         
/*     */         public double getD(HTYPE_RACE t) {
/*  89 */           return STATFakeRace.this.history.getD(t.race);
/*     */         }
/*     */       };
/*     */     
/*  93 */     init.upers.add(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int dataDivider() {
/*  99 */     return 1024;
/*     */   }
/*     */ 
/*     */   
/*     */   public INT_O.INT_OE<Induvidual> indu() {
/* 104 */     return this.indu;
/*     */   }
/*     */ 
/*     */   
/*     */   public HISTORY_INT.HISTORY_INT_OBJECT<Race> data() {
/* 109 */     return data(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public HISTORY_INT.HISTORY_INT_OBJECT<Race> data(HCLASS c) {
/* 114 */     return this.history;
/*     */   }
/*     */ 
/*     */   
/*     */   public INT_O<Div> div() {
/* 119 */     return (INT_O<Div>)this.div;
/*     */   }
/*     */ 
/*     */   
/*     */   public INT_O<HTYPE_RACE> type() {
/* 124 */     return (INT_O<HTYPE_RACE>)this.type;
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract double getDD(Race paramRace);
/*     */ 
/*     */   
/*     */   public void update(double ds) {
/* 132 */     int tot = 0;
/* 133 */     for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 134 */       Race r = (Race)RACES.all().get(ri);
/* 135 */       int am = (int)(dataDivider() * CLAMP.d(getDD(r), 0.0D, 1.0D));
/* 136 */       tot += am;
/* 137 */       this.history.set(r, am);
/*     */     } 
/*     */     
/* 140 */     this.history.set((Race)null, tot / RACES.all().size());
/*     */   }
/*     */ 
/*     */   
/*     */   private static abstract class II<T>
/*     */     implements INT_O.INT_OE<T>
/*     */   {
/*     */     public int min(T t) {
/* 148 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(T t) {
/* 153 */       return Integer.MAX_VALUE;
/*     */     }
/*     */     
/*     */     public void set(T t, int i) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\STATFakeRace.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */