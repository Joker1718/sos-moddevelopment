/*    */ package view.sett.ui.room.construction;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GuiSection;
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
/*    */ class null
/*    */   extends GuiSection
/*    */ {
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 36 */     super.render(r, ds);
/* 37 */     boolean b = !((VIEW.s()).tools.placer.getCurrent() != SShape.this.s.placement.placer.area() && (VIEW.s()).tools.placer.getCurrent() != SShape.this.s.placement.placer.area().getUndo());
/* 38 */     if (b)
/* 39 */       (SETT.ROOMS()).placement.placer.renderExpense(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SShape$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */