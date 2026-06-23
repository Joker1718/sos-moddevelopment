/*     */ package game.battle;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import settlement.entity.EntityIterator;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends EntityIterator.Humans
/*     */ {
/*     */   protected boolean processAndShouldBreakH(Humanoid h, int ie) {
/* 118 */     for (int i = 0; i < d.menNrOf(); i++) {
/* 119 */       check.set(i, d.index(), false);
/*     */     }
/*     */     
/* 122 */     if (h.division() == d) {
/* 123 */       if (h.divSpot() != d.reporter.positionSpot(h)) {
/* 124 */         LOG.ln("" + h.divSpot() + " -> " + h.divSpot());
/*     */       }
/*     */ 
/*     */       
/* 128 */       check.set((h.division()).reporter.positionSpot(h), h.division().index(), true);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 133 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\Armies$2$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */