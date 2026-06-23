/*    */ package world.map.road;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.map.MAP_BOOLEAN;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends WorldOverlays.OverlayTile
/*    */ {
/*    */   null(boolean $anonymous0, boolean $anonymous1) {
/* 26 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 30 */     if (marked.is(it.tile())) {
/* 31 */       COLOR.BLUEISH.bind();
/* 32 */       (SPRITES.cons()).ICO.crosshair.render(r, it.x(), it.y());
/* 33 */       COLOR.unbind();
/* 34 */     } else if (bridge.is(it.tile())) {
/* 35 */       COLOR.ORANGE100.bind();
/* 36 */       (SPRITES.cons()).BIG.line.render(r, 0, it.x(), it.y());
/* 37 */       COLOR.unbind();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\road\GenPortBuild$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */