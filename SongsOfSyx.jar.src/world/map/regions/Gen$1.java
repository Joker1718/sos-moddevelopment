/*    */ package world.map.regions;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.CORE;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ import world.WORLD;
/*    */ import world.overlay.WorldOverlays;
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends WorldOverlays.OverlayTile
/*    */ {
/*    */   null(boolean $anonymous0, boolean $anonymous1) {
/* 20 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 24 */     Region reg = (Region)(WORLD.REGIONS()).map.get(it.tile());
/* 25 */     if (reg == null)
/*    */       return; 
/* 27 */     ColorImp.TMP.set((COLOR)COLOR.UNIQUE.getC(reg.index())).setBrightnessSelf(2.0D);
/* 28 */     int m = 0;
/* 29 */     for (DIR d : DIR.ORTHO) {
/* 30 */       if ((WORLD.REGIONS()).map.get(it.tx(), it.ty(), d) == reg) {
/* 31 */         m |= d.mask();
/*    */       }
/*    */     } 
/* 34 */     ColorImp.TMP.bind();
/* 35 */     (SPRITES.cons()).BIG.outline.render((SPRITE_RENDERER)CORE.renderer(), m, it.x(), it.y());
/*    */ 
/*    */     
/* 38 */     COLOR.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\Gen$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */