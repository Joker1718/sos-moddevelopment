/*     */ package game.battle.factors;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends DivFactor
/*     */ {
/*     */   null(CharSequence $anonymous0, CharSequence $anonymous1, SPRITE $anonymous2, CharSequence $anonymous3, double $anonymous4) {
/* 116 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4);
/*     */   }
/*     */   
/*     */   public double getD(Div div) {
/* 120 */     return 1.0D - (STATS.NEEDS()).EXHASTION.div().getD(div);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void phover(Div div, GBox b) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected double induValue(Induvidual indu) {
/* 130 */     return 1.0D - (STATS.NEEDS()).EXHASTION.indu().getD(indu);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\factors\Init$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */