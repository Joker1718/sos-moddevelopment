/*     */ package view.sett.ui.subject;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.HTYPE;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class UISubjectType extends GuiSection {
/*  20 */   private final GuiSection currentS = new GuiSection();
/*     */   public final HTYPE type;
/*     */   private GuiSection current;
/*  23 */   private static CharSequence ¤¤race = "¤Read up about current race in the tome of knowledge.";
/*  24 */   private static CharSequence ¤¤favourite = "¤Mark as favourite";
/*  25 */   private static CharSequence ¤¤follow = "¤Center screen at subject.";
/*     */   
/*     */   static {
/*  28 */     D.ts(UISubjectType.class);
/*     */   }
/*     */ 
/*     */   
/*     */   UISubjectType(final AInfo a, HTYPE type) {
/*  33 */     GuiSection top = new GuiSection();
/*  34 */     int w = 0;
/*  35 */     this.type = type;
/*  36 */     top.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.arrow_right)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  40 */             a.follow = 20;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/*  45 */             selectedSet((a.follow > 0));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/*  50 */             text.text(UISubjectType.¤¤follow);
/*     */           }
/*  52 */         }).pad(4, 1));
/*     */     
/*  54 */     top.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.heart)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  58 */             (STATS.APPEARANCE()).favo.set(a.a.indu(), (STATS.APPEARANCE()).favo.get(a.a.indu()) + 1 & 0x1);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/*  63 */             selectedSet(((STATS.APPEARANCE()).favo.get(a.a.indu()) == 1));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/*  68 */             text.text(UISubjectType.¤¤favourite);
/*     */           }
/*  70 */         }).pad(4, 1));
/*     */     
/*  72 */     final UISubjectInfo info = new UISubjectInfo(a, ISidePanel.HEIGHT - 40, type);
/*  73 */     top.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel(Dic.¤¤Info)
/*     */         {
/*     */           protected void clickA() {
/*  76 */             UISubjectType.this.set(info);
/*  77 */             super.clickA();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/*  82 */             selectedSet((UISubjectType.this.current == info));
/*     */           }
/*  84 */         }).pad(4, 1));
/*  85 */     w = Math.max(w, info.body().width());
/*     */     
/*  87 */     final UISubjectProperties prop = new UISubjectProperties(a, ISidePanel.HEIGHT - 40, type);
/*  88 */     top.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel(Dic.¤¤Properites)
/*     */         {
/*     */           protected void clickA() {
/*  91 */             UISubjectType.this.set(prop);
/*  92 */             super.clickA();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/*  97 */             selectedSet((UISubjectType.this.current == prop));
/*     */           }
/*  99 */         }).pad(4, 1));
/* 100 */     w = Math.max(w, prop.body().width());
/*     */     
/* 102 */     if (type.CLASS.player) {
/* 103 */       final UISubjectStats stats = new UISubjectStats(a, ISidePanel.HEIGHT - 40);
/* 104 */       top.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel(((STANDINGS.CITIZEN()).fullfillment.info()).name)
/*     */           {
/*     */             protected void clickA() {
/* 107 */               UISubjectType.this.set(stats);
/* 108 */               super.clickA();
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 113 */               selectedSet((UISubjectType.this.current == stats));
/*     */             }
/* 115 */           }).pad(4, 1));
/* 116 */       w = Math.max(w, stats.body().width());
/*     */     } 
/*     */     
/* 119 */     top.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.questionmark)
/*     */         {
/*     */           protected void clickA() {
/* 122 */             (VIEW.UI()).wiki.showRace(a.a.race());
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 127 */             text.text(UISubjectType.¤¤race);
/* 128 */             super.hoverInfoGet(text);
/*     */           }
/* 130 */         }).pad(4, 1));
/* 131 */     w = Math.max(w, top.body().width());
/*     */     
/* 133 */     body().setDim(w, 1.0D);
/*     */     
/* 135 */     addRelBody(0, DIR.S, (RENDEROBJ)top);
/* 136 */     this.currentS.body().setDim(w, (ISidePanel.HEIGHT - body().height()));
/* 137 */     addRelBody(8, DIR.S, (RENDEROBJ)this.currentS);
/*     */     
/* 139 */     set(info);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void set(GuiSection s) {
/* 145 */     this.current = s;
/* 146 */     int y1 = this.currentS.body().y1();
/* 147 */     this.currentS.clear();
/* 148 */     this.currentS.add((RENDEROBJ)s);
/* 149 */     this.currentS.body().moveY1(y1);
/* 150 */     this.currentS.body().centerX((RECTANGLE)body());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectType.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */