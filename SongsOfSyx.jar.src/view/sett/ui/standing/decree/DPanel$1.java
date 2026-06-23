/*    */ package view.sett.ui.standing.decree;
/*    */ 
/*    */ import init.type.HCLASS;
/*    */ import init.type.HCLASSES;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import util.data.GETTER;
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
/* 53 */     if (cl == HCLASSES.CITIZEN() && race.get() == null) {
/* 54 */       (VIEW.s()).panels.remove(DPanel.this);
/*    */       return;
/*    */     } 
/* 57 */     super.render(r, ds);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\decree\DPanel$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */