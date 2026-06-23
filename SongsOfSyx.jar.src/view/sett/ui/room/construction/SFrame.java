/*     */ package view.sett.ui.room.construction;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class SFrame {
/*  20 */   private int width = 470;
/*     */   private final State state;
/*  22 */   private final GPanel panel = new GPanel();
/*  23 */   private GuiSection section = new GuiSection();
/*  24 */   private final Str title = new Str(50); private CharSequence sconstruction; private CharSequence sexpensive;
/*  25 */   private final GuiSection bottomButtons = new GuiSection(); private boolean message;
/*     */   SFrame(State state) {
/*  27 */     D.gInit(this);
/*     */     
/*  29 */     this.sconstruction = D.g("{0} construction");
/*  30 */     this.sexpensive = D.g("expensive", "The layout of the room will make it more expensive to construct and maintain. The yellow squares denote where support for the room is weak and will need extra materials. To increase support, remove some of the room in this area, so that it can be used to build supportive walls. Proceed anyway?");
/*  31 */     this.message = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  46 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/*  49 */           (UI.PANEL()).butt.render(r, (RECTANGLE)body(), 0);
/*  50 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */     
/*  54 */     s.addRightC(0, (RENDEROBJ)new GButt.Panel((SPRITE)(SPRITES.icons()).m.trash, D.g("removeRoom", "remove room"))
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  58 */             SFrame.this.state.config.build = false;
/*  59 */             (VIEW.s()).tools.placer.deactivate();
/*     */           }
/*     */         });
/*     */     
/*  63 */     s.addRightC(32, (RENDEROBJ)new GButt.Panel((SPRITE)(SPRITES.icons()).m.arrow_left, D.g("undo"))
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  67 */             (SETT.ROOMS()).placement.placer.popHistory();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/*  72 */             activeSet((SETT.ROOMS()).placement.placer.hasHistory());
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  77 */     final ACTION create = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/*  81 */           (SETT.ROOMS()).placement.placer.create();
/*     */ 
/*     */           
/*  84 */           (VIEW.s()).tools.placer.deactivate();
/*     */         }
/*     */       };
/*     */     
/*  88 */     final CharSequence cc = D.g("construct!");
/*     */     
/*  90 */     s.addRightC(0, (RENDEROBJ)new GButt.Panel((SPRITE)(SPRITES.icons()).m.ok)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  94 */             CharSequence s = (SETT.ROOMS()).placement.placer.createProblem();
/*  95 */             if (s != null) {
/*  96 */               if ((SETT.ROOMS()).placement.placer.createProblemItem() != null) {
/*  97 */                 SFrame.this.state.problemGroup = (SETT.ROOMS()).placement.placer.createProblemItem();
/*  98 */                 SFrame.this.state.problemTimer = VIEW.renderSecond() + 4.0D;
/*  99 */               }  if ((SETT.ROOMS()).placement.placer.createProblemWalls()) {
/* 100 */                 SFrame.this.state.problemTimer = VIEW.renderSecond() + 4.0D;
/* 101 */                 SFrame.this.state.problemneedDoor = true;
/*     */               } 
/*     */             } else {
/* 104 */               CharSequence warn = (SETT.ROOMS()).placement.placer.createWarning();
/* 105 */               if (warn != null) {
/* 106 */                 (VIEW.inters()).yesNo.activate(warn, create, ACTION.NOP, true);
/*     */               }
/* 108 */               else if (!SFrame.this.message && SFrame.this.state.b.constructor().mustBeIndoors() && SFrame.this.state.placement.placer.cost().support() > 0.0D) {
/* 109 */                 SFrame.this.message = true;
/* 110 */                 (VIEW.inters()).yesNo.activate(SFrame.this.sexpensive, create, ACTION.NOP, true);
/*     */               } else {
/*     */                 
/* 113 */                 create.exe();
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 121 */             text.title(cc);
/* 122 */             CharSequence s = (SETT.ROOMS()).placement.placer.createProblem();
/* 123 */             if (s != null) {
/* 124 */               GBox b = (GBox)text;
/* 125 */               b.error(s);
/*     */             } 
/* 127 */             super.hoverInfoGet(text);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 132 */     this.bottomButtons.add((RENDEROBJ)s);
/*     */     this.state = state;
/*     */   }
/*     */   GuiSection get(GuiSection s) {
/* 136 */     this.section.clear();
/* 137 */     if (this.state.collection != null) {
/* 138 */       this.title.clear().add(this.state.collection.name());
/*     */     } else {
/* 140 */       this.title.clear().add(this.sconstruction).insert(0, this.state.b.info.name);
/* 141 */     }  this.title.toUpper();
/*     */ 
/*     */     
/* 144 */     if (s.body().width() < this.width)
/* 145 */       s.pad((this.width - s.body().width()) / 2, 0); 
/* 146 */     this.panel.inner().set((BODY_HOLDER)s);
/* 147 */     this.panel.setTitle((CharSequence)this.title);
/* 148 */     this.section.add((RENDEROBJ)this.panel);
/* 149 */     s.body().centerIn((RECTANGLE)this.panel.inner());
/* 150 */     this.section.add((RENDEROBJ)s);
/*     */     
/* 152 */     if (this.state.b.constructor().usesArea()) {
/* 153 */       this.bottomButtons.body().moveX2((this.section.body().x2() - 60));
/* 154 */       this.bottomButtons.body().moveCY(this.section.body().y2());
/* 155 */       this.section.add((RENDEROBJ)this.bottomButtons);
/*     */     } 
/*     */ 
/*     */     
/* 159 */     return this.section;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SFrame.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */