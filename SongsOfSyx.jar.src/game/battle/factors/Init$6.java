/*     */ package game.battle.factors;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 218 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4);
/*     */   }
/*     */   
/*     */   public double getD(Div div) {
/* 222 */     if (div.army().men() == 0)
/* 223 */       return 1.0D; 
/* 224 */     if (div.men() == 0) {
/* 225 */       return 1.0D;
/*     */     }
/* 227 */     double a = ff.routing.army.getD(div.army());
/* 228 */     a /= a + div.army().men();
/*     */     
/* 230 */     double d = ff.routing.getD(div);
/* 231 */     d = 2.0D * d / (d + div.men());
/*     */     
/* 233 */     return CLAMP.d(1.0D - a * d, 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void phover(Div div, GBox b) {
/* 239 */     b.textLL(Init.¤¤inUnit);
/* 240 */     b.tab(6);
/* 241 */     b.add((SPRITE)GFORMAT.i(b.text(), (int)ff.routing.getD(div)));
/* 242 */     b.NL();
/* 243 */     b.textLL(Init.¤¤inArmy);
/* 244 */     b.tab(6);
/* 245 */     b.add((SPRITE)GFORMAT.i(b.text(), (int)ff.routing.army.getD(div.army())));
/* 246 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\factors\Init$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */