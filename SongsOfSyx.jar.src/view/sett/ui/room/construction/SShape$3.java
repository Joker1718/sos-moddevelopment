/*    */ package view.sett.ui.room.construction;
/*    */ 
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
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
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 64 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 68 */     SShape.this.s.placement.placer.buildOnWalls.set(true);
/* 69 */     (VIEW.s()).tools.place(SShape.this.s.placement.placer.area(), SShape.this.s.config);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 74 */     selectedSet(((VIEW.s()).tools.placer.getCurrent() == SShape.this.s.placement.placer.area() && SShape.this.s.placement.placer.buildOnWalls.is()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SShape$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */