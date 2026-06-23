/*     */ package settlement.stats.stat;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPE_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.data.INT_O;
/*     */ import util.statistics.HISTORY_INT;
/*     */ 
/*     */ public abstract class STATFake
/*     */   extends STAT
/*     */ {
/*  20 */   private final ArrayList<HISTORY_INT.HISTORY_INT_OBJECT<Race>> datas = new ArrayList(
/*  21 */       HCLASSES.ALL().size() + 1);
/*     */   private final INT_O<Div> div;
/*     */   private final INT_O<HTYPE_RACE> type;
/*     */   private final INT_O.INT_OE<Induvidual> indu;
/*     */   
/*     */   public STATFake(String key, StatsInit init) {
/*  27 */     this(key, init, null);
/*     */   }
/*     */   
/*     */   public STATFake(String key, StatsInit init, StatInfo info) {
/*  31 */     super(key, init, info);
/*  32 */     for (HCLASS c : HCLASSES.ALL()) {
/*     */       
/*  34 */       this.datas.add(new HISTORY_INT.HISTORY_INT_OBJECT<Race>()
/*     */           {
/*     */             public int min(Race t)
/*     */             {
/*  38 */               return 0;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max(Race t) {
/*  43 */               return STATFake.this.dataDivider() * STATFake.this.pdivider(c, t, 0);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public double getD(Race t, int fromZero) {
/*  49 */               return STATFake.this.getDD(c, t, fromZero);
/*     */             }
/*     */ 
/*     */             
/*     */             public TIMECYCLE time() {
/*  54 */               return (TIMECYCLE)TIME.days();
/*     */             }
/*     */ 
/*     */             
/*     */             public int historyRecords() {
/*  59 */               return 32;
/*     */             }
/*     */ 
/*     */             
/*     */             public int get(Race t, int fromZero) {
/*  64 */               double d = (STATFake.this.dataDivider() * STATFake.this.pdivider(c, t, fromZero));
/*  65 */               return (int)(STATFake.this.getDD(c, t, fromZero) * d);
/*     */             }
/*     */           });
/*     */     } 
/*     */     
/*  70 */     this.datas.add(new HISTORY_INT.HISTORY_INT_OBJECT<Race>()
/*     */         {
/*     */           public int min(Race t)
/*     */           {
/*  74 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max(Race t) {
/*  79 */             return STATFake.this.dataDivider() * STATFake.this.pdivider(null, t, 0);
/*     */           }
/*     */ 
/*     */           
/*     */           public double getD(Race t, int fromZero) {
/*  84 */             double am = 0.0D;
/*  85 */             for (int hi = 0; hi < HCLASSES.ALL().size(); hi++) {
/*  86 */               HCLASS cl = (HCLASS)HCLASSES.ALL().get(hi);
/*  87 */               if (cl.player) {
/*  88 */                 am += (STATS.POP()).POP.data(cl).get(null, fromZero) * STATFake.this.getDD(cl, null, fromZero);
/*     */               }
/*     */             } 
/*  91 */             double pop = (STATS.POP()).POP.data().get(null, fromZero);
/*  92 */             if (pop == 0.0D)
/*  93 */               return ((am > 0.0D) ? true : false); 
/*  94 */             return am / pop;
/*     */           }
/*     */ 
/*     */           
/*     */           public TIMECYCLE time() {
/*  99 */             return (TIMECYCLE)TIME.days();
/*     */           }
/*     */ 
/*     */           
/*     */           public int historyRecords() {
/* 104 */             return 32;
/*     */           }
/*     */ 
/*     */           
/*     */           public int get(Race t, int fromZero) {
/* 109 */             double d = (STATFake.this.dataDivider() * STATFake.this.pdivider(null, t, fromZero));
/* 110 */             return (int)(getD(t, fromZero) * d);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 115 */     this.div = new INT_O<Div>()
/*     */       {
/*     */         public int get(Div t)
/*     */         {
/* 119 */           return STATFake.this.data(HCLASSES.CITIZEN()).get(t.race());
/*     */         }
/*     */ 
/*     */         
/*     */         public int min(Div t) {
/* 124 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max(Div t) {
/* 129 */           return STATFake.this.dataDivider() * STATFake.this.pdivider(HCLASSES.CITIZEN(), t.race(), 0);
/*     */         }
/*     */       };
/*     */     
/* 133 */     this.type = new INT_O<HTYPE_RACE>()
/*     */       {
/*     */         public int get(HTYPE_RACE t)
/*     */         {
/* 137 */           return STATFake.this.data(t.cl.CLASS).get(t.race);
/*     */         }
/*     */ 
/*     */         
/*     */         public int min(HTYPE_RACE t) {
/* 142 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max(HTYPE_RACE t) {
/* 147 */           return STATFake.this.dataDivider() * STATFake.this.pdivider(t.cl.CLASS, t.race, 0);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 152 */     this.indu = new INT_O.INT_OE<Induvidual>()
/*     */       {
/*     */         public int get(Induvidual t)
/*     */         {
/* 156 */           return (int)(64.0D * STATFake.this.induGet(t));
/*     */         }
/*     */ 
/*     */         
/*     */         public int min(Induvidual t) {
/* 161 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max(Induvidual t) {
/* 166 */           return 64;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void set(Induvidual t, int i) {}
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected double induGet(Induvidual t) {
/* 178 */     return getDD(t.clas(), t.race(), 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public INT_O.INT_OE<Induvidual> indu() {
/* 183 */     return this.indu;
/*     */   }
/*     */ 
/*     */   
/*     */   public HISTORY_INT.HISTORY_INT_OBJECT<Race> data() {
/* 188 */     return data(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public HISTORY_INT.HISTORY_INT_OBJECT<Race> data(HCLASS c) {
/* 193 */     if (c == null)
/* 194 */       return (HISTORY_INT.HISTORY_INT_OBJECT<Race>)this.datas.get(this.datas.size() - 1); 
/* 195 */     return (HISTORY_INT.HISTORY_INT_OBJECT<Race>)this.datas.get(c.index());
/*     */   }
/*     */ 
/*     */   
/*     */   public INT_O<HTYPE_RACE> type() {
/* 200 */     return this.type;
/*     */   }
/*     */ 
/*     */   
/*     */   public INT_O<Div> div() {
/* 205 */     return this.div;
/*     */   }
/*     */   
/*     */   protected abstract double getDD(HCLASS paramHCLASS, Race paramRace, int paramInt);
/*     */   
/*     */   protected int pdivider(HCLASS c, Race r, int daysback) {
/* 211 */     return (STATS.POP()).POP.data(c).get(r, daysback);
/*     */   }
/*     */ 
/*     */   
/*     */   public int dataDivider() {
/* 216 */     return 1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\STATFake.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */