/*    */ package view.keyboard;
/*    */ 
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
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
/*    */ class null
/*    */   extends CLICKABLE.ClickWrap
/*    */ {
/*    */   null(RENDEROBJ $anonymous0) {
/* 23 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 27 */     text.title(key.name);
/* 28 */     text.text(key.desc);
/* 29 */     text.NL(4);
/* 30 */     super.hoverInfoGet(text);
/* 31 */     text.NL(8);
/* 32 */     key.setMapping(text);
/* 33 */     text.NL(2);
/* 34 */     if (key.rebindable) {
/* 35 */       text.text(KeyButt.¤¤assign);
/* 36 */       text.text((KEYS.MAIN()).ASSIGN_HOTKEY.repr());
/*    */     } 
/* 38 */     text.NL(8);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean hover(COORDINATE mCoo) {
/* 44 */     if (super.hover(mCoo)) {
/* 45 */       if (key.rebindable)
/* 46 */         (KEYS.get()).toChange = key; 
/* 47 */       return true;
/*    */     } 
/* 49 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected RENDEROBJ pget() {
/* 54 */     return (RENDEROBJ)base;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\keyboard\KeyButt$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */