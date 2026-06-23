/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.battle.Armies;
/*     */ import init.race.RACES;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.file.Alloc;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Data
/*     */   implements StatsInit.Addable
/*     */ {
/*     */   private final INT_O.INT_OE<Induvidual> indu;
/* 112 */   private int[][] gdata = Alloc.i2(HCLASSES.ALL().size() + 1, RACES.all().size() + 1);
/* 113 */   private int[] ddata = Alloc.ii(Armies.DIVISIONS);
/*     */   
/*     */   Data(StatsInit init, String key) {
/* 116 */     this.indu = (INT_O.INT_OE<Induvidual>)new DataO.DataNibble(init.count, "TRAIT_" + key);
/* 117 */     init.copier.add(new INT_O.INT_OE<Induvidual>()
/*     */         {
/*     */           public int get(Induvidual t)
/*     */           {
/* 121 */             return StatsTraits.StatTrait.Data.this.indu.get(t);
/*     */           }
/*     */ 
/*     */           
/*     */           public int min(Induvidual t) {
/* 126 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max(Induvidual t) {
/* 131 */             return 15;
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(Induvidual t, int i) {
/* 136 */             StatsTraits.StatTrait.Data.this.removeH(t);
/* 137 */             StatsTraits.StatTrait.Data.this.indu.set(t, i);
/* 138 */             StatsTraits.StatTrait.Data.this.addH(t);
/*     */           }
/*     */         });
/*     */     
/* 142 */     init.addable.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addPrivate(Induvidual i) {
/* 147 */     if (i.player()) {
/* 148 */       this.gdata[i.clas().index()][RACES.all().size()] = this.gdata[i.clas().index()][RACES.all().size()] + this.indu.get(i);
/* 149 */       this.gdata[HCLASSES.ALL().size()][RACES.all().size()] = this.gdata[HCLASSES.ALL().size()][RACES.all().size()] + this.indu.get(i);
/*     */     } 
/* 151 */     this.gdata[i.clas().index()][(i.race()).index] = this.gdata[i.clas().index()][(i.race()).index] + this.indu.get(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removePrivate(Induvidual i) {
/* 156 */     if (i.player()) {
/* 157 */       this.gdata[i.clas().index()][RACES.all().size()] = this.gdata[i.clas().index()][RACES.all().size()] - this.indu.get(i);
/* 158 */       this.gdata[HCLASSES.ALL().size()][RACES.all().size()] = this.gdata[HCLASSES.ALL().size()][RACES.all().size()] - this.indu.get(i);
/*     */     } 
/* 160 */     this.gdata[i.clas().index()][(i.race()).index] = this.gdata[i.clas().index()][(i.race()).index] - this.indu.get(i);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsTraits$StatTrait$Data.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */