/*     */ package view.ui.message;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import view.interrupter.Interrupter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class List
/*     */   extends Interrupter
/*     */ {
/*     */   private final GuiSection section;
/*     */   private boolean removed = false;
/*     */   
/*     */   protected List() {
/* 283 */     GTableBuilder builder = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/* 287 */           return (Messages.List.access$0(Messages.List.this)).all.size();
/*     */         }
/*     */ 
/*     */         
/*     */         public void click(int index) {
/* 292 */           if (Messages.List.this.removed) {
/* 293 */             Messages.List.this.removed = false;
/*     */             return;
/*     */           } 
/* 296 */           Message message = (Message)(Messages.List.access$0(Messages.List.this)).all.get((Messages.List.access$0(Messages.List.this)).all.size() - 1 - index);
/* 297 */           if (message != null) {
/* 298 */             (Messages.List.access$0(Messages.List.this)).imess.act(message);
/*     */           }
/*     */         }
/*     */       };
/* 302 */     builder.column(Messages.¤¤title, 200, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier) {
/* 305 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 309 */                   Message m = (Message)(Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.get((Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.size() - 1 - ((Integer)ier.get()).intValue());
/* 310 */                   if (m == null)
/*     */                     return; 
/* 312 */                   if (m.title().length() >= 20) {
/* 313 */                     text.add(m.title(), 0, 20);
/* 314 */                     text.add('.').add('.').add('.');
/*     */                   } else {
/* 316 */                     text.add(m.title());
/*     */                   } 
/* 318 */                   if (m.isRead) {
/* 319 */                     text.color(COLOR.WHITE65);
/*     */                   } else {
/* 321 */                     text.color(COLOR.WHITE100);
/*     */                   } 
/*     */                 }
/* 324 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */     
/* 328 */     builder.column(Messages.¤¤Arrived, 200, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier) {
/* 331 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 335 */                   Message m = (Message)(Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.get((Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.size() - 1 - ((Integer)ier.get()).intValue());
/* 336 */                   if (m == null)
/*     */                     return; 
/* 338 */                   int t = (int)(TIME.currentSecond() - m.currentSecond);
/* 339 */                   DicTime.setAgo((Str)text, t);
/*     */                   
/* 341 */                   if (m.isRead) {
/* 342 */                     text.color(COLOR.WHITE65);
/*     */                   } else {
/* 344 */                     text.color(COLOR.WHITE100);
/*     */                   } 
/*     */                 }
/* 347 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */     
/* 351 */     builder.column("", 36, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier) {
/* 354 */             return (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).s.cancel)
/*     */               {
/*     */                 protected void clickA() {
/* 357 */                   Message m = (Message)(Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.get((Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.size() - 1 - ((Integer)ier.get()).intValue());
/* 358 */                   if (m == null) {
/*     */                     return;
/*     */                   }
/* 361 */                   Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this)).remove((Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.size() - 1 - ((Integer)ier.get()).intValue());
/* 362 */                   (Messages.List.null.access$0(Messages.List.null.this)).removed = true;
/*     */                 }
/* 364 */               }).hoverInfoSet(Dic.¤¤remove);
/*     */           }
/*     */         });
/*     */     
/* 368 */     builder.column("", 36, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier) {
/* 371 */             return (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).s.clock)
/*     */               {
/*     */                 protected void clickA() {
/* 374 */                   Message m = (Message)(Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.get((Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.size() - 1 - ((Integer)ier.get()).intValue());
/* 375 */                   if (m == null) {
/*     */                     return;
/*     */                   }
/* 378 */                   if ((Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).hideMap.containsKey(m.key)) {
/* 379 */                     (Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).hideMap.remove(m.key);
/*     */                   } else {
/* 381 */                     (Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).hideMap.put(m.key, m.key);
/*     */                   } 
/* 383 */                   Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this)).flush();
/*     */                 }
/*     */ 
/*     */                 
/*     */                 protected void renAction() {
/* 388 */                   Message m = (Message)(Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.get((Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).all.size() - 1 - ((Integer)ier.get()).intValue());
/* 389 */                   selectedSet((m != null && !(Messages.List.access$0(Messages.List.null.access$0(Messages.List.null.this))).hideMap.containsKey(m.key)));
/*     */                 }
/* 392 */               }).hoverInfoSet(Messages.¤¤PauseD);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 397 */     this.section = builder.create(15, true);
/*     */     
/* 399 */     GButt.ButtPanel buttPanel = new GButt.ButtPanel(Messages.¤¤delete)
/*     */       {
/*     */         protected void clickA() {
/* 402 */           for (int i = 0; i < (Messages.List.access$0(Messages.List.this)).all.size(); i++) {
/* 403 */             if (((Message)(Messages.List.access$0(Messages.List.this)).all.get(i)).isRead) {
/* 404 */               (Messages.List.access$0(Messages.List.this)).all.removeOrdered(i);
/* 405 */               i--;
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 412 */           activeSet(((Messages.List.access$0(Messages.List.this)).all.size() - (Messages.List.access$0(Messages.List.this)).unread > 0));
/*     */         }
/*     */       };
/* 415 */     buttPanel.body().centerX((BODY_HOLDER)this.section).moveY1((this.section.body().y2() + 10));
/* 416 */     this.section.add((RENDEROBJ)buttPanel);
/*     */     
/* 418 */     GPanel p = new GPanel();
/* 419 */     p.set((RECTANGLE)this.section.body());
/*     */     
/* 421 */     p.setCloseAction(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 424 */             Messages.List.this.hide();
/*     */           }
/*     */         });
/* 427 */     p.body().centerY(C.DIM());
/* 428 */     p.body().centerX((C.WIDTH() / 2), C.WIDTH());
/* 429 */     this.section.body().centerIn((BODY_HOLDER)p);
/* 430 */     this.section.add((RENDEROBJ)p);
/* 431 */     this.section.moveLastToBack();
/*     */     
/* 433 */     p.setTitle(Messages.¤¤Messages, (UI.FONT()).H2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void act() {
/* 440 */     show(Messages.this.manager);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 445 */     this.section.hover(mCoo);
/* 446 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 451 */     if (button == MButt.LEFT)
/* 452 */       this.section.click(); 
/* 453 */     if (button == MButt.RIGHT) {
/* 454 */       hide();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void hide() {
/* 460 */     super.hide();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/* 465 */     this.section.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 470 */     this.section.render((SPRITE_RENDERER)r, ds);
/* 471 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 477 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\message\Messages$List.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */