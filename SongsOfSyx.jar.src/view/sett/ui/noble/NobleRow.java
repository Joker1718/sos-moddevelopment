/*     */ package view.sett.ui.noble;
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.nobility.Noble;
/*     */ import game.nobility.NobleOffice;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ class NobleRow extends GuiSection {
/*  26 */   private static CharSequence ¤¤Rank = "Current rank of this noble. More ranks allows a noble to contribute a lot more towards their current assignment. Ranks are gained by levelling up your city. A noble can not be stripped of ranks, but the ranks will become available after their death.";
/*  27 */   private static CharSequence ¤¤no = "Unassigned Nobility";
/*  28 */   private static CharSequence ¤¤assign = "Assign this noble to an office.";
/*     */   static {
/*  30 */     D.ts(NobleRow.class);
/*     */   }
/*     */   
/*  33 */   public static int width = 500;
/*     */   private final GETTER<Integer> ier;
/*     */   
/*     */   public NobleRow(GETTER<Integer> ier) {
/*  37 */     this.ier = ier;
/*     */     
/*  39 */     GStat s = new GStat((UI.FONT()).S)
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/*  43 */           text.lablifySub();
/*  44 */           text.add(NobleRow.this.n().rankName());
/*     */         }
/*     */       };
/*     */     
/*  48 */     add((SPRITE)s, 0, 0);
/*     */     
/*  50 */     s = new GStat((UI.FONT()).H2)
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/*  54 */           text.lablify();
/*  55 */           text.add(STATS.APPEARANCE().name(NobleRow.this.n().subject().indu()));
/*  56 */           text.setMaxWidth(420);
/*  57 */           text.setMultipleLines(false);
/*     */         }
/*     */       };
/*     */     
/*  61 */     addDown(2, (SPRITE)s);
/*     */     
/*  63 */     s = new GStat((UI.FONT()).S)
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/*  67 */           if (NobleRow.this.n().office() == null) {
/*  68 */             text.warnify().add(NobleRow.¤¤no);
/*     */           } else {
/*  70 */             text.lablifySub().add(NobleRow.this.n().title());
/*     */           } 
/*     */         }
/*     */       };
/*  74 */     addDown(2, (SPRITE)s);
/*     */ 
/*     */     
/*  77 */     GButt.ButtPanel p = new GButt.ButtPanel((SPRITE)new Assignments())
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  81 */           (VIEW.s()).ui.nobles.assigns.n = NobleRow.this.n();
/*  82 */           (VIEW.inters()).popup.show((RENDEROBJ)(VIEW.s()).ui.nobles.assigns, (CLICKABLE)this);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  87 */           if (NobleRow.this.n().office() == null) {
/*  88 */             text.text(NobleRow.¤¤assign);
/*     */           } else {
/*  90 */             NobleRow.this.n().hoverOffice(text);
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/*  95 */     p.pad(4, 4);
/*  96 */     addDown(4, (RENDEROBJ)p);
/*     */     
/*  98 */     GuiSection rank = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 101 */           text.text(NobleRow.¤¤Rank);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 106 */     rank.addRightC(8, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).s.chevron(DIR.N))
/*     */         {
/*     */           protected void clickA() {
/* 109 */             GAME.NOBLE().ranksAllocate(NobleRow.this.n());
/*     */           }
/*     */           
/*     */           protected void renAction() {
/* 113 */             activeSet((NobleRow.this.n().rank() < GAME.NOBLE().maxRanks() - 1 && GAME.NOBLE().ranksAllocated() < (int)(GAME.NOBLE()).MAX_RANKS.get((BOOSTABLE_O)HCLASS_RACE.clP())));
/*     */           }
/* 115 */         }).pad(4, 4));
/*     */     
/* 117 */     rank.addRightC(4, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 121 */             GFORMAT.i(text, NobleRow.this.n().rank());
/*     */           }
/*     */         });
/*     */     
/* 125 */     addRightC(16, (RENDEROBJ)rank);
/*     */     
/* 127 */     addRight(32, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.crossair)
/*     */         {
/*     */           protected void clickA() {
/* 130 */             VIEW.s().activate();
/* 131 */             (VIEW.s().getWindow()).centerer.set(NobleRow.this.n().subject().body().cX(), NobleRow.this.n().subject().body().cY());
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     SPRITE.Imp imp = new SPRITE.Imp(80, 128)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 145 */           STATS.APPEARANCE().portraitRender(r, NobleRow.this.n().subject().indu(), X1, Y1, 2);
/*     */         }
/*     */       };
/*     */     
/* 149 */     addRelBody(16, DIR.W, (SPRITE)imp);
/* 150 */     body().pad(16, 2);
/* 151 */     body().setWidth(width);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 156 */     GButt.ButtPanel.renderBG(r, true, false, false, (RECTANGLE)body());
/* 157 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/* 158 */     super.render(r, ds);
/*     */   }
/*     */ 
/*     */   
/*     */   private Noble n() {
/* 163 */     return (Noble)GAME.NOBLE().active().get(((Integer)this.ier.get()).intValue());
/*     */   }
/*     */   
/*     */   private class Assignments
/*     */     extends SPRITE.Imp {
/*     */     public Assignments() {
/* 169 */       super(32, 32);
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 174 */       int cy = Y1 + (Y2 - Y1) / 2;
/* 175 */       int cx = X1 + (X2 - X1) / 2;
/* 176 */       NobleOffice o = NobleRow.this.n().office();
/* 177 */       if (o == null) {
/* 178 */         (UI.icons()).m.questionmark.renderC(r, cx, cy);
/*     */       } else {
/* 180 */         o.icon.renderC(r, cx, cy);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\noble\NobleRow.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */