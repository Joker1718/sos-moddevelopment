/*     */ package view.ui.profile;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.gui.misc.GButt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(CharSequence $anonymous0) {
/*  95 */     super($anonymous0);
/*     */   }
/*     */   protected void clickA() {
/*  98 */     UILevel.this.switcher.set((RENDEROBJ)UILevel.this.titles);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 103 */     selectedSet((UILevel.this.switcher.current() == UILevel.this.titles));
/* 104 */     if (!selectedIs() && !hoveredIs() && (FACTIONS.player()).titles.hasNew()) {
/* 105 */       bg(COLOR.WHITE202WHITE100);
/*     */     } else {
/* 107 */       bgClear();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\profile\UILevel$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */