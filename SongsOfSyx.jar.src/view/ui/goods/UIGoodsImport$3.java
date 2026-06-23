/*     */ package view.ui.goods;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.diplomacy.deal.DealParty;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TRADABLE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
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
/*     */ class null
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(CharSequence $anonymous0) {
/* 116 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 120 */     int i = isActive & (((FACTIONS.player()).trade.pricesBuy.get((MAPPED)UIGoodsImport.this.res.get()) > 0) ? 1 : 0);
/* 121 */     super.render(r, ds, i, isSelected, isHovered);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 126 */     FactionNPC f = best();
/*     */     
/* 128 */     if (f != null) {
/* 129 */       (VIEW.inters()).popup.close();
/* 130 */       (VIEW.UI()).manager.close();
/* 131 */       (VIEW.world()).UI.factions.openBuy(f, (TRADABLE)UIGoodsImport.this.res.get());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 137 */     super.hoverInfoGet(text);
/* 138 */     GBox b = (GBox)text;
/* 139 */     b.NL(8);
/* 140 */     CharSequence p = FACTIONS.player().buyer((TRADABLE)UIGoodsImport.this.res.get()).problem();
/* 141 */     if (p != null) {
/* 142 */       b.error(p);
/*     */     }
/* 144 */     b.NL();
/*     */     
/* 146 */     FactionNPC f = best();
/*     */     
/* 148 */     if (f != null) {
/* 149 */       b.add((f.banner()).MEDIUM);
/* 150 */       b.textLL((CharSequence)f.name);
/* 151 */       b.add((SPRITE)(UI.icons()).s.money);
/* 152 */       b.add((SPRITE)GFORMAT.i(b.text(), DealParty.manualPriceSell(f, (TRADABLE)UIGoodsImport.this.res.get(), 1)));
/* 153 */       b.NL();
/*     */     } 
/*     */   }
/*     */   
/*     */   private FactionNPC best() {
/* 158 */     FactionNPC f = null;
/* 159 */     int pp = Integer.MAX_VALUE;
/*     */     
/* 161 */     for (int fi = 0; fi < FACTIONS.NPCs().size(); fi++) {
/* 162 */       FactionNPC ff = (FactionNPC)FACTIONS.NPCs().get(fi);
/* 163 */       int p = DealParty.manualPriceSell(ff, (TRADABLE)UIGoodsImport.this.res.get(), 1);
/* 164 */       if (p > 0 && ff.seller((TRADABLE)UIGoodsImport.this.res.get()).removeMax() > 0 && p < pp) {
/* 165 */         pp = p;
/* 166 */         f = ff;
/*     */       } 
/*     */     } 
/* 169 */     return f;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\goods\UIGoodsImport$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */