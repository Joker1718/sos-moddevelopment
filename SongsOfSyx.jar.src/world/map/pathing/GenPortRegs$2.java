/*    */ package world.map.pathing;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends WorldOverlays.OverlayTile
/*    */ {
/*    */   null(boolean $anonymous0, boolean $anonymous1) {
/* 28 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 32 */     if ((WORLD.WATER()).isBig.is(it.tile()) && GenPortRegs.this.get(it.tile()) >= 0) {
/* 33 */       ((COLOR)COLOR.UNIQUE.getC(GenPortRegs.this.get(it.tile()))).bind();
/* 34 */       (SPRITES.cons()).BIG.outline.render(r, 0, it.x(), it.y());
/* 35 */       COLOR.unbind();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\GenPortRegs$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */