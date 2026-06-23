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
/*     */ class null
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/* 105 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void renAction() {
/* 109 */     selectedSet(((StockpileInstance)g.get()).fetching());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 114 */     ((StockpileInstance)g.get()).fetchingSet(!((StockpileInstance)g.get()).fetching());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 121 */     super.render(r, ds, isActive, isSelected, isHovered);
/* 122 */     if (((StockpileInstance)g.get()).fetching() && ((StockpileInstance)g.get()).coolFetch > -1) {
/* 123 */       (GCOLOR.UI()).SOSO.hovered.bind();
/* 124 */       (UI.icons()).s.alert.render(r, this.body.x1() + 6, this.body.y1() + 6);
/* 125 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 131 */     GBox b = (GBox)text;
/* 132 */     b.title(MoveDic.¤¤fetch);
/* 133 */     b.text(MoveDic.¤¤fetchD);
/* 134 */     b.NL();
/* 135 */     if (((StockpileInstance)g.get()).fetching() && ((StockpileInstance)g.get()).coolFetch > -1) {
/* 136 */       b.add((SPRITE)b.text().warnify().add(MoveDic.¤¤fetchProblem));
/*     */     }
/* 138 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\stockpile\Gui$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */