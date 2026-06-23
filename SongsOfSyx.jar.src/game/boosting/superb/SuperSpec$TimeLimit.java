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
/*     */ public class TimeLimit<T extends SuperBoostableObj>
/*     */   extends SuperSpec.SuperSpecImp<T>
/*     */ {
/*     */   private final double seconds;
/*     */   
/*     */   public TimeLimit(double days, SuperBoostable<T> self, String key, BSourceInfo info, CharSequence desc, double to, boolean isMul) {
/* 200 */     super(self, key, info, desc, to, isMul);
/* 201 */     this.seconds = days * TIME.secondsPerDay();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(T bo, double time) {
/* 207 */     if (this.time.getD(bo) > 0.0D) {
/* 208 */       this.time.incD(bo, -time);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public double pget(T bo) {
/* 214 */     if (this.time.getD(bo) > 0.0D)
/* 215 */       return 1.0D; 
/* 216 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void activate(T bo, boolean active) {
/* 221 */     this.time.setD(bo, active ? this.seconds : 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean activated(T bo) {
/* 226 */     return (this.time.getD(bo) > 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public double secondsRemaining(T bo) {
/* 231 */     return this.time.getD(bo);
/*     */   }
/*     */ 
/*     */   
/*     */   public double increase(T bo) {
/* 236 */     return 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\superb\SuperSpec$TimeLimit.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */