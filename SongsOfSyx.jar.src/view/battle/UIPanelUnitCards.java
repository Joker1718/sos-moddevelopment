/*     */ package view.battle;
/*     */ 
/*     */ import game.battle.Army;
/*     */ import game.battle.div.Div;
/*     */ import init.constant.Config;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class UIPanelUnitCards
/*     */   extends ISidePanel
/*     */ {
/*  28 */   private static int xs = 5;
/*  29 */   private final ArrayList<DivButton> cards = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*  30 */   private final ArrayList<DivButton> current = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*     */   
/*     */   private DivButton clicked;
/*     */   
/*     */   private boolean dragging;
/*     */   private final Army army;
/*     */   private final DivSelection selection;
/*     */   
/*     */   public UIPanelUnitCards(Army army, DivSelection selection) {
/*  39 */     titleSet(Dic.¤¤Army);
/*  40 */     this.army = army;
/*  41 */     this.selection = selection;
/*  42 */     this.section = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/*  45 */           UIPanelUnitCards.this.init();
/*  46 */           super.render(r, ds);
/*  47 */           if (!MButt.LEFT.isDown()) {
/*  48 */             UIPanelUnitCards.this.dragging = false;
/*     */           }
/*     */         }
/*     */       };
/*  52 */     for (Div d : army.divisions()) {
/*  53 */       this.cards.add(new DivButton(d, selection));
/*     */     }
/*  55 */     GTableBuilder bu = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  59 */           int am = CLAMP.i(UIPanelUnitCards.this.current.size(), 0, (Config.battle()).DIVISIONS_PER_ARMY);
/*  60 */           return (int)Math.ceil(am / UIPanelUnitCards.xs);
/*     */         }
/*     */       };
/*     */     
/*  64 */     bu.column(null, xs * (VIEW.UI()).div.battle.width, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/*  68 */             return UIPanelUnitCards.this.row(ier);
/*     */           }
/*     */         });
/*     */     
/*  72 */     this.section.add((RENDEROBJ)bu.createHeight(HEIGHT, false));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private RENDEROBJ row(final GETTER<Integer> ier) {
/*  78 */     GuiSection ss = new GuiSection()
/*     */       {
/*     */         
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/*  83 */           int x1 = body().x1();
/*  84 */           int y1 = body().y1();
/*  85 */           clear();
/*  86 */           for (int i = 0; i < UIPanelUnitCards.xs; i++) {
/*  87 */             int k = ((Integer)ier.get()).intValue() * UIPanelUnitCards.xs + i;
/*  88 */             if (k >= UIPanelUnitCards.this.current.size()) {
/*     */               break;
/*     */             }
/*  91 */             addRightC(0, (RENDEROBJ)UIPanelUnitCards.this.current.get(k));
/*     */           } 
/*     */           
/*  94 */           body().moveX1Y1(x1, y1);
/*  95 */           body().setWidth(((VIEW.UI()).div.battle.width * UIPanelUnitCards.xs));
/*  96 */           body().setHeight((VIEW.UI()).div.battle.height);
/*  97 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */     
/* 101 */     ss.body().setWidth(((VIEW.UI()).div.battle.width * xs));
/* 102 */     ss.body().setHeight((VIEW.UI()).div.battle.height);
/* 103 */     return (RENDEROBJ)ss;
/*     */   }
/*     */   
/*     */   private void init() {
/* 107 */     this.current.clearSloppy();
/* 108 */     for (Div d : this.army.ordered()) {
/* 109 */       if (d.menNrOf() > 0) {
/* 110 */         this.current.add(this.cards.get(d.indexArmy())); continue;
/*     */       } 
/* 112 */       this.selection.deSelect(d);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private class DivButton
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/*     */     private final Div div;
/*     */     
/*     */     private final DivSelection selection;
/*     */ 
/*     */     
/*     */     DivButton(Div div, DivSelection selection) {
/* 126 */       this.body.setDim((DIMENSION)(VIEW.UI()).div.battle);
/* 127 */       this.div = div;
/* 128 */       this.selection = selection;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 134 */       isSelected = this.selection.selected(this.div);
/* 135 */       isHovered |= this.selection.hovered(this.div);
/* 136 */       (VIEW.UI()).div.battle.render(this.div, body().x1(), body().y1(), 1, r, isActive, isSelected, isHovered);
/*     */       
/* 138 */       if (UIPanelUnitCards.this.dragging && isHovered && UIPanelUnitCards.this.clicked != null && UIPanelUnitCards.this.clicked != this && !(KEYS.MAIN()).UNDO.isPressed() && !(KEYS.MAIN()).MOD.isPressed()) {
/*     */         
/* 140 */         COLOR.GREEN100.render(r, body().x1() - 2, body().x1() + 2, body().y1(), body().y2());
/* 141 */         if (!MButt.LEFT.isDown()) {
/*     */           
/* 143 */           UIPanelUnitCards.this.army.setDivAtOrderedIndex(this.div, UIPanelUnitCards.this.clicked.div);
/* 144 */           this.selection.deSelect(UIPanelUnitCards.this.clicked.div);
/* 145 */           this.selection.select(this.div);
/* 146 */           UIPanelUnitCards.this.clicked = this;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 154 */       if ((KEYS.MAIN()).UNDO.isPressed() && UIPanelUnitCards.this.clicked != null) {
/* 155 */         int ci = UIPanelUnitCards.this.current.indexOf(this);
/* 156 */         int di = UIPanelUnitCards.this.current.indexOf(UIPanelUnitCards.this.clicked);
/* 157 */         int f = Math.min(ci, di);
/* 158 */         int t = Math.max(ci, di);
/*     */         
/* 160 */         for (int i = 0; i < UIPanelUnitCards.this.current.size(); i++) {
/* 161 */           if (i >= f && i <= t) {
/* 162 */             this.selection.select(((DivButton)UIPanelUnitCards.this.current.get(i)).div);
/*     */           } else {
/* 164 */             this.selection.deSelect(((DivButton)UIPanelUnitCards.this.current.get(i)).div);
/*     */           }
/*     */         
/*     */         } 
/* 168 */       } else if ((KEYS.MAIN()).MOD.isPressed()) {
/* 169 */         this.selection.sToggle(this.div);
/*     */       } else {
/* 171 */         for (int i = 0; i < UIPanelUnitCards.this.current.size(); i++) {
/* 172 */           this.selection.deSelect(((DivButton)UIPanelUnitCards.this.current.get(i)).div);
/*     */         }
/* 174 */         this.selection.select(this.div);
/* 175 */         UIPanelUnitCards.this.clicked = this;
/* 176 */         UIPanelUnitCards.this.dragging = true;
/* 177 */         if (MButt.LEFT.isDouble() && this.div.menNrOf() > 0) {
/* 178 */           ((VIEW.s()).battle.getWindow()).centerer.set(this.div.reporter.body().cX(), this.div.reporter.body().cY());
/* 179 */           (VIEW.b().getWindow()).centerer.set(this.div.reporter.body().cX(), this.div.reporter.body().cY());
/* 180 */           (VIEW.inters()).popup.show((RENDEROBJ)(VIEW.UI()).div.battle.hovBox(this.div), (CLICKABLE)this);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 195 */       if ((VIEW.inters()).popup.showing())
/*     */         return; 
/* 197 */       this.div.hoverInfo((GBox)text);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 202 */       if (super.hover(mCoo)) {
/* 203 */         this.selection.hover(this.div);
/* 204 */         return true;
/*     */       } 
/* 206 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\UIPanelUnitCards.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */