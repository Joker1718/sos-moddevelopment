/*     */ package world.army;
/*     */ 
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BoosterAbs;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends BoosterAbs<WArmy>
/*     */ {
/*     */   null(BSourceInfo $anonymous0, boolean $anonymous1) {
/*  93 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   public double to() {
/*  97 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double pget(WArmy o) {
/* 102 */     return ADStats.this.rep().getD(o);
/*     */   }
/*     */ 
/*     */   
/*     */   public double from() {
/* 107 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getValue(double input) {
/* 112 */     return input;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADStats$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */