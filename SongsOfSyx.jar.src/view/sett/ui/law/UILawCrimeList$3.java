/*     */ package view.sett.ui.law;
/*     */ 
/*     */ import init.type.CRIMES;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.law.StatsLaw;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GStat
/*     */ {
/*     */   public void update(GText text) {
/* 121 */     GFORMAT.percInc(text, (UILawCrimeList.this.sel.getRace() == null) ? STATS.LAW().tyrrany(cl, UILawCrimeList.this.sel.getRace()) : target(), 0);
/* 122 */     text.errorify();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GBox b) {
/* 127 */     b.title(UILawCrimeList.¤¤tyranny);
/* 128 */     b.text(StatsLaw.¤¤tyrannyD);
/* 129 */     b.NL(8);
/*     */     
/* 131 */     if (UILawCrimeList.this.sel.getRace() == null) {
/*     */       return;
/*     */     }
/* 134 */     b.textLL(Dic.¤¤Current);
/* 135 */     b.tab(6);
/* 136 */     b.add((SPRITE)GFORMAT.percInv(b.text(), STATS.LAW().tyrrany(cl, UILawCrimeList.this.sel.getRace())));
/* 137 */     b.NL();
/* 138 */     b.textLL(Dic.¤¤Target);
/* 139 */     b.tab(6);
/* 140 */     b.add((SPRITE)GFORMAT.percInv(b.text(), target()));
/* 141 */     b.NL();
/*     */   }
/*     */   
/*     */   private double target() {
/* 145 */     double t = 0.0D;
/* 146 */     for (CRIMES.CRIME c : CRIMES.all(cl)) {
/* 147 */       t += c.tyrrany(cl, UILawCrimeList.this.sel.getRace(), (c.stat().punishment(cl, UILawCrimeList.this.sel.getRace())).punish);
/*     */     }
/* 149 */     return t;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\law\UILawCrimeList$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */