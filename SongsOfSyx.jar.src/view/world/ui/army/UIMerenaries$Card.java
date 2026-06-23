/*     */ package view.world.ui.army;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.constant.Config;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.info.GFORMAT;
/*     */ import view.main.VIEW;
/*     */ import world.army.AD;
/*     */ import world.army.WDIV;
/*     */ import world.army.WDivMercenary;
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
/*     */ class Card
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private final int ii;
/*     */   private final WDivMercenary div;
/*     */   private SPRITE title;
/*     */   
/*     */   Card(int ii) {
/* 195 */     this.title = (SPRITE)new SPRITE.Imp(400, 40)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 199 */           Str.TMP.clear().add(UIMerenaries.¤¤intro);
/* 200 */           Str.TMP.insert(0, STATS.APPEARANCE().name(UIMerenaries.Card.this.div.cheif()));
/* 201 */           (GCOLOR.T()).H1.bind();
/* 202 */           (UI.FONT()).H2.renderCX(r, X1 + (X2 - X1) / 2, Y1, (CharSequence)Str.TMP);
/* 203 */           (GCOLOR.T()).H2.bind();
/* 204 */           (UI.FONT()).M.renderCX(r, X1 + (X2 - X1) / 2, Y1 + 18, UIMerenaries.Card.this.div.name());
/*     */         }
/*     */       };
/*     */     this.ii = ii;
/*     */     this.div = AD.mercenaries().get(ii);
/*     */     this.body.setDim(paramUIMerenaries.width, paramUIMerenaries.height);
/*     */   } protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 211 */     isActive = (AD.mercenaries().signingCost(this.ii) <= FACTIONS.player().credits().credits());
/* 212 */     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 213 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */     
/* 215 */     STATS.APPEARANCE().portraitRender(r, this.div.cheif(), this.body.x1() + 10, this.body.y1(), 2);
/* 216 */     ((SPRITE)(this.div.cheif().race().appearance()).crown.merc().getC(STATS.RAN().get(this.div.cheif(), 9))).renderScaled(r, this.body.x1() + 10, this.body.y1() + 8, 2);
/*     */     
/* 218 */     this.div.banner().renderSymbol(r, this.body.x1() + 4, this.body.y1() + 8, 1);
/*     */ 
/*     */ 
/*     */     
/* 222 */     int y2 = this.body.y1() + 128 + 4;
/* 223 */     GMeter.render(r, GMeter.C_GRAY, this.div.men() / (Config.battle()).MEN_PER_DIVISION, this.body.x1() + 6, this.body.x2() - 6, y2, y2 + 8);
/*     */     
/* 225 */     y2 += 10;
/*     */     
/* 227 */     int tot = 0;
/* 228 */     for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/* 229 */       tot = (int)(tot + Math.ceil((this.div.equipI(e) / 3)));
/*     */     }
/*     */     
/* 232 */     int i = this.body.cX() - tot * 10 / 2;
/*     */     
/* 234 */     for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/* 235 */       int am = (int)Math.ceil((this.div.equipI(e) / 3));
/* 236 */       for (int j = 0; j < am; j++) {
/* 237 */         (e.resource.icon()).small.render(r, i, y2);
/* 238 */         i += 10;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 244 */     y2 += 12;
/*     */     
/* 246 */     UIMerenaries.this.tmp.clear();
/* 247 */     GFORMAT.i(UIMerenaries.this.tmp, AD.mercenaries().signingCost(this.ii));
/* 248 */     UIMerenaries.this.tmp.adjustWidth();
/* 249 */     if ((UIMerenaries.this.cost() + AD.mercenaries().signingCost(this.ii)) > FACTIONS.player().credits().credits()) {
/* 250 */       UIMerenaries.this.tmp.errorify();
/*     */     } else {
/* 252 */       UIMerenaries.this.tmp.normalify();
/* 253 */     }  UIMerenaries.this.tmp.adjustWidth();
/* 254 */     OPACITY.O50.bind();
/* 255 */     int x1 = this.body.cX() - UIMerenaries.this.tmp.width() / 2;
/* 256 */     COLOR.BLACK.render(r, x1 - 1, x1 + UIMerenaries.this.tmp.width() + 2, y2 - 1, y2 + 18);
/* 257 */     OPACITY.unbind();
/* 258 */     UIMerenaries.this.tmp.render(r, x1, y2);
/*     */     
/* 260 */     (VIEW.UI()).div.renderPower(this.body.x2() - 18, this.body.y1() + 6, r, this.div.provess());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 266 */     text.add(this.title);
/* 267 */     text.NL();
/* 268 */     (VIEW.UI()).div.world.hover((WDIV)this.div, text);
/* 269 */     text.title(null);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 274 */     selectedToggle();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\army\UIMerenaries$Card.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */