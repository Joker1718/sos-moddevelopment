/*    */ package view.tool;
/*    */ 
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
/*    */ import view.keyboard.KEYS;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends GButt.Panel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 45 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 50 */     if (ToolPlacer.this.placer != ToolPlacer.this.undo) {
/* 51 */       ToolPlacer.this.placer = ToolPlacer.this.undo;
/* 52 */       ToolPlacer.this.current = ToolPlacer.this.get(ToolPlacer.this.placer);
/* 53 */       ToolPlacer.this.current.activate(ToolPlacer.this.placer, ToolPlacer.this.window);
/* 54 */       selectedSet(true);
/*    */     } else {
/* 56 */       ToolPlacer.this.placer = ToolPlacer.this.origional;
/* 57 */       ToolPlacer.this.current = ToolPlacer.this.get(ToolPlacer.this.placer);
/* 58 */       ToolPlacer.this.current.activate(ToolPlacer.this.placer, ToolPlacer.this.window);
/* 59 */       selectedSet(true);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 65 */     if (ToolPlacer.this.placer == ToolPlacer.this.undo) {
/* 66 */       selectTmp();
/*    */     }
/*    */   }
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 71 */     text.text(ToolPlacer.this.undo.name());
/* 72 */     text.text((KEYS.MAIN()).UNDO.repr());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\ToolPlacer$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */