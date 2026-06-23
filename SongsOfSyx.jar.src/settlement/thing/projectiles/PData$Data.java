/*     */ package settlement.thing.projectiles;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Data
/*     */ {
/*     */   private int sI;
/*     */   
/*     */   public float x() {
/* 148 */     return PData.this.space[this.sI + 0];
/*     */   }
/*     */   private void xSet(float x) {
/* 151 */     PData.this.space[this.sI + 0] = x;
/*     */   }
/*     */   public float y() {
/* 154 */     return PData.this.space[this.sI + 1];
/*     */   }
/*     */   private void ySet(float x) {
/* 157 */     PData.this.space[this.sI + 1] = x;
/*     */   }
/*     */   public float z() {
/* 160 */     return PData.this.space[this.sI + 2];
/*     */   }
/*     */   public void zSet(double x) {
/* 163 */     PData.this.space[this.sI + 2] = (float)x;
/*     */   }
/*     */   
/*     */   public float nx() {
/* 167 */     return PData.this.space[this.sI + 3];
/*     */   }
/*     */   public void nxSet(double x) {
/* 170 */     PData.this.space[this.sI + 3] = (float)x;
/*     */   }
/*     */   public float ny() {
/* 173 */     return PData.this.space[this.sI + 4];
/*     */   }
/*     */   public void nySet(double x) {
/* 176 */     PData.this.space[this.sI + 4] = (float)x;
/*     */   }
/*     */   public float dz() {
/* 179 */     return PData.this.space[this.sI + 5];
/*     */   }
/*     */   public void dzSet(double x) {
/* 182 */     PData.this.space[this.sI + 5] = (float)x;
/*     */   }
/*     */   void magnitudeSet(double x) {
/* 185 */     PData.this.space[this.sI + 6] = (float)x;
/*     */   }
/*     */   public double dMagnitude() {
/* 188 */     return PData.this.space[this.sI + 6];
/*     */   }
/*     */   
/*     */   public double speedX() {
/* 192 */     return nx() * dMagnitude();
/*     */   }
/*     */   
/*     */   public double speedY() {
/* 196 */     return ny() * dMagnitude();
/*     */   }
/*     */   
/*     */   public int qx() {
/* 200 */     return (int)x() >> Map.gridScroll;
/*     */   }
/*     */   
/*     */   public int qy() {
/* 204 */     return (int)y() >> Map.gridScroll;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\projectiles\PData$Data.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */