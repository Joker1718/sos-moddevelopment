/*    */ package view.world.panel;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.BOOLEAN;
/*    */ import util.gui.misc.GButt;
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
/*    */   extends GButt.Checkbox
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 36 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 39 */     selectedToggle();
/* 40 */     toggle.set(selectedIs());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 45 */     selectedSet(toggle.is());
/* 46 */     super.render(r, ds, isActive, isSelected, isHovered);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\panel\IDebugPanelWorld$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */