/*    */ package view.world.ui.battle;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import util.colors.GCOLOR;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GuiSection
/*    */ {
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 62 */     super.render(r, ds);
/* 63 */     Battle.this.hovRetreat = false;
/* 64 */     Battle.this.hovAuto = false;
/* 65 */     CharSequence title = Battle.this.title(Battle.this.g);
/* 66 */     int w = (UI.FONT()).H2.width(title);
/* 67 */     (UI.PANEL()).titleBoxes[1].renderCY(r, body().cX() - w / 2, body().y1() - 16, w);
/* 68 */     (GCOLOR.T()).H1.bind();
/* 69 */     (UI.FONT()).H2.renderC(r, body().cX(), body().y1() - 16, title);
/* 70 */     COLOR.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\Battle$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */