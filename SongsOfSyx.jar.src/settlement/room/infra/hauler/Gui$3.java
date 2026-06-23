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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 118 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void renAction() {
/* 122 */     selectedSet(((HaulerInstance)g.get()).prio());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 127 */     ((HaulerInstance)g.get()).prioSet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 134 */     super.render(r, ds, isActive, isSelected, isHovered);
/* 135 */     if (((HaulerInstance)g.get()).prio() && ((HaulerInstance)g.get()).coolFetch > -1) {
/* 136 */       (GCOLOR.UI()).SOSO.hovered.bind();
/* 137 */       (UI.icons()).s.alert.render(r, this.body.x1() + 6, this.body.y1() + 6);
/* 138 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 144 */     GBox b = (GBox)text;
/* 145 */     b.title(MoveDic.¤¤prio);
/* 146 */     b.text(MoveDic.¤¤prioD);
/* 147 */     b.NL();
/* 148 */     if (((HaulerInstance)g.get()).prio() && ((HaulerInstance)g.get()).coolFetch > -1)
/* 149 */       b.add((SPRITE)b.text().warnify().add(MoveDic.¤¤fetchProblem)); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\hauler\Gui$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */