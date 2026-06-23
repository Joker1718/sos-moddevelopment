/*    */ package view.sett.ui.room.prints;
/*    */ 
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import view.main.VIEW;
/*    */ import view.tool.ToolConfig;
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
/*    */   implements ToolConfig
/*    */ {
/*    */   public void addUI(LISTE<RENDEROBJ> uis) {}
/*    */   
/*    */   public void activateAction() {}
/*    */   
/*    */   public void update(boolean UIHovered) {
/* 43 */     if (!(VIEW.s()).panels.added(PlacerSave.this.pp)) {
/* 44 */       (VIEW.s()).tools.place(null, null, false);
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean back() {
/* 49 */     if (PlacerSave.this.pp.placing != null) {
/* 50 */       PlacerSave.this.pp.placing = null;
/* 51 */       return false;
/*    */     } 
/* 53 */     (VIEW.s()).panels.remove(PlacerSave.this.pp);
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\prints\PlacerSave$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */