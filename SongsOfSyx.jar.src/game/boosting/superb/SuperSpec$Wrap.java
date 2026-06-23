/*     */ package game.boosting.superb;
/*     */ 
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.Booster;
/*     */ import init.type.HCLASS_RACE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Wrap<T extends SuperBoostableObj>
/*     */   extends SuperSpec<T>
/*     */ {
/*     */   private final Booster boo;
/*     */   
/*     */   public Wrap(Booster b, SuperBoostable<T> self, String key, BSourceInfo info, CharSequence desc) {
/* 169 */     super(self, info, desc, b.to(), b.isMul);
/* 170 */     this.boo = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public double get(T o) {
/* 175 */     return this.boo.get(HCLASS_RACE.clP());
/*     */   }
/*     */ 
/*     */   
/*     */   public double pget(T bo) {
/* 180 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double secondsRemaining(T bo) {
/* 185 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double increase(T bo) {
/* 190 */     return 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\superb\SuperSpec$Wrap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */