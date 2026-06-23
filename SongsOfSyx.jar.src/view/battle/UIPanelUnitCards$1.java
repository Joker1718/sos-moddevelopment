/*    */ package view.battle;
/*    */ 
/*    */ import snake2d.MButt;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GuiSection;
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
/*    */   extends GuiSection
/*    */ {
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 45 */     UIPanelUnitCards.this.init();
/* 46 */     super.render(r, ds);
/* 47 */     if (!MButt.LEFT.isDown())
/* 48 */       UIPanelUnitCards.this.dragging = false; 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\UIPanelUnitCards$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */