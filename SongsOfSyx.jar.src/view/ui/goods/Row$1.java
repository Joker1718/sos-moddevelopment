/*    */ package view.ui.goods;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.Dic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   null(int $anonymous0) {
/* 56 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 60 */     SPRITE s = (Row.this.res.get() == null) ? (SPRITES.icons()).m.urn.big : (SPRITE)((RESOURCE)Row.this.res.get()).icon();
/* 61 */     s.render(r, (RECTANGLE)this.body);
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 66 */     if (Row.this.res.get() != null) {
/* 67 */       ((RESOURCE)Row.this.res.get()).hoverDetailed(text);
/*    */     } else {
/* 69 */       text.title(Dic.¤¤Total);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\goods\Row$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */