/*     */ package view.ui.message;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class IMessage
/*     */   extends Interrupter
/*     */ {
/* 484 */   private final GPanel panel = (new GPanel()).setBig();
/*     */   private Message m;
/*     */   
/* 487 */   private final GButt.ButtPanel show = (new GButt.ButtPanel((UI.FONT()).S.getText(Dic.¤¤Alert))
/*     */     {
/*     */       public void hoverInfoGet(GUI_BOX text)
/*     */       {
/* 491 */         text.text(Messages.¤¤PauseD);
/*     */       }
/*     */ 
/*     */       
/*     */       protected void renAction() {
/* 496 */         selectedSet(!(Messages.IMessage.access$1(Messages.IMessage.this)).hideMap.containsKey(Messages.IMessage.this.m.key));
/*     */       }
/*     */ 
/*     */       
/*     */       protected void clickA() {
/* 501 */         if ((Messages.IMessage.access$1(Messages.IMessage.this)).hideMap.containsKey(Messages.IMessage.this.m.key)) {
/* 502 */           (Messages.IMessage.access$1(Messages.IMessage.this)).hideMap.remove(Messages.IMessage.this.m.key);
/*     */         } else {
/* 504 */           (Messages.IMessage.access$1(Messages.IMessage.this)).hideMap.put(Messages.IMessage.this.m.key, Messages.IMessage.this.m.key);
/*     */         } 
/* 506 */         Messages.IMessage.access$1(Messages.IMessage.this).flush();
/*     */       }
/* 508 */     }).icon((SPRITE)(UI.icons()).s.clock);
/*     */   
/* 510 */   ACTION close = new ACTION()
/*     */     {
/*     */       public void exe() {
/* 513 */         Messages.IMessage.this.hide();
/* 514 */         if (Messages.IMessage.this.m == null)
/*     */           return; 
/* 516 */         if (!Messages.IMessage.this.m.isRead)
/* 517 */           (Messages.IMessage.access$1(Messages.IMessage.this)).unread--; 
/* 518 */         Messages.IMessage.this.m.isRead = true;
/* 519 */         if (!(Messages.IMessage.access$1(Messages.IMessage.this)).queued.isEmpty()) {
/* 520 */           Messages.IMessage.this.act((Message)(Messages.IMessage.access$1(Messages.IMessage.this)).queued.removeLast());
/*     */         }
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   void act(Message m) {
/* 527 */     if (VIEW.b().isActive())
/*     */       return; 
/* 529 */     this.m = m;
/* 530 */     if (m.section == null)
/* 531 */       m.section = m.makeSection(); 
/* 532 */     this.panel.inner().set((BODY_HOLDER)m.section);
/* 533 */     this.panel.inner().setWidth(Math.max(this.panel.inner().width(), 500));
/* 534 */     this.panel.inner().incrH(20.0D);
/* 535 */     this.panel.body().centerIn(C.DIM());
/* 536 */     m.section.body().centerX((RECTANGLE)this.panel.inner());
/* 537 */     m.section.body().moveY1(this.panel.inner().y1());
/* 538 */     this.show.body.moveX2((m.section.body().x2() - 8));
/* 539 */     this.show.body.moveY1((this.panel.inner().y2() + 2));
/* 540 */     this.panel.setCloseAction(this.close);
/* 541 */     if (m.title() != null && m.title().length() > 0) {
/* 542 */       this.panel.setTitle(m.title());
/*     */     } else {
/* 544 */       this.panel.setTitle(Dic.¤¤Clear);
/*     */     } 
/* 546 */     show(Messages.this.manager);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 551 */     this.panel.hover(mCoo);
/* 552 */     if (this.m.section instanceof HOVERABLE)
/* 553 */       ((HOVERABLE)this.m.section).hover(mCoo); 
/* 554 */     this.show.hover(mCoo);
/* 555 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 560 */     if (button == MButt.LEFT) {
/* 561 */       this.panel.click();
/* 562 */       if (this.m.section instanceof CLICKABLE)
/* 563 */         ((CLICKABLE)this.m.section).click(); 
/* 564 */       this.show.click();
/* 565 */     } else if (button == MButt.RIGHT) {
/* 566 */       this.close.exe();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/* 571 */     if (this.panel.hoveredIs())
/* 572 */       this.panel.hoverInfoGet((GUI_BOX)text); 
/* 573 */     if (this.m.section instanceof HOVERABLE)
/* 574 */       ((HOVERABLE)this.m.section).hoverInfoGet((GUI_BOX)text); 
/* 575 */     if (this.show.hoveredIs()) {
/* 576 */       this.show.hoverInfoGet((GUI_BOX)text);
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 581 */     this.panel.render((SPRITE_RENDERER)r, ds);
/* 582 */     this.m.section.render((SPRITE_RENDERER)r, ds);
/* 583 */     this.show.render((SPRITE_RENDERER)r, ds);
/* 584 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 589 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\message\Messages$IMessage.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */