/*    */ package view.sett.ui.subject;
/*    */ 
/*    */ import init.type.HTYPE;
/*    */ import init.type.HTYPES;
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import view.interrupter.ISidePanel;
/*    */ import view.keyboard.KEYS;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ public final class UISubject {
/* 17 */   private final UISubjectType[] all = new UISubjectType[HTYPES.ALL().size()];
/*    */   private UISubjectType current;
/* 19 */   private AInfo a = new AInfo();
/* 20 */   private final Str title = new Str(24);
/*    */   
/*    */   private final ISidePanel panel;
/*    */   
/*    */   UISubject() {
/* 25 */     for (HTYPE t : HTYPES.ALL()) {
/* 26 */       this.all[t.index()] = new UISubjectType(this.a, t);
/*    */     }
/*    */     
/* 29 */     GuiSection section = new GuiSection()
/*    */       {
/*    */         public void render(SPRITE_RENDERER r, float ds) {
/* 32 */           if (UISubject.this.a.a == null || UISubject.this.a.a.isRemoved()) {
/* 33 */             (VIEW.s()).panels.remove(UISubject.this.panel);
/*    */             return;
/*    */           } 
/* 36 */           if (UISubject.this.a.a.indu().hType() != UISubject.this.current.type) {
/* 37 */             UISubject.this.activate(UISubject.this.a.a, false);
/*    */             
/*    */             return;
/*    */           } 
/* 41 */           super.render(r, ds);
/*    */           
/* 43 */           if (UISubject.this.a.a != null) {
/* 44 */             SETT.OVERLAY().add((ENTITY)UISubject.this.a.a);
/*    */ 
/*    */             
/* 47 */             if (KEYS.moveDown())
/* 48 */               UISubject.this.a.follow--; 
/* 49 */             if (UISubject.this.a.follow > 0) {
/* 50 */               (VIEW.s().getWindow()).centerer.set(UISubject.this.a.a.body().cX(), UISubject.this.a.a.body().cY());
/*    */             }
/*    */           } 
/*    */         }
/*    */       };
/* 55 */     this.panel = new ISidePanel(section);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void activate(Humanoid a, boolean disturb) {
/* 66 */     this.a.a = a;
/* 67 */     this.current = this.all[a.indu().hType().index()];
/* 68 */     this.panel.section().clear();
/* 69 */     this.panel.section().add((RENDEROBJ)this.current);
/* 70 */     this.a.follow = 20;
/*    */     
/* 72 */     this.title.clear();
/* 73 */     this.title.add((a.race()).info.namePosessive).add(' ').add((a.indu().hType()).name);
/* 74 */     this.panel.titleSet((CharSequence)this.title);
/* 75 */     (VIEW.s()).panels.add(this.panel, disturb);
/* 76 */     (VIEW.s().getWindow()).centerer.set(a.body().cX(), a.body().cY());
/*    */   }
/*    */   
/*    */   public Humanoid showing() {
/* 80 */     if ((VIEW.s()).panels.added(this.panel))
/* 81 */       return this.a.a; 
/* 82 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubject.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */