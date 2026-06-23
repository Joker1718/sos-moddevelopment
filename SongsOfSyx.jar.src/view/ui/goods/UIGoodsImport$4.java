/*     */ package view.ui.goods;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.trade.TRADABLE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.keymap.MAPPED;
/*     */ import view.main.VIEW;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 179 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 184 */     int i = isActive & (((FACTIONS.player()).trade.pricesBuy.get((MAPPED)UIGoodsImport.this.res.get()) > 0) ? 1 : 0);
/* 185 */     super.render(r, ds, i, isSelected, isHovered);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 190 */     FactionNPC f = null;
/* 191 */     int pp = Integer.MAX_VALUE;
/* 192 */     for (Faction fff : DIP.traders()) {
/* 193 */       FactionNPC ff = (FactionNPC)fff;
/* 194 */       int p = RD.DIST().distance((Faction)ff);
/* 195 */       if (ff.res((TRADABLE)UIGoodsImport.this.res.get()).priceSellP() > 0 && ff.seller((TRADABLE)UIGoodsImport.this.res.get()).removeMax() > 0 && p < pp) {
/* 196 */         pp = p;
/* 197 */         f = ff;
/*     */       } 
/*     */     } 
/* 200 */     if (f != null) {
/* 201 */       (VIEW.inters()).popup.close();
/* 202 */       (VIEW.UI()).manager.close();
/* 203 */       (VIEW.world()).UI.factions.openBuy(f, (TRADABLE)UIGoodsImport.this.res.get());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 209 */     super.hoverInfoGet(text);
/* 210 */     GBox b = (GBox)text;
/* 211 */     b.NL(8);
/* 212 */     CharSequence p = FACTIONS.player().buyer((TRADABLE)UIGoodsImport.this.res.get()).problem();
/* 213 */     if (p != null)
/* 214 */       b.error(p); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\goods\UIGoodsImport$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */