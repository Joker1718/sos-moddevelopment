/*    */ package settlement.path.components;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.ON_TOP_RENDERABLE;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
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
/*    */ class null
/*    */   extends ON_TOP_RENDERABLE
/*    */ {
/*    */   public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {
/* 34 */     if (SCompTests.Placer.this.res == null)
/*    */       return; 
/* 36 */     RenderData.RenderIterator it = data.onScreenTiles();
/* 37 */     while (it.has()) {
/* 38 */       if (SCompTests.Placer.this.res.is(it.tile())) {
/* 39 */         if (it.tx() == SCompTests.Placer.this.sx && it.ty() == SCompTests.Placer.this.sy)
/* 40 */           COLOR.GREEN100.bind(); 
/* 41 */         (SPRITES.cons()).BIG.dots.render((SPRITE_RENDERER)r, 0, it.x(), it.y());
/* 42 */         COLOR.unbind();
/*    */       } 
/* 44 */       it.next();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SCompTests$Placer$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */