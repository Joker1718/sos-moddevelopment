/*    */ package world.map.pathing;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ import world.WORLD;
/*    */ import world.overlay.WorldOverlays;
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
/*    */   extends WorldOverlays.OverlayTile
/*    */ {
/*    */   null(boolean $anonymous0, boolean $anonymous1) {
/* 25 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 30 */     if ((WORLD.PATH()).map.is.is(it.tile())) {
/* 31 */       COLOR.ORANGE100.bind();
/* 32 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 33 */         DIR d = (DIR)DIR.ALL.get(di);
/* 34 */         if ((WORLD.PATH()).map.can(it.tx(), it.ty(), d))
/* 35 */           ((SPRITE)(SPRITES.cons()).ICO.arrows2.get(d.id())).render(r, it.x(), 
/* 36 */               it.y()); 
/*    */       } 
/* 38 */       COLOR.unbind();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\Gen$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */