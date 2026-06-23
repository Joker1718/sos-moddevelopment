/*    */ package view.sett.ui.subject;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.colors.GCOLOR;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.panel.GFrame;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends HOVERABLE.HoverableAbs
/*    */ {
/*    */   null(int $anonymous0, int $anonymous1) {
/* 29 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 33 */     (a.a.indu().hType()).color.render(r, (RECTANGLE)body());
/* 34 */     GFrame.render(r, body().x1(), body().x2(), body().y1(), body().y2());
/*    */     
/* 36 */     STATS.APPEARANCE().portraitRender(r, a.a.indu(), this.body.x1() + 8, body().y1() + 8, 4);
/*    */ 
/*    */     
/* 39 */     OPACITY.O25TO100.bind();
/* 40 */     if (SProblem.problem(a.a) != null) {
/* 41 */       (GCOLOR.UI()).BAD.hovered.bind();
/* 42 */       (UI.icons()).s.flag.renderScaled(r, body().x1() + 8, body().y1() + 8, 2);
/*    */     }
/* 44 */     else if (SProblem.warning(a.a) != null) {
/* 45 */       (GCOLOR.UI()).SOSO.hovered.bind();
/* 46 */       (UI.icons()).s.flag.renderScaled(r, body().x1() + 8, body().y1() + 8, 2);
/*    */     } 
/* 48 */     OPACITY.unbind();
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 53 */     GBox b = (GBox)text;
/* 54 */     if (SProblem.problem(a.a) != null) {
/* 55 */       b.add((SPRITE)b.text().errorify().add(SProblem.problem(a.a)));
/*    */     
/*    */     }
/* 58 */     else if (SProblem.warning(a.a) != null) {
/* 59 */       b.add((SPRITE)b.text().warnify().add(SProblem.warning(a.a)));
/*    */     } 
/* 61 */     super.hoverInfoGet(text);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectInfo$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */