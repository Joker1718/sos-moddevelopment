/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import settlement.stats.Induvidual;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements INT_O.INT_OE<Induvidual>
/*     */ {
/*     */   public int get(Induvidual t) {
/* 121 */     return StatsTraits.StatTrait.Data.this.indu.get(t);
/*     */   }
/*     */ 
/*     */   
/*     */   public int min(Induvidual t) {
/* 126 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max(Induvidual t) {
/* 131 */     return 15;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(Induvidual t, int i) {
/* 136 */     StatsTraits.StatTrait.Data.this.removeH(t);
/* 137 */     StatsTraits.StatTrait.Data.this.indu.set(t, i);
/* 138 */     StatsTraits.StatTrait.Data.this.addH(t);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsTraits$StatTrait$Data$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */