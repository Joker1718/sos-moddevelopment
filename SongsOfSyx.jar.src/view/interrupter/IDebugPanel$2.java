/*    */ package view.interrupter;
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
/*    */ class null
/*    */   extends GButt.Checkbox
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 32 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 35 */     selectedToggle();
/* 36 */     toggle.set(selectedIs());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 41 */     selectedSet(toggle.is());
/* 42 */     super.render(r, ds, isActive, isSelected, isHovered);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\IDebugPanel$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */