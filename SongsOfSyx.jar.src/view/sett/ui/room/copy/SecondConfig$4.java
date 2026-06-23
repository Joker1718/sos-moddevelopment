/*    */ package view.sett.ui.room.copy;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.ON_TOP_RENDERABLE;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
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
/*    */   extends ON_TOP_RENDERABLE
/*    */ {
/*    */   public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {
/* 77 */     RenderData.RenderIterator it = data.onScreenTiles();
/* 78 */     while (it.has()) {
/* 79 */       if (source.is(it.tile())) {
/* 80 */         int m = 0;
/* 81 */         for (DIR d : DIR.ORTHO) {
/* 82 */           if (source.is(it.tx(), it.ty(), d))
/* 83 */             m |= d.mask(); 
/*    */         } 
/* 85 */         (SPRITES.cons()).BIG.dashed.render((SPRITE_RENDERER)r, m, it.x(), it.y());
/*    */       } 
/* 87 */       it.next();
/*    */     } 
/* 89 */     SecondConfig.this.top.remove();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\copy\SecondConfig$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */