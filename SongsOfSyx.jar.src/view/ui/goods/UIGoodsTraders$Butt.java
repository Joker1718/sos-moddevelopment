/*     */ package view.ui.goods;
/*     */ 
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
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
/*     */ class Butt
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private final GETTER<Integer> ier;
/*     */   
/*     */   Butt(GETTER<Integer> ier) {
/*  70 */     this.body.setDim(96.0D, 32.0D);
/*  71 */     this.ier = ier;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  77 */     FactionNPC f = UIGoodsTraders.this.facs[((Integer)this.ier.get()).intValue()];
/*     */     
/*  79 */     isSelected |= (DIP.get(f)).trades;
/*     */     
/*  81 */     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/*  82 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */     
/*  84 */     (f.banner()).MEDIUM.renderCY(r, this.body.x1() + 4, this.body.cY());
/*     */     
/*  86 */     UIGoodsTraders.this.buttPrice.clear();
/*  87 */     GFORMAT.i(UIGoodsTraders.this.buttPrice, UIGoodsTraders.this.price(f));
/*  88 */     UIGoodsTraders.this.buttPrice.adjustWidth();
/*     */     
/*  90 */     UIGoodsTraders.this.buttPrice.renderCY(r, this.body.x1() + 4 + 24 + 4, this.body.cY());
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/*  95 */     FactionNPC f = UIGoodsTraders.this.facs[((Integer)this.ier.get()).intValue()];
/*  96 */     (VIEW.world()).UI.factions.hover(text, (Faction)f);
/*  97 */     GBox b = (GBox)text;
/*     */     
/*  99 */     b.sep();
/*     */     
/* 101 */     b.textLL(Dic.¤¤Price);
/* 102 */     b.tab(6).add((SPRITE)GFORMAT.i(b.text(), UIGoodsTraders.this.price(f)));
/* 103 */     b.NL(8);
/* 104 */     if ((DIP.get(f)).trades) {
/* 105 */       b.text(UIGoodsTraders.¤¤TradeYes);
/*     */     } else {
/* 107 */       b.text(UIGoodsTraders.¤¤TradeNo);
/* 108 */     }  b.NL(4);
/* 109 */     b.text(UIGoodsTraders.¤¤Click);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 114 */     FactionNPC f = UIGoodsTraders.this.facs[((Integer)this.ier.get()).intValue()];
/* 115 */     if (!(DIP.get(f)).trades && ROPINION.get(f) >= (DIP.TRADE()).opinionNeeded) {
/* 116 */       (VIEW.world()).UI.factions.openTrade(f);
/*     */     } else {
/* 118 */       (VIEW.world()).UI.factions.openDip(f);
/* 119 */     }  (VIEW.UI()).manager.close();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\goods\UIGoodsTraders$Butt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */