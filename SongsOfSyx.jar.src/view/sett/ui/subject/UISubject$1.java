/*    */ package view.sett.ui.subject;
/*    */ 
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import view.keyboard.KEYS;
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
/*    */ class null
/*    */   extends GuiSection
/*    */ {
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 32 */     if (UISubject.this.a.a == null || UISubject.this.a.a.isRemoved()) {
/* 33 */       (VIEW.s()).panels.remove(UISubject.this.panel);
/*    */       return;
/*    */     } 
/* 36 */     if (UISubject.this.a.a.indu().hType() != UISubject.this.current.type) {
/* 37 */       UISubject.this.activate(UISubject.this.a.a, false);
/*    */       
/*    */       return;
/*    */     } 
/* 41 */     super.render(r, ds);
/*    */     
/* 43 */     if (UISubject.this.a.a != null) {
/* 44 */       SETT.OVERLAY().add((ENTITY)UISubject.this.a.a);
/*    */ 
/*    */       
/* 47 */       if (KEYS.moveDown())
/* 48 */         UISubject.this.a.follow--; 
/* 49 */       if (UISubject.this.a.follow > 0)
/* 50 */         (VIEW.s().getWindow()).centerer.set(UISubject.this.a.a.body().cX(), UISubject.this.a.a.body().cY()); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubject$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */