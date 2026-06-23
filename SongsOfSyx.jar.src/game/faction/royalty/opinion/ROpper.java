/*    */ package game.faction.royalty.opinion;
/*    */ 
/*    */ import game.boosting.BSourceInfo;
/*    */ import game.boosting.superb.SuperBoostableObj;
/*    */ import game.boosting.superb.SuperSpec;
/*    */ import game.faction.royalty.Royalty;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ 
/*    */ abstract class ROpper
/*    */   extends SuperSpec.SuperSpecImp<Royalty> {
/*    */   public ROpper(String key, CharSequence name, CharSequence desc, SPRITE icon, double to, boolean isMul) {
/* 12 */     super(ROPINION.BOOST(), key, new BSourceInfo(name, desc, null, icon), desc, to, isMul);
/*    */   }
/*    */ 
/*    */   
/*    */   public double pget(Royalty bo) {
/* 17 */     return this.value.getD(bo) * getModifier((SuperBoostableObj)bo);
/*    */   }
/*    */ 
/*    */   
/*    */   public final double get(Royalty o) {
/* 22 */     return super.get(o);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void update(Royalty bo, double time) {
/* 30 */     double inc = time * increase(bo);
/* 31 */     double t = ptarget(bo);
/* 32 */     double v = this.value.getD(bo);
/* 33 */     v += inc;
/*    */     
/* 35 */     if (inc >= 0.0D) {
/* 36 */       if (v > t)
/* 37 */         v = t; 
/* 38 */     } else if (inc < 0.0D && 
/* 39 */       v < t) {
/* 40 */       v = t;
/*    */     } 
/*    */ 
/*    */     
/* 44 */     this.value.setD(bo, v);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public double increase(Royalty roy) {
/* 50 */     return 0.0D;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void activate(Royalty bo, boolean active) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean activated(Royalty bo) {
/* 60 */     return (get(bo) > 0.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public double secondsRemaining(Royalty bo) {
/* 65 */     return 0.0D;
/*    */   }
/*    */   
/*    */   protected abstract double ptarget(Royalty paramRoyalty);
/*    */   
/*    */   static class ROpperDown extends ROpper {
/*    */     private final double dc;
/*    */     
/*    */     public ROpperDown(String key, CharSequence name, CharSequence desc, SPRITE icon, double to, boolean isMul, double downSpeed) {
/* 74 */       super(key, name, desc, icon, to, isMul);
/* 75 */       this.dc = 1.0D / downSpeed;
/*    */     }
/*    */ 
/*    */     
/*    */     public double increase(Royalty roy) {
/* 80 */       return -this.dc;
/*    */     }
/*    */ 
/*    */     
/*    */     protected double ptarget(Royalty bo) {
/* 85 */       return 0.0D;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\ROpper.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */