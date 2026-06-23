/*     */ package view.sett.ui.law;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CRIMES;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.law.Curfew;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ 
/*     */ public class UILaw extends ISidePanel {
/*  20 */   private final GuiSection sec = new GuiSection();
/*     */   
/*     */   public UILaw() {
/*  23 */     titleSet(Dic.¤¤Law);
/*     */     
/*  25 */     GuiSection sel = new GuiSection();
/*  26 */     int w = 0;
/*     */     
/*  28 */     int HH = HEIGHT - 64;
/*     */ 
/*     */     
/*  31 */     GuiSection s = new UILawCrimeList(HH, HCLASSES.CITIZEN());
/*  32 */     w = Math.max(s.body().width(), w);
/*  33 */     sel.addRightC(0, butt((HCLASSES.CITIZEN()).names, s));
/*  34 */     if (this.sec.elements().size() == 0) {
/*  35 */       set((RENDEROBJ)s);
/*     */     }
/*     */ 
/*     */     
/*  39 */     s = new UILawCrimeList(HH, HCLASSES.SLAVE());
/*  40 */     w = Math.max(s.body().width(), w);
/*  41 */     sel.addRightC(0, butt((HCLASSES.SLAVE()).names, s));
/*  42 */     if (this.sec.elements().size() == 0) {
/*  43 */       set((RENDEROBJ)s);
/*     */     }
/*     */ 
/*     */     
/*  47 */     s = new WarCriminals(HH);
/*  48 */     w = Math.max(s.body().width(), w);
/*  49 */     sel.addRightC(0, butt((CRIMES.WAR()).names, s));
/*  50 */     if (this.sec.elements().size() == 0) {
/*  51 */       set((RENDEROBJ)s);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  56 */     GButt.ButtPanel cur = new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.building)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/*  60 */           text.title(Curfew.¤¤name);
/*  61 */           text.text(Curfew.¤¤desc);
/*  62 */           text.NL(8);
/*  63 */           if (STATS.LAW().getCurfew().isSetForADay()) {
/*  64 */             text.text(Dic.¤¤Deactivate);
/*     */           } else {
/*  66 */             text.text(Dic.¤¤Activate);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/*  72 */           selectedSet(STATS.LAW().getCurfew().isSetForADay());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/*  77 */           STATS.LAW().getCurfew().setForADay(!STATS.LAW().getCurfew().isSetForADay());
/*     */         }
/*     */       };
/*     */     
/*  81 */     cur.pad(14, 0);
/*     */ 
/*     */     
/*  84 */     GuiSection guiSection1 = new GuiSection();
/*  85 */     w = Math.max(guiSection1.body().width(), w);
/*  86 */     sel.addRightC(0, (RENDEROBJ)cur);
/*     */ 
/*     */     
/*  89 */     if ((S.get()).developer) {
/*  90 */       GButt.ButtPanel b = new GButt.ButtPanel((SPRITE)(UI.icons()).s.arrowUp)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  94 */             (STATS.LAW()).debug = 1.0D;
/*     */           }
/*     */         };
/*     */       
/*  98 */       sel.addRightC(0, (RENDEROBJ)b);
/*     */     } 
/*     */     
/* 101 */     w = Math.max(w, sel.body().width());
/* 102 */     this.sec.body().setWidth(w);
/* 103 */     set((RENDEROBJ)this.sec.elements().get(0));
/*     */     
/* 105 */     this.section.add((RENDEROBJ)sel);
/* 106 */     this.sec.body().centerIn((BODY_HOLDER)this.section);
/* 107 */     this.sec.body().moveY1(48.0D);
/* 108 */     this.section.add((RENDEROBJ)this.sec);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private RENDEROBJ butt(CharSequence name, final GuiSection s) {
/* 114 */     GButt.ButtPanel b = new GButt.ButtPanel(name)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 118 */           UILaw.this.set((RENDEROBJ)s);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 123 */           selectedSet((UILaw.this.sec.elements().get(0) == s));
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 128 */     b.body.setWidth(160.0D);
/* 129 */     return (RENDEROBJ)b;
/*     */   }
/*     */ 
/*     */   
/*     */   private void set(RENDEROBJ s) {
/* 134 */     int x1 = this.sec.body().x1();
/* 135 */     int y1 = this.sec.body().y1();
/* 136 */     int w = this.sec.body().width();
/*     */     
/* 138 */     this.sec.clear();
/* 139 */     this.sec.body().setWidth(w);
/* 140 */     this.sec.addRelBody(0, DIR.S, s);
/* 141 */     this.sec.body().moveX1Y1(x1, y1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\law\UILaw.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */