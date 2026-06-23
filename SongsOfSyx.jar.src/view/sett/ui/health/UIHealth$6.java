/*     */ package view.sett.ui.health;
/*     */ 
/*     */ import game.boosting.Boostable;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.DicTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GStaples
/*     */ {
/*     */   null(int $anonymous0) {
/* 161 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected double getValue(int stapleI) {
/* 165 */     int i = 32 - stapleI - 1;
/* 166 */     return (STATS.DISEASE()).healthHistory.getD(i);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, int stapleI) {
/* 171 */     int i = 32 - stapleI - 1;
/* 172 */     box.title(bo.name);
/* 173 */     GText t = box.text();
/* 174 */     DicTime.setDaysAgo((Str)t, i);
/* 175 */     box.add((SPRITE)t);
/* 176 */     box.tab(6);
/* 177 */     box.add((SPRITE)GFORMAT.perc(box.text(), (STATS.DISEASE()).healthHistory.getD(i)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setColor(ColorImp c, int stapleI, double value) {
/* 184 */     if (value < 0.5D) {
/* 185 */       c.interpolate((GCOLOR.UI()).SOSO.normal, (GCOLOR.UI()).BAD.normal, 1.0D - value * 2.0D);
/*     */     } else {
/* 187 */       c.interpolate((GCOLOR.UI()).SOSO.normal, (GCOLOR.UI()).GOOD.normal, (value - 0.5D) * 2.0D);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\health\UIHealth$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */