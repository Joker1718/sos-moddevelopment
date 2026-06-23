/*     */ package settlement.room.military.supply;
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
/*     */ class null
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/*  78 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void renAction() {
/*  82 */     selectedSet(((SupplyInstance)g.get()).fetching());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/*  87 */     ((SupplyInstance)g.get()).fetchingToggle();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  94 */     super.render(r, ds, isActive, isSelected, isHovered);
/*  95 */     if (((SupplyInstance)g.get()).fetching() && ((SupplyInstance)g.get()).coolFetch > 0) {
/*  96 */       (GCOLOR.UI()).SOSO.hovered.bind();
/*  97 */       (UI.icons()).s.alert.render(r, this.body.x1() + 6, this.body.y1() + 6);
/*  98 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 104 */     GBox b = (GBox)text;
/* 105 */     b.title(MoveDic.¤¤fetch);
/* 106 */     b.text(MoveDic.¤¤fetchD);
/* 107 */     b.NL();
/* 108 */     if (((SupplyInstance)g.get()).fetching() && ((SupplyInstance)g.get()).coolFetch > 0) {
/* 109 */       b.add((SPRITE)b.text().warnify().add(MoveDic.¤¤fetchProblem));
/*     */     }
/* 111 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\supply\Gui$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */