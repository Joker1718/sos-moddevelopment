/*    */ package view.sett.ui.subject;
/*    */ 
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GuiSection;
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
/* 80 */     UISubjectsList.this.li.sort();
/* 81 */     if (UISubjectsList.this.current != null && UISubjectsList.this.current instanceof Humanoid) {
/* 82 */       Humanoid a = (Humanoid)UISubjectsList.this.current;
/* 83 */       (VIEW.s().getWindow()).centerer.set(a.body().cX(), a.body().cY());
/* 84 */       SETT.OVERLAY().add((ENTITY)a);
/*    */     } 
/* 86 */     super.render(r, ds);
/* 87 */     if (UISubjectsList.this.selected != -1) {
/* 88 */       UISubjectsList.this.current = UISubjectsList.this.li.li.get(UISubjectsList.this.selected);
/*    */     } else {
/* 90 */       UISubjectsList.this.current = null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectsList$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */