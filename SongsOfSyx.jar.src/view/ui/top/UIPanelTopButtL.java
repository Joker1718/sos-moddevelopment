/*    */ package view.ui.top;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GStat;
/*    */ 
/*    */ public abstract class UIPanelTopButtL
/*    */   extends UIPanelTopButtAbs {
/*    */   public UIPanelTopButtL(SPRITE icon) {
/* 12 */     super(icon, 60, 48);
/*    */   }
/*    */ 
/*    */   
/*    */   void render(SPRITE_RENDERER r, SPRITE label, GStat stat, boolean active) {
/* 17 */     COLOR.BLACK.bind();
/* 18 */     label.renderC(r, body().cX() + 1, this.body.y1() + 17);
/* 19 */     COLOR.unbind();
/* 20 */     label.renderC(r, body().cX(), this.body.y1() + 16);
/*    */     
/* 22 */     if (active) {
/* 23 */       OPACITY.O50.bind();
/*    */       
/* 25 */       int w = stat.width();
/*    */       
/* 27 */       int y2 = this.body.y2() - 6;
/* 28 */       int y1 = y2 - stat.height();
/*    */       
/* 30 */       int x1 = this.body.cX() - w / 2;
/* 31 */       int x2 = x1 + w;
/*    */       
/* 33 */       COLOR.BLACK.render(r, x1 - 2, 
/* 34 */           x2 + 2, y1 - 1, y2 + 1);
/* 35 */       OPACITY.unbind();
/* 36 */       stat.render(r, x1, y1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\top\UIPanelTopButtL.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */