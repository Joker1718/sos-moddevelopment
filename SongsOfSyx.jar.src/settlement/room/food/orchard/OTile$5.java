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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   null(int $anonymous0) {
/* 121 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public void work(Humanoid a, int skill) {
/* 125 */     if (OTile.this.bProgress.get() >= smalldays) {
/* 126 */       OTile.this.setState(OTile.this.IBIG);
/*     */     } else {
/* 128 */       OTile.this.bProgress.inc((ROOMA)OTile.this.ins, skill);
/* 129 */     }  OTile.this.bDead.inc((ROOMA)OTile.this.ins, -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void fail() {
/* 134 */     if (OTile.this.bDead.get() == OTile.this.bDead.max()) {
/* 135 */       OTile.this.setState(OTile.this.ISAPLING);
/*     */     } else {
/* 137 */       OTile.this.bDead.inc((ROOMA)OTile.this.ins, 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int daysTillGrown() {
/* 142 */     return Math.max(0, (smalldays - OTile.this.bProgress.get()) / 4);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\orchard\OTile$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */