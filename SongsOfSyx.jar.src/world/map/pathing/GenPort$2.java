/*    */ package world.map.pathing;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.sprite.SPRITE;
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
/* 42 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 46 */     if ((WORLD.PATH()).portArea.is(it.tile())) {
/* 47 */       ((COLOR)COLOR.UNIQUE.getC(GenPort.this.wRegs.get(it.tile()))).bind();
/* 48 */       (SPRITES.cons()).BIG.outline.render(r, 0, it.x(), it.y());
/* 49 */       COLOR.unbind();
/*    */     } 
/* 51 */     if ((WORLD.PATH()).map.is.is(it.tile())) {
/* 52 */       COLOR.ORANGE100.bind();
/* 53 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 54 */         DIR d = (DIR)DIR.ALL.get(di);
/* 55 */         if ((WORLD.PATH()).map.can(it.tx(), it.ty(), d))
/* 56 */           ((SPRITE)(SPRITES.cons()).ICO.arrows2.get(d.id())).render(r, it.x(), 
/* 57 */               it.y()); 
/*    */       } 
/* 59 */       COLOR.unbind();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\GenPort$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */