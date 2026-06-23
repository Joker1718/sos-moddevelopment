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
/*     */ class null
/*     */   extends DivFactor
/*     */ {
/*     */   null(CharSequence $anonymous0, CharSequence $anonymous1, SPRITE $anonymous2, CharSequence $anonymous3, double $anonymous4) {
/* 184 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4);
/*     */   }
/*     */ 
/*     */   
/*     */   public double getD(Div div) {
/* 189 */     if (div.army().men() == 0)
/* 190 */       return 1.0D; 
/* 191 */     if (div.men() == 0) {
/* 192 */       return 1.0D;
/*     */     }
/* 194 */     double a = ff.casulties.army.getD(div.army());
/* 195 */     a /= a + div.army().men();
/*     */     
/* 197 */     double d = ff.casulties.getD(div);
/* 198 */     d = 2.0D * d / (d + div.men());
/*     */     
/* 200 */     return CLAMP.d(1.0D - 0.5D * a - d, 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void phover(Div div, GBox b) {
/* 206 */     b.textLL(Init.¤¤inUnit);
/* 207 */     b.tab(6);
/* 208 */     b.add((SPRITE)GFORMAT.i(b.text(), (int)ff.casulties.getD(div)));
/* 209 */     b.NL();
/* 210 */     b.textLL(Init.¤¤inArmy);
/* 211 */     b.tab(6);
/* 212 */     b.add((SPRITE)GFORMAT.i(b.text(), (int)ff.casulties.army.getD(div.army())));
/* 213 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\factors\Init$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */