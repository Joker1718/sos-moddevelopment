/*    */ package view.sett.ui.room.copy;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.ON_TOP_RENDERABLE;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import util.colors.GCOLOR;
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
/*    */ class null
/*    */   extends ON_TOP_RENDERABLE
/*    */ {
/*    */   public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {
/* 68 */     RenderData.RenderIterator it = data.onScreenTiles();
/* 69 */     while (it.has()) {
/* 70 */       if (source.is(it.tile())) {
/* 71 */         int m = 0;
/* 72 */         for (DIR d : DIR.ORTHO) {
/* 73 */           if (source.is(it.tx(), it.ty(), d))
/* 74 */             m |= d.mask(); 
/*    */         } 
/* 76 */         (GCOLOR.MAP()).BEST_DARK.bind();
/* 77 */         (SPRITES.cons()).BIG.dashed.render((SPRITE_RENDERER)r, m, it.x(), it.y());
/*    */       } 
/* 79 */       it.next();
/*    */     } 
/* 81 */     FirstConfig.this.top.remove();
/* 82 */     COLOR.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\copy\FirstConfig$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */