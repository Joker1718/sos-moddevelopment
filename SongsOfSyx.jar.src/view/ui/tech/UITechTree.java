/*     */ package view.ui.tech;
/*     */ 
/*     */ import game.faction.player.PTech;
/*     */ import init.constant.C;
/*     */ import init.sprite.UI.UI;
/*     */ import init.tech.TECHS;
/*     */ import init.tech.TechTree;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GInput;
/*     */ import util.text.Dic;
/*     */ import view.ui.manage.IFullView;
/*     */ 
/*     */ public class UITechTree extends IFullView {
/*  24 */   final Prompt prompt = new Prompt(); final Search search;
/*     */   final InfoBonuses bonuses;
/*     */   final CLICKABLE.ClickSwitch swit;
/*     */   GuiSection currentTree;
/*     */   
/*  29 */   final StringInputSprite filter = new StringInputSprite(16, (UI.FONT()).S)
/*     */     {
/*     */       protected void change() {
/*  32 */         if (text() == null || text().length() == 0) {
/*  33 */           UITechTree.this.swit.set((RENDEROBJ)UITechTree.this.currentTree);
/*     */         } else {
/*  35 */           UITechTree.this.swit.set((RENDEROBJ)UITechTree.this.search.set((CharSequence)text()));
/*     */         } 
/*     */       }
/*     */     };
/*     */   public UITechTree() {
/*  40 */     super(PTech.¤¤name, (SPRITE)(UI.icons()).l.vial);
/*     */     
/*  42 */     this.filter.placeHolder(Dic.¤¤Filter);
/*  43 */     Info info = new Info(this, WIDTH);
/*     */     
/*  45 */     GuiSection trees = new GuiSection();
/*  46 */     for (TechTree t : TECHS.TREES()) {
/*  47 */       final GuiSection tree = new Tree(t, HEIGHT - info.body().height() - 48, WIDTH);
/*  48 */       if (this.currentTree == null)
/*  49 */         this.currentTree = tree; 
/*  50 */       trees.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel(t.icon)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/*  54 */               UITechTree.this.currentTree = tree;
/*  55 */               UITechTree.this.swit.set((RENDEROBJ)tree);
/*  56 */               UITechTree.this.filter.text().clear();
/*  57 */               super.clickA();
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/*  62 */               selectedSet((UITechTree.this.swit.current() == tree));
/*     */             }
/*  65 */           }).setDim(50, 40).hoverTitleSet(t.name));
/*     */     } 
/*  67 */     trees.addRightC(8, (RENDEROBJ)filter());
/*  68 */     GuiSection ss = new GuiSection()
/*     */       {
/*     */         
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/*  73 */           GCOLOR.UI().border().renderFrame(r, 0, C.WIDTH(), body().y1(), body().y2(), 0, 2);
/*  74 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */     
/*  78 */     ss.body().setDim((WIDTH + 32), (trees.body().height() + 2));
/*  79 */     trees.body().centerIn((BODY_HOLDER)ss);
/*  80 */     ss.add((RENDEROBJ)trees);
/*  81 */     ss.pad(8, 4);
/*  82 */     ss.body().moveY1((info.body().y2() + 4));
/*  83 */     ss.body().moveCX((WIDTH / 2));
/*  84 */     info.add((RENDEROBJ)ss);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  89 */     this.bonuses = new InfoBonuses(this, HEIGHT - info.body().height() + 16, WIDTH);
/*  90 */     this.search = new Search(info.body().height() + 16, WIDTH);
/*     */     
/*  92 */     this.swit = new CLICKABLE.ClickSwitch((RENDEROBJ)this.currentTree);
/*  93 */     this.section.add((RENDEROBJ)this.swit, 0, 0);
/*     */ 
/*     */     
/*  96 */     this.bonuses.body().moveX1((this.section.body().x2() + 8));
/*  97 */     this.bonuses.body().moveY1(this.section.body().y1());
/*     */     
/*  99 */     this.section.addRelBody(16, DIR.N, (RENDEROBJ)info);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private GuiSection filter() {
/* 113 */     GuiSection s = new GuiSection();
/*     */     
/* 115 */     GInput in = new GInput(this.filter);
/* 116 */     s.add((RENDEROBJ)in);
/*     */     
/* 118 */     GButt.ButtPanel buttPanel = new GButt.ButtPanel("+++")
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 122 */           boolean bo = UITechTree.this.bonuses();
/* 123 */           UITechTree.this.filter.set(Dic.empty);
/* 124 */           UITechTree.this.bonuses(!bo);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 129 */           selectedSet(UITechTree.this.bonuses());
/*     */         }
/*     */       };
/*     */     
/* 133 */     buttPanel.hoverInfoSet(Dic.¤¤Boosts);
/*     */     
/* 135 */     s.addRightC(4, (RENDEROBJ)buttPanel);
/* 136 */     s.pad(32, 4);
/* 137 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   public void filter(CharSequence ss) {
/* 142 */     this.filter.set(ss);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean back() {
/* 147 */     if (this.swit.current() != this.currentTree) {
/* 148 */       this.filter.set(Dic.empty);
/* 149 */       return true;
/*     */     } 
/* 151 */     return super.back();
/*     */   }
/*     */   
/*     */   void bonuses(boolean b) {
/* 155 */     if (b) {
/* 156 */       this.swit.set((RENDEROBJ)this.bonuses);
/*     */     } else {
/* 158 */       this.swit.set((RENDEROBJ)this.currentTree);
/*     */     } 
/*     */   }
/*     */   boolean bonuses() {
/* 162 */     return (this.swit.current() == this.bonuses);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\UITechTree.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */