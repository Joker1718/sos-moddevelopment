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
/*     */ class null
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(CharSequence $anonymous0) {
/* 158 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 163 */     int i = isActive & (((FACTIONS.player()).trade.pricesSell.get((MAPPED)UIGoodsExport.this.res.get()) > 0 && ((TRADABLE)UIGoodsExport.this.res.get()).ps().playerOwned() > 0) ? 1 : 0);
/* 164 */     super.render(r, ds, i, isSelected, isHovered);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 169 */     FactionNPC f = null;
/* 170 */     int pp = Integer.MAX_VALUE;
/* 171 */     for (Faction fff : DIP.traders()) {
/* 172 */       FactionNPC ff = (FactionNPC)fff;
/* 173 */       int p = RD.DIST().distance((Faction)ff);
/* 174 */       if (ff.res((TRADABLE)UIGoodsExport.this.res.get()).priceSellP() > 0 && p < pp) {
/* 175 */         pp = p;
/* 176 */         f = ff;
/*     */       } 
/*     */     } 
/* 179 */     if (f != null) {
/* 180 */       (VIEW.inters()).popup.close();
/* 181 */       (VIEW.UI()).manager.close();
/* 182 */       (VIEW.world()).UI.factions.openSell(f, (TRADABLE)UIGoodsExport.this.res.get());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 188 */     super.hoverInfoGet(text);
/* 189 */     GBox b = (GBox)text;
/* 190 */     b.NL(8);
/* 191 */     CharSequence p = FACTIONS.player().seller((TRADABLE)UIGoodsExport.this.res.get()).problem();
/* 192 */     if (p != null)
/* 193 */       b.error(p); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\goods\UIGoodsExport$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */