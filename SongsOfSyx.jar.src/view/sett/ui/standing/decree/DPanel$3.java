/*     */ package view.sett.ui.standing.decree;
/*     */ 
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.muls.StatsMultipliers;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GSliderInt
/*     */ {
/*     */   null(INT.INTE $anonymous0, int $anonymous1, boolean $anonymous2) {
/* 114 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */   }
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 117 */     GBox b = (GBox)text;
/* 118 */     GText t = b.text();
/* 119 */     if (dec == (STATS.MULTIPLIERS()).EMANCIPATE || dec == (STATS.MULTIPLIERS()).PROSECUTION) {
/* 120 */       t.add(DPanel.¤¤AutoAm).insert(0, ee.get());
/*     */     } else {
/* 122 */       t.add(DPanel.¤¤AutoPer).insert(0, ee.get());
/* 123 */     }  b.add((SPRITE)t);
/* 124 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\decree\DPanel$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */