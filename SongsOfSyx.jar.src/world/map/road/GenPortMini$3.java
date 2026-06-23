/*    */ package world.map.road;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.map.MAP_BOOLEANE;
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
/* 38 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 42 */     if (marked.is(it.tile())) {
/* 43 */       COLOR.BLUEISH.bind();
/* 44 */       (SPRITES.cons()).ICO.crosshair.render(r, it.x(), it.y());
/* 45 */       COLOR.unbind();
/* 46 */     } else if (GenPortMini.this.debug.is(it.tile())) {
/* 47 */       COLOR.ORANGE100.bind();
/* 48 */       (SPRITES.cons()).BIG.line.render(r, 0, it.x(), it.y());
/* 49 */       COLOR.unbind();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\road\GenPortMini$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */