/*     */ package view.sett.ui.room.construction;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
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
/*     */ class null
/*     */   extends GStat
/*     */ {
/*     */   public void update(GText text) {
/* 111 */     double am = (SETT.ROOMS()).placement.placer.resNeeded(k);
/* 112 */     GFORMAT.i(text, (int)Math.ceil(am));
/* 113 */     if ((SETT.ROOMS()).placement.placer.cost().total() > 0.0D) {
/* 114 */       text.warnify();
/* 115 */       text.add('*');
/* 116 */     } else if ((SETT.ROOMS()).placement.placer.blueprint().constructor().needsIsolation() && s.placement.placer.isolation() < 1.0D) {
/* 117 */       text.warnify();
/* 118 */     } else if ((SETT.ROOMS()).placement.placer.cost().total() < 0.0D) {
/* 119 */       text.color((GCOLOR.T()).IGREAT);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SStats$3$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */