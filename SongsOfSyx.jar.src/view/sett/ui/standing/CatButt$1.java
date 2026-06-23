/*    */ package view.sett.ui.standing;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import util.gui.misc.GHeader;
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
/*    */   extends GHeader
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 54 */     super($anonymous0);
/*    */   }
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 57 */     OPACITY.O50.bind();
/* 58 */     COLOR.BLACK.render(r, (RECTANGLE)this.body, 2);
/* 59 */     OPACITY.unbind();
/* 60 */     super.render(r, ds, isHovered);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatButt$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */