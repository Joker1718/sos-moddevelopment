/*     */ package settlement.room.food.orchard;
/*     */ 
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends FurnisherStat.FurnisherStatProduction2
/*     */ {
/*     */   null(Furnisher $anonymous0, INDUSTRY_HASER $anonymous1, double $anonymous2) {
/* 118 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */   }
/*     */   
/*     */   protected double getBase(AREA area, double[] acc) {
/* 122 */     double f = area.area();
/* 123 */     if (!Constructor.this.isIndoors) {
/* 124 */       f = 0.0D;
/* 125 */       for (COORDINATE c : area.body()) {
/* 126 */         if (area.is(c)) {
/* 127 */           f += Constructor.this.fertility(c.x(), c.y());
/*     */         }
/*     */       } 
/*     */     } 
/* 131 */     f /= area.area();
/* 132 */     f = CLAMP.d(f, 0.0D, 1.0D);
/* 133 */     return f * Constructor.this.workers.get(area, acc[Constructor.this.workers.index()]);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\orchard\Constructor$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */