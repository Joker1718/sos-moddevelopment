/*     */ package view.world.ui.army;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import init.constant.Config;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import world.army.AD;
/*     */ import world.army.WDIV;
/*     */ import world.army.WDivMercenary;
/*     */ 
/*     */ class UIMerenaries {
/*  37 */   private static CharSequence ¤¤intro = "Captain {0}'s";
/*     */   
/*     */   static {
/*  40 */     D.ts(UIMerenaries.class);
/*     */   }
/*     */   
/*  43 */   private int max = AD.mercenaries().size();
/*  44 */   private final Card[] cards = new Card[AD.mercenaries().size()];
/*  45 */   private final ArrayList<Card> active = new ArrayList(this.cards.length);
/*  46 */   private GuiSection scards = new GuiSection();
/*  47 */   private final GuiSection section = new GuiSection()
/*     */     {
/*     */       public void render(SPRITE_RENDERER r, float ds) {
/*  50 */         UIMerenaries.this.arrange();
/*  51 */         super.render(r, ds);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   private static int xs = 10;
/*  59 */   private int width = 100;
/*  60 */   private int height = 172;
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
/*     */   private GText tmp;
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
/*     */   public void arrange() {
/* 138 */     this.active.clearSloppy();
/* 139 */     int max = AD.mercenaries().max();
/* 140 */     for (int i = 0; i < max; i++) {
/* 141 */       WDivMercenary d = AD.mercenaries().get(i);
/* 142 */       if (d.army() == null)
/*     */       {
/* 144 */         if (d.men() != 0)
/*     */         {
/* 146 */           if (!d.disbanded())
/*     */           {
/* 148 */             this.active.add(this.cards[i]);
/*     */           }
/*     */         }
/*     */       }
/*     */     } 
/* 153 */     int x1 = this.scards.body().x1();
/* 154 */     int y1 = this.scards.body().y1();
/* 155 */     this.scards.clear();
/* 156 */     for (int j = 0; j < this.active.size(); j++) {
/* 157 */       Card c = (Card)this.active.get(j);
/* 158 */       this.scards.add((RENDEROBJ)c, j % xs * c.body().width(), j / xs * c.body().height());
/*     */     } 
/*     */     
/* 161 */     this.scards.body().moveX1Y1(x1, y1);
/*     */   }
/*     */   
/*     */   private int cost()
/*     */   {
/* 166 */     int am = 0;
/* 167 */     for (Card c : this.active) {
/* 168 */       if (c.selectedIs()) {
/* 169 */         am += AD.mercenaries().signingCost(c.ii);
/*     */       }
/*     */     } 
/* 172 */     return am; } public GuiSection get() {
/*     */     byte b;
/*     */     int i;
/*     */     Card[] arrayOfCard;
/* 176 */     for (i = (arrayOfCard = this.cards).length, b = 0; b < i; ) { Card c = arrayOfCard[b];
/* 177 */       c.selectedSet(false); b++; }
/* 178 */      arrange();
/* 179 */     return this.section;
/*     */   }
/*     */   
/* 182 */   UIMerenaries() { this.tmp = new GText((UI.FONT()).S, 8); for (int i = 0; i < AD.mercenaries().size(); i++) { Card c = new Card(i); this.cards[i] = c; }
/*     */      this.scards.body().setDim((xs * this.width), Math.ceil(this.max / xs) * this.height); this.section.add((RENDEROBJ)this.scards); GuiSection bb = new GuiSection(); bb.addRightC(8, (RENDEROBJ)(new GStat() { public void update(GText text) { GFORMAT.i(text, (int)FACTIONS.player().credits().credits()); } }
/*     */         ).hh(Dic.¤¤Currs)); bb.addRightC(64, (RENDEROBJ)(new GStat() { public void update(GText text) { int co = UIMerenaries.this.cost(); if (co > FACTIONS.player().credits().credits()) { text.errorify(); }
/*     */             else { text.normalify(); }
/*     */              GFORMAT.iIncr(text, -co); } }
/*     */         ).hh(Dic.¤¤Cost)); bb.addRightC(64, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Recruit) { protected void renAction() { activeSet((Army.army.added() && Army.army.divs().canAdd() && UIMerenaries.this.cost() > 0 && UIMerenaries.this.cost() <= FACTIONS.player().credits().credits())); } protected void clickA() { for (UIMerenaries.Card c : UIMerenaries.this.active) { if (c.selectedIs() && Army.army.divs().canAdd()) { int cost = AD.mercenaries().signingCost(c.ii); if (cost < FACTIONS.player().credits().credits()) {
/*     */                   c.div.reassign(Army.army); GAME.player().credits().inc(-AD.mercenaries().signingCost(c.ii), FCredits.CTYPE.MERCINARIES);
/*     */                 }  }
/*     */                }
/*     */              (VIEW.inters()).popup.close(); super.clickA(); } }
/*     */       ); if ((S.get()).developer)
/*     */       bb.addRightC(16, (RENDEROBJ)new GButt.ButtPanel("shuffle") { protected void clickA() { AD.mercenaries().debug(); } }
/*     */         );  this.section.addRelBody(8, DIR.S, (RENDEROBJ)bb); } private class Card extends CLICKABLE.ClickableAbs {
/* 195 */     private final int ii; Card(int ii) { this.title = (SPRITE)new SPRITE.Imp(400, 40)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 199 */             Str.TMP.clear().add(UIMerenaries.¤¤intro);
/* 200 */             Str.TMP.insert(0, STATS.APPEARANCE().name(UIMerenaries.Card.this.div.cheif()));
/* 201 */             (GCOLOR.T()).H1.bind();
/* 202 */             (UI.FONT()).H2.renderCX(r, X1 + (X2 - X1) / 2, Y1, (CharSequence)Str.TMP);
/* 203 */             (GCOLOR.T()).H2.bind();
/* 204 */             (UI.FONT()).M.renderCX(r, X1 + (X2 - X1) / 2, Y1 + 18, UIMerenaries.Card.this.div.name());
/*     */           }
/*     */         };
/*     */       this.ii = ii;
/*     */       this.div = AD.mercenaries().get(ii);
/*     */       this.body.setDim(UIMerenaries.this.width, UIMerenaries.this.height); }
/*     */      private final WDivMercenary div; private SPRITE title; protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 211 */       isActive = (AD.mercenaries().signingCost(this.ii) <= FACTIONS.player().credits().credits());
/* 212 */       GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 213 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */       
/* 215 */       STATS.APPEARANCE().portraitRender(r, this.div.cheif(), this.body.x1() + 10, this.body.y1(), 2);
/* 216 */       ((SPRITE)(this.div.cheif().race().appearance()).crown.merc().getC(STATS.RAN().get(this.div.cheif(), 9))).renderScaled(r, this.body.x1() + 10, this.body.y1() + 8, 2);
/*     */       
/* 218 */       this.div.banner().renderSymbol(r, this.body.x1() + 4, this.body.y1() + 8, 1);
/*     */ 
/*     */ 
/*     */       
/* 222 */       int y2 = this.body.y1() + 128 + 4;
/* 223 */       GMeter.render(r, GMeter.C_GRAY, this.div.men() / (Config.battle()).MEN_PER_DIVISION, this.body.x1() + 6, this.body.x2() - 6, y2, y2 + 8);
/*     */       
/* 225 */       y2 += 10;
/*     */       
/* 227 */       int tot = 0;
/* 228 */       for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/* 229 */         tot = (int)(tot + Math.ceil((this.div.equipI(e) / 3)));
/*     */       }
/*     */       
/* 232 */       int i = this.body.cX() - tot * 10 / 2;
/*     */       
/* 234 */       for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/* 235 */         int am = (int)Math.ceil((this.div.equipI(e) / 3));
/* 236 */         for (int j = 0; j < am; j++) {
/* 237 */           (e.resource.icon()).small.render(r, i, y2);
/* 238 */           i += 10;
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 244 */       y2 += 12;
/*     */       
/* 246 */       UIMerenaries.this.tmp.clear();
/* 247 */       GFORMAT.i(UIMerenaries.this.tmp, AD.mercenaries().signingCost(this.ii));
/* 248 */       UIMerenaries.this.tmp.adjustWidth();
/* 249 */       if ((UIMerenaries.this.cost() + AD.mercenaries().signingCost(this.ii)) > FACTIONS.player().credits().credits()) {
/* 250 */         UIMerenaries.this.tmp.errorify();
/*     */       } else {
/* 252 */         UIMerenaries.this.tmp.normalify();
/* 253 */       }  UIMerenaries.this.tmp.adjustWidth();
/* 254 */       OPACITY.O50.bind();
/* 255 */       int x1 = this.body.cX() - UIMerenaries.this.tmp.width() / 2;
/* 256 */       COLOR.BLACK.render(r, x1 - 1, x1 + UIMerenaries.this.tmp.width() + 2, y2 - 1, y2 + 18);
/* 257 */       OPACITY.unbind();
/* 258 */       UIMerenaries.this.tmp.render(r, x1, y2);
/*     */       
/* 260 */       (VIEW.UI()).div.renderPower(this.body.x2() - 18, this.body.y1() + 6, r, this.div.provess());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 266 */       text.add(this.title);
/* 267 */       text.NL();
/* 268 */       (VIEW.UI()).div.world.hover((WDIV)this.div, text);
/* 269 */       text.title(null);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 274 */       selectedToggle();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\army\UIMerenaries.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */