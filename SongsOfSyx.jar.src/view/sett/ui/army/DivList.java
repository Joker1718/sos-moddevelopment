/*     */ package view.sett.ui.army;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import init.constant.Config;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.data.GETTER;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class DivList
/*     */   extends GuiSection {
/*  23 */   private static int xs = 10;
/*  24 */   private static int scale = 1;
/*  25 */   private final ArrayList<Card> cards = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*  26 */   private final ArrayList<Card> current = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*     */   
/*     */   private final ArrayList<Div> selection;
/*     */   private Card clicked;
/*     */   private boolean dragging;
/*     */   
/*     */   DivList(int height, ArrayList<Div> selection) {
/*  33 */     this.selection = selection;
/*     */     
/*  35 */     for (Div d : GAME.ARMIES().player().divisions()) {
/*  36 */       this.cards.add(new Card(d.indexArmy()));
/*     */     }
/*     */     
/*  39 */     GTableBuilder bu = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  43 */           int am = CLAMP.i(DivList.this.current.size(), 0, (Config.battle()).DIVISIONS_PER_ARMY);
/*  44 */           return (int)Math.ceil(am / DivList.xs);
/*     */         }
/*     */       };
/*     */     
/*  48 */     bu.column(null, xs * (VIEW.UI()).div.settCivic.width() * scale, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/*  52 */             return DivList.this.row(ier);
/*     */           }
/*     */         });
/*     */     
/*  56 */     add((RENDEROBJ)bu.createHeight(height, false));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  64 */     init();
/*  65 */     super.render(r, ds);
/*  66 */     if (!MButt.LEFT.isDown()) {
/*  67 */       this.dragging = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void init() {
/*  73 */     this.current.clearSloppy();
/*  74 */     this.selection.clearSloppy();
/*  75 */     for (Card c : this.cards) {
/*  76 */       if ((c.div()).info.men() > 0) {
/*  77 */         this.current.add(c);
/*  78 */         if (c.selectedIs())
/*  79 */           this.selection.add(c.div());  continue;
/*     */       } 
/*  81 */       c.selectedSet(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<Div> selection() {
/*  87 */     return (LIST<Div>)this.selection;
/*     */   }
/*     */   
/*     */   private RENDEROBJ row(final GETTER<Integer> ier) {
/*  91 */     GuiSection ss = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/*  95 */           int x1 = body().x1();
/*  96 */           int y1 = body().y1();
/*  97 */           clear();
/*  98 */           for (int i = 0; i < DivList.xs; i++) {
/*  99 */             int k = ((Integer)ier.get()).intValue() * DivList.xs + i;
/* 100 */             if (k >= DivList.this.current.size()) {
/*     */               break;
/*     */             }
/* 103 */             addRightC(0, (RENDEROBJ)DivList.this.current.get(k));
/*     */           } 
/*     */           
/* 106 */           body().moveX1Y1(x1, y1);
/* 107 */           body().setWidth(((VIEW.UI()).div.settCivic.width() * DivList.scale * DivList.xs));
/* 108 */           body().setHeight(((VIEW.UI()).div.settCivic.height() * DivList.scale));
/* 109 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */     
/* 113 */     ss.body().setWidth(((VIEW.UI()).div.settCivic.width() * scale * xs));
/* 114 */     ss.body().setHeight(((VIEW.UI()).div.settCivic.height() * scale));
/* 115 */     return (RENDEROBJ)ss;
/*     */   }
/*     */   
/*     */   private class Card
/*     */     extends CLICKABLE.ClickableAbs {
/*     */     private final int di;
/*     */     
/*     */     Card(int di) {
/* 123 */       super((VIEW.UI()).div.settCivic.width() * DivList.scale, (VIEW.UI()).div.settCivic.height() * DivList.scale);
/* 124 */       this.di = di;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 129 */       Div div = div();
/* 130 */       (VIEW.UI()).div.settCivic.render(r, this.body.x1(), this.body.y1(), DivList.scale, div, isActive, isSelected, isHovered);
/*     */ 
/*     */ 
/*     */       
/* 134 */       if (DivList.this.dragging && isHovered && DivList.this.clicked != null && DivList.this.clicked != this && !(KEYS.MAIN()).UNDO.isPressed() && !(KEYS.MAIN()).MOD.isPressed()) {
/*     */         
/* 136 */         COLOR.GREEN100.render(r, body().x1() - 2, body().x1() + 2, body().y1(), body().y2());
/* 137 */         if (!MButt.LEFT.isDown()) {
/*     */           
/* 139 */           GAME.ARMIES().player().setDivAtOrderedIndex(div(), DivList.this.clicked.div());
/* 140 */           DivList.this.clicked.selectedSet(false);
/* 141 */           selectedSet(true);
/* 142 */           DivList.this.clicked = this;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 152 */       if ((KEYS.MAIN()).UNDO.isPressed() && DivList.this.clicked != null) {
/* 153 */         int ci = DivList.this.current.indexOf(this);
/* 154 */         int di = DivList.this.current.indexOf(DivList.this.clicked);
/* 155 */         int f = Math.min(ci, di);
/* 156 */         int t = Math.max(ci, di);
/*     */         
/* 158 */         for (int i = 0; i < DivList.this.current.size(); i++) {
/* 159 */           ((Card)DivList.this.current.get(i)).selectedSet((i >= f && i <= t));
/*     */         
/*     */         }
/*     */       }
/* 163 */       else if ((KEYS.MAIN()).MOD.isPressed()) {
/* 164 */         selectedSet(!selectedIs());
/*     */       } else {
/* 166 */         for (int i = 0; i < DivList.this.current.size(); i++) {
/* 167 */           ((Card)DivList.this.current.get(i)).selectedSet(false);
/*     */         }
/* 169 */         selectedSet(true);
/* 170 */         DivList.this.clicked = this;
/* 171 */         DivList.this.dragging = true;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 178 */       (VIEW.UI()).div.settCivic.hover(text, div());
/*     */     }
/*     */     
/*     */     private Div div() {
/* 182 */       return (Div)GAME.ARMIES().player().ordered().get(this.di);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\DivList.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */