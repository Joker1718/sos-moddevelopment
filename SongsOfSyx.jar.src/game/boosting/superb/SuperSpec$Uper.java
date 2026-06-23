/*     */ package game.boosting.superb;
/*     */ 
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.time.TIME;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Uper<T extends SuperBoostableObj>
/*     */   extends SuperSpec.SuperSpecImp<T>
/*     */ {
/*     */   private final double decreaseTime;
/*     */   private final double maxTime;
/*     */   
/*     */   public Uper(double daysToIncrease, SuperBoostable<T> self, String key, BSourceInfo info, CharSequence desc, double to, boolean isMul) {
/* 298 */     this(daysToIncrease, -1.0D, self, key, info, desc, to, isMul);
/*     */   }
/*     */   
/*     */   public Uper(double daysToDecrease, double maxDays, SuperBoostable<T> self, String key, BSourceInfo info, CharSequence desc, double to, boolean isMul) {
/* 302 */     super(self, key, info, desc, to, isMul);
/* 303 */     if (daysToDecrease == 0.0D)
/* 304 */       throw new RuntimeException(); 
/* 305 */     this.decreaseTime = daysToDecrease * TIME.secondsPerDayI();
/* 306 */     this.maxTime = maxDays * TIME.secondsPerDay();
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(T bo, double time) {
/* 311 */     if (this.state.getD(bo) == 1.0D) {
/* 312 */       if (this.maxTime >= 0.0D) {
/* 313 */         double t = this.time.incD(bo, -time).getD(bo);
/* 314 */         if (t <= 0.0D) {
/* 315 */           activate(bo, false);
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */       
/* 321 */       this.value.incD(bo, time * this.decreaseTime);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double pget(T bo) {
/* 328 */     if (this.state.getD(bo) == 0.0D)
/* 329 */       return 0.0D; 
/* 330 */     if (this.maxTime > 0.0D && this.time.getD(bo) <= 0.0D)
/* 331 */       return 0.0D; 
/* 332 */     return this.value.getD(bo);
/*     */   }
/*     */ 
/*     */   
/*     */   public void activate(T bo, boolean active) {
/* 337 */     this.time.setD(bo, this.maxTime);
/* 338 */     this.value.setD(bo, 0.0D);
/* 339 */     this.state.setD(bo, (active ? true : false));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean activated(T bo) {
/* 345 */     return (this.state.getD(bo) == 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public double secondsRemaining(T bo) {
/* 350 */     if (this.maxTime >= 0.0D)
/* 351 */       return this.time.getD(bo); 
/* 352 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double increase(T bo) {
/* 357 */     return this.decreaseTime * TIME.secondsPerDay();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\superb\SuperSpec$Uper.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */