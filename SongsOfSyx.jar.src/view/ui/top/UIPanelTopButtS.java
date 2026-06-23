/*    */ package view.ui.top;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GStat;
/*    */ 
/*    */ public abstract class UIPanelTopButtS
/*    */   extends UIPanelTopButtAbs
/*    */ {
/*    */   public UIPanelTopButtS(SPRITE icon) {
/* 14 */     super(icon, width(), 24);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, SPRITE label, GStat stat, boolean active) {
/* 19 */     label.renderCY(r, body().x1() + 4, this.body.cY());
/*    */     
/* 21 */     if (active) {
/* 22 */       OPACITY.O35.bind();
/* 23 */       stat.adjust();
/* 24 */       COLOR.BLACK.render(r, body().x1() + 4 + label.width() + 0, 
/* 25 */           body().x1() + 4 + label.width() + 2 + stat.width() + 2, this.body.y1() + 4, this.body.y2() - 4);
/* 26 */       OPACITY.unbind();
/* 27 */       stat.renderCY(r, body().x1() + 4 + label.width() + 2, this.body.cY());
/*    */     } 
/*    */   }
/*    */   
/*    */   public static int width() {
/* 32 */     return 16 + (UI.FONT()).S.height() * 4 - 6;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\top\UIPanelTopButtS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */