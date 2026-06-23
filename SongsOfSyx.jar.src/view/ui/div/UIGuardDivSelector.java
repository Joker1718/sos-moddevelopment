/*     */ package view.ui.div;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import init.constant.Config;
/*     */ import init.type.HTYPES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.law.guard.ROOM_GUARD;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public class UIGuardDivSelector extends GuiSection {
/*  28 */   private static CharSequence ¤¤guards = "Guard Force";
/*     */   
/*     */   static {
/*  31 */     D.ts(UIGuardDivSelector.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  36 */   private final int cols = 8;
/*  37 */   private final ArrayList<Card> allCards = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*  38 */   private final ArrayList<GuiSection> allRows = new ArrayList((int)Math.ceil((Config.battle()).DIVISIONS_PER_ARMY / 8.0D));
/*     */ 
/*     */ 
/*     */   
/*     */   public UIGuardDivSelector() {
/*  43 */     while (this.allRows.hasRoom()) {
/*  44 */       this.allRows.add(new GuiSection());
/*     */     }
/*  46 */     while (this.allCards.hasRoom()) {
/*  47 */       this.allCards.add(new Card(this.allCards.size()));
/*     */     }
/*     */ 
/*     */     
/*  51 */     GuiSection s = new GuiSection();
/*     */     
/*  53 */     s.add((RENDEROBJ)new GHeader(¤¤guards));
/*     */     
/*  55 */     s.addDown(2, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  59 */             int a = 0;
/*  60 */             for (Div d : GAME.ARMIES().player().divisions()) {
/*  61 */               if ((UIGuardDivSelector.this.blue()).activeDuty.is(d))
/*  62 */                 a++; 
/*  63 */             }  GFORMAT.i(text, a);
/*     */           }
/*  65 */         }).hh(Dic.¤¤Divisions, 120));
/*     */ 
/*     */ 
/*     */     
/*  69 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  73 */             int tot = 0;
/*  74 */             for (Div d : GAME.ARMIES().player().divisions()) {
/*  75 */               if ((UIGuardDivSelector.this.blue()).activeDuty.is(d))
/*  76 */                 tot += d.info.men(); 
/*  77 */             }  GFORMAT.iofk(text, STATS.POP().pop(HTYPES.GUARD()), tot);
/*     */           }
/*  79 */         }).hh(Dic.¤¤Soldiers, 120), 0, s.body().y2() + 4);
/*     */     
/*  81 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  85 */             GFORMAT.f0(text, (UIGuardDivSelector.this.blue()).power.get());
/*     */           }
/*  87 */         }).hh(Dic.¤¤Power, 120), 0, s.body().y2() + 4);
/*     */     
/*  89 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  93 */             GFORMAT.f0(text, (STATS.LAW()).guards.data(null).getD(null));
/*     */           }
/*  95 */         }).hh((BOOSTABLES.CIVICS()).LAW.name, 120), 0, s.body().y2() + 4);
/*     */     
/*  97 */     add((RENDEROBJ)s);
/*     */ 
/*     */     
/* 100 */     setDims();
/* 101 */     CLICKABLE cLICKABLE = (new GScrollRows((Iterable)this.allRows, ((Card)this.allCards.get(0)).body.height() * 5)
/*     */       {
/*     */         protected boolean passesFilter(int i, RENDEROBJ o) {
/* 104 */           return true;
/*     */         }
/* 106 */       }).view();
/*     */     
/* 108 */     addRelBody(8, DIR.S, (RENDEROBJ)cLICKABLE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 115 */     for (GuiSection s : this.allRows) {
/* 116 */       s.clear();
/*     */     }
/* 118 */     int rowI = 0;
/*     */     
/* 120 */     for (Div d : GAME.ARMIES().player().divisions()) {
/* 121 */       if (d.info.men() > 0) {
/* 122 */         ((GuiSection)this.allRows.get(rowI)).addRightC(0, (RENDEROBJ)this.allCards.get(d.indexArmy()));
/* 123 */         if (((GuiSection)this.allRows.get(rowI)).elements().size() == 8) {
/* 124 */           rowI++;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 129 */     setDims();
/*     */ 
/*     */ 
/*     */     
/* 133 */     super.render(r, ds);
/*     */   }
/*     */   
/*     */   private void setDims() {
/* 137 */     for (GuiSection s : this.allRows) {
/* 138 */       s.body().setWidth((((Card)this.allCards.get(0)).body.width() * 8));
/* 139 */       s.body().setHeight(((Card)this.allCards.get(0)).body.height());
/*     */     } 
/*     */   }
/*     */   
/*     */   private ROOM_GUARD blue() {
/* 144 */     return (SETT.ROOMS()).GUARD;
/*     */   }
/*     */   
/*     */   private final class Card
/*     */     extends CLICKABLE.ClickableAbs {
/*     */     private final int di;
/*     */     
/*     */     Card(int di) {
/* 152 */       super((VIEW.UI()).div.settCivic.width(), (VIEW.UI()).div.settCivic.height());
/* 153 */       this.di = di;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 158 */       Div d = (Div)GAME.ARMIES().player().divisions().get(this.di);
/* 159 */       isSelected = (UIGuardDivSelector.this.blue()).activeDuty.is(d);
/* 160 */       (VIEW.UI()).div.settCivic.render(r, this.body.x1(), this.body.y1(), 1, d, isActive, isSelected, isHovered);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 165 */       Div d = (Div)GAME.ARMIES().player().divisions().get(this.di);
/* 166 */       (VIEW.UI()).div.settCivic.hover(text, d);
/* 167 */       super.hoverInfoGet(text);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 172 */       Div d = (Div)GAME.ARMIES().player().divisions().get(this.di);
/* 173 */       (UIGuardDivSelector.this.blue()).activeDuty.toggle(d);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIGuardDivSelector.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */