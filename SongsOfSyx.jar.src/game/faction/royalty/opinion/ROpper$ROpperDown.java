/*    */ package game.faction.royalty.opinion;
/*    */ 
/*    */ import game.faction.royalty.Royalty;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ROpperDown
/*    */   extends ROpper
/*    */ {
/*    */   private final double dc;
/*    */   
/*    */   public ROpperDown(String key, CharSequence name, CharSequence desc, SPRITE icon, double to, boolean isMul, double downSpeed) {
/* 74 */     super(key, name, desc, icon, to, isMul);
/* 75 */     this.dc = 1.0D / downSpeed;
/*    */   }
/*    */ 
/*    */   
/*    */   public double increase(Royalty roy) {
/* 80 */     return -this.dc;
/*    */   }
/*    */ 
/*    */   
/*    */   protected double ptarget(Royalty bo) {
/* 85 */     return 0.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\ROpper$ROpperDown.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */