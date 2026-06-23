/*    */ package world.map.regions;
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
/*    */ class null
/*    */   extends WorldOverlays.OverlayTile
/*    */ {
/*    */   null(boolean $anonymous0, boolean $anonymous1) {
/* 37 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 41 */     ((COLOR)COLOR.UNIQUE.getC(GenAssign.this.pmap.get(it.tx(), it.ty()))).bind();
/* 42 */     (SPRITES.cons()).BIG.outline.render(r, 0, it.x(), it.y());
/* 43 */     COLOR.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\GenAssign$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */