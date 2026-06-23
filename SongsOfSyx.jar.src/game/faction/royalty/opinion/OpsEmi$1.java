/*    */ package game.faction.royalty.opinion;
/*    */ 
/*    */ import game.faction.FACTIONS;
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
/*    */ class null
/*    */   extends ROpper
/*    */ {
/*    */   null(String $anonymous0, CharSequence $anonymous1, CharSequence $anonymous2, SPRITE $anonymous3, double $anonymous4, boolean $anonymous5) {
/* 49 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4, $anonymous5);
/*    */   }
/*    */   
/*    */   public double increase(Royalty roy) {
/* 53 */     double v = this.value.getD(roy);
/*    */     
/* 55 */     double target = ptarget(roy);
/* 56 */     if (target > v)
/* 57 */       return 1.0D / year * 2.0D; 
/* 58 */     if (target < v) {
/* 59 */       return -1.0D / year * 0.5D;
/*    */     }
/* 61 */     return 0.0D;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected double ptarget(Royalty bo) {
/* 70 */     return OpsEmi.this.vv(bo, (FACTIONS.player()).emissaries.flatter, this, (FACTIONS.player()).emissaries.penaltyMul());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\OpsEmi$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */