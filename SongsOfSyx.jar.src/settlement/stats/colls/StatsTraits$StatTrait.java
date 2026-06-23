/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.battle.Armies;
/*     */ import game.battle.div.Div;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.TRAIT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class StatTrait
/*     */   implements DOUBLE_O.DOUBLE_OE<Induvidual>
/*     */ {
/*     */   public final TRAIT trait;
/*     */   private final Data data;
/*  70 */   private final double di = 0.06666666666666667D;
/*     */   
/*     */   StatTrait(StatsInit init, LISTE<StatTrait> all, TRAIT trait) {
/*  73 */     all.add(this);
/*  74 */     this.trait = trait;
/*  75 */     this.data = new Data(init, "TRAIT_" + trait.key());
/*     */   }
/*     */   
/*     */   public int get(HCLASS c, Race r) {
/*  79 */     int ci = (c == null) ? HCLASSES.ALL().size() : c.index();
/*  80 */     int ri = (r == null) ? RACES.all().size() : r.index;
/*  81 */     return this.data.gdata[ci][ri];
/*     */   }
/*     */   
/*     */   public double getD(HCLASS c, Race r) {
/*  85 */     double p = (STATS.POP()).POP.data(c).get(r);
/*  86 */     double v = get(c, r) * 0.06666666666666667D;
/*  87 */     if (p == 0.0D)
/*  88 */       return CLAMP.d(v, 0.0D, 1.0D); 
/*  89 */     return CLAMP.d(v / p, 0.0D, 1.0D);
/*     */   }
/*     */   
/*     */   public double getD(Div div) {
/*  93 */     return this.data.ddata[div.index()] * 0.06666666666666667D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getD(Induvidual t) {
/*  98 */     return this.data.indu.get(t) * 0.06666666666666667D;
/*     */   }
/*     */ 
/*     */   
/*     */   public DOUBLE_O.DOUBLE_OE<Induvidual> setD(Induvidual t, double d) {
/* 103 */     this.data.removePrivate(t);
/* 104 */     this.data.indu.set(t, (int)(d * 15.0D));
/* 105 */     this.data.addPrivate(t);
/* 106 */     return (DOUBLE_O.DOUBLE_OE<Induvidual>)this.data.indu;
/*     */   }
/*     */   
/*     */   private static class Data
/*     */     implements StatsInit.Addable {
/*     */     private final INT_O.INT_OE<Induvidual> indu;
/* 112 */     private int[][] gdata = Alloc.i2(HCLASSES.ALL().size() + 1, RACES.all().size() + 1);
/* 113 */     private int[] ddata = Alloc.ii(Armies.DIVISIONS);
/*     */     
/*     */     Data(StatsInit init, String key) {
/* 116 */       this.indu = (INT_O.INT_OE<Induvidual>)new DataO.DataNibble(init.count, "TRAIT_" + key);
/* 117 */       init.copier.add(new INT_O.INT_OE<Induvidual>()
/*     */           {
/*     */             public int get(Induvidual t)
/*     */             {
/* 121 */               return StatsTraits.StatTrait.Data.this.indu.get(t);
/*     */             }
/*     */ 
/*     */             
/*     */             public int min(Induvidual t) {
/* 126 */               return 0;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max(Induvidual t) {
/* 131 */               return 15;
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(Induvidual t, int i) {
/* 136 */               StatsTraits.StatTrait.Data.this.removeH(t);
/* 137 */               StatsTraits.StatTrait.Data.this.indu.set(t, i);
/* 138 */               StatsTraits.StatTrait.Data.this.addH(t);
/*     */             }
/*     */           });
/*     */       
/* 142 */       init.addable.add(this);
/*     */     }
/*     */ 
/*     */     
/*     */     public void addPrivate(Induvidual i) {
/* 147 */       if (i.player()) {
/* 148 */         this.gdata[i.clas().index()][RACES.all().size()] = this.gdata[i.clas().index()][RACES.all().size()] + this.indu.get(i);
/* 149 */         this.gdata[HCLASSES.ALL().size()][RACES.all().size()] = this.gdata[HCLASSES.ALL().size()][RACES.all().size()] + this.indu.get(i);
/*     */       } 
/* 151 */       this.gdata[i.clas().index()][(i.race()).index] = this.gdata[i.clas().index()][(i.race()).index] + this.indu.get(i);
/*     */     }
/*     */ 
/*     */     
/*     */     public void removePrivate(Induvidual i) {
/* 156 */       if (i.player()) {
/* 157 */         this.gdata[i.clas().index()][RACES.all().size()] = this.gdata[i.clas().index()][RACES.all().size()] - this.indu.get(i);
/* 158 */         this.gdata[HCLASSES.ALL().size()][RACES.all().size()] = this.gdata[HCLASSES.ALL().size()][RACES.all().size()] - this.indu.get(i);
/*     */       } 
/* 160 */       this.gdata[i.clas().index()][(i.race()).index] = this.gdata[i.clas().index()][(i.race()).index] - this.indu.get(i);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsTraits$StatTrait.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */