/*    */ package game.battle.formation;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.CORE;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.rendering.RenderData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class DivRenderer
/*    */ {
/*    */   public static void render(SPRITE_RENDERER ren, DivFormation p, RenderData data) {
/* 20 */     render(ren, p, data, 0, 0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void render(SPRITE_RENDERER ren, DivFormation p, RenderData data, int offX, int offY) {
/* 26 */     if (p == null) {
/*    */       return;
/*    */     }
/* 29 */     int men = p.deployed();
/*    */     
/* 31 */     if (men == 0) {
/*    */       return;
/*    */     }
/* 34 */     if (!p.body().touches(data.gBounds())) {
/*    */       return;
/*    */     }
/*    */     
/* 38 */     int ox = data.offX1() + 32 + offX;
/* 39 */     int oy = data.offY1() + 32 + offY;
/*    */ 
/*    */ 
/*    */     
/* 43 */     for (int i = 0; i < men; i++) {
/*    */       
/* 45 */       int rx = p.px(i) - ox;
/* 46 */       int ry = p.py(i) - oy;
/* 47 */       if (CORE.renderer().getZoomout() < 3) {
/* 48 */         DIR d = p.dir();
/* 49 */         SPRITE s = (SPRITE)(SPRITES.cons()).ICO.arrows2.get(d.id());
/* 50 */         rx -= 16 * d.x();
/* 51 */         ry -= 16 * d.y();
/* 52 */         s.render(ren, rx, ry);
/*    */       } else {
/* 54 */         int m = p.dirMaskOrtho(i);
/* 55 */         (SPRITES.cons()).BIG.dots.render(ren, m, rx, ry);
/*    */       } 
/*    */     } 
/*    */     
/* 59 */     ox -= 32;
/* 60 */     oy -= 32;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\formation\DivRenderer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */