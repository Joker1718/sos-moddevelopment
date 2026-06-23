/*    */ package view.ui.diplomacy;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends HOVERABLE.HoverableAbs
/*    */ {
/*    */   null(int $anonymous0, int $anonymous1) {
/* 73 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 78 */     o.body().moveX1Y1((RECTANGLE)this.body);
/* 79 */     o.body().moveCY(this.body.cY());
/* 80 */     o.render(r, ds);
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 85 */     if (o instanceof HOVERABLE)
/* 86 */       ((HOVERABLE)o).hoverInfoGet(text); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\diplomacy\UIDealListSaved$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */