/*     */ package game.battle.thread.status;
/*     */ 
/*     */ import init.constant.Config;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Surrounder
/*     */ {
/* 283 */   private final VectorImp vec = new VectorImp();
/* 284 */   int size = Math.max((Config.battle()).DIVISIONS_PER_ARMY, (Config.battle()).MEN_PER_DIVISION);
/* 285 */   int current = 0;
/* 286 */   private final double[] dxs = new double[this.size];
/* 287 */   private final double[] dys = new double[this.size];
/* 288 */   private final double[] amounts = new double[this.size];
/*     */   
/*     */   public void init() {
/* 291 */     this.current = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(double px, double py, double amount) {
/* 296 */     this.dxs[this.current] = px;
/* 297 */     this.dys[this.current] = py;
/* 298 */     this.amounts[this.current] = amount;
/* 299 */     this.current++;
/*     */   }
/*     */   
/*     */   public double getValue(double cx, double cy) {
/* 303 */     if (this.current == 0) {
/* 304 */       return 0.0D;
/*     */     }
/* 306 */     convertToVectors(cx, cy);
/*     */     
/* 308 */     double xs = 0.0D;
/* 309 */     double ys = 0.0D;
/* 310 */     double am = 0.0D;
/* 311 */     for (int i = 0; i < this.current; i++) {
/* 312 */       xs += this.dxs[i] * this.amounts[i];
/* 313 */       ys += this.dys[i] * this.amounts[i];
/* 314 */       am += this.amounts[i];
/*     */     } 
/*     */     
/* 317 */     if (am == 0.0D) {
/* 318 */       return 0.0D;
/*     */     }
/* 320 */     xs /= am;
/* 321 */     ys /= am;
/* 322 */     if (xs == 0.0D && ys == 0.0D) {
/* 323 */       xs = this.dxs[0];
/* 324 */       ys = this.dys[0];
/*     */     } 
/*     */     
/* 327 */     this.vec.set(xs, ys);
/* 328 */     xs = this.vec.nX();
/* 329 */     ys = this.vec.nY();
/*     */     
/* 331 */     double v = 0.0D;
/*     */     
/* 333 */     for (int j = 0; j < this.current; j++) {
/* 334 */       double dot = this.dxs[j] * xs + this.dys[j] * ys;
/* 335 */       if (dot < -0.6D) {
/* 336 */         dot = -dot;
/* 337 */         dot /= 0.4D;
/*     */ 
/*     */         
/* 340 */         v += dot * this.amounts[j];
/*     */       } 
/*     */     } 
/* 343 */     return v;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void convertToVectors(double cx, double cy) {
/* 349 */     for (int i = 0; i < this.current; i++) {
/* 350 */       double dx = this.dxs[i] - cx;
/* 351 */       double dy = this.dys[i] - cy;
/* 352 */       this.vec.set(dx, dy);
/* 353 */       dx = this.vec.nX();
/* 354 */       dy = this.vec.nY();
/* 355 */       this.dxs[i] = this.vec.nX();
/* 356 */       this.dys[i] = this.vec.nY();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\status\Updater$Surrounder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */