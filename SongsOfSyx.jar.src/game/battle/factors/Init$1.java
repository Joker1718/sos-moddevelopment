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
/*     */ class null
/*     */   extends DivFactor
/*     */ {
/*     */   null(CharSequence $anonymous0, CharSequence $anonymous1, SPRITE $anonymous2, CharSequence $anonymous3, double $anonymous4) {
/*  80 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4);
/*     */   }
/*     */   
/*     */   public double getD(Div div) {
/*  84 */     if (!div.position().isCoherent())
/*  85 */       return 0.0D; 
/*  86 */     double men = div.men();
/*  87 */     if (men == 0.0D)
/*  88 */       return 0.0D; 
/*  89 */     double d = div.centre().inFormation() / div.men();
/*  90 */     d -= 0.35D;
/*  91 */     d /= 0.65D;
/*  92 */     double w = men / (div.position().width() / div.position().formation().size(div));
/*  93 */     w = CLAMP.d(w / 5.0D, 0.0D, 1.0D);
/*  94 */     return d * w;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void phover(Div div, GBox b) {
/* 100 */     b.textLL(Init.¤¤inPos);
/* 101 */     b.tab(6);
/* 102 */     b.add((SPRITE)GFORMAT.iofkInv(b.text(), div.centre().inFormation(), div.men()));
/* 103 */     b.NL();
/* 104 */     b.textLL(Init.¤¤depth);
/* 105 */     b.tab(6);
/* 106 */     int d = div.position().width() / div.position().formation().size(div);
/* 107 */     if (d == 0)
/* 108 */       d = 1; 
/* 109 */     b.add((SPRITE)GFORMAT.iofkInv(b.text(), (div.men() / d), 5L));
/* 110 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\factors\Init$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */