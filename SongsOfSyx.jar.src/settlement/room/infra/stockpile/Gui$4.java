/*     */ package settlement.room.infra.stockpile;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.room.infra.logistics.MoveDic;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   null(SPRITE $anonymous0) {
/* 145 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void renAction() {
/* 149 */     selectedSet(((StockpileInstance)g.get()).prioritizing());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 154 */     ((StockpileInstance)g.get()).prioritizeToggle();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 161 */     super.render(r, ds, isActive, isSelected, isHovered);
/* 162 */     if (((StockpileInstance)g.get()).prioritizing() && ((StockpileInstance)g.get()).coolFetch > -1) {
/* 163 */       (GCOLOR.UI()).SOSO.hovered.bind();
/* 164 */       (UI.icons()).s.alert.render(r, this.body.x1() + 6, this.body.y1() + 6);
/* 165 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 171 */     GBox b = (GBox)text;
/* 172 */     b.title(MoveDic.¤¤prio);
/* 173 */     b.text(MoveDic.¤¤prioD);
/* 174 */     b.NL();
/* 175 */     if (((StockpileInstance)g.get()).prioritizing() && ((StockpileInstance)g.get()).coolFetch > -1)
/* 176 */       b.add((SPRITE)b.text().warnify().add(MoveDic.¤¤fetchProblem)); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\stockpile\Gui$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */