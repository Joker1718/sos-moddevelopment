/*    */ package settlement.path.finders;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.ON_TOP_RENDERABLE;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.sets.Bitmap1D;
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
/*    */ class null
/*    */   extends ON_TOP_RENDERABLE
/*    */ {
/*    */   Bitmap1D map;
/*    */   
/*    */   public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {
/* 54 */     if (!TestPath.tester.isSuccessful()) {
/*    */       return;
/*    */     }
/* 57 */     if (this.map == null) {
/*    */       return;
/*    */     }
/* 60 */     if (TestPath.tester.hasNext()) {
/* 61 */       this.map = new Bitmap1D(SETT.TAREA, false);
/*    */       
/* 63 */       this.map.set(TestPath.tester.x() + TestPath.tester.y() * SETT.TWIDTH, true);
/* 64 */       while (TestPath.tester.setNext()) {
/* 65 */         this.map.set(TestPath.tester.x() + TestPath.tester.y() * SETT.TWIDTH, true);
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 70 */     RenderData.RenderIterator it = data.onScreenTiles();
/* 71 */     while (it.has()) {
/* 72 */       if (this.map.get(it.tile())) {
/* 73 */         (SPRITES.cons()).BIG.dots.render((SPRITE_RENDERER)r, 0, it.x(), it.y());
/*    */       }
/* 75 */       it.next();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\Tests$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */