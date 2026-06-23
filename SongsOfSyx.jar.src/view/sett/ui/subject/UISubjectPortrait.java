/*    */ package view.sett.ui.subject;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import init.type.HTYPE;
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
/*    */ final class UISubjectPortrait extends HOVERABLE.HoverableAbs {
/*    */   private final AInfo a;
/*    */   
/*    */   UISubjectPortrait(AInfo a, HTYPE t) {
/* 20 */     super(176, 272);
/* 21 */     this.a = a;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 27 */     (this.a.a.indu().hType()).color.render(r, (RECTANGLE)body());
/* 28 */     GFrame.render(r, body().x1(), body().x2(), body().y1(), body().y2());
/*    */     
/* 30 */     STATS.APPEARANCE().portraitRender(r, this.a.a.indu(), this.body.x1() + 8, body().y1() + 8, 4);
/*    */ 
/*    */     
/* 33 */     OPACITY.O25TO100.bind();
/* 34 */     if (SProblem.problem(this.a.a) != null) {
/* 35 */       (GCOLOR.UI()).BAD.hovered.bind();
/* 36 */       (UI.icons()).s.flag.renderScaled(r, body().x1() + 8, body().y1() + 8, 2);
/*    */     }
/* 38 */     else if (SProblem.warning(this.a.a) != null) {
/* 39 */       (GCOLOR.UI()).SOSO.hovered.bind();
/* 40 */       (UI.icons()).s.flag.renderScaled(r, body().x1() + 8, body().y1() + 8, 2);
/*    */     } 
/* 42 */     OPACITY.unbind();
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 47 */     GBox b = (GBox)text;
/* 48 */     if (SProblem.problem(this.a.a) != null) {
/* 49 */       b.add((SPRITE)b.text().errorify().add(SProblem.problem(this.a.a)));
/*    */     
/*    */     }
/* 52 */     else if (SProblem.warning(this.a.a) != null) {
/* 53 */       b.add((SPRITE)b.text().warnify().add(SProblem.warning(this.a.a)));
/*    */     } 
/* 55 */     super.hoverInfoGet(text);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectPortrait.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */