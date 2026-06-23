/*     */ package game.boosting.superb;
/*     */ 
/*     */ import game.boosting.BSourceInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Permanent<T extends SuperBoostableObj>
/*     */   extends SuperSpec.SuperSpecImp<T>
/*     */ {
/*     */   public Permanent(SuperBoostable<T> self, String key, BSourceInfo info, CharSequence desc, double to, boolean isMul) {
/* 129 */     super(self, key, info, desc, to, isMul);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(T bo, double time) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void activate(T bo, boolean active) {
/* 139 */     this.value.setD(bo, (active ? true : false));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean activated(T bo) {
/* 144 */     return (this.value.getD(bo) > 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public double secondsRemaining(T bo) {
/* 149 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double increase(T bo) {
/* 154 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double pget(T bo) {
/* 159 */     return this.value.getD(bo);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\superb\SuperSpec$Permanent.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */