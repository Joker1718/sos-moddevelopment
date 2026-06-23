/*    */ package world.map.landmark;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import util.colors.GCOLOR;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ import world.WORLD;
/*    */ import world.overlay.WorldOverlays;
/*    */ 
/*    */ class PlacerOverlay
/*    */   extends WorldOverlays.OverlayTile {
/* 15 */   WorldLandmark hovered = null;
/*    */   
/*    */   public PlacerOverlay() {
/* 18 */     super(true, false);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 24 */     WorldLandmark l = (WorldLandmark)(WORLD.LANDMARKS()).setter.get(it.tile());
/* 25 */     if (l != null) {
/* 26 */       COLOR c = (l == this.hovered) ? (GCOLOR.MAP()).BEST : COLOR.WHITE35;
/* 27 */       c.bind();
/* 28 */       int m = 0;
/* 29 */       for (DIR d : DIR.ORTHO) {
/* 30 */         if ((WORLD.LANDMARKS()).setter.get(it.tx(), it.ty(), d) == l)
/* 31 */           m |= d.mask(); 
/*    */       } 
/* 33 */       (SPRITES.cons()).BIG.dashed.render(r, m, it.x(), it.y());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\landmark\PlacerOverlay.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */