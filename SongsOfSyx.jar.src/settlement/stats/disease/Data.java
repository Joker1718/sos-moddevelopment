/*     */ package settlement.stats.disease;
/*     */ 
/*     */ import init.type.DISEASE;
/*     */ import init.type.DISEASES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STATData;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ class Data
/*     */ {
/*     */   final STATData infected;
/*     */   final STATData incubating;
/*     */   private final INT_O.INT_OE<Induvidual> index;
/*     */   public final INT_O.INT_OE<Induvidual> count;
/*     */   private final INT_O.INT_OE<Induvidual> status;
/*     */   final INT_O.INT_OE<Induvidual> die;
/*  22 */   private int[][] active = Alloc.i2(HCLASS_RACE.ALL().size(), DISEASES.all().size());
/*     */   
/*     */   private final StatsInit.Addable adder;
/*     */   
/*     */   Data(StatsInit init) {
/*  27 */     this.infected = new SS(init, "INFECTED", "D_INFECTED", DiseaseStatus.ISICK);
/*  28 */     this.incubating = new SS(init, "INCUBATE", "D_INCUBATE", DiseaseStatus.INCUBATING);
/*     */     
/*  30 */     this.incubating.info().setMatters(false, true);
/*     */     
/*  32 */     init.count.getClass(); this.index = (INT_O.INT_OE<Induvidual>)new DataO.DataByte(init.count, "DIS_INDEX");
/*  33 */     init.count.getClass(); this.count = (INT_O.INT_OE<Induvidual>)new DataO.DataNibble(init.count, "DIS_COUNT");
/*  34 */     init.count.getClass(); this.die = (INT_O.INT_OE<Induvidual>)new DataO.DataBit(init.count, "DIS_DIE");
/*  35 */     this.adder = new StatsInit.Addable()
/*     */       {
/*     */         
/*     */         public void addPrivate(Induvidual i)
/*     */         {
/*  40 */           if (i.player() && Data.this.get(i) != null && (Data.this.status(i)).active) {
/*  41 */             Data.this.active[(HCLASS_RACE.clP(i)).index][Data.this.get(i).index()] = Data.this.active[(HCLASS_RACE.clP(i)).index][Data.this.get(i).index()] + 1;
/*  42 */             Data.this.active[(HCLASS_RACE.clP(i.clas())).index][Data.this.get(i).index()] = Data.this.active[(HCLASS_RACE.clP(i.clas())).index][Data.this.get(i).index()] + 1;
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void removePrivate(Induvidual i) {
/*  48 */           if (i.player() && Data.this.get(i) != null && (Data.this.status(i)).active) {
/*     */             
/*  50 */             Data.this.active[(HCLASS_RACE.clP(i)).index][Data.this.get(i).index()] = Data.this.active[(HCLASS_RACE.clP(i)).index][Data.this.get(i).index()] - 1;
/*  51 */             Data.this.active[(HCLASS_RACE.clP(i.clas())).index][Data.this.get(i).index()] = Data.this.active[(HCLASS_RACE.clP(i.clas())).index][Data.this.get(i).index()] - 1;
/*     */             
/*  53 */             Data.this.active[(HCLASS_RACE.clP(i)).index][Data.this.get(i).index()] = Data.this.active[(HCLASS_RACE.clP(i)).index][Data.this.get(i).index()] & Integer.MAX_VALUE;
/*  54 */             Data.this.active[(HCLASS_RACE.clP(i.clas())).index][Data.this.get(i).index()] = Data.this.active[(HCLASS_RACE.clP(i.clas())).index][Data.this.get(i).index()] & Integer.MAX_VALUE;
/*     */           } 
/*     */         }
/*     */       };
/*  58 */     init.addable.add(this.adder);
/*     */     
/*  60 */     init.count.getClass(); this.status = (INT_O.INT_OE<Induvidual>)new DataO.DataNibble(init.count, "DIST_STATUS");
/*     */   }
/*     */   
/*     */   private class SS
/*     */     extends STATData
/*     */   {
/*     */     SS(StatsInit init, String key, String dkey, DiseaseStatus status) {
/*  67 */       super(key, key, init, new INT_O.INT_OE<Induvidual>(Data.this, status)
/*     */           {
/*     */             public int get(Induvidual t)
/*     */             {
/*  71 */               if (Data.this.get(t) != null && Data.this.status(t) == status)
/*  72 */                 return 1; 
/*  73 */               return 0;
/*     */             }
/*     */ 
/*     */             
/*     */             public int min(Induvidual t) {
/*  78 */               return 0;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max(Induvidual t) {
/*  83 */               return 1;
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void set(Induvidual t, int i) {}
/*     */           });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DISEASE get(Induvidual t) {
/*  97 */     int in = this.index.get(t) - 1;
/*  98 */     if (in < 0)
/*  99 */       return null; 
/* 100 */     return (DISEASE)DISEASES.all().get(in);
/*     */   }
/*     */   
/*     */   public DiseaseStatus status(Induvidual t) {
/* 104 */     return (DiseaseStatus)DiseaseStatus.ALL.getC(this.status.get(t));
/*     */   }
/*     */   
/*     */   public int cases(HCLASS_RACE pop, DISEASE d) {
/* 108 */     return this.active[pop.index][d.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(Induvidual t, DISEASE d, DiseaseStatus status) {
/* 113 */     this.infected.removeH(t);
/* 114 */     this.incubating.removeH(t);
/* 115 */     this.adder.removeH(t);
/*     */     
/* 117 */     int i = 0;
/* 118 */     if (d != null) {
/* 119 */       i = d.index() + 1;
/* 120 */       double f = d.fatalityRate;
/* 121 */       if (t.hType().parent() != t.hType())
/* 122 */         f *= (1.0F + RND.rFloat(5.0D)); 
/* 123 */       this.die.set(t, (RND.rFloat() < f) ? 1 : 0);
/*     */     } else {
/*     */       
/* 126 */       status = DiseaseStatus.NONE;
/*     */     } 
/*     */     
/* 129 */     this.index.set(t, i);
/* 130 */     this.status.set(t, status.ordinal());
/* 131 */     this.count.set(t, 0);
/*     */     
/* 133 */     this.infected.addH(t);
/* 134 */     this.incubating.addH(t);
/* 135 */     this.adder.addH(t);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\disease\Data.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */