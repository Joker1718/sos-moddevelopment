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
/*     */ public class Downer<T extends SuperBoostableObj>
/*     */   extends SuperSpec.SuperSpecImp<T>
/*     */ {
/*     */   private final double decreaseTime;
/*     */   private final double durationDays;
/*     */   
/*     */   public Downer(double daysToDecrease, SuperBoostable<T> self, String key, BSourceInfo info, CharSequence desc, double to, boolean isMul, double durationDays) {
/* 247 */     super(self, key, info, desc, to, isMul);
/* 248 */     if (daysToDecrease == 0.0D)
/* 249 */       throw new RuntimeException(); 
/* 250 */     this.decreaseTime = daysToDecrease * TIME.secondsPerDayI();
/* 251 */     this.durationDays = durationDays;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(T bo, double time) {
/* 256 */     if (this.time.getD(bo) > 0.0D) {
/* 257 */       this.time.incD(bo, -time);
/*     */       return;
/*     */     } 
/* 260 */     this.value.incD(bo, -time * this.decreaseTime);
/*     */   }
/*     */ 
/*     */   
/*     */   public void activate(T bo, boolean active) {
/* 265 */     this.value.setD(bo, active ? 1.0D : 0.0D);
/* 266 */     this.time.setD(bo, this.durationDays * TIME.secondsPerDay());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean activated(T bo) {
/* 271 */     return (this.value.getD(bo) > 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public double secondsRemaining(T bo) {
/* 276 */     return this.time.getD(bo);
/*     */   }
/*     */ 
/*     */   
/*     */   public double increase(T bo) {
/* 281 */     return -this.decreaseTime * TIME.secondsPerDay();
/*     */   }
/*     */ 
/*     */   
/*     */   protected double pget(T o) {
/* 286 */     return this.value.getD(o);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\superb\SuperSpec$Downer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */