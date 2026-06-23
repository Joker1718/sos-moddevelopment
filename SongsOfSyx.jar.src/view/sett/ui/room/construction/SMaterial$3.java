/*    */ package view.sett.ui.room.construction;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
/*    */ import view.main.VIEW;
/*    */ import view.tool.PLACABLE;
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
/* 56 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 59 */     if (SMaterial.this.s.placement.placer.autoWalls.is()) {
/* 60 */       (VIEW.s()).tools.place((PLACABLE)SMaterial.this.s.placement.placer.placerDoor, SMaterial.this.s.config);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 66 */     activeSet(SMaterial.this.s.placement.placer.autoWalls.is());
/* 67 */     selectedSet(((VIEW.s()).tools.placer.getCurrent() == SMaterial.this.s.placement.placer.placerDoor));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 72 */     super.render(r, ds, isActive, isSelected, isHovered);
/* 73 */     if (SMaterial.this.s.problemneedDoor && SMaterial.this.s.problemTimer > VIEW.renderSecond()) {
/* 74 */       COLOR.RED100.renderFrame(r, (RECTANGLE)this.body, 2, 3);
/* 75 */       OPACITY.O25To50.bind();
/* 76 */       COLOR.RED100.render(r, (RECTANGLE)this.body);
/* 77 */       OPACITY.unbind();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SMaterial$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */