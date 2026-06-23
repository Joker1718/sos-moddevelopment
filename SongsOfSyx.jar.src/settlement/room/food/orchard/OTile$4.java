/*     */ package settlement.room.food.orchard;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.main.ROOMA;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends OTile.STATE
/*     */ {
/*     */   private final int failA;
/*     */   
/*     */   null(int $anonymous0) {
/*  96 */     super($anonymous0);
/*     */     
/*  98 */     this.failA = (int)Math.ceil(paramInt1 / 16.0D);
/*     */   }
/*     */   
/*     */   public void fail() {
/* 102 */     OTile.this.bProgress.inc((ROOMA)OTile.this.ins, -this.failA);
/*     */   }
/*     */ 
/*     */   
/*     */   public void work(Humanoid a, int skill) {
/* 107 */     if (OTile.this.bProgress.get() >= sdays) {
/* 108 */       OTile.this.setState(OTile.this.ISMALL);
/*     */     } else {
/* 110 */       OTile.this.bProgress.inc((ROOMA)OTile.this.ins, skill);
/*     */     } 
/* 112 */     OTile.this.bDead.inc((ROOMA)OTile.this.ins, -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public int daysTillGrown() {
/* 117 */     return Math.max(0, b.time.DAYS_TILL_GROWTH - OTile.this.bProgress.get() / 4);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\orchard\OTile$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */