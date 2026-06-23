/*     */ package view.sett.ui.home;
/*     */ 
/*     */ import init.type.HGROUP;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.table.GTableBuilder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GTableBuilder
/*     */ {
/*     */   public int nrOFEntries() {
/* 105 */     return HGROUP.all().size();
/*     */   }
/*     */   
/*     */   private void hover(GBox box, HGROUP h, UIHomesTable.Data d) {
/* 109 */     box.textL(d.name);
/* 110 */     box.tab(5);
/* 111 */     box.add((SPRITE)d.format(box.text(), h));
/* 112 */     box.NL();
/* 113 */     box.text(d.desc);
/* 114 */     box.NL(4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfo(int index, GBox box) {
/* 119 */     HGROUP h = (HGROUP)HGROUP.all().get(index);
/* 120 */     box.title(h.name);
/*     */     
/* 122 */     hover(box, h, homeless);
/* 123 */     hover(box, h, housed);
/* 124 */     hover(box, h, available);
/* 125 */     hover(box, h, total);
/* 126 */     hover(box, h, furnishing);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean activeIs(int index) {
/* 132 */     HGROUP h = (HGROUP)HGROUP.all().get(index);
/* 133 */     return ((STATS.POP()).POP.data(h.type).get(h.race) > 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\home\UIHomesTable$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */