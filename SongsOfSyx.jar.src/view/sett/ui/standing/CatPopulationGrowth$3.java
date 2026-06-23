/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASSES;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements INT.INTE
/*     */ {
/*     */   double[] d;
/*     */   
/*     */   null() {
/* 112 */     this.d = new double[RACES.all().size()];
/*     */     
/* 114 */     Arrays.fill(this.d, 1.0D);
/*     */   }
/*     */   
/*     */   public int min() {
/* 118 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max() {
/* 123 */     if (CatPopulationGrowth.this.cl == HCLASSES.CITIZEN())
/* 124 */       return SETT.ENTRY().immi().wanted((Race)CatPopulationGrowth.this.race.get()); 
/* 125 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get() {
/* 130 */     if (CatPopulationGrowth.this.race.get() != null)
/* 131 */       return (int)(max() * this.d[((Race)CatPopulationGrowth.this.race.get()).index]); 
/* 132 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(int t) {
/* 137 */     this.d[((Race)CatPopulationGrowth.this.race.get()).index] = t / max();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatPopulationGrowth$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */