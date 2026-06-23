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
/* 75 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4, $anonymous5);
/*    */   }
/*    */   
/*    */   public double increase(Royalty roy) {
/* 79 */     double v = this.value.getD(roy);
/*    */     
/* 81 */     double target = ptarget(roy);
/* 82 */     if (target > v) {
/* 83 */       return 1.0D / year * 2.0D;
/*    */     }
/* 85 */     if (target < v) {
/* 86 */       return -1.0D / year * 0.5D;
/*    */     }
/* 88 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   protected double ptarget(Royalty bo) {
/* 93 */     return OpsEmi.this.vv(bo, (FACTIONS.player()).emissaries.sabotage, this, (FACTIONS.player()).emissaries.penaltyMul());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\OpsEmi$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */