/*    */ package world.map.road;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
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
/* 45 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 49 */     if (GenPort.this.port.is(it.tile())) {
/* 50 */       if (GenPort.this.oldPort.is(it.tile())) {
/* 51 */         COLOR.REDISH.bind();
/*    */       } else {
/* 53 */         COLOR.ORANGE100.bind();
/* 54 */       }  (SPRITES.cons()).ICO.crosshair.render(r, it.x(), it.y());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\road\GenPort$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */