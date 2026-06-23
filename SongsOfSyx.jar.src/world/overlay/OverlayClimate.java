/*    */ package world.overlay;
/*    */ 
/*    */ import init.type.CLIMATE;
/*    */ import init.type.CLIMATES;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ import world.WORLD;
/*    */ 
/*    */ 
/*    */ 
/*    */ class OverlayClimate
/*    */   extends WorldOverlays.OverlayTileNormal
/*    */ {
/*    */   OverlayClimate() {
/* 18 */     super((CLIMATES.INFO()).name, "", true, true);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 23 */     CLIMATE cl = (CLIMATE)(WORLD.TERRAIN()).climate.getter.get(it.tile());
/* 24 */     int m = 15;
/*    */     
/* 26 */     COLOR c = cl.color;
/* 27 */     c.bind();
/* 28 */     renderUnder(m, r, it);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderAbove(Renderer r, ShadowBatch s, RenderData data) {
/* 34 */     (WORLD.OVERLAY()).regNames.renderAbove(r, s, data);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\overlay\OverlayClimate.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */