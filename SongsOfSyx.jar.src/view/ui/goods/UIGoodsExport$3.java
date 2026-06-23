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
/*     */ class null
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(CharSequence $anonymous0) {
/*  99 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 103 */     int i = isActive & (((FACTIONS.player()).trade.pricesSell.get((MAPPED)UIGoodsExport.this.res.get()) > 0 && ((TRADABLE)UIGoodsExport.this.res.get()).ps().playerOwned() > 0) ? 1 : 0);
/* 104 */     super.render(r, ds, i, isSelected, isHovered);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 109 */     FactionNPC f = best();
/*     */     
/* 111 */     if (f != null) {
/* 112 */       (VIEW.inters()).popup.close();
/* 113 */       (VIEW.UI()).manager.close();
/* 114 */       (VIEW.world()).UI.factions.openSell(f, (TRADABLE)UIGoodsExport.this.res.get());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 120 */     super.hoverInfoGet(text);
/* 121 */     GBox b = (GBox)text;
/* 122 */     b.NL(8);
/* 123 */     CharSequence p = FACTIONS.player().seller((TRADABLE)UIGoodsExport.this.res.get()).problem();
/* 124 */     if (p != null)
/* 125 */       b.error(p); 
/* 126 */     b.NL();
/* 127 */     FactionNPC f = best();
/*     */     
/* 129 */     if (f != null) {
/* 130 */       b.add((f.banner()).MEDIUM);
/* 131 */       b.textLL((CharSequence)f.name);
/* 132 */       b.add((SPRITE)(UI.icons()).s.money);
/* 133 */       b.add((SPRITE)GFORMAT.i(b.text(), DealParty.manualPriceBuy(f, (TRADABLE)UIGoodsExport.this.res.get(), 1)));
/* 134 */       b.NL();
/*     */     } 
/*     */   }
/*     */   
/*     */   private FactionNPC best() {
/* 139 */     FactionNPC f = null;
/* 140 */     int pp = 0;
/*     */     
/* 142 */     for (int fi = 0; fi < FACTIONS.NPCs().size(); fi++) {
/* 143 */       FactionNPC ff = (FactionNPC)FACTIONS.NPCs().get(fi);
/* 144 */       int p = DealParty.manualPriceBuy(ff, (TRADABLE)UIGoodsExport.this.res.get(), 1);
/* 145 */       if (p > 0 && p > pp) {
/* 146 */         pp = p;
/* 147 */         f = ff;
/*     */       } 
/*     */     } 
/* 150 */     return f;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\goods\UIGoodsExport$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */