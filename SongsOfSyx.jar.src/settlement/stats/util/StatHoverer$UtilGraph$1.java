/*     */ package settlement.stats.util;
/*     */ 
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.table.GStaples;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 258 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, int stapleI) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected double getValue(int stapleI) {
/* 268 */     int fromZero = 32 - stapleI - 1;
/* 269 */     if (!StatHoverer.UtilGraph.this.valuev && StatHoverer.UtilGraph.this.global instanceof STAT) {
/*     */       
/* 271 */       STAT s = (STAT)StatHoverer.UtilGraph.this.global;
/* 272 */       double m = s.standing.max(StatHoverer.UtilGraph.this.c, StatHoverer.UtilGraph.this.race);
/* 273 */       if (m <= 0.0D)
/* 274 */         return 0.0D; 
/* 275 */       if (s.standing().max(StatHoverer.UtilGraph.this.c, StatHoverer.UtilGraph.this.race, fromZero) > 0.0D) {
/* 276 */         return s.standing().get(StatHoverer.UtilGraph.this.c, StatHoverer.UtilGraph.this.race, StatHoverer.UtilGraph.this.global.data(StatHoverer.UtilGraph.this.c).getD(StatHoverer.UtilGraph.this.race, fromZero)) / m;
/*     */       }
/*     */     } 
/*     */     
/* 280 */     return StatHoverer.UtilGraph.this.global.data(StatHoverer.UtilGraph.this.c).getD(StatHoverer.UtilGraph.this.race, fromZero);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setColor(ColorImp col, int stapleI, double value) {
/* 285 */     int fromZero = 32 - stapleI - 1;
/*     */     
/* 287 */     if (!StatHoverer.UtilGraph.this.valuev && StatHoverer.UtilGraph.this.global instanceof STAT) {
/* 288 */       STAT s = (STAT)StatHoverer.UtilGraph.this.global;
/* 289 */       if (s.standing().max(StatHoverer.UtilGraph.this.c, StatHoverer.UtilGraph.this.race, fromZero) > 0.0D) {
/* 290 */         col.set((GCOLOR.UI()).NEUTRAL.normal);
/*     */         return;
/*     */       } 
/*     */     } 
/* 294 */     col.set(COLOR.WHITE65);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setColorBg(ColorImp col, int stapleI, double value) {
/* 300 */     col.set(COLOR.WHITE05);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stat\\util\StatHoverer$UtilGraph$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */