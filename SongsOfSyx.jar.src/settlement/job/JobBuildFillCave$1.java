/*    */ package settlement.job;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import view.main.VIEW;
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
/*    */   null(Job $anonymous0, RESOURCE $anonymous1, int $anonymous2, CharSequence $anonymous3) {
/* 43 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/* 44 */     this.jobs = "Jobs: ";
/*    */   }
/*    */   public void placeInfo(GBox b, int okTiles, AREA a) {
/* 47 */     super.placeInfo(b, okTiles, a);
/* 48 */     if (okTiles > 0) {
/* 49 */       VIEW.hoverBox().add((SPRITE)VIEW.hoverBox().text().add("Jobs: ").add(okTiles));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public LIST<CLICKABLE> getAdditionalButt() {
/* 55 */     return (LIST<CLICKABLE>)(SETT.JOBS()).clearss.butts;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobBuildFillCave$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */