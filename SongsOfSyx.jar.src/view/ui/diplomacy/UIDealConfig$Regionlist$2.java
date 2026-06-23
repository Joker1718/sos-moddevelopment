/*     */ package view.ui.diplomacy;
/*     */ 
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.deal.DealParty;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.common.UIPickerRegion;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends UIPickerRegion
/*     */ {
/*     */   null(GETTER<? extends Faction> $anonymous0, int $anonymous1) {
/* 141 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected void toggle(Region reg) {
/* 145 */     p.regs.select(reg, !p.regs.selected(reg));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean active(Region reg) {
/* 150 */     return p.regs.selecteCan(reg);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean selected(Region reg) {
/* 155 */     return p.regs.selected(reg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hoverInfo(GBox b, Region reg) {
/* 161 */     b.add((SPRITE)(UI.icons()).s.money);
/* 162 */     b.add((SPRITE)GFORMAT.i(b.text(), p.regs.value(reg)));
/* 163 */     b.NL(8);
/*     */     
/* 165 */     super.hoverInfo(b, reg);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\diplomacy\UIDealConfig$Regionlist$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */