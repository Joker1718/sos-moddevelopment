/*     */ package settlement.room.infra.export;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 237 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void renAction() {
/* 241 */     selectedSet(((ExportInstance)g.get()).prio());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 246 */     ((ExportInstance)g.get()).prioSet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 253 */     super.render(r, ds, isActive, isSelected, isHovered);
/* 254 */     if (((ExportInstance)g.get()).resource() == null || ((ROOM_EXPORT)Gui.access$2(Gui.this)).prioFetchAvailable(((ExportInstance)g.get()).resource()) < 0 || (((ExportInstance)g.get()).prio() && ((ExportInstance)g.get()).coolFetch > -1)) {
/* 255 */       (GCOLOR.UI()).SOSO.hovered.bind();
/* 256 */       (UI.icons()).s.alert.render(r, this.body.x1() + 6, this.body.y1() + 6);
/* 257 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 263 */     GBox b = (GBox)text;
/* 264 */     b.title(MoveDic.¤¤prio);
/* 265 */     b.text(MoveDic.¤¤prioD);
/* 266 */     b.NL();
/* 267 */     b.text(Gui.¤¤prio);
/* 268 */     b.NL();
/*     */     
/* 270 */     if (((ExportInstance)g.get()).resource() == null) {
/* 271 */       b.add((SPRITE)b.text().warnify().add(Gui.¤¤NoResource));
/* 272 */     } else if (((ROOM_EXPORT)Gui.access$2(Gui.this)).prioFetchAvailable(((ExportInstance)g.get()).resource()) < 0) {
/* 273 */       b.add((SPRITE)b.text().warnify().add(Gui.¤¤prioProb));
/* 274 */     } else if (((ExportInstance)g.get()).prio() && ((ExportInstance)g.get()).coolFetch > -1) {
/* 275 */       b.add((SPRITE)b.text().warnify().add(MoveDic.¤¤fetchProblem));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\export\Gui$7.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */