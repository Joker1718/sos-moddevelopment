/*    */ package settlement.job;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import view.main.VIEW;
/*    */ import view.subview.GameWindow;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends Placer
/*    */ {
/*    */   private final String jobs = "Jobs: ";
/*    */   
/*    */   null(Job $anonymous0, CharSequence $anonymous1) {
/* 36 */     super($anonymous0, $anonymous1);
/* 37 */     this.jobs = "Jobs: ";
/*    */   }
/*    */   public void placeInfo(GBox b, int okTiles, AREA a) {
/* 40 */     super.placeInfo(b, okTiles, a);
/* 41 */     if (okTiles > 0) {
/* 42 */       VIEW.hoverBox().add((SPRITE)VIEW.hoverBox().text().add("Jobs: ").add(okTiles));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public LIST<CLICKABLE> getAdditionalButt() {
/* 48 */     return (LIST<CLICKABLE>)(SETT.JOBS()).clearss.butts;
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateRegardless(GameWindow window, AREA selected) {
/* 53 */     (SETT.JOBS()).clearss.currentOverlay = JobClear.this.overlay();
/* 54 */     if (JobClear.this.overlay() != null && (SETT.JOBS()).clearss.overlay)
/* 55 */       JobClear.this.overlay().add(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobClear$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */