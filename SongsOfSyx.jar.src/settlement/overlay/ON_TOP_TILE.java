/*    */ package settlement.overlay;
/*    */ 
/*    */ import snake2d.Renderer;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ 
/*    */ public interface ON_TOP_TILE
/*    */ {
/*    */   default void render(Renderer r, ShadowBatch shadowBatch, RenderData data) {
/* 11 */     RenderData.RenderIterator it = data.onScreenTiles();
/* 12 */     while (it.has()) {
/* 13 */       render(r, shadowBatch, it);
/* 14 */       it.next();
/*    */     } 
/*    */   }
/*    */   
/*    */   void render(Renderer paramRenderer, ShadowBatch paramShadowBatch, RenderData.RenderIterator paramRenderIterator);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\overlay\ON_TOP_TILE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */