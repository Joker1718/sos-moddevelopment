/*     */ package settlement.room.infra.hauler;
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
/*     */ class null
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/*  77 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void renAction() {
/*  81 */     selectedSet(((HaulerInstance)g.get()).fetching());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/*  86 */     ((HaulerInstance)g.get()).fetchingSet(!((HaulerInstance)g.get()).fetching());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  93 */     super.render(r, ds, isActive, isSelected, isHovered);
/*  94 */     if (((HaulerInstance)g.get()).fetching() && ((HaulerInstance)g.get()).coolFetch > -1) {
/*  95 */       (GCOLOR.UI()).SOSO.hovered.bind();
/*  96 */       (UI.icons()).s.alert.render(r, this.body.x1() + 6, this.body.y1() + 6);
/*  97 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 103 */     GBox b = (GBox)text;
/* 104 */     b.title(MoveDic.¤¤fetch);
/* 105 */     b.text(MoveDic.¤¤fetchD);
/* 106 */     b.NL();
/* 107 */     if (((HaulerInstance)g.get()).fetching() && ((HaulerInstance)g.get()).coolFetch > -1) {
/* 108 */       b.add((SPRITE)b.text().warnify().add(MoveDic.¤¤fetchProblem));
/*     */     }
/* 110 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\hauler\Gui$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */