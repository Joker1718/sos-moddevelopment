/*     */ package view.sett.ui.army;
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.DIV_SIMPLE;
/*     */ import init.constant.Config;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.ui.div.UIDivCardSett;
/*     */ import view.ui.div.UIDivCardWorld;
/*     */ import world.army.AD;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ public class UIArmyCitySendOut extends GuiSection {
/*  29 */   private static int xs = 8;
/*  30 */   private final ArrayList<Card> cards = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*  31 */   private final ArrayList<Card> current = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*  32 */   private final ArrayList<Div> li = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*  33 */   private final UIDivCardSett card = (VIEW.UI()).div.settCivic;
/*     */   
/*     */   private WArmy army;
/*     */   
/*     */   public UIArmyCitySendOut() {
/*  38 */     for (Div d : GAME.ARMIES().player().divisions()) {
/*  39 */       this.cards.add(new Card(d));
/*     */     }
/*     */     
/*  42 */     GTableBuilder bu = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  46 */           int am = CLAMP.i(UIArmyCitySendOut.this.current.size() + 1, 0, (Config.battle()).DIVISIONS_PER_ARMY);
/*  47 */           return (int)Math.ceil(am / UIArmyCitySendOut.xs);
/*     */         }
/*     */       };
/*     */     
/*  51 */     bu.column(null, xs * this.card.width(), new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/*  55 */             return UIArmyCitySendOut.this.row(ier);
/*     */           }
/*     */         });
/*     */     
/*  59 */     add((RENDEROBJ)bu.create(4, false));
/*     */     
/*  61 */     GuiSection s = new GuiSection();
/*  62 */     GButt.ButtPanel but = new GButt.ButtPanel(Dic.¤¤confirm)
/*     */       {
/*     */         protected void renAction()
/*     */         {
/*  66 */           activeSet((UIArmyCitySendOut.this.li.size() > 0 && Actions.sendProblem((LIST<Div>)UIArmyCitySendOut.this.li) == null));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void clickA() {
/*  72 */           for (UIArmyCitySendOut.Card c : UIArmyCitySendOut.this.current) {
/*  73 */             if (UIArmyCitySendOut.this.army.divs().canAdd() && c.selectedIs() && (c.div()).info.men() > 0 && AD.cityDivs().attachedArmy(c.div()) == null) {
/*  74 */               AD.cityDivs().attach(UIArmyCitySendOut.this.army, c.div());
/*     */             }
/*     */           } 
/*     */           
/*  78 */           (VIEW.inters()).popup.close();
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  83 */           Actions.hoverSendOutProblem((LIST<Div>)UIArmyCitySendOut.this.li, text);
/*  84 */           super.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */     
/*  88 */     s.add((RENDEROBJ)but);
/*  89 */     but = new GButt.ButtPanel((SPRITE)(UI.icons()).m.fast_forw)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  93 */           (SETT.BATTLE()).info.sendOutWithoutTraining(!(SETT.BATTLE()).info.sendOutWithoutTraining());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/*  98 */           selectedSet((SETT.BATTLE()).info.sendOutWithoutTraining());
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 105 */     but.hoverInfoSet(Dic.¤¤SendOutArmyToggleD);
/* 106 */     s.addRightC(0, (RENDEROBJ)but);
/*     */     
/* 108 */     addRelBody(16, DIR.S, (RENDEROBJ)s);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(WArmy a) {
/* 114 */     this.army = a;
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 119 */     init();
/* 120 */     if (!VIEW.world().isActive())
/* 121 */       (VIEW.inters()).popup.close(); 
/* 122 */     super.render(r, ds);
/*     */   }
/*     */   
/*     */   private void init() {
/* 126 */     this.current.clearSloppy();
/* 127 */     this.li.clearSloppy();
/* 128 */     for (Card c : this.cards) {
/*     */ 
/*     */       
/* 131 */       if ((c.div()).info.men() > 0 && AD.cityDivs().attachedArmy(c.div()) == null) {
/* 132 */         this.current.add(c);
/*     */         
/* 134 */         if (c.selectedIs())
/* 135 */           this.li.add(c.div()); 
/*     */         continue;
/*     */       } 
/* 138 */       c.selectedSet(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private RENDEROBJ row(final GETTER<Integer> ier) {
/* 144 */     GuiSection ss = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 148 */           int x1 = body().x1();
/* 149 */           int y1 = body().y1();
/* 150 */           clear();
/* 151 */           for (int i = 0; i < UIArmyCitySendOut.xs; i++) {
/* 152 */             int k = ((Integer)ier.get()).intValue() * UIArmyCitySendOut.xs + i;
/* 153 */             if (k >= UIArmyCitySendOut.this.current.size()) {
/*     */               break;
/*     */             }
/* 156 */             addRightC(0, (RENDEROBJ)UIArmyCitySendOut.this.current.get(k));
/*     */           } 
/*     */           
/* 159 */           body().moveX1Y1(x1, y1);
/* 160 */           body().setWidth((UIArmyCitySendOut.this.card.width() * UIArmyCitySendOut.xs));
/* 161 */           body().setHeight(UIArmyCitySendOut.this.card.height());
/* 162 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */     
/* 166 */     ss.body().setWidth((this.card.width() * xs));
/* 167 */     ss.body().setHeight(this.card.height());
/* 168 */     return (RENDEROBJ)ss;
/*     */   }
/*     */   
/*     */   private class Card
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/*     */     private final int di;
/*     */     
/*     */     Card(Div div) {
/* 177 */       super(UIArmyCitySendOut.this.card.width(), UIArmyCitySendOut.this.card.height());
/* 178 */       this.di = div.indexArmy();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 183 */       isActive = (UIDivCardWorld.supplyError((DIV_SIMPLE)div()) == null);
/* 184 */       UIArmyCitySendOut.this.card.render(r, this.body.x1(), this.body.y1(), 1, div(), isActive, isSelected, isHovered);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 190 */       (VIEW.UI()).div.settCivic.hover(text, div());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 196 */       selectedSet(!selectedIs());
/*     */     }
/*     */     
/*     */     public Div div() {
/* 200 */       return (Div)GAME.ARMIES().player().ordered().get(this.di);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\UIArmyCitySendOut.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */